package com.bytedance.android.shopping.store.home.frame.container;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u000b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/shopping/store/home/frame/container/ShopContainerType;", "", "LIVE_PREVIEW_CONTAINER", "BACKGROUND_CONTAINER", "LIVE_TAB_CONTAINER", "TAB_CONTENT_CONTAINER", "SHOP_TOPBAR_CONTAINER", "SHOP_INFO_CONTAINER", "SHOP_LYNX", "BOTTOM_BAR_CONTAINER", "RIGHT_FLOAT_WIDGET_CONTAINER", "ROOT_CONTAINER", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum ShopContainerType extends Enum<ShopContainerType> {
    public static final ShopContainerType BACKGROUND_CONTAINER = null;
    public static final ShopContainerType BOTTOM_BAR_CONTAINER = null;
    public static final ShopContainerType LIVE_PREVIEW_CONTAINER = null;
    public static final ShopContainerType LIVE_TAB_CONTAINER = null;
    public static final ShopContainerType RIGHT_FLOAT_WIDGET_CONTAINER = null;
    public static final ShopContainerType ROOT_CONTAINER = null;
    public static final ShopContainerType SHOP_INFO_CONTAINER = null;
    public static final ShopContainerType SHOP_LYNX = null;
    public static final ShopContainerType SHOP_TOPBAR_CONTAINER = null;
    public static final ShopContainerType TAB_CONTENT_CONTAINER = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ShopContainerType[] f183767a = null;

    static {
        ShopContainerType r100 = new ShopContainerType("LIVE_PREVIEW_CONTAINER", 0);
        LIVE_PREVIEW_CONTAINER = r100;
        ShopContainerType r101 = new ShopContainerType("BACKGROUND_CONTAINER", 1);
        BACKGROUND_CONTAINER = r101;
        ShopContainerType r102 = new ShopContainerType("LIVE_TAB_CONTAINER", 2);
        LIVE_TAB_CONTAINER = r102;
        ShopContainerType r103 = new ShopContainerType("TAB_CONTENT_CONTAINER", 3);
        TAB_CONTENT_CONTAINER = r103;
        ShopContainerType r104 = new ShopContainerType("SHOP_TOPBAR_CONTAINER", 4);
        SHOP_TOPBAR_CONTAINER = r104;
        ShopContainerType r105 = new ShopContainerType("SHOP_INFO_CONTAINER", 5);
        SHOP_INFO_CONTAINER = r105;
        ShopContainerType r106 = new ShopContainerType("SHOP_LYNX", 6);
        SHOP_LYNX = r106;
        ShopContainerType r107 = new ShopContainerType("BOTTOM_BAR_CONTAINER", 7);
        BOTTOM_BAR_CONTAINER = r107;
        ShopContainerType r108 = new ShopContainerType("RIGHT_FLOAT_WIDGET_CONTAINER", 8);
        RIGHT_FLOAT_WIDGET_CONTAINER = r108;
        ShopContainerType r109 = new ShopContainerType("ROOT_CONTAINER", 9);
        ROOT_CONTAINER = r109;
        f183767a = new ShopContainerType[]{r100, r101, r102, r103, r104, r105, r106, r107, r108, r109};
    }

    public static ShopContainerType valueOf(String r100) {
        return (ShopContainerType) a.a(ShopContainerType.class, r100);
    }

    public static ShopContainerType[] values() {
        return (ShopContainerType[]) f183767a.clone();
    }

    public ShopContainerType(String r100, int r101) {
        super(r100, r101);
    }
}
