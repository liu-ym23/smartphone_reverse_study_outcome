package com.bytedance.frameworks.baselib.network.http.ok3.impl;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.NetworkUtils;
import com.bytedance.common.utility.collection.WeakHandler;
import com.bytedance.frameworks.baselib.network.http.BaseHttpRequestInfo;
import com.bytedance.frameworks.baselib.network.http.IHttpClient;
import com.bytedance.frameworks.baselib.network.http.NetworkParams;
import com.bytedance.frameworks.baselib.network.http.exception.HttpResponseException;
import com.bytedance.frameworks.baselib.network.http.exception.NetworkNotAvailabeException;
import com.bytedance.frameworks.baselib.network.http.exception.NotAllowUseNetworkException;
import com.bytedance.frameworks.baselib.network.http.ok3.impl.httpdns.IHttpDnsDepend;
import com.bytedance.frameworks.baselib.network.http.parser.MimeType;
import com.bytedance.frameworks.baselib.network.http.storeregion.StoreRegionManager;
import com.bytedance.retrofit2.IRequestInfo;
import com.bytedance.retrofit2.RetrofitMetrics;
import com.bytedance.retrofit2.client.SsCall;
import com.bytedance.retrofit2.mime.TypedInput;
import com.bytedance.retrofit2.mime.TypedOutput;
import com.ttnet.org.chromium.net.NetError;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import okhttp3.Call;
import okhttp3.EventListener;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.internal.http.HttpMethod;
import okio.BufferedSink;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class i implements IHttpClient {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile i f7419a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile boolean f7420b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile int f7421c = -1;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static volatile String f7422d = "";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Object f7423e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static int f7424f = 0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static volatile String f7425g = "";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static volatile int f7426h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static volatile String f7427i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static volatile String[] f7428j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static volatile String[] f7429k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static Context f7430l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static OkHttp3Builder f7431m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static Ok3TncBridge f7432n;

    public class a implements IHttpDnsDepend {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ i f7433a;

        public a(i r10) {
            this.f7433a = r10;
        }

        @Override // com.bytedance.frameworks.baselib.network.http.ok3.impl.httpdns.IHttpDnsDepend
        public String getAppId() {
            return String.valueOf(i.n());
        }

        @Override // com.bytedance.frameworks.baselib.network.http.ok3.impl.httpdns.IHttpDnsDepend
        public Context getContext() {
            return i.b();
        }

        @Override // com.bytedance.frameworks.baselib.network.http.ok3.impl.httpdns.IHttpDnsDepend
        public String[] getHardCodeIps() {
            return i.r();
        }

        @Override // com.bytedance.frameworks.baselib.network.http.ok3.impl.httpdns.IHttpDnsDepend
        public String getHttpDnsDomain() {
            return i.q();
        }

        @Override // com.bytedance.frameworks.baselib.network.http.ok3.impl.httpdns.IHttpDnsDepend
        public String[] getPreloadDomains() {
            return i.c();
        }
    }

    public static class b implements SsCall, IRequestInfo, WeakHandler.IHandler {

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public static boolean f7434o = false;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public OkHttpClient f7435a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public BaseHttpRequestInfo f7436b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public long f7437c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public ResponseBody f7438d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public String f7439e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public g6.b f7440f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public Request f7441g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public Response f7442h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public Call f7443i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public boolean f7444j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public RetrofitMetrics f7445k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public volatile e f7446l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public boolean f7447m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public final WeakHandler f7448n;

        public class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ b f7449a;

            public a(b r10) {
                this.f7449a = r10;
            }

            @Override // java.lang.Runnable
            public void run() {
                b r10 = this.f7449a;
                b.a(r10, r10.f7446l.o());
            }
        }

        /* JADX INFO: renamed from: com.bytedance.frameworks.baselib.network.http.ok3.impl.i$b$b, reason: collision with other inner class name */
        public static class C0096b extends RequestBody {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ MediaType f7450a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ TypedOutput f7451b;

            public C0096b(MediaType r10, TypedOutput r11) {
                this.f7450a = r10;
                this.f7451b = r11;
            }

            @Override // okhttp3.RequestBody
            public long a() {
                return this.f7451b.length();
            }

            @Override // okhttp3.RequestBody
            public MediaType b() {
                return this.f7450a;
            }

            @Override // okhttp3.RequestBody
            public void g(BufferedSink r10) {
                this.f7451b.writeTo(r10.outputStream());
            }
        }

        public class c implements TypedInput {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ ResponseBody f7452a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ Map f7453b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ boolean f7454c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final /* synthetic */ b f7455d;

            public c(b r10, ResponseBody r11, Map r12, boolean r13) {
                this.f7455d = r10;
                this.f7452a = r11;
                this.f7453b = r12;
                this.f7454c = r13;
            }

            @Override // com.bytedance.retrofit2.mime.TypedInput
            public InputStream in() {
                return new o4.b(v4.c.f(this.f7452a.byteStream(), this.f7453b, this.f7454c, this.f7455d.f7445k), this.f7455d);
            L4:
                th = move-exception;
                Response r10 = this.f7455d.f7442h;
                if (r10 == null) goto L13;
                String r11 = r10.l();
                StringBuilder r12 = new StringBuilder();
                r12.append("reason = ");
                if (r11 != null) goto L10;
                r11 = "";
            L10:
                r12.append(r11);
                r12.append("  exception = ");
                r12.append(th.getMessage());
                String r13 = r12.toString();
                throw new HttpResponseException(this.f7455d.f7442h.d(), r13);
            L13:
                throw new IOException(th);
            }

            @Override // com.bytedance.retrofit2.mime.TypedInput
            public long length() {
                return this.f7452a.contentLength();
            }

            @Override // com.bytedance.retrofit2.mime.TypedInput
            public String mimeType() {
                MediaType r10 = this.f7452a.contentType();
                if (r10 != null) goto L6;
                return null;
            L6:
                return r10.toString();
            }
        }

        static {
        }

        public b(g6.b r19) {
            this.f7435a = null;
            this.f7436b = BaseHttpRequestInfo.a();
            this.f7437c = 0;
            this.f7438d = null;
            this.f7439e = null;
            this.f7444j = false;
            this.f7445k = null;
            this.f7446l = null;
            this.f7447m = false;
            this.f7448n = new WeakHandler(com.bytedance.frameworks.baselib.network.http.ok3.impl.httpdns.b.q().k().getLooper(), this);
            this.f7435a = i.s().a(false);
            i.t(r19.s());
            this.f7440f = r19;
            String r10 = r19.D();
            RetrofitMetrics r11 = r19.y();
            this.f7445k = r11;
            if (r11 == null) goto L5;
            BaseHttpRequestInfo r12 = this.f7436b;
            r12.f7164c = r11.f7900g;
            r12.f7165d = r11.f7901h;
        L5:
            this.f7446l = new e();
            this.f7446l.B(r10, this.f7440f.x());
            long r13 = System.currentTimeMillis();
            this.f7437c = r13;
            BaseHttpRequestInfo r14 = this.f7436b;
            r14.f7166e = r13;
            r14.f7183v = 1;
            r14.f7184w = i.u();
            this.f7436b.f7185x = i.v();
            if (this.f7440f.I() == false) goto L8;
            this.f7436b.A = true;
        L54:
            OkHttpClient.Builder r15 = this.f7435a.p();     // Catch: Exception -> L18
            long r16 = NetworkParams.g();     // Catch: Exception -> L18
            TimeUnit r17 = TimeUnit.MILLISECONDS;     // Catch: Exception -> L18
            r15.e(r16, r17);     // Catch: Exception -> L18
            r15.n(NetworkParams.k(), r17);     // Catch: Exception -> L18
            r15.q(NetworkParams.k(), r17);     // Catch: Exception -> L18
            if ((r19.s() instanceof o4.a) == false) goto L34;
            this.f7436b.f7163b = (o4.a) r19.s();     // Catch: Exception -> L18
            o4.a r18 = this.f7436b.f7163b;     // Catch: Exception -> L18
            long r110 = r18.f22480c;     // Catch: Exception -> L18
            if (r110 > 0) goto L21;
            if (r18.f22481d > 0) goto L21;
            if (r18.f22482e > 0) goto L21;
        L29:
            this.f7444j = r18.f22488k;     // Catch: Exception -> L18
            if (r18.f22492o == true) goto L32;
            r15.k(false);     // Catch: Exception -> L18
        L32:
            this.f7446l.D(r18);     // Catch: Exception -> L18
        L21:
            if (r110 <= 0) goto L23;
            r15.e(r110, r17);     // Catch: Exception -> L18
        L23:
            long r111 = r18.f22482e;     // Catch: Exception -> L18
            if (r111 <= 0) goto L26;
            r15.q(r111, r17);     // Catch: Exception -> L18
        L26:
            long r112 = r18.f22481d;     // Catch: Exception -> L18
            if (r112 <= 0) goto L29;
            r15.n(r112, r17);     // Catch: Exception -> L18
        L34:
            if (this.f7435a.i() == null) goto L36;
            EventListener r20 = this.f7435a.i().create(this.f7443i);     // Catch: Exception -> L18
        L37:
            r15.i(new d(r20, this.f7446l));     // Catch: Exception -> L18
            this.f7435a = r15.c();     // Catch: Exception -> L18
            r10 = com.bytedance.frameworks.baselib.network.http.util.a.k(i.b(), f(r10, r19.x()), this.f7440f.u());     // Catch: Exception -> L18
            Request.a r21 = new Request.a().j(r10);     // Catch: Exception -> L18
            if (HttpMethod.permitsRequestBody(this.f7440f.x()) == true) goto L40;
            Request.a r22 = r21.f(this.f7440f.x(), null);     // Catch: Exception -> L18
        L41:
            List r23 = this.f7440f.u();     // Catch: Exception -> L18
            if (this.f7440f.r() == null) goto L46;
            String r24 = this.f7440f.r().md5Stub();     // Catch: Exception -> L18
            if (r24 == null) goto L46;
            r22.a("X-SS-STUB", r24);     // Catch: Exception -> L18
        L46:
            Request r25 = i.w(r22, r23);     // Catch: Exception -> L18
            this.f7441g = r25;     // Catch: Exception -> L18
            this.f7443i = this.f7435a.newCall(r25);     // Catch: Exception -> L18
            BaseHttpRequestInfo r26 = this.f7436b;     // Catch: Exception -> L18
            r26.f7187z = i.d(this.f7441g, r26);     // Catch: Exception -> L18
            return;
        L40:
            r22 = r21.f(this.f7440f.x(), d(this.f7440f.r(), this.f7440f.B()));     // Catch: Exception -> L18
            goto L41
        L36:
            r20 = null;
        L18:
            e = move-exception;
            i.e(this.f7441g, r10, this.f7437c, this.f7436b, this.f7439e, e, this.f7443i, this.f7442h, this.f7445k, this.f7446l);
            if ((e instanceof IOException) == false) goto L53;
            throw ((IOException) e);
        L53:
            throw new IOException(e.getMessage(), e.getCause());
        L8:
            this.f7436b.A = false;
            goto L54
        }

        public static /* synthetic */ void a(b r10, boolean r11) {
            r10.b(r11);
        }

        public static List c(Headers r10) {
            int r11 = r10.h();
            ArrayList r12 = new ArrayList(r11);
            int r13 = 0;
        L3:
            if (r13 >= r11) goto L13;
            String r14 = r10.d(r13);
            if (r14 != null) goto L7;
        L11:
            r12.add(new g6.a(r10.d(r13), r10.j(r13)));
        L12:
            r13 = r13 + 1;
            goto L3
        L7:
            if (r14.equalsIgnoreCase("bdturing-verify") == false) goto L11;
            if (f7434o == false) goto L11;
        L13:
            return r12;
        }

        public static RequestBody d(TypedOutput r10, RequestBody r11) {
            if (r11 == null) goto L4;
            return r11;
        L4:
            if (r10 != null) goto L8;
            return RequestBody.c(null, "body=null");
        L8:
            return new C0096b(MediaType.c(r10.mimeType()), r10);
        }

        public final void b(boolean r10) {
            if (r10 == false) goto L4;
            i.p(this.f7436b, this.f7445k, this.f7446l);
        L5:
            BaseHttpRequestInfo r11 = this.f7436b;
            o4.a r12 = r11.f7163b;
            if (r12 != null) goto L8;
        L9:
            long r13 = r11.f7169h;
            long r14 = this.f7437c;
            NetworkParams.s(r13 - r14, r14, this.f7440f.D(), this.f7439e, this.f7436b);
            return;
        L8:
            if (r12.f22493p == true) goto L9;
            return;
        L4:
            i.p(this.f7436b, this.f7445k, null);
            goto L5
        }

        @Override // com.bytedance.retrofit2.client.SsCall
        public void cancel() {
            Call r10 = this.f7443i;
            if (r10 == null) goto L14;
            r10.cancel();
            if (this.f7440f.I() == true) goto L7;
        L12:
            this.f7447m = true;
            return;
        L7:
            if (this.f7447m == true) goto L12;
            if (this.f7446l.o() == true) goto L11;
            this.f7448n.postDelayed(new a(this), 500);
            goto L12
        L11:
            b(true);
            goto L12
        }

        public final TypedInput e(ResponseBody r10, Map r11, boolean r12) {
            if (r10.contentLength() != 0) goto L7;
            return null;
        L7:
            return new c(this, r10, r11, r12);
        }

        @Override // com.bytedance.retrofit2.client.SsCall
        public g6.c execute() {
            String r11 = this.f7440f.D();
            if (i.i() == true) goto L112;
            Call r10 = this.f7443i;
            if (r10 == null) goto L12;
            if (r10.isCanceled() == false) goto L12;
            throw new IOException("request canceled");
        L12:
            if (this.f7444j == false) goto L14;
        L20:
            boolean r12 = false;
            HttpUrl r13 = null;
        L31:
            e = e;
            HttpUrl r15 = null;
            boolean r14 = false;
        L113:
        L80:
            th = th;
            r12 = r14;
            r13 = r15;
            boolean r16 = true;
        L101:
            if (this.f7440f.I() == false) goto L103;
            if (r16 == true) goto L103;
        L105:
            if (this.f7440f.I() == true) goto L108;
            if (r12 == false) goto L108;
            m4.a.c().e();
        L108:
            if (r13 == null) goto L110;
            com.bytedance.frameworks.baselib.network.http.ok3.impl.c.b().c(r13.m(), this.f7446l);
        L110:
            throw th;
        L103:
            i.f(this.f7438d);
            goto L105
        L78:
            if (i.k() == null) goto L83;
            i.k().onOk3Timeout(this.f7441g, e);     // Catch: Throwable -> L80
        L83:
            if ((e instanceof HttpResponseException) == false) goto L89;
            HttpResponseException r17 = (HttpResponseException) e;     // Catch: Throwable -> L80
            if (r17.getStatusCode() != 304) goto L89;
            throw r17;     // Catch: Throwable -> L80
        L89:
            if ((e instanceof IOException) == true) goto L91;
        L94:
            i.e(this.f7441g, r11, this.f7437c, this.f7436b, this.f7439e, e, this.f7443i, this.f7442h, this.f7445k, this.f7446l);     // Catch: Throwable -> L80
            if ((e instanceof IOException) == false) goto L99;
            throw ((IOException) e);     // Catch: Throwable -> L80
        L99:
            throw new IOException(e.getMessage(), e.getCause());     // Catch: Throwable -> L80
        L91:
            if ("Canceled".equals(e.getMessage()) == false) goto L94;
            throw e;     // Catch: Throwable -> L80
        L29:
            th = th;
            r16 = false;
            goto L101
        L22:
            if (this.f7440f.I() == true) goto L33;
            NetworkParams.ConnectionQualitySamplerHook r18 = NetworkParams.h();     // Catch: Throwable -> L29 Exception -> L31
            if (r18 == null) goto L33;
            if (r18.shouldSampling(r11) == false) goto L33;
            m4.a.c().d();     // Catch: Throwable -> L29 Exception -> L31
            r14 = true;
        L115:
            this.f7436b.B = i.g(this.f7443i.request().e());     // Catch: Throwable -> L73 Exception -> L75
            r15 = this.f7443i.request().k();     // Catch: Throwable -> L73 Exception -> L75
            if (r15 != null) goto L114;
        L43:
            this.f7442h = i.h(this.f7435a, this.f7443i);     // Catch: Throwable -> L39 Exception -> L41
            h();     // Catch: Throwable -> L39 Exception -> L41
            this.f7446l.E(this.f7442h);     // Catch: Throwable -> L39 Exception -> L41
            this.f7436b.f7167f = System.currentTimeMillis();     // Catch: Throwable -> L39 Exception -> L41
            this.f7436b.C = i.g(this.f7442h.i());     // Catch: Throwable -> L39 Exception -> L41
            this.f7439e = i.j(this.f7442h, this.f7436b);     // Catch: Throwable -> L39 Exception -> L41
            if (i.k() == null) goto L46;
            i.k().onOk3Response(this.f7441g, this.f7442h);     // Catch: Throwable -> L39 Exception -> L41
        L46:
            int r19 = this.f7442h.d();     // Catch: Throwable -> L39 Exception -> L41
            String r110 = this.f7442h.f("Content-Type");     // Catch: Throwable -> L39 Exception -> L41
            if (this.f7440f.I() == false) goto L60;
            boolean r20 = "gzip".equalsIgnoreCase(this.f7442h.f("Content-Encoding"));     // Catch: Throwable -> L39 Exception -> L41
            Map r21 = this.f7442h.i().i();     // Catch: Throwable -> L39 Exception -> L41
            if (r19 < 200) goto L53;
            if (r19 >= 300) goto L53;
        L54:
            TypedInput r22 = e(this.f7442h.a(), r21, r20);     // Catch: Throwable -> L39 Exception -> L41
        L61:
            g6.c r23 = new g6.c(r11, r19, this.f7442h.l(), c(this.f7442h.i()), r22);     // Catch: Throwable -> L39 Exception -> L41
            r23.h(this.f7436b);     // Catch: Throwable -> L39 Exception -> L41
            if (this.f7440f.I() == true) goto L67;
            i.f(this.f7438d);
        L67:
            if (this.f7440f.I() == true) goto L70;
            if (r14 == false) goto L70;
            m4.a.c().e();
        L70:
            if (r15 == null) goto L72;
            com.bytedance.frameworks.baselib.network.http.ok3.impl.c.b().c(r15.m(), this.f7446l);
        L72:
            return r23;
        L53:
            if (i.l(this.f7436b) == true) goto L54;
            String r24 = this.f7442h.l();     // Catch: Throwable -> L39 Exception -> L41
            int r25 = this.f7440f.w();     // Catch: Throwable -> L39 Exception -> L41
            ResponseBody r111 = this.f7442h.a();     // Catch: Throwable -> L39 Exception -> L41
            if (r111 == null) goto L59;
            i.m(r20, r21, r25, r111.byteStream(), r110, r11, this.f7445k);     // Catch: Throwable -> L39 Exception -> L41
            v4.c.i(r111);     // Catch: Throwable -> L39 Exception -> L41
        L59:
            throw new HttpResponseException(r19, r24);     // Catch: Throwable -> L39 Exception -> L41
        L60:
            r22 = new h6.f(r110, i.o(r11, this.f7440f.w(), this.f7442h, this.f7437c, this.f7436b, this.f7439e, this.f7445k, this.f7446l), new String[0]);     // Catch: Throwable -> L39 Exception -> L41
            goto L61
        L114:
        L41:
            e = e;
        L39:
            th = th;
            r16 = false;
            r12 = r14;
            r13 = r15;
            goto L101
        L37:
            if (TextUtils.isEmpty(r15.m()) == true) goto L43;
            this.f7446l.V = r15.m();     // Catch: Throwable -> L39 Exception -> L41
            com.bytedance.frameworks.baselib.network.http.ok3.impl.c.b().a(r15.m(), this.f7446l);     // Catch: Throwable -> L39 Exception -> L41
            goto L43
        L75:
            e = e;
            r15 = null;
        L73:
            th = th;
            r16 = false;
            r12 = r14;
            goto L101
        L33:
            r14 = false;
            goto L115
        L14:
            if (i.b() == null) goto L20;
            if (NetworkUtils.l(i.b()) == true) goto L20;
            throw new NetworkNotAvailabeException("network not available");
        L112:
            throw new NotAllowUseNetworkException("request is not allowed using network");
        }

        public final String f(String r12, String r13) {
            if (com.bytedance.frameworks.baselib.network.http.ok3.impl.urldispatcher.g.l().m() == true) goto L18;
            long r10 = System.currentTimeMillis();
            u4.c r11 = new u4.c(r12, r13);
            u4.b r14 = com.bytedance.frameworks.baselib.network.http.ok3.impl.urldispatcher.g.l().d(r11);
            long r15 = System.currentTimeMillis();
            if (r14 == null) goto L24;
            this.f7446l.p(this.f7440f.x(), r14.f24858a, r15 - r10, false, r14.f24860c);
            if (r12.equals(r14.f24858a) == false) goto L9;
            return r12;
        L9:
            if (r14.f24858a.isEmpty() == false) goto L16;
            if (r14.f24859b.isEmpty() == true) goto L16;
            this.f7446l.A(NetError.ERR_TTNET_TRAFFIC_CONTROL_DROP);
            throw new Exception("ERR_TTNET_TRAFFIC_CONTROL_DROP, -555");
        L16:
            if (com.bytedance.frameworks.baselib.network.http.util.i.f(r14.f24858a) == true) goto L27;
            return r12;
        L27:
            return r14.f24858a;
        L24:
            return r12;
        L18:
            Logger.d("SsOkHttp3Client", "fallback to host replace map");
            long r16 = System.currentTimeMillis();
            String r17 = com.bytedance.frameworks.baselib.network.http.ok3.impl.urldispatcher.g.l().k(r12);
            long r18 = System.currentTimeMillis();
            if (r12.equals(r17) == false) goto L21;
            return r12;
        L21:
            if (com.bytedance.frameworks.baselib.network.http.util.i.f(r17) == false) goto L29;
            this.f7446l.p(this.f7440f.x(), r17, r18 - r16, true, null);
            return r17;
        L29:
            return r12;
        }

        public final void g(boolean r10) {
            Call r11 = this.f7443i;
            if (r11 == null) goto L5;
            r11.cancel();
        L5:
            i.f(this.f7442h.a());
            if (r10 == false) goto L8;
            this.f7436b.I = true;
            this.f7441g = this.f7441g.h().a("x-tt-bdturing-retry", "1").b();
        L8:
            Call r12 = this.f7435a.newCall(this.f7441g);
            this.f7443i = r12;
            BaseHttpRequestInfo r13 = this.f7436b;
            r13.B = i.g(r12.request().e());
            this.f7442h = i.h(this.f7435a, this.f7443i);
        }

        @Override // com.bytedance.retrofit2.client.SsCall
        public g6.b getRequest() {
            return this.f7440f;
        }

        @Override // com.bytedance.retrofit2.IRequestInfo
        public Object getRequestInfo() {
            return this.f7436b;
        }

        public final void h() {
            Map r10 = this.f7442h.i().i();
            if (r10 != null) goto L5;
            return;
        L5:
            if (r10.containsKey("bdturing-verify") == false) goto L25;
            Request r11 = this.f7441g;
            if (r11 == null) goto L10;
            String r12 = r11.c("x-tt-bypass-bdturing");
        L12:
            if (TextUtils.isEmpty(r12) == false) goto L14;
        L16:
            long r13 = SystemClock.uptimeMillis();
            boolean r14 = NetworkParams.E(this.f7442h.d(), r10);
            BaseHttpRequestInfo r15 = this.f7436b;
            r15.H = SystemClock.uptimeMillis() - r13;
            if (r14 == false) goto L20;
            this.f7436b.G = true;
            g(true);
        L22:
            BaseHttpRequestInfo r16 = this.f7436b;
            r16.f7187z = i.d(this.f7441g, r16);
            return;
        L20:
            if (r10.containsKey("bdturing-verify") == true) goto L22;
            this.f7436b.G = true;
            f7434o = true;
            goto L22
        L14:
            if (r12.equalsIgnoreCase("1") == false) goto L16;
            return;
        L10:
            r12 = null;
            goto L12
        }

        @Override // com.bytedance.common.utility.collection.WeakHandler.IHandler
        public void handleMsg(Message r10) {
        }

        @Override // com.bytedance.retrofit2.client.SsCall
        public boolean setThrottleNetSpeed(long r10) {
            return false;
        }
    }

    static {
        f7423e = new Object();
    }

    public i(Context r10) {
        f7430l = r10.getApplicationContext();
        f7431m = new OkHttp3Builder();
        com.bytedance.frameworks.baselib.network.http.ok3.impl.urldispatcher.g.l().o(f7430l);
        com.bytedance.frameworks.baselib.network.http.ok3.impl.httpdns.b.q().B(new a(this));
    }

    public static String A(Context r10) {
        if (TextUtils.isEmpty(f7425g) == false) goto L12;
        StringBuilder r11 = new StringBuilder();
        r11.append(f7430l.getPackageName());
        r11.append('/');
        r11.append(U(f7430l));
        r11.append(" (Linux; U; Android ");
        r11.append(Build.VERSION.RELEASE);
        r11.append("; ");
        r11.append(Locale.getDefault().toString());
        String r12 = Build.MODEL;
        if (r12.length() <= 0) goto L7;
        r11.append("; ");
        r11.append(r12);
    L7:
        String r13 = Build.ID;
        if (r13.length() <= 0) goto L10;
        r11.append("; Build/");
        r11.append(r13);
    L10:
        r11.append(";");
        r11.append("tt-ok/3.10.0.2");
        r11.append(')');
        f7425g = r11.toString();
    L12:
        return f7425g;
    }

    public static int B() {
        return f7421c;
    }

    private static String C(Exception r10) {
        if (r10 != null) goto L18;
        return "";
    L18:
        String[] r11 = r10.getMessage().split("\\|");     // Catch: Throwable -> L12
        if (r11 != null) goto L8;
    L17:
        return "";
    L8:
        if (r11.length < 2) goto L17;
        if (Logger.debug() == false) goto L14;
        Logger.d("SsOkHttp3Client", "getHostAddress remoteIp = " + r11[0]);     // Catch: Throwable -> L12
    L14:
        return r11[0];
    L12:
        th = move-exception;
        th.printStackTrace();
        goto L17
    }

    public static Ok3TncBridge D() {
        return f7432n;
    }

    private static void E(String r10, BaseHttpRequestInfo r11) {
        if (com.bytedance.common.utility.e.b(r10) == true) goto L16;
        if (r11 == null) goto L18;
        if (Logger.debug() == false) goto L9;
        Logger.d("SsOkHttp3Client", "getRequestInfo remoteIp = " + r10);     // Catch: Throwable -> L13
    L9:
        r11.f7162a = r10;     // Catch: Throwable -> L13
        o4.a r12 = r11.f7163b;     // Catch: Throwable -> L13
        if (r12 == null) goto L17;
        r12.f22478a = r10;     // Catch: Throwable -> L13
        return;
    L17:
        return;
    L19:
        return;
    L18:
        return;
    }

    public static void F(BaseHttpRequestInfo r10, RetrofitMetrics r11, e r12) {
        if (r10 == null) goto L16;
        if (r11 == null) goto L17;
        r11.f7894a = r10.f7184w;
        r11.f7895b = r10.f7185x;
        r11.f7914u = SystemClock.uptimeMillis();
        r11.f7904k = System.currentTimeMillis();
        r11.O = "4.1.79.42-pico";
        r10.f7187z.put("retrofit", r11.f());     // Catch: JSONException -> L8
    L10:
        if (r12 != null) goto L12;
        return;
    L12:
        r12.C(r10, f7430l);
        return;
    L8:
        e = move-exception;
        e.printStackTrace();
        goto L10
    L17:
        return;
    }

    public static void G(int r10, String r11, String[] r12, String[] r13) {
        if (TextUtils.isEmpty(f7427i) == true) goto L5;
        return;
    L5:
        f7426h = r10;
        f7427i = r11;
        f7429k = r12;
        f7428j = r13;
    }

    public static i H(Context r10) {
        if (f7419a != null) goto L16;
        monitor-enter(i.class);
    L9:
        th = move-exception;
        throw th;
    L7:
        if (f7419a != null) goto L11;
        f7419a = new i(r10);     // Catch: Throwable -> L9
    L11:
        monitor-exit(i.class);     // Catch: Throwable -> L9
    L16:
        return f7419a;
    }

    public static String I(Response r10, BaseHttpRequestInfo r11) {
        if (r10 != null) goto L5;
        return null;
    L5:
        E(r10.f("x-net-info.remoteaddr"), r11);
        if (r11 == null) goto L11;
        o4.a r12 = r11.f7163b;
        if (r12 == null) goto L11;
        r12.f22479b = r10.d();
    L11:
        return r10.f("X-TT-LOGID");
    }

    public static Request J(Request.a r10, List r11) {
        if (r10 != null) goto L5;
        return null;
    L5:
        r10.a("Accept-Encoding", "gzip");
        boolean r12 = true;
        boolean r13 = false;
        if (r11 == null) goto L19;
        Iterator r14 = r11.iterator();
    L9:
        if (r14.hasNext() == false) goto L19;
        g6.a r15 = (g6.a) r14.next();
        if (com.bytedance.common.utility.e.b(r15.a()) == true) goto L9;
        if (com.bytedance.common.utility.e.b(r15.b()) == true) goto L9;
        if ("User-Agent".equals(r15.a()) == false) goto L18;
        r13 = true;
    L18:
        r10.d(r15.a(), r15.b());
    L19:
        if (r13 == true) goto L23;
        String r16 = NetworkParams.m();
        if (com.bytedance.common.utility.e.b(r16) == true) goto L23;
        r10.d("User-Agent", r16 + " tt-ok/3.10.0.2");
    L24:
        if (r12 == true) goto L29;
        String r17 = A(f7430l);
        if (TextUtils.isEmpty(r17) == true) goto L29;
        r10.d("User-Agent", r17);
    L29:
        return r10.b();
    L23:
        r12 = r13;
        goto L24
    }

    public static void K(Request r10, String r11, long r12, BaseHttpRequestInfo r13, String r14, Exception r15, Call r16, Response r17, RetrofitMetrics r18, e r19) {
        if (r11 == null) goto L27;
        if (r15 == null) goto L29;
        if (r13 != null) goto L25;
    L12:
        r13.f7187z.put("ex", r15.getMessage());     // Catch: Throwable -> L10
        String r20 = z(r17);     // Catch: Throwable -> L10
        if (com.bytedance.common.utility.e.b(r20) == true) goto L17;
        r13.f7187z.put("response-headers", r20);     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        th.printStackTrace();
    L17:
        if (r13 != null) goto L19;
    L21:
        long r21 = System.currentTimeMillis() - r12;
        r13.f7169h = System.currentTimeMillis();
        r13.f7184w = f7421c;
        r13.f7185x = f7422d;
        F(r13, r18, r19);
        NetworkParams.n(r11, r15, r21, r13);
        NetworkParams.q(r21, r12, r11, r14, r13, r15);
        if (r16 == null) goto L28;
        r16.cancel();
        return;
    L28:
        return;
    L19:
        if (com.bytedance.common.utility.e.b(r13.f7162a) == false) goto L21;
        E(C(r15), r13);
        goto L21
    L25:
        if (r13.f7187z != null) goto L12;
        r13.f7187z = x(r10, r13);     // Catch: Throwable -> L10
        goto L12
    L29:
        return;
    }

    public static Response L(OkHttpClient r10, Call r11) {
        if (r10 == null) goto L7;
        if (r11 != null) goto L6;
        return null;
    L6:
        return r11.execute();
    L7:
        return null;
    }

    public static void M(ResponseBody r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        v4.c.i(r10);
    }

    private static void N(boolean r10, Map r11, int r12, InputStream r13, String r14, String r15, RetrofitMetrics r16) {
        if (r13 != null) goto L4;
        return;
    L4:
        int[] r17 = new int[1];
        r17[0] = 0;     // Catch: Throwable -> L29
        byte[] r18 = v4.c.g(r10, r11, r12, r13, r17, r16);     // Catch: Throwable -> L29
        v4.c.i(r13);
        int r19 = r17[0];
        byte[] r110 = new byte[r19];
        if (r18 == null) goto L10;
        if (r19 <= 0) goto L10;
        System.arraycopy(r18, 0, r110, 0, r19);
    L10:
        if (r19 > 0) goto L12;
        return;
    L12:
        if (com.bytedance.common.utility.e.b(r14) == false) goto L14;
        return;
    L14:
        if (Logger.debug() == false) goto L38;
        MimeType r20 = new MimeType(r14);     // Catch: Throwable -> L20
        if ("text".equalsIgnoreCase(r20.getPrimaryType()) == false) goto L18;
    L22:
        String r21 = r20.getParameter("charset");     // Catch: Throwable -> L20
        if (com.bytedance.common.utility.e.b(r21) == false) goto L25;
        r21 = "utf-8";
    L25:
        Logger.d("SsOkHttp3Client", " response body = " + new String(r110, r21) + " for url = " + r15);     // Catch: Throwable -> L20
        return;
    L18:
        if ("application/json".equalsIgnoreCase(r20.getBaseType()) == true) goto L22;
        return;
    L20:
        th = move-exception;
        th.printStackTrace();
        return;
    L38:
        return;
    L29:
        th = move-exception;
        v4.c.i(r13);
        throw th;
    }

    public static byte[] O(String r17, int r18, Response r19, long r20, BaseHttpRequestInfo r22, String r23, RetrofitMetrics r24, e r25) {
        if (r19 == null) goto L5;
        int r12 = r19.d();
        ResponseBody r13 = r19.a();
        Map r14 = r19.i().i();
        boolean r15 = "gzip".equals(r19.f("Content-Encoding"));
        String r16 = r19.f("Content-Type");
        r22.f7184w = f7421c;
        r22.f7185x = f7422d;
        if (r12 != 200) goto L9;
    L19:
        if (r13 == null) goto L37;
        r22.f7168g = System.currentTimeMillis();
        InputStream r110 = r13.byteStream();
        int[] r111 = new int[1];
        r111[0] = 0;     // Catch: Throwable -> L33
        byte[] r10 = v4.c.g(r15, r14, r18, r110, r111, r24);     // Catch: Throwable -> L33
        v4.c.i(r110);
        int r11 = r111[0];
        byte[] r112 = new byte[r11];
        if (r10 == null) goto L27;
        if (r11 <= 0) goto L27;
        System.arraycopy(r10, 0, r112, 0, r11);
    L27:
        if (v4.c.k(r16) == false) goto L29;
        v4.c.a(r112, r11);
    L29:
        long r21 = System.currentTimeMillis() - r20;
        r22.f7169h = System.currentTimeMillis();
        F(r22, r24, r25);
        StoreRegionManager.m().t(r19, r17, r112);     // Catch: Throwable -> L38
    L31:
        NetworkParams.o(r17, r21, r22);
        NetworkParams.s(r21, r20, r17, r23, r22);
        return r112;
    L33:
        th = move-exception;
        v4.c.i(r110);
        throw th;
    L37:
        return new byte[0];
    L9:
        if (a(r22) == true) goto L19;
        if (r12 != 304) goto L14;
        r22.f7168g = System.currentTimeMillis();
        long r26 = System.currentTimeMillis() - r20;
        r22.f7169h = System.currentTimeMillis();
        F(r22, r24, r25);
        NetworkParams.o(r17, r26, r22);
        NetworkParams.s(r26, r20, r17, r23, r22);
    L14:
        String r27 = r19.l();
        if (r13 == null) goto L18;
        N(r15, r14, r18, r13.byteStream(), r16, r17, r24);
        v4.c.i(r13);
    L18:
        throw new HttpResponseException(r12, r27);
    L5:
        return new byte[0];
    }

    public static void P(String r10) {
        f7422d = r10;
    }

    public static void Q(int r10) {
        f7421c = r10;
    }

    public static void S(Object r10) {
        if (NetworkParams.p(r10) == true) goto L6;
        NetworkParams.I();
        return;
    }

    public static void T(Object r10) {
        NetworkParams.H();
        S(r10);
    }

    public static int U(Context r10) {
        Object r11 = f7423e;
        monitor-enter(r11);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (f7424f == 0) goto L20;
    L12:
        int r12 = f7424f;     // Catch: Throwable -> L10
        monitor-exit(r11);     // Catch: Throwable -> L10
        return r12;
    L20:
        f7424f = r10.getPackageManager().getPackageInfo(r10.getPackageName(), 0).versionCode;     // Catch: Throwable -> L10 PackageManager.NameNotFoundException -> L17
        goto L12
    }

    public static boolean a(BaseHttpRequestInfo r10) {
        if (r10 == null) goto L10;
        o4.a r11 = r10.f7163b;
        if (r11 != null) goto L6;
        return false;
    L6:
        if (r11.f22487j == false) goto L13;
        return true;
    L13:
        return false;
    L10:
        return false;
    }

    public static /* synthetic */ Context b() {
        return f7430l;
    }

    public static /* synthetic */ String[] c() {
        return f7428j;
    }

    public static /* synthetic */ JSONObject d(Request r10, BaseHttpRequestInfo r11) {
        return x(r10, r11);
    }

    public static /* synthetic */ void e(Request r10, String r11, long r12, BaseHttpRequestInfo r13, String r14, Exception r15, Call r16, Response r17, RetrofitMetrics r18, e r19) {
        K(r10, r11, r12, r13, r14, r15, r16, r17, r18, r19);
    }

    public static /* synthetic */ void f(ResponseBody r10) {
        M(r10);
    }

    public static /* synthetic */ String g(Headers r10) {
        return y(r10);
    }

    public static /* synthetic */ Response h(OkHttpClient r10, Call r11) {
        return L(r10, r11);
    }

    public static /* synthetic */ boolean i() {
        return f7420b;
    }

    public static /* synthetic */ String j(Response r10, BaseHttpRequestInfo r11) {
        return I(r10, r11);
    }

    public static /* synthetic */ Ok3TncBridge k() {
        return f7432n;
    }

    public static /* synthetic */ boolean l(BaseHttpRequestInfo r10) {
        return a(r10);
    }

    public static /* synthetic */ void m(boolean r10, Map r11, int r12, InputStream r13, String r14, String r15, RetrofitMetrics r16) {
        N(r10, r11, r12, r13, r14, r15, r16);
    }

    public static /* synthetic */ int n() {
        return f7426h;
    }

    public static /* synthetic */ byte[] o(String r10, int r11, Response r12, long r13, BaseHttpRequestInfo r14, String r15, RetrofitMetrics r16, e r17) {
        return O(r10, r11, r12, r13, r14, r15, r16, r17);
    }

    public static /* synthetic */ void p(BaseHttpRequestInfo r10, RetrofitMetrics r11, e r12) {
        F(r10, r11, r12);
    }

    public static /* synthetic */ String q() {
        return f7427i;
    }

    public static /* synthetic */ String[] r() {
        return f7429k;
    }

    public static /* synthetic */ OkHttp3Builder s() {
        return f7431m;
    }

    public static /* synthetic */ void t(Object r10) {
        T(r10);
    }

    public static /* synthetic */ int u() {
        return f7421c;
    }

    public static /* synthetic */ String v() {
        return f7422d;
    }

    public static /* synthetic */ Request w(Request.a r10, List r11) {
        return J(r10, r11);
    }

    public static JSONObject x(Request r10, BaseHttpRequestInfo r11) {
        JSONObject r12 = new JSONObject();
        if (r10 != null) goto L16;
        return r12;
    L16:
        r12.put("hc", "SsOkHttp3Client");     // Catch: Exception -> L8
        r12.put("hcv", "tt-ok/3.10.0.2");     // Catch: Exception -> L8
        r12.put("ua", r10.c("User-Agent"));     // Catch: Exception -> L8
        if (r11.G == false) goto L11;
        r12.put("turing_callback", r11.H);     // Catch: Exception -> L8
    L11:
        if (r11.I == false) goto L15;
        r12.put("turing_retry", "1");     // Catch: Exception -> L8
    L15:
        return r12;
    L8:
        e = move-exception;
        e.printStackTrace();
        goto L15
    }

    public static String y(Headers r10) {
        JSONObject r11 = new JSONObject();     // Catch: Exception -> L15
        Iterator r12 = r10.i().entrySet().iterator();     // Catch: Exception -> L15
    L4:
        if (r12.hasNext() == false) goto L17;
        Map.Entry r13 = (Map.Entry) r12.next();     // Catch: Exception -> L15
        String r14 = (String) r13.getKey();     // Catch: Exception -> L15
        List r15 = (List) r13.getValue();     // Catch: Exception -> L15
        if (TextUtils.isEmpty(r14) == true) goto L4;
        if (r15 == null) goto L4;
        if (r15.size() <= 0) goto L4;
        Iterator r16 = r15.iterator();     // Catch: Exception -> L15
    L13:
        if (r16.hasNext() == false) goto L4;
        r11.put(r14, (String) r16.next());     // Catch: Exception -> L15
        goto L13
    L17:
        return r11.toString();
    L15:
        e = move-exception;
        e.printStackTrace();
        return "";
    }

    public static String z(Response r10) {
        if (r10 != null) goto L36;
        return "";
    L36:
        Headers r11 = r10.i();     // Catch: Throwable -> L27
        if (r11 != null) goto L8;
        return "";
    L8:
        JSONObject r12 = new JSONObject();     // Catch: Throwable -> L27
        Iterator r13 = r11.e().iterator();     // Catch: Throwable -> L27
    L10:
        if (r13.hasNext() == false) goto L32;
        String r14 = (String) r13.next();     // Catch: Throwable -> L27
        if (com.bytedance.common.utility.e.b(r14) == true) goto L10;
        List r15 = r11.k(r14);     // Catch: Throwable -> L27
        if (r15 == null) goto L10;
        if (r15.isEmpty() == true) goto L10;
        StringBuilder r16 = new StringBuilder();     // Catch: Throwable -> L27
        Iterator r17 = r15.iterator();     // Catch: Throwable -> L27
        int r18 = 0;
    L21:
        if (r17.hasNext() == false) goto L31;
        String r19 = (String) r17.next();     // Catch: Throwable -> L27
        if (com.bytedance.common.utility.e.b(r19) == true) goto L21;
        if (r18 != 0) goto L29;
        r16.append(r19);     // Catch: Throwable -> L27
    L30:
        r18 = r18 + 1;     // Catch: Throwable -> L27
        goto L21
    L29:
        r16.append("; ");     // Catch: Throwable -> L27
        r16.append(r19);     // Catch: Throwable -> L27
        goto L30
    L31:
        r12.put(r14, r16.toString());     // Catch: Throwable -> L27
        goto L10
    L32:
        return r12.toString();
    L27:
        th = move-exception;
        th.printStackTrace();
        return "";
    }

    public void R(Ok3TncBridge r10) {
        f7432n = r10;
    }

    @Override // com.bytedance.retrofit2.client.Client
    public SsCall newSsCall(g6.b r10) {
        g6.b r11 = StoreRegionManager.m().d(r10);     // Catch: Throwable -> L12
        if (r11 == null) goto L5;
        r10 = r11;
    L5:
        long r12 = SystemClock.uptimeMillis();
        g6.b r13 = y4.d.e().d(r10);
        if (r10.y() == null) goto L8;
        RetrofitMetrics r14 = r10.y();
        r14.L = SystemClock.uptimeMillis() - r12;
    L8:
        if (r13 == null) goto L11;
        r10 = r13;
    L11:
        return new b(r10);
    }
}
