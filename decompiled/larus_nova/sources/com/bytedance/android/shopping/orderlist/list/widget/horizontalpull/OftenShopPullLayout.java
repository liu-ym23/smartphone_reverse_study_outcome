package com.bytedance.android.shopping.orderlist.list.widget.horizontalpull;

import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.bytedance.android.shopping.orderlist.common.utils.OrderCommonLog;
import com.bytedance.android.shopping.orderlist.common.widgets.touch.TouchHelper;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Iterator;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/shopping/orderlist/list/widget/horizontalpull/OftenShopPullLayout;", "Lcom/bytedance/android/shopping/orderlist/list/widget/horizontalpull/BaseHorizontalPullLayout;", "Lcom/bytedance/android/shopping/orderlist/list/widget/horizontalpull/b;", "listener", "", "setEasyPullListener", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class OftenShopPullLayout extends BaseHorizontalPullLayout {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f180479e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f180480f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f180481g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f180482h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Integer f180483i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public b f180484j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final TouchHelper f180485k;

    public OftenShopPullLayout(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public OftenShopPullLayout(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    @Override // android.view.View
    public final boolean canScrollHorizontally(int r100) {
        return true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(final MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "ev");
        boolean r101 = true;
        if (this.f180482h == false) goto L5;
        return true;
    L5:
        this.f180485k.a(r100, null);
        TouchHelper.TouchIntent r102 = this.f180485k.f180076c;
        if (r102 != TouchHelper.TouchIntent.DOWN_STATE) goto L8;
        boolean r103 = true;
    L10:
        if (r103 == false) goto L13;
        getParent().requestDisallowInterceptTouchEvent(true);
    L37:
        Lazy r104 = OrderCommonLog.f179948a;
        OrderCommonLog.a("OftenShopPullLayout", new AnonymousClass3(r100));
        return super.dispatchTouchEvent(r100);
    L13:
        if (r102 != TouchHelper.TouchIntent.V_MOVING_DOWN) goto L15;
        boolean r105 = true;
    L16:
        if (r105 == false) goto L18;
    L36:
        Lazy r106 = OrderCommonLog.f179948a;
        OrderCommonLog.a("OftenShopPullLayout", AnonymousClass1.INSTANCE);
        getParent().requestDisallowInterceptTouchEvent(false);
        goto L37
    L18:
        if (r102 != TouchHelper.TouchIntent.V_MOVING_UP) goto L20;
        boolean r107 = true;
    L21:
        if (r107 == true) goto L36;
        if (r102 != TouchHelper.TouchIntent.H_MOVING_LEFT) goto L26;
        boolean r108 = true;
    L27:
        if (r108 == true) goto L34;
        if (r102 == TouchHelper.TouchIntent.H_MOVING_RIGHT) goto L32;
        r101 = false;
    L32:
        if (r101 == false) goto L37;
    L34:
        if (a() == false) goto L37;
        Lazy r109 = OrderCommonLog.f179948a;
        OrderCommonLog.a("OftenShopPullLayout", AnonymousClass2.INSTANCE);
        getParent().requestDisallowInterceptTouchEvent(false);
        goto L37
    L26:
        r108 = false;
        goto L27
    L20:
        r107 = false;
        goto L21
    L15:
        r105 = false;
        goto L16
    L8:
        r103 = false;
        goto L10
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(final MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "ev");
        Lazy r101 = OrderCommonLog.f179948a;
        OrderCommonLog.a("OftenShopPullLayout", new C103721(r100));
        int r102 = r100.getAction();
        if (r102 != 0) goto L5;
        this.f180481g = r100.getX();
    L28:
        OrderCommonLog.a("OftenShopPullLayout", AnonymousClass5.INSTANCE);
        return false;
    L5:
        if (r102 != 2) goto L28;
        TouchHelper.TouchIntent r103 = this.f180485k.f180076c;
        boolean r104 = true;
        if (r103 != TouchHelper.TouchIntent.H_MOVING_RIGHT) goto L10;
        boolean r105 = true;
    L11:
        if (r105 == false) goto L17;
        final boolean r106 = a();
        if (r106 == false) goto L15;
        this.f180483i = 0;
    L15:
        OrderCommonLog.a("OftenShopPullLayout", new C103732(r106));
        return r106;
    L17:
        if (r103 == TouchHelper.TouchIntent.H_MOVING_LEFT) goto L20;
        r104 = false;
    L20:
        if (r104 == false) goto L25;
        final boolean r107 = b();
        if (r107 == false) goto L24;
        this.f180483i = 2;
    L24:
        OrderCommonLog.a("OftenShopPullLayout", new C103743(r107));
        return r107;
    L25:
        this.f180483i = -1;
        OrderCommonLog.a("OftenShopPullLayout", AnonymousClass4.INSTANCE);
        return false;
    L10:
        r105 = false;
        goto L11
    }

    @Override // android.view.View
    public final boolean onTouchEvent(final MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "ev");
        getParent().requestDisallowInterceptTouchEvent(true);
        int r101 = r100.getAction();
        if (r101 == 1) goto L70;
        if (r101 != 2) goto L6;
        this.f180480f = r100.getX() - this.f180481g;
        Lazy r102 = OrderCommonLog.f179948a;
        OrderCommonLog.a("OftenShopPullLayout", OftenShopPullLayout$moveByHand$1.INSTANCE);
        Integer r103 = this.f180483i;
        float r104 = 0.0f;
        if (r103 != null) goto L12;
    L28:
        if (r103 != null) goto L31;
    L49:
        b r105 = this.f180484j;
        if (r105 == null) goto L52;
        r105.d(r104);
    L52:
        this.f180479e = r104;
        Integer r106 = this.f180483i;
        if (r106 != null) goto L56;
    L61:
        if (r106 != null) goto L64;
    L69:
        Lazy r107 = OrderCommonLog.f179948a;
        OrderCommonLog.a("OftenShopPullLayout", new C103751(r100));
    L81:
        return true;
    L64:
        if (r106.intValue() != 2) goto L69;
        Iterator<Map.Entry<View, BaseHorizontalPullLayout.a>> r108 = getChildViews().entrySet().iterator();
    L67:
        if (r108.hasNext() == false) goto L69;
        Map.Entry<View, BaseHorizontalPullLayout.a> r109 = r108.next();
        r109.getKey().setX(r109.getValue().f180477a + this.f180480f);
        goto L67
    L56:
        if (r106.intValue() != 0) goto L61;
        Iterator<Map.Entry<View, BaseHorizontalPullLayout.a>> r110 = getChildViews().entrySet().iterator();
    L59:
        if (r110.hasNext() == false) goto L69;
        Map.Entry<View, BaseHorizontalPullLayout.a> r111 = r110.next();
        r111.getKey().setX(r111.getValue().f180477a + this.f180480f);
        goto L59
    L31:
        if (r103.intValue() != 2) goto L49;
        float r112 = this.f180480f;
        if (r112 <= 0) goto L36;
        float r113 = 0.0f;
    L39:
        this.f180480f = r113;
        if (r113 == 0.0f) goto L49;
        if ((-getMaxOffsetRight()) < this.f180480f) goto L45;
    L48:
        r104 = 1.0f;
        goto L49
    L45:
        if (getMaxOffsetRight() == 0) goto L48;
        float r114 = this.f180480f;
        int r115 = -getMaxOffsetRight();
    L47:
        r104 = r114 / r115;
        goto L49
    L36:
        if (r112 >= (-getMaxOffsetRight())) goto L38;
        r113 = -getMaxOffsetRight();
        goto L39
    L38:
        r113 = this.f180480f;
        goto L39
    L12:
        if (r103.intValue() != 0) goto L28;
        float r116 = this.f180480f;
        if (r116 >= 0) goto L17;
        float r117 = 0.0f;
    L20:
        this.f180480f = r117;
        if (r117 == 0.0f) goto L49;
        if (getMaxOffsetLeft() <= this.f180480f) goto L48;
        if (getMaxOffsetLeft() == 0) goto L48;
        r114 = this.f180480f;
        r115 = getMaxOffsetLeft();
        goto L47
    L17:
        if (r116 <= getMaxOffsetLeft()) goto L19;
        r117 = getMaxOffsetLeft();
        goto L20
    L19:
        r117 = this.f180480f;
        goto L20
    L6:
        if (r101 != 3) goto L81;
    L70:
        Integer r118 = this.f180483i;
        if (r118 != null) goto L74;
    L76:
        if (r118 == null) goto L81;
        if (r118.intValue() != 2) goto L81;
    L80:
        Lazy r119 = OrderCommonLog.f179948a;
        OrderCommonLog.a("OftenShopPullLayout", new C103762(r100));
        float r120 = this.f180480f;
        ValueAnimator r121 = ValueAnimator.ofFloat(new float[]{1.0f, 0.0f});
        r121.setDuration(getRollBackDuration());
        r121.addUpdateListener(new d(r121, this.f180479e, this, r120));
        r121.addListener(new e(this));
        r121.start();
        goto L81
    L74:
        if (r118.intValue() != 0) goto L76;
        goto L76
    }

    public final void setEasyPullListener(b r100) {
        this.f180484j = r100;
    }

    public OftenShopPullLayout(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f180483i = -1;
        this.f180485k = new TouchHelper(r100);
    }

    public /* synthetic */ OftenShopPullLayout(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
