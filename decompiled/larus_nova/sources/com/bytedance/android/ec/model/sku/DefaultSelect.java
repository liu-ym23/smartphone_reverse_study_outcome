package com.bytedance.android.ec.model.sku;

import com.bytedance.android.ec.core.event.a;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001BI\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n¢\u0006\u0002\u0010\fJ\u0006\u0010\u001b\u001a\u00020\u001cJ\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0019J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010 \u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u000eJ\t\u0010!\u001a\u00020\nHÆ\u0003J\t\u0010\"\u001a\u00020\nHÆ\u0003JR\u0010#\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\nHÆ\u0001¢\u0006\u0002\u0010$J\u0013\u0010%\u001a\u00020\n2\b\u0010&\u001a\u0004\u0018\u00010'HÖ\u0003J\t\u0010(\u001a\u00020\u0005HÖ\u0001J\t\u0010)\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000eR\u001c\u0010\t\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0016\u0010\u000b\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0016R\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b\u0018\u0010\u0019¨\u0006*"}, d2 = {"Lcom/bytedance/android/ec/model/sku/DefaultSelect;", "Ljava/io/Serializable;", "skuId", "", "type", "", "lastSelectedSkuId", "buyNum", "", "disableHotSaleSelect", "", "disableServerSpecsDefaultSelect", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Long;ZZ)V", "getBuyNum", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getDisableHotSaleSelect$annotations", "()V", "getDisableHotSaleSelect", "()Z", "getDisableServerSpecsDefaultSelect", "getLastSelectedSkuId", "()Ljava/lang/String;", "getSkuId", "getType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "asJSONDescription", "Lorg/json/JSONObject;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Long;ZZ)Lcom/bytedance/android/ec/model/sku/DefaultSelect;", "equals", "other", "", "hashCode", "toString", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class DefaultSelect implements Serializable {

    @SerializedName("buy_num")
    private final Long buyNum;

    @SerializedName("disable_hotsale_select")
    private final boolean disableHotSaleSelect;

    @SerializedName("disable_server_specs_default_select")
    private final boolean disableServerSpecsDefaultSelect;

    @SerializedName("last_selected_sku_id")
    private final String lastSelectedSkuId;

    @SerializedName(a.KEY_SKU_ID)
    private final String skuId;

    @SerializedName("type")
    private final Integer type;

    public DefaultSelect() {
        this(null, null, null, null, false, false, 63, null);
    }

    public static /* synthetic */ DefaultSelect copy$default(DefaultSelect r100, String r101, Integer r102, String r103, Long r104, boolean r105, boolean r110, int r111, Object r112) {
        if ((r111 & 1) == 0) goto L6;
        r101 = r100.skuId;
    L6:
        if ((r111 & 2) == 0) goto L8;
        r102 = r100.type;
    L8:
        Integer r113 = r102;
        if ((r111 & 4) == 0) goto L11;
        r103 = r100.lastSelectedSkuId;
    L11:
        String r106 = r103;
        if ((r111 & 8) == 0) goto L14;
        r104 = r100.buyNum;
    L14:
        Long r107 = r104;
        if ((r111 & 16) == 0) goto L17;
        r105 = r100.disableHotSaleSelect;
    L17:
        boolean r108 = r105;
        if ((r111 & 32) == 0) goto L20;
        r110 = r100.disableServerSpecsDefaultSelect;
    L20:
        String r109 = r101;
        return r100.copy(r109, r113, r106, r107, r108, r110);
    }

    @Deprecated(message = "不允许使用")
    public static /* synthetic */ void getDisableHotSaleSelect$annotations() {
    }

    public final String component1() {
        return this.skuId;
    }

    public final Integer component2() {
        return this.type;
    }

    public final String component3() {
        return this.lastSelectedSkuId;
    }

    public final Long component4() {
        return this.buyNum;
    }

    public final boolean component5() {
        return this.disableHotSaleSelect;
    }

    public final boolean component6() {
        return this.disableServerSpecsDefaultSelect;
    }

    public final DefaultSelect copy(String r100, Integer r110, String r111, Long r112, boolean r113, boolean r114) {
        return new DefaultSelect(r100, r110, r111, r112, r113, r114);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof DefaultSelect) == false) goto L18;
        DefaultSelect r101 = (DefaultSelect) r100;
        if (Intrinsics.areEqual(this.skuId, r101.skuId) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.type, r101.type) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.lastSelectedSkuId, r101.lastSelectedSkuId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.buyNum, r101.buyNum) == true) goto L14;
        return false;
    L14:
        if (this.disableHotSaleSelect == r101.disableHotSaleSelect) goto L16;
        return false;
    L16:
        if (this.disableServerSpecsDefaultSelect == r101.disableServerSpecsDefaultSelect) goto L28;
        return false;
    L28:
        return true;
    L18:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10, types: [int] */
    /* JADX WARN: Type inference failed for: r0v12, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r2v7 */
    /* JADX WARN: Type inference failed for: r2v8, types: [int] */
    /* JADX WARN: Type inference failed for: r2v9 */
    public int hashCode() {
        String r100 = this.skuId;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        Integer r104 = this.type;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.lastSelectedSkuId;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        Long r110 = this.buyNum;
        if (r110 == null) goto L17;
        r101 = r110.hashCode();
    L17:
        int r111 = (r109 + r101) * 31;
        boolean r112 = this.disableHotSaleSelect;
        ?? r113 = 1;
        ?? r114 = r112;
        if (r112 == false) goto L20;
        r114 = 1;
    L20:
        int r115 = (r111 + r114) * 31;
        boolean r116 = this.disableServerSpecsDefaultSelect;
        if (r116 == true) goto L25;
        r113 = r116;
    L25:
        return r115 + r113;
    L13:
        r108 = 0;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public String toString() {
        return "DefaultSelect(skuId=" + this.skuId + ", type=" + this.type + ", lastSelectedSkuId=" + this.lastSelectedSkuId + ", buyNum=" + this.buyNum + ", disableHotSaleSelect=" + this.disableHotSaleSelect + ", disableServerSpecsDefaultSelect=" + this.disableServerSpecsDefaultSelect + ")";
    }

    public final JSONObject asJSONDescription() {
        JSONObject r100 = new JSONObject();
        r100.put(a.KEY_SKU_ID, this.skuId);
        r100.put("type", this.type);
        r100.put("last_selected_sku_id", this.lastSelectedSkuId);
        r100.put("buy_num", this.buyNum);
        return r100;
    }

    public final Long getBuyNum() {
        return this.buyNum;
    }

    public final boolean getDisableHotSaleSelect() {
        return this.disableHotSaleSelect;
    }

    public final boolean getDisableServerSpecsDefaultSelect() {
        return this.disableServerSpecsDefaultSelect;
    }

    public final String getLastSelectedSkuId() {
        return this.lastSelectedSkuId;
    }

    public final String getSkuId() {
        return this.skuId;
    }

    public final Integer getType() {
        return this.type;
    }

    public DefaultSelect(String r100, Integer r101, String r102, Long r103, boolean r104, boolean r105) {
        this.skuId = r100;
        this.type = r101;
        this.lastSelectedSkuId = r102;
        this.buyNum = r103;
        this.disableHotSaleSelect = r104;
        this.disableServerSpecsDefaultSelect = r105;
    }

    public /* synthetic */ DefaultSelect(String r100, Integer r101, String r102, Long r103, boolean r104, boolean r110, int r111, DefaultConstructorMarker r112) {
        Long r105 = null;
        if ((r111 & 1) == 0) goto L5;
        String r113 = null;
    L7:
        if ((r111 & 2) == 0) goto L9;
        Integer r106 = null;
    L11:
        if ((r111 & 4) == 0) goto L13;
        String r107 = null;
    L15:
        if ((r111 & 8) != 0) goto L19;
        r105 = r103;
    L19:
        if ((r111 & 16) == 0) goto L21;
        boolean r108 = false;
    L23:
        if ((r111 & 32) == 0) goto L25;
        boolean r114 = r108;
    L26:
        this(r113, r106, r107, r105, r108, r114);
        return;
    L25:
        r114 = r110;
        goto L26
    L21:
        r108 = r104;
        goto L23
    L13:
        r107 = r102;
        goto L15
    L9:
        r106 = r101;
        goto L11
    L5:
        r113 = r100;
        goto L7
    }
}
