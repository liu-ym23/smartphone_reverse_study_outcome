package com.bytedance.android.ec.model.response.anchorv3;

import com.android.ttcjpaysdk.base.CJPayConstant;
import com.bytedance.android.shopping.buynow.data.model.BuyNowUrlType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0006HÆ\u0003J3\u0010\u0010\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0006HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/ec/model/response/anchorv3/PromotionAdditionModulesInfoDTO;", "Ljava/io/Serializable;", "schema", "", "hybridSchema", "orderList", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getHybridSchema", "()Ljava/lang/String;", "getOrderList", "()Ljava/util/List;", "getSchema", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class PromotionAdditionModulesInfoDTO implements Serializable {

    @SerializedName("hybrid_schema")
    private final String hybridSchema;

    @SerializedName(BuyNowUrlType.ORDER_LIST)
    private final List<String> orderList;

    @SerializedName(CJPayConstant.CJ_PAY_RETAIN_INFO_V2_SCHEMA_KEY)
    private final String schema;

    public PromotionAdditionModulesInfoDTO() {
        this(null, null, null, 7, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ PromotionAdditionModulesInfoDTO copy$default(PromotionAdditionModulesInfoDTO r100, String r101, String r102, List r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.schema;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.hybridSchema;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.orderList;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final String component1() {
        return this.schema;
    }

    public final String component2() {
        return this.hybridSchema;
    }

    public final List<String> component3() {
        return this.orderList;
    }

    public final PromotionAdditionModulesInfoDTO copy(String r100, String r101, List<String> r102) {
        return new PromotionAdditionModulesInfoDTO(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof PromotionAdditionModulesInfoDTO) == false) goto L12;
        PromotionAdditionModulesInfoDTO r101 = (PromotionAdditionModulesInfoDTO) r100;
        if (Intrinsics.areEqual(this.schema, r101.schema) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.hybridSchema, r101.hybridSchema) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.orderList, r101.orderList) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public int hashCode() {
        String r100 = this.schema;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.hybridSchema;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        List<String> r107 = this.orderList;
        if (r107 == null) goto L14;
        r101 = r107.hashCode();
    L14:
        return r106 + r101;
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public String toString() {
        return "PromotionAdditionModulesInfoDTO(schema=" + this.schema + ", hybridSchema=" + this.hybridSchema + ", orderList=" + this.orderList + ")";
    }

    public final String getHybridSchema() {
        return this.hybridSchema;
    }

    public final List<String> getOrderList() {
        return this.orderList;
    }

    public final String getSchema() {
        return this.schema;
    }

    public PromotionAdditionModulesInfoDTO(String r100, String r101, List<String> r102) {
        this.schema = r100;
        this.hybridSchema = r101;
        this.orderList = r102;
    }

    public /* synthetic */ PromotionAdditionModulesInfoDTO(String r100, String r101, List r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r103 & 4) == 0) goto L11;
        r102 = null;
    L11:
        this(r100, r101, r102);
    }
}
