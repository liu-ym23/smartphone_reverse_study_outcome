package com.bytedance.ttnet.config;

import android.os.SystemClock;
import android.text.TextUtils;
import androidx.vectordrawable.graphics.drawable.PathInterpolatorCompat;
import com.android.contacts.util.HanziToPinyin;
import com.bytedance.common.utility.Logger;
import com.bytedance.frameworks.baselib.network.asynctask.NetworkAsyncTaskManager;
import com.bytedance.frameworks.baselib.network.asynctask.NetworkAsyncTaskType;
import com.bytedance.frameworks.baselib.network.http.exception.DroppedByThrottleControlException;
import com.bytedance.retrofit2.RetrofitMetrics;
import com.bytedance.retrofit2.SsRunnable;
import com.bytedance.retrofit2.client.Request;
import com.bytedance.retrofit2.ttnet.IHttpCallThrottleControl;
import com.bytedance.ttnet.TTNetInit;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class TTHttpCallThrottleControl implements IHttpCallThrottleControl {
    private static volatile TTHttpCallThrottleControl mInstance;
    private final Map<Runnable, Executor> mAsyncReqExecutorMap;
    private volatile StateConfig mCurrentConfig;
    private final ReadWriteLock mCurrentConfigRWLock;
    private final Lock mCurrentConfigReadLock;
    private final Lock mCurrentConfigWriteLock;
    private final AtomicLong mLastP0StartTime;
    private final Set<Request> mP1AsyncSet;
    private final Set<Request> mP1SyncSet;
    private final ReadWriteLock mReleaseP1EnqueueLock;
    private final Lock mReleaseP1EnqueueWriteLock;
    private final Condition mReleaseP1ExecuteCondition;
    private final Lock mReleaseP1ExecuteLock;
    private final Set<Request> mRuntimePOSet;
    private final Map<String, StateConfig> mStateConfigMap;
    private final AtomicBoolean mTncStateDelayEnabled;

    public static final enum DelayMode extends Enum<DelayMode> {
        private static final /* synthetic */ DelayMode[] $VALUES = null;
        public static final DelayMode BLACK_LIST = null;
        public static final DelayMode NOT_REACHED = null;
        public static final DelayMode NO_DELAY = null;
        public static final DelayMode RUNTIME = null;
        public static final DelayMode WHITE_LIST = null;

        private DelayMode(String r1, int r2) {
            super(r1, r2);
        }

        public static DelayMode valueOf(String r1) {
            return (DelayMode) Enum.valueOf(DelayMode.class, r1);
        }

        public static DelayMode[] values() {
            return (DelayMode[]) $VALUES.clone();
        }

        static {
            DelayMode r0 = new DelayMode("NO_DELAY", 0);
            NO_DELAY = r0;
            DelayMode r1 = new DelayMode("BLACK_LIST", 1);
            BLACK_LIST = r1;
            DelayMode r3 = new DelayMode("WHITE_LIST", 2);
            WHITE_LIST = r3;
            DelayMode r5 = new DelayMode("RUNTIME", 3);
            RUNTIME = r5;
            DelayMode r7 = new DelayMode("NOT_REACHED", 4);
            NOT_REACHED = r7;
            $VALUES = new DelayMode[]{r0, r1, r3, r5, r7};
        }
    }

    private static class StateConfig {
        int asyncReqDelayMaxCount;
        Map<String, Integer> blackList;
        Set<String> blackListForRuntime;
        int delayDisableTimeMs;
        DelayMode delayMode;
        Set<String> dropList;
        int p0CheckCountdownMs;
        Set<String> p0List;
        int p1MaxWaitMs;
        int randomSendLowerBoundMs;
        int randomSendUpperBoundMs;
        int state;
        String stateName;
        int syncReqDelayMaxCount;
        Set<String> whiteList;
        int whiteListDelayTimeMs;
        Set<String> whiteListForRuntime;

        private StateConfig() {
            this.delayMode = DelayMode.NO_DELAY;
            this.state = -1;
            this.stateName = "";
            this.delayDisableTimeMs = 1000;
            this.syncReqDelayMaxCount = 5;
            this.asyncReqDelayMaxCount = 5;
            this.dropList = new CopyOnWriteArraySet();
            this.blackList = new ConcurrentHashMap();
            this.whiteList = new CopyOnWriteArraySet();
            this.whiteListDelayTimeMs = 100;
            this.p0List = new CopyOnWriteArraySet();
            this.blackListForRuntime = new CopyOnWriteArraySet();
            this.whiteListForRuntime = new CopyOnWriteArraySet();
            this.p0CheckCountdownMs = 5000;
            this.p1MaxWaitMs = 5000;
            this.randomSendUpperBoundMs = PathInterpolatorCompat.MAX_NUM_POINTS;
            this.randomSendLowerBoundMs = 500;
        }

        /* synthetic */ StateConfig(AnonymousClass1 r1) {
            this();
        }
    }

    public TTHttpCallThrottleControl() {
        this.mTncStateDelayEnabled = new AtomicBoolean(false);
        this.mStateConfigMap = new ConcurrentHashMap();
        this.mCurrentConfig = new StateConfig(null);
        ReentrantReadWriteLock r0 = new ReentrantReadWriteLock();
        this.mCurrentConfigRWLock = r0;
        this.mCurrentConfigReadLock = r0.readLock();
        this.mCurrentConfigWriteLock = r0.writeLock();
        this.mP1AsyncSet = new CopyOnWriteArraySet();
        this.mP1SyncSet = new CopyOnWriteArraySet();
        this.mLastP0StartTime = new AtomicLong(0);
        this.mRuntimePOSet = new CopyOnWriteArraySet();
        this.mAsyncReqExecutorMap = new ConcurrentHashMap();
        ReentrantReadWriteLock r1 = new ReentrantReadWriteLock();
        this.mReleaseP1EnqueueLock = r1;
        this.mReleaseP1EnqueueWriteLock = r1.writeLock();
        ReentrantLock r2 = new ReentrantLock();
        this.mReleaseP1ExecuteLock = r2;
        this.mReleaseP1ExecuteCondition = r2.newCondition();
    }

    static /* synthetic */ Lock access$100(TTHttpCallThrottleControl r0) {
        return r0.mReleaseP1EnqueueWriteLock;
    }

    static /* synthetic */ Map access$200(TTHttpCallThrottleControl r0) {
        return r0.mAsyncReqExecutorMap;
    }

    static /* synthetic */ Set access$300(TTHttpCallThrottleControl r0) {
        return r0.mRuntimePOSet;
    }

    static /* synthetic */ Set access$400(TTHttpCallThrottleControl r0) {
        return r0.mP1AsyncSet;
    }

    static /* synthetic */ Set access$500(TTHttpCallThrottleControl r0) {
        return r0.mP1SyncSet;
    }

    static /* synthetic */ void access$600(TTHttpCallThrottleControl r0) {
        r0.releaseAllP1Request();
    }

    public static TTHttpCallThrottleControl getInstance() {
        if (mInstance != null) goto L15;
        monitor-enter(TTHttpCallThrottleControl.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (mInstance != null) goto L9;
        mInstance = new TTHttpCallThrottleControl();     // Catch: Throwable -> L11
    L9:
        monitor-exit(TTHttpCallThrottleControl.class);     // Catch: Throwable -> L11
    L15:
        return mInstance;
    }

    public void onServerConfigChangedFromTNCHandler(JSONObject r13) {
        JSONArray r0 = r13.optJSONArray("tt_req_delay_config");
        boolean r3 = true;
        if (r13.optInt("state_delay_enabled") <= 0) goto L5;
        boolean r1 = true;
    L7:
        if (r13.optInt("state_new_strategy_enabled", 1) <= 0) goto L9;
        boolean r14 = true;
    L11:
        if (TTNetInit.getStateDelayNewStrategyEnabled() == false) goto L14;
        if (r14 == false) goto L14;
    L15:
        if (r1 == false) goto L89;
        if (r0 == null) goto L89;
        if (r3 == true) goto L89;
        ConcurrentHashMap r15 = new ConcurrentHashMap();
        int r4 = 0;
    L21:
        if (r4 >= r0.length()) goto L87;
        StateConfig r5 = new StateConfig(null);
        JSONObject r6 = r0.optJSONObject(r4);
        if (r6 == null) goto L86;
        r5.stateName = r6.optString("state_name", "");
        if (r6.isNull("bl_with_delay_ms") == true) goto L34;
        r5.delayMode = DelayMode.BLACK_LIST;
        JSONObject r7 = r6.optJSONObject("bl_with_delay_ms");
        if (r7 == null) goto L66;
        Iterator<String> r8 = r7.keys();
    L31:
        if (r8.hasNext() == false) goto L66;
        String r9 = r8.next();
        r5.blackList.put(r9, Integer.valueOf(r7.optInt(r9)));
    L66:
        if (r5.blackList.size() > 0) goto L72;
        if (r5.whiteList.size() > 0) goto L72;
        if (r5.p0List.size() <= 0) goto L86;
    L72:
        if (TextUtils.isEmpty(r5.stateName) == true) goto L86;
        r5.delayDisableTimeMs = r6.optInt("delay_disable_time_ms", 1000);
        if (r5.delayDisableTimeMs > 0) goto L78;
        r5.delayDisableTimeMs = 1000;
    L78:
        if (r6.isNull("dl") == true) goto L85;
        JSONArray r10 = r6.optJSONArray("dl");
        if (r10 == null) goto L85;
        int r11 = 0;
    L83:
        if (r11 >= r10.length()) goto L85;
        r5.dropList.add((String) r10.opt(r11));
        r11 = r11 + 1;
    L85:
        r5.state = r6.optInt("state", -1);
        r5.syncReqDelayMaxCount = r6.optInt("sync_req_delay_max_count", 10);
        r5.asyncReqDelayMaxCount = r6.optInt("async_req_delay_max_count", 10);
        r15.put(r5.stateName, r5);
        goto L86
    L34:
        if (r6.isNull("wl") == true) goto L45;
        r5.delayMode = DelayMode.WHITE_LIST;
        JSONArray r12 = r6.optJSONArray("wl");
        if (r12 == null) goto L41;
        int r16 = 0;
    L39:
        if (r16 >= r12.length()) goto L41;
        r5.whiteList.add((String) r12.opt(r16));
        r16 = r16 + 1;
    L41:
        r5.whiteListDelayTimeMs = r6.optInt("delay_time_ms", 1000);
        if (r5.whiteListDelayTimeMs > 0) goto L66;
        r5.whiteListDelayTimeMs = 1000;
        goto L66
    L45:
        if (r6.isNull("p0") == true) goto L66;
        r5.delayMode = DelayMode.RUNTIME;
        JSONArray r17 = r6.optJSONArray("p0");
        if (r17 == null) goto L52;
        int r18 = 0;
    L50:
        if (r18 >= r17.length()) goto L52;
        r5.p0List.add((String) r17.opt(r18));
        r18 = r18 + 1;
    L52:
        JSONArray r19 = r6.optJSONArray("bl_for_runtime");
        if (r19 == null) goto L58;
        int r20 = 0;
    L56:
        if (r20 >= r19.length()) goto L58;
        r5.blackListForRuntime.add((String) r19.opt(r20));
        r20 = r20 + 1;
    L58:
        JSONArray r21 = r6.optJSONArray("wl_for_runtime");
        if (r21 == null) goto L64;
        int r22 = 0;
    L62:
        if (r22 >= r21.length()) goto L64;
        r5.whiteListForRuntime.add((String) r21.opt(r22));
        r22 = r22 + 1;
    L64:
        r5.p0CheckCountdownMs = r6.optInt("p0_check_max_ms", 5000);
        r5.p1MaxWaitMs = r6.optInt("p1_wait_max_ms", 5000);
        r5.randomSendUpperBoundMs = r6.optInt("random_send_ubound_ms", PathInterpolatorCompat.MAX_NUM_POINTS);
        r5.randomSendLowerBoundMs = r6.optInt("random_send_lbound_ms", 500);
    L86:
        r4 = r4 + 1;
        goto L21
    L87:
        this.mStateConfigMap.clear();
        this.mStateConfigMap.putAll(r15);
        this.mTncStateDelayEnabled.set(r1);
        return;
    L89:
        this.mStateConfigMap.clear();
        this.mTncStateDelayEnabled.set(r1);
        return;
    L14:
        r3 = false;
        goto L15
    L9:
        r14 = false;
        goto L11
    L5:
        r1 = false;
        goto L7
    }

    public void setAppState(String r8) {
        releaseAllP1Request();
        StateConfig r1 = this.mStateConfigMap.get(r8);
        this.mCurrentConfigWriteLock.lock();
    L17:
        th = move-exception;
        this.mCurrentConfigWriteLock.unlock();
        throw th;
    L4:
        if (Logger.debug() == false) goto L7;
        Logger.d("delayrefine", "setAppState " + r8);     // Catch: Throwable -> L17
    L7:
        if (r1 != this.mCurrentConfig) goto L10;
        this.mCurrentConfigWriteLock.unlock();
        return;
    L10:
        if (r1 != null) goto L12;
        r1 = new StateConfig(null);     // Catch: Throwable -> L17
    L12:
        this.mCurrentConfig = r1;     // Catch: Throwable -> L17
        if (this.mCurrentConfig.delayMode == DelayMode.NO_DELAY) goto L15;
        NetworkAsyncTaskManager r9 = NetworkAsyncTaskManager.inst(NetworkAsyncTaskType.NETWORK);     // Catch: Throwable -> L17
        final long r2 = this.mCurrentConfig.delayDisableTimeMs;     // Catch: Throwable -> L17
        final long r4 = 0;
        r9.postTask(new AnonymousClass1(this, r2, r4));     // Catch: Throwable -> L17
    L15:
        this.mCurrentConfigWriteLock.unlock();
    }

    @Override // com.bytedance.retrofit2.ttnet.IHttpCallThrottleControl
    public void maybeDropRequestOrBlockingDelay(Request r10, RetrofitMetrics r11) throws Exception {
        if (this.mTncStateDelayEnabled.get() == true) goto L5;
        return;
    L5:
        if (r10 != null) goto L7;
        return;
    L7:
        if (r10.getPath() == null) goto L72;
        if (r11 == null) goto L73;
        this.mCurrentConfigReadLock.lock();
        int r3 = getNoneRuntimeSleepTimeOrRaiseDroppedByThrottleControlException(false, this.mCurrentConfig, r11, r10);     // Catch: Throwable -> L57 Exception -> L59
        if (Logger.debug() == false) goto L15;
        Logger.d("delayrefine", "get sleep time " + r3 + " path is " + r10.getPath());     // Catch: Throwable -> L57 Exception -> L59
    L15:
        this.mCurrentConfigReadLock.unlock();
        if (r3 <= 0) goto L19;
        sleepForSpecificTimeMs(r3, r10, r11);
        return;
    L19:
        if (r3 != 0) goto L21;
        return;
    L21:
        this.mCurrentConfigReadLock.lock();
        int r2 = this.mCurrentConfig.randomSendLowerBoundMs;
        int r4 = this.mCurrentConfig.randomSendUpperBoundMs;
        int r5 = this.mCurrentConfig.p1MaxWaitMs;
    L51:
        th = move-exception;
        this.mCurrentConfigReadLock.unlock();
        throw th;
    L53:
        e = move-exception;
        throw e;     // Catch: Throwable -> L51
    L23:
        if (this.mCurrentConfig.delayMode == DelayMode.RUNTIME) goto L27;
    L24:
        this.mCurrentConfigReadLock.unlock();
        return;
    L27:
        if (checkRequestForRuntime(this.mCurrentConfig, r10) == false) goto L24;
        if (p1CheckP0Done() == true) goto L24;
        this.mCurrentConfigReadLock.unlock();
        this.mReleaseP1ExecuteLock.lock();
        r11.delayStartTimeStamp = SystemClock.uptimeMillis();     // Catch: Throwable -> L44 Exception -> L46
        this.mP1SyncSet.add(r10);     // Catch: Throwable -> L44 Exception -> L46
        if (Logger.debug() == false) goto L36;
        Logger.d("delayrefine", "execute p1 add request " + r10.getPath() + " after added me, sync size is " + this.mP1SyncSet.size());     // Catch: Throwable -> L44 Exception -> L46
    L36:
        this.mReleaseP1ExecuteCondition.await(r5, TimeUnit.MILLISECONDS);     // Catch: Throwable -> L44 Exception -> L46
        int r1 = getP1RandomDelayTime(false, r2, r4);     // Catch: Throwable -> L44 Exception -> L46
        long r6 = r1;
        r11.randomSendTime = r6;     // Catch: Throwable -> L44 Exception -> L46
        if (r1 <= 0) goto L40;
        Thread.sleep(r6);     // Catch: Throwable -> L44 Exception -> L46
    L40:
        if (Logger.debug() == false) goto L42;
        Logger.d("delayrefine", "execute p1 release now " + r10.getPath() + " random is " + r1);     // Catch: Throwable -> L44 Exception -> L46
    L42:
        r11.stateDelayTime = SystemClock.uptimeMillis() - r11.delayStartTimeStamp;     // Catch: Throwable -> L44 Exception -> L46
        r11.delayedWithState = true;     // Catch: Throwable -> L44 Exception -> L46
    L47:
        this.mReleaseP1ExecuteLock.unlock();
        return;
    L46:
        Logger.e("sleeping interrupted");     // Catch: Throwable -> L44
    L44:
        th = move-exception;
        this.mReleaseP1ExecuteLock.unlock();
        throw th;
    L59:
        e = move-exception;
        throw e;     // Catch: Throwable -> L57
    L57:
        th = move-exception;
        this.mCurrentConfigReadLock.unlock();
        throw th;
    L73:
        return;
    }

    private void sleepForSpecificTimeMs(int r3, Request r4, RetrofitMetrics r5) {
        if (r3 > 0) goto L4;
        return;
    L4:
        this.mP1SyncSet.add(r4);
        r5.delayStartTimeStamp = System.currentTimeMillis();
        r5.delayedWithState = true;
        Thread.sleep(r3);     // Catch: Throwable -> L8 InterruptedException -> L10
        r5.stateDelayTime = System.currentTimeMillis() - r5.delayStartTimeStamp;
        return;
    L10:
        e = move-exception;
        throw new RuntimeException(e);     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        r5.stateDelayTime = System.currentTimeMillis() - r5.delayStartTimeStamp;
        throw th;
    }

    @Override // com.bytedance.retrofit2.ttnet.IHttpCallThrottleControl
    public boolean maybeDropRequestOrAsyncDelay(final Request r16, final RetrofitMetrics r17, final Executor r18, final Runnable r19) throws IOException {
        if (this.mTncStateDelayEnabled.get() == true) goto L5;
        return false;
    L5:
        if (r16 != null) goto L7;
    L47:
        return false;
    L7:
        if (r16.getPath() == null) goto L47;
        if (r17 == null) goto L47;
        this.mCurrentConfigReadLock.lock();
        int r3 = this.mCurrentConfig.p1MaxWaitMs;
        int r5 = getNoneRuntimeSleepTimeOrRaiseDroppedByThrottleControlException(true, this.mCurrentConfig, r17, r16);     // Catch: Throwable -> L41 Exception -> L43
        if (Logger.debug() == false) goto L15;
        Logger.d("delayrefine", "get sleep time " + r5 + " path is " + r16.getPath());     // Catch: Throwable -> L41 Exception -> L43
    L15:
        if (r5 <= 0) goto L19;
        statePostDelay(r5, r18, r19, r16, r17);     // Catch: Throwable -> L41 Exception -> L43
        this.mCurrentConfigReadLock.unlock();
        return true;
    L19:
        if (r5 != 0) goto L23;
    L20:
        this.mCurrentConfigReadLock.unlock();
        return false;
    L23:
        if (this.mCurrentConfig.delayMode != DelayMode.RUNTIME) goto L20;
        if (checkRequestForRuntime(this.mCurrentConfig, r16) == false) goto L20;
        if (p1CheckP0Done() == true) goto L20;
        this.mCurrentConfigReadLock.unlock();
        this.mReleaseP1EnqueueWriteLock.lock();
        this.mP1AsyncSet.add(r16);     // Catch: Throwable -> L38
        if (Logger.debug() == false) goto L35;
        Logger.d("delayrefine", "enqueue p1 add request " + r16.getPath() + " after added me, async size is " + this.mP1AsyncSet.size());     // Catch: Throwable -> L38
    L35:
        r17.delayStartTimeStamp = System.currentTimeMillis();     // Catch: Throwable -> L38
        this.mAsyncReqExecutorMap.put(r19, r18);     // Catch: Throwable -> L38
        r17.delayedWithState = true;     // Catch: Throwable -> L38
        final long r4 = r3;
        final long r6 = 0;
        NetworkAsyncTaskManager.inst(NetworkAsyncTaskType.NETWORK).postTask(new AnonymousClass2(this, r4, r6, r19, r16, r17, r18));     // Catch: Throwable -> L38
        this.mReleaseP1EnqueueWriteLock.unlock();
        return true;
    L38:
        th = move-exception;
        this.mReleaseP1EnqueueWriteLock.unlock();
        throw th;
    L43:
        e = move-exception;
        throw e;     // Catch: Throwable -> L41
    L41:
        th = move-exception;
        this.mCurrentConfigReadLock.unlock();
        throw th;
    }

    private void statePostDelay(final int r9, final Executor r10, final Runnable r11, final Request r12, final RetrofitMetrics r13) {
        if (r9 > 0) goto L4;
        return;
    L4:
        r13.delayStartTimeStamp = System.currentTimeMillis();
        r13.delayedWithState = true;
        SsRunnable r0 = new AnonymousClass3(this, r13, r10, r11, r12, r9);
        this.mP1AsyncSet.add(r12);
        r10.execute(r0);
    }

    private boolean p1CheckP0Done() {
        if ((System.currentTimeMillis() - this.mLastP0StartTime.get()) <= this.mCurrentConfig.p0CheckCountdownMs) goto L6;
        return true;
    L6:
        if (this.mRuntimePOSet.size() <= 0) goto L10;
        return false;
    L10:
        return true;
    }

    @Override // com.bytedance.retrofit2.ttnet.IHttpCallThrottleControl
    public void notifyRequestCompleted(final Request r3) {
        if (this.mTncStateDelayEnabled.get() == false) goto L5;
    L7:
        if (r3 != null) goto L9;
        return;
    L9:
        NetworkAsyncTaskManager.inst(NetworkAsyncTaskType.NETWORK).postTask(new AnonymousClass4(this, r3));
        return;
    L5:
        if (this.mRuntimePOSet.size() > 0) goto L7;
    }

    private void releaseAllP1Request() {
        if (Logger.debug() == false) goto L5;
        Logger.d("delayrefine", "releaseAllP1Request, " + this.mP1SyncSet.size() + HanziToPinyin.Token.SEPARATOR + this.mP1AsyncSet.size());
    L5:
        this.mReleaseP1ExecuteLock.lock();
        this.mReleaseP1ExecuteCondition.signalAll();     // Catch: Throwable -> L23
        this.mReleaseP1ExecuteLock.unlock();
        this.mCurrentConfigReadLock.lock();
        int r0 = this.mCurrentConfig.randomSendLowerBoundMs;     // Catch: Throwable -> L20
        int r1 = this.mCurrentConfig.randomSendUpperBoundMs;     // Catch: Throwable -> L20
        this.mCurrentConfigReadLock.unlock();
        this.mReleaseP1EnqueueWriteLock.lock();
        Iterator<Map.Entry<Runnable, Executor>> r2 = this.mAsyncReqExecutorMap.entrySet().iterator();     // Catch: Throwable -> L17
    L12:
        if (r2.hasNext() == false) goto L15;
        Map.Entry<Runnable, Executor> r3 = r2.next();     // Catch: Throwable -> L17
        final Runnable r11 = r3.getKey();     // Catch: Throwable -> L17
        final Executor r13 = r3.getValue();     // Catch: Throwable -> L17
        final int r12 = getP1RandomDelayTime(true, r0, r1);     // Catch: Throwable -> L17
        final long r7 = r12;
        final long r9 = 0;
        NetworkAsyncTaskManager.inst(NetworkAsyncTaskType.NETWORK).postTask(new AnonymousClass5(this, r7, r9, r11, r12, r13));     // Catch: Throwable -> L17
        goto L12
    L15:
        this.mReleaseP1EnqueueWriteLock.unlock();
        this.mP1AsyncSet.clear();
        this.mP1SyncSet.clear();
        return;
    L17:
        th = move-exception;
        this.mReleaseP1EnqueueWriteLock.unlock();
        throw th;
    L20:
        th = move-exception;
        this.mCurrentConfigReadLock.unlock();
        throw th;
    L23:
        th = move-exception;
        this.mReleaseP1ExecuteLock.unlock();
        throw th;
    }

    private int getP1RandomDelayTime(boolean r4, int r5, int r6) {
        if (r4 == true) goto L5;
    L7:
        if (r4 == true) goto L12;
        if (this.mP1SyncSet.size() > 5) goto L12;
        return 0;
    L12:
        return new Random().nextInt((r6 - r5) + 1) + r5;
    L5:
        if (this.mP1AsyncSet.size() > 5) goto L7;
        return 0;
    }

    private Integer getMapValueIfMatch(Map<String, Integer> r4, String r5) {
        if (r5 != null) goto L5;
        return null;
    L5:
        Iterator<String> r0 = r4.keySet().iterator();
    L7:
        if (r0.hasNext() == false) goto L15;
        String r1 = r0.next();
        if (r5.startsWith(r1) == false) goto L7;
        return r4.get(r1);
    L15:
        return null;
    }

    private boolean isMatch(Set<String> r2, String r3) {
        if (r3 != null) goto L5;
        return false;
    L5:
        Iterator<String> r4 = r2.iterator();
    L7:
        if (r4.hasNext() == false) goto L15;
        if (r3.startsWith(r4.next()) == false) goto L7;
        return true;
    L15:
        return false;
    }

    private int getNoneRuntimeSleepTimeOrRaiseDroppedByThrottleControlException(boolean r3, StateConfig r4, RetrofitMetrics r5, Request r6) throws IOException {
        if (r6.getMetrics() != null) goto L5;
        r6.setMetrics(r5);
    L5:
        r5.delayState = r4.state;
        r5.syncDelayCount = this.mP1SyncSet.size();
        r5.asyncDelayCount = this.mP1AsyncSet.size();
        if (isMatch(r4.dropList, r6.getPath()) == true) goto L32;
        if (r3 == true) goto L10;
    L12:
        if (r3 == true) goto L17;
        if (this.mP1SyncSet.size() < r4.syncReqDelayMaxCount) goto L17;
        return 0;
    L17:
        if (r4.delayMode != DelayMode.BLACK_LIST) goto L23;
        Integer r2 = getMapValueIfMatch(r4.blackList, r6.getPath());
        if (r2 != null) goto L21;
        return 0;
    L21:
        return r2.intValue();
    L23:
        if (r4.delayMode == DelayMode.WHITE_LIST) goto L25;
        return -1;
    L25:
        if (isMatch(r4.whiteList, r6.getPath()) == false) goto L27;
        return 0;
    L27:
        return r4.whiteListDelayTimeMs;
    L10:
        if (this.mP1AsyncSet.size() < r4.asyncReqDelayMaxCount) goto L12;
        return 0;
    L32:
        throw new DroppedByThrottleControlException();
    }

    private boolean checkRequestForRuntime(StateConfig r3, Request r4) {
        if (isMatch(r3.p0List, r4.getPath()) == false) goto L10;
        this.mLastP0StartTime.set(System.currentTimeMillis());
        this.mRuntimePOSet.add(r4);
        if (Logger.debug() == false) goto L18;
        Logger.d("delayrefine", "p0 add request " + r4.getPath() + " size " + this.mRuntimePOSet.size());
        return false;
    L18:
        return false;
    L10:
        if (r3.blackListForRuntime.size() <= 0) goto L14;
        return isMatch(r3.blackListForRuntime, r4.getPath());
    L14:
        if (r3.whiteListForRuntime.size() > 0) goto L16;
        return true;
    L16:
        return !isMatch(r3.whiteListForRuntime, r4.getPath());
    }
}
