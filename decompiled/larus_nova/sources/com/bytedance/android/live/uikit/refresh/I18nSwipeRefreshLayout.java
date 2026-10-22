package com.bytedance.android.live.uikit.refresh;

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
import androidx.core.view.ViewCompat;
import com.bytedance.android.livesdk.feed.BaseFeedRoomPlayComponent;
import com.bytedance.common.utility.Logger;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;

/* JADX INFO: loaded from: classes7.dex */
public class I18nSwipeRefreshLayout extends ViewGroup {
    public static final int[] D = null;
    public final a A;
    public final c B;
    public final d C;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public View f102335a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public f f102336b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public e f102337c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f102338d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f102339e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f102340f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f102341g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f102342h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f102343i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public float f102344j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f102345k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f102346l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final DecelerateInterpolator f102347m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public zb1.a f102348n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f102349o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f102350p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f102351q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public MaterialProgressDrawable f102352r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public zb1.b f102353s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public zb1.c f102354t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public zb1.d f102355u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public zb1.d f102356v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final float f102357w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f102358x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f102359y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f102360z;

    public class a implements Animation.AnimationListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ I18nSwipeRefreshLayout f102361a;

        @Override // android.view.animation.Animation.AnimationListener
        public final void onAnimationRepeat(Animation r100) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public final void onAnimationStart(Animation r100) {
        }

        public a(I18nSwipeRefreshLayout r100) {
            this.f102361a = r100;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public final void onAnimationEnd(Animation r100) {
            I18nSwipeRefreshLayout r101 = this.f102361a;
            if (r101.f102338d == false) goto L9;
            MaterialProgressDrawable r102 = r101.f102352r;
            r102.f102369b.f102399u = 255;
            r102.start();
            I18nSwipeRefreshLayout r103 = this.f102361a;
            if (r103.f102358x == false) goto L10;
            f r104 = r103.f102336b;
            if (r104 == null) goto L10;
            r104.onRefresh();
        L10:
            I18nSwipeRefreshLayout r105 = this.f102361a;
            r105.f102342h = r105.f102348n.getTop();
            return;
        L9:
            r101.f102352r.stop();
            this.f102361a.f102348n.setVisibility(8);
            I18nSwipeRefreshLayout.a(this.f102361a);
            this.f102361a.getClass();
            I18nSwipeRefreshLayout r106 = this.f102361a;
            r106.e(r106.f102351q - r106.f102342h);
            goto L10
        }
    }

    public class b implements Animation.AnimationListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ I18nSwipeRefreshLayout f102362a;

        @Override // android.view.animation.Animation.AnimationListener
        public final void onAnimationRepeat(Animation r100) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public final void onAnimationStart(Animation r100) {
        }

        public b(I18nSwipeRefreshLayout r100) {
            this.f102362a = r100;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public final void onAnimationEnd(Animation r100) {
            I18nSwipeRefreshLayout r101 = this.f102362a;
            int[] r102 = I18nSwipeRefreshLayout.D;
            r101.getClass();
            I18nSwipeRefreshLayout r103 = this.f102362a;
            r103.getClass();
            zb1.c r104 = new zb1.c(r103);
            r103.f102354t = r104;
            r104.setDuration(150);
            zb1.a r105 = r103.f102348n;
            r105.f571118a = null;
            r105.clearAnimation();
            r103.f102348n.startAnimation(r103.f102354t);
        }
    }

    public class c extends Animation {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ I18nSwipeRefreshLayout f102363a;

        public c(I18nSwipeRefreshLayout r100) {
            this.f102363a = r100;
        }

        @Override // android.view.animation.Animation
        public final void applyTransformation(float r100, Transformation r101) {
            I18nSwipeRefreshLayout r102 = this.f102363a;
            int[] r103 = I18nSwipeRefreshLayout.D;
            r102.getClass();
            I18nSwipeRefreshLayout r104 = this.f102363a;
            int r105 = (int) (r104.f102357w - Math.abs(r104.f102351q));
            I18nSwipeRefreshLayout r106 = this.f102363a;
            int r107 = r106.f102350p;
            this.f102363a.e((r107 + ((int) ((r105 - r107) * r100))) - r106.f102348n.getTop());
        }
    }

