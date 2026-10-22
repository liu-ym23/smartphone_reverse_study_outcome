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
import com.stepos.launcher.assistant.slidepanel.ConstConfig;
import java.util.Iterator;
import java.util.List;
import stepos.support.v7.app.l;
import stepos.support.v7.appcompat.R$color;
import stepos.support.v7.appcompat.R$dimen;
import stepos.support.v7.appcompat.R$id;
import stepos.support.v7.widget.LitePopupContentFrameLayout;
import stepos.support.v7.widget.PopupNestedScrollingLayout;

/* loaded from: classes5.dex */
public class n implements l {

    /* renamed from: q, reason: collision with root package name */
    public static final Interpolator f40529q = D0.a.a(0.11f, 0.9f, 0.2f, 1.0f);

    /* renamed from: r, reason: collision with root package name */
    public static final Interpolator f40530r = D0.a.a(0.23f, 0.03f, 0.63f, 0.93f);

    /* renamed from: s, reason: collision with root package name */
    public static final Interpolator f40531s = D0.a.a(0.33f, 0.0f, 0.67f, 1.0f);

    /* renamed from: a, reason: collision with root package name */
    public final ColorDrawable f40532a;

    /* renamed from: b, reason: collision with root package name */
    public final int f40533b;

    /* renamed from: d, reason: collision with root package name */
    public PopupNestedScrollingLayout f40535d;

    /* renamed from: g, reason: collision with root package name */
    public m f40538g;

    /* renamed from: h, reason: collision with root package name */
    public stepos.support.v7.app.a f40539h;

    /* renamed from: i, reason: collision with root package name */
    public LitePopupContentFrameLayout f40540i;

    /* renamed from: j, reason: collision with root package name */
    public LinearLayout f40541j;

    /* renamed from: k, reason: collision with root package name */
    public int f40542k;

    /* renamed from: l, reason: collision with root package name */
    public AnimatorSet f40543l;

    /* renamed from: m, reason: collision with root package name */
    public androidx.dynamicanimation.animation.i f40544m;

    /* renamed from: n, reason: collision with root package name */
    public List<l.b> f40545n;

    /* renamed from: p, reason: collision with root package name */
    public Window f40547p;

    /* renamed from: c, reason: collision with root package name */
    public boolean f40534c = true;

    /* renamed from: e, reason: collision with root package name */
    public int f40536e = 0;

    /* renamed from: f, reason: collision with root package name */
    public boolean f40537f = true;

    /* renamed from: o, reason: collision with root package name */
    public l.a f40546o = new a();

    public class a implements l.a {
        public a() {
        }

        @Override // stepos.support.v7.app.l.a
        public void a(boolean z10) {
            n.this.f40538g.z();
            n.this.f40538g.s(z10);
        }

        @Override // stepos.support.v7.app.l.a
        public void b() {
            n.this.f40538g.A();
        }

        @Override // stepos.support.v7.app.l.a
        public void c(float f10) {
            n.this.q(f10);
            n.this.f40538g.y(f10);
        }
    }

    public class b implements PopupNestedScrollingLayout.e {
        public b() {
        }

        @Override // stepos.support.v7.widget.PopupNestedScrollingLayout.e
        public void a(int i10) {
            n.this.i(i10);
        }
    }

    public class c implements ViewTreeObserver.OnPreDrawListener {
        public c() {
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            n.this.f40535d.getViewTreeObserver().removeOnPreDrawListener(this);
            n.this.p();
            return true;
        }
    }

