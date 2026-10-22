package com.stepos.agentbus.generated;

import androidx.autofill.HintConstants;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0085\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0016\b\u0002\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\u0018\b\u0002\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0006\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\u0018\b\u0002\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0006¢\u0006\u0004\b\r\u0010\u000eJ\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\u0017\u0010\u001c\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0006HÆ\u0003J\t\u0010\u001d\u001a\u00020\bHÆ\u0003J\u0019\u0010\u001e\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0019\u0010!\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0006HÆ\u0003J\u008b\u0001\u0010\"\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\u0016\b\u0002\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\u0018\b\u0002\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u00062\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\u0018\b\u0002\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0006HÆ\u0001J\u0013\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010&\u001a\u00020'HÖ\u0001J\t\u0010(\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u001f\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R!\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0013R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0010R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0010R!\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0013¨\u0006)"}, d2 = {"Lcom/stepos/agentbus/generated/ToolCall;", "", "id", "", HintConstants.AUTOFILL_HINT_NAME, "arguments", "", "status", "Lcom/stepos/agentbus/generated/ToolStatus;", "result", "errorCode", "errorMessage", "update", AppAgent.CONSTRUCT, "(Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Lcom/stepos/agentbus/generated/ToolStatus;Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)V", "getId", "()Ljava/lang/String;", "getName", "getArguments", "()Ljava/util/Map;", "getStatus", "()Lcom/stepos/agentbus/generated/ToolStatus;", "getResult", "getErrorCode", "getErrorMessage", "getUpdate", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "", "other", "hashCode", "", "toString", "agentbus-client_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class ToolCall {
    private final Map<String, Object> arguments;
    private final String errorCode;
    private final String errorMessage;
    private final String id;
    private final String name;
    private final Map<String, Object> result;
    private final ToolStatus status;
    private final Map<String, Object> update;

    public ToolCall(String id, String name, Map<String, ? extends Object> arguments, ToolStatus status, Map<String, ? extends Object> map, String str, String str2, Map<String, ? extends Object> map2) {
        k.f(id, "id");
        k.f(name, "name");
        k.f(arguments, "arguments");
        k.f(status, "status");
        this.id = id;
        this.name = name;
        this.arguments = arguments;
        this.status = status;
        this.result = map;
        this.errorCode = str;
        this.errorMessage = str2;
        this.update = map2;
    }

    public static /* synthetic */ ToolCall copy$default(ToolCall toolCall, String str, String str2, Map map, ToolStatus toolStatus, Map map2, String str3, String str4, Map map3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = toolCall.id;
        }
        if ((i & 2) != 0) {
            str2 = toolCall.name;
        }
        if ((i & 4) != 0) {
            map = toolCall.arguments;
        }
        if ((i & 8) != 0) {
            toolStatus = toolCall.status;
        }
        if ((i & 16) != 0) {
            map2 = toolCall.result;
        }
        if ((i & 32) != 0) {
            str3 = toolCall.errorCode;
        }
        if ((i & 64) != 0) {
            str4 = toolCall.errorMessage;
        }
        if ((i & 128) != 0) {
            map3 = toolCall.update;
        }
        String str5 = str4;
        Map map4 = map3;
        Map map5 = map2;
        String str6 = str3;
        return toolCall.copy(str, str2, map, toolStatus, map5, str6, str5, map4);
    }

    /* renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* renamed from: component2, reason: from getter */
    public final String getName() {
        return this.name;
    }

    public final Map<String, Object> component3() {
        return this.arguments;
    }

    /* renamed from: component4, reason: from getter */
    public final ToolStatus getStatus() {
        return this.status;
    }

    public final Map<String, Object> component5() {
        return this.result;
    }

    /* renamed from: component6, reason: from getter */
    public final String getErrorCode() {
        return this.errorCode;
    }

    /* renamed from: component7, reason: from getter */
    public final String getErrorMessage() {
        return this.errorMessage;
    }

    public final Map<String, Object> component8() {
        return this.update;
    }

    public final ToolCall copy(String id, String name, Map<String, ? extends Object> arguments, ToolStatus status, Map<String, ? extends Object> result, String errorCode, String errorMessage, Map<String, ? extends Object> update) {
        k.f(id, "id");
        k.f(name, "name");
        k.f(arguments, "arguments");
        k.f(status, "status");
        return new ToolCall(id, name, arguments, status, result, errorCode, errorMessage, update);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ToolCall)) {
            return false;
        }
        ToolCall toolCall = (ToolCall) other;
        return k.b(this.id, toolCall.id) && k.b(this.name, toolCall.name) && k.b(this.arguments, toolCall.arguments) && this.status == toolCall.status && k.b(this.result, toolCall.result) && k.b(this.errorCode, toolCall.errorCode) && k.b(this.errorMessage, toolCall.errorMessage) && k.b(this.update, toolCall.update);
    }

    public final Map<String, Object> getArguments() {
        return this.arguments;
    }

    public final String getErrorCode() {
        return this.errorCode;
    }

    public final String getErrorMessage() {
        return this.errorMessage;
    }

    public final String getId() {
        return this.id;
    }

    public final String getName() {
        return this.name;
    }

    public final Map<String, Object> getResult() {
        return this.result;
    }

    public final ToolStatus getStatus() {
        return this.status;
    }

    public final Map<String, Object> getUpdate() {
        return this.update;
    }

    public int hashCode() {
        int iHashCode = (this.status.hashCode() + androidx.appfunctions.metadata.a.f(this.arguments, B7.a.c(this.id.hashCode() * 31, 31, this.name), 31)) * 31;
        Map<String, Object> map = this.result;
        int iHashCode2 = (iHashCode + (map == null ? 0 : map.hashCode())) * 31;
        String str = this.errorCode;
        int iHashCode3 = (iHashCode2 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.errorMessage;
        int iHashCode4 = (iHashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31;
        Map<String, Object> map2 = this.update;
        return iHashCode4 + (map2 != null ? map2.hashCode() : 0);
    }

    public String toString() {
        String str = this.id;
        String str2 = this.name;
        Map<String, Object> map = this.arguments;
        ToolStatus toolStatus = this.status;
        Map<String, Object> map2 = this.result;
        String str3 = this.errorCode;
        String str4 = this.errorMessage;
        Map<String, Object> map3 = this.update;
        StringBuilder sbW = B7.a.w("ToolCall(id=", str, ", name=", str2, ", arguments=");
        sbW.append(map);
        sbW.append(", status=");
        sbW.append(toolStatus);
        sbW.append(", result=");
        sbW.append(map2);
        sbW.append(", errorCode=");
        sbW.append(str3);
        sbW.append(", errorMessage=");
        sbW.append(str4);
        sbW.append(", update=");
        sbW.append(map3);
        sbW.append(")");
        return sbW.toString();
    }

    public /* synthetic */ ToolCall(String str, String str2, Map map, ToolStatus toolStatus, Map map2, String str3, String str4, Map map3, int i, e eVar) {
        this(str, str2, (i & 4) != 0 ? kotlin.collections.a.M() : map, (i & 8) != 0 ? ToolStatus.PENDING : toolStatus, (i & 16) != 0 ? null : map2, (i & 32) != 0 ? null : str3, (i & 64) != 0 ? null : str4, (i & 128) != 0 ? null : map3);
    }
}