    public class d extends Animation {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ I18nSwipeRefreshLayout f102364a;

        public d(I18nSwipeRefreshLayout r100) {
            this.f102364a = r100;
        }

        @Override // android.view.animation.Animation
        public final void applyTransformation(float r100, Transformation r101) {
            I18nSwipeRefreshLayout r102 = this.f102364a;
            int r103 = r102.f102350p;
            r102.e((r103 + ((int) ((r102.f102351q - r103) * r100))) - r102.f102348n.getTop());
        }
    }

    public interface e {
    }

    public interface f {
        void onRefresh();
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean r100) {
    }

    static {
        D = new int[]{R.attr.enabled};
    }

    public final void c() {
        if (this.f102335a != null) goto L11;
        int r100 = 0;
    L6:
        if (r100 >= getChildCount()) goto L15;
        View r101 = getChildAt(r100);
        if (r101.equals(this.f102348n) == false) goto L9;
        r100 = r100 + 1;
        goto L6
    L9:
        this.f102335a = r101;
        return;
    L15:
        return;
    }

    public I18nSwipeRefreshLayout(Context r100) {
        this(r100, null);
    }

    public static /* synthetic */ void a(I18nSwipeRefreshLayout r100) {
        r100.setColorViewAlpha(255);
    }

    private void setAnimationProgress(float r100) {
        ViewCompat.setScaleX(this.f102348n, r100);
        ViewCompat.setScaleY(this.f102348n, r100);
    }

    private void setColorViewAlpha(int r100) {
        this.f102348n.getBackground().setAlpha(r100);
        this.f102352r.f102369b.f102399u = r100;
    }

