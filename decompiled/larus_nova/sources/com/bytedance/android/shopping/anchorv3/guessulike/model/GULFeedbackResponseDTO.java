package com.bytedance.android.shopping.anchorv3.guessulike.model;

import com.bytedance.android.ec.model.api.CommerceBaseResponse;
import com.google.gson.annotations.SerializedName;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R$\u0010\u0003\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/shopping/anchorv3/guessulike/model/GULFeedbackResponseDTO;", "Lcom/bytedance/android/ec/model/api/CommerceBaseResponse;", "()V", "negFeedbackStyles", "", "", "Lcom/bytedance/android/shopping/anchorv3/guessulike/model/NegFeedbackStyle;", "getNegFeedbackStyles", "()Ljava/util/Map;", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class GULFeedbackResponseDTO extends CommerceBaseResponse {

    @SerializedName("neg_feedback_styles")
    private final Map<String, NegFeedbackStyle> negFeedbackStyles;

    public GULFeedbackResponseDTO() {
    }

    public final Map<String, NegFeedbackStyle> getNegFeedbackStyles() {
        return this.negFeedbackStyles;
    }
}
