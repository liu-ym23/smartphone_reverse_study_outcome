package com.google.android.material.snackbar;

import a1.C0409b;
import a1.C0411d;
import a1.C0418k;
import android.accessibilityservice.AccessibilityServiceInfo;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.WindowInsets;
import android.view.accessibility.AccessibilityManager;
import android.widget.FrameLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import b1.C0553a;
import com.google.android.material.behavior.SwipeDismissBehavior;
import com.google.android.material.internal.r;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.b;
import j1.C0777a;
import java.util.List;
import q1.C0981c;
import t1.C1115h;
import x1.C1282a;

/* loaded from: classes.dex */
public abstract class BaseTransientBottomBar<B extends BaseTransientBottomBar<B>> {

    /* renamed from: a, reason: collision with root package name */
    private final int f13148a;

    /* renamed from: b, reason: collision with root package name */
    private final int f13149b;

    /* renamed from: c, reason: collision with root package name */
    private final int f13150c;

    /* renamed from: d, reason: collision with root package name */
    private final TimeInterpolator f13151d;

    /* renamed from: e, reason: collision with root package name */
    private final TimeInterpolator f13152e;

    /* renamed from: f, reason: collision with root package name */
    private final TimeInterpolator f13153f;

    /* renamed from: g, reason: collision with root package name */
    private final ViewGroup f13154g;

    /* renamed from: h, reason: collision with root package name */
    protected final o f13155h;

    /* renamed from: i, reason: collision with root package name */
    private final com.google.android.material.snackbar.a f13156i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f13157j;

    /* renamed from: k, reason: collision with root package name */
    private final Runnable f13158k;

    /* renamed from: l, reason: collision with root package name */
    private int f13159l;

    /* renamed from: m, reason: collision with root package name */
    private int f13160m;

    /* renamed from: n, reason: collision with root package name */
    private int f13161n;

    /* renamed from: o, reason: collision with root package name */
    private int f13162o;

    /* renamed from: p, reason: collision with root package name */
    private int f13163p;

    /* renamed from: q, reason: collision with root package name */
    private int f13164q;

    /* renamed from: r, reason: collision with root package name */
    private boolean f13165r;

    /* renamed from: s, reason: collision with root package name */
    private List<m<B>> f13166s;

    /* renamed from: t, reason: collision with root package name */
    private Behavior f13167t;

    /* renamed from: u, reason: collision with root package name */
    private final AccessibilityManager f13168u;

    /* renamed from: v, reason: collision with root package name */
    b.InterfaceC0171b f13169v;

    /* renamed from: w, reason: collision with root package name */
    private static final TimeInterpolator f13144w = C0553a.f11784b;

    /* renamed from: x, reason: collision with root package name */
    private static final TimeInterpolator f13145x = C0553a.f11783a;

    /* renamed from: y, reason: collision with root package name */
    private static final TimeInterpolator f13146y = C0553a.f11786d;

    /* renamed from: A, reason: collision with root package name */
    private static final int[] f13142A = {C0409b.f6703M};

    /* renamed from: B, reason: collision with root package name */
    private static final String f13143B = BaseTransientBottomBar.class.getSimpleName();

    /* renamed from: z, reason: collision with root package name */
    static final Handler f13147z = new Handler(Looper.getMainLooper(), new h());

    public static class Behavior extends SwipeDismissBehavior<View> {

        /* renamed from: l, reason: collision with root package name */
        private final n f13170l = new n(this);

        /* JADX INFO: Access modifiers changed from: private */
        public void o(BaseTransientBottomBar<?> baseTransientBottomBar) {
            this.f13170l.c(baseTransientBottomBar);
        }

        @Override // com.google.android.material.behavior.SwipeDismissBehavior
        public boolean d(View view) {
            return this.f13170l.a(view);
        }

