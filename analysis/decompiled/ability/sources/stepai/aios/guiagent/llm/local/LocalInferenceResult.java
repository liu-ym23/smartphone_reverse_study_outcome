package stepai.aios.guiagent.llm.local;

import androidx.appfunctions.metadata.a;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J)\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00052\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u0017"}, d2 = {"Lstepai/aios/guiagent/llm/local/LocalInferenceResult;", "", "content", "", "success", "", "error", AppAgent.CONSTRUCT, "(Ljava/lang/String;ZLjava/lang/String;)V", "getContent", "()Ljava/lang/String;", "getSuccess", "()Z", "getError", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "guiagent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class LocalInferenceResult {
    private final String content;
    private final String error;
    private final boolean success;

    public LocalInferenceResult(String content, boolean z10, String str) {
        k.f(content, "content");
        this.content = content;
        this.success = z10;
        this.error = str;
    }

    public static /* synthetic */ LocalInferenceResult copy$default(LocalInferenceResult localInferenceResult, String str, boolean z10, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = localInferenceResult.content;
        }
        if ((i & 2) != 0) {
            z10 = localInferenceResult.success;
        }
        if ((i & 4) != 0) {
            str2 = localInferenceResult.error;
        }
        return localInferenceResult.copy(str, z10, str2);
    }

    /* renamed from: component1, reason: from getter */
    public final String getContent() {
        return this.content;
    }

    /* renamed from: component2, reason: from getter */
    public final boolean getSuccess() {
        return this.success;
    }

    /* renamed from: component3, reason: from getter */
    public final String getError() {
        return this.error;
    }

    public final LocalInferenceResult copy(String content, boolean success, String error) {
        k.f(content, "content");
        return new LocalInferenceResult(content, success, error);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LocalInferenceResult)) {
            return false;
        }
        LocalInferenceResult localInferenceResult = (LocalInferenceResult) other;
        return k.b(this.content, localInferenceResult.content) && this.success == localInferenceResult.success && k.b(this.error, localInferenceResult.error);
    }

    public final String getContent() {
        return this.content;
    }

    public final String getError() {
        return this.error;
    }

    public final boolean getSuccess() {
        return this.success;
    }

    public int hashCode() {
        int iD = a.d(this.content.hashCode() * 31, 31, this.success);
        String str = this.error;
        return iD + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        String str = this.content;
        boolean z10 = this.success;
        return B7.a.q(androidx.constraintlayout.core.dsl.a.l("LocalInferenceResult(content=", str, ", success=", ", error=", z10), this.error, ")");
    }

    public /* synthetic */ LocalInferenceResult(String str, boolean z10, String str2, int i, e eVar) {
        this(str, (i & 2) != 0 ? true : z10, (i & 4) != 0 ? null : str2);
    }
}
