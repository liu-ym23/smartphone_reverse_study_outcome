package com.stepos.ailauncher.agent.aispace.skill.wecom.net;

import com.autonavi.aps.amapapi.config.Const;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0080\b\u0018\u00002\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u0004R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\r\u001a\u0004\b\u0010\u0010\u0004R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\r\u001a\u0004\b\u0012\u0010\u0004R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\r\u001a\u0004\b\u0014\u0010\u0004R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010\r\u001a\u0004\b\u0016\u0010\u0004R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u00178\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u00178\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001c\u0010\u0019\u001a\u0004\b\u001d\u0010\u001bR\u001c\u0010\u001f\u001a\u0004\u0018\u00010\u001e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"¨\u0006#"}, d2 = {"Lcom/stepos/ailauncher/agent/aispace/skill/wecom/net/h;", "", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "taskId", "Ljava/lang/String;", "e", "envId", "getEnvId", "status", Const.INTENT_KEY_UMID, "botId", "getBotId", "failReason", "getFailReason", "", "expireAt", "Ljava/lang/Long;", Const.INTENT_KEY_APIKEY, "()Ljava/lang/Long;", "serverTime", "c", "Lcom/stepos/ailauncher/agent/aispace/skill/wecom/net/j;", "nextAction", "Lcom/stepos/ailauncher/agent/aispace/skill/wecom/net/j;", Const.INTENT_KEY_PKGNAME, "()Lcom/stepos/ailauncher/agent/aispace/skill/wecom/net/j;", "agent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.agent.aispace.skill.wecom.net.h, reason: from toString */
/* loaded from: classes3.dex */
public final /* data */ class WecomConnectTaskSnapshot {

    @SerializedName("bot_id")
    private final String botId;

    @SerializedName("env_id")
    private final String envId;

    @SerializedName("expire_at")
    private final Long expireAt;

    @SerializedName("fail_reason")
    private final String failReason;

    @SerializedName("next_action")
    private final WecomNextAction nextAction;

    @SerializedName("server_time")
    private final Long serverTime;

    @SerializedName("status")
    private final String status;

    @SerializedName("task_id")
    private final String taskId;

    /* renamed from: a, reason: from getter */
    public final Long getExpireAt() {
        return this.expireAt;
    }

    /* renamed from: b, reason: from getter */
    public final WecomNextAction getNextAction() {
        return this.nextAction;
    }

    /* renamed from: c, reason: from getter */
    public final Long getServerTime() {
        return this.serverTime;
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
        if (!(other instanceof WecomConnectTaskSnapshot)) {
            return false;
        }
        WecomConnectTaskSnapshot wecomConnectTaskSnapshot = (WecomConnectTaskSnapshot) other;
        return p.d(this.taskId, wecomConnectTaskSnapshot.taskId) && p.d(this.envId, wecomConnectTaskSnapshot.envId) && p.d(this.status, wecomConnectTaskSnapshot.status) && p.d(this.botId, wecomConnectTaskSnapshot.botId) && p.d(this.failReason, wecomConnectTaskSnapshot.failReason) && p.d(this.expireAt, wecomConnectTaskSnapshot.expireAt) && p.d(this.serverTime, wecomConnectTaskSnapshot.serverTime) && p.d(this.nextAction, wecomConnectTaskSnapshot.nextAction);
    }

    public int hashCode() {
        String str = this.taskId;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.envId;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.status;
        int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.botId;
        int iHashCode4 = (iHashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.failReason;
        int iHashCode5 = (iHashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31;
        Long l10 = this.expireAt;
        int iHashCode6 = (iHashCode5 + (l10 == null ? 0 : l10.hashCode())) * 31;
        Long l11 = this.serverTime;
        int iHashCode7 = (iHashCode6 + (l11 == null ? 0 : l11.hashCode())) * 31;
        WecomNextAction wecomNextAction = this.nextAction;
        return iHashCode7 + (wecomNextAction != null ? wecomNextAction.hashCode() : 0);
    }

    public String toString() {
        return "WecomConnectTaskSnapshot(taskId=" + this.taskId + ", envId=" + this.envId + ", status=" + this.status + ", botId=" + this.botId + ", failReason=" + this.failReason + ", expireAt=" + this.expireAt + ", serverTime=" + this.serverTime + ", nextAction=" + this.nextAction + ")";
    }
}
