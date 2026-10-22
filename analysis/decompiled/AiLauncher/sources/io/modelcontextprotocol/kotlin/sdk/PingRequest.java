package io.modelcontextprotocol.kotlin.sdk;

import io.modelcontextprotocol.kotlin.sdk.Method;
import kotlin.Metadata;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import pb.T0;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u0000 \u00182\u00020\u00012\u00020\u0002:\u0002\u0019\u0018B\u0007¢\u0006\u0004\b\u0003\u0010\u0004B%\b\u0010\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u0003\u0010\u000bJ'\u0010\u0014\u001a\u00020\u00112\u0006\u0010\f\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fH\u0001¢\u0006\u0004\b\u0012\u0010\u0013R\u001a\u0010\b\u001a\u00020\u00078\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\b\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u001a"}, d2 = {"Lio/modelcontextprotocol/kotlin/sdk/PingRequest;", "Lio/modelcontextprotocol/kotlin/sdk/ServerRequest;", "Lio/modelcontextprotocol/kotlin/sdk/ClientRequest;", "<init>", "()V", "", "seen0", "Lio/modelcontextprotocol/kotlin/sdk/Method;", "method", "Lpb/T0;", "serializationConstructorMarker", "(ILio/modelcontextprotocol/kotlin/sdk/Method;Lpb/T0;)V", "self", "Lob/d;", "output", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialDesc", "LY8/t;", "write$Self$kotlin_sdk", "(Lio/modelcontextprotocol/kotlin/sdk/PingRequest;Lob/d;Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "write$Self", "Lio/modelcontextprotocol/kotlin/sdk/Method;", "getMethod", "()Lio/modelcontextprotocol/kotlin/sdk/Method;", "Companion", "$serializer", "kotlin-sdk"}, k = 1, mv = {2, 2, 0}, xi = 48)
@lb.l
/* loaded from: classes4.dex */
public final class PingRequest implements ServerRequest, ClientRequest {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final Method method;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lio/modelcontextprotocol/kotlin/sdk/PingRequest$Companion;", "", "<init>", "()V", "Lkotlinx/serialization/KSerializer;", "Lio/modelcontextprotocol/kotlin/sdk/PingRequest;", "serializer", "()Lkotlinx/serialization/KSerializer;", "kotlin-sdk"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public final KSerializer<PingRequest> serializer() {
            return PingRequest$$serializer.INSTANCE;
        }

        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }
    }

    public PingRequest() {
        this.method = Method.Defined.Ping;
    }

    public static final /* synthetic */ void write$Self$kotlin_sdk(PingRequest self, ob.d output, SerialDescriptor serialDesc) {
        if (!output.y(serialDesc, 0) && self.getMethod() == Method.Defined.Ping) {
            return;
        }
        output.x(serialDesc, 0, RequestMethodSerializer.INSTANCE, self.getMethod());
    }

    @Override // io.modelcontextprotocol.kotlin.sdk.Request
    public Method getMethod() {
        return this.method;
    }

    public /* synthetic */ PingRequest(int i10, Method method, T0 t02) {
        if ((i10 & 1) == 0) {
            this.method = Method.Defined.Ping;
        } else {
            this.method = method;
        }
    }
}
