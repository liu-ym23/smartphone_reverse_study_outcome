package j1;

import b0.c3;

/* loaded from: classes.dex */
public abstract class g1 {

    /* renamed from: a, reason: collision with root package name */
    public static final c3 f5167a = new c3(l0.f5226n);

    /* renamed from: b, reason: collision with root package name */
    public static final c3 f5168b = new c3(l0.f5227o);

    /* renamed from: c, reason: collision with root package name */
    public static final c3 f5169c = new c3(l0.f5229q);

    /* renamed from: d, reason: collision with root package name */
    public static final c3 f5170d = new c3(l0.f5228p);

    /* renamed from: e, reason: collision with root package name */
    public static final c3 f5171e = new c3(l0.f5231s);

    /* renamed from: f, reason: collision with root package name */
    public static final c3 f5172f = new c3(l0.f5230r);

    /* renamed from: g, reason: collision with root package name */
    public static final c3 f5173g = new c3(l0.f5237y);

    /* renamed from: h, reason: collision with root package name */
    public static final c3 f5174h = new c3(l0.f5233u);

    /* renamed from: i, reason: collision with root package name */
    public static final c3 f5175i = new c3(l0.f5234v);

    /* renamed from: j, reason: collision with root package name */
    public static final c3 f5176j = new c3(l0.f5236x);

    /* renamed from: k, reason: collision with root package name */
    public static final c3 f5177k = new c3(l0.f5235w);

    /* renamed from: l, reason: collision with root package name */
    public static final c3 f5178l = new c3(l0.f5238z);

    /* renamed from: m, reason: collision with root package name */
    public static final c3 f5179m = new c3(l0.A);

    /* renamed from: n, reason: collision with root package name */
    public static final c3 f5180n = new c3(l0.B);

    /* renamed from: o, reason: collision with root package name */
    public static final c3 f5181o = new c3(l0.F);

    /* renamed from: p, reason: collision with root package name */
    public static final c3 f5182p = new c3(l0.E);

    /* renamed from: q, reason: collision with root package name */
    public static final c3 f5183q = new c3(l0.G);

    /* renamed from: r, reason: collision with root package name */
    public static final c3 f5184r = new c3(l0.H);

    /* renamed from: s, reason: collision with root package name */
    public static final c3 f5185s = new c3(l0.I);

    /* renamed from: t, reason: collision with root package name */
    public static final c3 f5186t = new c3(l0.J);

    /* renamed from: u, reason: collision with root package name */
    public static final c3 f5187u = new c3(l0.C);

    /* renamed from: v, reason: collision with root package name */
    public static final b0.e0 f5188v = new b0.e0(l0.D);

    static {
        s7.a.H(l0.f5232t);
    }

    public static final void a(i1.k1 k1Var, u0 u0Var, p7.n nVar, b0.p pVar, int i2) {
        pVar.T(1925803616);
        int i10 = (pVar.f(k1Var) ? 4 : 2) | i2 | (pVar.f(u0Var) ? 32 : 16) | (pVar.h(nVar) ? 256 : 128);
        if (pVar.L(i10 & 1, (i10 & 147) != 146)) {
            y yVar = (y) k1Var;
            b0.x1 x1VarA = f5167a.a(yVar.getAccessibilityManager());
            b0.x1 x1VarA2 = f5168b.a(yVar.getAutofill());
            b0.x1 x1VarA3 = f5170d.a(yVar.getAutofillManager());
            b0.x1 x1VarA4 = f5169c.a(yVar.getAutofillTree());
            b0.x1 x1VarA5 = f5171e.a(yVar.getClipboardManager());
            b0.x1 x1VarA6 = f5172f.a(yVar.getClipboard());
            b0.x1 x1VarA7 = f5174h.a(yVar.getDensity());
            b0.x1 x1VarA8 = f5175i.a(yVar.getFocusOwner());
            b0.x1 x1VarA9 = f5176j.a(yVar.getFontLoader());
            x1VarA9.f1423f = false;
            b0.x1 x1VarA10 = f5177k.a(yVar.getFontFamilyResolver());
            x1VarA10.f1423f = false;
            b0.b.b(new b0.x1[]{x1VarA, x1VarA2, x1VarA3, x1VarA4, x1VarA5, x1VarA6, x1VarA7, x1VarA8, x1VarA9, x1VarA10, f5178l.a(yVar.getHapticFeedBack()), f5179m.a(yVar.getInputModeManager()), f5180n.a(yVar.getLayoutDirection()), f5181o.a(yVar.getTextInputService()), f5182p.a(yVar.getSoftwareKeyboardController()), f5183q.a(yVar.getTextToolbar()), f5184r.a(u0Var), f5185s.a(yVar.getViewConfiguration()), f5186t.a(yVar.getWindowInfo()), f5187u.a(yVar.getPointerIconService()), f5173g.a(yVar.getGraphicsContext())}, nVar, pVar, ((i10 >> 3) & 112) | 8);
        } else {
            pVar.O();
        }
        b0.z1 z1VarS = pVar.s();
        if (z1VarS != null) {
            z1VarS.f1444d = new n0(k1Var, u0Var, nVar, i2);
        }
    }

    public static final void b(String str) {
        throw new IllegalStateException(("CompositionLocal " + str + " not present").toString());
    }
}