        @Override // com.google.android.material.behavior.SwipeDismissBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public boolean onInterceptTouchEvent(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
            this.f13170l.b(coordinatorLayout, view, motionEvent);
            return super.onInterceptTouchEvent(coordinatorLayout, view, motionEvent);
        }
    }

    class a extends AnimatorListenerAdapter {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f13171a;

        a(int i5) {
            this.f13171a = i5;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            BaseTransientBottomBar.this.A(this.f13171a);
        }
    }

    class b implements ValueAnimator.AnimatorUpdateListener {
        b() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            BaseTransientBottomBar.this.f13155h.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
        }
    }

    class c implements ValueAnimator.AnimatorUpdateListener {
        c() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            BaseTransientBottomBar.this.f13155h.setScaleX(fFloatValue);
            BaseTransientBottomBar.this.f13155h.setScaleY(fFloatValue);
        }
    }

    class d extends AnimatorListenerAdapter {
        d() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            BaseTransientBottomBar.this.B();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            BaseTransientBottomBar.this.f13156i.a(BaseTransientBottomBar.this.f13150c - BaseTransientBottomBar.this.f13148a, BaseTransientBottomBar.this.f13148a);
        }
    }

    class e implements ValueAnimator.AnimatorUpdateListener {
        e() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            BaseTransientBottomBar.this.f13155h.setTranslationY(((Integer) valueAnimator.getAnimatedValue()).intValue());
        }
    }

    class f extends AnimatorListenerAdapter {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f13177a;

        f(int i5) {
            this.f13177a = i5;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            BaseTransientBottomBar.this.A(this.f13177a);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            BaseTransientBottomBar.this.f13156i.b(0, BaseTransientBottomBar.this.f13149b);
        }
    }

    class g implements ValueAnimator.AnimatorUpdateListener {
        g() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            BaseTransientBottomBar.this.f13155h.setTranslationY(((Integer) valueAnimator.getAnimatedValue()).intValue());
        }
    }

    class h implements Handler.Callback {
        h() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i5 = message.what;
            if (i5 == 0) {
                ((BaseTransientBottomBar) message.obj).G();
                return true;
            }
            if (i5 != 1) {
                return false;
            }
            ((BaseTransientBottomBar) message.obj).u(message.arg1);
            return true;
        }
    }

    class i implements Runnable {
        i() {
        }

        @Override // java.lang.Runnable
        public void run() {
            BaseTransientBottomBar.this.A(3);
        }
    }

    class j implements SwipeDismissBehavior.c {
        j() {
        }

        @Override // com.google.android.material.behavior.SwipeDismissBehavior.c
        public void a(View view) {
            if (view.getParent() != null) {
                view.setVisibility(8);
            }
            BaseTransientBottomBar.this.o(0);
        }

        @Override // com.google.android.material.behavior.SwipeDismissBehavior.c
        public void b(int i5) {
            if (i5 == 0) {
                com.google.android.material.snackbar.b.c().k(BaseTransientBottomBar.this.f13169v);
            } else if (i5 == 1 || i5 == 2) {
                com.google.android.material.snackbar.b.c().j(BaseTransientBottomBar.this.f13169v);
            }
        }
    }

    class k implements Runnable {
        k() {
        }

        @Override // java.lang.Runnable
        public void run() {
            o oVar = BaseTransientBottomBar.this.f13155h;
            if (oVar == null) {
                return;
            }
            if (oVar.getParent() != null) {
                BaseTransientBottomBar.this.f13155h.setVisibility(0);
            }
            if (BaseTransientBottomBar.this.f13155h.getAnimationMode() == 1) {
                BaseTransientBottomBar.this.I();
            } else {
                BaseTransientBottomBar.this.K();
            }
        }
    }

    class l extends AnimatorListenerAdapter {
        l() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            BaseTransientBottomBar.this.B();
        }
    }

    public static abstract class m<B> {
        public void a(B b6, int i5) {
        }

        public void b(B b6) {
        }
    }

    public static class n {

        /* renamed from: a, reason: collision with root package name */
        private b.InterfaceC0171b f13184a;

        public n(SwipeDismissBehavior<?> swipeDismissBehavior) {
            swipeDismissBehavior.k(0.1f);
            swipeDismissBehavior.i(0.6f);
            swipeDismissBehavior.l(0);
        }

        public boolean a(View view) {
            return view instanceof o;
        }

        public void b(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
            int actionMasked = motionEvent.getActionMasked();
            if (actionMasked == 0) {
                if (coordinatorLayout.O(view, (int) motionEvent.getX(), (int) motionEvent.getY())) {
                    com.google.android.material.snackbar.b.c().j(this.f13184a);
                }
            } else if (actionMasked == 1 || actionMasked == 3) {
                com.google.android.material.snackbar.b.c().k(this.f13184a);
            }
        }

        public void c(BaseTransientBottomBar<?> baseTransientBottomBar) {
            this.f13184a = baseTransientBottomBar.f13169v;
        }
    }

    protected static class o extends FrameLayout {

        /* renamed from: l, reason: collision with root package name */
        private static final View.OnTouchListener f13185l = new a();

        /* renamed from: a, reason: collision with root package name */
        private BaseTransientBottomBar<?> f13186a;

        /* renamed from: b, reason: collision with root package name */
        t1.l f13187b;

        /* renamed from: c, reason: collision with root package name */
        private int f13188c;

        /* renamed from: d, reason: collision with root package name */
        private final float f13189d;

        /* renamed from: e, reason: collision with root package name */
        private final float f13190e;

        /* renamed from: f, reason: collision with root package name */
        private final int f13191f;

        /* renamed from: g, reason: collision with root package name */
        private final int f13192g;

        /* renamed from: h, reason: collision with root package name */
        private ColorStateList f13193h;

        /* renamed from: i, reason: collision with root package name */
        private PorterDuff.Mode f13194i;

        /* renamed from: j, reason: collision with root package name */
        private Rect f13195j;

        /* renamed from: k, reason: collision with root package name */
        private boolean f13196k;

        class a implements View.OnTouchListener {
            a() {
            }

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return true;
            }
        }

        protected o(Context context, AttributeSet attributeSet) {
            super(C1282a.d(context, attributeSet, 0, 0), attributeSet);
            Context context2 = getContext();
            TypedArray typedArrayObtainStyledAttributes = context2.obtainStyledAttributes(attributeSet, C0418k.f7203r4);
            if (typedArrayObtainStyledAttributes.hasValue(C0418k.f7245y4)) {
                setElevation(typedArrayObtainStyledAttributes.getDimensionPixelSize(r2, 0));
            }
            this.f13188c = typedArrayObtainStyledAttributes.getInt(C0418k.f7221u4, 0);
            if (typedArrayObtainStyledAttributes.hasValue(C0418k.f6940A4) || typedArrayObtainStyledAttributes.hasValue(C0418k.f6946B4)) {
                this.f13187b = t1.l.e(context2, attributeSet, 0, 0).m();
            }
            this.f13189d = typedArrayObtainStyledAttributes.getFloat(C0418k.f7227v4, 1.0f);
            setBackgroundTintList(C0981c.a(context2, typedArrayObtainStyledAttributes, C0418k.f7233w4));
            setBackgroundTintMode(r.h(typedArrayObtainStyledAttributes.getInt(C0418k.f7239x4, -1), PorterDuff.Mode.SRC_IN));
            this.f13190e = typedArrayObtainStyledAttributes.getFloat(C0418k.f7215t4, 1.0f);
            this.f13191f = typedArrayObtainStyledAttributes.getDimensionPixelSize(C0418k.f7209s4, -1);
            this.f13192g = typedArrayObtainStyledAttributes.getDimensionPixelSize(C0418k.f7251z4, -1);
            typedArrayObtainStyledAttributes.recycle();
            setOnTouchListener(f13185l);
            setFocusable(true);
            if (getBackground() == null) {
                setBackground(c());
            }
        }

        private Drawable c() {
            int iK = C0777a.k(this, C0409b.f6720g, C0409b.f6717d, getBackgroundOverlayColorAlpha());
            t1.l lVar = this.f13187b;
            Drawable drawableN = lVar != null ? BaseTransientBottomBar.n(iK, lVar) : BaseTransientBottomBar.m(iK, getResources());
            if (this.f13193h == null) {
                return androidx.core.graphics.drawable.a.r(drawableN);
            }
            Drawable drawableR = androidx.core.graphics.drawable.a.r(drawableN);
            drawableR.setTintList(this.f13193h);
            return drawableR;
        }

        private void d(ViewGroup.MarginLayoutParams marginLayoutParams) {
            this.f13195j = new Rect(marginLayoutParams.leftMargin, marginLayoutParams.topMargin, marginLayoutParams.rightMargin, marginLayoutParams.bottomMargin);
        }

        private void setBaseTransientBottomBar(BaseTransientBottomBar<?> baseTransientBottomBar) {
            this.f13186a = baseTransientBottomBar;
        }

        void b(ViewGroup viewGroup) {
            this.f13196k = true;
            viewGroup.addView(this);
            this.f13196k = false;
        }

        float getActionTextColorAlpha() {
            return this.f13190e;
        }

        int getAnimationMode() {
            return this.f13188c;
        }

        float getBackgroundOverlayColorAlpha() {
            return this.f13189d;
        }

        int getMaxInlineActionWidth() {
            return this.f13192g;
        }

        int getMaxWidth() {
            return this.f13191f;
        }

        @Override // android.view.ViewGroup, android.view.View
        protected void onAttachedToWindow() {
            super.onAttachedToWindow();
            BaseTransientBottomBar<?> baseTransientBottomBar = this.f13186a;
            if (baseTransientBottomBar != null) {
                baseTransientBottomBar.x();
            }
            requestApplyInsets();
        }

        @Override // android.view.ViewGroup, android.view.View
        protected void onDetachedFromWindow() {
            super.onDetachedFromWindow();
            BaseTransientBottomBar<?> baseTransientBottomBar = this.f13186a;
            if (baseTransientBottomBar != null) {
                baseTransientBottomBar.y();
            }
        }

        @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
        protected void onLayout(boolean z5, int i5, int i6, int i7, int i8) {
            super.onLayout(z5, i5, i6, i7, i8);
            BaseTransientBottomBar<?> baseTransientBottomBar = this.f13186a;
            if (baseTransientBottomBar != null) {
                baseTransientBottomBar.z();
            }
        }

        @Override // android.widget.FrameLayout, android.view.View
        protected void onMeasure(int i5, int i6) {
            super.onMeasure(i5, i6);
            if (this.f13191f > 0) {
                int measuredWidth = getMeasuredWidth();
                int i7 = this.f13191f;
                if (measuredWidth > i7) {
                    super.onMeasure(View.MeasureSpec.makeMeasureSpec(i7, 1073741824), i6);
                }
            }
        }

        void setAnimationMode(int i5) {
            this.f13188c = i5;
        }

        @Override // android.view.View
        public void setBackground(Drawable drawable) {
            setBackgroundDrawable(drawable);
        }

        @Override // android.view.View
        public void setBackgroundDrawable(Drawable drawable) {
            if (drawable != null && this.f13193h != null) {
                drawable = androidx.core.graphics.drawable.a.r(drawable.mutate());
                drawable.setTintList(this.f13193h);
                drawable.setTintMode(this.f13194i);
            }
            super.setBackgroundDrawable(drawable);
        }

        @Override // android.view.View
        public void setBackgroundTintList(ColorStateList colorStateList) {
            this.f13193h = colorStateList;
            if (getBackground() != null) {
                Drawable drawableR = androidx.core.graphics.drawable.a.r(getBackground().mutate());
                drawableR.setTintList(colorStateList);
                drawableR.setTintMode(this.f13194i);
                if (drawableR != getBackground()) {
                    super.setBackgroundDrawable(drawableR);
                }
            }
        }

        @Override // android.view.View
        public void setBackgroundTintMode(PorterDuff.Mode mode) {
            this.f13194i = mode;
            if (getBackground() != null) {
                Drawable drawableR = androidx.core.graphics.drawable.a.r(getBackground().mutate());
                drawableR.setTintMode(mode);
                if (drawableR != getBackground()) {
                    super.setBackgroundDrawable(drawableR);
                }
            }
        }

        @Override // android.view.View
        public void setLayoutParams(ViewGroup.LayoutParams layoutParams) {
            super.setLayoutParams(layoutParams);
            if (this.f13196k || !(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
                return;
            }
            d((ViewGroup.MarginLayoutParams) layoutParams);
            BaseTransientBottomBar<?> baseTransientBottomBar = this.f13186a;
            if (baseTransientBottomBar != null) {
                baseTransientBottomBar.M();
            }
        }

        @Override // android.view.View
        public void setOnClickListener(View.OnClickListener onClickListener) {
            setOnTouchListener(onClickListener != null ? null : f13185l);
            super.setOnClickListener(onClickListener);
        }
    }

    private void C() {
        this.f13162o = l();
        M();
    }

    private void D(CoordinatorLayout.f fVar) {
        SwipeDismissBehavior<? extends View> swipeDismissBehaviorR = this.f13167t;
        if (swipeDismissBehaviorR == null) {
            swipeDismissBehaviorR = r();
        }
        if (swipeDismissBehaviorR instanceof Behavior) {
            ((Behavior) swipeDismissBehaviorR).o(this);
        }
        swipeDismissBehaviorR.j(new j());
        fVar.o(swipeDismissBehaviorR);
        if (q() == null) {
            fVar.f9431g = 80;
        }
    }

    private boolean F() {
        return this.f13163p > 0 && !this.f13157j && w();
    }

    private void H() {
        if (E()) {
            j();
            return;
        }
        if (this.f13155h.getParent() != null) {
            this.f13155h.setVisibility(0);
        }
        B();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void I() {
        ValueAnimator valueAnimatorP = p(0.0f, 1.0f);
        ValueAnimator valueAnimatorS = s(0.8f, 1.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(valueAnimatorP, valueAnimatorS);
        animatorSet.setDuration(this.f13148a);
        animatorSet.addListener(new l());
        animatorSet.start();
    }

    private void J(int i5) {
        ValueAnimator valueAnimatorP = p(1.0f, 0.0f);
        valueAnimatorP.setDuration(this.f13149b);
        valueAnimatorP.addListener(new a(i5));
        valueAnimatorP.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void K() {
        int iT = t();
        this.f13155h.setTranslationY(iT);
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setIntValues(iT, 0);
        valueAnimator.setInterpolator(this.f13152e);
        valueAnimator.setDuration(this.f13150c);
        valueAnimator.addListener(new d());
        valueAnimator.addUpdateListener(new e());
        valueAnimator.start();
    }

    private void L(int i5) {
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setIntValues(0, t());
        valueAnimator.setInterpolator(this.f13152e);
        valueAnimator.setDuration(this.f13150c);
        valueAnimator.addListener(new f(i5));
        valueAnimator.addUpdateListener(new g());
        valueAnimator.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void M() {
        ViewGroup.LayoutParams layoutParams = this.f13155h.getLayoutParams();
        if (!(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
            Log.w(f13143B, "Unable to update margins because layout params are not MarginLayoutParams");
            return;
        }
        if (this.f13155h.f13195j == null) {
            Log.w(f13143B, "Unable to update margins because original view margins are not set");
            return;
        }
        if (this.f13155h.getParent() == null) {
            return;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        int i5 = this.f13155h.f13195j.bottom + (q() != null ? this.f13162o : this.f13159l);
        int i6 = this.f13155h.f13195j.left + this.f13160m;
        int i7 = this.f13155h.f13195j.right + this.f13161n;
        int i8 = this.f13155h.f13195j.top;
        boolean z5 = (marginLayoutParams.bottomMargin == i5 && marginLayoutParams.leftMargin == i6 && marginLayoutParams.rightMargin == i7 && marginLayoutParams.topMargin == i8) ? false : true;
        if (z5) {
            marginLayoutParams.bottomMargin = i5;
            marginLayoutParams.leftMargin = i6;
            marginLayoutParams.rightMargin = i7;
            marginLayoutParams.topMargin = i8;
            this.f13155h.requestLayout();
        }
        if ((z5 || this.f13164q != this.f13163p) && F()) {
            this.f13155h.removeCallbacks(this.f13158k);
            this.f13155h.post(this.f13158k);
        }
    }

    private void k(int i5) {
        if (this.f13155h.getAnimationMode() == 1) {
            J(i5);
        } else {
            L(i5);
        }
    }

    private int l() {
        if (q() == null) {
            return 0;
        }
        int[] iArr = new int[2];
        q().getLocationOnScreen(iArr);
        int i5 = iArr[1];
        int[] iArr2 = new int[2];
        this.f13154g.getLocationOnScreen(iArr2);
        return (iArr2[1] + this.f13154g.getHeight()) - i5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static GradientDrawable m(int i5, Resources resources) throws Resources.NotFoundException {
        float dimension = resources.getDimension(C0411d.f6781e0);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setCornerRadius(dimension);
        gradientDrawable.setColor(i5);
        return gradientDrawable;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static C1115h n(int i5, t1.l lVar) {
        C1115h c1115h = new C1115h(lVar);
        c1115h.g0(ColorStateList.valueOf(i5));
        return c1115h;
    }

    private ValueAnimator p(float... fArr) {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(fArr);
        valueAnimatorOfFloat.setInterpolator(this.f13151d);
        valueAnimatorOfFloat.addUpdateListener(new b());
        return valueAnimatorOfFloat;
    }

    private ValueAnimator s(float... fArr) {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(fArr);
        valueAnimatorOfFloat.setInterpolator(this.f13153f);
        valueAnimatorOfFloat.addUpdateListener(new c());
        return valueAnimatorOfFloat;
    }

    private int t() {
        int height = this.f13155h.getHeight();
        ViewGroup.LayoutParams layoutParams = this.f13155h.getLayoutParams();
        return layoutParams instanceof ViewGroup.MarginLayoutParams ? height + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin : height;
    }

    private boolean w() {
        ViewGroup.LayoutParams layoutParams = this.f13155h.getLayoutParams();
        return (layoutParams instanceof CoordinatorLayout.f) && (((CoordinatorLayout.f) layoutParams).f() instanceof SwipeDismissBehavior);
    }

    void A(int i5) {
        com.google.android.material.snackbar.b.c().h(this.f13169v);
        List<m<B>> list = this.f13166s;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.f13166s.get(size).a(this, i5);
            }
        }
        ViewParent parent = this.f13155h.getParent();
        if (parent instanceof ViewGroup) {
            ((ViewGroup) parent).removeView(this.f13155h);
        }
    }

    void B() {
        com.google.android.material.snackbar.b.c().i(this.f13169v);
        List<m<B>> list = this.f13166s;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.f13166s.get(size).b(this);
            }
        }
    }

    boolean E() {
        AccessibilityManager accessibilityManager = this.f13168u;
        if (accessibilityManager == null) {
            return true;
        }
        List<AccessibilityServiceInfo> enabledAccessibilityServiceList = accessibilityManager.getEnabledAccessibilityServiceList(1);
        return enabledAccessibilityServiceList != null && enabledAccessibilityServiceList.isEmpty();
    }

    final void G() {
        if (this.f13155h.getParent() == null) {
            ViewGroup.LayoutParams layoutParams = this.f13155h.getLayoutParams();
            if (layoutParams instanceof CoordinatorLayout.f) {
                D((CoordinatorLayout.f) layoutParams);
            }
            this.f13155h.b(this.f13154g);
            C();
            this.f13155h.setVisibility(4);
        }
        if (this.f13155h.isLaidOut()) {
            H();
        } else {
            this.f13165r = true;
        }
    }

    void j() {
        this.f13155h.post(new k());
    }

    protected void o(int i5) {
        com.google.android.material.snackbar.b.c().b(this.f13169v, i5);
    }

    public View q() {
        return null;
    }

    protected SwipeDismissBehavior<? extends View> r() {
        return new Behavior();
    }

    final void u(int i5) {
        if (E() && this.f13155h.getVisibility() == 0) {
            k(i5);
        } else {
            A(i5);
        }
    }

    public boolean v() {
        return com.google.android.material.snackbar.b.c().e(this.f13169v);
    }

    void x() {
        WindowInsets rootWindowInsets = this.f13155h.getRootWindowInsets();
        if (rootWindowInsets != null) {
            this.f13163p = rootWindowInsets.getMandatorySystemGestureInsets().bottom;
            M();
        }
    }

    void y() {
        if (v()) {
            f13147z.post(new i());
        }
    }

    void z() {
        if (this.f13165r) {
            H();
            this.f13165r = false;
        }
    }
}
