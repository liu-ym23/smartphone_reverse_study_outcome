package com.stepos.agentframework.adapter.agentbus.bff;

import com.google.gson.annotations.SerializedName;
import com.stepos.statsapp.v3.lib.plugin.constants.Parameters;
import java.util.Map;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B;\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0002\u0012\u0016\b\u0002\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0006¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0013\u001a\u0004\b\u0014\u0010\u000bR\u001a\u0010\u0004\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0013\u001a\u0004\b\u0015\u0010\u000bR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0013\u001a\u0004\b\u0016\u0010\u000bR(\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019¨\u0006\u001a"}, d2 = {"Lcom/stepos/agentframework/adapter/agentbus/bff/l;", "", "", "deviceId", "agent", "title", "", "metadata", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getDeviceId", "getAgent", "getTitle", "Ljava/util/Map;", "getMetadata", "()Ljava/util/Map;", "protocol_agentbus_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.agentframework.adapter.agentbus.bff.l, reason: from toString */
/* loaded from: classes2.dex */
public final /* data */ class SessionCreateRequest {

    @SerializedName("agent")
    private final String agent;

    @SerializedName(Parameters.DEVICE_ID)
    private final String deviceId;

    @SerializedName("metadata")
    private final Map<String, Object> metadata;

    @SerializedName("title")
    private final String title;

    public SessionCreateRequest(String deviceId, String agent, String str, Map<String, ? extends Object> map) {
        kotlin.jvm.internal.p.i(deviceId, "deviceId");
        kotlin.jvm.internal.p.i(agent, "agent");
        this.deviceId = deviceId;
        this.agent = agent;
        this.title = str;
        this.metadata = map;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SessionCreateRequest)) {
            return false;
        }
        SessionCreateRequest sessionCreateRequest = (SessionCreateRequest) other;
        return kotlin.jvm.internal.p.d(this.deviceId, sessionCreateRequest.deviceId) && kotlin.jvm.internal.p.d(this.agent, sessionCreateRequest.agent) && kotlin.jvm.internal.p.d(this.title, sessionCreateRequest.title) && kotlin.jvm.internal.p.d(this.metadata, sessionCreateRequest.metadata);
    }

    public int hashCode() {
        int iHashCode = ((this.deviceId.hashCode() * 31) + this.agent.hashCode()) * 31;
        String str = this.title;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        Map<String, Object> map = this.metadata;
        return iHashCode2 + (map != null ? map.hashCode() : 0);
    }

    public String toString() {
        return "SessionCreateRequest(deviceId=" + this.deviceId + ", agent=" + this.agent + ", title=" + this.title + ", metadata=" + this.metadata + ")";
    }

    public /* synthetic */ SessionCreateRequest(String str, String str2, String str3, Map map, int i10, kotlin.jvm.internal.i iVar) {
        this(str, str2, (i10 & 4) != 0 ? null : str3, (i10 & 8) != 0 ? null : map);
    }
}
