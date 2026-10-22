package com.bytedance.android.ec.model.response.anchorv3;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u001e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/ec/model/response/anchorv3/PromotionProductSkuStruct;", "Ljava/io/Serializable;", "()V", "specKey", "", "getSpecKey", "()Ljava/lang/String;", "specNameList", "", "getSpecNameList", "()Ljava/util/List;", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class PromotionProductSkuStruct implements Serializable {

    @SerializedName("spec_key")
    private final String specKey;

    @SerializedName("spec_name")
    private final List<String> specNameList;

    public PromotionProductSkuStruct() {
    }

    public final String getSpecKey() {
        return this.specKey;
    }

    public final List<String> getSpecNameList() {
        return this.specNameList;
    }
}
