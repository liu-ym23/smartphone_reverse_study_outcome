package com.bytedance.android.shopping.card_list.hybrid;

import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.shopping.extensions.b;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0016\n\u0002\u0010\u0000\n\u0002\b&\b\u0086\b\u0018\u0000 G2\u00020\u0001:\u0001HB\u0081\u0001\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\u0016\u001a\u00020\t\u0012\b\b\u0002\u0010\u0017\u001a\u00020\t\u0012\b\b\u0002\u0010\u0018\u001a\u00020\f\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\u001a\u001a\u00020\f\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\u001c\u001a\u00020\f\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\bE\u0010FJ\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0010\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\t\u0010\n\u001a\u00020\tHÆ\u0003J\t\u0010\u000b\u001a\u00020\tHÆ\u0003J\t\u0010\r\u001a\u00020\fHÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\t\u0010\u000f\u001a\u00020\fHÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\t\u0010\u0011\u001a\u00020\fHÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u0083\u0001\u0010 \u001a\u00020\u00002\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\u0016\u001a\u00020\t2\b\b\u0002\u0010\u0017\u001a\u00020\t2\b\b\u0002\u0010\u0018\u001a\u00020\f2\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\u001a\u001a\u00020\f2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\u001c\u001a\u00020\f2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\t\u0010!\u001a\u00020\u0007HÖ\u0001J\t\u0010\"\u001a\u00020\tHÖ\u0001J\u0013\u0010%\u001a\u00020\f2\b\u0010$\u001a\u0004\u0018\u00010#HÖ\u0003R$\u0010\u0015\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010&\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\"\u0010\u0016\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010+\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\"\u0010\u0017\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010+\u001a\u0004\b0\u0010-\"\u0004\b1\u0010/R\"\u0010\u0018\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0018\u00102\u001a\u0004\b3\u00104\"\u0004\b5\u00106R$\u0010\u0019\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010&\u001a\u0004\b7\u0010(\"\u0004\b8\u0010*R\"\u0010\u001a\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001a\u00102\u001a\u0004\b9\u00104\"\u0004\b:\u00106R$\u0010\u001b\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010&\u001a\u0004\b;\u0010(\"\u0004\b<\u0010*R\"\u0010\u001c\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001c\u00102\u001a\u0004\b=\u00104\"\u0004\b>\u00106R$\u0010\u001d\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010&\u001a\u0004\b?\u0010(\"\u0004\b@\u0010*R$\u0010\u001e\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010&\u001a\u0004\bA\u0010(\"\u0004\bB\u0010*R$\u0010\u001f\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010&\u001a\u0004\bC\u0010(\"\u0004\bD\u0010*¨\u0006I"}, d2 = {"Lcom/bytedance/android/shopping/card_list/hybrid/CardListHybridDialogPrams;", "Ljava/io/Serializable;", "Lorg/json/JSONObject;", "getCloseTriggerParams", "params", "", "setCloseTriggerParams", "", "component1", "", "component2", "component3", "", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "schema", "heightPercent", "bottomOffset", "hasMask", "maskColor", "maskClickDisable", "type", "enablePullUp", "closeTriggerEvent", "closeTriggerParamsJson", "popupCode", "copy", "toString", "hashCode", "", "other", "equals", "Ljava/lang/String;", "getSchema", "()Ljava/lang/String;", "setSchema", "(Ljava/lang/String;)V", "I", "getHeightPercent", "()I", "setHeightPercent", "(I)V", "getBottomOffset", "setBottomOffset", "Z", "getHasMask", "()Z", "setHasMask", "(Z)V", "getMaskColor", "setMaskColor", "getMaskClickDisable", "setMaskClickDisable", "getType", "setType", "getEnablePullUp", "setEnablePullUp", "getCloseTriggerEvent", "setCloseTriggerEvent", "getCloseTriggerParamsJson", "setCloseTriggerParamsJson", "getPopupCode", "setPopupCode", "<init>", "(Ljava/lang/String;IIZLjava/lang/String;ZLjava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CardListHybridDialogPrams implements Serializable {
    public static final a Companion = null;
    private static final long serialVersionUID = 1;

    @SerializedName("bottomOffset")
    private int bottomOffset;

    @SerializedName("closeTriggerEvent")
    private String closeTriggerEvent;

    @SerializedName("closeTriggerParams")
    private String closeTriggerParamsJson;

    @SerializedName("enablePullUp")
    private boolean enablePullUp;

    @SerializedName("hasMask")
    private boolean hasMask;

    @SerializedName("heightPercent")
    private int heightPercent;

    @SerializedName("maskClickDisable")
    private boolean maskClickDisable;

    @SerializedName("maskColor")
    private String maskColor;

    @SerializedName("popupCode")
    private String popupCode;

    @SerializedName("schema")
    private String schema;

    @SerializedName("type")
    private String type;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public CardListHybridDialogPrams() {
        this(null, 0, 0, false, null, false, null, false, null, null, null, 2047, null);
    }

    public static /* synthetic */ CardListHybridDialogPrams copy$default(CardListHybridDialogPrams r110, String r111, int r112, int r113, boolean r114, String r115, boolean r116, String r117, boolean r210, String r211, String r212, String r213, int r214, Object r215) {
        if ((r214 & 1) == 0) goto L5;
        String r100 = r110.schema;
    L7:
        if ((r214 & 2) == 0) goto L9;
        int r101 = r110.heightPercent;
    L11:
        if ((r214 & 4) == 0) goto L13;
        int r102 = r110.bottomOffset;
    L15:
        if ((r214 & 8) == 0) goto L17;
        boolean r103 = r110.hasMask;
    L19:
        if ((r214 & 16) == 0) goto L21;
        String r104 = r110.maskColor;
    L23:
        if ((r214 & 32) == 0) goto L25;
        boolean r105 = r110.maskClickDisable;
    L27:
        if ((r214 & 64) == 0) goto L29;
        String r106 = r110.type;
    L31:
        if ((r214 & 128) == 0) goto L33;
        boolean r107 = r110.enablePullUp;
    L35:
        if ((r214 & 256) == 0) goto L37;
        String r118 = r110.closeTriggerEvent;
    L39:
        if ((r214 & 512) == 0) goto L41;
        String r119 = r110.closeTriggerParamsJson;
    L43:
        if ((r214 & 1024) == 0) goto L45;
        String r108 = r110.popupCode;
    L47:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107, r118, r119, r108);
    L45:
        r108 = r213;
        goto L47
    L41:
        r119 = r212;
        goto L43
    L37:
        r118 = r211;
        goto L39
    L33:
        r107 = r210;
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

    public final String component1() {
        return this.schema;
    }

    public final String component10() {
        return this.closeTriggerParamsJson;
    }

    public final String component11() {
        return this.popupCode;
    }

    public final int component2() {
        return this.heightPercent;
    }

    public final int component3() {
        return this.bottomOffset;
    }

    public final boolean component4() {
        return this.hasMask;
    }

    public final String component5() {
        return this.maskColor;
    }

    public final boolean component6() {
        return this.maskClickDisable;
    }

    public final String component7() {
        return this.type;
    }

    public final boolean component8() {
        return this.enablePullUp;
    }

    public final String component9() {
        return this.closeTriggerEvent;
    }

    public final CardListHybridDialogPrams copy(String r110, int r111, int r112, boolean r113, String r114, boolean r115, String r210, boolean r211, String r212, String r213, String r214) {
        return new CardListHybridDialogPrams(r110, r111, r112, r113, r114, r115, r210, r211, r212, r213, r214);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof CardListHybridDialogPrams) == false) goto L28;
        CardListHybridDialogPrams r101 = (CardListHybridDialogPrams) r100;
        if (Intrinsics.areEqual(this.schema, r101.schema) == true) goto L8;
        return false;
    L8:
        if (this.heightPercent == r101.heightPercent) goto L10;
        return false;
    L10:
        if (this.bottomOffset == r101.bottomOffset) goto L12;
        return false;
    L12:
        if (this.hasMask == r101.hasMask) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.maskColor, r101.maskColor) == true) goto L16;
        return false;
    L16:
        if (this.maskClickDisable == r101.maskClickDisable) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.type, r101.type) == true) goto L20;
        return false;
    L20:
        if (this.enablePullUp == r101.enablePullUp) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.closeTriggerEvent, r101.closeTriggerEvent) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.closeTriggerParamsJson, r101.closeTriggerParamsJson) == true) goto L26;
        return false;
    L26:
        if (Intrinsics.areEqual(this.popupCode, r101.popupCode) == true) goto L43;
        return false;
    L43:
        return true;
    L28:
        return false;
    }

    public final JSONObject getCloseTriggerParams() {
        String r100 = this.closeTriggerParamsJson;     // Catch: Exception -> L8
        if (r100 == null) goto L13;
        return new JSONObject(r100);
    L13:
        return null;
    L8:
        e = move-exception;
        ECExceptionMonitor.e(e);
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v8, types: [int] */
    /* JADX WARN: Type inference failed for: r2v23 */
    /* JADX WARN: Type inference failed for: r2v25 */
    /* JADX WARN: Type inference failed for: r2v26 */
    /* JADX WARN: Type inference failed for: r2v27 */
    /* JADX WARN: Type inference failed for: r2v3, types: [int] */
    /* JADX WARN: Type inference failed for: r2v8, types: [int] */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v2 */
    public int hashCode() {
        String r100 = this.schema;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = ((((r102 * 31) + this.heightPercent) * 31) + this.bottomOffset) * 31;
        boolean r104 = this.hasMask;
        ?? r105 = 1;
        ?? r106 = r104;
        if (r104 == false) goto L9;
        r106 = 1;
    L9:
        int r107 = (r103 + r106) * 31;
        String r108 = this.maskColor;
        if (r108 == null) goto L12;
        int r109 = r108.hashCode();
    L13:
        int r110 = (r107 + r109) * 31;
        boolean r111 = this.maskClickDisable;
        ?? r112 = r111;
        if (r111 == false) goto L16;
        r112 = 1;
    L16:
        int r113 = (r110 + r112) * 31;
        String r114 = this.type;
        if (r114 == null) goto L19;
        int r115 = r114.hashCode();
    L20:
        int r116 = (r113 + r115) * 31;
        boolean r117 = this.enablePullUp;
        if (r117 == true) goto L24;
        r105 = r117;
    L24:
        int r118 = (r116 + r105) * 31;
        String r119 = this.closeTriggerEvent;
        if (r119 == null) goto L27;
        int r120 = r119.hashCode();
    L28:
        int r121 = (r118 + r120) * 31;
        String r122 = this.closeTriggerParamsJson;
        if (r122 == null) goto L31;
        int r123 = r122.hashCode();
    L32:
        int r124 = (r121 + r123) * 31;
        String r125 = this.popupCode;
        if (r125 == null) goto L36;
        r101 = r125.hashCode();
    L36:
        return r124 + r101;
    L31:
        r123 = 0;
        goto L32
    L27:
        r120 = 0;
        goto L28
    L19:
        r115 = 0;
        goto L20
    L12:
        r109 = 0;
        goto L13
    L5:
        r102 = 0;
        goto L6
    }

    public String toString() {
        return "CardListHybridDialogPrams(schema=" + this.schema + ", heightPercent=" + this.heightPercent + ", bottomOffset=" + this.bottomOffset + ", hasMask=" + this.hasMask + ", maskColor=" + this.maskColor + ", maskClickDisable=" + this.maskClickDisable + ", type=" + this.type + ", enablePullUp=" + this.enablePullUp + ", closeTriggerEvent=" + this.closeTriggerEvent + ", closeTriggerParamsJson=" + this.closeTriggerParamsJson + ", popupCode=" + this.popupCode + ")";
    }

    public final int getBottomOffset() {
        return this.bottomOffset;
    }

    public final String getCloseTriggerEvent() {
        return this.closeTriggerEvent;
    }

    public final String getCloseTriggerParamsJson() {
        return this.closeTriggerParamsJson;
    }

    public final boolean getEnablePullUp() {
        return this.enablePullUp;
    }

    public final boolean getHasMask() {
        return this.hasMask;
    }

    public final int getHeightPercent() {
        return this.heightPercent;
    }

    public final boolean getMaskClickDisable() {
        return this.maskClickDisable;
    }

    public final String getMaskColor() {
        return this.maskColor;
    }

    public final String getPopupCode() {
        return this.popupCode;
    }

    public final String getSchema() {
        return this.schema;
    }

    public final String getType() {
        return this.type;
    }

    public final void setBottomOffset(int r100) {
        this.bottomOffset = r100;
    }

    public final void setCloseTriggerEvent(String r100) {
        this.closeTriggerEvent = r100;
    }

    public final void setCloseTriggerParams(JSONObject r100) {
        if (r100 == null) goto L4;
        String r101 = r100.toString();
    L5:
        this.closeTriggerParamsJson = r101;
        return;
    L4:
        r101 = null;
        goto L5
    }

    public final void setCloseTriggerParamsJson(String r100) {
        this.closeTriggerParamsJson = r100;
    }

    public final void setEnablePullUp(boolean r100) {
        this.enablePullUp = r100;
    }

    public final void setHasMask(boolean r100) {
        this.hasMask = r100;
    }

    public final void setHeightPercent(int r100) {
        this.heightPercent = r100;
    }

    public final void setMaskClickDisable(boolean r100) {
        this.maskClickDisable = r100;
    }

    public final void setMaskColor(String r100) {
        this.maskColor = r100;
    }

    public final void setPopupCode(String r100) {
        this.popupCode = r100;
    }

    public final void setSchema(String r100) {
        this.schema = r100;
    }

    public final void setType(String r100) {
        this.type = r100;
    }

    public CardListHybridDialogPrams(String r100, int r101, int r102, boolean r103, String r104, boolean r105, String r106, boolean r107, String r108, String r110, String r111) {
        this.schema = r100;
        this.heightPercent = r101;
        this.bottomOffset = r102;
        this.hasMask = r103;
        this.maskColor = r104;
        this.maskClickDisable = r105;
        this.type = r106;
        this.enablePullUp = r107;
        this.closeTriggerEvent = r108;
        this.closeTriggerParamsJson = r110;
        this.popupCode = r111;
    }

    public /* synthetic */ CardListHybridDialogPrams(String r110, int r111, int r112, boolean r113, String r114, boolean r115, String r116, boolean r210, String r211, String r212, String r213, int r214, DefaultConstructorMarker r215) {
        String r100 = null;
        if ((r214 & 1) == 0) goto L5;
        String r101 = null;
    L7:
        if ((r214 & 2) == 0) goto L9;
        int r102 = 73;
    L11:
        if ((r214 & 4) == 0) goto L13;
        int r103 = b.b(75);
    L15:
        if ((r214 & 8) == 0) goto L17;
        boolean r104 = true;
    L19:
        if ((r214 & 16) == 0) goto L21;
        String r105 = "1711276032";
    L22:
        boolean r106 = false;
        if ((r214 & 32) == 0) goto L25;
        boolean r107 = false;
    L27:
        if ((r214 & 64) == 0) goto L29;
        String r108 = null;
    L31:
        if ((r214 & 128) != 0) goto L35;
        r106 = r210;
    L35:
        if ((r214 & 256) == 0) goto L37;
        String r117 = null;
    L39:
        if ((r214 & 512) == 0) goto L41;
        String r118 = null;
    L43:
        if ((r214 & 1024) != 0) goto L46;
        r100 = r213;
    L46:
        this(r101, r102, r103, r104, r105, r107, r108, r106, r117, r118, r100);
        return;
    L41:
        r118 = r212;
        goto L43
    L37:
        r117 = r211;
        goto L39
    L29:
        r108 = r116;
        goto L31
    L25:
        r107 = r115;
        goto L27
    L21:
        r105 = r114;
        goto L22
    L17:
        r104 = r113;
        goto L19
    L13:
        r103 = r112;
        goto L15
    L9:
        r102 = r111;
        goto L11
    L5:
        r101 = r110;
        goto L7
    }
}
