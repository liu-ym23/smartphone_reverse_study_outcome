package com.danikula.videocache;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.Socket;
import java.net.URI;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
class Pinger {
    private static final String PING_REQUEST = "ping";
    private static final String PING_RESPONSE = "ping ok";
    private final String host;
    private final ExecutorService pingExecutor;
    private final int port;

    /* JADX INFO: renamed from: com.danikula.videocache.Pinger$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public class PingCallable implements Callable<Boolean> {
        final /* synthetic */ Pinger this$0;

        private PingCallable(Pinger r10) {
            this.this$0 = r10;
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Boolean call() throws Exception {
            return call();
        }

        public /* synthetic */ PingCallable(Pinger r10, AnonymousClass1 r11) {
            this(r10);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public Boolean call() throws Exception {
            return Boolean.valueOf(Pinger.access$100(this.this$0));
        }
    }

    public Pinger(String r10, int r11) {
        this.pingExecutor = Executors.newSingleThreadExecutor();
        this.host = (String) Preconditions.checkNotNull(r10);
        this.port = r11;
    }

    public static /* synthetic */ boolean access$100(Pinger r10) throws ProxyCacheException {
        return r10.pingServer();
    }

    private List<Proxy> getDefaultProxies() {
        return ProxySelector.getDefault().select(new URI(getPingUrl()));
    L4:
        e = move-exception;
        throw new IllegalStateException(e);
    }

    private String getPingUrl() {
        return String.format(Locale.US, "http://%s:%d/%s", new Object[]{this.host, Integer.valueOf(this.port), PING_REQUEST});
    }

    private boolean pingServer() throws ProxyCacheException {
        HttpUrlSource r10 = new HttpUrlSource(getPingUrl());
        byte[] r11 = PING_RESPONSE.getBytes();     // Catch: Throwable -> L6 ProxyCacheException -> L8
        r10.open(0);     // Catch: Throwable -> L6 ProxyCacheException -> L8
        byte[] r12 = new byte[r11.length];     // Catch: Throwable -> L6 ProxyCacheException -> L8
        r10.read(r12);     // Catch: Throwable -> L6 ProxyCacheException -> L8
        boolean r13 = Arrays.equals(r11, r12);     // Catch: Throwable -> L6 ProxyCacheException -> L8
        KLog.i("Ping response: `" + new String(r12) + "`, pinged? " + r13);     // Catch: Throwable -> L6 ProxyCacheException -> L8
        r10.close();
        return r13;
    L6:
        th = move-exception;
        r10.close();
        throw th;
    L8:
        e = move-exception;
        KLog.e("Error reading ping response", new Object[]{e});     // Catch: Throwable -> L6
        r10.close();
        return false;
    }

    public boolean isPingRequest(String r10) {
        return PING_REQUEST.equals(r10);
    }

    public boolean ping(int r10, int r11) {
        if (r10 < 1) goto L5;
        boolean r12 = true;
    L6:
        Preconditions.checkArgument(r12);
        if (r11 <= 0) goto L9;
        boolean r13 = true;
    L10:
        Preconditions.checkArgument(r13);
        int r14 = 0;
    L11:
        if (r14 >= r10) goto L19;
        if (((Boolean) this.pingExecutor.submit(new PingCallable(this, null)).get(r11, TimeUnit.MILLISECONDS)).booleanValue() == false) goto L18;
        return true;
    L18:
        r14 = r14 + 1;
        r11 = r11 * 2;
        goto L11
    L15:
        e = move-exception;
        KLog.e("Error pinging server due to unexpected error", new Object[]{e});
    L17:
        KLog.w("Error pinging server (attempt: " + r14 + ", timeout: " + r11 + "). ");
        goto L18
    L19:
        String r15 = String.format(Locale.US, "Error pinging server (attempts: %d, max timeout: %d). If you see this message, please, report at https://github.com/danikula/AndroidVideoCache/issues/134. Default proxies are: %s", new Object[]{Integer.valueOf(r14), Integer.valueOf(r11 / 2), getDefaultProxies()});
        KLog.e(r15, new Object[]{new ProxyCacheException(r15)});
        return false;
    L9:
        r13 = false;
        goto L10
    L5:
        r12 = false;
        goto L6
    }

    public void responseToPing(Socket r10) throws IOException {
        OutputStream r11 = r10.getOutputStream();
        r11.write("HTTP/1.1 200 OK\n\n".getBytes());
        r11.write(PING_RESPONSE.getBytes());
    }
}
