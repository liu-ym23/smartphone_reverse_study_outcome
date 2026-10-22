package com.bytedance.android.shopping.mall.homepage.card.headercard.channel.itemview;

import com.bytedance.android.ec.hybrid.card.event.ECEventCenter;
import com.bytedance.android.shopping.api.mall.common.homepage.card.headercard.model.BtmData;
import com.bytedance.android.shopping.api.mall.common.homepage.card.headercard.model.ChannelCID;
import com.bytedance.android.shopping.api.mall.common.homepage.card.headercard.model.ChannelVO;
import com.bytedance.android.shopping.api.mall.common.homepage.card.headercard.model.Coupon4Activity;
import com.bytedance.android.shopping.mall.feed.ECMallFeed;
import com.bytedance.android.shopping.mall.homepage.card.headercard.a;
import com.bytedance.android.shopping.mall.homepage.card.headercard.util.Popup7Type;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3})
final class BigCardTitleView$playLottie$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ BigCardTitleView this$0;

    public BigCardTitleView$playLottie$1(BigCardTitleView r100) {
        this.this$0 = r100;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        a r100 = this.this$0.f177692h;
        String r101 = "";
        if (r100 == null) goto L50;
        ECMallFeed r102 = r100.f472424h;
        if (r102 == null) goto L50;
        ECMallFeed.f r103 = r102.A1;
        if (r103 == null) goto L50;
        Map<String, Object> r104 = r103.getGlobalProps();
        if (r104 == null) goto L50;
        Object r105 = r104.get("delivery_type");
        if ((r105 instanceof String) == true) goto L13;
        r105 = null;
    L13:
        String r106 = (String) r105;
        Object r107 = r104.get("delivery_value");
        if ((r107 instanceof String) == true) goto L16;
        r107 = null;
    L16:
        String r108 = (String) r107;
        if (r108 != null) goto L19;
    L20:
        if (r108 != null) goto L22;
    L23:
        if (r108 != null) goto L25;
    L27:
        if (r108 != null) goto L29;
    L31:
        String r109 = "";
    L33:
        if (Intrinsics.areEqual(r109, Popup7Type.Seckill.getValue()) == false) goto L42;
        ChannelVO r110 = this.this$0.f177691g;
        if (r110 == null) goto L37;
        String r111 = r110.getComponentId();
    L39:
        if (Intrinsics.areEqual(r111, ChannelCID.SECKILL.getValue()) == false) goto L42;
        this.this$0.f177686b = true;
        goto L42
    L37:
        r111 = null;
    L42:
        if (Intrinsics.areEqual(r109, Popup7Type.Subsidy.getValue()) == false) goto L50;
        ChannelVO r112 = this.this$0.f177691g;
        if (r112 == null) goto L46;
        String r113 = r112.getComponentId();
    L48:
        if (Intrinsics.areEqual(r113, ChannelCID.SUBSIDE.getValue()) == false) goto L50;
        this.this$0.f177686b = true;
        goto L50
    L46:
        r113 = null;
        goto L48
    L29:
        if (StringsKt.contains$default(r108, "mall_channels_regular/seckill", false, 2, null) != true) goto L31;
        r109 = Popup7Type.Seckill.getValue();
        goto L33
    L25:
        if (StringsKt.contains$default(r108, "ecommerce_subsidy_douyin", false, 2, null) != true) goto L27;
    L26:
        r109 = Popup7Type.Subsidy.getValue();
        goto L33
    L22:
        if (StringsKt.contains$default(r108, "/mall_channels_regular/preorder/", false, 2, null) == true) goto L26;
    L19:
        if (StringsKt.contains$default(r108, "/mall_channels_group_bargain/", false, 2, null) == true) goto L26;
    L50:
        BigCardTitleView r114 = this.this$0;
        ChannelVO r115 = r114.f177691g;
        a r116 = r114.f177692h;
        if (r116 == null) goto L57;
        ECMallFeed r117 = r116.f472424h;
        if (r117 == null) goto L57;
        ECMallFeed.f r118 = r117.A1;
        if (r118 == null) goto L57;
        Map<String, Object> r119 = r118.getGlobalProps();
    L58:
        if (r115 == null) goto L81;
        if (r119 == null) goto L81;
        BigCardTitleView r120 = this.this$0;
        com.bytedance.android.shopping.mall.homepage.card.headercard.channel.action.a r121 = r120.f177693i;
        if (r121 == null) goto L81;
        Pair[] r122 = new Pair[2];
        ChannelVO.a r123 = r120.f177690f;
        if (r123 == null) goto L72;
        Coupon4Activity r124 = r123.f170325c;
        if (r124 == null) goto L72;
        Long r125 = r124.getId();
        if (r125 == null) goto L72;
        String r126 = String.valueOf(r125.longValue());
        if (r126 == null) goto L72;
        r101 = r126;
    L72:
        r122[0] = TuplesKt.to("coupon_id", r101);
        if (this.this$0.f177686b == false) goto L75;
        String r127 = "popup";
    L76:
        r122[1] = TuplesKt.to("behave_type", r127);
        Map r128 = MapsKt.mapOf(r122);
        a r129 = this.this$0.f177692h;
        if (r129 == null) goto L79;
        BtmData r130 = r129.f177571j;
    L80:
        com.bytedance.android.shopping.mall.homepage.card.headercard.channel.action.a.d(r121, r115, r128, false, r130, r119);
        goto L81
    L79:
        r130 = null;
        goto L80
    L75:
        r127 = "normal";
    L81:
        BigCardTitleView r131 = this.this$0;
        a r132 = r131.f177692h;
        if (r132 == null) goto L84;
        String r133 = r132.f472425i;
    L86:
        if (r131.f177694j != null) goto L89;
        if (r133 == null) goto L89;
        BigCardTitleView$playLottie$1$sub$1 r134 = new BigCardTitleView$playLottie$1$sub$1(this);
        r131.f177694j = r134;
        ECEventCenter.e("ec.mallAllowEffectShow", r134, r133);
    L89:
        a r135 = this.this$0.f177692h;
        if (r135 == null) goto L97;
        ECMallFeed r136 = r135.f472424h;
        if (r136 == null) goto L98;
        ECMallFeed.f r137 = r136.A1;
        if (r137 == null) goto L99;
        r137.Q30("requestChannelTitleLottieShow", null);
        return;
    L99:
        return;
    L98:
        return;
    L97:
        return;
    L84:
        r133 = null;
    L57:
        r119 = null;
        goto L58
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }
}
