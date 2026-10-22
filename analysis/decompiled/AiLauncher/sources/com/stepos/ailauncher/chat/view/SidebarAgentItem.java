package com.stepos.ailauncher.chat.view;

import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.contract.model.search.SidebarSession;
import kotlin.Metadata;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b \b\u0080\b\u0018\u00002\u00020\u0001By\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\u0006\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\f\u001a\u00020\u0006\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\r\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0018\u001a\u00020\u0017HÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u001a\u0010\u001b\u001a\u00020\u00062\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001b\u0010\u001cR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u001d\u001a\u0004\b\u001e\u0010\u0016R\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u001d\u001a\u0004\b\u001f\u0010\u0016R\u0017\u0010\u0005\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u001d\u001a\u0004\b \u0010\u0016R\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010!\u001a\u0004\b\"\u0010#R\u0017\u0010\b\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\b\u0010!\u001a\u0004\b$\u0010#R\u0017\u0010\t\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\t\u0010!\u001a\u0004\b%\u0010#R\u0017\u0010\u000b\u001a\u00020\n8\u0006¢\u0006\f\n\u0004\b\u000b\u0010&\u001a\u0004\b'\u0010(R\u0017\u0010\f\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\f\u0010!\u001a\u0004\b)\u0010#R\u0019\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0006¢\u0006\f\n\u0004\b\u000e\u0010*\u001a\u0004\b+\u0010,R\u0017\u0010\u000f\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u001d\u001a\u0004\b-\u0010\u0016R\u0017\u0010\u0010\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u001d\u001a\u0004\b.\u0010\u0016R\u0017\u0010\u0011\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u001d\u001a\u0004\b/\u0010\u0016R\u0017\u0010\u0012\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u001d\u001a\u0004\b0\u0010\u0016R\u0011\u00102\u001a\u00020\u00028F¢\u0006\u0006\u001a\u0004\b1\u0010\u0016R\u0011\u00104\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\b3\u0010(R\u0011\u00106\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\b5\u0010(¨\u00067"}, d2 = {"Lcom/stepos/ailauncher/chat/view/s8;", "", "", "agentId", "deviceId", "displayName", "", com.stepos.ailauncher.sla.G.NETWORK_ONLINE, "isPrimary", "pinned", "", "updateAt", "installed", "Lcom/stepos/ailauncher/contract/model/search/SidebarSession;", "latestSession", "assetId", "reversionId", "semver", "icon", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZZJZLcom/stepos/ailauncher/contract/model/search/SidebarSession;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", Const.INTENT_KEY_APIKEY, "c", Const.INTENT_KEY_UMID, "Z", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "()Z", "m", "getPinned", "J", "getUpdateAt", "()J", "f", "Lcom/stepos/ailauncher/contract/model/search/SidebarSession;", "getLatestSession", "()Lcom/stepos/ailauncher/contract/model/search/SidebarSession;", Const.INTENT_KEY_PKGNAME, Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "k", "e", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "rowKey", Const.INTENT_KEY_BACKGROUND_COMMAND, "lastMessageAt", "l", "sortTimeMs", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.chat.view.s8, reason: case insensitive filesystem and from toString */
/* loaded from: classes3.dex */
public final /* data */ class SidebarAgentItem {
    private final String agentId;
    private final String assetId;
    private final String deviceId;
    private final String displayName;
    private final String icon;
    private final boolean installed;
    private final boolean isPrimary;
    private final SidebarSession latestSession;
    private final boolean online;
    private final boolean pinned;
    private final String reversionId;
    private final String semver;
    private final long updateAt;

    public SidebarAgentItem(String agentId, String deviceId, String displayName, boolean z10, boolean z11, boolean z12, long j10, boolean z13, SidebarSession sidebarSession, String assetId, String reversionId, String semver, String icon) {
        kotlin.jvm.internal.p.i(agentId, "agentId");
        kotlin.jvm.internal.p.i(deviceId, "deviceId");
        kotlin.jvm.internal.p.i(displayName, "displayName");
        kotlin.jvm.internal.p.i(assetId, "assetId");
        kotlin.jvm.internal.p.i(reversionId, "reversionId");
        kotlin.jvm.internal.p.i(semver, "semver");
        kotlin.jvm.internal.p.i(icon, "icon");
        this.agentId = agentId;
        this.deviceId = deviceId;
        this.displayName = displayName;
        this.online = z10;
        this.isPrimary = z11;
        this.pinned = z12;
        this.updateAt = j10;
        this.installed = z13;
        this.latestSession = sidebarSession;
        this.assetId = assetId;
        this.reversionId = reversionId;
        this.semver = semver;
        this.icon = icon;
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
    public final String getDeviceId() {
        return this.deviceId;
    }

    /* renamed from: d, reason: from getter */
    public final String getDisplayName() {
        return this.displayName;
    }

    /* renamed from: e, reason: from getter */
    public final String getIcon() {
        return this.icon;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SidebarAgentItem)) {
            return false;
        }
        SidebarAgentItem sidebarAgentItem = (SidebarAgentItem) other;
        return kotlin.jvm.internal.p.d(this.agentId, sidebarAgentItem.agentId) && kotlin.jvm.internal.p.d(this.deviceId, sidebarAgentItem.deviceId) && kotlin.jvm.internal.p.d(this.displayName, sidebarAgentItem.displayName) && this.online == sidebarAgentItem.online && this.isPrimary == sidebarAgentItem.isPrimary && this.pinned == sidebarAgentItem.pinned && this.updateAt == sidebarAgentItem.updateAt && this.installed == sidebarAgentItem.installed && kotlin.jvm.internal.p.d(this.latestSession, sidebarAgentItem.latestSession) && kotlin.jvm.internal.p.d(this.assetId, sidebarAgentItem.assetId) && kotlin.jvm.internal.p.d(this.reversionId, sidebarAgentItem.reversionId) && kotlin.jvm.internal.p.d(this.semver, sidebarAgentItem.semver) && kotlin.jvm.internal.p.d(this.icon, sidebarAgentItem.icon);
    }

    /* renamed from: f, reason: from getter */
    public final boolean getInstalled() {
        return this.installed;
    }

    public final long g() {
        SidebarSession sidebarSession = this.latestSession;
        if (sidebarSession != null) {
            return sidebarSession.getUpdatedAt();
        }
        return 0L;
    }

    /* renamed from: h, reason: from getter */
    public final boolean getOnline() {
        return this.online;
    }

    public int hashCode() {
        int iHashCode = ((((((((((((((this.agentId.hashCode() * 31) + this.deviceId.hashCode()) * 31) + this.displayName.hashCode()) * 31) + Boolean.hashCode(this.online)) * 31) + Boolean.hashCode(this.isPrimary)) * 31) + Boolean.hashCode(this.pinned)) * 31) + Long.hashCode(this.updateAt)) * 31) + Boolean.hashCode(this.installed)) * 31;
        SidebarSession sidebarSession = this.latestSession;
        return ((((((((iHashCode + (sidebarSession == null ? 0 : sidebarSession.hashCode())) * 31) + this.assetId.hashCode()) * 31) + this.reversionId.hashCode()) * 31) + this.semver.hashCode()) * 31) + this.icon.hashCode();
    }

    /* renamed from: i, reason: from getter */
    public final String getReversionId() {
        return this.reversionId;
    }

    public final String j() {
        return this.deviceId + "|" + this.agentId;
    }

    /* renamed from: k, reason: from getter */
    public final String getSemver() {
        return this.semver;
    }

    public final long l() {
        return Math.max(g(), this.updateAt * 1000);
    }

    /* renamed from: m, reason: from getter */
    public final boolean getIsPrimary() {
        return this.isPrimary;
    }

    public String toString() {
        return "SidebarAgentItem(agentId=" + this.agentId + ", deviceId=" + this.deviceId + ", displayName=" + this.displayName + ", online=" + this.online + ", isPrimary=" + this.isPrimary + ", pinned=" + this.pinned + ", updateAt=" + this.updateAt + ", installed=" + this.installed + ", latestSession=" + this.latestSession + ", assetId=" + this.assetId + ", reversionId=" + this.reversionId + ", semver=" + this.semver + ", icon=" + this.icon + ")";
    }

    public /* synthetic */ SidebarAgentItem(String str, String str2, String str3, boolean z10, boolean z11, boolean z12, long j10, boolean z13, SidebarSession sidebarSession, String str4, String str5, String str6, String str7, int i10, kotlin.jvm.internal.i iVar) {
        this(str, str2, str3, z10, z11, z12, j10, z13, sidebarSession, (i10 & 512) != 0 ? "" : str4, (i10 & 1024) != 0 ? "" : str5, (i10 & 2048) != 0 ? "" : str6, (i10 & 4096) != 0 ? "" : str7);
    }
}
