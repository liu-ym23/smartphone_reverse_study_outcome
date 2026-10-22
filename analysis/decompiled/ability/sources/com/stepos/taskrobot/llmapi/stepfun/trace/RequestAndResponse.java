package com.stepos.taskrobot.llmapi.stepfun.trace;

import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.google.gson.JsonElement;
import kotlin.Metadata;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B;\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\n\u0010\u000bJ\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0006HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\bHÆ\u0003JC\u0010\u001a\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\bHÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001J\t\u0010 \u001a\u00020\u0004HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0001¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013¨\u0006!"}, d2 = {"Lcom/stepos/taskrobot/llmapi/stepfun/trace/RequestAndResponse;", "", "request", "response", "", "costTimeMs", "", "remoteTraceRaw", "Lcom/google/gson/JsonElement;", "fullResponse", AppAgent.CONSTRUCT, "(Ljava/lang/Object;Ljava/lang/String;JLcom/google/gson/JsonElement;Lcom/google/gson/JsonElement;)V", "getRequest", "()Ljava/lang/Object;", "getResponse", "()Ljava/lang/String;", "getCostTimeMs", "()J", "getRemoteTraceRaw", "()Lcom/google/gson/JsonElement;", "getFullResponse", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "stepfun_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class RequestAndResponse {
    private final long costTimeMs;
    private final JsonElement fullResponse;
    private final JsonElement remoteTraceRaw;
    private final Object request;
    private final String response;

    public RequestAndResponse(Object obj, String str, long j5, JsonElement jsonElement, JsonElement jsonElement2) {
        this.request = obj;
        this.response = str;
        this.costTimeMs = j5;
        this.remoteTraceRaw = jsonElement;
        this.fullResponse = jsonElement2;
    }

    public static /* synthetic */ RequestAndResponse copy$default(RequestAndResponse requestAndResponse, Object obj, String str, long j5, JsonElement jsonElement, JsonElement jsonElement2, int i, Object obj2) {
        if ((i & 1) != 0) {
            obj = requestAndResponse.request;
        }
        if ((i & 2) != 0) {
            str = requestAndResponse.response;
        }
        if ((i & 4) != 0) {
            j5 = requestAndResponse.costTimeMs;
        }
        if ((i & 8) != 0) {
            jsonElement = requestAndResponse.remoteTraceRaw;
        }
        if ((i & 16) != 0) {
            jsonElement2 = requestAndResponse.fullResponse;
        }
        long j6 = j5;
        return requestAndResponse.copy(obj, str, j6, jsonElement, jsonElement2);
    }

    /* renamed from: component1, reason: from getter */
    public final Object getRequest() {
        return this.request;
    }

    /* renamed from: component2, reason: from getter */
    public final String getResponse() {
        return this.response;
    }

    /* renamed from: component3, reason: from getter */
    public final long getCostTimeMs() {
        return this.costTimeMs;
    }

    /* renamed from: component4, reason: from getter */
    public final JsonElement getRemoteTraceRaw() {
        return this.remoteTraceRaw;
    }

    /* renamed from: component5, reason: from getter */
    public final JsonElement getFullResponse() {
        return this.fullResponse;
    }

    public final RequestAndResponse copy(Object request, String response, long costTimeMs, JsonElement remoteTraceRaw, JsonElement fullResponse) {
        return new RequestAndResponse(request, response, costTimeMs, remoteTraceRaw, fullResponse);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RequestAndResponse)) {
            return false;
        }
        RequestAndResponse requestAndResponse = (RequestAndResponse) other;
        return k.b(this.request, requestAndResponse.request) && k.b(this.response, requestAndResponse.response) && this.costTimeMs == requestAndResponse.costTimeMs && k.b(this.remoteTraceRaw, requestAndResponse.remoteTraceRaw) && k.b(this.fullResponse, requestAndResponse.fullResponse);
    }

    public final long getCostTimeMs() {
        return this.costTimeMs;
    }

    public final JsonElement getFullResponse() {
        return this.fullResponse;
    }

    public final JsonElement getRemoteTraceRaw() {
        return this.remoteTraceRaw;
    }

    public final Object getRequest() {
        return this.request;
    }

    public final String getResponse() {
        return this.response;
    }

    public int hashCode() {
        Object obj = this.request;
        int iHashCode = (obj == null ? 0 : obj.hashCode()) * 31;
        String str = this.response;
        int iC = androidx.appfunctions.metadata.a.c((iHashCode + (str == null ? 0 : str.hashCode())) * 31, 31, this.costTimeMs);
        JsonElement jsonElement = this.remoteTraceRaw;
        int iHashCode2 = (iC + (jsonElement == null ? 0 : jsonElement.hashCode())) * 31;
        JsonElement jsonElement2 = this.fullResponse;
        return iHashCode2 + (jsonElement2 != null ? jsonElement2.hashCode() : 0);
    }

    public String toString() {
        return "RequestAndResponse(request=" + this.request + ", response=" + this.response + ", costTimeMs=" + this.costTimeMs + ", remoteTraceRaw=" + this.remoteTraceRaw + ", fullResponse=" + this.fullResponse + ")";
    }

    public /* synthetic */ RequestAndResponse(Object obj, String str, long j5, JsonElement jsonElement, JsonElement jsonElement2, int i, e eVar) {
        this(obj, str, j5, (i & 8) != 0 ? null : jsonElement, (i & 16) != 0 ? null : jsonElement2);
    }
}
