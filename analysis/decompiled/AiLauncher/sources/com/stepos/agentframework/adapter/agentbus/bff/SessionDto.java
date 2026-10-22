package com.stepos.agentframework.adapter.agentbus.bff;

import com.autonavi.aps.amapapi.config.Const;
import com.google.gson.annotations.SerializedName;
import com.stepos.ailauncher.taskstore.provider.c;
import com.stepos.statsapp.v3.lib.plugin.constants.Parameters;
import java.util.Map;
import kotlin.Metadata;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0011\b\u0086\b\u0018\u00002\u00020\u0001B\u007f\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0007\u0012\u0016\b\u0002\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0001\u0018\u00010\f¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0013\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u001a\u0010\u0017\u001a\u00020\u00162\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0017\u0010\u0018R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0019\u001a\u0004\b\u001a\u0010\u0011R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0019\u001a\u0004\b\u001b\u0010\u0011R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0019\u001a\u0004\b\u001c\u0010\u0011R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u0019\u001a\u0004\b\u001d\u0010\u0011R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u001e\u001a\u0004\b!\u0010 R\u001c\u0010\n\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u001e\u001a\u0004\b\"\u0010 R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u001e\u001a\u0004\b#\u0010 R(\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0001\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010$\u001a\u0004\b%\u0010&¨\u0006'"}, d2 = {"Lcom/stepos/agentframework/adapter/agentbus/bff/o;", "", "", "sessionId", "deviceId", "agent", "title", "", "createdAt", "updatedAt", "lastSeq", "messageCount", "", "metadata", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/util/Map;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", Const.INTENT_KEY_APIKEY, "getDeviceId", "getAgent", Const.INTENT_KEY_PKGNAME, "Ljava/lang/Long;", "getCreatedAt", "()Ljava/lang/Long;", "getUpdatedAt", "getLastSeq", "getMessageCount", "Ljava/util/Map;", "getMetadata", "()Ljava/util/Map;", "protocol_agentbus_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.agentframework.adapter.agentbus.bff.o, reason: from toString */
/* loaded from: classes2.dex */
public final /* data */ class SessionDto {

    @SerializedName("agent")
    private final String agent;

    @SerializedName(c.a.COL_CREATED_AT)
    private final Long createdAt;

    @SerializedName(Parameters.DEVICE_ID)
    private final String deviceId;

    @SerializedName("last_seq")
    private final Long lastSeq;

    @SerializedName("message_count")
    private final Long messageCount;

    @SerializedName("metadata")
    private final Map<String, Object> metadata;

    @SerializedName("session_id")
    private final String sessionId;

    @SerializedName("title")
    private final String title;

    @SerializedName(c.a.COL_UPDATED_AT)
    private final Long updatedAt;

    public SessionDto() {
        this(null, null, null, null, null, null, null, null, null, 511, null);
    }

    /* renamed from: a, reason: from getter */
    public final String getSessionId() {
        return this.sessionId;
    }

    /* renamed from: b, reason: from getter */
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
        return kotlin.jvm.internal.p.d(this.sessionId, sessionDto.sessionId) && kotlin.jvm.internal.p.d(this.deviceId, sessionDto.deviceId) && kotlin.jvm.internal.p.d(this.agent, sessionDto.agent) && kotlin.jvm.internal.p.d(this.title, sessionDto.title) && kotlin.jvm.internal.p.d(this.createdAt, sessionDto.createdAt) && kotlin.jvm.internal.p.d(this.updatedAt, sessionDto.updatedAt) && kotlin.jvm.internal.p.d(this.lastSeq, sessionDto.lastSeq) && kotlin.jvm.internal.p.d(this.messageCount, sessionDto.messageCount) && kotlin.jvm.internal.p.d(this.metadata, sessionDto.metadata);
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
        Long l10 = this.createdAt;
        int iHashCode5 = (iHashCode4 + (l10 == null ? 0 : l10.hashCode())) * 31;
        Long l11 = this.updatedAt;
        int iHashCode6 = (iHashCode5 + (l11 == null ? 0 : l11.hashCode())) * 31;
        Long l12 = this.lastSeq;
        int iHashCode7 = (iHashCode6 + (l12 == null ? 0 : l12.hashCode())) * 31;
        Long l13 = this.messageCount;
        int iHashCode8 = (iHashCode7 + (l13 == null ? 0 : l13.hashCode())) * 31;
        Map<String, Object> map = this.metadata;
        return iHashCode8 + (map != null ? map.hashCode() : 0);
    }

    public String toString() {
        return "SessionDto(sessionId=" + this.sessionId + ", deviceId=" + this.deviceId + ", agent=" + this.agent + ", title=" + this.title + ", createdAt=" + this.createdAt + ", updatedAt=" + this.updatedAt + ", lastSeq=" + this.lastSeq + ", messageCount=" + this.messageCount + ", metadata=" + this.metadata + ")";
    }

    public SessionDto(String str, String str2, String str3, String str4, Long l10, Long l11, Long l12, Long l13, Map<String, ? extends Object> map) {
        this.sessionId = str;
        this.deviceId = str2;
        this.agent = str3;
        this.title = str4;
        this.createdAt = l10;
        this.updatedAt = l11;
        this.lastSeq = l12;
        this.messageCount = l13;
        this.metadata = map;
    }

    public /* synthetic */ SessionDto(String str, String str2, String str3, String str4, Long l10, Long l11, Long l12, Long l13, Map map, int i10, kotlin.jvm.internal.i iVar) {
        this((i10 & 1) != 0 ? null : str, (i10 & 2) != 0 ? null : str2, (i10 & 4) != 0 ? null : str3, (i10 & 8) != 0 ? null : str4, (i10 & 16) != 0 ? null : l10, (i10 & 32) != 0 ? null : l11, (i10 & 64) != 0 ? null : l12, (i10 & 128) != 0 ? null : l13, (i10 & 256) != 0 ? null : map);
    }
}
