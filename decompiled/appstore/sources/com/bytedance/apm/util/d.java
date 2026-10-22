package com.bytedance.apm.util;

import android.app.ActivityManager;
import android.os.Build;
import android.os.Debug;
import android.os.Environment;
import android.os.StatFs;
import android.support.v4.media.session.PlaybackStateCompat;
import android.text.TextUtils;
import com.bytedance.apm.MonitorCoreExceptionManager;
import com.bytedance.apm.constant.CommonKey;
import com.bytedance.apm.constant.PerfConsts;
import com.bytedance.apm.thread.AsyncEventManager;
import java.io.BufferedReader;
import java.io.FileReader;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f6629a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f6630b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f6631c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f6632d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f6633e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f6634f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f6635g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f6636h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f6637i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public long f6638j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f6639k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f6640l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public long f6641m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public long f6642n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public double f6643o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public long f6644p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public long f6645q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public double f6646r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public long f6647s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public long f6648t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public double f6649u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f6650v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f6651w;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Throwable f6652a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ d f6653b;

        public a(d r10, Throwable r11) {
            this.f6653b = r10;
            this.f6652a = r11;
        }

        @Override // java.lang.Runnable
        public void run() {
            MonitorCoreExceptionManager.e().b(this.f6652a, "apm_error");
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d f6654a = null;

        static {
            f6654a = new d(null);
        }
    }

    public /* synthetic */ d(a r10) {
        this();
    }

    public static d k() {
        return b.f6654a;
    }

    public void a(JSONObject r10) {
        b(r10, false);
    }

    public void b(JSONObject r10, boolean r11) {
        if (this.f6629a == true) goto L9;
        if (r11 == true) goto L9;
        return;
    L9:
        k().d(r10);     // Catch: JSONException -> L8
        k().c(r10);     // Catch: JSONException -> L8
        k().h(r10);     // Catch: JSONException -> L8
        return;
    }

    public void c(JSONObject r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        if (this.f6629a == false) goto L9;
        r10.put(PerfConsts.PERF_KEY_PHYSICAL_MEM, this.f6634f);
        r10.put(PerfConsts.PERF_KEY_MALLOC_IMPL, this.f6639k);
        return;
    }

    public void d(JSONObject r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        if (this.f6629a == false) goto L12;
        r10.put(PerfConsts.PERF_KEY_IS_APP_64_BIT, this.f6630b);
        r10.put(PerfConsts.PERF_KEY_IS_DEVICE_64_BIT, this.f6631c);
        r10.put(PerfConsts.PERF_KEY_CPU_MODEL, this.f6632d);
        int r11 = this.f6633e;
        if (r11 <= 0) goto L11;
        r10.put(PerfConsts.PERF_KEY_CPU_CORE_NUM, r11);
        return;
    L11:
        return;
    }

    public void e(JSONObject r10) {
        f(r10, false);
    }

    public void f(JSONObject r10, boolean r11) {
        if (this.f6629a == true) goto L9;
        if (r11 == true) goto L9;
        return;
    L9:
        k().g(r10);     // Catch: JSONException -> L8
        return;
    }

    public void g(JSONObject r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        if (this.f6629a == false) goto L9;
        s();
        r10.put(PerfConsts.PERF_KEY_HAS_NATIVE_HEAP_SIZE, this.f6635g);
        r10.put(PerfConsts.PERF_KEY_HAS_JAVA_HEAP_LEAK, this.f6636h);
        r10.put(PerfConsts.PERF_KEY_JAVA_HEAP_USED, this.f6638j);
        r10.put(PerfConsts.PERF_KEY_JAVA_HEAP_MAX, this.f6637i);
        return;
    }

    public void h(JSONObject r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        if (this.f6629a == true) goto L7;
        return;
    L7:
        if (this.f6641m == 0) goto L10;
        r10.put(PerfConsts.PERF_KEY_SYSTEM_AVAILABLE_SIZE, this.f6642n / PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED);
        r10.put(PerfConsts.PERF_KEY_SYSTEM_AVAILABLE_RATIO, this.f6643o);
    L10:
        if (this.f6644p == 0) goto L13;
        r10.put(PerfConsts.PERF_KEY_DATA_AVAILABLE_SIZE, l(this.f6645q));
        r10.put(PerfConsts.PERF_KEY_DATA_AVAILABLE_RATIO, this.f6646r);
    L13:
        if (this.f6647s == 0) goto L16;
        r10.put(PerfConsts.PERF_KEY_SDCARD_AVAILABLE_SIZE, l(this.f6648t));
        r10.put(PerfConsts.PERF_KEY_SDCARD_AVAILABLE_RATIO, this.f6649u);
    L16:
        if (this.f6650v == false) goto L20;
        r10.put(PerfConsts.PERF_KEY_EXTERNAL_STORAGE_REMOVABLE, this.f6651w);
        return;
    }

    public final void i() {
        if (u.a() == false) goto L6;
        Throwable r10 = new Throwable("Don't use DeviceInfoUtil on main thread.");
        AsyncEventManager.e().h(new a(this, r10));
        return;
    }

    public final double j(long r10, long r11) {
        if (r11 != 0) goto L7;
        return 0.0d;
    L7:
        return Math.round((r10 / r11) * 100.0d) / 100.0d;
    }

    public final long l(long r10) {
        return r10 / 1073741824;
    }

    public final void m() {
        String r10 = w0.c.g().getApplicationInfo().nativeLibraryDir;
        if (TextUtils.isEmpty(r10) == false) goto L5;
    L7:
        StringBuilder r11 = new StringBuilder();
        if (Build.SUPPORTED_ABIS.length <= 0) goto L16;
        int r12 = 0;
    L10:
        String[] r13 = Build.SUPPORTED_ABIS;
        if (r12 >= r13.length) goto L17;
        r11.append(r13[r12]);
        if (r12 == (r13.length - 1)) goto L15;
        r11.append(", ");
    L15:
        r12 = r12 + 1;
    L17:
        String r14 = r11.toString();
        if (r14 != null) goto L20;
    L22:
        n();
        return;
    L20:
        if (r14.contains("64") == false) goto L22;
        this.f6631c = true;
        goto L22
    L16:
        r11 = new StringBuilder(Build.CPU_ABI);
        goto L17
    L5:
        if (r10.endsWith("arm64") == false) goto L7;
        this.f6630b = true;
        goto L7
    }

    public final void n() {
        com.bytedance.apm.internal.b r10 = com.bytedance.apm.internal.b.a();
        String r11 = r10.d(CommonKey.KEY_SP_CPU_MODEL);
        int r12 = r10.b(CommonKey.KEY_SP_CPU_CORE_NUM);
        if (TextUtils.isEmpty(r11) == true) goto L6;
        this.f6632d = r11;
        this.f6633e = r12;
        return;
    L6:
        r();
        if (TextUtils.isEmpty(this.f6632d) == false) goto L9;
        this.f6632d = "unknown";
    L9:
        r10.g(CommonKey.KEY_SP_CPU_MODEL, this.f6632d);
        r10.e(CommonKey.KEY_SP_CPU_CORE_NUM, this.f6633e);
    }

    public final void o() {
        if (this.f6629a == true) goto L8;
        return;
    L8:
        m();     // Catch: Throwable -> L7
        p();     // Catch: Throwable -> L7
        q();     // Catch: Throwable -> L7
        return;
    }

    public final void p() {
        ActivityManager r10 = (ActivityManager) w0.c.g().getSystemService("activity");
        ActivityManager.MemoryInfo r11 = new ActivityManager.MemoryInfo();
        r10.getMemoryInfo(r11);
        this.f6634f = (int) (r11.totalMem / 536870912);
        this.f6639k = "jemalloc";
    }

    public final void q() {
        this.f6640l = true;
        StatFs r10 = new StatFs(Environment.getRootDirectory().getAbsolutePath());
        if (this.f6640l == false) goto L5;
        this.f6642n = r10.getAvailableBytes();
        this.f6641m = r10.getBlockSizeLong() * r10.getBlockCountLong();
    L6:
        this.f6643o = j(this.f6642n, this.f6641m);
        StatFs r11 = new StatFs(w0.c.g().getFilesDir().getAbsolutePath());     // Catch: Throwable -> L25
        if (this.f6640l == false) goto L10;
        this.f6645q = r11.getAvailableBytes();     // Catch: Throwable -> L25
        this.f6644p = r11.getBlockSizeLong() * r11.getBlockCountLong();     // Catch: Throwable -> L25
    L11:
        this.f6646r = j(this.f6645q, this.f6644p);     // Catch: Throwable -> L25
        goto L30
    L10:
        this.f6645q = ((long) r11.getBlockSize()) * ((long) r11.getAvailableBlocks());     // Catch: Throwable -> L25
        this.f6644p = ((long) r11.getBlockSize()) * ((long) r11.getBlockCount());     // Catch: Throwable -> L25
    L30:
        String r12 = Environment.getExternalStorageState();     // Catch: Exception -> L14
    L15:
        boolean r13 = TextUtils.equals(r12, "mounted");
        this.f6650v = r13;
        if (r13 == false) goto L22;
        StatFs r14 = new StatFs(Environment.getExternalStorageDirectory().getAbsolutePath());     // Catch: Throwable -> L26
        if (this.f6640l == false) goto L20;
        this.f6648t = r14.getAvailableBytes();     // Catch: Throwable -> L26
        this.f6647s = r14.getBlockSizeLong() * r14.getBlockCountLong();     // Catch: Throwable -> L26
    L21:
        this.f6649u = j(this.f6648t, this.f6647s);     // Catch: Throwable -> L26
        goto L23
    L20:
        this.f6648t = ((long) r14.getBlockSize()) * ((long) r14.getAvailableBlocks());     // Catch: Throwable -> L26
        this.f6647s = ((long) r14.getBlockSize()) * ((long) r14.getBlockCount());     // Catch: Throwable -> L26
        goto L21
    L22:
        this.f6647s = 0;     // Catch: Throwable -> L26
    L23:
        this.f6651w = Environment.isExternalStorageRemovable();
        return;
    L14:
        r12 = null;
        goto L15
    L5:
        this.f6642n = ((long) r10.getBlockSize()) * ((long) r10.getAvailableBlocks());
        this.f6641m = ((long) r10.getBlockSize()) * ((long) r10.getBlockCount());
        goto L6
    }

    public final void r() {
        BufferedReader r10 = null;
        String r11 = null;
        BufferedReader r12 = null;
        BufferedReader r13 = new BufferedReader(new FileReader("/proc/cpuinfo"));     // Catch: Throwable -> L21 Exception -> L23
        int r14 = 0;
    L45:
        String r15 = r13.readLine();     // Catch: Throwable -> L13 Exception -> L15
        if (r15 == null) goto L39;
        String[] r16 = r15.split(":");     // Catch: Throwable -> L13 Exception -> L15
        if (r16.length != 2) goto L45;
        if (r16[0].startsWith("Hardware") == true) goto L12;
        if (r16[0].startsWith("processor") == false) goto L45;
        r14 = r14 + 1;
        goto L45
    L12:
        r11 = r16[1].trim();     // Catch: Throwable -> L13 Exception -> L15
        goto L45
    L39:
        r13.close();     // Catch: Exception -> L36
    L30:
        this.f6632d = r11;
        this.f6633e = r14;
        if (TextUtils.isEmpty(r11) == true) goto L33;
        return;
    L33:
        if (r.t() == false) goto L60;
        this.f6632d = Build.HARDWARE;
        return;
    L60:
        return;
    L15:
        String r17 = r11;
        r12 = r13;
    L27:
        if (r12 != null) goto L41;
    L29:
        r11 = r17;
        goto L30
    L41:
        r12.close();     // Catch: Exception -> L38
    L13:
        th = th;
        r10 = r13;
    L24:
        if (r10 != null) goto L43;
    L26:
        throw th;
    L43:
        r10.close();     // Catch: Exception -> L37
        goto L26
    L23:
        r14 = 0;
        r17 = null;
    L21:
        th = th;
        goto L24
    }

    public final void s() {
        this.f6635g = Debug.getNativeHeapAllocatedSize() / PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED;
        Runtime r10 = Runtime.getRuntime();
        long r11 = r10.maxMemory();
        long r12 = r10.freeMemory();
        long r13 = r10.totalMemory();
        this.f6637i = r11 / PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED;
        long r14 = r13 - r12;
        this.f6638j = r14 / PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED;
        if (r14 <= (r11 * 0.95f)) goto L5;
        boolean r15 = true;
    L6:
        this.f6636h = r15;
        return;
    L5:
        r15 = false;
        goto L6
    }

    public d() {
        i();
        this.f6629a = w0.c.C();
        o();
    }
}
