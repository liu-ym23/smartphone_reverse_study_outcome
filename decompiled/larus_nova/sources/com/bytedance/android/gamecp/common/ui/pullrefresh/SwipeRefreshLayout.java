package com.bytedance.android.gamecp.common.ui.pullrefresh;

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

/* JADX INFO: loaded from: classes44.dex */
public class SwipeRefreshLayout extends ViewGroup implements NestedScrollingParent, NestedScrollingChild {
    public static final int[] H = null;
    public ev.f A;
    public boolean B;
    public final int C;
    public final a D;
    public final c E;
    public final d F;
    public final e G;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public View f57092a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f57093b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f57094c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float f57095d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f57096e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final NestedScrollingParentHelper f57097f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final NestedScrollingChildHelper f57098g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int[] f57099h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int[] f57100i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f57101j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final int f57102k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f57103l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public float f57104m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public float f57105n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f57106o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f57107p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final DecelerateInterpolator f57108q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public ev.a f57109r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f57110s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f57111t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final int f57112u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final int f57113v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public MaterialProgressDrawable f57114w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public ev.d f57115x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public ev.e f57116y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public ev.f f57117z;

    public class a implements Animation.AnimationListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SwipeRefreshLayout f57118a;

        @Override // android.view.animation.Animation.AnimationListener
        public final void onAnimationRepeat(Animation r100) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public final void onAnimationStart(Animation r100) {
        }

        public a(SwipeRefreshLayout r100) {
            this.f57118a = r100;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public final void onAnimationEnd(Animation r100) {
            SwipeRefreshLayout r101 = this.f57118a;
            if (r101.f57093b == false) goto L5;
            r101.G.b(false);
            MaterialProgressDrawable r102 = this.f57118a.f57114w;
            r102.f57059b.f57088u = 255;
            r102.start();
            SwipeRefreshLayout r103 = this.f57118a;
            boolean r104 = r103.B;
            r103.f57103l = r103.f57109r.getTop();
            return;
        L5:
            r101.e();
        }
    }

    public class b implements Animation.AnimationListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SwipeRefreshLayout f57119a;

        @Override // android.view.animation.Animation.AnimationListener
        public final void onAnimationRepeat(Animation r100) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public final void onAnimationStart(Animation r100) {
        }

        public b(SwipeRefreshLayout r100) {
            this.f57119a = r100;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public final void onAnimationEnd(Animation r100) {
            this.f57119a.getClass();
            SwipeRefreshLayout r101 = this.f57119a;
            r101.getClass();
            ev.e r102 = new ev.e(r101);
            r101.f57116y = r102;
            r102.setDuration(150);
            ev.a r103 = r101.f57109r;
            r103.f474184a = null;
            r103.clearAnimation();
            r101.f57109r.startAnimation(r101.f57116y);
        }
    }

    public class c extends Animation {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SwipeRefreshLayout f57120a;

        public c(SwipeRefreshLayout r100) {
            this.f57120a = r100;
        }

        @Override // android.view.animation.Animation
        public final void applyTransformation(float r100, Transformation r101) {
            this.f57120a.getClass();
            SwipeRefreshLayout r102 = this.f57120a;
            int r103 = r102.f57113v - Math.abs(r102.f57112u);
            SwipeRefreshLayout r104 = this.f57120a;
            int r105 = r104.f57111t;
            this.f57120a.g((r105 + ((int) ((r103 - r105) * r100))) - r104.f57109r.getTop());
            float r106 = 1.0f - r100;
            MaterialProgressDrawable.b r107 = this.f57120a.f57114w.f57059b;
            if (r106 == r107.f57084q) goto L6;
            r107.f57084q = r106;
            r107.a();
            return;
        }
    }

    public class d extends Animation {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SwipeRefreshLayout f57121a;

        public d(SwipeRefreshLayout r100) {
            this.f57121a = r100;
        }

        @Override // android.view.animation.Animation
        public final void applyTransformation(float r100, Transformation r101) {
            this.f57121a.d(r100);
        }
    }

    public class e extends ev.c {
        @Override // ev.c
        public final void a() {
        }

        public e() {
        }
    }

    public interface f {
    }

    public void setOnRefreshListener(f r100) {
    }

    static {
        H = new int[]{R.attr.enabled};
    }

    public final void a() {
        if (this.f57092a != null) goto L11;
        int r100 = 0;
    L6:
        if (r100 >= getChildCount()) goto L15;
        View r101 = getChildAt(r100);
        if (r101.equals(this.f57109r) == false) goto L9;
        r100 = r100 + 1;
        goto L6
    L9:
        this.f57092a = r101;
        return;
    L15:
        return;
    }

