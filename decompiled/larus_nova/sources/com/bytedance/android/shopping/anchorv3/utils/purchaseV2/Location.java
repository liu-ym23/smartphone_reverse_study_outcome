package com.bytedance.android.shopping.anchorv3.utils.purchaseV2;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/shopping/anchorv3/utils/purchaseV2/Location;", "", "", "value", "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "GOOD_FEED_PRODUCT_CARD", "GOOD_FEED_PRODUCT_CARD_REFACTOR", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum Location extends Enum<Location> {
    public static final Location GOOD_FEED_PRODUCT_CARD = null;
    public static final Location GOOD_FEED_PRODUCT_CARD_REFACTOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ Location[] f165326a = null;
    private final String value;

    static {
        Location r100 = new Location("GOOD_FEED_PRODUCT_CARD", 0, "good_feed_product_card");
        GOOD_FEED_PRODUCT_CARD = r100;
        Location r101 = new Location("GOOD_FEED_PRODUCT_CARD_REFACTOR", 1, "good_feed_product_card_refactor");
        GOOD_FEED_PRODUCT_CARD_REFACTOR = r101;
        f165326a = new Location[]{r100, r101};
    }

    public static Location valueOf(String r100) {
        return (Location) r27.a.a(Location.class, r100);
    }

    public static Location[] values() {
        return (Location[]) f165326a.clone();
    }

    public final String getValue() {
        return this.value;
    }

    public Location(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}
