package stepai.aios.guiagent.llm.local;

import B7.a;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J)\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0016"}, d2 = {"Lstepai/aios/guiagent/llm/local/LocalMessage;", "", "role", "", "text", "imageBase64", AppAgent.CONSTRUCT, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getRole", "()Ljava/lang/String;", "getText", "getImageBase64", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "guiagent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class LocalMessage {
    private final String imageBase64;
    private final String role;
    private final String text;

    public LocalMessage(String role, String text, String str) {
        k.f(role, "role");
        k.f(text, "text");
        this.role = role;
        this.text = text;
        this.imageBase64 = str;
    }

    public static /* synthetic */ LocalMessage copy$default(LocalMessage localMessage, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = localMessage.role;
        }
        if ((i & 2) != 0) {
            str2 = localMessage.text;
        }
        if ((i & 4) != 0) {
            str3 = localMessage.imageBase64;
        }
        return localMessage.copy(str, str2, str3);
    }

    /* renamed from: component1, reason: from getter */
    public final String getRole() {
        return this.role;
    }

    /* renamed from: component2, reason: from getter */
    public final String getText() {
        return this.text;
    }

    /* renamed from: component3, reason: from getter */
    public final String getImageBase64() {
        return this.imageBase64;
    }

    public final LocalMessage copy(String role, String text, String imageBase64) {
        k.f(role, "role");
        k.f(text, "text");
        return new LocalMessage(role, text, imageBase64);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LocalMessage)) {
            return false;
        }
        LocalMessage localMessage = (LocalMessage) other;
        return k.b(this.role, localMessage.role) && k.b(this.text, localMessage.text) && k.b(this.imageBase64, localMessage.imageBase64);
    }

    public final String getImageBase64() {
        return this.imageBase64;
    }

    public final String getRole() {
        return this.role;
    }

    public final String getText() {
        return this.text;
    }

    public int hashCode() {
        int iC = a.c(this.role.hashCode() * 31, 31, this.text);
        String str = this.imageBase64;
        return iC + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        String str = this.role;
        String str2 = this.text;
        return a.q(a.w("LocalMessage(role=", str, ", text=", str2, ", imageBase64="), this.imageBase64, ")");
    }

    public /* synthetic */ LocalMessage(String str, String str2, String str3, int i, e eVar) {
        this(str, str2, (i & 4) != 0 ? null : str3);
    }
}
