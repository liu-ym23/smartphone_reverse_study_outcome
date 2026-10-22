package com.bytedance.android.ec.model.response;

import com.bytedance.ee.bear.middleground.comment.adapter.CardAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/ec/model/response/BenefitLabelElementType;", "", CardAdapter.TEXT, "IMAGE", "COUNT_DOWN", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final enum BenefitLabelElementType extends Enum<BenefitLabelElementType> {

    @SerializedName("3")
    public static final BenefitLabelElementType COUNT_DOWN = null;

    @SerializedName("2")
    public static final BenefitLabelElementType IMAGE = null;

    @SerializedName("1")
    public static final BenefitLabelElementType TEXT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ BenefitLabelElementType[] f47897a = null;

    static {
        BenefitLabelElementType r100 = new BenefitLabelElementType(CardAdapter.TEXT, 0);
        TEXT = r100;
        BenefitLabelElementType r101 = new BenefitLabelElementType("IMAGE", 1);
        IMAGE = r101;
        BenefitLabelElementType r102 = new BenefitLabelElementType("COUNT_DOWN", 2);
        COUNT_DOWN = r102;
        f47897a = new BenefitLabelElementType[]{r100, r101, r102};
    }

    public static BenefitLabelElementType valueOf(String r100) {
        return (BenefitLabelElementType) r27.a.a(BenefitLabelElementType.class, r100);
    }

    public static BenefitLabelElementType[] values() {
        return (BenefitLabelElementType[]) f47897a.clone();
    }

    public BenefitLabelElementType(String r100, int r101) {
        super(r100, r101);
    }
}
