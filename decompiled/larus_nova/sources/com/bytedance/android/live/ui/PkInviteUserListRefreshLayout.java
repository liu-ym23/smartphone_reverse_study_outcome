package com.bytedance.android.live.ui;

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
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.apm.impl.protector.RunnableProtector;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.ugc.effectmanager.common.EffectConstants;

/* JADX INFO: loaded from: classes7.dex */
public class PkInviteUserListRefreshLayout extends ViewGroup {
    public static final int[] E = null;
    public final d A;
    public final e B;
    public final f C;
    public final g D;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public View f101960a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f101961b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public k f101962c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f101963d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f101964e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f101965f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f101966g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f101967h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f101968i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public float f101969j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public float f101970k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f101971l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f101972m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f101973n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final DecelerateInterpolator f101974o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public View f101975p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f101976q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public STATUS f101977r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f101978s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f101979t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public RecyclerView f101980u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public j f101981v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public View f101982w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final a f101983x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final b f101984y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final c f101985z;

    public static final enum STATUS extends Enum<STATUS> {
        public static final STATUS LOOSEN = null;
        public static final STATUS NORMAL = null;
        public static final STATUS REFRESHING = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ STATUS[] f101986a = null;

        static {
            STATUS r100 = new STATUS(EffectConstants.NORMAL, 0);
            NORMAL = r100;
            STATUS r101 = new STATUS("LOOSEN", 1);
            LOOSEN = r101;
            STATUS r102 = new STATUS("REFRESHING", 2);
            REFRESHING = r102;
            f101986a = new STATUS[]{r100, r101, r102};
        }

        public static STATUS[] values() {
            return (STATUS[]) f101986a.clone();
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
        public final /* synthetic */ PkInviteUserListRefreshLayout f101987a;

        public a(PkInviteUserListRefreshLayout r100) {
            this.f101987a = r100;
        }

        @Override // android.view.animation.Animation
        public final void applyTransformation(float r100, Transformation r101) {
            PkInviteUserListRefreshLayout r102 = this.f101987a;
            int r103 = r102.f101963d;
            int r104 = r102.f101961b;
            if (r103 == r104) goto L5;
            int r105 = r103 + ((int) ((r104 - r103) * r100));
        L6:
            int r106 = r105 - r102.f101960a.getTop();
            int r107 = this.f101987a.f101960a.getTop();
            if ((r106 + r107) >= 0) goto L9;
            r106 = 0 - r107;
        L9:
            PkInviteUserListRefreshLayout.b(this.f101987a, r106);
            return;
        L5:
            r105 = 0;
            goto L6
        }
    }

    public class b extends Animation {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PkInviteUserListRefreshLayout f101988a;

        public b(PkInviteUserListRefreshLayout r100) {
            this.f101988a = r100;
        }

        @Override // android.view.animation.Animation
        public final void applyTransformation(float r100, Transformation r101) {
            PkInviteUserListRefreshLayout r102 = this.f101988a;
            int r103 = r102.f101963d;
            int r104 = r102.f101976q;
            if (r103 == r104) goto L5;
            int r105 = r103 + ((int) ((r104 - r103) * r100));
        L6:
            int r106 = r105 - r102.f101960a.getTop();
            int r107 = this.f101988a.f101960a.getTop();
            if ((r106 + r107) >= 0) goto L9;
            r106 = 0 - r107;
        L9:
            PkInviteUserListRefreshLayout.b(this.f101988a, r106);
            return;
        L5:
            r105 = 0;
            goto L6
        }
    }

    public class c extends i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PkInviteUserListRefreshLayout f101989a;

        public c(PkInviteUserListRefreshLayout r100) {
            this.f101989a = r100;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public final void onAnimationEnd(Animation r100) {
            PkInviteUserListRefreshLayout r101 = this.f101989a;
            r101.f101968i = 0;
            r101.f101977r = STATUS.NORMAL;
            r101.f101978s = false;
            r101.f101962c.onFinish();
        }
    }

    public class d extends i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PkInviteUserListRefreshLayout f101990a;

        public d(PkInviteUserListRefreshLayout r100) {
            this.f101990a = r100;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public final void onAnimationEnd(Animation r100) {
            PkInviteUserListRefreshLayout r101 = this.f101990a;
            r101.f101968i = r101.f101976q;
            r101.f101977r = STATUS.REFRESHING;
        }
    }

    public class e implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PkInviteUserListRefreshLayout f101991a;

        @Override // java.lang.Runnable
        public final void run() {
            PkInviteUserListRefreshLayout r100 = this.f101991a;     // Catch: Throwable -> L4
            r100.f101973n = true;     // Catch: Throwable -> L4
            PkInviteUserListRefreshLayout.a(r100, r100.f101968i + r100.getPaddingTop(), this.f101991a.f101985z);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public e(PkInviteUserListRefreshLayout r100) {
            this.f101991a = r100;
        }
    }

