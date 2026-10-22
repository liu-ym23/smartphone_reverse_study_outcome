package q4;

import com.bytedance.common.utility.reflect.Reflect;
import com.bytedance.frameworks.baselib.network.http.BaseHttpRequestInfo;
import com.bytedance.frameworks.baselib.network.http.NetworkParams;
import com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient;
import com.bytedance.frameworks.baselib.network.http.cronet.impl.CronetIOException;
import com.bytedance.frameworks.baselib.network.http.cronet.impl.SsCronetHttpClient;
import com.bytedance.frameworks.baselib.network.http.exception.HttpResponseException;
import com.bytedance.retrofit2.IMetricsCollect;
import com.bytedance.retrofit2.IRequestInfo;
import com.bytedance.retrofit2.RetrofitMetrics;
import com.bytedance.retrofit2.client.SsCall;
import com.bytedance.retrofit2.mime.TypedInput;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;

/* JADX INFO: loaded from: classes.dex */
public class b implements SsCall, IMetricsCollect, IRequestInfo {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static boolean f23515k = false;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static ICronetClient f23516l;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public HttpURLConnection f23517a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public BaseHttpRequestInfo f23518b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f23519c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f23520d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public g6.b f23521e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f23522f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f23523g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public RetrofitMetrics f23524h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public volatile long f23525i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f23526j;

    public class a implements TypedInput {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ HttpURLConnection f23527a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ boolean f23528b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ b f23529c;

        public a(b r10, HttpURLConnection r11, boolean r12) {
            this.f23529c = r10;
            this.f23527a = r11;
            this.f23528b = r12;
        }

        @Override // com.bytedance.retrofit2.mime.TypedInput
        public InputStream in() {
            InputStream r10 = v4.c.f(this.f23527a.getInputStream(), this.f23527a.getHeaderFields(), this.f23528b, this.f23529c.f23524h);     // Catch: Exception -> L4
        L9:
            return new o4.b(r10, this.f23529c);
        L4:
            e = move-exception;
            if (SsCronetHttpClient.A(this.f23529c.f23518b) == false) goto L10;
            r10 = this.f23527a.getErrorStream();
            goto L9
        L10:
            String r11 = this.f23527a.getResponseMessage();
            StringBuilder r12 = new StringBuilder();
            r12.append("reason = ");
            if (r11 != null) goto L13;
            r11 = "";
        L13:
            r12.append(r11);
            r12.append("  exception = ");
            r12.append(e.getMessage());
            String r13 = r12.toString();
            throw new HttpResponseException(this.f23527a.getResponseCode(), r13);
        }

        @Override // com.bytedance.retrofit2.mime.TypedInput
        public long length() {
            return this.f23527a.getContentLength();
        }

        @Override // com.bytedance.retrofit2.mime.TypedInput
        public String mimeType() {
            return SsCronetHttpClient.q(this.f23527a, "Content-Type");
        }
    }

    static {
    }

    public b(g6.b r13, ICronetClient r14) {
        this.f23518b = BaseHttpRequestInfo.a();
        this.f23520d = null;
        this.f23522f = false;
        this.f23523g = false;
        this.f23525i = 0;
        this.f23521e = r13;
        f23516l = r14;
        String r10 = r13.D();
        this.f23517a = null;
        RetrofitMetrics r15 = r13.y();
        this.f23524h = r15;
        if (r15 == null) goto L5;
        BaseHttpRequestInfo r11 = this.f23518b;
        r11.f7164c = r15.f7900g;
        r11.f7165d = r15.f7901h;
    L5:
        long r12 = System.currentTimeMillis();
        this.f23519c = r12;
        BaseHttpRequestInfo r16 = this.f23518b;
        r16.f7166e = r12;
        r16.f7183v = 0;
        if (this.f23521e.I() == false) goto L8;
        this.f23518b.A = true;
    L10:
        if ((r13.s() instanceof o4.a) == false) goto L21;
        BaseHttpRequestInfo r17 = this.f23518b;
        r17.f7163b = (o4.a) r13.s();
        this.f23523g = this.f23518b.f7163b.f22488k;
    L21:
        this.f23517a = SsCronetHttpClient.f(r10, r13, this.f23518b, this.f23525i);     // Catch: Exception -> L14
        return;
    L14:
        e = move-exception;
        SsCronetHttpClient.L(r10, this.f23519c, this.f23518b, this.f23520d, e, this.f23517a, this.f23524h);
        this.f23522f = true;
        if ((e instanceof IOException) == false) goto L20;
        throw ((IOException) e);
    L20:
        throw new IOException(e.getMessage(), e.getCause());
    L8:
        this.f23518b.A = false;
        goto L10
    }

