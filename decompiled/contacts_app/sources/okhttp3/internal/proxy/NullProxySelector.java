package okhttp3.internal.proxy;

import java.io.IOException;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.SocketAddress;
import java.net.URI;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public class NullProxySelector extends ProxySelector {
    @Override // java.net.ProxySelector
    public void connectFailed(URI r1, SocketAddress r2, IOException r3) {
    }

    public NullProxySelector() {
    }

    @Override // java.net.ProxySelector
    public List<Proxy> select(URI r1) {
        if (r1 == null) goto L6;
        return Collections.singletonList(Proxy.NO_PROXY);
    L6:
        throw new IllegalArgumentException("uri must not be null");
    }
}
