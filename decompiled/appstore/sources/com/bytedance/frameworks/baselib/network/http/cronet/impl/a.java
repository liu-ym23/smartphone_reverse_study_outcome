package com.bytedance.frameworks.baselib.network.http.cronet.impl;

import android.net.Uri;
import android.os.HandlerThread;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.collection.WeakHandler;
import com.bytedance.common.utility.reflect.Reflect;
import com.bytedance.frameworks.baselib.network.dispatcher.IRequest;
import com.bytedance.frameworks.baselib.network.http.BaseHttpRequestInfo;
import com.bytedance.frameworks.baselib.network.http.NetworkParams;
import com.bytedance.frameworks.baselib.network.http.exception.HttpResponseException;
import com.bytedance.frameworks.baselib.network.http.exception.NetworkNotAvailabeException;
import com.bytedance.retrofit2.IMetricsCollect;
import com.bytedance.retrofit2.IRequestInfo;
import com.bytedance.retrofit2.RetrofitMetrics;
import com.bytedance.retrofit2.client.SsCall;
import com.bytedance.retrofit2.mime.TypedInput;
import com.bytedanceos.common.toolbox.ServerElements;
import com.ss.android.ugc.quota.tag.BDNetworkTagLaunchType;
import com.ttnet.org.chromium.net.impl.NetworkExceptionImpl;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import q4.f;
import v4.c;

/* JADX INFO: loaded from: classes.dex */
public class a implements SsCall, IMetricsCollect, IRequestInfo, WeakHandler.IHandler {
    public static final String A = "a";
    public static HandlerThread B;
    public static boolean C;
    public static Class D;
    public static boolean E;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public RetrofitMetrics f7245a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile long f7246b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f7247c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f7248d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public volatile boolean f7249e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public g6.b f7250f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f7251g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f7252h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public BaseHttpRequestInfo f7253i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f7254j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f7255k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public List f7256l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Object f7257m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public volatile AtomicInteger f7258n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public List f7259o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public volatile boolean f7260p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public volatile HttpURLConnection f7261q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public volatile HttpURLConnection f7262r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public List f7263s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public volatile int f7264t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public CountDownLatch f7265u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public WeakHandler f7266v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public long f7267w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f7268x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public long f7269y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public String f7270z;

    /* JADX INFO: renamed from: com.bytedance.frameworks.baselib.network.http.cronet.impl.a$a, reason: collision with other inner class name */
    public class C0094a implements TypedInput {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ HttpURLConnection f7271a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ a f7272b;

        public C0094a(a r10, HttpURLConnection r11) {
            this.f7272b = r10;
            this.f7271a = r11;
        }

        @Override // com.bytedance.retrofit2.mime.TypedInput
        public InputStream in() {
            InputStream r10 = c.f(this.f7271a.getInputStream(), this.f7271a.getHeaderFields(), false, a.c(this.f7272b));     // Catch: Exception -> L4
        L9:
            return new o4.b(r10, this.f7272b);
        L4:
            e = move-exception;
            if (SsCronetHttpClient.A(a.d(this.f7272b)) == false) goto L10;
            r10 = this.f7271a.getErrorStream();
            goto L9
        L10:
            String r11 = this.f7271a.getResponseMessage();
            StringBuilder r12 = new StringBuilder();
            r12.append("reason = ");
            if (r11 != null) goto L13;
            r11 = "";
        L13:
            r12.append(r11);
            r12.append("  exception = ");
            r12.append(e.getMessage());
            String r13 = r12.toString();
            throw new HttpResponseException(this.f7271a.getResponseCode(), r13);
        }

        @Override // com.bytedance.retrofit2.mime.TypedInput
        public long length() {
            return this.f7271a.getContentLength();
        }

