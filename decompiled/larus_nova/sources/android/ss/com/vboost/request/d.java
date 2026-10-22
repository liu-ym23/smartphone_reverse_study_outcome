package android.ss.com.vboost.request;

import android.ss.com.vboost.CapabilityType;
import android.ss.com.vboost.CoreCluster;
import android.ss.com.vboost.CustomRequest;
import android.ss.com.vboost.CustomScene;
import android.ss.com.vboost.FrequencyLevel;
import android.ss.com.vboost.utils.LogUtil;

/* JADX INFO: loaded from: classes2.dex */
public class d implements Comparable {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private static final String f4737u = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public CapabilityType f4738a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public FrequencyLevel f4739b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f4740c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f4741d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f4742e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public CoreCluster f4743f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public CustomScene f4744g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public android.ss.com.vboost.d f4745h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public android.ss.com.vboost.b f4746i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f4747j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f4748k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private g f4749l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    c f4750m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private long f4751n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private i f4752o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public e f4753p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private long f4754q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private h f4755r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public CustomRequest f4756s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public android.ss.com.vboost.i.i f4757t;

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f4758a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        static final /* synthetic */ int[] f4759b = null;

        static {
            int[] r100 = new int[i.values().length];
            f4759b = r100;
            r100[i.f4772d.ordinal()] = 1;     // Catch: NoSuchFieldError -> L30
        L72:
            f4759b[i.f4771c.ordinal()] = 2;     // Catch: NoSuchFieldError -> L31
        L60:
            f4759b[i.f4769a.ordinal()] = 3;     // Catch: NoSuchFieldError -> L32
        L70:
            f4759b[i.f4770b.ordinal()] = 4;     // Catch: NoSuchFieldError -> L33
        L10:
            int[] r101 = new int[CapabilityType.values().length];
            f4758a = r101;
            r101[CapabilityType.IO_PRELOAD.ordinal()] = 1;     // Catch: NoSuchFieldError -> L34
        L54:
            f4758a[CapabilityType.THUMB_FETCH.ordinal()] = 2;     // Catch: NoSuchFieldError -> L35
        L78:
            f4758a[CapabilityType.PRESET_SCENE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L36
        L90:
            f4758a[CapabilityType.CPU_AFFINITY.ordinal()] = 4;     // Catch: NoSuchFieldError -> L37
        L52:
            f4758a[CapabilityType.TASK_PRIORITY.ordinal()] = 5;     // Catch: NoSuchFieldError -> L38
        L76:
            f4758a[CapabilityType.VIBRATE_ENHANCE.ordinal()] = 6;     // Catch: NoSuchFieldError -> L39
        L94:
            f4758a[CapabilityType.IDLE_STATE.ordinal()] = 7;     // Catch: NoSuchFieldError -> L40
        L58:
            f4758a[CapabilityType.CPU_FREQ_MAX.ordinal()] = 8;     // Catch: NoSuchFieldError -> L41
        L82:
            f4758a[CapabilityType.CPU_CORE_MAX.ordinal()] = 9;     // Catch: NoSuchFieldError -> L42
        L88:
            f4758a[CapabilityType.GPU_FREQ_MAX.ordinal()] = 10;     // Catch: NoSuchFieldError -> L43
        L68:
            f4758a[CapabilityType.BUS_FREQ_MAX.ordinal()] = 11;     // Catch: NoSuchFieldError -> L44
        L74:
            f4758a[CapabilityType.UFS_FREQ_MAX.ordinal()] = 12;     // Catch: NoSuchFieldError -> L45
        L62:
            f4758a[CapabilityType.CPU_FREQ_MIN.ordinal()] = 13;     // Catch: NoSuchFieldError -> L46
        L64:
            f4758a[CapabilityType.CPU_CORE_MIN.ordinal()] = 14;     // Catch: NoSuchFieldError -> L47
        L92:
            f4758a[CapabilityType.GPU_FREQ_MIN.ordinal()] = 15;     // Catch: NoSuchFieldError -> L48
        L56:
            f4758a[CapabilityType.BUS_FREQ_MIN.ordinal()] = 16;     // Catch: NoSuchFieldError -> L49
        L80:
            f4758a[CapabilityType.UFS_FREQ_MIN.ordinal()] = 17;     // Catch: NoSuchFieldError -> L50
        L86:
            f4758a[CapabilityType.NETWORK_ENHANCE.ordinal()] = 18;     // Catch: NoSuchFieldError -> L51
            return;
        }
    }

    static {
        f4737u = "d";
        FrequencyLevel r100 = FrequencyLevel.LEVEL_0;
    }

    public d(CapabilityType r100) {
        this.f4738a = r100;
        b(r100);
        a(r100);
        long r101 = System.currentTimeMillis();
        this.f4754q = r101;
        this.f4751n = r101;
    }

