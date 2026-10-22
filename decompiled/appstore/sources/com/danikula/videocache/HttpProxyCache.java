package com.danikula.videocache;

import android.text.TextUtils;
import com.danikula.videocache.file.FileCache;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Locale;

/* JADX INFO: loaded from: classes2.dex */
class HttpProxyCache extends ProxyCache {
    private static final float NO_CACHE_BARRIER = 0.2f;
    private final FileCache cache;
    private CacheListener listener;
    private final HttpUrlSource source;

    public HttpProxyCache(HttpUrlSource r10, FileCache r11) {
        super(r10, r11);
        this.cache = r11;
        this.source = r10;
    }

    private String format(String r10, Object... r11) {
        return String.format(Locale.US, r10, r11);
    }

    private boolean isUseCache(GetRequest r10) throws ProxyCacheException {
        long r11 = this.source.length();
        if (r11 <= 0) goto L5;
        boolean r12 = true;
    L6:
        long r13 = this.cache.available();
        if (r12 == false) goto L13;
        if (r10.partial == false) goto L13;
        if (r10.rangeOffset <= (r13 + (r11 * NO_CACHE_BARRIER))) goto L13;
        return false;
    L13:
        return true;
    L5:
        r12 = false;
        goto L6
    }

    private String newResponseHeaders(GetRequest r11) throws IOException, ProxyCacheException {
        String r10 = this.source.getMime();
        boolean r12 = TextUtils.isEmpty(r10);
        if (this.cache.isCompleted() == false) goto L5;
        long r13 = this.cache.available();
    L6:
        boolean r14 = false;
        if (r13 < 0) goto L9;
        boolean r15 = true;
    L10:
        boolean r16 = r11.partial;
        if (r16 == false) goto L13;
        long r17 = r13 - r11.rangeOffset;
    L14:
        if (r15 == false) goto L17;
        if (r16 == false) goto L17;
        r14 = true;
    L17:
        StringBuilder r18 = new StringBuilder();
        if (r11.partial == false) goto L20;
        String r19 = "HTTP/1.1 206 PARTIAL CONTENT\n";
    L21:
        r18.append(r19);
        r18.append("Accept-Ranges: bytes\n");
        String r20 = "";
        if (r15 == false) goto L24;
        String r21 = format("Content-Length: %d\n", new Object[]{Long.valueOf(r17)});
    L25:
        r18.append(r21);
        if (r14 == false) goto L28;
        String r110 = format("Content-Range: bytes %d-%d/%d\n", new Object[]{Long.valueOf(r11.rangeOffset), Long.valueOf(r13 - 1), Long.valueOf(r13)});
    L29:
        r18.append(r110);
        if (r12 == true) goto L32;
        r20 = format("Content-Type: %s\n", new Object[]{r10});
    L32:
        r18.append(r20);
        r18.append("\n");
        return r18.toString();
    L28:
        r110 = "";
        goto L29
    L24:
        r21 = "";
        goto L25
    L20:
        r19 = "HTTP/1.1 200 OK\n";
        goto L21
    L13:
        r17 = r13;
        goto L14
    L9:
        r15 = false;
        goto L10
    L5:
        r13 = this.source.length();
        goto L6
    }

    private void responseWithCache(OutputStream r10, long r11) throws ProxyCacheException, IOException {
        byte[] r12 = new byte[8192];
    L3:
        int r13 = read(r12, r11, 8192);
        if (r13 == (-1)) goto L6;
        r10.write(r12, 0, r13);
        r11 = r11 + ((long) r13);
        goto L3
    L6:
        r10.flush();
    }

    private void responseWithoutCache(OutputStream r10, long r11) throws ProxyCacheException, IOException {
        HttpUrlSource r12 = new HttpUrlSource(this.source);
        r12.open((int) r11);     // Catch: Throwable -> L7
        byte[] r13 = new byte[8192];     // Catch: Throwable -> L7
    L4:
        int r14 = r12.read(r13);     // Catch: Throwable -> L7
        if (r14 == (-1)) goto L9;
        r10.write(r13, 0, r14);     // Catch: Throwable -> L7
        goto L4
    L9:
        r10.flush();     // Catch: Throwable -> L7
        r12.close();
        return;
    L7:
        th = move-exception;
        r12.close();
        throw th;
    }

    @Override // com.danikula.videocache.ProxyCache
    public void onCachePercentsAvailableChanged(int r10) {
        CacheListener r11 = this.listener;
        if (r11 == null) goto L6;
        r11.onCacheAvailable(this.cache.file, this.source.getUrl(), r10);
        return;
    }

    public void processRequest(GetRequest r10, Socket r11) throws IOException, ProxyCacheException {
        BufferedOutputStream r12 = new BufferedOutputStream(r11.getOutputStream());
        r12.write(newResponseHeaders(r10).getBytes("UTF-8"));
        long r13 = r10.rangeOffset;
        if (isUseCache(r10) == false) goto L5;
        responseWithCache(r12, r13);
        return;
    L5:
        responseWithoutCache(r12, r13);
    }

    public void registerCacheListener(CacheListener r10) {
        this.listener = r10;
    }
}
