package com.bytedance.android.ec.window.base.status;

import com.larus.nova.R;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/bytedance/android/ec/window/base/status/StructType;", "", "", "drawableRes", "I", "getDrawableRes", "()I", "TOP_BAR_LOADING", "STORE_INFO_LOADING", "SORT_BAR_LOADING", "PRODUCT_LOADING", "PRODUCT_DOUBLE_LOADING", "PRODUCT_SIGNLE_LOADING", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum StructType extends Enum<StructType> {
    public static final StructType PRODUCT_DOUBLE_LOADING = null;
    public static final StructType PRODUCT_LOADING = null;
    public static final StructType PRODUCT_SIGNLE_LOADING = null;
    public static final StructType SORT_BAR_LOADING = null;
    public static final StructType STORE_INFO_LOADING = null;
    public static final StructType TOP_BAR_LOADING = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ StructType[] f49689a = null;
    private final int drawableRes;

    static {
        StructType r100 = new StructType("TOP_BAR_LOADING", 0, R.drawable.ec_window_top_bar_loading);
        TOP_BAR_LOADING = r100;
        StructType r101 = new StructType("STORE_INFO_LOADING", 1, R.drawable.ec_window_info_area_loading);
        STORE_INFO_LOADING = r101;
        StructType r102 = new StructType("SORT_BAR_LOADING", 2, R.drawable.ec_window_sort_bar_loading);
        SORT_BAR_LOADING = r102;
        StructType r103 = new StructType("PRODUCT_LOADING", 3, R.drawable.ec_window_product_card_loading);
        PRODUCT_LOADING = r103;
        StructType r104 = new StructType("PRODUCT_DOUBLE_LOADING", 4, R.drawable.ec_window_product_card_loading_double);
        PRODUCT_DOUBLE_LOADING = r104;
        StructType r105 = new StructType("PRODUCT_SIGNLE_LOADING", 5, R.drawable.ec_window_product_card_loading_signle);
        PRODUCT_SIGNLE_LOADING = r105;
        f49689a = new StructType[]{r100, r101, r102, r103, r104, r105};
    }

    public static StructType valueOf(String r100) {
        return (StructType) r27.a.a(StructType.class, r100);
    }

    public static StructType[] values() {
        return (StructType[]) f49689a.clone();
    }

    public final int getDrawableRes() {
        return this.drawableRes;
    }

    public StructType(String r100, int r101, int r102) {
        super(r100, r101);
        this.drawableRes = r102;
    }
}
