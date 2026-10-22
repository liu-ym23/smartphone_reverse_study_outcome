package io.modelcontextprotocol.kotlin.sdk;

import com.stepos.ailauncher.chat.trace.ChatTracker;
import com.stepos.deepbinder.core.constant.Constants;
import io.modelcontextprotocol.kotlin.sdk.Method;
import kotlin.Metadata;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import pb.E0;
import pb.T0;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0010\b\u0087\b\u0018\u0000 :2\u00020\u00012\u00020\u0002:\u0002;:B)\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fBM\b\u0010\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\n\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011¢\u0006\u0004\b\u000b\u0010\u0013J'\u0010\u001c\u001a\u00020\u00192\u0006\u0010\u0014\u001a\u00020\u00002\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0017H\u0001¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u001d\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u001f\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u001f\u0010 J\u0010\u0010!\u001a\u00020\u0007HÆ\u0003¢\u0006\u0004\b!\u0010\"J\u0010\u0010#\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b#\u0010$J8\u0010%\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\tHÆ\u0001¢\u0006\u0004\b%\u0010&J\u0010\u0010'\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b'\u0010\u001eJ\u0010\u0010(\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b(\u0010)J\u001a\u0010-\u001a\u00020,2\b\u0010+\u001a\u0004\u0018\u00010*HÖ\u0003¢\u0006\u0004\b-\u0010.R\u0017\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u0010/\u001a\u0004\b0\u0010\u001eR\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u00101\u001a\u0004\b2\u0010 R\u0017\u0010\b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\b\u00103\u001a\u0004\b4\u0010\"R\u001a\u0010\n\u001a\u00020\t8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\n\u00105\u001a\u0004\b6\u0010$R\u001a\u0010\u0010\u001a\u00020\u000f8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0010\u00107\u001a\u0004\b8\u00109¨\u0006<"}, d2 = {"Lio/modelcontextprotocol/kotlin/sdk/InitializeRequest;", "Lio/modelcontextprotocol/kotlin/sdk/ClientRequest;", "Lio/modelcontextprotocol/kotlin/sdk/WithMeta;", "", Constants.PARAM_PROTOCOL_VERSION, "Lio/modelcontextprotocol/kotlin/sdk/ClientCapabilities;", "capabilities", "Lio/modelcontextprotocol/kotlin/sdk/Implementation;", "clientInfo", "Lqb/D;", "_meta", "<init>", "(Ljava/lang/String;Lio/modelcontextprotocol/kotlin/sdk/ClientCapabilities;Lio/modelcontextprotocol/kotlin/sdk/Implementation;Lqb/D;)V", "", "seen0", "Lio/modelcontextprotocol/kotlin/sdk/Method;", "method", "Lpb/T0;", "serializationConstructorMarker", "(ILjava/lang/String;Lio/modelcontextprotocol/kotlin/sdk/ClientCapabilities;Lio/modelcontextprotocol/kotlin/sdk/Implementation;Lqb/D;Lio/modelcontextprotocol/kotlin/sdk/Method;Lpb/T0;)V", "self", "Lob/d;", "output", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialDesc", "LY8/t;", "write$Self$kotlin_sdk", "(Lio/modelcontextprotocol/kotlin/sdk/InitializeRequest;Lob/d;Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "write$Self", "component1", "()Ljava/lang/String;", "component2", "()Lio/modelcontextprotocol/kotlin/sdk/ClientCapabilities;", "component3", "()Lio/modelcontextprotocol/kotlin/sdk/Implementation;", "component4", "()Lqb/D;", ChatTracker.CLICK_COPY, "(Ljava/lang/String;Lio/modelcontextprotocol/kotlin/sdk/ClientCapabilities;Lio/modelcontextprotocol/kotlin/sdk/Implementation;Lqb/D;)Lio/modelcontextprotocol/kotlin/sdk/InitializeRequest;", "toString", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getProtocolVersion", "Lio/modelcontextprotocol/kotlin/sdk/ClientCapabilities;", "getCapabilities", "Lio/modelcontextprotocol/kotlin/sdk/Implementation;", "getClientInfo", "Lqb/D;", "get_meta", "Lio/modelcontextprotocol/kotlin/sdk/Method;", "getMethod", "()Lio/modelcontextprotocol/kotlin/sdk/Method;", "Companion", "$serializer", "kotlin-sdk"}, k = 1, mv = {2, 2, 0}, xi = 48)
@lb.l
/* loaded from: classes4.dex */
public final /* data */ class InitializeRequest implements ClientRequest, WithMeta {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final qb.D _meta;
    private final ClientCapabilities capabilities;
    private final Implementation clientInfo;
    private final Method method;
    private final String protocolVersion;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lio/modelcontextprotocol/kotlin/sdk/InitializeRequest$Companion;", "", "<init>", "()V", "Lkotlinx/serialization/KSerializer;", "Lio/modelcontextprotocol/kotlin/sdk/InitializeRequest;", "serializer", "()Lkotlinx/serialization/KSerializer;", "kotlin-sdk"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public final KSerializer<InitializeRequest> serializer() {
            return InitializeRequest$$serializer.INSTANCE;
        }

        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }
    }

    public /* synthetic */ InitializeRequest(int i10, String str, ClientCapabilities clientCapabilities, Implementation implementation, qb.D d10, Method method, T0 t02) {
        if (7 != (i10 & 7)) {
            E0.a(i10, 7, InitializeRequest$$serializer.INSTANCE.getDescriptor());
        }
        this.protocolVersion = str;
        this.capabilities = clientCapabilities;
        this.clientInfo = implementation;
        if ((i10 & 8) == 0) {
            this._meta = Types_utilKt.getEmptyJsonObject();
        } else {
            this._meta = d10;
        }
        if ((i10 & 16) == 0) {
            this.method = Method.Defined.Initialize;
        } else {
            this.method = method;
        }
    }

    public static /* synthetic */ InitializeRequest copy$default(InitializeRequest initializeRequest, String str, ClientCapabilities clientCapabilities, Implementation implementation, qb.D d10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = initializeRequest.protocolVersion;
        }
        if ((i10 & 2) != 0) {
            clientCapabilities = initializeRequest.capabilities;
        }
        if ((i10 & 4) != 0) {
            implementation = initializeRequest.clientInfo;
        }
        if ((i10 & 8) != 0) {
            d10 = initializeRequest._meta;
        }
        return initializeRequest.copy(str, clientCapabilities, implementation, d10);
    }

    public static final /* synthetic */ void write$Self$kotlin_sdk(InitializeRequest self, ob.d output, SerialDescriptor serialDesc) {
        output.w(serialDesc, 0, self.protocolVersion);
        output.x(serialDesc, 1, ClientCapabilities$$serializer.INSTANCE, self.capabilities);
        output.x(serialDesc, 2, Implementation$$serializer.INSTANCE, self.clientInfo);
        if (output.y(serialDesc, 3) || !kotlin.jvm.internal.p.d(self.get_meta(), Types_utilKt.getEmptyJsonObject())) {
            output.x(serialDesc, 3, qb.E.f38623a, self.get_meta());
        }
        if (!output.y(serialDesc, 4) && self.getMethod() == Method.Defined.Initialize) {
            return;
        }
        output.x(serialDesc, 4, RequestMethodSerializer.INSTANCE, self.getMethod());
    }

    /* renamed from: component1, reason: from getter */
    public final String getProtocolVersion() {
        return this.protocolVersion;
    }

    /* renamed from: component2, reason: from getter */
    public final ClientCapabilities getCapabilities() {
        return this.capabilities;
    }

    /* renamed from: component3, reason: from getter */
    public final Implementation getClientInfo() {
        return this.clientInfo;
    }

    /* renamed from: component4, reason: from getter */
    public final qb.D get_meta() {
        return this._meta;
    }

    public final InitializeRequest copy(String protocolVersion, ClientCapabilities capabilities, Implementation clientInfo, qb.D _meta) {
        kotlin.jvm.internal.p.i(protocolVersion, "protocolVersion");
        kotlin.jvm.internal.p.i(capabilities, "capabilities");
        kotlin.jvm.internal.p.i(clientInfo, "clientInfo");
        kotlin.jvm.internal.p.i(_meta, "_meta");
        return new InitializeRequest(protocolVersion, capabilities, clientInfo, _meta);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof InitializeRequest)) {
            return false;
        }
        InitializeRequest initializeRequest = (InitializeRequest) other;
        return kotlin.jvm.internal.p.d(this.protocolVersion, initializeRequest.protocolVersion) && kotlin.jvm.internal.p.d(this.capabilities, initializeRequest.capabilities) && kotlin.jvm.internal.p.d(this.clientInfo, initializeRequest.clientInfo) && kotlin.jvm.internal.p.d(this._meta, initializeRequest._meta);
    }

    public final ClientCapabilities getCapabilities() {
        return this.capabilities;
    }

    public final Implementation getClientInfo() {
        return this.clientInfo;
    }

    @Override // io.modelcontextprotocol.kotlin.sdk.Request
    public Method getMethod() {
        return this.method;
    }

    public final String getProtocolVersion() {
        return this.protocolVersion;
    }

    @Override // io.modelcontextprotocol.kotlin.sdk.WithMeta
    public qb.D get_meta() {
        return this._meta;
    }

    public int hashCode() {
        return (((((this.protocolVersion.hashCode() * 31) + this.capabilities.hashCode()) * 31) + this.clientInfo.hashCode()) * 31) + this._meta.hashCode();
    }

    public String toString() {
        return "InitializeRequest(protocolVersion=" + this.protocolVersion + ", capabilities=" + this.capabilities + ", clientInfo=" + this.clientInfo + ", _meta=" + this._meta + ')';
    }

    public InitializeRequest(String protocolVersion, ClientCapabilities capabilities, Implementation clientInfo, qb.D _meta) {
        kotlin.jvm.internal.p.i(protocolVersion, "protocolVersion");
        kotlin.jvm.internal.p.i(capabilities, "capabilities");
        kotlin.jvm.internal.p.i(clientInfo, "clientInfo");
        kotlin.jvm.internal.p.i(_meta, "_meta");
        this.protocolVersion = protocolVersion;
        this.capabilities = capabilities;
        this.clientInfo = clientInfo;
        this._meta = _meta;
        this.method = Method.Defined.Initialize;
    }

    public /* synthetic */ InitializeRequest(String str, ClientCapabilities clientCapabilities, Implementation implementation, qb.D d10, int i10, kotlin.jvm.internal.i iVar) {
        this(str, clientCapabilities, implementation, (i10 & 8) != 0 ? Types_utilKt.getEmptyJsonObject() : d10);
    }
}
