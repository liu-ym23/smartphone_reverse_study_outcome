package io.modelcontextprotocol.kotlin.sdk;

import com.stepos.ailauncher.chat.trace.ChatTracker;
import kotlin.Metadata;
import kotlinx.serialization.KSerializer;
import pb.E0;
import pb.T0;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0087\b\u0018\u0000 '2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0002('B\u000f\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bB%\b\u0010\u0012\u0006\u0010\n\u001a\u00020\t\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\u0007\u0010\rJ'\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u000e\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0011H\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0017\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0017\u0010\u0018J\u001a\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u001c\u001a\u00020\u001bHÖ\u0001¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u001e\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\u001e\u0010\u001fJ\u001a\u0010#\u001a\u00020\"2\b\u0010!\u001a\u0004\u0018\u00010 HÖ\u0003¢\u0006\u0004\b#\u0010$R\u001a\u0010\u0006\u001a\u00020\u00058\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0006\u0010%\u001a\u0004\b&\u0010\u0018¨\u0006)"}, d2 = {"Lio/modelcontextprotocol/kotlin/sdk/UnknownMethodRequestOrNotification;", "Lio/modelcontextprotocol/kotlin/sdk/ClientNotification;", "Lio/modelcontextprotocol/kotlin/sdk/ClientRequest;", "Lio/modelcontextprotocol/kotlin/sdk/ServerNotification;", "Lio/modelcontextprotocol/kotlin/sdk/ServerRequest;", "Lio/modelcontextprotocol/kotlin/sdk/Method;", "method", "<init>", "(Lio/modelcontextprotocol/kotlin/sdk/Method;)V", "", "seen0", "Lpb/T0;", "serializationConstructorMarker", "(ILio/modelcontextprotocol/kotlin/sdk/Method;Lpb/T0;)V", "self", "Lob/d;", "output", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialDesc", "LY8/t;", "write$Self$kotlin_sdk", "(Lio/modelcontextprotocol/kotlin/sdk/UnknownMethodRequestOrNotification;Lob/d;Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "write$Self", "component1", "()Lio/modelcontextprotocol/kotlin/sdk/Method;", ChatTracker.CLICK_COPY, "(Lio/modelcontextprotocol/kotlin/sdk/Method;)Lio/modelcontextprotocol/kotlin/sdk/UnknownMethodRequestOrNotification;", "", "toString", "()Ljava/lang/String;", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lio/modelcontextprotocol/kotlin/sdk/Method;", "getMethod", "Companion", "$serializer", "kotlin-sdk"}, k = 1, mv = {2, 2, 0}, xi = 48)
@lb.l
/* loaded from: classes4.dex */
public final /* data */ class UnknownMethodRequestOrNotification implements ClientNotification, ClientRequest, ServerNotification, ServerRequest {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final Method method;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lio/modelcontextprotocol/kotlin/sdk/UnknownMethodRequestOrNotification$Companion;", "", "<init>", "()V", "Lkotlinx/serialization/KSerializer;", "Lio/modelcontextprotocol/kotlin/sdk/UnknownMethodRequestOrNotification;", "serializer", "()Lkotlinx/serialization/KSerializer;", "kotlin-sdk"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public final KSerializer<UnknownMethodRequestOrNotification> serializer() {
            return UnknownMethodRequestOrNotification$$serializer.INSTANCE;
        }

        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }
    }

    public /* synthetic */ UnknownMethodRequestOrNotification(int i10, Method method, T0 t02) {
        if (1 != (i10 & 1)) {
            E0.a(i10, 1, UnknownMethodRequestOrNotification$$serializer.INSTANCE.getDescriptor());
        }
        this.method = method;
    }

    public static /* synthetic */ UnknownMethodRequestOrNotification copy$default(UnknownMethodRequestOrNotification unknownMethodRequestOrNotification, Method method, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            method = unknownMethodRequestOrNotification.method;
        }
        return unknownMethodRequestOrNotification.copy(method);
    }

    /* renamed from: component1, reason: from getter */
    public final Method getMethod() {
        return this.method;
    }

    public final UnknownMethodRequestOrNotification copy(Method method) {
        kotlin.jvm.internal.p.i(method, "method");
        return new UnknownMethodRequestOrNotification(method);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof UnknownMethodRequestOrNotification) && kotlin.jvm.internal.p.d(this.method, ((UnknownMethodRequestOrNotification) other).method);
    }

    @Override // io.modelcontextprotocol.kotlin.sdk.Notification
    public Method getMethod() {
        return this.method;
    }

    public int hashCode() {
        return this.method.hashCode();
    }

    public String toString() {
        return "UnknownMethodRequestOrNotification(method=" + this.method + ')';
    }

    public UnknownMethodRequestOrNotification(Method method) {
        kotlin.jvm.internal.p.i(method, "method");
        this.method = method;
    }
}
