package okhttp3.internal.http;

import android.text.TextUtils;
import com.bytedance.librarian.LibrarianImpl;
import com.bytedance.retrofit2.HttpMethodContrants;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.HttpRetryException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.SocketTimeoutException;
import java.security.cert.CertificateException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocketFactory;
import okhttp3.Address;
import okhttp3.Call;
import okhttp3.CertificatePinner;
import okhttp3.EventListener;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.Route;
import okhttp3.internal.Util;
import okhttp3.internal.connection.RouteException;
import okhttp3.internal.connection.StreamAllocation;
import okhttp3.internal.http2.ConnectionShutdownException;
import okhttp3.ttnet.TTConfigManager;
import okhttp3.ttnet.TTNetDnsRetryHelper;
import okhttp3.ttnet.TTNetUtils;
import okhttp3.ttnet.TTOkHttpConstants;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
public final class RetryAndFollowUpInterceptor implements Interceptor {
    public static final String BYPASS_DOWNGRADE_COOKIE_HEADER = "x-metasec-ok-bypass-downgrade-cookie";
    private static final String COOKIE2_HEADER = "Cookie2";
    private static final String COOKIE_HEADER = "Cookie";
    private static final int MAX_FOLLOW_UPS = 20;
    private static final List<String> SAFE_STANDARD_REQUEST_HEADERS = null;
    private static final String TT_TOKEN_HEADER = "x-tt-token";
    private static final String X_SS_COOKIE_HEADER = "X-SS-Cookie";
    private Object callStackTrace;
    private volatile boolean canceled;
    private volatile int canceledReason;
    private final OkHttpClient client;
    private final boolean forWebSocket;
    private volatile boolean hasTriedForceHttpDns;
    private volatile StreamAllocation streamAllocation;

    private boolean needRedirectToPost(int r1) {
        if (r1 != 308) goto L5;
        return true;
    L5:
        if (r1 == 307) goto L11;
        return false;
    L11:
        return true;
    }

    static {
        SAFE_STANDARD_REQUEST_HEADERS = Util.immutableList(new String[]{com.google.common.net.HttpHeaders.ACCEPT, com.google.common.net.HttpHeaders.ACCEPT_CHARSET, "Accept-Encoding", com.google.common.net.HttpHeaders.ACCEPT_LANGUAGE, com.google.common.net.HttpHeaders.AUTHORIZATION, "Cache-Control", "Connection", "Content-Length", "Content-Type", "Host", com.google.common.net.HttpHeaders.IF_MATCH, "If-Modified-Since", "If-None-Match", com.google.common.net.HttpHeaders.IF_RANGE, com.google.common.net.HttpHeaders.IF_UNMODIFIED_SINCE, com.google.common.net.HttpHeaders.ORIGIN, com.google.common.net.HttpHeaders.PRAGMA, com.google.common.net.HttpHeaders.PROXY_AUTHORIZATION, "Proxy-Connection", com.google.common.net.HttpHeaders.RANGE, com.google.common.net.HttpHeaders.REFERER, "Transfer-Encoding", "User-Agent"});
    }

    public RetryAndFollowUpInterceptor(OkHttpClient r2, boolean r3) {
        this.canceledReason = TTOkHttpConstants.ERR_TTNET_UNKNOWN;
        this.hasTriedForceHttpDns = false;
        this.client = r2;
        this.forWebSocket = r3;
    }

    public void cancel(int r2) {
        this.canceledReason = r2;
        this.canceled = true;
        StreamAllocation r1 = this.streamAllocation;
        if (r1 == null) goto L6;
        r1.cancel(r2);
        return;
    }

    public boolean isCanceled() {
        return this.canceled;
    }

    public boolean canceledReason() {
        return this.canceled;
    }

    public void setCallStackTrace(Object r1) {
        this.callStackTrace = r1;
    }

