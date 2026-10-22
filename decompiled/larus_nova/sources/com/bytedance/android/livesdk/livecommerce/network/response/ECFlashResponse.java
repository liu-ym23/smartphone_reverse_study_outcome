package com.bytedance.android.livesdk.livecommerce.network.response;

import com.bytedance.android.ec.core.event.a;
import com.bytedance.android.ec.model.g;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u000e\n\u0002\u0010\u0000\n\u0002\b\"\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u0002B\u0093\u0001\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0007\u0012\u0016\b\u0002\u0010\u0017\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u000b\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0003\u0012\u001c\b\u0002\u0010\u001b\u001a\u0016\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0010\u0018\u00010\u000b¢\u0006\u0004\b?\u0010@J\t\u0010\u0004\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0006\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\t\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u0017\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u000bHÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0005HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u0011\u001a\u0016\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0010\u0018\u00010\u000bHÆ\u0003J\u0095\u0001\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0012\u001a\u00020\u00032\b\b\u0002\u0010\u0013\u001a\u00020\u00052\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00072\u0016\b\u0002\u0010\u0017\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u000b2\b\b\u0002\u0010\u0018\u001a\u00020\u00052\b\b\u0002\u0010\u0019\u001a\u00020\u00052\b\b\u0002\u0010\u001a\u001a\u00020\u00032\u001c\b\u0002\u0010\u001b\u001a\u0016\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0010\u0018\u00010\u000bHÆ\u0001J\t\u0010\u001d\u001a\u00020\u0007HÖ\u0001J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001J\u0013\u0010!\u001a\u00020\u00052\b\u0010 \u001a\u0004\u0018\u00010\u001fHÖ\u0003R\"\u0010\u0012\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\"\u0010\u0013\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010'\u001a\u0004\b\u0013\u0010(\"\u0004\b)\u0010*R$\u0010\u0014\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010+\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R$\u0010\u0015\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010+\u001a\u0004\b0\u0010-\"\u0004\b1\u0010/R$\u0010\u0016\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010+\u001a\u0004\b2\u0010-\"\u0004\b3\u0010/R0\u0010\u0017\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0017\u00104\u001a\u0004\b5\u00106\"\u0004\b7\u00108R\"\u0010\u0018\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010'\u001a\u0004\b\u0018\u0010(\"\u0004\b9\u0010*R\"\u0010\u0019\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010'\u001a\u0004\b\u0019\u0010(\"\u0004\b:\u0010*R\"\u0010\u001a\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\"\u001a\u0004\b;\u0010$\"\u0004\b<\u0010&R6\u0010\u001b\u001a\u0016\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0010\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001b\u00104\u001a\u0004\b=\u00106\"\u0004\b>\u00108¨\u0006A"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/network/response/ECFlashResponse;", "Lcom/bytedance/android/ec/model/g;", "Ljava/io/Serializable;", "", "component1", "", "component2", "", "component3", "component4", "component5", "", "component6", "component7", "component8", "component9", "", "component10", "hasAuth", "isOpen", "shopId", "names", "ids", "properties", "isNewStyle", "isNeedBarCode", "lastBarCodeState", "properties_adapt_multi", "copy", "toString", "hashCode", "", "other", "equals", "I", "getHasAuth", "()I", "setHasAuth", "(I)V", "Z", "()Z", "setOpen", "(Z)V", "Ljava/lang/String;", "getShopId", "()Ljava/lang/String;", "setShopId", "(Ljava/lang/String;)V", "getNames", "setNames", "getIds", "setIds", "Ljava/util/Map;", "getProperties", "()Ljava/util/Map;", "setProperties", "(Ljava/util/Map;)V", "setNewStyle", "setNeedBarCode", "getLastBarCodeState", "setLastBarCodeState", "getProperties_adapt_multi", "setProperties_adapt_multi", "<init>", "(IZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;ZZILjava/util/Map;)V", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECFlashResponse extends g implements Serializable {

    @SerializedName("is_auth")
    private int hasAuth;

    @SerializedName("last_category_cids")
    private String ids;

    @SerializedName("sku_auth")
    private boolean isNeedBarCode;

    @SerializedName("has_auth")
    private boolean isNewStyle;

    @SerializedName("is_open")
    private boolean isOpen;

    @SerializedName("last_sku_state")
    private int lastBarCodeState;

    @SerializedName("last_category_name")
    private String names;

    @SerializedName("last_properties")
    private Map<String, String> properties;

    @SerializedName("last_properties_multi")
    private Map<String, ? extends List<String>> properties_adapt_multi;

    @SerializedName(a.KEY_SHOP_ID)
    private String shopId;

    public ECFlashResponse() {
        this(0, false, null, null, null, null, false, false, 0, null, 1023, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ECFlashResponse copy$default(ECFlashResponse r110, int r111, boolean r112, String r113, String r114, String r115, Map r116, boolean r117, boolean r118, int r210, Map r211, int r212, Object r213) {
        if ((r212 & 1) == 0) goto L5;
        int r100 = r110.hasAuth;
    L7:
        if ((r212 & 2) == 0) goto L9;
        boolean r101 = r110.isOpen;
    L11:
        if ((r212 & 4) == 0) goto L13;
        String r102 = r110.shopId;
    L15:
        if ((r212 & 8) == 0) goto L17;
        String r103 = r110.names;
    L19:
        if ((r212 & 16) == 0) goto L21;
        String r104 = r110.ids;
    L23:
        if ((r212 & 32) == 0) goto L25;
        Map r105 = r110.properties;
    L27:
        if ((r212 & 64) == 0) goto L29;
        boolean r106 = r110.isNewStyle;
    L31:
        if ((r212 & 128) == 0) goto L33;
        boolean r107 = r110.isNeedBarCode;
    L35:
        if ((r212 & 256) == 0) goto L37;
        int r119 = r110.lastBarCodeState;
    L39:
        if ((r212 & 512) == 0) goto L41;
        Map r108 = r110.properties_adapt_multi;
    L43:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107, r119, r108);
    L41:
        r108 = r211;
        goto L43
    L37:
        r119 = r210;
        goto L39
    L33:
        r107 = r118;
        goto L35
    L29:
        r106 = r117;
        goto L31
    L25:
        r105 = r116;
        goto L27
    L21:
        r104 = r115;
        goto L23
    L17:
        r103 = r114;
        goto L19
    L13:
        r102 = r113;
        goto L15
    L9:
        r101 = r112;
        goto L11
    L5:
        r100 = r111;
        goto L7
    }

    public final int component1() {
        return this.hasAuth;
    }

    public final Map<String, List<String>> component10() {
        return this.properties_adapt_multi;
    }

    public final boolean component2() {
        return this.isOpen;
    }

    public final String component3() {
        return this.shopId;
    }

    public final String component4() {
        return this.names;
    }

    public final String component5() {
        return this.ids;
    }

    public final Map<String, String> component6() {
        return this.properties;
    }

    public final boolean component7() {
        return this.isNewStyle;
    }

    public final boolean component8() {
        return this.isNeedBarCode;
    }

    public final int component9() {
        return this.lastBarCodeState;
    }

    public final ECFlashResponse copy(int r110, boolean r111, String r112, String r113, String r114, Map<String, String> r115, boolean r116, boolean r210, int r211, Map<String, ? extends List<String>> r212) {
        return new ECFlashResponse(r110, r111, r112, r113, r114, r115, r116, r210, r211, r212);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof ECFlashResponse) == false) goto L26;
        ECFlashResponse r101 = (ECFlashResponse) r100;
        if (this.hasAuth == r101.hasAuth) goto L8;
        return false;
    L8:
        if (this.isOpen == r101.isOpen) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.shopId, r101.shopId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.names, r101.names) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.ids, r101.ids) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.properties, r101.properties) == true) goto L18;
        return false;
    L18:
        if (this.isNewStyle == r101.isNewStyle) goto L20;
        return false;
    L20:
        if (this.isNeedBarCode == r101.isNeedBarCode) goto L22;
        return false;
    L22:
        if (this.lastBarCodeState == r101.lastBarCodeState) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.properties_adapt_multi, r101.properties_adapt_multi) == true) goto L40;
        return false;
    L40:
        return true;
    L26:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v12, types: [int] */
    /* JADX WARN: Type inference failed for: r0v2, types: [int] */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v15, types: [int] */
    /* JADX WARN: Type inference failed for: r1v19 */
    /* JADX WARN: Type inference failed for: r1v24 */
    /* JADX WARN: Type inference failed for: r1v25 */
    /* JADX WARN: Type inference failed for: r1v26 */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v2 */
    public int hashCode() {
        int r100 = this.hasAuth * 31;
        boolean r101 = this.isOpen;
        ?? r102 = 1;
        ?? r103 = r101;
        if (r101 == false) goto L5;
        r103 = 1;
    L5:
        int r104 = (r100 + r103) * 31;
        String r105 = this.shopId;
        int r106 = 0;
        if (r105 == null) goto L8;
        int r107 = r105.hashCode();
    L9:
        int r108 = (r104 + r107) * 31;
        String r109 = this.names;
        if (r109 == null) goto L12;
        int r110 = r109.hashCode();
    L13:
        int r111 = (r108 + r110) * 31;
        String r112 = this.ids;
        if (r112 == null) goto L16;
        int r113 = r112.hashCode();
    L17:
        int r114 = (r111 + r113) * 31;
        Map<String, String> r115 = this.properties;
        if (r115 == null) goto L20;
        int r116 = r115.hashCode();
    L21:
        int r117 = (r114 + r116) * 31;
        boolean r118 = this.isNewStyle;
        ?? r119 = r118;
        if (r118 == false) goto L24;
        r119 = 1;
    L24:
        int r120 = (r117 + r119) * 31;
        boolean r121 = this.isNeedBarCode;
        if (r121 == true) goto L28;
        r102 = r121;
    L28:
        int r122 = (((r120 + r102) * 31) + this.lastBarCodeState) * 31;
        Map<String, ? extends List<String>> r123 = this.properties_adapt_multi;
        if (r123 == null) goto L32;
        r106 = r123.hashCode();
    L32:
        return r122 + r106;
    L20:
        r116 = 0;
        goto L21
    L16:
        r113 = 0;
        goto L17
    L12:
        r110 = 0;
        goto L13
    L8:
        r107 = 0;
        goto L9
    }

    public String toString() {
        return "ECFlashResponse(hasAuth=" + this.hasAuth + ", isOpen=" + this.isOpen + ", shopId=" + this.shopId + ", names=" + this.names + ", ids=" + this.ids + ", properties=" + this.properties + ", isNewStyle=" + this.isNewStyle + ", isNeedBarCode=" + this.isNeedBarCode + ", lastBarCodeState=" + this.lastBarCodeState + ", properties_adapt_multi=" + this.properties_adapt_multi + ")";
    }

    public final int getHasAuth() {
        return this.hasAuth;
    }

    public final String getIds() {
        return this.ids;
    }

    public final int getLastBarCodeState() {
        return this.lastBarCodeState;
    }

    public final String getNames() {
        return this.names;
    }

    public final Map<String, String> getProperties() {
        return this.properties;
    }

    public final Map<String, List<String>> getProperties_adapt_multi() {
        return this.properties_adapt_multi;
    }

    public final String getShopId() {
        return this.shopId;
    }

    public final boolean isNeedBarCode() {
        return this.isNeedBarCode;
    }

    public final boolean isNewStyle() {
        return this.isNewStyle;
    }

    public final boolean isOpen() {
        return this.isOpen;
    }

    public final void setHasAuth(int r100) {
        this.hasAuth = r100;
    }

    public final void setIds(String r100) {
        this.ids = r100;
    }

    public final void setLastBarCodeState(int r100) {
        this.lastBarCodeState = r100;
    }

    public final void setNames(String r100) {
        this.names = r100;
    }

    public final void setNeedBarCode(boolean r100) {
        this.isNeedBarCode = r100;
    }

    public final void setNewStyle(boolean r100) {
        this.isNewStyle = r100;
    }

    public final void setOpen(boolean r100) {
        this.isOpen = r100;
    }

    public final void setProperties(Map<String, String> r100) {
        this.properties = r100;
    }

    public final void setProperties_adapt_multi(Map<String, ? extends List<String>> r100) {
        this.properties_adapt_multi = r100;
    }

    public final void setShopId(String r100) {
        this.shopId = r100;
    }

    public ECFlashResponse(int r100, boolean r101, String r102, String r103, String r104, Map<String, String> r105, boolean r106, boolean r107, int r108, Map<String, ? extends List<String>> r110) {
        this.hasAuth = r100;
        this.isOpen = r101;
        this.shopId = r102;
        this.names = r103;
        this.ids = r104;
        this.properties = r105;
        this.isNewStyle = r106;
        this.isNeedBarCode = r107;
        this.lastBarCodeState = r108;
        this.properties_adapt_multi = r110;
    }

    public /* synthetic */ ECFlashResponse(int r110, boolean r111, String r112, String r113, String r114, Map r115, boolean r116, boolean r210, int r211, Map r212, int r213, DefaultConstructorMarker r214) {
        int r100 = 0;
        if ((r213 & 1) == 0) goto L5;
        int r101 = 0;
    L7:
        if ((r213 & 2) == 0) goto L9;
        boolean r102 = false;
    L10:
        Map r103 = null;
        if ((r213 & 4) == 0) goto L13;
        String r104 = null;
    L15:
        if ((r213 & 8) == 0) goto L17;
        String r105 = null;
    L19:
        if ((r213 & 16) == 0) goto L21;
        String r106 = null;
    L23:
        if ((r213 & 32) == 0) goto L25;
        Map r107 = null;
    L27:
        if ((r213 & 64) == 0) goto L29;
        boolean r108 = false;
    L31:
        if ((r213 & 128) == 0) goto L33;
        boolean r117 = false;
    L35:
        if ((r213 & 256) != 0) goto L39;
        r100 = r211;
    L39:
        if ((r213 & 512) != 0) goto L42;
        r103 = r212;
    L42:
        this(r101, r102, r104, r105, r106, r107, r108, r117, r100, r103);
        return;
    L33:
        r117 = r210;
        goto L35
    L29:
        r108 = r116;
        goto L31
    L25:
        r107 = r115;
        goto L27
    L21:
        r106 = r114;
        goto L23
    L17:
        r105 = r113;
        goto L19
    L13:
        r104 = r112;
        goto L15
    L9:
        r102 = r111;
        goto L10
    L5:
        r101 = r110;
        goto L7
    }
}
