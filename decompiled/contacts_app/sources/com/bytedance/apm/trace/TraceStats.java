package com.bytedance.apm.trace;

import android.os.SystemClock;
import android.text.TextUtils;
import com.android.contacts.ContactsUtils;
import com.bytedance.apm.ApmContext;
import com.bytedance.apm.agent.tracing.AutoLaunchTraceHelper;
import com.bytedance.apm.block.trace.MethodCollector;
import com.bytedance.apm.constant.TraceStatsConsts;
import com.bytedance.apm.data.pipeline.CommonDataPipeline;
import com.bytedance.apm.data.type.PerfData;
import com.bytedance.apm.entity.TraceTimeEntity;
import com.bytedance.apm.internal.FunctionSwitcher;
import com.bytedance.apm.launch.LaunchAnalysisContext;
import com.bytedance.apm.launch.LaunchCommon;
import com.bytedance.apm.launch.LaunchDataReport;
import com.bytedance.apm.launch.LaunchPerfDataFetcher;
import com.bytedance.apm.launch.evil.LaunchLockDetector;
import com.bytedance.apm.launch.evil.LaunchSleepDetector;
import com.bytedance.apm.logging.ApmAlogHelper;
import com.bytedance.apm.thread.AsyncEventManager;
import com.bytedance.apm.util.DeviceInfoUtil;
import com.bytedance.apm.util.LogUtils;
import com.bytedance.apm6.perf.base.CommonDataAssembly;
import com.bytedance.monitor.collector.LockMonitorManager;
import com.bytedance.perf.monitor.EvilMethodTracer;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class TraceStats {
    public static final int FLAG_EXTRA_INFO_IO = 16;
    public static final int FLAG_EXTRA_INFO_NET = 1;
    public static final int FLAG_EXTRA_INFO_NONE = 0;
    public static final int FLAG_EXTRA_INFO_THREAD = 256;
    private static final String TAG = "AppStartStats";
    private static volatile boolean isFirst = true;
    private final ConcurrentHashMap<String, TraceTimeEntity> timeSpanMap;
    private long traceBeginTimestamp;
    private long traceEndTimestamp;
    private final String traceName;
    private final String traceServiceName;

    public interface LockFetchListener {
        void lockTime(long r1);
    }

    static {
    }

    static /* synthetic */ boolean access$000(TraceStats r0) {
        return r0.isLaunchService();
    }

    static /* synthetic */ long access$100(TraceStats r2) {
        return r2.traceEndTimestamp;
    }

    static /* synthetic */ void access$200(TraceStats r0, int r1, String r2, String r3, long r4, LaunchPerfDataFetcher.LaunchTraceData r6) {
        r0.reportAsync(r1, r2, r3, r4, r6);
    }

    public TraceStats(String r3, String r4) {
        this.timeSpanMap = new ConcurrentHashMap(4);
        if ("start_trace".equals(r3) == false) goto L5;
    L9:
        this.traceServiceName = r3;
        this.traceName = r4;
        return;
    L5:
        if ("page_load_trace".equals(r3) == true) goto L9;
        throw new IllegalStateException("Please add TraceServiceName support on TraceState#reportAsync");
    }

    private boolean isLaunchService() {
        return "start_trace".equals(this.traceServiceName);
    }

    public long getTraceBeginTimestamp() {
        return this.traceBeginTimestamp;
    }

    public void startTrace() {
        this.traceBeginTimestamp = System.currentTimeMillis();
    }

    public void startSpan(String r2, String r3) {
        startSpan(r2, r3, false);
    }

    public void startSpan(String r4, String r5, boolean r6) {
        if (this.timeSpanMap.get(r4 + ContactsUtils.CHAR_POUND + r5) == null) goto L5;
        if (r6 == true) goto L5;
        return;
    L5:
        this.timeSpanMap.put(r4 + ContactsUtils.CHAR_POUND + r5, new TraceTimeEntity(System.currentTimeMillis()));
    }

    public void endSpan(String r6, String r7) {
        TraceTimeEntity r0 = this.timeSpanMap.get(r6 + ContactsUtils.CHAR_POUND + r7);
        if (r0 != null) goto L5;
        return;
    L5:
        r0.appendEndTimeAndThread(System.currentTimeMillis(), Thread.currentThread().getName());
        this.timeSpanMap.put(r6 + ContactsUtils.CHAR_POUND + r7, r0);
    }

    public void recordSpan(String r4, String r5, long r6) {
        long r0 = System.currentTimeMillis();
        TraceTimeEntity r2 = new TraceTimeEntity(r0 - r6);
        r2.appendEndTimeAndThread(r0, Thread.currentThread().getName());
        this.timeSpanMap.put(r4 + ContactsUtils.CHAR_POUND + r5, r2);
    }

    public void endTrace(int r8, String r9, long r10) {
        endTrace(r8, r9, r10, 0);
    }

    public void endTrace(int r9, String r10, long r11, long r13) {
        endTrace(r9, "", r10, r11, r13);
    }

    public void endTrace(String r8, String r9, long r10) {
        endTrace(r8, r9, r10, 0);
    }

    public void endTrace(String r9, String r10, long r11, long r13) {
        endTrace(-1, r9, r10, r11, r13);
    }

    private void endTrace(final int r12, final String r13, final String r14, long r15, long r17) {
        if (r12 != (-1)) goto L12;
        if (r13.isEmpty() == false) goto L12;
        if (ApmContext.isDebugMode() == false) goto L12;
        throw new IllegalArgumentException("Launch mode is both none");
    L12:
        if (isLaunchService() == false) goto L14;
        LaunchPerfDataFetcher.LaunchTraceData r0 = LaunchDataReport.createPerfData();
    L15:
        final LaunchPerfDataFetcher.LaunchTraceData r10 = r0;
        this.traceEndTimestamp = System.currentTimeMillis();
        if (r17 <= 0) goto L18;
        this.traceEndTimestamp = this.traceBeginTimestamp + r17;
    L18:
        long r2 = this.traceEndTimestamp - this.traceBeginTimestamp;
        if (r15 <= 0) goto L24;
        if (r2 <= r15) goto L24;
        return;
    L24:
        if (isLaunchService() == false) goto L31;
        if (EvilMethodTracer.isEvilMethodTraceEnable == false) goto L31;
        if (isFirst == false) goto L31;
        isFirst = false;
        reportPerfInfo(r12, r13, this.traceBeginTimestamp, this.traceEndTimestamp);
    L31:
        if (isLaunchService() == true) goto L33;
    L42:
        AsyncEventManager.getInstance().post(new AnonymousClass1(this, r10, r12, r13, r14));
        if (isLaunchService() == false) goto L48;
        LaunchSleepDetector.stopDetect();
        return;
    L48:
        return;
    L33:
        if (LaunchAnalysisContext.getInstance().getMonitorConfig().isDetectLock() == false) goto L42;
        if (FunctionSwitcher.getSwitch(8) == false) goto L42;
        JSONObject r1 = new JSONObject();
        r1.put(LaunchLockDetector.LAUNCH_LOCK_WITH_OWNER_KEY, true);     // Catch: JSONException -> L39
    L41:
        LockMonitorManager.endLockDetect(r1);
    L39:
        e = move-exception;
        e.printStackTrace();
        goto L41
    L14:
        r0 = null;
        goto L15
    }

    public void cancelTrace() {
        this.timeSpanMap.clear();
    }

    private void reportAsync(int r19, String r20, String r21, long r22, LaunchPerfDataFetcher.LaunchTraceData r24) {
        JSONArray r8 = new JSONArray();
        int r9 = 2;
        char r11 = 1;
    L28:
        e = move-exception;
        e.printStackTrace();
    L30:
        ConcurrentHashMap<String, TraceTimeEntity> r0 = this.timeSpanMap;
        if (r0 == null) goto L33;
        r0.clear();
    L33:
        JSONObject r1 = new JSONObject();
        r1.put("name", this.traceName);     // Catch: JSONException -> L60
        r1.put("page_type", this.traceName);     // Catch: JSONException -> L60
        r1.put("start", this.traceBeginTimestamp);     // Catch: JSONException -> L60
        r1.put(TraceStatsConsts.STATS_KEY_END, r22);     // Catch: JSONException -> L60
        r1.put(TraceStatsConsts.STATS_KEY_SPANS, r8);     // Catch: JSONException -> L60
        r1.put(TraceStatsConsts.START_STATS_KEY_COLLECT_FROM, 2);     // Catch: JSONException -> L60
        r1.put(TraceStatsConsts.PAGE_STATS_KEY_PAGE_NAME, r21);     // Catch: JSONException -> L60
        if (r19 == (-1)) goto L38;
        r1.put(TraceStatsConsts.STATS_KEY_LAUNCH_MODE, r19);     // Catch: JSONException -> L60
    L38:
        if (r20.isEmpty() == true) goto L41;
        r1.put(TraceStatsConsts.STATS_KEY_CUSTOM_LAUNCH_MODE, r20);     // Catch: JSONException -> L60
    L41:
        if (ApmAlogHelper.isFeedbackALogEnabled() == false) goto L44;
        ApmAlogHelper.feedbackI(TAG, r1.toString());     // Catch: JSONException -> L60
    L44:
        if (isLaunchService() == true) goto L46;
    L49:
        JSONObject r2 = new JSONObject();
        r2.put(TraceStatsConsts.STATS_KEY_TRACE, r1);     // Catch: JSONException -> L62
        if (r24 == null) goto L55;
        JSONObject r3 = LaunchDataReport.packagePerfData(r24);     // Catch: JSONException -> L62
        if (r3 == null) goto L55;
        r2.put(LaunchCommon.LAUNCH_DATA_PERF_DATA, r3);     // Catch: JSONException -> L62
    L55:
        PerfData r4 = new PerfData(this.traceServiceName, "", null, null, r2);
        CommonDataAssembly.wrapFilters(r4, false);
        if (ApmContext.isDebugMode() == false) goto L58;
        LogUtils.d(TAG, "reportAsync: " + r2);
    L58:
        CommonDataPipeline.getInstance().handle(r4);
        return;
    L46:
        if (LaunchAnalysisContext.getInstance().getConfig().isNeedCollectDeviceInfo() == false) goto L49;
        JSONObject r5 = new JSONObject();
        DeviceInfoUtil.getInstance().addRealTimeDeviceInfo(r5, true);
        DeviceInfoUtil.getInstance().addConstantDeviceInfo(r5, true);
        r1.put(LaunchCommon.LAUNCH_DATA_DEVICE_DATA, r5);     // Catch: Throwable -> L61
        goto L49
    L4:
        if (TextUtils.equals(r21, AutoLaunchTraceHelper.sLauncherActivityName) == false) goto L6;
        r8 = AutoLaunchTraceHelper.assemblySpan();     // Catch: JSONException -> L28
    L6:
        ConcurrentHashMap<String, TraceTimeEntity> r6 = this.timeSpanMap;     // Catch: JSONException -> L28
        if (r6 == null) goto L30;
        if (r6.isEmpty() == true) goto L30;
        Iterator<Map.Entry<String, TraceTimeEntity>> r7 = this.timeSpanMap.entrySet().iterator();     // Catch: JSONException -> L28
    L11:
        if (r7.hasNext() == false) goto L30;
        Map.Entry<String, TraceTimeEntity> r12 = r7.next();     // Catch: JSONException -> L28
        String r13 = r12.getKey();     // Catch: JSONException -> L28
        TraceTimeEntity r14 = r12.getValue();     // Catch: JSONException -> L28
        if (r14.endTimestamp == 0) goto L11;
        JSONObject r15 = new JSONObject();     // Catch: JSONException -> L28
        String[] r16 = r13.split(ContactsUtils.CHAR_POUND);     // Catch: JSONException -> L28
        if (r16.length != r9) goto L24;
        if ("page_load_trace".equals(this.traceServiceName) == false) goto L22;
        r15.put("name", r16[r11]);     // Catch: JSONException -> L28
    L26:
        r15.put("start", r14.startTimestamp);     // Catch: JSONException -> L28
        r15.put(TraceStatsConsts.STATS_KEY_END, r14.endTimestamp);     // Catch: JSONException -> L28
        r15.put("thread", r14.threadName);     // Catch: JSONException -> L28
        r8.put(r15);     // Catch: JSONException -> L28
        r9 = 2;
        r11 = 1;
        goto L11
    L22:
        r15.put(TraceStatsConsts.STATS_KEY_MODULE_NAME, r16[0]);     // Catch: JSONException -> L28
        r15.put(TraceStatsConsts.STATS_KEY_SPAN_NAME, r16[1]);     // Catch: JSONException -> L28
        goto L26
    L24:
        if (r16.length != 1) goto L26;
        r15.put(TraceStatsConsts.STATS_KEY_SPAN_NAME, r16[0]);     // Catch: JSONException -> L28
        goto L26
    }

    private void reportPerfInfo(final int r14, final String r15, final long r16, final long r18) {
        final long[] r3 = MethodCollector.getInstance().copyAllData();
        final long r4 = SystemClock.uptimeMillis();
        if (r3 == null) goto L6;
        AsyncEventManager.getInstance().post(new AnonymousClass2(this, r3, r4, r18, r16, r14, r15));
        return;
    }
}
