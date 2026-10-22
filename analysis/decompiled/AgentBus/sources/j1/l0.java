package j1;

import android.os.Handler;
import android.os.Looper;
import android.view.Choreographer;

/* loaded from: classes.dex */
public final class l0 extends q7.m implements p7.a {
    public static final l0 A;
    public static final l0 B;
    public static final l0 C;
    public static final l0 D;
    public static final l0 E;
    public static final l0 F;
    public static final l0 G;
    public static final l0 H;
    public static final l0 I;
    public static final l0 J;

    /* renamed from: h, reason: collision with root package name */
    public static final l0 f5220h;

    /* renamed from: i, reason: collision with root package name */
    public static final l0 f5221i;

    /* renamed from: j, reason: collision with root package name */
    public static final l0 f5222j;

    /* renamed from: k, reason: collision with root package name */
    public static final l0 f5223k;

    /* renamed from: l, reason: collision with root package name */
    public static final l0 f5224l;

    /* renamed from: m, reason: collision with root package name */
    public static final l0 f5225m;

    /* renamed from: n, reason: collision with root package name */
    public static final l0 f5226n;

    /* renamed from: o, reason: collision with root package name */
    public static final l0 f5227o;

    /* renamed from: p, reason: collision with root package name */
    public static final l0 f5228p;

    /* renamed from: q, reason: collision with root package name */
    public static final l0 f5229q;

    /* renamed from: r, reason: collision with root package name */
    public static final l0 f5230r;

    /* renamed from: s, reason: collision with root package name */
    public static final l0 f5231s;

    /* renamed from: t, reason: collision with root package name */
    public static final l0 f5232t;

    /* renamed from: u, reason: collision with root package name */
    public static final l0 f5233u;

    /* renamed from: v, reason: collision with root package name */
    public static final l0 f5234v;

    /* renamed from: w, reason: collision with root package name */
    public static final l0 f5235w;

    /* renamed from: x, reason: collision with root package name */
    public static final l0 f5236x;

    /* renamed from: y, reason: collision with root package name */
    public static final l0 f5237y;

    /* renamed from: z, reason: collision with root package name */
    public static final l0 f5238z;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ int f5239g;

    static {
        int i2 = 0;
        f5220h = new l0(i2, 0);
        f5221i = new l0(i2, 1);
        f5222j = new l0(i2, 2);
        f5223k = new l0(i2, 3);
        f5224l = new l0(i2, 4);
        f5225m = new l0(i2, 5);
        f5226n = new l0(i2, 6);
        f5227o = new l0(i2, 7);
        f5228p = new l0(i2, 8);
        f5229q = new l0(i2, 9);
        f5230r = new l0(i2, 10);
        f5231s = new l0(i2, 11);
        f5232t = new l0(i2, 12);
        f5233u = new l0(i2, 13);
        f5234v = new l0(i2, 14);
        f5235w = new l0(i2, 15);
        f5236x = new l0(i2, 16);
        f5237y = new l0(i2, 17);
        f5238z = new l0(i2, 18);
        A = new l0(i2, 19);
        B = new l0(i2, 20);
        C = new l0(i2, 21);
        D = new l0(i2, 22);
        E = new l0(i2, 23);
        F = new l0(i2, 24);
        G = new l0(i2, 25);
        H = new l0(i2, 26);
        I = new l0(i2, 27);
        J = new l0(i2, 28);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ l0(int i2, int i10) {
        super(i2);
        this.f5239g = i10;
    }

    @Override // p7.a
    public final Object c() {
        Choreographer choreographer;
        g7.d dVar = null;
        switch (this.f5239g) {
            case 0:
                q0.b("LocalConfiguration");
                throw null;
            case 1:
                q0.b("LocalContext");
                throw null;
            case 2:
                q0.b("LocalImageVectorCache");
                throw null;
            case 3:
                q0.b("LocalResourceIdCache");
                throw null;
            case 4:
                q0.b("LocalView");
                throw null;
            case 5:
                if (Looper.myLooper() == Looper.getMainLooper()) {
                    choreographer = Choreographer.getInstance();
                } else {
                    pa.e eVar = ia.n0.f4982a;
                    choreographer = (Choreographer) ia.d0.w(na.o.f6923a, new h5.c(2, dVar, 1));
                }
                s0 s0Var = new s0(choreographer, Handler.createAsync(Looper.getMainLooper()));
                return g7.i.plus(s0Var, s0Var.f5323q);
            case 6:
            case 7:
                return null;
            case 8:
                g1.b("LocalAutofillManager");
                throw null;
            case 9:
                g1.b("LocalAutofillTree");
                throw null;
            case 10:
                g1.b("LocalClipboard");
                throw null;
            case 11:
                g1.b("LocalClipboardManager");
                throw null;
            case 12:
                return Boolean.TRUE;
            case 13:
                g1.b("LocalDensity");
                throw null;
            case com.google.protobuf.y0.EDITION_FIELD_NUMBER /* 14 */:
                g1.b("LocalFocusManager");
                throw null;
            case com.google.protobuf.x0.UNVERIFIED_LAZY_FIELD_NUMBER /* 15 */:
                g1.b("LocalFontFamilyResolver");
                throw null;
            case 16:
                g1.b("LocalFontLoader");
                throw null;
            case 17:
                g1.b("LocalGraphicsContext");
                throw null;
            case com.google.protobuf.a1.PY_GENERIC_SERVICES_FIELD_NUMBER /* 18 */:
                g1.b("LocalHapticFeedback");
                throw null;
            case com.google.protobuf.x0.TARGETS_FIELD_NUMBER /* 19 */:
                g1.b("LocalInputManager");
                throw null;
            case 20:
                g1.b("LocalLayoutDirection");
                throw null;
            case com.google.protobuf.x0.FEATURES_FIELD_NUMBER /* 21 */:
                return null;
            case com.google.protobuf.x0.FEATURE_SUPPORT_FIELD_NUMBER /* 22 */:
                return Boolean.FALSE;
            case com.google.protobuf.a1.DEPRECATED_FIELD_NUMBER /* 23 */:
            case 24:
                return null;
            case 25:
                g1.b("LocalTextToolbar");
                throw null;
            case 26:
                g1.b("LocalUriHandler");
                throw null;
            case com.google.protobuf.a1.JAVA_STRING_CHECK_UTF8_FIELD_NUMBER /* 27 */:
                g1.b("LocalViewConfiguration");
                throw null;
            default:
                g1.b("LocalWindowInfo");
                throw null;
        }
    }
}
