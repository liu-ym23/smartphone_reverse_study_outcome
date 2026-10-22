package okhttp3.internal;

import com.baidu.platform.comapi.map.MapBundleKey;
import h3.C0599h;
import h3.C0610t;
import h3.C0611u;
import h3.C0612v;
import h3.G;
import h3.J;
import h3.V;
import h3.b0;
import java.util.regex.Pattern;
import javax.net.ssl.SSLSocket;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000T\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u001a'\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\b\u001a\u001d\u0010\f\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\r\u001a\u001d\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0004¢\u0006\u0004\b\u0011\u0010\u0012\u001a%\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0004¢\u0006\u0004\b\u0011\u0010\u0015\u001a\u001f\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u0018¢\u0006\u0004\b\u001b\u0010\u001c\u001a%\u0010#\u001a\u00020\"2\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\n¢\u0006\u0004\b#\u0010$¨\u0006%"}, d2 = {"", "currentTimeMillis", "Lh3/J;", MapBundleKey.MapObjKey.OBJ_URL, "", "setCookie", "Lh3/v;", "parseCookie", "(JLh3/J;Ljava/lang/String;)Lh3/v;", "cookie", "", "forObsoleteRfc2965", "cookieToString", "(Lh3/v;Z)Ljava/lang/String;", "Lh3/G;", "builder", "line", "addHeaderLenient", "(Lh3/G;Ljava/lang/String;)Lh3/G;", "name", "value", "(Lh3/G;Ljava/lang/String;Ljava/lang/String;)Lh3/G;", "Lh3/h;", "cache", "Lh3/V;", "request", "Lh3/b0;", "cacheGet", "(Lh3/h;Lh3/V;)Lh3/b0;", "Lh3/t;", "connectionSpec", "Ljavax/net/ssl/SSLSocket;", "sslSocket", "isFallback", "", "applyConnectionSpec", "(Lh3/t;Ljavax/net/ssl/SSLSocket;Z)V", "okhttp"}, k = 2, mv = {1, 6, 0})
@JvmName(name = "Internal")
/* loaded from: classes2.dex */
public final class Internal {
    @NotNull
    public static final G addHeaderLenient(@NotNull G builder, @NotNull String line) {
        Intrinsics.checkNotNullParameter(builder, "builder");
        Intrinsics.checkNotNullParameter(line, "line");
        builder.b(line);
        return builder;
    }

    public static final void applyConnectionSpec(@NotNull C0610t connectionSpec, @NotNull SSLSocket sslSocket, boolean z4) {
        Intrinsics.checkNotNullParameter(connectionSpec, "connectionSpec");
        Intrinsics.checkNotNullParameter(sslSocket, "sslSocket");
        connectionSpec.a(sslSocket, z4);
    }

    @Nullable
    public static final b0 cacheGet(@NotNull C0599h cache, @NotNull V request) {
        Intrinsics.checkNotNullParameter(cache, "cache");
        Intrinsics.checkNotNullParameter(request, "request");
        return cache.a(request);
    }

    @NotNull
    public static final String cookieToString(@NotNull C0612v cookie, boolean z4) {
        Intrinsics.checkNotNullParameter(cookie, "cookie");
        return cookie.a(z4);
    }

    @Nullable
    public static final C0612v parseCookie(long j4, @NotNull J url, @NotNull String setCookie) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(setCookie, "setCookie");
        Pattern pattern = C0612v.f12974j;
        return C0611u.u(j4, url, setCookie);
    }

    @NotNull
    public static final G addHeaderLenient(@NotNull G builder, @NotNull String name, @NotNull String value) {
        Intrinsics.checkNotNullParameter(builder, "builder");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(value, "value");
        builder.c(name, value);
        return builder;
    }
}
