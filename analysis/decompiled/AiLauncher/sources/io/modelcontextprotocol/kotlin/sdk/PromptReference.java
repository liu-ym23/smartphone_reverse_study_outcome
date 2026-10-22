package io.modelcontextprotocol.kotlin.sdk;

import com.stepos.ailauncher.chat.trace.ChatTracker;
import kotlin.Metadata;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import pb.E0;
import pb.T0;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\b\u0087\b\u0018\u0000 $2\u00020\u0001:\u0002$%B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005B/\b\u0010\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u0004\u0010\u000bJ'\u0010\u0014\u001a\u00020\u00112\u0006\u0010\f\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fH\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0015\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0015\u0010\u0016J\u001a\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0019\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0019\u0010\u0016J\u0010\u0010\u001a\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u001a\u0010\u001bJ\u001a\u0010\u001f\u001a\u00020\u001e2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cHÖ\u0003¢\u0006\u0004\b\u001f\u0010 R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010!\u001a\u0004\b\"\u0010\u0016R\u001a\u0010\b\u001a\u00020\u00028\u0016X\u0096D¢\u0006\f\n\u0004\b\b\u0010!\u001a\u0004\b#\u0010\u0016¨\u0006&"}, d2 = {"Lio/modelcontextprotocol/kotlin/sdk/PromptReference;", "Lio/modelcontextprotocol/kotlin/sdk/Reference;", "", "name", "<init>", "(Ljava/lang/String;)V", "", "seen0", "type", "Lpb/T0;", "serializationConstructorMarker", "(ILjava/lang/String;Ljava/lang/String;Lpb/T0;)V", "self", "Lob/d;", "output", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialDesc", "LY8/t;", "write$Self$kotlin_sdk", "(Lio/modelcontextprotocol/kotlin/sdk/PromptReference;Lob/d;Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "write$Self", "component1", "()Ljava/lang/String;", ChatTracker.CLICK_COPY, "(Ljava/lang/String;)Lio/modelcontextprotocol/kotlin/sdk/PromptReference;", "toString", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getName", "getType", "Companion", "$serializer", "kotlin-sdk"}, k = 1, mv = {2, 2, 0}, xi = 48)
@lb.l
/* loaded from: classes4.dex */
public final /* data */ class PromptReference implements Reference {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final String TYPE = "ref/prompt";
    private final String name;
    private final String type;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\t\u001a\u00020\b8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lio/modelcontextprotocol/kotlin/sdk/PromptReference$Companion;", "", "<init>", "()V", "Lkotlinx/serialization/KSerializer;", "Lio/modelcontextprotocol/kotlin/sdk/PromptReference;", "serializer", "()Lkotlinx/serialization/KSerializer;", "", "TYPE", "Ljava/lang/String;", "kotlin-sdk"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }

        public final KSerializer<PromptReference> serializer() {
            return PromptReference$$serializer.INSTANCE;
        }

        private Companion() {
        }
    }

    public /* synthetic */ PromptReference(int i10, String str, String str2, T0 t02) {
        if (1 != (i10 & 1)) {
            E0.a(i10, 1, PromptReference$$serializer.INSTANCE.getDescriptor());
        }
        this.name = str;
        if ((i10 & 2) == 0) {
            this.type = "ref/prompt";
        } else {
            this.type = str2;
        }
    }

    public static /* synthetic */ PromptReference copy$default(PromptReference promptReference, String str, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = promptReference.name;
        }
        return promptReference.copy(str);
    }

    public static final /* synthetic */ void write$Self$kotlin_sdk(PromptReference self, ob.d output, SerialDescriptor serialDesc) {
        output.w(serialDesc, 0, self.name);
        if (!output.y(serialDesc, 1) && kotlin.jvm.internal.p.d(self.getType(), "ref/prompt")) {
            return;
        }
        output.w(serialDesc, 1, self.getType());
    }

    /* renamed from: component1, reason: from getter */
    public final String getName() {
        return this.name;
    }

    public final PromptReference copy(String name) {
        kotlin.jvm.internal.p.i(name, "name");
        return new PromptReference(name);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof PromptReference) && kotlin.jvm.internal.p.d(this.name, ((PromptReference) other).name);
    }

    public final String getName() {
        return this.name;
    }

    @Override // io.modelcontextprotocol.kotlin.sdk.Reference
    public String getType() {
        return this.type;
    }

    public int hashCode() {
        return this.name.hashCode();
    }

    public String toString() {
        return "PromptReference(name=" + this.name + ')';
    }

    public PromptReference(String name) {
        kotlin.jvm.internal.p.i(name, "name");
        this.name = name;
        this.type = "ref/prompt";
    }
}
