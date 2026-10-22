package com.bytedance.android.shopping.new_cart.widgets.nest;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.bytedance.android.ec.core.monitor.MonitorScenes;
import com.bytedance.android.ec.core.monitor.q;
import com.bytedance.android.ec.core.utils.k1;
import com.bytedance.android.shopping.new_cart.components.CartBackToTopBtnManageComponent;
import com.bytedance.android.shopping.new_cart.components.CartLoadMoreComponent;
import com.bytedance.android.shopping.new_cart.container.CartObjectContainer;
import com.bytedance.android.shopping.new_cart.container.CartSliceCustomWidgetAdapterComponent;
import com.bytedance.android.shopping.new_cart.utils.CartSettingUtils;
import com.bytedance.android.shopping.new_cart.utils.CartViewExtentionsKt;
import com.bytedance.android.shopping.new_cart.utils.h;
import com.bytedance.android.shopping.new_cart.viewmodel.CartViewModel;
import com.bytedance.android.shopping.new_cart.widgets.CartGULView;
import com.bytedance.android.shopping.new_cart.widgets.LoadMoreFooterView;
import com.bytedance.android.shopping.new_cart.widgets.j;
import com.bytedance.ee.bear.bitable.dao.resourcedata.BitableResourceData;
import com.bytedance.kmp.ec.yata.AndroidYaTaInstance;
import com.bytedance.kmp.ec.yata.view.render.controller.common.ContainerPosition;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ttnet.org.chromium.base.BaseSwitches;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002:\u0001>B'\b\u0007\u0012\u0006\u00108\u001a\u000207\u0012\n\b\u0002\u0010:\u001a\u0004\u0018\u000109\u0012\b\b\u0002\u0010;\u001a\u00020\u0003¢\u0006\u0004\b<\u0010=J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016J\b\u0010\t\u001a\u00020\u0007H\u0016J\u0006\u0010\u000b\u001a\u00020\nJ\u0006\u0010\r\u001a\u00020\fJ\u000e\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u000eJ\u0010\u0010\u0014\u001a\u00020\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012J\b\u0010\u0015\u001a\u00020\u0003H\u0016R\u001d\u0010\u001b\u001a\u0004\u0018\u00010\u00168BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u001d\u0010 \u001a\u0004\u0018\u00010\u001c8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u0018\u001a\u0004\b\u001e\u0010\u001fR\u001d\u0010%\u001a\u0004\u0018\u00010!8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\"\u0010\u0018\u001a\u0004\b#\u0010$R\u001d\u0010*\u001a\u0004\u0018\u00010&8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b'\u0010\u0018\u001a\u0004\b(\u0010)R*\u00102\u001a\u00020\u00032\u0006\u0010+\u001a\u00020\u00038\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R*\u00106\u001a\u00020\u00032\u0006\u0010+\u001a\u00020\u00038\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b3\u0010-\u001a\u0004\b4\u0010/\"\u0004\b5\u00101¨\u0006?"}, d2 = {"Lcom/bytedance/android/shopping/new_cart/widgets/nest/CartLinkedScrollViewV2;", "Lcom/bytedance/android/shopping/new_cart/widgets/nest/CartTwoRevNestedScrollView;", "Lcom/bytedance/android/shopping/new_cart/widgets/j;", "", "getOffsetToBottomScreen", "", "getSessionId", "Landroidx/recyclerview/widget/RecyclerView;", "getYataBody", "getCartRev", "Lcom/bytedance/android/shopping/new_cart/widgets/CartGULView;", "getGul", "Lcom/bytedance/android/shopping/new_cart/widgets/LoadMoreFooterView;", "getLoadingFooter", "Lcom/bytedance/android/shopping/new_cart/container/CartObjectContainer;", "objectContainer", "", "setCartObjectContainer", "Landroid/view/View;", "view", "setTopView", "getMaxScrollRange", "Lcom/bytedance/android/shopping/new_cart/components/CartLoadMoreComponent;", BaseSwitches.V, "Lkotlin/Lazy;", "getCartLoadMoreComponent", "()Lcom/bytedance/android/shopping/new_cart/components/CartLoadMoreComponent;", "cartLoadMoreComponent", "Lcom/bytedance/android/shopping/new_cart/container/CartSliceCustomWidgetAdapterComponent;", "w", "getSliceCustomWidgetAdapterComponent", "()Lcom/bytedance/android/shopping/new_cart/container/CartSliceCustomWidgetAdapterComponent;", "sliceCustomWidgetAdapterComponent", "Lcom/bytedance/android/shopping/new_cart/viewmodel/CartViewModel;", "x", "getCartVM", "()Lcom/bytedance/android/shopping/new_cart/viewmodel/CartViewModel;", "cartVM", "Lcom/bytedance/android/shopping/new_cart/components/CartBackToTopBtnManageComponent;", "y", "getCartBackToTopBtnManageComponent", "()Lcom/bytedance/android/shopping/new_cart/components/CartBackToTopBtnManageComponent;", "cartBackToTopBtnManageComponent", "value", MapBundleKey.MapObjKey.OBJ_SS_ARROW_Z, "I", "getOuterHeight", "()I", "setOuterHeight", "(I)V", "outerHeight", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "getPhysicalHeight", "setPhysicalHeight", "physicalHeight", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "c", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CartLinkedScrollViewV2 extends CartTwoRevNestedScrollView implements j {
    public static final /* synthetic */ int E = 0;
    public int A;
    public Boolean B;
    public final Rect C;
    public final Function2<String, Double, Unit> D;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final RecyclerView f179502p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final CartGULView f179503q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final LoadMoreFooterView f179504r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final View f179505s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f179506t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public CartObjectContainer f179507u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final Lazy f179508v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final Lazy f179509w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final Lazy f179510x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final Lazy f179511y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f179512z;

    public static final class a implements View.OnLayoutChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CartLinkedScrollViewV2 f179513a;

        public a(CartLinkedScrollViewV2 r100) {
            this.f179513a = r100;
        }

        @Override // android.view.View.OnLayoutChangeListener
        public final void onLayoutChange(View r100, int r101, int r102, int r103, int r104, int r105, int r106, int r107, int r108) {
            CartLinkedScrollViewV2 r109 = this.f179513a;
            int r110 = CartLinkedScrollViewV2.E;
            r109.s();
        }
    }

    public static final class b implements View.OnLayoutChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CartLinkedScrollViewV2 f179514a;

        public b(CartLinkedScrollViewV2 r100) {
            this.f179514a = r100;
        }

        @Override // android.view.View.OnLayoutChangeListener
        public final void onLayoutChange(View r100, int r101, int r102, int r103, int r104, int r105, int r106, int r107, int r108) {
            CartLinkedScrollViewV2 r109 = this.f179514a;
            int r110 = CartLinkedScrollViewV2.E;
            r109.s();
        }
    }

    public static final class c {
    }

    public static final class d implements et3.c.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CartLinkedScrollViewV2 f179515a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f179516b;

        public d(CartLinkedScrollViewV2 r100, String r101) {
            this.f179515a = r100;
            this.f179516b = r101;
        }

        @Override // et3.c.d
        public final void fpsCallBack(double r100) {
            this.f179515a.D.invoke(this.f179516b, Double.valueOf(r100));
        }
    }

    public static final class e implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CartLinkedScrollViewV2 f179517a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f179518b;

        public e(CartLinkedScrollViewV2 r100, int r101) {
            this.f179517a = r100;
            this.f179518b = r101;
        }

        public final void a() {
            CartLinkedScrollViewV2 r100 = this.f179517a;
            r100.getClass();
            r100.post(new com.bytedance.android.shopping.new_cart.widgets.nest.e(r100));
            CartSliceCustomWidgetAdapterComponent r101 = CartLinkedScrollViewV2.o(this.f179517a);
            if (r101 == null) goto L24;
            if (r101.f178941d != true) goto L24;
            CartViewModel r102 = CartLinkedScrollViewV2.n(this.f179517a);
            if (r102 == null) goto L11;
            com.bytedance.android.shopping.new_cart.yata.customdata.a r103 = r102.getCustomDataCenter();
            if (r103 == null) goto L11;
            r103.c(Boolean.FALSE);
        L11:
            CartSliceCustomWidgetAdapterComponent r104 = CartLinkedScrollViewV2.o(this.f179517a);
            if (r104 == null) goto L14;
            r104.f178941d = false;
        L14:
            CartViewExtentionsKt.c(this.f179517a);
            CartObjectContainer r105 = this.f179517a.f179507u;
            if (r105 == null) goto L24;
            com.bytedance.android.shopping.new_cart.container.b r106 = r105.f178935e;
            if (r106 == null) goto L24;
            Function0<AndroidYaTaInstance> r107 = r106.f178983d;
            if (r107 == null) goto L24;
            AndroidYaTaInstance r108 = r107.invoke();
            if (r108 == null) goto L24;
            r108.x(null, aa6.a.C0038a.f2348b, null, null);
        L24:
            if (this.f179518b <= 0) goto L28;
            CartLoadMoreComponent r109 = CartLinkedScrollViewV2.m(this.f179517a);
            if (r109 == null) goto L28;
            CartLinkedScrollViewV2 r110 = this.f179517a;
            r109.o(r110, true, r110.getLoadingFooter());
        L28:
            CartLinkedScrollViewV2.k(this.f179517a);
            CartLinkedScrollViewV2.p(this.f179517a);
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

    static {
    }

    public CartLinkedScrollViewV2(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public CartLinkedScrollViewV2(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    private final CartBackToTopBtnManageComponent getCartBackToTopBtnManageComponent() {
        return (CartBackToTopBtnManageComponent) this.f179511y.getValue();
    }

    private final CartLoadMoreComponent getCartLoadMoreComponent() {
        return (CartLoadMoreComponent) this.f179508v.getValue();
    }

    private final CartViewModel getCartVM() {
        return (CartViewModel) this.f179510x.getValue();
    }

    private final CartSliceCustomWidgetAdapterComponent getSliceCustomWidgetAdapterComponent() {
        return (CartSliceCustomWidgetAdapterComponent) this.f179509w.getValue();
    }

    @Override // com.bytedance.android.shopping.new_cart.widgets.j
    public final void d() {
    L10:
        th = move-exception;
        CartViewModel r100 = getCartVM();
        if (r100 == null) goto L17;
        bg3.a r101 = com.bytedance.android.shopping.new_cart.utils.a.f179357a;
        com.bytedance.android.shopping.new_cart.utils.a.g(r100, "justify", th.getMessage(), MapsKt.mapOf(TuplesKt.to("location", "justifyList()")));
        return;
    L17:
        return;
    L4:
        if (canScrollVertically(1) == false) goto L8;
        RecyclerView r102 = this.f179503q.getGULRecyclerView();     // Catch: Throwable -> L10
        if (r102 == null) goto L8;
        Intrinsics.checkNotNullParameter(r102, "$this$scrollToTop");     // Catch: Throwable -> L10
        com.bytedance.android.shopping.new_cart.utils.a.f179359c.d("scrollToTop", new h(r102));     // Catch: Throwable -> L10
    L8:
        int r103 = getScrollY();     // Catch: Throwable -> L10
        scrollBy(0, -r103);     // Catch: Throwable -> L10
        this.f179502p.startNestedScroll(2, 0);     // Catch: Throwable -> L10
        this.f179502p.scrollBy(0, r103);     // Catch: Throwable -> L10
    }

    @Override // androidx.core.widget.NestedScrollView, android.view.View
    public final void onSizeChanged(int r100, int r101, int r102, int r103) {
    }

    public final int q() {
        View r100 = getChildAt(0);
        if (r100 != null) goto L6;
        return 0;
    L6:
        if (CartSettingUtils.a() == false) goto L18;
        int r101 = this.f179502p.getBottom();
        if (r101 <= 0) goto L27;
        CartGULView r102 = this.f179503q;
        if (r102.f179434k == false) goto L16;
        if (r102.getHeight() <= 0) goto L16;
        return RangesKt.coerceAtLeast(this.f179503q.getTop(), 0);
    L16:
        if (RangesKt.coerceAtLeast((r100.getHeight() - r101) - this.f179506t, 0) > 0) goto L26;
        return 0;
    L26:
        return RangesKt.coerceAtLeast(r100.getHeight() - getHeight(), 0);
    L27:
        return 0;
    L18:
        View r103 = this.f179505s;
        if (r103 == null) goto L21;
        int r104 = r103.getHeight();
    L23:
        return RangesKt.coerceAtLeast((r100.getHeight() - r104) - getHeight(), 0);
    L21:
        r104 = 0;
        goto L23
    }

    @Override // com.bytedance.android.shopping.new_cart.widgets.j
    public final void b() {
        int r100 = this.f179503q.getTop();
        if (r100 <= 0) goto L6;
        scrollBy(0, r100);
        return;
    }

    @Override // com.bytedance.android.shopping.new_cart.widgets.j
    public final void c() {
        this.f179502p.stopScroll();
        RecyclerView r100 = this.f179503q.getGULRecyclerView();
        if (r100 == null) goto L5;
        r100.stopScroll();
    L5:
        RecyclerView r101 = this.f179503q.getGULRecyclerView();
        if (r101 == null) goto L8;
        r101.scrollToPosition(0);
    L8:
        scrollTo(0, 0);
    }

    @Override // com.bytedance.android.shopping.new_cart.widgets.j
    public int getOffsetToBottomScreen() {
        if (getGlobalVisibleRect(this.C) == false) goto L5;
        bg3.a r100 = com.bytedance.android.shopping.new_cart.utils.a.f179357a;
        return k1.j(getContext()) - this.C.bottom;
    L5:
        return 0;
    }

    @Override // com.bytedance.android.shopping.new_cart.widgets.nest.CartTwoRevNestedScrollView
    public String getSessionId() {
        CartObjectContainer r100 = this.f179507u;
        if (r100 == null) goto L8;
        com.bytedance.android.shopping.new_cart.container.b r101 = r100.f178935e;
        if (r101 == null) goto L8;
        String r102 = r101.f178992m;
        if (r102 == null) goto L8;
        return r102;
    L8:
        return "";
    }

    @Override // com.bytedance.android.shopping.new_cart.widgets.j
    public final boolean a() {
        if (getScrollY() < this.f179503q.getTop()) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.bytedance.android.shopping.new_cart.widgets.nest.CartTwoRevNestedScrollView
    public int getMaxScrollRange() {
        if (CartSettingUtils.a() == true) goto L7;
        return super.getMaxScrollRange();
    L7:
        return q();
    }

    public final void s() {
        if (CartSettingUtils.a() == true) goto L5;
        return;
    L5:
        RecyclerView r100 = this.f179502p;
        if ((r100 instanceof MaxHeightRecyclerView) == true) goto L8;
        r100 = null;
    L8:
        MaxHeightRecyclerView r101 = (MaxHeightRecyclerView) r100;
        if (r101 != null) goto L11;
        return;
    L11:
        r101.setFooterRoundCornerExtraHeight(this.f179506t);
        int r102 = this.f179504r.getHeight();
        ViewGroup.LayoutParams r103 = this.f179504r.getLayoutParams();
        int r104 = 0;
        if (r103 == null) goto L14;
        int r105 = r103.height;
    L15:
        int r106 = RangesKt.coerceAtLeast(r102, r105);
        if (this.f179504r.getVisibility() != 0) goto L18;
        if (r106 <= 0) goto L18;
    L22:
        boolean r107 = true;
    L24:
        if (r107 == true) goto L27;
        r104 = this.f179506t;
    L27:
        r101.setFooterRoundCornerPaddingBottom(r104);
        return;
    L18:
        CartGULView r108 = this.f179503q;
        if (r108.f179434k == true) goto L21;
    L23:
        r107 = false;
        goto L24
    L21:
        if (r108.getHeight() <= 0) goto L23;
    L14:
        r105 = 0;
        goto L15
    }

    @Override // com.bytedance.android.shopping.new_cart.widgets.j
    public RecyclerView getCartRev() {
        return this.f179502p;
    }

    public final CartGULView getGul() {
        return this.f179503q;
    }

    public final LoadMoreFooterView getLoadingFooter() {
        return this.f179504r;
    }

    public final int getOuterHeight() {
        return this.f179512z;
    }

    public final int getPhysicalHeight() {
        return this.A;
    }

    public RecyclerView getYataBody() {
        return this.f179502p;
    }

    public static final void k(CartLinkedScrollViewV2 r100) {
        CartObjectContainer r101 = r100.f179507u;
        if (r101 == null) goto L49;
        com.bytedance.android.shopping.new_cart.container.b r102 = r101.f178935e;
        if (r102 == null) goto L50;
        Function0<AndroidYaTaInstance> r103 = r102.f178983d;
        if (r103 == null) goto L51;
        AndroidYaTaInstance r104 = r103.invoke();
        if (r104 == null) goto L54;
        View r105 = r104.K("cart_tab_1");
        if (r105 == null) goto L14;
        ViewParent r106 = r105.getParent();
    L16:
        if (r106 != null) goto L18;
    L20:
        boolean r107 = false;
    L22:
        if ((!Intrinsics.areEqual(Boolean.valueOf(r107), r100.B)) == false) goto L52;
        r100.B = Boolean.valueOf(r107);
        List<com.bytedance.kmp.ec.yata.store.node.c> r108 = r104.n(ContainerPosition.BODY);
        if (r108 == null) goto L39;
        Iterator<T> r109 = r108.iterator();
    L27:
        if (r109.hasNext() == false) goto L37;
        Object r110 = r109.next();
        com.bytedance.kmp.ec.yata.store.node.c r111 = (com.bytedance.kmp.ec.yata.store.node.c) r110;
        if ((r111 instanceof com.bytedance.kmp.ec.yata.store.node.c) == true) goto L31;
        r111 = null;
    L31:
        if (r111 == null) goto L33;
        String r112 = r111.getNodeName();
    L35:
        if (Intrinsics.areEqual(r112, "cart_tab") == false) goto L27;
    L38:
        com.bytedance.kmp.ec.yata.store.node.c r113 = (com.bytedance.kmp.ec.yata.store.node.c) r110;
    L40:
        if (r113 == null) goto L53;
        if (r107 == false) goto L43;
        String r114 = "cart_tab_on_screen";
    L44:
        bg3.a r115 = com.bytedance.android.shopping.new_cart.utils.a.f179357a;
        com.bytedance.android.shopping.new_cart.utils.a.c(r100.getCartVM(), r114, new com.bytedance.android.shopping.new_cart.widgets.nest.c(r114, r107, r104, r113), null);
        return;
    L43:
        r114 = "cart_tab_not_on_screen";
        goto L44
    L53:
        return;
    L33:
        r112 = null;
        goto L35
    L37:
        r110 = null;
        goto L38
    L39:
        r113 = null;
        goto L40
    L52:
        return;
    L18:
        if (r105.getBottom() <= 0) goto L20;
        r107 = true;
        goto L22
    L14:
        r106 = null;
        goto L16
    L54:
        return;
    L51:
        return;
    L50:
        return;
    }

    public static final /* synthetic */ CartBackToTopBtnManageComponent l(CartLinkedScrollViewV2 r100) {
        return r100.getCartBackToTopBtnManageComponent();
    }

    public static final /* synthetic */ CartLoadMoreComponent m(CartLinkedScrollViewV2 r100) {
        return r100.getCartLoadMoreComponent();
    }

    public static final /* synthetic */ CartViewModel n(CartLinkedScrollViewV2 r100) {
        return r100.getCartVM();
    }

    public static final /* synthetic */ CartSliceCustomWidgetAdapterComponent o(CartLinkedScrollViewV2 r100) {
        return r100.getSliceCustomWidgetAdapterComponent();
    }

    public static final void p(CartLinkedScrollViewV2 r100) {
        View r101 = r100.getRootView();
        if (r101 == null) goto L105;
        View r102 = r101.findViewById(R.id.save_card_sticky_container);
        if (r102 == null) goto L112;
        CartObjectContainer r103 = r100.f179507u;
        if (r103 == null) goto L106;
        com.bytedance.android.shopping.new_cart.container.b r104 = r103.f178935e;
        if (r104 == null) goto L107;
        Function0<AndroidYaTaInstance> r105 = r104.f178983d;
        if (r105 == null) goto L108;
        AndroidYaTaInstance r106 = r105.invoke();
        if (r106 == null) goto L113;
        List<com.bytedance.kmp.ec.yata.store.node.c> r107 = r106.n(ContainerPosition.BODY);
        Object r108 = null;
        if (r107 == null) goto L32;
        Iterator<T> r109 = r107.iterator();
    L20:
        if (r109.hasNext() == false) goto L30;
        Object r110 = r109.next();
        com.bytedance.kmp.ec.yata.store.node.c r111 = (com.bytedance.kmp.ec.yata.store.node.c) r110;
        if ((r111 instanceof com.bytedance.kmp.ec.yata.store.node.c) == true) goto L24;
        r111 = null;
    L24:
        if (r111 == null) goto L26;
        String r112 = r111.getNodeName();
    L28:
        if (Intrinsics.areEqual(r112, "save_card_bar_inflow") == false) goto L20;
    L31:
        com.bytedance.kmp.ec.yata.store.node.c r113 = (com.bytedance.kmp.ec.yata.store.node.c) r110;
    L34:
        if (r107 == null) goto L52;
        Iterator<T> r114 = r107.iterator();
    L37:
        if (r114.hasNext() == false) goto L47;
        Object r115 = r114.next();
        com.bytedance.kmp.ec.yata.store.node.c r116 = (com.bytedance.kmp.ec.yata.store.node.c) r115;
        if ((r116 instanceof com.bytedance.kmp.ec.yata.store.node.c) == true) goto L41;
        r116 = null;
    L41:
        if (r116 == null) goto L43;
        String r117 = r116.getNodeName();
    L45:
        if (Intrinsics.areEqual(r117, "save_card_bar_sticky") == false) goto L37;
    L48:
        com.bytedance.kmp.ec.yata.store.node.c r118 = (com.bytedance.kmp.ec.yata.store.node.c) r115;
        if (r118 == null) goto L52;
        r108 = r118;
    L67:
        int r119 = 8;
        if (r113 == null) goto L93;
        if (r108 == null) goto L93;
        View r120 = r106.K(r113.getKey());
        if (r120 != null) goto L75;
        return;
    L75:
        if (r120.getHeight() <= 0) goto L115;
        int[] r121 = new int[2];
        int[] r122 = new int[2];
        r100.getLocationOnScreen(r121);
        r120.getLocationOnScreen(r122);
        boolean r123 = true;
        int r124 = r122[1] - r121[1];
        if (r102.getVisibility() != 0) goto L80;
        boolean r125 = true;
    L81:
        if (r125 == false) goto L85;
        if (r124 <= 2) goto L88;
    L87:
        r123 = false;
    L88:
        if (r123 == r125) goto L109;
        if (r123 == false) goto L91;
        r119 = 0;
    L91:
        r102.setVisibility(r119);
        return;
    L109:
        return;
    L85:
        if (r124 > (-2)) goto L87;
    L80:
        r125 = false;
        goto L81
    L115:
        return;
    L93:
        if (r102.getVisibility() != 0) goto L111;
        r102.setVisibility(8);
        return;
    L111:
        return;
    L43:
        r117 = null;
        goto L45
    L47:
        r115 = null;
    L52:
        List<com.bytedance.kmp.ec.yata.store.node.c> r126 = r106.n("save_card_sticky");
        if (r126 == null) goto L67;
        Iterator<T> r127 = r126.iterator();
    L56:
        if (r127.hasNext() == false) goto L66;
        Object r128 = r127.next();
        com.bytedance.kmp.ec.yata.store.node.c r129 = (com.bytedance.kmp.ec.yata.store.node.c) r128;
        if ((r129 instanceof com.bytedance.kmp.ec.yata.store.node.c) == true) goto L60;
        r129 = null;
    L60:
        if (r129 == null) goto L62;
        String r130 = r129.getNodeName();
    L64:
        if (Intrinsics.areEqual(r130, "save_card_bar_sticky") == false) goto L56;
        r108 = r128;
        goto L66
    L62:
        r130 = null;
    L66:
        r108 = (com.bytedance.kmp.ec.yata.store.node.c) r108;
        goto L67
    L26:
        r112 = null;
        goto L28
    L30:
        r110 = null;
        goto L31
    L32:
        r113 = null;
        goto L34
    L113:
        return;
    L108:
        return;
    L107:
        return;
    L106:
        return;
    L112:
        return;
    }

    @Override // android.view.View
    public final boolean canScrollVertically(int r100) {
        if (CartSettingUtils.a() == false) goto L5;
        if (r100 <= 0) goto L12;
        if (getScrollY() >= q()) goto L10;
        return true;
    L10:
        return false;
    L12:
        return super.canScrollVertically(r100);
    L5:
        return super.canScrollVertically(r100);
    }

    @Override // com.bytedance.android.shopping.new_cart.widgets.nest.CartTwoRevNestedScrollView
    public final void g(int r100) {
        CartBackToTopBtnManageComponent r101 = getCartBackToTopBtnManageComponent();
        if (r101 != null) goto L5;
        return;
    L5:
        if (((Boolean) r101.f178686c.getValue()).booleanValue() == false) goto L22;
        View r102 = r101.f178689f;
        if (r102 != null) goto L10;
        return;
    L10:
        if (r102.getVisibility() == 0) goto L13;
        return;
    L13:
        if (r100 != 2) goto L15;
        View r103 = r101.f178689f;
        r103.animate().cancel();
        r103.setAlpha(0.5f);
        r103.animate().alpha(0.5f).setDuration(300).withStartAction(new com.bytedance.android.shopping.new_cart.components.b(r103)).start();
        return;
    L15:
        if (r100 != 0) goto L21;
        View r104 = r101.f178689f;
        r104.animate().cancel();
        r104.animate().alpha(1.0f).setStartDelay(1000).setDuration(500).start();
        return;
    L21:
        return;
    }

    @Override // com.bytedance.android.shopping.new_cart.widgets.nest.CartTwoRevNestedScrollView
    public final RecyclerView.OnScrollListener h(String r100) {
        Intrinsics.checkNotNullParameter(r100, "type");
        final et3.c r101 = new et3.c("yata_cart", true, null);
        r101.c(new d(this, r100));
        return new CartLinkedScrollViewV2$getFpsHook$2(r101);
    }

    @Override // com.bytedance.android.shopping.new_cart.widgets.nest.CartTwoRevNestedScrollView
    public final void i(int r100) {
        post(new e(this, r100));
    }

    public final void r(int r100) {
        if (CartSettingUtils.a() == false) goto L7;
        int r101 = RangesKt.coerceAtLeast(r100, 0);
        this.f179506t = r101;
        this.f179503q.setFooterRoundCornerExtraHeight(r101);
        s();
        View r102 = this.f179505s;
        if (r102 == null) goto L11;
        ViewGroup.LayoutParams r103 = r102.getLayoutParams();
        r103.height = this.f179506t;
        Unit r104 = Unit.INSTANCE;
        r102.setLayoutParams(r103);
        r102.requestLayout();
        return;
    L11:
        return;
    L7:
        View r105 = this.f179505s;
        if (r105 == null) goto L13;
        ViewGroup.LayoutParams r106 = r105.getLayoutParams();
        r106.height = r100;
        Unit r107 = Unit.INSTANCE;
        r105.setLayoutParams(r106);
        r105.requestLayout();
        return;
    }

    public final void setCartObjectContainer(CartObjectContainer r100) {
        Intrinsics.checkNotNullParameter(r100, "objectContainer");
        this.f179507u = r100;
        this.f179503q.setObjectContainer(r100);
    }

    public final void setOuterHeight(int r100) {
        if (this.f179512z == r100) goto L15;
        RecyclerView r101 = this.f179502p;
        if ((r101 instanceof MaxHeightRecyclerView) == true) goto L7;
        r101 = null;
    L7:
        MaxHeightRecyclerView r102 = (MaxHeightRecyclerView) r101;
        if (r102 == null) goto L10;
        r102.setMaxHeight(r100);
    L10:
        this.f179503q.setOuterHeight(r100);
        if (CartSettingUtils.a() == true) goto L15;
        ViewGroup.LayoutParams r103 = getLayoutParams();
        if (r103 == null) goto L15;
        r103.height = r100;
    L15:
        this.f179512z = r100;
    }

    public final void setPhysicalHeight(int r100) {
        if (this.A != r100) goto L5;
    L10:
        this.A = r100;
        return;
    L5:
        if (CartSettingUtils.a() == false) goto L10;
        ViewGroup.LayoutParams r101 = getLayoutParams();
        if (r101 == null) goto L9;
        r101.height = r100;
    L9:
        requestLayout();
        goto L10
    }

    public final void setTopView(View r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        removeView(this.f179502p);
        ViewGroup r101 = getInnerLayout();
        if (r101 == null) goto L8;
        r101.addView(r100, 0);
        return;
    }

    @Override // androidx.core.widget.NestedScrollView, android.view.View
    public final void scrollTo(int r100, int r101) {
        if (CartSettingUtils.a() == true) goto L6;
        super.scrollTo(r100, r101);
        return;
    L6:
        int r102 = q();
        if (r102 <= 0) goto L9;
        r101 = RangesKt.coerceAtMost(r101, r102);
    L9:
        super.scrollTo(r100, r101);
    }

    public CartLinkedScrollViewV2(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f179508v = LazyKt.lazy(new CartLinkedScrollViewV2$cartLoadMoreComponent$2(this));
        this.f179509w = LazyKt.lazy(new CartLinkedScrollViewV2$sliceCustomWidgetAdapterComponent$2(this));
        this.f179510x = LazyKt.lazy(new CartLinkedScrollViewV2$cartVM$2(this));
        this.f179511y = LazyKt.lazy(new CartLinkedScrollViewV2$cartBackToTopBtnManageComponent$2(this));
        LayoutInflater.from(r100).inflate(R.layout.new_cart_nested_v2_container, this, true);
        setInnerLayout((ViewGroup) findViewById(R.id.container));
        RecyclerView r103 = (RecyclerView) findViewById(R.id.rev1);
        r103.setLayoutManager(new LinearLayoutManager(r100, 1, false));
        j(BitableResourceData.KEY_REV_1, r103);
        Unit r104 = Unit.INSTANCE;
        this.f179502p = r103;
        CartGULView r105 = (CartGULView) findViewById(R.id.nested_v2_gul);
        r105.setSetUpCallBack(new CartLinkedScrollViewV2$$special$$inlined$apply$lambda$1(this));
        r105.setOuterScrollView(this);
        this.f179503q = r105;
        LoadMoreFooterView r106 = (LoadMoreFooterView) findViewById(R.id.load_more_footer_view);
        this.f179504r = r106;
        r106.addOnLayoutChangeListener(new a(this));
        r105.addOnLayoutChangeListener(new b(this));
        this.f179505s = findViewById(R.id.footer_round_corner_placeholder);
        jh.b.a r107 = jh.b.f499064c;
        q r108 = new q(MonitorScenes.FPS_SCENE_EC_CART_LIST.getSceneName());
        r107.getClass();
        jh.b.a.c(r108).c(r103);
        this.C = new Rect();
        this.D = new CartLinkedScrollViewV2$fpsCallback$1(this);
    }

    public /* synthetic */ CartLinkedScrollViewV2(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