    public class f implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PkInviteUserListRefreshLayout f101992a;

        public final void a() {
            PkInviteUserListRefreshLayout r100 = this.f101992a;
            r100.f101973n = true;
            int r101 = r100.f101968i + r100.getPaddingTop();
            d r102 = this.f101992a.A;
            r100.f101963d = r101;
            r100.f101984y.reset();
            r100.f101984y.setDuration(r100.f101967h);
            r100.f101984y.setAnimationListener(r102);
            r100.f101984y.setInterpolator(r100.f101974o);
            View r103 = r100.f101960a;
            if (r103 == null) goto L6;
            r103.startAnimation(r100.f101984y);
            return;
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

        public f(PkInviteUserListRefreshLayout r100) {
            this.f101992a = r100;
        }
    }

    public class g implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PkInviteUserListRefreshLayout f101993a;

        @Override // java.lang.Runnable
        public final void run() {
            PkInviteUserListRefreshLayout r100 = this.f101993a;     // Catch: Throwable -> L4
            r100.f101973n = true;     // Catch: Throwable -> L4
            PkInviteUserListRefreshLayout.a(r100, r100.f101968i + r100.getPaddingTop(), this.f101993a.f101985z);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public g(PkInviteUserListRefreshLayout r100) {
            this.f101993a = r100;
        }
    }

    public class h implements View.OnTouchListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PkInviteUserListRefreshLayout f101994a;

        public h(PkInviteUserListRefreshLayout r100) {
            this.f101994a = r100;
        }

