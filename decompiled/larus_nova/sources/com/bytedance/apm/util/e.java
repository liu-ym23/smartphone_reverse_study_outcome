package com.bytedance.apm.util;

import android.app.ActivityManager;
import android.os.Build;
import android.os.Debug;
import android.os.Environment;
import android.os.StatFs;
import android.text.TextUtils;
import androidx.camera.video.AudioStats;
import com.bytedance.bdlocation.exception.BDLocationException;
import com.bytedance.security.android.aopcheck.PolarisFileReaderWrapper;
import java.io.BufferedReader;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f190645a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f190646b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f190647c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f190648d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f190649e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f190650f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f190651g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f190652h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f190653i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public long f190654j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f190655k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f190656l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public long f190657m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public long f190658n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public double f190659o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public long f190660p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public long f190661q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public double f190662r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public long f190663s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public long f190664t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public double f190665u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f190666v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f190667w;

    /* JADX INFO: loaded from: classes14.dex */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final e f190668a = null;

        static {
            f190668a = new e();
        }
    }

    public final void h() {
        this.f190656l = true;
        StatFs r100 = new StatFs(Environment.getRootDirectory().getAbsolutePath());
        if (this.f190656l == false) goto L5;
        this.f190658n = r100.getAvailableBytes();
        this.f190657m = r100.getBlockSizeLong() * r100.getBlockCountLong();
    L6:
        this.f190659o = e(this.f190658n, this.f190657m);
        StatFs r101 = new StatFs(com.bytedance.apm.d.getContext().getFilesDir().getAbsolutePath());     // Catch: Throwable -> L25
        if (this.f190656l == false) goto L10;
        this.f190661q = r101.getAvailableBytes();     // Catch: Throwable -> L25
        this.f190660p = r101.getBlockSizeLong() * r101.getBlockCountLong();     // Catch: Throwable -> L25
    L11:
        this.f190662r = e(this.f190661q, this.f190660p);     // Catch: Throwable -> L25
        goto L27
    L10:
        this.f190661q = ((long) r101.getBlockSize()) * ((long) r101.getAvailableBlocks());     // Catch: Throwable -> L25
        this.f190660p = ((long) r101.getBlockSize()) * ((long) r101.getBlockCount());     // Catch: Throwable -> L25
    L27:
        String r102 = Environment.getExternalStorageState();     // Catch: Exception -> L14
    L15:
        boolean r103 = TextUtils.equals(r102, "mounted");
        this.f190666v = r103;
        if (r103 == false) goto L22;
        StatFs r104 = new StatFs(Environment.getExternalStorageDirectory().getAbsolutePath());     // Catch: Throwable -> L26
        if (this.f190656l == false) goto L20;
        this.f190664t = r104.getAvailableBytes();     // Catch: Throwable -> L26
        this.f190663s = r104.getBlockSizeLong() * r104.getBlockCountLong();     // Catch: Throwable -> L26
    L21:
        this.f190665u = e(this.f190664t, this.f190663s);     // Catch: Throwable -> L26
        goto L23
    L20:
        this.f190664t = ((long) r104.getBlockSize()) * ((long) r104.getAvailableBlocks());     // Catch: Throwable -> L26
        this.f190663s = ((long) r104.getBlockSize()) * ((long) r104.getBlockCount());     // Catch: Throwable -> L26
        goto L21
    L22:
        this.f190663s = 0;     // Catch: Throwable -> L26
    L23:
        this.f190667w = Environment.isExternalStorageRemovable();
        return;
    L14:
        r102 = null;
        goto L15
    L5:
        this.f190658n = ((long) r100.getBlockSize()) * ((long) r100.getAvailableBlocks());
        this.f190657m = ((long) r100.getBlockSize()) * ((long) r100.getBlockCount());
        goto L6
    }

    public e() {
        if (u.a() == false) goto L5;
        Throwable r100 = new Throwable("Don't use DeviceInfoUtil on main thread.");
        bt3.b.d.f20539a.e(new d(r100));
    L5:
        boolean r101 = com.bytedance.apm.d.f190531s;
        this.f190645a = r101;
        if (r101 == false) goto L13;
        f();     // Catch: Throwable -> L10
        g();     // Catch: Throwable -> L10
        h();     // Catch: Throwable -> L10
        return;
    L14:
        return;
    }

    public final void f() {
        String r100 = com.bytedance.apm.d.getContext().getApplicationInfo().nativeLibraryDir;
        boolean r101 = true;
        if (TextUtils.isEmpty(r100) == false) goto L5;
    L7:
        StringBuilder r102 = new StringBuilder();
        if (Build.SUPPORTED_ABIS.length <= 0) goto L16;
        int r103 = 0;
    L10:
        String[] r104 = Build.SUPPORTED_ABIS;
        if (r103 >= r104.length) goto L17;
        r102.append(r104[r103]);
        if (r103 == (r104.length - 1)) goto L15;
        r102.append(", ");
    L15:
        r103 = r103 + 1;
    L17:
        String r105 = r102.toString();
        if (r105 != null) goto L20;
    L22:
        com.bytedance.apm.internal.h r106 = com.bytedance.apm.internal.h.a.f190606a;
        BufferedReader r107 = null;
        String r108 = null;
        BufferedReader r109 = null;
        String r110 = r106.f190605a.getString("sp_cpu_model", null);
        int r111 = r106.f190605a.getInt("sp_cpu_core_num", -1);
        if (TextUtils.isEmpty(r110) == true) goto L86;
        this.f190648d = r110;
        this.f190649e = r111;
        return;
    L86:
        BufferedReader r112 = new BufferedReader(new PolarisFileReaderWrapper("/proc/cpuinfo"));     // Catch: Throwable -> L44 Exception -> L48
        int r113 = 0;
    L84:
        String r114 = r112.readLine();     // Catch: Throwable -> L41 Exception -> L43
        if (r114 == null) goto L82;
        String[] r115 = r114.split(":");     // Catch: Throwable -> L41 Exception -> L43
        if (r115.length != 2) goto L84;
        if (r115[0].startsWith("Hardware") == true) goto L34;
        if (r115[0].startsWith("processor") == false) goto L84;
        r113 = r113 + 1;
        goto L84
    L34:
        r108 = r115[1].trim();     // Catch: Throwable -> L41 Exception -> L43
        goto L84
    L82:
        r112.close();     // Catch: Exception -> L40
    L54:
        this.f190648d = r108;
        this.f190649e = r113;
        if (TextUtils.isEmpty(r108) == false) goto L71;
        String r116 = Build.BRAND;     // Catch: Throwable -> L66
        if (TextUtils.isEmpty(r116) == false) goto L60;
    L61:
        String r117 = Build.MANUFACTURER;     // Catch: Throwable -> L66
        if (TextUtils.isEmpty(r117) == true) goto L67;
        if (r117.toLowerCase().startsWith("hua") == false) goto L67;
    L68:
        if (r101 == false) goto L71;
        this.f190648d = Build.HARDWARE;
        goto L71
    L60:
        if (r116.toLowerCase().startsWith("hua") == true) goto L68;
    L67:
        r101 = false;
    L71:
        if (TextUtils.isEmpty(this.f190648d) == false) goto L73;
        this.f190648d = "unknown";
    L73:
        r106.f190605a.edit().putString("sp_cpu_model", this.f190648d).apply();
        r106.f190605a.edit().putInt("sp_cpu_core_num", this.f190649e).apply();
        return;
    L43:
        String r118 = r108;
        r109 = r112;
        String r119 = r118;
    L49:
        if (r109 != null) goto L78;
    L53:
        r108 = r119;
        goto L54
    L78:
        r109.close();     // Catch: Exception -> L52
    L41:
        th = th;
        r107 = r112;
    L45:
        if (r107 != null) goto L80;
    L47:
        throw th;
    L80:
        r107.close();     // Catch: Exception -> L75
        goto L47
    L48:
        r119 = null;
        r113 = 0;
    L44:
        th = th;
        goto L45
    L20:
        if (r105.contains(BDLocationException.ERROR_RESTRICTED_MODE_ON) == false) goto L22;
        this.f190647c = true;
        goto L22
    L16:
        r102 = new StringBuilder(Build.CPU_ABI);
        goto L17
    L5:
        if (r100.endsWith("arm64") == false) goto L7;
        this.f190646b = true;
        goto L7
    }

    public final void g() {
        ActivityManager r100 = (ActivityManager) com.bytedance.apm.d.getContext().getSystemService("activity");
        ActivityManager.MemoryInfo r101 = new ActivityManager.MemoryInfo();
        r100.getMemoryInfo(r101);
        int r102 = Build.VERSION.SDK_INT;
        this.f190650f = (int) (r101.totalMem / 536870912);
        if (r102 < 24) goto L5;
        this.f190655k = "jemalloc";
        return;
    L5:
        com.bytedance.apm.internal.h r103 = com.bytedance.apm.internal.h.a.f190606a;
        String r104 = r103.f190605a.getString("sp_malloc_impl", null);
        if (r104 != null) goto L8;
        r104 = "unknown";
        r103.f190605a.edit().putString("sp_malloc_impl", "unknown").apply();
    L8:
        this.f190655k = r104;
    }

    public final void c(JSONObject r110) throws JSONException {
        if (this.f190645a == false) goto L11;
        this.f190651g = Debug.getNativeHeapAllocatedSize() / 1048576;
        Runtime r100 = Runtime.getRuntime();
        long r101 = r100.maxMemory();
        long r102 = r100.freeMemory();
        long r103 = r100.totalMemory();
        this.f190653i = r101 / 1048576;
        long r104 = r103 - r102;
        this.f190654j = r104 / 1048576;
        if (r104 <= (r101 * 0.95f)) goto L8;
        boolean r105 = true;
    L9:
        this.f190652h = r105;
        r110.put("apm_native_heap_size", this.f190651g);
        r110.put("apm_java_heap_leak", this.f190652h);
        r110.put("apm_java_heap_used", this.f190654j);
        r110.put("apm_java_heap_max", this.f190653i);
        return;
    L8:
        r105 = false;
        goto L9
    }

    public final void d(JSONObject r100) throws JSONException {
        if (this.f190645a == true) goto L6;
        return;
    L6:
        if (this.f190657m == 0) goto L9;
        r100.put("apm_sys_avail_size", this.f190658n / 1048576);
        r100.put("apm_sys_avail_ratio", this.f190659o);
    L9:
        if (this.f190660p == 0) goto L12;
        r100.put("apm_data_avail_size", this.f190661q / 1073741824);
        r100.put("apm_data_avail_ratio", this.f190662r);
    L12:
        if (this.f190663s == 0) goto L15;
        r100.put("apm_sd_avail_size", this.f190664t / 1073741824);
        r100.put("apm_sd_avail_ratio", this.f190665u);
    L15:
        if (this.f190666v == false) goto L18;
        r100.put("apm_external_removable", this.f190667w);
        return;
    }

    public static double e(long r100, long r101) {
        if (r101 != 0) goto L7;
        return AudioStats.AUDIO_AMPLITUDE_NONE;
    L7:
        return Math.round((r100 / r101) * 100.0d) / 100.0d;
    }

    public final void a(JSONObject r100, boolean r101) {
        if (this.f190645a == true) goto L19;
        if (r101 == true) goto L19;
        return;
    L19:
        e r102 = a.f190668a;     // Catch: JSONException -> L18
        if (r102.f190645a == false) goto L13;
        r100.put("apm_is_app_64", r102.f190646b);     // Catch: JSONException -> L18
        r100.put("apm_is_device_64", r102.f190647c);     // Catch: JSONException -> L18
        r100.put("apm_cpu_model", r102.f190648d);     // Catch: JSONException -> L18
        int r103 = r102.f190649e;     // Catch: JSONException -> L18
        if (r103 <= 0) goto L13;
        r100.put("apm_cpu_core_num", r103);     // Catch: JSONException -> L18
    L13:
        if (r102.f190645a == false) goto L16;
        r100.put("apm_physical_mem", r102.f190650f);     // Catch: JSONException -> L18
        r100.put("apm_malloc_impl", r102.f190655k);     // Catch: JSONException -> L18
    L16:
        r102.d(r100);     // Catch: JSONException -> L18
        return;
    }

    public final void b(JSONObject r100, boolean r101) {
        if (this.f190645a == true) goto L9;
        if (r101 == true) goto L9;
        return;
    L9:
        a.f190668a.c(r100);     // Catch: JSONException -> L8
        return;
    }
}
