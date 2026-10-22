package androidx.appfunctions.internal.serializableproxies;

import B7.a;
import android.net.Uri;
import androidx.annotation.RestrictTo;
import androidx.appfunctions.AppFunctionSerializableProxy;
import androidx.appfunctions.metadata.AppFunctionMetadataKt;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;

@AppFunctionSerializableProxy(targetClass = Uri.class)
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0087\b\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\b\u001a\u00020\tJ\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u000f\u001a\u00020\u0010HÖ\u0081\u0004J\n\u0010\u0011\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0013"}, d2 = {"Landroidx/appfunctions/internal/serializableproxies/AppFunctionUri;", "", "uri", "", AppAgent.CONSTRUCT, "(Ljava/lang/String;)V", "getUri", "()Ljava/lang/String;", "toUri", "Landroid/net/Uri;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "Companion", AppFunctionMetadataKt.APP_FUNCTION_NAMESPACE}, k = 1, mv = {2, 1, 0}, xi = 48)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes.dex */
public final /* data */ class AppFunctionUri {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String uri;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Landroidx/appfunctions/internal/serializableproxies/AppFunctionUri$Companion;", "", AppAgent.CONSTRUCT, "()V", "fromUri", "Landroidx/appfunctions/internal/serializableproxies/AppFunctionUri;", "androidUri", "Landroid/net/Uri;", AppFunctionMetadataKt.APP_FUNCTION_NAMESPACE}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(e eVar) {
            this();
        }

        public final AppFunctionUri fromUri(Uri androidUri) {
            k.f(androidUri, "androidUri");
            String string = androidUri.toString();
            k.e(string, "toString(...)");
            return new AppFunctionUri(string);
        }

        private Companion() {
        }
    }

    public AppFunctionUri(String uri) {
        k.f(uri, "uri");
        this.uri = uri;
    }

    public static /* synthetic */ AppFunctionUri copy$default(AppFunctionUri appFunctionUri, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = appFunctionUri.uri;
        }
        return appFunctionUri.copy(str);
    }

    /* renamed from: component1, reason: from getter */
    public final String getUri() {
        return this.uri;
    }

    public final AppFunctionUri copy(String uri) {
        k.f(uri, "uri");
        return new AppFunctionUri(uri);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof AppFunctionUri) && k.b(this.uri, ((AppFunctionUri) other).uri);
    }

    public final String getUri() {
        return this.uri;
    }

    public int hashCode() {
        return this.uri.hashCode();
    }

    public String toString() {
        return a.g(')', this.uri, new StringBuilder("AppFunctionUri(uri="));
    }

    public final Uri toUri() {
        Uri uri = Uri.parse(this.uri);
        k.e(uri, "parse(...)");
        return uri;
    }
}
