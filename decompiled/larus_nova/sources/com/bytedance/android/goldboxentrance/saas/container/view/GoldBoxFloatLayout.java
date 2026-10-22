package com.bytedance.android.goldboxentrance.saas.container.view;

import android.content.Context;
import android.os.Vibrator;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import vw.c;
import vw.d;
import vw.e;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\u0002;<B\u0011\b\u0016\u0012\u0006\u00102\u001a\u000201¢\u0006\u0004\b3\u00104B\u001b\b\u0016\u0012\u0006\u00102\u001a\u000201\u0012\b\u00106\u001a\u0004\u0018\u000105¢\u0006\u0004\b3\u00107B#\b\u0016\u0012\u0006\u00102\u001a\u000201\u0012\b\u00106\u001a\u0004\u0018\u000105\u0012\u0006\u00109\u001a\u000208¢\u0006\u0004\b3\u0010:J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\u0012\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J\u0010\u0010\f\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u000bH\u0016J\u0010\u0010\u000f\u001a\u00020\t2\b\u0010\u000e\u001a\u0004\u0018\u00010\rJ\u0010\u0010\u0011\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0010H\u0016R\"\u0010\u0018\u001a\u00020\u00048\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\"\u0010 \u001a\u00020\u00198\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\"\u0010(\u001a\u00020!8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\"\u0010,\u001a\u00020\u00198\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b)\u0010\u001b\u001a\u0004\b*\u0010\u001d\"\u0004\b+\u0010\u001fR\"\u00100\u001a\u00020\u00198\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b-\u0010\u001b\u001a\u0004\b.\u0010\u001d\"\u0004\b/\u0010\u001f¨\u0006="}, d2 = {"Lcom/bytedance/android/goldboxentrance/saas/container/view/GoldBoxFloatLayout;", "Landroid/widget/FrameLayout;", "Landroid/view/View$OnTouchListener;", "", "", "getTopMargin", "getBottomMargin", "Lvw/d;", "listener", "", "setOnMoveListener", "Landroid/view/View$OnClickListener;", "setOnContentClickListener", "Lcom/bytedance/android/goldboxentrance/saas/container/view/GoldBoxFloatLayout$b;", "onPositionChangedListener", "setOnPositionChangedListener", "Lvw/e;", "setOnDragUpListener", "q", FaceService.girlLabel, "getMaxDragX", "()F", "setMaxDragX", "(F)V", "maxDragX", "", "r", "Z", "getCanDrag", "()Z", "setCanDrag", "(Z)V", "canDrag", "Lcom/bytedance/android/goldboxentrance/saas/container/view/FloatStaySide;", "s", "Lcom/bytedance/android/goldboxentrance/saas/container/view/FloatStaySide;", "getStaySide", "()Lcom/bytedance/android/goldboxentrance/saas/container/view/FloatStaySide;", "setStaySide", "(Lcom/bytedance/android/goldboxentrance/saas/container/view/FloatStaySide;)V", "staySide", "t", "getAutoAdsorption", "setAutoAdsorption", "autoAdsorption", "u", "getStayOnRight", "setStayOnRight", "stayOnRight", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "b", "liveprofit-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class GoldBoxFloatLayout extends FrameLayout implements View.OnTouchListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f58116a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f58117b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f58118c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f58119d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f58120e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f58121f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f58122g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f58123h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public float f58124i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public b f58125j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public e f58126k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f58127l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public long f58128m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f58129n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public float f58130o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public float f58131p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public float f58132q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f58133r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public FloatStaySide f58134s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f58135t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f58136u;

    public static final class a {
    }

    public interface b {
        void b(float r100, float r101);
    }

    static {
    }

    public void setOnContentClickListener(View.OnClickListener r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
    }

    public void setOnMoveListener(d r100) {
    }

    private final float getBottomMargin() {
        return this.f58124i;
    }

    private final float getTopMargin() {
        return this.f58122g;
    }

    public boolean getAutoAdsorption() {
        return this.f58135t;
    }

    public boolean getCanDrag() {
        return this.f58133r;
    }

    public float getMaxDragX() {
        return this.f58132q;
    }

    public final boolean getStayOnRight() {
        return this.f58136u;
    }

    public FloatStaySide getStaySide() {
        return this.f58134s;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    public GoldBoxFloatLayout(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        this.f58132q = Integer.MAX_VALUE;
        this.f58133r = true;
        this.f58134s = FloatStaySide.SideRight;
        this.f58135t = true;
        this.f58120e = ViewConfiguration.get(r100).getScaledTouchSlop();
        setOnTouchListener(this);
    }

    public final boolean b(MotionEvent r100) {
        if (Math.abs(this.f58118c - r100.getRawX()) <= this.f58120e) goto L5;
    L8:
        return true;
    L5:
        if (Math.abs(this.f58119d - r100.getRawY()) > this.f58120e) goto L8;
        return false;
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r100) {
        if (r100 != null) goto L5;
        return false;
    L5:
        int r101 = r100.getActionMasked();
        if (r101 == 0) goto L29;
        if (r101 != 1) goto L9;
        getParent().requestDisallowInterceptTouchEvent(false);
    L28:
        return false;
    L9:
        if (r101 != 2) goto L28;
        if (getCanDrag() == true) goto L14;
        return false;
    L14:
        if (b(r100) == false) goto L28;
        this.f58116a = getX() - r100.getRawX();
        this.f58117b = getY() - r100.getRawY();
        if (b(r100) == true) goto L19;
    L25:
        return true;
    L19:
        if (this.f58129n == true) goto L25;
        this.f58129n = true;
        setAlpha(0.5f);
        Object r102 = getContext().getApplicationContext().getSystemService("vibrator");
        if (r102 == null) goto L24;
        ((Vibrator) r102).vibrate(50);
        goto L25
    L24:
        throw new NullPointerException("null cannot be cast to non-null type android.os.Vibrator");
    L29:
        this.f58128m = System.currentTimeMillis();
        this.f58118c = r100.getRawX();
        this.f58119d = r100.getRawY();
        getParent().requestDisallowInterceptTouchEvent(true);
        this.f58129n = false;
        return false;
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r100) {
        return super.onTouchEvent(r100);
    }

    public void setAutoAdsorption(boolean r100) {
        this.f58135t = r100;
    }

    public void setCanDrag(boolean r100) {
        this.f58133r = r100;
    }

    public void setMaxDragX(float r100) {
        this.f58132q = r100;
    }

    public void setOnDragUpListener(e r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.f58126k = r100;
    }

    public final void setOnPositionChangedListener(b r100) {
        this.f58125j = r100;
    }

    public final void setStayOnRight(boolean r100) {
        this.f58136u = r100;
    }

    public void setStaySide(FloatStaySide r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f58134s = r100;
    }

    public GoldBoxFloatLayout(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        this.f58132q = Integer.MAX_VALUE;
        this.f58133r = true;
        this.f58134s = FloatStaySide.SideRight;
        this.f58135t = true;
        this.f58120e = ViewConfiguration.get(r100).getScaledTouchSlop();
        setOnTouchListener(this);
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View r110, MotionEvent r111) {
        Intrinsics.checkNotNullParameter(r110, "view");
        Intrinsics.checkNotNullParameter(r111, "event");
        int r100 = r111.getActionMasked();
        boolean r101 = true;
        if (r100 != 0) goto L5;
        this.f58128m = System.currentTimeMillis();
        this.f58118c = r111.getRawX();
        this.f58119d = r111.getRawY();
        this.f58116a = getX() - r111.getRawX();
        this.f58117b = getY() - r111.getRawY();
        getParent().requestDisallowInterceptTouchEvent(true);
        this.f58129n = false;
    L75:
        return true;
    L5:
        if (r100 == 1) goto L20;
        if (r100 == 2) goto L10;
        return super.onTouchEvent(r111);
    L10:
        if (getCanDrag() == false) goto L19;
        Object r102 = r110.getParent();
        if (r102 == null) goto L18;
        View r103 = (View) r102;
        int r104 = r103.getWidth();
        int r105 = r103.getHeight();
        float r106 = Math.min(Math.max(0.0f, Math.max(r111.getRawX() + this.f58116a, this.f58121f)), (r104 - r110.getWidth()) - this.f58123h);
        if (r106 > getMaxDragX()) goto L16;
        setX(r106);
    L16:
        setY(Math.min(Math.max(0.0f, r111.getRawY() + this.f58117b), r105 - r110.getHeight()));
        goto L75
    L18:
        throw new NullPointerException("null cannot be cast to non-null type android.view.View");
    L19:
        return true;
    L20:
        getParent().requestDisallowInterceptTouchEvent(false);
        setAlpha(1.0f);
        float r107 = r111.getRawX();
        float r112 = r111.getRawY();
        float r108 = r107 - this.f58118c;
        float r113 = r112 - this.f58119d;
        if (Math.abs(r108) < this.f58120e) goto L23;
    L29:
        boolean r114 = false;
    L30:
        if (r114 == false) goto L32;
        return true;
    L32:
        Object r115 = r110.getParent();
        if (r115 == null) goto L73;
        View r116 = (View) r115;
        r110.getX();
        float r109 = r110.getY();
        if (r110.getX() != 0.0f) goto L37;
        int r117 = c.f557415a;
        float r118 = 0.0f;
    L38:
        int r119 = vw.a.f557413a[getStaySide().ordinal()];
        if (r119 == 1) goto L48;
        if (r119 != 2) goto L42;
    L49:
        this.f58136u = r101;
        if (r101 == false) goto L52;
        float r120 = r116.getRight() - r110.getWidth();
        this.f58130o = r120;
        this.f58130o = Math.max(0.0f, r120) - this.f58123h;
    L53:
        float r121 = getTopMargin();
        float r122 = getBottomMargin();
        this.f58131p = r109;
        if ((r110.getY() + r116.getTop()) >= r121) goto L57;
        this.f58131p = r116.getTop() + r121;
    L57:
        if (((r116.getBottom() - r110.getY()) - r110.getHeight()) >= r122) goto L60;
        this.f58131p = (r116.getBottom() - r110.getHeight()) - r122;
    L60:
        if (getAutoAdsorption() == false) goto L66;
        b r123 = this.f58125j;
        if (r123 == null) goto L64;
        r123.b(this.f58130o, this.f58131p);
    L64:
        c(r110, this.f58130o, this.f58131p, 200);
    L66:
        if (this.f58129n == false) goto L78;
        e r124 = this.f58126k;
        if (r124 == null) goto L77;
        r124.a();
        return false;
    L77:
        return false;
    L78:
        return false;
    L52:
        this.f58130o = r116.getLeft();
        this.f58130o = Math.min(r116.getWidth() - r110.getWidth(), this.f58130o) + this.f58121f;
        goto L53
    L42:
        if (r119 != 3) goto L47;
        if (((r118 + (r110.getWidth() / 2)) - 0.0f) <= (r116.getWidth() / 2)) goto L48;
    L47:
        throw new NoWhenBranchMatchedException();
    L48:
        r101 = false;
        goto L49
    L37:
        r118 = r110.getX();
        goto L38
    L73:
        throw new NullPointerException("null cannot be cast to non-null type android.view.View");
    L23:
        if (Math.abs(r113) >= this.f58120e) goto L29;
        if ((System.currentTimeMillis() - this.f58128m) >= 250) goto L29;
        if (performClick() == false) goto L29;
        r114 = true;
        goto L30
    }

    public GoldBoxFloatLayout(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f58132q = Integer.MAX_VALUE;
        this.f58133r = true;
        this.f58134s = FloatStaySide.SideRight;
        this.f58135t = true;
        this.f58120e = ViewConfiguration.get(r100).getScaledTouchSlop();
        setOnTouchListener(this);
    }

    public final void a(float r100, float r101, int r102) {
        Object r103 = getParent();
        if ((r103 instanceof View) == true) goto L5;
        r103 = null;
    L5:
        View r104 = (View) r103;
        if (r104 != null) goto L9;
        return;
    L9:
        if (((r104.getWidth() - getWidth()) - r100) >= this.f58123h) goto L11;
        float r105 = (r104.getWidth() - this.f58123h) - getWidth();
    L12:
        float r106 = this.f58121f;
        if (r100 >= r106) goto L16;
        r105 = r106;
    L16:
        if (((r104.getHeight() - getHeight()) - r101) >= this.f58124i) goto L18;
        float r107 = (r104.getHeight() - this.f58124i) - getHeight();
    L19:
        float r108 = this.f58122g;
        if (r101 >= r108) goto L22;
        r107 = r108;
    L22:
        if (r102 <= 0) goto L24;
        c(this, r105, r107, r102);
        return;
    L24:
        if (r105 > getMaxDragX()) goto L26;
        setX(r105);
    L26:
        setY(r107);
        return;
    L18:
        r107 = r101;
        goto L19
    L11:
        r105 = r100;
        goto L12
    }

    public static void c(View r100, float r101, float r102, int r103) {
        Intrinsics.checkNotNullParameter(r100, "view");
        r100.animate().x(r101).y(r102).setInterpolator(new DecelerateInterpolator()).setDuration(r103).start();
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r100, int r101, int r102, int r103, int r104) {
        super.onLayout(r100, r101, r102, r103, r104);
        this.f58127l = true;
    }
}
