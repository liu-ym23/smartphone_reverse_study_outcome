package com.bytedance.android.livesdk.livecommerce.room.controller.related;

/* JADX INFO: loaded from: classes10.dex */
public final /* synthetic */ class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f151709a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int[] f151710b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int[] f151711c = null;

    static {
        int[] r100 = new int[IRelatedInfoManager$FromSource.values().length];
        f151709a = r100;
        r100[IRelatedInfoManager$FromSource.JUMP_SCHEMA.ordinal()] = 1;
        r100[IRelatedInfoManager$FromSource.LIVE_LIST_TAB_RESORT_ABILITY.ordinal()] = 2;
        int[] r101 = new int[IRelatedInfoManager$Scene.values().length];
        f151710b = r101;
        IRelatedInfoManager$Scene r102 = IRelatedInfoManager$Scene.PROMOTION_LIST;
        r101[r102.ordinal()] = 1;
        int[] r103 = new int[IRelatedInfoManager$Scene.values().length];
        f151711c = r103;
        r103[r102.ordinal()] = 1;
        r103[IRelatedInfoManager$Scene.GOODS_LIST_TAB.ordinal()] = 2;
        r103[IRelatedInfoManager$Scene.CARRY_ON_CARD.ordinal()] = 3;
    }
}
