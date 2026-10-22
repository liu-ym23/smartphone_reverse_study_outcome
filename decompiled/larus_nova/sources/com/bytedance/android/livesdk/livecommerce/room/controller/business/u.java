package com.bytedance.android.livesdk.livecommerce.room.controller.business;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.bytedance.android.btm.api.BtmSDK;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.ec.model.promotion.ECUIPromotion;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.android.livesdk.livecommerce.room.LiveRoomProvider;
import com.bytedance.android.livesdk.livecommerce.room.controller.RealRoomController$roomResources$1;
import com.bytedance.android.livesdk.livecommerce.room.controller.c0;
import com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.refactor.ExplainCardViewModel;
import com.bytedance.android.livesdk.livecommerce.utils.UtilityKotlinExtentionsKt;
import com.ss.ttvideoengine.model.VideoRef;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class u extends c0 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f151673c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f151674d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f151675e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ExplainCardViewModel f151676f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final List<String> f151677g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final t f151678h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final PreviewClickEntryController$fragmentLifeCallBack$1 f151679i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Function0<Unit> f151680j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final s f151681k;

    @Override // com.bytedance.android.livesdk.livecommerce.room.controller.c0, com.bytedance.android.livesdk.livecommerce.room.api.b
    public final void onPause() {
        this.f151674d = false;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.controller.c0, com.bytedance.android.livesdk.livecommerce.room.api.b
    public final void onResume() {
        this.f151674d = true;
        if (this.f151673c == false) goto L9;
        int r100 = ECSdk.f48106a;
        cf.l r101 = (cf.l) ECSdk.a(cf.l.class);
        if (r101 == null) goto L7;
        r101.Qa(B());
    L7:
        this.f151673c = false;
        return;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.controller.c0, com.bytedance.android.livesdk.livecommerce.room.api.b
    public final void onExitRoom() {
        super.onExitRoom();
        this.f151676f = null;
    }

    /* JADX WARN: Type inference failed for: r11v4, types: [com.bytedance.android.livesdk.livecommerce.room.controller.business.PreviewClickEntryController$fragmentLifeCallBack$1] */
    public u(RealRoomController$roomResources$1 r110) {
        Intrinsics.checkNotNullParameter(r110, "roomResources");
        super(r110);
        this.f151677g = CollectionsKt.listOf(new String[]{"AnchorV4Fragment", "LivePromotionListFragment", "SkuFragment", "SkuPanelOptimizeFragment", "SkuYataFragment", "BuyNowFragment", "BuyNowHalfScreenDialogFragment", "LiveAnnieFragment", "MatchPurchaseFragment"});
        this.f151678h = new t(this);
        this.f151679i = new PreviewClickEntryController$fragmentLifeCallBack$1(this);
        this.f151680j = new PreviewClickEntryController$cancelInteractionMask$1(this);
        this.f151681k = new s(this);
    }

    public final void H(String r210, final View r211) {
        Intrinsics.checkNotNullParameter(r210, "clickFrom");
        Intrinsics.checkNotNullParameter(r211, "view");
        com.bytedance.android.livesdk.livecommerce.room.g r100 = LiveRoomProvider.f151379g;
        if (Intrinsics.areEqual(r100.f151847a, r210) == false) goto L44;
        int r101 = r210.hashCode();
        Object r102 = null;
        if (r101 == (-1648893033)) goto L28;
        if (r101 == 287895896) goto L10;
    L42:
        Intrinsics.checkNotNullParameter("UNKNOW", "<set-?>");
        r100.f151847a = "UNKNOW";
        r100.f151848b.clear();
        return;
    L10:
        if (r210.equals("explain_card") == false) goto L42;
        final s r103 = this.f151681k;
        Bundle r104 = r100.f151848b;
        r103.getClass();
        Intrinsics.checkNotNullParameter(r104, "businessArg");
        Intrinsics.checkNotNullParameter(r211, "view");
        int r105 = ECSdk.f48106a;
        cf.l r106 = (cf.l) ECSdk.a(cf.l.class);
        if (r106 == null) goto L14;
        r106.showInteractionMask(r103.f151671a.B());
    L14:
        Context r107 = r103.f151671a.m();
        if ((r107 instanceof FragmentActivity) == true) goto L17;
        r107 = null;
    L17:
        FragmentActivity r108 = (FragmentActivity) r107;
        if (r108 == null) goto L22;
        FragmentManager r109 = r108.getSupportFragmentManager();
        if (r109 == null) goto L22;
        r109.registerFragmentLifecycleCallbacks(r103.f151671a.f151679i, true);
    L22:
        String r110 = r104.getString("bundle_key_click_area");
        final ECUIPromotion r111 = e.f151625a.remove(Integer.valueOf(r104.getInt("bundle_key_explain_card_preview_ui_promotion")));
        u r112 = r103.f151671a;
        ExplainCardViewModel r113 = r112.f151676f;
        if (r111 == null) goto L42;
        if (r113 == null) goto L26;
        r102 = r113.getNewJumpDispatcher(r112.m(), null, true);
    L26:
        UtilityKotlinExtentionsKt.g(r113, r102, r110, new PreviewClickEntryController$previewClickJumpDispatcher$1$clickFromExplainCard$1(r103, r211, r111));
        xh.a r114 = xh.c.a("Live");
        String r115 = "explain_card_" + r110;
        LinkedHashMap r116 = new LinkedHashMap();
        r116.put("promotion_id", r111.getPromotionId());
        Unit r117 = Unit.INSTANCE;
        r114.d("explain_card", r115, r116);
        goto L42
    L28:
        if (r210.equals("shopping_cart") == false) goto L42;
        final s r118 = this.f151681k;
        Bundle r119 = r100.f151848b;
        r118.getClass();
        Intrinsics.checkNotNullParameter(r119, "businessArg");
        Intrinsics.checkNotNullParameter(r211, "view");
        int r120 = ECSdk.f48106a;
        cf.l r121 = (cf.l) ECSdk.a(cf.l.class);
        if (r121 == null) goto L32;
        r121.showInteractionMask(r118.f151671a.B());
    L32:
        String r212 = BtmSDK.createJumpSourceBtmToken$default(BtmSDK.INSTANCE, "c366460.d75972", PageFinder.via(r211), null, 4, null);
        Context r122 = r118.f151671a.m();
        if ((r122 instanceof FragmentActivity) == false) goto L36;
        r102 = r122;
    L36:
        FragmentActivity r123 = (FragmentActivity) r102;
        if (r123 == null) goto L41;
        FragmentManager r124 = r123.getSupportFragmentManager();
        if (r124 == null) goto L41;
        r124.registerFragmentLifecycleCallbacks(r118.f151671a.f151679i, true);
    L41:
        PromotionListController.N(r118.f151671a.A().f151427r, r118.f151671a.m(), "live_preview_shopping_cart", new si2.b("live_preview_shopping_cart", false, false), new PromotionListController.c(null, false, null, null, r212, null, null, null, VideoRef.VALUE_VIDEO_REF_SUBTITLE_POSITION_X), true, null, null, new PreviewClickEntryController$previewClickJumpDispatcher$1$clickFromShoppingCart$1(r118), 32);
        goto L42
    }
}
