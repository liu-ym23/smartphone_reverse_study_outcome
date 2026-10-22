package com.bytedance.android.livesdk.performance;

import android.app.ActivityManager;
import android.content.Context;
import android.os.BatteryManager;
import android.os.Build;
import android.os.Debug;
import android.text.TextUtils;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.performance.api.IPerfToolsService;
import com.bytedance.android.livehostapi.platform.base.IBaseHostPerformanceMonitor;
import com.bytedance.android.livesdk.TTLiveSDKContext;
import com.bytedance.android.livesdkapi.app.AppConstants;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.android.livesdkapi.performance.IPerformanceCacheData;
import com.bytedance.ies.sdk.widgets.priority.PriorityModule;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.ss.android.socialbase.appdownloader.util.RomUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes11.dex */
public final class o0 implements IPerformanceCacheData {

    /* JADX INFO: renamed from: l1, reason: collision with root package name */
    public static final /* synthetic */ int f154691l1 = 0;
    public long A;
    public float A0;
    public long B;
    public float B0;
    public long C;
    public float C0;
    public long D;
    public float D0;
    public long E;
    public boolean E0;
    public long F;
    public String F0;
    public long G;
    public long G0;
    public long H;
    public List<Long> H0;
    public long I;
    public float I0;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public long f154692J;
    public long J0;
    public long K;
    public float K0;
    public boolean L;
    public long L0;
    public int M;
    public float M0;
    public float N;
    public double N0;
    public float O;
    public double O0;
    public boolean P;
    public double P0;
    public double Q;
    public double Q0;
    public double R;
    public String R0;
    public String S;
    public int S0;
    public String T;
    public ActivityManager T0;
    public String U;
    public final ActivityManager.MemoryInfo U0;
    public int V;
    public long V0;
    public int W;
    public long W0;
    public double X;
    public long X0;
    public double Y;
    public long Y0;
    public final HashMap<String, String> Z;
    public int Z0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f154693a;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public Map<String, String> f154694a0;

    /* JADX INFO: renamed from: a1, reason: collision with root package name */
    public float f154695a1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f154696b;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public int f154697b0;

    /* JADX INFO: renamed from: b1, reason: collision with root package name */
    public float f154698b1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f154699c;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public int f154700c0;

    /* JADX INFO: renamed from: c1, reason: collision with root package name */
    public float f154701c1;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f154702d;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    public int f154703d0;

    /* JADX INFO: renamed from: d1, reason: collision with root package name */
    public float f154704d1;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f154705e;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    public int f154706e0;

    /* JADX INFO: renamed from: e1, reason: collision with root package name */
    public float f154707e1;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f154708f;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    public boolean f154709f0;

    /* JADX INFO: renamed from: f1, reason: collision with root package name */
    public float f154710f1;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f154711g;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    public int f154712g0;

    /* JADX INFO: renamed from: g1, reason: collision with root package name */
    public float f154713g1;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f154714h;

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    public int f154715h0;

    /* JADX INFO: renamed from: h1, reason: collision with root package name */
    public float f154716h1;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f154717i;

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    public double f154718i0;

    /* JADX INFO: renamed from: i1, reason: collision with root package name */
    public float f154719i1;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f154720j;

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    public double f154721j0;

    /* JADX INFO: renamed from: j1, reason: collision with root package name */
    public final float f154722j1;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public volatile AtomicLong f154723k;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public double f154724k0;

    /* JADX INFO: renamed from: k1, reason: collision with root package name */
    public boolean f154725k1;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public double f154726l;

    /* JADX INFO: renamed from: l0, reason: collision with root package name */
    public float f154727l0;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public double f154728m;

    /* JADX INFO: renamed from: m0, reason: collision with root package name */
    public int f154729m0;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public double f154730n;

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    public float f154731n0;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public double f154732o;

    /* JADX INFO: renamed from: o0, reason: collision with root package name */
    public float f154733o0;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final HashMap<String, Double> f154734p;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    public float f154735p0;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public double f154736q;

