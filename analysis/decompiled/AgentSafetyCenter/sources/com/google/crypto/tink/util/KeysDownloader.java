package com.google.crypto.tink.util;

import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpHeaders;
import com.google.api.client.http.HttpResponse;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import g5.f;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.Locale;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.annotation.concurrent.GuardedBy;
import org.joda.time.Instant;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public class KeysDownloader {
    private final Executor backgroundExecutor;

    @GuardedBy("instanceStateLock")
    private long cacheExpirationDurationInMillis;

    @GuardedBy("instanceStateLock")
    private String cachedData;

    @GuardedBy("instanceStateLock")
    private long cachedTimeInMillis;
    private final Object fetchDataLock;
    private final HttpTransport httpTransport;
    private final Object instanceStateLock;

    @GuardedBy("instanceStateLock")
    private Runnable pendingRefreshRunnable;
    private final String url;
    private static final Charset UTF_8 = Charset.forName("UTF-8");
    private static final NetHttpTransport DEFAULT_HTTP_TRANSPORT = new NetHttpTransport.Builder().build();
    private static final Executor DEFAULT_BACKGROUND_EXECUTOR = Executors.newCachedThreadPool();
    private static final Pattern MAX_AGE_PATTERN = Pattern.compile("\\s*max-age\\s*=\\s*(\\d+)\\s*");

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public static class Builder {
        private String url;
        private HttpTransport httpTransport = KeysDownloader.DEFAULT_HTTP_TRANSPORT;
        private Executor executor = KeysDownloader.DEFAULT_BACKGROUND_EXECUTOR;

        public KeysDownloader build() {
            if (this.url != null) {
                return new KeysDownloader(this.executor, this.httpTransport, this.url);
            }
            f.s("must provide a url with {#setUrl}");
            return null;
        }

        public Builder setExecutor(Executor executor) {
            this.executor = executor;
            return this;
        }

        public Builder setHttpTransport(HttpTransport httpTransport) {
            this.httpTransport = httpTransport;
            return this;
        }

        public Builder setUrl(String str) {
            this.url = str;
            return this;
        }
    }

    public KeysDownloader(Executor executor, HttpTransport httpTransport, String str) {
        validate(str);
        this.backgroundExecutor = executor;
        this.httpTransport = httpTransport;
        this.instanceStateLock = new Object();
        this.fetchDataLock = new Object();
        this.url = str;
        this.cachedTimeInMillis = Long.MIN_VALUE;
        this.cacheExpirationDurationInMillis = 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @GuardedBy("fetchDataLock")
    public String fetchAndCacheData() throws IOException {
        long currentTimeInMillis = getCurrentTimeInMillis();
        HttpResponse httpResponseExecute = this.httpTransport.createRequestFactory().buildGetRequest(new GenericUrl(this.url)).execute();
        if (httpResponseExecute.getStatusCode() != 200) {
            f.e(httpResponseExecute.getStatusCode(), "Unexpected status code = ");
            return null;
        }
        InputStream content = httpResponseExecute.getContent();
        try {
            String str = readerToString(new InputStreamReader(content, UTF_8));
            content.close();
            synchronized (this.instanceStateLock) {
                this.cachedTimeInMillis = currentTimeInMillis;
                this.cacheExpirationDurationInMillis = getExpirationDurationInSeconds(httpResponseExecute.getHeaders()) * 1000;
                this.cachedData = str;
            }
            return str;
        } catch (Throwable th) {
            content.close();
            throw th;
        }
    }

    @GuardedBy("instanceStateLock")
    private boolean hasNonExpiredDataCached() {
        long currentTimeInMillis = getCurrentTimeInMillis();
        long j10 = this.cachedTimeInMillis;
        return j10 + this.cacheExpirationDurationInMillis > currentTimeInMillis && !((j10 > currentTimeInMillis ? 1 : (j10 == currentTimeInMillis ? 0 : -1)) > 0);
    }

    private Runnable newRefreshRunnable() {
        return new Runnable() { // from class: com.google.crypto.tink.util.KeysDownloader.1
            /* JADX WARN: Code restructure failed: missing block: B:17:0x0028, code lost:
            
                r5 = move-exception;
             */
            /* JADX WARN: Code restructure failed: missing block: B:25:0x0040, code lost:
            
                r5 = move-exception;
             */
            /* JADX WARN: Code restructure failed: missing block: B:30:0x0045, code lost:
            
                throw r5;
             */
            /* JADX WARN: Code restructure failed: missing block: B:44:0x0063, code lost:
            
                throw r5;
             */
            @Override // java.lang.Runnable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public void run() {
                /*
                    r5 = this;
                    com.google.crypto.tink.util.KeysDownloader r0 = com.google.crypto.tink.util.KeysDownloader.this
                    java.lang.Object r0 = com.google.crypto.tink.util.KeysDownloader.access$000(r0)
                    monitor-enter(r0)
                    r1 = 0
                    com.google.crypto.tink.util.KeysDownloader r2 = com.google.crypto.tink.util.KeysDownloader.this     // Catch: java.lang.Throwable -> L2a java.io.IOException -> L46
                    com.google.crypto.tink.util.KeysDownloader.access$100(r2)     // Catch: java.lang.Throwable -> L2a java.io.IOException -> L46
                    com.google.crypto.tink.util.KeysDownloader r2 = com.google.crypto.tink.util.KeysDownloader.this     // Catch: java.lang.Throwable -> L28
                    java.lang.Object r2 = com.google.crypto.tink.util.KeysDownloader.access$200(r2)     // Catch: java.lang.Throwable -> L28
                    monitor-enter(r2)     // Catch: java.lang.Throwable -> L28
                    com.google.crypto.tink.util.KeysDownloader r3 = com.google.crypto.tink.util.KeysDownloader.this     // Catch: java.lang.Throwable -> L22
                    java.lang.Runnable r3 = com.google.crypto.tink.util.KeysDownloader.access$300(r3)     // Catch: java.lang.Throwable -> L22
                    if (r3 != r5) goto L24
                    com.google.crypto.tink.util.KeysDownloader r5 = com.google.crypto.tink.util.KeysDownloader.this     // Catch: java.lang.Throwable -> L22
                    com.google.crypto.tink.util.KeysDownloader.access$302(r5, r1)     // Catch: java.lang.Throwable -> L22
                    goto L24
                L22:
                    r5 = move-exception
                    goto L26
                L24:
                    monitor-exit(r2)     // Catch: java.lang.Throwable -> L22
                    goto L5e
                L26:
                    monitor-exit(r2)     // Catch: java.lang.Throwable -> L22
                    throw r5     // Catch: java.lang.Throwable -> L28
                L28:
                    r5 = move-exception
                    goto L62
                L2a:
                    r2 = move-exception
                    com.google.crypto.tink.util.KeysDownloader r3 = com.google.crypto.tink.util.KeysDownloader.this     // Catch: java.lang.Throwable -> L28
                    java.lang.Object r3 = com.google.crypto.tink.util.KeysDownloader.access$200(r3)     // Catch: java.lang.Throwable -> L28
                    monitor-enter(r3)     // Catch: java.lang.Throwable -> L28
                    com.google.crypto.tink.util.KeysDownloader r4 = com.google.crypto.tink.util.KeysDownloader.this     // Catch: java.lang.Throwable -> L40
                    java.lang.Runnable r4 = com.google.crypto.tink.util.KeysDownloader.access$300(r4)     // Catch: java.lang.Throwable -> L40
                    if (r4 != r5) goto L42
                    com.google.crypto.tink.util.KeysDownloader r5 = com.google.crypto.tink.util.KeysDownloader.this     // Catch: java.lang.Throwable -> L40
                    com.google.crypto.tink.util.KeysDownloader.access$302(r5, r1)     // Catch: java.lang.Throwable -> L40
                    goto L42
                L40:
                    r5 = move-exception
                    goto L44
                L42:
                    monitor-exit(r3)     // Catch: java.lang.Throwable -> L40
                    throw r2     // Catch: java.lang.Throwable -> L28
                L44:
                    monitor-exit(r3)     // Catch: java.lang.Throwable -> L40
                    throw r5     // Catch: java.lang.Throwable -> L28
                L46:
                    com.google.crypto.tink.util.KeysDownloader r2 = com.google.crypto.tink.util.KeysDownloader.this     // Catch: java.lang.Throwable -> L28
                    java.lang.Object r2 = com.google.crypto.tink.util.KeysDownloader.access$200(r2)     // Catch: java.lang.Throwable -> L28
                    monitor-enter(r2)     // Catch: java.lang.Throwable -> L28
                    com.google.crypto.tink.util.KeysDownloader r3 = com.google.crypto.tink.util.KeysDownloader.this     // Catch: java.lang.Throwable -> L5b
                    java.lang.Runnable r3 = com.google.crypto.tink.util.KeysDownloader.access$300(r3)     // Catch: java.lang.Throwable -> L5b
                    if (r3 != r5) goto L5d
                    com.google.crypto.tink.util.KeysDownloader r5 = com.google.crypto.tink.util.KeysDownloader.this     // Catch: java.lang.Throwable -> L5b
                    com.google.crypto.tink.util.KeysDownloader.access$302(r5, r1)     // Catch: java.lang.Throwable -> L5b
                    goto L5d
                L5b:
                    r5 = move-exception
                    goto L60
                L5d:
                    monitor-exit(r2)     // Catch: java.lang.Throwable -> L5b
                L5e:
                    monitor-exit(r0)     // Catch: java.lang.Throwable -> L28
                    return
                L60:
                    monitor-exit(r2)     // Catch: java.lang.Throwable -> L5b
                    throw r5     // Catch: java.lang.Throwable -> L28
                L62:
                    monitor-exit(r0)     // Catch: java.lang.Throwable -> L28
                    throw r5
                */
                throw new UnsupportedOperationException("Method not decompiled: com.google.crypto.tink.util.KeysDownloader.AnonymousClass1.run():void");
            }
        };
    }

    private static String readerToString(Reader reader) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(reader);
        StringBuilder sb2 = new StringBuilder();
        while (true) {
            int i = bufferedReader.read();
            if (i == -1) {
                return sb2.toString();
            }
            sb2.append((char) i);
        }
    }

    @GuardedBy("instanceStateLock")
    private boolean shouldProactivelyRefreshDataInBackground() {
        return (this.cacheExpirationDurationInMillis / 2) + this.cachedTimeInMillis <= getCurrentTimeInMillis();
    }

    private static void validate(String str) {
        try {
            if (new URL(str).getProtocol().toLowerCase(Locale.US).equals("https")) {
            } else {
                throw new IllegalArgumentException("url must point to a HTTPS server");
            }
        } catch (MalformedURLException e10) {
            throw new IllegalArgumentException(e10);
        }
    }

    public String download() {
        synchronized (this.instanceStateLock) {
            try {
                if (hasNonExpiredDataCached()) {
                    if (shouldProactivelyRefreshDataInBackground()) {
                        refreshInBackground();
                    }
                    return this.cachedData;
                }
                synchronized (this.fetchDataLock) {
                    synchronized (this.instanceStateLock) {
                        if (hasNonExpiredDataCached()) {
                            return this.cachedData;
                        }
                        return fetchAndCacheData();
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public long getCurrentTimeInMillis() {
        return Instant.now().getMillis();
    }

    public long getExpirationDurationInSeconds(HttpHeaders httpHeaders) {
        long jLongValue;
        if (httpHeaders.getCacheControl() != null) {
            for (String str : httpHeaders.getCacheControl().split(",")) {
                Matcher matcher = MAX_AGE_PATTERN.matcher(str);
                if (matcher.matches()) {
                    jLongValue = Long.valueOf(matcher.group(1)).longValue();
                    break;
                }
            }
            jLongValue = 0;
        } else {
            jLongValue = 0;
        }
        if (httpHeaders.getAge() != null) {
            jLongValue -= httpHeaders.getAge().longValue();
        }
        return Math.max(0L, jLongValue);
    }

    public HttpTransport getHttpTransport() {
        return this.httpTransport;
    }

    public String getUrl() {
        return this.url;
    }

    public void refreshInBackground() {
        Runnable runnableNewRefreshRunnable = newRefreshRunnable();
        synchronized (this.instanceStateLock) {
            try {
                if (this.pendingRefreshRunnable != null) {
                    return;
                }
                this.pendingRefreshRunnable = runnableNewRefreshRunnable;
                try {
                    this.backgroundExecutor.execute(runnableNewRefreshRunnable);
                } catch (Throwable th) {
                    synchronized (this.instanceStateLock) {
                        try {
                            if (this.pendingRefreshRunnable == runnableNewRefreshRunnable) {
                                this.pendingRefreshRunnable = null;
                            }
                            throw th;
                        } finally {
                        }
                    }
                }
            } finally {
            }
        }
    }
}
