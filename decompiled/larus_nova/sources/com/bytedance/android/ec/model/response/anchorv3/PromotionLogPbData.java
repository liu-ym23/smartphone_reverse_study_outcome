package com.bytedance.android.ec.model.response.anchorv3;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\t\u001a\u00020\nR \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/ec/model/response/anchorv3/PromotionLogPbData;", "Ljava/io/Serializable;", "()V", "imprId", "", "getImprId", "()Ljava/lang/String;", "setImprId", "(Ljava/lang/String;)V", "asJSONDescription", "Lorg/json/JSONObject;", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class PromotionLogPbData implements Serializable {

    @SerializedName("impr_id")
    private String imprId;

    public PromotionLogPbData() {
    }

    public final JSONObject asJSONDescription() {
        JSONObject r100 = new JSONObject();
        r100.put("impr_id", this.imprId);
        return r100;
    }

    public final String getImprId() {
        return this.imprId;
    }

    public final void setImprId(String r100) {
        this.imprId = r100;
    }
}
