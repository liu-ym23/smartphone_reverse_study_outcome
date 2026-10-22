package com.google.android.material.snackbar;

import a3.InterfaceC1226a;
import android.accessibilityservice.AccessibilityServiceInfo;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
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
import com.google.android.material.R$attr;
import com.google.android.material.R$dimen;
import com.google.android.material.R$styleable;
import com.google.android.material.behavior.SwipeDismissBehavior;
import com.google.android.material.internal.u;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.a;
import d3.C3953a;
import java.util.List;
import u0.C5566a;

/* loaded from: classes2.dex */
public abstract class BaseTransientBottomBar<B extends BaseTransientBottomBar<B>> {

    /* renamed from: a, reason: collision with root package name */
    public final int f21313a;

    /* renamed from: b, reason: collision with root package name */
    public final int f21314b;

    /* renamed from: c, reason: collision with root package name */
    public final int f21315c;

    /* renamed from: d, reason: collision with root package name */
    public final TimeInterpolator f21316d;

    /* renamed from: e, reason: collision with root package name */
    public final TimeInterpolator f21317e;

    /* renamed from: f, reason: collision with root package name */
    public final TimeInterpolator f21318f;

    /* renamed from: g, reason: collision with root package name */
    public final ViewGroup f21319g;

    /* renamed from: h, reason: collision with root package name */
    public final o f21320h;

    /* renamed from: i, reason: collision with root package name */
    public final InterfaceC1226a f21321i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f21322j;

    /* renamed from: k, reason: collision with root package name */
    public final Runnable f21323k;

    /* renamed from: l, reason: collision with root package name */
    public int f21324l;

    /* renamed from: m, reason: collision with root package name */
    public int f21325m;

    /* renamed from: n, reason: collision with root package name */
    public int f21326n;

    /* renamed from: o, reason: collision with root package name */
    public int f21327o;

    /* renamed from: p, reason: collision with root package name */
    public int f21328p;

    /* renamed from: q, reason: collision with root package name */
    public int f21329q;

    /* renamed from: r, reason: collision with root package name */
    public boolean f21330r;

    /* renamed from: s, reason: collision with root package name */
    public List<m<B>> f21331s;

    /* renamed from: t, reason: collision with root package name */
    public Behavior f21332t;

    /* renamed from: u, reason: collision with root package name */
    public final AccessibilityManager f21333u;

    /* renamed from: v, reason: collision with root package name */
    public a.b f21334v;

    /* renamed from: w, reason: collision with root package name */
    public static final TimeInterpolator f21309w = E2.a.f2340b;

    /* renamed from: x, reason: collision with root package name */
    public static final TimeInterpolator f21310x = E2.a.f2339a;

    /* renamed from: y, reason: collision with root package name */
    public static final TimeInterpolator f21311y = E2.a.f2342d;

    /* renamed from: A, reason: collision with root package name */
    public static final int[] f21307A = {R$attr.snackbarStyle};

    /* renamed from: B, reason: collision with root package name */
    public static final String f21308B = BaseTransientBottomBar.class.getSimpleName();

    /* renamed from: z, reason: collision with root package name */
    public static final Handler f21312z = new Handler(Looper.getMainLooper(), new h());

    public static class Behavior extends SwipeDismissBehavior<View> {

        /* renamed from: l, reason: collision with root package name */
        public final n f21335l = new n(this);

        @Override // com.google.android.material.behavior.SwipeDismissBehavior
        public boolean h(View view) {
            return this.f21335l.a(view);
        }

        @Override // com.google.android.material.behavior.SwipeDismissBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public boolean onInterceptTouchEvent(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
            this.f21335l.b(coordinatorLayout, view, motionEvent);
            return super.onInterceptTouchEvent(coordinatorLayout, view, motionEvent);
        }

