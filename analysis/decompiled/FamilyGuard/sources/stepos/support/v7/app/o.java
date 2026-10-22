package stepos.support.v7.app;

import android.R;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.graphics.drawable.ColorDrawable;
import android.provider.Settings;
import android.util.Log;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.animation.Interpolator;
import android.widget.LinearLayout;
import java.util.Iterator;
import java.util.List;
import stepos.support.v7.app.m;
import stepos.support.v7.widget.LitePopupContentFrameLayout;
import stepos.support.v7.widget.PopupNestedScrollingLayout;

/* loaded from: classes.dex */
class o implements m {

    /* renamed from: q, reason: collision with root package name */
    private static final Interpolator f20853q = androidx.core.view.animation.a.a(0.11f, 0.9f, 0.2f, 1.0f);

    /* renamed from: r, reason: collision with root package name */
    private static final Interpolator f20854r = androidx.core.view.animation.a.a(0.23f, 0.03f, 0.63f, 0.93f);

    /* renamed from: s, reason: collision with root package name */
    private static final Interpolator f20855s = androidx.core.view.animation.a.a(0.33f, 0.0f, 0.67f, 1.0f);

    /* renamed from: a, reason: collision with root package name */
    private final ColorDrawable f20856a;

    /* renamed from: b, reason: collision with root package name */
    private final int f20857b;

    /* renamed from: d, reason: collision with root package name */
    private PopupNestedScrollingLayout f20859d;

    /* renamed from: g, reason: collision with root package name */
    private n f20862g;

    /* renamed from: h, reason: collision with root package name */
    private stepos.support.v7.app.a f20863h;

    /* renamed from: i, reason: collision with root package name */
    private LitePopupContentFrameLayout f20864i;

    /* renamed from: j, reason: collision with root package name */
    private LinearLayout f20865j;

    /* renamed from: k, reason: collision with root package name */
    private int f20866k;

    /* renamed from: l, reason: collision with root package name */
    private AnimatorSet f20867l;

    /* renamed from: m, reason: collision with root package name */
    private P.i f20868m;

    /* renamed from: n, reason: collision with root package name */
    private List<m.b> f20869n;

    /* renamed from: p, reason: collision with root package name */
    private Window f20871p;

    /* renamed from: c, reason: collision with root package name */
    protected boolean f20858c = true;

    /* renamed from: e, reason: collision with root package name */
    private int f20860e = 0;

    /* renamed from: f, reason: collision with root package name */
    private boolean f20861f = true;

    /* renamed from: o, reason: collision with root package name */
    private m.a f20870o = new a();

    class a implements m.a {
        a() {
        }

        @Override // stepos.support.v7.app.m.a
        public void a(boolean z5) {
            o.this.f20862g.B();
            o.this.f20862g.u(z5);
        }

        @Override // stepos.support.v7.app.m.a
        public void b(float f5) {
            o.this.r(f5);
            o.this.f20862g.A(f5);
        }

        @Override // stepos.support.v7.app.m.a
        public void c() {
            o.this.f20862g.C();
        }
    }

    class b implements PopupNestedScrollingLayout.e {
        b() {
        }

        @Override // stepos.support.v7.widget.PopupNestedScrollingLayout.e
        public void a(int i5) {
            o.this.j(i5);
        }
    }

    class c implements ViewTreeObserver.OnPreDrawListener {
        c() {
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            o.this.f20859d.getViewTreeObserver().removeOnPreDrawListener(this);
            o.this.q();
            return true;
        }
    }

