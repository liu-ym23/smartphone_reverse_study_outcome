package com.stepos.ailauncher.contract.model.search;

import com.stepos.ailauncher.chat.trace.ChatTracker;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b!\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001Bq\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010\r\u001a\u00020\t\u0012\u0006\u0010\u000e\u001a\u00020\t\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012¢\u0006\u0004\b\u0013\u0010\u0014J\t\u0010$\u001a\u00020\u0003HÆ\u0003J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\t\u0010&\u001a\u00020\u0003HÆ\u0003J\t\u0010'\u001a\u00020\u0003HÆ\u0003J\t\u0010(\u001a\u00020\u0003HÆ\u0003J\t\u0010)\u001a\u00020\tHÆ\u0003J\t\u0010*\u001a\u00020\u000bHÆ\u0003J\t\u0010+\u001a\u00020\u000bHÆ\u0003J\t\u0010,\u001a\u00020\tHÆ\u0003J\t\u0010-\u001a\u00020\tHÆ\u0003J\t\u0010.\u001a\u00020\u0010HÆ\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\u0012HÆ\u0003J\u0083\u0001\u00100\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\r\u001a\u00020\t2\b\b\u0002\u0010\u000e\u001a\u00020\t2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÆ\u0001J\u0013\u00101\u001a\u00020\t2\b\u00102\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00103\u001a\u000204HÖ\u0001J\t\u00105\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0016R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0016R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0016R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0016R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u001bR\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\f\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001dR\u0011\u0010\r\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u001bR\u0011\u0010\u000e\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001bR\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0012¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#¨\u00066"}, d2 = {"Lcom/stepos/ailauncher/contract/model/search/SidebarSession;", "", "sessionId", "", "agentId", "deviceId", "title", "agentLabel", "isExternalAgent", "", "createdAt", "", "updatedAt", "isRead", "sendFailed", "sessionKind", "Lcom/stepos/ailauncher/contract/model/search/SidebarSessionKind;", "activityState", "Lcom/stepos/ailauncher/contract/model/search/SessionActivityState;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZJJZZLcom/stepos/ailauncher/contract/model/search/SidebarSessionKind;Lcom/stepos/ailauncher/contract/model/search/SessionActivityState;)V", "getSessionId", "()Ljava/lang/String;", "getAgentId", "getDeviceId", "getTitle", "getAgentLabel", "()Z", "getCreatedAt", "()J", "getUpdatedAt", "getSendFailed", "getSessionKind", "()Lcom/stepos/ailauncher/contract/model/search/SidebarSessionKind;", "getActivityState", "()Lcom/stepos/ailauncher/contract/model/search/SessionActivityState;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", ChatTracker.CLICK_COPY, "equals", "other", "hashCode", "", "toString", "contract_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class SidebarSession {
    private final SessionActivityState activityState;
    private final String agentId;
    private final String agentLabel;
    private final long createdAt;
    private final String deviceId;
    private final boolean isExternalAgent;
    private final boolean isRead;
    private final boolean sendFailed;
    private final String sessionId;
    private final SidebarSessionKind sessionKind;
    private final String title;
    private final long updatedAt;

    public SidebarSession(String sessionId, String agentId, String deviceId, String title, String agentLabel, boolean z10, long j10, long j11, boolean z11, boolean z12, SidebarSessionKind sessionKind, SessionActivityState sessionActivityState) {
        p.i(sessionId, "sessionId");
        p.i(agentId, "agentId");
        p.i(deviceId, "deviceId");
        p.i(title, "title");
        p.i(agentLabel, "agentLabel");
        p.i(sessionKind, "sessionKind");
        this.sessionId = sessionId;
        this.agentId = agentId;
        this.deviceId = deviceId;
        this.title = title;
        this.agentLabel = agentLabel;
        this.isExternalAgent = z10;
        this.createdAt = j10;
        this.updatedAt = j11;
        this.isRead = z11;
        this.sendFailed = z12;
        this.sessionKind = sessionKind;
        this.activityState = sessionActivityState;
    }

    /* renamed from: component1, reason: from getter */
    public final String getSessionId() {
        return this.sessionId;
    }

    /* renamed from: component10, reason: from getter */
    public final boolean getSendFailed() {
        return this.sendFailed;
    }

    /* renamed from: component11, reason: from getter */
    public final SidebarSessionKind getSessionKind() {
        return this.sessionKind;
    }

    /* renamed from: component12, reason: from getter */
    public final SessionActivityState getActivityState() {
        return this.activityState;
    }

    /* renamed from: component2, reason: from getter */
    public final String getAgentId() {
        return this.agentId;
    }

    /* renamed from: component3, reason: from getter */
    public final String getDeviceId() {
        return this.deviceId;
    }

    /* renamed from: component4, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    /* renamed from: component5, reason: from getter */
    public final String getAgentLabel() {
        return this.agentLabel;
    }

    /* renamed from: component6, reason: from getter */
    public final boolean getIsExternalAgent() {
        return this.isExternalAgent;
    }

    /* renamed from: component7, reason: from getter */
    public final long getCreatedAt() {
        return this.createdAt;
    }

    /* renamed from: component8, reason: from getter */
    public final long getUpdatedAt() {
        return this.updatedAt;
    }

    /* renamed from: component9, reason: from getter */
    public final boolean getIsRead() {
        return this.isRead;
    }

    public final SidebarSession copy(String sessionId, String agentId, String deviceId, String title, String agentLabel, boolean isExternalAgent, long createdAt, long updatedAt, boolean isRead, boolean sendFailed, SidebarSessionKind sessionKind, SessionActivityState activityState) {
        p.i(sessionId, "sessionId");
        p.i(agentId, "agentId");
        p.i(deviceId, "deviceId");
        p.i(title, "title");
        p.i(agentLabel, "agentLabel");
        p.i(sessionKind, "sessionKind");
        return new SidebarSession(sessionId, agentId, deviceId, title, agentLabel, isExternalAgent, createdAt, updatedAt, isRead, sendFailed, sessionKind, activityState);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SidebarSession)) {
            return false;
        }
        SidebarSession sidebarSession = (SidebarSession) other;
        return p.d(this.sessionId, sidebarSession.sessionId) && p.d(this.agentId, sidebarSession.agentId) && p.d(this.deviceId, sidebarSession.deviceId) && p.d(this.title, sidebarSession.title) && p.d(this.agentLabel, sidebarSession.agentLabel) && this.isExternalAgent == sidebarSession.isExternalAgent && this.createdAt == sidebarSession.createdAt && this.updatedAt == sidebarSession.updatedAt && this.isRead == sidebarSession.isRead && this.sendFailed == sidebarSession.sendFailed && this.sessionKind == sidebarSession.sessionKind && this.activityState == sidebarSession.activityState;
    }

    public final SessionActivityState getActivityState() {
        return this.activityState;
    }

    public final String getAgentId() {
        return this.agentId;
    }

    public final String getAgentLabel() {
        return this.agentLabel;
    }

    public final long getCreatedAt() {
        return this.createdAt;
    }

    public final String getDeviceId() {
        return this.deviceId;
    }

    public final boolean getSendFailed() {
        return this.sendFailed;
    }

    public final String getSessionId() {
        return this.sessionId;
    }

    public final SidebarSessionKind getSessionKind() {
        return this.sessionKind;
    }

    public final String getTitle() {
        return this.title;
    }

    public final long getUpdatedAt() {
        return this.updatedAt;
    }

    public int hashCode() {
        int iHashCode = ((((((((((((((((((((this.sessionId.hashCode() * 31) + this.agentId.hashCode()) * 31) + this.deviceId.hashCode()) * 31) + this.title.hashCode()) * 31) + this.agentLabel.hashCode()) * 31) + Boolean.hashCode(this.isExternalAgent)) * 31) + Long.hashCode(this.createdAt)) * 31) + Long.hashCode(this.updatedAt)) * 31) + Boolean.hashCode(this.isRead)) * 31) + Boolean.hashCode(this.sendFailed)) * 31) + this.sessionKind.hashCode()) * 31;
        SessionActivityState sessionActivityState = this.activityState;
        return iHashCode + (sessionActivityState == null ? 0 : sessionActivityState.hashCode());
    }

    public final boolean isExternalAgent() {
        return this.isExternalAgent;
    }

    public final boolean isRead() {
        return this.isRead;
    }

    public String toString() {
        return "SidebarSession(sessionId=" + this.sessionId + ", agentId=" + this.agentId + ", deviceId=" + this.deviceId + ", title=" + this.title + ", agentLabel=" + this.agentLabel + ", isExternalAgent=" + this.isExternalAgent + ", createdAt=" + this.createdAt + ", updatedAt=" + this.updatedAt + ", isRead=" + this.isRead + ", sendFailed=" + this.sendFailed + ", sessionKind=" + this.sessionKind + ", activityState=" + this.activityState + ")";
    }

    public /* synthetic */ SidebarSession(String str, String str2, String str3, String str4, String str5, boolean z10, long j10, long j11, boolean z11, boolean z12, SidebarSessionKind sidebarSessionKind, SessionActivityState sessionActivityState, int i10, i iVar) {
        this(str, str2, (i10 & 4) != 0 ? "" : str3, str4, (i10 & 16) != 0 ? "" : str5, (i10 & 32) != 0 ? false : z10, j10, j11, z11, z12, sidebarSessionKind, (i10 & 2048) != 0 ? null : sessionActivityState);
    }
}