    /* JADX INFO: renamed from: q0, reason: collision with root package name */
    public final List<Float> f154737q0;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public long f154738r;

    /* JADX INFO: renamed from: r0, reason: collision with root package name */
    public float f154739r0;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public long f154740s;

    /* JADX INFO: renamed from: s0, reason: collision with root package name */
    public float f154741s0;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public long f154742t;

    /* JADX INFO: renamed from: t0, reason: collision with root package name */
    public float f154743t0;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public long f154744u;

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    public float f154745u0;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public long f154746v;

    /* JADX INFO: renamed from: v0, reason: collision with root package name */
    public float f154747v0;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public long f154748w;

    /* JADX INFO: renamed from: w0, reason: collision with root package name */
    public float f154749w0;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public long f154750x;

    /* JADX INFO: renamed from: x0, reason: collision with root package name */
    public float f154751x0;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public long f154752y;

    /* JADX INFO: renamed from: y0, reason: collision with root package name */
    public float f154753y0;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public long f154754z;

    /* JADX INFO: renamed from: z0, reason: collision with root package name */
    public float f154755z0;

    public static final class a {
        public static String a(LiveMode r100) {
            if (r100 != null) goto L5;
        L13:
            return "video";
        L5:
            switch(n0.f154690a[r100.ordinal()]) {
                case 1: goto L12;
                case 2: goto L11;
                case 3: goto L10;
                case 4: goto L9;
                case 5: goto L8;
                case 6: goto L7;
                default: goto L13;
            };
        L7:
            return LiveMode.SCENE_ACQUAINTANCE;
        L8:
            return PriorityModule.SCENE_THIRD_PARTY;
        L9:
            return "audio";
        L10:
            return "game";
        L11:
            return "official";
        L12:
            return "media";
        }
    }

    static {
    }

    public final void b() {
        t r100 = t.a.f154815a;
        this.f154697b0 = r100.f154807e;
        this.f154700c0 = r100.f154813k;
        this.f154703d0 = r100.f154808f;
        this.f154706e0 = r100.f154810h;
        this.f154709f0 = r100.f154811i;
        this.f154712g0 = r100.f154809g;
        this.f154715h0 = r100.f154812j;
        Context r101 = s1.getContext();
        float r102 = -1.0f;
        if (b.a(r101) == false) goto L65;
        if (r101 == null) goto L65;
        BatteryManager r103 = b.b(r101);     // Catch: Exception -> L80
        if (r103 == null) goto L65;
        float r104 = r103.getLongProperty(2);     // Catch: Exception -> L80
        if (r104 < (-1.0E7f)) goto L65;
        if (r104 > 1.0E7f) goto L65;
        boolean r105 = true;
        if (w0.d() != null) goto L19;
    L21:
        boolean r106 = w0.b("EMUI");     // Catch: Exception -> L80
    L23:
        if (r106 == true) goto L62;
        boolean r107 = false;
        if (w0.d() != null) goto L27;
    L29:
        boolean r108 = false;
    L30:
        if (r108 == true) goto L62;
        int r109 = w0.f154828b;     // Catch: Exception -> L80
        if (r109 == (-1)) goto L36;
        if (r109 == 1) goto L46;
    L47:
        if (r107 == false) goto L52;
        if (r104 >= (-10000.0f)) goto L64;
        r104 = r104 / 1000.0f;     // Catch: Exception -> L80
    L64:
        r104 = -r104;
    L66:
        this.f154718i0 = r104;
        Context r110 = s1.getContext();
        if (b.a(r110) == true) goto L84;
    L71:
        this.f154721j0 = r102;
        Context r111 = s1.getContext();
        double r112 = -1.0d;
        if (b.a(r111) == true) goto L81;
    L76:
        this.f154724k0 = r112;
        return;
    L81:
        r112 = (b.b(r111).getLongProperty(5) / 1.0E9d) / 1000.0d;
        goto L76
    L84:
        r102 = b.b(r110).getLongProperty(3) / 1000.0f;
        goto L71
    L52:
        if (w0.d() != null) goto L54;
    L56:
        r105 = w0.b("OPPO");     // Catch: Exception -> L80
    L57:
        if (r105 == true) goto L59;
    L60:
        r104 = r104 / 1000.0f;
        goto L66
    L59:
        if (r104 <= 10000.0f) goto L66;
    L54:
        if (w0.d().toLowerCase().equals(AppConstants.CHANNEL_OPPO) == false) goto L56;
    L46:
        r107 = true;
        goto L47
    L36:
        String r113 = Build.HARDWARE;     // Catch: Exception -> L80
        if (TextUtils.isEmpty(r113) == true) goto L39;
    L43:
        int r114 = 0;
    L44:
        w0.f154828b = r114;     // Catch: Exception -> L80
        if (r114 != 1) goto L47;
    L39:
        if (r113.toLowerCase().contains("hi") == false) goto L41;
    L42:
        r114 = 1;
        goto L44
    L41:
        if (r113.toLowerCase().contains("kirin") == false) goto L43;
    L27:
        if (w0.d().toLowerCase().equals(RomUtils.BRAND_HONOR) == false) goto L29;
        r108 = true;
    L62:
        if (r104 >= (-10000.0f)) goto L64;
        r104 = -r104;
        goto L60
    L19:
        if (w0.d().toLowerCase().equals(RomUtils.BRAND_HUAWEI) == false) goto L21;
        r106 = true;
    L65:
        r104 = -1.0f;
        goto L66
    }