    private int b(boolean r10) {
        HttpURLConnection r11 = this.f23517a;
        if (r11 == null) goto L5;
        r11.disconnect();
    L5:
        String r12 = this.f23521e.D();
        HttpURLConnection r13 = SsCronetHttpClient.f(r12, this.f23521e, this.f23518b, this.f23525i);     // Catch: Exception -> L10
        this.f23517a = r13;     // Catch: Exception -> L10
        if (r10 == false) goto L13;
        this.f23518b.I = true;     // Catch: Exception -> L10
        r13.addRequestProperty("x-tt-bdturing-retry", "1");     // Catch: Exception -> L10
    L13:
        return SsCronetHttpClient.M(this.f23521e, this.f23517a);
    L10:
        e = move-exception;
        SsCronetHttpClient.L(r12, this.f23519c, this.f23518b, this.f23520d, e, this.f23517a, this.f23524h);
        this.f23522f = true;
        if ((e instanceof IOException) == false) goto L19;
        throw ((IOException) e);
    L19:
        throw new IOException(e.getMessage(), e.getCause());
    }

    private int c(int r10) {
        if (SsCronetHttpClient.a0(this.f23517a, this.f23518b, r10) == false) goto L7;
        return b(true);
    L7:
        if (this.f23518b.G == false) goto L9;
        f23515k = true;
    L9:
        return r10;
    }

    public final TypedInput a(HttpURLConnection r10, boolean r11) {
        if (r10 != null) goto L6;
        return null;
    L6:
        if (r10.getContentLength() != 0) goto L10;
        cancel();
        return null;
    L10:
        return new a(this, r10, r11);
    }

    @Override // com.bytedance.retrofit2.client.SsCall
    public void cancel() {
        HttpURLConnection r10 = this.f23517a;
        if (r10 == null) goto L16;
        r10.disconnect();
        if (this.f23521e.I() == true) goto L7;
    L14:
        this.f23522f = true;
        return;
    L7:
        if (this.f23522f == true) goto L14;
        doCollect();
        BaseHttpRequestInfo r11 = this.f23518b;
        r11.K = SsCronetHttpClient.l(this.f23526j);
        BaseHttpRequestInfo r12 = this.f23518b;
        r12.f7169h = System.currentTimeMillis();
        BaseHttpRequestInfo r13 = this.f23518b;
        o4.a r14 = r13.f7163b;
        if (r14 != null) goto L11;
    L12:
        long r15 = r13.f7169h;
        long r16 = this.f23519c;
        NetworkParams.s(r15 - r16, r16, this.f23521e.D(), this.f23520d, this.f23518b);
    L13:
        f r17 = f.a();
        String r18 = this.f23521e.D();
        BaseHttpRequestInfo r19 = this.f23518b;
        r17.c(r18, r19.f7180s, r19.f7181t, r19.K, r19.f7186y);
        goto L14
    L11:
        if (r14.f22493p == false) goto L13;
    }

    @Override // com.bytedance.retrofit2.IMetricsCollect
    public void doCollect() {
        SsCronetHttpClient.w(this.f23517a, this.f23518b, this.f23524h);
    }

