package com.stepos.agentbus.generated;

import androidx.autofill.HintConstants;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0014\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u0017\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0005HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003JC\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0016\b\u0002\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001f\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000b¨\u0006\u001b"}, d2 = {"Lcom/stepos/agentbus/generated/StepClawEvent;", "", HintConstants.AUTOFILL_HINT_NAME, "", "payload", "", "sessionId", "runId", AppAgent.CONSTRUCT, "(Ljava/lang/String;Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;)V", "getName", "()Ljava/lang/String;", "getPayload", "()Ljava/util/Map;", "getSessionId", "getRunId", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "agentbus-client_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class StepClawEvent {
    private final String name;
    private final Map<String, Object> payload;
    private final String runId;
    private final String sessionId;

    public StepClawEvent(String name, Map<String, ? extends Object> payload, String str, String str2) {
        k.f(name, "name");
        k.f(payload, "payload");
        this.name = name;
        this.payload = payload;
        this.sessionId = str;
        this.runId = str2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ StepClawEvent copy$default(StepClawEvent stepClawEvent, String str, Map map, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = stepClawEvent.name;
        }
        if ((i & 2) != 0) {
            map = stepClawEvent.payload;
        }
        if ((i & 4) != 0) {
            str2 = stepClawEvent.sessionId;
        }
        if ((i & 8) != 0) {
            str3 = stepClawEvent.runId;
        }
        return stepClawEvent.copy(str, map, str2, str3);
    }

    /* renamed from: component1, reason: from getter */
    public final String getName() {
        return this.name;
    }

    public final Map<String, Object> component2() {
        return this.payload;
    }

    /* renamed from: component3, reason: from getter */
    public final String getSessionId() {
        return this.sessionId;
    }

    /* renamed from: component4, reason: from getter */
    public final String getRunId() {
        return this.runId;
    }

    public final StepClawEvent copy(String name, Map<String, ? extends Object> payload, String sessionId, String runId) {
        k.f(name, "name");
        k.f(payload, "payload");
        return new StepClawEvent(name, payload, sessionId, runId);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof StepClawEvent)) {
            return false;
        }
        StepClawEvent stepClawEvent = (StepClawEvent) other;
        return k.b(this.name, stepClawEvent.name) && k.b(this.payload, stepClawEvent.payload) && k.b(this.sessionId, stepClawEvent.sessionId) && k.b(this.runId, stepClawEvent.runId);
    }

    public final String getName() {
        return this.name;
    }

    public final Map<String, Object> getPayload() {
        return this.payload;
    }

    public final String getRunId() {
        return this.runId;
    }

    public final String getSessionId() {
        return this.sessionId;
    }

    public int hashCode() {
        int iF = androidx.appfunctions.metadata.a.f(this.payload, this.name.hashCode() * 31, 31);
        String str = this.sessionId;
        int iHashCode = (iF + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.runId;
        return iHashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        String str = this.name;
        Map<String, Object> map = this.payload;
        String str2 = this.sessionId;
        String str3 = this.runId;
        StringBuilder sb = new StringBuilder("StepClawEvent(name=");
        sb.append(str);
        sb.append(", payload=");
        sb.append(map);
        sb.append(", sessionId=");
        return androidx.appfunctions.metadata.a.p(sb, str2, ", runId=", str3, ")");
    }

    public /* synthetic */ StepClawEvent(String str, Map map, String str2, String str3, int i, e eVar) {
        this(str, map, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? null : str3);
    }
}
