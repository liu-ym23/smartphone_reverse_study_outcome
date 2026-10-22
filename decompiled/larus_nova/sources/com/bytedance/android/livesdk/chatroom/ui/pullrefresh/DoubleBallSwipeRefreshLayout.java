package com.bytedance.android.livesdk.chatroom.ui.pullrefresh;

import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Transformation;
import android.widget.Scroller;
import androidx.camera.video.AudioStats;
import androidx.core.content.ContextCompat;
import androidx.core.view.MotionEventCompat;
import androidx.core.view.NestedScrollingChild;
import androidx.core.view.NestedScrollingChildHelper;
import androidx.core.view.NestedScrollingParent;
import androidx.core.view.NestedScrollingParentHelper;
import androidx.core.view.ViewCompat;
import com.bytedance.android.live.core.setting.LiveInfraSettingKeys;
import com.bytedance.android.livesdk.chatroom.ui.LiveDoubleColorBallAnimationView;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import java.util.Objects;
import no1.g;

/* JADX INFO: loaded from: classes8.dex */
public class DoubleBallSwipeRefreshLayout extends ViewGroup implements NestedScrollingParent, NestedScrollingChild {
    public static final int[] I = null;
    public boolean A;
    public int B;
    public final int C;
    public final int D;
    public final a E;
    public final c F;
    public final d G;
    public final e H;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public View f113778a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public SwipeRefreshLayout.f f113779b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f113780c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f113781d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f113782e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f113783f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Scroller f113784g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f113785h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final NestedScrollingParentHelper f113786i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final NestedScrollingChildHelper f113787j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final int[] f113788k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final int[] f113789l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f113790m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final int f113791n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public float f113792o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public float f113793p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f113794q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f113795r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final DecelerateInterpolator f113796s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public LiveDoubleColorBallAnimationView f113797t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final int f113798u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final int f113799v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public MaterialProgressDrawable f113800w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public no1.b f113801x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public no1.d f113802y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public no1.d f113803z;

    public class a implements Animation.AnimationListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DoubleBallSwipeRefreshLayout f113804a;

        @Override // android.view.animation.Animation.AnimationListener
        public final void onAnimationRepeat(Animation r100) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public final void onAnimationStart(Animation r100) {
        }

        public a(DoubleBallSwipeRefreshLayout r100) {
            this.f113804a = r100;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public final void onAnimationEnd(Animation r100) {
            DoubleBallSwipeRefreshLayout r101 = this.f113804a;
            if (r101.f113780c == false) goto L9;
            r101.H.b(false);
            MaterialProgressDrawable r102 = this.f113804a.f113800w;
            r102.f113837b.f113867u = 255;
            r102.start();
            DoubleBallSwipeRefreshLayout r103 = this.f113804a;
            if (r103.A == false) goto L11;
            SwipeRefreshLayout.f r104 = r103.f113779b;
            if (r104 == null) goto L12;
            r104.onRefresh();
            return;
        L12:
            return;
        L11:
            return;
        L9:
            r101.d();
        }
    }

    public class b implements Animation.AnimationListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DoubleBallSwipeRefreshLayout f113805a;

        @Override // android.view.animation.Animation.AnimationListener
        public final void onAnimationRepeat(Animation r100) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public final void onAnimationStart(Animation r100) {
        }

        public b(DoubleBallSwipeRefreshLayout r100) {
            this.f113805a = r100;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public final void onAnimationEnd(Animation r100) {
            this.f113805a.getClass();
            DoubleBallSwipeRefreshLayout r101 = this.f113805a;
            r101.getClass();
            no1.c r102 = new no1.c(r101);
            r101.getClass();
            r102.setDuration(150);
        }
    }

    public class c extends Animation {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DoubleBallSwipeRefreshLayout f113806a;

        public c(DoubleBallSwipeRefreshLayout r100) {
            this.f113806a = r100;
        }

        @Override // android.view.animation.Animation
        public final void applyTransformation(float r100, Transformation r101) {
            this.f113806a.getClass();
            DoubleBallSwipeRefreshLayout r102 = this.f113806a;
            int r103 = r102.f113799v;
            Math.abs(r102.f113798u);
            this.f113806a.f113800w.a(1.0f - r100);
        }
    }

    public class d extends Animation {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DoubleBallSwipeRefreshLayout f113807a;

