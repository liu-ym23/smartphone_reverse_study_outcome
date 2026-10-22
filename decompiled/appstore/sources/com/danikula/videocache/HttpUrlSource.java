package com.danikula.videocache;

import android.text.TextUtils;
import com.bytedance.keva.KevaImpl;
import com.danikula.videocache.headers.EmptyHeadersInjector;
import com.danikula.videocache.headers.HeaderInjector;
import com.danikula.videocache.sourcestorage.SourceInfoStorage;
import com.danikula.videocache.sourcestorage.SourceInfoStorageFactory;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class HttpUrlSource implements Source {
    private static final int MAX_REDIRECTS = 5;
    private HttpURLConnection connection;
    private final HeaderInjector headerInjector;
    private InputStream inputStream;
    private SourceInfo sourceInfo;
    private final SourceInfoStorage sourceInfoStorage;

    public HttpUrlSource(String r10) {
        this(r10, SourceInfoStorageFactory.newEmptySourceInfoStorage());
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v5, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v8, types: [java.net.HttpURLConnection] */
    private void fetchContentInfo() throws ProxyCacheException {
        KLog.d("Read content info from " + this.sourceInfo.url);
        ?? r10 = 0;
        InputStream r11 = null;
        HttpURLConnection r12 = openConnection(0, KevaImpl.PrivateConstants.REPORT_VALUE_SIZE_THRESHOLD);     // Catch: Throwable -> L11 IOException -> L13
        long r13 = getContentLength(r12);     // Catch: Throwable -> L7 IOException -> L9
        String r14 = r12.getContentType();     // Catch: Throwable -> L7 IOException -> L9
        r11 = r12.getInputStream();     // Catch: Throwable -> L7 IOException -> L9
        SourceInfo r15 = new SourceInfo(this.sourceInfo.url, r13, r14);     // Catch: Throwable -> L7 IOException -> L9
        this.sourceInfo = r15;     // Catch: Throwable -> L7 IOException -> L9
        this.sourceInfoStorage.put(r15.url, r15);     // Catch: Throwable -> L7 IOException -> L9
        KLog.d("Source info fetched: " + this.sourceInfo);     // Catch: Throwable -> L7 IOException -> L9
        ProxyCacheUtils.close(r11);
        r10 = r12;
    L6:
        r10.disconnect();
        return;
    L9:
        e = e;
    L15:
        KLog.e("Error fetching info from " + this.sourceInfo.url, new Object[]{e});     // Catch: Throwable -> L7
        ProxyCacheUtils.close(r11);
        r10 = r12;
        if (r12 != null) goto L6;
        return;
    L7:
        th = th;
    L20:
        ProxyCacheUtils.close(r11);
        if (r10 == 0) goto L23;
        r10.disconnect();
    L23:
        throw th;
    L13:
        e = e;
        r12 = null;
    L11:
        th = th;
        r10 = 0;
        goto L20
    }

    private long getContentLength(HttpURLConnection r10) {
        String r11 = r10.getHeaderField("Content-Length");
        if (r11 != null) goto L6;
        return -1;
    L6:
        return Long.parseLong(r11);
    }

    private void injectCustomHeaders(HttpURLConnection r10, String r11) {
        Iterator<Map.Entry<String, String>> r12 = this.headerInjector.addHeaders(r11).entrySet().iterator();
    L4:
        if (r12.hasNext() == false) goto L6;
        Map.Entry<String, String> r13 = r12.next();
        r10.setRequestProperty(r13.getKey(), r13.getValue());
        goto L4
    }

    private HttpURLConnection openConnection(long r10, int r11) throws IOException, ProxyCacheException {
        String r12 = this.sourceInfo.url;
        int r13 = 0;
    L3:
        StringBuilder r14 = new StringBuilder();
        r14.append("Open connection ");
        if (r10 <= 0) goto L6;
        String r15 = " with offset " + r10;
    L7:
        r14.append(r15);
        r14.append(" to ");
        r14.append(r12);
        KLog.d(r14.toString());
        HttpURLConnection r16 = (HttpURLConnection) new URL(r12).openConnection();
        injectCustomHeaders(r16, r12);
        if (r10 <= 0) goto L10;
        r16.setRequestProperty("Range", "bytes=" + r10 + "-");
    L10:
        if (r11 <= 0) goto L12;
        r16.setConnectTimeout(r11);
        r16.setReadTimeout(r11);
    L12:
        int r17 = r16.getResponseCode();
        if (r17 != 301) goto L15;
    L20:
        boolean r18 = true;
    L21:
        if (r18 == false) goto L24;
        r12 = r16.getHeaderField("Location");
        r13 = r13 + 1;
        r16.disconnect();
    L24:
        if (r13 > 5) goto L28;
        if (r18 == true) goto L3;
        return r16;
    L28:
        throw new ProxyCacheException("Too many redirects: " + r13);
    L15:
        if (r17 == 302) goto L20;
        if (r17 == 303) goto L20;
        r18 = false;
        goto L21
    L6:
        r15 = "";
        goto L7
    }

    private long readSourceAvailableBytes(HttpURLConnection r10, long r11, int r12) throws IOException {
        long r13 = getContentLength(r10);
        if (r12 != 200) goto L6;
        return r13;
    L6:
        if (r12 != 206) goto L9;
        return r13 + r11;
    L9:
        return this.sourceInfo.length;
    }

    @Override // com.danikula.videocache.Source
    public void close() throws ProxyCacheException {
        HttpURLConnection r10 = this.connection;
        if (r10 != null) goto L12;
        return;
    L12:
        r10.disconnect();     // Catch: ArrayIndexOutOfBoundsException -> L6 Throwable -> L8
    L15:
        return;
    L6:
        e = move-exception;
        KLog.e("Error closing connection correctly. Should happen only on Android L. If anybody know how to fix it, please visit https://github.com/danikula/AndroidVideoCache/issues/88. Until good solution is not know, just ignore this issue :(", new Object[]{e});
        return;
    L8:
        e = move-exception;
        throw new RuntimeException("Wait... but why? WTF!? Really shouldn't happen any more after fixing https://github.com/danikula/AndroidVideoCache/issues/43. If you read it on your device log, please, notify me danikula@gmail.com or create issue here https://github.com/danikula/AndroidVideoCache/issues.", e);
    }

    public synchronized String getMime() throws ProxyCacheException {
        monitor-enter(this);
    L6:
        th = move-exception;
        throw th;
    L4:
        if (TextUtils.isEmpty(this.sourceInfo.mime) == false) goto L8;
        fetchContentInfo();     // Catch: Throwable -> L6
    L8:
        String r10 = this.sourceInfo.mime;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r10;
    }

    public String getUrl() {
        return this.sourceInfo.url;
    }

    @Override // com.danikula.videocache.Source
    public synchronized long length() throws ProxyCacheException {
        monitor-enter(this);
    L6:
        th = move-exception;
        throw th;
    L4:
        if (this.sourceInfo.length != (-2147483648L)) goto L8;
        fetchContentInfo();     // Catch: Throwable -> L6
    L8:
        long r10 = this.sourceInfo.length;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r10;
    }

    @Override // com.danikula.videocache.Source
    public void open(long r10) throws ProxyCacheException {
        HttpURLConnection r11 = openConnection(r10, -1);     // Catch: IOException -> L5
        this.connection = r11;     // Catch: IOException -> L5
        String r12 = r11.getContentType();     // Catch: IOException -> L5
        this.inputStream = new BufferedInputStream(this.connection.getInputStream(), 8192);     // Catch: IOException -> L5
        HttpURLConnection r13 = this.connection;     // Catch: IOException -> L5
        SourceInfo r14 = new SourceInfo(this.sourceInfo.url, readSourceAvailableBytes(r13, r10, r13.getResponseCode()), r12);     // Catch: IOException -> L5
        this.sourceInfo = r14;     // Catch: IOException -> L5
        this.sourceInfoStorage.put(r14.url, r14);     // Catch: IOException -> L5
        return;
    L5:
        e = move-exception;
        throw new ProxyCacheException("Error opening connection for " + this.sourceInfo.url + " with offset " + r10, e);
    }

    @Override // com.danikula.videocache.Source
    public int read(byte[] r10) throws ProxyCacheException {
        InputStream r11 = this.inputStream;
        if (r11 == null) goto L15;
        return r11.read(r10, 0, r10.length);
    L8:
        e = move-exception;
        throw new InterruptedProxyCacheException("Reading source " + this.sourceInfo.url + " is interrupted", e);
    L6:
        e = move-exception;
        throw new ProxyCacheException("Error reading data from " + this.sourceInfo.url, e);
    L15:
        throw new ProxyCacheException("Error reading data from " + this.sourceInfo.url + ": connection is absent!");
    }

    public String toString() {
        return "HttpUrlSource{sourceInfo='" + this.sourceInfo + "}";
    }

    public HttpUrlSource(String r10, SourceInfoStorage r11) {
        this(r10, r11, new EmptyHeadersInjector());
    }

    public HttpUrlSource(String r10, SourceInfoStorage r11, HeaderInjector r12) {
        this.sourceInfoStorage = (SourceInfoStorage) Preconditions.checkNotNull(r11);
        this.headerInjector = (HeaderInjector) Preconditions.checkNotNull(r12);
        SourceInfo r13 = r11.get(r10);
        if (r13 != null) goto L6;
        r13 = new SourceInfo(r10, -2147483648L, ProxyCacheUtils.getSupposablyMime(r10));
    L6:
        this.sourceInfo = r13;
    }

    public HttpUrlSource(HttpUrlSource r10) {
        this.sourceInfo = r10.sourceInfo;
        this.sourceInfoStorage = r10.sourceInfoStorage;
        this.headerInjector = r10.headerInjector;
    }
}
