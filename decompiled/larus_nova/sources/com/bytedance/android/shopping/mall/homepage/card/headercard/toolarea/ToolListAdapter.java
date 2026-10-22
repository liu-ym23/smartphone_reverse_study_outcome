package com.bytedance.android.shopping.mall.homepage.card.headercard.toolarea;

import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.ec.hybrid.ECHybridExtensionsKt;
import com.bytedance.android.ec.hybrid.hostapi.IHybridHostService;
import com.bytedance.android.ec.hybrid.log.mall.ECMallLogUtil;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.android.shopping.api.mall.common.homepage.card.headercard.model.CornerType;
import com.bytedance.android.shopping.api.mall.common.homepage.card.headercard.model.ToolVO;
import com.bytedance.android.shopping.api.mall.common.tools.b0;
import com.bytedance.android.shopping.api.mall.common.tools.p;
import com.bytedance.android.shopping.mall.feed.ECMallFeed;
import com.bytedance.android.shopping.mall.homepage.card.headercard.widget.BadgeView;
import com.bytedance.android.shopping.mall.homepage.tools.d0;
import com.bytedance.services.apm.api.EnsureManager;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;
import java.lang.reflect.Type;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004:\u0001\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/shopping/mall/homepage/card/headercard/toolarea/ToolListAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lcom/bytedance/android/shopping/api/mall/common/homepage/card/headercard/model/ToolVO;", "Lcom/bytedance/android/shopping/mall/homepage/card/headercard/toolarea/ToolViewHolder;", "Lef3/b;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "mall_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ToolListAdapter extends ListAdapter<ToolVO, ToolViewHolder> implements ef3.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.bytedance.android.shopping.mall.homepage.card.headercard.toolarea.a f177825a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final h f177826b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public List<ToolVO> f177827c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public RecyclerView f177828d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f177829e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f177830f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ToolListAdapter$scroller$1 f177831g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Function0<Boolean> f177832h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final com.bytedance.android.shopping.mall.homepage.card.headercard.a f177833i;

    public static final class a {
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ RecyclerView f177834a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ToolListAdapter f177835b;

        public b(RecyclerView r100, ToolListAdapter r101) {
            this.f177834a = r100;
            this.f177835b = r101;
        }

        public final void a() {
            ToolListAdapter r100 = this.f177835b;
            if (r100.f177830f == false) goto L18;
            com.bytedance.android.shopping.mall.homepage.card.headercard.a r101 = r100.f177833i;
            if (r101.f472421e == false) goto L7;
            return;
        L7:
            if (r101.f472422f == false) goto L24;
            Map<String, Object> r102 = r101.f472424h.A1.getGlobalProps();
            int r103 = 0;
        L11:
            if (r103 >= 5) goto L25;
            ToolVO r104 = r100.A2(r103);
            ECMallFeed r105 = r100.f177833i.f472424h;
            if (r104 == null) goto L16;
            String r106 = r104.getComponentId();
            if (r106 == null) goto L16;
        L17:
            r105.V(r106);
            Single.fromCallable(new e(r100, r103, r104, r102)).subscribeOn(Schedulers.single()).subscribe();
            r103 = r103 + 1;
        L16:
            r106 = "";
            goto L17
        L25:
            return;
        L24:
            return;
        L18:
            ToolListAdapter.y2(r100, this.f177834a);
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

    @Override // ef3.b
    public final void onRelease() {
    }

    @Override // ef3.b
    public final void p() {
    }

    /* JADX WARN: Type inference failed for: r0v14, types: [com.bytedance.android.shopping.mall.homepage.card.headercard.toolarea.ToolListAdapter$scroller$1] */
    /* JADX WARN: Type inference failed for: r3v3, types: [T, com.bytedance.android.shopping.mall.homepage.card.headercard.toolarea.ToolListAdapter$$special$$inlined$call$lambda$1] */
    public ToolListAdapter(com.bytedance.android.shopping.mall.homepage.card.headercard.a r100) {
        Intrinsics.checkNotNullParameter(r100, "mallContext");
        super(new ToolDiffCallback());
        this.f177833i = r100;
        this.f177825a = new com.bytedance.android.shopping.mall.homepage.card.headercard.toolarea.a(r100);
        this.f177826b = new h(r100);
        Intrinsics.checkNotNullParameter(72, "dp");
        int r101 = com.bytedance.android.ec.hybrid.list.util.c.f47296a;
        this.f177829e = com.bytedance.android.ec.hybrid.list.util.c.c(72, r100.getContext(), true);
        int r102 = s93.c.f541066a;
        Object r103 = 1;
        IHybridHostService r104 = com.bytedance.android.ec.hybrid.a.h();
        if (r104 == null) goto L10;
        yj.g r105 = r104.getHostAB();
        if (r105 == null) goto L10;
        Object r106 = r105.a("ec_mall_tool_list_report_by_item_size", r103);
        if (r106 == null) goto L10;
        r103 = r106;
    L10:
        Lazy r107 = ECMallLogUtil.f47441a;
        ECMallLogUtil.c(com.bytedance.android.ec.hybrid.log.mall.c.a.f47463b, "Key : ec_mall_tool_list_report_by_item_size, Value: " + r103);
        if (((Number) r103).intValue() != 1) goto L13;
        boolean r108 = true;
    L14:
        this.f177830f = r108;
        this.f177831g = new ToolListAdapter$scroller$1(this);
        kjc.c r109 = new kjc.c();
        if (5 != kjc.a.a()) goto L18;
        r109.f503730a.f503729a = new ToolListAdapter$$special$$inlined$call$lambda$1(this);
        r109.f503731b = true;
    L18:
        if (r109.f503731b == true) goto L20;
        r109.f503730a.f503729a = null;
    L20:
        this.f177832h = (Function0) r109.f503730a.f503729a;
        r100.a(this);
        return;
    L13:
        r108 = false;
        goto L14
    }

    public final ToolVO A2(int r100) {
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L8
        if (r100 < getItemCount()) goto L6;
        return null;
    L6:
        return (ToolVO) super.getItem(r100);
    L8:
        th = move-exception;
        Result.Companion r102 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        return null;
    }

    @Override // ef3.b
    public final void N2(View r100) {
        Intrinsics.checkNotNullParameter(r100, "cardView");
        Intrinsics.checkNotNullParameter(r100, "cardView");
    }

    @Override // androidx.recyclerview.widget.ListAdapter
    public final /* bridge */ /* synthetic */ ToolVO getItem(int r100) {
        return A2(r100);
    }

    public static final void y2(ToolListAdapter r100, RecyclerView r101) {
        com.bytedance.android.shopping.mall.homepage.card.headercard.a r102 = r100.f177833i;
        if (r102.f472421e == false) goto L5;
        return;
    L5:
        if (r102.f472422f == false) goto L43;
        Map<String, Object> r103 = r102.f472424h.A1.getGlobalProps();
        RecyclerView.LayoutManager r104 = r101.getLayoutManager();
        if ((r104 instanceof LinearLayoutManager) == true) goto L10;
        r104 = null;
    L10:
        LinearLayoutManager r105 = (LinearLayoutManager) r104;
        if (r105 == null) goto L40;
        int r106 = r105.findFirstVisibleItemPosition();
        int r107 = r105.findLastVisibleItemPosition();
        if (r106 < 0) goto L41;
        if (r107 < 0) goto L42;
        int r108 = r107 + 1;
    L16:
        if (r106 >= r108) goto L44;
        RecyclerView.ViewHolder r109 = r101.findViewHolderForAdapterPosition(r106);
        RecyclerView r110 = r100.f177828d;
        if (r110 == null) goto L27;
        int r111 = r110.getWidth();
        if (r109 == null) goto L27;
        int r112 = r109.itemView.getLeft();
        int r113 = r109.itemView.getRight();
        if ((r113 - r112) <= 0) goto L27;
        if (r113 <= 0) goto L27;
        if (r112 >= r111) goto L27;
        boolean r114 = true;
    L28:
        if (r114 == false) goto L35;
        ToolVO r115 = r100.A2(r106);
        ECMallFeed r116 = r100.f177833i.f472424h;
        if (r115 == null) goto L33;
        String r117 = r115.getComponentId();
        if (r117 == null) goto L33;
    L34:
        r116.V(r117);
        Single.fromCallable(new g(r106, r115, r100, r103)).subscribeOn(Schedulers.single()).subscribe();
    L33:
        r117 = "";
    L35:
        r106 = r106 + 1;
    L27:
        r114 = false;
        goto L28
    L44:
        return;
    L42:
        return;
    L41:
        return;
    L40:
        return;
    }

    public final void B2(String r100, Function1<? super Boolean, Unit> r101) {
        Intrinsics.checkNotNullParameter(r100, "componentID");
        Intrinsics.checkNotNullParameter(r101, "callback");
        RecyclerView r102 = this.f177828d;     // Catch: Exception -> L33
        Integer r103 = null;
        if (r102 == null) goto L6;
        RecyclerView.LayoutManager r104 = r102.getLayoutManager();     // Catch: Exception -> L33
    L8:
        if ((r104 instanceof LinearLayoutManager) == true) goto L11;
        r101.invoke(Boolean.FALSE);     // Catch: Exception -> L33
        return;
    L11:
        List<ToolVO> r105 = this.f177827c;     // Catch: Exception -> L33
        if (r105 == null) goto L26;
        Iterator<ToolVO> r106 = r105.iterator();     // Catch: Exception -> L33
        int r107 = 0;
    L15:
        if (r106.hasNext() == false) goto L24;
        ToolVO r108 = r106.next();     // Catch: Exception -> L33
        if (r108 == null) goto L19;
        String r109 = r108.getComponentId();     // Catch: Exception -> L33
    L21:
        if (Intrinsics.areEqual(r109, r100) == true) goto L25;
        r107 = r107 + 1;     // Catch: Exception -> L33
    L25:
        r103 = Integer.valueOf(r107);     // Catch: Exception -> L33
        goto L26
    L19:
        r109 = null;
        goto L21
    L24:
        r107 = -1;
    L26:
        if (r103 != null) goto L28;
    L31:
        r101.invoke(Boolean.FALSE);     // Catch: Exception -> L33
        return;
    L28:
        if (r103.intValue() < 0) goto L31;
        ((LinearLayoutManager) r104).scrollToPositionWithOffset(r103.intValue(), 0);     // Catch: Exception -> L33
        r101.invoke(Boolean.TRUE);     // Catch: Exception -> L33
        return;
    L6:
        r104 = null;
    L33:
        e = move-exception;
        EnsureManager.ensureNotReachHere(e);
        r101.invoke(Boolean.FALSE);
    }

    public final void C2(final List<ToolVO> r100, final ToolVO r101) {
        ECHybridExtensionsKt.f(new ToolListAdapter$setToolItemList$1(this, r100, r101));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v53, types: [T, java.lang.Boolean] */
    /* JADX WARN: Type inference failed for: r4v10, types: [T, java.lang.Boolean] */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r110) {
        ToolViewHolder r101 = (ToolViewHolder) r100;
        Intrinsics.checkNotNullParameter(r101, "holder");
        ToolVO r111 = A2(r110);
        if (r111 == null) goto L88;
        r101.itemView.setVisibility(0);
        r101.f177848e = r111;
        r101.f177849f.setTag(r111.getName());
        r101.f177849f.getAnchorView().setTag("tool-list-anchor-" + r101.getAdapterPosition());
        r101.f177849f.getAnchorViewRight().setTag("tool-list-anchor-" + r101.getAdapterPosition() + "-right");
        r101.f177849f.getAnchorViewLeft().setTag("tool-list-anchor-" + r101.getAdapterPosition() + "-left");
        r101.f177849f.getAnchorViewBottomLeft().setTag("tool-list-anchor-bottom-left-" + r101.getAdapterPosition());
        String r102 = r111.getDarkIcon();
        if (r102 == null) goto L9;
        d0.c(r101.f177845b, r102, r101.f177850g.f177572k);
    L9:
        String r103 = r111.getTitle();
        if (r103 != null) goto L12;
    L15:
        boolean r104 = true;
    L16:
        if (r104 == true) goto L18;
        r101.f177846c.setText(r111.getTitle());
    L18:
        ToolVO.Corner r105 = r111.getCorner();
        kjc.c r106 = new kjc.c();
        String r107 = null;
        if (5 != kjc.a.a()) goto L26;
        kjc.b<T> r108 = r106.f503730a;
        Map<String, String> r112 = r111.getCornerExtra();
        if (r112 == null) goto L23;
        String r113 = b0.h(r112, "open_corner_animation", "0");
    L24:
        r108.f503729a = Boolean.valueOf(Intrinsics.areEqual(r113, "1"));
        r106.f503731b = true;
        goto L26
    L23:
        r113 = null;
    L26:
        if (r106.f503731b == true) goto L28;
        r106.f503730a.f503729a = Boolean.FALSE;
    L28:
        r101.f177847d.f177921c = ((Boolean) r106.f503730a.f503729a).booleanValue();
        if (r105 == null) goto L31;
        String r114 = r105.getType();
    L33:
        if (Intrinsics.areEqual(r114, CornerType.TEXT.getValue()) == true) goto L35;
    L75:
        if (r105 == null) goto L78;
        r107 = r105.getType();
    L78:
        if (Intrinsics.areEqual(r107, CornerType.DOT.getValue()) == true) goto L80;
    L82:
        r101.f177847d.y();
        return;
    L80:
        if (r105.getCanShow() == false) goto L82;
        r101.f177847d.setMode(1);
        int r115 = com.bytedance.android.ec.hybrid.list.util.c.f47296a;
        int r116 = com.bytedance.android.ec.hybrid.list.util.c.c(30, r101.f177844a, true);
        int r109 = com.bytedance.android.ec.hybrid.list.util.c.c(1, r101.f177844a, true);
        r101.f177847d.setTranslationX(r116);
        r101.f177847d.setTranslationY(r109);
        r101.f177847d.setBadgeColor(ContextCompat.getColor(r101.f177844a, R.color.shopping_home_color_FF3344));
        r101.f177847d.B();
        return;
    L35:
        if (r105.getCanShow() == false) goto L75;
        String r117 = r105.getText();
        if (r117 == null) goto L39;
        Integer r118 = StringsKt.toIntOrNull(r117);
    L41:
        if (r118 != null) goto L43;
    L49:
        String r119 = r105.getText();
        if (r119 != null) goto L52;
    L55:
        boolean r120 = true;
    L56:
        if (r120 == true) goto L74;
        r101.f177847d.setMode(3);
        String r121 = r105.getText();
        if (r121 == null) goto L60;
        int r122 = r121.length();
    L61:
        if (r122 < 3) goto L63;
        int r123 = com.bytedance.android.ec.hybrid.list.util.c.f47296a;
        int r124 = com.bytedance.android.ec.hybrid.list.util.c.c(17, r101.f177844a, true);
    L64:
        String r125 = r105.getText();
        if (r125 == null) goto L67;
        int r126 = r125.length();
    L69:
        if (r126 <= 6) goto L73;
        if (r125 == null) goto L72;
        r107 = r125.substring(0, 6);
    L72:
        r125 = r107;
    L73:
        r101.f177847d.setText(r125);
        r101.f177847d.setTranslationX(r124);
        r101.f177847d.setTranslationY(0.0f);
        r101.T3();
        r101.f177847d.B();
        return;
    L67:
        r126 = 0;
        goto L69
    L63:
        int r127 = com.bytedance.android.ec.hybrid.list.util.c.f47296a;
        r124 = com.bytedance.android.ec.hybrid.list.util.c.c(27, r101.f177844a, true);
        goto L64
    L60:
        r122 = 0;
        goto L61
    L74:
        r101.f177847d.y();
        return;
    L52:
        if (r119.length() == 0) goto L55;
        r120 = false;
        goto L56
    L43:
        if (r118.intValue() <= 0) goto L49;
        if (r118.intValue() <= 99) goto L47;
        int r128 = com.bytedance.android.ec.hybrid.list.util.c.f47296a;
        int r129 = com.bytedance.android.ec.hybrid.list.util.c.c(17, r101.f177844a, true);
    L48:
        r101.f177847d.setTranslationX(r129);
        r101.f177847d.setTranslationY(0.0f);
        r101.T3();
        BadgeView r130 = r101.f177847d;
        int r131 = r118.intValue();
        r130.setMode(2);
        r130.setCount(r131);
        r130.setVisibility(0);
        return;
    L47:
        int r132 = com.bytedance.android.ec.hybrid.list.util.c.f47296a;
        r129 = com.bytedance.android.ec.hybrid.list.util.c.c(27, r101.f177844a, true);
        goto L48
    L39:
        r118 = null;
        goto L41
    L31:
        r114 = null;
        goto L33
    L12:
        if (r103.length() == 0) goto L15;
        r104 = false;
        goto L16
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        int r102 = ToolViewHolder.f177843j;
        com.bytedance.android.shopping.mall.homepage.card.headercard.a r103 = this.f177833i;
        h r104 = this.f177826b;
        Function0<Boolean> r105 = this.f177832h;
        Intrinsics.checkNotNullParameter(r100, KtvSubElement.CONTAINER);
        Intrinsics.checkNotNullParameter(r103, "mallContext");
        Intrinsics.checkNotNullParameter(r104, "toolReporter");
        AttributeSet r106 = null;
        return new ToolViewHolder(new ToolItemView(r100.getContext(), r106, 6, 0), r103, r104, r105);
    }

    public static final void z2(final ToolListAdapter r100, final List r101, final ToolVO r102) {
        r100.getClass();
        List r103 = r101;
        boolean r104 = false;
        if (r103 != null) goto L5;
    L8:
        boolean r105 = true;
    L9:
        if (r105 == false) goto L24;
        List<ToolVO> r106 = r100.f177827c;
        if (r106 != null) goto L14;
    L17:
        boolean r107 = true;
    L18:
        if (r107 == true) goto L33;
        r101 = r100.f177827c;
        goto L24
    L33:
        r101 = (List) p.b().fromJson("[{\"name\":\"tool_order\",\"title\":\"我的订单\",\"subtitle\":\"\",\"icon\":\"\",\"light_icon\":\"https://p3-ecop-imagex.byteimg.com/tos-cn-i-5bio2hw93e/7b5e67848ba94584948a8af77c86ea82~tplv-5bio2hw93e-origin.png\",\"link\":\"sslocal://webcast_lynxview?type=fullscreen&hide_nav_bar=1&enable_pad_adapter=1&screen_size_adaptation=1&trans_status_bar=1&web_bg_color=ffffff&status_bar_color=black&url=https%3A%2F%2Flf-webcast-sourcecdn-tos.bytegecko.com%2Fobj%2Fbyte-gurd-source%2Fwebcast%2Ffalcon%2Fdouyin%2Fecommerce_orders_douyin%2Fapp_new%2Ftemplate.js%3Fenter_from%3Dmall_homepage_request%26tab_id%3D0&enter_from=mall_homepage_request&show_small_window=&api_migration_gray=1\",\"tip\":{\"type\":0,\"data\":\"\",\"style\":0},\"location\":0,\"dark_icon\":\"https://p3-ecop-imagex.byteimg.com/tos-cn-i-5bio2hw93e/6b0355f9df4b4d76b5344762976adf7f~tplv-5bio2hw93e-origin.png\",\"create_time\":1684218631,\"card_type\":0,\"resource_id\":\"79984\",\"fgUrl\":\"\",\"extra\":\"\",\"bg_url_1\":\"\",\"tag_url\":\"\",\"tag_url_1\":\"\",\"module_id\":\"tool_list\",\"component_id\":\"2\",\"data\":{\"items\":[],\"extra\":{}},\"activity_tab_id\":\"\",\"text_list\":[],\"tag_url_2\":\"\",\"bg_url_2\":\"\",\"end_time\":1730390399,\"bcm\":{\"bcm_em_id\":\"\",\"bcm_em\":\"\"}},{\"name\":\"tool_charge\",\"title\":\"手机充值\",\"subtitle\":\"\",\"icon\":\"\",\"light_icon\":\"https://p3-ecop-imagex.byteimg.com/tos-cn-i-5bio2hw93e/9ed2e11909434a2cb46a4ab687930a35~tplv-5bio2hw93e-origin.png\",\"link\":\"sslocal://webcast_lynxview?type=fullscreen&url=https%3A%2F%2Flf-webcast-sourcecdn-tos.bytegecko.com%2Fobj%2Fbyte-gurd-source%2F10181%2Fgecko%2Fresource%2Fecom_fxg_life_lynx%2Fpages%2Fphone%2Ftemplate.js&hide_nav_bar=1&trans_status_bar=1&status_bar_color=white&source=recharge_xtab_homepage&web_bg_color=ffffff\",\"tip\":{\"type\":0,\"data\":\"\",\"style\":0},\"location\":0,\"dark_icon\":\"https://p3-ecop-imagex.byteimg.com/tos-cn-i-5bio2hw93e/161fadf571174022aff7f86f604810df~tplv-5bio2hw93e-origin.png\",\"create_time\":1698292286,\"card_type\":0,\"resource_id\":\"96065\",\"fgUrl\":\"\",\"extra\":\"\",\"bg_url_1\":\"\",\"tag_url\":\"\",\"tag_url_1\":\"\",\"module_id\":\"tool_list\",\"component_id\":\"17\",\"data\":{\"items\":[],\"extra\":{}},\"activity_tab_id\":\"\",\"text_list\":[],\"tag_url_2\":\"\",\"bg_url_2\":\"\",\"end_time\":1822838399,\"bcm\":{\"bcm_em_id\":\"\",\"bcm_em\":\"\"}},{\"name\":\"tool_customer_msg\",\"title\":\"客服消息\",\"subtitle\":\"\",\"icon\":\"\",\"light_icon\":\"https://p3-ecop-imagex.byteimg.com/tos-cn-i-5bio2hw93e/6f7be98067c348f99613f249d3790b3f~tplv-5bio2hw93e-origin.png\",\"link\":\"aweme://ecomcs_im/message_list?origin_enter_from=mall\",\"tip\":{\"type\":0,\"data\":\"\",\"style\":0},\"location\":0,\"dark_icon\":\"https://p3-ecop-imagex.byteimg.com/tos-cn-i-5bio2hw93e/f7044bb307b44ea2b61cfbde16b5bce7~tplv-5bio2hw93e-origin.png\",\"create_time\":1690461716,\"card_type\":0,\"resource_id\":\"87378\",\"fgUrl\":\"\",\"extra\":\"\",\"bg_url_1\":\"\",\"tag_url\":\"\",\"tag_url_1\":\"\",\"module_id\":\"tool_list\",\"component_id\":\"5\",\"data\":{\"items\":[],\"extra\":{}},\"activity_tab_id\":\"\",\"text_list\":[],\"tag_url_2\":\"\",\"bg_url_2\":\"\",\"end_time\":1730390399,\"bcm\":{\"bcm_em_id\":\"\",\"bcm_em\":\"\"}},{\"name\":\"tool_following_shop\",\"title\":\"关注店铺\",\"subtitle\":\"\",\"icon\":\"\",\"light_icon\":\"https://p3-ecop-imagex.byteimg.com/tos-cn-i-5bio2hw93e/4de1ad1e4c844845bb652325bb6e6deb~tplv-5bio2hw93e-origin.png\",\"link\":\"sslocal://webcast_lynxview?url=https%3A%2F%2Flf-webcast-sourcecdn-tos.bytegecko.com%2Fobj%2Fbyte-gurd-source%2F10181%2Fgecko%2Fresource%2Fecommerce_shop_subpage_dynamic%2Fapp%2Ffollowed_shop%2Ftemplate.js&status_bar_color=black&hide_nav_bar=1&add_safe_area_height=0&trans_status_bar=1&web_bg_color=%23ffffffff&top_level=1&window_floating=0&use_real_screen_height=1&enable_latch=1&entrance_location=101&enable_pad_adapter=1&screen_size_adaptation=1&initialProps=%5B%22storage%3AFOLLOW_SHOP_FULL_MODE%22%2C%22current_user%22%5D\",\"tip\":{\"type\":0,\"data\":\"\",\"style\":0},\"location\":0,\"dark_icon\":\"https://p3-ecop-imagex.byteimg.com/tos-cn-i-5bio2hw93e/473cdbc0519b4260bfcc23205a8a9237~tplv-5bio2hw93e-origin.png\",\"create_time\":1695801835,\"card_type\":0,\"resource_id\":\"93464\",\"fgUrl\":\"\",\"extra\":\"\",\"bg_url_1\":\"\",\"tag_url\":\"\",\"tag_url_1\":\"\",\"module_id\":\"tool_list\",\"component_id\":\"28\",\"data\":{\"items\":[],\"extra\":{}},\"activity_tab_id\":\"\",\"text_list\":[],\"tag_url_2\":\"\",\"bg_url_2\":\"\",\"end_time\":1793375999,\"bcm\":{\"bcm_em_id\":\"\",\"bcm_em\":\"\"}},{\"name\":\"tool_try\",\"title\":\"试用领取\",\"subtitle\":\"\",\"icon\":\"\",\"light_icon\":\"https://p3-ecop-imagex.byteimg.com/tos-cn-i-5bio2hw93e/3909ae3e8d154db18f37cd518dcb3ba0~tplv-5bio2hw93e-origin.png\",\"link\":\"sslocal://webcast_lynxview?enable_latch=1&hide_nav_bar=1&hide_status_bar=0&inject_config_channel=ecommerce_brand_new_product_trial_aweme&retention=0&status_bar_color=black&top_level=1&trans_status_bar=1&type=fullscreen&url=https%3A%2F%2Flf-webcast-sourcecdn-tos.bytegecko.com%2Fobj%2Fbyte-gurd-source%2F10181%2Fgecko%2Fresource%2Fecommerce_brand_new_product_trial_aweme%2Fhome%2Ftemplate.js&web_bg_color=%23ffffffff&title_type=1&channel_scene=brand_try_introduce_home_tool\",\"tip\":{\"type\":0,\"data\":\"\",\"style\":0},\"location\":0,\"dark_icon\":\"https://p3-ecop-imagex.byteimg.com/tos-cn-i-5bio2hw93e/581947ff209d426ca0c6a4064234f83d~tplv-5bio2hw93e-origin.png\",\"create_time\":1697684469,\"card_type\":0,\"resource_id\":\"94941\",\"fgUrl\":\"\",\"extra\":\"\",\"bg_url_1\":\"\",\"tag_url\":\"\",\"tag_url_1\":\"\",\"module_id\":\"tool_list\",\"component_id\":\"29\",\"data\":{\"items\":[],\"extra\":{}},\"activity_tab_id\":\"\",\"text_list\":[],\"tag_url_2\":\"\",\"bg_url_2\":\"\",\"end_time\":1917705599,\"bcm\":{\"bcm_em_id\":\"\",\"bcm_em\":\"\"}},{\"name\":\"tool_fav\",\"title\":\"收藏\",\"subtitle\":\"\",\"icon\":\"\",\"light_icon\":\"https://p3-ecop-imagex.byteimg.com/tos-cn-i-5bio2hw93e/e9db5ba83a734940ba9976227f92324e~tplv-5bio2hw93e-origin.png\",\"link\":\"aweme://favorite?tab_name=goods&type=6\",\"tip\":{\"type\":0,\"data\":\"33\",\"style\":0},\"location\":0,\"dark_icon\":\"https://p3-ecop-imagex.byteimg.com/tos-cn-i-5bio2hw93e/4a0096f64c4d4e9ea95d3b42e7dd8701~tplv-5bio2hw93e-origin.png\",\"create_time\":1684218596,\"card_type\":0,\"resource_id\":\"79982\",\"fgUrl\":\"\",\"extra\":\"\",\"bg_url_1\":\"\",\"tag_url\":\"\",\"tag_url_1\":\"\",\"module_id\":\"tool_list\",\"component_id\":\"9\",\"data\":{\"items\":[],\"extra\":{}},\"activity_tab_id\":\"\",\"text_list\":[],\"tag_url_2\":\"\",\"bg_url_2\":\"\",\"end_time\":1793289599,\"bcm\":{\"bcm_em_id\":\"\",\"bcm_em\":\"\"}},{\"name\":\"tool_comment\",\"title\":\"评价中心\",\"subtitle\":\"\",\"icon\":\"\",\"light_icon\":\"https://p3-ecop-imagex.byteimg.com/tos-cn-i-5bio2hw93e/e966578a920046bdaf5081543f589916~tplv-5bio2hw93e-origin.png\",\"link\":\"sslocal://webcast_lynxview?type=fullscreen&url=https%3A%2F%2Flf-webcast-sourcecdn-tos.bytegecko.com%2Fobj%2Fbyte-gurd-source%2F10181%2Fgecko%2Fresource%2Fecommerce_evaluation_aweme%2Flist%2Ftemplate.js%3Fenter_from%3Dcenter%26tab_id%3D&hide_nav_bar=1&hide_status_bar=0&status_bar_bg_color=white&load_taro=0&status_bar_color=black&trans_status_bar=1&enable_pad_adapter=1&container_bg_color=ffffff&screen_size_adaptation=1\",\"tip\":{\"type\":0,\"data\":\"1\",\"style\":0},\"location\":0,\"dark_icon\":\"https://p3-ecop-imagex.byteimg.com/tos-cn-i-5bio2hw93e/ee801bb102a740fbae7e9c10ad34f19d~tplv-5bio2hw93e-origin.png\",\"create_time\":1694506683,\"card_type\":0,\"resource_id\":\"91383\",\"fgUrl\":\"\",\"extra\":\"\",\"bg_url_1\":\"\",\"tag_url\":\"\",\"tag_url_1\":\"\",\"module_id\":\"tool_list\",\"component_id\":\"3\",\"data\":{\"items\":[],\"extra\":{}},\"activity_tab_id\":\"\",\"text_list\":[],\"tag_url_2\":\"\",\"bg_url_2\":\"\",\"end_time\":1793375999,\"bcm\":{\"bcm_em_id\":\"\",\"bcm_em\":\"\"}},{\"name\":\"tool_coupon_notip\",\"title\":\"券红包\",\"subtitle\":\"\",\"icon\":\"\",\"light_icon\":\"https://p3-ecop-imagex.byteimg.com/tos-cn-i-5bio2hw93e/374cb285898643ad85a5fc6c5d709c9f~tplv-5bio2hw93e-origin.png\",\"link\":\"sslocal://webcast_webview?type=fullscreen&url=https%3A%2F%2Flf-webcast-sourcecdn-tos.bytegecko.com%2Fobj%2Fbyte-gurd-source%2F10181%2Fgecko%2Fresource%2Fecom_fe_promotion_coupon_centre_aweme%2Fhtml%2Fpages%2Fhome%2Findex.html%3Ftab%3Dcoupon%26enter_from%3Dorder_center&hide_nav_bar=1&hide_status_bar=0&trans_status_bar=1&use_wk_falcon=1&status_bar_color=black&web_bg_color=ffffff\",\"tip\":{\"type\":0,\"data\":\"\",\"style\":0},\"location\":0,\"dark_icon\":\"https://p3-ecop-imagex.byteimg.com/tos-cn-i-5bio2hw93e/6f5ebc1f71784ecdb9caf25e2dc41a8a~tplv-5bio2hw93e-origin.png\",\"create_time\":1684218499,\"card_type\":0,\"resource_id\":\"79981\",\"fgUrl\":\"\",\"extra\":\"\",\"bg_url_1\":\"\",\"tag_url\":\"\",\"tag_url_1\":\"\",\"module_id\":\"tool_list\",\"component_id\":\"6\",\"data\":{\"items\":[],\"extra\":{}},\"activity_tab_id\":\"\",\"text_list\":[],\"tag_url_2\":\"\",\"bg_url_2\":\"\",\"end_time\":1730390399,\"bcm\":{\"bcm_em_id\":\"\",\"bcm_em\":\"\"}},{\"name\":\"tool_cpay\",\"title\":\"抖音月付\",\"subtitle\":\"\",\"icon\":\"\",\"light_icon\":\"https://p3-ecop-imagex.byteimg.com/tos-cn-i-5bio2hw93e/43643daa62a240709ae9f6ffb364abc2~tplv-5bio2hw93e-origin.png\",\"link\":\"sslocal://cjpay?canvas_mode=1&url=https%3A%2F%2Ff-cpay.snssdk.com%2Ffeoffline%2Fcpay%2Frouter.html%3Fcanvas_mode%3D1%26cpsource%3Ddyds_order_center_new\",\"tip\":{\"type\":0,\"data\":\"\",\"style\":0},\"location\":0,\"dark_icon\":\"https://p3-ecop-imagex.byteimg.com/tos-cn-i-5bio2hw93e/4caf7e97b3c044779889d1e9fa8ed56e~tplv-5bio2hw93e-origin.png\",\"create_time\":1684217986,\"card_type\":0,\"resource_id\":\"79972\",\"fgUrl\":\"\",\"extra\":\"\",\"bg_url_1\":\"\",\"tag_url\":\"\",\"tag_url_1\":\"\",\"module_id\":\"tool_list\",\"component_id\":\"10\",\"data\":{\"items\":[],\"extra\":{}},\"activity_tab_id\":\"\",\"text_list\":[],\"tag_url_2\":\"\",\"bg_url_2\":\"\",\"end_time\":1730390399,\"bcm\":{\"bcm_em_id\":\"\",\"bcm_em\":\"\"}}]", b0.getType(List.class, new Type[]{ToolVO.class}));     // Catch: Exception -> L22
    L22:
        e = move-exception;
        EnsureManager.ensureNotReachHere(e);
        r101 = null;
        goto L24
    L14:
        if (r106.isEmpty() == true) goto L17;
        r107 = false;
    L24:
        List r108 = r101;
        if (r108 != null) goto L27;
    L28:
        r104 = true;
    L29:
        if (r104 == true) goto L35;
        r100.f177827c = r101;
        kk.d.c(new ToolListAdapter$setToolItemListInner$1(r100, r101, r102));
        r100.submitList(r101);
        return;
    L35:
        return;
    L27:
        if (r108.isEmpty() == false) goto L29;
    L5:
        if (r103.isEmpty() == true) goto L8;
        r105 = false;
        goto L9
    }

    @Override // ef3.b
    public final void Q0(boolean r100, Boolean r101, boolean r102) {
        if (r100 == true) goto L4;
        return;
    L4:
        if (Intrinsics.areEqual(r101, Boolean.FALSE) == false) goto L11;
        if (r102 == false) goto L12;
        RecyclerView r103 = this.f177828d;
        if (r103 == null) goto L13;
        r103.post(new b(r103, this));
        return;
    L13:
        return;
    L12:
        return;
    }
}
