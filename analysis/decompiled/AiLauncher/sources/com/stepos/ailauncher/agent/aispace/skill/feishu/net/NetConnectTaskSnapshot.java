package com.stepos.ailauncher.agent.aispace.skill.feishu.net;

import com.autonavi.aps.amapapi.config.Const;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0007\b\u0080\b\u0018\u00002\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u0004R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\r\u001a\u0004\b\u0010\u0010\u0004R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\r\u001a\u0004\b\u0012\u0010\u0004R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u00188\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001d\u0010\r\u001a\u0004\b\u001e\u0010\u0004R\u001c\u0010 \u001a\u0004\u0018\u00010\u001f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#R\u001c\u0010$\u001a\u0004\u0018\u00010\u001f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b$\u0010!\u001a\u0004\b%\u0010#¨\u0006&"}, d2 = {"Lcom/stepos/ailauncher/agent/aispace/skill/feishu/net/p;", "", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "taskId", "Ljava/lang/String;", "e", "envId", Const.INTENT_KEY_APIKEY, "status", Const.INTENT_KEY_UMID, "Lcom/stepos/ailauncher/agent/aispace/skill/feishu/net/r;", "nextAction", "Lcom/stepos/ailauncher/agent/aispace/skill/feishu/net/r;", "c", "()Lcom/stepos/ailauncher/agent/aispace/skill/feishu/net/r;", "Lcom/stepos/ailauncher/agent/aispace/skill/feishu/net/q;", "account", "Lcom/stepos/ailauncher/agent/aispace/skill/feishu/net/q;", "getAccount", "()Lcom/stepos/ailauncher/agent/aispace/skill/feishu/net/q;", "failReason", Const.INTENT_KEY_PKGNAME, "", "expireAt", "Ljava/lang/Long;", "getExpireAt", "()Ljava/lang/Long;", "serverTime", "getServerTime", "agent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.agent.aispace.skill.feishu.net.p, reason: from toString */
/* loaded from: classes3.dex */
public final /* data */ class NetConnectTaskSnapshot {

    @SerializedName("account")
    private final NetFeishuAccount account;

    @SerializedName("envId")
    private final String envId;

    @SerializedName("expireAt")
    private final Long expireAt;

    @SerializedName("failReason")
    private final String failReason;

    @SerializedName("nextAction")
    private final NetNextAction nextAction;

    @SerializedName("serverTime")
    private final Long serverTime;

    @SerializedName("status")
    private final String status;

    @SerializedName("taskId")
    private final String taskId;

    /* renamed from: a, reason: from getter */
    public final String getEnvId() {
        return this.envId;
    }

    /* renamed from: b, reason: from getter */
    public final String getFailReason() {
        return this.failReason;
    }

    /* renamed from: c, reason: from getter */
    public final NetNextAction getNextAction() {
        return this.nextAction;
    }

    /* renamed from: d, reason: from getter */
    public final String getStatus() {
        return this.status;
    }

    /* renamed from: e, reason: from getter */
    public final String getTaskId() {
        return this.taskId;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof NetConnectTaskSnapshot)) {
            return false;
        }
        NetConnectTaskSnapshot netConnectTaskSnapshot = (NetConnectTaskSnapshot) other;
        return kotlin.jvm.internal.p.d(this.taskId, netConnectTaskSnapshot.taskId) && kotlin.jvm.internal.p.d(this.envId, netConnectTaskSnapshot.envId) && kotlin.jvm.internal.p.d(this.status, netConnectTaskSnapshot.status) && kotlin.jvm.internal.p.d(this.nextAction, netConnectTaskSnapshot.nextAction) && kotlin.jvm.internal.p.d(this.account, netConnectTaskSnapshot.account) && kotlin.jvm.internal.p.d(this.failReason, netConnectTaskSnapshot.failReason) && kotlin.jvm.internal.p.d(this.expireAt, netConnectTaskSnapshot.expireAt) && kotlin.jvm.internal.p.d(this.serverTime, netConnectTaskSnapshot.serverTime);
    }

    public int hashCode() {
        String str = this.taskId;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.envId;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.status;
        int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        NetNextAction netNextAction = this.nextAction;
        int iHashCode4 = (iHashCode3 + (netNextAction == null ? 0 : netNextAction.hashCode())) * 31;
        NetFeishuAccount netFeishuAccount = this.account;
        int iHashCode5 = (iHashCode4 + (netFeishuAccount == null ? 0 : netFeishuAccount.hashCode())) * 31;
        String str4 = this.failReason;
        int iHashCode6 = (iHashCode5 + (str4 == null ? 0 : str4.hashCode())) * 31;
        Long l10 = this.expireAt;
        int iHashCode7 = (iHashCode6 + (l10 == null ? 0 : l10.hashCode())) * 31;
        Long l11 = this.serverTime;
        return iHashCode7 + (l11 != null ? l11.hashCode() : 0);
    }

    public String toString() {
        return "NetConnectTaskSnapshot(taskId=" + this.taskId + ", envId=" + this.envId + ", status=" + this.status + ", nextAction=" + this.nextAction + ", account=" + this.account + ", failReason=" + this.failReason + ", expireAt=" + this.expireAt + ", serverTime=" + this.serverTime + ")";
    }
}
