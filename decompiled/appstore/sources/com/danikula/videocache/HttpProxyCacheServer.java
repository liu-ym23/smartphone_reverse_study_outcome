package com.danikula.videocache;

import android.content.Context;
import android.net.Uri;
import com.danikula.videocache.file.DiskUsage;
import com.danikula.videocache.file.FileNameGenerator;
import com.danikula.videocache.file.Md5FileNameGenerator;
import com.danikula.videocache.file.TotalCountLruDiskUsage;
import com.danikula.videocache.file.TotalSizeLruDiskUsage;
import com.danikula.videocache.headers.EmptyHeadersInjector;
import com.danikula.videocache.headers.HeaderInjector;
import com.danikula.videocache.sourcestorage.SourceInfoStorage;
import com.danikula.videocache.sourcestorage.SourceInfoStorageFactory;
import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* JADX INFO: loaded from: classes2.dex */
public class HttpProxyCacheServer {
    private static final String PROXY_HOST = "127.0.0.1";
    private final Object clientsLock;
    private final Map<String, HttpProxyCacheServerClients> clientsMap;
    private final Config config;
    private final Pinger pinger;
    private final int port;
    private final ServerSocket serverSocket;
    private final ExecutorService socketProcessor;
    private final Thread waitConnectionThread;

    /* JADX INFO: renamed from: com.danikula.videocache.HttpProxyCacheServer$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static final class Builder {
        private static final long DEFAULT_MAX_SIZE = 536870912;
        private File cacheRoot;
        private DiskUsage diskUsage;
        private FileNameGenerator fileNameGenerator;
        private HeaderInjector headerInjector;
        private SourceInfoStorage sourceInfoStorage;

        public Builder(Context r10) {
            this.sourceInfoStorage = SourceInfoStorageFactory.newSourceInfoStorage(r10);
            this.cacheRoot = StorageUtils.getIndividualCacheDirectory(r10);
            this.diskUsage = new TotalSizeLruDiskUsage(DEFAULT_MAX_SIZE);
            this.fileNameGenerator = new Md5FileNameGenerator();
            this.headerInjector = new EmptyHeadersInjector();
        }

        public static /* synthetic */ Config access$000(Builder r10) {
            return r10.buildConfig();
        }

        private Config buildConfig() {
            return new Config(this.cacheRoot, this.fileNameGenerator, this.diskUsage, this.sourceInfoStorage, this.headerInjector);
        }

        public HttpProxyCacheServer build() {
            return new HttpProxyCacheServer(buildConfig(), null);
        }

        public Builder cacheDirectory(File r10) {
            this.cacheRoot = (File) Preconditions.checkNotNull(r10);
            return this;
        }

        public Builder diskUsage(DiskUsage r10) {
            this.diskUsage = (DiskUsage) Preconditions.checkNotNull(r10);
            return this;
        }

        public Builder fileNameGenerator(FileNameGenerator r10) {
            this.fileNameGenerator = (FileNameGenerator) Preconditions.checkNotNull(r10);
            return this;
        }

        public Builder headerInjector(HeaderInjector r10) {
            this.headerInjector = (HeaderInjector) Preconditions.checkNotNull(r10);
            return this;
        }

        public Builder maxCacheFilesCount(int r10) {
            this.diskUsage = new TotalCountLruDiskUsage(r10);
            return this;
        }