    @Override // com.bytedance.android.livesdkapi.performance.IPerformanceCacheData
    public final boolean isDataValid() {
        float r100 = this.f154735p0;
        long r101 = this.L0;
        long r102 = this.J0 + r101;
        float r103 = this.M0;
        float r104 = this.I0 + r103;
        float r105 = this.f154743t0;
        float r106 = this.f154741s0;
        float r110 = 0;
        if (Float.compare(r100, r110) > 0) goto L5;
        return false;
    L5:
        if (r102 >= 0) goto L7;
        return false;
    L7:
        if (Float.compare(r104, r110) >= 0) goto L9;
        return false;
    L9:
        if (r101 >= 0) goto L11;
        return false;
    L11:
        if (Float.compare(r103, r110) < 0) goto L22;
        float r107 = 1;
        if (Float.compare(r105, r107) < 0) goto L15;
        return false;
    L15:
        if (Float.compare(r106, r107) >= 0) goto L24;
        return true;
    L24:
        return false;
    L22:
        return false;
    }

    @Override // com.bytedance.android.livesdkapi.performance.IPerformanceCacheData
    public final void resetStreamType() {
        this.f154705e = "";
    }

    public o0() {
        this.f154705e = "";
        this.f154711g = -1;
        this.f154714h = -1;
        this.f154717i = -1;
        this.f154723k = new AtomicLong(0);
        this.f154726l = -1.0d;
        this.f154728m = -1.0d;
        this.f154730n = -1.0d;
        this.f154732o = -1.0d;
        this.f154734p = new HashMap();
        this.f154736q = -1.0d;
        this.f154738r = -1;
        this.f154740s = -1;
        this.f154742t = -1;
        this.f154744u = -1;
        this.f154746v = -1;
        this.f154748w = -1;
        this.f154750x = -1;
        this.f154752y = -1;
        this.f154754z = -1;
        this.A = -1;
        this.B = -1;
        this.C = -1;
        this.D = -1;
        this.E = -1;
        this.F = -1;
        this.G = -1;
        this.H = -1;
        this.I = -1;
        this.f154692J = -1;
        this.K = -1;
        this.N = -1.0f;
        this.O = -1.0f;
        this.Q = -1.0d;
        this.R = -1.0d;
        this.S = "";
        this.T = "";
        this.U = "";
        this.V = -1;
        this.W = -1;
        this.X = -1.0d;
        this.Y = -1.0d;
        this.Z = new HashMap();
        this.f154697b0 = -1;
        this.f154700c0 = -1;
        this.f154703d0 = -1;
        this.f154706e0 = -1;
        this.f154712g0 = -1;
        this.f154715h0 = -1;
        this.f154718i0 = -1.0d;
        this.f154721j0 = -1.0d;
        this.f154724k0 = -1.0d;
        this.f154727l0 = -1.0f;
        this.f154729m0 = -1;
        this.f154731n0 = -1.0f;
        this.f154733o0 = -1.0f;
        this.f154735p0 = -1.0f;
        this.f154737q0 = new ArrayList();
        this.f154739r0 = 60.0f;
        this.f154741s0 = -1.0f;
        this.f154743t0 = -1.0f;
        this.f154745u0 = -1.0f;
        this.f154747v0 = -1.0f;
        this.f154749w0 = -1.0f;
        this.f154751x0 = -1.0f;
        this.f154753y0 = -1.0f;
        this.f154755z0 = -1.0f;
        this.A0 = -1.0f;
        this.B0 = -1.0f;
        this.C0 = -1.0f;
        this.D0 = -1.0f;
        this.F0 = "";
        this.G0 = -1;
        this.I0 = -1.0f;
        this.J0 = -1;
        this.K0 = -1.0f;
        this.L0 = -1;
        this.M0 = -1.0f;
        this.N0 = -1.0d;
        this.O0 = -1.0d;
        this.P0 = -1.0d;
        this.Q0 = -1.0d;
        this.R0 = "";
        this.U0 = new ActivityManager.MemoryInfo();
        this.V0 = -1;
        this.W0 = -1;
        this.X0 = -1;
        this.Y0 = -1;
        this.Z0 = -1;
        this.f154695a1 = -1.0f;
        this.f154698b1 = -1.0f;
        this.f154701c1 = -1.0f;
        this.f154704d1 = -1.0f;
        this.f154707e1 = -1.0f;
        this.f154710f1 = -1.0f;
        this.f154713g1 = -1.0f;
        this.f154716h1 = -1.0f;
        this.f154719i1 = -1.0f;
        this.f154722j1 = -1.0f;
    }

