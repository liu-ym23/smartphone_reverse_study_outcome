package io.modelcontextprotocol.kotlin.sdk;

import com.stepos.ailauncher.chat.trace.ChatTracker;
import io.modelcontextprotocol.kotlin.sdk.Method;
import kotlin.C4848b;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import p9.InterfaceC5063a;
import pb.C5083B;
import pb.E0;
import pb.T0;
import pb.Y0;

@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0012\b\u0087\b\u0018\u0000 @2\u00020\u00012\u00020\u00022\u00020\u0003:\u0002A@B9\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\n\u0010\b\u001a\u00060\u0006j\u0002`\u0007\u0012\b\b\u0002\u0010\n\u001a\u00020\t\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\u000f\u0010\u0010BU\b\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\n\u001a\u0004\u0018\u00010\t\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\r\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014¢\u0006\u0004\b\u000f\u0010\u0016J'\u0010\u001f\u001a\u00020\u001c2\u0006\u0010\u0017\u001a\u00020\u00002\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u001aH\u0001¢\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010 \u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b \u0010!J\u0014\u0010\"\u001a\u00060\u0006j\u0002`\u0007HÆ\u0003¢\u0006\u0004\b\"\u0010#J\u0010\u0010$\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b$\u0010%J\u0012\u0010&\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0004\b&\u0010'J\u0012\u0010(\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0004\b(\u0010)JJ\u0010*\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u00042\f\b\u0002\u0010\b\u001a\u00060\u0006j\u0002`\u00072\b\b\u0002\u0010\n\u001a\u00020\t2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\rHÆ\u0001¢\u0006\u0004\b*\u0010+J\u0010\u0010,\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b,\u0010)J\u0010\u0010-\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b-\u0010!J\u001a\u00101\u001a\u0002002\b\u0010/\u001a\u0004\u0018\u00010.HÖ\u0003¢\u0006\u0004\b1\u00102R\u001a\u0010\u0005\u001a\u00020\u00048\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0005\u00103\u001a\u0004\b4\u0010!R\u001b\u0010\b\u001a\u00060\u0006j\u0002`\u00078\u0006¢\u0006\f\n\u0004\b\b\u00105\u001a\u0004\b6\u0010#R\u0017\u0010\n\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\n\u00107\u001a\u0004\b8\u0010%R\u001c\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\f\u00109\u001a\u0004\b:\u0010'R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u000e\u0010;\u001a\u0004\b<\u0010)R\u001a\u0010\u0013\u001a\u00020\u00128\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0013\u0010=\u001a\u0004\b>\u0010?¨\u0006B"}, d2 = {"Lio/modelcontextprotocol/kotlin/sdk/ProgressNotification;", "Lio/modelcontextprotocol/kotlin/sdk/ClientNotification;", "Lio/modelcontextprotocol/kotlin/sdk/ServerNotification;", "Lio/modelcontextprotocol/kotlin/sdk/ProgressBase;", "", "progress", "Lio/modelcontextprotocol/kotlin/sdk/RequestId;", "Lio/modelcontextprotocol/kotlin/sdk/ProgressToken;", "progressToken", "Lqb/D;", "_meta", "", "total", "", "message", "<init>", "(ILio/modelcontextprotocol/kotlin/sdk/RequestId;Lqb/D;Ljava/lang/Double;Ljava/lang/String;)V", "seen0", "Lio/modelcontextprotocol/kotlin/sdk/Method;", "method", "Lpb/T0;", "serializationConstructorMarker", "(IILio/modelcontextprotocol/kotlin/sdk/RequestId;Lqb/D;Ljava/lang/Double;Ljava/lang/String;Lio/modelcontextprotocol/kotlin/sdk/Method;Lpb/T0;)V", "self", "Lob/d;", "output", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialDesc", "LY8/t;", "write$Self$kotlin_sdk", "(Lio/modelcontextprotocol/kotlin/sdk/ProgressNotification;Lob/d;Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "write$Self", "component1", "()I", "component2", "()Lio/modelcontextprotocol/kotlin/sdk/RequestId;", "component3", "()Lqb/D;", "component4", "()Ljava/lang/Double;", "component5", "()Ljava/lang/String;", ChatTracker.CLICK_COPY, "(ILio/modelcontextprotocol/kotlin/sdk/RequestId;Lqb/D;Ljava/lang/Double;Ljava/lang/String;)Lio/modelcontextprotocol/kotlin/sdk/ProgressNotification;", "toString", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "I", "getProgress", "Lio/modelcontextprotocol/kotlin/sdk/RequestId;", "getProgressToken", "Lqb/D;", "get_meta", "Ljava/lang/Double;", "getTotal", "Ljava/lang/String;", "getMessage", "Lio/modelcontextprotocol/kotlin/sdk/Method;", "getMethod", "()Lio/modelcontextprotocol/kotlin/sdk/Method;", "Companion", "$serializer", "kotlin-sdk"}, k = 1, mv = {2, 2, 0}, xi = 48)
@lb.l
/* loaded from: classes4.dex */
public final /* data */ class ProgressNotification implements ClientNotification, ServerNotification, ProgressBase {
    private final qb.D _meta;
    private final String message;
    private final Method method;
    private final int progress;
    private final RequestId progressToken;
    private final Double total;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Y8.h<KSerializer<Object>>[] $childSerializers = {null, C4848b.a(LazyThreadSafetyMode.PUBLICATION, new InterfaceC5063a() { // from class: io.modelcontextprotocol.kotlin.sdk.B
        @Override // p9.InterfaceC5063a
        public final Object invoke() {
            return ProgressNotification._childSerializers$_anonymous_();
        }
    }), null, null, null, null};

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lio/modelcontextprotocol/kotlin/sdk/ProgressNotification$Companion;", "", "<init>", "()V", "Lkotlinx/serialization/KSerializer;", "Lio/modelcontextprotocol/kotlin/sdk/ProgressNotification;", "serializer", "()Lkotlinx/serialization/KSerializer;", "kotlin-sdk"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public final KSerializer<ProgressNotification> serializer() {
            return ProgressNotification$$serializer.INSTANCE;
        }

        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }
    }

    public /* synthetic */ ProgressNotification(int i10, int i11, RequestId requestId, qb.D d10, Double d11, String str, Method method, T0 t02) {
        if (27 != (i10 & 27)) {
            E0.a(i10, 27, ProgressNotification$$serializer.INSTANCE.getDescriptor());
        }
        this.progress = i11;
        this.progressToken = requestId;
        if ((i10 & 4) == 0) {
            this._meta = Types_utilKt.getEmptyJsonObject();
        } else {
            this._meta = d10;
        }
        this.total = d11;
        this.message = str;
        if ((i10 & 32) == 0) {
            this.method = Method.Defined.NotificationsProgress;
        } else {
            this.method = method;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_() {
        return new RequestIdSerializer();
    }

    public static /* synthetic */ ProgressNotification copy$default(ProgressNotification progressNotification, int i10, RequestId requestId, qb.D d10, Double d11, String str, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i10 = progressNotification.progress;
        }
        if ((i11 & 2) != 0) {
            requestId = progressNotification.progressToken;
        }
        if ((i11 & 4) != 0) {
            d10 = progressNotification._meta;
        }
        if ((i11 & 8) != 0) {
            d11 = progressNotification.total;
        }
        if ((i11 & 16) != 0) {
            str = progressNotification.message;
        }
        String str2 = str;
        qb.D d12 = d10;
        return progressNotification.copy(i10, requestId, d12, d11, str2);
    }

    public static final /* synthetic */ void write$Self$kotlin_sdk(ProgressNotification self, ob.d output, SerialDescriptor serialDesc) {
        Y8.h<KSerializer<Object>>[] hVarArr = $childSerializers;
        output.t(serialDesc, 0, self.getProgress());
        output.x(serialDesc, 1, hVarArr[1].getValue(), self.progressToken);
        if (output.y(serialDesc, 2) || !kotlin.jvm.internal.p.d(self._meta, Types_utilKt.getEmptyJsonObject())) {
            output.x(serialDesc, 2, qb.E.f38623a, self._meta);
        }
        output.k(serialDesc, 3, C5083B.f38260a, self.getTotal());
        output.k(serialDesc, 4, Y0.f38329a, self.getMessage());
        if (!output.y(serialDesc, 5) && self.getMethod() == Method.Defined.NotificationsProgress) {
            return;
        }
        output.x(serialDesc, 5, RequestMethodSerializer.INSTANCE, self.getMethod());
    }

    /* renamed from: component1, reason: from getter */
    public final int getProgress() {
        return this.progress;
    }

    /* renamed from: component2, reason: from getter */
    public final RequestId getProgressToken() {
        return this.progressToken;
    }

    /* renamed from: component3, reason: from getter */
    public final qb.D get_meta() {
        return this._meta;
    }

    /* renamed from: component4, reason: from getter */
    public final Double getTotal() {
        return this.total;
    }

    /* renamed from: component5, reason: from getter */
    public final String getMessage() {
        return this.message;
    }

    public final ProgressNotification copy(int progress, RequestId progressToken, qb.D _meta, Double total, String message) {
        kotlin.jvm.internal.p.i(progressToken, "progressToken");
        kotlin.jvm.internal.p.i(_meta, "_meta");
        return new ProgressNotification(progress, progressToken, _meta, total, message);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ProgressNotification)) {
            return false;
        }
        ProgressNotification progressNotification = (ProgressNotification) other;
        return this.progress == progressNotification.progress && kotlin.jvm.internal.p.d(this.progressToken, progressNotification.progressToken) && kotlin.jvm.internal.p.d(this._meta, progressNotification._meta) && kotlin.jvm.internal.p.d(this.total, progressNotification.total) && kotlin.jvm.internal.p.d(this.message, progressNotification.message);
    }

    @Override // io.modelcontextprotocol.kotlin.sdk.ProgressBase
    public String getMessage() {
        return this.message;
    }

    @Override // io.modelcontextprotocol.kotlin.sdk.Notification
    public Method getMethod() {
        return this.method;
    }

    @Override // io.modelcontextprotocol.kotlin.sdk.ProgressBase
    public int getProgress() {
        return this.progress;
    }

    public final RequestId getProgressToken() {
        return this.progressToken;
    }

    @Override // io.modelcontextprotocol.kotlin.sdk.ProgressBase
    public Double getTotal() {
        return this.total;
    }

    public final qb.D get_meta() {
        return this._meta;
    }

    public int hashCode() {
        int iHashCode = ((((Integer.hashCode(this.progress) * 31) + this.progressToken.hashCode()) * 31) + this._meta.hashCode()) * 31;
        Double d10 = this.total;
        int iHashCode2 = (iHashCode + (d10 == null ? 0 : d10.hashCode())) * 31;
        String str = this.message;
        return iHashCode2 + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        return "ProgressNotification(progress=" + this.progress + ", progressToken=" + this.progressToken + ", _meta=" + this._meta + ", total=" + this.total + ", message=" + this.message + ')';
    }

    public ProgressNotification(int i10, RequestId progressToken, qb.D _meta, Double d10, String str) {
        kotlin.jvm.internal.p.i(progressToken, "progressToken");
        kotlin.jvm.internal.p.i(_meta, "_meta");
        this.progress = i10;
        this.progressToken = progressToken;
        this._meta = _meta;
        this.total = d10;
        this.message = str;
        this.method = Method.Defined.NotificationsProgress;
    }

    public /* synthetic */ ProgressNotification(int i10, RequestId requestId, qb.D d10, Double d11, String str, int i11, kotlin.jvm.internal.i iVar) {
        this(i10, requestId, (i11 & 4) != 0 ? Types_utilKt.getEmptyJsonObject() : d10, d11, str);
    }
}
