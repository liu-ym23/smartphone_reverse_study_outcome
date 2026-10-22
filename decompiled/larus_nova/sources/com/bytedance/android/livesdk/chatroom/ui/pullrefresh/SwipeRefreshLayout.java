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
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Transformation;
import androidx.camera.video.AudioStats;
import androidx.core.view.MotionEventCompat;
import androidx.core.view.NestedScrollingChild;
import androidx.core.view.NestedScrollingChildHelper;
import androidx.core.view.NestedScrollingParent;
import androidx.core.view.NestedScrollingParentHelper;
import androidx.core.view.ViewCompat;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import java.util.Objects;
import no1.h;
import no1.i;
import no1.j;

/* JADX INFO: loaded from: classes8.dex */
public class SwipeRefreshLayout extends ViewGroup implements NestedScrollingParent, NestedScrollingChild {
    public static final int[] I = null;
    public j A;
    public j B;
    public boolean C;
    public final int D;
    public final a E;
    public final c F;
    public final d G;
    public final e H;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public View f113871a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public f f113872b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f113873c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f113874d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final float f113875e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f113876f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final NestedScrollingParentHelper f113877g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final NestedScrollingChildHelper f113878h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int[] f113879i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int[] f113880j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f113881k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final int f113882l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f113883m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public float f113884n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public float f113885o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f113886p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f113887q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final DecelerateInterpolator f113888r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public no1.a f113889s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f113890t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f113891u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final int f113892v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final int f113893w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public MaterialProgressDrawable f113894x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public h f113895y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public i f113896z;

    public class a implements Animation.AnimationListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SwipeRefreshLayout f113897a;

        @Override // android.view.animation.Animation.AnimationListener
        public final void onAnimationRepeat(Animation r100) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public final void onAnimationStart(Animation r100) {
        }

        public a(SwipeRefreshLayout r100) {
            this.f113897a = r100;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public final void onAnimationEnd(Animation r100) {
            SwipeRefreshLayout r101 = this.f113897a;
            if (r101.f113873c == false) goto L10;
            r101.H.b(false);
            MaterialProgressDrawable r102 = this.f113897a.f113894x;
            r102.f113837b.f113867u = 255;
            r102.start();
            SwipeRefreshLayout r103 = this.f113897a;
            if (r103.C == false) goto L9;
            f r104 = r103.f113872b;
            if (r104 == null) goto L9;
            r104.onRefresh();
        L9:
            SwipeRefreshLayout r105 = this.f113897a;
            r105.f113883m = r105.f113889s.getTop();
            return;
        L10:
            r101.e();
        }
    }

    public class b implements Animation.AnimationListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SwipeRefreshLayout f113898a;

        @Override // android.view.animation.Animation.AnimationListener
        public final void onAnimationRepeat(Animation r100) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public final void onAnimationStart(Animation r100) {
        }

        public b(SwipeRefreshLayout r100) {
            this.f113898a = r100;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public final void onAnimationEnd(Animation r100) {
            this.f113898a.getClass();
            SwipeRefreshLayout r101 = this.f113898a;
            r101.getClass();
            i r102 = new i(r101);
            r101.f113896z = r102;
            r102.setDuration(150);
            no1.a r103 = r101.f113889s;
            r103.f519884a = null;
            r103.clearAnimation();
            r101.f113889s.startAnimation(r101.f113896z);
        }
    }

    public class c extends Animation {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SwipeRefreshLayout f113899a;

        public c(SwipeRefreshLayout r100) {
            this.f113899a = r100;
        }

        @Override // android.view.animation.Animation
        public final void applyTransformation(float r100, Transformation r101) {
            this.f113899a.getClass();
            SwipeRefreshLayout r102 = this.f113899a;
            int r103 = r102.f113893w - Math.abs(r102.f113892v);
            SwipeRefreshLayout r104 = this.f113899a;
            int r105 = r104.f113891u;
            this.f113899a.g((r105 + ((int) ((r103 - r105) * r100))) - r104.f113889s.getTop());
            this.f113899a.f113894x.a(1.0f - r100);
        }
    }