    @Override // com.bytedance.android.livesdkapi.performance.IPerformanceCacheData
    public final float getFps() {
        return this.f154735p0;
    }

    @Override // com.bytedance.android.livesdkapi.performance.IPerformanceCacheData
    public final long getRoomId() {
        return this.f154711g;
    }

    @Override // com.bytedance.android.livesdkapi.performance.IPerformanceCacheData
    public final float getUIStallRate() {
        return this.f154743t0;
    }

    @Override // com.bytedance.android.livesdkapi.performance.IPerformanceCacheData
    public final float getVideoStallRate() {
        return this.f154747v0;
    }

    public final void a(Map<String, Long> r110) {
        long r100 = -1;
        if (r110 == null) goto L7;
        Long r101 = r110.get("mem_pss_total");
        if (r101 == null) goto L7;
        long r102 = r101.longValue();
    L8:
        this.f154738r = r102;
        if (r110 == null) goto L13;
        Long r103 = r110.get("mem_pss_dalvik");
        if (r103 == null) goto L13;
        long r104 = r103.longValue();
    L14:
        this.f154740s = r104;
        if (r110 == null) goto L19;
        Long r105 = r110.get("mem_pss_native");
        if (r105 == null) goto L19;
        long r106 = r105.longValue();
    L20:
        this.f154742t = r106;
        if (r110 == null) goto L25;
        Long r107 = r110.get("mem_vmsize");
        if (r107 == null) goto L25;
        long r108 = r107.longValue();
    L26:
        this.f154744u = r108;
        if (r110 == null) goto L31;
        Long r109 = r110.get("mem_java_total");
        if (r109 == null) goto L31;
        long r111 = r109.longValue();
    L32:
        this.f154746v = r111;
        if (r110 == null) goto L37;
        Long r112 = r110.get("mem_java_free");
        if (r112 == null) goto L37;
        long r113 = r112.longValue();
    L38:
        this.f154748w = r113;
        if (r110 == null) goto L43;
        Long r114 = r110.get("mem_java_used");
        if (r114 == null) goto L43;
        long r115 = r114.longValue();
    L44:
        this.f154750x = r115;
        if (r110 == null) goto L49;
        Long r116 = r110.get("mem_graphics");
        if (r116 == null) goto L49;
        long r117 = r116.longValue();
    L50:
        this.D = r117;
        if (r110 == null) goto L55;
        Long r118 = r110.get("mem_java_max");
        if (r118 == null) goto L55;
        r100 = r118.longValue();
    L55:
        this.f154752y = r100;
        this.f154754z = (r100 - this.f154746v) + this.f154748w;
        this.A = Debug.getNativeHeapFreeSize();
        lo2.a.e().getClass();
        if (lo2.a.d() == false) goto L62;
        if (r110 == null) goto L63;
        IPerfToolsService r119 = lo2.a.f510088k;
        r119.addPerformanceData("data_pss_total", (lo2.a.f(r110, "mem_pss_total", -1L) / 1024.0d) / 1024.0d);
        r119.addPerformanceData("data_java_heap_summary", (lo2.a.f(r110, "mem_java_total", -1L) / 1024.0d) / 1024.0d);
        r119.addPerformanceData("data_native_heap_summary", (lo2.a.f(r110, "mem_pss_native", -1L) / 1024.0d) / 1024.0d);
        r119.addPerformanceData("data_graphics", (lo2.a.f(r110, "mem_graphics", -1L) / 1024.0d) / 1024.0d);
        return;
    L63:
        return;
    L62:
        return;
    L49:
        r117 = -1;
    L43:
        r115 = -1;
    L37:
        r113 = -1;
    L31:
        r111 = -1;
    L25:
        r108 = -1;
    L19:
        r106 = -1;
    L13:
        r104 = -1;
    L7:
        r102 = -1;
        goto L8
    }

