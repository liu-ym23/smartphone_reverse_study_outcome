package com.baidu.mapapi.map;

import android.R;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;

/* JADX INFO: loaded from: classes39.dex */
public class SwipeDismissTouchListener implements View.OnTouchListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f31333a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f31334b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f31335c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f31336d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private View f31337e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private DismissCallbacks f31338f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f31339g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private float f31340h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private float f31341i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f31342j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f31343k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private Object f31344l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private VelocityTracker f31345m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private float f31346n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private boolean f31347o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private boolean f31348p;

    public interface DismissCallbacks {
        boolean canDismiss(Object r100);

        void onDismiss(View r100, Object r101);

        void onNotify();
    }

    public class a extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ SwipeDismissTouchListener f31349a;

        public a(SwipeDismissTouchListener r100) {
            this.f31349a = r100;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator r100) {
            SwipeDismissTouchListener.a(this.f31349a);
        }
    }

    public class b extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ ViewGroup.LayoutParams f31350a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f31351b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ SwipeDismissTouchListener f31352c;

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator r100) {
            SwipeDismissTouchListener.d(this.f31352c).onDismiss(SwipeDismissTouchListener.b(this.f31352c), SwipeDismissTouchListener.c(this.f31352c));
            SwipeDismissTouchListener.b(this.f31352c).setTranslationX(0.0f);
            ViewGroup.LayoutParams r101 = this.f31350a;
            r101.height = this.f31351b;
            SwipeDismissTouchListener.b(this.f31352c).setLayoutParams(this.f31350a);
        }

        public b(SwipeDismissTouchListener r100, ViewGroup.LayoutParams r101, int r102) {
            this.f31352c = r100;
            this.f31350a = r101;
            this.f31351b = r102;
        }
    }

    public class c implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ ViewGroup.LayoutParams f31353a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ SwipeDismissTouchListener f31354b;

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator r100) {
            ViewGroup.LayoutParams r101 = this.f31353a;
            r101.height = ((Integer) r100.getAnimatedValue()).intValue();
            SwipeDismissTouchListener.b(this.f31354b).setLayoutParams(this.f31353a);
        }

        public c(SwipeDismissTouchListener r100, ViewGroup.LayoutParams r101) {
            this.f31354b = r100;
            this.f31353a = r101;
        }
    }

    private void a() {
        ViewGroup.LayoutParams r100 = this.f31337e.getLayoutParams();
        int r101 = this.f31337e.getHeight();
        ValueAnimator r102 = ValueAnimator.ofInt(new int[]{r101, 1}).setDuration(this.f31336d);
        r102.addListener(new b(this, r100, r101));
        r102.addUpdateListener(new c(this, r100));
        r102.start();
    }

    public static /* synthetic */ void a(SwipeDismissTouchListener r100) {
        r100.a();
    }

    public static /* synthetic */ View b(SwipeDismissTouchListener r100) {
        return r100.f31337e;
    }

    public static /* synthetic */ Object c(SwipeDismissTouchListener r100) {
        return r100.f31344l;
    }

    public static /* synthetic */ DismissCallbacks d(SwipeDismissTouchListener r100) {
        return r100.f31338f;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View r110, MotionEvent r111) {
        r111.offsetLocation(this.f31346n, 0.0f);
        if (this.f31339g >= 2) goto L5;
        this.f31339g = this.f31337e.getWidth();
    L5:
        int r112 = r111.getActionMasked();
        boolean r100 = true;
        if (r112 != 0) goto L8;
        this.f31340h = r111.getRawX();
        this.f31341i = r111.getRawY();
        if (this.f31338f.canDismiss(this.f31344l) == false) goto L90;
        this.f31347o = false;
        VelocityTracker r113 = VelocityTracker.obtain();
        this.f31345m = r113;
        r113.addMovement(r111);
    L90:
        return true;
    L8:
        if (r112 == 1) goto L42;
        if (r112 == 2) goto L16;
        if (r112 == 3) goto L13;
    L86:
        return false;
    L13:
        if (this.f31345m == null) goto L86;
        this.f31337e.animate().translationX(0.0f).setDuration(this.f31336d).setListener(null);
        this.f31345m.recycle();
        this.f31345m = null;
        this.f31346n = 0.0f;
        this.f31340h = 0.0f;
        this.f31341i = 0.0f;
        this.f31342j = false;
        goto L86
    L16:
        VelocityTracker r114 = this.f31345m;
        if (r114 == null) goto L86;
        r114.addMovement(r111);
        float r115 = r111.getRawX() - this.f31340h;
        float r101 = r111.getRawY() - this.f31341i;
        if (Math.abs(r115) <= this.f31333a) goto L38;
        if (Math.abs(r101) >= (Math.abs(r115) / 2.0f)) goto L38;
        this.f31342j = true;
        if (r115 <= 0.0f) goto L26;
        int r102 = this.f31333a;
    L27:
        this.f31343k = r102;
        this.f31337e.getParent().requestDisallowInterceptTouchEvent(true);
        if (this.f31347o == true) goto L31;
        this.f31347o = true;
        this.f31338f.onNotify();
    L31:
        if (Math.abs(r115) > (this.f31339g / 3)) goto L33;
        this.f31348p = false;
    L36:
        MotionEvent r103 = MotionEvent.obtain(r111);
        r103.setAction((r111.getActionIndex() << 8) | 3);
        this.f31337e.onTouchEvent(r103);
        r103.recycle();
        goto L38
    L33:
        if (this.f31348p == true) goto L36;
        this.f31348p = true;
        this.f31338f.onNotify();
        goto L36
    L26:
        r102 = -this.f31333a;
    L38:
        if (this.f31342j == false) goto L86;
        this.f31346n = r115;
        this.f31337e.setTranslationX(r115 - this.f31343k);
        return true;
    L42:
        if (this.f31345m == null) goto L86;
        float r116 = r111.getRawX() - this.f31340h;
        this.f31345m.addMovement(r111);
        this.f31345m.computeCurrentVelocity(1000);
        float r117 = this.f31345m.getXVelocity();
        float r104 = Math.abs(r117);
        float r105 = Math.abs(this.f31345m.getYVelocity());
        if (Math.abs(r116) <= (this.f31339g / 3)) goto L52;
        if (this.f31342j == false) goto L52;
        if (r116 > 0.0f) goto L73;
    L74:
        boolean r118 = false;
    L76:
        if (r100 == false) goto L83;
        ViewPropertyAnimator r119 = this.f31337e.animate();
        if (r118 == false) goto L80;
        int r120 = this.f31339g;
    L81:
        r119.translationX(r120).setDuration(this.f31336d).setListener(new a(this));
    L85:
        this.f31345m.recycle();
        this.f31345m = null;
        this.f31346n = 0.0f;
        this.f31340h = 0.0f;
        this.f31341i = 0.0f;
        this.f31342j = false;
        goto L86
    L80:
        r120 = -this.f31339g;
        goto L81
    L83:
        if (this.f31342j == false) goto L85;
        this.f31337e.animate().translationX(0.0f).setDuration(this.f31336d).setListener(null);
    L73:
        r118 = true;
    L52:
        if (this.f31334b <= r104) goto L54;
    L75:
        r118 = false;
        r100 = false;
        goto L76
    L54:
        if (r104 > this.f31335c) goto L75;
        if (r105 >= r104) goto L75;
        if (r105 >= r104) goto L75;
        if (this.f31342j == false) goto L75;
        if (r117 >= 0.0f) goto L63;
        boolean r121 = true;
    L65:
        if (r116 >= 0.0f) goto L67;
        boolean r122 = true;
    L68:
        if (r121 != r122) goto L70;
        boolean r123 = true;
    L71:
        r100 = r123;
        if (this.f31345m.getXVelocity() <= 0.0f) goto L74;
    L70:
        r123 = false;
        goto L71
    L67:
        r122 = false;
        goto L68
    L63:
        r121 = false;
        goto L65
    }

    public SwipeDismissTouchListener(View r100, Object r101, DismissCallbacks r102) {
        this.f31339g = 1;
        ViewConfiguration r103 = ViewConfiguration.get(r100.getContext());
        this.f31333a = r103.getScaledTouchSlop();
        this.f31334b = r103.getScaledMinimumFlingVelocity();
        this.f31335c = r103.getScaledMaximumFlingVelocity();
        this.f31336d = r100.getContext().getResources().getInteger(R.integer.config_shortAnimTime);
        this.f31337e = r100;
        r100.getContext();
        this.f31344l = r101;
        this.f31338f = r102;
    }
}
