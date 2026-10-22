package com.stepos.ailauncher.agent.aispace.connect.data;

import com.autonavi.aps.amapapi.config.Const;
import com.google.gson.annotations.SerializedName;
import com.stepos.ailauncher.taskstore.provider.c;
import com.stepos.statsapp.v3.lib.plugin.constants.Parameters;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\b\u0080\b\u0018\u00002\u00020\u0001BO\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0014\u001a\u0004\b\u0015\u0010\fR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0014\u001a\u0004\b\u0016\u0010\fR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0014\u001a\u0004\b\u0017\u0010\fR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u0014\u001a\u0004\b\u0018\u0010\fR\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0014\u001a\u0004\b\u0019\u0010\fR\u001c\u0010\b\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\u0014\u001a\u0004\b\u001a\u0010\f¨\u0006\u001b"}, d2 = {"Lcom/stepos/ailauncher/agent/aispace/connect/data/A;", "", "", "sessionId", "deviceId", "agent", "title", "createdAt", "updatedAt", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", Const.INTENT_KEY_UMID, "c", Const.INTENT_KEY_APIKEY, "e", Const.INTENT_KEY_PKGNAME, "f", "agent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.agent.aispace.connect.data.A, reason: from toString */
/* loaded from: classes3.dex */
public final /* data */ class SessionDto {

    @SerializedName("agent")
    private final String agent;

    @SerializedName(c.a.COL_CREATED_AT)
    private final String createdAt;

    @SerializedName(Parameters.DEVICE_ID)
    private final String deviceId;

    @SerializedName("session_id")
    private final String sessionId;

    @SerializedName("title")
    private final String title;

    @SerializedName(c.a.COL_UPDATED_AT)
    private final String updatedAt;

    public SessionDto() {
        this(null, null, null, null, null, null, 63, null);
    }

    /* renamed from: a, reason: from getter */
    public final String getAgent() {
        return this.agent;
    }

    /* renamed from: b, reason: from getter */
    public final String getCreatedAt() {
        return this.createdAt;
    }

    /* renamed from: c, reason: from getter */
    public final String getDeviceId() {
        return this.deviceId;
    }

    /* renamed from: d, reason: from getter */
    public final String getSessionId() {
        return this.sessionId;
    }

    /* renamed from: e, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SessionDto)) {
            return false;
        }
        SessionDto sessionDto = (SessionDto) other;
        return kotlin.jvm.internal.p.d(this.sessionId, sessionDto.sessionId) && kotlin.jvm.internal.p.d(this.deviceId, sessionDto.deviceId) && kotlin.jvm.internal.p.d(this.agent, sessionDto.agent) && kotlin.jvm.internal.p.d(this.title, sessionDto.title) && kotlin.jvm.internal.p.d(this.createdAt, sessionDto.createdAt) && kotlin.jvm.internal.p.d(this.updatedAt, sessionDto.updatedAt);
    }

    /* renamed from: f, reason: from getter */
    public final String getUpdatedAt() {
        return this.updatedAt;
    }

    public int hashCode() {
        String str = this.sessionId;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.deviceId;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.agent;
        int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.title;
        int iHashCode4 = (iHashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.createdAt;
        int iHashCode5 = (iHashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.updatedAt;
        return iHashCode5 + (str6 != null ? str6.hashCode() : 0);
    }

    public String toString() {
        return "SessionDto(sessionId=" + this.sessionId + ", deviceId=" + this.deviceId + ", agent=" + this.agent + ", title=" + this.title + ", createdAt=" + this.createdAt + ", updatedAt=" + this.updatedAt + ")";
    }

    public SessionDto(String str, String str2, String str3, String str4, String str5, String str6) {
        this.sessionId = str;
        this.deviceId = str2;
        this.agent = str3;
        this.title = str4;
        this.createdAt = str5;
        this.updatedAt = str6;
    }

    public /* synthetic */ SessionDto(String str, String str2, String str3, String str4, String str5, String str6, int i10, kotlin.jvm.internal.i iVar) {
        this((i10 & 1) != 0 ? null : str, (i10 & 2) != 0 ? null : str2, (i10 & 4) != 0 ? null : str3, (i10 & 8) != 0 ? null : str4, (i10 & 16) != 0 ? null : str5, (i10 & 32) != 0 ? null : str6);
    }
}
