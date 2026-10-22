package com.bytedance.android.livesdk.livecommerce.promotionlist.viewmodel;

import com.bytedance.android.livesdk.livecommerce.promotion.card.Decision;
import com.bytedance.android.livesdk.livecommerce.promotion.card.ILivePromotionCardContainerHandler;

/* JADX INFO: loaded from: classes10.dex */
public final /* synthetic */ class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f151347a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int[] f151348b = null;

    static {
        int[] r100 = new int[Decision.values().length];
        f151347a = r100;
        r100[Decision.DEGRADE_HOT_ATMOSPHERE.ordinal()] = 1;
        r100[Decision.HIDE_EXPLAINING_ANIM.ordinal()] = 2;
        r100[Decision.DEGRADE_SALE_POINT_LOOP.ordinal()] = 3;
        r100[Decision.PROMOTION_CARD_CLOSE_STYLE.ordinal()] = 4;
        r100[Decision.DISPLAY_TWO_LINE_TITLE.ordinal()] = 5;
        r100[Decision.ADJUST_INSTANT_FUSION.ordinal()] = 6;
        r100[Decision.SHORTEN_BTN_INSTANT_FUSION.ordinal()] = 7;
        r100[Decision.IS_IN_SPLIT_SCREEN.ordinal()] = 8;
        int[] r101 = new int[ILivePromotionCardContainerHandler.ContainerPriority.values().length];
        f151348b = r101;
        r101[ILivePromotionCardContainerHandler.ContainerPriority.LigoInitDataMap.ordinal()] = 1;
        r101[ILivePromotionCardContainerHandler.ContainerPriority.AddressInfo.ordinal()] = 2;
    }
}
