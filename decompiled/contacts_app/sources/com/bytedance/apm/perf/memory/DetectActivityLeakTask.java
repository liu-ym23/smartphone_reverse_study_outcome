package com.bytedance.apm.perf.memory;

import android.app.Activity;
import android.app.Application;
import android.os.Handler;
import android.os.Looper;
import com.bytedance.apm.ApmContext;
import com.bytedance.apm.config.ActivityLeakDetectConfig;
import com.bytedance.apm.logging.Logger;
import com.bytedance.apm.perf.memory.utils.ActivityLeakFixer;
import com.bytedance.apm.perf.memory.utils.KeyedWeakReference;
import com.bytedance.monitor.util.thread.AsyncTaskUtil;
import com.bytedance.monitor.util.thread.IAsyncTaskManager;
import java.lang.ref.ReferenceQueue;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: loaded from: classes2.dex */
public class DetectActivityLeakTask {
    private static final long ACTIVITY_LEAK_CHECK_DELAY_MILLIS = 60000;
    private static final String ACTIVITY_LEAK_SWITCH = "activity_leak_switch";
    private static final String LEAK_CHECK_THREAD_NAME = "LeakCheck-Thread";
    private static final String TAG = "DetectActivityLeakTask";
    private static boolean mInited;
    private static DetectActivityLeakTask mTask;
    private ActivityLeakDetectConfig mActivityLeakDetectConfig;
    private volatile IAsyncTaskManager mAsyncTaskManager;
    private Handler mHandler;
    private ReferenceQueue<Object> mQueue;
    private Set<String> mRetainedKeys;
    private long mWaitDetectTimeMs;

    public DetectActivityLeakTask() {
    }

    static /* synthetic */ Set access$000(DetectActivityLeakTask r0) {
        return r0.mRetainedKeys;
    }

    static /* synthetic */ ReferenceQueue access$100(DetectActivityLeakTask r0) {
        return r0.mQueue;
    }

    static /* synthetic */ String access$200(DetectActivityLeakTask r0, Activity r1) {
        return r0.getActivityName(r1);
    }

    static /* synthetic */ void access$300(DetectActivityLeakTask r0, KeyedWeakReference r1, String r2) {
        r0.checkActivityLeak(r1, r2);
    }

    static /* synthetic */ void access$400(DetectActivityLeakTask r0) {
        r0.removeWeaklyReachableReferences();
    }

    static /* synthetic */ boolean access$500(DetectActivityLeakTask r0, KeyedWeakReference r1) {
        return r0.gone(r1);
    }

    static /* synthetic */ ActivityLeakDetectConfig access$600(DetectActivityLeakTask r0) {
        return r0.mActivityLeakDetectConfig;
    }

    static /* synthetic */ void access$700(DetectActivityLeakTask r0) {
        r0.runGc();
    }

    static /* synthetic */ void access$800(DetectActivityLeakTask r0, KeyedWeakReference r1, String r2) {
        r0.dealActivityLeak(r1, r2);
    }

    static /* synthetic */ void access$900(DetectActivityLeakTask r0, KeyedWeakReference r1) {
        r0.waitForIdle(r1);
    }

    static {
        mTask = new DetectActivityLeakTask();
        mInited = false;
    }

    public static void init(Application r1, ActivityLeakDetectConfig r2) {
        if (r1 == null) goto L9;
        if (r2 != null) goto L6;
        return;
    L6:
        if (mInited == true) goto L10;
        mInited = true;
        mTask.run(r1, r2);
        return;
    L10:
        return;
    }

    public void run(Application r5, ActivityLeakDetectConfig r6) {
        this.mActivityLeakDetectConfig = r6;
        this.mWaitDetectTimeMs = r6.getWaitDetectActivityTimeMs();
        long r0 = System.currentTimeMillis();
        initLeakCheck(r5);
        if (ApmContext.isDebugMode() == false) goto L6;
        Logger.i(TAG, new String[]{"initActivityLeakCheck done, cost: " + (System.currentTimeMillis() - r0) + " ms."});
        return;
    }

    private void initLeakCheck(Application r3) {
        this.mHandler = new Handler(Looper.getMainLooper());
        this.mQueue = new ReferenceQueue();
        this.mRetainedKeys = new CopyOnWriteArraySet();
        r3.registerActivityLifecycleCallbacks(new AnonymousClass1(this));
    }

    private void checkActivityLeak(final KeyedWeakReference r4, final String r5) {
        if (this.mAsyncTaskManager != null) goto L5;
        this.mAsyncTaskManager = AsyncTaskUtil.getAsyncTaskManagerInstance();
    L5:
        this.mAsyncTaskManager.postDelayed(AsyncTaskUtil.wrapLightWeightTask(LEAK_CHECK_THREAD_NAME, new AnonymousClass2(this, r4, r5)), getWaitDetectTimeMs());
    }

    private long getWaitDetectTimeMs() {
        if (this.mWaitDetectTimeMs > 0) goto L6;
        this.mWaitDetectTimeMs = 60000;
    L6:
        return this.mWaitDetectTimeMs;
    }

    private void dealActivityLeak(KeyedWeakReference r4, String r5) {
        if (ApmContext.isDebugMode() == false) goto L5;
        Logger.e(TAG, new String[]{"Leak:" + r5});
    L5:
        Activity r6 = (Activity) r4.get();
        if (r6 != null) goto L9;
        return;
    L9:
        if (this.mActivityLeakDetectConfig.isUnbindActivityLeak() == false) goto L12;
        fixActivityLeak(r4);
    L12:
        if (this.mActivityLeakDetectConfig.isReportActivityLeakEvent() == false) goto L14;
        uploadLeakActivity(r6);
    L14:
        this.mRetainedKeys.remove(r4.key);
        IActivityLeakListener r3 = this.mActivityLeakDetectConfig.getActivityLeakListener();
        if (r3 == null) goto L18;
        r3.onActivityLeaked(r6);
        return;
    }

    private void fixActivityLeak(final KeyedWeakReference r3) {
        this.mHandler.post(new AnonymousClass3(this, r3));
    }

    private void enqueueReferences() {
        Thread.sleep(100);     // Catch: InterruptedException -> L5
        return;
    L6:
        throw new AssertionError();
    }

    private void runGc() {
        long r0 = System.currentTimeMillis();
        Runtime.getRuntime().gc();
        enqueueReferences();
        System.runFinalization();
        if (ApmContext.isDebugMode() == false) goto L6;
        Logger.i(TAG, new String[]{"GC time done, cost: " + (System.currentTimeMillis() - r0) + " ms."});
        return;
    }

    private void uploadLeakActivity(Activity r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        ActivityLeakFixer.uploadLeakEvent(r3.getClass().getName());
        if (ApmContext.isDebugMode() == false) goto L8;
        Logger.i(TAG, new String[]{"upload leak activity:" + r3.getLocalClassName()});
        return;
    }

    private void waitForIdle(final KeyedWeakReference r3) {
        Looper.myQueue().addIdleHandler(new AnonymousClass4(this, r3));
    }

    private String getActivityName(Activity r1) {
        return r1.getLocalClassName();
    }

    private void removeWeaklyReachableReferences() {
    L2:
        KeyedWeakReference r0 = (KeyedWeakReference) this.mQueue.poll();
        if (r0 == null) goto L5;
        this.mRetainedKeys.remove(r0.key);
        goto L2
    }

    private boolean gone(KeyedWeakReference r1) {
        return !this.mRetainedKeys.contains(r1.key);
    }
}
