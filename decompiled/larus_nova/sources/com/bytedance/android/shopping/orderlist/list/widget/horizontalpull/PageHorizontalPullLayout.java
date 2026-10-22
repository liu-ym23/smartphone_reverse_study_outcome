package com.bytedance.android.shopping.orderlist.list.widget.horizontalpull;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import com.bytedance.android.shopping.orderlist.common.monitor.business.OrderCommonBusinessMonitor;
import com.bytedance.android.shopping.orderlist.common.monitor.error.OrderCommonErrorMonitorKt;
import com.bytedance.android.shopping.orderlist.common.utils.OrderCommonLog;
import com.bytedance.android.shopping.orderlist.common.widgets.touch.CheckViewHelper;
import com.bytedance.android.shopping.orderlist.common.widgets.touch.TouchHelper;
import com.bytedance.android.shopping.orderlist.list.container.OrderListFragment;
import com.bytedance.android.shopping.orderlist.list.viewmodel.OrderListViewModel;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/shopping/orderlist/list/widget/horizontalpull/PageHorizontalPullLayout;", "Lcom/bytedance/android/shopping/orderlist/list/widget/horizontalpull/BaseHorizontalPullLayout;", "Lcom/bytedance/android/shopping/orderlist/list/widget/horizontalpull/c;", "listener", "", "setEasyPullListener", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PageHorizontalPullLayout extends BaseHorizontalPullLayout {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final /* synthetic */ int f180486s = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public OrderListFragment f180487e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public com.bytedance.android.shopping.orderlist.list.container.c f180488f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public OrderListViewModel f180489g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f180490h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public float f180491i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public float f180492j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final int f180493k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f180494l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public Integer f180495m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public ValueAnimator f180496n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public c f180497o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final VelocityTracker f180498p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final int f180499q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final TouchHelper f180500r;

    public PageHorizontalPullLayout(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public PageHorizontalPullLayout(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public final void d() {
        ValueAnimator r100 = this.f180496n;
        if (r100 != null) goto L5;
    L9:
        e();
        return;
    L5:
        if (r100.isRunning() != true) goto L9;
        ValueAnimator r101 = this.f180496n;
        if (r101 == null) goto L11;
        com.bytedance.android.ec.core.utils.f.a(r101, new PageHorizontalPullLayout$resetUI$1(this));
        return;
    }

    public final void e() {
        Iterator<Map.Entry<View, BaseHorizontalPullLayout.a>> r100 = getChildViews().entrySet().iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        Map.Entry<View, BaseHorizontalPullLayout.a> r101 = r100.next();
        r101.getKey().setX(r101.getValue().f180477a);
        goto L4
    L6:
        this.f180490h = 0.0f;
        this.f180491i = 0.0f;
    }

    public final boolean c(Integer r110) {
        OrderListViewModel r100 = this.f180489g;
        final com.bytedance.android.shopping.orderlist.list.slice.elements.tab.g r101 = null;
        if (r100 == null) goto L5;
        com.bytedance.android.shopping.orderlist.list.viewmodel.a r102 = r100.getStaticState();
    L6:
        if (r102 == null) goto L8;
        final Integer r103 = r102.f180397l;
    L9:
        if (r102 == null) goto L11;
        final List<Integer> r104 = r102.f180399n;
    L12:
        if (r104 != null) goto L15;
        r104 = CollectionsKt.emptyList();
    L15:
        if (r103 != null) goto L17;
    L38:
        if (r102 == null) goto L40;
        r101 = r102.f180393h;
    L40:
        if (r110 != null) goto L43;
    L49:
        if (r110 != null) goto L52;
    L58:
        return false;
    L52:
        if (r110.intValue() != 2) goto L58;
        if (r101 != null) goto L55;
    L56:
        Lazy r111 = OrderCommonLog.f179948a;
        OrderCommonLog.a("PageHorizontalPullLayout", new PageHorizontalPullLayout$isNeedInterceptMove$5(r101));
        return true;
    L55:
        if (r101.f180330h == false) goto L58;
    L43:
        if (r110.intValue() != 0) goto L49;
        if (r101 != null) goto L46;
    L47:
        Lazy r112 = OrderCommonLog.f179948a;
        OrderCommonLog.a("PageHorizontalPullLayout", new PageHorizontalPullLayout$isNeedInterceptMove$4(r101));
        return true;
    L46:
        if (r101.f180329g == false) goto L49;
    L17:
        if ((!r104.isEmpty()) == false) goto L38;
        int r105 = r104.indexOf(r103);
        if (r105 >= 0) goto L22;
        Lazy r113 = OrderCommonLog.f179948a;
        OrderCommonLog.a("PageHorizontalPullLayout", new PageHorizontalPullLayout$isNeedInterceptMove$1(r103, r104));
        return true;
    L22:
        if (r110 != null) goto L25;
    L29:
        if (r110 != null) goto L32;
    L37:
        return false;
    L32:
        if (r110.intValue() != 2) goto L37;
        if (r105 != CollectionsKt.getLastIndex(r104)) goto L37;
        Lazy r114 = OrderCommonLog.f179948a;
        OrderCommonLog.a("PageHorizontalPullLayout", new PageHorizontalPullLayout$isNeedInterceptMove$3(r103, r104));
        return true;
    L25:
        if (r110.intValue() != 0) goto L29;
        if (r105 != 0) goto L29;
        Lazy r115 = OrderCommonLog.f179948a;
        OrderCommonLog.a("PageHorizontalPullLayout", new PageHorizontalPullLayout$isNeedInterceptMove$2(r103, r104));
        return true;
    L11:
        r104 = null;
        goto L12
    L8:
        r103 = null;
        goto L9
    L5:
        r102 = null;
        goto L6
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(final MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "ev");
        CheckViewHelper.b(this, r100);
        if (this.f180494l == false) goto L6;
        return true;
    L6:
        this.f180500r.a(r100, null);
        Lazy r101 = OrderCommonLog.f179948a;
        OrderCommonLog.a("PageHorizontalPullLayout", new AnonymousClass1(r100));
        return super.dispatchTouchEvent(r100);
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "ev");
        int r101 = r100.getAction();
        if (r101 != 0) goto L5;
        this.f180492j = r100.getX();
    L33:
        Lazy r102 = OrderCommonLog.f179948a;
        OrderCommonLog.a("PageHorizontalPullLayout", AnonymousClass4.INSTANCE);
        return false;
    L5:
        if (r101 != 2) goto L33;
        if (this.f180500r.f180076c != TouchHelper.TouchIntent.H_MOVING_RIGHT) goto L10;
        boolean r103 = true;
    L12:
        if (r103 == false) goto L20;
        int r104 = CheckViewHelper.f180073a;
        if (CheckViewHelper.a(new Point((int) r100.getRawX(), (int) r100.getRawY()), this, -1) != null) goto L20;
        final boolean r105 = a();
        if (r105 == false) goto L18;
        this.f180495m = 0;
    L18:
        Lazy r106 = OrderCommonLog.f179948a;
        OrderCommonLog.a("PageHorizontalPullLayout", new C103771(r105));
        return r105;
    L20:
        if (this.f180500r.f180076c != TouchHelper.TouchIntent.H_MOVING_LEFT) goto L22;
        boolean r107 = true;
    L23:
        if (r107 == false) goto L30;
        int r108 = CheckViewHelper.f180073a;
        if (CheckViewHelper.a(new Point((int) r100.getRawX(), (int) r100.getRawY()), this, 1) != null) goto L30;
        final boolean r109 = b();
        if (r109 == false) goto L29;
        this.f180495m = 2;
    L29:
        Lazy r110 = OrderCommonLog.f179948a;
        OrderCommonLog.a("PageHorizontalPullLayout", new AnonymousClass2(r109));
        return r109;
    L30:
        this.f180495m = -1;
        Lazy r111 = OrderCommonLog.f179948a;
        OrderCommonLog.a("PageHorizontalPullLayout", AnonymousClass3.INSTANCE);
        return false;
    L22:
        r107 = false;
        goto L23
    L10:
        r103 = false;
        goto L12
    }

    @Override // android.view.View
    public final boolean onTouchEvent(final MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "ev");
        getParent().requestDisallowInterceptTouchEvent(true);
        int r101 = r100.getAction();
        if (r101 == 0) goto L118;
        float r102 = 0.0f;
        if (r101 == 1) goto L75;
        if (r101 != 2) goto L8;
        this.f180498p.addMovement(r100);
        this.f180491i = r100.getX() - this.f180492j;
        if (c(this.f180495m) == true) goto L74;
        Lazy r103 = OrderCommonLog.f179948a;
        OrderCommonLog.a("PageHorizontalPullLayout", PageHorizontalPullLayout$moveByHand$1.INSTANCE);
        Integer r104 = this.f180495m;
        if (r104 != null) goto L17;
    L33:
        if (r104 != null) goto L36;
    L54:
        c r105 = this.f180497o;
        if (r105 == null) goto L57;
        r105.d(this.f180495m, r102);
    L57:
        this.f180490h = r102;
        Integer r106 = this.f180495m;
        if (r106 != null) goto L61;
    L66:
        if (r106 == null) goto L74;
        if (r106.intValue() != 2) goto L74;
        Iterator<Map.Entry<View, BaseHorizontalPullLayout.a>> r107 = getChildViews().entrySet().iterator();
    L72:
        if (r107.hasNext() == false) goto L74;
        Map.Entry<View, BaseHorizontalPullLayout.a> r108 = r107.next();
        r108.getKey().setX(r108.getValue().f180477a + this.f180491i);
        goto L72
    L61:
        if (r106.intValue() != 0) goto L66;
        Iterator<Map.Entry<View, BaseHorizontalPullLayout.a>> r109 = getChildViews().entrySet().iterator();
    L64:
        if (r109.hasNext() == false) goto L74;
        Map.Entry<View, BaseHorizontalPullLayout.a> r110 = r109.next();
        r110.getKey().setX(r110.getValue().f180477a + this.f180491i);
        goto L64
    L36:
        if (r104.intValue() != 2) goto L54;
        float r111 = this.f180491i;
        if (r111 <= 0) goto L41;
        float r112 = 0.0f;
    L44:
        this.f180491i = r112;
        if (r112 == 0.0f) goto L54;
        if ((-getMaxOffsetRight()) < this.f180491i) goto L50;
    L53:
        r102 = 1.0f;
        goto L54
    L50:
        if (getMaxOffsetRight() == 0) goto L53;
        float r113 = this.f180491i;
        int r114 = -getMaxOffsetRight();
    L52:
        r102 = r113 / r114;
        goto L54
    L41:
        if (r111 >= (-getMaxOffsetRight())) goto L43;
        r112 = -getMaxOffsetRight();
        goto L44
    L43:
        r112 = this.f180491i;
        goto L44
    L17:
        if (r104.intValue() != 0) goto L33;
        float r115 = this.f180491i;
        if (r115 >= 0) goto L22;
        float r116 = 0.0f;
    L25:
        this.f180491i = r116;
        if (r116 == 0.0f) goto L54;
        if (getMaxOffsetLeft() <= this.f180491i) goto L53;
        if (getMaxOffsetLeft() == 0) goto L53;
        r113 = this.f180491i;
        r114 = getMaxOffsetLeft();
        goto L52
    L22:
        if (r115 <= getMaxOffsetLeft()) goto L24;
        r116 = getMaxOffsetLeft();
        goto L25
    L24:
        r116 = this.f180491i;
    L74:
        Lazy r117 = OrderCommonLog.f179948a;
        OrderCommonLog.a("PageHorizontalPullLayout", new C103781(r100));
    L119:
        return true;
    L8:
        if (r101 != 3) goto L119;
    L75:
        this.f180498p.addMovement(r100);
        this.f180498p.computeCurrentVelocity(1000);
        Integer r118 = this.f180495m;
        if (r118 != null) goto L79;
    L81:
        if (r118 == null) goto L119;
        if (r118.intValue() != 2) goto L119;
    L85:
        Lazy r119 = OrderCommonLog.f179948a;
        OrderCommonLog.a("PageHorizontalPullLayout", new C103792(r100));
        int r120 = (int) this.f180498p.getXVelocity();
        if (c(this.f180495m) == true) goto L119;
        com.bytedance.android.shopping.orderlist.list.container.c r121 = this.f180488f;
        if (r121 == null) goto L100;
        if (r121.isRequesting() != true) goto L100;
        OrderListFragment r122 = this.f180487e;
        if (r122 == null) goto L100;
        ig3.a r123 = r122.K;
        if (r123 == null) goto L100;
        OrderCommonBusinessMonitor r124 = r123.f489721c;
        if (r124 == null) goto L100;
        r124.b("slideTab");
    L100:
        if (Math.abs(this.f180491i) <= this.f180493k) goto L102;
    L103:
        com.bytedance.android.shopping.orderlist.list.container.c r125 = this.f180488f;
        if (r125 != null) goto L106;
    L117:
        float r126 = this.f180491i;
        ValueAnimator r127 = ValueAnimator.ofFloat(new float[]{1.0f, 0.0f});
        r127.setDuration(getRollBackDuration());
        r127.addUpdateListener(new f(r127, this.f180490h, this, r126));
        r127.addListener(new g(this));
        Unit r128 = Unit.INSTANCE;
        this.f180496n = r127;
        r127.start();
        goto L119
    L106:
        if (r125.isRequesting() == true) goto L117;
        View r129 = a.a(getChildViews(), 4);
        if (r129 != null) goto L110;
        OrderCommonErrorMonitorKt.b(null, "SERIOUS_BUSINESS_ERROR", "PageHorizontalPullLayout-rollFrontHorizontalRefresh: contentView is null");
        goto L119
    L110:
        float r130 = this.f180491i;
        if (r130 == 0.0f) goto L113;
        Float r131 = Float.valueOf(((r129.getWidth() - Math.abs(r130)) * r130) / Math.abs(r130));
    L114:
        if (r131 != null) goto L116;
        OrderCommonErrorMonitorKt.b(null, "SERIOUS_BUSINESS_ERROR", "PageHorizontalPullLayout-rollFrontHorizontalRefresh: remainOffset is null");
        goto L119
    L116:
        ValueAnimator r132 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        r132.setDuration(getRollBackDuration());
        r132.addUpdateListener(new h(r132, this, r130, r131));
        r132.addListener(new i(this));
        Unit r133 = Unit.INSTANCE;
        this.f180496n = r132;
        r132.start();
        goto L119
    L113:
        r131 = null;
        goto L114
    L102:
        if (Math.abs(r120) <= this.f180499q) goto L117;
    L79:
        if (r118.intValue() != 0) goto L81;
    L118:
        this.f180498p.clear();
        this.f180498p.addMovement(r100);
        goto L119
    }

    public final void setEasyPullListener(c r100) {
        this.f180497o = r100;
    }

    public PageHorizontalPullLayout(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f180493k = com.bytedance.android.shopping.extensions.b.b(90);
        this.f180495m = -1;
        this.f180498p = VelocityTracker.obtain();
        Resources r103 = r100.getResources();
        this.f180499q = (int) (WindowDisplayMetricsOverride.apply(r103, r103.getDisplayMetrics()).density * 400.0f);
        this.f180500r = new TouchHelper(r100);
    }

    public /* synthetic */ PageHorizontalPullLayout(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