    private void a(CapabilityType r100) {
        switch(a.f4758a[r100.ordinal()]) {
            case 1: goto L7;
            case 2: goto L7;
            case 3: goto L6;
            case 4: goto L6;
            case 5: goto L6;
            case 6: goto L6;
            case 7: goto L6;
            case 8: goto L5;
            case 9: goto L5;
            case 10: goto L5;
            case 11: goto L5;
            case 12: goto L5;
            case 13: goto L5;
            case 14: goto L5;
            case 15: goto L5;
            case 16: goto L5;
            case 17: goto L5;
            default: goto L10;
        };
    L5:
        g r101 = g.f4762b;
    L8:
        this.f4749l = r101;
        return;
    L6:
        r101 = g.f4763c;
        goto L8
    L7:
        r101 = g.f4764d;
        goto L8
    }

    private void b(CapabilityType r100) {
        switch(a.f4758a[r100.ordinal()]) {
            case 1: goto L7;
            case 2: goto L7;
            case 3: goto L7;
            case 4: goto L7;
            case 5: goto L7;
            case 6: goto L7;
            case 7: goto L7;
            case 8: goto L6;
            case 9: goto L6;
            case 10: goto L6;
            case 11: goto L6;
            case 12: goto L6;
            case 13: goto L5;
            case 14: goto L5;
            case 15: goto L5;
            case 16: goto L5;
            case 17: goto L5;
            case 18: goto L7;
            default: goto L10;
        };
    L5:
        i r101 = i.f4772d;
    L8:
        this.f4752o = r101;
        return;
    L6:
        r101 = i.f4771c;
        goto L8
    L7:
        r101 = i.f4769a;
        goto L8
    }

    public long a() {
        long r100 = this.f4740c - (this.f4754q - this.f4751n);
        LogUtil.debug(f4737u, "real timeout:" + r100);
        return r100;
    }

    public void a(long r100) {
        this.f4754q = r100;
    }

    public void a(g r100) {
        this.f4749l = r100;
    }

    public void a(h r100) {
        this.f4755r = r100;
    }

    public g b() {
        return this.f4749l;
    }

    public h c() {
        return this.f4755r;
    }

    @Override // java.lang.Comparable
    public int compareTo(Object r100) {
        d r101 = (d) r100;
        int r102 = a.f4759b[r101.d().ordinal()];
        int r103 = 0;
        if (r102 != 1) goto L5;
        FrequencyLevel r104 = this.f4739b;
        if (r104 != null) goto L44;
    L52:
        int r105 = 1;
    L53:
        if (r105 != 0) goto L67;
        long r106 = this.f4740c;
        long r107 = r101.f4740c;
        if (r106 >= r107) goto L57;
        r105 = 1;
    L60:
        if (r105 != 0) goto L67;
        long r108 = this.f4751n;
        long r109 = r101.f4751n;
        if (r108 <= r109) goto L64;
    L63:
        r103 = 1;
    L68:
        LogUtil.debug(f4737u, "compare result " + r103);
        return r103;
    L64:
        if (r108 == r109) goto L68;
    L66:
        r103 = -1;
        goto L68
    L57:
        if (r106 != r107) goto L59;
        r105 = 0;
        goto L60
    L59:
        r105 = -1;
    L67:
        r103 = r105;
        goto L68
    L44:
        if (r101.f4739b == null) goto L52;
        if (r104.ordinal() < r101.f4739b.ordinal()) goto L52;
        if (this.f4739b.ordinal() != r101.f4739b.ordinal()) goto L51;
        r105 = 0;
        goto L53
    L51:
        r105 = -1;
        goto L53
    L5:
        if (r102 == 2) goto L29;
        if (r102 != 3) goto L9;
        long r110 = this.f4751n;
        long r111 = r101.f4751n;
        if (r110 <= r111) goto L23;
        r103 = 1;
    L26:
        if (r103 != 0) goto L68;
    L23:
        if (r110 == r111) goto L26;
        r103 = -1;
        goto L26
    L9:
        if (r102 == 4) goto L15;
        LogUtil.warn(f4737u, "request not implement any update strategy!!!");
        long r112 = this.f4751n;
        long r113 = r101.f4751n;
        if (r112 > r113) goto L63;
        if (r112 != r113) goto L66;
    L15:
        long r114 = this.f4751n;
        long r115 = r101.f4751n;
        if (r114 < r115) goto L63;
        if (r114 != r115) goto L66;
    L29:
        if (this.f4739b.ordinal() <= r101.f4739b.ordinal()) goto L32;
        r105 = 1;
    L35:
        if (r105 != 0) goto L67;
        long r116 = this.f4751n;
        long r117 = r101.f4751n;
        if (r116 > r117) goto L63;
        if (r116 != r117) goto L66;
    L32:
        if (this.f4739b.ordinal() != r101.f4739b.ordinal()) goto L34;
        r105 = 0;
        goto L35
    L34:
        r105 = -1;
        goto L35
    }

    public i d() {
        return this.f4752o;
    }

    public String toString() {
        return "Request{type=" + this.f4738a + ", level=" + this.f4739b + ", timeout=" + this.f4740c + ", tid=" + this.f4741d + ", priority=" + this.f4742e + ", cluster=" + this.f4743f + ", timeoutStrategy=" + this.f4749l + ", createTime=" + this.f4751n + ", updateStrategy=" + this.f4752o + ", info=" + this.f4753p + ", commitTime=" + this.f4754q + ", task=" + this.f4755r + '}';
    }
}
