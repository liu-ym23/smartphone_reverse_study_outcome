package com.bytedance.android.ec.common.api.inflow;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/bytedance/android/ec/common/api/inflow/AnchorBenefitSchema;", "Ljava/io/Serializable;", "()V", "halfScreenSchema", "", "getHalfScreenSchema", "()Ljava/lang/String;", "schema", "getSchema", "ec-common-api_release"}, k = 1, mv = {1, 4, 3})
public final class AnchorBenefitSchema implements Serializable {

    @SerializedName("half_screen_click_schema")
    private final String halfScreenSchema;

    @SerializedName("click_schema")
    private final String schema;

    public AnchorBenefitSchema() {
    }

    public final String getHalfScreenSchema() {
        return this.halfScreenSchema;
    }

    public final String getSchema() {
        return this.schema;
    }
}