    public StreamAllocation streamAllocation() {
        return this.streamAllocation;
    }

    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain r15) throws IOException {
        Request r0 = r15.request();
        RealInterceptorChain r16 = (RealInterceptorChain) r15;
        Call r7 = r16.call();
        EventListener r8 = r16.eventListener();
        StreamAllocation r9 = new StreamAllocation(this.client.connectionPool(), createAddress(r0.url()), r7, r8, this.callStackTrace);
        this.streamAllocation = r9;
        int r2 = 0;
        Response r1 = null;
    L4:
        if (this.canceled == true) goto L50;
        Response r3 = r16.proceed(r0, r9, null, null);     // Catch: Throwable -> L31 IOException -> L33 RouteException -> L42
    L6:
        if (r1 == null) goto L52;
        r3 = r3.newBuilder().priorResponse(r1.newBuilder().body(null).build()).build();
    L52:
        Request r12 = followUpRequest(r3, r9.route(), r7, r8);     // Catch: IOException -> L28
        if (r12 == null) goto L10;
        Util.closeQuietly(r3.body());
        int r13 = r2 + 1;
        if (r13 > 20) goto L26;
        if ((r12.body() instanceof UnrepeatableRequestBody) == true) goto L24;
        if (sameConnection(r3, r12.url()) == true) goto L20;
        r9.release();
        r9 = new StreamAllocation(this.client.connectionPool(), createAddress(r12.url()), r7, r8, this.callStackTrace);
        this.streamAllocation = r9;
    L21:
        r1 = r3;
        r0 = r12;
        r2 = r13;
        goto L4
    L20:
        if (r9.codec() == null) goto L21;
        throw new IllegalStateException("Closing the body of " + r3 + " didn't close its backing stream. Bad interceptor?");
    L24:
        r9.release();
        throw new HttpRetryException("Cannot retry streamed HTTP body", r3.code());
    L26:
        r9.release();
        throw new ProtocolException("Too many follow-up requests: " + r13);
    L10:
        r9.release();
        return r3;
    L28:
        e = move-exception;
        r9.release();
        throw e;
    L31:
        th = move-exception;
        r9.streamFailed(null);
        r9.release();
        throw th;
    L33:
        e = move-exception;
        if ((e instanceof ConnectionShutdownException) == true) goto L37;
        boolean r4 = true;
    L39:
        if (recover(e, r9, r4, r0) == true) goto L4;
        throw e;     // Catch: Throwable -> L31
    L37:
        r4 = false;
    L42:
        e = move-exception;
        if (recover(e.getLastConnectException(), r9, false, r0) == true) goto L4;
        throw e.getFirstConnectException();     // Catch: Throwable -> L31
    L50:
        r9.release();
        throw new IOException("Canceled#Reason=" + this.canceledReason);
    }

    private Address createAddress(HttpUrl r17) {
        if (r17.isHttps() == false) goto L5;
        SSLSocketFactory r1 = this.client.sslSocketFactory();
        SSLSocketFactory r7 = r1;
        HostnameVerifier r8 = this.client.hostnameVerifier();
        CertificatePinner r9 = this.client.certificatePinner();
    L7:
        return new Address(r17.host(), r17.port(), this.client.dns(), this.client.socketFactory(), r7, r8, r9, this.client.proxyAuthenticator(), this.client.proxy(), this.client.protocols(), this.client.connectionSpecs(), this.client.proxySelector(), this.client.ttnetDns());
    L5:
        r7 = null;
        r8 = null;
        r9 = null;
        goto L7
    }

    private boolean recover(IOException r2, StreamAllocation r3, boolean r4, Request r5) {
        r3.streamFailed(r2);
        if (this.client.retryOnConnectionFailure() == true) goto L5;
        return false;
    L5:
        if (r4 == false) goto L10;
        if (requestIsUnrepeatable(r2, r5) == false) goto L10;
        return false;
    L10:
        if (isRecoverable(r2, r4) == true) goto L14;
        return shouldRetryForceHttpDnsOnError(r2, r5);
    L14:
        if (streamAllocation().hasMoreRoutes() == false) goto L16;
        return true;
    L16:
        return shouldRetryForceHttpDnsOnError(r2, r5);
    }

    private boolean shouldRetryForceHttpDnsOnError(IOException r5, Request r6) {
        if (this.hasTriedForceHttpDns == false) goto L5;
        return false;
    L5:
        this.hasTriedForceHttpDns = true;
        int r2 = TTNetUtils.convertExceptionToErrorCode(r5);
        if (TTConfigManager.inst().shouldRetryForceHttpdnsOnError(r5, r6, r2) == false) goto L9;
        this.streamAllocation.resetRouteSelector(r2);
        TTNetDnsRetryHelper.inst().setForceHttpDns(r6, true);
        return true;
    L9:
        return false;
    }

    private boolean requestIsUnrepeatable(IOException r1, Request r2) {
        if ((r2.body() instanceof UnrepeatableRequestBody) == false) goto L5;
    L8:
        return true;
    L5:
        if ((r1 instanceof FileNotFoundException) == true) goto L8;
        return false;
    }

    private boolean isRecoverable(IOException r3, boolean r4) {
        if ((r3 instanceof ProtocolException) == false) goto L6;
        return false;
    L6:
        if ((r3 instanceof InterruptedIOException) == false) goto L13;
        if ((r3 instanceof SocketTimeoutException) == false) goto L21;
        if (r4 == false) goto L11;
        return false;
    L11:
        return true;
    L21:
        return false;
    L13:
        if ((r3 instanceof SSLHandshakeException) == false) goto L18;
        if ((r3.getCause() instanceof CertificateException) == false) goto L18;
        return false;
    L18:
        if ((r3 instanceof SSLPeerUnverifiedException) == false) goto L20;
        return false;
    L20:
        return true;
    }

    private Request followUpRequest(Response r12, Route r13, Call r14, EventListener r15) throws IOException {
        if (r12 == null) goto L88;
        int r0 = r12.code();
        String r1 = r12.request().method();
        boolean r3 = false;
        RequestBody r4 = null;
        if (r0 == 307) goto L52;
        if (r0 == 308) goto L52;
        if (r0 == 401) goto L50;
        if (r0 == 503) goto L40;
        if (r0 == 407) goto L34;
        if (r0 == 408) goto L18;
        switch(r0) {
            case 300: goto L52;
            case 301: goto L52;
            case 302: goto L52;
            case 303: goto L52;
            default: goto L16;
        };
    L16:
        return null;
    L18:
        if (this.client.retryOnConnectionFailure() == true) goto L21;
        return null;
    L21:
        if ((r12.request().body() instanceof UnrepeatableRequestBody) == false) goto L24;
        return null;
    L24:
        if (r12.priorResponse() == null) goto L29;
        if (r12.priorResponse().code() != 408) goto L29;
        return null;
    L29:
        if (retryAfter(r12, 0) <= 0) goto L32;
        return null;
    L32:
        return r12.request();
    L34:
        if (r13.proxy().type() != Proxy.Type.HTTP) goto L38;
        return this.client.proxyAuthenticator().authenticate(r13, r12);
    L38:
        throw new ProtocolException("Received HTTP_PROXY_AUTH (407) code while not using proxy");
    L40:
        if (r12.priorResponse() == null) goto L45;
        if (r12.priorResponse().code() != 503) goto L45;
        return null;
    L45:
        if (retryAfter(r12, Integer.MAX_VALUE) == 0) goto L47;
        return null;
    L47:
        return r12.request();
    L50:
        return this.client.authenticator().authenticate(r13, r12);
    L52:
        if (this.client.followRedirects() == true) goto L54;
        return null;
    L54:
        String r16 = r12.header(com.google.common.net.HttpHeaders.LOCATION);
        if (r16 != null) goto L57;
        return null;
    L57:
        HttpUrl r17 = r12.request().url().resolve(r16);
        if (r17 != null) goto L61;
        return null;
    L61:
        if (r17.scheme().equals(r12.request().url().scheme()) == false) goto L63;
    L65:
        Request.Builder r2 = r12.request().newBuilder();
        if (HttpMethod.permitsRequestBody(r1) == false) goto L83;
        if (HttpMethod.redirectsWithBody(r1) == false) goto L70;
    L71:
        r3 = true;
    L73:
        if (needRedirectToPost(r0) == false) goto L75;
    L77:
        if (r3 == false) goto L79;
        r4 = r12.request().body();
    L79:
        r2.method(r1, r4);
    L80:
        if (r3 == true) goto L83;
        r2.removeHeader("Transfer-Encoding");
        r2.removeHeader("Content-Length");
        r2.removeHeader("Content-Type");
        goto L83
    L75:
        if (HttpMethod.redirectsToGet(r1) == false) goto L77;
        r2.method(HttpMethodContrants.GET, null);
        goto L80
    L70:
        if (needRedirectToPost(r0) == false) goto L73;
    L83:
        if (sameConnection(r12, r17) == true) goto L85;
        r2.removeHeader(com.google.common.net.HttpHeaders.AUTHORIZATION);
    L85:
        handleRedirectHeaders(r14, r12.request(), r17, r2, r15);
        return r2.url(r17).build();
    L63:
        if (this.client.followSslRedirects() == true) goto L65;
        return null;
    L88:
        throw new IllegalStateException();
    }

    private int retryAfter(Response r1, int r2) {
        String r0 = r1.header(com.google.common.net.HttpHeaders.RETRY_AFTER);
        if (r0 != null) goto L6;
        return r2;
    L6:
        if (r0.matches("\\d+") == true) goto L8;
        return Integer.MAX_VALUE;
    L8:
        return Integer.valueOf(r0).intValue();
    }

    private boolean sameConnection(Response r2, HttpUrl r3) {
        HttpUrl r1 = r2.request().url();
        if (r1.host().equals(r3.host()) == true) goto L5;
    L9:
        return false;
    L5:
        if (r1.port() != r3.port()) goto L9;
        if (r1.scheme().equals(r3.scheme()) == false) goto L9;
        return true;
    }

    private void handleRedirectHeaders(Call r9, Request r10, HttpUrl r11, Request.Builder r12, EventListener r13) {
        if (r11 != null) goto L4;
        return;
    L4:
        if (TextUtils.isEmpty(r11.host()) == false) goto L6;
        return;
    L6:
        if (this.client.enableBoe() == false) goto L9;
        return;
    L9:
        if (r10.isHttps() == true) goto L13;
        if (r10.originUrl().isHttps() == true) goto L13;
    L15:
        boolean r0 = false;
    L16:
        if (r0 == false) goto L21;
        tryRemoveInsecureRequestHeader(r9, r10, r11, true, r12, r13);
        if (TTConfigManager.inCookieHostList(r11.host()) == false) goto L35;
        r12.addHeader(BYPASS_DOWNGRADE_COOKIE_HEADER, "1");
        return;
    L35:
        return;
    L21:
        if (TTConfigManager.inst().getRedirectRequestControlConfig().mOnlyControlWebview.get() == false) goto L23;
        return;
    L23:
        if (r10.url().host().equals(r11.host()) == false) goto L25;
        return;
    L25:
        if (r10.originUrl() == null) goto L30;
        if (r11.host().equals(r10.originUrl().host()) == false) goto L30;
        return;
    L30:
        if (isInSecureRedirectWhiteList(r11.host()) == true) goto L39;
        tryRemoveInsecureRequestHeader(r9, r10, r11, false, r12, r13);
        return;
    L39:
        return;
    L13:
        if (r11.isHttps() == true) goto L15;
        r0 = true;
        goto L16
    }

    private void tryRemoveInsecureRequestHeader(Call r10, Request r11, HttpUrl r12, boolean r13, Request.Builder r14, EventListener r15) {
        TTConfigManager.RedirectRequestControlConfig r8 = TTConfigManager.inst().getRedirectRequestControlConfig();
        ArrayList r7 = new ArrayList();
        boolean r3 = true;
        if (r8.mV2On.get() == false) goto L5;
        Iterator<Map.Entry<String, List<String>>> r1 = r11.headers().toMultimap().entrySet().iterator();
    L30:
        if (r1.hasNext() == false) goto L36;
        String r4 = r1.next().getKey();
        if (shouldSkipRemoveHeader(r4, r8.mKeepHeadersV2, r8.mRmStdKeepHeadersV2) == true) goto L30;
        r7.add(r4);
    L36:
        if (r7.isEmpty() == false) goto L38;
        return;
    L38:
        boolean r5 = r3 | r13;
        if (r5 == false) goto L45;
        Iterator<String> r2 = r7.iterator();
    L42:
        if (r2.hasNext() == false) goto L45;
        r14.removeHeader(r2.next());
    L45:
        if (r8.mDisableReportInsecureRedirect.get() == false) goto L47;
        return;
    L47:
        reportInsecureRequestHeader(r10, r11, r12, r15, r5, r13, r7, r8);
        return;
    L5:
        if (r8.mRmInsecureRedirectHeadersOutWhiteList.get() == true) goto L11;
        if (isInSecureRedirectBlackList(r12.host()) == true) goto L11;
        r3 = false;
    L11:
        if (TextUtils.isEmpty(r11.header(TT_TOKEN_HEADER)) == true) goto L14;
        r7.add(TT_TOKEN_HEADER);
    L14:
        if (TextUtils.isEmpty(r11.header("Cookie")) == true) goto L17;
        r7.add("Cookie");
    L17:
        if (TextUtils.isEmpty(r11.header("Cookie2")) == true) goto L20;
        r7.add("Cookie2");
    L20:
        if (TextUtils.isEmpty(r11.header("X-SS-Cookie")) == true) goto L22;
        r7.add("X-SS-Cookie");
    L22:
        Iterator<String> r6 = r8.mSecureHeaders.iterator();
    L24:
        if (r6.hasNext() == false) goto L36;
        String r9 = r6.next();
        if (TextUtils.isEmpty(r11.header(r9)) == true) goto L24;
        r7.add(r9);
        goto L24
    }

    boolean shouldSkipRemoveHeader(String r2, List<String> r3, List<String> r4) {
        if (TextUtils.isEmpty(r2) == false) goto L5;
        return true;
    L5:
        Iterator<String> r1 = r3.iterator();
    L7:
        if (r1.hasNext() == false) goto L11;
        if (r2.equalsIgnoreCase(r1.next()) == false) goto L7;
        return true;
    L11:
        Iterator<String> r5 = r4.iterator();
    L13:
        if (r5.hasNext() == false) goto L17;
        if (r2.equalsIgnoreCase(r5.next()) == false) goto L13;
        return false;
    L17:
        Iterator<String> r6 = SAFE_STANDARD_REQUEST_HEADERS.iterator();
    L19:
        if (r6.hasNext() == false) goto L23;
        if (r2.equalsIgnoreCase(r6.next()) == false) goto L19;
        return true;
    L23:
        return false;
    }

    private void reportInsecureRequestHeader(Call r5, Request r6, HttpUrl r7, EventListener r8, boolean r9, boolean r10, List<String> r11, TTConfigManager.RedirectRequestControlConfig r12) {
        JSONObject r0 = new JSONObject();     // Catch: JSONException -> L16
        r0.put("src", "ttok");     // Catch: JSONException -> L16
        if (r12.mReportFullUrl.get() == false) goto L6;
        r0.put("origin_url", r6.url());     // Catch: JSONException -> L16
        r0.put("rect_url", r7.url());     // Catch: JSONException -> L16
    L6:
        r0.put("origin_host", r6.url().scheme() + "://" + r6.url().host());     // Catch: JSONException -> L16
        r0.put("rect_host", r7.scheme() + "://" + r7.host());     // Catch: JSONException -> L16
        r0.put("origin_path", r6.url().encodedPath());     // Catch: JSONException -> L16
        r0.put("rect_path", r7.encodedPath());     // Catch: JSONException -> L16
        JSONArray r4 = new JSONArray();     // Catch: JSONException -> L16
        Iterator<String> r13 = r11.iterator();     // Catch: JSONException -> L16
    L8:
        if (r13.hasNext() == false) goto L10;
        r4.put(r13.next());     // Catch: JSONException -> L16
        goto L8
    L10:
        r0.put("scy_headers", r4);     // Catch: JSONException -> L16
        r0.put("remove_scy_header", r9);     // Catch: JSONException -> L16
        r0.put("downgrade", r10);     // Catch: JSONException -> L16
        if (r12.mV2On.get() == false) goto L13;
        r0.put("ctl_ver", "v2");     // Catch: JSONException -> L16
    L13:
        if (r8 == null) goto L22;
        r8.callInSecureRedirect(r5, r0);     // Catch: JSONException -> L16
        return;
    L22:
        return;
    L16:
        e = move-exception;
        e.printStackTrace();
    }

    private boolean isInSecureRedirectBlackList(String r6) {
        if (TextUtils.isEmpty(r6) == false) goto L5;
        return false;
    L5:
        Iterator<String> r5 = TTConfigManager.inst().getRedirectRequestControlConfig().mSecureRedirectBlackList.iterator();
    L7:
        if (r5.hasNext() == false) goto L17;
        String r1 = r5.next();
        if (r6.equals(r1) == true) goto L10;
        if (r1.startsWith(LibrarianImpl.Constants.DOT) == true) goto L15;
        r1 = LibrarianImpl.Constants.DOT + r1;
    L15:
        if (r6.toLowerCase().endsWith(r1.toLowerCase()) == false) goto L7;
        return true;
    L10:
        return true;
    L17:
        return false;
    }

    private boolean isInSecureRedirectWhiteList(String r5) {
        if (TextUtils.isEmpty(r5) == false) goto L6;
        return false;
    L6:
        Iterator<String> r4 = TTConfigManager.inst().getRedirectRequestControlConfig().mSecureRedirectWhiteList.iterator();
    L8:
        if (r4.hasNext() == false) goto L18;
        String r0 = r4.next();
        if (r5.equals(r0) == true) goto L11;
        if (r0.startsWith(LibrarianImpl.Constants.DOT) == true) goto L16;
        r0 = LibrarianImpl.Constants.DOT + r0;
    L16:
        if (r5.toLowerCase().endsWith(r0.toLowerCase()) == false) goto L8;
        return true;
    L11:
        return true;
    L18:
        TTConfigManager.inst();
        return TTConfigManager.inCookieHostList(r5);
    }

    private void removeCookieHeader(Request.Builder r1) {
        r1.removeHeader("Cookie");
        r1.removeHeader("Cookie2");
        r1.removeHeader("X-SS-Cookie");
    }
}