    public final void e(int r100) {
        this.f102348n.bringToFront();
        this.f102348n.offsetTopAndBottom(r100);
        this.f102342h = this.f102348n.getTop();
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent r100) {
        c();
        int r101 = MotionEventCompat.getActionMasked(r100);
        int r102 = 0;
        if (isEnabled() == true) goto L5;
    L63:
        return false;
    L5:
        if (ViewCompat.canScrollVertically(this.f102335a, -1) == true) goto L63;
        if (this.f102338d == true) goto L63;
        if (r101 == 0) goto L31;
        if (r101 != 1) goto L13;
    L24:
        this.f102345k = false;
        Logger.d("I18nSwipeRefreshLayout", "intercept cancel refresh");
        e r103 = this.f102337c;
        if (r103 == null) goto L30;
        com.bytedance.android.livesdk.feed.b r104 = (com.bytedance.android.livesdk.feed.b) r103;
        if (r104.f123617a == false) goto L29;
        r104.f123618b.d();
    L29:
        r104.f123617a = false;
    L30:
        this.f102346l = -1;
    L62:
        return this.f102345k;
    L13:
        if (r101 != 2) goto L15;
    L39:
        int r105 = this.f102346l;
        if (r105 != (-1)) goto L42;
        return false;
    L42:
        int r106 = MotionEventCompat.findPointerIndex(r100, r105);
        if (r106 >= 0) goto L45;
        float r107 = -1.0f;
    L47:
        if (r107 != (-1.0f)) goto L50;
        return false;
    L50:
        if ((r107 - this.f102344j) <= this.f102339e) goto L62;
        if (this.f102345k == true) goto L62;
        this.f102345k = true;
        Logger.d("I18nSwipeRefreshLayout", "intercept going refresh");
        e r108 = this.f102337c;
        if (r108 == null) goto L60;
        com.bytedance.android.livesdk.feed.b r109 = (com.bytedance.android.livesdk.feed.b) r108;
        BaseFeedRoomPlayComponent r110 = r109.f123618b;
        BaseFeedRoomPlayComponent.d r111 = r110.f123416f;
        if (r111 == null) goto L60;
        if (r111.f123425b <= 0) goto L60;
        r110.e();
        r109.f123617a = true;
    L60:
        this.f102352r.f102369b.f102399u = 76;
        goto L62
    L45:
        r107 = MotionEventCompat.getY(r100, r106);
        goto L47
    L15:
        if (r101 == 3) goto L24;
        if (r101 != 6) goto L62;
        int r112 = MotionEventCompat.getActionIndex(r100);
        if (MotionEventCompat.getPointerId(r100, r112) != this.f102346l) goto L62;
        if (r112 != 0) goto L23;
        r102 = 1;
    L23:
        this.f102346l = MotionEventCompat.getPointerId(r100, r102);
        goto L62
    L31:
        e(this.f102351q - this.f102348n.getTop());
        int r113 = MotionEventCompat.getPointerId(r100, 0);
        this.f102346l = r113;
        this.f102345k = false;
        int r114 = MotionEventCompat.findPointerIndex(r100, r113);
        if (r114 >= 0) goto L34;
        float r115 = -1.0f;
    L36:
        if (r115 != (-1.0f)) goto L38;
        return false;
    L38:
        this.f102344j = r115;
        goto L39
    L34:
        r115 = MotionEventCompat.getY(r100, r114);
        goto L36
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r110) {
        int r100 = MotionEventCompat.getActionMasked(r110);
        int r101 = 0;
        if (isEnabled() == true) goto L5;
    L96:
        return false;
    L5:
        if (ViewCompat.canScrollVertically(this.f102335a, -1) == true) goto L96;
        if (r100 != 0) goto L10;
        this.f102346l = MotionEventCompat.getPointerId(r110, 0);
        this.f102345k = false;
    L95:
        return true;
    L10:
        if (r100 != 1) goto L12;
    L72:
        int r102 = this.f102346l;
        if (r102 != (-1)) goto L97;
        return false;
    L97:
        float r111 = (MotionEventCompat.getY(r110, MotionEventCompat.findPointerIndex(r110, r102)) - this.f102344j) * 0.5f;
        this.f102345k = false;
        if (r111 <= this.f102340f) goto L80;
        d(true, true);
    L89:
        this.f102346l = -1;
        return false;
    L80:
        this.f102338d = false;
        MaterialProgressDrawable r112 = this.f102352r;
        MaterialProgressDrawable.c r103 = r112.f102369b;
        r103.f102383e = 0.0f;
        r103.a();
        MaterialProgressDrawable.c r113 = r112.f102369b;
        r113.f102384f = 0.0f;
        r113.a();
        b r114 = new b(this);
        this.f102350p = this.f102342h;
        this.C.reset();
        this.C.setDuration(200);
        this.C.setInterpolator(this.f102347m);
        zb1.a r104 = this.f102348n;
        r104.f571118a = r114;
        r104.clearAnimation();
        this.f102348n.startAnimation(this.C);
        MaterialProgressDrawable.c r115 = this.f102352r.f102369b;
        if (r115.f102393o == false) goto L83;
        r115.f102393o = false;
        r115.a();
    L83:
        Logger.d("I18nSwipeRefreshLayout", "on touch cancel refresh");
        e r116 = this.f102337c;
        if (r116 == null) goto L89;
        com.bytedance.android.livesdk.feed.b r117 = (com.bytedance.android.livesdk.feed.b) r116;
        if (r117.f123617a == false) goto L88;
        r117.f123618b.d();
    L88:
        r117.f123617a = false;
    L91:
        e = move-exception;
        e.printStackTrace();
        return true;
    L12:
        if (r100 != 2) goto L14;
        int r105 = MotionEventCompat.findPointerIndex(r110, this.f102346l);
        if (r105 >= 0) goto L99;
        return false;
    L99:
        float r118 = (MotionEventCompat.getY(r110, r105) - this.f102344j) * 0.5f;
        if (this.f102345k == false) goto L95;
        MaterialProgressDrawable.c r106 = this.f102352r.f102369b;
        if (r106.f102393o == true) goto L35;
        r106.f102393o = true;
        r106.a();
    L35:
        float r107 = r118 / this.f102340f;
        if (r107 >= 0.0f) goto L38;
        return false;
    L38:
        float r108 = Math.min(1.0f, Math.abs(r107));
        float r109 = (((float) Math.max(((double) r108) - 0.4d, AudioStats.AUDIO_AMPLITUDE_NONE)) * 5.0f) / 3.0f;
        float r119 = Math.abs(r118) - this.f102340f;
        float r120 = this.f102357w;
        double r121 = Math.max(0.0f, Math.min(r119, r120 * 2.0f) / r120) / 4.0f;
        float r122 = ((float) (r121 - Math.pow(r121, 2.0d))) * 2.0f;
        int r123 = this.f102351q + ((int) ((r120 * r108) + ((r120 * r122) * 2.0f)));
        if (this.f102348n.getVisibility() == 0) goto L41;
        this.f102348n.setVisibility(0);
    L41:
        ViewCompat.setScaleX(this.f102348n, 1.0f);
        ViewCompat.setScaleY(this.f102348n, 1.0f);
        if (r118 >= this.f102340f) goto L58;
        if (this.f102352r.f102369b.f102399u <= 76) goto L54;
        zb1.d r124 = this.f102355u;
        if (r124 != null) goto L48;
    L52:
        if (r101 != 0) goto L54;
        zb1.d r125 = new zb1.d(this, this.f102352r.f102369b.f102399u, 76);
        r125.setDuration(300);
        zb1.a r126 = this.f102348n;
        r126.f571118a = null;
        r126.clearAnimation();
        this.f102348n.startAnimation(r125);
        this.f102355u = r125;
        goto L54
    L48:
        if (r124.hasStarted() == false) goto L52;
        if (r124.hasEnded() == true) goto L52;
        r101 = 1;
    L54:
        MaterialProgressDrawable r127 = this.f102352r;
        float r128 = Math.min(0.8f, r109 * 0.8f);
        MaterialProgressDrawable.c r129 = r127.f102369b;
        r129.f102383e = 0.0f;
        r129.a();
        MaterialProgressDrawable.c r130 = r127.f102369b;
        r130.f102384f = r128;
        r130.a();
        MaterialProgressDrawable r131 = this.f102352r;
        float r132 = Math.min(1.0f, r109);
        MaterialProgressDrawable.c r133 = r131.f102369b;
        if (r132 == r133.f102395q) goto L68;
        r133.f102395q = r132;
        r133.a();
    L68:
        MaterialProgressDrawable.c r134 = this.f102352r.f102369b;
        r134.f102385g = (((r109 * 0.4f) - 0.25f) + (r122 * 2.0f)) * 0.5f;
        r134.a();
        e(r123 - this.f102342h);
        goto L95
    L58:
        if (this.f102352r.f102369b.f102399u >= 255) goto L68;
        zb1.d r135 = this.f102356v;
        if (r135 != null) goto L62;
    L66:
        if (r101 != 0) goto L68;
        zb1.d r136 = new zb1.d(this, this.f102352r.f102369b.f102399u, 255);
        r136.setDuration(300);
        zb1.a r137 = this.f102348n;
        r137.f571118a = null;
        r137.clearAnimation();
        this.f102348n.startAnimation(r136);
        this.f102356v = r136;
        goto L68
    L62:
        if (r135.hasStarted() == false) goto L66;
        if (r135.hasEnded() == true) goto L66;
        r101 = 1;
    L69:
        e = move-exception;
        e.printStackTrace();
        return true;
    L14:
        if (r100 == 3) goto L72;
        if (r100 != 5) goto L18;
        this.f102346l = MotionEventCompat.getPointerId(r110, MotionEventCompat.getActionIndex(r110));
        goto L95
    L18:
        if (r100 != 6) goto L95;
        int r138 = MotionEventCompat.getActionIndex(r110);
        if (MotionEventCompat.getPointerId(r110, r138) != this.f102346l) goto L95;
        if (r138 != 0) goto L24;
        r101 = 1;
    L24:
        this.f102346l = MotionEventCompat.getPointerId(r110, r101);
        goto L95
    }

