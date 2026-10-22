package io.modelcontextprotocol.kotlin.sdk;

import com.stepos.ailauncher.chat.trace.ChatTracker;
import kotlin.Metadata;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import pb.E0;
import pb.T0;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\b\u0087\b\u0018\u0000 +2\u00020\u0001:\u0002,+B#\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bB9\b\u0010\u0012\u0006\u0010\n\u001a\u00020\t\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\u0007\u0010\rJ'\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u000e\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0011H\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0017\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0019\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u001b\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u001b\u0010\u0018J.\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u001e\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u001e\u0010\u0018J\u0010\u0010\u001f\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\u001f\u0010 J\u001a\u0010$\u001a\u00020#2\b\u0010\"\u001a\u0004\u0018\u00010!HÖ\u0003¢\u0006\u0004\b$\u0010%R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010&\u001a\u0004\b'\u0010\u0018R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010(\u001a\u0004\b)\u0010\u001aR\u0017\u0010\u0006\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010&\u001a\u0004\b*\u0010\u0018¨\u0006-"}, d2 = {"Lio/modelcontextprotocol/kotlin/sdk/JSONRPCNotification;", "Lio/modelcontextprotocol/kotlin/sdk/JSONRPCMessage;", "", "method", "Lqb/i;", "params", "jsonrpc", "<init>", "(Ljava/lang/String;Lqb/i;Ljava/lang/String;)V", "", "seen0", "Lpb/T0;", "serializationConstructorMarker", "(ILjava/lang/String;Lqb/i;Ljava/lang/String;Lpb/T0;)V", "self", "Lob/d;", "output", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialDesc", "LY8/t;", "write$Self$kotlin_sdk", "(Lio/modelcontextprotocol/kotlin/sdk/JSONRPCNotification;Lob/d;Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "write$Self", "component1", "()Ljava/lang/String;", "component2", "()Lqb/i;", "component3", ChatTracker.CLICK_COPY, "(Ljava/lang/String;Lqb/i;Ljava/lang/String;)Lio/modelcontextprotocol/kotlin/sdk/JSONRPCNotification;", "toString", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getMethod", "Lqb/i;", "getParams", "getJsonrpc", "Companion", "$serializer", "kotlin-sdk"}, k = 1, mv = {2, 2, 0}, xi = 48)
@lb.l
/* loaded from: classes4.dex */
public final /* data */ class JSONRPCNotification implements JSONRPCMessage {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String jsonrpc;
    private final String method;
    private final qb.i params;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lio/modelcontextprotocol/kotlin/sdk/JSONRPCNotification$Companion;", "", "<init>", "()V", "Lkotlinx/serialization/KSerializer;", "Lio/modelcontextprotocol/kotlin/sdk/JSONRPCNotification;", "serializer", "()Lkotlinx/serialization/KSerializer;", "kotlin-sdk"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public final KSerializer<JSONRPCNotification> serializer() {
            return JSONRPCNotification$$serializer.INSTANCE;
        }

        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }
    }

    public /* synthetic */ JSONRPCNotification(int i10, String str, qb.i iVar, String str2, T0 t02) {
        if (1 != (i10 & 1)) {
            E0.a(i10, 1, JSONRPCNotification$$serializer.INSTANCE.getDescriptor());
        }
        this.method = str;
        if ((i10 & 2) == 0) {
            this.params = Types_utilKt.getEmptyJsonObject();
        } else {
            this.params = iVar;
        }
        if ((i10 & 4) == 0) {
            this.jsonrpc = "2.0";
        } else {
            this.jsonrpc = str2;
        }
    }

    public static /* synthetic */ JSONRPCNotification copy$default(JSONRPCNotification jSONRPCNotification, String str, qb.i iVar, String str2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = jSONRPCNotification.method;
        }
        if ((i10 & 2) != 0) {
            iVar = jSONRPCNotification.params;
        }
        if ((i10 & 4) != 0) {
            str2 = jSONRPCNotification.jsonrpc;
        }
        return jSONRPCNotification.copy(str, iVar, str2);
    }

    public static final /* synthetic */ void write$Self$kotlin_sdk(JSONRPCNotification self, ob.d output, SerialDescriptor serialDesc) {
        output.w(serialDesc, 0, self.method);
        if (output.y(serialDesc, 1) || !kotlin.jvm.internal.p.d(self.params, Types_utilKt.getEmptyJsonObject())) {
            output.x(serialDesc, 1, qb.q.f38674a, self.params);
        }
        if (!output.y(serialDesc, 2) && kotlin.jvm.internal.p.d(self.jsonrpc, "2.0")) {
            return;
        }
        output.w(serialDesc, 2, self.jsonrpc);
    }

    /* renamed from: component1, reason: from getter */
    public final String getMethod() {
        return this.method;
    }

    /* renamed from: component2, reason: from getter */
    public final qb.i getParams() {
        return this.params;
    }

    /* renamed from: component3, reason: from getter */
    public final String getJsonrpc() {
        return this.jsonrpc;
    }

    public final JSONRPCNotification copy(String method, qb.i params, String jsonrpc) {
        kotlin.jvm.internal.p.i(method, "method");
        kotlin.jvm.internal.p.i(params, "params");
        kotlin.jvm.internal.p.i(jsonrpc, "jsonrpc");
        return new JSONRPCNotification(method, params, jsonrpc);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof JSONRPCNotification)) {
            return false;
        }
        JSONRPCNotification jSONRPCNotification = (JSONRPCNotification) other;
        return kotlin.jvm.internal.p.d(this.method, jSONRPCNotification.method) && kotlin.jvm.internal.p.d(this.params, jSONRPCNotification.params) && kotlin.jvm.internal.p.d(this.jsonrpc, jSONRPCNotification.jsonrpc);
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
        return (((this.method.hashCode() * 31) + this.params.hashCode()) * 31) + this.jsonrpc.hashCode();
    }

    public String toString() {
        return "JSONRPCNotification(method=" + this.method + ", params=" + this.params + ", jsonrpc=" + this.jsonrpc + ')';
    }

    public JSONRPCNotification(String method, qb.i params, String jsonrpc) {
        kotlin.jvm.internal.p.i(method, "method");
        kotlin.jvm.internal.p.i(params, "params");
        kotlin.jvm.internal.p.i(jsonrpc, "jsonrpc");
        this.method = method;
        this.params = params;
        this.jsonrpc = jsonrpc;
    }

    public /* synthetic */ JSONRPCNotification(String str, qb.i iVar, String str2, int i10, kotlin.jvm.internal.i iVar2) {
        this(str, (i10 & 2) != 0 ? Types_utilKt.getEmptyJsonObject() : iVar, (i10 & 4) != 0 ? "2.0" : str2);
    }
}
