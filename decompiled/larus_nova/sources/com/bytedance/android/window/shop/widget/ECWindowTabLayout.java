package com.bytedance.android.window.shop.widget;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.core.content.res.ResourcesCompat;
import com.bytedance.android.ui.base.widget.tablayout.ECTabLayout;
import com.bytedance.android.window.shop.repository.tab.entity.WindowProductCategoryVODeprecated;
import com.bytedance.android.window.shop.repository.tab.entity.i0;
import com.bytedance.android.window.shop.widget.category.TextCategoryView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.security.android.aopcheck.reporter.ReportConstant;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001\u0010B'\b\u0007\u0012\u0006\u0010\n\u001a\u00020\t\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\b\b\u0002\u0010\r\u001a\u00020\u0005¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0001H\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0005H\u0016¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/window/shop/widget/ECWindowTabLayout;", "Lcom/bytedance/android/ui/base/widget/tablayout/ECTabLayout;", "tabLayout", "", "setTabWidth", "", "getScreenWidth", "color", "setSelectedTabIndicatorColor", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECWindowTabLayout extends ECTabLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<ClickSeparatedTabSelectListener> f189847a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<com.bytedance.android.window.shop.c, ECTabLayout.Tab> f189848b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final c f189849c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final b f189850d;

    public static final class a {
    }

    public static final class b extends ClickSeparatedTabSelectListener {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ECWindowTabLayout f189851b;

        public b(ECWindowTabLayout r100) {
            this.f189851b = r100;
        }

        @Override // com.bytedance.android.window.shop.widget.ClickSeparatedTabSelectListener
        public final void b(ECTabLayout.Tab r100, ClickSeparatedTabSelectListener.ActionType r101) {
            Intrinsics.checkNotNullParameter(r101, ReportConstant.COMMON_ACTION_TYPE);
            ArrayList r102 = (ArrayList) this.f189851b.f189847a;
            Integer r103 = Integer.valueOf(r102.indexOf(this));
            if (r103.intValue() < 0) goto L5;
            boolean r104 = true;
        L6:
            if (r104 == true) goto L9;
            r103 = null;
        L9:
            if (r103 == null) goto L13;
            int r105 = r103.intValue() + 1;
            int r106 = r102.size();
        L11:
            if (r105 >= r106) goto L15;
            ((ClickSeparatedTabSelectListener) ListProtector.get(r102, r105)).a(r100, r101);
            r105 = r105 + 1;
            goto L11
        L15:
            return;
        L13:
            return;
        L5:
            r104 = false;
            goto L6
        }
    }

    public static final class c extends ClickSeparatedTabSelectListener {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ECWindowTabLayout f189852b;

        public c(ECWindowTabLayout r100) {
            this.f189852b = r100;
        }

        @Override // com.bytedance.android.window.shop.widget.ClickSeparatedTabSelectListener
        public final void b(ECTabLayout.Tab r100, ClickSeparatedTabSelectListener.ActionType r101) {
            Intrinsics.checkNotNullParameter(r101, ReportConstant.COMMON_ACTION_TYPE);
            Iterator r102 = ((ArrayList) this.f189852b.f189847a).iterator();
            if (r102.hasNext() == false) goto L6;
            ((ClickSeparatedTabSelectListener) r102.next()).b(r100, r101);
            return;
        }
    }

    static {
    }

    public ECWindowTabLayout(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public ECWindowTabLayout(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    private final int getScreenWidth() {
        Resources r100 = getResources();
        return WindowDisplayMetricsOverride.apply(r100, r100.getDisplayMetrics()).widthPixels;
    }

    private final void setTabWidth(ECTabLayout r100) {
        int r101 = r100.getTabCount();
        if (r101 > 0) goto L5;
        return;
    L5:
        int r102 = getScreenWidth() - (th.a.f(r100.getContext()).getDimensionPixelSize(R.dimen.ec_window_subcategory_edge_padding) * 2);
        float r103 = com.bytedance.android.ec.core.utils.q.a(8);
        int r104 = 0;
    L6:
        if (r104 >= r101) goto L23;
        ECTabLayout.Tab r105 = r100.getTabAt(r104);
        View r106 = r100.getChildAt(0);
        if ((r106 instanceof LinearLayout) == true) goto L10;
        r106 = null;
    L10:
        LinearLayout r107 = (LinearLayout) r106;
        if (r107 == null) goto L20;
        ViewGroup.LayoutParams r108 = r107.getChildAt(r104).getLayoutParams();
        if (r108 == null) goto L22;
        LinearLayout.LayoutParams r109 = (LinearLayout.LayoutParams) r108;
        r109.width = (int) ((r102 / r101) - r103);
        if (r105 == null) goto L20;
        View r110 = r105.getCustomView();
        if (r110 == null) goto L20;
        r110.setLayoutParams(r109);
        goto L20
    L22:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
    L20:
        r104 = r104 + 1;
        goto L6
    }

    @Override // com.bytedance.android.ui.base.widget.tablayout.ECTabLayout
    public final void addOnTabSelectedListener(ECTabLayout.BaseOnTabSelectedListener<?> r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        if ((r100 instanceof ClickSeparatedTabSelectListener) == false) goto L5;
        this.f189847a.add(r100);
        return;
    L5:
        super.addOnTabSelectedListener(r100);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v0, types: [com.bytedance.android.ui.base.widget.tablayout.ECTabLayout$Tab] */
    /* JADX WARN: Type inference failed for: r8v0 */
    /* JADX WARN: Type inference failed for: r8v2, types: [android.view.View, com.bytedance.android.window.shop.widget.category.a] */
    /* JADX WARN: Type inference failed for: r8v3 */
    public final void b(com.bytedance.android.window.shop.repository.tab.entity.x r110) {
        Iterator r100 = r110.f189643k.f189508j.iterator();
        int r101 = 0;
    L4:
        if (r100.hasNext() == false) goto L28;
        Object r102 = r100.next();
        int r103 = r101 + 1;
        if (r101 >= 0) goto L8;
        CollectionsKt.throwIndexOverflow();
    L8:
        WindowProductCategoryVODeprecated.a r104 = (WindowProductCategoryVODeprecated.a) r102;
        ?? r105 = getTabAt(r101);
        if (r105 == 0) goto L27;
        int r106 = r110.f189642j;
        ?? r107 = 0;
        if ((r104 instanceof WindowProductCategoryVODeprecated.c) == false) goto L19;
        WindowProductCategoryVODeprecated.c r108 = (WindowProductCategoryVODeprecated.c) r104;
        com.bytedance.android.window.shop.widget.category.b r109 = new com.bytedance.android.window.shop.widget.category.b(r108, getContext(), null);
        int r111 = getHeight() - getPaddingTop();
        if (r109.getDp(Integer.valueOf(r108.f189515e.getHeight())) <= r111) goto L16;
        if (r111 == 0) goto L16;
        ViewGroup.LayoutParams r112 = new ViewGroup.LayoutParams((r109.getDp(Integer.valueOf(r108.f189515e.getWidth())) * r111) / r109.getDp(Integer.valueOf(r108.f189515e.getHeight())), r111);
    L17:
        r109.setLayoutParams(r112);
        Object r113 = r109;
    L21:
        r107 = r113;
    L22:
        if (r107 == 0) goto L26;
        if (r101 != r106) goto L25;
        r107.u();
        goto L26
    L25:
        r107.w();
    L26:
        r105.setCustomView(r107);
    L16:
        r112 = new ViewGroup.LayoutParams(r109.getDp(Integer.valueOf(r108.f189515e.getWidth())), r109.getDp(Integer.valueOf(r108.f189515e.getHeight())));
        goto L17
    L19:
        if ((r104 instanceof WindowProductCategoryVODeprecated.d) == false) goto L22;
        TextCategoryView r114 = new TextCategoryView((WindowProductCategoryVODeprecated.d) r104, getContext(), null, new TextCategoryView.a(16.0f, null));
        r114.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        r114.setPadding(0, com.bytedance.android.shopping.extensions.b.b(2), 0, 0);
        r113 = r114;
    L27:
        r101 = r103;
        goto L4
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v10 */
    /* JADX WARN: Type inference failed for: r4v2, types: [android.view.View, com.bytedance.android.window.shop.widget.category.a] */
    /* JADX WARN: Type inference failed for: r4v9 */
    /* JADX WARN: Type inference failed for: r6v1, types: [com.bytedance.android.ui.base.widget.tablayout.ECTabLayout$Tab] */
    public final void c(i0 r110) {
        Iterator r100 = r110.f189578k.f189508j.iterator();
        int r101 = 0;
    L3:
        ?? r102 = 0;
        if (r100.hasNext() == false) goto L32;
        Object r103 = r100.next();
        int r104 = r101 + 1;
        if (r101 >= 0) goto L8;
        CollectionsKt.throwIndexOverflow();
    L8:
        WindowProductCategoryVODeprecated.a r105 = (WindowProductCategoryVODeprecated.a) r103;
        ECTabLayout.Tab r106 = newTab();
        r106.setTag(r105.f189512a);
        Unit r107 = Unit.INSTANCE;
        addTab(r106, r101);
        ?? r108 = getTabAt(r101);
        if (r108 == 0) goto L31;
        int r109 = r110.f189577j;
        if ((r105 instanceof WindowProductCategoryVODeprecated.c) == false) goto L21;
        WindowProductCategoryVODeprecated.c r111 = (WindowProductCategoryVODeprecated.c) r105;
        com.bytedance.android.window.shop.widget.category.b r112 = new com.bytedance.android.window.shop.widget.category.b(r111, getContext(), null);
        int r113 = getHeight() - getPaddingTop();
        if (r112.getDp(Integer.valueOf(r111.f189515e.getHeight())) > r113) goto L15;
    L18:
        ViewGroup.LayoutParams r114 = new ViewGroup.LayoutParams(r112.getDp(Integer.valueOf(r111.f189515e.getWidth())), r112.getDp(Integer.valueOf(r111.f189515e.getHeight())));
    L19:
        r112.setLayoutParams(r114);
        r102 = r112;
    L23:
        if (r102 == 0) goto L30;
        if (r101 != r109) goto L29;
        ECTabLayout.Tab r115 = getTabAt(r101);
        if (r115 == null) goto L28;
        r115.select();
    L28:
        r102.u();
        goto L30
    L29:
        r102.w();
    L30:
        r108.setCustomView(r102);
        goto L31
    L15:
        if (r112.getDp(Integer.valueOf(r111.f189515e.getHeight())) <= 0) goto L18;
        if (r113 == 0) goto L18;
        r114 = new ViewGroup.LayoutParams((r112.getDp(Integer.valueOf(r111.f189515e.getWidth())) * r113) / r112.getDp(Integer.valueOf(r111.f189515e.getHeight())), r113);
        goto L19
    L21:
        if ((r105 instanceof WindowProductCategoryVODeprecated.d) == false) goto L23;
        com.bytedance.android.window.shop.widget.category.c r116 = new com.bytedance.android.window.shop.widget.category.c((WindowProductCategoryVODeprecated.d) r105, getContext());
        r116.setLayoutParams(new ViewGroup.LayoutParams(-2, com.bytedance.android.shopping.extensions.b.b(24)));
        r102 = r116;
    L31:
        r101 = r104;
        goto L3
    L32:
        int r117 = getTabCount();
        int r118 = 0;
        int r119 = 0;
    L33:
        if (r118 >= r117) goto L45;
        ECTabLayout.Tab r120 = getTabAt(r118);
        if (r120 == null) goto L37;
        View r121 = r120.getCustomView();
    L38:
        if (r121 == null) goto L40;
        r121.measure(0, 0);
    L40:
        if (r121 == null) goto L42;
        int r122 = r121.getMeasuredWidth();
    L43:
        r119 = r119 + r122;
        r118 = r118 + 1;
        goto L33
    L42:
        r122 = 0;
        goto L43
    L37:
        r121 = null;
        goto L38
    L45:
        if (r119 <= (getScreenWidth() - com.bytedance.android.shopping.extensions.b.b(14))) goto L47;
        setTabMode(0);
        return;
    L47:
        setTabMode(1);
        setTabWidth(this);
    }

    @Override // com.bytedance.android.ui.base.widget.tablayout.ECTabLayout
    public void setSelectedTabIndicatorColor(int r100) {
        super.setSelectedTabIndicatorColor(r100);
    }

    public static final /* synthetic */ void a(ECWindowTabLayout r100, c r101) {
        super.addOnTabSelectedListener(r101);
    }

    public ECWindowTabLayout(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        post(new e(this));
        setSelectedTabIndicator(R.drawable.shopping_shopwindow_tab_indicator);
        setTabRippleColor(null);
        addOnTabSelectedListener(new d());
        this.f189847a = new ArrayList();
        this.f189848b = new LinkedHashMap();
        ResourcesCompat.getColor(getResources(), R.color.ec_shop_tab_indicator_color_start, null);
        this.f189849c = new c(this);
        this.f189850d = new b(this);
    }

    @Override // com.bytedance.android.ui.base.widget.tablayout.ECTabLayout
    public final void addTab(ECTabLayout.Tab r100, int r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "tab");
        super.addTab(r100, r101, r102);
        c r103 = this.f189849c;
        r103.getClass();
        Intrinsics.checkNotNullParameter(r100, "tab");
        ECTabLayout.TabView r104 = r100.view;
        if (r104 == null) goto L7;
        r104.setOnClickListener(new com.bytedance.android.window.shop.widget.a(r103, r100));
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type android.view.View");
    }

    public /* synthetic */ ECWindowTabLayout(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
