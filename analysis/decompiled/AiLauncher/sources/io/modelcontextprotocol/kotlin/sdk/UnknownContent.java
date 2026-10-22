package io.modelcontextprotocol.kotlin.sdk;

import com.stepos.ailauncher.chat.trace.ChatTracker;
import kotlin.Metadata;
import kotlinx.serialization.KSerializer;
import pb.E0;
import pb.T0;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0087\b\u0018\u0000 \"2\u00020\u0001:\u0002#\"B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005B%\b\u0010\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u0004\u0010\nJ'\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0014\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0014\u0010\u0015J\u001a\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0018\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0015J\u0010\u0010\u0019\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0019\u0010\u001aJ\u001a\u0010\u001e\u001a\u00020\u001d2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bHÖ\u0003¢\u0006\u0004\b\u001e\u0010\u001fR\u001a\u0010\u0003\u001a\u00020\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0003\u0010 \u001a\u0004\b!\u0010\u0015¨\u0006$"}, d2 = {"Lio/modelcontextprotocol/kotlin/sdk/UnknownContent;", "Lio/modelcontextprotocol/kotlin/sdk/PromptMessageContentMultimodal;", "", "type", "<init>", "(Ljava/lang/String;)V", "", "seen0", "Lpb/T0;", "serializationConstructorMarker", "(ILjava/lang/String;Lpb/T0;)V", "self", "Lob/d;", "output", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialDesc", "LY8/t;", "write$Self$kotlin_sdk", "(Lio/modelcontextprotocol/kotlin/sdk/UnknownContent;Lob/d;Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "write$Self", "component1", "()Ljava/lang/String;", ChatTracker.CLICK_COPY, "(Ljava/lang/String;)Lio/modelcontextprotocol/kotlin/sdk/UnknownContent;", "toString", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getType", "Companion", "$serializer", "kotlin-sdk"}, k = 1, mv = {2, 2, 0}, xi = 48)
@lb.l
/* loaded from: classes4.dex */
public final /* data */ class UnknownContent implements PromptMessageContentMultimodal {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String type;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lio/modelcontextprotocol/kotlin/sdk/UnknownContent$Companion;", "", "<init>", "()V", "Lkotlinx/serialization/KSerializer;", "Lio/modelcontextprotocol/kotlin/sdk/UnknownContent;", "serializer", "()Lkotlinx/serialization/KSerializer;", "kotlin-sdk"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public final KSerializer<UnknownContent> serializer() {
            return UnknownContent$$serializer.INSTANCE;
        }

        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }
    }

    public /* synthetic */ UnknownContent(int i10, String str, T0 t02) {
        if (1 != (i10 & 1)) {
            E0.a(i10, 1, UnknownContent$$serializer.INSTANCE.getDescriptor());
        }
        this.type = str;
    }

    public static /* synthetic */ UnknownContent copy$default(UnknownContent unknownContent, String str, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = unknownContent.type;
        }
        return unknownContent.copy(str);
    }

    /* renamed from: component1, reason: from getter */
    public final String getType() {
        return this.type;
    }

    public final UnknownContent copy(String type) {
        kotlin.jvm.internal.p.i(type, "type");
        return new UnknownContent(type);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof UnknownContent) && kotlin.jvm.internal.p.d(this.type, ((UnknownContent) other).type);
    }

    @Override // io.modelcontextprotocol.kotlin.sdk.PromptMessageContent
    public String getType() {
        return this.type;
    }

    public int hashCode() {
        return this.type.hashCode();
    }

    public String toString() {
        return "UnknownContent(type=" + this.type + ')';
    }

    public UnknownContent(String type) {
        kotlin.jvm.internal.p.i(type, "type");
        this.type = type;
    }
}
