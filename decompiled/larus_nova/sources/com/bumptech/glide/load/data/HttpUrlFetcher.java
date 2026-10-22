package com.bumptech.glide.load.data;

import android.text.TextUtils;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.HttpException;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.util.ContentLengthInputStream;
import com.bumptech.glide.util.GlideLogUtil;
import com.bumptech.glide.util.LogTime;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.network.okhttp.a;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Iterator;
import java.util.Map;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes39.dex */
public class HttpUrlFetcher implements DataFetcher<InputStream> {
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

        @Skip({"com.obric.assistant.network.okhttp"})
        public static URLConnection INVOKEVIRTUAL_com_bumptech_glide_load_data_HttpUrlFetcher$DefaultHttpUrlConnectionFactory_com_obric_assistant_network_okhttp_UrlConnLancet_openConnection(URL r100) throws IOException {
            String r101 = r100.getHost();     // Catch: Throwable -> L8 IOException -> L12
            String r102 = r100.getPath();     // Catch: Throwable -> L8 IOException -> L12
            if (a.c(r101, r102) == false) goto L11;
            FLogger.f375446a.i("UrlConnLancet", "openConnection drop host=" + r101 + " path=" + r102);     // Catch: Throwable -> L8 IOException -> L12
            a.b(a.a(r101, r102), r101, r102);     // Catch: Throwable -> L8 IOException -> L12
            throw new IOException("[NetGuard] dropped " + r100);     // Catch: Throwable -> L8 IOException -> L12
        L11:
            return r100.openConnection();
        L12:
            e = move-exception;
            throw e;
        L8:
            th = move-exception;
            FLogger.f375446a.e("UrlConnLancet", "openConnection intercept failed, fallback to origin: " + th.getMessage());
            goto L11
        }

        @Override // com.bumptech.glide.load.data.HttpUrlFetcher.HttpUrlConnectionFactory
        public HttpURLConnection build(URL r100) throws IOException {
            return (HttpURLConnection) INVOKEVIRTUAL_com_bumptech_glide_load_data_HttpUrlFetcher$DefaultHttpUrlConnectionFactory_com_obric_assistant_network_okhttp_UrlConnLancet_openConnection(r100);
        }
    }

    public interface HttpUrlConnectionFactory {
        HttpURLConnection build(URL r100) throws IOException;
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    public void cancel() {
        this.isCancelled = true;
    }

    static {
        DEFAULT_CONNECTION_FACTORY = new DefaultHttpUrlConnectionFactory();
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    public void cleanup() {
        InputStream r100 = this.stream;
        if (r100 != null) goto L12;
    L7:
        HttpURLConnection r101 = this.urlConnection;
        if (r101 == null) goto L10;
        r101.disconnect();
    L10:
        this.urlConnection = null;
        return;
    L12:
        r100.close();     // Catch: IOException -> L6
        goto L7
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    public Class<InputStream> getDataClass() {
        return InputStream.class;
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    public DataSource getDataSource() {
        return DataSource.REMOTE;
    }

    private InputStream getStreamForSuccessfulRequest(InputStream r100) {
        String r101 = this.urlConnection.getContentEncoding();
        int r102 = this.urlConnection.getContentLength();
        if (TextUtils.isEmpty(r101) == false) goto L5;
        this.stream = ContentLengthInputStream.obtain(r100, r102);
    L7:
        return this.stream;
    L5:
        GlideLogUtil.w(TAG, "Got non empty content encoding: " + r101);
        this.stream = r100;
        goto L7
    }

    private static boolean isHttpOk(int r100) {
        if ((r100 / 100) != 2) goto L5;
        return true;
    L5:
        return false;
    }

    private static boolean isHttpRedirect(int r100) {
        if ((r100 / 100) != 3) goto L5;
        return true;
    L5:
        return false;
    }

    public HttpUrlFetcher(GlideUrl r100, int r101) {
        this(r100, r101, DEFAULT_CONNECTION_FACTORY);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [long] */
    /* JADX WARN: Type inference failed for: r1v3, types: [double] */
    @Override // com.bumptech.glide.load.data.DataFetcher
    public void loadData(Priority r100, DataFetcher.DataCallback<? super InputStream> r101) {
        String r102 = "Finished http url fetcher fetch in ";
        long r103 = LogTime.getLogTime();
        r101.onDataReady(loadDataWithRedirects(this.glideUrl.toURL(), 0, null, this.glideUrl.getHeaders()));     // Catch: Throwable -> L5 IOException -> L7
        StringBuilder r104 = new StringBuilder("Finished http url fetcher fetch in ");
    L10:
        r103 = LogTime.getElapsedMillis(r103);
        r104.append(r103);
        r102 = r104.toString();
        GlideLogUtil.i(TAG, r102);
        return;
    L5:
        th = move-exception;
        GlideLogUtil.i(TAG, r102 + LogTime.getElapsedMillis(r103));
        throw th;
    L7:
        e = move-exception;
        GlideLogUtil.e(TAG, "Failed to load data for url", e);     // Catch: Throwable -> L5
        r101.onLoadFailed(e);     // Catch: Throwable -> L5
        r104 = new StringBuilder("Finished http url fetcher fetch in ");
        goto L10
    }

    public HttpUrlFetcher(GlideUrl r100, int r101, HttpUrlConnectionFactory r102) {
        this.glideUrl = r100;
        this.timeout = r101;
        this.connectionFactory = r102;
    }

    private InputStream loadDataWithRedirects(URL r100, int r101, URL r102, Map<String, String> r103) throws IOException {
        if (r101 >= 5) goto L37;
        if (r102 != null) goto L39;
    L10:
        this.urlConnection = this.connectionFactory.build(r100);
        Iterator<Map.Entry<String, String>> r104 = r103.entrySet().iterator();
    L12:
        if (r104.hasNext() == false) goto L14;
        Map.Entry<String, String> r105 = r104.next();
        this.urlConnection.addRequestProperty(r105.getKey(), r105.getValue());
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
        int r106 = this.urlConnection.getResponseCode();
        if (isHttpOk(r106) == false) goto L23;
        return getStreamForSuccessfulRequest(this.stream);
    L23:
        if (isHttpRedirect(r106) == false) goto L31;
        String r107 = this.urlConnection.getHeaderField("Location");
        if (TextUtils.isEmpty(r107) == true) goto L29;
        URL r108 = new URL(r100, r107);
        cleanup();
        return loadDataWithRedirects(r108, r101 + 1, r100, r103);
    L29:
        throw new HttpException("Received empty or null redirect url");
    L31:
        if (r106 != (-1)) goto L35;
        throw new HttpException(r106);
    L35:
        throw new HttpException(this.urlConnection.getResponseMessage(), r106);
    L39:
        if (r100.toURI().equals(r102.toURI()) == false) goto L10;
        throw new HttpException("In re-direct loop");     // Catch: URISyntaxException -> L38
    L37:
        throw new HttpException("Too many (> 5) redirects!");
    }
}