        public d(DoubleBallSwipeRefreshLayout r100) {
            this.f113807a = r100;
        }

        @Override // android.view.animation.Animation
        public final void applyTransformation(float r100, Transformation r101) {
            this.f113807a.getClass();
        }
    }

    public class e extends g {
        @Override // no1.g
        public final void a() {
        }

        public e() {
        }
    }

    public interface f {
    }

    public void setAnimationProgress(float r100) {
    }

    public void setColorScheme(int... r100) {
    }

    public void setOnChildScrollUpCallback(f r100) {
    }

    public void setOnSwipeChangeListener(SwipeRefreshLayout.g r100) {
    }

    static {
        I = new int[]{R.attr.enabled};
    }

    public final void a() {
        if (this.f113778a != null) goto L11;
        int r100 = 0;
    L6:
        if (r100 >= getChildCount()) goto L15;
        View r101 = getChildAt(r100);
        if (r101.equals(this.f113797t) == false) goto L9;
        r100 = r100 + 1;
        goto L6
    L9:
        this.f113778a = r101;
        return;
    L15:
        return;
    }

    @Override // android.view.View
    public final void computeScroll() {
        if (this.f113784g.computeScrollOffset() == false) goto L6;
        scrollTo(this.f113784g.getCurrX(), this.f113784g.getCurrY());
        invalidate();
        return;
    }

    public final void d() {
        this.H.b(true);
        this.f113800w.stop();
        setColorViewAlpha(255);
    }

