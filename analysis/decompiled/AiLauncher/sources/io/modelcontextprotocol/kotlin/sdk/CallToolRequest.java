package io.modelcontextprotocol.kotlin.sdk;

import com.stepos.ailauncher.chat.trace.ChatTracker;
import io.modelcontextprotocol.kotlin.sdk.Method;
import kotlin.Metadata;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import pb.E0;
import pb.T0;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\b\u0087\b\u0018\u0000 12\u00020\u00012\u00020\u0002:\u000221B#\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\tBC\b\u0010\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\r\u001a\u0004\u0018\u00010\f\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\b\u0010\u0010J'\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u0011\u001a\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0014H\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u001a\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u001c\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u001e\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u001e\u0010\u001dJ.\u0010\u001f\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\u001f\u0010 J\u0010\u0010!\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b!\u0010\u001bJ\u0010\u0010\"\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\"\u0010#J\u001a\u0010'\u001a\u00020&2\b\u0010%\u001a\u0004\u0018\u00010$HÖ\u0003¢\u0006\u0004\b'\u0010(R\u0017\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u0010)\u001a\u0004\b*\u0010\u001bR\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010+\u001a\u0004\b,\u0010\u001dR\u001a\u0010\u0007\u001a\u00020\u00058\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0007\u0010+\u001a\u0004\b-\u0010\u001dR\u001a\u0010\r\u001a\u00020\f8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\r\u0010.\u001a\u0004\b/\u00100¨\u00063"}, d2 = {"Lio/modelcontextprotocol/kotlin/sdk/CallToolRequest;", "Lio/modelcontextprotocol/kotlin/sdk/ClientRequest;", "Lio/modelcontextprotocol/kotlin/sdk/WithMeta;", "", "name", "Lqb/D;", "arguments", "_meta", "<init>", "(Ljava/lang/String;Lqb/D;Lqb/D;)V", "", "seen0", "Lio/modelcontextprotocol/kotlin/sdk/Method;", "method", "Lpb/T0;", "serializationConstructorMarker", "(ILjava/lang/String;Lqb/D;Lqb/D;Lio/modelcontextprotocol/kotlin/sdk/Method;Lpb/T0;)V", "self", "Lob/d;", "output", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialDesc", "LY8/t;", "write$Self$kotlin_sdk", "(Lio/modelcontextprotocol/kotlin/sdk/CallToolRequest;Lob/d;Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "write$Self", "component1", "()Ljava/lang/String;", "component2", "()Lqb/D;", "component3", ChatTracker.CLICK_COPY, "(Ljava/lang/String;Lqb/D;Lqb/D;)Lio/modelcontextprotocol/kotlin/sdk/CallToolRequest;", "toString", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getName", "Lqb/D;", "getArguments", "get_meta", "Lio/modelcontextprotocol/kotlin/sdk/Method;", "getMethod", "()Lio/modelcontextprotocol/kotlin/sdk/Method;", "Companion", "$serializer", "kotlin-sdk"}, k = 1, mv = {2, 2, 0}, xi = 48)
@lb.l
/* loaded from: classes4.dex */
public final /* data */ class CallToolRequest implements ClientRequest, WithMeta {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final qb.D _meta;
    private final qb.D arguments;
    private final Method method;
    private final String name;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lio/modelcontextprotocol/kotlin/sdk/CallToolRequest$Companion;", "", "<init>", "()V", "Lkotlinx/serialization/KSerializer;", "Lio/modelcontextprotocol/kotlin/sdk/CallToolRequest;", "serializer", "()Lkotlinx/serialization/KSerializer;", "kotlin-sdk"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public final KSerializer<CallToolRequest> serializer() {
            return CallToolRequest$$serializer.INSTANCE;
        }

        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }
    }

    public /* synthetic */ CallToolRequest(int i10, String str, qb.D d10, qb.D d11, Method method, T0 t02) {
        if (1 != (i10 & 1)) {
            E0.a(i10, 1, CallToolRequest$$serializer.INSTANCE.getDescriptor());
        }
        this.name = str;
        if ((i10 & 2) == 0) {
            this.arguments = Types_utilKt.getEmptyJsonObject();
        } else {
            this.arguments = d10;
        }
        if ((i10 & 4) == 0) {
            this._meta = Types_utilKt.getEmptyJsonObject();
        } else {
            this._meta = d11;
        }
        if ((i10 & 8) == 0) {
            this.method = Method.Defined.ToolsCall;
        } else {
            this.method = method;
        }
    }

    public static /* synthetic */ CallToolRequest copy$default(CallToolRequest callToolRequest, String str, qb.D d10, qb.D d11, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = callToolRequest.name;
        }
        if ((i10 & 2) != 0) {
            d10 = callToolRequest.arguments;
        }
        if ((i10 & 4) != 0) {
            d11 = callToolRequest._meta;
        }
        return callToolRequest.copy(str, d10, d11);
    }

    public static final /* synthetic */ void write$Self$kotlin_sdk(CallToolRequest self, ob.d output, SerialDescriptor serialDesc) {
        output.w(serialDesc, 0, self.name);
        if (output.y(serialDesc, 1) || !kotlin.jvm.internal.p.d(self.arguments, Types_utilKt.getEmptyJsonObject())) {
            output.x(serialDesc, 1, qb.E.f38623a, self.arguments);
        }
        if (output.y(serialDesc, 2) || !kotlin.jvm.internal.p.d(self.get_meta(), Types_utilKt.getEmptyJsonObject())) {
            output.x(serialDesc, 2, qb.E.f38623a, self.get_meta());
        }
        if (!output.y(serialDesc, 3) && self.getMethod() == Method.Defined.ToolsCall) {
            return;
        }
        output.x(serialDesc, 3, RequestMethodSerializer.INSTANCE, self.getMethod());
    }

    /* renamed from: component1, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* renamed from: component2, reason: from getter */
    public final qb.D getArguments() {
        return this.arguments;
    }

    /* renamed from: component3, reason: from getter */
    public final qb.D get_meta() {
        return this._meta;
    }

    public final CallToolRequest copy(String name, qb.D arguments, qb.D _meta) {
        kotlin.jvm.internal.p.i(name, "name");
        kotlin.jvm.internal.p.i(arguments, "arguments");
        kotlin.jvm.internal.p.i(_meta, "_meta");
        return new CallToolRequest(name, arguments, _meta);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CallToolRequest)) {
            return false;
        }
        CallToolRequest callToolRequest = (CallToolRequest) other;
        return kotlin.jvm.internal.p.d(this.name, callToolRequest.name) && kotlin.jvm.internal.p.d(this.arguments, callToolRequest.arguments) && kotlin.jvm.internal.p.d(this._meta, callToolRequest._meta);
    }

    public final qb.D getArguments() {
        return this.arguments;
    }

    @Override // io.modelcontextprotocol.kotlin.sdk.Request
    public Method getMethod() {
        return this.method;
    }

    public final String getName() {
        return this.name;
    }

    @Override // io.modelcontextprotocol.kotlin.sdk.WithMeta
    public qb.D get_meta() {
        return this._meta;
    }

    public int hashCode() {
        return (((this.name.hashCode() * 31) + this.arguments.hashCode()) * 31) + this._meta.hashCode();
    }

    public String toString() {
        return "CallToolRequest(name=" + this.name + ", arguments=" + this.arguments + ", _meta=" + this._meta + ')';
    }

    public CallToolRequest(String name, qb.D arguments, qb.D _meta) {
        kotlin.jvm.internal.p.i(name, "name");
        kotlin.jvm.internal.p.i(arguments, "arguments");
        kotlin.jvm.internal.p.i(_meta, "_meta");
        this.name = name;
        this.arguments = arguments;
        this._meta = _meta;
        this.method = Method.Defined.ToolsCall;
    }

    public /* synthetic */ CallToolRequest(String str, qb.D d10, qb.D d11, int i10, kotlin.jvm.internal.i iVar) {
        this(str, (i10 & 2) != 0 ? Types_utilKt.getEmptyJsonObject() : d10, (i10 & 4) != 0 ? Types_utilKt.getEmptyJsonObject() : d11);
    }
}
