package com.bytedance.android.ec.model.response;

import com.bytedance.ee.bear.middleground.comment.adapter.CardAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/ec/model/response/PriceDescriptionType;", "", CardAdapter.TEXT, "REGULAR_PRICE", "EXCLUSIVE", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final enum PriceDescriptionType extends Enum<PriceDescriptionType> {

    @SerializedName("3")
    public static final PriceDescriptionType EXCLUSIVE = null;

    @SerializedName("2")
    public static final PriceDescriptionType REGULAR_PRICE = null;

    @SerializedName("1")
    public static final PriceDescriptionType TEXT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PriceDescriptionType[] f47913a = null;

    static {
        PriceDescriptionType r100 = new PriceDescriptionType(CardAdapter.TEXT, 0);
        TEXT = r100;
        PriceDescriptionType r101 = new PriceDescriptionType("REGULAR_PRICE", 1);
        REGULAR_PRICE = r101;
        PriceDescriptionType r102 = new PriceDescriptionType("EXCLUSIVE", 2);
        EXCLUSIVE = r102;
        f47913a = new PriceDescriptionType[]{r100, r101, r102};
    }

    public static PriceDescriptionType valueOf(String r100) {
        return (PriceDescriptionType) r27.a.a(PriceDescriptionType.class, r100);
    }

    public static PriceDescriptionType[] values() {
        return (PriceDescriptionType[]) f47913a.clone();
    }

    public PriceDescriptionType(String r100, int r101) {
        super(r100, r101);
    }
}
