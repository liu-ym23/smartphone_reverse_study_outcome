package v1;

import android.os.Handler;
import android.os.Looper;
import android.view.Choreographer;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import com.google.crypto.tink.aead.internal.InsecureNonceXChaCha20;
import com.stepos.policy.sdk.bean.PolicyBasicListVO;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class h0 extends yb.l implements xb.a {
    public static final h0 A;
    public static final h0 B;
    public static final h0 C;
    public static final h0 D;
    public static final h0 E;
    public static final h0 F;
    public static final h0 G;
    public static final h0 H;
    public static final h0 I;

    /* renamed from: f, reason: collision with root package name */
    public static final h0 f14432f;

    /* renamed from: g, reason: collision with root package name */
    public static final h0 f14433g;

    /* renamed from: h, reason: collision with root package name */
    public static final h0 f14434h;
    public static final h0 i;

    /* renamed from: j, reason: collision with root package name */
    public static final h0 f14435j;

    /* renamed from: k, reason: collision with root package name */
    public static final h0 f14436k;

    /* renamed from: l, reason: collision with root package name */
    public static final h0 f14437l;

    /* renamed from: m, reason: collision with root package name */
    public static final h0 f14438m;

    /* renamed from: n, reason: collision with root package name */
    public static final h0 f14439n;

    /* renamed from: o, reason: collision with root package name */
    public static final h0 f14440o;

    /* renamed from: p, reason: collision with root package name */
    public static final h0 f14441p;

    /* renamed from: q, reason: collision with root package name */
    public static final h0 f14442q;

    /* renamed from: r, reason: collision with root package name */
    public static final h0 f14443r;

    /* renamed from: s, reason: collision with root package name */
    public static final h0 f14444s;

    /* renamed from: t, reason: collision with root package name */
    public static final h0 f14445t;

    /* renamed from: u, reason: collision with root package name */
    public static final h0 f14446u;

    /* renamed from: v, reason: collision with root package name */
    public static final h0 f14447v;

    /* renamed from: w, reason: collision with root package name */
    public static final h0 f14448w;

    /* renamed from: x, reason: collision with root package name */
    public static final h0 f14449x;

    /* renamed from: y, reason: collision with root package name */
    public static final h0 f14450y;

    /* renamed from: z, reason: collision with root package name */
    public static final h0 f14451z;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f14452c;

    static {
        int i3 = 0;
        f14432f = new h0(i3, 0);
        f14433g = new h0(i3, 1);
        f14434h = new h0(i3, 2);
        i = new h0(i3, 3);
        f14435j = new h0(i3, 4);
        f14436k = new h0(i3, 5);
        f14437l = new h0(i3, 6);
        f14438m = new h0(i3, 7);
        f14439n = new h0(i3, 8);
        f14440o = new h0(i3, 9);
        f14441p = new h0(i3, 10);
        f14442q = new h0(i3, 11);
        f14443r = new h0(i3, 12);
        f14444s = new h0(i3, 13);
        f14445t = new h0(i3, 14);
        f14446u = new h0(i3, 15);
        f14447v = new h0(i3, 16);
        f14448w = new h0(i3, 17);
        f14449x = new h0(i3, 18);
        f14450y = new h0(i3, 19);
        f14451z = new h0(i3, 20);
        A = new h0(i3, 21);
        B = new h0(i3, 22);
        C = new h0(i3, 23);
        D = new h0(i3, 24);
        E = new h0(i3, 25);
        F = new h0(i3, 26);
        G = new h0(i3, 27);
        H = new h0(i3, 28);
        I = new h0(i3, 29);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ h0(int i3, int i10) {
        super(i3);
        this.f14452c = i10;
    }

    @Override // xb.a
    public final Object invoke() {
        Choreographer choreographer;
        nb.c cVar = null;
        switch (this.f14452c) {
            case 0:
                AndroidCompositionLocals_androidKt.b("LocalConfiguration");
                throw null;
            case 1:
                AndroidCompositionLocals_androidKt.b("LocalContext");
                throw null;
            case 2:
                AndroidCompositionLocals_androidKt.b("LocalImageVectorCache");
                throw null;
            case 3:
                AndroidCompositionLocals_androidKt.b("LocalResourceIdCache");
                throw null;
            case 4:
                AndroidCompositionLocals_androidKt.b("LocalView");
                throw null;
            case 5:
                if (Looper.myLooper() == Looper.getMainLooper()) {
                    choreographer = Choreographer.getInstance();
                } else {
                    rc.e eVar = kc.e0.f7430a;
                    choreographer = (Choreographer) kc.w.y(pc.n.f9978a, new h0.n1(2, cVar, 6));
                }
                m0 m0Var = new m0(choreographer, Handler.createAsync(Looper.getMainLooper()));
                return m0Var.plus(m0Var.f14502o);
            case 6:
            case 7:
                return null;
            case 8:
                a1.b("LocalAutofillManager");
                throw null;
            case 9:
                a1.b("LocalAutofillTree");
                throw null;
            case 10:
                a1.b("LocalClipboard");
                throw null;
            case 11:
                a1.b("LocalClipboardManager");
                throw null;
            case 12:
                return Boolean.TRUE;
            case 13:
                a1.b("LocalDensity");
                throw null;
            case 14:
                a1.b("LocalFocusManager");
                throw null;
            case 15:
                a1.b("LocalFontFamilyResolver");
                throw null;
            case 16:
                a1.b("LocalFontLoader");
                throw null;
            case 17:
                a1.b("LocalGraphicsContext");
                throw null;
            case 18:
                a1.b("LocalHapticFeedback");
                throw null;
            case 19:
                a1.b("LocalInputManager");
                throw null;
            case PolicyBasicListVO.TYPE_ID_LIST_ICON_SMALL /* 20 */:
                a1.b("LocalLayoutDirection");
                throw null;
            case PolicyBasicListVO.TYPE_ID_LIST_ICON_SMALL_WITH_SUBTITLE /* 21 */:
                return null;
            case PolicyBasicListVO.TYPE_ID_LIST_ICON_MIDDLE /* 22 */:
                return Boolean.FALSE;
            case PolicyBasicListVO.TYPE_ID_LIST_ICON_LARGE /* 23 */:
            case InsecureNonceXChaCha20.NONCE_SIZE_IN_BYTES /* 24 */:
                return null;
            case PolicyBasicListVO.TYPE_ID_LIST_AVATAR /* 25 */:
                a1.b("LocalTextToolbar");
                throw null;
            case PolicyBasicListVO.TYPE_ID_LIST_AVATAR_WITH_SUBTITLE /* 26 */:
                a1.b("LocalUriHandler");
                throw null;
            case PolicyBasicListVO.TYPE_ID_LIST_AVATAR_WITH_DESC /* 27 */:
                a1.b("LocalViewConfiguration");
                throw null;
            case 28:
                a1.b("LocalWindowInfo");
                throw null;
            default:
                return Boolean.FALSE;
        }
    }
}
