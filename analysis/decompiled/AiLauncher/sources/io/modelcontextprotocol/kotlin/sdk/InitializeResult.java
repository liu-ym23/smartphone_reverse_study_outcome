package io.modelcontextprotocol.kotlin.sdk;

import com.stepos.ailauncher.chat.trace.ChatTracker;
import com.stepos.deepbinder.core.constant.Constants;
import io.modelcontextprotocol.kotlin.sdk.ServerCapabilities;
import kotlin.Metadata;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import pb.E0;
import pb.T0;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\b\u0087\b\u0018\u0000 42\u00020\u0001:\u000254B-\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bBC\b\u0010\u0012\u0006\u0010\r\u001a\u00020\f\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\n\u0010\u0010J'\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u0011\u001a\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0014H\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u001a\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u001c\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u001e\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010 \u001a\u00020\bHÆ\u0003¢\u0006\u0004\b \u0010!J8\u0010\"\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\bHÆ\u0001¢\u0006\u0004\b\"\u0010#J\u0010\u0010$\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b$\u0010\u001bJ\u0010\u0010%\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b%\u0010&J\u001a\u0010*\u001a\u00020)2\b\u0010(\u001a\u0004\u0018\u00010'HÖ\u0003¢\u0006\u0004\b*\u0010+R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010,\u001a\u0004\b-\u0010\u001bR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010.\u001a\u0004\b/\u0010\u001dR\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u00100\u001a\u0004\b1\u0010\u001fR\u001a\u0010\t\u001a\u00020\b8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\t\u00102\u001a\u0004\b3\u0010!¨\u00066"}, d2 = {"Lio/modelcontextprotocol/kotlin/sdk/InitializeResult;", "Lio/modelcontextprotocol/kotlin/sdk/ServerResult;", "", Constants.PARAM_PROTOCOL_VERSION, "Lio/modelcontextprotocol/kotlin/sdk/ServerCapabilities;", "capabilities", "Lio/modelcontextprotocol/kotlin/sdk/Implementation;", "serverInfo", "Lqb/D;", "_meta", "<init>", "(Ljava/lang/String;Lio/modelcontextprotocol/kotlin/sdk/ServerCapabilities;Lio/modelcontextprotocol/kotlin/sdk/Implementation;Lqb/D;)V", "", "seen0", "Lpb/T0;", "serializationConstructorMarker", "(ILjava/lang/String;Lio/modelcontextprotocol/kotlin/sdk/ServerCapabilities;Lio/modelcontextprotocol/kotlin/sdk/Implementation;Lqb/D;Lpb/T0;)V", "self", "Lob/d;", "output", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialDesc", "LY8/t;", "write$Self$kotlin_sdk", "(Lio/modelcontextprotocol/kotlin/sdk/InitializeResult;Lob/d;Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "write$Self", "component1", "()Ljava/lang/String;", "component2", "()Lio/modelcontextprotocol/kotlin/sdk/ServerCapabilities;", "component3", "()Lio/modelcontextprotocol/kotlin/sdk/Implementation;", "component4", "()Lqb/D;", ChatTracker.CLICK_COPY, "(Ljava/lang/String;Lio/modelcontextprotocol/kotlin/sdk/ServerCapabilities;Lio/modelcontextprotocol/kotlin/sdk/Implementation;Lqb/D;)Lio/modelcontextprotocol/kotlin/sdk/InitializeResult;", "toString", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getProtocolVersion", "Lio/modelcontextprotocol/kotlin/sdk/ServerCapabilities;", "getCapabilities", "Lio/modelcontextprotocol/kotlin/sdk/Implementation;", "getServerInfo", "Lqb/D;", "get_meta", "Companion", "$serializer", "kotlin-sdk"}, k = 1, mv = {2, 2, 0}, xi = 48)
@lb.l
/* loaded from: classes4.dex */
public final /* data */ class InitializeResult implements ServerResult {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final qb.D _meta;
    private final ServerCapabilities capabilities;
    private final String protocolVersion;
    private final Implementation serverInfo;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lio/modelcontextprotocol/kotlin/sdk/InitializeResult$Companion;", "", "<init>", "()V", "Lkotlinx/serialization/KSerializer;", "Lio/modelcontextprotocol/kotlin/sdk/InitializeResult;", "serializer", "()Lkotlinx/serialization/KSerializer;", "kotlin-sdk"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public final KSerializer<InitializeResult> serializer() {
            return InitializeResult$$serializer.INSTANCE;
        }

        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }
    }

    public /* synthetic */ InitializeResult(int i10, String str, ServerCapabilities serverCapabilities, Implementation implementation, qb.D d10, T0 t02) {
        if (4 != (i10 & 4)) {
            E0.a(i10, 4, InitializeResult$$serializer.INSTANCE.getDescriptor());
        }
        this.protocolVersion = (i10 & 1) == 0 ? "2024-11-05" : str;
        if ((i10 & 2) == 0) {
            this.capabilities = new ServerCapabilities((qb.D) null, (qb.D) null, (qb.D) null, (ServerCapabilities.Prompts) null, (ServerCapabilities.Resources) null, (ServerCapabilities.Tools) null, 63, (kotlin.jvm.internal.i) null);
        } else {
            this.capabilities = serverCapabilities;
        }
        this.serverInfo = implementation;
        if ((i10 & 8) == 0) {
            this._meta = Types_utilKt.getEmptyJsonObject();
        } else {
            this._meta = d10;
        }
    }

    public static /* synthetic */ InitializeResult copy$default(InitializeResult initializeResult, String str, ServerCapabilities serverCapabilities, Implementation implementation, qb.D d10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = initializeResult.protocolVersion;
        }
        if ((i10 & 2) != 0) {
            serverCapabilities = initializeResult.capabilities;
        }
        if ((i10 & 4) != 0) {
            implementation = initializeResult.serverInfo;
        }
        if ((i10 & 8) != 0) {
            d10 = initializeResult._meta;
        }
        return initializeResult.copy(str, serverCapabilities, implementation, d10);
    }

    public static final /* synthetic */ void write$Self$kotlin_sdk(InitializeResult self, ob.d output, SerialDescriptor serialDesc) {
        if (output.y(serialDesc, 0) || !kotlin.jvm.internal.p.d(self.protocolVersion, "2024-11-05")) {
            output.w(serialDesc, 0, self.protocolVersion);
        }
        if (output.y(serialDesc, 1) || !kotlin.jvm.internal.p.d(self.capabilities, new ServerCapabilities((qb.D) null, (qb.D) null, (qb.D) null, (ServerCapabilities.Prompts) null, (ServerCapabilities.Resources) null, (ServerCapabilities.Tools) null, 63, (kotlin.jvm.internal.i) null))) {
            output.x(serialDesc, 1, ServerCapabilities$$serializer.INSTANCE, self.capabilities);
        }
        output.x(serialDesc, 2, Implementation$$serializer.INSTANCE, self.serverInfo);
        if (!output.y(serialDesc, 3) && kotlin.jvm.internal.p.d(self.get_meta(), Types_utilKt.getEmptyJsonObject())) {
            return;
        }
        output.x(serialDesc, 3, qb.E.f38623a, self.get_meta());
    }

    /* renamed from: component1, reason: from getter */
    public final String getProtocolVersion() {
        return this.protocolVersion;
    }

    /* renamed from: component2, reason: from getter */
    public final ServerCapabilities getCapabilities() {
        return this.capabilities;
    }

    /* renamed from: component3, reason: from getter */
    public final Implementation getServerInfo() {
        return this.serverInfo;
    }

    /* renamed from: component4, reason: from getter */
    public final qb.D get_meta() {
        return this._meta;
    }

    public final InitializeResult copy(String protocolVersion, ServerCapabilities capabilities, Implementation serverInfo, qb.D _meta) {
        kotlin.jvm.internal.p.i(protocolVersion, "protocolVersion");
        kotlin.jvm.internal.p.i(capabilities, "capabilities");
        kotlin.jvm.internal.p.i(serverInfo, "serverInfo");
        kotlin.jvm.internal.p.i(_meta, "_meta");
        return new InitializeResult(protocolVersion, capabilities, serverInfo, _meta);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof InitializeResult)) {
            return false;
        }
        InitializeResult initializeResult = (InitializeResult) other;
        return kotlin.jvm.internal.p.d(this.protocolVersion, initializeResult.protocolVersion) && kotlin.jvm.internal.p.d(this.capabilities, initializeResult.capabilities) && kotlin.jvm.internal.p.d(this.serverInfo, initializeResult.serverInfo) && kotlin.jvm.internal.p.d(this._meta, initializeResult._meta);
    }

    public final ServerCapabilities getCapabilities() {
        return this.capabilities;
    }

    public final String getProtocolVersion() {
        return this.protocolVersion;
    }

    public final Implementation getServerInfo() {
        return this.serverInfo;
    }

    @Override // io.modelcontextprotocol.kotlin.sdk.WithMeta
    public qb.D get_meta() {
        return this._meta;
    }

    public int hashCode() {
        return (((((this.protocolVersion.hashCode() * 31) + this.capabilities.hashCode()) * 31) + this.serverInfo.hashCode()) * 31) + this._meta.hashCode();
    }

    public String toString() {
        return "InitializeResult(protocolVersion=" + this.protocolVersion + ", capabilities=" + this.capabilities + ", serverInfo=" + this.serverInfo + ", _meta=" + this._meta + ')';
    }

    public InitializeResult(String protocolVersion, ServerCapabilities capabilities, Implementation serverInfo, qb.D _meta) {
        kotlin.jvm.internal.p.i(protocolVersion, "protocolVersion");
        kotlin.jvm.internal.p.i(capabilities, "capabilities");
        kotlin.jvm.internal.p.i(serverInfo, "serverInfo");
        kotlin.jvm.internal.p.i(_meta, "_meta");
        this.protocolVersion = protocolVersion;
        this.capabilities = capabilities;
        this.serverInfo = serverInfo;
        this._meta = _meta;
    }

    public /* synthetic */ InitializeResult(String str, ServerCapabilities serverCapabilities, Implementation implementation, qb.D d10, int i10, kotlin.jvm.internal.i iVar) {
        this((i10 & 1) != 0 ? "2024-11-05" : str, (i10 & 2) != 0 ? new ServerCapabilities((qb.D) null, (qb.D) null, (qb.D) null, (ServerCapabilities.Prompts) null, (ServerCapabilities.Resources) null, (ServerCapabilities.Tools) null, 63, (kotlin.jvm.internal.i) null) : serverCapabilities, implementation, (i10 & 8) != 0 ? Types_utilKt.getEmptyJsonObject() : d10);
    }
}
