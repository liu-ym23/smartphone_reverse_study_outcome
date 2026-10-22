package com.bytedance.android.shopping.mall.homepage.card.headercard.components;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.ec.hybrid.ECHybridExtensionsKt;
import com.bytedance.android.ec.hybrid.card.event.ECEventCenter;
import com.bytedance.android.shopping.api.mall.common.homepage.card.headercard.model.HeaderCardData;
import com.bytedance.android.shopping.api.mall.common.homepage.card.headercard.model.ToolVO;
import com.bytedance.android.shopping.mall.homepage.card.headercard.toolarea.FixedLinearLayoutManager;
import com.bytedance.android.shopping.mall.homepage.card.headercard.toolarea.ToolListAdapter;
import com.bytedance.android.shopping.mall.homepage.card.headercard.widget.RCHItemDecoration;
import com.bytedance.android.shopping.mall.homepage.card.headercard.widget.RVIndicator;
import com.bytedance.android.shopping.mall.homepage.card.headercard.widget.RVIndicator$bindRecyclerView$1;
import com.bytedance.android.ui.base.widget.round.BackgroundDrawable;
import com.bytedance.services.apm.api.EnsureManager;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class ToolAreaComponent extends ef3.e<HeaderCardData> implements ef3.d {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final RecyclerView f177795d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final RVIndicator f177796e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ToolListAdapter f177797f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ToolAreaComponent$refreshSubscriber$1 f177798g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public f f177799h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final a f177800i;

    public static final class a implements com.bytedance.android.ec.hybrid.card.event.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ToolAreaComponent f177801a;

        public a(ToolAreaComponent r100) {
            this.f177801a = r100;
        }

        @Override // com.bytedance.android.ec.hybrid.card.event.e
        public final void a(com.bytedance.android.ec.hybrid.card.event.d r100) {
            Intrinsics.checkNotNullParameter(r100, "jsEvent");
            Map<String, Object> r101 = r100.f46490b;
            Object r102 = null;
            if (r101 == null) goto L5;
            Object r103 = r101.get("show");
        L7:
            if ((r103 instanceof Boolean) == false) goto L10;
            r102 = r103;
        L10:
            Boolean r104 = (Boolean) r102;
            if (r104 == null) goto L16;
            ToolListAdapter r105 = this.f177801a.f177797f;
            boolean r106 = !r104.booleanValue();
            RecyclerView r107 = r105.f177828d;
            if (r107 == null) goto L17;
            r107.post(new com.bytedance.android.shopping.mall.homepage.card.headercard.toolarea.c(r105, r106));
            return;
        L17:
            return;
        L16:
            return;
        L5:
            r103 = null;
            goto L7
        }
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ToolAreaComponent f177802a;

        public b(ToolAreaComponent r100) {
            this.f177802a = r100;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Runnable
        public final void run() {
            HeaderCardData r100 = (HeaderCardData) this.f177802a.f472427b;     // Catch: Throwable -> L20 Exception -> L22
            if (r100 == null) goto L7;
            HeaderCardData.ToolList r101 = r100.getToolList();     // Catch: Throwable -> L20 Exception -> L22
            if (r101 == null) goto L7;
            List<ToolVO> r102 = r101.getData();     // Catch: Throwable -> L20 Exception -> L22
        L8:
            List<ToolVO> r103 = r102;     // Catch: Throwable -> L20 Exception -> L22
            if (r103 != null) goto L11;
        L14:
            boolean r104 = true;
        L15:
            if (r104 == true) goto L27;
            ToolAreaComponent r105 = this.f177802a;     // Catch: Throwable -> L20 Exception -> L22
            if (r105.f472428c.f472421e == true) goto L31;
            r105.f177797f.notifyDataSetChanged();     // Catch: Throwable -> L20 Exception -> L22
        L33:
            return;
        L31:
            return;
        L27:
            return;
        L11:
            if (r103.isEmpty() == true) goto L14;
            r104 = false;
        L7:
            r102 = null;
        L20:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L32;
            throw th;
        L32:
            return;
        L22:
            e = move-exception;
            EnsureManager.ensureNotReachHere(e);     // Catch: Throwable -> L20
        }
    }

    @Override // ef3.c
    public final String getName() {
        return "TOOL_AREA";
    }

    @Override // ef3.e
    public final void c() {
        ECEventCenter.f("ecom_mall_resource_scope_refresh", this.f177798g);
        f r100 = this.f177799h;
        if (r100 == null) goto L5;
        ECEventCenter.f("ec.mallActionOpenOrderDetailSwitchHighlight", r100);
    L5:
        ECEventCenter.f("ecom_mall_mask_tool_highlight", this.f177800i);
    }

    @Override // ef3.e
    public final void d() {
        RecyclerView r100 = this.f177795d;
        if (r100 == null) goto L6;
        r100.post(new b(this));
        return;
    }

    @Override // ef3.c
    public final void onCreate() {
        String r100 = this.f472428c.f472425i;
        ECEventCenter.e("ecom_mall_resource_scope_refresh", this.f177798g, r100);
        if (Intrinsics.areEqual(this.f472428c.f472424h.A1.getGlobalProps().get("order_guide_highlight"), "1") == false) goto L5;
        f r101 = new f(this);
        this.f177799h = r101;
        ECEventCenter.e("ec.mallActionOpenOrderDetailSwitchHighlight", r101, r100);
    L5:
        ECEventCenter.e("ecom_mall_mask_tool_highlight", this.f177800i, r100);
        RVIndicator r102 = this.f177796e;
        if (r102 == null) goto L13;
        ViewGroup.LayoutParams r103 = r102.getLayoutParams();
        int r104 = com.bytedance.android.ec.hybrid.list.util.c.f47296a;
        r103.width = com.bytedance.android.ec.hybrid.list.util.c.c(25, getContext(), true);
        ViewGroup.LayoutParams r105 = r102.getLayoutParams();
        r105.height = com.bytedance.android.ec.hybrid.list.util.c.c(2, getContext(), true);
        ViewGroup.LayoutParams r106 = r102.getLayoutParams();
        if ((r106 instanceof FrameLayout.LayoutParams) == true) goto L10;
        r106 = null;
    L10:
        FrameLayout.LayoutParams r107 = (FrameLayout.LayoutParams) r106;
        if (r107 == null) goto L13;
        r107.bottomMargin = com.bytedance.android.ec.hybrid.list.util.c.c(5, getContext(), true);
    L13:
        RecyclerView r108 = this.f177795d;
        if (r108 == null) goto L20;
        int r109 = com.bytedance.android.ec.hybrid.list.util.c.f47296a;
        r108.addItemDecoration(new RCHItemDecoration(com.bytedance.android.ec.hybrid.list.util.c.c(1, getContext(), true)));
        RVIndicator r110 = this.f177796e;
        if (r110 == null) goto L18;
        Intrinsics.checkNotNullParameter(r108, "recyclerView");
        r108.addOnScrollListener(new RVIndicator$bindRecyclerView$1(r110));
    L18:
        ToolListAdapter r111 = this.f177797f;
        r111.getClass();
        Intrinsics.checkNotNullParameter(r108, "recyclerView");
        r111.f177828d = r108;
        r108.addOnScrollListener(r111.f177831g);
        r108.setAdapter(this.f177797f);
        r108.setLayoutManager(new FixedLinearLayoutManager(r108.getContext()));
        return;
    }

    public ToolAreaComponent(View r110, com.bytedance.android.shopping.mall.homepage.card.headercard.a r111) {
        Intrinsics.checkNotNullParameter(r110, "cardView");
        Intrinsics.checkNotNullParameter(r111, "mallContext");
        super(r110, r111);
        RecyclerView r100 = (RecyclerView) r110.findViewById(R.id.rcv_tool_list);
        ViewGroup.LayoutParams r101 = null;
        if (r100 == null) goto L16;
        BackgroundDrawable r102 = new BackgroundDrawable(r100.getContext(), null, false, 4, null);
        if (Intrinsics.areEqual(r111.f472417a, "order_homepage") == false) goto L7;
        int r103 = ContextCompat.getColor(r100.getContext(), R.color.shopping_home_color_00FFFFFF);
    L8:
        r102.setBgColor(r103);
        int r104 = com.bytedance.android.ec.hybrid.list.util.c.f47296a;
        r102.setCornerRadius(com.bytedance.android.ec.hybrid.list.util.c.c(12, getContext(), true));
        r102.invalidate();
        Unit r105 = Unit.INSTANCE;
        r100.setBackground(r102);
        ViewGroup.LayoutParams r106 = r100.getLayoutParams();
        if ((r106 instanceof FrameLayout.LayoutParams) == false) goto L12;
        r101 = r106;
    L12:
        FrameLayout.LayoutParams r107 = (FrameLayout.LayoutParams) r101;
        if (r107 == null) goto L15;
        r107.bottomMargin = com.bytedance.android.ec.hybrid.list.util.c.c(8, getContext(), true);
    L15:
        r100.setTag("header_tool");
    L17:
        this.f177795d = r100;
        this.f177796e = (RVIndicator) r110.findViewById(R.id.fl_tool_list_indicator);
        this.f177797f = new ToolListAdapter(r111);
        this.f177798g = new ToolAreaComponent$refreshSubscriber$1(this);
        this.f177800i = new a(this);
        return;
    L7:
        r103 = ContextCompat.getColor(r100.getContext(), R.color.shopping_home_color_FFFFFF);
        goto L8
    L16:
        r100 = null;
        goto L17
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // ef3.c
    public final void a(HeaderCardData r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "itemId");
        this.f472427b = r100;
        ToolListAdapter r102 = this.f177797f;
        ToolVO r103 = null;
        if (r100 == 0) goto L7;
        HeaderCardData.ToolList r104 = r100.getToolList();
        if (r104 == null) goto L7;
        List<ToolVO> r105 = r104.getData();
    L8:
        if (r100 == 0) goto L10;
        r103 = r100.getSearchCart();
    L10:
        r102.C2(r105, r103);
        return;
    L7:
        r105 = null;
        goto L8
    }

    @Override // ef3.d
    public final void b(final String r100, final Function1<? super Boolean, Unit> r101) {
        Intrinsics.checkNotNullParameter(r100, "componentID");
        Intrinsics.checkNotNullParameter(r101, "callback");
        ECHybridExtensionsKt.f(new ToolAreaComponent$drawToolItemToCenter$1(this, r100, r101));
    }
}
