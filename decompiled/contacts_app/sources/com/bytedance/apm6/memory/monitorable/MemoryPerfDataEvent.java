package com.bytedance.apm6.memory.monitorable;

import com.bytedance.apm.constant.CommonKey;
import com.bytedance.apm6.foundation.context.ApmContext;
import com.bytedance.apm6.memory.bean.MemoryCollectInfo;
import com.bytedance.apm6.perf.base.PerfFilterManager;
import com.bytedance.apm6.perf.base.model.PerfBaseEvent;
import com.bytedance.apm6.service.ServiceManager;
import com.bytedance.apm6.service.device.IDeviceInfoService;
import com.bytedance.apm6.util.JsonUtils;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class MemoryPerfDataEvent extends PerfBaseEvent {
    private static final String KEY_BLOCK_GC_COUNT = "block_gc_count";
    private static final String KEY_BLOCK_GC_TIME = "block_gc_time";
    private static final String KEY_GC_COUNT = "gc_count";
    private static final String KEY_GC_TIME = "gc_time";
    private static final String KEY_REACH_TOP_JAVA = "reach_top_java";
    private static final String PERF_MEM_DALVIK_PSS_BACKGROUND = "dalvik_pss_background";
    private static final String PERF_MEM_DALVIK_PSS_FOREGROUND = "dalvik_pss_foreground";
    private static final String PERF_MEM_GRAPHICS_MEM_BACKGROUND = "graphics_background";
    private static final String PERF_MEM_GRAPHICS_MEM_FOREGROUND = "graphics_foreground";
    private static final String PERF_MEM_NATIVE_PSS_BACKGROUND = "native_pss_background";
    private static final String PERF_MEM_NATIVE_PSS_FOREGROUND = "native_pss_foreground";
    private static final String PERF_MEM_TOTAL_JAVA_BACKGROUND = "java_heap_background";
    private static final String PERF_MEM_TOTAL_JAVA_BACKGROUND_USED_RATE = "java_heap_background_used_rate";
    private static final String PERF_MEM_TOTAL_JAVA_FOREGROUND = "java_heap_foreground";
    private static final String PERF_MEM_TOTAL_JAVA_FOREGROUND_USED_RATE = "java_heap_foreground_used_rate";
    private static final String PERF_MEM_TOTAL_PSS_BACKGROUND = "total_pss_background";
    private static final String PERF_MEM_TOTAL_PSS_FOREGROUND = "total_pss_foreground";
    private static final String PERF_MEM_VM_SIZE_BACKGROUND = "vm_size_background";
    private static final String PERF_MEM_VM_SIZE_FOREGROUND = "vm_size_foreground";
    private static final String SERVICE_NAME = "memory";
    private boolean background;
    private long blockingGcCount;
    private long blockingGcTime;
    private long dalvikUsedSize;
    private long gcCount;
    private long gcTime;
    private long graphics;
    private boolean isMemoryReachTop;
    private boolean isRealTimeMemEnable;
    private long javaUsedMemory;
    private double javaUsedMemoryRate;
    private Map<Object, Object> mmapInfo;
    private long nativePss;
    private long totalPss;
    private long vmSize;

    @Override // com.bytedance.apm6.perf.base.model.PerfBaseEvent
    protected String getServiceName() {
        return "memory";
    }

    @Override // com.bytedance.apm6.monitor.Monitorable
    public boolean isValid() {
        return true;
    }

    public MemoryPerfDataEvent(long r4, long r6, long r8, long r10, boolean r12, long r13, long r15, long r17, long r19, long r21, long r23, double r25, boolean r27, boolean r28) {
        this.gcCount = r4;
        this.gcTime = r6;
        this.blockingGcCount = r8;
        this.blockingGcTime = r10;
        this.background = r12;
        this.nativePss = r13;
        this.totalPss = r15;
        this.javaUsedMemory = r17;
        this.dalvikUsedSize = r19;
        this.graphics = r21;
        this.vmSize = r23;
        this.javaUsedMemoryRate = r25;
        this.isMemoryReachTop = r27;
        this.isRealTimeMemEnable = r28;
    }

    public void setMmapInfo(Map<Object, Object> r1) {
        this.mmapInfo = r1;
    }

    @Override // com.bytedance.apm6.perf.base.model.PerfBaseEvent
    protected JSONObject getExtraValues() {
        JSONObject r0 = new JSONObject();
        r0.put("gc_count", this.gcCount);     // Catch: JSONException -> L12
        r0.put("gc_time", this.gcTime);     // Catch: JSONException -> L12
        r0.put("block_gc_count", this.blockingGcCount);     // Catch: JSONException -> L12
        r0.put("block_gc_time", this.blockingGcTime);     // Catch: JSONException -> L12
        if (this.background == false) goto L6;
        r0.put("dalvik_pss_background", this.dalvikUsedSize);     // Catch: JSONException -> L12
        r0.put("native_pss_background", this.nativePss);     // Catch: JSONException -> L12
        r0.put("total_pss_background", this.totalPss);     // Catch: JSONException -> L12
        r0.put("java_heap_background", this.javaUsedMemory);     // Catch: JSONException -> L12
        r0.put("java_heap_background_used_rate", this.javaUsedMemoryRate);     // Catch: JSONException -> L12
        r0.put("vm_size_background", this.vmSize);     // Catch: JSONException -> L12
        r0.put("graphics_background", this.graphics);     // Catch: JSONException -> L12
    L8:
        if (this.isMemoryReachTop == false) goto L10;
        r0.put("reach_top_java", 1);     // Catch: JSONException -> L12
    L10:
        calMapsInfo(r0);     // Catch: JSONException -> L12
    L14:
        return r0;
    L6:
        r0.put("dalvik_pss_foreground", this.dalvikUsedSize);     // Catch: JSONException -> L12
        r0.put("native_pss_foreground", this.nativePss);     // Catch: JSONException -> L12
        r0.put("total_pss_foreground", this.totalPss);     // Catch: JSONException -> L12
        r0.put("java_heap_foreground", this.javaUsedMemory);     // Catch: JSONException -> L12
        r0.put("java_heap_foreground_used_rate", this.javaUsedMemoryRate);     // Catch: JSONException -> L12
        r0.put("vm_size_foreground", this.vmSize);     // Catch: JSONException -> L12
        r0.put("graphics_foreground", this.graphics);     // Catch: JSONException -> L12
    L12:
        e = move-exception;
        e.printStackTrace();
        goto L14
    }

    private void calMapsInfo(JSONObject r5) {
        if (r5 != null) goto L14;
        return;
    L14:
        Map<Object, Object> r4 = this.mmapInfo;     // Catch: Exception -> L13
        if (r4 != null) goto L7;
        return;
    L7:
        Iterator<Map.Entry<Object, Object>> r6 = r4.entrySet().iterator();     // Catch: Exception -> L13
    L9:
        if (r6.hasNext() == false) goto L18;
        Map.Entry<Object, Object> r0 = r6.next();     // Catch: Exception -> L13
        r5.put((String) r0.getKey(), Long.parseLong((String) r0.getValue()));     // Catch: Exception -> L13
    L18:
        return;
    }

    public double getJavaUsedMemoryRate() {
        return this.javaUsedMemoryRate;
    }

    @Override // com.bytedance.apm6.perf.base.model.PerfBaseEvent
    protected JSONObject getExtraStatus() {
        JSONObject r0 = new JSONObject();     // Catch: Throwable -> L8
        r0.put("scene", PerfFilterManager.getInstance().getSceneString());     // Catch: Throwable -> L8
        r0.put("process_name", ApmContext.getCurrentProcessName());     // Catch: Throwable -> L8
        if (this.background == true) goto L5;
        boolean r3 = true;
    L6:
        r0.put(CommonKey.KEY_IS_FRONT, r3);     // Catch: Throwable -> L8
        r0.put("is_main_process", ApmContext.isMainProcess());     // Catch: Throwable -> L8
        return r0;
    L5:
        r3 = false;
    L8:
        return null;
    }

    public boolean isBackground() {
        return this.background;
    }

    @Override // com.bytedance.apm6.perf.base.model.PerfBaseEvent
    public JSONObject getFilters() {
        JSONObject r0 = PerfFilterManager.getInstance().getPerfFiltersJson();
        if (this.isRealTimeMemEnable == true) goto L14;
    L6:
        IDeviceInfoService r1 = (IDeviceInfoService) ServiceManager.getService(IDeviceInfoService.class);
        if (r1 != null) goto L12;
    L9:
        return r0;
    L12:
        JsonUtils.copyJson2(r0, r1.getDeviceInfo());     // Catch: Exception -> L11
        goto L9
    L14:
        JsonUtils.copyJson2(r0, PerfFilterManager.getInstance().getRealTimeMemInfo());     // Catch: Exception -> L10
        goto L6
    }

    public MemoryCollectInfo getMemoryCollectInfo() {
        MemoryCollectInfo r0 = new MemoryCollectInfo();
        r0.gcCount = this.gcCount;
        r0.gcTime = this.gcTime;
        r0.blockingGcCount = this.blockingGcCount;
        r0.blockingGcTime = this.blockingGcTime;
        r0.background = this.background;
        r0.nativePss = this.nativePss;
        r0.totalPss = this.totalPss;
        r0.javaUsedMemory = this.javaUsedMemory;
        r0.dalvikUsedSize = this.dalvikUsedSize;
        r0.graphics = this.graphics;
        r0.vmSize = this.vmSize;
        r0.isMemoryReachTop = this.isMemoryReachTop;
        return r0;
    }

    public String toString() {
        return "MemoryPerfMonitorable{gcCount=" + this.gcCount + ", gcTime=" + this.gcTime + ", blockingGcCount=" + this.blockingGcCount + ", blockingGcTime=" + this.blockingGcTime + ", background=" + this.background + ", nativePss=" + this.nativePss + ", totalPss=" + this.totalPss + ", javaUsedMemory=" + this.javaUsedMemory + ", dalvikUsedSize=" + this.dalvikUsedSize + ", graphics=" + this.graphics + ", vmSize=" + this.vmSize + ", javaUsedMemoryRate=" + this.javaUsedMemoryRate + ", isMemoryReachTop=" + this.isMemoryReachTop + '}';
    }
}