    public class d extends Animation {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SwipeRefreshLayout f113900a;

        public d(SwipeRefreshLayout r100) {
            this.f113900a = r100;
        }

        @Override // android.view.animation.Animation
        public final void applyTransformation(float r100, Transformation r101) {
            this.f113900a.d(r100);
        }
    }

    public class e extends no1.g {
        @Override // no1.g
        public final void a() {
        }

        public e() {
        }
    }

    public interface f {
        void onRefresh();
    }

    public interface g {
    }

    static {
        I = new int[]{R.attr.enabled};
    }

    public final void a() {
        if (this.f113871a != null) goto L11;
        int r100 = 0;
    L6:
        if (r100 >= getChildCount()) goto L15;
        View r101 = getChildAt(r100);
        if (r101.equals(this.f113889s) == false) goto L9;
        r100 = r100 + 1;
        goto L6
    L9:
        this.f113871a = r101;
        return;
    L15:
        return;
    }

    public final void e() {
        this.H.b(true);
        this.f113889s.clearAnimation();
        this.f113894x.stop();
        this.f113889s.setVisibility(8);
        setColorViewAlpha(255);
        g(this.f113892v - this.f113883m);
        this.f113883m = this.f113889s.getTop();
    }

    @Override // android.view.ViewGroup, androidx.core.view.NestedScrollingParent
    public int getNestedScrollAxes() {
        return this.f113877g.getNestedScrollAxes();
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public final boolean hasNestedScrollingParent() {
        return this.f113878h.hasNestedScrollingParent();
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public final boolean isNestedScrollingEnabled() {
        return this.f113878h.isNestedScrollingEnabled();
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public final void stopNestedScroll() {
        this.f113878h.stopNestedScroll();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        e();
    }

    public int getProgressViewEndOffset() {
        return this.f113893w;
    }

    public int getProgressViewStartOffset() {
        return this.f113892v;
    }

    public SwipeRefreshLayout(Context r100) {
        this(r100, null);
    }

    private void setColorViewAlpha(int r100) {
        this.f113889s.getBackground().setAlpha(r100);
        this.f113894x.f113837b.f113867u = r100;
    }

    public final void b(float r100) {
        if (r100 <= this.f113875e) goto L5;
        f(true, true);
        return;
    L5:
        this.f113873c = false;
        MaterialProgressDrawable r101 = this.f113894x;
        MaterialProgressDrawable.b r102 = r101.f113837b;
        r102.f113851e = 0.0f;
        r102.a();
        MaterialProgressDrawable.b r103 = r101.f113837b;
        r103.f113852f = 0.0f;
        r103.a();
        b r104 = new b(this);
        int r105 = this.f113883m;
        e r106 = this.H;
        r106.getClass();
        no1.f r107 = new no1.f(r106, r104);
        e r108 = this.H;
        r108.getClass();
        Objects.toString(r107);
        r108.b(false);
        this.f113891u = r105;
        this.G.reset();
        this.G.setDuration(200);
        this.G.setInterpolator(this.f113888r);
        no1.a r109 = this.f113889s;
        r109.f519884a = r107;
        r109.clearAnimation();
        this.f113889s.startAnimation(this.G);
        MaterialProgressDrawable.b r110 = this.f113894x.f113837b;
        if (r110.f113861o == false) goto L10;
        r110.f113861o = false;
        r110.a();
        return;
    }

    public final void c(float r110) {
        MaterialProgressDrawable.b r100 = this.f113894x.f113837b;
        boolean r101 = true;
        if (r100.f113861o == true) goto L5;
        r100.f113861o = true;
        r100.a();
    L5:
        float r102 = Math.min(1.0f, Math.abs(r110 / this.f113875e));
        float r103 = (((float) Math.max(((double) r102) - 0.4d, AudioStats.AUDIO_AMPLITUDE_NONE)) * 5.0f) / 3.0f;
        float r104 = Math.abs(r110) - this.f113875e;
        float r105 = this.f113893w;
        double r106 = Math.max(0.0f, Math.min(r104, r105 * 2.0f) / r105) / 4.0f;
        float r107 = ((float) (r106 - Math.pow(r106, 2.0d))) * 2.0f;
        int r108 = this.f113892v + ((int) ((r105 * r102) + ((r105 * r107) * 2.0f)));
        if (this.f113889s.getVisibility() == 0) goto L8;
        this.f113889s.setVisibility(0);
    L8:
        ViewCompat.setScaleX(this.f113889s, 1.0f);
        ViewCompat.setScaleY(this.f113889s, 1.0f);
        if (r110 >= this.f113875e) goto L23;
        if (this.f113894x.f113837b.f113867u <= 76) goto L34;
        j r111 = this.A;
        if (r111 != null) goto L15;
    L19:
        r101 = false;
    L20:
        if (r101 == true) goto L34;
        j r109 = new j(this, this.f113894x.f113837b.f113867u, 76);
        r109.setDuration(300);
        no1.a r112 = this.f113889s;
        r112.f519884a = null;
        r112.clearAnimation();
        this.f113889s.startAnimation(r109);
        this.A = r109;
        goto L34
    L15:
        if (r111.hasStarted() == false) goto L19;
        if (r111.hasEnded() == true) goto L19;
    L34:
        MaterialProgressDrawable r113 = this.f113894x;
        float r114 = Math.min(0.8f, r103 * 0.8f);
        MaterialProgressDrawable.b r115 = r113.f113837b;
        r115.f113851e = 0.0f;
        r115.a();
        MaterialProgressDrawable.b r116 = r113.f113837b;
        r116.f113852f = r114;
        r116.a();
        this.f113894x.a(Math.min(1.0f, r103));
        MaterialProgressDrawable.b r117 = this.f113894x.f113837b;
        r117.f113853g = (((r103 * 0.4f) - 0.25f) + (r107 * 2.0f)) * 0.5f;
        r117.a();
        g(r108 - this.f113883m);
        e r118 = this.H;
        r118.getClass();
        r118.b(false);
        return;
    L23:
        if (this.f113894x.f113837b.f113867u >= 255) goto L34;
        j r119 = this.B;
        if (r119 != null) goto L27;
    L31:
        r101 = false;
    L32:
        if (r101 == true) goto L34;
        j r120 = new j(this, this.f113894x.f113837b.f113867u, 255);
        r120.setDuration(300);
        no1.a r121 = this.f113889s;
        r121.f519884a = null;
        r121.clearAnimation();
        this.f113889s.startAnimation(r120);
        this.B = r120;
        goto L34
    L27:
        if (r119.hasStarted() == false) goto L31;
        if (r119.hasEnded() == true) goto L31;
        goto L31
    }

    public final void d(float r100) {
        int r101 = this.f113891u;
        g((r101 + ((int) ((this.f113892v - r101) * r100))) - this.f113889s.getTop());
    }

    public final void g(int r100) {
        this.f113889s.bringToFront();
        ViewCompat.offsetTopAndBottom(this.f113889s, r100);
        this.f113883m = this.f113889s.getTop();
    }

    public final void h(float r100) {
        float r101 = this.f113885o;
        float r102 = r100 - r101;
        int r103 = this.f113874d;
        if (r102 > r103) goto L5;
        return;
    L5:
        if (this.f113886p == true) goto L9;
        this.f113884n = r101 + r103;
        this.f113886p = true;
        this.f113894x.f113837b.f113867u = 76;
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
        if (ViewCompat.canScrollVertically(this.f113871a, -1) == true) goto L40;
        if (this.f113873c == true) goto L40;
        if (this.f113881k == true) goto L40;
        if (r101 != 0) goto L13;
        g(this.f113892v - this.f113889s.getTop());
        int r103 = r100.getPointerId(0);
        this.f113887q = r103;
        this.f113886p = false;
        int r104 = r100.findPointerIndex(r103);
        if (r104 >= 0) goto L37;
        return false;
    L37:
        this.f113885o = r100.getY(r104);
    L39:
        return this.f113886p;
    L13:
        if (r101 != 1) goto L15;
    L33:
        this.f113886p = false;
        this.f113887q = -1;
        goto L39
    L15:
        if (r101 != 2) goto L17;
        int r105 = this.f113887q;
        if (r105 != (-1)) goto L29;
        return false;
    L29:
        int r106 = r100.findPointerIndex(r105);
        if (r106 >= 0) goto L32;
        return false;
    L32:
        h(r100.getY(r106));
        goto L39
    L17:
        if (r101 == 3) goto L33;
        if (r101 != 6) goto L39;
        int r107 = MotionEventCompat.getActionIndex(r100);
        if (r100.getPointerId(r107) != this.f113887q) goto L39;
        if (r107 != 0) goto L25;
        r102 = 1;
    L25:
        this.f113887q = r100.getPointerId(r102);
        goto L39
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public final void onStopNestedScroll(View r100) {
        this.f113877g.onStopNestedScroll(r100);
        this.f113881k = false;
        float r101 = this.f113876f;
        if (r101 <= 0.0f) goto L5;
        b(r101);
        this.f113876f = 0.0f;
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
        if (ViewCompat.canScrollVertically(this.f113871a, -1) == true) goto L53;
        if (this.f113873c == true) goto L53;
        if (this.f113881k == true) goto L53;
        if (r101 != 0) goto L14;
        this.f113887q = r100.getPointerId(0);
        this.f113886p = false;
    L52:
        return true;
    L14:
        if (r101 != 1) goto L16;
    L43:
        int r103 = r100.findPointerIndex(this.f113887q);
        if (r103 >= 0) goto L47;
        return false;
    L47:
        if (this.f113886p == false) goto L49;
        float r104 = (r100.getY(r103) - this.f113884n) * 0.5f;
        this.f113886p = false;
        b(r104);
    L49:
        this.f113887q = -1;
        return false;
    L16:
        if (r101 != 2) goto L18;
        int r105 = r100.findPointerIndex(this.f113887q);
        if (r105 >= 0) goto L36;
        return false;
    L36:
        float r106 = r100.getY(r105);
        h(r106);
        if (this.f113886p == false) goto L52;
        float r107 = (r106 - this.f113884n) * 0.5f;
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
        this.f113887q = r100.getPointerId(r108);
        goto L52
    L22:
        if (r101 != 6) goto L52;
        int r109 = MotionEventCompat.getActionIndex(r100);
        if (r100.getPointerId(r109) != this.f113887q) goto L52;
        if (r109 != 0) goto L28;
        r102 = 1;
    L28:
        this.f113887q = r100.getPointerId(r102);
        goto L52
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void requestDisallowInterceptTouchEvent(boolean r100) {
        super.requestDisallowInterceptTouchEvent(r100);
    }

    public void setAnimationProgress(float r100) {
        ViewCompat.setScaleX(this.f113889s, r100);
        ViewCompat.setScaleY(this.f113889s, r100);
    }

    @Override // android.view.View
    public void setEnabled(boolean r100) {
        super.setEnabled(r100);
        if (r100 == true) goto L6;
        e();
        return;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public void setNestedScrollingEnabled(boolean r100) {
        this.f113878h.setNestedScrollingEnabled(r100);
    }

    public void setOnRefreshListener(f r100) {
        this.f113872b = r100;
    }

    public void setRefreshing(boolean r100) {
        if (r100 == true) goto L5;
    L10:
        f(r100, false);
        return;
    L5:
        if (this.f113873c == r100) goto L10;
        this.f113873c = r100;
        g((this.f113893w + this.f113892v) - this.f113883m);
        this.C = false;
        a r101 = this.E;
        this.f113889s.setVisibility(0);
        this.f113894x.f113837b.f113867u = 255;
        h r102 = new h(this);
        this.f113895y = r102;
        r102.setDuration(this.f113882l);
        if (r101 == null) goto L9;
        this.f113889s.f519884a = r101;
    L9:
        this.f113889s.clearAnimation();
        this.f113889s.startAnimation(this.f113895y);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public final boolean startNestedScroll(int r100) {
        return this.f113878h.startNestedScroll(r100);
    }

    public SwipeRefreshLayout(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.f113873c = false;
        this.f113875e = -1.0f;
        this.f113879i = new int[2];
        this.f113880j = new int[2];
        this.f113887q = -1;
        this.f113890t = -1;
        this.E = new a(this);
        this.F = new c(this);
        this.G = new d(this);
        this.H = new e();
        this.f113874d = ViewConfiguration.get(r100).getScaledTouchSlop();
        this.f113882l = getResources().getInteger(R.integer.config_mediumAnimTime);
        setWillNotDraw(false);
        this.f113888r = new DecelerateInterpolator(2.0f);
        Resources r102 = getResources();
        DisplayMetrics r103 = WindowDisplayMetricsOverride.apply(r102, r102.getDisplayMetrics());
        int r104 = (int) (r103.density * 40.0f);
        this.D = r104;
        this.f113889s = new no1.a(getContext());
        MaterialProgressDrawable r105 = new MaterialProgressDrawable(getContext(), this);
        this.f113894x = r105;
        r105.f113837b.f113869w = -328966;
        this.f113889s.setImageDrawable(r105);
        this.f113889s.setVisibility(8);
        addView(this.f113889s);
        ViewCompat.setChildrenDrawingOrderEnabled(this, true);
        int r106 = (int) (r103.density * 64.0f);
        this.f113893w = r106;
        this.f113875e = r106;
        this.f113877g = new NestedScrollingParentHelper(this);
        this.f113878h = new NestedScrollingChildHelper(this);
        setNestedScrollingEnabled(true);
        int r107 = -r104;
        this.f113883m = r107;
        this.f113892v = r107;
        d(1.0f);
        TypedArray r108 = r100.obtainStyledAttributes(r101, I);
        setEnabled(r108.getBoolean(0, true));
        r108.recycle();
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public final boolean dispatchNestedPreFling(float r100, float r101) {
        return this.f113878h.dispatchNestedPreFling(r100, r101);
    }

    public final void f(boolean r100, boolean r101) {
        this.H.getClass();
        if (this.f113873c == r100) goto L12;
        this.C = r101;
        a();
        this.f113873c = r100;
        if (r100 == false) goto L10;
        int r102 = this.f113883m;
        a r103 = this.E;
        e r104 = this.H;
        r104.getClass();
        Objects.toString(r103);
        r104.b(false);
        this.f113891u = r102;
        this.F.reset();
        this.F.setDuration(200);
        this.F.setInterpolator(this.f113888r);
        if (r103 == null) goto L9;
        this.f113889s.f519884a = r103;
    L9:
        this.f113889s.clearAnimation();
        this.f113889s.startAnimation(this.F);
        return;
    L10:
        a r105 = this.E;
        i r106 = new i(this);
        this.f113896z = r106;
        r106.setDuration(150);
        no1.a r107 = this.f113889s;
        r107.f519884a = r105;
        r107.clearAnimation();
        this.f113889s.startAnimation(this.f113896z);
        return;
    }

    @Override // android.view.ViewGroup
    public final int getChildDrawingOrder(int r100, int r101) {
        int r102 = this.f113890t;
        if (r102 >= 0) goto L6;
        return r101;
    L6:
        if (r101 != (r100 - 1)) goto L8;
        return r102;
    L8:
        if (r101 >= r102) goto L10;
        return r101;
    L10:
        return r101 + 1;
    }

    @Override // android.view.View
    public final void onMeasure(int r100, int r101) {
        super.onMeasure(r100, r101);
        if (this.f113871a != null) goto L5;
        a();
    L5:
        View r102 = this.f113871a;
        if (r102 != null) goto L19;
        return;
    L19:
        r102.measure(View.MeasureSpec.makeMeasureSpec((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), 1073741824), View.MeasureSpec.makeMeasureSpec((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), 1073741824));     // Catch: IllegalStateException -> L18
    L10:
        this.f113889s.measure(View.MeasureSpec.makeMeasureSpec(this.D, 1073741824), View.MeasureSpec.makeMeasureSpec(this.D, 1073741824));
        this.f113890t = -1;
        int r103 = 0;
    L12:
        if (r103 >= getChildCount()) goto L23;
        if (getChildAt(r103) == this.f113889s) goto L15;
        r103 = r103 + 1;
        goto L12
    L15:
        this.f113890t = r103;
        return;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public final boolean dispatchNestedFling(float r100, float r101, boolean r102) {
        return this.f113878h.dispatchNestedFling(r100, r101, r102);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public final boolean onNestedPreFling(View r100, float r101, float r102) {
        return dispatchNestedPreFling(r101, r102);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public final void onNestedScrollAccepted(View r100, View r101, int r102) {
        this.f113877g.onNestedScrollAccepted(r100, r101, r102);
        startNestedScroll(r102 & 2);
        this.f113876f = 0.0f;
        this.f113881k = true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public final boolean onStartNestedScroll(View r100, View r101, int r102) {
        if (isEnabled() == true) goto L5;
    L9:
        return false;
    L5:
        if (this.f113873c == true) goto L9;
        if ((r102 & 2) == 0) goto L9;
        return true;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public final boolean dispatchNestedPreScroll(int r100, int r101, int[] r102, int[] r103) {
        return this.f113878h.dispatchNestedPreScroll(r100, r101, r102, r103);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public final boolean onNestedFling(View r100, float r101, float r102, boolean r103) {
        return dispatchNestedFling(r101, r102, r103);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public final void onNestedPreScroll(View r100, int r101, int r102, int[] r103) {
        if (r102 <= 0) goto L11;
        float r104 = this.f113876f;
        if (r104 <= 0.0f) goto L11;
        float r105 = r102;
        if (r105 <= r104) goto L9;
        r103[1] = r102 - ((int) r104);
        this.f113876f = 0.0f;
    L10:
        c(this.f113876f);
        goto L11
    L9:
        this.f113876f = r104 - r105;
        r103[1] = r102;
    L11:
        int[] r106 = this.f113879i;
        if (dispatchNestedPreScroll(r101 - r103[0], r102 - r103[1], r106, null) == false) goto L15;
        r103[0] = r103[0] + r106[0];
        r103[1] = r103[1] + r106[1];
        return;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public final boolean dispatchNestedScroll(int r100, int r101, int r102, int r110, int[] r111) {
        return this.f113878h.dispatchNestedScroll(r100, r101, r102, r110, r111);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r100, int r101, int r102, int r103, int r104) {
        int r105 = getMeasuredWidth();
        int r106 = getMeasuredHeight();
        if (getChildCount() != 0) goto L6;
        return;
    L6:
        if (this.f113871a != null) goto L8;
        a();
    L8:
        View r107 = this.f113871a;
        if (r107 != null) goto L11;
        return;
    L11:
        int r108 = getPaddingLeft();
        int r109 = getPaddingTop();
        int r110 = (r105 - getPaddingLeft()) - getPaddingRight();
        r107.layout(r108, r109, r110 + r108, ((r106 - getPaddingTop()) - getPaddingBottom()) + r109);     // Catch: Exception -> L15
    L13:
        int r111 = this.f113889s.getMeasuredWidth();
        int r112 = this.f113889s.getMeasuredHeight();
        int r113 = r105 / 2;
        int r114 = r111 / 2;
        int r115 = this.f113883m;
        this.f113889s.layout(r113 - r114, r115, r113 + r114, r112 + r115);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public final void onNestedScroll(View r100, int r101, int r102, int r110, int r111) {
        dispatchNestedScroll(r101, r102, r110, r111, this.f113880j);
        int r112 = r111 + this.f113880j[1];
        if (r112 < 0) goto L5;
        return;
    L5:
        if (ViewCompat.canScrollVertically(this.f113871a, -1) == true) goto L9;
        float r103 = this.f113876f + Math.abs(r112);
        this.f113876f = r103;
        c(r103);
        return;
    }
}
