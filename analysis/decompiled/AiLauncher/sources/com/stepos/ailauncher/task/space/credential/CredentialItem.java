package com.stepos.ailauncher.task.space.credential;

import com.autonavi.aps.amapapi.config.Const;
import com.google.gson.annotations.SerializedName;
import com.stepos.widget.recipient.StepOSRecipientEmailHistory;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010$\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0015\b\u0086\b\u0018\u00002\u00020\u0001B±\u0001\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0002\u0012\u0016\b\u0002\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u000e\u0012\u0010\b\u0002\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0018\u001a\u00020\u0017HÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u001a\u0010\u001c\u001a\u00020\u001b2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001c\u0010\u001dR\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u001e\u001a\u0004\b\u001f\u0010\u0016R\u001a\u0010\u0004\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u001e\u001a\u0004\b \u0010\u0016R\u001a\u0010\u0005\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u001e\u001a\u0004\b!\u0010\u0016R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u001e\u001a\u0004\b\"\u0010\u0016R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u001e\u001a\u0004\b#\u0010\u0016R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\u001e\u001a\u0004\b$\u0010\u0016R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u001e\u001a\u0004\b%\u0010\u0016R\u001c\u0010\n\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u001e\u001a\u0004\b&\u0010\u0016R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u001e\u001a\u0004\b'\u0010\u0016R\u001c\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\u001e\u001a\u0004\b(\u0010\u0016R\u001c\u0010\r\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u001e\u001a\u0004\b)\u0010\u0016R(\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010*\u001a\u0004\b+\u0010,R\"\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u00108\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010-\u001a\u0004\b.\u0010/¨\u00060"}, d2 = {"Lcom/stepos/ailauncher/task/space/credential/f;", "", "", "connectionId", "vendorId", "vendorName", "displayName", "integrationId", "iconUrl", "authMode", "authMethodLabel", "status", "authorizedAt", "lastUsedAt", "", "masked", "", "Lcom/stepos/ailauncher/task/space/credential/e;", "fields", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/util/List;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getConnectionId", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "k", "getDisplayName", "f", "e", Const.INTENT_KEY_PKGNAME, Const.INTENT_KEY_APIKEY, Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "c", Const.INTENT_KEY_BACKGROUND_COMMAND, "Ljava/util/Map;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "()Ljava/util/Map;", "Ljava/util/List;", Const.INTENT_KEY_UMID, "()Ljava/util/List;", "task_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.task.space.credential.f, reason: case insensitive filesystem and from toString */
/* loaded from: classes3.dex */
public final /* data */ class CredentialItem {

    @SerializedName("auth_method_label")
    private final String authMethodLabel;

    @SerializedName("auth_mode")
    private final String authMode;

    @SerializedName("authorized_at")
    private final String authorizedAt;

    @SerializedName("connection_id")
    private final String connectionId;

    @SerializedName(StepOSRecipientEmailHistory.DISPLAY_NAME)
    private final String displayName;

    @SerializedName("fields")
    private final List<CredentialField> fields;

    @SerializedName("icon_url")
    private final String iconUrl;

    @SerializedName("integration_id")
    private final String integrationId;

    @SerializedName("last_used_at")
    private final String lastUsedAt;

    @SerializedName("masked")
    private final Map<String, String> masked;

    @SerializedName("status")
    private final String status;

    @SerializedName("vendor_id")
    private final String vendorId;

    @SerializedName("vendor_name")
    private final String vendorName;

    public CredentialItem() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, 8191, null);
    }

    /* renamed from: a, reason: from getter */
    public final String getAuthMethodLabel() {
        return this.authMethodLabel;
    }

    /* renamed from: b, reason: from getter */
    public final String getAuthMode() {
        return this.authMode;
    }

    /* renamed from: c, reason: from getter */
    public final String getAuthorizedAt() {
        return this.authorizedAt;
    }

    public final List<CredentialField> d() {
        return this.fields;
    }

    /* renamed from: e, reason: from getter */
    public final String getIconUrl() {
        return this.iconUrl;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CredentialItem)) {
            return false;
        }
        CredentialItem credentialItem = (CredentialItem) other;
        return kotlin.jvm.internal.p.d(this.connectionId, credentialItem.connectionId) && kotlin.jvm.internal.p.d(this.vendorId, credentialItem.vendorId) && kotlin.jvm.internal.p.d(this.vendorName, credentialItem.vendorName) && kotlin.jvm.internal.p.d(this.displayName, credentialItem.displayName) && kotlin.jvm.internal.p.d(this.integrationId, credentialItem.integrationId) && kotlin.jvm.internal.p.d(this.iconUrl, credentialItem.iconUrl) && kotlin.jvm.internal.p.d(this.authMode, credentialItem.authMode) && kotlin.jvm.internal.p.d(this.authMethodLabel, credentialItem.authMethodLabel) && kotlin.jvm.internal.p.d(this.status, credentialItem.status) && kotlin.jvm.internal.p.d(this.authorizedAt, credentialItem.authorizedAt) && kotlin.jvm.internal.p.d(this.lastUsedAt, credentialItem.lastUsedAt) && kotlin.jvm.internal.p.d(this.masked, credentialItem.masked) && kotlin.jvm.internal.p.d(this.fields, credentialItem.fields);
    }

    /* renamed from: f, reason: from getter */
    public final String getIntegrationId() {
        return this.integrationId;
    }

    /* renamed from: g, reason: from getter */
    public final String getLastUsedAt() {
        return this.lastUsedAt;
    }

    public final Map<String, String> h() {
        return this.masked;
    }

    public int hashCode() {
        String str = this.connectionId;
        int iHashCode = (((((str == null ? 0 : str.hashCode()) * 31) + this.vendorId.hashCode()) * 31) + this.vendorName.hashCode()) * 31;
        String str2 = this.displayName;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.integrationId;
        int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.iconUrl;
        int iHashCode4 = (iHashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.authMode;
        int iHashCode5 = (iHashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.authMethodLabel;
        int iHashCode6 = (iHashCode5 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.status;
        int iHashCode7 = (iHashCode6 + (str7 == null ? 0 : str7.hashCode())) * 31;
        String str8 = this.authorizedAt;
        int iHashCode8 = (iHashCode7 + (str8 == null ? 0 : str8.hashCode())) * 31;
        String str9 = this.lastUsedAt;
        int iHashCode9 = (iHashCode8 + (str9 == null ? 0 : str9.hashCode())) * 31;
        Map<String, String> map = this.masked;
        int iHashCode10 = (iHashCode9 + (map == null ? 0 : map.hashCode())) * 31;
        List<CredentialField> list = this.fields;
        return iHashCode10 + (list != null ? list.hashCode() : 0);
    }

    /* renamed from: i, reason: from getter */
    public final String getStatus() {
        return this.status;
    }

    /* renamed from: j, reason: from getter */
    public final String getVendorId() {
        return this.vendorId;
    }

    /* renamed from: k, reason: from getter */
    public final String getVendorName() {
        return this.vendorName;
    }

    public String toString() {
        return "CredentialItem(connectionId=" + this.connectionId + ", vendorId=" + this.vendorId + ", vendorName=" + this.vendorName + ", displayName=" + this.displayName + ", integrationId=" + this.integrationId + ", iconUrl=" + this.iconUrl + ", authMode=" + this.authMode + ", authMethodLabel=" + this.authMethodLabel + ", status=" + this.status + ", authorizedAt=" + this.authorizedAt + ", lastUsedAt=" + this.lastUsedAt + ", masked=" + this.masked + ", fields=" + this.fields + ")";
    }

    public CredentialItem(String str, String vendorId, String vendorName, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, Map<String, String> map, List<CredentialField> list) {
        kotlin.jvm.internal.p.i(vendorId, "vendorId");
        kotlin.jvm.internal.p.i(vendorName, "vendorName");
        this.connectionId = str;
        this.vendorId = vendorId;
        this.vendorName = vendorName;
        this.displayName = str2;
        this.integrationId = str3;
        this.iconUrl = str4;
        this.authMode = str5;
        this.authMethodLabel = str6;
        this.status = str7;
        this.authorizedAt = str8;
        this.lastUsedAt = str9;
        this.masked = map;
        this.fields = list;
    }

    public /* synthetic */ CredentialItem(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, Map map, List list, int i10, kotlin.jvm.internal.i iVar) {
        this((i10 & 1) != 0 ? null : str, (i10 & 2) != 0 ? "" : str2, (i10 & 4) == 0 ? str3 : "", (i10 & 8) != 0 ? null : str4, (i10 & 16) != 0 ? null : str5, (i10 & 32) != 0 ? null : str6, (i10 & 64) != 0 ? null : str7, (i10 & 128) != 0 ? null : str8, (i10 & 256) != 0 ? null : str9, (i10 & 512) != 0 ? null : str10, (i10 & 1024) != 0 ? null : str11, (i10 & 2048) != 0 ? null : map, (i10 & 4096) != 0 ? null : list);
    }
}
