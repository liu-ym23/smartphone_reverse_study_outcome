package com.stepos.ailauncher.agent.aispace.connect.data;

import com.autonavi.aps.amapapi.config.Const;
import com.google.gson.annotations.SerializedName;
import com.stepos.widget.recipient.StepOSRecipientEmailHistory;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u001f\b\u0080\b\u0018\u00002\u00020\u0001B\u0081\u0001\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\t\u001a\u00020\b\u0012\b\b\u0002\u0010\n\u001a\u00020\u0002\u0012\b\b\u0002\u0010\f\u001a\u00020\u000b\u0012\b\b\u0002\u0010\r\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0016\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u001a\u0010\u0019\u001a\u00020\b2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0019\u0010\u001aR\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u001b\u001a\u0004\b\u001c\u0010\u0015R\u001a\u0010\u0004\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u001b\u001a\u0004\b\u001d\u0010\u0015R\u001a\u0010\u0005\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u001b\u001a\u0004\b\u001e\u0010\u0015R\u001a\u0010\u0006\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u001b\u001a\u0004\b\u001f\u0010\u0015R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u001b\u001a\u0004\b \u0010\u0015R\u001a\u0010\t\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010!\u001a\u0004\b\"\u0010#R\u001a\u0010\n\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u001b\u001a\u0004\b$\u0010\u0015R\u001a\u0010\f\u001a\u00020\u000b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010%\u001a\u0004\b&\u0010'R\u001a\u0010\r\u001a\u00020\u000b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010%\u001a\u0004\b(\u0010'R\u001a\u0010\u000f\u001a\u00020\u000e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010)\u001a\u0004\b*\u0010\u0017R\u001a\u0010\u0010\u001a\u00020\u000b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010%\u001a\u0004\b+\u0010'R\u001a\u0010\u0011\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u001b\u001a\u0004\b,\u0010\u0015¨\u0006-"}, d2 = {"Lcom/stepos/ailauncher/agent/aispace/connect/data/v;", "", "", "agentId", "assetId", "reversionId", "semver", "displayName", "", x5.d.EXTRA_ENABLED, "status", "", "installedAtMs", "updatedAtMs", "", "pinned", "updateAt", "icon", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;JJIJLjava/lang/String;)V", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", Const.INTENT_KEY_APIKEY, Const.INTENT_KEY_PKGNAME, Const.INTENT_KEY_BACKGROUND_COMMAND, Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "c", "Z", Const.INTENT_KEY_UMID, "()Z", "getStatus", "J", "getInstalledAtMs", "()J", "getUpdatedAtMs", "I", "f", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "e", "agent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.agent.aispace.connect.data.v, reason: from toString */
/* loaded from: classes3.dex */
public final /* data */ class OpenClawAgentInfo {

    @SerializedName("agent_id")
    private final String agentId;

    @SerializedName("asset_id")
    private final String assetId;

    @SerializedName(StepOSRecipientEmailHistory.DISPLAY_NAME)
    private final String displayName;

    @SerializedName(x5.d.EXTRA_ENABLED)
    private final boolean enabled;

    @SerializedName("icon")
    private final String icon;

    @SerializedName("installed_at_ms")
    private final long installedAtMs;

    @SerializedName("pinned")
    private final int pinned;

    @SerializedName("reversion_id")
    private final String reversionId;

    @SerializedName("semver")
    private final String semver;

    @SerializedName("status")
    private final String status;

    @SerializedName("updateat")
    private final long updateAt;

    @SerializedName("updated_at_ms")
    private final long updatedAtMs;

    public OpenClawAgentInfo() {
        this(null, null, null, null, null, false, null, 0L, 0L, 0, 0L, null, 4095, null);
    }

    /* renamed from: a, reason: from getter */
    public final String getAgentId() {
        return this.agentId;
    }

    /* renamed from: b, reason: from getter */
    public final String getAssetId() {
        return this.assetId;
    }

    /* renamed from: c, reason: from getter */
    public final String getDisplayName() {
        return this.displayName;
    }

    /* renamed from: d, reason: from getter */
    public final boolean getEnabled() {
        return this.enabled;
    }

    /* renamed from: e, reason: from getter */
    public final String getIcon() {
        return this.icon;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof OpenClawAgentInfo)) {
            return false;
        }
        OpenClawAgentInfo openClawAgentInfo = (OpenClawAgentInfo) other;
        return kotlin.jvm.internal.p.d(this.agentId, openClawAgentInfo.agentId) && kotlin.jvm.internal.p.d(this.assetId, openClawAgentInfo.assetId) && kotlin.jvm.internal.p.d(this.reversionId, openClawAgentInfo.reversionId) && kotlin.jvm.internal.p.d(this.semver, openClawAgentInfo.semver) && kotlin.jvm.internal.p.d(this.displayName, openClawAgentInfo.displayName) && this.enabled == openClawAgentInfo.enabled && kotlin.jvm.internal.p.d(this.status, openClawAgentInfo.status) && this.installedAtMs == openClawAgentInfo.installedAtMs && this.updatedAtMs == openClawAgentInfo.updatedAtMs && this.pinned == openClawAgentInfo.pinned && this.updateAt == openClawAgentInfo.updateAt && kotlin.jvm.internal.p.d(this.icon, openClawAgentInfo.icon);
    }

    /* renamed from: f, reason: from getter */
    public final int getPinned() {
        return this.pinned;
    }

    /* renamed from: g, reason: from getter */
    public final String getReversionId() {
        return this.reversionId;
    }

    /* renamed from: h, reason: from getter */
    public final String getSemver() {
        return this.semver;
    }

    public int hashCode() {
        int iHashCode = ((((((this.agentId.hashCode() * 31) + this.assetId.hashCode()) * 31) + this.reversionId.hashCode()) * 31) + this.semver.hashCode()) * 31;
        String str = this.displayName;
        return ((((((((((((((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + Boolean.hashCode(this.enabled)) * 31) + this.status.hashCode()) * 31) + Long.hashCode(this.installedAtMs)) * 31) + Long.hashCode(this.updatedAtMs)) * 31) + Integer.hashCode(this.pinned)) * 31) + Long.hashCode(this.updateAt)) * 31) + this.icon.hashCode();
    }

    /* renamed from: i, reason: from getter */
    public final long getUpdateAt() {
        return this.updateAt;
    }

    public String toString() {
        return "OpenClawAgentInfo(agentId=" + this.agentId + ", assetId=" + this.assetId + ", reversionId=" + this.reversionId + ", semver=" + this.semver + ", displayName=" + this.displayName + ", enabled=" + this.enabled + ", status=" + this.status + ", installedAtMs=" + this.installedAtMs + ", updatedAtMs=" + this.updatedAtMs + ", pinned=" + this.pinned + ", updateAt=" + this.updateAt + ", icon=" + this.icon + ")";
    }

    public OpenClawAgentInfo(String agentId, String assetId, String reversionId, String semver, String str, boolean z10, String status, long j10, long j11, int i10, long j12, String icon) {
        kotlin.jvm.internal.p.i(agentId, "agentId");
        kotlin.jvm.internal.p.i(assetId, "assetId");
        kotlin.jvm.internal.p.i(reversionId, "reversionId");
        kotlin.jvm.internal.p.i(semver, "semver");
        kotlin.jvm.internal.p.i(status, "status");
        kotlin.jvm.internal.p.i(icon, "icon");
        this.agentId = agentId;
        this.assetId = assetId;
        this.reversionId = reversionId;
        this.semver = semver;
        this.displayName = str;
        this.enabled = z10;
        this.status = status;
        this.installedAtMs = j10;
        this.updatedAtMs = j11;
        this.pinned = i10;
        this.updateAt = j12;
        this.icon = icon;
    }

    public /* synthetic */ OpenClawAgentInfo(String str, String str2, String str3, String str4, String str5, boolean z10, String str6, long j10, long j11, int i10, long j12, String str7, int i11, kotlin.jvm.internal.i iVar) {
        this((i11 & 1) != 0 ? "" : str, (i11 & 2) != 0 ? "" : str2, (i11 & 4) != 0 ? "" : str3, (i11 & 8) != 0 ? "" : str4, (i11 & 16) != 0 ? null : str5, (i11 & 32) != 0 ? false : z10, (i11 & 64) != 0 ? "" : str6, (i11 & 128) != 0 ? 0L : j10, (i11 & 256) != 0 ? 0L : j11, (i11 & 512) == 0 ? i10 : 0, (i11 & 1024) == 0 ? j12 : 0L, (i11 & 2048) != 0 ? "" : str7);
    }
}