    public final void c(Map<String, Double> r110) {
        double r100 = -1.0d;
        if (r110 == null) goto L7;
        Double r101 = r110.get("cpu_rate");
        if (r101 == null) goto L7;
        double r102 = r101.doubleValue();
    L8:
        this.f154726l = r102;
        if (r110 == null) goto L13;
        Double r103 = r110.get("cpu_speed");
        if (r103 == null) goto L13;
        double r104 = r103.doubleValue();
    L14:
        this.f154728m = r104;
        lo2.a.e().getClass();
        if (lo2.a.d() == false) goto L35;
        if (r110 == null) goto L36;
        Double r105 = null;
        if (r110.containsKey("cpu_speed") == false) goto L22;
        Double r106 = r110.get("cpu_speed");
    L24:
        if (r110.containsKey("cpu_rate") == false) goto L26;
        r105 = r110.get("cpu_rate");
    L26:
        IPerfToolsService r111 = lo2.a.f510088k;
        if (r106 == null) goto L29;
        double r107 = r106.doubleValue();
        double r108 = Math.pow(10.0d, 2);
        double r109 = Math.ceil(r107 * r108) / r108;
    L30:
        r111.addPerformanceData("data_cpu_speed", r109);
        if (r105 == null) goto L33;
        double r112 = r105.doubleValue() * 100.0d;
        double r113 = Math.pow(10.0d, 2);
        r100 = Math.ceil(r112 * r113) / r113;
    L33:
        r111.addPerformanceData("data_cpu_rate", r100);
        return;
    L29:
        r109 = -1.0d;
        goto L30
    L22:
        r106 = null;
        goto L24
    L36:
        return;
    L35:
        return;
    L13:
        r104 = -1.0d;
    L7:
        r102 = -1.0d;
        goto L8
    }

