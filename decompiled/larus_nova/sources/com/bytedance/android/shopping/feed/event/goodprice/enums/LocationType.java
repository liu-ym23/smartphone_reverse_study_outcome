package com.bytedance.android.shopping.feed.event.goodprice.enums;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/bytedance/android/shopping/feed/event/goodprice/enums/LocationType;", "", "", "type", "Ljava/lang/String;", "getType", "()Ljava/lang/String;", "INFLOW_MAIN_CARD_TAG", "INFLOW_RESOURCE_CARD_MAIN", "INFLOW_RESOURCE_CARD_SEARCH", "INFLOW_MAIN_CARD_TITLE", "INFLOW_MAIN_CARD_IMAGE", "INFLOW_MAIN_CARD_IMAGE_WIDTH_FEEDBACK", "ec-biz-inner-flow-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum LocationType extends Enum<LocationType> {
    public static final LocationType INFLOW_MAIN_CARD_IMAGE = null;
    public static final LocationType INFLOW_MAIN_CARD_IMAGE_WIDTH_FEEDBACK = null;
    public static final LocationType INFLOW_MAIN_CARD_TAG = null;
    public static final LocationType INFLOW_MAIN_CARD_TITLE = null;
    public static final LocationType INFLOW_RESOURCE_CARD_MAIN = null;
    public static final LocationType INFLOW_RESOURCE_CARD_SEARCH = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LocationType[] f174743a = null;
    private final String type;

    static {
        LocationType r100 = new LocationType("INFLOW_MAIN_CARD_TAG", 0, "inflow_main_card_tag");
        INFLOW_MAIN_CARD_TAG = r100;
        LocationType r101 = new LocationType("INFLOW_RESOURCE_CARD_MAIN", 1, "inflow_resource_card_main");
        INFLOW_RESOURCE_CARD_MAIN = r101;
        LocationType r102 = new LocationType("INFLOW_RESOURCE_CARD_SEARCH", 2, "inflow_resource_card_search");
        INFLOW_RESOURCE_CARD_SEARCH = r102;
        LocationType r103 = new LocationType("INFLOW_MAIN_CARD_TITLE", 3, "inflow_main_card_title");
        INFLOW_MAIN_CARD_TITLE = r103;
        LocationType r104 = new LocationType("INFLOW_MAIN_CARD_IMAGE", 4, "inflow_main_card_image");
        INFLOW_MAIN_CARD_IMAGE = r104;
        LocationType r105 = new LocationType("INFLOW_MAIN_CARD_IMAGE_WIDTH_FEEDBACK", 5, "inflow_main_card_image_with_feedback");
        INFLOW_MAIN_CARD_IMAGE_WIDTH_FEEDBACK = r105;
        f174743a = new LocationType[]{r100, r101, r102, r103, r104, r105};
    }

    public static LocationType valueOf(String r100) {
        return (LocationType) a.a(LocationType.class, r100);
    }

    public static LocationType[] values() {
        return (LocationType[]) f174743a.clone();
    }

    public final String getType() {
        return this.type;
    }

    public LocationType(String r100, int r101, String r102) {
        super(r100, r101);
        this.type = r102;
    }
}
