package v1;

import com.fasterxml.jackson.core.ErrorReportConfiguration;
import k0.s2;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public abstract class a1 {

    /* renamed from: a, reason: collision with root package name */
    public static final s2 f14356a = new s2(h0.f14437l);

    /* renamed from: b, reason: collision with root package name */
    public static final s2 f14357b = new s2(h0.f14438m);

    /* renamed from: c, reason: collision with root package name */
    public static final s2 f14358c = new s2(h0.f14440o);

    /* renamed from: d, reason: collision with root package name */
    public static final s2 f14359d = new s2(h0.f14439n);

    /* renamed from: e, reason: collision with root package name */
    public static final s2 f14360e = new s2(h0.f14442q);

    /* renamed from: f, reason: collision with root package name */
    public static final s2 f14361f = new s2(h0.f14441p);

    /* renamed from: g, reason: collision with root package name */
    public static final s2 f14362g = new s2(h0.f14448w);

    /* renamed from: h, reason: collision with root package name */
    public static final s2 f14363h = new s2(h0.f14444s);
    public static final s2 i = new s2(h0.f14445t);

    /* renamed from: j, reason: collision with root package name */
    public static final s2 f14364j = new s2(h0.f14447v);

    /* renamed from: k, reason: collision with root package name */
    public static final s2 f14365k = new s2(h0.f14446u);

    /* renamed from: l, reason: collision with root package name */
    public static final s2 f14366l = new s2(h0.f14449x);

    /* renamed from: m, reason: collision with root package name */
    public static final s2 f14367m = new s2(h0.f14450y);

    /* renamed from: n, reason: collision with root package name */
    public static final s2 f14368n = new s2(h0.f14451z);

    /* renamed from: o, reason: collision with root package name */
    public static final s2 f14369o = new s2(h0.D);

    /* renamed from: p, reason: collision with root package name */
    public static final s2 f14370p = new s2(h0.C);

    /* renamed from: q, reason: collision with root package name */
    public static final s2 f14371q = new s2(h0.E);

    /* renamed from: r, reason: collision with root package name */
    public static final s2 f14372r = new s2(h0.F);

    /* renamed from: s, reason: collision with root package name */
    public static final s2 f14373s = new s2(h0.G);

    /* renamed from: t, reason: collision with root package name */
    public static final s2 f14374t = new s2(h0.H);

    /* renamed from: u, reason: collision with root package name */
    public static final s2 f14375u = new s2(h0.A);

    /* renamed from: v, reason: collision with root package name */
    public static final k0.e0 f14376v = k0.z.n(h0.B);

    static {
        new s2(h0.f14443r);
    }

    public static final void a(u1.n1 n1Var, o0 o0Var, xb.p pVar, k0.s sVar, int i3) {
        sVar.Z(1925803616);
        int i10 = i3 | (sVar.f(n1Var) ? 4 : 2) | (sVar.f(o0Var) ? 32 : 16) | (sVar.h(pVar) ? ErrorReportConfiguration.DEFAULT_MAX_ERROR_TOKEN_LENGTH : 128);
        if (sVar.P(i10 & 1, (i10 & 147) != 146)) {
            t tVar = (t) n1Var;
            k0.t1 t1VarA = f14356a.a(tVar.getAccessibilityManager());
            k0.t1 t1VarA2 = f14357b.a(tVar.getAutofill());
            k0.t1 t1VarA3 = f14359d.a(tVar.getAutofillManager());
            k0.t1 t1VarA4 = f14358c.a(tVar.getAutofillTree());
            k0.t1 t1VarA5 = f14360e.a(tVar.m7getClipboardManager());
            k0.t1 t1VarA6 = f14361f.a(tVar.m6getClipboard());
            k0.t1 t1VarA7 = f14363h.a(tVar.getDensity());
            k0.t1 t1VarA8 = i.a(tVar.getFocusOwner());
            k0.t1 t1VarA9 = f14364j.a(tVar.getFontLoader());
            t1VarA9.f7074c = false;
            k0.t1 t1VarA10 = f14365k.a(tVar.getFontFamilyResolver());
            t1VarA10.f7074c = false;
            k0.z.b(new k0.t1[]{t1VarA, t1VarA2, t1VarA3, t1VarA4, t1VarA5, t1VarA6, t1VarA7, t1VarA8, t1VarA9, t1VarA10, f14366l.a(tVar.getHapticFeedBack()), f14367m.a(tVar.getInputModeManager()), f14368n.a(tVar.getLayoutDirection()), f14369o.a(tVar.getTextInputService()), f14370p.a(tVar.getSoftwareKeyboardController()), f14371q.a(tVar.getTextToolbar()), f14372r.a(o0Var), f14373s.a(tVar.getViewConfiguration()), f14374t.a(tVar.getWindowInfo()), f14375u.a(tVar.getPointerIconService()), f14362g.a(tVar.getGraphicsContext())}, pVar, sVar, ((i10 >> 3) & 112) | 8);
        } else {
            sVar.S();
        }
        k0.v1 v1VarS = sVar.s();
        if (v1VarS != null) {
            v1VarS.f7091d = new u.p0(n1Var, o0Var, pVar, i3, 2);
        }
    }

    public static final void b(String str) {
        throw new IllegalStateException(("CompositionLocal " + str + " not present").toString());
    }
}
