package io.modelcontextprotocol.kotlin.sdk;

import com.stepos.ailauncher.chat.trace.ChatTracker;
import d9.C3962a;
import io.modelcontextprotocol.kotlin.sdk.RequestId;
import kotlin.C4848b;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import p9.InterfaceC5063a;
import pb.E0;
import pb.T0;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\b\u0087\b\u0018\u0000 12\u00020\u0001:\u000221B-\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\u0004¢\u0006\u0004\b\t\u0010\nBC\b\u0010\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\t\u0010\u000fJ'\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u0010\u001a\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0013H\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0019\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u001b\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u001d\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u001f\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b\u001f\u0010\u001cJ8\u0010 \u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u0004HÆ\u0001¢\u0006\u0004\b \u0010!J\u0010\u0010\"\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\"\u0010\u001cJ\u0010\u0010#\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b#\u0010$J\u001a\u0010(\u001a\u00020'2\b\u0010&\u001a\u0004\u0018\u00010%HÖ\u0003¢\u0006\u0004\b(\u0010)R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010*\u001a\u0004\b+\u0010\u001aR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010,\u001a\u0004\b-\u0010\u001cR\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010.\u001a\u0004\b/\u0010\u001eR\u0017\u0010\b\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\b\u0010,\u001a\u0004\b0\u0010\u001c¨\u00063"}, d2 = {"Lio/modelcontextprotocol/kotlin/sdk/JSONRPCRequest;", "Lio/modelcontextprotocol/kotlin/sdk/JSONRPCMessage;", "Lio/modelcontextprotocol/kotlin/sdk/RequestId;", "id", "", "method", "Lqb/i;", "params", "jsonrpc", "<init>", "(Lio/modelcontextprotocol/kotlin/sdk/RequestId;Ljava/lang/String;Lqb/i;Ljava/lang/String;)V", "", "seen0", "Lpb/T0;", "serializationConstructorMarker", "(ILio/modelcontextprotocol/kotlin/sdk/RequestId;Ljava/lang/String;Lqb/i;Ljava/lang/String;Lpb/T0;)V", "self", "Lob/d;", "output", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialDesc", "LY8/t;", "write$Self$kotlin_sdk", "(Lio/modelcontextprotocol/kotlin/sdk/JSONRPCRequest;Lob/d;Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "write$Self", "component1", "()Lio/modelcontextprotocol/kotlin/sdk/RequestId;", "component2", "()Ljava/lang/String;", "component3", "()Lqb/i;", "component4", ChatTracker.CLICK_COPY, "(Lio/modelcontextprotocol/kotlin/sdk/RequestId;Ljava/lang/String;Lqb/i;Ljava/lang/String;)Lio/modelcontextprotocol/kotlin/sdk/JSONRPCRequest;", "toString", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lio/modelcontextprotocol/kotlin/sdk/RequestId;", "getId", "Ljava/lang/String;", "getMethod", "Lqb/i;", "getParams", "getJsonrpc", "Companion", "$serializer", "kotlin-sdk"}, k = 1, mv = {2, 2, 0}, xi = 48)
@lb.l
/* loaded from: classes4.dex */
public final /* data */ class JSONRPCRequest implements JSONRPCMessage {
    private final RequestId id;
    private final String jsonrpc;
    private final String method;
    private final qb.i params;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Y8.h<KSerializer<Object>>[] $childSerializers = {C4848b.a(LazyThreadSafetyMode.PUBLICATION, new InterfaceC5063a() { // from class: io.modelcontextprotocol.kotlin.sdk.p
        @Override // p9.InterfaceC5063a
        public final Object invoke() {
            return JSONRPCRequest._childSerializers$_anonymous_();
        }
    }), null, null, null};

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lio/modelcontextprotocol/kotlin/sdk/JSONRPCRequest$Companion;", "", "<init>", "()V", "Lkotlinx/serialization/KSerializer;", "Lio/modelcontextprotocol/kotlin/sdk/JSONRPCRequest;", "serializer", "()Lkotlinx/serialization/KSerializer;", "kotlin-sdk"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public final KSerializer<JSONRPCRequest> serializer() {
            return JSONRPCRequest$$serializer.INSTANCE;
        }

        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }
    }

    public /* synthetic */ JSONRPCRequest(int i10, RequestId requestId, String str, qb.i iVar, String str2, T0 t02) {
        if (2 != (i10 & 2)) {
            E0.a(i10, 2, JSONRPCRequest$$serializer.INSTANCE.getDescriptor());
        }
        this.id = (i10 & 1) == 0 ? new RequestId.NumberId(C3962a.a(TypesKt.REQUEST_MESSAGE_ID)) : requestId;
        this.method = str;
        if ((i10 & 4) == 0) {
            this.params = Types_utilKt.getEmptyJsonObject();
        } else {
            this.params = iVar;
        }
        if ((i10 & 8) == 0) {
            this.jsonrpc = "2.0";
        } else {
            this.jsonrpc = str2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_() {
        return new RequestIdSerializer();
    }

    public static /* synthetic */ JSONRPCRequest copy$default(JSONRPCRequest jSONRPCRequest, RequestId requestId, String str, qb.i iVar, String str2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            requestId = jSONRPCRequest.id;
        }
        if ((i10 & 2) != 0) {
            str = jSONRPCRequest.method;
        }
        if ((i10 & 4) != 0) {
            iVar = jSONRPCRequest.params;
        }
        if ((i10 & 8) != 0) {
            str2 = jSONRPCRequest.jsonrpc;
        }
        return jSONRPCRequest.copy(requestId, str, iVar, str2);
    }

    public static final /* synthetic */ void write$Self$kotlin_sdk(JSONRPCRequest self, ob.d output, SerialDescriptor serialDesc) {
        Y8.h<KSerializer<Object>>[] hVarArr = $childSerializers;
        if (output.y(serialDesc, 0) || !kotlin.jvm.internal.p.d(self.id, new RequestId.NumberId(C3962a.a(TypesKt.REQUEST_MESSAGE_ID)))) {
            output.x(serialDesc, 0, hVarArr[0].getValue(), self.id);
        }
        output.w(serialDesc, 1, self.method);
        if (output.y(serialDesc, 2) || !kotlin.jvm.internal.p.d(self.params, Types_utilKt.getEmptyJsonObject())) {
            output.x(serialDesc, 2, qb.q.f38674a, self.params);
        }
        if (!output.y(serialDesc, 3) && kotlin.jvm.internal.p.d(self.jsonrpc, "2.0")) {
            return;
        }
        output.w(serialDesc, 3, self.jsonrpc);
    }

    /* renamed from: component1, reason: from getter */
    public final RequestId getId() {
        return this.id;
    }

    /* renamed from: component2, reason: from getter */
    public final String getMethod() {
        return this.method;
    }

    /* renamed from: component3, reason: from getter */
    public final qb.i getParams() {
        return this.params;
    }

    /* renamed from: component4, reason: from getter */
    public final String getJsonrpc() {
        return this.jsonrpc;
    }

    public final JSONRPCRequest copy(RequestId id, String method, qb.i params, String jsonrpc) {
        kotlin.jvm.internal.p.i(id, "id");
        kotlin.jvm.internal.p.i(method, "method");
        kotlin.jvm.internal.p.i(params, "params");
        kotlin.jvm.internal.p.i(jsonrpc, "jsonrpc");
        return new JSONRPCRequest(id, method, params, jsonrpc);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof JSONRPCRequest)) {
            return false;
        }
        JSONRPCRequest jSONRPCRequest = (JSONRPCRequest) other;
        return kotlin.jvm.internal.p.d(this.id, jSONRPCRequest.id) && kotlin.jvm.internal.p.d(this.method, jSONRPCRequest.method) && kotlin.jvm.internal.p.d(this.params, jSONRPCRequest.params) && kotlin.jvm.internal.p.d(this.jsonrpc, jSONRPCRequest.jsonrpc);
    }

    public final RequestId getId() {
        return this.id;
    }

    public final String getJsonrpc() {
        return this.jsonrpc;
    }

    public final String getMethod() {
        return this.method;
    }

    public final qb.i getParams() {
        return this.params;
    }

    public int hashCode() {
        return (((((this.id.hashCode() * 31) + this.method.hashCode()) * 31) + this.params.hashCode()) * 31) + this.jsonrpc.hashCode();
    }

    public String toString() {
        return "JSONRPCRequest(id=" + this.id + ", method=" + this.method + ", params=" + this.params + ", jsonrpc=" + this.jsonrpc + ')';
    }

    public JSONRPCRequest(RequestId id, String method, qb.i params, String jsonrpc) {
        kotlin.jvm.internal.p.i(id, "id");
        kotlin.jvm.internal.p.i(method, "method");
        kotlin.jvm.internal.p.i(params, "params");
        kotlin.jvm.internal.p.i(jsonrpc, "jsonrpc");
        this.id = id;
        this.method = method;
        this.params = params;
        this.jsonrpc = jsonrpc;
    }

    public /* synthetic */ JSONRPCRequest(RequestId requestId, String str, qb.i iVar, String str2, int i10, kotlin.jvm.internal.i iVar2) {
        this((i10 & 1) != 0 ? new RequestId.NumberId(C3962a.a(TypesKt.REQUEST_MESSAGE_ID)) : requestId, str, (i10 & 4) != 0 ? Types_utilKt.getEmptyJsonObject() : iVar, (i10 & 8) != 0 ? "2.0" : str2);
    }
}
