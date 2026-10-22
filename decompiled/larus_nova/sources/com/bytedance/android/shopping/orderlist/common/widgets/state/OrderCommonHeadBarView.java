package com.bytedance.android.shopping.orderlist.common.widgets.state;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.android.ecom.arch.slice.render.context.SlcRenderContext;
import com.bytedance.android.ecom.arch.slice.render.util.SlcDimensExtensionsKt;
import com.bytedance.android.shopping.extensions.j;
import com.bytedance.android.shopping.orderlist.common.utils.InflaterPriority;
import com.bytedance.android.shopping.orderlist.common.utils.OrderCommonViewUtils;
import com.bytedance.ies.xbridge.base.utils.c;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u0011B'\b\u0007\u0012\u0006\u0010\n\u001a\u00020\t\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\b\b\u0002\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0014\u0010\b\u001a\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u0006¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/shopping/orderlist/common/widgets/state/OrderCommonHeadBarView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Lcom/bytedance/android/shopping/orderlist/common/widgets/state/OrderCommonHeadBarView$HeadBarStyle;", "style", "", "setStyle", "Lkotlin/Function0;", "action", "setClickIconBackListener", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attributeSet", "", "defStyle", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "HeadBarStyle", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class OrderCommonHeadBarView extends ConstraintLayout {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ int f180052e = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Map<Integer, View> f180053a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final View f180054b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final View f180055c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public HeadBarStyle f180056d;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/shopping/orderlist/common/widgets/state/OrderCommonHeadBarView$HeadBarStyle;", "", "ORDER_LIST", "ORDER_SEARCH_RESULT", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum HeadBarStyle extends Enum<HeadBarStyle> {
        public static final HeadBarStyle ORDER_LIST = null;
        public static final HeadBarStyle ORDER_SEARCH_RESULT = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ HeadBarStyle[] f180057a = null;

        static {
            HeadBarStyle r100 = new HeadBarStyle("ORDER_LIST", 0);
            ORDER_LIST = r100;
            HeadBarStyle r101 = new HeadBarStyle("ORDER_SEARCH_RESULT", 1);
            ORDER_SEARCH_RESULT = r101;
            f180057a = new HeadBarStyle[]{r100, r101};
        }

        public static HeadBarStyle valueOf(String r100) {
            return (HeadBarStyle) r27.a.a(HeadBarStyle.class, r100);
        }

        public static HeadBarStyle[] values() {
            return (HeadBarStyle[]) f180057a.clone();
        }

        public HeadBarStyle(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function0 f180058a;

        public a(Function0 r100) {
            this.f180058a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            this.f180058a.invoke();
        }
    }

    public OrderCommonHeadBarView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public OrderCommonHeadBarView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public final View _$_findCachedViewById(int r100) {
        if (this.f180053a != null) goto L5;
        this.f180053a = new LinkedHashMap();
    L5:
        View r101 = this.f180053a.get(Integer.valueOf(r100));
        if (r101 != null) goto L12;
        View r102 = findViewById(r100);
        if (r102 == null) goto L10;
        this.f180053a.put(Integer.valueOf(r100), r102);
        return r102;
    L10:
        return null;
    L12:
        return r101;
    }

    public final void setClickIconBackListener(Function0<Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "action");
        ((ImageView) _$_findCachedViewById(R.id.search_bar_iv_back)).setOnClickListener(new a(r100));
    }

    public final void setStyle(HeadBarStyle r100) {
        this.f180056d = r100;
        if (r100 == null) goto L20;
        int r101 = com.bytedance.android.shopping.orderlist.common.widgets.state.a.f180068a[r100.ordinal()];
        if (r101 != 1) goto L8;
        ImageView r102 = (ImageView) _$_findCachedViewById(R.id.search_bar_head_img);
        if (r102 == null) goto L19;
        r102.setImageResource(R.drawable.order_list_head_bar_for_list);
        return;
    L19:
        return;
    L8:
        if (r101 != 2) goto L21;
        ImageView r103 = (ImageView) _$_findCachedViewById(R.id.search_bar_head_img);
        if (r103 == null) goto L17;
        r103.setImageResource(R.drawable.order_list_head_bar_for_search);
        return;
    L17:
        return;
    L21:
        return;
    }

    public OrderCommonHeadBarView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f180053a = new LinkedHashMap();
        int r103 = OrderCommonViewUtils.f179956a;
        OrderCommonViewUtils.b(InflaterPriority.ORIGIN_ASYNC_CONTEXT, "OrderCommonHeadBarView", r100, R.layout.order_list_view_head_bar, this);
        ConstraintLayout r104 = (ConstraintLayout) _$_findCachedViewById(R.id.head_bar_root);
        if (r104 == null) goto L5;
        r104.setPadding(0, c.a(r100), 0, 0);
    L5:
        this.f180054b = _$_findCachedViewById(R.id.search_bar_iv_back);
        this.f180055c = _$_findCachedViewById(R.id.search_bar_head_img);
    }

    public /* synthetic */ OrderCommonHeadBarView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    public final void R5(boolean r100, ShowBarType r101, String r110, boolean r111, boolean r112, SlcRenderContext r113) {
        if (r113 == null) goto L8;
        View r102 = this.f180054b;
        View r103 = this.f180055c;
        if (r102 == null) goto L6;
        ViewGroup.LayoutParams r104 = r102.getLayoutParams();
        r104.height = SlcDimensExtensionsKt.b(44, r113);
        r104.width = SlcDimensExtensionsKt.b(44, r113);
        Unit r105 = Unit.INSTANCE;
        r102.setLayoutParams(r104);
    L6:
        if (r103 == null) goto L8;
        ViewGroup.LayoutParams r106 = r103.getLayoutParams();
        r106.height = SlcDimensExtensionsKt.b(44, r113);
        Unit r114 = Unit.INSTANCE;
        r103.setLayoutParams(r106);
    L8:
        ConstraintLayout r115 = (ConstraintLayout) _$_findCachedViewById(R.id.search_bar_container);
        if (r100 == false) goto L11;
        int r107 = 0;
    L12:
        r115.setVisibility(r107);
        ConstraintLayout r108 = (ConstraintLayout) _$_findCachedViewById(R.id.tab_bar_container);
        if (r111 == false) goto L15;
        int r109 = 0;
    L16:
        r108.setVisibility(r109);
        if (r101 == null) goto L27;
        int r116 = com.bytedance.android.shopping.orderlist.common.widgets.state.a.f180069b[r101.ordinal()];
        if (r116 != 1) goto L22;
        ((ImageView) _$_findCachedViewById(R.id.search_bar_iv_back)).setVisibility(0);
        ((ImageView) _$_findCachedViewById(R.id.search_bar_head_img)).setVisibility(8);
        ConstraintLayout r117 = (ConstraintLayout) _$_findCachedViewById(R.id.head_bar_root);
        int r118 = c.f249457a;
        r117.setPadding(0, c.a(getContext()), 0, 0);
        setStyle(this.f180056d);
    L42:
        if (r100 == true) goto L46;
        if (r111 == true) goto L46;
        setVisibility(8);
        return;
    L46:
        setVisibility(0);
        return;
    L22:
        if (r116 != 2) goto L24;
        ((ImageView) _$_findCachedViewById(R.id.search_bar_iv_back)).setVisibility(0);
        ((ImageView) _$_findCachedViewById(R.id.search_bar_head_img)).setVisibility(0);
        ConstraintLayout r119 = (ConstraintLayout) _$_findCachedViewById(R.id.head_bar_root);
        int r120 = c.f249457a;
        r119.setPadding(0, c.a(getContext()), 0, 0);
        setStyle(this.f180056d);
        goto L42
    L24:
        if (r116 != 3) goto L26;
        ((ImageView) _$_findCachedViewById(R.id.search_bar_iv_back)).setVisibility(8);
        if (Intrinsics.areEqual(r110, BarTheme.DARK.getValue()) == false) goto L33;
        ((ImageView) _$_findCachedViewById(R.id.search_bar_head_img)).setImageResource(R.drawable.order_list_head_bar_for_search_dark);
    L36:
        if (r112 == false) goto L38;
        ((ConstraintLayout) _$_findCachedViewById(R.id.tab_bar_container)).setBackground(com.bytedance.commerce.base.drawable.a.a(OrderCommonHeadBarView$show$2.INSTANCE));
    L39:
        ((ConstraintLayout) _$_findCachedViewById(R.id.head_bar_root)).setPadding(0, 0, 0, 0);
        ((ImageView) _$_findCachedViewById(R.id.search_bar_head_img)).setVisibility(0);
        goto L42
    L38:
        ((ConstraintLayout) _$_findCachedViewById(R.id.tab_bar_container)).setBackgroundColor(j.b(R.color.order_list_F5F6F9));
        goto L39
    L33:
        if (Intrinsics.areEqual(r110, BarTheme.LIGHT.getValue()) == false) goto L35;
        ((ImageView) _$_findCachedViewById(R.id.search_bar_head_img)).setImageResource(R.drawable.order_list_head_bar_for_search_light);
        goto L36
    L35:
        ((ImageView) _$_findCachedViewById(R.id.search_bar_head_img)).setImageResource(R.drawable.order_list_mall_tab_head_bar);
        goto L36
    L26:
        if (r116 != 4) goto L27;
        ((ImageView) _$_findCachedViewById(R.id.search_bar_iv_back)).setVisibility(8);
        ((ImageView) _$_findCachedViewById(R.id.search_bar_head_img)).setVisibility(8);
        ((ConstraintLayout) _$_findCachedViewById(R.id.head_bar_root)).setPadding(0, 0, 0, 0);
        ((ImageView) _$_findCachedViewById(R.id.search_bar_head_img)).setImageResource(R.drawable.order_list_mall_tab_head_bar);
    L27:
        ((ImageView) _$_findCachedViewById(R.id.search_bar_iv_back)).setVisibility(0);
        ((ImageView) _$_findCachedViewById(R.id.search_bar_head_img)).setVisibility(0);
        ConstraintLayout r121 = (ConstraintLayout) _$_findCachedViewById(R.id.head_bar_root);
        int r122 = c.f249457a;
        r121.setPadding(0, c.a(getContext()), 0, 0);
        setStyle(this.f180056d);
        goto L42
    L15:
        r109 = 8;
        goto L16
    L11:
        r107 = 8;
        goto L12
    }
}
