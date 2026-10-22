package com.stepos.ailauncher.foundation.appui.card.provider.appauther;

import com.autonavi.aps.amapapi.config.Const;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0018\b\u0080\b\u0018\u00002\u00020\u0001B£\u0001\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0017\u001a\u00020\u0016HÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\u001a\u0010\u001a\u001a\u00020\u00062\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001a\u0010\u001bR\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u001c\u001a\u0004\b\u001d\u0010\u0015R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u001c\u001a\u0004\b\u001e\u0010\u0015R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u001c\u001a\u0004\b\u001f\u0010\u0015R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010 \u001a\u0004\b!\u0010\"R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\u001c\u001a\u0004\b#\u0010\u0015R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u001c\u001a\u0004\b$\u0010\u0015R\u001c\u0010\n\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u001c\u001a\u0004\b%\u0010\u0015R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u001c\u001a\u0004\b&\u0010\u0015R\u001c\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\u001c\u001a\u0004\b'\u0010\u0015R\u001c\u0010\r\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u001c\u001a\u0004\b(\u0010\u0015R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u001c\u001a\u0004\b)\u0010\u0015R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u001c\u001a\u0004\b*\u0010\u0015R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010+\u001a\u0004\b,\u0010-¨\u0006."}, d2 = {"Lcom/stepos/ailauncher/foundation/appui/card/provider/appauther/j;", "", "", "templateId", "kind", "frameStatus", "", "reauth", "vendorId", "integrationId", "integrationType", "displayName", "iconUrl", "pendingId", "authText", "modelInstruction", "Lcom/stepos/ailauncher/foundation/appui/card/provider/appauther/m;", "clientAction", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/stepos/ailauncher/foundation/appui/card/provider/appauther/m;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getTemplateId", "getKind", "getFrameStatus", "Ljava/lang/Boolean;", "getReauth", "()Ljava/lang/Boolean;", Const.INTENT_KEY_BACKGROUND_COMMAND, "e", "getIntegrationType", "c", Const.INTENT_KEY_UMID, "f", Const.INTENT_KEY_APIKEY, "getModelInstruction", "Lcom/stepos/ailauncher/foundation/appui/card/provider/appauther/m;", Const.INTENT_KEY_PKGNAME, "()Lcom/stepos/ailauncher/foundation/appui/card/provider/appauther/m;", "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.foundation.appui.card.provider.appauther.j, reason: case insensitive filesystem and from toString */
/* loaded from: classes3.dex */
public final /* data */ class AppAutherBusinessData {

    @SerializedName("authText")
    private final String authText;

    @SerializedName("clientAction")
    private final AppAutherClientAction clientAction;

    @SerializedName("displayName")
    private final String displayName;

    @SerializedName("frameStatus")
    private final String frameStatus;

    @SerializedName("iconUrl")
    private final String iconUrl;

    @SerializedName("integrationId")
    private final String integrationId;

    @SerializedName("integrationType")
    private final String integrationType;

    @SerializedName("kind")
    private final String kind;

    @SerializedName("modelInstruction")
    private final String modelInstruction;

    @SerializedName("pendingId")
    private final String pendingId;

    @SerializedName("reauth")
    private final Boolean reauth;

    @SerializedName("templateId")
    private final String templateId;

    @SerializedName("vendorId")
    private final String vendorId;

    public AppAutherBusinessData() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, 8191, null);
    }

    /* renamed from: a, reason: from getter */
    public final String getAuthText() {
        return this.authText;
    }

    /* renamed from: b, reason: from getter */
    public final AppAutherClientAction getClientAction() {
        return this.clientAction;
    }

    /* renamed from: c, reason: from getter */
    public final String getDisplayName() {
        return this.displayName;
    }

    /* renamed from: d, reason: from getter */
    public final String getIconUrl() {
        return this.iconUrl;
    }

    /* renamed from: e, reason: from getter */
    public final String getIntegrationId() {
        return this.integrationId;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AppAutherBusinessData)) {
            return false;
        }
        AppAutherBusinessData appAutherBusinessData = (AppAutherBusinessData) other;
        return kotlin.jvm.internal.p.d(this.templateId, appAutherBusinessData.templateId) && kotlin.jvm.internal.p.d(this.kind, appAutherBusinessData.kind) && kotlin.jvm.internal.p.d(this.frameStatus, appAutherBusinessData.frameStatus) && kotlin.jvm.internal.p.d(this.reauth, appAutherBusinessData.reauth) && kotlin.jvm.internal.p.d(this.vendorId, appAutherBusinessData.vendorId) && kotlin.jvm.internal.p.d(this.integrationId, appAutherBusinessData.integrationId) && kotlin.jvm.internal.p.d(this.integrationType, appAutherBusinessData.integrationType) && kotlin.jvm.internal.p.d(this.displayName, appAutherBusinessData.displayName) && kotlin.jvm.internal.p.d(this.iconUrl, appAutherBusinessData.iconUrl) && kotlin.jvm.internal.p.d(this.pendingId, appAutherBusinessData.pendingId) && kotlin.jvm.internal.p.d(this.authText, appAutherBusinessData.authText) && kotlin.jvm.internal.p.d(this.modelInstruction, appAutherBusinessData.modelInstruction) && kotlin.jvm.internal.p.d(this.clientAction, appAutherBusinessData.clientAction);
    }

    /* renamed from: f, reason: from getter */
    public final String getPendingId() {
        return this.pendingId;
    }

    /* renamed from: g, reason: from getter */
    public final String getVendorId() {
        return this.vendorId;
    }

    public int hashCode() {
        String str = this.templateId;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.kind;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.frameStatus;
        int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        Boolean bool = this.reauth;
        int iHashCode4 = (iHashCode3 + (bool == null ? 0 : bool.hashCode())) * 31;
        String str4 = this.vendorId;
        int iHashCode5 = (iHashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.integrationId;
        int iHashCode6 = (iHashCode5 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.integrationType;
        int iHashCode7 = (iHashCode6 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.displayName;
        int iHashCode8 = (iHashCode7 + (str7 == null ? 0 : str7.hashCode())) * 31;
        String str8 = this.iconUrl;
        int iHashCode9 = (iHashCode8 + (str8 == null ? 0 : str8.hashCode())) * 31;
        String str9 = this.pendingId;
        int iHashCode10 = (iHashCode9 + (str9 == null ? 0 : str9.hashCode())) * 31;
        String str10 = this.authText;
        int iHashCode11 = (iHashCode10 + (str10 == null ? 0 : str10.hashCode())) * 31;
        String str11 = this.modelInstruction;
        int iHashCode12 = (iHashCode11 + (str11 == null ? 0 : str11.hashCode())) * 31;
        AppAutherClientAction appAutherClientAction = this.clientAction;
        return iHashCode12 + (appAutherClientAction != null ? appAutherClientAction.hashCode() : 0);
    }

    public String toString() {
        return "AppAutherBusinessData(templateId=" + this.templateId + ", kind=" + this.kind + ", frameStatus=" + this.frameStatus + ", reauth=" + this.reauth + ", vendorId=" + this.vendorId + ", integrationId=" + this.integrationId + ", integrationType=" + this.integrationType + ", displayName=" + this.displayName + ", iconUrl=" + this.iconUrl + ", pendingId=" + this.pendingId + ", authText=" + this.authText + ", modelInstruction=" + this.modelInstruction + ", clientAction=" + this.clientAction + ")";
    }

    public AppAutherBusinessData(String str, String str2, String str3, Boolean bool, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, AppAutherClientAction appAutherClientAction) {
        this.templateId = str;
        this.kind = str2;
        this.frameStatus = str3;
        this.reauth = bool;
        this.vendorId = str4;
        this.integrationId = str5;
        this.integrationType = str6;
        this.displayName = str7;
        this.iconUrl = str8;
        this.pendingId = str9;
        this.authText = str10;
        this.modelInstruction = str11;
        this.clientAction = appAutherClientAction;
    }

    public /* synthetic */ AppAutherBusinessData(String str, String str2, String str3, Boolean bool, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, AppAutherClientAction appAutherClientAction, int i10, kotlin.jvm.internal.i iVar) {
        this((i10 & 1) != 0 ? null : str, (i10 & 2) != 0 ? null : str2, (i10 & 4) != 0 ? null : str3, (i10 & 8) != 0 ? null : bool, (i10 & 16) != 0 ? null : str4, (i10 & 32) != 0 ? null : str5, (i10 & 64) != 0 ? null : str6, (i10 & 128) != 0 ? null : str7, (i10 & 256) != 0 ? null : str8, (i10 & 512) != 0 ? null : str9, (i10 & 1024) != 0 ? null : str10, (i10 & 2048) != 0 ? null : str11, (i10 & 4096) != 0 ? null : appAutherClientAction);
    }
}