    @Override // com.bytedance.retrofit2.client.SsCall
    public g6.c execute() {
        RetrofitMetrics r10 = this.f23524h;
        if (r10 == null) goto L5;
        r10.f7903j = System.currentTimeMillis();
    L5:
        String r11 = this.f23521e.D();
        if (this.f23522f == true) goto L100;
        SsCronetHttpClient.d(this.f23523g, null);
        boolean r12 = true;
        int r13 = 0;
    L18:
        e = move-exception;
        Exception r14 = e;
        int r15 = 0;
    L103:
    L72:
        th = th;
    L30:
        r13 = r15;
    L91:
        if (this.f23521e.I() == false) goto L93;
        if (r12 == true) goto L93;
    L95:
        if (this.f23521e.I() == true) goto L98;
        if (r13 == 0) goto L98;
        m4.a.c().e();
    L98:
        throw th;
    L93:
        SsCronetHttpClient.N(this.f23517a);
        goto L95
    L67:
        if ((r14 instanceof HttpResponseException) == false) goto L75;
        HttpResponseException r16 = (HttpResponseException) r14;     // Catch: Throwable -> L72
        if (r16.getStatusCode() != 304) goto L75;
        throw r16;     // Catch: Throwable -> L72
    L75:
        if ((r14 instanceof IOException) == false) goto L81;
        if ("request canceled".equals(r14.getMessage()) == false) goto L81;
        throw r14;     // Catch: Throwable -> L72
    L81:
        if ("com.ttnet.org.chromium.net.urlconnection.TTRequestCanceledException".equals(r14.getClass().getName()) == false) goto L84;
        doCollect();     // Catch: Throwable -> L72
        r13 = SsCronetHttpClient.n(this.f23517a);     // Catch: Throwable -> L72
    L84:
        if ("com.ttnet.org.chromium.net.impl.NetworkExceptionImpl".equals(r14.getClass().getName()) == false) goto L86;
    L87:
        r13 = SsCronetHttpClient.n(this.f23517a);     // Catch: Throwable -> L72
    L88:
        SsCronetHttpClient.L(r11, this.f23519c, this.f23518b, this.f23520d, r14, this.f23517a, this.f23524h);     // Catch: Throwable -> L72
        SsCronetHttpClient.d(this.f23523g, r14.getMessage());     // Catch: Throwable -> L72
        throw new CronetIOException(r14, this.f23518b, this.f23520d, r13);     // Catch: Throwable -> L72
    L86:
        if ("com.ttnet.org.chromium.net.impl.QuicExceptionImpl".equals(r14.getClass().getName()) == false) goto L88;
    L16:
        th = th;
        r12 = false;
        goto L91
    L9:
        if (this.f23521e.I() == true) goto L20;
        NetworkParams.ConnectionQualitySamplerHook r17 = NetworkParams.h();     // Catch: Throwable -> L16 Exception -> L18
        if (r17 == null) goto L20;
        if (r17.shouldSampling(r11) == false) goto L20;
        m4.a.c().d();     // Catch: Throwable -> L16 Exception -> L18
        r15 = 1;
    L108:
        int r18 = c(SsCronetHttpClient.M(this.f23521e, this.f23517a));     // Catch: Throwable -> L28 Exception -> L31
        this.f23518b.f7167f = System.currentTimeMillis();     // Catch: Throwable -> L28 Exception -> L31
        BaseHttpRequestInfo r19 = this.f23518b;     // Catch: Throwable -> L28 Exception -> L31
        r19.f7170i = -1;     // Catch: Throwable -> L28 Exception -> L31
        this.f23520d = SsCronetHttpClient.K(this.f23517a, r19, r18);     // Catch: Throwable -> L28 Exception -> L31
        this.f23526j = SsCronetHttpClient.q(this.f23517a, "Content-Type");     // Catch: Throwable -> L28 Exception -> L31
        if (this.f23521e.I() == false) goto L55;
        boolean r20 = "gzip".equalsIgnoreCase(SsCronetHttpClient.q(this.f23517a, "Content-Encoding"));     // Catch: Throwable -> L28 Exception -> L31
        ICronetClient r21 = f23516l;     // Catch: Throwable -> L28 Exception -> L31
        if (r21 == null) goto L34;
        if (r21.isCronetHttpURLConnection(this.f23517a) == false) goto L34;
        r20 = false;
    L34:
        if (r18 < 200) goto L38;
        if (r18 >= 300) goto L38;
    L39:
        TypedInput r22 = a(this.f23517a, r20);     // Catch: Throwable -> L28 Exception -> L31
    L56:
        g6.c r23 = new g6.c(r11, r18, this.f23517a.getResponseMessage(), SsCronetHttpClient.h(this.f23517a, f23515k), r22);     // Catch: Throwable -> L28 Exception -> L31
        r23.h(this.f23518b);     // Catch: Throwable -> L28 Exception -> L31
        if (this.f23521e.I() == true) goto L62;
        SsCronetHttpClient.N(this.f23517a);
    L62:
        if (this.f23521e.I() == true) goto L65;
        if (r15 == 0) goto L65;
        m4.a.c().e();
    L65:
        return r23;
    L38:
        if (SsCronetHttpClient.A(this.f23518b) == true) goto L39;
        String r24 = this.f23517a.getResponseMessage();     // Catch: Throwable -> L28 Exception -> L31
        int r25 = this.f23521e.w();     // Catch: Throwable -> L44
        InputStream r26 = this.f23517a.getInputStream();     // Catch: Throwable -> L44 Exception -> L46
    L47:
        SsCronetHttpClient.O(r20, this.f23517a.getHeaderFields(), r25, r26, this.f23526j, r11, this.f23524h);     // Catch: Throwable -> L44
    L53:
        this.f23517a.disconnect();     // Catch: Throwable -> L28 Exception -> L31
        throw new HttpResponseException(r18, r24);     // Catch: Throwable -> L28 Exception -> L31
    L46:
        r26 = this.f23517a.getErrorStream();     // Catch: Throwable -> L44
    L44:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L28 Exception -> L31
        StringBuilder r27 = new StringBuilder();     // Catch: Throwable -> L28 Exception -> L31
        r27.append("reason = ");     // Catch: Throwable -> L28 Exception -> L31
        if (r24 != null) goto L52;
        r24 = "";
    L52:
        r27.append(r24);     // Catch: Throwable -> L28 Exception -> L31
        r27.append("  exception = ");     // Catch: Throwable -> L28 Exception -> L31
        r27.append(th.getMessage());     // Catch: Throwable -> L28 Exception -> L31
        r24 = r27.toString();     // Catch: Throwable -> L28 Exception -> L31
        goto L53
    L55:
        int r28 = this.f23521e.w();     // Catch: Throwable -> L28 Exception -> L31
        this.f23518b.K = SsCronetHttpClient.l(this.f23526j);     // Catch: Throwable -> L28 Exception -> L31
        r22 = new h6.f(this.f23526j, SsCronetHttpClient.P(r11, r28, this.f23517a, this.f23519c, this.f23518b, this.f23520d, r18, this.f23524h), new String[0]);     // Catch: Throwable -> L28 Exception -> L31
    L31:
        e = move-exception;
        r14 = e;
    L28:
        th = th;
        r12 = false;
        goto L30
    L20:
        r15 = 0;
        goto L108
    L100:
        throw new IOException("request canceled");
    }

    @Override // com.bytedance.retrofit2.client.SsCall
    public g6.b getRequest() {
        return this.f23521e;
    }

    @Override // com.bytedance.retrofit2.IRequestInfo
    public Object getRequestInfo() {
        return this.f23518b;
    }

    @Override // com.bytedance.retrofit2.client.SsCall
    public boolean setThrottleNetSpeed(long r10) {
        this.f23525i = r10;
        HttpURLConnection r11 = this.f23517a;
        if (r11 != null) goto L11;
        return true;
    L11:
        Reflect.on(r11).call("setThrottleNetSpeed", new Class[]{Long.TYPE}, new Object[]{Long.valueOf(r10)});     // Catch: Throwable -> L6
        return true;
    L6:
        th = move-exception;
        th.printStackTrace();
        return false;
    }
}
