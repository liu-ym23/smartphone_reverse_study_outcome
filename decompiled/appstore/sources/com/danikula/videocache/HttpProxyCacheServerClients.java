package com.danikula.videocache;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.danikula.videocache.file.FileCache;
import java.io.File;
import java.io.IOException;
import java.net.Socket;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes2.dex */
final class HttpProxyCacheServerClients {
    private final AtomicInteger clientsCount;
    private final Config config;
    private final List<CacheListener> listeners;
    private volatile HttpProxyCache proxyCache;
    private final CacheListener uiCacheListener;
    private final String url;

    public static final class UiListenerHandler extends Handler implements CacheListener {
        private final List<CacheListener> listeners;
        private final String url;

        public UiListenerHandler(String r10, List<CacheListener> r11) {
            super(Looper.getMainLooper());
            this.url = r10;
            this.listeners = r11;
        }

        @Override // android.os.Handler
        public void handleMessage(Message r10) {
            Iterator<CacheListener> r11 = this.listeners.iterator();
        L4:
            if (r11.hasNext() == false) goto L6;
            r11.next().onCacheAvailable((File) r10.obj, this.url, r10.arg1);
            goto L4
        }

        @Override // com.danikula.videocache.CacheListener
        public void onCacheAvailable(File r10, String r11, int r12) {
            Message r13 = obtainMessage();
            r13.arg1 = r12;
            r13.obj = r10;
            sendMessage(r13);
        }
    }

    public HttpProxyCacheServerClients(String r10, Config r11) {
        this.clientsCount = new AtomicInteger(0);
        CopyOnWriteArrayList r12 = new CopyOnWriteArrayList();
        this.listeners = r12;
        this.url = (String) Preconditions.checkNotNull(r10);
        this.config = (Config) Preconditions.checkNotNull(r11);
        this.uiCacheListener = new UiListenerHandler(r10, r12);
    }

    private synchronized void finishProcessRequest() {
        monitor-enter(this);
    L7:
        th = move-exception;
        throw th;
    L4:
        if (this.clientsCount.decrementAndGet() > 0) goto L9;
        this.proxyCache.shutdown();     // Catch: Throwable -> L7
        this.proxyCache = null;     // Catch: Throwable -> L7
    L9:
        monitor-exit(this);
    }

    private HttpProxyCache newHttpProxyCache() throws ProxyCacheException {
        String r10 = this.url;
        Config r11 = this.config;
        HttpProxyCache r12 = new HttpProxyCache(new HttpUrlSource(r10, r11.sourceInfoStorage, r11.headerInjector), new FileCache(this.config.generateCacheFile(this.url), this.config.diskUsage));
        r12.registerCacheListener(this.uiCacheListener);
        return r12;
    }

    private synchronized void startProcessRequest() throws ProxyCacheException {
        monitor-enter(this);
    L6:
        th = move-exception;
        throw th;
    L4:
        if (this.proxyCache != null) goto L8;
        HttpProxyCache r10 = newHttpProxyCache();     // Catch: Throwable -> L6
    L9:
        this.proxyCache = r10;     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L8:
        r10 = this.proxyCache;     // Catch: Throwable -> L6
        goto L9
    }

    public int getClientsCount() {
        return this.clientsCount.get();
    }

    public void processRequest(GetRequest r10, Socket r11) throws ProxyCacheException, IOException {
        startProcessRequest();
        this.clientsCount.incrementAndGet();     // Catch: Throwable -> L6
        this.proxyCache.processRequest(r10, r11);     // Catch: Throwable -> L6
        finishProcessRequest();
        return;
    L6:
        th = move-exception;
        finishProcessRequest();
        throw th;
    }

    public void registerCacheListener(CacheListener r10) {
        this.listeners.add(r10);
    }

    public void shutdown() {
        this.listeners.clear();
        if (this.proxyCache == null) goto L5;
        this.proxyCache.registerCacheListener(null);
        this.proxyCache.shutdown();
        this.proxyCache = null;
    L5:
        this.clientsCount.set(0);
    }

    public void unregisterCacheListener(CacheListener r10) {
        this.listeners.remove(r10);
    }
}
