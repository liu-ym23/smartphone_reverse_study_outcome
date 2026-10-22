package com.bytedance.android.ec.model.response;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/ec/model/response/PromotionExtendType;", "", "COMBINATION", "GIVEN", "GENERAL_BANNER", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final enum PromotionExtendType extends Enum<PromotionExtendType> {

    @SerializedName("1")
    public static final PromotionExtendType COMBINATION = null;

    @SerializedName("3")
    public static final PromotionExtendType GENERAL_BANNER = null;

    @SerializedName("2")
    public static final PromotionExtendType GIVEN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PromotionExtendType[] f47916a = null;

    static {
        PromotionExtendType r100 = new PromotionExtendType("COMBINATION", 0);
        COMBINATION = r100;
        PromotionExtendType r101 = new PromotionExtendType("GIVEN", 1);
        GIVEN = r101;
        PromotionExtendType r102 = new PromotionExtendType("GENERAL_BANNER", 2);
        GENERAL_BANNER = r102;
        f47916a = new PromotionExtendType[]{r100, r101, r102};
    }

    public static PromotionExtendType valueOf(String r100) {
        return (PromotionExtendType) r27.a.a(PromotionExtendType.class, r100);
    }

    public static PromotionExtendType[] values() {
        return (PromotionExtendType[]) f47916a.clone();
    }

    public PromotionExtendType(String r100, int r101) {
        super(r100, r101);
    }
}
