package com.bytedance.apm.util;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.os.Debug;
import android.os.Environment;
import android.os.StatFs;
import android.text.TextUtils;
import com.bytedance.security.zenmobile.io.SensitiveType;
import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.BufferedReader;
import java.io.FileReader;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: DeviceInfoUtil.java */
/* JADX INFO: loaded from: classes.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f4970a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f4971b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f4972c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f4973d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f4974e;
    private int f;
    private long g;
    private boolean h;
    private long i;
    private long j;
    private String k;
    private boolean l;
    private long m;
    private long n;
    private double o;
    private long p;
    private long q;
    private double r;
    private long s;
    private long t;
    private double u;
    private boolean v;
    private boolean w;

    /* JADX INFO: compiled from: DeviceInfoUtil.java */
    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final d f4977a = null;

        static {
            f4977a = new d(null);
        }
    }

    private String h() {
        return SensitiveType.UNKNOWN;
    }

    /* synthetic */ d(AnonymousClass1 r1) {
        this();
    }

    public static d a() {
        return a.f4977a;
    }

    private d() {
        b();
        this.f4970a = com.bytedance.apm.c.D();
        c();
    }

    private void b() {
        if (w.a() == false) goto L6;
        final Throwable r0 = new Throwable("Don't use DeviceInfoUtil on main thread.");
        com.bytedance.apm.thread.b.a().a(new AnonymousClass1(this, r0));
        return;
    }

    private void c() {
        if (this.f4970a == true) goto L8;
        return;
    L8:
        d();     // Catch: Throwable -> L7
        g();     // Catch: Throwable -> L7
        j();     // Catch: Throwable -> L7
        return;
    }

    private void d() {
        String r0 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(com.bytedance.apm.c.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getApplicationInfo().nativeLibraryDir;
        if (TextUtils.isEmpty(r0) == false) goto L5;
    L7:
        StringBuilder r1 = new StringBuilder();
        if (Build.VERSION.SDK_INT >= 21) goto L10;
    L18:
        r1 = new StringBuilder(Build.CPU_ABI);
    L19:
        String r2 = r1.toString();
        if (r2 != null) goto L22;
    L24:
        e();
        return;
    L22:
        if (r2.contains("64") == false) goto L24;
        this.f4972c = true;
        goto L24
    L10:
        if (Build.SUPPORTED_ABIS.length <= 0) goto L18;
        int r3 = 0;
    L13:
        if (r3 >= Build.SUPPORTED_ABIS.length) goto L19;
        r1.append(Build.SUPPORTED_ABIS[r3]);
        if (r3 == (Build.SUPPORTED_ABIS.length - 1)) goto L17;
        r1.append(", ");
    L17:
        r3 = r3 + 1;
        goto L13
    L5:
        if (r0.endsWith("arm64") == false) goto L7;
        this.f4971b = true;
        goto L7
    }

    private void e() {
        com.bytedance.apm.internal.b r0 = com.bytedance.apm.internal.b.a();
        String r2 = r0.a("sp_cpu_model");
        int r4 = r0.b("sp_cpu_core_num");
        if (TextUtils.isEmpty(r2) == true) goto L6;
        this.f4973d = r2;
        this.f4974e = r4;
        return;
    L6:
        f();
        if (TextUtils.isEmpty(this.f4973d) == false) goto L9;
        this.f4973d = SensitiveType.UNKNOWN;
    L9:
        r0.a("sp_cpu_model", this.f4973d);
        r0.a("sp_cpu_core_num", this.f4974e);
    }

    private void f() {
        BufferedReader r0 = null;
        String r1 = null;
        BufferedReader r2 = null;
        BufferedReader r3 = new BufferedReader(new FileReader("/proc/cpuinfo"));     // Catch: Throwable -> L21 Exception -> L25
        int r4 = 0;
    L46:
        String r5 = r3.readLine();     // Catch: Throwable -> L18 Exception -> L20
        if (r5 == null) goto L40;
        String[] r6 = r5.split(":");     // Catch: Throwable -> L18 Exception -> L20
        if (r6.length != 2) goto L46;
        if (r6[0].startsWith("Hardware") == true) goto L12;
        if (r6[0].startsWith("processor") == false) goto L46;
        r4 = r4 + 1;
        goto L46
    L12:
        r1 = r6[1].trim();     // Catch: Throwable -> L18 Exception -> L20
        goto L46
    L40:
        r3.close();     // Catch: Exception -> L35
    L29:
        this.f4973d = r1;
        this.f4974e = r4;
        if (TextUtils.isEmpty(r1) == true) goto L32;
        return;
    L32:
        if (s.p() == false) goto L59;
        this.f4973d = Build.HARDWARE;
        return;
    L59:
        return;
    L20:
        String r7 = r1;
        r2 = r3;
    L26:
        if (r2 != null) goto L42;
    L28:
        r1 = r7;
        goto L29
    L42:
        r2.close();     // Catch: Exception -> L37
    L18:
        th = th;
        r0 = r3;
    L22:
        if (r0 != null) goto L38;
    L24:
        throw th;
    L38:
        r0.close();     // Catch: Exception -> L36
        goto L24
    L25:
        r4 = 0;
        r7 = null;
    L21:
        th = th;
        goto L22
    }

    private void g() {
        ActivityManager r0 = (ActivityManager) ZeusTransformUtils.preCheckCast(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(com.bytedance.apm.c.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getSystemService("activity"), ActivityManager.class, "com.obric.aiagent.plugin");
        ActivityManager.MemoryInfo r1 = new ActivityManager.MemoryInfo();
        r0.getMemoryInfo(r1);
        if (Build.VERSION.SDK_INT >= 16) goto L5;
        this.f = -1;
    L7:
        if (Build.VERSION.SDK_INT >= 21) goto L10;
        this.k = "dlmalloc";
        return;
    L10:
        if (Build.VERSION.SDK_INT < 24) goto L12;
        this.k = "jemalloc";
        return;
    L12:
        String r2 = com.bytedance.apm.internal.b.a().a("sp_malloc_impl");
        if (r2 != null) goto L15;
        r2 = h();
        com.bytedance.apm.internal.b.a().a("sp_malloc_impl", r2);
    L15:
        this.k = r2;
        return;
    L5:
        this.f = (int) (r1.totalMem / 536870912);
        goto L7
    }

    private void i() {
        this.g = Debug.getNativeHeapAllocatedSize() / 1048576;
        Runtime r0 = Runtime.getRuntime();
        long r4 = r0.maxMemory();
        long r6 = r0.freeMemory();
        long r1 = r0.totalMemory();
        this.i = r4 / 1048576;
        long r2 = r1 - r6;
        this.j = r2 / 1048576;
        if (r2 <= (r4 * 0.95f)) goto L5;
        boolean r3 = true;
    L6:
        this.h = r3;
        return;
    L5:
        r3 = false;
        goto L6
    }

    private void j() {
        if (Build.VERSION.SDK_INT < 18) goto L5;
        boolean r1 = true;
    L6:
        this.l = r1;
        StatFs r2 = new StatFs(Environment.getRootDirectory().getAbsolutePath());
        if (this.l == false) goto L9;
        this.n = r2.getAvailableBytes();
        this.m = r2.getBlockSizeLong() * r2.getBlockCountLong();
    L10:
        this.o = a(this.n, this.m);
        StatFs r3 = new StatFs(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(com.bytedance.apm.c.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getFilesDir().getAbsolutePath());     // Catch: Throwable -> L28
        if (this.l == false) goto L14;
        this.q = r3.getAvailableBytes();     // Catch: Throwable -> L28
        this.p = r3.getBlockSizeLong() * r3.getBlockCountLong();     // Catch: Throwable -> L28
    L15:
        this.r = a(this.q, this.p);     // Catch: Throwable -> L28
        goto L16
    L14:
        this.q = ((long) r3.getBlockSize()) * ((long) r3.getAvailableBlocks());     // Catch: Throwable -> L28
        this.p = ((long) r3.getBlockSize()) * ((long) r3.getBlockCount());     // Catch: Throwable -> L28
    L16:
        String r0 = null;
        r0 = Environment.getExternalStorageState();     // Catch: Exception -> L29
    L18:
        boolean r4 = TextUtils.equals(r0, "mounted");
        this.v = r4;
        if (r4 == false) goto L25;
        StatFs r5 = new StatFs(Environment.getExternalStorageDirectory().getAbsolutePath());     // Catch: Throwable -> L30
        if (this.l == false) goto L23;
        this.t = r5.getAvailableBytes();     // Catch: Throwable -> L30
        this.s = r5.getBlockSizeLong() * r5.getBlockCountLong();     // Catch: Throwable -> L30
    L24:
        this.u = a(this.t, this.s);     // Catch: Throwable -> L30
        goto L26
    L23:
        this.t = ((long) r5.getBlockSize()) * ((long) r5.getAvailableBlocks());     // Catch: Throwable -> L30
        this.s = ((long) r5.getBlockSize()) * ((long) r5.getBlockCount());     // Catch: Throwable -> L30
        goto L24
    L25:
        this.s = 0;     // Catch: Throwable -> L30
    L26:
        this.w = Environment.isExternalStorageRemovable();
        return;
    L9:
        this.n = ((long) r2.getBlockSize()) * ((long) r2.getAvailableBlocks());
        this.m = ((long) r2.getBlockSize()) * ((long) r2.getBlockCount());
        goto L10
    L5:
        r1 = false;
        goto L6
    }

    private double a(long r3, long r5) {
        if (r5 != 0) goto L7;
        return 0.0d;
    L7:
        return Math.round((r3 / r5) * 100.0d) / 100.0d;
    }

    public void a(JSONObject r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        if (this.f4970a == false) goto L12;
        r3.put("apm_is_app_64", this.f4971b);
        r3.put("apm_is_device_64", this.f4972c);
        r3.put("apm_cpu_model", this.f4973d);
        int r2 = this.f4974e;
        if (r2 <= 0) goto L11;
        r3.put("apm_cpu_core_num", r2);
        return;
    L11:
        return;
    }

    public void b(JSONObject r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        if (this.f4970a == false) goto L9;
        r3.put("apm_physical_mem", this.f);
        r3.put("apm_malloc_impl", this.k);
        return;
    }

    public void c(JSONObject r4) {
        if (r4 != null) goto L4;
        return;
    L4:
        if (this.f4970a == false) goto L9;
        i();
        r4.put("apm_native_heap_size", this.g);
        r4.put("apm_java_heap_leak", this.h);
        r4.put("apm_java_heap_used", this.j);
        r4.put("apm_java_heap_max", this.i);
        return;
    }

    public void d(JSONObject r7) {
        if (r7 != null) goto L4;
        return;
    L4:
        if (this.f4970a == true) goto L7;
        return;
    L7:
        if (this.m == 0) goto L10;
        r7.put("apm_sys_avail_size", this.n / 1048576);
        r7.put("apm_sys_avail_ratio", this.o);
    L10:
        if (this.p == 0) goto L13;
        r7.put("apm_data_avail_size", a(this.q));
        r7.put("apm_data_avail_ratio", this.r);
    L13:
        if (this.s == 0) goto L16;
        r7.put("apm_sd_avail_size", a(this.t));
        r7.put("apm_sd_avail_ratio", this.u);
    L16:
        if (this.v == false) goto L20;
        r7.put("apm_external_removable", this.w);
        return;
    }

    public void e(JSONObject r2) {
        a(r2, false);
    }

    public void f(JSONObject r2) {
        b(r2, false);
    }

    public void a(JSONObject r1, boolean r2) {
        if (this.f4970a == true) goto L9;
        if (r2 == true) goto L9;
        return;
    L9:
        a().c(r1);     // Catch: JSONException -> L8
        return;
    }

    public void b(JSONObject r1, boolean r2) {
        if (this.f4970a == true) goto L9;
        if (r2 == true) goto L9;
        return;
    L9:
        a().a(r1);     // Catch: JSONException -> L8
        a().b(r1);     // Catch: JSONException -> L8
        a().d(r1);     // Catch: JSONException -> L8
        return;
    }

    private long a(long r3) {
        return r3 / DownloadConstants.GB;
    }
}
