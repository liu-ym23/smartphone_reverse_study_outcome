package androidx.appfunctions.metadata;

import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\r\u0010\b\u001a\u00020\tH\u0000¢\u0006\u0002\b\nJ\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u0003H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Landroidx/appfunctions/metadata/AppFunctionDeprecationMetadata;", "", "message", "", AppAgent.CONSTRUCT, "(Ljava/lang/String;)V", "getMessage", "()Ljava/lang/String;", "toAppFunctionDeprecationMetadataDocument", "Landroidx/appfunctions/metadata/AppFunctionDeprecationMetadataDocument;", "toAppFunctionDeprecationMetadataDocument$appfunctions", "equals", "", "other", "hashCode", "", "toString", AppFunctionMetadataKt.APP_FUNCTION_NAMESPACE}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public final class AppFunctionDeprecationMetadata {
    private final String message;

    public AppFunctionDeprecationMetadata(String message) {
        k.f(message, "message");
        this.message = message;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!AppFunctionDeprecationMetadata.class.equals(other != null ? other.getClass() : null)) {
            return false;
        }
        k.d(other, "null cannot be cast to non-null type androidx.appfunctions.metadata.AppFunctionDeprecationMetadata");
        return k.b(this.message, ((AppFunctionDeprecationMetadata) other).message);
    }

    public final String getMessage() {
        return this.message;
    }

    public int hashCode() {
        return this.message.hashCode();
    }

    public final AppFunctionDeprecationMetadataDocument toAppFunctionDeprecationMetadataDocument$appfunctions() {
        return new AppFunctionDeprecationMetadataDocument(null, null, this.message, 3, null);
    }

    public String toString() {
        return B7.a.q(new StringBuilder("AppFunctionDeprecationMetadata(message='"), this.message, "')");
    }
}
