package com.bytedance.android.shopping.mall.homepage.card.headercard.components;

import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.ec.hybrid.ECHybridExtensionsKt;
import com.bytedance.android.ec.hybrid.card.event.ECEventCenter;
import com.bytedance.android.shopping.api.mall.common.homepage.card.headercard.model.HeaderCardData;
import com.bytedance.android.shopping.api.mall.common.homepage.card.headercard.model.ToolVO;
import com.bytedance.android.shopping.api.mall.model.SkinConfigStyle;
import com.bytedance.android.shopping.mall.homepage.card.headercard.toolarea.ToolListAdapter;
import com.bytedance.android.shopping.mall.homepage.card.headercard.widget.RCHItemDecoration;
import com.bytedance.android.shopping.mall.homepage.card.headercard.widget.RVIndicator;
import com.bytedance.android.shopping.mall.homepage.card.headercard.widget.RVIndicator$bindRecyclerView$1;
import com.bytedance.android.ui.base.widget.round.BackgroundDrawable;
import com.bytedance.forest.utils.h;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.larus.nova.R;
import java.util.List;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class LegouToolAreaComponent extends ef3.e<HeaderCardData> implements ef3.d {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final RecyclerView f177787d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final RVIndicator f177788e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ToolListAdapter f177789f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final LegouToolAreaComponent$refreshSubscriber$1 f177790g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public e f177791h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final a f177792i;

    public static final class a implements com.bytedance.android.ec.hybrid.card.event.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LegouToolAreaComponent f177793a;

        public a(LegouToolAreaComponent r100) {
            this.f177793a = r100;
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
            ToolListAdapter r105 = this.f177793a.f177789f;
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

    @Override // ef3.c
    public final String getName() {
        return "TOOL_AREA";
    }

    @Override // ef3.e
    public final void c() {
        ECEventCenter.f("ecom_mall_resource_scope_refresh", this.f177790g);
        e r100 = this.f177791h;
        if (r100 == null) goto L5;
        ECEventCenter.f("ec.mallActionOpenOrderDetailSwitchHighlight", r100);
    L5:
        ECEventCenter.f("ecom_mall_mask_tool_highlight", this.f177792i);
    }

    @Override // ef3.e
    public final void d() {
        ECHybridExtensionsKt.f(new LegouToolAreaComponent$themeChanged$1(this));
    }

    public final void e() {
        RecyclerView r100 = this.f177787d;
        if (r100 == null) goto L34;
        ef3.a r101 = this.f472428c;
        Object r102 = null;
        if ((r101 instanceof com.bytedance.android.shopping.mall.homepage.card.headercard.a) == true) goto L7;
        r101 = null;
    L7:
        com.bytedance.android.shopping.mall.homepage.card.headercard.a r103 = (com.bytedance.android.shopping.mall.homepage.card.headercard.a) r101;
        if (r103 == null) goto L35;
        SkinConfigStyle r104 = r103.b();
        if (r104 == null) goto L36;
        SkinConfigStyle.ToolListStyle r105 = r104.getToolListStyle();
        if (r105 == null) goto L37;
        String r106 = r105.getBg_color();
        if (r106 != null) goto L16;
        return;
    L16:
        if (h.a(r106) == true) goto L19;
        r106 = null;
    L19:
        if (r106 == null) goto L39;
        Result.Companion r107 = Result.Companion;     // Catch: Throwable -> L22
        Object r108 = Result.m9449constructorimpl(Integer.valueOf(Color.parseColor(r106)));     // Catch: Throwable -> L22
    L25:
        if (Result.m9455isFailureimpl(r108) == true) goto L28;
        r102 = r108;
    L28:
        Integer r109 = (Integer) r102;
        if (r109 == null) goto L40;
        int r110 = r109.intValue();
        BackgroundDrawable r111 = new BackgroundDrawable(r100.getContext(), null, false, 4, null);
        r111.setBgColor(r110);
        int r112 = com.bytedance.android.ec.hybrid.list.util.c.f47296a;
        r111.setCornerRadius(com.bytedance.android.ec.hybrid.list.util.c.c(12, getContext(), true));
        r111.invalidate();
        Unit r113 = Unit.INSTANCE;
        r100.setBackground(r111);
        return;
    L40:
        return;
    L22:
        th = move-exception;
        Result.Companion r114 = Result.Companion;
        r108 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L25
    L39:
        return;
    L37:
        return;
    L36:
        return;
    L35:
        return;
    }

    @Override // ef3.c
    public final void onCreate() {
        String r100 = this.f472428c.f472425i;
        ECEventCenter.e("ecom_mall_resource_scope_refresh", this.f177790g, r100);
        if (Intrinsics.areEqual(this.f472428c.f472424h.A1.getGlobalProps().get("order_guide_highlight"), "1") == false) goto L5;
        e r101 = new e(this);
        this.f177791h = r101;
        ECEventCenter.e("ec.mallActionOpenOrderDetailSwitchHighlight", r101, r100);
    L5:
        ECEventCenter.e("ecom_mall_mask_tool_highlight", this.f177792i, r100);
        RVIndicator r102 = this.f177788e;
        if (r102 == null) goto L14;
        ViewGroup.LayoutParams r103 = r102.getLayoutParams();
        int r104 = com.bytedance.android.ec.hybrid.list.util.c.f47296a;
        r103.width = com.bytedance.android.ec.hybrid.list.util.c.c(36, getContext(), true);
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
        r102.setIndicatorColor(ColorProtector.parseColor("#FF3344"));
    L14:
        RecyclerView r108 = this.f177787d;
        if (r108 == null) goto L21;
        int r109 = com.bytedance.android.ec.hybrid.list.util.c.f47296a;
        r108.addItemDecoration(new RCHItemDecoration(com.bytedance.android.ec.hybrid.list.util.c.c(1, getContext(), true)));
        RVIndicator r110 = this.f177788e;
        if (r110 == null) goto L19;
        Intrinsics.checkNotNullParameter(r108, "recyclerView");
        r108.addOnScrollListener(new RVIndicator$bindRecyclerView$1(r110));
    L19:
        ToolListAdapter r111 = this.f177789f;
        r111.getClass();
        Intrinsics.checkNotNullParameter(r108, "recyclerView");
        r111.f177828d = r108;
        r108.addOnScrollListener(r111.f177831g);
        r108.setAdapter(this.f177789f);
        LinearLayoutManager r112 = new LinearLayoutManager(r108.getContext());
        r112.setOrientation(0);
        r108.setLayoutManager(r112);
        return;
    }

    public LegouToolAreaComponent(View r100, com.bytedance.android.shopping.mall.homepage.card.headercard.a r101) {
        Intrinsics.checkNotNullParameter(r100, "cardView");
        Intrinsics.checkNotNullParameter(r101, "mallContext");
        super(r100, r101);
        RecyclerView r102 = (RecyclerView) r100.findViewById(R.id.rcv_tool_list);
        ViewGroup.LayoutParams r103 = null;
        if (r102 == null) goto L12;
        ViewGroup.LayoutParams r104 = r102.getLayoutParams();
        if ((r104 instanceof FrameLayout.LayoutParams) == false) goto L8;
        r103 = r104;
    L8:
        FrameLayout.LayoutParams r105 = (FrameLayout.LayoutParams) r103;
        if (r105 == null) goto L11;
        int r106 = com.bytedance.android.ec.hybrid.list.util.c.f47296a;
        r105.bottomMargin = com.bytedance.android.ec.hybrid.list.util.c.c(8, getContext(), true);
    L11:
        r102.setTag("header_tool");
        Unit r107 = Unit.INSTANCE;
    L13:
        this.f177787d = r102;
        this.f177788e = (RVIndicator) r100.findViewById(R.id.fl_tool_list_indicator);
        this.f177789f = new ToolListAdapter(r101);
        this.f177790g = new LegouToolAreaComponent$refreshSubscriber$1(this);
        this.f177792i = new a(this);
        return;
    L12:
        r102 = null;
        goto L13
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // ef3.c
    public final void a(HeaderCardData r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "itemId");
        this.f472427b = r100;
        ToolListAdapter r102 = this.f177789f;
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
        e();
        return;
    L7:
        r105 = null;
        goto L8
    }

    @Override // ef3.d
    public final void b(final String r100, final Function1<? super Boolean, Unit> r101) {
        Intrinsics.checkNotNullParameter(r100, "componentID");
        Intrinsics.checkNotNullParameter(r101, "callback");
        ECHybridExtensionsKt.f(new LegouToolAreaComponent$drawToolItemToCenter$1(this, r100, r101));
    }
}
