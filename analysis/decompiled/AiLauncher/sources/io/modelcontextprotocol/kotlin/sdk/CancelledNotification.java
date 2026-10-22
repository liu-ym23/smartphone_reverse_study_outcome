package io.modelcontextprotocol.kotlin.sdk;

import com.stepos.ailauncher.chat.trace.ChatTracker;
import io.modelcontextprotocol.kotlin.sdk.Method;
import kotlin.C4848b;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import p9.InterfaceC5063a;
import pb.E0;
import pb.T0;
import pb.Y0;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\b\u0087\b\u0018\u0000 52\u00020\u00012\u00020\u00022\u00020\u0003:\u000265B#\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bBC\b\u0010\u0012\u0006\u0010\r\u001a\u00020\f\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b\n\u0010\u0012J'\u0010\u001b\u001a\u00020\u00182\u0006\u0010\u0013\u001a\u00020\u00002\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u0016H\u0001¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u001c\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b\u001c\u0010\u001dJ\u0012\u0010\u001e\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010 \u001a\u00020\bHÆ\u0003¢\u0006\u0004\b \u0010!J0\u0010\"\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\t\u001a\u00020\bHÆ\u0001¢\u0006\u0004\b\"\u0010#J\u0010\u0010$\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b$\u0010\u001fJ\u0010\u0010%\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b%\u0010&J\u001a\u0010*\u001a\u00020)2\b\u0010(\u001a\u0004\u0018\u00010'HÖ\u0003¢\u0006\u0004\b*\u0010+R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010,\u001a\u0004\b-\u0010\u001dR\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010.\u001a\u0004\b/\u0010\u001fR\u001a\u0010\t\u001a\u00020\b8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\t\u00100\u001a\u0004\b1\u0010!R\u001a\u0010\u000f\u001a\u00020\u000e8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u000f\u00102\u001a\u0004\b3\u00104¨\u00067"}, d2 = {"Lio/modelcontextprotocol/kotlin/sdk/CancelledNotification;", "Lio/modelcontextprotocol/kotlin/sdk/ClientNotification;", "Lio/modelcontextprotocol/kotlin/sdk/ServerNotification;", "Lio/modelcontextprotocol/kotlin/sdk/WithMeta;", "Lio/modelcontextprotocol/kotlin/sdk/RequestId;", "requestId", "", "reason", "Lqb/D;", "_meta", "<init>", "(Lio/modelcontextprotocol/kotlin/sdk/RequestId;Ljava/lang/String;Lqb/D;)V", "", "seen0", "Lio/modelcontextprotocol/kotlin/sdk/Method;", "method", "Lpb/T0;", "serializationConstructorMarker", "(ILio/modelcontextprotocol/kotlin/sdk/RequestId;Ljava/lang/String;Lqb/D;Lio/modelcontextprotocol/kotlin/sdk/Method;Lpb/T0;)V", "self", "Lob/d;", "output", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialDesc", "LY8/t;", "write$Self$kotlin_sdk", "(Lio/modelcontextprotocol/kotlin/sdk/CancelledNotification;Lob/d;Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "write$Self", "component1", "()Lio/modelcontextprotocol/kotlin/sdk/RequestId;", "component2", "()Ljava/lang/String;", "component3", "()Lqb/D;", ChatTracker.CLICK_COPY, "(Lio/modelcontextprotocol/kotlin/sdk/RequestId;Ljava/lang/String;Lqb/D;)Lio/modelcontextprotocol/kotlin/sdk/CancelledNotification;", "toString", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lio/modelcontextprotocol/kotlin/sdk/RequestId;", "getRequestId", "Ljava/lang/String;", "getReason", "Lqb/D;", "get_meta", "Lio/modelcontextprotocol/kotlin/sdk/Method;", "getMethod", "()Lio/modelcontextprotocol/kotlin/sdk/Method;", "Companion", "$serializer", "kotlin-sdk"}, k = 1, mv = {2, 2, 0}, xi = 48)
@lb.l
/* loaded from: classes4.dex */
public final /* data */ class CancelledNotification implements ClientNotification, ServerNotification, WithMeta {
    private final qb.D _meta;
    private final Method method;
    private final String reason;
    private final RequestId requestId;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Y8.h<KSerializer<Object>>[] $childSerializers = {C4848b.a(LazyThreadSafetyMode.PUBLICATION, new InterfaceC5063a() { // from class: io.modelcontextprotocol.kotlin.sdk.b
        @Override // p9.InterfaceC5063a
        public final Object invoke() {
            return CancelledNotification._childSerializers$_anonymous_();
        }
    }), null, null, null};

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lio/modelcontextprotocol/kotlin/sdk/CancelledNotification$Companion;", "", "<init>", "()V", "Lkotlinx/serialization/KSerializer;", "Lio/modelcontextprotocol/kotlin/sdk/CancelledNotification;", "serializer", "()Lkotlinx/serialization/KSerializer;", "kotlin-sdk"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public final KSerializer<CancelledNotification> serializer() {
            return CancelledNotification$$serializer.INSTANCE;
        }

        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }
    }

    public /* synthetic */ CancelledNotification(int i10, RequestId requestId, String str, qb.D d10, Method method, T0 t02) {
        if (3 != (i10 & 3)) {
            E0.a(i10, 3, CancelledNotification$$serializer.INSTANCE.getDescriptor());
        }
        this.requestId = requestId;
        this.reason = str;
        if ((i10 & 4) == 0) {
            this._meta = Types_utilKt.getEmptyJsonObject();
        } else {
            this._meta = d10;
        }
        if ((i10 & 8) == 0) {
            this.method = Method.Defined.NotificationsCancelled;
        } else {
            this.method = method;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_() {
        return new RequestIdSerializer();
    }

    public static /* synthetic */ CancelledNotification copy$default(CancelledNotification cancelledNotification, RequestId requestId, String str, qb.D d10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            requestId = cancelledNotification.requestId;
        }
        if ((i10 & 2) != 0) {
            str = cancelledNotification.reason;
        }
        if ((i10 & 4) != 0) {
            d10 = cancelledNotification._meta;
        }
        return cancelledNotification.copy(requestId, str, d10);
    }

    public static final /* synthetic */ void write$Self$kotlin_sdk(CancelledNotification self, ob.d output, SerialDescriptor serialDesc) {
        output.x(serialDesc, 0, $childSerializers[0].getValue(), self.requestId);
        output.k(serialDesc, 1, Y0.f38329a, self.reason);
        if (output.y(serialDesc, 2) || !kotlin.jvm.internal.p.d(self.get_meta(), Types_utilKt.getEmptyJsonObject())) {
            output.x(serialDesc, 2, qb.E.f38623a, self.get_meta());
        }
        if (!output.y(serialDesc, 3) && self.getMethod() == Method.Defined.NotificationsCancelled) {
            return;
        }
        output.x(serialDesc, 3, RequestMethodSerializer.INSTANCE, self.getMethod());
    }

    /* renamed from: component1, reason: from getter */
    public final RequestId getRequestId() {
        return this.requestId;
    }

    /* renamed from: component2, reason: from getter */
    public final String getReason() {
        return this.reason;
    }

    /* renamed from: component3, reason: from getter */
    public final qb.D get_meta() {
        return this._meta;
    }

    public final CancelledNotification copy(RequestId requestId, String reason, qb.D _meta) {
        kotlin.jvm.internal.p.i(requestId, "requestId");
        kotlin.jvm.internal.p.i(_meta, "_meta");
        return new CancelledNotification(requestId, reason, _meta);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CancelledNotification)) {
            return false;
        }
        CancelledNotification cancelledNotification = (CancelledNotification) other;
        return kotlin.jvm.internal.p.d(this.requestId, cancelledNotification.requestId) && kotlin.jvm.internal.p.d(this.reason, cancelledNotification.reason) && kotlin.jvm.internal.p.d(this._meta, cancelledNotification._meta);
    }

    @Override // io.modelcontextprotocol.kotlin.sdk.Notification
    public Method getMethod() {
        return this.method;
    }

    public final String getReason() {
        return this.reason;
    }

    public final RequestId getRequestId() {
        return this.requestId;
    }

    @Override // io.modelcontextprotocol.kotlin.sdk.WithMeta
    public qb.D get_meta() {
        return this._meta;
    }

    public int hashCode() {
        int iHashCode = this.requestId.hashCode() * 31;
        String str = this.reason;
        return ((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + this._meta.hashCode();
    }

    public String toString() {
        return "CancelledNotification(requestId=" + this.requestId + ", reason=" + this.reason + ", _meta=" + this._meta + ')';
    }

    public CancelledNotification(RequestId requestId, String str, qb.D _meta) {
        kotlin.jvm.internal.p.i(requestId, "requestId");
        kotlin.jvm.internal.p.i(_meta, "_meta");
        this.requestId = requestId;
        this.reason = str;
        this._meta = _meta;
        this.method = Method.Defined.NotificationsCancelled;
    }

    public /* synthetic */ CancelledNotification(RequestId requestId, String str, qb.D d10, int i10, kotlin.jvm.internal.i iVar) {
        this(requestId, str, (i10 & 4) != 0 ? Types_utilKt.getEmptyJsonObject() : d10);
    }
}
