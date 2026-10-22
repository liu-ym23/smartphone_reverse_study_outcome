package com.bytedance.android.shopping.store.slicecard;

import com.bytedance.bdlocation.exception.BDLocationException;
import com.tencent.connect.common.Constants;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u000f\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/shopping/store/slicecard/SliceItemType;", "", "", "type", "Ljava/lang/String;", "getType", "()Ljava/lang/String;", "SHOP_TOP_BAR", "SHOP_PROFILE", "SHOP_PROFILE_CONCISE", "SHOP_PRODUCT_LIST_PRODUCT_CARD", "SHOP_PRODUCT_LIST_PRODUCT_CARD_CARDPACK", "SHOP_PRODUCT_LIST_PRODUCT_CARD_TREND", "SHOP_INNER_FLOW_TOP_BAR", "SHOP_FILTER", "SHOP_SEARCH_RESULT_PAGE", "SHOP_CLASSIFICATION_SECOND_PAGE", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum SliceItemType extends Enum<SliceItemType> {
    public static final SliceItemType SHOP_CLASSIFICATION_SECOND_PAGE = null;
    public static final SliceItemType SHOP_FILTER = null;
    public static final SliceItemType SHOP_INNER_FLOW_TOP_BAR = null;
    public static final SliceItemType SHOP_PRODUCT_LIST_PRODUCT_CARD = null;
    public static final SliceItemType SHOP_PRODUCT_LIST_PRODUCT_CARD_CARDPACK = null;
    public static final SliceItemType SHOP_PRODUCT_LIST_PRODUCT_CARD_TREND = null;
    public static final SliceItemType SHOP_PROFILE = null;
    public static final SliceItemType SHOP_PROFILE_CONCISE = null;
    public static final SliceItemType SHOP_SEARCH_RESULT_PAGE = null;
    public static final SliceItemType SHOP_TOP_BAR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ SliceItemType[] f186328a = null;
    private final String type;

    public static SliceItemType valueOf(String r100) {
        return (SliceItemType) r27.a.a(SliceItemType.class, r100);
    }

    public static SliceItemType[] values() {
        return (SliceItemType[]) f186328a.clone();
    }

    static {
        SliceItemType r100 = new SliceItemType("SHOP_TOP_BAR", 0, "shop_top_bar");
        SHOP_TOP_BAR = r100;
        SliceItemType r101 = new SliceItemType("SHOP_PROFILE", 1, "shop_profile");
        SHOP_PROFILE = r101;
        SliceItemType r102 = new SliceItemType("SHOP_PROFILE_CONCISE", 2, "shop_profile_concise");
        SHOP_PROFILE_CONCISE = r102;
        SliceItemType r103 = new SliceItemType("SHOP_PRODUCT_LIST_PRODUCT_CARD", 3, "3");
        SHOP_PRODUCT_LIST_PRODUCT_CARD = r103;
        SliceItemType r104 = new SliceItemType("SHOP_PRODUCT_LIST_PRODUCT_CARD_CARDPACK", 4, BDLocationException.ERROR_UID_IS_EMPTY);
        SHOP_PRODUCT_LIST_PRODUCT_CARD_CARDPACK = r104;
        SliceItemType r105 = new SliceItemType("SHOP_PRODUCT_LIST_PRODUCT_CARD_TREND", 5, Constants.VIA_REPORT_TYPE_START_GROUP);
        SHOP_PRODUCT_LIST_PRODUCT_CARD_TREND = r105;
        SliceItemType r106 = new SliceItemType("SHOP_INNER_FLOW_TOP_BAR", 6, "201");
        SHOP_INNER_FLOW_TOP_BAR = r106;
        SliceItemType r107 = new SliceItemType("SHOP_FILTER", 7, "shop_filter");
        SHOP_FILTER = r107;
        SliceItemType r108 = new SliceItemType("SHOP_SEARCH_RESULT_PAGE", 8, "shop_search_result_page");
        SHOP_SEARCH_RESULT_PAGE = r108;
        SliceItemType r109 = new SliceItemType("SHOP_CLASSIFICATION_SECOND_PAGE", 9, "cate_second_page");
        SHOP_CLASSIFICATION_SECOND_PAGE = r109;
        f186328a = new SliceItemType[]{r100, r101, r102, r103, r104, r105, r106, r107, r108, r109};
    }

    public final String getType() {
        return this.type;
    }

    public SliceItemType(String r100, int r101, String r102) {
        super(r100, r101);
        this.type = r102;
    }
}
