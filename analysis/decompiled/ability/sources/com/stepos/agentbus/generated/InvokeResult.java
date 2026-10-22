package com.stepos.agentbus.generated;

import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0014\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\u0017\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0005HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\bHÆ\u0003J7\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0016\b\u0002\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00032\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0006HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001f\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001a"}, d2 = {"Lcom/stepos/agentbus/generated/InvokeResult;", "", "ok", "", "payload", "", "", "error", "Lcom/stepos/agentbus/generated/InvokeError;", AppAgent.CONSTRUCT, "(ZLjava/util/Map;Lcom/stepos/agentbus/generated/InvokeError;)V", "getOk", "()Z", "getPayload", "()Ljava/util/Map;", "getError", "()Lcom/stepos/agentbus/generated/InvokeError;", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "agentbus-client_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class InvokeResult {
    private final InvokeError error;
    private final boolean ok;
    private final Map<String, Object> payload;

    public InvokeResult(boolean z10, Map<String, ? extends Object> payload, InvokeError invokeError) {
        k.f(payload, "payload");
        this.ok = z10;
        this.payload = payload;
        this.error = invokeError;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ InvokeResult copy$default(InvokeResult invokeResult, boolean z10, Map map, InvokeError invokeError, int i, Object obj) {
        if ((i & 1) != 0) {
            z10 = invokeResult.ok;
        }
        if ((i & 2) != 0) {
            map = invokeResult.payload;
        }
        if ((i & 4) != 0) {
            invokeError = invokeResult.error;
        }
        return invokeResult.copy(z10, map, invokeError);
    }

    /* renamed from: component1, reason: from getter */
    public final boolean getOk() {
        return this.ok;
    }

    public final Map<String, Object> component2() {
        return this.payload;
    }

    /* renamed from: component3, reason: from getter */
    public final InvokeError getError() {
        return this.error;
    }

    public final InvokeResult copy(boolean ok, Map<String, ? extends Object> payload, InvokeError error) {
        k.f(payload, "payload");
        return new InvokeResult(ok, payload, error);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof InvokeResult)) {
            return false;
        }
        InvokeResult invokeResult = (InvokeResult) other;
        return this.ok == invokeResult.ok && k.b(this.payload, invokeResult.payload) && k.b(this.error, invokeResult.error);
    }

    public final InvokeError getError() {
        return this.error;
    }

    public final boolean getOk() {
        return this.ok;
    }

    public final Map<String, Object> getPayload() {
        return this.payload;
    }

    public int hashCode() {
        int iF = androidx.appfunctions.metadata.a.f(this.payload, Boolean.hashCode(this.ok) * 31, 31);
        InvokeError invokeError = this.error;
        return iF + (invokeError == null ? 0 : invokeError.hashCode());
    }

    public String toString() {
        return "InvokeResult(ok=" + this.ok + ", payload=" + this.payload + ", error=" + this.error + ")";
    }

    public /* synthetic */ InvokeResult(boolean z10, Map map, InvokeError invokeError, int i, e eVar) {
        this(z10, map, (i & 4) != 0 ? null : invokeError);
    }
}
