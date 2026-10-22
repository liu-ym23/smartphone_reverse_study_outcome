package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.preload.p006new;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/preload/new/GiftPreloadResType;", "", "ITEM_LIST_DATA", "GIFT_ICON", "ICON_ANIMATOR_URI", "GIFT_PANEL_VIEW", "ANNIE_LYNX_MODEL", "GIFT_EXTRA", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum GiftPreloadResType extends Enum<GiftPreloadResType> {
    public static final GiftPreloadResType ANNIE_LYNX_MODEL = null;
    public static final GiftPreloadResType GIFT_EXTRA = null;
    public static final GiftPreloadResType GIFT_ICON = null;
    public static final GiftPreloadResType GIFT_PANEL_VIEW = null;
    public static final GiftPreloadResType ICON_ANIMATOR_URI = null;
    public static final GiftPreloadResType ITEM_LIST_DATA = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ GiftPreloadResType[] f128198a = null;

    static {
        GiftPreloadResType r100 = new GiftPreloadResType("ITEM_LIST_DATA", 0);
        ITEM_LIST_DATA = r100;
        GiftPreloadResType r101 = new GiftPreloadResType("GIFT_ICON", 1);
        GIFT_ICON = r101;
        GiftPreloadResType r102 = new GiftPreloadResType("ICON_ANIMATOR_URI", 2);
        ICON_ANIMATOR_URI = r102;
        GiftPreloadResType r103 = new GiftPreloadResType("GIFT_PANEL_VIEW", 3);
        GIFT_PANEL_VIEW = r103;
        GiftPreloadResType r104 = new GiftPreloadResType("ANNIE_LYNX_MODEL", 4);
        ANNIE_LYNX_MODEL = r104;
        GiftPreloadResType r105 = new GiftPreloadResType("GIFT_EXTRA", 5);
        GIFT_EXTRA = r105;
        f128198a = new GiftPreloadResType[]{r100, r101, r102, r103, r104, r105};
    }

    public static GiftPreloadResType valueOf(String r100) {
        return (GiftPreloadResType) a.a(GiftPreloadResType.class, r100);
    }

    public static GiftPreloadResType[] values() {
        return (GiftPreloadResType[]) f128198a.clone();
    }

    public GiftPreloadResType(String r100, int r101) {
        super(r100, r101);
    }
}