    public final void d(Map<String, Long> r110) {
        long r100 = -1;
        if (r110 == null) goto L7;
        Long r101 = r110.get(IBaseHostPerformanceMonitor.MEM_SUMMARY_JAVA_HEAP);
        if (r101 == null) goto L7;
        long r102 = r101.longValue();
    L8:
        this.B = r102;
        if (r110 == null) goto L13;
        Long r103 = r110.get(IBaseHostPerformanceMonitor.MEM_SUMMARY_NATIVE_HEAP);
        if (r103 == null) goto L13;
        long r104 = r103.longValue();
    L14:
        this.C = r104;
        if (r110 == null) goto L19;
        Long r105 = r110.get(IBaseHostPerformanceMonitor.MEM_SUMMARY_CODE);
        if (r105 == null) goto L19;
        long r106 = r105.longValue();
    L20:
        this.E = r106;
        if (r110 == null) goto L25;
        Long r107 = r110.get(IBaseHostPerformanceMonitor.MEM_SUMMARY_STACK);
        if (r107 == null) goto L25;
        long r108 = r107.longValue();
    L26:
        this.F = r108;
        if (r110 == null) goto L31;
        Long r109 = r110.get(IBaseHostPerformanceMonitor.MEM_SUMMARY_SYSTEM);
        if (r109 == null) goto L31;
        long r111 = r109.longValue();
    L32:
        this.G = r111;
        if (r110 == null) goto L37;
        Long r112 = r110.get(IBaseHostPerformanceMonitor.MEM_SUMMARY_PRIVATE_OTHER);
        if (r112 == null) goto L37;
        r100 = r112.longValue();
    L37:
        this.H = r100;
        lo2.a.e().getClass();
        if (lo2.a.d() == false) goto L44;
        if (r110 == null) goto L45;
        IPerfToolsService r113 = lo2.a.f510088k;
        r113.addPerformanceData("data_code_summary", (lo2.a.f(r110, IBaseHostPerformanceMonitor.MEM_SUMMARY_CODE, -1L) / 1024.0d) / 1024.0d);
        r113.addPerformanceData("data_stack_summary", (lo2.a.f(r110, IBaseHostPerformanceMonitor.MEM_SUMMARY_STACK, -1L) / 1024.0d) / 1024.0d);
        r113.addPerformanceData("data_private_other_summary", (lo2.a.f(r110, IBaseHostPerformanceMonitor.MEM_SUMMARY_PRIVATE_OTHER, -1L) / 1024.0d) / 1024.0d);
        r113.addPerformanceData("data_private_system_summary", (lo2.a.f(r110, IBaseHostPerformanceMonitor.MEM_SUMMARY_SYSTEM, -1L) / 1024.0d) / 1024.0d);
        return;
    L45:
        return;
    L44:
        return;
    L31:
        r111 = -1;
    L25:
        r108 = -1;
    L19:
        r106 = -1;
    L13:
        r104 = -1;
    L7:
        r102 = -1;
        goto L8
    }

    public final void e(int r100) {
        this.M = r100;
        if (this.T0 != null) goto L8;
        Object r101 = s1.getContext().getSystemService("activity");
        if ((r101 instanceof ActivityManager) == true) goto L7;
        r101 = null;
    L7:
        this.T0 = (ActivityManager) r101;
    L8:
        ActivityManager r102 = this.T0;
        if (r102 == null) goto L12;
        r102.getMemoryInfo(this.U0);
        ActivityManager.MemoryInfo r103 = this.U0;
        this.I = r103.totalMem;
        this.f154692J = r103.availMem;
        this.K = r103.threshold;
        this.L = r103.lowMemory;
        return;
    }

    public final void f(double r100) {
        this.f154736q = r100;
        lo2.a.e().getClass();
        if (lo2.a.d() == false) goto L7;
        IPerfToolsService r101 = lo2.a.f510088k;
        double r102 = Math.pow(10.0d, 2);
        r101.addPerformanceData("data_gpu_used", Math.ceil(r100 * r102) / r102);
        return;
    }

