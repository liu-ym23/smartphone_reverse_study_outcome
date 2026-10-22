package io.modelcontextprotocol.kotlin.sdk;

import com.stepos.ailauncher.chat.trace.ChatTracker;
import kotlin.Metadata;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import pb.E0;
import pb.T0;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\b\u0087\b\u0018\u0000 '2\u00020\u0001:\u0002'(B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006B9\b\u0010\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u0005\u0010\fJ'\u0010\u0015\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0010H\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0016\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0018\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0018\u0010\u0017J$\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u001b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u001b\u0010\u0017J\u0010\u0010\u001c\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\u001c\u0010\u001dJ\u001a\u0010!\u001a\u00020 2\b\u0010\u001f\u001a\u0004\u0018\u00010\u001eHÖ\u0003¢\u0006\u0004\b!\u0010\"R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010#\u001a\u0004\b$\u0010\u0017R\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010#\u001a\u0004\b%\u0010\u0017R\u001a\u0010\t\u001a\u00020\u00028\u0016X\u0096D¢\u0006\f\n\u0004\b\t\u0010#\u001a\u0004\b&\u0010\u0017¨\u0006)"}, d2 = {"Lio/modelcontextprotocol/kotlin/sdk/ImageContent;", "Lio/modelcontextprotocol/kotlin/sdk/PromptMessageContentMultimodal;", "", "data", "mimeType", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "", "seen0", "type", "Lpb/T0;", "serializationConstructorMarker", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lpb/T0;)V", "self", "Lob/d;", "output", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialDesc", "LY8/t;", "write$Self$kotlin_sdk", "(Lio/modelcontextprotocol/kotlin/sdk/ImageContent;Lob/d;Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "write$Self", "component1", "()Ljava/lang/String;", "component2", ChatTracker.CLICK_COPY, "(Ljava/lang/String;Ljava/lang/String;)Lio/modelcontextprotocol/kotlin/sdk/ImageContent;", "toString", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getData", "getMimeType", "getType", "Companion", "$serializer", "kotlin-sdk"}, k = 1, mv = {2, 2, 0}, xi = 48)
@lb.l
/* loaded from: classes4.dex */
public final /* data */ class ImageContent implements PromptMessageContentMultimodal {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final String TYPE = "image";
    private final String data;
    private final String mimeType;
    private final String type;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\t\u001a\u00020\b8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lio/modelcontextprotocol/kotlin/sdk/ImageContent$Companion;", "", "<init>", "()V", "Lkotlinx/serialization/KSerializer;", "Lio/modelcontextprotocol/kotlin/sdk/ImageContent;", "serializer", "()Lkotlinx/serialization/KSerializer;", "", "TYPE", "Ljava/lang/String;", "kotlin-sdk"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }

        public final KSerializer<ImageContent> serializer() {
            return ImageContent$$serializer.INSTANCE;
        }

        private Companion() {
        }
    }

    public /* synthetic */ ImageContent(int i10, String str, String str2, String str3, T0 t02) {
        if (3 != (i10 & 3)) {
            E0.a(i10, 3, ImageContent$$serializer.INSTANCE.getDescriptor());
        }
        this.data = str;
        this.mimeType = str2;
        if ((i10 & 4) == 0) {
            this.type = "image";
        } else {
            this.type = str3;
        }
    }

    public static /* synthetic */ ImageContent copy$default(ImageContent imageContent, String str, String str2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = imageContent.data;
        }
        if ((i10 & 2) != 0) {
            str2 = imageContent.mimeType;
        }
        return imageContent.copy(str, str2);
    }

    public static final /* synthetic */ void write$Self$kotlin_sdk(ImageContent self, ob.d output, SerialDescriptor serialDesc) {
        output.w(serialDesc, 0, self.data);
        output.w(serialDesc, 1, self.mimeType);
        if (!output.y(serialDesc, 2) && kotlin.jvm.internal.p.d(self.getType(), "image")) {
            return;
        }
        output.w(serialDesc, 2, self.getType());
    }

    /* renamed from: component1, reason: from getter */
    public final String getData() {
        return this.data;
    }

    /* renamed from: component2, reason: from getter */
    public final String getMimeType() {
        return this.mimeType;
    }

    public final ImageContent copy(String data, String mimeType) {
        kotlin.jvm.internal.p.i(data, "data");
        kotlin.jvm.internal.p.i(mimeType, "mimeType");
        return new ImageContent(data, mimeType);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ImageContent)) {
            return false;
        }
        ImageContent imageContent = (ImageContent) other;
        return kotlin.jvm.internal.p.d(this.data, imageContent.data) && kotlin.jvm.internal.p.d(this.mimeType, imageContent.mimeType);
    }

    public final String getData() {
        return this.data;
    }

    public final String getMimeType() {
        return this.mimeType;
    }

    @Override // io.modelcontextprotocol.kotlin.sdk.PromptMessageContent
    public String getType() {
        return this.type;
    }

    public int hashCode() {
        return (this.data.hashCode() * 31) + this.mimeType.hashCode();
    }

    public String toString() {
        return "ImageContent(data=" + this.data + ", mimeType=" + this.mimeType + ')';
    }

    public ImageContent(String data, String mimeType) {
        kotlin.jvm.internal.p.i(data, "data");
        kotlin.jvm.internal.p.i(mimeType, "mimeType");
        this.data = data;
        this.mimeType = mimeType;
        this.type = "image";
    }
}
