package io.modelcontextprotocol.kotlin.sdk;

import com.stepos.ailauncher.chat.trace.ChatTracker;
import kotlin.Metadata;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import pb.E0;
import pb.T0;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0087\b\u0018\u0000 .2\u00020\u0001:\u0002/.B!\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tB9\b\u0010\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\r\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\b\u0010\u000eJ'\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u000f\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0012H\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0018\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u001a\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u001c\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u001c\u0010\u001dJ.\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u0006HÆ\u0001¢\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010 \u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b \u0010\u001bJ\u0010\u0010!\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b!\u0010\"J\u001a\u0010&\u001a\u00020%2\b\u0010$\u001a\u0004\u0018\u00010#HÖ\u0003¢\u0006\u0004\b&\u0010'R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010(\u001a\u0004\b)\u0010\u0019R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010*\u001a\u0004\b+\u0010\u001bR\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010,\u001a\u0004\b-\u0010\u001d¨\u00060"}, d2 = {"Lio/modelcontextprotocol/kotlin/sdk/JSONRPCError;", "Lio/modelcontextprotocol/kotlin/sdk/JSONRPCMessage;", "Lio/modelcontextprotocol/kotlin/sdk/ErrorCode;", "code", "", "message", "Lqb/D;", "data", "<init>", "(Lio/modelcontextprotocol/kotlin/sdk/ErrorCode;Ljava/lang/String;Lqb/D;)V", "", "seen0", "Lpb/T0;", "serializationConstructorMarker", "(ILio/modelcontextprotocol/kotlin/sdk/ErrorCode;Ljava/lang/String;Lqb/D;Lpb/T0;)V", "self", "Lob/d;", "output", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialDesc", "LY8/t;", "write$Self$kotlin_sdk", "(Lio/modelcontextprotocol/kotlin/sdk/JSONRPCError;Lob/d;Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "write$Self", "component1", "()Lio/modelcontextprotocol/kotlin/sdk/ErrorCode;", "component2", "()Ljava/lang/String;", "component3", "()Lqb/D;", ChatTracker.CLICK_COPY, "(Lio/modelcontextprotocol/kotlin/sdk/ErrorCode;Ljava/lang/String;Lqb/D;)Lio/modelcontextprotocol/kotlin/sdk/JSONRPCError;", "toString", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lio/modelcontextprotocol/kotlin/sdk/ErrorCode;", "getCode", "Ljava/lang/String;", "getMessage", "Lqb/D;", "getData", "Companion", "$serializer", "kotlin-sdk"}, k = 1, mv = {2, 2, 0}, xi = 48)
@lb.l
/* loaded from: classes4.dex */
public final /* data */ class JSONRPCError implements JSONRPCMessage {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final ErrorCode code;
    private final qb.D data;
    private final String message;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lio/modelcontextprotocol/kotlin/sdk/JSONRPCError$Companion;", "", "<init>", "()V", "Lkotlinx/serialization/KSerializer;", "Lio/modelcontextprotocol/kotlin/sdk/JSONRPCError;", "serializer", "()Lkotlinx/serialization/KSerializer;", "kotlin-sdk"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public final KSerializer<JSONRPCError> serializer() {
            return JSONRPCError$$serializer.INSTANCE;
        }

        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }
    }

    public /* synthetic */ JSONRPCError(int i10, ErrorCode errorCode, String str, qb.D d10, T0 t02) {
        if (3 != (i10 & 3)) {
            E0.a(i10, 3, JSONRPCError$$serializer.INSTANCE.getDescriptor());
        }
        this.code = errorCode;
        this.message = str;
        if ((i10 & 4) == 0) {
            this.data = Types_utilKt.getEmptyJsonObject();
        } else {
            this.data = d10;
        }
    }

    public static /* synthetic */ JSONRPCError copy$default(JSONRPCError jSONRPCError, ErrorCode errorCode, String str, qb.D d10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            errorCode = jSONRPCError.code;
        }
        if ((i10 & 2) != 0) {
            str = jSONRPCError.message;
        }
        if ((i10 & 4) != 0) {
            d10 = jSONRPCError.data;
        }
        return jSONRPCError.copy(errorCode, str, d10);
    }

    public static final /* synthetic */ void write$Self$kotlin_sdk(JSONRPCError self, ob.d output, SerialDescriptor serialDesc) {
        output.x(serialDesc, 0, ErrorCodeSerializer.INSTANCE, self.code);
        output.w(serialDesc, 1, self.message);
        if (!output.y(serialDesc, 2) && kotlin.jvm.internal.p.d(self.data, Types_utilKt.getEmptyJsonObject())) {
            return;
        }
        output.x(serialDesc, 2, qb.E.f38623a, self.data);
    }

    /* renamed from: component1, reason: from getter */
    public final ErrorCode getCode() {
        return this.code;
    }

    /* renamed from: component2, reason: from getter */
    public final String getMessage() {
        return this.message;
    }

    /* renamed from: component3, reason: from getter */
    public final qb.D getData() {
        return this.data;
    }

    public final JSONRPCError copy(ErrorCode code, String message, qb.D data) {
        kotlin.jvm.internal.p.i(code, "code");
        kotlin.jvm.internal.p.i(message, "message");
        kotlin.jvm.internal.p.i(data, "data");
        return new JSONRPCError(code, message, data);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof JSONRPCError)) {
            return false;
        }
        JSONRPCError jSONRPCError = (JSONRPCError) other;
        return kotlin.jvm.internal.p.d(this.code, jSONRPCError.code) && kotlin.jvm.internal.p.d(this.message, jSONRPCError.message) && kotlin.jvm.internal.p.d(this.data, jSONRPCError.data);
    }

    public final ErrorCode getCode() {
        return this.code;
    }

    public final qb.D getData() {
        return this.data;
    }

    public final String getMessage() {
        return this.message;
    }

    public int hashCode() {
        return (((this.code.hashCode() * 31) + this.message.hashCode()) * 31) + this.data.hashCode();
    }

    public String toString() {
        return "JSONRPCError(code=" + this.code + ", message=" + this.message + ", data=" + this.data + ')';
    }

    public JSONRPCError(ErrorCode code, String message, qb.D data) {
        kotlin.jvm.internal.p.i(code, "code");
        kotlin.jvm.internal.p.i(message, "message");
        kotlin.jvm.internal.p.i(data, "data");
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public /* synthetic */ JSONRPCError(ErrorCode errorCode, String str, qb.D d10, int i10, kotlin.jvm.internal.i iVar) {
        this(errorCode, str, (i10 & 4) != 0 ? Types_utilKt.getEmptyJsonObject() : d10);
    }
}
