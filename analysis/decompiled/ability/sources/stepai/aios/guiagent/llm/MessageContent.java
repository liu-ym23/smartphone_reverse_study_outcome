package stepai.aios.guiagent.llm;

import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0004\u0004\u0005\u0006\u0007B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0004\b\t\n\u000b¨\u0006\f"}, d2 = {"Lstepai/aios/guiagent/llm/MessageContent;", "", AppAgent.CONSTRUCT, "()V", "Text", "Image", "ImageBase64", "ToolCalls", "Lstepai/aios/guiagent/llm/MessageContent$Image;", "Lstepai/aios/guiagent/llm/MessageContent$ImageBase64;", "Lstepai/aios/guiagent/llm/MessageContent$Text;", "Lstepai/aios/guiagent/llm/MessageContent$ToolCalls;", "guiagent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public abstract class MessageContent {

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lstepai/aios/guiagent/llm/MessageContent$Image;", "Lstepai/aios/guiagent/llm/MessageContent;", "imageUrl", "", AppAgent.CONSTRUCT, "(Ljava/lang/String;)V", "getImageUrl", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "guiagent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class Image extends MessageContent {
        private final String imageUrl;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Image(String imageUrl) {
            super(null);
            k.f(imageUrl, "imageUrl");
            this.imageUrl = imageUrl;
        }

        public static /* synthetic */ Image copy$default(Image image, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = image.imageUrl;
            }
            return image.copy(str);
        }

        /* renamed from: component1, reason: from getter */
        public final String getImageUrl() {
            return this.imageUrl;
        }

        public final Image copy(String imageUrl) {
            k.f(imageUrl, "imageUrl");
            return new Image(imageUrl);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Image) && k.b(this.imageUrl, ((Image) other).imageUrl);
        }

        public final String getImageUrl() {
            return this.imageUrl;
        }

        public int hashCode() {
            return this.imageUrl.hashCode();
        }

        public String toString() {
            return B7.a.m("Image(imageUrl=", this.imageUrl, ")");
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0014"}, d2 = {"Lstepai/aios/guiagent/llm/MessageContent$ImageBase64;", "Lstepai/aios/guiagent/llm/MessageContent;", "base64", "", "mimeType", AppAgent.CONSTRUCT, "(Ljava/lang/String;Ljava/lang/String;)V", "getBase64", "()Ljava/lang/String;", "getMimeType", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "guiagent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class ImageBase64 extends MessageContent {
        private final String base64;
        private final String mimeType;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ImageBase64(String base64, String mimeType) {
            super(null);
            k.f(base64, "base64");
            k.f(mimeType, "mimeType");
            this.base64 = base64;
            this.mimeType = mimeType;
        }

        public static /* synthetic */ ImageBase64 copy$default(ImageBase64 imageBase64, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = imageBase64.base64;
            }
            if ((i & 2) != 0) {
                str2 = imageBase64.mimeType;
            }
            return imageBase64.copy(str, str2);
        }

        /* renamed from: component1, reason: from getter */
        public final String getBase64() {
            return this.base64;
        }

        /* renamed from: component2, reason: from getter */
        public final String getMimeType() {
            return this.mimeType;
        }

        public final ImageBase64 copy(String base64, String mimeType) {
            k.f(base64, "base64");
            k.f(mimeType, "mimeType");
            return new ImageBase64(base64, mimeType);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ImageBase64)) {
                return false;
            }
            ImageBase64 imageBase64 = (ImageBase64) other;
            return k.b(this.base64, imageBase64.base64) && k.b(this.mimeType, imageBase64.mimeType);
        }

        public final String getBase64() {
            return this.base64;
        }

        public final String getMimeType() {
            return this.mimeType;
        }

        public int hashCode() {
            return this.mimeType.hashCode() + (this.base64.hashCode() * 31);
        }

        public String toString() {
            return androidx.appfunctions.metadata.a.m("ImageBase64(base64=", this.base64, ", mimeType=", this.mimeType, ")");
        }

        public /* synthetic */ ImageBase64(String str, String str2, int i, e eVar) {
            this(str, (i & 2) != 0 ? "image/jpeg" : str2);
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lstepai/aios/guiagent/llm/MessageContent$Text;", "Lstepai/aios/guiagent/llm/MessageContent;", "text", "", AppAgent.CONSTRUCT, "(Ljava/lang/String;)V", "getText", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "guiagent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class Text extends MessageContent {
        private final String text;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Text(String text) {
            super(null);
            k.f(text, "text");
            this.text = text;
        }

        public static /* synthetic */ Text copy$default(Text text, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = text.text;
            }
            return text.copy(str);
        }

        /* renamed from: component1, reason: from getter */
        public final String getText() {
            return this.text;
        }

        public final Text copy(String text) {
            k.f(text, "text");
            return new Text(text);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Text) && k.b(this.text, ((Text) other).text);
        }

        public final String getText() {
            return this.text;
        }

        public int hashCode() {
            return this.text.hashCode();
        }

        public String toString() {
            return B7.a.m("Text(text=", this.text, ")");
        }
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\n\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0013"}, d2 = {"Lstepai/aios/guiagent/llm/MessageContent$ToolCalls;", "Lstepai/aios/guiagent/llm/MessageContent;", "toolCalls", "", "Lstepai/aios/guiagent/llm/ToolCall;", AppAgent.CONSTRUCT, "(Ljava/util/List;)V", "getToolCalls", "()Ljava/util/List;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "guiagent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class ToolCalls extends MessageContent {
        private final List<ToolCall> toolCalls;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ToolCalls(List<ToolCall> toolCalls) {
            super(null);
            k.f(toolCalls, "toolCalls");
            this.toolCalls = toolCalls;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ ToolCalls copy$default(ToolCalls toolCalls, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                list = toolCalls.toolCalls;
            }
            return toolCalls.copy(list);
        }

        public final List<ToolCall> component1() {
            return this.toolCalls;
        }

        public final ToolCalls copy(List<ToolCall> toolCalls) {
            k.f(toolCalls, "toolCalls");
            return new ToolCalls(toolCalls);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof ToolCalls) && k.b(this.toolCalls, ((ToolCalls) other).toolCalls);
        }

        public final List<ToolCall> getToolCalls() {
            return this.toolCalls;
        }

        public int hashCode() {
            return this.toolCalls.hashCode();
        }

        public String toString() {
            return "ToolCalls(toolCalls=" + this.toolCalls + ")";
        }
    }

    public /* synthetic */ MessageContent(e eVar) {
        this();
    }

    private MessageContent() {
    }
}
