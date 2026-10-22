package com.bytedance.android.shopping.mall.homepage.card.headercard.channel.cardview.legou.pits41;

import android.content.Context;
import android.graphics.Outline;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.android.shopping.api.mall.common.homepage.card.headercard.model.ChannelVO;
import com.bytedance.android.shopping.api.mall.common.homepage.card.headercard.model.ECCommonCard;
import com.bytedance.android.shopping.api.mall.common.homepage.card.headercard.model.ECProductStruct;
import com.bytedance.android.shopping.api.mall.common.homepage.card.headercard.model.PriceStruct;
import com.bytedance.android.shopping.mall.feed.ECMallFeed;
import com.bytedance.android.shopping.mall.homepage.card.headercard.util.BtmPositionResult;
import com.bytedance.android.shopping.mall.homepage.card.headercard.util.UtilsKt;
import com.bytedance.android.shopping.mall.homepage.card.headercard.util.e;
import com.bytedance.android.shopping.mall.homepage.card.headercard.util.f;
import com.bytedance.android.shopping.mall.homepage.tools.d0;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\fB'\b\u0007\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002¨\u0006\r"}, d2 = {"Lcom/bytedance/android/shopping/mall/homepage/card/headercard/channel/cardview/legou/pits41/CycleActivityView41;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Lcom/bytedance/android/shopping/mall/homepage/card/headercard/util/BtmPositionResult;", "getBtmInfo", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "b", "mall_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CycleActivityView41 extends ConstraintLayout {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final Typeface f177661k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final List<String> f177662l = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f177663a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TextView f177664b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TextView f177665c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final TextView f177666d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final TextView f177667e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final LinearLayout f177668f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f177669g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public com.bytedance.android.shopping.mall.homepage.card.headercard.a f177670h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public com.bytedance.android.shopping.mall.homepage.card.headercard.channel.action.a f177671i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public com.bytedance.android.shopping.mall.homepage.card.headercard.channel.cardview.legou.pits41.b f177672j;

    public static final class a extends ViewOutlineProvider {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CycleActivityView41 f177673a;

        public a(CycleActivityView41 r100) {
            this.f177673a = r100;
        }

        @Override // android.view.ViewOutlineProvider
        public final void getOutline(View r100, Outline r101) {
            if (r100 != null) goto L4;
            return;
        L4:
            if (r101 == null) goto L7;
            r101.setRoundRect(0, 0, r100.getWidth(), r100.getHeight(), this.f177673a.f177663a);
            return;
        }
    }

    public static final class b {
    }

    public static final class c implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CycleActivityView41 f177674a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ChannelVO f177675b;

        public c(CycleActivityView41 r100, ChannelVO r101) {
            this.f177674a = r100;
            this.f177675b = r101;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            this.f177674a.T5(this.f177675b, -1, System.currentTimeMillis());
            this.f177674a.U5(this.f177675b, -1);
        }
    }

    public static final class d implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f177676a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ CycleActivityView41 f177677b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ ChannelVO f177678c;

        public d(int r100, CycleActivityView41 r101, ChannelVO r102) {
            this.f177676a = r100;
            this.f177677b = r101;
            this.f177678c = r102;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            this.f177677b.T5(this.f177678c, this.f177676a, System.currentTimeMillis());
            this.f177677b.U5(this.f177678c, this.f177676a);
        }
    }

    public CycleActivityView41(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public CycleActivityView41(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public static Map S5() {
        return MapsKt.mapOf(new Pair[]{TuplesKt.to("activity_name", com.bytedance.android.ec.core.event.a.VALUE_EXPLOSIVE_SUBSIDY), TuplesKt.to("module_id", "cycle_activity"), TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_EVENT_ORIGIN_FEATURE, com.bytedance.android.ec.core.event.a.VALUE_TEMAI), TuplesKt.to("module_name", "万人团"), TuplesKt.to("product_type", "wanrentuan_card")});
    }

    static {
        com.bytedance.android.ec.hybrid.a.c();
        f177661k = null;
        f177662l = CollectionsKt.listOf(new String[]{"距结束", "已结束"});
    }

    private final BtmPositionResult getBtmInfo() {
        return new BtmPositionResult("c209853.d85698", null, null, 6, null);
    }

    public final void R5(ChannelVO r210, com.bytedance.android.shopping.mall.homepage.card.headercard.a r211) {
        Intrinsics.checkNotNullParameter(r210, "cycleActivityItem");
        Intrinsics.checkNotNullParameter(r211, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f177670h = r211;
        this.f177671i = new com.bytedance.android.shopping.mall.homepage.card.headercard.channel.action.a(r211);
        com.bytedance.android.shopping.mall.homepage.card.headercard.a r100 = this.f177670h;
        if (r100 != null) goto L5;
    L7:
        Map<String, String> r101 = UtilsKt.a(r210, true, -1);
        com.bytedance.android.shopping.mall.homepage.card.headercard.a r102 = this.f177670h;
        if (r102 == null) goto L38;
        BtmPositionResult r103 = getBtmInfo();
        if (r103 == null) goto L13;
        String r104 = r103.getBtm();
        if (r104 == null) goto L13;
    L14:
        LinkedHashMap r105 = new LinkedHashMap();
        if (this.f177671i == null) goto L27;
        com.bytedance.android.shopping.mall.homepage.card.headercard.a r106 = this.f177670h;
        if (r106 == null) goto L24;
        ECMallFeed r107 = r106.f472424h;
        if (r107 == null) goto L24;
        ECMallFeed.f r108 = r107.A1;
        if (r108 == null) goto L24;
        Map<String, Object> r109 = r108.getGlobalProps();
        if (r109 == null) goto L24;
    L25:
        Map r110 = com.bytedance.android.shopping.mall.homepage.card.headercard.channel.action.a.a(r210, r109);
        if (r110 == null) goto L27;
    L28:
        r105.putAll(r110);
        r105.putAll(r101);
        r105.putAll(S5());
        Unit r111 = Unit.INSTANCE;
        com.bytedance.android.shopping.mall.homepage.card.headercard.a r112 = this.f177670h;
        if (r112 == null) goto L36;
        ECMallFeed r113 = r112.f472424h;
        if (r113 == null) goto L36;
        ECMallFeed.f r114 = r113.A1;
        if (r114 == null) goto L36;
        Map<String, Object> r115 = r114.getGlobalProps();
        if (r115 == null) goto L36;
    L37:
        e.b(r102, "show_daogou_entrance", r104, r105, r115);
    L36:
        r115 = MapsKt.emptyMap();
    L24:
        r109 = MapsKt.emptyMap();
    L27:
        r110 = MapsKt.emptyMap();
    L13:
        r104 = "";
    L38:
        com.bytedance.android.shopping.mall.homepage.card.headercard.a r116 = this.f177670h;
        if (r116 == null) goto L46;
        BtmPositionResult r117 = getBtmInfo();
        if (r117 == null) goto L44;
        String r118 = r117.getBtm();
        if (r118 == null) goto L44;
    L45:
        e.b(r116, "marketing_show", r118, S5(), r116.f472424h.A1.getGlobalProps());
    L44:
        r118 = "";
    L46:
        SimpleDraweeView r119 = (SimpleDraweeView) findViewById(R.id.cycle_activity_tag);
        int r120 = com.bytedance.android.ec.hybrid.list.util.c.f47296a;
        r119.setLayoutParams(new ConstraintLayout.LayoutParams(-1, com.bytedance.android.ec.hybrid.list.util.c.c(28, getContext(), true)));
        String r121 = r210.getTagUrl();
        if (r121 != null) goto L49;
        r121 = "";
    L49:
        com.bytedance.android.shopping.mall.homepage.card.headercard.a r122 = this.f177670h;
        if (r122 == null) goto L53;
        String r123 = r122.f177572k;
        if (r123 == null) goto L53;
    L54:
        d0.c(r119, r121, r123);
        r119.setOnClickListener(new c(this, r210));
        SimpleDraweeView r124 = (SimpleDraweeView) findViewById(R.id.cycle_activity_bg);
        com.bytedance.android.shopping.mall.homepage.card.headercard.a r125 = this.f177670h;
        if (r125 == null) goto L58;
        String r126 = r125.f177572k;
        if (r126 == null) goto L58;
    L59:
        d0.c(r124, "https://p3-piu.byteimg.com/tos-cn-i-8jisjyls3a/5d7fb9c7d56a4c12a5236693b084a4ef~tplv-8jisjyls3a-image.image", r126);
        Iterator r127 = CollectionsKt.listOf(new Integer[]{Integer.valueOf(R.id.cycle_activity_countdown_prefix), Integer.valueOf(R.id.cycle_activity_countdown_hours), Integer.valueOf(R.id.cycle_activity_countdown_dot_1), Integer.valueOf(R.id.cycle_activity_countdown_minutes), Integer.valueOf(R.id.cycle_activity_countdown_dot_2), Integer.valueOf(R.id.cycle_activity_countdown_seconds)}).iterator();
    L61:
        if (r127.hasNext() == false) goto L63;
        AppCompatTextView r128 = (AppCompatTextView) findViewById(((Number) r127.next()).intValue());
        r128.setTypeface(f177661k);
        int r129 = com.bytedance.android.ec.hybrid.list.util.c.f47296a;
        r128.setTextSize(0, com.bytedance.android.ec.hybrid.list.util.c.c(11, getContext(), true));
        t93.a.d(r128);
        goto L61
    L63:
        SimpleDraweeView r130 = (SimpleDraweeView) findViewById(R.id.cycle_activity_countdown_right_arrow);
        int r131 = com.bytedance.android.ec.hybrid.list.util.c.f47296a;
        r130.setLayoutParams(new LinearLayout.LayoutParams(com.bytedance.android.ec.hybrid.list.util.c.c(10, getContext(), true), com.bytedance.android.ec.hybrid.list.util.c.c(10, getContext(), true)));
        com.bytedance.android.shopping.mall.homepage.card.headercard.a r132 = this.f177670h;
        if (r132 == null) goto L67;
        String r133 = r132.f177572k;
        if (r133 == null) goto L67;
    L68:
        d0.c(r130, "https://lf3-static.bytednsdoc.com/obj/eden-cn/sshfteh7nuhpebps/duliduan/wanrentuan_right_jiantou.png", r133);
        Long r134 = r210.getLeftTime();
        if (r134 == null) goto L71;
        long r135 = r134.longValue();
    L72:
        this.f177669g = r135;
        long r136 = 1000;
        com.bytedance.android.shopping.mall.homepage.card.headercard.channel.cardview.legou.pits41.b r137 = new com.bytedance.android.shopping.mall.homepage.card.headercard.channel.cardview.legou.pits41.b(this, this.f177669g * r136, r136);
        this.f177672j = r137;
        r137.start();
        LinearLayout.LayoutParams r138 = new LinearLayout.LayoutParams(-1, -1);
        r138.weight = 1.0f;
        ChannelVO.Data r139 = r210.getData();
        if (r139 == null) goto L117;
        List<ECCommonCard> r140 = r139.getItems();
        if (r140 == null) goto L122;
        Iterator<T> r141 = r140.iterator();
        int r142 = 0;
    L78:
        if (r141.hasNext() == false) goto L123;
        Object r143 = r141.next();
        int r144 = r142 + 1;
        if (r142 >= 0) goto L82;
        CollectionsKt.throwIndexOverflow();
    L82:
        ECCommonCard r145 = (ECCommonCard) r143;
        if (r145 == null) goto L90;
        ECProductStruct r146 = r145.getProduct();
        if (r146 == null) goto L90;
        Object r147 = r146.getCover();
        if (r147 == null) goto L90;
        String r148 = l93.b.a(r147);
        if (r148 == null) goto L90;
    L92:
        if (r145 == null) goto L98;
        ECProductStruct r149 = r145.getProduct();
        if (r149 == null) goto L98;
        PriceStruct r150 = r149.getPrice();
        if (r150 == null) goto L98;
        String r151 = PriceStruct.getPromoPrice$default(r150, false, 0, 1, 3, null);
    L99:
        View r152 = LayoutInflater.from(getContext()).inflate(R.layout.shopping_homepage_card_native_cycle_activity_product_item, null);
        SimpleDraweeView r153 = (SimpleDraweeView) r152.findViewById(R.id.cycle_activity_item_cover);
        ViewGroup.LayoutParams r154 = r153.getLayoutParams();
        int r155 = com.bytedance.android.ec.hybrid.list.util.c.f47296a;
        r154.width = com.bytedance.android.ec.hybrid.list.util.c.c(60, getContext(), true);
        r154.height = com.bytedance.android.ec.hybrid.list.util.c.c(60, getContext(), true);
        Unit r156 = Unit.INSTANCE;
        r153.setLayoutParams(r154);
        com.bytedance.android.shopping.mall.homepage.card.headercard.a r157 = this.f177670h;
        if (r157 == null) goto L103;
        String r158 = r157.f177572k;
        if (r158 == null) goto L103;
    L104:
        d0.c(r153, r148, r158);
        AppCompatTextView r159 = (AppCompatTextView) r152.findViewById(R.id.cycle_activity_item_price_prefix);
        Typeface r160 = f177661k;
        r159.setTypeface(r160);
        r159.setTextSize(0, com.bytedance.android.ec.hybrid.list.util.c.c(10, getContext(), true));
        t93.a.d(r159);
        AppCompatTextView r161 = (AppCompatTextView) r152.findViewById(R.id.cycle_activity_item_price_textview);
        r161.setText(r151);
        r161.setTypeface(r160);
        r161.setTextSize(0, com.bytedance.android.ec.hybrid.list.util.c.c(14, getContext(), true));
        t93.a.d(r161);
        AppCompatTextView r162 = (AppCompatTextView) r152.findViewById(R.id.cycle_activity_item_price_postfix);
        r162.setTextSize(0, com.bytedance.android.ec.hybrid.list.util.c.c(9, getContext(), true));
        t93.a.d(r162);
        r152.setOnClickListener(new d(r142, this, r210));
        this.f177668f.addView(r152, r138);
        com.bytedance.android.shopping.mall.homepage.card.headercard.channel.action.a r163 = this.f177671i;
        if (r163 == null) goto L116;
        BtmPositionResult r164 = getBtmInfo();
        com.bytedance.android.shopping.mall.homepage.card.headercard.a r165 = this.f177670h;
        if (r165 == null) goto L114;
        ECMallFeed r166 = r165.f472424h;
        if (r166 == null) goto L114;
        com.bytedance.android.shopping.api.mall.feed.e r167 = r166.A1;
        if (r167 == null) goto L114;
        Map<String, Object> r168 = r167.getGlobalProps();
        if (r168 == null) goto L114;
    L115:
        r163.c(r210, r164, r142, r168, S5());
    L114:
        r168 = MapsKt.emptyMap();
    L116:
        r142 = r144;
    L103:
        r158 = "ec_na_mall_header";
    L98:
        r151 = null;
    L90:
        r148 = "";
        goto L92
    L123:
        return;
    L122:
        return;
    L117:
        return;
    L71:
        r135 = 0;
    L67:
        r133 = "ec_na_mall_header";
    L58:
        r126 = "ec_na_mall_header";
    L53:
        r123 = "ec_na_mall_header";
        goto L54
    L5:
        if (r100.f472421e != true) goto L7;
        goto L7
    }

    public final void U5(ChannelVO r100, int r101) {
        if (r100 != null) goto L4;
        return;
    L4:
        com.bytedance.android.shopping.mall.homepage.card.headercard.channel.action.a r102 = this.f177671i;
        if (r102 == null) goto L17;
        BtmPositionResult r103 = getBtmInfo();
        com.bytedance.android.shopping.mall.homepage.card.headercard.a r104 = this.f177670h;
        if (r104 == null) goto L14;
        ECMallFeed r105 = r104.f472424h;
        if (r105 == null) goto L14;
        com.bytedance.android.shopping.api.mall.feed.e r106 = r105.A1;
        if (r106 == null) goto L14;
        Map<String, Object> r107 = r106.getGlobalProps();
        if (r107 == null) goto L14;
    L15:
        r102.b(r100, r103, r101, r107, S5());
        return;
    L14:
        r107 = MapsKt.emptyMap();
        goto L15
    }

    public CycleActivityView41(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        int r103 = com.bytedance.android.ec.hybrid.list.util.c.f47296a;
        this.f177663a = com.bytedance.android.ec.hybrid.list.util.c.c(12, getContext(), true);
        View r104 = LayoutInflater.from(r100).inflate(R.layout.shopping_homepage_layout_native_cycle_activity_card, this);
        this.f177664b = (TextView) r104.findViewById(R.id.cycle_activity_countdown_prefix);
        this.f177665c = (TextView) r104.findViewById(R.id.cycle_activity_countdown_hours);
        this.f177666d = (TextView) r104.findViewById(R.id.cycle_activity_countdown_minutes);
        this.f177667e = (TextView) r104.findViewById(R.id.cycle_activity_countdown_seconds);
        this.f177668f = (LinearLayout) r104.findViewById(R.id.cycle_activity_product_items);
        r104.setOutlineProvider(new a(this));
        r104.setClipToOutline(true);
    }

    public final void T5(ChannelVO r100, int r110, long r111) {
        if (r100 != null) goto L4;
        return;
    L4:
        com.bytedance.android.shopping.mall.homepage.card.headercard.a r101 = this.f177670h;
        if (r101 == null) goto L12;
        int r102 = f.f177884a;
        BtmPositionResult r103 = getBtmInfo();
        if (r103 == null) goto L9;
        String r104 = r103.getBtm();
    L10:
        f.a(r101, r100, r110, r104, r100.getBcm(), r101.f472424h.A1.getGlobalProps(), r111);
        return;
    L9:
        r104 = null;
        goto L10
    }

    public /* synthetic */ CycleActivityView41(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