    public void setColorScheme(int... r100) {
        setColorSchemeResources(r100);
    }

    public void setColorSchemeColors(int... r100) {
        c();
        MaterialProgressDrawable.c r101 = this.f102352r.f102369b;
        r101.f102388j = r100;
        r101.f102389k = 0;
        r101.f102389k = 0;
    }

    public void setColorSchemeResources(int... r100) {
        Resources r101 = getResources();
        int[] r102 = new int[r100.length];
        int r103 = 0;
    L4:
        if (r103 >= r100.length) goto L6;
        r102[r103] = r101.getColor(r100[r103]);
        r103 = r103 + 1;
        goto L4
    L6:
        setColorSchemeColors(r102);
    }

    public void setDistanceToTriggerSync(int r100) {
        this.f102340f = r100;
    }

    public void setOnRefreshListener(f r100) {
        this.f102336b = r100;
    }

    public void setProgressBackgroundColor(int r100) {
        this.f102348n.setBackgroundColor(r100);
        MaterialProgressDrawable r101 = this.f102352r;
        r101.f102369b.f102401w = getResources().getColor(r100);
    }

    public void setRefreshing(boolean r100) {
        if (r100 == true) goto L5;
    L10:
        d(r100, false);
        return;
    L5:
        if (this.f102338d == r100) goto L10;
        this.f102338d = r100;
        e(((int) (this.f102357w + this.f102351q)) - this.f102342h);
        this.f102358x = false;
        a r101 = this.A;
        this.f102348n.setVisibility(0);
        this.f102352r.f102369b.f102399u = 255;
        zb1.b r102 = new zb1.b(this);
        this.f102353s = r102;
        r102.setDuration(this.f102341g);
        if (r101 == null) goto L9;
        this.f102348n.f571118a = r101;
    L9:
        this.f102348n.clearAnimation();
        this.f102348n.startAnimation(this.f102353s);
    }

