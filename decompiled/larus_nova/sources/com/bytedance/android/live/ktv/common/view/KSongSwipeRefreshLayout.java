package com.bytedance.android.live.ktv.common.view;

import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Transformation;
import androidx.core.view.MotionEventCompat;
import androidx.core.view.ViewCompat;
import com.larus.apm.impl.protector.RunnableProtector;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.ugc.effectmanager.common.EffectConstants;

/* JADX INFO: loaded from: classes45.dex */
public class KSongSwipeRefreshLayout extends ViewGroup {
    public static final int[] A = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public View f70715a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f70716b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f70717c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f70718d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f70719e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f70720f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f70721g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f70722h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public float f70723i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public float f70724j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f70725k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f70726l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f70727m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final DecelerateInterpolator f70728n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public View f70729o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f70730p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public STATUS f70731q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f70732r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final boolean f70733s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final a f70734t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final b f70735u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final c f70736v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final d f70737w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final e f70738x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final f f70739y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final g f70740z;

    public static final enum STATUS extends Enum<STATUS> {
        public static final STATUS LOOSEN = null;
        public static final STATUS NORMAL = null;
        public static final STATUS REFRESHING = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ STATUS[] f70741a = null;

        static {
            STATUS r100 = new STATUS(EffectConstants.NORMAL, 0);
            NORMAL = r100;
            STATUS r101 = new STATUS("LOOSEN", 1);
            LOOSEN = r101;
            STATUS r102 = new STATUS("REFRESHING", 2);
            REFRESHING = r102;
            f70741a = new STATUS[]{r100, r101, r102};
        }

        public static STATUS[] values() {
            return (STATUS[]) f70741a.clone();
        }

        public static STATUS valueOf(String r100) {
            return (STATUS) r27.a.a(STATUS.class, r100);
        }

        public STATUS(String r100, int r101) {
            super(r100, r101);
        }
    }

    public class a extends Animation {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ KSongSwipeRefreshLayout f70742a;

        public a(KSongSwipeRefreshLayout r100) {
            this.f70742a = r100;
        }

        @Override // android.view.animation.Animation
        public final void applyTransformation(float r100, Transformation r101) {
            KSongSwipeRefreshLayout r102 = this.f70742a;
            int r103 = r102.f70717c;
            int r104 = r102.f70716b;
            if (r103 == r104) goto L5;
            int r105 = r103 + ((int) ((r104 - r103) * r100));
        L6:
            int r106 = r105 - r102.f70715a.getTop();
            int r107 = this.f70742a.f70715a.getTop();
            if ((r106 + r107) >= 0) goto L9;
            r106 = 0 - r107;
        L9:
            KSongSwipeRefreshLayout.b(this.f70742a, r106);
            return;
        L5:
            r105 = 0;
            goto L6
        }
    }

    public class b extends Animation {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ KSongSwipeRefreshLayout f70743a;

        public b(KSongSwipeRefreshLayout r100) {
            this.f70743a = r100;
        }

        @Override // android.view.animation.Animation
        public final void applyTransformation(float r100, Transformation r101) {
            KSongSwipeRefreshLayout r102 = this.f70743a;
            int r103 = r102.f70717c;
            int r104 = r102.f70730p;
            if (r103 == r104) goto L5;
            int r105 = r103 + ((int) ((r104 - r103) * r100));
        L6:
            int r106 = r105 - r102.f70715a.getTop();
            int r107 = this.f70743a.f70715a.getTop();
            if ((r106 + r107) >= 0) goto L9;
            r106 = 0 - r107;
        L9:
            KSongSwipeRefreshLayout.b(this.f70743a, r106);
            return;
        L5:
            r105 = 0;
            goto L6
        }
    }

    public class c extends i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ KSongSwipeRefreshLayout f70744a;

        public c(KSongSwipeRefreshLayout r100) {
            this.f70744a = r100;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public final void onAnimationEnd(Animation r100) {
            KSongSwipeRefreshLayout r101 = this.f70744a;
            r101.f70722h = 0;
            r101.f70731q = STATUS.NORMAL;
            r101.f70732r = false;
            r101.getClass();
        }
    }

    public class d extends i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ KSongSwipeRefreshLayout f70745a;

        public d(KSongSwipeRefreshLayout r100) {
            this.f70745a = r100;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public final void onAnimationEnd(Animation r100) {
            KSongSwipeRefreshLayout r101 = this.f70745a;
            r101.f70722h = r101.f70730p;
            r101.f70731q = STATUS.REFRESHING;
        }
    }

