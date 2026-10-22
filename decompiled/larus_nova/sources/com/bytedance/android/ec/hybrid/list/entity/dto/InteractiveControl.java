package com.bytedance.android.ec.hybrid.list.entity.dto;

import com.google.gson.JsonElement;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0007\u001a\u00020\b8\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0018\u0010\u000b\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u000f\u001a\u00020\b8\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\nR\u001a\u0010\u0011\u001a\u0004\u0018\u00010\u00128\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0013\u0010\u0014R\u001e\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u00178\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019¨\u0006\u001a"}, d2 = {"Lcom/bytedance/android/ec/hybrid/list/entity/dto/InteractiveControl;", "Ljava/io/Serializable;", "()V", "clientAiBusinessName", "", "getClientAiBusinessName", "()Ljava/lang/String;", "clientAiDecideShow", "", "getClientAiDecideShow", "()Z", "clientAiParams", "Lcom/google/gson/JsonElement;", "getClientAiParams", "()Lcom/google/gson/JsonElement;", "removeUnexposedProducts", "getRemoveUnexposedProducts", "retreatDistance", "", "getRetreatDistance", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "retreatItems", "", "getRetreatItems", "()Ljava/util/List;", "ec-hybrid_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class InteractiveControl implements Serializable {

    @SerializedName("client_ai_business_name")
    private final String clientAiBusinessName;

    @SerializedName("client_ai_decide_show")
    private final boolean clientAiDecideShow;

    @SerializedName("client_ai_input")
    private final JsonElement clientAiParams;

    @SerializedName("remove_unexposed_products")
    private final boolean removeUnexposedProducts;

    @SerializedName("retreat_distance")
    private final Integer retreatDistance;

    @SerializedName("retreat_items")
    private final List<Integer> retreatItems;

    public InteractiveControl() {
    }

    public final String getClientAiBusinessName() {
        return this.clientAiBusinessName;
    }

    public final boolean getClientAiDecideShow() {
        return this.clientAiDecideShow;
    }

    public final JsonElement getClientAiParams() {
        return this.clientAiParams;
    }

    public final boolean getRemoveUnexposedProducts() {
        return this.removeUnexposedProducts;
    }

    public final Integer getRetreatDistance() {
        return this.retreatDistance;
    }

    public final List<Integer> getRetreatItems() {
        return this.retreatItems;
    }
}
