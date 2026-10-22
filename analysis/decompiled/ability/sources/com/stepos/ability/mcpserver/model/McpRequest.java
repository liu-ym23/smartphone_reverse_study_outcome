package com.stepos.ability.mcpserver.model;

import B7.a;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.ability.beaninternal.task.GuiTaskProgressKt;
import io.modelcontextprotocol.spec.McpSchema;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B;\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0001\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0016\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\u0019\u0010\u0014\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0007HÆ\u0003JC\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00012\b\b\u0002\u0010\u0005\u001a\u00020\u00032\u0018\b\u0002\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0001¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR!\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001c"}, d2 = {"Lcom/stepos/ability/mcpserver/model/McpRequest;", "", "jsonrpc", "", "id", GuiTaskProgressKt.GuiTaskProgress_KEY_METHOD, "params", "", AppAgent.CONSTRUCT, "(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/String;Ljava/util/Map;)V", "getJsonrpc", "()Ljava/lang/String;", "getId", "()Ljava/lang/Object;", "getMethod", "getParams", "()Ljava/util/Map;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "server_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class McpRequest {
    private final Object id;
    private final String jsonrpc;
    private final String method;
    private final Map<String, Object> params;

    public McpRequest(String jsonrpc, Object obj, String method, Map<String, ? extends Object> map) {
        k.f(jsonrpc, "jsonrpc");
        k.f(method, "method");
        this.jsonrpc = jsonrpc;
        this.id = obj;
        this.method = method;
        this.params = map;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ McpRequest copy$default(McpRequest mcpRequest, String str, Object obj, String str2, Map map, int i, Object obj2) {
        if ((i & 1) != 0) {
            str = mcpRequest.jsonrpc;
        }
        if ((i & 2) != 0) {
            obj = mcpRequest.id;
        }
        if ((i & 4) != 0) {
            str2 = mcpRequest.method;
        }
        if ((i & 8) != 0) {
            map = mcpRequest.params;
        }
        return mcpRequest.copy(str, obj, str2, map);
    }

    /* renamed from: component1, reason: from getter */
    public final String getJsonrpc() {
        return this.jsonrpc;
    }

    /* renamed from: component2, reason: from getter */
    public final Object getId() {
        return this.id;
    }

    /* renamed from: component3, reason: from getter */
    public final String getMethod() {
        return this.method;
    }

    public final Map<String, Object> component4() {
        return this.params;
    }

    public final McpRequest copy(String jsonrpc, Object id, String method, Map<String, ? extends Object> params) {
        k.f(jsonrpc, "jsonrpc");
        k.f(method, "method");
        return new McpRequest(jsonrpc, id, method, params);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof McpRequest)) {
            return false;
        }
        McpRequest mcpRequest = (McpRequest) other;
        return k.b(this.jsonrpc, mcpRequest.jsonrpc) && k.b(this.id, mcpRequest.id) && k.b(this.method, mcpRequest.method) && k.b(this.params, mcpRequest.params);
    }

    public final Object getId() {
        return this.id;
    }

    public final String getJsonrpc() {
        return this.jsonrpc;
    }

    public final String getMethod() {
        return this.method;
    }

    public final Map<String, Object> getParams() {
        return this.params;
    }

    public int hashCode() {
        int iHashCode = this.jsonrpc.hashCode() * 31;
        Object obj = this.id;
        int iC = a.c((iHashCode + (obj == null ? 0 : obj.hashCode())) * 31, 31, this.method);
        Map<String, Object> map = this.params;
        return iC + (map != null ? map.hashCode() : 0);
    }

    public String toString() {
        return "McpRequest(jsonrpc=" + this.jsonrpc + ", id=" + this.id + ", method=" + this.method + ", params=" + this.params + ")";
    }

    public /* synthetic */ McpRequest(String str, Object obj, String str2, Map map, int i, e eVar) {
        this((i & 1) != 0 ? McpSchema.JSONRPC_VERSION : str, obj, str2, map);
    }
}