        @Override // android.view.View.OnTouchListener
        public final boolean onTouch(View r100, MotionEvent r101) {
            return this.f101994a.f101978s;
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

    public interface j {
        boolean a(MotionEvent r100);
    }

    public interface k {
        void onFinish();

        void onRefresh();

        void y0();

        void z1();
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void requestDisallowInterceptTouchEvent(boolean r100) {
    }

    static {
        E = new int[]{R.attr.enabled};
    }

    public final boolean d() {
        RecyclerView r100 = this.f101980u;
        if (r100 != null) goto L6;
        return true;
    L6:
        if ((r100.getLayoutManager() instanceof LinearLayoutManager) == true) goto L8;
        return true;
    L8:
        if (((LinearLayoutManager) this.f101980u.getLayoutManager()).findFirstVisibleItemPosition() == 0) goto L10;
    L18:
        return false;
    L10:
        if (this.f101980u.getChildAt(0).getY() != 0.0f) goto L18;
        View r101 = this.f101982w;
        if (r101 != null) goto L14;
        return true;
    L14:
        if (r101.getY() >= 0.0f) goto L21;
        return false;
    L21:
        return true;
    }

    public final void e() {
        if (this.f101960a != null) goto L13;
        if (getChildCount() > 2) goto L7;
    L11:
        View r100 = getChildAt(1);
        this.f101960a = r100;
        r100.setOnTouchListener(new h(this));
        this.f101961b = this.f101960a.getTop() + getPaddingTop();
        goto L13
    L7:
        if (isInEditMode() == true) goto L11;
        throw new IllegalStateException("SwipeRefreshLayout can only host two children");
    L13:
        if (this.f101966g == (-1.0f)) goto L15;
        return;
    L15:
        if (getParent() != null) goto L17;
        return;
    L17:
        if (((View) getParent()).getHeight() <= 0) goto L22;
        Resources r101 = getResources();
        this.f101966g = (int) Math.min(((View) getParent()).getHeight() * 0.6f, WindowDisplayMetricsOverride.apply(r101, r101.getDisplayMetrics()).density * 120.0f);
        return;
    }

    public final void g() {
        this.B.run();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        removeCallbacks(this.D);
        removeCallbacks(this.B);
        removeCallbacks(this.C);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.B);
        removeCallbacks(this.D);
        removeCallbacks(this.C);
    }

    public PkInviteUserListRefreshLayout(Context r100) {
        this(r100, null);
    }

    private void setTargetOffsetTopAndBottom(int r100) {
        this.f101960a.offsetTopAndBottom(r100);
        this.f101975p.offsetTopAndBottom(r100);
        this.f101968i = this.f101960a.getTop();
        invalidate();
    }

    public final boolean c(MotionEvent r100) {
        if (this.f101980u != null) goto L5;
    L7:
        j r101 = this.f101981v;
        if (r101 == null) goto L13;
        if (r101.a(r100) == false) goto L13;
        return true;
    L13:
        return ViewCompat.canScrollVertically(this.f101960a, -1);
    L5:
        if (d() == true) goto L7;
        return true;
    }

    public final void f(MotionEvent r100) {
        int r101 = MotionEventCompat.getActionIndex(r100);
        if (MotionEventCompat.getPointerId(r100, r101) != this.f101972m) goto L9;
        if (r101 != 0) goto L6;
        int r102 = 1;
    L7:
        this.f101970k = MotionEventCompat.getY(r100, r102);
        this.f101972m = MotionEventCompat.getPointerId(r100, r102);
        return;
    L6:
        r102 = 0;
        goto L7
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r100) {
        if (this.f101979t == false) goto L5;
        return false;
    L5:
        e();
        int r101 = MotionEventCompat.getActionMasked(r100);
        if (this.f101973n == false) goto L10;
        if (r101 != 0) goto L10;
        this.f101973n = false;
    L10:
        if (isEnabled() == true) goto L12;
        return false;
    L12:
        if (this.f101973n == false) goto L14;
        return false;
    L14:
        if (c(r100) == false) goto L17;
        return false;
    L17:
        if (r101 != 0) goto L19;
        getParent().requestDisallowInterceptTouchEvent(true);
        float r102 = r100.getY();
        this.f101969j = r102;
        this.f101970k = r102;
        this.f101972m = MotionEventCompat.getPointerId(r100, 0);
        this.f101971l = false;
    L40:
        if (this.f101971l == true) goto L42;
        return false;
    L42:
        if (d() == false) goto L48;
        return true;
    L48:
        return false;
    L19:
        if (r101 != 1) goto L21;
    L37:
        getParent().requestDisallowInterceptTouchEvent(false);
        this.f101971l = false;
        this.f101972m = -1;
        goto L40
    L21:
        if (r101 != 2) goto L23;
        int r103 = this.f101972m;
        if (r103 != (-1)) goto L31;
        return false;
    L31:
        int r104 = MotionEventCompat.findPointerIndex(r100, r103);
        if (r104 >= 0) goto L34;
        return false;
    L34:
        float r105 = MotionEventCompat.getY(r100, r104);
        if ((r105 - this.f101969j) <= this.f101965f) goto L40;
        this.f101970k = r105;
        this.f101971l = true;
        goto L40
    L23:
        if (r101 == 3) goto L37;
        if (r101 != 6) goto L40;
        f(r100);
        goto L40
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r100) {
        if (this.f101979t == false) goto L5;
        return true;
    L5:
        int r101 = MotionEventCompat.getActionMasked(r100);
        int r102 = 0;
        if (this.f101973n == false) goto L10;
        if (r101 != 0) goto L10;
        this.f101973n = false;
    L10:
        if (isEnabled() == true) goto L12;
    L84:
        return false;
    L12:
        if (this.f101973n == true) goto L84;
        if (c(r100) == true) goto L84;
        if (r101 != 0) goto L18;
        float r103 = r100.getY();
        this.f101969j = r103;
        this.f101970k = r103;
        this.f101972m = MotionEventCompat.getPointerId(r100, 0);
        this.f101971l = false;
    L83:
        return true;
    L18:
        if (r101 == 1) goto L75;
        if (r101 != 2) goto L22;
        int r104 = MotionEventCompat.findPointerIndex(r100, this.f101972m);
        if (r104 >= 0) goto L35;
        return false;
    L35:
        float r105 = MotionEventCompat.getY(r100, r104);
        float r106 = r105 - this.f101969j;
        if (this.f101971l == true) goto L41;
        if (r106 <= this.f101965f) goto L41;
        this.f101971l = true;
    L41:
        if (this.f101971l == false) goto L83;
        k r107 = this.f101962c;
        if (r107 == null) goto L46;
        r107.z1();
    L46:
        if (r106 <= this.f101966g) goto L60;
        if (this.f101977r != STATUS.NORMAL) goto L52;
        this.f101977r = STATUS.LOOSEN;
        k r108 = this.f101962c;
        if (r108 == null) goto L52;
        r108.y0();
    L52:
        int r109 = (int) r106;
        int r110 = this.f101960a.getTop();
        float r111 = r109;
        float r112 = this.f101966g;
        if (r111 <= r112) goto L55;
        r102 = (((int) (r111 - r112)) / 2) + ((int) r112);
    L58:
        setTargetOffsetTopAndBottom(r102 - r110);
    L73:
        this.f101970k = r105;
        goto L83
    L55:
        if (r109 < 0) goto L58;
        r102 = r109;
        goto L58
    L60:
        if (this.f101977r != STATUS.LOOSEN) goto L62;
        this.f101977r = STATUS.NORMAL;
    L62:
        int r113 = (int) r106;
        int r114 = this.f101960a.getTop();
        float r115 = r113;
        float r116 = this.f101966g;
        if (r115 <= r116) goto L65;
        r102 = (((int) (r115 - r116)) / 2) + ((int) r116);
    L68:
        setTargetOffsetTopAndBottom(r102 - r114);
        if (this.f101970k <= r105) goto L73;
        if (this.f101960a.getTop() != getPaddingTop()) goto L73;
        removeCallbacks(this.D);
        goto L73
    L65:
        if (r113 < 0) goto L68;
        r102 = r113;
        goto L68
    L22:
        if (r101 != 3) goto L24;
        removeCallbacks(this.D);
        postDelayed(this.D, 300);
        this.f101971l = false;
        this.f101972m = -1;
        return false;
    L24:
        if (r101 != 5) goto L26;
        int r117 = MotionEventCompat.getActionIndex(r100);
        this.f101970k = MotionEventCompat.getY(r100, r117);
        this.f101972m = MotionEventCompat.getPointerId(r100, r117);
        goto L83
    L26:
        if (r101 != 6) goto L83;
        f(r100);
        goto L83
    L75:
        if (this.f101977r != STATUS.LOOSEN) goto L79;
        removeCallbacks(this.D);
        this.C.run();
        setRefreshing(true);
        this.f101978s = true;
        k r118 = this.f101962c;
        if (r118 == null) goto L80;
        r118.onRefresh();
    L80:
        this.f101971l = false;
        this.f101972m = -1;
        return false;
    L79:
        removeCallbacks(this.D);
        postDelayed(this.D, 300);
        goto L80
    }

    public void setCallBack(j r100) {
        this.f101981v = r100;
    }

    public void setFirstView(View r100) {
        this.f101982w = r100;
    }

    public void setOnRefreshListener(k r100) {
        this.f101962c = r100;
    }

    public void setRecyclerView(RecyclerView r100) {
        this.f101980u = r100;
    }

    public void setRefreshing(boolean r100) {
        if (this.f101964e == r100) goto L6;
        e();
        this.f101964e = r100;
        return;
    }

    public void setmIsDisable(boolean r100) {
        this.f101979t = r100;
    }

    public PkInviteUserListRefreshLayout(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.f101964e = false;
        this.f101966g = -1.0f;
        this.f101972m = -1;
        this.f101977r = STATUS.NORMAL;
        this.f101983x = new a(this);
        this.f101984y = new b(this);
        this.f101985z = new c(this);
        this.A = new d(this);
        this.B = new e(this);
        this.C = new f(this);
        this.D = new g(this);
        this.f101965f = ViewConfiguration.get(r100).getScaledTouchSlop();
        this.f101967h = getResources().getInteger(R.integer.config_mediumAnimTime);
        this.f101974o = new DecelerateInterpolator(2.0f);
        TypedArray r102 = r100.obtainStyledAttributes(r101, E);
        setEnabled(r102.getBoolean(0, true));
        r102.recycle();
    }

    public static /* synthetic */ void b(PkInviteUserListRefreshLayout r100, int r101) {
        r100.setTargetOffsetTopAndBottom(r101);
    }

    @Override // android.view.View
    public final void onMeasure(int r100, int r101) {
        super.onMeasure(r100, r101);
        if (getChildCount() <= 1) goto L17;
        if (getChildCount() <= 2) goto L12;
        if (isInEditMode() == true) goto L12;
        throw new IllegalStateException("SwipeRefreshLayout can only host two children");
    L12:
        if (this.f101975p != null) goto L14;
        View r102 = getChildAt(0);
        this.f101975p = r102;
        measureChild(r102, r100, r101);
        int r103 = this.f101975p.getMeasuredHeight();
        this.f101976q = r103;
        this.f101966g = r103;
    L14:
        getChildAt(1).measure(View.MeasureSpec.makeMeasureSpec((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), 1073741824), View.MeasureSpec.makeMeasureSpec((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), 1073741824));
        return;
    L17:
        throw new IllegalStateException("SwipeRefreshLayout must have the headerview and contentview");
    }

    public static void a(PkInviteUserListRefreshLayout r100, int r101, c r102) {
        r100.f101963d = r101;
        r100.f101983x.reset();
        r100.f101983x.setDuration(r100.f101967h);
        r100.f101983x.setAnimationListener(r102);
        r100.f101983x.setInterpolator(r100.f101974o);
        r100.f101960a.startAnimation(r100.f101983x);
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
        int r109 = this.f101968i + getPaddingTop();
        int r110 = (r105 - getPaddingLeft()) - getPaddingRight();
        int r111 = r110 + r108;
        r107.layout(r108, r109, r111, ((r106 - getPaddingTop()) - getPaddingBottom()) + r109);
        this.f101975p.layout(r108, r109 - this.f101976q, r111, r109);
        return;
    }
}
