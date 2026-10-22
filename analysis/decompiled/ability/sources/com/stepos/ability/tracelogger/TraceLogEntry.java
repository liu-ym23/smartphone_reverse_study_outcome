package com.stepos.ability.tracelogger;

import B7.a;
import androidx.autofill.HintConstants;
import androidx.core.app.NotificationCompat;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.agentbus.generated.AgentBusWakeContract;
import kotlin.Metadata;
import kotlin.jvm.internal.k;
import org.json.JSONObject;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B9\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\nHÆ\u0003JG\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\t\u001a\u00020\nHÆ\u0001J\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001a\u00020!HÖ\u0001J\t\u0010\"\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000eR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000eR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006#"}, d2 = {"Lcom/stepos/ability/tracelogger/TraceLogEntry;", "", NotificationCompat.CATEGORY_EVENT, "", HintConstants.AUTOFILL_HINT_NAME, "time", "", "sessionId", AgentBusWakeContract.EXTRA_TRACE_ID, "payload", "Lorg/json/JSONObject;", AppAgent.CONSTRUCT, "(Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;Lorg/json/JSONObject;)V", "getEvent", "()Ljava/lang/String;", "getName", "getTime", "()J", "getSessionId", "getTraceId", "getPayload", "()Lorg/json/JSONObject;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "", "toString", "tracelogger_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class TraceLogEntry {
    private final String event;
    private final String name;
    private final JSONObject payload;
    private final String sessionId;
    private final long time;
    private final String traceId;

    public TraceLogEntry(String event, String name, long j5, String sessionId, String str, JSONObject payload) {
        k.f(event, "event");
        k.f(name, "name");
        k.f(sessionId, "sessionId");
        k.f(payload, "payload");
        this.event = event;
        this.name = name;
        this.time = j5;
        this.sessionId = sessionId;
        this.traceId = str;
        this.payload = payload;
    }

    public static /* synthetic */ TraceLogEntry copy$default(TraceLogEntry traceLogEntry, String str, String str2, long j5, String str3, String str4, JSONObject jSONObject, int i, Object obj) {
        if ((i & 1) != 0) {
            str = traceLogEntry.event;
        }
        if ((i & 2) != 0) {
            str2 = traceLogEntry.name;
        }
        if ((i & 4) != 0) {
            j5 = traceLogEntry.time;
        }
        if ((i & 8) != 0) {
            str3 = traceLogEntry.sessionId;
        }
        if ((i & 16) != 0) {
            str4 = traceLogEntry.traceId;
        }
        if ((i & 32) != 0) {
            jSONObject = traceLogEntry.payload;
        }
        JSONObject jSONObject2 = jSONObject;
        String str5 = str3;
        long j6 = j5;
        return traceLogEntry.copy(str, str2, j6, str5, str4, jSONObject2);
    }

    /* renamed from: component1, reason: from getter */
    public final String getEvent() {
        return this.event;
    }

    /* renamed from: component2, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* renamed from: component3, reason: from getter */
    public final long getTime() {
        return this.time;
    }

    /* renamed from: component4, reason: from getter */
    public final String getSessionId() {
        return this.sessionId;
    }

    /* renamed from: component5, reason: from getter */
    public final String getTraceId() {
        return this.traceId;
    }

    /* renamed from: component6, reason: from getter */
    public final JSONObject getPayload() {
        return this.payload;
    }

    public final TraceLogEntry copy(String event, String name, long time, String sessionId, String traceId, JSONObject payload) {
        k.f(event, "event");
        k.f(name, "name");
        k.f(sessionId, "sessionId");
        k.f(payload, "payload");
        return new TraceLogEntry(event, name, time, sessionId, traceId, payload);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TraceLogEntry)) {
            return false;
        }
        TraceLogEntry traceLogEntry = (TraceLogEntry) other;
        return k.b(this.event, traceLogEntry.event) && k.b(this.name, traceLogEntry.name) && this.time == traceLogEntry.time && k.b(this.sessionId, traceLogEntry.sessionId) && k.b(this.traceId, traceLogEntry.traceId) && k.b(this.payload, traceLogEntry.payload);
    }

    public final String getEvent() {
        return this.event;
    }

    public final String getName() {
        return this.name;
    }

    public final JSONObject getPayload() {
        return this.payload;
    }

    public final String getSessionId() {
        return this.sessionId;
    }

    public final long getTime() {
        return this.time;
    }

    public final String getTraceId() {
        return this.traceId;
    }

    public int hashCode() {
        int iC = a.c(androidx.appfunctions.metadata.a.c(a.c(this.event.hashCode() * 31, 31, this.name), 31, this.time), 31, this.sessionId);
        String str = this.traceId;
        return this.payload.hashCode() + ((iC + (str == null ? 0 : str.hashCode())) * 31);
    }

    public String toString() {
        String str = this.event;
        String str2 = this.name;
        long j5 = this.time;
        String str3 = this.sessionId;
        String str4 = this.traceId;
        JSONObject jSONObject = this.payload;
        StringBuilder sbW = a.w("TraceLogEntry(event=", str, ", name=", str2, ", time=");
        sbW.append(j5);
        sbW.append(", sessionId=");
        sbW.append(str3);
        sbW.append(", traceId=");
        sbW.append(str4);
        sbW.append(", payload=");
        sbW.append(jSONObject);
        sbW.append(")");
        return sbW.toString();
    }
}
