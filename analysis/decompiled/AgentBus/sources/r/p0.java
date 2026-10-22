package r;

import android.view.View;
import com.stepos.agentbus.R;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public final class p0 {

    /* renamed from: u, reason: collision with root package name */
    public static final WeakHashMap f8908u = new WeakHashMap();

    /* renamed from: a, reason: collision with root package name */
    public final a f8909a = e.c(4, "captionBar");

    /* renamed from: b, reason: collision with root package name */
    public final a f8910b;

    /* renamed from: c, reason: collision with root package name */
    public final a f8911c;

    /* renamed from: d, reason: collision with root package name */
    public final a f8912d;

    /* renamed from: e, reason: collision with root package name */
    public final a f8913e;

    /* renamed from: f, reason: collision with root package name */
    public final a f8914f;

    /* renamed from: g, reason: collision with root package name */
    public final a f8915g;

    /* renamed from: h, reason: collision with root package name */
    public final a f8916h;

    /* renamed from: i, reason: collision with root package name */
    public final a f8917i;

    /* renamed from: j, reason: collision with root package name */
    public final n0 f8918j;

    /* renamed from: k, reason: collision with root package name */
    public final n0 f8919k;

    /* renamed from: l, reason: collision with root package name */
    public final n0 f8920l;

    /* renamed from: m, reason: collision with root package name */
    public final n0 f8921m;

    /* renamed from: n, reason: collision with root package name */
    public final n0 f8922n;

    /* renamed from: o, reason: collision with root package name */
    public final n0 f8923o;

    /* renamed from: p, reason: collision with root package name */
    public final n0 f8924p;

    /* renamed from: q, reason: collision with root package name */
    public final n0 f8925q;

    /* renamed from: r, reason: collision with root package name */
    public final boolean f8926r;

    /* renamed from: s, reason: collision with root package name */
    public int f8927s;

    /* renamed from: t, reason: collision with root package name */
    public final w f8928t;

    public p0(View view) {
        a aVarC = e.c(128, "displayCutout");
        this.f8910b = aVarC;
        a aVarC2 = e.c(8, "ime");
        this.f8911c = aVarC2;
        a aVarC3 = e.c(32, "mandatorySystemGestures");
        this.f8912d = aVarC3;
        this.f8913e = e.c(2, "navigationBars");
        this.f8914f = e.c(1, "statusBars");
        a aVarC4 = e.c(519, "systemBars");
        this.f8915g = aVarC4;
        a aVarC5 = e.c(16, "systemGestures");
        this.f8916h = aVarC5;
        a aVarC6 = e.c(64, "tappableElement");
        this.f8917i = aVarC6;
        n0 n0Var = new n0(new z(0, 0, 0, 0), "waterfall");
        this.f8918j = n0Var;
        new l0(new l0(aVarC4, aVarC2), aVarC);
        new l0(new l0(new l0(aVarC6, aVarC3), aVarC5), n0Var);
        this.f8919k = e.d(4, "captionBarIgnoringVisibility");
        this.f8920l = e.d(2, "navigationBarsIgnoringVisibility");
        this.f8921m = e.d(1, "statusBarsIgnoringVisibility");
        this.f8922n = e.d(519, "systemBarsIgnoringVisibility");
        this.f8923o = e.d(64, "tappableElementIgnoringVisibility");
        this.f8924p = e.d(8, "imeAnimationTarget");
        this.f8925q = e.d(8, "imeAnimationSource");
        Object parent = view.getParent();
        View view2 = parent instanceof View ? (View) parent : null;
        Object tag = view2 != null ? view2.getTag(R.id.consume_window_insets_tag) : null;
        Boolean bool = tag instanceof Boolean ? (Boolean) tag : null;
        this.f8926r = bool != null ? bool.booleanValue() : true;
        this.f8928t = new w(this);
    }

    public static void a(p0 p0Var, o2.j0 j0Var) {
        boolean z4 = false;
        p0Var.f8909a.f(j0Var, 0);
        p0Var.f8911c.f(j0Var, 0);
        p0Var.f8910b.f(j0Var, 0);
        p0Var.f8913e.f(j0Var, 0);
        p0Var.f8914f.f(j0Var, 0);
        p0Var.f8915g.f(j0Var, 0);
        p0Var.f8916h.f(j0Var, 0);
        p0Var.f8917i.f(j0Var, 0);
        p0Var.f8912d.f(j0Var, 0);
        p0Var.f8919k.f(n7.o.C(j0Var.f7236a.i(4)));
        p0Var.f8920l.f(n7.o.C(j0Var.f7236a.i(2)));
        p0Var.f8921m.f(n7.o.C(j0Var.f7236a.i(1)));
        p0Var.f8922n.f(n7.o.C(j0Var.f7236a.i(519)));
        p0Var.f8923o.f(n7.o.C(j0Var.f7236a.i(64)));
        o2.c cVarG = j0Var.f7236a.g();
        if (cVarG != null) {
            p0Var.f8918j.f(n7.o.C(k2.a.c(cVarG.f7223a.getWaterfallInsets())));
        }
        synchronized (l0.m.f5774c) {
            k.b0 b0Var = l0.m.f5781j.f5736h;
            if (b0Var != null) {
                if (b0Var.h()) {
                    z4 = true;
                }
            }
        }
        if (z4) {
            l0.m.a();
        }
    }
}
