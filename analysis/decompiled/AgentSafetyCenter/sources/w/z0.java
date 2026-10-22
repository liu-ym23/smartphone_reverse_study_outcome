package w;

import android.view.View;
import com.stepos.agentsafetycenter.R;
import java.lang.invoke.VarHandle;
import java.util.WeakHashMap;
import n3.m1;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class z0 {

    /* renamed from: u, reason: collision with root package name */
    public static final WeakHashMap f15068u = new WeakHashMap();

    /* renamed from: a, reason: collision with root package name */
    public final b f15069a = c.b(4, "captionBar");

    /* renamed from: b, reason: collision with root package name */
    public final b f15070b;

    /* renamed from: c, reason: collision with root package name */
    public final b f15071c;

    /* renamed from: d, reason: collision with root package name */
    public final b f15072d;

    /* renamed from: e, reason: collision with root package name */
    public final b f15073e;

    /* renamed from: f, reason: collision with root package name */
    public final b f15074f;

    /* renamed from: g, reason: collision with root package name */
    public final b f15075g;

    /* renamed from: h, reason: collision with root package name */
    public final b f15076h;
    public final b i;

    /* renamed from: j, reason: collision with root package name */
    public final x0 f15077j;

    /* renamed from: k, reason: collision with root package name */
    public final x0 f15078k;

    /* renamed from: l, reason: collision with root package name */
    public final x0 f15079l;

    /* renamed from: m, reason: collision with root package name */
    public final x0 f15080m;

    /* renamed from: n, reason: collision with root package name */
    public final x0 f15081n;

    /* renamed from: o, reason: collision with root package name */
    public final x0 f15082o;

    /* renamed from: p, reason: collision with root package name */
    public final x0 f15083p;

    /* renamed from: q, reason: collision with root package name */
    public final x0 f15084q;

    /* renamed from: r, reason: collision with root package name */
    public final boolean f15085r;

    /* renamed from: s, reason: collision with root package name */
    public int f15086s;

    /* renamed from: t, reason: collision with root package name */
    public final e0 f15087t;

    /* JADX WARN: Multi-variable type inference failed */
    public z0(View view) {
        b bVarB = c.b(128, "displayCutout");
        this.f15070b = bVarB;
        b bVarB2 = c.b(8, "ime");
        this.f15071c = bVarB2;
        b bVarB3 = c.b(32, "mandatorySystemGestures");
        this.f15072d = bVarB3;
        this.f15073e = c.b(2, "navigationBars");
        this.f15074f = c.b(1, "statusBars");
        b bVarB4 = c.b(519, "systemBars");
        this.f15075g = bVarB4;
        b bVarB5 = c.b(16, "systemGestures");
        this.f15076h = bVarB5;
        b bVarB6 = c.b(64, "tappableElement");
        this.i = bVarB6;
        g0 g0Var = new g0();
        g0Var.f14976a = 0;
        g0Var.f14977b = 0;
        g0Var.f14978c = 0;
        g0Var.f14979d = 0;
        VarHandle.storeStoreFence();
        x0 x0Var = new x0();
        x0Var.f15064a = "waterfall";
        x0Var.f15065b = k0.z.v(g0Var);
        VarHandle.storeStoreFence();
        this.f15077j = x0Var;
        t1.e.q(t1.e.q(t1.e.q(bVarB4, bVarB2), bVarB), t1.e.q(t1.e.q(t1.e.q(bVarB6, bVarB3), bVarB5), x0Var));
        this.f15078k = c.d(4, "captionBarIgnoringVisibility");
        this.f15079l = c.d(2, "navigationBarsIgnoringVisibility");
        this.f15080m = c.d(1, "statusBarsIgnoringVisibility");
        this.f15081n = c.d(519, "systemBarsIgnoringVisibility");
        this.f15082o = c.d(64, "tappableElementIgnoringVisibility");
        this.f15083p = c.d(8, "imeAnimationTarget");
        this.f15084q = c.d(8, "imeAnimationSource");
        Object parent = view.getParent();
        View view2 = parent instanceof View ? (View) parent : null;
        Object tag = view2 != null ? view2.getTag(R.id.consume_window_insets_tag) : null;
        Boolean bool = tag instanceof Boolean ? (Boolean) tag : null;
        boolean zBooleanValue = bool != null ? bool.booleanValue() : 1;
        this.f15085r = zBooleanValue;
        e0 e0Var = new e0(!zBooleanValue);
        e0Var.f14967f = this;
        VarHandle.storeStoreFence();
        this.f15087t = e0Var;
    }

    public static void a(z0 z0Var, m1 m1Var) {
        boolean z10 = false;
        z0Var.f15069a.f(m1Var, 0);
        z0Var.f15071c.f(m1Var, 0);
        z0Var.f15070b.f(m1Var, 0);
        z0Var.f15073e.f(m1Var, 0);
        z0Var.f15074f.f(m1Var, 0);
        z0Var.f15075g.f(m1Var, 0);
        z0Var.f15076h.f(m1Var, 0);
        z0Var.i.f(m1Var, 0);
        z0Var.f15072d.f(m1Var, 0);
        z0Var.f15078k.f(t.n.l(m1Var.f8737a.j(4)));
        z0Var.f15079l.f(t.n.l(m1Var.f8737a.j(2)));
        z0Var.f15080m.f(t.n.l(m1Var.f8737a.j(1)));
        z0Var.f15081n.f(t.n.l(m1Var.f8737a.j(519)));
        z0Var.f15082o.f(t.n.l(m1Var.f8737a.j(64)));
        n3.f fVarH = m1Var.f8737a.h();
        if (fVarH != null) {
            z0Var.f15077j.f(t.n.l(f3.b.b(fVarH.f8712a.getWaterfallInsets())));
        }
        synchronized (u0.m.f13676c) {
            p.g0 g0Var = u0.m.f13682j.f13641h;
            if (g0Var != null) {
                if (g0Var.h()) {
                    z10 = true;
                }
            }
        }
        if (z10) {
            u0.m.a();
        }
    }
}
