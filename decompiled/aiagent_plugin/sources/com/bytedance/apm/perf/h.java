package com.bytedance.apm.perf;

import android.os.Looper;
import android.text.TextUtils;
import com.bytedance.apm.battery.dao.DBHelper;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: ThreadCollector.java */
/* JADX INFO: loaded from: classes.dex */
public class h extends a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int f4834a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static boolean f4835b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static int f4836c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static boolean f4837e;
    private static boolean f;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f4838d;

    @Override // com.bytedance.apm.perf.a
    public boolean c() {
        return true;
    }

    static /* synthetic */ int a() {
        return f4836c;
    }

    static /* synthetic */ JSONObject a(String r0, int r1, int r2, String r3) {
        return b(r0, r1, r2, r3);
    }

    static /* synthetic */ boolean g() {
        return f4835b;
    }

    static {
        f4834a = Runtime.getRuntime().availableProcessors();
        f4835b = false;
        f4836c = 300;
        f4837e = false;
        f = false;
    }

    public h() {
        this.f4838d = 600000;
        this.g = "thread";
    }

    @Override // com.bytedance.apm.perf.a
    public long d() {
        return this.f4838d;
    }

    @Override // com.bytedance.apm.perf.a, com.bytedance.services.slardar.config.a
    public void onReady() {
        super.onReady();
        f4835b = true;
    }

    @Override // com.bytedance.apm.perf.a
    public void a(JSONObject r5) {
        super.a(r5);
        boolean r1 = false;
        if (r5.optInt("enable_thread_collect", 0) != 1) goto L5;
        boolean r0 = true;
    L6:
        f4837e = r0;
        if (r5.optInt("enable_upload", 0) != 1) goto L9;
        r1 = true;
    L9:
        f = r1;
        f4836c = r5.optInt("thread_count_threshold", 300);
        this.f4838d = r5.optLong("collect_interval", 10) * 60000;
        return;
    L5:
        r0 = false;
        goto L6
    }

    @Override // com.bytedance.apm.perf.a
    public void e() {
        super.e();
        if (f4837e == true) goto L5;
        return;
    L5:
        if (f == true) goto L7;
        return;
    L7:
        if ((System.currentTimeMillis() - com.bytedance.apm.c.t()) <= 1200000) goto L12;
        h();
        return;
    }

    private void h() {
        a(null, false);
    }

    public static int a(final String r11, final boolean r12) {
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
        com.bytedance.apm.thread.b.a().a(new AnonymousClass1(r12, r8, r11, r6, r7));
        return (r1 << 16) + r8[0];
    L5:
        r1 = 0;
        goto L6
    }

    private static JSONObject b(String r2, int r3, int r4, String r5) {
        JSONObject r0 = new JSONObject();
        if (r3 > 0) goto L16;
    L5:
        r0.put("java_thread_count", r4);     // Catch: JSONException -> L13
        if (TextUtils.isEmpty(r2) == true) goto L9;
        r0.put(DBHelper.BATTERY_COL_SCENE, r2);     // Catch: JSONException -> L13
    L9:
        if (TextUtils.isEmpty(r5) == true) goto L11;
        r0.put("thread_detail", r5);     // Catch: JSONException -> L13
    L11:
        r0.put("is_main_process", com.bytedance.apm.c.d());     // Catch: JSONException -> L13
        r0.put("cpu_count", f4834a);     // Catch: JSONException -> L13
        r0.put("process_name", com.bytedance.apm.c.c());     // Catch: JSONException -> L13
    L15:
        return r0;
    L13:
        e = move-exception;
        e.printStackTrace();
        goto L15
    L16:
        r0.put("total_thread_count", r3);     // Catch: JSONException -> L13
        goto L5
    }
}
