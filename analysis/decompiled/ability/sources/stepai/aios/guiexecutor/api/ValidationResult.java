package stepai.aios.guiexecutor.api;

import androidx.appfunctions.metadata.a;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007HÆ\u0003J/\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00032\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\nR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0019"}, d2 = {"Lstepai/aios/guiexecutor/api/ValidationResult;", "", "isValid", "", "message", "", "errors", "", AppAgent.CONSTRUCT, "(ZLjava/lang/String;Ljava/util/List;)V", "()Z", "getMessage", "()Ljava/lang/String;", "getErrors", "()Ljava/util/List;", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "Companion", "guiagent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class ValidationResult {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final List<String> errors;
    private final boolean isValid;
    private final String message;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005J\u000e\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bJ\u0014\u0010\u0006\u001a\u00020\u00052\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\n¨\u0006\u000b"}, d2 = {"Lstepai/aios/guiexecutor/api/ValidationResult$Companion;", "", AppAgent.CONSTRUCT, "()V", "success", "Lstepai/aios/guiexecutor/api/ValidationResult;", "failure", "message", "", "errors", "", "guiagent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(e eVar) {
            this();
        }

        public final ValidationResult failure(String message) {
            k.f(message, "message");
            return new ValidationResult(false, message, null, 4, null);
        }

        public final ValidationResult success() {
            return new ValidationResult(true, null, null, 6, null);
        }

        private Companion() {
        }

        public final ValidationResult failure(List<String> errors) {
            k.f(errors, "errors");
            return new ValidationResult(false, null, errors, 2, null);
        }
    }

    public ValidationResult(boolean z10, String str, List list, int i, e eVar) {
        this(z10, (i & 2) != 0 ? null : str, (i & 4) != 0 ? EmptyList.f4893a : list);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ValidationResult copy$default(ValidationResult validationResult, boolean z10, String str, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            z10 = validationResult.isValid;
        }
        if ((i & 2) != 0) {
            str = validationResult.message;
        }
        if ((i & 4) != 0) {
            list = validationResult.errors;
        }
        return validationResult.copy(z10, str, list);
    }

    /* renamed from: component1, reason: from getter */
    public final boolean getIsValid() {
        return this.isValid;
    }

    /* renamed from: component2, reason: from getter */
    public final String getMessage() {
        return this.message;
    }

    public final List<String> component3() {
        return this.errors;
    }

    public final ValidationResult copy(boolean isValid, String message, List<String> errors) {
        k.f(errors, "errors");
        return new ValidationResult(isValid, message, errors);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ValidationResult)) {
            return false;
        }
        ValidationResult validationResult = (ValidationResult) other;
        return this.isValid == validationResult.isValid && k.b(this.message, validationResult.message) && k.b(this.errors, validationResult.errors);
    }

    public final List<String> getErrors() {
        return this.errors;
    }

    public final String getMessage() {
        return this.message;
    }

    public int hashCode() {
        int iHashCode = Boolean.hashCode(this.isValid) * 31;
        String str = this.message;
        return this.errors.hashCode() + ((iHashCode + (str == null ? 0 : str.hashCode())) * 31);
    }

    public final boolean isValid() {
        return this.isValid;
    }

    public String toString() {
        boolean z10 = this.isValid;
        String str = this.message;
        List<String> list = this.errors;
        StringBuilder sb = new StringBuilder("ValidationResult(isValid=");
        sb.append(z10);
        sb.append(", message=");
        sb.append(str);
        sb.append(", errors=");
        return a.q(sb, list, ")");
    }

    public ValidationResult(boolean z10, String str, List<String> errors) {
        k.f(errors, "errors");
        this.isValid = z10;
        this.message = str;
        this.errors = errors;
    }
}