    class d extends AnimatorListenerAdapter {
        d() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            if (o.this.l()) {
                return;
            }
            p.f().b();
        }
    }

    class e extends AnimatorListenerAdapter {
        e() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            o.this.f20862g.D();
            o.this.f20862g.overridePendingTransition(0, 0);
            o.this.f20867l = null;
            p.f().h();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            if (o.this.l()) {
                return;
            }
            Log.d("popup_stack", " top stack start exit Anim, try to call bottom stack do stackExit ");
            p.f().c();
        }
    }

    o(n nVar) {
        this.f20862g = nVar;
        this.f20871p = nVar.getWindow();
        PopupNestedScrollingLayout popupNestedScrollingLayout = (PopupNestedScrollingLayout) this.f20862g.findViewById(X4.f.f5955C);
        this.f20859d = popupNestedScrollingLayout;
        popupNestedScrollingLayout.setUncollapsibleHeight(this.f20862g.getResources().getDimensionPixelSize(X4.d.f5883T));
        this.f20863h = this.f20862g.getSupportActionBar();
        this.f20864i = (LitePopupContentFrameLayout) this.f20862g.findViewById(R.id.content);
        this.f20856a = new ColorDrawable(this.f20862g.getResources().getColor(X4.c.f5860f));
        this.f20865j = (LinearLayout) this.f20862g.findViewById(X4.f.f5981b);
        this.f20859d.setOnDismissedListener(this.f20870o);
        this.f20857b = 255;
        this.f20866k = 255;
        this.f20868m = new P.i(this.f20859d, P.e.f4489o);
        this.f20859d.setScrollListener(new b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(int i5) {
        List<m.b> list = this.f20869n;
        if (list != null) {
            Iterator<m.b> it = list.iterator();
            while (it.hasNext()) {
                it.next().a(i5);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean l() {
        return p.f().e() == this.f20862g;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q() {
        AnimatorSet animatorSet = new AnimatorSet();
        this.f20859d.setTranslationY(this.f20859d.getCurrentScrollY() <= 0 ? this.f20859d.getUncollapsibleHeight() : this.f20859d.getMeasuredHeight());
        this.f20868m.x(new P.j().f(p.f20878h).h(p.f20879i));
        this.f20868m.u().g(0.0f);
        if (k()) {
            this.f20868m.p();
        } else {
            this.f20859d.setTranslationY(0.0f);
        }
        ObjectAnimator objectAnimatorOfInt = ObjectAnimator.ofInt(this.f20856a, "alpha", 0, this.f20857b);
        objectAnimatorOfInt.setInterpolator(f20855s);
        objectAnimatorOfInt.setDuration(100L);
        animatorSet.addListener(new d());
        animatorSet.playTogether(objectAnimatorOfInt);
        animatorSet.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r(float f5) {
        int i5 = (int) (this.f20857b * (1.0f - f5));
        this.f20856a.setAlpha(i5);
        this.f20866k = i5;
    }

    @Override // stepos.support.v7.app.m
    public void a(int i5) {
        this.f20860e = i5;
        PopupNestedScrollingLayout popupNestedScrollingLayout = this.f20859d;
        if (popupNestedScrollingLayout != null) {
            popupNestedScrollingLayout.setStyle(i5);
        }
    }

    @Override // stepos.support.v7.app.m
    public void b(boolean z5) {
        this.f20861f = z5;
        PopupNestedScrollingLayout popupNestedScrollingLayout = this.f20859d;
        if (popupNestedScrollingLayout != null) {
            popupNestedScrollingLayout.setScrollToDismissEnabled(z5);
        }
    }

    public boolean k() throws Settings.SettingNotFoundException {
        float f5;
        try {
            f5 = Settings.Global.getFloat(this.f20862g.getContentResolver(), "transition_animation_scale");
        } catch (Exception unused) {
            f5 = 1.0f;
        }
        return f5 != 0.0f;
    }

    public void m() {
        this.f20862g.getWindow().setBackgroundDrawable(this.f20856a);
        this.f20859d.getViewTreeObserver().addOnPreDrawListener(new c());
        this.f20862g.overridePendingTransition(0, 0);
        this.f20871p.setDecorFitsSystemWindows(false);
    }

    public void n() {
        AnimatorSet animatorSet = this.f20867l;
        if (animatorSet == null || !animatorSet.isRunning()) {
            this.f20867l = new AnimatorSet();
            int uncollapsibleHeight = this.f20859d.getCurrentScrollY() <= 0 ? this.f20859d.getUncollapsibleHeight() : this.f20859d.getMeasuredHeight();
            this.f20868m.x(new P.j().f(p.f20880j).h(p.f20881k));
            float f5 = uncollapsibleHeight;
            this.f20868m.u().g(f5);
            if (k()) {
                this.f20868m.p();
            } else {
                this.f20859d.setTranslationY(f5);
            }
            ObjectAnimator objectAnimatorOfInt = ObjectAnimator.ofInt(this.f20856a, "alpha", this.f20866k, 0);
            objectAnimatorOfInt.setInterpolator(f20855s);
            objectAnimatorOfInt.setDuration(300L);
            this.f20867l.playTogether(objectAnimatorOfInt);
            this.f20867l.addListener(new e());
            this.f20867l.start();
        }
    }

    public void o() {
        if (l()) {
            Log.d("popup_stack", " bottom stack resume, to reset state ");
            p.f().d();
        }
    }

    public void p() {
        if (this.f20858c) {
            this.f20862g.E();
        }
    }
}
