package com.danikula.videocache;

import java.io.IOException;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.SocketAddress;
import java.net.URI;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
class IgnoreHostProxySelector extends ProxySelector {
    private static final List<Proxy> NO_PROXY_LIST = null;
    private final ProxySelector defaultProxySelector;
    private final String hostToIgnore;
    private final int portToIgnore;

    static {
        NO_PROXY_LIST = Arrays.asList(new Proxy[]{Proxy.NO_PROXY});
    }

    public IgnoreHostProxySelector(ProxySelector r10, String r11, int r12) {
        this.defaultProxySelector = (ProxySelector) Preconditions.checkNotNull(r10);
        this.hostToIgnore = (String) Preconditions.checkNotNull(r11);
        this.portToIgnore = r12;
    }

    public static void install(String r10, int r11) {
        ProxySelector.setDefault(new IgnoreHostProxySelector(ProxySelector.getDefault(), r10, r11));
    }

    @Override // java.net.ProxySelector
    public void connectFailed(URI r10, SocketAddress r11, IOException r12) {
        this.defaultProxySelector.connectFailed(r10, r11, r12);
    }

    @Override // java.net.ProxySelector
    public List<Proxy> select(URI r10) {
        if (this.hostToIgnore.equals(r10.getHost()) == false) goto L8;
        if (this.portToIgnore != r10.getPort()) goto L8;
        return NO_PROXY_LIST;
    L8:
        return this.defaultProxySelector.select(r10);
    }
}