        public Builder maxCacheSize(long r10) {
            this.diskUsage = new TotalSizeLruDiskUsage(r10);
            return this;
        }
    }

    public final class SocketProcessorRunnable implements Runnable {
        private final Socket socket;
        final /* synthetic */ HttpProxyCacheServer this$0;

        public SocketProcessorRunnable(HttpProxyCacheServer r10, Socket r11) {
            this.this$0 = r10;
            this.socket = r11;
        }

        @Override // java.lang.Runnable
        public void run() {
            HttpProxyCacheServer.access$200(this.this$0, this.socket);
        }
    }

    public final class WaitRequestsRunnable implements Runnable {
        private final CountDownLatch startSignal;
        final /* synthetic */ HttpProxyCacheServer this$0;

        public WaitRequestsRunnable(HttpProxyCacheServer r10, CountDownLatch r11) {
            this.this$0 = r10;
            this.startSignal = r11;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.startSignal.countDown();
            HttpProxyCacheServer.access$100(this.this$0);
        }
    }

    public /* synthetic */ HttpProxyCacheServer(Config r10, AnonymousClass1 r11) {
        this(r10);
    }

    public static /* synthetic */ void access$100(HttpProxyCacheServer r10) {
        r10.waitForRequest();
    }

    public static /* synthetic */ void access$200(HttpProxyCacheServer r10, Socket r11) {
        r10.processSocket(r11);
    }

    private String appendToProxyUrl(String r10) {
        return String.format(Locale.US, "http://%s:%d/%s", new Object[]{PROXY_HOST, Integer.valueOf(this.port), ProxyCacheUtils.encode(r10)});
    }

    private void closeSocket(Socket r10) {
    L6:
        e = move-exception;
        onError(new ProxyCacheException("Error closing socket", e));
        return;
    L3:
        if (r10.isClosed() == true) goto L11;
        r10.close();     // Catch: IOException -> L6
        return;
    }

    private void closeSocketInput(Socket r10) {
    L8:
        KLog.d("Releasing input stream… Socket is closed by client.");
        return;
    L6:
        e = move-exception;
        onError(new ProxyCacheException("Error closing socket input stream", e));
        return;
    L3:
        if (r10.isInputShutdown() == true) goto L12;
        r10.shutdownInput();     // Catch: IOException -> L6 SocketException -> L8
    L14:
        return;
    }

    private void closeSocketOutput(Socket r10) {
    L6:
        e = move-exception;
        KLog.w("Failed to close socket on proxy side: {}. It seems client have already closed connection.", new Object[]{e.getMessage()});
        return;
    L3:
        if (r10.isOutputShutdown() == true) goto L11;
        r10.shutdownOutput();     // Catch: IOException -> L6
        return;
    }

    private File getCacheFile(String r10) {
        Config r11 = this.config;
        return new File(r11.cacheRoot, r11.fileNameGenerator.generate(r10));
    }

    private HttpProxyCacheServerClients getClients(String r10) throws ProxyCacheException {
        Object r11 = this.clientsLock;
        monitor-enter(r11);
        HttpProxyCacheServerClients r12 = this.clientsMap.get(r10);     // Catch: Throwable -> L7
        if (r12 != null) goto L9;
        r12 = new HttpProxyCacheServerClients(r10, this.config);     // Catch: Throwable -> L7
        this.clientsMap.put(r10, r12);     // Catch: Throwable -> L7
    L9:
        monitor-exit(r11);     // Catch: Throwable -> L7
        return r12;
    L7:
        th = move-exception;
        throw th;
    }

    private int getClientsCount() {
        Object r10 = this.clientsLock;
        monitor-enter(r10);
        Iterator<HttpProxyCacheServerClients> r11 = this.clientsMap.values().iterator();     // Catch: Throwable -> L8
        int r12 = 0;
    L6:
        if (r11.hasNext() == false) goto L10;
        r12 = r12 + r11.next().getClientsCount();     // Catch: Throwable -> L8
        goto L6
    L10:
        monitor-exit(r10);     // Catch: Throwable -> L8
        return r12;
    L8:
        th = move-exception;
        throw th;
    }

    private boolean isAlive() {
        return this.pinger.ping(3, 70);
    }

    private void onError(Throwable r10) {
        KLog.e("HttpProxyCacheServer error", new Object[]{r10});
    }

    private void processSocket(Socket r10) {
        GetRequest r11 = GetRequest.read(r10.getInputStream());     // Catch: Throwable -> L6 Throwable -> L8 SocketException -> L15
        KLog.d("Request to cache proxy:" + r11);     // Catch: Throwable -> L6 Throwable -> L8 SocketException -> L15
        String r12 = ProxyCacheUtils.decode(r11.uri);     // Catch: Throwable -> L6 Throwable -> L8 SocketException -> L15
        if (this.pinger.isPingRequest(r12) == false) goto L10;
        this.pinger.responseToPing(r10);     // Catch: Throwable -> L6 Throwable -> L8 SocketException -> L15
    L11:
        releaseSocket(r10);
        StringBuilder r13 = new StringBuilder();
    L12:
        r13.append("Opened connections: ");
        r13.append(getClientsCount());
        KLog.d(r13.toString());
        return;
    L10:
        getClients(r12).processRequest(r11, r10);     // Catch: Throwable -> L6 Throwable -> L8 SocketException -> L15
    L6:
        th = move-exception;
        releaseSocket(r10);
        KLog.d("Opened connections: " + getClientsCount());
        throw th;
    L15:
        KLog.d("Closing socket… Socket is closed by client.");     // Catch: Throwable -> L6
        releaseSocket(r10);
        r13 = new StringBuilder();
    L8:
        e = move-exception;
        onError(new ProxyCacheException("Error processing request", e));     // Catch: Throwable -> L6
        releaseSocket(r10);
        r13 = new StringBuilder();
        goto L12
    }

    private void releaseSocket(Socket r10) {
        closeSocketInput(r10);
        closeSocketOutput(r10);
        closeSocket(r10);
    }

    private void shutdownClients() {
        Object r10 = this.clientsLock;
        monitor-enter(r10);
        Iterator<HttpProxyCacheServerClients> r11 = this.clientsMap.values().iterator();     // Catch: Throwable -> L8
    L6:
        if (r11.hasNext() == false) goto L10;
        r11.next().shutdown();     // Catch: Throwable -> L8
        goto L6
    L10:
        this.clientsMap.clear();     // Catch: Throwable -> L8
        monitor-exit(r10);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    private void touchFileSafely(File r10) {
        this.config.diskUsage.touch(r10);     // Catch: IOException -> L4
        return;
    L4:
        e = move-exception;
        KLog.e("Error touching file " + r10, new Object[]{e});
    }

    private void waitForRequest() {
    L9:
    L6:
        e = move-exception;
        onError(new ProxyCacheException("Error during waiting connection", e));
        return;
    L3:
        if (Thread.currentThread().isInterrupted() == true) goto L13;
        Socket r10 = this.serverSocket.accept();     // Catch: IOException -> L6
        KLog.d("Accept new socket " + r10);     // Catch: IOException -> L6
        this.socketProcessor.submit(new SocketProcessorRunnable(this, r10));     // Catch: IOException -> L6
        goto L9
    }

    public String getProxyUrl(String r10) {
        return getProxyUrl(r10, true);
    }

    public boolean isCached(String r10) {
        Preconditions.checkNotNull(r10, "Url can't be null!");
        return getCacheFile(r10).exists();
    }

    public void registerCacheListener(CacheListener r10, String r11) {
        Preconditions.checkAllNotNull(new Object[]{r10, r11});
        Object r12 = this.clientsLock;
        monitor-enter(r12);
        getClients(r11).registerCacheListener(r10);     // Catch: Throwable -> L6 ProxyCacheException -> L8
    L10:
        monitor-exit(r12);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        throw th;
    L8:
        e = move-exception;
        KLog.w("Error registering cache listener", new Object[]{e});     // Catch: Throwable -> L6
        goto L10
    }

    public void shutdown() {
        KLog.i("Shutdown proxy server");
        shutdownClients();
        this.config.sourceInfoStorage.release();
        this.waitConnectionThread.interrupt();
    L7:
        e = move-exception;
        onError(new ProxyCacheException("Error shutting down proxy server", e));
        return;
    L4:
        if (this.serverSocket.isClosed() == true) goto L12;
        this.serverSocket.close();     // Catch: IOException -> L7
        return;
    }

    public void unregisterCacheListener(CacheListener r10, String r11) {
        Preconditions.checkAllNotNull(new Object[]{r10, r11});
        Object r12 = this.clientsLock;
        monitor-enter(r12);
        getClients(r11).unregisterCacheListener(r10);     // Catch: Throwable -> L6 ProxyCacheException -> L8
    L10:
        monitor-exit(r12);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        throw th;
    L8:
        e = move-exception;
        KLog.w("Error registering cache listener", new Object[]{e});     // Catch: Throwable -> L6
        goto L10
    }

    public HttpProxyCacheServer(Context r10) {
        this(Builder.access$000(new Builder(r10)));
    }

    public String getProxyUrl(String r10, boolean r11) {
        if (r11 == false) goto L8;
        if (isCached(r10) == false) goto L8;
        File r12 = getCacheFile(r10);
        touchFileSafely(r12);
        return Uri.fromFile(r12).toString();
    L8:
        if (isAlive() == true) goto L10;
        return r10;
    L10:
        return appendToProxyUrl(r10);
    }

    private HttpProxyCacheServer(Config r10) {
        this.clientsLock = new Object();
        this.socketProcessor = Executors.newFixedThreadPool(8);
        this.clientsMap = new ConcurrentHashMap();
        this.config = (Config) Preconditions.checkNotNull(r10);
        ServerSocket r11 = new ServerSocket(0, 8, InetAddress.getByName(PROXY_HOST));     // Catch: Throwable -> L5
        this.serverSocket = r11;     // Catch: Throwable -> L5
        int r12 = r11.getLocalPort();     // Catch: Throwable -> L5
        this.port = r12;     // Catch: Throwable -> L5
        IgnoreHostProxySelector.install(PROXY_HOST, r12);     // Catch: Throwable -> L5
        CountDownLatch r13 = new CountDownLatch(1);     // Catch: Throwable -> L5
        Thread r14 = new Thread(new WaitRequestsRunnable(this, r13));     // Catch: Throwable -> L5
        this.waitConnectionThread = r14;     // Catch: Throwable -> L5
        r14.start();     // Catch: Throwable -> L5
        r13.await();     // Catch: Throwable -> L5
        this.pinger = new Pinger(PROXY_HOST, r12);     // Catch: Throwable -> L5
        KLog.i("Proxy cache server started. Is it alive? " + isAlive());     // Catch: Throwable -> L5
        return;
    L5:
        e = move-exception;
        this.socketProcessor.shutdown();
        throw new IllegalStateException("Error starting local proxy server", e);
    }

    public void unregisterCacheListener(CacheListener r10) {
        Preconditions.checkNotNull(r10);
        Object r11 = this.clientsLock;
        monitor-enter(r11);
        Iterator<HttpProxyCacheServerClients> r12 = this.clientsMap.values().iterator();     // Catch: Throwable -> L8
    L6:
        if (r12.hasNext() == false) goto L10;
        r12.next().unregisterCacheListener(r10);     // Catch: Throwable -> L8
        goto L6
    L10:
        monitor-exit(r11);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }
}