        @Override // com.bytedance.retrofit2.mime.TypedInput
        public String mimeType() {
            return SsCronetHttpClient.q(this.f7271a, "Content-Type");
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f7273a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f7274b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public long f7275c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public long f7276d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f7277e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f7278f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public IOException f7279g;

        public b(String r10) {
            this.f7273a = -1;
            this.f7274b = r10;
            this.f7275c = System.currentTimeMillis();
            this.f7277e = 0;
            this.f7278f = -1;
        }

        public JSONObject a() {
            JSONObject r10 = new JSONObject();
            r10.put("host", this.f7274b);     // Catch: JSONException -> L12
            r10.put("start", this.f7275c);     // Catch: JSONException -> L12
            r10.put("end", this.f7276d);     // Catch: JSONException -> L12
            r10.put("net_error", this.f7277e);     // Catch: JSONException -> L12
            r10.put(ServerElements.CODE, this.f7278f);     // Catch: JSONException -> L12
            IOException r11 = this.f7279g;     // Catch: JSONException -> L12
            if (r11 == null) goto L11;
            String r12 = r11.getMessage();     // Catch: JSONException -> L12
            if (TextUtils.isEmpty(r12) == false) goto L8;
        L10:
            r10.put("exception", r12);     // Catch: JSONException -> L12
            goto L11
        L8:
            if (r12.length() <= 64) goto L10;
            r12 = r12.substring(0, 64);     // Catch: JSONException -> L12
        L11:
            return r10;
        }
    }

    static {
        B = new HandlerThread("Concurrent-Handler");
        E = false;
        int r10 = NetworkExceptionImpl.f18727a;     // Catch: ClassNotFoundException -> L5
        D = NetworkExceptionImpl.class;     // Catch: ClassNotFoundException -> L5
    L7:
        B.start();
        return;
    L5:
        e = move-exception;
        e.printStackTrace();
        goto L7
    }

    public a(g6.b r11, com.bytedance.frameworks.baselib.network.http.cronet.impl.b.a r12) {
        this.f7246b = 0;
        this.f7247c = false;
        this.f7249e = false;
        this.f7253i = BaseHttpRequestInfo.a();
        this.f7256l = new ArrayList();
        this.f7257m = new Object();
        this.f7258n = new AtomicInteger(0);
        this.f7259o = new CopyOnWriteArrayList();
        this.f7260p = false;
        this.f7261q = null;
        this.f7262r = null;
        this.f7263s = new CopyOnWriteArrayList();
        this.f7264t = 0;
        this.f7265u = new CountDownLatch(1);
        this.f7266v = new WeakHandler(B.getLooper(), this);
        Logger.d(A, "Request url: " + r11.D());
        this.f7250f = r11;
        this.f7245a = r11.y();
        String r10 = r11.D();
        this.f7251g = r10;
        Uri r13 = Uri.parse(r10);
        String r14 = r13.getScheme();
        String r15 = r14 + "://" + r13.getHost();
        String r16 = r13.getQuery();
        Iterator r17 = r12.a().iterator();
        int r18 = 0;
    L4:
        if (r17.hasNext() == false) goto L15;
        String r19 = this.f7251g.replaceFirst(r15, r14 + "://" + ((String) r17.next()));
        if (TextUtils.isEmpty(r16) == true) goto L14;
        if (r16.contains("concurrent=") == true) goto L10;
        r19 = r19 + "&concurrent=" + r18;
    L10:
        if (r18 <= 0) goto L14;
        if (r16.contains("is_retry=") == true) goto L14;
        r19 = r19 + "&is_retry=1";
    L14:
        r18 = r18 + 1;
        this.f7256l.add(r19);
        goto L4
    L15:
        this.f7254j = UUID.randomUUID().toString();
        this.f7255k = r12.f7292i;
        this.f7267w = r12.f7296m;
        C = r12.f7297n;
        this.f7268x = r12.f7298o;
        f(r11);
        Logger.d(A, "Request max wait time milliseconds: " + this.f7269y + ", connect interval milliseconds: " + this.f7267w);
        RetrofitMetrics r110 = this.f7245a;
        if (r110 == null) goto L18;
        r110.f7897d = this.f7254j;
        r110.f7898e = true;
        BaseHttpRequestInfo r20 = this.f7253i;
        r20.f7164c = r110.f7900g;
        r20.f7165d = r110.f7901h;
    L18:
        long r21 = System.currentTimeMillis();
        this.f7252h = r21;
        BaseHttpRequestInfo r111 = this.f7253i;
        r111.f7166e = r21;
        r111.f7183v = 0;
        if (this.f7250f.I() == false) goto L21;
        this.f7253i.A = true;
    L23:
        if ((r11.s() instanceof o4.a) == false) goto L31;
        this.f7253i.f7163b = (o4.a) r11.s();
        this.f7247c = this.f7253i.f7163b.f22488k;
        return;
    L31:
        return;
    L21:
        this.f7253i.A = false;
        goto L23
    }

