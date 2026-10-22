package io.modelcontextprotocol.kotlin.sdk;

import com.stepos.ailauncher.chat.trace.ChatTracker;
import kotlin.C4848b;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import p9.InterfaceC5063a;
import pb.E0;
import pb.T0;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0014\b\u0007\u0018\u0000 (2\u00020\u0001:\u0002)(B1\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\n\u0010\u000bBC\b\u0010\u0012\u0006\u0010\r\u001a\u00020\f\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\n\u0010\u0010J'\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u0011\u001a\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0014H\u0001¢\u0006\u0004\b\u0017\u0010\u0018J9\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u001a\u0010\u001bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u001f\u001a\u0004\b \u0010!R\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\"\u001a\u0004\b#\u0010$R\u0019\u0010\t\u001a\u0004\u0018\u00010\b8\u0006¢\u0006\f\n\u0004\b\t\u0010%\u001a\u0004\b&\u0010'¨\u0006*"}, d2 = {"Lio/modelcontextprotocol/kotlin/sdk/JSONRPCResponse;", "Lio/modelcontextprotocol/kotlin/sdk/JSONRPCMessage;", "Lio/modelcontextprotocol/kotlin/sdk/RequestId;", "id", "", "jsonrpc", "Lio/modelcontextprotocol/kotlin/sdk/RequestResult;", "result", "Lio/modelcontextprotocol/kotlin/sdk/JSONRPCError;", "error", "<init>", "(Lio/modelcontextprotocol/kotlin/sdk/RequestId;Ljava/lang/String;Lio/modelcontextprotocol/kotlin/sdk/RequestResult;Lio/modelcontextprotocol/kotlin/sdk/JSONRPCError;)V", "", "seen0", "Lpb/T0;", "serializationConstructorMarker", "(ILio/modelcontextprotocol/kotlin/sdk/RequestId;Ljava/lang/String;Lio/modelcontextprotocol/kotlin/sdk/RequestResult;Lio/modelcontextprotocol/kotlin/sdk/JSONRPCError;Lpb/T0;)V", "self", "Lob/d;", "output", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialDesc", "LY8/t;", "write$Self$kotlin_sdk", "(Lio/modelcontextprotocol/kotlin/sdk/JSONRPCResponse;Lob/d;Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "write$Self", ChatTracker.CLICK_COPY, "(Lio/modelcontextprotocol/kotlin/sdk/RequestId;Ljava/lang/String;Lio/modelcontextprotocol/kotlin/sdk/RequestResult;Lio/modelcontextprotocol/kotlin/sdk/JSONRPCError;)Lio/modelcontextprotocol/kotlin/sdk/JSONRPCResponse;", "Lio/modelcontextprotocol/kotlin/sdk/RequestId;", "getId", "()Lio/modelcontextprotocol/kotlin/sdk/RequestId;", "Ljava/lang/String;", "getJsonrpc", "()Ljava/lang/String;", "Lio/modelcontextprotocol/kotlin/sdk/RequestResult;", "getResult", "()Lio/modelcontextprotocol/kotlin/sdk/RequestResult;", "Lio/modelcontextprotocol/kotlin/sdk/JSONRPCError;", "getError", "()Lio/modelcontextprotocol/kotlin/sdk/JSONRPCError;", "Companion", "$serializer", "kotlin-sdk"}, k = 1, mv = {2, 2, 0}, xi = 48)
@lb.l
/* loaded from: classes4.dex */
public final class JSONRPCResponse implements JSONRPCMessage {
    private final JSONRPCError error;
    private final RequestId id;
    private final String jsonrpc;
    private final RequestResult result;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Y8.h<KSerializer<Object>>[] $childSerializers = {C4848b.a(LazyThreadSafetyMode.PUBLICATION, new InterfaceC5063a() { // from class: io.modelcontextprotocol.kotlin.sdk.q
        @Override // p9.InterfaceC5063a
        public final Object invoke() {
            return JSONRPCResponse._childSerializers$_anonymous_();
        }
    }), null, null, null};

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lio/modelcontextprotocol/kotlin/sdk/JSONRPCResponse$Companion;", "", "<init>", "()V", "Lkotlinx/serialization/KSerializer;", "Lio/modelcontextprotocol/kotlin/sdk/JSONRPCResponse;", "serializer", "()Lkotlinx/serialization/KSerializer;", "kotlin-sdk"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public final KSerializer<JSONRPCResponse> serializer() {
            return JSONRPCResponse$$serializer.INSTANCE;
        }

        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }
    }

    public /* synthetic */ JSONRPCResponse(int i10, RequestId requestId, String str, RequestResult requestResult, JSONRPCError jSONRPCError, T0 t02) {
        if (1 != (i10 & 1)) {
            E0.a(i10, 1, JSONRPCResponse$$serializer.INSTANCE.getDescriptor());
        }
        this.id = requestId;
        if ((i10 & 2) == 0) {
            this.jsonrpc = "2.0";
        } else {
            this.jsonrpc = str;
        }
        if ((i10 & 4) == 0) {
            this.result = null;
        } else {
            this.result = requestResult;
        }
        if ((i10 & 8) == 0) {
            this.error = null;
        } else {
            this.error = jSONRPCError;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_() {
        return new RequestIdSerializer();
    }

    public static /* synthetic */ JSONRPCResponse copy$default(JSONRPCResponse jSONRPCResponse, RequestId requestId, String str, RequestResult requestResult, JSONRPCError jSONRPCError, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            requestId = jSONRPCResponse.id;
        }
        if ((i10 & 2) != 0) {
            str = jSONRPCResponse.jsonrpc;
        }
        if ((i10 & 4) != 0) {
            requestResult = jSONRPCResponse.result;
        }
        if ((i10 & 8) != 0) {
            jSONRPCError = jSONRPCResponse.error;
        }
        return jSONRPCResponse.copy(requestId, str, requestResult, jSONRPCError);
    }

    public static final /* synthetic */ void write$Self$kotlin_sdk(JSONRPCResponse self, ob.d output, SerialDescriptor serialDesc) {
        output.x(serialDesc, 0, $childSerializers[0].getValue(), self.id);
        if (output.y(serialDesc, 1) || !kotlin.jvm.internal.p.d(self.jsonrpc, "2.0")) {
            output.w(serialDesc, 1, self.jsonrpc);
        }
        if (output.y(serialDesc, 2) || self.result != null) {
            output.k(serialDesc, 2, RequestResultPolymorphicSerializer.INSTANCE, self.result);
        }
        if (!output.y(serialDesc, 3) && self.error == null) {
            return;
        }
        output.k(serialDesc, 3, JSONRPCError$$serializer.INSTANCE, self.error);
    }

    public final JSONRPCResponse copy(RequestId id, String jsonrpc, RequestResult result, JSONRPCError error) {
        kotlin.jvm.internal.p.i(id, "id");
        kotlin.jvm.internal.p.i(jsonrpc, "jsonrpc");
        return new JSONRPCResponse(id, jsonrpc, result, error);
    }

    public final JSONRPCError getError() {
        return this.error;
    }

    public final RequestId getId() {
        return this.id;
    }

    public final String getJsonrpc() {
        return this.jsonrpc;
    }

    public final RequestResult getResult() {
        return this.result;
    }

    public JSONRPCResponse(RequestId id, String jsonrpc, RequestResult requestResult, JSONRPCError jSONRPCError) {
        kotlin.jvm.internal.p.i(id, "id");
        kotlin.jvm.internal.p.i(jsonrpc, "jsonrpc");
        this.id = id;
        this.jsonrpc = jsonrpc;
        this.result = requestResult;
        this.error = jSONRPCError;
    }

    public /* synthetic */ JSONRPCResponse(RequestId requestId, String str, RequestResult requestResult, JSONRPCError jSONRPCError, int i10, kotlin.jvm.internal.i iVar) {
        this(requestId, (i10 & 2) != 0 ? "2.0" : str, (i10 & 4) != 0 ? null : requestResult, (i10 & 8) != 0 ? null : jSONRPCError);
    }
}
