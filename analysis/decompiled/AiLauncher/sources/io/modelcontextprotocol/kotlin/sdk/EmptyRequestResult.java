package io.modelcontextprotocol.kotlin.sdk;

import com.stepos.ailauncher.chat.trace.ChatTracker;
import kotlin.Metadata;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import pb.T0;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0087\b\u0018\u0000 %2\u00020\u00012\u00020\u0002:\u0002&%B\u0011\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006B%\b\u0010\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u0005\u0010\u000bJ'\u0010\u0014\u001a\u00020\u00112\u0006\u0010\f\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fH\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0015\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b\u0015\u0010\u0016J\u001a\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u001a\u001a\u00020\u0019HÖ\u0001¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u001c\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\u001c\u0010\u001dJ\u001a\u0010!\u001a\u00020 2\b\u0010\u001f\u001a\u0004\u0018\u00010\u001eHÖ\u0003¢\u0006\u0004\b!\u0010\"R\u001a\u0010\u0004\u001a\u00020\u00038\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0004\u0010#\u001a\u0004\b$\u0010\u0016¨\u0006'"}, d2 = {"Lio/modelcontextprotocol/kotlin/sdk/EmptyRequestResult;", "Lio/modelcontextprotocol/kotlin/sdk/ServerResult;", "Lio/modelcontextprotocol/kotlin/sdk/ClientResult;", "Lqb/D;", "_meta", "<init>", "(Lqb/D;)V", "", "seen0", "Lpb/T0;", "serializationConstructorMarker", "(ILqb/D;Lpb/T0;)V", "self", "Lob/d;", "output", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialDesc", "LY8/t;", "write$Self$kotlin_sdk", "(Lio/modelcontextprotocol/kotlin/sdk/EmptyRequestResult;Lob/d;Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "write$Self", "component1", "()Lqb/D;", ChatTracker.CLICK_COPY, "(Lqb/D;)Lio/modelcontextprotocol/kotlin/sdk/EmptyRequestResult;", "", "toString", "()Ljava/lang/String;", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lqb/D;", "get_meta", "Companion", "$serializer", "kotlin-sdk"}, k = 1, mv = {2, 2, 0}, xi = 48)
@lb.l
/* loaded from: classes4.dex */
public final /* data */ class EmptyRequestResult implements ServerResult, ClientResult {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final qb.D _meta;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lio/modelcontextprotocol/kotlin/sdk/EmptyRequestResult$Companion;", "", "<init>", "()V", "Lkotlinx/serialization/KSerializer;", "Lio/modelcontextprotocol/kotlin/sdk/EmptyRequestResult;", "serializer", "()Lkotlinx/serialization/KSerializer;", "kotlin-sdk"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public final KSerializer<EmptyRequestResult> serializer() {
            return EmptyRequestResult$$serializer.INSTANCE;
        }

        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public EmptyRequestResult() {
        this((qb.D) null, 1, (kotlin.jvm.internal.i) (0 == true ? 1 : 0));
    }

    public static /* synthetic */ EmptyRequestResult copy$default(EmptyRequestResult emptyRequestResult, qb.D d10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            d10 = emptyRequestResult._meta;
        }
        return emptyRequestResult.copy(d10);
    }

    public static final /* synthetic */ void write$Self$kotlin_sdk(EmptyRequestResult self, ob.d output, SerialDescriptor serialDesc) {
        if (!output.y(serialDesc, 0) && kotlin.jvm.internal.p.d(self.get_meta(), Types_utilKt.getEmptyJsonObject())) {
            return;
        }
        output.x(serialDesc, 0, qb.E.f38623a, self.get_meta());
    }

    /* renamed from: component1, reason: from getter */
    public final qb.D get_meta() {
        return this._meta;
    }

    public final EmptyRequestResult copy(qb.D _meta) {
        kotlin.jvm.internal.p.i(_meta, "_meta");
        return new EmptyRequestResult(_meta);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof EmptyRequestResult) && kotlin.jvm.internal.p.d(this._meta, ((EmptyRequestResult) other)._meta);
    }

    @Override // io.modelcontextprotocol.kotlin.sdk.WithMeta
    public qb.D get_meta() {
        return this._meta;
    }

    public int hashCode() {
        return this._meta.hashCode();
    }

    public String toString() {
        return "EmptyRequestResult(_meta=" + this._meta + ')';
    }

    public /* synthetic */ EmptyRequestResult(int i10, qb.D d10, T0 t02) {
        if ((i10 & 1) == 0) {
            this._meta = Types_utilKt.getEmptyJsonObject();
        } else {
            this._meta = d10;
        }
    }

    public EmptyRequestResult(qb.D _meta) {
        kotlin.jvm.internal.p.i(_meta, "_meta");
        this._meta = _meta;
    }

    public /* synthetic */ EmptyRequestResult(qb.D d10, int i10, kotlin.jvm.internal.i iVar) {
        this((i10 & 1) != 0 ? Types_utilKt.getEmptyJsonObject() : d10);
    }
}
