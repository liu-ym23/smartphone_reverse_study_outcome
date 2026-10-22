package io.modelcontextprotocol.kotlin.sdk;

import com.stepos.ailauncher.chat.trace.ChatTracker;
import kotlin.Metadata;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import pb.E0;
import pb.T0;
import pb.Y0;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\b\u0087\b\u0018\u0000 (2\u00020\u0001:\u0002)(B!\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0006\u0010\u0007B9\b\u0010\u0012\u0006\u0010\t\u001a\u00020\b\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u0006\u0010\fJ'\u0010\u0015\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0010H\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0016\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0018\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0018\u0010\u0017J\u0012\u0010\u0019\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0019\u0010\u0017J0\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u001c\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u001c\u0010\u0017J\u0010\u0010\u001d\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\u001d\u0010\u001eJ\u001a\u0010\"\u001a\u00020!2\b\u0010 \u001a\u0004\u0018\u00010\u001fHÖ\u0003¢\u0006\u0004\b\"\u0010#R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010$\u001a\u0004\b%\u0010\u0017R\u001a\u0010\u0004\u001a\u00020\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0004\u0010$\u001a\u0004\b&\u0010\u0017R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0005\u0010$\u001a\u0004\b'\u0010\u0017¨\u0006*"}, d2 = {"Lio/modelcontextprotocol/kotlin/sdk/TextResourceContents;", "Lio/modelcontextprotocol/kotlin/sdk/ResourceContents;", "", "text", "uri", "mimeType", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "", "seen0", "Lpb/T0;", "serializationConstructorMarker", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lpb/T0;)V", "self", "Lob/d;", "output", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialDesc", "LY8/t;", "write$Self$kotlin_sdk", "(Lio/modelcontextprotocol/kotlin/sdk/TextResourceContents;Lob/d;Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "write$Self", "component1", "()Ljava/lang/String;", "component2", "component3", ChatTracker.CLICK_COPY, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lio/modelcontextprotocol/kotlin/sdk/TextResourceContents;", "toString", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getText", "getUri", "getMimeType", "Companion", "$serializer", "kotlin-sdk"}, k = 1, mv = {2, 2, 0}, xi = 48)
@lb.l
/* loaded from: classes4.dex */
public final /* data */ class TextResourceContents implements ResourceContents {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String mimeType;
    private final String text;
    private final String uri;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lio/modelcontextprotocol/kotlin/sdk/TextResourceContents$Companion;", "", "<init>", "()V", "Lkotlinx/serialization/KSerializer;", "Lio/modelcontextprotocol/kotlin/sdk/TextResourceContents;", "serializer", "()Lkotlinx/serialization/KSerializer;", "kotlin-sdk"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public final KSerializer<TextResourceContents> serializer() {
            return TextResourceContents$$serializer.INSTANCE;
        }

        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }
    }

    public /* synthetic */ TextResourceContents(int i10, String str, String str2, String str3, T0 t02) {
        if (7 != (i10 & 7)) {
            E0.a(i10, 7, TextResourceContents$$serializer.INSTANCE.getDescriptor());
        }
        this.text = str;
        this.uri = str2;
        this.mimeType = str3;
    }

    public static /* synthetic */ TextResourceContents copy$default(TextResourceContents textResourceContents, String str, String str2, String str3, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = textResourceContents.text;
        }
        if ((i10 & 2) != 0) {
            str2 = textResourceContents.uri;
        }
        if ((i10 & 4) != 0) {
            str3 = textResourceContents.mimeType;
        }
        return textResourceContents.copy(str, str2, str3);
    }

    public static final /* synthetic */ void write$Self$kotlin_sdk(TextResourceContents self, ob.d output, SerialDescriptor serialDesc) {
        output.w(serialDesc, 0, self.text);
        output.w(serialDesc, 1, self.getUri());
        output.k(serialDesc, 2, Y0.f38329a, self.getMimeType());
    }

    /* renamed from: component1, reason: from getter */
    public final String getText() {
        return this.text;
    }

    /* renamed from: component2, reason: from getter */
    public final String getUri() {
        return this.uri;
    }

    /* renamed from: component3, reason: from getter */
    public final String getMimeType() {
        return this.mimeType;
    }

    public final TextResourceContents copy(String text, String uri, String mimeType) {
        kotlin.jvm.internal.p.i(text, "text");
        kotlin.jvm.internal.p.i(uri, "uri");
        return new TextResourceContents(text, uri, mimeType);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TextResourceContents)) {
            return false;
        }
        TextResourceContents textResourceContents = (TextResourceContents) other;
        return kotlin.jvm.internal.p.d(this.text, textResourceContents.text) && kotlin.jvm.internal.p.d(this.uri, textResourceContents.uri) && kotlin.jvm.internal.p.d(this.mimeType, textResourceContents.mimeType);
    }

    @Override // io.modelcontextprotocol.kotlin.sdk.ResourceContents
    public String getMimeType() {
        return this.mimeType;
    }

    public final String getText() {
        return this.text;
    }

    @Override // io.modelcontextprotocol.kotlin.sdk.ResourceContents
    public String getUri() {
        return this.uri;
    }

    public int hashCode() {
        int iHashCode = ((this.text.hashCode() * 31) + this.uri.hashCode()) * 31;
        String str = this.mimeType;
        return iHashCode + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return "TextResourceContents(text=" + this.text + ", uri=" + this.uri + ", mimeType=" + this.mimeType + ')';
    }

    public TextResourceContents(String text, String uri, String str) {
        kotlin.jvm.internal.p.i(text, "text");
        kotlin.jvm.internal.p.i(uri, "uri");
        this.text = text;
        this.uri = uri;
        this.mimeType = str;
    }
}
