package okhttp3.internal.http;

import com.baidu.platform.comapi.map.MapBundleKey;
import h3.J;
import h3.V;
import java.net.Proxy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u001d\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\n\u0010\u000bJ\u0015\u0010\u000e\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, d2 = {"Lokhttp3/internal/http/RequestLine;", "", "Lh3/V;", "request", "Ljava/net/Proxy$Type;", "proxyType", "", "includeAuthorityInRequestLine", "(Lh3/V;Ljava/net/Proxy$Type;)Z", "", "get", "(Lh3/V;Ljava/net/Proxy$Type;)Ljava/lang/String;", "Lh3/J;", MapBundleKey.MapObjKey.OBJ_URL, "requestPath", "(Lh3/J;)Ljava/lang/String;", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes2.dex */
public final class RequestLine {

    @NotNull
    public static final RequestLine INSTANCE = new RequestLine();

    private RequestLine() {
    }

    private final boolean includeAuthorityInRequestLine(V request, Proxy.Type proxyType) {
        return !request.f12826a.f12731j && proxyType == Proxy.Type.HTTP;
    }

    @NotNull
    public final String get(@NotNull V request, @NotNull Proxy.Type proxyType) {
        Intrinsics.checkNotNullParameter(request, "request");
        Intrinsics.checkNotNullParameter(proxyType, "proxyType");
        StringBuilder sb = new StringBuilder();
        sb.append(request.f12827b);
        sb.append(' ');
        RequestLine requestLine = INSTANCE;
        boolean zIncludeAuthorityInRequestLine = requestLine.includeAuthorityInRequestLine(request, proxyType);
        J j4 = request.f12826a;
        if (zIncludeAuthorityInRequestLine) {
            sb.append(j4);
        } else {
            sb.append(requestLine.requestPath(j4));
        }
        sb.append(" HTTP/1.1");
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    @NotNull
    public final String requestPath(@NotNull J url) {
        Intrinsics.checkNotNullParameter(url, "url");
        String strB = url.b();
        String strD = url.d();
        if (strD == null) {
            return strB;
        }
        return strB + '?' + ((Object) strD);
    }
}
