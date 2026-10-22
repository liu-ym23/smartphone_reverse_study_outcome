package com.bumptech.glide.load.data;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.HttpException;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.util.ContentLengthInputStream;
import com.bumptech.glide.util.LogTime;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class HttpUrlFetcher implements DataFetcher<InputStream> {

    @VisibleForTesting
    static final HttpUrlConnectionFactory DEFAULT_CONNECTION_FACTORY = null;
    private static final int INVALID_STATUS_CODE = -1;
    private static final int MAXIMUM_REDIRECTS = 5;
    private static final String TAG = "HttpUrlFetcher";
    private final HttpUrlConnectionFactory connectionFactory;
    private final GlideUrl glideUrl;
    private volatile boolean isCancelled;
    private InputStream stream;
    private final int timeout;
    private HttpURLConnection urlConnection;

    public static class DefaultHttpUrlConnectionFactory implements HttpUrlConnectionFactory {
        public DefaultHttpUrlConnectionFactory() {
        }

        @Override // com.bumptech.glide.load.data.HttpUrlFetcher.HttpUrlConnectionFactory
        public HttpURLConnection build(URL r10) throws IOException {
            return (HttpURLConnection) r10.openConnection();
        }
    }

    public interface HttpUrlConnectionFactory {
        HttpURLConnection build(URL r10) throws IOException;
    }

    static {
        DEFAULT_CONNECTION_FACTORY = new DefaultHttpUrlConnectionFactory();
    }

    public HttpUrlFetcher(GlideUrl r10, int r11) {
        this(r10, r11, DEFAULT_CONNECTION_FACTORY);
    }

    private InputStream getStreamForSuccessfulRequest(HttpURLConnection r10) throws IOException {
        if (TextUtils.isEmpty(r10.getContentEncoding()) == false) goto L6;
        this.stream = ContentLengthInputStream.obtain(r10.getInputStream(), r10.getContentLength());
    L10:
        return this.stream;
    L6:
        if (Log.isLoggable(TAG, 3) == false) goto L8;
        Log.d(TAG, "Got non empty content encoding: " + r10.getContentEncoding());
    L8:
        this.stream = r10.getInputStream();
        goto L10
    }

    private static boolean isHttpOk(int r10) {
        if ((r10 / 100) != 2) goto L5;
        return true;
    L5:
        return false;
    }

    private static boolean isHttpRedirect(int r10) {
        if ((r10 / 100) != 3) goto L5;
        return true;
    L5:
        return false;
    }

    private InputStream loadDataWithRedirects(URL r10, int r11, URL r12, Map<String, String> r13) throws IOException {
        if (r11 >= 5) goto L37;
        if (r12 != null) goto L39;
    L10:
        this.urlConnection = this.connectionFactory.build(r10);
        Iterator<Map.Entry<String, String>> r14 = r13.entrySet().iterator();
    L12:
        if (r14.hasNext() == false) goto L14;
        Map.Entry<String, String> r15 = r14.next();
        this.urlConnection.addRequestProperty(r15.getKey(), r15.getValue());
        goto L12
    L14:
        this.urlConnection.setConnectTimeout(this.timeout);
        this.urlConnection.setReadTimeout(this.timeout);
        this.urlConnection.setUseCaches(false);
        this.urlConnection.setDoInput(true);
        this.urlConnection.setInstanceFollowRedirects(false);
        this.urlConnection.connect();
        this.stream = this.urlConnection.getInputStream();
        if (this.isCancelled == false) goto L18;
        return null;
    L18:
        int r16 = this.urlConnection.getResponseCode();
        if (isHttpOk(r16) == false) goto L23;
        return getStreamForSuccessfulRequest(this.urlConnection);
    L23:
        if (isHttpRedirect(r16) == false) goto L31;
        String r17 = this.urlConnection.getHeaderField("Location");
        if (TextUtils.isEmpty(r17) == true) goto L29;
        URL r18 = new URL(r10, r17);
        cleanup();
        return loadDataWithRedirects(r18, r11 + 1, r10, r13);
    L29:
        throw new HttpException("Received empty or null redirect url");
    L31:
        if (r16 != (-1)) goto L35;
        throw new HttpException(r16);
    L35:
        throw new HttpException(this.urlConnection.getResponseMessage(), r16);
    L39:
        if (r10.toURI().equals(r12.toURI()) == false) goto L10;
        throw new HttpException("In re-direct loop");     // Catch: URISyntaxException -> L38
    L37:
        throw new HttpException("Too many (> 5) redirects!");
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    public void cancel() {
        this.isCancelled = true;
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    public void cleanup() {
        InputStream r10 = this.stream;
        if (r10 != null) goto L11;
    L5:
        HttpURLConnection r11 = this.urlConnection;
        if (r11 == null) goto L8;
        r11.disconnect();
    L8:
        this.urlConnection = null;
        return;
    L11:
        r10.close();     // Catch: IOException -> L10
        goto L5
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    @NonNull
    public Class<InputStream> getDataClass() {
        return InputStream.class;
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    @NonNull
    public DataSource getDataSource() {
        return DataSource.REMOTE;
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    public void loadData(@NonNull Priority r10, @NonNull DataFetcher.DataCallback<? super InputStream> r11) {
        long r12 = LogTime.getLogTime();
        r11.onDataReady(loadDataWithRedirects(this.glideUrl.toURL(), 0, null, this.glideUrl.getHeaders()));     // Catch: Throwable -> L8 IOException -> L10
    L5:
        if (Log.isLoggable(TAG, 2) == false) goto L19;
        StringBuilder r13 = new StringBuilder();
    L7:
        r13.append("Finished http url fetcher fetch in ");
        r13.append(LogTime.getElapsedMillis(r12));
        Log.v(TAG, r13.toString());
        return;
    L19:
        return;
    L8:
        th = move-exception;
        if (Log.isLoggable(TAG, 2) == false) goto L23;
        Log.v(TAG, "Finished http url fetcher fetch in " + LogTime.getElapsedMillis(r12));
    L23:
        throw th;
    L10:
        e = move-exception;
        if (Log.isLoggable(TAG, 3) == false) goto L15;
        Log.d(TAG, "Failed to load data for url", e);     // Catch: Throwable -> L8
    L15:
        r11.onLoadFailed(e);     // Catch: Throwable -> L8
        if (Log.isLoggable(TAG, 2) == false) goto L27;
        r13 = new StringBuilder();
        goto L7
    }

    @VisibleForTesting
    public HttpUrlFetcher(GlideUrl r10, int r11, HttpUrlConnectionFactory r12) {
        this.glideUrl = r10;
        this.timeout = r11;
        this.connectionFactory = r12;
    }
}
