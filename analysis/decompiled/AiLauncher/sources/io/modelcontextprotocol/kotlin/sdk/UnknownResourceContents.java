package io.modelcontextprotocol.kotlin.sdk;

import com.stepos.ailauncher.chat.trace.ChatTracker;
import kotlin.Metadata;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import pb.E0;
import pb.T0;
import pb.Y0;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\b\u0087\b\u0018\u0000 %2\u00020\u0001:\u0002&%B\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0005\u0010\u0006B/\b\u0010\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u0005\u0010\u000bJ'\u0010\u0014\u001a\u00020\u00112\u0006\u0010\f\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fH\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0015\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0015\u0010\u0016J\u0012\u0010\u0017\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0017\u0010\u0016J&\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u001a\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u001a\u0010\u0016J\u0010\u0010\u001b\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\u001b\u0010\u001cJ\u001a\u0010 \u001a\u00020\u001f2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dHÖ\u0003¢\u0006\u0004\b \u0010!R\u001a\u0010\u0003\u001a\u00020\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0003\u0010\"\u001a\u0004\b#\u0010\u0016R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0004\u0010\"\u001a\u0004\b$\u0010\u0016¨\u0006'"}, d2 = {"Lio/modelcontextprotocol/kotlin/sdk/UnknownResourceContents;", "Lio/modelcontextprotocol/kotlin/sdk/ResourceContents;", "", "uri", "mimeType", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "", "seen0", "Lpb/T0;", "serializationConstructorMarker", "(ILjava/lang/String;Ljava/lang/String;Lpb/T0;)V", "self", "Lob/d;", "output", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialDesc", "LY8/t;", "write$Self$kotlin_sdk", "(Lio/modelcontextprotocol/kotlin/sdk/UnknownResourceContents;Lob/d;Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "write$Self", "component1", "()Ljava/lang/String;", "component2", ChatTracker.CLICK_COPY, "(Ljava/lang/String;Ljava/lang/String;)Lio/modelcontextprotocol/kotlin/sdk/UnknownResourceContents;", "toString", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getUri", "getMimeType", "Companion", "$serializer", "kotlin-sdk"}, k = 1, mv = {2, 2, 0}, xi = 48)
@lb.l
/* loaded from: classes4.dex */
public final /* data */ class UnknownResourceContents implements ResourceContents {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String mimeType;
    private final String uri;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lio/modelcontextprotocol/kotlin/sdk/UnknownResourceContents$Companion;", "", "<init>", "()V", "Lkotlinx/serialization/KSerializer;", "Lio/modelcontextprotocol/kotlin/sdk/UnknownResourceContents;", "serializer", "()Lkotlinx/serialization/KSerializer;", "kotlin-sdk"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public final KSerializer<UnknownResourceContents> serializer() {
            return UnknownResourceContents$$serializer.INSTANCE;
        }

        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }
    }

    public /* synthetic */ UnknownResourceContents(int i10, String str, String str2, T0 t02) {
        if (3 != (i10 & 3)) {
            E0.a(i10, 3, UnknownResourceContents$$serializer.INSTANCE.getDescriptor());
        }
        this.uri = str;
        this.mimeType = str2;
    }

    public static /* synthetic */ UnknownResourceContents copy$default(UnknownResourceContents unknownResourceContents, String str, String str2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = unknownResourceContents.uri;
        }
        if ((i10 & 2) != 0) {
            str2 = unknownResourceContents.mimeType;
        }
        return unknownResourceContents.copy(str, str2);
    }

    public static final /* synthetic */ void write$Self$kotlin_sdk(UnknownResourceContents self, ob.d output, SerialDescriptor serialDesc) {
        output.w(serialDesc, 0, self.getUri());
        output.k(serialDesc, 1, Y0.f38329a, self.getMimeType());
    }

    /* renamed from: component1, reason: from getter */
    public final String getUri() {
        return this.uri;
    }

    /* renamed from: component2, reason: from getter */
    public final String getMimeType() {
        return this.mimeType;
    }

    public final UnknownResourceContents copy(String uri, String mimeType) {
        kotlin.jvm.internal.p.i(uri, "uri");
        return new UnknownResourceContents(uri, mimeType);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof UnknownResourceContents)) {
            return false;
        }
        UnknownResourceContents unknownResourceContents = (UnknownResourceContents) other;
        return kotlin.jvm.internal.p.d(this.uri, unknownResourceContents.uri) && kotlin.jvm.internal.p.d(this.mimeType, unknownResourceContents.mimeType);
    }

    @Override // io.modelcontextprotocol.kotlin.sdk.ResourceContents
    public String getMimeType() {
        return this.mimeType;
    }

    @Override // io.modelcontextprotocol.kotlin.sdk.ResourceContents
    public String getUri() {
        return this.uri;
    }

    public int hashCode() {
        int iHashCode = this.uri.hashCode() * 31;
        String str = this.mimeType;
        return iHashCode + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return "UnknownResourceContents(uri=" + this.uri + ", mimeType=" + this.mimeType + ')';
    }

    public UnknownResourceContents(String uri, String str) {
        kotlin.jvm.internal.p.i(uri, "uri");
        this.uri = uri;
        this.mimeType = str;
    }
}
