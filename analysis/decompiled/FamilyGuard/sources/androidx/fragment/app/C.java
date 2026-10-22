package androidx.fragment.app;

import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.AbstractC0533m;

@Deprecated
/* loaded from: classes.dex */
public abstract class C extends androidx.viewpager.widget.a {

    /* renamed from: c, reason: collision with root package name */
    private final x f10393c;

    /* renamed from: d, reason: collision with root package name */
    private final int f10394d;

    /* renamed from: e, reason: collision with root package name */
    private G f10395e;

    /* renamed from: f, reason: collision with root package name */
    private ComponentCallbacksC0511f f10396f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f10397g;

    @Deprecated
    public C(x xVar) {
        this(xVar, 0);
    }

    private static String q(int i5, long j5) {
        return "android:switcher:" + i5 + ":" + j5;
    }

    @Override // androidx.viewpager.widget.a
    public void a(ViewGroup viewGroup, int i5, Object obj) {
        ComponentCallbacksC0511f componentCallbacksC0511f = (ComponentCallbacksC0511f) obj;
        if (this.f10395e == null) {
            this.f10395e = this.f10393c.m();
        }
        this.f10395e.m(componentCallbacksC0511f);
        if (componentCallbacksC0511f.equals(this.f10396f)) {
            this.f10396f = null;
        }
    }

    @Override // androidx.viewpager.widget.a
    public void b(ViewGroup viewGroup) {
        G g5 = this.f10395e;
        if (g5 != null) {
            if (!this.f10397g) {
                try {
                    this.f10397g = true;
                    g5.l();
                } finally {
                    this.f10397g = false;
                }
            }
            this.f10395e = null;
        }
    }

    @Override // androidx.viewpager.widget.a
    public Object f(ViewGroup viewGroup, int i5) {
        if (this.f10395e == null) {
            this.f10395e = this.f10393c.m();
        }
        long jP = p(i5);
        ComponentCallbacksC0511f componentCallbacksC0511fG0 = this.f10393c.g0(q(viewGroup.getId(), jP));
        if (componentCallbacksC0511fG0 != null) {
            this.f10395e.h(componentCallbacksC0511fG0);
        } else {
            componentCallbacksC0511fG0 = o(i5);
            this.f10395e.c(viewGroup.getId(), componentCallbacksC0511fG0, q(viewGroup.getId(), jP));
        }
        if (componentCallbacksC0511fG0 != this.f10396f) {
            componentCallbacksC0511fG0.J1(false);
            if (this.f10394d == 1) {
                this.f10395e.u(componentCallbacksC0511fG0, AbstractC0533m.b.STARTED);
                return componentCallbacksC0511fG0;
            }
            componentCallbacksC0511fG0.P1(false);
        }
        return componentCallbacksC0511fG0;
    }

    @Override // androidx.viewpager.widget.a
    public boolean g(View view, Object obj) {
        return ((ComponentCallbacksC0511f) obj).a0() == view;
    }

    @Override // androidx.viewpager.widget.a
    public void i(Parcelable parcelable, ClassLoader classLoader) {
    }

    @Override // androidx.viewpager.widget.a
    public Parcelable j() {
        return null;
    }

    @Override // androidx.viewpager.widget.a
    public void k(ViewGroup viewGroup, int i5, Object obj) {
        ComponentCallbacksC0511f componentCallbacksC0511f = (ComponentCallbacksC0511f) obj;
        ComponentCallbacksC0511f componentCallbacksC0511f2 = this.f10396f;
        if (componentCallbacksC0511f != componentCallbacksC0511f2) {
            if (componentCallbacksC0511f2 != null) {
                componentCallbacksC0511f2.J1(false);
                if (this.f10394d == 1) {
                    if (this.f10395e == null) {
                        this.f10395e = this.f10393c.m();
                    }
                    this.f10395e.u(this.f10396f, AbstractC0533m.b.STARTED);
                } else {
                    this.f10396f.P1(false);
                }
            }
            componentCallbacksC0511f.J1(true);
            if (this.f10394d == 1) {
                if (this.f10395e == null) {
                    this.f10395e = this.f10393c.m();
                }
                this.f10395e.u(componentCallbacksC0511f, AbstractC0533m.b.RESUMED);
            } else {
                componentCallbacksC0511f.P1(true);
            }
            this.f10396f = componentCallbacksC0511f;
        }
    }

    @Override // androidx.viewpager.widget.a
    public void m(ViewGroup viewGroup) {
        if (viewGroup.getId() != -1) {
            return;
        }
        throw new IllegalStateException("ViewPager with adapter " + this + " requires a view id");
    }

    public abstract ComponentCallbacksC0511f o(int i5);

    public long p(int i5) {
        return i5;
    }

    public C(x xVar, int i5) {
        this.f10395e = null;
        this.f10396f = null;
        this.f10393c = xVar;
        this.f10394d = i5;
    }
}
