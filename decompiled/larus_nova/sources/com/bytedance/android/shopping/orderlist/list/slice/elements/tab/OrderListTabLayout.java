package com.bytedance.android.shopping.orderlist.list.slice.elements.tab;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.Space;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.ec.core.opt.asyncInflate.ShoppingAsyncInflater;
import com.bytedance.android.ec.core.utils.s0;
import com.bytedance.android.ec.store.window.popup.ShopPopupWindowManager;
import com.bytedance.android.ecom.arch.slice.render.widget.roundcorner.SlcRoundLinearlayout;
import com.bytedance.android.shopping.orderlist.common.utils.OrderCommonLog;
import com.bytedance.android.shopping.orderlist.common.utils.m;
import com.bytedance.android.shopping.orderlist.list.container.OrderListFragment;
import com.bytedance.android.ui.base.widget.round.RoundView;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.PopupWindowLancet;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0002\u001c\u001dB'\b\u0007\u0012\u0006\u0010\u0016\u001a\u00020\u0015\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0017\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0006¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0006\u0010\u0007\u001a\u00020\u0006J\b\u0010\t\u001a\u0004\u0018\u00010\bJ\b\u0010\n\u001a\u0004\u0018\u00010\bJ\b\u0010\u000b\u001a\u0004\u0018\u00010\bJ\b\u0010\f\u001a\u0004\u0018\u00010\bJ\b\u0010\r\u001a\u0004\u0018\u00010\bJ\u0016\u0010\u0011\u001a\u00020\u00042\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH\u0002J\u0012\u0010\u0013\u001a\u00020\u00042\b\u0010\u0012\u001a\u0004\u0018\u00010\u000fH\u0002J\u0010\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u000fH\u0002¨\u0006\u001e"}, d2 = {"Lcom/bytedance/android/shopping/orderlist/list/slice/elements/tab/OrderListTabLayout;", "Lcom/bytedance/android/ecom/arch/slice/render/widget/roundcorner/SlcRoundLinearlayout;", "Lcom/bytedance/android/shopping/orderlist/list/slice/elements/tab/e;", "event", "", "onTabBubbleEvent", "", "getTabSize", "Lcom/bytedance/android/shopping/orderlist/list/slice/elements/tab/OrderListTabLayout$a;", "getSelectedViewInfo", "getSelectedRightViewInfo", "getSelectedLeftViewInfo", "getFirstViewInfo", "getLastViewInfo", "", "Lcom/bytedance/android/shopping/orderlist/list/slice/elements/tab/g;", "tabList", "setTabAccessible", "tabInfo", "setStartTabAccessible", "setOtherTabsAccessible", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "BindType", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class OrderListTabLayout extends SlcRoundLinearlayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final FrameLayout f180279a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LinearLayout f180280b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final RoundView f180281c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Space f180282d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f180283e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public f f180284f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public f f180285g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final LinkedHashMap<Integer, a> f180286h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final b f180287i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public PopupWindow f180288j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Integer f180289k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f180290l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public LifecycleOwner f180291m;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/shopping/orderlist/list/slice/elements/tab/OrderListTabLayout$BindType;", "", "FULL_INIT", "DIFF_UPDATE", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum BindType extends Enum<BindType> {
        public static final BindType DIFF_UPDATE = null;
        public static final BindType FULL_INIT = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ BindType[] f180292a = null;

        static {
            BindType r100 = new BindType("FULL_INIT", 0);
            FULL_INIT = r100;
            BindType r101 = new BindType("DIFF_UPDATE", 1);
            DIFF_UPDATE = r101;
            f180292a = new BindType[]{r100, r101};
        }

        public static BindType valueOf(String r100) {
            return (BindType) r27.a.a(BindType.class, r100);
        }

        public static BindType[] values() {
            return (BindType[]) f180292a.clone();
        }

        public BindType(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public g f180293a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final OrderListTabItemView f180294b;

        public a(g r100, OrderListTabItemView r101) {
            Intrinsics.checkNotNullParameter(r100, "tabItemInfo");
            Intrinsics.checkNotNullParameter(r101, "itemTabView");
            this.f180293a = r100;
            this.f180294b = r101;
        }
    }

    public OrderListTabLayout(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public OrderListTabLayout(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public final void d() {
        PopupWindow r100 = this.f180288j;
        if (r100 == null) goto L5;
        PopupWindowLancet.handleDismissBeforeOrigin(r100);
        r100.dismiss();
    L5:
        this.f180288j = null;
        this.f180289k = null;
        this.f180290l = false;
    }

    public final a getFirstViewInfo() {
        Iterator<Map.Entry<Integer, a>> r100 = this.f180286h.entrySet().iterator();
    L4:
        if (r100.hasNext() == false) goto L9;
        Map.Entry<Integer, a> r101 = r100.next();
        if (r101.getValue().f180293a.f180329g == false) goto L4;
        return r101.getValue();
    L9:
        return null;
    }

    public final a getLastViewInfo() {
        Iterator<Map.Entry<Integer, a>> r100 = this.f180286h.entrySet().iterator();
    L4:
        if (r100.hasNext() == false) goto L9;
        Map.Entry<Integer, a> r101 = r100.next();
        if (r101.getValue().f180293a.f180330h == false) goto L4;
        return r101.getValue();
    L9:
        return null;
    }

    public final a getSelectedLeftViewInfo() {
        List r100 = MapsKt.toList(this.f180286h);
        Iterator r101 = r100.iterator();
        int r102 = 0;
    L4:
        if (r101.hasNext() == false) goto L15;
        Object r103 = r101.next();
        int r104 = r102 + 1;
        if (r102 >= 0) goto L9;
        CollectionsKt.throwIndexOverflow();
    L9:
        if (((a) ((Pair) r103).getSecond()).f180293a.f180328f == true) goto L10;
        r102 = r104;
        goto L4
    L10:
        Pair r105 = (Pair) CollectionsKt.getOrNull(r100, r102 - 1);
        if (r105 != null) goto L13;
        return null;
    L13:
        return (a) r105.getSecond();
    L15:
        return null;
    }

    public final a getSelectedRightViewInfo() {
        List r100 = MapsKt.toList(this.f180286h);
        Iterator r101 = r100.iterator();
        int r102 = 0;
    L4:
        if (r101.hasNext() == false) goto L15;
        Object r103 = r101.next();
        int r104 = r102 + 1;
        if (r102 >= 0) goto L9;
        CollectionsKt.throwIndexOverflow();
    L9:
        if (((a) ((Pair) r103).getSecond()).f180293a.f180328f == true) goto L10;
        r102 = r104;
        goto L4
    L10:
        Pair r105 = (Pair) CollectionsKt.getOrNull(r100, r104);
        if (r105 != null) goto L13;
        return null;
    L13:
        return (a) r105.getSecond();
    L15:
        return null;
    }

    public final a getSelectedViewInfo() {
        Iterator<Map.Entry<Integer, a>> r100 = this.f180286h.entrySet().iterator();
    L4:
        if (r100.hasNext() == false) goto L9;
        Map.Entry<Integer, a> r101 = r100.next();
        if (r101.getValue().f180293a.f180328f == false) goto L4;
        return r101.getValue();
    L9:
        return null;
    }

    public final int getTabSize() {
        return this.f180286h.size();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        s0.c(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        d();
        s0.e(this);
        this.f180291m = null;
        super.onDetachedFromWindow();
    }

    private final void setOtherTabsAccessible(g r100) {
        a r101 = e(r100.f180326d);
        if (r101 == null) goto L42;
        OrderListTabItemView r102 = r101.f180294b;
        if (r102 == null) goto L43;
        g r103 = r101.f180293a;
        String r104 = null;
        if (r103 == null) goto L9;
        String r105 = r103.f180324b;
    L11:
        if (r105 == null) goto L31;
        if (f(r100.f180326d) == false) goto L22;
        Resources r106 = getResources();
        Object[] r107 = new Object[2];
        g r108 = r101.f180293a;
        if (r108 == null) goto L17;
        String r109 = r108.f180323a;
    L18:
        r107[0] = r109;
        if (r108 == null) goto L21;
        r104 = r108.f180324b;
    L21:
        r107[1] = r104;
        String r110 = r106.getString(R.string.order_list_accessible_button_with_count, r107);
    L40:
        r102.setContentDescription(r110);
        return;
    L17:
        r109 = null;
        goto L18
    L22:
        Resources r111 = getResources();
        Object[] r112 = new Object[2];
        g r113 = r101.f180293a;
        if (r113 == null) goto L25;
        String r114 = r113.f180323a;
    L26:
        r112[0] = r114;
        if (r113 == null) goto L29;
        r104 = r113.f180324b;
    L29:
        r112[1] = r104;
        r110 = r111.getString(R.string.order_list_accessible_button_with_count_unselected, r112);
        goto L40
    L25:
        r114 = null;
        goto L26
    L31:
        if (f(r100.f180326d) == false) goto L36;
        Resources r115 = getResources();
        Object[] r116 = new Object[1];
        g r117 = r101.f180293a;
        if (r117 == null) goto L35;
        r104 = r117.f180323a;
    L35:
        r116[0] = r104;
        r110 = r115.getString(R.string.order_list_accessible_button, r116);
        goto L40
    L36:
        Resources r118 = getResources();
        Object[] r119 = new Object[1];
        g r120 = r101.f180293a;
        if (r120 == null) goto L39;
        r104 = r120.f180323a;
    L39:
        r119[0] = r104;
        r110 = r118.getString(R.string.order_list_accessible_button_unselected, r119);
        goto L40
    L9:
        r105 = null;
        goto L11
    L43:
        return;
    }

    private final void setStartTabAccessible(g r100) {
        Integer r101 = null;
        if (r100 == null) goto L5;
        Integer r102 = Integer.valueOf(r100.f180326d);
    L6:
        a r103 = e(com.bytedance.android.shopping.extensions.k.f(r102));
        if (r103 == null) goto L17;
        OrderListTabItemView r104 = r103.f180294b;
        if (r100 == null) goto L12;
        r101 = Integer.valueOf(r100.f180326d);
    L12:
        if (f(com.bytedance.android.shopping.extensions.k.f(r101)) == false) goto L14;
        String r105 = getResources().getString(R.string.order_list_accessible_button, new Object[]{r103.f180293a.f180323a});
    L15:
        r104.setContentDescription(r105);
        return;
    L14:
        r105 = getResources().getString(R.string.order_list_accessible_button_unselected, new Object[]{r103.f180293a.f180323a});
        goto L15
    L17:
        return;
    L5:
        r102 = null;
        goto L6
    }

    private final void setTabAccessible(List<g> r100) {
        setStartTabAccessible((g) CollectionsKt.firstOrNull(r100));
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L5
        Object r102 = Result.m9449constructorimpl(r100.subList(1, r100.size()));     // Catch: Throwable -> L5
    L8:
        if (Result.m9455isFailureimpl(r102) == false) goto L10;
        r102 = null;
    L10:
        List r103 = (List) r102;
        if (r103 == null) goto L16;
        Iterator r104 = r103.iterator();
    L14:
        if (r104.hasNext() == false) goto L20;
        setOtherTabsAccessible((g) r104.next());
        goto L14
    L20:
        return;
    L16:
        return;
    L5:
        th = move-exception;
        Result.Companion r105 = Result.Companion;
        r102 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L8
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchHoverEvent(MotionEvent r100) {
        return super.dispatchHoverEvent(r100);
    }

    public final a e(int r100) {
        Iterator<Map.Entry<Integer, a>> r101 = this.f180286h.entrySet().iterator();
    L4:
        if (r101.hasNext() == false) goto L9;
        Map.Entry<Integer, a> r102 = r101.next();
        if (r102.getKey().intValue() != r100) goto L4;
        return r102.getValue();
    L9:
        return null;
    }

    public final boolean f(int r100) {
        a r101 = getSelectedViewInfo();
        if (r101 == null) goto L9;
        g r102 = r101.f180293a;
        if (r102 == null) goto L9;
        if (r102.f180326d != r100) goto L9;
        return true;
    L9:
        return false;
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public final void onTabBubbleEvent(e r210) {
        Intrinsics.checkNotNullParameter(r210, "event");
        if (r210.f180311b == false) goto L24;
        int r100 = r210.f180310a;
        String r101 = r210.f180312c;
        if (r101 != null) goto L7;
        r101 = "";
    L7:
        String r102 = r101;
        Long r103 = r210.f180313d;
        boolean r110 = Intrinsics.areEqual(r210.f180314e, Boolean.TRUE);
        int r111 = r210.f180315f;
        if (StringsKt.isBlank(r102) == true) goto L33;
        LifecycleOwner r104 = this.f180291m;
        if (r104 == null) goto L34;
        a r105 = e(r100);
        if (r105 == null) goto L35;
        d();
        ArrayList r106 = new ArrayList();
        if (r110 == false) goto L19;
        r106.add(new sn.d.a());
    L19:
        if (r103 != null) goto L21;
    L23:
        rn.d r107 = new rn.d(r106, new tn.a.c(0, 0, false, r111, new tn.a.C7744a(12.0f, 12.0f, 12.0f, 12.0f)), CollectionsKt.listOf(new rn.c[]{new rn.b(new tn.a.b()), new rn.f(CollectionsKt.emptyList(), new tn.a.e(18, 13, -1, r102, true)), new rn.b(new tn.a.b())}));
        int r108 = ShopPopupWindowManager.f49015a;
        PopupWindow r109 = ShopPopupWindowManager.b(r105.f180294b, r107, r104, ShopPopupWindowManager.PopupPosition.BELOW, ShopPopupWindowManager.PopupRelativeAnchorPosition.HORIZONTAL_CENTER);
        r109.setOnDismissListener(new i(r109, this));
        Unit r112 = Unit.INSTANCE;
        this.f180288j = r109;
        this.f180289k = Integer.valueOf(r100);
        this.f180290l = r110;
        return;
    L21:
        if (r103.longValue() <= 0) goto L23;
        r106.add(new sn.d.c(r103.longValue()));
        goto L23
    L35:
        return;
    L34:
        return;
    L33:
        return;
    L24:
        int r113 = r210.f180310a;
        Integer r114 = this.f180289k;
        if (r114 != null) goto L28;
        return;
    L28:
        if (r114.intValue() != r113) goto L37;
        d();
        return;
    }

    public OrderListTabLayout(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f180286h = new LinkedHashMap();
        setOrientation(1);
        ShoppingAsyncInflater.f45268e.getClass();
        ShoppingAsyncInflater.a.a(r100).aU(R.layout.order_list_view_tab_layout, this, true);
        setPadding(com.bytedance.android.shopping.extensions.b.b(8), 0, 0, 0);
        FrameLayout r103 = (FrameLayout) findViewById(R.id.fl_start_container);
        this.f180279a = r103;
        this.f180280b = (LinearLayout) findViewById(R.id.ll_scroll_container);
        RoundView r104 = (RoundView) findViewById(R.id.tab_indicator);
        this.f180281c = r104;
        this.f180282d = (Space) findViewById(R.id.tab_space);
        this.f180287i = new b(this, r103, (CustomHorizontalScrollView) findViewById(R.id.scroll_view), r104, findViewById(R.id.shadow_view));
    }

    public /* synthetic */ OrderListTabLayout(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    public static final void b(final OrderListTabLayout r100, final Function0 r101, final f r102, final BindType r103) {
        r100.getClass();
        Lazy r104 = OrderCommonLog.f179948a;
        OrderCommonLog.c("OrderListTabLayout", new OrderListTabLayout$initView$1(r103, r102));
        List<g> r105 = r102.f180320e;
        r100.setTabAccessible(r105);
        if (r103 != BindType.FULL_INIT) goto L34;
        r100.f180279a.removeAllViews();
        r100.f180280b.removeAllViews();
        r100.f180286h.clear();
        Iterator<T> r106 = r105.iterator();
    L5:
        AttributeSet r107 = null;
        if (r106.hasNext() == false) goto L8;
        final g r108 = (g) r106.next();
        OrderListTabItemView r109 = new OrderListTabItemView(r100.getContext(), r107, 6, 0);
        com.bytedance.android.ec.core.widget.f.c(r109, null, null, new OrderListTabLayout$initView$$inlined$forEach$lambda$1(r108, r100, r101), 3);
        r100.f180286h.put(Integer.valueOf(r108.f180326d), new a(r108, r109));
        goto L5
    L8:
        g r110 = (g) CollectionsKt.firstOrNull(r105);
        if (r110 == null) goto L42;
        a r111 = r100.e(r110.f180326d);
        FrameLayout r112 = r100.f180279a;
        if (r111 == null) goto L13;
        OrderListTabItemView r113 = r111.f180294b;
    L14:
        r112.addView(r113, new LinearLayout.LayoutParams(-2, -1));
        goto L42
    L13:
        r113 = null;
    L42:
        Result.Companion r114 = Result.Companion;     // Catch: Throwable -> L17
        Object r115 = Result.m9449constructorimpl(r105.subList(1, r105.size()));     // Catch: Throwable -> L17
    L20:
        if (Result.m9455isFailureimpl(r115) == false) goto L22;
        r115 = null;
    L22:
        List r116 = (List) r115;
        if (r116 == null) goto L32;
        Iterator r117 = r116.iterator();
    L26:
        if (r117.hasNext() == false) goto L32;
        a r118 = r100.e(((g) r117.next()).f180326d);
        LinearLayout r119 = r100.f180280b;
        if (r118 == null) goto L30;
        OrderListTabItemView r120 = r118.f180294b;
    L31:
        r119.addView(r120, new LinearLayout.LayoutParams(-2, -1));
        goto L26
    L30:
        r120 = null;
    L32:
        r100.f180280b.addView(r100.f180282d);
        return;
    L17:
        th = move-exception;
        Result.Companion r121 = Result.Companion;
        r115 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L20
    L34:
        if (r103 != BindType.DIFF_UPDATE) goto L53;
        Iterator<T> r122 = r102.f180320e.iterator();
    L37:
        if (r122.hasNext() == false) goto L54;
        g r123 = (g) r122.next();
        a r124 = r100.f180286h.get(Integer.valueOf(r123.f180326d));
        if (r124 == null) goto L37;
        Intrinsics.checkNotNullParameter(r123, "<set-?>");
        r124.f180293a = r123;
        goto L37
    L54:
        return;
    }

    public final void c(final com.bytedance.android.ecom.arch.slice.render.context.b r100, final Function0<OrderListFragment> r101, final f r110, final BindType r111) {
        Intrinsics.checkNotNullParameter(r100, "slcDisplayMetrics");
        Intrinsics.checkNotNullParameter(r101, "fragmentProvider");
        Intrinsics.checkNotNullParameter(r110, "tabInfo");
        Intrinsics.checkNotNullParameter(r111, "type");
        m.a r102 = m.f179977a;
        m.c(new OrderListTabLayout$bindView$1(this, r101, r110, r111, r100));
    }
}