    public final void g(Map<String, Long> r100) {
        if (r100 == null) goto L6;
        Long r101 = r100.get("video_render_stall_count");
        if (r101 == null) goto L6;
        long r102 = r101.longValue();
    L7:
        this.L0 = r102;
        if (r100 == null) goto L12;
        Long r103 = r100.get("video_render_stall_duration");
        if (r103 == null) goto L12;
        float r104 = r103.longValue();
    L13:
        this.M0 = r104;
        if (r100 == null) goto L18;
        Long r105 = r100.get("net_stall_count");
        if (r105 == null) goto L18;
        r105.longValue();
    L18:
        if (r100 == null) goto L22;
        Long r106 = r100.get("net_stall_duration");
        if (r106 == null) goto L22;
        r106.longValue();
    L22:
        if (r100 == null) goto L26;
        Long r107 = r100.get("audio_stall_count");
        if (r107 == null) goto L26;
        r107.longValue();
    L26:
        if (r100 == null) goto L31;
        Long r108 = r100.get("audio_stall_duration");
        if (r108 == null) goto L32;
        r108.longValue();
        return;
    L32:
        return;
    L31:
        return;
    L12:
        r104 = -1.0f;
    L6:
        r102 = -1;
        goto L7
    }

    public final void h(long r100) {
        float r101 = this.M0;
        float r102 = this.I0;
        float r103 = r100;
        float r104 = (r101 + r102) / r103;
        this.f154741s0 = r104;
        this.f154743t0 = r102 / r103;
        this.f154745u0 = this.K0 / r103;
        this.f154747v0 = r101 / r103;
        this.f154749w0 = this.f154751x0 / r103;
        this.f154753y0 = this.f154755z0 / r103;
        this.A0 = this.B0 / r103;
        this.C0 = this.D0 / r103;
        boolean r105 = false;
        if (r104 <= 0) goto L5;
        r105 = true;
    L5:
        this.E0 = r105;
        this.G0 = r100;
    }

    @Override // com.bytedance.android.livesdkapi.performance.IPerformanceCacheData
    public final void setupReportParams(Map<String, String> r100) {
        Intrinsics.checkNotNullParameter(r100, "reportParams");
        long r101 = this.L0 + this.J0;
        float r102 = this.M0 + this.I0;
        if (this.f154723k.get() > 1) goto L5;
        String r103 = "1";
    L6:
        r100.put("is_first_start", r103);
        r100.put("avg_fps", String.valueOf(this.f154735p0));
        r100.put("video_stall_count", String.valueOf(this.L0));
        r100.put("video_stall_duration", String.valueOf(this.M0));
        r100.put("ui_stall_count", String.valueOf(this.J0));
        r100.put("ui_stall_duration", String.valueOf(this.I0));
        r100.put("video_ui_total_stall_rate", String.valueOf(this.f154741s0));
        r100.put("ui_total_stall_rate", String.valueOf(this.f154743t0));
        r100.put("video_total_stall_rate", String.valueOf(this.f154747v0));
        r100.put("ui_slight_stall_rate", String.valueOf(this.f154753y0));
        r100.put("ui_moderate_stall_rate", String.valueOf(this.A0));
        r100.put("ui_serious_stall_rate", String.valueOf(this.C0));
        r100.put("ui_stall_duration_sum", String.valueOf(r102));
        r100.put("ui_stall_count_sum", String.valueOf(r101));
        r100.put("room_id", String.valueOf(this.f154711g));
        return;
    L5:
        r103 = "0";
        goto L6
    }