        public final void s(BaseTransientBottomBar<?> baseTransientBottomBar) {
            this.f21335l.c(baseTransientBottomBar);
        }
    }

    public class a extends AnimatorListenerAdapter {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f21336a;

        public a(int i10) {
            this.f21336a = i10;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            BaseTransientBottomBar.this.A(this.f21336a);
        }
    }

    public class b implements ValueAnimator.AnimatorUpdateListener {
        public b() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            BaseTransientBottomBar.this.f21320h.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
        }
    }

    public class c implements ValueAnimator.AnimatorUpdateListener {
        public c() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            BaseTransientBottomBar.this.f21320h.setScaleX(fFloatValue);
            BaseTransientBottomBar.this.f21320h.setScaleY(fFloatValue);
        }
    }

    public class d extends AnimatorListenerAdapter {
        public d() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            BaseTransientBottomBar.this.B();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            BaseTransientBottomBar.this.f21321i.a(BaseTransientBottomBar.this.f21315c - BaseTransientBottomBar.this.f21313a, BaseTransientBottomBar.this.f21313a);
        }
    }

    public class e implements ValueAnimator.AnimatorUpdateListener {
        public e() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            BaseTransientBottomBar.this.f21320h.setTranslationY(((Integer) valueAnimator.getAnimatedValue()).intValue());
        }
    }

    public class f extends AnimatorListenerAdapter {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f21342a;

        public f(int i10) {
            this.f21342a = i10;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            BaseTransientBottomBar.this.A(this.f21342a);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            BaseTransientBottomBar.this.f21321i.b(0, BaseTransientBottomBar.this.f21314b);
        }
    }

    public class g implements ValueAnimator.AnimatorUpdateListener {
        public g() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            BaseTransientBottomBar.this.f21320h.setTranslationY(((Integer) valueAnimator.getAnimatedValue()).intValue());
        }
    }

    public class h implements Handler.Callback {
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i10 = message.what;
            if (i10 == 0) {
                ((BaseTransientBottomBar) message.obj).G();
                return true;
            }
            if (i10 != 1) {
                return false;
            }
            ((BaseTransientBottomBar) message.obj).u(message.arg1);
            return true;
        }
    }

    public class i implements Runnable {
        public i() {
        }

        @Override // java.lang.Runnable
        public void run() {
            BaseTransientBottomBar.this.A(3);
        }
    }

    public class j implements SwipeDismissBehavior.c {
        public j() {
        }

        @Override // com.google.android.material.behavior.SwipeDismissBehavior.c
        public void a(View view) {
            if (view.getParent() != null) {
                view.setVisibility(8);
            }
            BaseTransientBottomBar.this.o(0);
        }

        @Override // com.google.android.material.behavior.SwipeDismissBehavior.c
        public void b(int i10) {
            if (i10 == 0) {
                com.google.android.material.snackbar.a.c().k(BaseTransientBottomBar.this.f21334v);
            } else if (i10 == 1 || i10 == 2) {
                com.google.android.material.snackbar.a.c().j(BaseTransientBottomBar.this.f21334v);
            }
        }
    }

    public class k implements Runnable {
        public k() {
        }

        @Override // java.lang.Runnable
        public void run() {
            o oVar = BaseTransientBottomBar.this.f21320h;
            if (oVar == null) {
                return;
            }
            if (oVar.getParent() != null) {
                BaseTransientBottomBar.this.f21320h.setVisibility(0);
            }
            if (BaseTransientBottomBar.this.f21320h.getAnimationMode() == 1) {
                BaseTransientBottomBar.this.I();
            } else {
                BaseTransientBottomBar.this.K();
            }
        }
    }

    public class l extends AnimatorListenerAdapter {
        public l() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            BaseTransientBottomBar.this.B();
        }
    }

    public static abstract class m<B> {
        public void a(B b10, int i10) {
        }

        public void b(B b10) {
        }
    }

    public static class n {

        /* renamed from: a, reason: collision with root package name */
        public a.b f21349a;

        public n(SwipeDismissBehavior<?> swipeDismissBehavior) {
            swipeDismissBehavior.o(0.1f);
            swipeDismissBehavior.m(0.6f);
            swipeDismissBehavior.p(0);
        }

        public boolean a(View view) {
            return view instanceof o;
        }

        public void b(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
            int actionMasked = motionEvent.getActionMasked();
            if (actionMasked == 0) {
                if (coordinatorLayout.I(view, (int) motionEvent.getX(), (int) motionEvent.getY())) {
                    com.google.android.material.snackbar.a.c().j(this.f21349a);
                }
            } else if (actionMasked == 1 || actionMasked == 3) {
                com.google.android.material.snackbar.a.c().k(this.f21349a);
            }
        }

        public void c(BaseTransientBottomBar<?> baseTransientBottomBar) {
            this.f21349a = baseTransientBottomBar.f21334v;
        }
    }

    public static class o extends FrameLayout {

        /* renamed from: l, reason: collision with root package name */
        public static final View.OnTouchListener f21350l = new a();

        /* renamed from: a, reason: collision with root package name */
        public BaseTransientBottomBar<?> f21351a;

        /* renamed from: b, reason: collision with root package name */
        public Z2.l f21352b;

        /* renamed from: c, reason: collision with root package name */
        public int f21353c;

        /* renamed from: d, reason: collision with root package name */
        public final float f21354d;

        /* renamed from: e, reason: collision with root package name */
        public final float f21355e;

        /* renamed from: f, reason: collision with root package name */
        public final int f21356f;

        /* renamed from: g, reason: collision with root package name */
        public final int f21357g;

        /* renamed from: h, reason: collision with root package name */
        public ColorStateList f21358h;

        /* renamed from: i, reason: collision with root package name */
        public PorterDuff.Mode f21359i;

        /* renamed from: j, reason: collision with root package name */
        public Rect f21360j;

        /* renamed from: k, reason: collision with root package name */
        public boolean f21361k;

        public class a implements View.OnTouchListener {
            @Override // android.view.View.OnTouchListener
            @SuppressLint({"ClickableViewAccessibility"})
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return true;
            }
        }

        public o(Context context, AttributeSet attributeSet) {
            super(C3953a.d(context, attributeSet, 0, 0), attributeSet);
            Context context2 = getContext();
            TypedArray typedArrayObtainStyledAttributes = context2.obtainStyledAttributes(attributeSet, R$styleable.SnackbarLayout);
            if (typedArrayObtainStyledAttributes.hasValue(R$styleable.SnackbarLayout_elevation)) {
                setElevation(typedArrayObtainStyledAttributes.getDimensionPixelSize(r2, 0));
            }
            this.f21353c = typedArrayObtainStyledAttributes.getInt(R$styleable.SnackbarLayout_animationMode, 0);
            if (typedArrayObtainStyledAttributes.hasValue(R$styleable.SnackbarLayout_shapeAppearance) || typedArrayObtainStyledAttributes.hasValue(R$styleable.SnackbarLayout_shapeAppearanceOverlay)) {
                this.f21352b = Z2.l.e(context2, attributeSet, 0, 0).m();
            }
            this.f21354d = typedArrayObtainStyledAttributes.getFloat(R$styleable.SnackbarLayout_backgroundOverlayColorAlpha, 1.0f);
            setBackgroundTintList(W2.c.a(context2, typedArrayObtainStyledAttributes, R$styleable.SnackbarLayout_backgroundTint));
            setBackgroundTintMode(u.i(typedArrayObtainStyledAttributes.getInt(R$styleable.SnackbarLayout_backgroundTintMode, -1), PorterDuff.Mode.SRC_IN));
            this.f21355e = typedArrayObtainStyledAttributes.getFloat(R$styleable.SnackbarLayout_actionTextColorAlpha, 1.0f);
            this.f21356f = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.SnackbarLayout_android_maxWidth, -1);
            this.f21357g = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.SnackbarLayout_maxActionInlineWidth, -1);
            typedArrayObtainStyledAttributes.recycle();
            setOnTouchListener(f21350l);
            setFocusable(true);
            if (getBackground() == null) {
                setBackground(c());
            }
        }

        private void setBaseTransientBottomBar(BaseTransientBottomBar<?> baseTransientBottomBar) {
            this.f21351a = baseTransientBottomBar;
        }

        public void b(ViewGroup viewGroup) {
            this.f21361k = true;
            viewGroup.addView(this);
            this.f21361k = false;
        }

        public final Drawable c() {
            int iK = M2.a.k(this, R$attr.colorSurface, R$attr.colorOnSurface, getBackgroundOverlayColorAlpha());
            Z2.l lVar = this.f21352b;
            Drawable drawableN = lVar != null ? BaseTransientBottomBar.n(iK, lVar) : BaseTransientBottomBar.m(iK, getResources());
            if (this.f21358h == null) {
                return C5566a.r(drawableN);
            }
            Drawable drawableR = C5566a.r(drawableN);
            drawableR.setTintList(this.f21358h);
            return drawableR;
        }

        public final void d(ViewGroup.MarginLayoutParams marginLayoutParams) {
            this.f21360j = new Rect(marginLayoutParams.leftMargin, marginLayoutParams.topMargin, marginLayoutParams.rightMargin, marginLayoutParams.bottomMargin);
        }

        public float getActionTextColorAlpha() {
            return this.f21355e;
        }

        public int getAnimationMode() {
            return this.f21353c;
        }

        public float getBackgroundOverlayColorAlpha() {
            return this.f21354d;
        }

        public int getMaxInlineActionWidth() {
            return this.f21357g;
        }

        public int getMaxWidth() {
            return this.f21356f;
        }

        @Override // android.view.ViewGroup, android.view.View
        public void onAttachedToWindow() {
            super.onAttachedToWindow();
            BaseTransientBottomBar<?> baseTransientBottomBar = this.f21351a;
            if (baseTransientBottomBar != null) {
                baseTransientBottomBar.x();
            }
            requestApplyInsets();
        }

        @Override // android.view.ViewGroup, android.view.View
        public void onDetachedFromWindow() {
            super.onDetachedFromWindow();
            BaseTransientBottomBar<?> baseTransientBottomBar = this.f21351a;
            if (baseTransientBottomBar != null) {
                baseTransientBottomBar.y();
            }
        }

        @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
        public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
            super.onLayout(z10, i10, i11, i12, i13);
            BaseTransientBottomBar<?> baseTransientBottomBar = this.f21351a;
            if (baseTransientBottomBar != null) {
                baseTransientBottomBar.z();
            }
        }

        @Override // android.widget.FrameLayout, android.view.View
        public void onMeasure(int i10, int i11) {
            super.onMeasure(i10, i11);
            if (this.f21356f > 0) {
                int measuredWidth = getMeasuredWidth();
                int i12 = this.f21356f;
                if (measuredWidth > i12) {
                    super.onMeasure(View.MeasureSpec.makeMeasureSpec(i12, 1073741824), i11);
                }
            }
        }

        public void setAnimationMode(int i10) {
            this.f21353c = i10;
        }

        @Override // android.view.View
        public void setBackground(Drawable drawable) {
            setBackgroundDrawable(drawable);
        }

        @Override // android.view.View
        public void setBackgroundDrawable(Drawable drawable) {
            if (drawable != null && this.f21358h != null) {
                drawable = C5566a.r(drawable.mutate());
                drawable.setTintList(this.f21358h);
                drawable.setTintMode(this.f21359i);
            }
            super.setBackgroundDrawable(drawable);
        }

        @Override // android.view.View
        public void setBackgroundTintList(ColorStateList colorStateList) {
            this.f21358h = colorStateList;
            if (getBackground() != null) {
                Drawable drawableR = C5566a.r(getBackground().mutate());
                drawableR.setTintList(colorStateList);
                drawableR.setTintMode(this.f21359i);
                if (drawableR != getBackground()) {
                    super.setBackgroundDrawable(drawableR);
                }
            }
        }

        @Override // android.view.View
        public void setBackgroundTintMode(PorterDuff.Mode mode) {
            this.f21359i = mode;
            if (getBackground() != null) {
                Drawable drawableR = C5566a.r(getBackground().mutate());
                drawableR.setTintMode(mode);
                if (drawableR != getBackground()) {
                    super.setBackgroundDrawable(drawableR);
                }
            }
        }

        @Override // android.view.View
        public void setLayoutParams(ViewGroup.LayoutParams layoutParams) {
            super.setLayoutParams(layoutParams);
            if (this.f21361k || !(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
                return;
            }
            d((ViewGroup.MarginLayoutParams) layoutParams);
            BaseTransientBottomBar<?> baseTransientBottomBar = this.f21351a;
            if (baseTransientBottomBar != null) {
                baseTransientBottomBar.M();
            }
        }

        @Override // android.view.View
        public void setOnClickListener(View.OnClickListener onClickListener) {
            setOnTouchListener(onClickListener != null ? null : f21350l);
            super.setOnClickListener(onClickListener);
        }
    }

    public static GradientDrawable m(int i10, Resources resources) throws Resources.NotFoundException {
        float dimension = resources.getDimension(R$dimen.mtrl_snackbar_background_corner_radius);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setCornerRadius(dimension);
        gradientDrawable.setColor(i10);
        return gradientDrawable;
    }

    public static Z2.h n(int i10, Z2.l lVar) {
        Z2.h hVar = new Z2.h(lVar);
        hVar.g0(ColorStateList.valueOf(i10));
        return hVar;
    }

    public void A(int i10) {
        com.google.android.material.snackbar.a.c().h(this.f21334v);
        List<m<B>> list = this.f21331s;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.f21331s.get(size).a(this, i10);
            }
        }
        ViewParent parent = this.f21320h.getParent();
        if (parent instanceof ViewGroup) {
            ((ViewGroup) parent).removeView(this.f21320h);
        }
    }

    public void B() {
        com.google.android.material.snackbar.a.c().i(this.f21334v);
        List<m<B>> list = this.f21331s;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.f21331s.get(size).b(this);
            }
        }
    }

    public final void C() {
        this.f21327o = l();
        M();
    }

    public final void D(CoordinatorLayout.f fVar) {
        SwipeDismissBehavior<? extends View> swipeDismissBehaviorR = this.f21332t;
        if (swipeDismissBehaviorR == null) {
            swipeDismissBehaviorR = r();
        }
        if (swipeDismissBehaviorR instanceof Behavior) {
            ((Behavior) swipeDismissBehaviorR).s(this);
        }
        swipeDismissBehaviorR.n(new j());
        fVar.o(swipeDismissBehaviorR);
        if (q() == null) {
            fVar.f12913g = 80;
        }
    }

    public boolean E() {
        AccessibilityManager accessibilityManager = this.f21333u;
        if (accessibilityManager == null) {
            return true;
        }
        List<AccessibilityServiceInfo> enabledAccessibilityServiceList = accessibilityManager.getEnabledAccessibilityServiceList(1);
        return enabledAccessibilityServiceList != null && enabledAccessibilityServiceList.isEmpty();
    }

    public final boolean F() {
        return this.f21328p > 0 && !this.f21322j && w();
    }

    public final void G() {
        if (this.f21320h.getParent() == null) {
            ViewGroup.LayoutParams layoutParams = this.f21320h.getLayoutParams();
            if (layoutParams instanceof CoordinatorLayout.f) {
                D((CoordinatorLayout.f) layoutParams);
            }
            this.f21320h.b(this.f21319g);
            C();
            this.f21320h.setVisibility(4);
        }
        if (this.f21320h.isLaidOut()) {
            H();
        } else {
            this.f21330r = true;
        }
    }

    public final void H() {
        if (E()) {
            j();
            return;
        }
        if (this.f21320h.getParent() != null) {
            this.f21320h.setVisibility(0);
        }
        B();
    }

    public final void I() {
        ValueAnimator valueAnimatorP = p(0.0f, 1.0f);
        ValueAnimator valueAnimatorS = s(0.8f, 1.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(valueAnimatorP, valueAnimatorS);
        animatorSet.setDuration(this.f21313a);
        animatorSet.addListener(new l());
        animatorSet.start();
    }

    public final void J(int i10) {
        ValueAnimator valueAnimatorP = p(1.0f, 0.0f);
        valueAnimatorP.setDuration(this.f21314b);
        valueAnimatorP.addListener(new a(i10));
        valueAnimatorP.start();
    }

    public final void K() {
        int iT = t();
        this.f21320h.setTranslationY(iT);
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setIntValues(iT, 0);
        valueAnimator.setInterpolator(this.f21317e);
        valueAnimator.setDuration(this.f21315c);
        valueAnimator.addListener(new d());
        valueAnimator.addUpdateListener(new e());
        valueAnimator.start();
    }

    public final void L(int i10) {
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setIntValues(0, t());
        valueAnimator.setInterpolator(this.f21317e);
        valueAnimator.setDuration(this.f21315c);
        valueAnimator.addListener(new f(i10));
        valueAnimator.addUpdateListener(new g());
        valueAnimator.start();
    }

    public final void M() {
        ViewGroup.LayoutParams layoutParams = this.f21320h.getLayoutParams();
        if (!(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
            Log.w(f21308B, "Unable to update margins because layout params are not MarginLayoutParams");
            return;
        }
        if (this.f21320h.f21360j == null) {
            Log.w(f21308B, "Unable to update margins because original view margins are not set");
            return;
        }
        if (this.f21320h.getParent() == null) {
            return;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        int i10 = this.f21320h.f21360j.bottom + (q() != null ? this.f21327o : this.f21324l);
        int i11 = this.f21320h.f21360j.left + this.f21325m;
        int i12 = this.f21320h.f21360j.right + this.f21326n;
        int i13 = this.f21320h.f21360j.top;
        boolean z10 = (marginLayoutParams.bottomMargin == i10 && marginLayoutParams.leftMargin == i11 && marginLayoutParams.rightMargin == i12 && marginLayoutParams.topMargin == i13) ? false : true;
        if (z10) {
            marginLayoutParams.bottomMargin = i10;
            marginLayoutParams.leftMargin = i11;
            marginLayoutParams.rightMargin = i12;
            marginLayoutParams.topMargin = i13;
            this.f21320h.requestLayout();
        }
        if ((z10 || this.f21329q != this.f21328p) && F()) {
            this.f21320h.removeCallbacks(this.f21323k);
            this.f21320h.post(this.f21323k);
        }
    }

    public void j() {
        this.f21320h.post(new k());
    }

    public final void k(int i10) {
        if (this.f21320h.getAnimationMode() == 1) {
            J(i10);
        } else {
            L(i10);
        }
    }

    public final int l() {
        if (q() == null) {
            return 0;
        }
        int[] iArr = new int[2];
        q().getLocationOnScreen(iArr);
        int i10 = iArr[1];
        int[] iArr2 = new int[2];
        this.f21319g.getLocationOnScreen(iArr2);
        return (iArr2[1] + this.f21319g.getHeight()) - i10;
    }

    public void o(int i10) {
        com.google.android.material.snackbar.a.c().b(this.f21334v, i10);
    }

    public final ValueAnimator p(float... fArr) {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(fArr);
        valueAnimatorOfFloat.setInterpolator(this.f21316d);
        valueAnimatorOfFloat.addUpdateListener(new b());
        return valueAnimatorOfFloat;
    }

    public View q() {
        return null;
    }

    public SwipeDismissBehavior<? extends View> r() {
        return new Behavior();
    }

    public final ValueAnimator s(float... fArr) {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(fArr);
        valueAnimatorOfFloat.setInterpolator(this.f21318f);
        valueAnimatorOfFloat.addUpdateListener(new c());
        return valueAnimatorOfFloat;
    }

    public final int t() {
        int height = this.f21320h.getHeight();
        ViewGroup.LayoutParams layoutParams = this.f21320h.getLayoutParams();
        return layoutParams instanceof ViewGroup.MarginLayoutParams ? height + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin : height;
    }

    public final void u(int i10) {
        if (E() && this.f21320h.getVisibility() == 0) {
            k(i10);
        } else {
            A(i10);
        }
    }

    public boolean v() {
        return com.google.android.material.snackbar.a.c().e(this.f21334v);
    }

    public final boolean w() {
        ViewGroup.LayoutParams layoutParams = this.f21320h.getLayoutParams();
        return (layoutParams instanceof CoordinatorLayout.f) && (((CoordinatorLayout.f) layoutParams).f() instanceof SwipeDismissBehavior);
    }

    public void x() {
        WindowInsets rootWindowInsets = this.f21320h.getRootWindowInsets();
        if (rootWindowInsets != null) {
            this.f21328p = rootWindowInsets.getMandatorySystemGestureInsets().bottom;
            M();
        }
    }

    public void y() {
        if (v()) {
            f21312z.post(new i());
        }
    }

    public void z() {
        if (this.f21330r) {
            H();
            this.f21330r = false;
        }
    }
}
