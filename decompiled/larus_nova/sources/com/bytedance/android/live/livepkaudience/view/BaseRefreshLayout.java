package com.bytedance.android.live.livepkaudience.view;

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
import androidx.core.view.MotionEventCompat;
import androidx.core.view.ViewCompat;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.larus.apm.impl.protector.RunnableProtector;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.effectmanager.common.EffectConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001:\u0004\u0019\u001a\u001b\u001cB\u001d\b\u0007\u0012\u0006\u0010\u0014\u001a\u00020\u0013\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0015¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u000e\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tR*\u0010\u000f\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u00068\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u001d"}, d2 = {"Lcom/bytedance/android/live/livepkaudience/view/BaseRefreshLayout;", "Landroid/view/ViewGroup;", "", "offset", "", "setTargetOffsetTopAndBottom", "", "mIsDisable", "setmIsDisable", "Lcom/bytedance/android/live/livepkaudience/view/BaseRefreshLayout$c;", "listener", "setOnRefreshListener", "refreshing", "e", "Z", "isRefreshing", "()Z", "setRefreshing", "(Z)V", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "b", "c", CommonConstant.RETKEY.STATUS, "livepkaudience-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class BaseRefreshLayout extends ViewGroup {
    public static final int[] D = null;
    public final j A;
    public final h B;
    public final g C;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public View f82261a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f82262b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public c f82263c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f82264d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f82265e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f82266f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f82267g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f82268h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f82269i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public float f82270j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public float f82271k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f82272l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f82273m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f82274n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final DecelerateInterpolator f82275o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public View f82276p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f82277q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public STATUS f82278r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f82279s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f82280t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public float f82281u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public float f82282v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final f f82283w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final e f82284x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final k f82285y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final i f82286z;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0082\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/livepkaudience/view/BaseRefreshLayout$STATUS;", "", EffectConstants.NORMAL, "LOOSEN", "REFRESHING", "livepkaudience-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum STATUS extends Enum<STATUS> {
        public static final STATUS LOOSEN = null;
        public static final STATUS NORMAL = null;
        public static final STATUS REFRESHING = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ STATUS[] f82287a = null;

        static {
            STATUS r100 = new STATUS(EffectConstants.NORMAL, 0);
            NORMAL = r100;
            STATUS r101 = new STATUS("LOOSEN", 1);
            LOOSEN = r101;
            STATUS r102 = new STATUS("REFRESHING", 2);
            REFRESHING = r102;
            f82287a = new STATUS[]{r100, r101, r102};
        }

        public static STATUS valueOf(String r100) {
            return (STATUS) r27.a.a(STATUS.class, r100);
        }

        public static STATUS[] values() {
            return (STATUS[]) f82287a.clone();
        }

        public STATUS(String r100, int r101) {
            super(r100, r101);
        }
    }

    public class a implements Animation.AnimationListener {
        @Override // android.view.animation.Animation.AnimationListener
        public final void onAnimationRepeat(Animation r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public final void onAnimationStart(Animation r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        }

        public a() {
        }
    }

    public static final class b {
    }

    public interface c {
        void onFinish();

        void onRefresh();

        void y0();

        void z1();
    }

    public static final class d implements View.OnTouchListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BaseRefreshLayout f82288a;

        public d(BaseRefreshLayout r100) {
            this.f82288a = r100;
        }

        @Override // android.view.View.OnTouchListener
        public final boolean onTouch(View r100, MotionEvent r101) {
            return this.f82288a.f82279s;
        }
    }

    public static final class e extends Animation {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BaseRefreshLayout f82289a;

        public e(BaseRefreshLayout r100) {
            this.f82289a = r100;
        }

        @Override // android.view.animation.Animation
        public final void applyTransformation(float r100, Transformation r101) {
            Intrinsics.checkNotNullParameter(r101, "t");
            BaseRefreshLayout r102 = this.f82289a;
            int r103 = r102.f82264d;
            int r104 = r102.f82277q;
            if (r103 == r104) goto L5;
            int r105 = r103 + ((int) ((r104 - r103) * r100));
        L6:
            View r106 = r102.f82261a;
            Intrinsics.checkNotNull(r106);
            int r107 = r105 - r106.getTop();
            View r108 = this.f82289a.f82261a;
            Intrinsics.checkNotNull(r108);
            int r109 = r108.getTop();
            if ((r107 + r109) >= 0) goto L9;
            r107 = 0 - r109;
        L9:
            BaseRefreshLayout.b(this.f82289a, r107);
            return;
        L5:
            r105 = 0;
            goto L6
        }
    }

    public static final class f extends Animation {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BaseRefreshLayout f82290a;

        public f(BaseRefreshLayout r100) {
            this.f82290a = r100;
        }

        @Override // android.view.animation.Animation
        public final void applyTransformation(float r100, Transformation r101) {
            Intrinsics.checkNotNullParameter(r101, "t");
            BaseRefreshLayout r102 = this.f82290a;
            int r103 = r102.f82264d;
            int r104 = r102.f82262b;
            if (r103 == r104) goto L5;
            int r105 = r103 + ((int) ((r104 - r103) * r100));
        L6:
            View r106 = r102.f82261a;
            Intrinsics.checkNotNull(r106);
            int r107 = r105 - r106.getTop();
            View r108 = this.f82290a.f82261a;
            Intrinsics.checkNotNull(r108);
            int r109 = r108.getTop();
            if ((r107 + r109) >= 0) goto L9;
            r107 = 0 - r109;
        L9:
            BaseRefreshLayout.b(this.f82290a, r107);
            return;
        L5:
            r105 = 0;
            goto L6
        }
    }

    public static final class g implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BaseRefreshLayout f82291a;

        public g(BaseRefreshLayout r100) {
            this.f82291a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            BaseRefreshLayout r100 = this.f82291a;     // Catch: Throwable -> L4
            r100.f82274n = true;     // Catch: Throwable -> L4
            BaseRefreshLayout.a(r100, r100.f82269i + r100.getPaddingTop(), this.f82291a.f82285y);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class h implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BaseRefreshLayout f82292a;

        public h(BaseRefreshLayout r100) {
            this.f82292a = r100;
        }

        public final void a() {
            BaseRefreshLayout r100 = this.f82292a;
            r100.f82274n = true;
            int r101 = r100.f82269i + r100.getPaddingTop();
            i r102 = this.f82292a.f82286z;
            r100.f82264d = r101;
            r100.f82284x.reset();
            r100.f82284x.setDuration(r100.f82268h);
            r100.f82284x.setAnimationListener(r102);
            r100.f82284x.setInterpolator(r100.f82275o);
            View r103 = r100.f82261a;
            Intrinsics.checkNotNull(r103);
            r103.startAnimation(r100.f82284x);
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
    }

    public static final class i extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BaseRefreshLayout f82293a;

        public i(BaseRefreshLayout r100) {
            this.f82293a = r100;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public final void onAnimationEnd(Animation r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            BaseRefreshLayout r101 = this.f82293a;
            r101.f82269i = r101.f82277q;
            r101.f82278r = STATUS.REFRESHING;
        }
    }

    public static final class j implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BaseRefreshLayout f82294a;

        public j(BaseRefreshLayout r100) {
            this.f82294a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            BaseRefreshLayout r100 = this.f82294a;     // Catch: Throwable -> L4
            r100.f82274n = true;     // Catch: Throwable -> L4
            BaseRefreshLayout.a(r100, r100.f82269i + r100.getPaddingTop(), this.f82294a.f82285y);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class k extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BaseRefreshLayout f82295a;

        public k(BaseRefreshLayout r100) {
            this.f82295a = r100;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public final void onAnimationEnd(Animation r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            BaseRefreshLayout r101 = this.f82295a;
            r101.f82269i = 0;
            r101.f82278r = STATUS.NORMAL;
            r101.f82279s = false;
            c r102 = r101.f82263c;
            if (r102 == null) goto L6;
            r102.onFinish();
            return;
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void requestDisallowInterceptTouchEvent(boolean r100) {
    }

    static {
        D = new int[]{R.attr.enabled};
    }

    public final void c() {
        if (this.f82261a != null) goto L18;
        if (getChildCount() > 2) goto L7;
    L10:
        boolean r100 = true;
    L11:
        if (r100 == false) goto L16;
        View r101 = getChildAt(1);
        this.f82261a = r101;
        if (r101 == null) goto L18;
        r101.setOnTouchListener(new d(this));
        this.f82262b = r101.getTop() + getPaddingTop();
        goto L18
    L16:
        throw new IllegalStateException("SwipeRefreshLayout can only host two children".toString());
    L7:
        if (isInEditMode() == true) goto L10;
        r100 = false;
    L18:
        if (this.f82267g == (-1.0f)) goto L20;
        return;
    L20:
        if (getParent() == null) goto L33;
        Object r102 = getParent();
        if (r102 == null) goto L31;
        if (((View) r102).getHeight() <= 0) goto L34;
        Resources r103 = getResources();
        DisplayMetrics r104 = WindowDisplayMetricsOverride.apply(r103, r103.getDisplayMetrics());
        Object r105 = getParent();
        if (r105 == null) goto L29;
        this.f82267g = (int) Math.min(((View) r105).getHeight() * 0.6f, 120 * r104.density);
        return;
    L29:
        throw new NullPointerException("null cannot be cast to non-null type android.view.View");
    L34:
        return;
    L31:
        throw new NullPointerException("null cannot be cast to non-null type android.view.View");
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        removeCallbacks(this.C);
        removeCallbacks(this.A);
        removeCallbacks(this.B);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.A);
        removeCallbacks(this.C);
        removeCallbacks(this.B);
    }

    public BaseRefreshLayout(Context r100) {
        this(r100, null);
    }

    private final void setTargetOffsetTopAndBottom(int r100) {
        View r101 = this.f82261a;
        Intrinsics.checkNotNull(r101);
        r101.offsetTopAndBottom(r100);
        View r102 = this.f82276p;
        Intrinsics.checkNotNull(r102);
        r102.offsetTopAndBottom(r100);
        View r103 = this.f82261a;
        Intrinsics.checkNotNull(r103);
        this.f82269i = r103.getTop();
        invalidate();
    }

    public final void d(MotionEvent r100) {
        int r101 = MotionEventCompat.getActionIndex(r100);
        if (MotionEventCompat.getPointerId(r100, r101) != this.f82273m) goto L9;
        if (r101 != 0) goto L6;
        int r102 = 1;
    L7:
        this.f82271k = MotionEventCompat.getY(r100, r102);
        this.f82273m = MotionEventCompat.getPointerId(r100, r102);
        return;
    L6:
        r102 = 0;
        goto L7
    }

    public final void e(int r100) {
        View r101 = this.f82261a;
        Intrinsics.checkNotNull(r101);
        int r102 = r101.getTop();
        float r103 = r100;
        float r104 = this.f82267g;
        if (r103 <= r104) goto L5;
        r100 = ((int) r104) + (((int) (r103 - r104)) / 2);
    L7:
        setTargetOffsetTopAndBottom(r100 - r102);
        return;
    L5:
        if (r100 >= 0) goto L7;
        r100 = 0;
        goto L7
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "ev");
        boolean r101 = false;
        if (this.f82280t == false) goto L5;
        return false;
    L5:
        c();
        int r102 = MotionEventCompat.getActionMasked(r100);
        if (this.f82274n == false) goto L10;
        if (r102 != 0) goto L10;
        this.f82274n = false;
    L10:
        if (isEnabled() == true) goto L12;
    L44:
        return false;
    L12:
        if (this.f82274n == true) goto L44;
        View r103 = this.f82261a;
        Intrinsics.checkNotNull(r103);
        if (ViewCompat.canScrollVertically(r103, -1) == true) goto L44;
        if (r102 != 0) goto L18;
        float r104 = r100.getY();
        this.f82270j = r104;
        this.f82271k = r104;
        r100.getX();
        this.f82273m = MotionEventCompat.getPointerId(r100, 0);
        this.f82272l = false;
        this.f82281u = r100.getX();
        this.f82282v = r100.getY();
    L42:
        this.f82281u = r100.getX();
        this.f82282v = r100.getY();
        return this.f82272l;
    L18:
        if (r102 != 1) goto L20;
    L40:
        this.f82272l = false;
        this.f82273m = -1;
        goto L42
    L20:
        if (r102 != 2) goto L22;
        int r105 = this.f82273m;
        if (r105 != (-1)) goto L30;
        return false;
    L30:
        int r106 = MotionEventCompat.findPointerIndex(r100, r105);
        if (r106 >= 0) goto L33;
        return false;
    L33:
        float r107 = MotionEventCompat.getY(r100, r106);
        MotionEventCompat.getX(r100, r106);
        if ((r107 - this.f82270j) <= this.f82266f) goto L42;
        if (Math.abs(r100.getX() - this.f82281u) >= Math.abs(r100.getY() - this.f82282v)) goto L38;
        r101 = true;
    L38:
        if (r101 == false) goto L42;
        this.f82271k = r107;
        this.f82272l = true;
        goto L42
    L22:
        if (r102 == 3) goto L40;
        if (r102 != 6) goto L42;
        d(r100);
        goto L42
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "ev");
        if (this.f82280t == false) goto L5;
        return true;
    L5:
        int r101 = MotionEventCompat.getActionMasked(r100);
        if (this.f82274n == false) goto L10;
        if (r101 != 0) goto L10;
        this.f82274n = false;
    L10:
        if (isEnabled() == true) goto L12;
    L72:
        return false;
    L12:
        if (this.f82274n == true) goto L72;
        View r102 = this.f82261a;
        Intrinsics.checkNotNull(r102);
        if (ViewCompat.canScrollVertically(r102, -1) == true) goto L72;
        if (r101 != 0) goto L18;
        float r103 = r100.getY();
        this.f82270j = r103;
        this.f82271k = r103;
        this.f82273m = MotionEventCompat.getPointerId(r100, 0);
        this.f82272l = false;
    L71:
        return true;
    L18:
        if (r101 == 1) goto L63;
        if (r101 != 2) goto L22;
        int r104 = MotionEventCompat.findPointerIndex(r100, this.f82273m);
        if (r104 >= 0) goto L35;
        return false;
    L35:
        float r105 = MotionEventCompat.getY(r100, r104);
        float r106 = r105 - this.f82270j;
        if (this.f82272l == true) goto L41;
        if (r106 <= this.f82266f) goto L41;
        this.f82272l = true;
    L41:
        if (this.f82272l == false) goto L71;
        c r107 = this.f82263c;
        if (r107 == null) goto L46;
        Intrinsics.checkNotNull(r107);
        r107.z1();
    L46:
        if (r106 <= this.f82267g) goto L54;
        if (this.f82278r != STATUS.NORMAL) goto L52;
        this.f82278r = STATUS.LOOSEN;
        c r108 = this.f82263c;
        if (r108 == null) goto L52;
        Intrinsics.checkNotNull(r108);
        r108.y0();
    L52:
        e((int) r106);
    L61:
        this.f82271k = r105;
        goto L71
    L54:
        if (this.f82278r != STATUS.LOOSEN) goto L56;
        this.f82278r = STATUS.NORMAL;
    L56:
        e((int) r106);
        if (this.f82271k <= r105) goto L61;
        View r109 = this.f82261a;
        Intrinsics.checkNotNull(r109);
        if (r109.getTop() != getPaddingTop()) goto L61;
        removeCallbacks(this.C);
        goto L61
    L22:
        if (r101 != 3) goto L24;
        removeCallbacks(this.C);
        postDelayed(this.C, 300);
        this.f82272l = false;
        this.f82273m = -1;
        return false;
    L24:
        if (r101 != 5) goto L26;
        int r110 = MotionEventCompat.getActionIndex(r100);
        this.f82271k = MotionEventCompat.getY(r100, r110);
        this.f82273m = MotionEventCompat.getPointerId(r100, r110);
        goto L71
    L26:
        if (r101 != 6) goto L71;
        d(r100);
        goto L71
    L63:
        if (this.f82278r != STATUS.LOOSEN) goto L67;
        removeCallbacks(this.C);
        this.B.run();
        setRefreshing(true);
        this.f82279s = true;
        c r111 = this.f82263c;
        if (r111 == null) goto L68;
        Intrinsics.checkNotNull(r111);
        r111.onRefresh();
    L68:
        this.f82272l = false;
        this.f82273m = -1;
        return false;
    L67:
        removeCallbacks(this.C);
        postDelayed(this.C, 300);
        goto L68
    }

    public final void setOnRefreshListener(c r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.f82263c = r100;
    }

    public final void setRefreshing(boolean r100) {
        if (this.f82265e == r100) goto L6;
        c();
        this.f82265e = r100;
        return;
    }

    public final void setmIsDisable(boolean r100) {
        this.f82280t = r100;
    }

    public BaseRefreshLayout(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        this.f82267g = -1.0f;
        this.f82273m = -1;
        this.f82278r = STATUS.NORMAL;
        this.f82283w = new f(this);
        this.f82284x = new e(this);
        this.f82285y = new k(this);
        this.f82286z = new i(this);
        this.A = new j(this);
        this.B = new h(this);
        this.C = new g(this);
        this.f82266f = ViewConfiguration.get(r100).getScaledTouchSlop();
        this.f82268h = getResources().getInteger(R.integer.config_mediumAnimTime);
        this.f82275o = new DecelerateInterpolator(2.0f);
        TypedArray r102 = r100.obtainStyledAttributes(r101, D);
        setEnabled(r102.getBoolean(0, true));
        r102.recycle();
    }

    public static final /* synthetic */ void b(BaseRefreshLayout r100, int r101) {
        r100.setTargetOffsetTopAndBottom(r101);
    }

    @Override // android.view.View
    public final void onMeasure(int r100, int r101) {
        super.onMeasure(r100, r101);
        int r102 = 0;
        if (getChildCount() <= 1) goto L5;
        boolean r103 = true;
    L6:
        if (r103 == false) goto L26;
        if (getChildCount() > 2) goto L10;
    L13:
        boolean r104 = true;
    L14:
        if (r104 == false) goto L24;
        if (this.f82276p != null) goto L21;
        View r105 = getChildAt(0);
        this.f82276p = r105;
        measureChild(r105, r100, r101);
        View r106 = this.f82276p;
        if (r106 == null) goto L20;
        r102 = r106.getMeasuredHeight();
    L20:
        this.f82277q = r102;
        this.f82267g = r102;
    L21:
        getChildAt(1).measure(View.MeasureSpec.makeMeasureSpec((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), 1073741824), View.MeasureSpec.makeMeasureSpec((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), 1073741824));
        return;
    L24:
        throw new IllegalStateException("SwipeRefreshLayout can only host two children".toString());
    L10:
        if (isInEditMode() == true) goto L13;
        r104 = false;
        goto L14
    L26:
        throw new IllegalStateException("SwipeRefreshLayout must have the headerview and contentview".toString());
    L5:
        r103 = false;
        goto L6
    }

    public static final void a(BaseRefreshLayout r100, int r101, k r102) {
        r100.f82264d = r101;
        r100.f82283w.reset();
        r100.f82283w.setDuration(r100.f82268h);
        r100.f82283w.setAnimationListener(r102);
        r100.f82283w.setInterpolator(r100.f82275o);
        View r103 = r100.f82261a;
        Intrinsics.checkNotNull(r103);
        r103.startAnimation(r100.f82283w);
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
        int r109 = this.f82269i + getPaddingTop();
        int r110 = (r105 - getPaddingLeft()) - getPaddingRight();
        int r111 = r110 + r108;
        r107.layout(r108, r109, r111, ((r106 - getPaddingTop()) - getPaddingBottom()) + r109);
        View r112 = this.f82276p;
        Intrinsics.checkNotNull(r112);
        r112.layout(r108, r109 - this.f82277q, r111, r109);
        return;
    }
}