    public final void i(double r110, JSONObject r111) {
        JSONObject r100 = r111;
        float r101 = (float) r110;
        this.f154735p0 = r101;
        monitor-enter(this);
    L55:
        th = move-exception;
        throw th;
    L5:
        if (((ArrayList) this.f154737q0).size() < 4) goto L12;
        int r102 = ((ArrayList) this.f154737q0).size() - 4;     // Catch: Throwable -> L55
        if (r102 < 0) goto L12;
        int r103 = 0;
    L9:
        ListProtector.remove(this.f154737q0, 0);     // Catch: Throwable -> L55
        if (r103 == r102) goto L12;
        r103 = r103 + 1;     // Catch: Throwable -> L55
    L12:
        ((ArrayList) this.f154737q0).add(Float.valueOf(r101));     // Catch: Throwable -> L55
        float r104 = 0.0f;
        if (((ArrayList) this.f154737q0).size() != 4) goto L19;
        Iterator r105 = ((ArrayList) this.f154737q0).iterator();     // Catch: Throwable -> L55
        float r106 = 0.0f;
    L16:
        if (r105.hasNext() == false) goto L18;
        r106 = r106 + ((Number) r105.next()).floatValue();     // Catch: Throwable -> L55
        goto L16
    L18:
        this.f154739r0 = r106 / 4;     // Catch: Throwable -> L55
    L19:
        monitor-exit(this);
        if (r100 == null) goto L23;
        String r107 = r111.toString();
        if (r107 == null) goto L23;
    L24:
        this.F0 = r107;
        if (r100 == null) goto L52;
        float r108 = com.bytedance.android.live.core.utils.h0.a();
        Iterator<String> r109 = r111.keys();
        long r112 = 0;
        long r113 = 0;
        long r114 = 0;
        float r115 = 0.0f;
        float r116 = 0.0f;
        float r117 = 0.0f;
    L28:
        if (r109.hasNext() == false) goto L51;
        String r118 = r109.next();
        int r119 = CastIntegerProtector.parseInt(r118);
        int r120 = r100.optInt(r118);
        if (1 > r119) goto L36;
        if (2 < r119) goto L36;
        r115 = r115 + ((r119 * r120) * r108);
    L50:
        r100 = r111;
    L36:
        if (3 > r119) goto L42;
        if (6 < r119) goto L42;
        r112 = r112 + ((long) r120);
        r116 = r116 + ((r119 * r120) * r108);
    L42:
        if (7 > r119) goto L48;
        if (13 < r119) goto L48;
        r113 = r113 + ((long) r120);
        r117 = r117 + ((r119 * r120) * r108);
    L48:
        if (r119 < 14) goto L50;
        r114 = r114 + ((long) r120);
        r104 = r104 + ((r119 * r120) * r108);
        goto L50
    L51:
        float r121 = r104;
        r104 = r115;
    L53:
        this.f154751x0 = r104;
        this.f154755z0 = r116;
        this.B0 = r117;
        this.D0 = r121;
        this.J0 = (r112 + r113) + r114;
        this.I0 = (r116 + r117) + r121;
        this.K0 = ((r104 + r116) + r117) + r121;
        return;
    L52:
        r121 = 0.0f;
        r117 = 0.0f;
        r112 = 0;
        r113 = 0;
        r114 = 0;
        r116 = 0.0f;
    L23:
        r107 = "";
        goto L24
    }

    @Override // com.bytedance.android.livesdkapi.performance.IPerformanceCacheData
    public final void setupPrefDataForStart(long r100, boolean r101) {
        this.f154693a = r101;
        if (r101 == false) goto L7;
        com.bytedance.android.livesdk.service.h r102 = TTLiveSDKContext.getHostService();
        if (r102 == null) goto L7;
        ((com.bytedance.android.livesdk.service.f) r102).h();
    L7:
        this.f154723k.getAndIncrement();
        this.f154711g = r100;
    }

    @Override // com.bytedance.android.livesdkapi.performance.IPerformanceCacheData
    public final void setupPrefDataForStop(double r100, JSONObject r101, Map<String, Long> r102, long r103) {
        i(r100, r101);
        g(r102);
        if (r103 <= 0) goto L6;
        h(r103);
        return;
    }
}
