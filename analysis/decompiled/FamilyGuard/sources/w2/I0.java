package w2;

import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.transition.Transition;
import android.view.View;
import androidx.fragment.app.ComponentCallbacksC0511f;
import com.stepos.familyguard.R;
import j2.C0779B;
import stepos.support.v4.view.ViewPager;
import stepos.support.v7.app.a;

/* loaded from: classes.dex */
public abstract class I0 extends com.stepos.familyguard.ui.base.a implements a.j, Transition.TransitionListener {

    /* renamed from: c, reason: collision with root package name */
    protected C0779B f23565c;

    private class a extends androidx.fragment.app.C {

        /* renamed from: h, reason: collision with root package name */
        private ComponentCallbacksC0511f f23566h;

        /* renamed from: i, reason: collision with root package name */
        private ComponentCallbacksC0511f f23567i;

        public a(androidx.fragment.app.x xVar) {
            super(xVar);
        }

        @Override // androidx.viewpager.widget.a
        public int c() {
            return 2;
        }

        @Override // androidx.fragment.app.C
        public ComponentCallbacksC0511f o(int i5) {
            ComponentCallbacksC0511f componentCallbacksC0511f;
            if (i5 == 0) {
                if (this.f23566h == null) {
                    this.f23566h = I0.this.V(i5);
                }
                componentCallbacksC0511f = this.f23566h;
            } else {
                if (this.f23567i == null) {
                    this.f23567i = I0.this.V(i5);
                }
                componentCallbacksC0511f = this.f23567i;
            }
            componentCallbacksC0511f.G1(I0.this.getIntent().getExtras());
            return componentCallbacksC0511f;
        }
    }

    private class b implements ViewPager.l {

        /* renamed from: a, reason: collision with root package name */
        int f23569a;

        @Override // stepos.support.v4.view.ViewPager.l
        public void a(int i5, float f5, int i6) {
            stepos.support.v7.app.a supportActionBar = I0.this.getSupportActionBar();
            if (supportActionBar == null || !supportActionBar.s()) {
                return;
            }
            supportActionBar.O(i5, f5, i6);
        }

        @Override // stepos.support.v4.view.ViewPager.l
        public void b(int i5) {
            stepos.support.v7.app.a supportActionBar;
            if (i5 != 0 || (supportActionBar = I0.this.getSupportActionBar()) == null || !supportActionBar.s() || supportActionBar.n(this.f23569a) == null) {
                return;
            }
            supportActionBar.x(supportActionBar.n(this.f23569a));
        }

        @Override // stepos.support.v4.view.ViewPager.l
        public void c(int i5) {
            this.f23569a = i5;
            I0.this.X(i5);
        }

        private b() {
        }
    }

    private a.i W(stepos.support.v7.app.a aVar, int i5) {
        return aVar.t().r(i5).s(androidx.core.content.a.d(this, R.color.us_action_bar_capsule_tab_text_color)).n(androidx.core.content.a.d(this, R.color.us_action_bar_capsule_tab_background_color)).q(this);
    }

    protected abstract ComponentCallbacksC0511f V(int i5);

    protected void X(int i5) {
    }

    @Override // stepos.support.v7.app.a.j
    public void c(a.i iVar, androidx.fragment.app.G g5) {
    }

    @Override // stepos.support.v7.app.a.j
    public void d(a.i iVar, androidx.fragment.app.G g5) throws Resources.NotFoundException {
        C0779B c0779b = this.f23565c;
        if (c0779b != null) {
            ViewPager viewPager = c0779b.f17634b;
            if (viewPager.getAdapter() == null || iVar.h() >= viewPager.getAdapter().c()) {
                return;
            }
            viewPager.setCurrentItem(iVar.h());
        }
    }

    @Override // stepos.support.v7.app.a.j
    public void l(a.i iVar, androidx.fragment.app.G g5) {
    }

    @Override // android.transition.Transition.TransitionListener
    public void onTransitionCancel(Transition transition) {
    }

    @Override // android.transition.Transition.TransitionListener
    public void onTransitionEnd(Transition transition) {
    }

    @Override // android.transition.Transition.TransitionListener
    public void onTransitionPause(Transition transition) {
    }

    @Override // android.transition.Transition.TransitionListener
    public void onTransitionResume(Transition transition) {
    }

    @Override // android.transition.Transition.TransitionListener
    public void onTransitionStart(Transition transition) {
    }

    @Override // i2.AbstractActivityC0758a
    public int u() {
        return ((super.u() + T1.a.b(this)) + T1.g.b(this, R.attr.marginSmall)) - T1.g.f(1.0f);
    }

    @Override // com.stepos.familyguard.ui.base.a, i2.AbstractActivityC0758a
    public View x() {
        C0779B c0779bC = C0779B.c(getLayoutInflater());
        this.f23565c = c0779bC;
        return c0779bC.b();
    }

    @Override // i2.AbstractActivityC0758a
    public void y(View view, Bundle bundle) {
        super.y(view, bundle);
        this.f23565c.f17634b.setAdapter(new a(getSupportFragmentManager()));
        this.f23565c.f17634b.setOnPageChangeListener(new b());
    }

    @Override // i2.AbstractActivityC0758a
    protected void z() {
        stepos.support.v7.app.a supportActionBar = getSupportActionBar();
        if (supportActionBar == null) {
            return;
        }
        ColorDrawable colorDrawable = new ColorDrawable(T1.h.a(this, R.attr.colorSurface));
        supportActionBar.y(colorDrawable);
        supportActionBar.N(colorDrawable);
        supportActionBar.p().g(colorDrawable);
        supportActionBar.I(false);
        supportActionBar.G(true);
        supportActionBar.E(true);
        supportActionBar.P(R.string.us_usage_limit);
        supportActionBar.z(true);
        supportActionBar.L(2);
        supportActionBar.f(W(supportActionBar, R.string.us_app));
        supportActionBar.f(W(supportActionBar, R.string.us_category));
    }
}