    public void setSize(int r100) {
        if (r100 != 0) goto L4;
    L6:
        Resources r101 = getResources();
        DisplayMetrics r102 = WindowDisplayMetricsOverride.apply(r101, r101.getDisplayMetrics());
        if (r100 != 0) goto L9;
        int r103 = (int) (r102.density * 56.0f);
        this.f102359y = r103;
        this.f102360z = r103;
    L10:
        this.f102348n.setImageDrawable(null);
        this.f102352r.b(r100);
        this.f102348n.setImageDrawable(this.f102352r);
        return;
    L9:
        int r104 = (int) (r102.density * 40.0f);
        this.f102359y = r104;
        this.f102360z = r104;
        goto L10
    L4:
        if (r100 == 1) goto L6;
    }

    public void setStartEndRefreshListener(e r100) {
        this.f102337c = r100;
    }

    public I18nSwipeRefreshLayout(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.f102338d = false;
        this.f102340f = -1.0f;
        this.f102343i = false;
        this.f102346l = -1;
        this.f102349o = -1;
        this.A = new a(this);
        this.B = new c(this);
        this.C = new d(this);
        this.f102339e = ViewConfiguration.get(r100).getScaledTouchSlop();
        this.f102341g = getResources().getInteger(R.integer.config_mediumAnimTime);
        setWillNotDraw(false);
        this.f102347m = new DecelerateInterpolator(2.0f);
        TypedArray r102 = r100.obtainStyledAttributes(r101, D);
        setEnabled(r102.getBoolean(0, true));
        r102.recycle();
        Resources r103 = getResources();
        DisplayMetrics r104 = WindowDisplayMetricsOverride.apply(r103, r103.getDisplayMetrics());
        int r105 = (int) (r104.density * 40.0f);
        this.f102359y = r105;
        this.f102360z = r105;
        this.f102348n = new zb1.a(getContext());
        MaterialProgressDrawable r106 = new MaterialProgressDrawable(getContext(), this);
        this.f102352r = r106;
        r106.f102369b.f102401w = -328966;
        this.f102348n.setImageDrawable(r106);
        this.f102348n.setVisibility(8);
        addView(this.f102348n);
        ViewCompat.setChildrenDrawingOrderEnabled(this, true);
        float r107 = r104.density * 64.0f;
        this.f102357w = r107;
        this.f102340f = r107;
    }

