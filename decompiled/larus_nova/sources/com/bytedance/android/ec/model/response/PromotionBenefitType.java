package com.bytedance.android.ec.model.response;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/android/ec/model/response/PromotionBenefitType;", "", "ELASTIC_TITLE", "TAG", "BENEFIT_LABEL", "PROGRESS_BAR", "TAG_PLATFORM", "CUSTOM_TAG", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final enum PromotionBenefitType extends Enum<PromotionBenefitType> {

    @SerializedName("3")
    public static final PromotionBenefitType BENEFIT_LABEL = null;

    @SerializedName("6")
    public static final PromotionBenefitType CUSTOM_TAG = null;

    @SerializedName("1")
    public static final PromotionBenefitType ELASTIC_TITLE = null;

    @SerializedName("4")
    public static final PromotionBenefitType PROGRESS_BAR = null;

    @SerializedName("2")
    public static final PromotionBenefitType TAG = null;

    @SerializedName("5")
    public static final PromotionBenefitType TAG_PLATFORM = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PromotionBenefitType[] f47915a = null;

    static {
        PromotionBenefitType r100 = new PromotionBenefitType("ELASTIC_TITLE", 0);
        ELASTIC_TITLE = r100;
        PromotionBenefitType r101 = new PromotionBenefitType("TAG", 1);
        TAG = r101;
        PromotionBenefitType r102 = new PromotionBenefitType("BENEFIT_LABEL", 2);
        BENEFIT_LABEL = r102;
        PromotionBenefitType r103 = new PromotionBenefitType("PROGRESS_BAR", 3);
        PROGRESS_BAR = r103;
        PromotionBenefitType r104 = new PromotionBenefitType("TAG_PLATFORM", 4);
        TAG_PLATFORM = r104;
        PromotionBenefitType r105 = new PromotionBenefitType("CUSTOM_TAG", 5);
        CUSTOM_TAG = r105;
        f47915a = new PromotionBenefitType[]{r100, r101, r102, r103, r104, r105};
    }

    public static PromotionBenefitType valueOf(String r100) {
        return (PromotionBenefitType) r27.a.a(PromotionBenefitType.class, r100);
    }

    public static PromotionBenefitType[] values() {
        return (PromotionBenefitType[]) f47915a.clone();
    }

    public PromotionBenefitType(String r100, int r101) {
        super(r100, r101);
    }
}
