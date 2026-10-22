package com.bytedance.apm.perf;

import android.os.Looper;
import android.text.TextUtils;
import com.bytedance.apm.ApmContext;
import com.bytedance.apm.constant.SlardarSettingsConsts;
import com.bytedance.apm.thread.AsyncEventManager;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class ThreadCollector extends AbstractPerfCollector {
    private static final int CPU_COUNT = 0;
    private static final long DEFAULT_COLLECT_INTERVAL_MINUTE = 10;
    private static final long DEFAULT_DELAY_CHECK_MS = 1200000;
    public static final String KEY_CPU_COUNT = "cpu_count";
    public static final String KEY_JAVA_THREAD_COUNT = "java_thread_count";
    public static final String KEY_THREAD_DETAIL = "thread_detail";
    public static final String KEY_THREAD_SCENE = "scene";
    public static final String KEY_TOTAL_THREAD_COUNT = "total_thread_count";
    private static final int PERF_THREAD_COUNT_DEFAULT_THRESHOLD = 300;
    private static boolean isReady;
    private static boolean isThreadHit;
    private static boolean isThreadUploadHit;
    private static int threadCountThreshold;
    private long collectIntervalMs;

    @Override // com.bytedance.apm.perf.AbstractPerfCollector
    protected boolean isTimerMonitor() {
        return true;
    }

    static /* synthetic */ int access$000() {
        return threadCountThreshold;
    }

    static /* synthetic */ boolean access$100() {
        return isReady;
    }

    static /* synthetic */ JSONObject access$200(String r0, int r1, int r2, String r3) {
        return buildJson(r0, r1, r2, r3);
    }

    static {
        CPU_COUNT = Runtime.getRuntime().availableProcessors();
        isReady = false;
        threadCountThreshold = 300;
        isThreadHit = false;
        isThreadUploadHit = false;
    }

    public ThreadCollector() {
        this.collectIntervalMs = 600000;
        this.mCollectorSettingKey = "thread";
    }

    @Override // com.bytedance.apm.perf.AbstractPerfCollector
    protected long workInternalMs() {
        return this.collectIntervalMs;
    }

    @Override // com.bytedance.apm.perf.AbstractPerfCollector, com.bytedance.services.slardar.config.IConfigListener
    public void onReady() {
        super.onReady();
        isReady = true;
    }

    @Override // com.bytedance.apm.perf.AbstractPerfCollector
    protected void doConfig(JSONObject r5) {
        super.doConfig(r5);
        boolean r1 = false;
        if (r5.optInt("enable_thread_collect", 0) != 1) goto L5;
        boolean r0 = true;
    L6:
        isThreadHit = r0;
        if (r5.optInt("enable_upload", 0) != 1) goto L9;
        r1 = true;
    L9:
        isThreadUploadHit = r1;
        threadCountThreshold = r5.optInt(SlardarSettingsConsts.PERF_KEY_THREAD_COUNT_INTERVAL, 300);
        this.collectIntervalMs = r5.optLong("collect_interval", 10) * 60000;
        return;
    L5:
        r0 = false;
        goto L6
    }

    @Override // com.bytedance.apm.perf.AbstractPerfCollector
    protected void onStart() {
        super.onStart();
        if (isThreadHit == true) goto L5;
        return;
    L5:
        if (isThreadUploadHit == true) goto L7;
        return;
    L7:
        if ((System.currentTimeMillis() - ApmContext.getInitTimeStamp()) <= 1200000) goto L12;
        collect();
        return;
    }

    private void collect() {
        reportThreadCount(null, false);
    }

    public static int reportThreadCount(final String r11, final boolean r12) {
        int r1 = new File("/proc/self/task/").list().length;     // Catch: Throwable -> L5
    L6:
        if (r1 != 0) goto L8;
        return 0;
    L8:
        final ThreadGroup r7 = Looper.getMainLooper().getThread().getThreadGroup();
    L10:
        if (r7.getParent() == null) goto L12;
        r7 = r7.getParent();
        goto L10
    L12:
        final int[] r8 = {r7.activeCount()};
        final int r6 = r1;
        AsyncEventManager.getInstance().post(new AnonymousClass1(r12, r8, r11, r6, r7));
        return (r1 << 16) + r8[0];
    L5:
        r1 = 0;
        goto L6
    }

    private static JSONObject buildJson(String r2, int r3, int r4, String r5) {
        JSONObject r0 = new JSONObject();
        if (r3 > 0) goto L16;
    L5:
        r0.put(KEY_JAVA_THREAD_COUNT, r4);     // Catch: JSONException -> L13
        if (TextUtils.isEmpty(r2) == true) goto L9;
        r0.put("scene", r2);     // Catch: JSONException -> L13
    L9:
        if (TextUtils.isEmpty(r5) == true) goto L11;
        r0.put(KEY_THREAD_DETAIL, r5);     // Catch: JSONException -> L13
    L11:
        r0.put("is_main_process", ApmContext.isMainProcess());     // Catch: JSONException -> L13
        r0.put(KEY_CPU_COUNT, CPU_COUNT);     // Catch: JSONException -> L13
        r0.put("process_name", ApmContext.getCurrentProcessName());     // Catch: JSONException -> L13
    L15:
        return r0;
    L13:
        e = move-exception;
        e.printStackTrace();
        goto L15
    L16:
        r0.put(KEY_TOTAL_THREAD_COUNT, r3);     // Catch: JSONException -> L13
        goto L5
    }
}
