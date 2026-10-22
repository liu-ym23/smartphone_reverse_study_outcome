package com.bytedance.android.livesdk.chatroom.replay.cache.ui.customui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.OvershootInterpolator;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes7.dex */
public class SwipeMenuLayout extends ViewGroup {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static boolean f108180u;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f108181a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f108182b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f108183c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f108184d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f108185e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f108186f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public View f108187g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final PointF f108188h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f108189i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final PointF f108190j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f108191k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public SwipeMenuLayout f108192l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public VelocityTracker f108193m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public e f108194n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f108195o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f108196p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f108197q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f108198r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public ValueAnimator f108199s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public ValueAnimator f108200t;

    public class a implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SwipeMenuLayout f108201a;

        public a(SwipeMenuLayout r100) {
            this.f108201a = r100;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r100) {
            this.f108201a.scrollTo(((Integer) r100.getAnimatedValue()).intValue(), 0);
        }
    }

    public class b extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SwipeMenuLayout f108202a;

        public b(SwipeMenuLayout r100) {
            this.f108202a = r100;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
            SwipeMenuLayout r101 = this.f108202a;
            boolean r102 = SwipeMenuLayout.f108180u;
            r101.getClass();
            e r103 = this.f108202a.f108194n;
            if (r103 == null) goto L6;
            r103.onShow();
            return;
        }
    }

    public class c implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SwipeMenuLayout f108203a;

        public c(SwipeMenuLayout r100) {
            this.f108203a = r100;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r100) {
            this.f108203a.scrollTo(((Integer) r100.getAnimatedValue()).intValue(), 0);
        }
    }

    public class d extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SwipeMenuLayout f108204a;

        public d(SwipeMenuLayout r100) {
            this.f108204a = r100;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
            SwipeMenuLayout r101 = this.f108204a;
            boolean r102 = SwipeMenuLayout.f108180u;
            r101.getClass();
        }
    }

    public interface e {
        void onShow();
    }

    public final void b() {
        this.f108192l = null;
        View r100 = this.f108187g;
        if (r100 == null) goto L5;
        r100.setLongClickable(true);
    L5:
        a();
        ValueAnimator r101 = ValueAnimator.ofInt(new int[]{getScrollX(), 0});
        this.f108200t = r101;
        if (r101 == null) goto L9;
        r101.addUpdateListener(new c(this));
        this.f108200t.setInterpolator(new AccelerateInterpolator());
        this.f108200t.addListener(new d(this));
        this.f108200t.setDuration(300).start();
        return;
    }

    public final void a() {
        ValueAnimator r100 = this.f108200t;
        if (r100 != null) goto L5;
    L7:
        ValueAnimator r101 = this.f108199s;
        if (r101 != null) goto L10;
        return;
    L10:
        if (r101.isRunning() == false) goto L14;
        this.f108199s.cancel();
        return;
    L14:
        return;
    L5:
        if (r100.isRunning() == false) goto L7;
        this.f108200t.cancel();
        goto L7
    }

    public final void c() {
        this.f108192l = this;
        View r100 = this.f108187g;
        if (r100 == null) goto L5;
        r100.setLongClickable(false);
    L5:
        a();
        int[] r101 = new int[2];
        r101[0] = getScrollX();
        if (this.f108198r == false) goto L8;
        int r102 = this.f108185e;
    L9:
        r101[1] = r102;
        ValueAnimator r103 = ValueAnimator.ofInt(r101);
        this.f108199s = r103;
        if (r103 == null) goto L13;
        r103.addUpdateListener(new a(this));
        this.f108199s.setInterpolator(new OvershootInterpolator());
        this.f108199s.addListener(new b(this));
        this.f108199s.setDuration(300).start();
        return;
    L13:
        return;
    L8:
        r102 = -this.f108185e;
        goto L9
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        SwipeMenuLayout r100 = this.f108192l;
        if (this != r100) goto L5;
        r100.b();
        this.f108192l = null;
    L5:
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public final boolean performLongClick() {
        if (Math.abs(getScrollX()) <= this.f108181a) goto L7;
        return false;
    L7:
        return super.performLongClick();
    }

    public SwipeMenuLayout getViewCache() {
        return this.f108192l;
    }

    public SwipeMenuLayout(Context r100) {
        this(r100, null);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r100) {
        if (this.f108195o == false) goto L79;
        if (this.f108193m != null) goto L7;
        this.f108193m = VelocityTracker.obtain();
    L7:
        VelocityTracker r101 = this.f108193m;
        if (r101 == null) goto L10;
        r101.addMovement(r100);
    L10:
        VelocityTracker r102 = this.f108193m;
        int r103 = r100.getAction();
        if (r103 == 0) goto L69;
        if (r103 == 1) goto L45;
        if (r103 == 2) goto L19;
        if (r103 == 3) goto L45;
    L19:
        if (this.f108197q == true) goto L79;
        float r104 = this.f108188h.x - r100.getRawX();
        if (Math.abs(r104) <= 10.0f) goto L24;
    L25:
        getParent().requestDisallowInterceptTouchEvent(true);
    L27:
        if (Math.abs(r104) <= this.f108181a) goto L29;
        this.f108189i = false;
    L29:
        scrollBy((int) r104, 0);
        if (this.f108198r == true) goto L32;
        int r105 = getScrollX();
        int r106 = this.f108185e;
        if (r105 >= (-r106)) goto L41;
        scrollTo(-r106, 0);
    L41:
        if (getScrollX() <= 0) goto L43;
        scrollTo(0, 0);
    L43:
        this.f108188h.set(r100.getRawX(), r100.getRawY());
        goto L79
    L32:
        if (getScrollX() >= 0) goto L34;
        scrollTo(0, 0);
    L34:
        int r107 = getScrollX();
        int r108 = this.f108185e;
        if (r107 <= r108) goto L43;
        scrollTo(r108, 0);
        goto L43
    L24:
        if (Math.abs(getScrollX()) <= 10) goto L27;
    L45:
        if (Math.abs(r100.getRawX() - this.f108190j.x) <= this.f108181a) goto L48;
        this.f108191k = true;
    L48:
        if (this.f108197q == true) goto L65;
        r102.computeCurrentVelocity(1000, this.f108182b);
        float r109 = r102.getXVelocity(this.f108183c);
        if (Math.abs(r109) <= 1000.0f) goto L62;
        if (r109 >= (-1000.0f)) goto L58;
        if (this.f108198r == false) goto L56;
        c();
        goto L65
    L56:
        b();
        goto L65
    L58:
        if (this.f108198r == false) goto L60;
        b();
        goto L65
    L60:
        c();
        goto L65
    L62:
        if (Math.abs(getScrollX()) <= this.f108186f) goto L64;
        c();
        goto L65
    L64:
        b();
    L65:
        VelocityTracker r110 = this.f108193m;
        if (r110 == null) goto L68;
        r110.clear();
        this.f108193m.recycle();
        this.f108193m = null;
    L68:
        f108180u = false;
        goto L79
    L69:
        this.f108191k = false;
        this.f108189i = true;
        this.f108197q = false;
        if (f108180u == false) goto L72;
        return false;
    L72:
        f108180u = true;
        this.f108188h.set(r100.getRawX(), r100.getRawY());
        this.f108190j.set(r100.getRawX(), r100.getRawY());
        SwipeMenuLayout r111 = this.f108192l;
        if (r111 == null) goto L77;
        if (r111 == this) goto L76;
        r111.b();
        this.f108197q = this.f108196p;
    L76:
        getParent().requestDisallowInterceptTouchEvent(true);
    L77:
        this.f108183c = r100.getPointerId(0);
    L79:
        return super.dispatchTouchEvent(r100);
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet r100) {
        return new ViewGroup.MarginLayoutParams(getContext(), r100);
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r100) {
        if (this.f108195o == false) goto L37;
        int r101 = r100.getAction();
        if (r101 == 1) goto L13;
        if (r101 != 2) goto L34;
        if (Math.abs(r100.getRawX() - this.f108190j.x) <= this.f108181a) goto L34;
        return true;
    L34:
        if (this.f108197q == false) goto L37;
        return true;
    L13:
        if (this.f108198r == false) goto L23;
        if (getScrollX() <= this.f108181a) goto L31;
        if (r100.getX() >= (getWidth() - getScrollX())) goto L31;
        if (this.f108189i == false) goto L21;
        b();
    L21:
        return true;
    L31:
        if (this.f108191k == false) goto L34;
        return true;
    L23:
        if ((-getScrollX()) <= this.f108181a) goto L31;
        if (r100.getX() <= (-getScrollX())) goto L31;
        if (this.f108189i == false) goto L29;
        b();
    L29:
        return true;
    L37:
        return super.onInterceptTouchEvent(r100);
    }

    public void setShowListener(e r100) {
        this.f108194n = r100;
    }

    public void setSwipeEnable(boolean r100) {
        this.f108195o = r100;
    }

    public SwipeMenuLayout(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    @Override // android.view.View
    public final void onMeasure(int r110, int r111) {
        super.onMeasure(r110, r111);
        setClickable(true);
        this.f108185e = 0;
        this.f108184d = 0;
        int r100 = getChildCount();
        if (View.MeasureSpec.getMode(r111) == 1073741824) goto L5;
        boolean r101 = true;
    L6:
        int r102 = 0;
        int r103 = 0;
        boolean r104 = false;
    L8:
        if (r102 >= r100) goto L21;
        View r112 = getChildAt(r102);
        r112.setClickable(true);
        if (r112.getVisibility() == 8) goto L20;
        measureChild(r112, r110, r111);
        ViewGroup.MarginLayoutParams r113 = (ViewGroup.MarginLayoutParams) r112.getLayoutParams();
        this.f108184d = Math.max(this.f108184d, r112.getMeasuredHeight());
        if (r101 == true) goto L14;
    L16:
        if (r102 <= 0) goto L18;
        this.f108185e += r112.getMeasuredWidth();
        goto L20
    L18:
        this.f108187g = r112;
        r103 = r112.getMeasuredWidth();
        goto L20
    L14:
        if (r113.height != (-1)) goto L16;
        r104 = true;
    L20:
        r102 = r102 + 1;
        goto L8
    L21:
        setMeasuredDimension((getPaddingLeft() + getPaddingRight()) + r103, (this.f108184d + getPaddingTop()) + getPaddingBottom());
        this.f108186f = (this.f108185e * 4) / 10;
        if (r104 == false) goto L31;
        int r105 = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824);
        int r114 = 0;
    L24:
        if (r114 >= r100) goto L40;
        View r106 = getChildAt(r114);
        if (r106.getVisibility() == 8) goto L30;
        ViewGroup.MarginLayoutParams r115 = (ViewGroup.MarginLayoutParams) r106.getLayoutParams();
        if (r115.height != (-1)) goto L30;
        int r116 = r115.width;
        r115.width = r106.getMeasuredWidth();
        measureChildWithMargins(r106, r110, 0, r105, 0);
        r115.width = r116;
    L30:
        r114 = r114 + 1;
        goto L24
    L40:
        return;
    L31:
        return;
    L5:
        r101 = false;
        goto L6
    }

    public SwipeMenuLayout(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f108188h = new PointF();
        this.f108189i = true;
        this.f108190j = new PointF();
        this.f108181a = ViewConfiguration.get(r100).getScaledTouchSlop();
        this.f108182b = ViewConfiguration.get(r100).getScaledMaximumFlingVelocity();
        this.f108195o = true;
        this.f108196p = true;
        this.f108198r = true;
        int r103 = 0;
        TypedArray r104 = r100.getTheme().obtainStyledAttributes(r101, new int[]{R.attr.ios, R.attr.leftSwipe, R.attr.swipeEnable}, r102, 0);
        int r105 = r104.getIndexCount();
    L3:
        if (r103 >= r105) goto L12;
        int r106 = r104.getIndex(r103);
        if (r106 != 2) goto L7;
        this.f108195o = r104.getBoolean(r106, true);
    L11:
        r103 = r103 + 1;
        goto L3
    L7:
        if (r106 != 0) goto L9;
        this.f108196p = r104.getBoolean(r106, true);
        goto L11
    L9:
        if (r106 != 1) goto L11;
        this.f108198r = r104.getBoolean(r106, true);
        goto L11
    L12:
        r104.recycle();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r100, int r101, int r102, int r103, int r104) {
        int r105 = getChildCount();
        int r106 = 0;
        int r107 = getPaddingLeft() + 0;
        int r108 = getPaddingLeft() + 0;
    L3:
        if (r106 >= r105) goto L14;
        View r109 = getChildAt(r106);
        if (r109.getVisibility() == 8) goto L13;
        if (r106 != 0) goto L10;
        r109.layout(r107, getPaddingTop(), r109.getMeasuredWidth() + r107, getPaddingTop() + r109.getMeasuredHeight());
        int r110 = r109.getMeasuredWidth();
    L8:
        r107 = r107 + r110;
        goto L13
    L10:
        if (this.f108198r == false) goto L12;
        r109.layout(r107, getPaddingTop(), r109.getMeasuredWidth() + r107, getPaddingTop() + r109.getMeasuredHeight());
        r110 = r109.getMeasuredWidth();
        goto L8
    L12:
        r109.layout(r108 - r109.getMeasuredWidth(), getPaddingTop(), r108, getPaddingTop() + r109.getMeasuredHeight());
        r108 = r108 - r109.getMeasuredWidth();
    L13:
        r106 = r106 + 1;
        goto L3
    }
}