    @Override // android.view.ViewGroup, androidx.core.view.NestedScrollingParent
    public int getNestedScrollAxes() {
        return this.f113786i.getNestedScrollAxes();
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public final boolean hasNestedScrollingParent() {
        return this.f113787j.hasNestedScrollingParent();
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public final boolean isNestedScrollingEnabled() {
        return this.f113787j.isNestedScrollingEnabled();
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public final void stopNestedScroll() {
        this.f113787j.stopNestedScroll();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        d();
    }

    public int getProgressCircleDiameter() {
        return this.B;
    }

    public int getProgressViewEndOffset() {
        return this.f113799v;
    }

    public int getProgressViewStartOffset() {
        return this.f113798u;
    }

    public DoubleBallSwipeRefreshLayout(Context r100) {
        this(r100, null);
    }

    private void setColorViewAlpha(int r100) {
        this.f113800w.f113837b.f113867u = r100;
    }

    public final void b(float r100) {
        if (r100 <= this.f113782e) goto L5;
        e(true, true);
        return;
    L5:
        this.f113780c = false;
        MaterialProgressDrawable r101 = this.f113800w;
        MaterialProgressDrawable.b r102 = r101.f113837b;
        r102.f113851e = 0.0f;
        r102.a();
        MaterialProgressDrawable.b r103 = r101.f113837b;
        r103.f113852f = 0.0f;
        r103.a();
        b r104 = new b(this);
        e r105 = this.H;
        r105.getClass();
        no1.f r106 = new no1.f(r105, r104);
        e r107 = this.H;
        r107.getClass();
        Objects.toString(r106);
        r107.b(false);
        this.G.reset();
        this.G.setDuration(200);
        this.G.setInterpolator(this.f113796s);
        r106.onAnimationEnd(this.F);
        MaterialProgressDrawable.b r108 = this.f113800w.f113837b;
        if (r108.f113861o == false) goto L8;
        r108.f113861o = false;
        r108.a();
    L8:
        this.f113784g.startScroll(0, getScrollY(), 0, -getScrollY(), Math.abs(getScrollY() * 2));
        invalidate();
        this.f113797t.c();
    }

    public final void c(float r110) {
        MaterialProgressDrawable.b r100 = this.f113800w.f113837b;
        boolean r101 = true;
        if (r100.f113861o == true) goto L5;
        r100.f113861o = true;
        r100.a();
    L5:
        float r102 = r110 / this.f113782e;
        float r103 = (((float) Math.max(((double) Math.min(1.0f, Math.abs(r102))) - 0.4d, AudioStats.AUDIO_AMPLITUDE_NONE)) * 5.0f) / 3.0f;
        float r104 = Math.abs(r110) - this.f113782e;
        float r105 = this.f113799v;
        double r106 = Math.max(0.0f, Math.min(r104, r105 * 2.0f) / r105) / 4.0f;
        float r107 = ((float) (r106 - Math.pow(r106, 2.0d))) * 2.0f;
        if (r110 >= this.f113782e) goto L20;
        if (this.f113800w.f113837b.f113867u <= 76) goto L31;
        no1.d r111 = this.f113802y;
        if (r111 != null) goto L12;
    L16:
        r101 = false;
    L17:
        if (r101 == true) goto L31;
        no1.d r108 = new no1.d(this, this.f113800w.f113837b.f113867u, 76);
        r108.setDuration(300);
        this.f113802y = r108;
        goto L31
    L12:
        if (r111.hasStarted() == false) goto L16;
        if (r111.hasEnded() == true) goto L16;
    L31:
        float r112 = (float) Math.atan(r102);
        scrollTo(0, (int) ((-this.f113782e) * r112));
        this.f113797t.setProgress(Math.max(0.0f, Math.min(1.0f, r112 - 0.5f)));
        MaterialProgressDrawable r109 = this.f113800w;
        float r113 = Math.min(0.8f, r103 * 0.8f);
        MaterialProgressDrawable.b r114 = r109.f113837b;
        r114.f113851e = 0.0f;
        r114.a();
        MaterialProgressDrawable.b r115 = r109.f113837b;
        r115.f113852f = r113;
        r115.a();
        this.f113800w.a(Math.min(1.0f, r103));
        MaterialProgressDrawable.b r116 = this.f113800w.f113837b;
        r116.f113853g = (((r103 * 0.4f) - 0.25f) + (r107 * 2.0f)) * 0.5f;
        r116.a();
        e r117 = this.H;
        r117.getClass();
        r117.b(false);
        return;
    L20:
        if (this.f113800w.f113837b.f113867u >= 255) goto L31;
        no1.d r118 = this.f113803z;
        if (r118 != null) goto L24;
    L28:
        r101 = false;
    L29:
        if (r101 == true) goto L31;
        no1.d r119 = new no1.d(this, this.f113800w.f113837b.f113867u, 255);
        r119.setDuration(300);
        this.f113803z = r119;
        goto L31
    L24:
        if (r118.hasStarted() == false) goto L28;
        if (r118.hasEnded() == true) goto L28;
        goto L28
    }

    public final void f(float r100) {
        float r101 = this.f113793p;
        float r102 = r100 - r101;
        int r103 = this.f113781d;
        if (r102 > r103) goto L5;
        return;
    L5:
        if (this.f113794q == true) goto L9;
        this.f113792o = r101 + r103;
        this.f113794q = true;
        this.f113800w.f113837b.f113867u = 76;
        return;
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r100) {
        a();
        int r101 = MotionEventCompat.getActionMasked(r100);
        int r102 = 0;
        if (isEnabled() == true) goto L5;
    L40:
        return false;
    L5:
        if (ViewCompat.canScrollVertically(this.f113778a, -1) == true) goto L40;
        if (this.f113780c == true) goto L40;
        if (this.f113790m == true) goto L40;
        if (r101 != 0) goto L13;
        int r103 = r100.getPointerId(0);
        this.f113795r = r103;
        this.f113794q = false;
        int r104 = r100.findPointerIndex(r103);
        if (r104 >= 0) goto L37;
        return false;
    L37:
        this.f113793p = r100.getY(r104);
    L39:
        return this.f113794q;
    L13:
        if (r101 != 1) goto L15;
    L33:
        this.f113794q = false;
        this.f113795r = -1;
        goto L39
    L15:
        if (r101 != 2) goto L17;
        int r105 = this.f113795r;
        if (r105 != (-1)) goto L29;
        return false;
    L29:
        int r106 = r100.findPointerIndex(r105);
        if (r106 >= 0) goto L32;
        return false;
    L32:
        f(r100.getY(r106));
        goto L39
    L17:
        if (r101 == 3) goto L33;
        if (r101 != 6) goto L39;
        int r107 = MotionEventCompat.getActionIndex(r100);
        if (r100.getPointerId(r107) != this.f113795r) goto L39;
        if (r107 != 0) goto L25;
        r102 = 1;
    L25:
        this.f113795r = r100.getPointerId(r102);
        goto L39
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public final void onStopNestedScroll(View r100) {
        this.f113786i.onStopNestedScroll(r100);
        this.f113790m = false;
        float r101 = this.f113785h;
        if (r101 <= 0.0f) goto L5;
        b(r101);
        this.f113785h = 0.0f;
    L5:
        stopNestedScroll();
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r100) {
        int r101 = MotionEventCompat.getActionMasked(r100);
        int r102 = 0;
        if (isEnabled() == true) goto L5;
    L53:
        return false;
    L5:
        if (ViewCompat.canScrollVertically(this.f113778a, -1) == true) goto L53;
        if (this.f113780c == true) goto L53;
        if (this.f113790m == true) goto L53;
        if (r101 != 0) goto L14;
        this.f113795r = r100.getPointerId(0);
        this.f113794q = false;
    L52:
        return true;
    L14:
        if (r101 != 1) goto L16;
    L43:
        int r103 = r100.findPointerIndex(this.f113795r);
        if (r103 >= 0) goto L47;
        return false;
    L47:
        if (this.f113794q == false) goto L49;
        float r104 = (r100.getY(r103) - this.f113792o) * 0.5f;
        this.f113794q = false;
        b(r104);
    L49:
        this.f113795r = -1;
        return false;
    L16:
        if (r101 != 2) goto L18;
        int r105 = r100.findPointerIndex(this.f113795r);
        if (r105 >= 0) goto L36;
        return false;
    L36:
        float r106 = r100.getY(r105);
        f(r106);
        if (this.f113794q == false) goto L52;
        float r107 = (r106 - this.f113792o) * 0.5f;
        if (r107 <= 0.0f) goto L41;
        c(r107);
        goto L52
    L41:
        c(0.0f);
        return false;
    L18:
        if (r101 == 3) goto L43;
        if (r101 != 5) goto L22;
        int r108 = MotionEventCompat.getActionIndex(r100);
        if (r108 >= 0) goto L32;
        return false;
    L32:
        this.f113795r = r100.getPointerId(r108);
        goto L52
    L22:
        if (r101 != 6) goto L52;
        int r109 = MotionEventCompat.getActionIndex(r100);
        if (r100.getPointerId(r109) != this.f113795r) goto L52;
        if (r109 != 0) goto L28;
        r102 = 1;
    L28:
        this.f113795r = r100.getPointerId(r102);
        goto L52
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void requestDisallowInterceptTouchEvent(boolean r100) {
        super.requestDisallowInterceptTouchEvent(r100);
    }

    public void setColorSchemeColors(int... r100) {
        a();
        MaterialProgressDrawable r101 = this.f113800w;
        MaterialProgressDrawable.b r102 = r101.f113837b;
        r102.f113856j = r100;
        r102.b(0);
        r101.f113837b.b(0);
    }

    public void setColorSchemeResources(int... r100) {
        Context r101 = getContext();
        int[] r102 = new int[r100.length];
        int r103 = 0;
    L4:
        if (r103 >= r100.length) goto L6;
        r102[r103] = ContextCompat.getColor(r101, r100[r103]);
        r103 = r103 + 1;
        goto L4
    L6:
        setColorSchemeColors(r102);
    }

    public void setDistanceToTriggerSync(int r100) {
        this.f113782e = r100;
    }

    public void setDoNotCatchException(boolean r100) {
        this.f113783f = r100;
    }

    @Override // android.view.View
    public void setEnabled(boolean r100) {
        super.setEnabled(r100);
        if (r100 == true) goto L6;
        d();
        return;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public void setNestedScrollingEnabled(boolean r100) {
        this.f113787j.setNestedScrollingEnabled(r100);
    }

    public void setOnRefreshListener(SwipeRefreshLayout.f r100) {
        this.f113779b = r100;
    }

    public void setProgressBackgroundColor(int r100) {
        setProgressBackgroundColorSchemeResource(r100);
    }

    public void setProgressBackgroundColorSchemeColor(int r100) {
        this.f113800w.f113837b.f113869w = r100;
    }

    public void setProgressBackgroundColorSchemeResource(int r100) {
        setProgressBackgroundColorSchemeColor(ContextCompat.getColor(getContext(), r100));
    }

    public void setRefreshing(boolean r100) {
        if (r100 == true) goto L5;
    L10:
        e(r100, false);
        return;
    L5:
        if (this.f113780c == r100) goto L10;
        this.f113780c = r100;
        this.A = false;
        a r101 = this.E;
        this.f113800w.f113837b.f113867u = 255;
        no1.b r102 = new no1.b(this);
        this.f113801x = r102;
        r102.setDuration(this.f113791n);
        if (r101 == null) goto L9;
        r101.onAnimationEnd(this.f113801x);
    L9:
        this.f113797t.b();
        this.f113784g.startScroll(0, getScrollY(), 0, (int) (-this.f113782e));
    }

    public void setSize(int r100) {
        if (r100 != 0) goto L4;
    L6:
        Resources r101 = getResources();
        DisplayMetrics r102 = WindowDisplayMetricsOverride.apply(r101, r101.getDisplayMetrics());
        if (r100 != 0) goto L9;
        this.B = (int) (r102.density * 56.0f);
    L10:
        this.f113800w.d(r100);
        return;
    L9:
        this.B = (int) (r102.density * 40.0f);
        goto L10
    L4:
        if (r100 == 1) goto L6;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public final boolean startNestedScroll(int r100) {
        return this.f113787j.startNestedScroll(r100);
    }

    public DoubleBallSwipeRefreshLayout(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.f113780c = false;
        this.f113782e = -1.0f;
        this.f113783f = false;
        this.f113788k = new int[2];
        this.f113789l = new int[2];
        this.f113795r = -1;
        this.E = new a(this);
        this.F = new c(this);
        this.G = new d(this);
        this.H = new e();
        this.f113781d = ViewConfiguration.get(r100).getScaledTouchSlop();
        this.f113784g = new Scroller(r100, new AccelerateDecelerateInterpolator());
        this.f113791n = getResources().getInteger(R.integer.config_mediumAnimTime);
        setWillNotDraw(false);
        this.f113796s = new DecelerateInterpolator(2.0f);
        Resources r102 = getResources();
        DisplayMetrics r103 = WindowDisplayMetricsOverride.apply(r102, r102.getDisplayMetrics());
        float r104 = r103.density;
        this.B = (int) (40.0f * r104);
        this.C = (int) (r104 * 56.0f);
        this.D = (int) (r104 * 32.0f);
        MaterialProgressDrawable r105 = new MaterialProgressDrawable(getContext(), this);
        this.f113800w = r105;
        r105.f113837b.f113869w = -328966;
        ViewCompat.setChildrenDrawingOrderEnabled(this, true);
        int r106 = (int) (r103.density * 56.0f);
        this.f113799v = r106;
        this.f113782e = r106;
        this.f113786i = new NestedScrollingParentHelper(this);
        this.f113787j = new NestedScrollingChildHelper(this);
        setNestedScrollingEnabled(true);
        this.f113798u = -this.B;
        TypedArray r107 = r100.obtainStyledAttributes(r101, I);
        setEnabled(r107.getBoolean(0, true));
        r107.recycle();
        this.f113797t = new LiveDoubleColorBallAnimationView(getContext());
        if (LiveInfraSettingKeys.LIVE_ANIMATION_LEAK.getValue().doubleColorBall == false) goto L5;
        this.f113797t.setStartAnimationAfterAttach(false);
    L5:
        addView(this.f113797t);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public final boolean dispatchNestedPreFling(float r100, float r101) {
        return this.f113787j.dispatchNestedPreFling(r100, r101);
    }

    public final void e(boolean r100, boolean r101) {
        this.H.getClass();
        if (this.f113780c == r100) goto L11;
        this.A = r101;
        a();
        this.f113780c = r100;
        if (r100 == false) goto L9;
        a r102 = this.E;
        e r103 = this.H;
        r103.getClass();
        Objects.toString(r102);
        r103.b(false);
        this.F.reset();
        this.F.setDuration(200);
        this.F.setInterpolator(this.f113796s);
        this.f113797t.setCycleBias(1);
        this.f113797t.b();
        this.f113784g.startScroll(0, getScrollY(), 0, (-getScrollY()) - this.C, Math.abs(((-getScrollY()) - this.C) * 2));
        invalidate();
        if (r102 == null) goto L12;
        r102.onAnimationEnd(this.F);
        return;
    L12:
        return;
    L9:
        this.f113784g.forceFinished(true);
        this.f113784g.startScroll(0, getScrollY(), 0, -getScrollY(), Math.abs(getScrollY() * 2));
        invalidate();
        this.f113797t.c();
        return;
    }

    @Override // android.view.View
    public final void onMeasure(int r100, int r101) {
        super.onMeasure(r100, r101);
        if (this.f113778a != null) goto L5;
        a();
    L5:
        View r102 = this.f113778a;
        if (r102 != null) goto L17;
        return;
    L17:
        r102.measure(View.MeasureSpec.makeMeasureSpec((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), 1073741824), View.MeasureSpec.makeMeasureSpec((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), 1073741824));     // Catch: IllegalStateException -> L11
    L14:
        this.f113797t.measure(View.MeasureSpec.makeMeasureSpec(this.D, 1073741824), View.MeasureSpec.makeMeasureSpec(this.D, 1073741824));
        return;
    L11:
        e = move-exception;
        if (this.f113783f == false) goto L14;
        throw e;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public final boolean dispatchNestedFling(float r100, float r101, boolean r102) {
        return this.f113787j.dispatchNestedFling(r100, r101, r102);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public final boolean onNestedPreFling(View r100, float r101, float r102) {
        return dispatchNestedPreFling(r101, r102);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public final void onNestedScrollAccepted(View r100, View r101, int r102) {
        this.f113786i.onNestedScrollAccepted(r100, r101, r102);
        startNestedScroll(r102 & 2);
        this.f113785h = 0.0f;
        this.f113790m = true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public final boolean onStartNestedScroll(View r100, View r101, int r102) {
        if (isEnabled() == true) goto L5;
    L9:
        return false;
    L5:
        if (this.f113780c == true) goto L9;
        if ((r102 & 2) == 0) goto L9;
        return true;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public final boolean dispatchNestedPreScroll(int r100, int r101, int[] r102, int[] r103) {
        return this.f113787j.dispatchNestedPreScroll(r100, r101, r102, r103);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public final boolean onNestedFling(View r100, float r101, float r102, boolean r103) {
        return dispatchNestedFling(r101, r102, r103);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public final void onNestedPreScroll(View r100, int r101, int r102, int[] r103) {
        if (r102 <= 0) goto L11;
        float r104 = this.f113785h;
        if (r104 <= 0.0f) goto L11;
        float r105 = r102;
        if (r105 <= r104) goto L9;
        r103[1] = r102 - ((int) r104);
        this.f113785h = 0.0f;
    L10:
        c(this.f113785h);
        goto L11
    L9:
        this.f113785h = r104 - r105;
        r103[1] = r102;
    L11:
        int[] r106 = this.f113788k;
        if (dispatchNestedPreScroll(r101 - r103[0], r102 - r103[1], r106, null) == false) goto L15;
        r103[0] = r103[0] + r106[0];
        r103[1] = r103[1] + r106[1];
        return;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public final boolean dispatchNestedScroll(int r100, int r101, int r102, int r110, int[] r111) {
        return this.f113787j.dispatchNestedScroll(r100, r101, r102, r110, r111);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r100, int r101, int r102, int r103, int r104) {
        int r105 = getMeasuredWidth();
        int r106 = getMeasuredHeight();
        if (getChildCount() != 0) goto L6;
        return;
    L6:
        if (this.f113778a != null) goto L8;
        a();
    L8:
        View r107 = this.f113778a;
        if (r107 != null) goto L11;
        return;
    L11:
        int r108 = getPaddingLeft();
        int r109 = getPaddingTop();
        int r110 = (r105 - getPaddingLeft()) - getPaddingRight();
        r107.layout(r108, r109, r110 + r108, ((r106 - getPaddingTop()) - getPaddingBottom()) + r109);     // Catch: Exception -> L14
    L17:
        int r111 = this.f113797t.getMeasuredWidth();
        int r112 = this.f113797t.getMeasuredHeight();
        int r113 = (r105 - r111) / 2;
        int r114 = (this.C + r112) / 2;
        this.f113797t.layout(r113, -r114, r111 + r113, 0);
        return;
    L14:
        e = move-exception;
        if (this.f113783f == false) goto L17;
        throw e;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public final void onNestedScroll(View r100, int r101, int r102, int r110, int r111) {
        dispatchNestedScroll(r101, r102, r110, r111, this.f113789l);
        int r112 = r111 + this.f113789l[1];
        if (r112 < 0) goto L5;
        return;
    L5:
        if (ViewCompat.canScrollVertically(this.f113778a, -1) == true) goto L9;
        float r103 = this.f113785h + Math.abs(r112);
        this.f113785h = r103;
        c(r103);
        return;
    }
}
