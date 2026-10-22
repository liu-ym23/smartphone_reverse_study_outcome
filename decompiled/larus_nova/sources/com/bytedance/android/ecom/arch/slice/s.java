package com.bytedance.android.ecom.arch.slice;

import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001R\"\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001c\u0010\t\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/bytedance/android/ecom/arch/slice/s;", "", "", "Lcom/google/gson/JsonObject;", "rules", "Ljava/util/List;", "getRules", "()Ljava/util/List;", "", "btmId", "Ljava/lang/String;", "getBtmId", "()Ljava/lang/String;", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class s {

    @SerializedName("btm_id")
    private final String btmId;

    @SerializedName("rules")
    private final List<JsonObject> rules;

    public s() {
        this.rules = null;
        this.btmId = null;
    }
}
