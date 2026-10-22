package com.bytedance.perf.monitor;

import android.text.TextUtils;
import com.android.contacts.common.SimContactsConstants;
import com.bytedance.apm.ApmContext;
import com.bytedance.apm.block.AbsLooperObserver;
import com.bytedance.apm.block.EvilMethodSwitchListener;
import com.bytedance.apm.block.EvilMethodSwitchManager;
import com.bytedance.apm.block.FluencySceneManager;
import com.bytedance.apm.block.trace.MainThreadMonitor;
import com.bytedance.apm.block.trace.MethodCollector;
import com.bytedance.apm.constant.CommonKey;
import com.bytedance.apm.core.ActivityLifeObserver;
import com.bytedance.apm.data.pipeline.CommonDataPipeline;
import com.bytedance.apm.data.type.ExceptionLogData;
import com.bytedance.apm6.util.Tools;
import com.bytedance.monitor.collector.AbsLooperDispatchListener;
import com.bytedance.monitor.collector.LooperDispatchMonitor;
import com.bytedance.monitor.collector.PerfMonitorManager;
import com.bytedance.monitor.collector.Util;
import com.bytedance.perf.collector.TraceDataUtils;
import com.obric.matrix.platform.sdk.ones.internal.monitor.EventConstants;
import java.util.LinkedList;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class EvilMethodTracer extends AbsLooperObserver implements EvilMethodSwitchListener {
    public static final String EVIL_METHOD_ANALYSE_EXCEPTION = "evil_method_analyse_exception";
    public static final String EVIL_METHOD_BEGIN = "evil_method_begin";
    public static final String EVIL_METHOD_DATA_NULL = "evil_method_data_null";
    public static final String EVIL_METHOD_END = "evil_method_end";
    public static final String EVIL_METHOD_SECTION = "evil_method_section";
    private static final String EVIL_METHOD_TAG = "method_tracer";
    public static final String EVIL_METHOD_TRACING = "evil_method_tracing";
    private static final long MASK_TIME_DURATION = 300;
    private static final String TAG = "EvilMethodTracer";
    private static long evilThresholdMs = 0;
    public static boolean isEvilMethodTraceEnable = false;
    public static boolean isMethodTraced = false;
    private static volatile boolean isRegisterConfig = false;
    private static IBlockListener sBlockListener;
    private static EvilMethodTracer sEvilMethodTracer;
    private MethodCollector.IndexRecord indexRecord;
    private volatile boolean isHyperMode;
    private boolean isStartTrace;
    private MethodCollector.IndexRecord lastIndexRecord;
    private volatile long lastMaskTime;
    private volatile String mCurrentMsg;
    private AnalyseTask mLastTask;
    private boolean mLimitDepth;
    private long[] queueTypeCosts;

    private class AnalyseTask implements Runnable {
        private boolean blockFrame;
        private boolean blockInput;
        long cost;
        long cpuCost;
        long[] data;
        long endMs;
        boolean isForeground;
        LooperDispatchMonitor.ScheduleItem item;
        String msg;
        long occurTime;
        long[] queueCost;
        String scene;
        final /* synthetic */ EvilMethodTracer this$0;
        String uuid;

        static /* synthetic */ boolean access$002(AnalyseTask r0, boolean r1) {
            r0.blockFrame = r1;
            return r1;
        }

        static /* synthetic */ boolean access$102(AnalyseTask r0, boolean r1) {
            r0.blockInput = r1;
            return r1;
        }

        AnalyseTask(EvilMethodTracer r4, boolean r5, String r6, long[] r7, long[] r8, long r9, long r11, long r13, String r15, long r16, String r18, LooperDispatchMonitor.ScheduleItem r19) {
            this.this$0 = r4;
            this.isForeground = r5;
            this.scene = r6;
            this.cost = r11;
            this.cpuCost = r9;
            this.data = r7;
            this.queueCost = r8;
            this.endMs = r13;
            this.msg = r15;
            this.occurTime = r16;
            this.uuid = r18;
            this.item = r19;
        }

        void analyse() {
            LinkedList r2 = new LinkedList();     // Catch: Exception -> L14
            long[] r3 = this.data;     // Catch: Exception -> L14
            if (r3.length <= 0) goto L7;
            TraceDataUtils.structuredDataToStack(r3, r2, true, this.endMs);     // Catch: Exception -> L14
            TraceDataUtils.trimStack(r2, 30, new AnonymousClass1(this));     // Catch: Exception -> L14
        L7:
            if (r2.size() > 2) goto L9;
            return;
        L9:
            StringBuilder r4 = new StringBuilder();     // Catch: Exception -> L14
            long r5 = Math.max(this.cost, TraceDataUtils.stackToString(r2, r4));     // Catch: Exception -> L14
            String r6 = TraceDataUtils.getTreeKey(r2, r5);     // Catch: Exception -> L14
            JSONObject r7 = new JSONObject();     // Catch: Exception -> L14
            String r8 = r4.toString();     // Catch: Exception -> L14
            LooperDispatchMonitor.ScheduleItem r9 = this.item;     // Catch: Exception -> L14
            if (r9 == null) goto L12;
            r9.updateBlockInfo(this.uuid, null, null, r8);     // Catch: Exception -> L14
        L12:
            r7.put("stack", r8);     // Catch: Exception -> L14
            r7.put("stack_key", r6);     // Catch: Exception -> L14
            r7.put("scene", this.scene);     // Catch: Exception -> L14
            r7.put(EventConstants.EVENT_KEY_COST_TIME, r5);     // Catch: Exception -> L14
            r7.put("cpu_cost", this.cpuCost);     // Catch: Exception -> L14
            r7.put("method_time", r5);     // Catch: Exception -> L14
            PerfMonitorManager r10 = PerfMonitorManager.getInstance();     // Catch: Exception -> L14
            long r11 = this.endMs;     // Catch: Exception -> L14
            JSONObject r12 = r10.dumpInfos(r11 - this.cost, r11);     // Catch: Exception -> L14
            MethodCollector r13 = MethodCollector.getInstance();     // Catch: Exception -> L14
            long r14 = this.endMs;     // Catch: Exception -> L14
            r12.put("evil_method", r13.getEvilMethod(r14 - this.cost, r14));     // Catch: Exception -> L14
            r7.put("custom", r12);     // Catch: Exception -> L14
            r7.put("message", Util.parseMessageKey(this.msg));     // Catch: Exception -> L14
            r7.put("timestamp", this.endMs);     // Catch: Exception -> L14
            r7.put("event_type", "lag_drop_frame");     // Catch: Exception -> L14
            JSONObject r15 = new JSONObject();     // Catch: Exception -> L14
            r15.put("crash_section", ApmContext.getTimeRange(this.occurTime));     // Catch: Exception -> L14
            r15.put(CommonKey.KEY_BLOCK_FRAME, String.valueOf(this.blockFrame));     // Catch: Exception -> L14
            r15.put(CommonKey.KEY_BLOCK_INPUT, String.valueOf(this.blockInput));     // Catch: Exception -> L14
            r15.put(CommonKey.KEY_TRACE_TYPE, "message");     // Catch: Exception -> L14
            r15.put("update_version_code", ApmContext.getHeaderInner().optString("update_version_code"));     // Catch: Exception -> L14
            r7.put("filters", r15);     // Catch: Exception -> L14
            CommonDataPipeline.getInstance().handle(new ExceptionLogData("drop_frame_stack", r7));     // Catch: Exception -> L14
            EvilMethodTracer.access$200(EvilMethodTracer.EVIL_METHOD_END);     // Catch: Exception -> L14
            return;
        L14:
            EvilMethodTracer.access$200(EvilMethodTracer.EVIL_METHOD_ANALYSE_EXCEPTION);
        }

        @Override // java.lang.Runnable
        public void run() {
            analyse();
        }
    }

    static {
    }

    static /* synthetic */ void access$200(String r0) {
        reportEvilMethod(r0);
    }

    public EvilMethodTracer() {
        this(false);
    }

    public EvilMethodTracer(boolean r1) {
        this(false, false);
    }

    public EvilMethodTracer(boolean r4, boolean r5) {
        this.isHyperMode = false;
        this.queueTypeCosts = new long[3];
        this.lastMaskTime = 0;
        this.mLastTask = null;
        this.isStartTrace = false;
        this.mLimitDepth = r4;
        if (r5 == true) goto L6;
        registerConfig();
    L6:
        if (sEvilMethodTracer != null) goto L9;
        sEvilMethodTracer = this;
        return;
    }

    public static void setBlockListener(IBlockListener r0) {
        sBlockListener = r0;
    }

    public static EvilMethodTracer getEvilMethodTracer() {
        return sEvilMethodTracer;
    }

    @Override // com.bytedance.apm.block.EvilMethodSwitchListener
    public void onRefresh(boolean r1, long r2) {
        setEvilThresholdMs(r2);
        isEvilMethodTraceEnable = r1;
        if (r1 == true) goto L6;
        Tools.runOnUiThread(new AnonymousClass1(this));
        MethodCollector.getInstance().onStop();
        return;
    }

    public synchronized void startTrace() {
        monitor-enter(this);
    L15:
        th = move-exception;
        throw th;
    L4:
        if (this.isStartTrace == false) goto L8;
        monitor-exit(this);
        return;
    L8:
        if (isEvilMethodTraceEnable == true) goto L10;
    L12:
        this.isStartTrace = true;     // Catch: Throwable -> L15
        monitor-exit(this);
        return;
    L10:
        if (isMethodTraced == false) goto L12;
        MainThreadMonitor.getMonitor().addObserver(this);     // Catch: Throwable -> L15
        goto L12
    }

    public synchronized void stopTrace() {
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L4:
        if (this.isStartTrace == true) goto L8;
        monitor-exit(this);
        return;
    L8:
        if (isEvilMethodTraceEnable == false) goto L10;
        MainThreadMonitor.getMonitor().removeObserver(this);     // Catch: Throwable -> L13
    L10:
        this.isStartTrace = false;     // Catch: Throwable -> L13
        monitor-exit(this);
    }

    @Override // com.bytedance.apm.block.AbsLooperObserver
    public void dispatchBegin(String r6) {
        super.dispatchBegin(r6);
        MethodCollector.i(MethodCollector.METHOD_ID_DISPATCH, AbsLooperDispatchListener.uptime);
        if ((AbsLooperDispatchListener.uptime - this.lastMaskTime) <= 300) goto L9;
        this.lastIndexRecord = this.indexRecord;
        this.lastMaskTime = AbsLooperDispatchListener.uptime;
        this.indexRecord = MethodCollector.maskIndex("EvilMethodTracer#dispatchBegin", 0);
        if (this.isHyperMode == false) goto L9;
        if (this.lastIndexRecord == null) goto L9;
        final long[] r0 = MethodCollector.getInstance().copyData(this.lastIndexRecord);     // Catch: Throwable -> L11
        final long r1 = AbsLooperDispatchListener.uptime;     // Catch: Throwable -> L11
        PerfMonitorManager.getInstance().getThreadWithHandler().post(new AnonymousClass2(this, r0, r1));     // Catch: Throwable -> L11
    L9:
        this.mCurrentMsg = r6;
    }

    @Override // com.bytedance.apm.block.AbsLooperObserver
    public void dispatchEnd(long r19, long r21, long r23, long r25, boolean r27) {
        super.dispatchEnd(r19, r21, r23, r25, r27);
        MethodCollector.o(MethodCollector.METHOD_ID_DISPATCH, AbsLooperDispatchListener.uptime);
        AnalyseTask r1 = this.mLastTask;
        if (r1 == null) goto L6;
        AnalyseTask.access$002(r1, r27);
        AnalyseTask.access$102(this.mLastTask, MainThreadMonitor.getMonitor().mainThreadInfo.isInputDelayed());
        com.bytedance.apm.thread.AsyncEventManager.getInstance().post(this.mLastTask);
        this.mLastTask = null;
    L6:
        if (MethodCollector.getInstance().isAlive() == true) goto L8;
        return;
    L8:
        long r8 = r23 - r19;
        if (r8 < evilThresholdMs) goto L25;
        IBlockListener r2 = sBlockListener;
        if (r2 == null) goto L13;
        r2.doBlock(r8, r27);
    L13:
        reportEvilMethod(EVIL_METHOD_BEGIN);
        long[] r4 = MethodCollector.getInstance().copyData(this.indexRecord);
        if (r4 != null) goto L16;
    L23:
        reportEvilMethod(EVIL_METHOD_DATA_NULL);
        return;
    L16:
        if (r4.length == 0) goto L23;
        long[] r5 = new long[3];
        System.arraycopy(this.queueTypeCosts, 0, r5, 0, 3);
        String r0 = FluencySceneManager.getInjectScene();
        if (TextUtils.isEmpty(r0) == false) goto L21;
        String r3 = ActivityLifeObserver.getInstance().getTopActivityClassName();
    L22:
        String r12 = this.mCurrentMsg;
        this.mLastTask = new AnalyseTask(this, ActivityLifeObserver.getInstance().isForeground(), r3, r4, r5, r25 - r21, r8, r23, r12, System.currentTimeMillis(), "uuid", PerfMonitorManager.getInstance().getLastMessageItem());
        return;
    L21:
        r3 = r0 + SimContactsConstants.EMAIL_SEP + ActivityLifeObserver.getInstance().getTopActivityClassName();
        goto L22
    }

    private static void reportEvilMethod(final String r2) {
        com.bytedance.apm.thread.AsyncEventManager.getInstance().post(new AnonymousClass3(r2));
    }

    public synchronized void startHyperMode() {
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L4:
        if (this.isHyperMode == false) goto L8;
        monitor-exit(this);
        return;
    L8:
        this.isHyperMode = true;     // Catch: Throwable -> L11
        monitor-exit(this);
    }

    public synchronized void stopHyperMode() {
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L4:
        if (this.isHyperMode == true) goto L8;
        monitor-exit(this);
        return;
    L8:
        this.isHyperMode = false;     // Catch: Throwable -> L11
        monitor-exit(this);
    }

    public void registerConfig() {
        if (isRegisterConfig == false) goto L5;
        return;
    L5:
        EvilMethodSwitchManager.addListener(this);
        isRegisterConfig = true;
    }

    public static void setEvilThresholdMs(long r2) {
        if (r2 >= 70) goto L5;
        r2 = 1000;
    L5:
        evilThresholdMs = r2;
    }

    public static void setIsEvilMethodTraceEnable(boolean r0) {
        isEvilMethodTraceEnable = r0;
    }

    public void setLimitDepth(boolean r1) {
        this.mLimitDepth = r1;
    }
}
