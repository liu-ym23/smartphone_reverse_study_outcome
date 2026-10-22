package io.ktor.client.engine.cio;

import Z8.F;
import io.ktor.http.URLUtilsJvmKt;
import io.ktor.http.Url;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u001f\u0010\u0004\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u00032\u0006\u0010\u0001\u001a\u00020\u0000H\u0000¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lio/ktor/http/Url;", "url", "Ljava/net/Proxy;", "Lio/ktor/client/engine/ProxyConfig;", "lookupGlobalProxy", "(Lio/ktor/http/Url;)Ljava/net/Proxy;", "ktor-client-cio"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class Proxy_jvmKt {
    public static final Proxy lookupGlobalProxy(Url url) {
        URI uri;
        p.i(url, "url");
        try {
            uri = URLUtilsJvmKt.toURI(url);
        } catch (URISyntaxException unused) {
            uri = null;
        }
        if (uri == null) {
            return null;
        }
        List<Proxy> listSelect = ProxySelector.getDefault().select(uri);
        p.f(listSelect);
        if (listSelect.isEmpty()) {
            return null;
        }
        Proxy proxy = (Proxy) F.q0(listSelect);
        if (listSelect.size() == 1 && proxy.type() == Proxy.Type.DIRECT) {
            return null;
        }
        return proxy;
    }
}
