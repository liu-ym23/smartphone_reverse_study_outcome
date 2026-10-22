package com.bytedance.android.shopping.store.home.entity;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u0018\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019¨\u0006\u001a"}, d2 = {"Lcom/bytedance/android/shopping/store/home/entity/ECShopModuleType;", "", "", "type", "Ljava/lang/String;", "getType", "()Ljava/lang/String;", "SHOPBASICINFO", "ABNORMAL_SHOP_BASIC_INFO", "SHOPACCOUNTINFO", "SHOPLISTINFO", "HOMECONFIGINFO", "ABNORMAL_SHOP_HOME_CONFIG_INFO", "SHOPMEDIAINFO", "SHOPHEADERSTYLE", "SHOPLOGEXTRA", "SHOPINFOLYNX", "TOPSEARCHINFO", "SHOP_LIVE_TAB_INFO", "SHOPCARTINFO", "SHOP_SHARE_INFO", "SHOP_SHARE_CARD_INFO", "SHOP_TOOLS_INFO", "SHOP_BRAND_HEADER_STYLE", "SHOP_BRAND_MODULE_INFO", "SHOP_NORMAL_HEADER_INFO", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum ECShopModuleType extends Enum<ECShopModuleType> {
    public static final ECShopModuleType ABNORMAL_SHOP_BASIC_INFO = null;
    public static final ECShopModuleType ABNORMAL_SHOP_HOME_CONFIG_INFO = null;
    public static final ECShopModuleType HOMECONFIGINFO = null;
    public static final ECShopModuleType SHOPACCOUNTINFO = null;
    public static final ECShopModuleType SHOPBASICINFO = null;
    public static final ECShopModuleType SHOPCARTINFO = null;
    public static final ECShopModuleType SHOPHEADERSTYLE = null;
    public static final ECShopModuleType SHOPINFOLYNX = null;
    public static final ECShopModuleType SHOPLISTINFO = null;
    public static final ECShopModuleType SHOPLOGEXTRA = null;
    public static final ECShopModuleType SHOPMEDIAINFO = null;
    public static final ECShopModuleType SHOP_BRAND_HEADER_STYLE = null;
    public static final ECShopModuleType SHOP_BRAND_MODULE_INFO = null;
    public static final ECShopModuleType SHOP_LIVE_TAB_INFO = null;
    public static final ECShopModuleType SHOP_NORMAL_HEADER_INFO = null;
    public static final ECShopModuleType SHOP_SHARE_CARD_INFO = null;
    public static final ECShopModuleType SHOP_SHARE_INFO = null;
    public static final ECShopModuleType SHOP_TOOLS_INFO = null;
    public static final ECShopModuleType TOPSEARCHINFO = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ECShopModuleType[] f183631a = null;
    private final String type;

    public static ECShopModuleType valueOf(String r100) {
        return (ECShopModuleType) r27.a.a(ECShopModuleType.class, r100);
    }

    public static ECShopModuleType[] values() {
        return (ECShopModuleType[]) f183631a.clone();
    }

    static {
        ECShopModuleType r100 = new ECShopModuleType("SHOPBASICINFO", 0, "shop_basic_info");
        SHOPBASICINFO = r100;
        ECShopModuleType r101 = new ECShopModuleType("ABNORMAL_SHOP_BASIC_INFO", 1, "abnormal_shop_basic_info");
        ABNORMAL_SHOP_BASIC_INFO = r101;
        ECShopModuleType r102 = new ECShopModuleType("SHOPACCOUNTINFO", 2, "shop_account_info");
        SHOPACCOUNTINFO = r102;
        ECShopModuleType r103 = new ECShopModuleType("SHOPLISTINFO", 3, "shop_list_info");
        SHOPLISTINFO = r103;
        ECShopModuleType r104 = new ECShopModuleType("HOMECONFIGINFO", 4, "home_config_info");
        HOMECONFIGINFO = r104;
        ECShopModuleType r105 = new ECShopModuleType("ABNORMAL_SHOP_HOME_CONFIG_INFO", 5, "abnormal_shop_home_config_info");
        ABNORMAL_SHOP_HOME_CONFIG_INFO = r105;
        ECShopModuleType r106 = new ECShopModuleType("SHOPMEDIAINFO", 6, "home_media_info");
        SHOPMEDIAINFO = r106;
        ECShopModuleType r107 = new ECShopModuleType("SHOPHEADERSTYLE", 7, "shop_header_style");
        SHOPHEADERSTYLE = r107;
        ECShopModuleType r108 = new ECShopModuleType("SHOPLOGEXTRA", 8, "shop_log_extra");
        SHOPLOGEXTRA = r108;
        ECShopModuleType r109 = new ECShopModuleType("SHOPINFOLYNX", 9, "home_info_lynx");
        SHOPINFOLYNX = r109;
        ECShopModuleType r110 = new ECShopModuleType("TOPSEARCHINFO", 10, "top_search_info");
        TOPSEARCHINFO = r110;
        ECShopModuleType r111 = new ECShopModuleType("SHOP_LIVE_TAB_INFO", 11, "live_tab_home_info");
        SHOP_LIVE_TAB_INFO = r111;
        ECShopModuleType r112 = new ECShopModuleType("SHOPCARTINFO", 12, "shop_cart");
        SHOPCARTINFO = r112;
        ECShopModuleType r113 = new ECShopModuleType("SHOP_SHARE_INFO", 13, "shop_share_info");
        SHOP_SHARE_INFO = r113;
        ECShopModuleType r114 = new ECShopModuleType("SHOP_SHARE_CARD_INFO", 14, "shop_share_card_info");
        SHOP_SHARE_CARD_INFO = r114;
        ECShopModuleType r115 = new ECShopModuleType("SHOP_TOOLS_INFO", 15, "shop_tools_info");
        SHOP_TOOLS_INFO = r115;
        ECShopModuleType r116 = new ECShopModuleType("SHOP_BRAND_HEADER_STYLE", 16, "brand_header_style");
        SHOP_BRAND_HEADER_STYLE = r116;
        ECShopModuleType r117 = new ECShopModuleType("SHOP_BRAND_MODULE_INFO", 17, "brand_module_info");
        SHOP_BRAND_MODULE_INFO = r117;
        ECShopModuleType r118 = new ECShopModuleType("SHOP_NORMAL_HEADER_INFO", 18, "normal_header_info");
        SHOP_NORMAL_HEADER_INFO = r118;
        f183631a = new ECShopModuleType[]{r100, r101, r102, r103, r104, r105, r106, r107, r108, r109, r110, r111, r112, r113, r114, r115, r116, r117, r118};
    }

    public final String getType() {
        return this.type;
    }

    public ECShopModuleType(String r100, int r101, String r102) {
        super(r100, r101);
        this.type = r102;
    }
}
