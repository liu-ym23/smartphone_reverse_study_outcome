package com.stepos.ability.mcpserver.model;

import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.taskrobot.settingsprovider.SettingsConfig;
import io.modelcontextprotocol.spec.McpSchema;
import kotlin.Metadata;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB3\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0001\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0001\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0007HÆ\u0003J7\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0001¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001d"}, d2 = {"Lcom/stepos/ability/mcpserver/model/McpResponse;", "", "jsonrpc", "", "id", "result", "error", "Lcom/stepos/ability/mcpserver/model/McpErrorPayload;", AppAgent.CONSTRUCT, "(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;Lcom/stepos/ability/mcpserver/model/McpErrorPayload;)V", "getJsonrpc", "()Ljava/lang/String;", "getId", "()Ljava/lang/Object;", "getResult", "getError", "()Lcom/stepos/ability/mcpserver/model/McpErrorPayload;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "Companion", "server_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class McpResponse {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final McpErrorPayload error;
    private final Object id;
    private final String jsonrpc;
    private final Object result;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0001J,\u0010\b\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00012\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0001¨\u0006\u000e"}, d2 = {"Lcom/stepos/ability/mcpserver/model/McpResponse$Companion;", "", AppAgent.CONSTRUCT, "()V", "success", "Lcom/stepos/ability/mcpserver/model/McpResponse;", "id", "result", "error", "code", "", "message", "", SettingsConfig.KEY_DATA, "server_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(e eVar) {
            this();
        }

        public static /* synthetic */ McpResponse error$default(Companion companion, Object obj, int i, String str, Object obj2, int i6, Object obj3) {
            if ((i6 & 8) != 0) {
                obj2 = null;
            }
            return companion.error(obj, i, str, obj2);
        }

        public final McpResponse error(Object id, int code, String message, Object data) {
            k.f(message, "message");
            return new McpResponse(null, id, null, new McpErrorPayload(code, message, data), 5, null);
        }

        public final McpResponse success(Object id, Object result) {
            return new McpResponse(null, id, result, null, 9, null);
        }

        private Companion() {
        }
    }

    public McpResponse(String jsonrpc, Object obj, Object obj2, McpErrorPayload mcpErrorPayload) {
        k.f(jsonrpc, "jsonrpc");
        this.jsonrpc = jsonrpc;
        this.id = obj;
        this.result = obj2;
        this.error = mcpErrorPayload;
    }

    public static /* synthetic */ McpResponse copy$default(McpResponse mcpResponse, String str, Object obj, Object obj2, McpErrorPayload mcpErrorPayload, int i, Object obj3) {
        if ((i & 1) != 0) {
            str = mcpResponse.jsonrpc;
        }
        if ((i & 2) != 0) {
            obj = mcpResponse.id;
        }
        if ((i & 4) != 0) {
            obj2 = mcpResponse.result;
        }
        if ((i & 8) != 0) {
            mcpErrorPayload = mcpResponse.error;
        }
        return mcpResponse.copy(str, obj, obj2, mcpErrorPayload);
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
    public final Object getResult() {
        return this.result;
    }

    /* renamed from: component4, reason: from getter */
    public final McpErrorPayload getError() {
        return this.error;
    }

    public final McpResponse copy(String jsonrpc, Object id, Object result, McpErrorPayload error) {
        k.f(jsonrpc, "jsonrpc");
        return new McpResponse(jsonrpc, id, result, error);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof McpResponse)) {
            return false;
        }
        McpResponse mcpResponse = (McpResponse) other;
        return k.b(this.jsonrpc, mcpResponse.jsonrpc) && k.b(this.id, mcpResponse.id) && k.b(this.result, mcpResponse.result) && k.b(this.error, mcpResponse.error);
    }

    public final McpErrorPayload getError() {
        return this.error;
    }

    public final Object getId() {
        return this.id;
    }

    public final String getJsonrpc() {
        return this.jsonrpc;
    }

    public final Object getResult() {
        return this.result;
    }

    public int hashCode() {
        int iHashCode = this.jsonrpc.hashCode() * 31;
        Object obj = this.id;
        int iHashCode2 = (iHashCode + (obj == null ? 0 : obj.hashCode())) * 31;
        Object obj2 = this.result;
        int iHashCode3 = (iHashCode2 + (obj2 == null ? 0 : obj2.hashCode())) * 31;
        McpErrorPayload mcpErrorPayload = this.error;
        return iHashCode3 + (mcpErrorPayload != null ? mcpErrorPayload.hashCode() : 0);
    }

    public String toString() {
        return "McpResponse(jsonrpc=" + this.jsonrpc + ", id=" + this.id + ", result=" + this.result + ", error=" + this.error + ")";
    }

    public /* synthetic */ McpResponse(String str, Object obj, Object obj2, McpErrorPayload mcpErrorPayload, int i, e eVar) {
        this((i & 1) != 0 ? McpSchema.JSONRPC_VERSION : str, obj, (i & 4) != 0 ? null : obj2, (i & 8) != 0 ? null : mcpErrorPayload);
    }
}
