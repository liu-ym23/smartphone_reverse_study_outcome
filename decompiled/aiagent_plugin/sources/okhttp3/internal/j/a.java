package okhttp3.internal.j;

import d.a.p;
import java.io.IOException;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.SocketAddress;
import java.net.URI;
import java.util.List;

/* JADX INFO: compiled from: NullProxySelector.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class a extends ProxySelector {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f40149a = null;

    static {
        f40149a = new a();
    }

    @Override // java.net.ProxySelector
    public void connectFailed(URI r1, SocketAddress r2, IOException r3) {
    }

    private a() {
    }

    @Override // java.net.ProxySelector
    public List<Proxy> select(URI r1) {
        if (r1 == null) goto L6;
        return p.a(Proxy.NO_PROXY);
    L6:
        throw new IllegalArgumentException("uri must not be null".toString());
    }
}
