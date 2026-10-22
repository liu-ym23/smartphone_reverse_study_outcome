package com.bytedance.android.shopping.mall.homepage.card.headercard.channel;

import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.ec.hybrid.card.event.ECEventCenter;
import com.bytedance.android.ec.hybrid.list.util.k;
import com.bytedance.android.ec.hybrid.monitor.HybridAppInfoService;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.android.shopping.api.mall.common.homepage.card.headercard.model.BtmData;
import com.bytedance.android.shopping.api.mall.common.homepage.card.headercard.model.ChannelCID;
import com.bytedance.android.shopping.api.mall.common.homepage.card.headercard.model.ChannelCardLayoutType;
import com.bytedance.android.shopping.api.mall.common.homepage.card.headercard.model.ChannelVO;
import com.bytedance.android.shopping.mall.homepage.card.headercard.channel.action.ReportAction$onChannelAreaShow$1;
import com.bytedance.android.shopping.mall.homepage.card.headercard.channel.action.a;
import com.bytedance.android.shopping.mall.homepage.card.headercard.channel.cardview.ChannelCardView11;
import com.bytedance.android.shopping.mall.homepage.card.headercard.channel.cardview.ChannelCardView11Live;
import com.bytedance.android.shopping.mall.homepage.card.headercard.channel.cardview.ChannelCardView21;
import com.bytedance.android.shopping.mall.homepage.card.headercard.channel.cardview.ChannelCardView21Live;
import com.bytedance.android.shopping.mall.homepage.card.headercard.channel.cardview.ChannelCardView41;
import com.bytedance.android.shopping.mall.homepage.card.headercard.channel.cardview.legou.pits31.ChannelItemLive;
import com.bytedance.android.shopping.mall.homepage.card.headercard.channel.cardview.legou.pits31.ChannelItemSubSide;
import com.bytedance.android.shopping.mall.homepage.card.headercard.channel.cardview.legou.pits31.Common31ChannelCardLayout;
import com.bytedance.android.shopping.mall.homepage.card.headercard.channel.cardview.legou.pits41.ChannelCardViewNew41;
import com.bytedance.android.shopping.mall.homepage.card.headercard.channel.viewholder.Channel11LiveVH;
import com.bytedance.android.shopping.mall.homepage.card.headercard.channel.viewholder.Channel11VH;
import com.bytedance.android.shopping.mall.homepage.card.headercard.channel.viewholder.Channel21LiveVH;
import com.bytedance.android.shopping.mall.homepage.card.headercard.channel.viewholder.Channel21VH;
import com.bytedance.android.shopping.mall.homepage.card.headercard.channel.viewholder.Channel41VH;
import com.bytedance.android.shopping.mall.homepage.card.headercard.channel.viewholder.ChannelBaseVH;
import com.bytedance.android.shopping.mall.homepage.card.headercard.channel.viewholder.legou.Channel31LiveVH;
import com.bytedance.android.shopping.mall.homepage.card.headercard.channel.viewholder.legou.Channel31VH;
import com.bytedance.android.shopping.mall.homepage.card.headercard.channel.viewholder.legou.ChannelNew41VH;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import ef3.b;
import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;
import java.util.List;
import java.util.Map;
import kjc.c;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004:\u0001\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/shopping/mall/homepage/card/headercard/channel/ChannelAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lcom/bytedance/android/shopping/api/mall/common/homepage/card/headercard/model/ChannelVO;", "Lcom/bytedance/android/shopping/mall/homepage/card/headercard/channel/viewholder/ChannelBaseVH;", "Lef3/b;", "EmptyViewHolder", "mall_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ChannelAdapter extends ListAdapter<ChannelVO, ChannelBaseVH> implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public List<ChannelVO> f177577a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public RecyclerView f177578b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final a f177579c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Function0<Boolean> f177580d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ChannelAdapter$clickHighlightSub$1 f177581e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final com.bytedance.android.shopping.mall.homepage.card.headercard.a f177582f;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/shopping/mall/homepage/card/headercard/channel/ChannelAdapter$EmptyViewHolder;", "Lcom/bytedance/android/shopping/mall/homepage/card/headercard/channel/viewholder/ChannelBaseVH;", "mall_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class EmptyViewHolder extends ChannelBaseVH {
        public EmptyViewHolder(View r100, com.bytedance.android.shopping.mall.homepage.card.headercard.a r101, a r102) {
            Intrinsics.checkNotNullParameter(r100, "itemView");
            Intrinsics.checkNotNullParameter(r101, "mallContext");
            Intrinsics.checkNotNullParameter(r102, "impressAction");
            super(r100, r101, r102);
        }
    }

    @Override // ef3.b
    public final void p() {
    }

    @Override // androidx.recyclerview.widget.ListAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        List<ChannelVO> r100 = this.f177577a;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.size();
    }

    @Override // ef3.b
    public final void onRelease() {
        ECEventCenter.f("click_bubble_highlight_event", this.f177581e);
    }

    /* JADX WARN: Type inference failed for: r2v2, types: [T, com.bytedance.android.shopping.mall.homepage.card.headercard.channel.ChannelAdapter$$special$$inlined$call$lambda$1] */
    public ChannelAdapter(com.bytedance.android.shopping.mall.homepage.card.headercard.a r100) {
        Intrinsics.checkNotNullParameter(r100, "mallContext");
        super(new ChannelDiffCallback());
        this.f177582f = r100;
        this.f177579c = new a(r100);
        c r101 = new c();
        if (5 != kjc.a.a()) goto L6;
        kjc.b<T> r102 = r101.f503730a;
        r102.f503729a = new ChannelAdapter$$special$$inlined$call$lambda$1(this);
        r101.f503731b = true;
    L6:
        if (r101.f503731b == true) goto L8;
        r101.f503730a.f503729a = null;
    L8:
        this.f177580d = (Function0) r101.f503730a.f503729a;
        ChannelAdapter$clickHighlightSub$1 r103 = new ChannelAdapter$clickHighlightSub$1(this);
        this.f177581e = r103;
        r100.a(this);
        ECEventCenter.e("click_bubble_highlight_event", r103, r100.f472425i);
    }

    @Override // ef3.b
    public final void N2(View r100) {
        Intrinsics.checkNotNullParameter(r100, "cardView");
        Intrinsics.checkNotNullParameter(r100, "cardView");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemViewType(int r100) {
        List<ChannelVO> r101 = this.f177577a;
        JSONObject r102 = null;
        if (r101 == null) goto L5;
        Integer r103 = Integer.valueOf(r101.size());
    L6:
        if (r103 == null) goto L78;
        if (r103.intValue() <= r100) goto L78;
        List<ChannelVO> r104 = this.f177577a;
        if (r104 == null) goto L76;
        ChannelVO r105 = (ChannelVO) ListProtector.get(r104, r100);
        if (r105 == null) goto L76;
        ChannelVO.Layout r106 = r105.getLayout();
        if (r106 == null) goto L17;
        Integer r107 = r106.getHSpan();
    L18:
        boolean r108 = true;
        if (r107 != null) goto L22;
    L48:
        if (r107 != null) goto L51;
    L57:
        if (r107 != null) goto L60;
    L66:
        if (r107 == null) goto L78;
        if (r107.intValue() != 1) goto L78;
        if (Intrinsics.areEqual(r105.getComponentId(), ChannelCID.LIVE_SQUARE.getValue()) == false) goto L74;
        return ChannelCardLayoutType.SINGLE_PIT_LIVE_CARD.getValue();
    L74:
        return ChannelCardLayoutType.SINGLE_PIT_CARD.getValue();
    L60:
        if (r107.intValue() != 3) goto L66;
        if (Intrinsics.areEqual(r105.getComponentId(), ChannelCID.LIVE_SQUARE.getValue()) == false) goto L65;
        return ChannelCardLayoutType.THREE_PITS_CARD_LIVE.getValue();
    L65:
        return ChannelCardLayoutType.THREE_PITS_CARD.getValue();
    L51:
        if (r107.intValue() != 2) goto L57;
        if (Intrinsics.areEqual(r105.getComponentId(), ChannelCID.LIVE_SQUARE.getValue()) == false) goto L56;
        return ChannelCardLayoutType.DOUBLE_PITS_LIVE_CARD.getValue();
    L56:
        return ChannelCardLayoutType.DOUBLE_PITS_CARD.getValue();
    L22:
        if (r107.intValue() != 4) goto L48;
        Intrinsics.checkNotNullParameter(r105, "$this$isLegouStyle41");
        Object r109 = r105.getExtra();
        if (r109 == null) goto L33;
        if ((r109 instanceof String) == false) goto L30;
        JSONObject r110 = k.c((String) r109);
    L28:
        r102 = r110;
        goto L33
    L30:
        if ((r109 instanceof JSONObject) == false) goto L33;
        r110 = (JSONObject) r109;
    L33:
        if (r102 != null) goto L35;
    L37:
        boolean r111 = false;
    L38:
        if (r111 == false) goto L42;
        Lazy r112 = HybridAppInfoService.f47530a;
        if (HybridAppInfoService.l() == false) goto L42;
    L43:
        if (r108 == false) goto L47;
        return ChannelCardLayoutType.BIG_CARD_NEW_41.getValue();
    L47:
        return ChannelCardLayoutType.BIG_CARD.getValue();
    L42:
        r108 = false;
        goto L43
    L35:
        if (r102.optBoolean("new_style", false) != true) goto L37;
        r111 = true;
        goto L38
    L17:
        r107 = null;
    L76:
        return ChannelCardLayoutType.NONE.getValue();
    L78:
        return ChannelCardLayoutType.NONE.getValue();
    L5:
        r103 = null;
        goto L6
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r101) {
        ChannelBaseVH r102 = (ChannelBaseVH) r100;
        Intrinsics.checkNotNullParameter(r102, "holder");
        List<ChannelVO> r103 = this.f177577a;
        if (r103 != null) goto L6;
        return;
    L6:
        if (r101 >= r103.size()) goto L9;
        r102.T3((ChannelVO) ListProtector.get(r103, r101));
        return;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r110, int r111) {
        Intrinsics.checkNotNullParameter(r110, "parent");
        int r100 = 6;
        AttributeSet r101 = null;
        int r102 = 0;
        if (r111 != ChannelCardLayoutType.SINGLE_PIT_CARD.getValue()) goto L6;
        int r112 = Channel11VH.f177730j;
        com.bytedance.android.shopping.mall.homepage.card.headercard.a r113 = this.f177582f;
        a r103 = this.f177579c;
        Intrinsics.checkNotNullParameter(r110, KtvSubElement.CONTAINER);
        Intrinsics.checkNotNullParameter(r113, "mallContext");
        Intrinsics.checkNotNullParameter(r103, "action");
        return new Channel11VH(new ChannelCardView11(r110.getContext(), r101, r100, r102), r113, r103);
    L6:
        if (r111 != ChannelCardLayoutType.SINGLE_PIT_LIVE_CARD.getValue()) goto L9;
        int r114 = Channel11LiveVH.f177726j;
        com.bytedance.android.shopping.mall.homepage.card.headercard.a r115 = this.f177582f;
        a r104 = this.f177579c;
        Intrinsics.checkNotNullParameter(r110, KtvSubElement.CONTAINER);
        Intrinsics.checkNotNullParameter(r115, "mallContext");
        Intrinsics.checkNotNullParameter(r104, "action");
        return new Channel11LiveVH(new ChannelCardView11Live(r110.getContext(), r101, r100, r102), r115, r104);
    L9:
        if (r111 != ChannelCardLayoutType.DOUBLE_PITS_CARD.getValue()) goto L12;
        int r116 = Channel21VH.f177740m;
        com.bytedance.android.shopping.mall.homepage.card.headercard.a r117 = this.f177582f;
        a r105 = this.f177579c;
        Intrinsics.checkNotNullParameter(r110, KtvSubElement.CONTAINER);
        Intrinsics.checkNotNullParameter(r117, "mallContext");
        Intrinsics.checkNotNullParameter(r105, "action");
        return new Channel21VH(new ChannelCardView21(r110.getContext(), r101, r100, r102), r117, r105);
    L12:
        if (r111 != ChannelCardLayoutType.DOUBLE_PITS_LIVE_CARD.getValue()) goto L15;
        int r118 = Channel21LiveVH.f177734k;
        com.bytedance.android.shopping.mall.homepage.card.headercard.a r119 = this.f177582f;
        a r106 = this.f177579c;
        Intrinsics.checkNotNullParameter(r110, KtvSubElement.CONTAINER);
        Intrinsics.checkNotNullParameter(r119, "mallContext");
        Intrinsics.checkNotNullParameter(r106, "action");
        return new Channel21LiveVH(new ChannelCardView21Live(r110.getContext(), r101, r100, r102), r119, r106);
    L15:
        if (r111 != ChannelCardLayoutType.THREE_PITS_CARD.getValue()) goto L21;
        int r120 = Channel31VH.f177771m;
        com.bytedance.android.shopping.mall.homepage.card.headercard.a r121 = this.f177582f;
        a r107 = this.f177579c;
        Function0<Boolean> r108 = this.f177580d;
        Intrinsics.checkNotNullParameter(r110, KtvSubElement.CONTAINER);
        Intrinsics.checkNotNullParameter(r121, "mallContext");
        Intrinsics.checkNotNullParameter(r107, "action");
        ChannelItemSubSide[] r109 = new ChannelItemSubSide[3];
        int r122 = 0;
    L17:
        if (r122 >= 3) goto L19;
        r109[r122] = new ChannelItemSubSide(r110.getContext(), r101, r100, r102);
        r122 = r122 + 1;
        goto L17
    L19:
        List r123 = ArraysKt.toList(r109);
        Common31ChannelCardLayout r124 = new Common31ChannelCardLayout(r110.getContext(), r101, r100, r102);
        r124.a(r123);
        return new Channel31VH(r124, r121, r107, r108);
    L21:
        if (r111 != ChannelCardLayoutType.THREE_PITS_CARD_LIVE.getValue()) goto L27;
        int r125 = Channel31LiveVH.f177764k;
        com.bytedance.android.shopping.mall.homepage.card.headercard.a r126 = this.f177582f;
        a r127 = this.f177579c;
        Function0<Boolean> r128 = this.f177580d;
        Intrinsics.checkNotNullParameter(r110, KtvSubElement.CONTAINER);
        Intrinsics.checkNotNullParameter(r126, "mallContext");
        Intrinsics.checkNotNullParameter(r127, "action");
        ChannelItemLive[] r129 = new ChannelItemLive[3];
        int r130 = 0;
    L23:
        if (r130 >= 3) goto L25;
        r129[r130] = new ChannelItemLive(r110.getContext(), r101, r100, r102);
        r130 = r130 + 1;
        goto L23
    L25:
        List r131 = ArraysKt.toList(r129);
        Common31ChannelCardLayout r132 = new Common31ChannelCardLayout(r110.getContext(), r101, r100, r102);
        r132.a(r131);
        return new Channel31LiveVH(r132, r126, r127, r128);
    L27:
        if (r111 != ChannelCardLayoutType.BIG_CARD.getValue()) goto L30;
        int r133 = Channel41VH.f177748m;
        com.bytedance.android.shopping.mall.homepage.card.headercard.a r134 = this.f177582f;
        a r135 = this.f177579c;
        Intrinsics.checkNotNullParameter(r110, KtvSubElement.CONTAINER);
        Intrinsics.checkNotNullParameter(r134, "mallContext");
        Intrinsics.checkNotNullParameter(r135, "action");
        return new Channel41VH(new ChannelCardView41(r110.getContext(), r101, r100, r102), r134, r135);
    L30:
        if (r111 != ChannelCardLayoutType.BIG_CARD_NEW_41.getValue()) goto L33;
        int r136 = ChannelNew41VH.f177782l;
        com.bytedance.android.shopping.mall.homepage.card.headercard.a r137 = this.f177582f;
        a r138 = this.f177579c;
        Function0<Boolean> r139 = this.f177580d;
        Intrinsics.checkNotNullParameter(r110, KtvSubElement.CONTAINER);
        Intrinsics.checkNotNullParameter(r137, "mallContext");
        Intrinsics.checkNotNullParameter(r138, "action");
        return new ChannelNew41VH(new ChannelCardViewNew41(r110.getContext(), null, 6, 0), r137, r138, r139);
    L33:
        return new EmptyViewHolder(new View(r110.getContext()), this.f177582f, this.f177579c);
    }

    @Override // ef3.b
    public final void Q0(boolean r100, Boolean r101, boolean r102) {
        if (r100 == true) goto L4;
        return;
    L4:
        if (Intrinsics.areEqual(r101, Boolean.FALSE) == false) goto L9;
        if (r102 == false) goto L10;
        final Map<String, Object> r103 = this.f177582f.f472424h.A1.getGlobalProps();
        final BtmData r104 = this.f177582f.f177571j;
        final a r105 = this.f177579c;
        final List<ChannelVO> r106 = this.f177577a;
        r105.getClass();
        Intrinsics.checkNotNullParameter(r103, "globalProps");
        Single.fromCallable(new ReportAction$onChannelAreaShow$1(r105, r106, r104, r103)).subscribeOn(Schedulers.single()).subscribe();
        return;
    L10:
        return;
    }
}
