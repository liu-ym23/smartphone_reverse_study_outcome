package stepai.aios.guiagent.tracer.remote;

import B7.a;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÆ\u0003J+\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00032\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f¨\u0006\u0017"}, d2 = {"Lstepai/aios/guiagent/tracer/remote/UploadResult;", "", "success", "", "message", "", "key", AppAgent.CONSTRUCT, "(ZLjava/lang/String;Ljava/lang/String;)V", "getSuccess", "()Z", "getMessage", "()Ljava/lang/String;", "getKey", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "guiagent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class UploadResult {
    private final String key;
    private final String message;
    private final boolean success;

    public UploadResult(boolean z10, String str, String str2) {
        this.success = z10;
        this.message = str;
        this.key = str2;
    }

    public static /* synthetic */ UploadResult copy$default(UploadResult uploadResult, boolean z10, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            z10 = uploadResult.success;
        }
        if ((i & 2) != 0) {
            str = uploadResult.message;
        }
        if ((i & 4) != 0) {
            str2 = uploadResult.key;
        }
        return uploadResult.copy(z10, str, str2);
    }

    /* renamed from: component1, reason: from getter */
    public final boolean getSuccess() {
        return this.success;
    }

    /* renamed from: component2, reason: from getter */
    public final String getMessage() {
        return this.message;
    }

    /* renamed from: component3, reason: from getter */
    public final String getKey() {
        return this.key;
    }

    public final UploadResult copy(boolean success, String message, String key) {
        return new UploadResult(success, message, key);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof UploadResult)) {
            return false;
        }
        UploadResult uploadResult = (UploadResult) other;
        return this.success == uploadResult.success && k.b(this.message, uploadResult.message) && k.b(this.key, uploadResult.key);
    }

    public final String getKey() {
        return this.key;
    }

    public final String getMessage() {
        return this.message;
    }

    public final boolean getSuccess() {
        return this.success;
    }

    public int hashCode() {
        int iHashCode = Boolean.hashCode(this.success) * 31;
        String str = this.message;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.key;
        return iHashCode2 + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        boolean z10 = this.success;
        String str = this.message;
        String str2 = this.key;
        StringBuilder sb = new StringBuilder("UploadResult(success=");
        sb.append(z10);
        sb.append(", message=");
        sb.append(str);
        sb.append(", key=");
        return a.q(sb, str2, ")");
    }
}