    public static /* synthetic */ void a(a r10) {
        r10.j();
    }

    public static /* synthetic */ RetrofitMetrics c(a r10) {
        return r10.f7245a;
    }

    public static /* synthetic */ BaseHttpRequestInfo d(a r10) {
        return r10.f7253i;
    }

    public static boolean p(int r10, String r11, String r12) {
        if (r10 < 200) goto L6;
        if (r10 >= 300) goto L6;
        return false;
    L6:
        if (r11 != null) goto L8;
    L10:
        if (r10 < 300) goto L17;
        if (r10 >= 600) goto L17;
        if (C == true) goto L17;
        return false;
    L17:
        if (com.bytedance.frameworks.baselib.network.http.cronet.impl.b.d().c(r10, r12) == false) goto L19;
        return false;
    L19:
        return true;
    L8:
        if (r11.equals("1") == false) goto L10;
        return false;
    }

    public final void b() {
        Message r10 = Message.obtain();
        r10.what = 1;
        r10.obj = this;
        this.f7266v.sendMessage(r10);
    }

    @Override // com.bytedance.retrofit2.client.SsCall
    public void cancel() {
        Logger.d(A, "cancel countdown.");
        Object r10 = this.f7257m;
        monitor-enter(r10);
        this.f7265u.countDown();     // Catch: Throwable -> L15
        e();     // Catch: Throwable -> L15
        if (this.f7261q == null) goto L19;
        this.f7261q.disconnect();     // Catch: Throwable -> L15
        if (this.f7250f.I() == false) goto L19;
        if (this.f7249e == true) goto L19;
        doCollect();     // Catch: Throwable -> L15
        BaseHttpRequestInfo r11 = this.f7253i;     // Catch: Throwable -> L15
        r11.K = SsCronetHttpClient.l(this.f7270z);     // Catch: Throwable -> L15
        BaseHttpRequestInfo r12 = this.f7253i;     // Catch: Throwable -> L15
        r12.f7169h = System.currentTimeMillis();     // Catch: Throwable -> L15
        BaseHttpRequestInfo r13 = this.f7253i;     // Catch: Throwable -> L15
        o4.a r14 = r13.f7163b;     // Catch: Throwable -> L15
        if (r14 != null) goto L13;
    L17:
        long r15 = r13.f7169h;     // Catch: Throwable -> L15
        long r16 = this.f7252h;     // Catch: Throwable -> L15
        NetworkParams.s(r15 - r16, r16, this.f7250f.D(), this.f7248d, this.f7253i);     // Catch: Throwable -> L15
    L18:
        f r17 = f.a();     // Catch: Throwable -> L15
        String r18 = this.f7250f.D();     // Catch: Throwable -> L15
        BaseHttpRequestInfo r19 = this.f7253i;     // Catch: Throwable -> L15
        r17.c(r18, r19.f7180s, r19.f7181t, r19.K, r19.f7186y);     // Catch: Throwable -> L15
        goto L19
    L13:
        if (r14.f22493p == false) goto L18;
    L19:
        this.f7249e = true;     // Catch: Throwable -> L15
        monitor-exit(r10);     // Catch: Throwable -> L15
        return;
    L15:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.retrofit2.IMetricsCollect
    public void doCollect() {
        SsCronetHttpClient.w(this.f7261q, this.f7253i, this.f7245a);
    }

    public final void e() {
        this.f7266v.removeCallbacksAndMessages(null);
        Object r10 = this.f7257m;
        monitor-enter(r10);
    L8:
        th = move-exception;
        throw th;
    L5:
        if (this.f7260p == false) goto L10;
        monitor-exit(r10);     // Catch: Throwable -> L8
        return;
    L10:
        Iterator r11 = this.f7259o.iterator();     // Catch: Throwable -> L8
    L12:
        if (r11.hasNext() == false) goto L22;
        HttpURLConnection r12 = (HttpURLConnection) r11.next();     // Catch: Throwable -> L8
        if (r12 == null) goto L12;
        Iterator r13 = this.f7263s.iterator();     // Catch: Throwable -> L8
    L17:
        if (r13.hasNext() == false) goto L21;
        b r14 = (b) r13.next();     // Catch: Throwable -> L8
        if (r14.f7273a != r12.hashCode()) goto L17;
        r14.f7276d = System.currentTimeMillis();     // Catch: Throwable -> L8
        r14.f7277e = BDNetworkTagLaunchType.UNSPECIFIED;     // Catch: Throwable -> L8
        r14.f7279g = new IOException("cleanupMessagesAndPendingConnections");     // Catch: Throwable -> L8
    L21:
        r12.disconnect();     // Catch: Throwable -> L8
        this.f7259o.remove(r12);     // Catch: Throwable -> L8
        goto L12
    L22:
        RetrofitMetrics r15 = this.f7245a;     // Catch: Throwable -> L8
        r15.f7896c = l();     // Catch: Throwable -> L8
        this.f7260p = true;     // Catch: Throwable -> L8
        monitor-exit(r10);     // Catch: Throwable -> L8
    }

    @Override // com.bytedance.retrofit2.client.SsCall
    public g6.c execute() {
        RetrofitMetrics r10 = this.f7245a;
        if (r10 == null) goto L6;
        r10.f7903j = System.currentTimeMillis();
    L6:
        if (this.f7249e == true) goto L85;
        Logger.d(A, "Execute url: " + this.f7251g);
        SsCronetHttpClient.d(this.f7247c, null);
        h();
        this.f7265u.await(this.f7269y, TimeUnit.MILLISECONDS);     // Catch: Exception -> L75
        this.f7265u.countDown();     // Catch: Exception -> L75
        Object r11 = this.f7257m;     // Catch: Exception -> L75
        monitor-enter(r11);     // Catch: Exception -> L75
    L20:
        th = move-exception;
        throw th;     // Catch: Exception -> L75
    L11:
        if (this.f7249e == true) goto L72;
        boolean r12 = false;
        if (this.f7261q != null) goto L24;
        com.bytedance.frameworks.baselib.network.http.cronet.impl.b.d().h(this.f7255k, false);     // Catch: Throwable -> L20
        if (this.f7263s.size() <= 0) goto L23;
        if (((b) this.f7263s.get(0)).f7279g == null) goto L23;
        throw ((b) this.f7263s.get(0)).f7279g;     // Catch: Throwable -> L20
    L23:
        throw k(new IOException("All urls have been tried and timed out by max wait time."), this.f7251g, this.f7261q, false);     // Catch: Throwable -> L20
    L24:
        this.f7259o.remove(this.f7261q);     // Catch: Throwable -> L20
        monitor-exit(r11);     // Catch: Throwable -> L20
        e();
        com.bytedance.frameworks.baselib.network.http.cronet.impl.b.d().h(this.f7255k, true);     // Catch: Throwable -> L36 Exception -> L38
        int r13 = n(this.f7261q.getResponseCode());     // Catch: Throwable -> L36 Exception -> L38
        this.f7253i.f7167f = System.currentTimeMillis();     // Catch: Throwable -> L36 Exception -> L38
        this.f7253i.f7170i = -1;     // Catch: Throwable -> L36 Exception -> L38
        this.f7248d = SsCronetHttpClient.K(this.f7261q, this.f7253i, r13);     // Catch: Throwable -> L36 Exception -> L38
        this.f7270z = SsCronetHttpClient.q(this.f7261q, "Content-Type");     // Catch: Throwable -> L36 Exception -> L38
        if (this.f7250f.I() == true) goto L30;
        int r14 = this.f7250f.w();     // Catch: Throwable -> L36 Exception -> L38
        this.f7253i.K = SsCronetHttpClient.l(this.f7270z);     // Catch: Throwable -> L36 Exception -> L38
        TypedInput r15 = new h6.f(this.f7270z, SsCronetHttpClient.P(this.f7251g, r14, this.f7261q, this.f7252h, this.f7253i, this.f7248d, r13, this.f7245a), new String[0]);     // Catch: Throwable -> L36 Exception -> L38
    L56:
        g6.c r16 = new g6.c(this.f7251g, r13, this.f7261q.getResponseMessage(), SsCronetHttpClient.h(this.f7261q, E), r15);     // Catch: Throwable -> L36 Exception -> L38
        r16.h(this.f7253i);     // Catch: Throwable -> L36 Exception -> L38
        if (this.f7250f.I() == true) goto L61;
        SsCronetHttpClient.N(this.f7261q);
    L61:
        return r16;
    L30:
        if (r13 < 200) goto L34;
        if (r13 >= 300) goto L34;
    L35:
        r15 = g(this.f7261q);     // Catch: Throwable -> L36 Exception -> L38
    L34:
        if (SsCronetHttpClient.A(this.f7253i) == true) goto L35;
        String r17 = this.f7261q.getResponseMessage();     // Catch: Throwable -> L36 Exception -> L38
        int r18 = this.f7250f.w();     // Catch: Throwable -> L44
        InputStream r19 = this.f7261q.getInputStream();     // Catch: Throwable -> L44 Exception -> L46
    L47:
        SsCronetHttpClient.O(false, this.f7261q.getHeaderFields(), r18, r19, this.f7270z, this.f7251g, this.f7245a);     // Catch: Throwable -> L44
    L53:
        this.f7261q.disconnect();     // Catch: Throwable -> L36 Exception -> L38
        throw new HttpResponseException(r13, r17);     // Catch: Throwable -> L36 Exception -> L38
    L46:
        r19 = this.f7261q.getErrorStream();     // Catch: Throwable -> L44
    L44:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L36 Exception -> L38
        StringBuilder r20 = new StringBuilder();     // Catch: Throwable -> L36 Exception -> L38
        r20.append("reason = ");     // Catch: Throwable -> L36 Exception -> L38
        if (r17 != null) goto L52;
        r17 = "";
    L52:
        r20.append(r17);     // Catch: Throwable -> L36 Exception -> L38
        r20.append("  exception = ");     // Catch: Throwable -> L36 Exception -> L38
        r20.append(th.getMessage());     // Catch: Throwable -> L36 Exception -> L38
        r17 = r20.toString();     // Catch: Throwable -> L36 Exception -> L38
    L38:
        e = move-exception;
    L64:
        th = move-exception;
        r12 = true;
        th = th;
    L67:
        if (this.f7250f.I() == false) goto L69;
        if (r12 == true) goto L69;
        throw th;
    L69:
        SsCronetHttpClient.N(this.f7261q);
        throw th;
    L63:
        throw k(e, this.f7251g, this.f7261q, true);     // Catch: Throwable -> L64
    L36:
        th = th;
        goto L67
    L72:
        throw new IOException("request canceled");     // Catch: Throwable -> L20
    L75:
        e = move-exception;
        e();
        if (this.f7261q != null) goto L83;
        if (this.f7262r == null) goto L83;
        throw k(e, this.f7251g, this.f7262r, true);
    L83:
        throw k(e, this.f7251g, this.f7261q, true);
    L85:
        throw new IOException("request canceled");
    }

    public final void f(g6.b r10) {
        this.f7269y = NetworkParams.g() + NetworkParams.k();
        if ((r10.s() instanceof o4.a) == false) goto L12;
        o4.a r11 = (o4.a) r10.s();
        long r12 = r11.f22486i;
        if (r12 <= 0) goto L7;
        this.f7269y = r12;
        goto L12
    L7:
        long r13 = r11.f22480c;
        if (r13 <= 0) goto L12;
        long r14 = r11.f22481d;
        if (r14 <= 0) goto L12;
        this.f7269y = r13 + r14;
    L12:
        this.f7269y += 1000;
    }

    public final TypedInput g(HttpURLConnection r10) {
        if (r10 != null) goto L6;
        return null;
    L6:
        if (r10.getContentLength() != 0) goto L10;
        cancel();
        return null;
    L10:
        return new C0094a(this, r10);
    }

    @Override // com.bytedance.retrofit2.client.SsCall
    public g6.b getRequest() {
        return this.f7250f;
    }

    @Override // com.bytedance.retrofit2.IRequestInfo
    public Object getRequestInfo() {
        return this.f7253i;
    }

    public final void h() {
        com.bytedance.frameworks.baselib.network.dispatcher.a r10 = new com.bytedance.frameworks.baselib.network.dispatcher.a("Concurrent-Call", IRequest.Priority.IMMEDIATE, 0, new q4.a(this), this.f7253i.A);
        n4.b.a().add(r10);
        o(this.f7267w);
    }

    @Override // com.bytedance.common.utility.collection.WeakHandler.IHandler
    public void handleMsg(Message r10) {
        if (r10 == null) goto L22;
        Object r11 = r10.obj;
        if ((r11 instanceof a) == false) goto L23;
        int r12 = r10.what;     // Catch: Throwable -> L12
        if (r12 != 0) goto L9;
        ((a) r11).h();     // Catch: Throwable -> L12
    L18:
        return;
    L9:
        if (r12 != 1) goto L18;
        ((a) r11).i();     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        th.printStackTrace();
        return;
    L23:
        return;
    }

    public final void i() {
        if (this.f7266v.obtainMessage(0) == null) goto L6;
        this.f7266v.removeMessages(0);
        h();
        return;
    }

    public final /* synthetic */ void j() {
        long r10 = SystemClock.uptimeMillis();
        HttpURLConnection r11 = null;
        Object r12 = this.f7257m;     // Catch: IOException -> L72
        monitor-enter(r12);     // Catch: IOException -> L72
    L60:
        th = th;
        String r13 = null;
        b r14 = null;
    L117:
        monitor-exit(r12);     // Catch: Throwable -> L70
        throw th;     // Catch: IOException -> L67
    L67:
        e = e;
        HttpURLConnection r15 = r11;
    L69:
        IOException e10 = e;
    L74:
        Object r16 = this.f7257m;
        monitor-enter(r16);
        int r17 = -1;
        Class r18 = D;     // Catch: Throwable -> L109
        if (r18 == null) goto L123;
        if (r18.isInstance(e10) == false) goto L123;
        r17 = ((Integer) Reflect.on(e10).call("getCronetInternalErrorCode").get()).intValue();     // Catch: Throwable -> L109
        Logger.d(A, "cronet error code: " + r17);     // Catch: Throwable -> L109
    L123:
    L85:
        th = move-exception;
        throw th;
    L83:
        if (this.f7262r != null) goto L87;
        this.f7262r = r15;     // Catch: Throwable -> L85
    L87:
        if (r15 == null) goto L92;
        r15.disconnect();     // Catch: Throwable -> L85
        if (r14 == null) goto L91;
        r14.f7279g = k(e10, r13, r15, false);     // Catch: Throwable -> L85
        r14.f7277e = r17;     // Catch: Throwable -> L85
        r14.f7276d = System.currentTimeMillis();     // Catch: Throwable -> L85
    L91:
        this.f7259o.remove(r15);     // Catch: Throwable -> L85
    L92:
        int r19 = this.f7264t + 1;     // Catch: Throwable -> L85
        this.f7264t = r19;     // Catch: Throwable -> L85
        if (r19 < this.f7256l.size()) goto L98;
        Logger.d(A, "Try all urls failed countdown.");     // Catch: Throwable -> L85
        this.f7265u.countDown();     // Catch: Throwable -> L85
        monitor-exit(r16);     // Catch: Throwable -> L85
        return;
    L98:
        if (com.bytedance.frameworks.baselib.network.http.cronet.impl.b.d().c(r17, this.f7255k) == false) goto L103;
        Logger.d(A, "inBlockErrorCode countdown.");     // Catch: Throwable -> L85
        this.f7265u.countDown();     // Catch: Throwable -> L85
        monitor-exit(r16);     // Catch: Throwable -> L85
        return;
    L103:
        if ((SystemClock.uptimeMillis() - r10) >= this.f7267w) goto L105;
        b();     // Catch: Throwable -> L85
    L105:
        monitor-exit(r16);     // Catch: Throwable -> L85
        return;
    L70:
        th = th;
        goto L117
    L6:
        if (this.f7258n.get() < this.f7256l.size()) goto L8;
    L62:
        this.f7266v.removeCallbacksAndMessages(null);     // Catch: Throwable -> L60
        monitor-exit(r12);     // Catch: Throwable -> L60
        return;
    L8:
        if (this.f7261q != null) goto L62;
        if (this.f7265u.getCount() == 0) goto L62;
        if (this.f7249e == true) goto L62;
        r13 = (String) this.f7256l.get(this.f7258n.get());     // Catch: Throwable -> L60
        String r20 = A;     // Catch: Throwable -> L58
        Logger.d(r20, "ConstructURLConnection and execute index: " + this.f7258n.get() + " url: " + r13);     // Catch: Throwable -> L58
        r15 = SsCronetHttpClient.f(r13, this.f7250f, this.f7253i, this.f7246b);     // Catch: Throwable -> L58
    L19:
        th = th;
        r14 = null;
    L21:
        r11 = r15;
        goto L117
    L17:
        if (this.f7268x == false) goto L22;
        r15.setRequestProperty("x-tt-bp-rs", "1");     // Catch: Throwable -> L19
    L22:
        r15.setRequestProperty("transaction-id", this.f7254j);     // Catch: Throwable -> L19
        this.f7258n.incrementAndGet();     // Catch: Throwable -> L19
        this.f7259o.add(r15);     // Catch: Throwable -> L19
        r14 = new b(r15.getURL().getHost());     // Catch: Throwable -> L19
        r14.f7273a = r15.hashCode();     // Catch: Throwable -> L56
        this.f7263s.add(r14);     // Catch: Throwable -> L56
        monitor-exit(r12);     // Catch: Throwable -> L56
        int r21 = SsCronetHttpClient.M(this.f7250f, r15);     // Catch: IOException -> L39
        r14.f7278f = r21;     // Catch: IOException -> L39
        r14.f7276d = System.currentTimeMillis();     // Catch: IOException -> L39
        if (p(r21, r15.getHeaderField("tt-api-source-5xx"), this.f7255k) == true) goto L41;
        Object r22 = this.f7257m;     // Catch: IOException -> L39
        monitor-enter(r22);     // Catch: IOException -> L39
    L32:
        th = move-exception;
        throw th;     // Catch: IOException -> L39
    L30:
        if (this.f7261q != null) goto L34;
        this.f7261q = r15;     // Catch: Throwable -> L32
        this.f7251g = r13;     // Catch: Throwable -> L32
        Logger.d(r20, "Find winner connection countdown.");     // Catch: Throwable -> L32
        this.f7265u.countDown();     // Catch: Throwable -> L32
    L35:
        monitor-exit(r22);     // Catch: Throwable -> L32
    L134:
        return;
    L34:
        r15.disconnect();     // Catch: Throwable -> L32
        this.f7259o.remove(r15);     // Catch: Throwable -> L32
        goto L35
    L41:
        String r23 = r15.getResponseMessage();     // Catch: IOException -> L39
        int r24 = this.f7250f.w();     // Catch: Throwable -> L45
        InputStream r25 = r15.getInputStream();     // Catch: Throwable -> L45 Exception -> L47
    L44:
        InputStream r26 = r25;
        SsCronetHttpClient.O(false, r15.getHeaderFields(), r24, r26, SsCronetHttpClient.q(r15, "Content-Type"), r13, this.f7245a);     // Catch: Throwable -> L45
    L55:
        throw new HttpResponseException(r21, r23);     // Catch: IOException -> L39
    L47:
        r25 = r15.getErrorStream();     // Catch: Throwable -> L45
    L45:
        th = move-exception;
        th.printStackTrace();     // Catch: IOException -> L39
        StringBuilder r27 = new StringBuilder();     // Catch: IOException -> L39
        r27.append("reason = ");     // Catch: IOException -> L39
        if (r23 != null) goto L53;
        r23 = "";
    L53:
        r27.append(r23);     // Catch: IOException -> L39
        r27.append("  exception = ");     // Catch: IOException -> L39
        r27.append(th.getMessage());     // Catch: IOException -> L39
        r23 = r27.toString();     // Catch: IOException -> L39
    L39:
        e10 = e;
    L56:
        th = th;
    L58:
        th = th;
        r14 = null;
    L72:
        e = e;
        r13 = null;
        r15 = null;
        r14 = null;
        goto L69
    }

    public final IOException k(Exception r10, String r11, HttpURLConnection r12, boolean r13) {
        if ((r10 instanceof IOException) == false) goto L11;
        if (r10.getMessage() == null) goto L11;
        if (r10.getMessage().startsWith("request canceled") == false) goto L11;
        return (IOException) r10;
    L11:
        if ("com.ttnet.org.chromium.net.impl.NetworkExceptionImpl".equals(r10.getClass().getName()) == false) goto L13;
    L16:
        int r14 = SsCronetHttpClient.n(r12);
    L18:
        if (TextUtils.isEmpty(r11) == false) goto L20;
        r11 = this.f7251g;
    L20:
        String r15 = r11;
        if (r13 == false) goto L23;
        SsCronetHttpClient.L(r15, this.f7252h, this.f7253i, this.f7248d, r10, r12, this.f7245a);
    L25:
        String r16 = r10.getMessage();
        SsCronetHttpClient.d(this.f7247c, r16);     // Catch: NetworkNotAvailabeException -> L29
        return new CronetIOException(r10, this.f7253i, this.f7248d, r14);
    L29:
        e = move-exception;
        return e;
    L23:
        if (r12 == null) goto L25;
        r12.disconnect();
        goto L25
    L13:
        if ("com.ttnet.org.chromium.net.impl.QuicExceptionImpl".equals(r10.getClass().getName()) == true) goto L16;
        r14 = 0;
        goto L18
    }

    public final JSONObject l() {
        JSONObject r10 = new JSONObject();
        r10.put("concurrent", this.f7263s.size() - 1);     // Catch: JSONException -> L7
        r10.put("duration", System.currentTimeMillis() - this.f7252h);     // Catch: JSONException -> L7
        JSONArray r11 = new JSONArray();     // Catch: JSONException -> L7
        Iterator r12 = this.f7263s.iterator();     // Catch: JSONException -> L7
    L5:
        if (r12.hasNext() == false) goto L9;
        r11.put(((b) r12.next()).a());     // Catch: JSONException -> L7
        goto L5
    L9:
        r10.put("tasks", r11);     // Catch: JSONException -> L7
    L12:
        return r10;
    L7:
        e = move-exception;
        e.printStackTrace();
        goto L12
    }

    public final int m(boolean r10) {
        if (this.f7261q == null) goto L5;
        this.f7261q.disconnect();
    L5:
        String r11 = this.f7250f.D();
        this.f7261q = SsCronetHttpClient.f(r11, this.f7250f, this.f7253i, this.f7246b);     // Catch: Exception -> L10
        if (r10 == false) goto L13;
        this.f7253i.I = true;     // Catch: Exception -> L10
        this.f7261q.addRequestProperty("x-tt-bdturing-retry", "1");     // Catch: Exception -> L10
    L13:
        return SsCronetHttpClient.M(this.f7250f, this.f7261q);
    L10:
        e = move-exception;
        SsCronetHttpClient.L(r11, this.f7252h, this.f7253i, this.f7248d, e, this.f7261q, this.f7245a);
        this.f7249e = true;
        if ((e instanceof IOException) == false) goto L19;
        throw ((IOException) e);
    L19:
        throw new IOException(e.getMessage(), e.getCause());
    }

    public final int n(int r10) {
        if (SsCronetHttpClient.a0(this.f7261q, this.f7253i, r10) == false) goto L7;
        return m(true);
    L7:
        if (this.f7253i.G == false) goto L9;
        E = true;
    L9:
        return r10;
    }

    public final void o(long r10) {
        Message r11 = Message.obtain();
        r11.what = 0;
        r11.obj = this;
        this.f7266v.sendMessageDelayed(r11, r10);
    }

    @Override // com.bytedance.retrofit2.client.SsCall
    public boolean setThrottleNetSpeed(long r10) {
        this.f7246b = r10;
        if (this.f7261q != null) goto L11;
        return true;
    L11:
        Reflect.on(this.f7261q).call("setThrottleNetSpeed", new Class[]{Long.TYPE}, new Object[]{Long.valueOf(r10)});     // Catch: Throwable -> L6
        return true;
    L6:
        th = move-exception;
        th.printStackTrace();
        return false;
    }
}
