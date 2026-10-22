package androidx.appfunctions.metadata;

import androidx.autofill.HintConstants;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.aiengine.args.QueryAlgorithmBundle;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0003H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0014"}, d2 = {"Landroidx/appfunctions/metadata/AppFunctionSchemaMetadata;", "", QueryAlgorithmBundle.KEY_CATEGORY, "", HintConstants.AUTOFILL_HINT_NAME, "version", "", AppAgent.CONSTRUCT, "(Ljava/lang/String;Ljava/lang/String;J)V", "getCategory", "()Ljava/lang/String;", "getName", "getVersion", "()J", "equals", "", "other", "hashCode", "", "toString", AppFunctionMetadataKt.APP_FUNCTION_NAMESPACE}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public final class AppFunctionSchemaMetadata {
    private final String category;
    private final String name;
    private final long version;

    public AppFunctionSchemaMetadata(String category, String name, long j5) {
        k.f(category, "category");
        k.f(name, "name");
        this.category = category;
        this.name = name;
        this.version = j5;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!AppFunctionSchemaMetadata.class.equals(other != null ? other.getClass() : null)) {
            return false;
        }
        k.d(other, "null cannot be cast to non-null type androidx.appfunctions.metadata.AppFunctionSchemaMetadata");
        AppFunctionSchemaMetadata appFunctionSchemaMetadata = (AppFunctionSchemaMetadata) other;
        return this.version == appFunctionSchemaMetadata.version && k.b(this.category, appFunctionSchemaMetadata.category) && k.b(this.name, appFunctionSchemaMetadata.name);
    }

    public final String getCategory() {
        return this.category;
    }

    public final String getName() {
        return this.name;
    }

    public final long getVersion() {
        return this.version;
    }

    public int hashCode() {
        return this.name.hashCode() + B7.a.c(Long.hashCode(this.version) * 31, 31, this.category);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("AppFunctionSchemaMetadata(category='");
        sb.append(this.category);
        sb.append("', name='");
        sb.append(this.name);
        sb.append("', version=");
        return B7.a.p(sb, this.version, ')');
    }
}
