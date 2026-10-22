package com.bytedance.android.shopping.anchorv4.widgets;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.Scroller;
import androidx.recyclerview.widget.RecyclerView;
import com.amap.api.col.s.ce;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.android.shopping.anchorv3.widget.BasePdpRecyclerView;
import com.bytedance.android.shopping.extensions.ViewExtensionsKt;
import com.bytedance.common.utility.Logger;
import com.bytedance.services.apm.api.EnsureManager;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0002()B'\b\u0007\u0012\u0006\u0010\"\u001a\u00020!\u0012\n\b\u0002\u0010$\u001a\u0004\u0018\u00010#\u0012\b\b\u0002\u0010%\u001a\u00020\u0002¢\u0006\u0004\b&\u0010'R\u001b\u0010\u0007\u001a\u00020\u00028BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R$\u0010\u000f\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR.\u0010\u0018\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001d\u0010\u001d\u001a\u0004\u0018\u00010\u00198BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u0004\u001a\u0004\b\u001b\u0010\u001cR\u001d\u0010 \u001a\u0004\u0018\u00010\u00198BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001e\u0010\u0004\u001a\u0004\b\u001f\u0010\u001c¨\u0006*"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/widgets/ECCoordinatorRecyclerView;", "Lcom/bytedance/android/shopping/anchorv3/widget/BasePdpRecyclerView;", "", "c", "Lkotlin/Lazy;", "getWindowHeight", "()I", "windowHeight", "Landroid/view/View;", "f", "Landroid/view/View;", "getSecondaryViewContainer", "()Landroid/view/View;", "setSecondaryViewContainer", "(Landroid/view/View;)V", "secondaryViewContainer", "Landroidx/recyclerview/widget/RecyclerView;", "value", ce.f26391f, "Landroidx/recyclerview/widget/RecyclerView;", "getSecondaryScrollView", "()Landroidx/recyclerview/widget/RecyclerView;", "setSecondaryScrollView", "(Landroidx/recyclerview/widget/RecyclerView;)V", "secondaryScrollView", "Ljava/lang/reflect/Method;", "r", "getMethodSetScrollState", "()Ljava/lang/reflect/Method;", "methodSetScrollState", "s", "getMethodDispatchOnScrollStateChanged", "methodDispatchOnScrollStateChanged", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "b", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECCoordinatorRecyclerView extends BasePdpRecyclerView {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f170145c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f170146d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f170147e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public View f170148f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public RecyclerView f170149g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final List<b> f170150h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f170151i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Scroller f170152j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final VelocityTracker f170153k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f170154l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public float f170155m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f170156n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f170157o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public float f170158p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public float f170159q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final Lazy f170160r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final Lazy f170161s;

    public static final class a {
    }

    public interface b {
        void b();
    }

    static {
    }

    public ECCoordinatorRecyclerView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public ECCoordinatorRecyclerView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    private final Method getMethodDispatchOnScrollStateChanged() {
        return (Method) this.f170161s.getValue();
    }

    private final Method getMethodSetScrollState() {
        return (Method) this.f170160r.getValue();
    }

    private final int getWindowHeight() {
        return ((Number) this.f170145c.getValue()).intValue();
    }

    @Override // android.view.View
    public final void computeScroll() {
        if (this.f170147e == true) goto L6;
        super.computeScroll();
    L6:
        if (this.f170152j.computeScrollOffset() == false) goto L14;
        int r100 = this.f170152j.getCurrY() - this.f170156n;
        this.f170157o = true;
        v(r100);     // Catch: Exception -> L10
    L12:
        this.f170156n = this.f170152j.getCurrY();
        invalidate();
        return;
    L10:
        e = move-exception;
        ECExceptionMonitor.e(e);
        goto L12
    L14:
        if (this.f170157o == false) goto L20;
        y(this, 0);
        y(this.f170149g, 0);
        this.f170157o = false;
        return;
    }

    public final RecyclerView getSecondaryScrollView() {
        return this.f170149g;
    }

    public final View getSecondaryViewContainer() {
        return this.f170148f;
    }

    @Override // com.bytedance.android.shopping.anchorv3.widget.BasePdpRecyclerView
    public final boolean r() {
        return this.f170146d;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r100) {
        if (r100 == null) goto L4;
        boolean r101 = this.f170147e;
        if (r100.getAction() != 0) goto L9;
        this.f170147e = false;
    L25:
        if (r101 == false) goto L30;
        if (this.f170147e == true) goto L30;
        onInterceptTouchEvent(r100);
    L30:
        if (r100.getAction() != 0) goto L32;
    L33:
        this.f170158p = r100.getX();
        this.f170159q = r100.getY();
        this.f170155m = r100.getY();
        this.f170154l = 0;
        if (this.f170157o == false) goto L38;
        this.f170152j.forceFinished(true);
        this.f170157o = false;
        return true;
    L38:
        return super.dispatchTouchEvent(r100);
    L32:
        if (r100.getAction() != 5) goto L38;
    L9:
        if (r100.getAction() != 2) goto L25;
        Rect r102 = new Rect();
        getGlobalVisibleRect(r102);
        if ((r102.bottom - r102.top) == getHeight()) goto L13;
    L15:
        boolean r103 = false;
    L16:
        if (r103 == true) goto L18;
    L23:
        boolean r104 = true;
    L24:
        this.f170147e = !r104;
        goto L25
    L18:
        if (r100.getY() > this.f170155m) goto L20;
    L22:
        r104 = false;
        goto L24
    L20:
        if (canScrollVertically(-1) == true) goto L22;
    L13:
        if (isShown() == false) goto L15;
        r103 = true;
        goto L16
    L4:
        return super.dispatchTouchEvent(r100);
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    public final boolean onTouchEvent(MotionEvent r110) {
        if (r110 == null) goto L4;
        int r100 = r110.getAction();
        if (r100 == 0) goto L9;
        if (r100 == 2) goto L9;
        boolean r101 = false;
    L10:
        this.f170146d = r101;
        if (this.f170147e == true) goto L15;
        return super.onTouchEvent(r110);
    L15:
        if (this.f170154l != 1) goto L17;
        return true;
    L17:
        int r102 = r110.getAction();
        if (r102 != 0) goto L20;
    L69:
        this.f170153k.clear();
        this.f170153k.addMovement(r110);
        this.f170157o = false;
        return true;
    L20:
        if (r102 == 1) goto L36;
        if (r102 != 2) goto L23;
        float r103 = this.f170155m;
        if (r103 != 0.0f) goto L71;
    L34:
        this.f170155m = r110.getY();
        this.f170153k.addMovement(r110);
        this.f170157o = true;
        return true;
    L71:
        v((int) (r103 - r110.getY()));     // Catch: Exception -> L32
    L32:
        e = move-exception;
        ECExceptionMonitor.e(e);
        goto L34
    L23:
        if (r102 == 5) goto L69;
        if (r102 == 6) goto L36;
        return super.onTouchEvent(r110);
    L36:
        if (this.f170157o == false) goto L75;
        this.f170153k.addMovement(r110);
        this.f170153k.computeCurrentVelocity(1000);
        int r104 = -((int) this.f170153k.getYVelocity());
        if (r104 <= 0) goto L53;
        if (w(this) == false) goto L45;
        if (canScrollVertically(r104) == false) goto L45;
    L63:
        boolean r111 = true;
    L65:
        if (r111 == true) goto L67;
        y(this, 0);
        y(this.f170149g, 0);
    L68:
        this.f170155m = 0.0f;
        return true;
    L67:
        y(this, 2);
        this.f170156n = 0;
        this.f170152j.fling(0, 0, 0, r104, 0, 0, Integer.MIN_VALUE, Integer.MAX_VALUE);
        post(new com.bytedance.android.shopping.anchorv4.widgets.a(this));
        invalidate();
    L45:
        if (w(this.f170148f) == false) goto L51;
        RecyclerView r112 = this.f170149g;
        if (r112 == null) goto L51;
        if (r112.canScrollVertically(r104) == true) goto L63;
    L51:
        r111 = canScrollVertically(r104);
        goto L65
    L53:
        if (w(this.f170148f) == false) goto L60;
        RecyclerView r113 = this.f170149g;
        if (r113 == null) goto L60;
        if (r113.canScrollVertically(r104) == true) goto L63;
    L60:
        if (w(this) == true) goto L62;
    L64:
        r111 = canScrollVertically(r104);
        goto L65
    L62:
        if (canScrollVertically(r104) == false) goto L64;
    L75:
        return true;
    L9:
        r101 = true;
        goto L10
    L4:
        return super.onTouchEvent(r110);
    }

    public final void setSecondaryScrollView(RecyclerView r100) {
        if (r100 == null) goto L4;
        r100.setNestedScrollingEnabled(false);
    L4:
        this.f170149g = r100;
    }

    public final void setSecondaryViewContainer(View r100) {
        this.f170148f = r100;
    }

    @Override // com.bytedance.android.shopping.anchorv3.widget.BasePdpRecyclerView
    public final boolean t(MotionEvent r100) {
        if (r100 == null) goto L39;
        if (this.f170147e == false) goto L39;
        int r101 = r100.getAction();
        if (r101 != 0) goto L9;
    L36:
        this.f170158p = r100.getX();
        this.f170159q = r100.getY();
        this.f170155m = r100.getY();
        this.f170154l = 0;
        return false;
    L9:
        if (r101 != 2) goto L11;
        this.f170155m = r100.getY();
        int r102 = this.f170154l;
        if (r102 != 2) goto L16;
        return true;
    L16:
        if (r102 != 1) goto L18;
        return false;
    L18:
        if (r102 != 0) goto L33;
        if (Math.abs(this.f170159q - r100.getY()) <= this.f170151i) goto L33;
        View r103 = ViewExtensionsKt.a(this, r100.getRawX(), r100.getRawY());
        if ((Math.abs(this.f170159q - r100.getY()) * 1.2f) <= Math.abs(this.f170158p - r100.getX())) goto L24;
        boolean r104 = true;
    L25:
        if (r104 == false) goto L27;
    L30:
        int r105 = 2;
    L31:
        this.f170154l = r105;
        goto L33
    L27:
        if ((!Intrinsics.areEqual(r103, this)) == true) goto L30;
        r105 = 1;
        goto L31
    L24:
        r104 = false;
    L33:
        if (this.f170154l != 2) goto L40;
        return true;
    L40:
        return false;
    L11:
        if (r101 == 5) goto L36;
        return super.t(r100);
    L39:
        return super.t(r100);
    }

    public final void v(int r110) {
        if (r110 != 0) goto L4;
        return;
    L4:
        x("dispatchScrollY, dy = " + r110 + ", flagFling = " + this.f170157o);
        Iterator r100 = ((ArrayList) this.f170150h).iterator();
    L6:
        if (r100.hasNext() == false) goto L9;
        ((b) r100.next()).b();
        goto L6
    L9:
        if (this.f170157o == false) goto L11;
        int r101 = 2;
    L13:
        if (r110 <= 0) goto L44;
        if (w(this) == false) goto L20;
        if (canScrollVertically(r110) == false) goto L20;
        scrollBy(0, r110);
        y(this, r101);
        x("dispatchScrollY, dispatch to primaryScrollView, dy = " + r110);
        return;
    L20:
        if (w(this.f170148f) == false) goto L33;
        RecyclerView r102 = this.f170149g;
        if (r102 == null) goto L33;
        if (r102.canScrollVertically(r110) != true) goto L33;
        RecyclerView r103 = this.f170149g;
        if (r103 != null) goto L28;
    L31:
        x("dispatchScrollY, dispatch to secondaryScrollView, dy = " + r110);
        return;
    L28:
        if (r103.getHeight() >= 10) goto L30;
        return;
    L30:
        r103.scrollBy(0, r110);
        y(r103, r101);
    L33:
        if (canScrollVertically(r110) == false) goto L42;
        int r104 = getScrollY();
        scrollBy(0, r110);
        int r105 = r110 - r104;
        if (r105 <= 0) goto L41;
        RecyclerView r106 = this.f170149g;
        if (r106 == null) goto L41;
        if (r106.canScrollVertically(r105) != true) goto L41;
        scrollBy(0, r105);
    L41:
        y(this, r101);
        y(this.f170149g, r101);
        x("dispatchScrollY, dispatch to self, dy = " + r110 + ", remain = " + r105 + ", scrollY = " + getScrollY());
        return;
    L42:
        scrollBy(0, r110);
        y(this, r101);
        x("dispatchScrollY, no target, scrollY = " + getScrollY() + ", maxScrollY = 0, dy = " + r110);
        return;
    L44:
        if (w(this.f170148f) == false) goto L54;
        RecyclerView r111 = this.f170149g;
        if (r111 == null) goto L54;
        if (r111.canScrollVertically(r110) != true) goto L54;
        RecyclerView r107 = this.f170149g;
        if (r107 == null) goto L52;
        r107.scrollBy(0, r110);
        y(r107, r101);
    L52:
        x("dispatchScrollY, dispatch to secondaryScrollView, dy = " + r110 + ", state = " + r101);
        return;
    L54:
        if (w(this) == false) goto L59;
        if (canScrollVertically(r110) == false) goto L59;
        scrollBy(0, r110);
        y(this, r101);
        x("dispatchScrollY, dispatch to primaryScrollView, dy = " + r110 + ", state = " + r101);
        return;
    L59:
        if (canScrollVertically(r110) == false) goto L70;
        int r108 = 0 - getScrollY();
        scrollBy(0, r110);
        int r109 = r108 + r110;
        if (r109 >= 0) goto L69;
        RecyclerView r112 = this.f170149g;
        if (r112 == null) goto L69;
        if (r112.canScrollVertically(r109) != true) goto L69;
        RecyclerView r113 = this.f170149g;
        if (r113 == null) goto L69;
        r113.scrollBy(0, r109);
    L69:
        y(this, r101);
        y(this.f170149g, r101);
        x("dispatchScrollY, dispatch to self, dy = " + r110 + ", remain = " + r109 + ", scrollY = " + getScrollY());
        return;
    L70:
        x("dispatchScrollY, no target, scrollY = " + getScrollY() + ", maxScrollY = 0, dy = " + r110);
        return;
    L11:
        r101 = 1;
        goto L13
    }

    public final boolean w(View r100) {
        if (r100 != null) goto L5;
        return false;
    L5:
        int r101 = r100.getTop();
        ViewGroup.LayoutParams r102 = r100.getLayoutParams();
        if ((r102 instanceof ViewGroup.MarginLayoutParams) == true) goto L8;
        r102 = null;
    L8:
        ViewGroup.MarginLayoutParams r103 = (ViewGroup.MarginLayoutParams) r102;
        if (r103 == null) goto L11;
        int r104 = r103.topMargin;
    L13:
        if (((r101 - r104) - getPaddingTop()) != getScrollY()) goto L16;
        return true;
    L16:
        return false;
    L11:
        r104 = 0;
        goto L13
    }

    public final void x(String r100) {
        Logger.d("ScrollViewCoordinator", r100);
    }

    public static final boolean u(ECCoordinatorRecyclerView r100, RecyclerView r101) {
        r100.getClass();
        if (r101 == null) goto L8;
        int[] r102 = new int[2];
        r101.getLocationInWindow(r102);
        if (r102[1] >= r100.getWindowHeight()) goto L8;
        return true;
    L8:
        return false;
    }

    public final void y(RecyclerView r100, int r101) {
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L11
        if (r100 != null) goto L6;
        return;
    L6:
        Method r103 = getMethodSetScrollState();     // Catch: Throwable -> L11
        if (r103 == null) goto L9;
        r103.invoke(r100, new Object[]{Integer.valueOf(r101)});     // Catch: Throwable -> L11
    L9:
        x("setScrollState, target = " + r100 + ", state = " + r101);     // Catch: Throwable -> L11
        Object r104 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L11
    L13:
        Throwable r105 = Result.m9452exceptionOrNullimpl(r104);
        if (r105 == null) goto L19;
        EnsureManager.ensureNotReachHere("reflect invoke setScrollState failed");
        if (ECAppInfoService.f48114e.isLocalTest() == false) goto L22;
        throw r105;
    L22:
        return;
    L19:
        return;
    L11:
        th = move-exception;
        Result.Companion r106 = Result.Companion;
        r104 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L13
    }

    public ECCoordinatorRecyclerView(final Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f170145c = LazyKt.lazy(new ECCoordinatorRecyclerView$windowHeight$2(r100));
        setEdgeEffectFactory(new AnonymousClass1(r100));
        addOnScrollListener(new AnonymousClass2(this));
        this.f170150h = new ArrayList();
        this.f170151i = ViewConfiguration.get(r100).getScaledTouchSlop();
        this.f170152j = new Scroller(r100);
        this.f170153k = VelocityTracker.obtain();
        this.f170160r = LazyKt.lazy(ECCoordinatorRecyclerView$methodSetScrollState$2.INSTANCE);
        this.f170161s = LazyKt.lazy(ECCoordinatorRecyclerView$methodDispatchOnScrollStateChanged$2.INSTANCE);
    }

    public /* synthetic */ ECCoordinatorRecyclerView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
