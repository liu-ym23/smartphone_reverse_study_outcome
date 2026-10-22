package com.bytedance.android.ec.model.response;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/ec/model/response/PromotionPriceType;", "", "SHOW_PRICE", "COUNT_DOWN", "SHOW_TEXT", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final enum PromotionPriceType extends Enum<PromotionPriceType> {

    @SerializedName("2")
    public static final PromotionPriceType COUNT_DOWN = null;

    @SerializedName("1")
    public static final PromotionPriceType SHOW_PRICE = null;

    @SerializedName("3")
    public static final PromotionPriceType SHOW_TEXT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PromotionPriceType[] f47917a = null;

    static {
        PromotionPriceType r100 = new PromotionPriceType("SHOW_PRICE", 0);
        SHOW_PRICE = r100;
        PromotionPriceType r101 = new PromotionPriceType("COUNT_DOWN", 1);
        COUNT_DOWN = r101;
        PromotionPriceType r102 = new PromotionPriceType("SHOW_TEXT", 2);
        SHOW_TEXT = r102;
        f47917a = new PromotionPriceType[]{r100, r101, r102};
    }

    public static PromotionPriceType valueOf(String r100) {
        return (PromotionPriceType) r27.a.a(PromotionPriceType.class, r100);
    }

    public static PromotionPriceType[] values() {
        return (PromotionPriceType[]) f47917a.clone();
    }

    public PromotionPriceType(String r100, int r101) {
        super(r100, r101);
    }
}
