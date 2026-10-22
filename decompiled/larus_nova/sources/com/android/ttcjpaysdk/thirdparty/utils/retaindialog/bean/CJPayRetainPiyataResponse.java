package com.android.ttcjpaysdk.thirdparty.utils.retaindialog.bean;

import com.ss.android.ugc.route_monitor.impl.route_out.control.bean.ControlRule;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BA\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003¢\u0006\u0002\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003JO\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020 HÖ\u0001J\b\u0010!\u001a\u00020\u0003H\u0016R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\rR\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\r¨\u0006\""}, d2 = {"Lcom/android/ttcjpaysdk/thirdparty/utils/retaindialog/bean/CJPayRetainPiyataResponse;", "", "subType", "", ControlRule.KEY_RULE_ID, "growthViewModel", "Lorg/json/JSONObject;", "contactRetainInfo", "isClientDecision", "priorLynxSchema", "material", "(Ljava/lang/String;Ljava/lang/String;Lorg/json/JSONObject;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getContactRetainInfo", "()Ljava/lang/String;", "getGrowthViewModel", "()Lorg/json/JSONObject;", "getMaterial", "getPriorLynxSchema", "getRuleId", "getSubType", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "hashCode", "", "toString", "bdpay-base_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJPayRetainPiyataResponse {
    private final String contactRetainInfo;
    private final JSONObject growthViewModel;
    private final String isClientDecision;
    private final String material;
    private final String priorLynxSchema;
    private final String ruleId;
    private final String subType;

    public static /* synthetic */ CJPayRetainPiyataResponse copy$default(CJPayRetainPiyataResponse r100, String r101, String r102, JSONObject r103, String r104, String r110, String r111, String r112, int r113, Object r114) {
        if ((r113 & 1) == 0) goto L6;
        r101 = r100.subType;
    L6:
        if ((r113 & 2) == 0) goto L8;
        r102 = r100.ruleId;
    L8:
        String r115 = r102;
        if ((r113 & 4) == 0) goto L11;
        r103 = r100.growthViewModel;
    L11:
        JSONObject r105 = r103;
        if ((r113 & 8) == 0) goto L14;
        r104 = r100.contactRetainInfo;
    L14:
        String r106 = r104;
        if ((r113 & 16) == 0) goto L17;
        r110 = r100.isClientDecision;
    L17:
        String r107 = r110;
        if ((r113 & 32) == 0) goto L20;
        r111 = r100.priorLynxSchema;
    L20:
        String r108 = r111;
        if ((r113 & 64) == 0) goto L23;
        r112 = r100.material;
    L23:
        String r109 = r101;
        return r100.copy(r109, r115, r105, r106, r107, r108, r112);
    }

    public final String component1() {
        return this.subType;
    }

    public final String component2() {
        return this.ruleId;
    }

    public final JSONObject component3() {
        return this.growthViewModel;
    }

    public final String component4() {
        return this.contactRetainInfo;
    }

    public final String component5() {
        return this.isClientDecision;
    }

    public final String component6() {
        return this.priorLynxSchema;
    }

    public final String component7() {
        return this.material;
    }

    public final CJPayRetainPiyataResponse copy(String r110, String r111, JSONObject r112, String r113, String r114, String r115, String r116) {
        Intrinsics.checkNotNullParameter(r110, "subType");
        Intrinsics.checkNotNullParameter(r111, ControlRule.KEY_RULE_ID);
        Intrinsics.checkNotNullParameter(r112, "growthViewModel");
        Intrinsics.checkNotNullParameter(r113, "contactRetainInfo");
        Intrinsics.checkNotNullParameter(r114, "isClientDecision");
        Intrinsics.checkNotNullParameter(r115, "priorLynxSchema");
        Intrinsics.checkNotNullParameter(r116, "material");
        return new CJPayRetainPiyataResponse(r110, r111, r112, r113, r114, r115, r116);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof CJPayRetainPiyataResponse) == true) goto L8;
        return false;
    L8:
        CJPayRetainPiyataResponse r101 = (CJPayRetainPiyataResponse) r100;
        if (Intrinsics.areEqual(this.subType, r101.subType) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.ruleId, r101.ruleId) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.growthViewModel, r101.growthViewModel) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.contactRetainInfo, r101.contactRetainInfo) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.isClientDecision, r101.isClientDecision) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.priorLynxSchema, r101.priorLynxSchema) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.material, r101.material) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public int hashCode() {
        return (((((((((((this.subType.hashCode() * 31) + this.ruleId.hashCode()) * 31) + this.growthViewModel.hashCode()) * 31) + this.contactRetainInfo.hashCode()) * 31) + this.isClientDecision.hashCode()) * 31) + this.priorLynxSchema.hashCode()) * 31) + this.material.hashCode();
    }

    public String toString() {
        return "CJPayRetainPiyataResponse(subType='" + this.subType + "', ruleId='" + this.ruleId + "', growthViewModel=" + this.growthViewModel + ", contactRetainInfo='" + this.contactRetainInfo + "', isClientDecision='" + this.isClientDecision + "', priorLynxSchema='" + this.priorLynxSchema + "', material='" + this.material + "')";
    }

    public final String getContactRetainInfo() {
        return this.contactRetainInfo;
    }

    public final JSONObject getGrowthViewModel() {
        return this.growthViewModel;
    }

    public final String getMaterial() {
        return this.material;
    }

    public final String getPriorLynxSchema() {
        return this.priorLynxSchema;
    }

    public final String getRuleId() {
        return this.ruleId;
    }

    public final String getSubType() {
        return this.subType;
    }

    public final String isClientDecision() {
        return this.isClientDecision;
    }

    public CJPayRetainPiyataResponse(String r100, String r101, JSONObject r102, String r103, String r104, String r105, String r106) {
        Intrinsics.checkNotNullParameter(r100, "subType");
        Intrinsics.checkNotNullParameter(r101, ControlRule.KEY_RULE_ID);
        Intrinsics.checkNotNullParameter(r102, "growthViewModel");
        Intrinsics.checkNotNullParameter(r103, "contactRetainInfo");
        Intrinsics.checkNotNullParameter(r104, "isClientDecision");
        Intrinsics.checkNotNullParameter(r105, "priorLynxSchema");
        Intrinsics.checkNotNullParameter(r106, "material");
        this.subType = r100;
        this.ruleId = r101;
        this.growthViewModel = r102;
        this.contactRetainInfo = r103;
        this.isClientDecision = r104;
        this.priorLynxSchema = r105;
        this.material = r106;
    }

    public /* synthetic */ CJPayRetainPiyataResponse(String r110, String r111, JSONObject r112, String r113, String r114, String r115, String r116, int r117, DefaultConstructorMarker r118) {
        if ((r117 & 32) == 0) goto L5;
        String r100 = "";
    L7:
        if ((r117 & 64) == 0) goto L9;
        String r101 = "";
    L10:
        this(r110, r111, r112, r113, r114, r100, r101);
        return;
    L9:
        r101 = r116;
        goto L10
    L5:
        r100 = r115;
        goto L7
    }
}
