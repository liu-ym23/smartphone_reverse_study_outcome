package com.bytedance.apm6.java_alloc;

import androidx.core.os.EnvironmentCompat;
import com.bytedance.apm.constant.ExceptionConsts;
import com.bytedance.apm.constant.ExceptionTypeName;
import com.bytedance.apm.data.pipeline.CommonDataPipeline;
import com.bytedance.apm.data.type.ExceptionLogData;
import com.bytedance.apm6.foundation.context.ApmContext;
import com.bytedance.apm6.java_alloc.model.ReportData;
import com.bytedance.apm6.java_alloc.model.ReportInfo;
import com.bytedance.apm6.perf.base.PerfFilterManager;
import com.bytedance.apm6.service.ServiceManager;
import com.bytedance.apm6.util.log.Logger;
import com.bytedance.monitor.collector.MonitorJni;
import com.bytedance.monitor.collector.PerfMonitorManager;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class JavaAllocCollector {
    private static final int MAGIC_NUM = 123457;
    public static final int MAX_BYTE_LEN = 4096;
    private static final int MEM_INIT_FAILED = 0;
    private static final int MEM_INIT_SUCC = 1;
    private static final int MEM_UNINIT = -1;
    private static final String TAG = "APM-JavaAlloc";
    public static final long UNKNOWN_VALUE = -1;
    private static int sJavaMemState = -1;
    private static int sJavaMonitorState = -1;
    private JavaAllocConfig config;
    public JavaAllocConfig forcedConfig;
    private volatile boolean initialized;

    /* JADX INFO: renamed from: com.bytedance.apm6.java_alloc.JavaAllocCollector$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private static class InnerHolder {
        private static final JavaAllocCollector instance = null;

        private InnerHolder() {
        }

        static /* synthetic */ JavaAllocCollector access$000() {
            return instance;
        }

        static {
            instance = new JavaAllocCollector(null);
        }
    }

    static {
    }

    /* synthetic */ JavaAllocCollector(AnonymousClass1 r1) {
        this();
    }

    private JavaAllocCollector() {
    }

    public static JavaAllocCollector getInstance() {
        return InnerHolder.access$000();
    }

    public void init() {
        if (this.initialized == true) goto L9;
        JavaAllocConfigService r0 = (JavaAllocConfigService) ServiceManager.getService(JavaAllocConfigService.class);
        if (r0 == null) goto L7;
        updateConfig(r0.getConfig());
    L7:
        isInitJavaMem();
        this.initialized = true;
        return;
    }

    public void updateConfig(JavaAllocConfig r1) {
        if (r1 != null) goto L4;
        return;
    L4:
        this.config = r1;
    }

    public JavaAllocConfig getConfig() {
        JavaAllocConfig r0 = this.forcedConfig;
        if (r0 == null) goto L6;
        return r0;
    L6:
        return this.config;
    }

    public boolean enableAllocateMonitor(String r2) {
        if (getConfig() != null) goto L5;
        return false;
    L5:
        if (isInitJavaMonitor() == false) goto L13;
        if (r2 != null) goto L10;
        r2 = EnvironmentCompat.MEDIA_UNKNOWN;
    L10:
        return MonitorJni.startOrStopAllocatedMonitor(true, r2);
    L13:
        return false;
    }

    public boolean disableAllocateMonitor() {
        if (isInitJavaMonitor() == true) goto L6;
        return false;
    L6:
        return MonitorJni.startOrStopAllocatedMonitor(false, null);
    }

    public boolean initAllocateMonitor() {
        return isInitJavaMonitor();
    }

    public boolean deinitAllocateMonitor() {
        if (1 != sJavaMonitorState) goto L10;
        if (isInitJavaMem() == false) goto L10;
        if (MonitorJni.setEnableAllocatedMonitor(false, 0, 0, Integer.MAX_VALUE, 2147483647L, MonitorJni.class.getClassLoader()) == false) goto L10;
        sJavaMonitorState = -1;
    L10:
        if (sJavaMonitorState == (-1)) goto L14;
        return false;
    L14:
        return true;
    }

    private boolean isInitJavaMem() {
        JavaAllocConfig r2 = getConfig();
        if (r2 != null) goto L5;
        return false;
    L5:
        if (r2.enable_collect == true) goto L8;
        return false;
    L8:
        if ((-1) != sJavaMemState) goto L13;
        if (PerfMonitorManager.isSoLoaded() == false) goto L13;
        sJavaMemState = MonitorJni.initJavaMem() ? 1 : 0;
    L13:
        if (sJavaMemState == 1) goto L15;
        return false;
    L15:
        return true;
    }

    private boolean isInitJavaMonitor() {
        JavaAllocConfig r0 = getConfig();
        if (r0 != null) goto L5;
        return false;
    L5:
        if (r0.enable_collect == true) goto L8;
        return false;
    L8:
        if ((-1) != sJavaMonitorState) goto L13;
        if (isInitJavaMem() == false) goto L13;
        sJavaMonitorState = MonitorJni.setEnableAllocatedMonitor(true, r0.collect_per_thousand_alloc, r0.dump_per_thousand_collect, r0.threshold_alloc_frequency, r0.threshold_alloc_size, MonitorJni.class.getClassLoader()) ? 1 : 0;
    L13:
        if (sJavaMonitorState == 1) goto L15;
        return false;
    L15:
        return true;
    }

    public long getBytesAllocatedEver() {
        if (isInitJavaMem() == true) goto L7;
        return -1;
    L7:
        return MonitorJni.getBytesAllocatedEver();
    }

    public long getObjectsAllocatedEver() {
        if (isInitJavaMem() == true) goto L7;
        return -1;
    L7:
        return MonitorJni.getObjectsAllocatedEver();
    }

    public long getGcCount() {
        if (isInitJavaMem() == true) goto L7;
        return -1;
    L7:
        return MonitorJni.getGCCount();
    }

    public long getGcTime() {
        if (isInitJavaMem() == true) goto L7;
        return -1;
    L7:
        return MonitorJni.getGCTime();
    }

    public long getBlockingGcCount() {
        if (isInitJavaMem() == true) goto L7;
        return -1;
    L7:
        return MonitorJni.getBlockGCCount();
    }

    public long getBlockingGcTime() {
        if (isInitJavaMem() == true) goto L7;
        return -1;
    L7:
        return MonitorJni.getBlockGCTime();
    }

    private ByteBuffer getReportInfoInner() {
        if (isInitJavaMem() == true) goto L7;
        return null;
    L7:
        return MonitorJni.getAllocReportInfo();
    }

    public void clearAllocateInfo() {
        if (isInitJavaMem() == true) goto L5;
        return;
    L5:
        MonitorJni.clearAllocateInfo();
    }

    public long getMinorFaults() {
        if (PerfMonitorManager.isSoLoaded() == true) goto L7;
        return -1;
    L7:
        return MonitorJni.getMinorFaults();
    }

    public long getMajorFaults() {
        if (PerfMonitorManager.isSoLoaded() == true) goto L7;
        return -1;
    L7:
        return MonitorJni.getMajorFaults();
    }

    private static String getString(ByteBuffer r3, byte[] r4) {
        return new String(r4, 0, fillStringBytes(r3, r4), StandardCharsets.US_ASCII);
    }

    public static int fillStringBytes(ByteBuffer r3, byte[] r4) {
        int r0 = r3.getInt();
        if (r0 <= r4.length) goto L5;
        r3.position((r3.position() + r0) - r4.length);
        r3.get(r4, 0, r4.length);
        return r4.length;
    L5:
        r3.get(r4, 0, r0);
        return r0;
    }

    public void getReportInfo(IRecordReader r27) {
        if (PerfMonitorManager.isSoLoaded() == true) goto L5;
        return;
    L5:
        if (r27 != null) goto L7;
        return;
    L7:
        ByteBuffer r0 = getReportInfoInner();
        if (r0 != null) goto L10;
        return;
    L10:
        r0.order(ByteOrder.LITTLE_ENDIAN);
        r0.position(0);
        if (r0.getInt() == MAGIC_NUM) goto L13;
        return;
    L13:
        byte[] r14 = new byte[4096];
        Trace r15 = new Trace();
        long r16 = r0.getLong();
        String r2 = getString(r0, r14);
        int r6 = r0.getInt();
        int r7 = r0.getInt();
        int r8 = r0.getInt();
        int r1 = r0.getInt();
        long r11 = r0.getLong();
        long r18 = r0.getLong();
        long r20 = r0.getLong();
        long r22 = r0.getLong();
        int r9 = r0.getInt();
        byte[] r25 = r14;
        r27.onHeadInfo(r2, r20, r22, r9, new JavaAllocConfig(true, true, r6, r7, r8, r1), r11, r18);
        int r10 = 0;
    L14:
        if (r10 >= r9) goto L19;
        byte[] r12 = r25;
        String r3 = getString(r0, r12);
        int r13 = r0.getInt();
        int r4 = r0.getInt();
        int r5 = r0.getInt();
        r15.setStream(r0);
        if (r27.onItem(r3, r4, r5, r15, r13) == false) goto L19;
        r10 = r10 + 1;
        r25 = r12;
    L19:
        MonitorJni.releaseByteBuffer(r16);
    }

    public ReportData getReportData() {
        DefaultRecordReader r0 = new DefaultRecordReader();
        getReportInfo(r0);
        return new ReportData(r0.result, r0.getDuration(), r0.getConfig());
    }

    public void collectAndReport() {
        if (getConfig().enable_upload == true) goto L5;
        return;
    L5:
        if (getConfig().enable_collect == false) goto L42;
        ReportData r9 = getReportData();
        if (r9 == null) goto L30;
        if (r9.infoList == null) goto L30;
        if (r9.infoList.size() == 0) goto L30;
        long r0 = System.currentTimeMillis();
        Iterator<ReportInfo> r2 = r9.infoList.iterator();
    L15:
        if (r2.hasNext() == false) goto L44;
        ReportInfo r3 = r2.next();
        JSONObject r4 = PerfFilterManager.getInstance().getPerfFiltersJson();     // Catch: JSONException -> L33
        r4.put("is_main_process", ApmContext.isMainProcess());     // Catch: JSONException -> L33
        r4.put("process_name", ApmContext.getCurrentProcessName());     // Catch: JSONException -> L33
        JSONObject r5 = r3.packJson(r4);     // Catch: JSONException -> L33
        JSONObject r6 = new JSONObject();     // Catch: JSONException -> L33
        r6.put("alloc_duration", r9.duration);     // Catch: JSONException -> L33
        if (r9.config == null) goto L23;
        Iterator<String> r7 = r9.config.keys();     // Catch: JSONException -> L33
    L21:
        if (r7.hasNext() == false) goto L23;
        String r8 = r7.next();     // Catch: JSONException -> L33
        r6.put(r8, r9.config.opt(r8));     // Catch: JSONException -> L33
    L23:
        r5.put("custom", r6);     // Catch: JSONException -> L33
        if (r3.exceptionType != 1) goto L26;
        String r10 = ExceptionTypeName.EXCEPTION_EVENT_TYPE_FREQUENT_OBJECT;
    L27:
        r5.put("event_type", r10);     // Catch: JSONException -> L33
        ExceptionLogData r11 = new ExceptionLogData(ExceptionConsts.MONITOR_TYPE_ALLOC, r5, r0);     // Catch: JSONException -> L33
        r11.forceSample();     // Catch: JSONException -> L33
        CommonDataPipeline.getInstance().handle(r11);     // Catch: JSONException -> L33
        goto L15
    L26:
        r10 = ExceptionTypeName.EXCEPTION_EVENT_TYPE_LARGE_OBJECT;
        goto L27
    L44:
        return;
    L30:
        if (ApmContext.isDebugMode() == false) goto L43;
        Logger.i(TAG, "empty report info");
        return;
    L43:
        return;
    }
}