    public class e implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ KSongSwipeRefreshLayout f70746a;

        @Override // java.lang.Runnable
        public final void run() {
            View r100 = this.f70746a.f70729o;     // Catch: Throwable -> L7
            if (r100 == null) goto L5;
            r100.setVisibility(8);     // Catch: Throwable -> L7
        L5:
            KSongSwipeRefreshLayout r101 = this.f70746a;     // Catch: Throwable -> L7
            r101.f70727m = true;     // Catch: Throwable -> L7
            KSongSwipeRefreshLayout.a(r101, r101.f70722h + r101.getPaddingTop(), this.f70746a.f70736v);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L11;
            return;
        L11:
            throw th;
        }

        public e(KSongSwipeRefreshLayout r100) {
            this.f70746a = r100;
        }
    }

    public class f implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ KSongSwipeRefreshLayout f70747a;

        public final void a() {
            KSongSwipeRefreshLayout r100 = this.f70747a;
            r100.f70727m = true;
            int r101 = r100.f70722h + r100.getPaddingTop();
            d r102 = this.f70747a.f70737w;
            r100.f70717c = r101;
            r100.f70735u.reset();
            r100.f70735u.setDuration(r100.f70721g);
            r100.f70735u.setAnimationListener(r102);
            r100.f70735u.setInterpolator(r100.f70728n);
            r100.f70715a.startAnimation(r100.f70735u);
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public f(KSongSwipeRefreshLayout r100) {
            this.f70747a = r100;
        }
    }

    public class g implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ KSongSwipeRefreshLayout f70748a;

        @Override // java.lang.Runnable
        public final void run() {
            KSongSwipeRefreshLayout r100 = this.f70748a;     // Catch: Throwable -> L4
            r100.f70727m = true;     // Catch: Throwable -> L4
            KSongSwipeRefreshLayout.a(r100, r100.f70722h + r100.getPaddingTop(), this.f70748a.f70736v);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public g(KSongSwipeRefreshLayout r100) {
            this.f70748a = r100;
        }
    }

    public class h implements View.OnTouchListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ KSongSwipeRefreshLayout f70749a;

        public h(KSongSwipeRefreshLayout r100) {
            this.f70749a = r100;
        }

        @Override // android.view.View.OnTouchListener
        public final boolean onTouch(View r100, MotionEvent r101) {
            return this.f70749a.f70732r;
        }
    }

    public class i implements Animation.AnimationListener {
        @Override // android.view.animation.Animation.AnimationListener
        public final void onAnimationRepeat(Animation r100) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public final void onAnimationStart(Animation r100) {
        }

        public i() {
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void requestDisallowInterceptTouchEvent(boolean r100) {
    }

    static {
        A = new int[]{R.attr.enabled};
    }

    public final void c() {
        if (this.f70715a != null) goto L13;
        if (getChildCount() > 2) goto L7;
    L11:
        View r100 = getChildAt(1);
        this.f70715a = r100;
        r100.setOnTouchListener(new h(this));
        this.f70716b = this.f70715a.getTop() + getPaddingTop();
        goto L13
    L7:
        if (isInEditMode() == true) goto L11;
        throw new IllegalStateException("SwipeRefreshLayout can only host two children");
    L13:
        if (this.f70720f == (-1.0f)) goto L15;
        return;
    L15:
        if (getParent() != null) goto L17;
        return;
    L17:
        if (((View) getParent()).getHeight() <= 0) goto L22;
        Resources r101 = getResources();
        this.f70720f = (int) Math.min(((View) getParent()).getHeight() * 0.6f, WindowDisplayMetricsOverride.apply(r101, r101.getDisplayMetrics()).density * 120.0f);
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        removeCallbacks(this.f70740z);
        removeCallbacks(this.f70738x);
        removeCallbacks(this.f70739y);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.f70738x);
        removeCallbacks(this.f70740z);
        removeCallbacks(this.f70739y);
    }

    public KSongSwipeRefreshLayout(Context r100) {
        this(r100, null);
    }

    private void setTargetOffsetTopAndBottom(int r100) {
        this.f70715a.offsetTopAndBottom(r100);
        this.f70729o.offsetTopAndBottom(r100);
        this.f70722h = this.f70715a.getTop();
        invalidate();
    }

    public final void d(MotionEvent r100) {
        int r101 = MotionEventCompat.getActionIndex(r100);
        if (MotionEventCompat.getPointerId(r100, r101) != this.f70726l) goto L9;
        if (r101 != 0) goto L6;
        int r102 = 1;
    L7:
        this.f70724j = MotionEventCompat.getY(r100, r102);
        this.f70726l = MotionEventCompat.getPointerId(r100, r102);
        return;
    L6:
        r102 = 0;
        goto L7
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r100) {
        c();
        int r101 = MotionEventCompat.getActionMasked(r100);
        if (this.f70727m == false) goto L7;
        if (r101 != 0) goto L7;
        this.f70727m = false;
    L7:
        if (isEnabled() == true) goto L9;
    L39:
        return false;
    L9:
        if (this.f70727m == true) goto L39;
        if (ViewCompat.canScrollVertically(this.f70715a, -1) == true) goto L39;
        if (this.f70731q == STATUS.REFRESHING) goto L39;
        if (r101 == 0) goto L36;
        if (r101 != 1) goto L19;
    L35:
        getParent().requestDisallowInterceptTouchEvent(false);
        this.f70725k = false;
        this.f70726l = -1;
    L38:
        return this.f70725k;
    L19:
        if (r101 != 2) goto L21;
        int r102 = this.f70726l;
        if (r102 != (-1)) goto L29;
        return false;
    L29:
        int r103 = MotionEventCompat.findPointerIndex(r100, r102);
        if (r103 >= 0) goto L32;
        return false;
    L32:
        float r104 = MotionEventCompat.getY(r100, r103);
        if ((r104 - this.f70723i) <= this.f70719e) goto L38;
        this.f70724j = r104;
        this.f70725k = true;
        goto L38
    L21:
        if (r101 == 3) goto L35;
        if (r101 != 6) goto L38;
        d(r100);
        goto L38
    L36:
        getParent().requestDisallowInterceptTouchEvent(true);
        float r105 = r100.getY();
        this.f70723i = r105;
        this.f70724j = r105;
        this.f70726l = MotionEventCompat.getPointerId(r100, 0);
        this.f70725k = false;
        goto L38
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r100) {
        int r101 = 0;
        if (this.f70733s == true) goto L5;
        return false;
    L5:
        int r102 = MotionEventCompat.getActionMasked(r100);
        if (this.f70727m == false) goto L10;
        if (r102 != 0) goto L10;
        this.f70727m = false;
    L10:
        if (isEnabled() == true) goto L12;
    L80:
        return false;
    L12:
        if (this.f70727m == true) goto L80;
        if (ViewCompat.canScrollVertically(this.f70715a, -1) == true) goto L80;
        STATUS r103 = this.f70731q;
        if (r103 == STATUS.REFRESHING) goto L80;
        if (r102 != 0) goto L21;
        float r104 = r100.getY();
        this.f70723i = r104;
        this.f70724j = r104;
        this.f70726l = MotionEventCompat.getPointerId(r100, 0);
        this.f70725k = false;
    L79:
        return true;
    L21:
        if (r102 == 1) goto L73;
        if (r102 != 2) goto L25;
        this.f70729o.setVisibility(0);
        int r105 = MotionEventCompat.findPointerIndex(r100, this.f70726l);
        if (r105 >= 0) goto L38;
        return false;
    L38:
        float r106 = MotionEventCompat.getY(r100, r105);
        float r107 = r106 - this.f70723i;
        if (this.f70725k == true) goto L44;
        if (r107 <= this.f70719e) goto L44;
        this.f70725k = true;
    L44:
        if (this.f70725k == false) goto L79;
        if (r107 <= this.f70720f) goto L58;
        if (this.f70731q != STATUS.NORMAL) goto L50;
        this.f70731q = STATUS.LOOSEN;
    L50:
        int r108 = (int) r107;
        int r109 = this.f70715a.getTop();
        float r110 = r108;
        float r111 = this.f70720f;
        if (r110 <= r111) goto L53;
        r101 = (((int) (r110 - r111)) / 2) + ((int) r111);
    L56:
        setTargetOffsetTopAndBottom(r101 - r109);
    L71:
        this.f70724j = r106;
        goto L79
    L53:
        if (r108 < 0) goto L56;
        r101 = r108;
        goto L56
    L58:
        if (this.f70731q != STATUS.LOOSEN) goto L60;
        this.f70731q = STATUS.NORMAL;
    L60:
        int r112 = (int) r107;
        int r113 = this.f70715a.getTop();
        float r114 = r112;
        float r115 = this.f70720f;
        if (r114 <= r115) goto L63;
        r101 = (((int) (r114 - r115)) / 2) + ((int) r115);
    L66:
        setTargetOffsetTopAndBottom(r101 - r113);
        if (this.f70724j <= r106) goto L71;
        if (this.f70715a.getTop() != getPaddingTop()) goto L71;
        removeCallbacks(this.f70740z);
        goto L71
    L63:
        if (r112 < 0) goto L66;
        r101 = r112;
        goto L66
    L25:
        if (r102 != 3) goto L27;
        removeCallbacks(this.f70740z);
        postDelayed(this.f70740z, 300);
        this.f70725k = false;
        this.f70726l = -1;
        return false;
    L27:
        if (r102 != 5) goto L29;
        int r116 = MotionEventCompat.getActionIndex(r100);
        this.f70724j = MotionEventCompat.getY(r100, r116);
        this.f70726l = MotionEventCompat.getPointerId(r100, r116);
        goto L79
    L29:
        if (r102 != 6) goto L79;
        d(r100);
        goto L79
    L73:
        if (r103 != STATUS.LOOSEN) goto L75;
        removeCallbacks(this.f70740z);
        this.f70739y.run();
        setRefreshing(true);
        this.f70732r = true;
    L76:
        this.f70725k = false;
        this.f70726l = -1;
        return false;
    L75:
        removeCallbacks(this.f70740z);
        postDelayed(this.f70740z, 300);
        goto L76
    }

    public void setRefreshing(boolean r100) {
        if (this.f70718d == r100) goto L6;
        c();
        this.f70718d = r100;
        return;
    }

    public KSongSwipeRefreshLayout(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.f70718d = false;
        this.f70720f = -1.0f;
        this.f70726l = -1;
        this.f70731q = STATUS.NORMAL;
        this.f70733s = true;
        this.f70734t = new a(this);
        this.f70735u = new b(this);
        this.f70736v = new c(this);
        this.f70737w = new d(this);
        this.f70738x = new e(this);
        this.f70739y = new f(this);
        this.f70740z = new g(this);
        this.f70719e = ViewConfiguration.get(r100).getScaledTouchSlop() - 10;
        this.f70721g = getResources().getInteger(R.integer.config_mediumAnimTime);
        this.f70728n = new DecelerateInterpolator(2.0f);
        TypedArray r102 = r100.obtainStyledAttributes(r101, A);
        setEnabled(r102.getBoolean(0, true));
        r102.recycle();
    }

    public static /* synthetic */ void b(KSongSwipeRefreshLayout r100, int r101) {
        r100.setTargetOffsetTopAndBottom(r101);
    }

    @Override // android.view.View
    public final void onMeasure(int r100, int r101) {
        super.onMeasure(r100, r101);
        if (getChildCount() <= 0) goto L17;
        if (getChildCount() <= 2) goto L12;
        if (isInEditMode() == true) goto L12;
        throw new IllegalStateException("SwipeRefreshLayout can only host two children");
    L12:
        if (this.f70729o != null) goto L14;
        View r102 = getChildAt(0);
        this.f70729o = r102;
        measureChild(r102, r100, r101);
        int r103 = this.f70729o.getMeasuredHeight();
        this.f70730p = r103;
        this.f70720f = r103;
    L14:
        getChildAt(1).measure(View.MeasureSpec.makeMeasureSpec((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), 1073741824), View.MeasureSpec.makeMeasureSpec((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), 1073741824));
        return;
    L17:
        throw new IllegalStateException("SwipeRefreshLayout must have the headerview and contentview");
    }

    public static void a(KSongSwipeRefreshLayout r100, int r101, c r102) {
        r100.f70717c = r101;
        r100.f70734t.reset();
        r100.f70734t.setDuration(r100.f70721g);
        r100.f70734t.setAnimationListener(r102);
        r100.f70734t.setInterpolator(r100.f70728n);
        r100.f70715a.startAnimation(r100.f70734t);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r100, int r101, int r102, int r103, int r104) {
        int r105 = getMeasuredWidth();
        int r106 = getMeasuredHeight();
        if (getChildCount() != 0) goto L5;
        return;
    L5:
        if (getChildCount() == 1) goto L10;
        View r107 = getChildAt(1);
        int r108 = getPaddingLeft();
        int r109 = this.f70722h + getPaddingTop();
        int r110 = (r105 - getPaddingLeft()) - getPaddingRight();
        int r111 = r110 + r108;
        r107.layout(r108, r109, r111, ((r106 - getPaddingTop()) - getPaddingBottom()) + r109);
        this.f70729o.layout(r108, r109 - this.f70730p, r111, r109);
        return;
    }
}