    public class d extends AnimatorListenerAdapter {
        public d() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            if (n.this.k()) {
                return;
            }
            o.f().b();
        }
    }

    public class e extends AnimatorListenerAdapter {
        public e() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            n.this.f40538g.B();
            n.this.f40538g.overridePendingTransition(0, 0);
            n.this.f40543l = null;
            o.f().h();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            if (n.this.k()) {
                return;
            }
            Log.d("popup_stack", " top stack start exit Anim, try to call bottom stack do stackExit ");
            o.f().c();
        }
    }

    public n(m mVar) {
        this.f40538g = mVar;
        this.f40547p = mVar.getWindow();
        PopupNestedScrollingLayout popupNestedScrollingLayout = (PopupNestedScrollingLayout) this.f40538g.findViewById(R$id.nested_scrolling_layout);
        this.f40535d = popupNestedScrollingLayout;
        popupNestedScrollingLayout.setUncollapsibleHeight(this.f40538g.getResources().getDimensionPixelSize(R$dimen.stepos_lite_popup_middle_state_height));
        this.f40539h = this.f40538g.getSupportActionBar();
        this.f40540i = (LitePopupContentFrameLayout) this.f40538g.findViewById(R.id.content);
        this.f40532a = new ColorDrawable(this.f40538g.getResources().getColor(R$color.stepos_lite_popup_window_dim));
        this.f40541j = (LinearLayout) this.f40538g.findViewById(R$id.action_bar_container);
        this.f40535d.setOnDismissedListener(this.f40546o);
        this.f40533b = 255;
        this.f40542k = 255;
        this.f40544m = new androidx.dynamicanimation.animation.i(this.f40535d, androidx.dynamicanimation.animation.e.f13691o);
        this.f40535d.setScrollListener(new b());
    }

    @Override // stepos.support.v7.app.l
    public void a(int i10) {
        this.f40536e = i10;
        PopupNestedScrollingLayout popupNestedScrollingLayout = this.f40535d;
        if (popupNestedScrollingLayout != null) {
            popupNestedScrollingLayout.setStyle(i10);
        }
    }

    public final void i(int i10) {
        List<l.b> list = this.f40545n;
        if (list != null) {
            Iterator<l.b> it = list.iterator();
            while (it.hasNext()) {
                it.next().a(i10);
            }
        }
    }

    public boolean j() throws Settings.SettingNotFoundException {
        float f10;
        try {
            f10 = Settings.Global.getFloat(this.f40538g.getContentResolver(), "transition_animation_scale");
        } catch (Exception unused) {
            f10 = 1.0f;
        }
        return f10 != 0.0f;
    }

    public final boolean k() {
        return o.f().e() == this.f40538g;
    }

    public void l() {
        this.f40538g.getWindow().setBackgroundDrawable(this.f40532a);
        this.f40535d.getViewTreeObserver().addOnPreDrawListener(new c());
        this.f40538g.overridePendingTransition(0, 0);
        this.f40547p.setDecorFitsSystemWindows(false);
    }

    public void m() {
        AnimatorSet animatorSet = this.f40543l;
        if (animatorSet == null || !animatorSet.isRunning()) {
            this.f40543l = new AnimatorSet();
            int uncollapsibleHeight = this.f40535d.getCurrentScrollY() <= 0 ? this.f40535d.getUncollapsibleHeight() : this.f40535d.getMeasuredHeight();
            this.f40544m.B(new androidx.dynamicanimation.animation.j().f(o.f40556j).h(o.f40557k));
            float f10 = uncollapsibleHeight;
            this.f40544m.y().g(f10);
            if (j()) {
                this.f40544m.t();
            } else {
                this.f40535d.setTranslationY(f10);
            }
            ObjectAnimator objectAnimatorOfInt = ObjectAnimator.ofInt(this.f40532a, ConstConfig.KEY_VIEW_ALPHA_PROPERTY, this.f40542k, 0);
            objectAnimatorOfInt.setInterpolator(f40531s);
            objectAnimatorOfInt.setDuration(300L);
            this.f40543l.playTogether(objectAnimatorOfInt);
            this.f40543l.addListener(new e());
            this.f40543l.start();
        }
    }

    public void n() {
        if (k()) {
            Log.d("popup_stack", " bottom stack resume, to reset state ");
            o.f().d();
        }
    }

    public void o() {
        if (this.f40534c) {
            this.f40538g.C();
        }
    }

    public final void p() {
        AnimatorSet animatorSet = new AnimatorSet();
        this.f40535d.setTranslationY(this.f40535d.getCurrentScrollY() <= 0 ? this.f40535d.getUncollapsibleHeight() : this.f40535d.getMeasuredHeight());
        this.f40544m.B(new androidx.dynamicanimation.animation.j().f(o.f40554h).h(o.f40555i));
        this.f40544m.y().g(0.0f);
        if (j()) {
            this.f40544m.t();
        } else {
            this.f40535d.setTranslationY(0.0f);
        }
        ObjectAnimator objectAnimatorOfInt = ObjectAnimator.ofInt(this.f40532a, ConstConfig.KEY_VIEW_ALPHA_PROPERTY, 0, this.f40533b);
        objectAnimatorOfInt.setInterpolator(f40531s);
        objectAnimatorOfInt.setDuration(100L);
        animatorSet.addListener(new d());
        animatorSet.playTogether(objectAnimatorOfInt);
        animatorSet.start();
    }

    public final void q(float f10) {
        int i10 = (int) (this.f40533b * (1.0f - f10));
        this.f40532a.setAlpha(i10);
        this.f40542k = i10;
    }
}