    public final void e() {
        this.G.b(true);
        this.f57109r.clearAnimation();
        this.f57114w.stop();
        this.f57109r.setVisibility(8);
        setColorViewAlpha(255);
        g(this.f57112u - this.f57103l);
        this.f57103l = this.f57109r.getTop();
    }

    @Override // android.view.ViewGroup, androidx.core.view.NestedScrollingParent
    public int getNestedScrollAxes() {
        return this.f57097f.getNestedScrollAxes();
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public final boolean hasNestedScrollingParent() {
        return this.f57098g.hasNestedScrollingParent();
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public final boolean isNestedScrollingEnabled() {
        return this.f57098g.isNestedScrollingEnabled();
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public final void stopNestedScroll() {
        this.f57098g.stopNestedScroll();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        e();
    }

    public int getProgressViewEndOffset() {
        return this.f57113v;
    }

    public int getProgressViewStartOffset() {
        return this.f57112u;
    }

    public SwipeRefreshLayout(Context r100) {
        this(r100, null);
    }

    private void setColorViewAlpha(int r100) {
        this.f57109r.getBackground().setAlpha(r100);
        this.f57114w.f57059b.f57088u = r100;
    }

    public final void b(float r100) {
        if (r100 <= this.f57095d) goto L5;
        f(true, true);
        return;
    L5:
        this.f57093b = false;
        MaterialProgressDrawable r101 = this.f57114w;
        MaterialProgressDrawable.b r102 = r101.f57059b;
        r102.f57072e = 0.0f;
        r102.a();
        MaterialProgressDrawable.b r103 = r101.f57059b;
        r103.f57073f = 0.0f;
        r103.a();
        b r104 = new b(this);
        int r105 = this.f57103l;
        e r106 = this.G;
        r106.getClass();
        ev.b r107 = new ev.b(r106, r104);
        e r108 = this.G;
        r108.getClass();
        Objects.toString(r107);
        r108.b(false);
        this.f57111t = r105;
        this.F.reset();
        this.F.setDuration(200);
        this.F.setInterpolator(this.f57108q);
        ev.a r109 = this.f57109r;
        r109.f474184a = r107;
        r109.clearAnimation();
        this.f57109r.startAnimation(this.F);
        MaterialProgressDrawable.b r110 = this.f57114w.f57059b;
        if (r110.f57082o == false) goto L10;
        r110.f57082o = false;
        r110.a();
        return;
    }

    public final void c(float r110) {
        MaterialProgressDrawable.b r100 = this.f57114w.f57059b;
        boolean r101 = true;
        if (r100.f57082o == true) goto L5;
        r100.f57082o = true;
        r100.a();
    L5:
        float r102 = Math.min(1.0f, Math.abs(r110 / this.f57095d));
        float r103 = (((float) Math.max(((double) r102) - 0.4d, AudioStats.AUDIO_AMPLITUDE_NONE)) * 5.0f) / 3.0f;
        float r104 = Math.abs(r110) - this.f57095d;
        float r105 = this.f57113v;
        double r106 = Math.max(0.0f, Math.min(r104, r105 * 2.0f) / r105) / 4.0f;
        float r107 = ((float) (r106 - Math.pow(r106, 2.0d))) * 2.0f;
        int r108 = this.f57112u + ((int) ((r105 * r102) + ((r105 * r107) * 2.0f)));
        if (this.f57109r.getVisibility() == 0) goto L8;
        this.f57109r.setVisibility(0);
    L8:
        ViewCompat.setScaleX(this.f57109r, 1.0f);
        ViewCompat.setScaleY(this.f57109r, 1.0f);
        if (r110 >= this.f57095d) goto L23;
        if (this.f57114w.f57059b.f57088u <= 76) goto L34;
        ev.f r111 = this.f57117z;
        if (r111 != null) goto L15;
    L19:
        r101 = false;
    L20:
        if (r101 == true) goto L34;
        ev.f r109 = new ev.f(this, this.f57114w.f57059b.f57088u, 76);
        r109.setDuration(300);
        ev.a r112 = this.f57109r;
        r112.f474184a = null;
        r112.clearAnimation();
        this.f57109r.startAnimation(r109);
        this.f57117z = r109;
        goto L34
    L15:
        if (r111.hasStarted() == false) goto L19;
        if (r111.hasEnded() == true) goto L19;
    L34:
        MaterialProgressDrawable r113 = this.f57114w;
        float r114 = Math.min(0.8f, r103 * 0.8f);
        MaterialProgressDrawable.b r115 = r113.f57059b;
        r115.f57072e = 0.0f;
        r115.a();
        MaterialProgressDrawable.b r116 = r113.f57059b;
        r116.f57073f = r114;
        r116.a();
        MaterialProgressDrawable r117 = this.f57114w;
        float r118 = Math.min(1.0f, r103);
        MaterialProgressDrawable.b r119 = r117.f57059b;
        if (r118 == r119.f57084q) goto L37;
        r119.f57084q = r118;
        r119.a();
    L37:
        MaterialProgressDrawable.b r120 = this.f57114w.f57059b;
        r120.f57074g = (((r103 * 0.4f) - 0.25f) + (r107 * 2.0f)) * 0.5f;
        r120.a();
        g(r108 - this.f57103l);
        e r121 = this.G;
        r121.getClass();
        r121.b(false);
        return;
    L23:
        if (this.f57114w.f57059b.f57088u >= 255) goto L34;
        ev.f r122 = this.A;
        if (r122 != null) goto L27;
    L31:
        r101 = false;
    L32:
        if (r101 == true) goto L34;
        ev.f r123 = new ev.f(this, this.f57114w.f57059b.f57088u, 255);
        r123.setDuration(300);
        ev.a r124 = this.f57109r;
        r124.f474184a = null;
        r124.clearAnimation();
        this.f57109r.startAnimation(r123);
        this.A = r123;
        goto L34
    L27:
        if (r122.hasStarted() == false) goto L31;
        if (r122.hasEnded() == true) goto L31;
        goto L31
    }

    public final void d(float r100) {
        int r101 = this.f57111t;
        g((r101 + ((int) ((this.f57112u - r101) * r100))) - this.f57109r.getTop());
    }

    public final void g(int r100) {
        this.f57109r.bringToFront();
        ViewCompat.offsetTopAndBottom(this.f57109r, r100);
        this.f57103l = this.f57109r.getTop();
    }

    public final void h(float r100) {
        float r101 = this.f57105n;
        float r102 = r100 - r101;
        int r103 = this.f57094c;
        if (r102 > r103) goto L5;
        return;
    L5:
        if (this.f57106o == true) goto L9;
        this.f57104m = r101 + r103;
        this.f57106o = true;
        this.f57114w.f57059b.f57088u = 76;
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
        if (ViewCompat.canScrollVertically(this.f57092a, -1) == true) goto L40;
        if (this.f57093b == true) goto L40;
        if (this.f57101j == true) goto L40;
        if (r101 != 0) goto L13;
        g(this.f57112u - this.f57109r.getTop());
        int r103 = r100.getPointerId(0);
        this.f57107p = r103;
        this.f57106o = false;
        int r104 = r100.findPointerIndex(r103);
        if (r104 >= 0) goto L37;
        return false;
    L37:
        this.f57105n = r100.getY(r104);
    L39:
        return this.f57106o;
    L13:
        if (r101 != 1) goto L15;
    L33:
        this.f57106o = false;
        this.f57107p = -1;
        goto L39
    L15:
        if (r101 != 2) goto L17;
        int r105 = this.f57107p;
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
        if (r100.getPointerId(r107) != this.f57107p) goto L39;
        if (r107 != 0) goto L25;
        r102 = 1;
    L25:
        this.f57107p = r100.getPointerId(r102);
        goto L39
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public final void onStopNestedScroll(View r100) {
        this.f57097f.onStopNestedScroll(r100);
        this.f57101j = false;
        float r101 = this.f57096e;
        if (r101 <= 0.0f) goto L5;
        b(r101);
        this.f57096e = 0.0f;
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
        if (ViewCompat.canScrollVertically(this.f57092a, -1) == true) goto L53;
        if (this.f57093b == true) goto L53;
        if (this.f57101j == true) goto L53;
        if (r101 != 0) goto L14;
        this.f57107p = r100.getPointerId(0);
        this.f57106o = false;
    L52:
        return true;
    L14:
        if (r101 != 1) goto L16;
    L43:
        int r103 = r100.findPointerIndex(this.f57107p);
        if (r103 >= 0) goto L47;
        return false;
    L47:
        if (this.f57106o == false) goto L49;
        float r104 = (r100.getY(r103) - this.f57104m) * 0.5f;
        this.f57106o = false;
        b(r104);
    L49:
        this.f57107p = -1;
        return false;
    L16:
        if (r101 != 2) goto L18;
        int r105 = r100.findPointerIndex(this.f57107p);
        if (r105 >= 0) goto L36;
        return false;
    L36:
        float r106 = r100.getY(r105);
        h(r106);
        if (this.f57106o == false) goto L52;
        float r107 = (r106 - this.f57104m) * 0.5f;
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
        this.f57107p = r100.getPointerId(r108);
        goto L52
    L22:
        if (r101 != 6) goto L52;
        int r109 = MotionEventCompat.getActionIndex(r100);
        if (r100.getPointerId(r109) != this.f57107p) goto L52;
        if (r109 != 0) goto L28;
        r102 = 1;
    L28:
        this.f57107p = r100.getPointerId(r102);
        goto L52
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void requestDisallowInterceptTouchEvent(boolean r100) {
        super.requestDisallowInterceptTouchEvent(r100);
    }

    public void setAnimationProgress(float r100) {
        ViewCompat.setScaleX(this.f57109r, r100);
        ViewCompat.setScaleY(this.f57109r, r100);
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
        this.f57098g.setNestedScrollingEnabled(r100);
    }

    public void setRefreshing(boolean r100) {
        if (r100 == true) goto L5;
    L10:
        f(r100, false);
        return;
    L5:
        if (this.f57093b == r100) goto L10;
        this.f57093b = r100;
        g((this.f57113v + this.f57112u) - this.f57103l);
        this.B = false;
        a r101 = this.D;
        this.f57109r.setVisibility(0);
        this.f57114w.f57059b.f57088u = 255;
        ev.d r102 = new ev.d(this);
        this.f57115x = r102;
        r102.setDuration(this.f57102k);
        if (r101 == null) goto L9;
        this.f57109r.f474184a = r101;
    L9:
        this.f57109r.clearAnimation();
        this.f57109r.startAnimation(this.f57115x);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public final boolean startNestedScroll(int r100) {
        return this.f57098g.startNestedScroll(r100);
    }

    public SwipeRefreshLayout(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.f57093b = false;
        this.f57095d = -1.0f;
        this.f57099h = new int[2];
        this.f57100i = new int[2];
        this.f57107p = -1;
        this.f57110s = -1;
        this.D = new a(this);
        this.E = new c(this);
        this.F = new d(this);
        this.G = new e();
        this.f57094c = ViewConfiguration.get(r100).getScaledTouchSlop();
        this.f57102k = getResources().getInteger(R.integer.config_mediumAnimTime);
        setWillNotDraw(false);
        this.f57108q = new DecelerateInterpolator(2.0f);
        Resources r102 = getResources();
        DisplayMetrics r103 = WindowDisplayMetricsOverride.apply(r102, r102.getDisplayMetrics());
        int r104 = (int) (r103.density * 40.0f);
        this.C = r104;
        this.f57109r = new ev.a(getContext());
        MaterialProgressDrawable r105 = new MaterialProgressDrawable(getContext(), this);
        this.f57114w = r105;
        r105.f57059b.f57090w = -328966;
        this.f57109r.setImageDrawable(r105);
        this.f57109r.setVisibility(8);
        addView(this.f57109r);
        ViewCompat.setChildrenDrawingOrderEnabled(this, true);
        int r106 = (int) (r103.density * 64.0f);
        this.f57113v = r106;
        this.f57095d = r106;
        this.f57097f = new NestedScrollingParentHelper(this);
        this.f57098g = new NestedScrollingChildHelper(this);
        setNestedScrollingEnabled(true);
        int r107 = -r104;
        this.f57103l = r107;
        this.f57112u = r107;
        d(1.0f);
        TypedArray r108 = r100.obtainStyledAttributes(r101, H);
        setEnabled(r108.getBoolean(0, true));
        r108.recycle();
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public final boolean dispatchNestedPreFling(float r100, float r101) {
        return this.f57098g.dispatchNestedPreFling(r100, r101);
    }

    public final void f(boolean r100, boolean r101) {
        this.G.getClass();
        if (this.f57093b == r100) goto L12;
        this.B = r101;
        a();
        this.f57093b = r100;
        if (r100 == false) goto L10;
        int r102 = this.f57103l;
        a r103 = this.D;
        e r104 = this.G;
        r104.getClass();
        Objects.toString(r103);
        r104.b(false);
        this.f57111t = r102;
        this.E.reset();
        this.E.setDuration(200);
        this.E.setInterpolator(this.f57108q);
        if (r103 == null) goto L9;
        this.f57109r.f474184a = r103;
    L9:
        this.f57109r.clearAnimation();
        this.f57109r.startAnimation(this.E);
        return;
    L10:
        a r105 = this.D;
        ev.e r106 = new ev.e(this);
        this.f57116y = r106;
        r106.setDuration(150);
        ev.a r107 = this.f57109r;
        r107.f474184a = r105;
        r107.clearAnimation();
        this.f57109r.startAnimation(this.f57116y);
        return;
    }

    @Override // android.view.ViewGroup
    public final int getChildDrawingOrder(int r100, int r101) {
        int r102 = this.f57110s;
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
        if (this.f57092a != null) goto L5;
        a();
    L5:
        View r102 = this.f57092a;
        if (r102 != null) goto L19;
        return;
    L19:
        r102.measure(View.MeasureSpec.makeMeasureSpec((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), 1073741824), View.MeasureSpec.makeMeasureSpec((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), 1073741824));     // Catch: IllegalStateException -> L18
    L10:
        this.f57109r.measure(View.MeasureSpec.makeMeasureSpec(this.C, 1073741824), View.MeasureSpec.makeMeasureSpec(this.C, 1073741824));
        this.f57110s = -1;
        int r103 = 0;
    L12:
        if (r103 >= getChildCount()) goto L23;
        if (getChildAt(r103) == this.f57109r) goto L15;
        r103 = r103 + 1;
        goto L12
    L15:
        this.f57110s = r103;
        return;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public final boolean dispatchNestedFling(float r100, float r101, boolean r102) {
        return this.f57098g.dispatchNestedFling(r100, r101, r102);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public final boolean onNestedPreFling(View r100, float r101, float r102) {
        return dispatchNestedPreFling(r101, r102);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public final void onNestedScrollAccepted(View r100, View r101, int r102) {
        this.f57097f.onNestedScrollAccepted(r100, r101, r102);
        startNestedScroll(r102 & 2);
        this.f57096e = 0.0f;
        this.f57101j = true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public final boolean onStartNestedScroll(View r100, View r101, int r102) {
        if (isEnabled() == true) goto L5;
    L9:
        return false;
    L5:
        if (this.f57093b == true) goto L9;
        if ((r102 & 2) == 0) goto L9;
        return true;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public final boolean dispatchNestedPreScroll(int r100, int r101, int[] r102, int[] r103) {
        return this.f57098g.dispatchNestedPreScroll(r100, r101, r102, r103);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public final boolean onNestedFling(View r100, float r101, float r102, boolean r103) {
        return dispatchNestedFling(r101, r102, r103);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public final void onNestedPreScroll(View r100, int r101, int r102, int[] r103) {
        if (r102 <= 0) goto L11;
        float r104 = this.f57096e;
        if (r104 <= 0.0f) goto L11;
        float r105 = r102;
        if (r105 <= r104) goto L9;
        r103[1] = r102 - ((int) r104);
        this.f57096e = 0.0f;
    L10:
        c(this.f57096e);
        goto L11
    L9:
        this.f57096e = r104 - r105;
        r103[1] = r102;
    L11:
        int[] r106 = this.f57099h;
        if (dispatchNestedPreScroll(r101 - r103[0], r102 - r103[1], r106, null) == false) goto L15;
        r103[0] = r103[0] + r106[0];
        r103[1] = r103[1] + r106[1];
        return;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public final boolean dispatchNestedScroll(int r100, int r101, int r102, int r110, int[] r111) {
        return this.f57098g.dispatchNestedScroll(r100, r101, r102, r110, r111);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r100, int r101, int r102, int r103, int r104) {
        int r105 = getMeasuredWidth();
        int r106 = getMeasuredHeight();
        if (getChildCount() != 0) goto L6;
        return;
    L6:
        if (this.f57092a != null) goto L8;
        a();
    L8:
        View r107 = this.f57092a;
        if (r107 != null) goto L11;
        return;
    L11:
        int r108 = getPaddingLeft();
        int r109 = getPaddingTop();
        int r110 = (r105 - getPaddingLeft()) - getPaddingRight();
        r107.layout(r108, r109, r110 + r108, ((r106 - getPaddingTop()) - getPaddingBottom()) + r109);     // Catch: Exception -> L15
    L13:
        int r111 = this.f57109r.getMeasuredWidth();
        int r112 = this.f57109r.getMeasuredHeight();
        int r113 = r105 / 2;
        int r114 = r111 / 2;
        int r115 = this.f57103l;
        this.f57109r.layout(r113 - r114, r115, r113 + r114, r112 + r115);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public final void onNestedScroll(View r100, int r101, int r102, int r110, int r111) {
        dispatchNestedScroll(r101, r102, r110, r111, this.f57100i);
        int r112 = r111 + this.f57100i[1];
        if (r112 < 0) goto L5;
        return;
    L5:
        if (ViewCompat.canScrollVertically(this.f57092a, -1) == true) goto L9;
        float r103 = this.f57096e + Math.abs(r112);
        this.f57096e = r103;
        c(r103);
        return;
    }
}