    public static /* synthetic */ void b(I18nSwipeRefreshLayout r100, float r101) {
        r100.setAnimationProgress(r101);
    }

    public final void d(boolean r100, boolean r101) {
        if (this.f102338d == r100) goto L12;
        this.f102358x = r101;
        c();
        this.f102338d = r100;
        if (r100 == false) goto L10;
        int r102 = this.f102342h;
        a r103 = this.A;
        this.f102350p = r102;
        this.B.reset();
        this.B.setDuration(200);
        this.B.setInterpolator(this.f102347m);
        if (r103 == null) goto L9;
        this.f102348n.f571118a = r103;
    L9:
        this.f102348n.clearAnimation();
        this.f102348n.startAnimation(this.B);
        return;
    L10:
        a r104 = this.A;
        zb1.c r105 = new zb1.c(this);
        this.f102354t = r105;
        r105.setDuration(150);
        zb1.a r106 = this.f102348n;
        r106.f571118a = r104;
        r106.clearAnimation();
        this.f102348n.startAnimation(this.f102354t);
        return;
    }

    @Override // android.view.ViewGroup
    public final int getChildDrawingOrder(int r100, int r101) {
        int r102 = this.f102349o;
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
        if (this.f102335a != null) goto L5;
        c();
    L5:
        View r102 = this.f102335a;
        if (r102 != null) goto L8;
        return;
    L8:
        r102.measure(View.MeasureSpec.makeMeasureSpec((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), 1073741824), View.MeasureSpec.makeMeasureSpec((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), 1073741824));
        this.f102348n.measure(View.MeasureSpec.makeMeasureSpec(this.f102359y, 1073741824), View.MeasureSpec.makeMeasureSpec(this.f102360z, 1073741824));
        if (this.f102343i == true) goto L11;
        this.f102343i = true;
        int r103 = -this.f102348n.getMeasuredHeight();
        this.f102351q = r103;
        this.f102342h = r103;
    L11:
        this.f102349o = -1;
        int r104 = 0;
    L13:
        if (r104 >= getChildCount()) goto L21;
        if (getChildAt(r104) == this.f102348n) goto L16;
        r104 = r104 + 1;
        goto L13
    L16:
        this.f102349o = r104;
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r100, int r101, int r102, int r103, int r104) {
        int r105 = getMeasuredWidth();
        int r106 = getMeasuredHeight();
        if (getChildCount() != 0) goto L6;
        return;
    L6:
        if (this.f102335a != null) goto L8;
        c();
    L8:
        View r107 = this.f102335a;
        if (r107 != null) goto L11;
        return;
    L11:
        int r108 = getPaddingLeft();
        int r109 = getPaddingTop();
        int r110 = (r105 - getPaddingLeft()) - getPaddingRight();
        r107.layout(r108, r109, r110 + r108, ((r106 - getPaddingTop()) - getPaddingBottom()) + r109);
        int r111 = this.f102348n.getMeasuredWidth();
        int r112 = this.f102348n.getMeasuredHeight();
        int r113 = r105 / 2;
        int r114 = r111 / 2;
        int r115 = this.f102342h;
        this.f102348n.layout(r113 - r114, r115, r113 + r114, r112 + r115);
    }
}
