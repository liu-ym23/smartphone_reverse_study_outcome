package com.ttnet.org.chromium.net.urlconnection;

import android.net.TrafficStats;
import android.text.TextUtils;
import android.util.Pair;
import com.bytedanceos.common.ad.param.AdReportParam;
import com.ss.android.http.legacy.cookie.SM;
import com.ss.android.ugc.quota.tag.BDNetworkTagLaunchType;
import com.ttnet.org.chromium.base.annotations.UsedByReflection;
import com.ttnet.org.chromium.base.k;
import com.ttnet.org.chromium.base.m;
import com.ttnet.org.chromium.net.CronetException;
import com.ttnet.org.chromium.net.NetworkException;
import com.ttnet.org.chromium.net.a0;
import com.ttnet.org.chromium.net.b0;
import com.ttnet.org.chromium.net.c;
import com.ttnet.org.chromium.net.g;
import com.ttnet.org.chromium.net.t;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ConnectException;
import java.net.CookieHandler;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.NoRouteToHostException;
import java.net.ProtocolException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.URI;
import java.net.URL;
import java.net.UnknownHostException;
import java.nio.ByteBuffer;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import lf.b;
import lf.d;
import lf.e;
import lf.f;
import org.apache.http.conn.ConnectTimeoutException;

/* JADX INFO: loaded from: classes4.dex */
public class CronetHttpURLConnection extends HttpURLConnection {
    public static final String D = "CronetHttpURLConnection";
    public long A;
    public CountDownLatch B;
    public volatile boolean C;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f18956a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final f f18957b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public a0 f18958c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List f18959d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f18960e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f18961f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f18962g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f18963h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public d f18964i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public e f18965j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public b0 f18966k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public IOException f18967l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f18968m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f18969n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public List f18970o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public Map f18971p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f18972q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f18973r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f18974s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f18975t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f18976u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f18977v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public volatile String f18978w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public t f18979x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public CookieHandler f18980y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f18981z;

    public class a extends a0.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CronetHttpURLConnection f18982a;

        public a(CronetHttpURLConnection r10) {
            this.f18982a = r10;
        }

        @Override // com.ttnet.org.chromium.net.a0.b
        public void a(a0 r10, b0 r11) {
            CronetHttpURLConnection.c(this.f18982a, r11);
            if (k.b() == false) goto L6;
            k.a("CronetHttpURLConnection", "onCanceled loop quit url = " + this.f18982a.getURL().toString());
        L6:
            if (CronetHttpURLConnection.g(this.f18982a) != null) goto L8;
            CronetHttpURLConnection.h(this.f18982a, new TTRequestCanceledException("request canceled, ErrorCode=11, InternalErrorCode=" + BDNetworkTagLaunchType.UNSPECIFIED));
        L8:
            j(CronetHttpURLConnection.g(this.f18982a), false);
        }

        @Override // com.ttnet.org.chromium.net.a0.b
        public void b(a0 r10, b0 r11, CronetException r12) {
            if (r12 == null) goto L9;
            CronetHttpURLConnection.c(this.f18982a, r11);
            CronetHttpURLConnection r13 = this.f18982a;
            CronetHttpURLConnection.h(r13, CronetHttpURLConnection.i(r13, r12));
            if (k.b() == false) goto L6;
            k.a("CronetHttpURLConnection", "onFailed url = " + this.f18982a.getURL().toString());
        L6:
            j(r12, true);
            return;
        L9:
            throw new IllegalStateException("Exception cannot be null in onFailed.");
        }

        @Override // com.ttnet.org.chromium.net.a0.b
        public void c(a0 r10, t r11) {
            CronetHttpURLConnection.k(this.f18982a, r11);
            if (k.b() == false) goto L5;
            k.a("CronetHttpURLConnection", "onMetricsCollected loop quit url = " + this.f18982a.getURL().toString());
        L5:
            i();
        }

        @Override // com.ttnet.org.chromium.net.a0.b
        public void d(a0 r10, b0 r11, ByteBuffer r12) {
            CronetHttpURLConnection.c(this.f18982a, r11);
            if (k.b() == false) goto L5;
            k.a("CronetHttpURLConnection", "onReadCompleted loop quit url = " + this.f18982a.getURL().toString());
        L5:
            CronetHttpURLConnection.r(this.f18982a).c();
        }

        @Override // com.ttnet.org.chromium.net.a0.b
        public void e(a0 r10, b0 r11, String r12, String r13) {
            CronetHttpURLConnection.s(this.f18982a, true);
            if (r11 == null) goto L31;
            CronetHttpURLConnection.q(this.f18982a, r13, r11.a());
        L31:
            URL r14 = new URL(r12);     // Catch: MalformedURLException -> L30
            boolean r15 = r14.getHost().equals(CronetHttpURLConnection.t(this.f18982a).getHost());     // Catch: MalformedURLException -> L30
            if (CronetHttpURLConnection.u(this.f18982a) == false) goto L9;
            CronetHttpURLConnection.v(this.f18982a, r14);     // Catch: MalformedURLException -> L30
        L9:
            if (CronetHttpURLConnection.w(this.f18982a) == false) goto L23;
            if (CronetHttpURLConnection.d(this.f18982a) == null) goto L34;
            if (r15 == true) goto L21;
            CronetHttpURLConnection.d(this.f18982a).b();     // Catch: MalformedURLException -> L30
            URL r16 = new URL(r12);     // Catch: MalformedURLException -> L30
            CronetHttpURLConnection r17 = this.f18982a;     // Catch: MalformedURLException -> L30
            Map r18 = CronetHttpURLConnection.f(r17, r17.S(r16));     // Catch: MalformedURLException -> L30
            if (r18 == null) goto L21;
            if (r18.isEmpty() == true) goto L21;
            Iterator r19 = r18.entrySet().iterator();     // Catch: MalformedURLException -> L30
        L19:
            if (r19.hasNext() == false) goto L21;
            Map.Entry r20 = (Map.Entry) r19.next();     // Catch: MalformedURLException -> L30
            CronetHttpURLConnection.d(this.f18982a).a((String) r20.getKey(), (String) r20.getValue());     // Catch: MalformedURLException -> L30
        L21:
            CronetHttpURLConnection.d(this.f18982a).e();     // Catch: MalformedURLException -> L30
            return;
        L34:
            return;
        L23:
            CronetHttpURLConnection.c(this.f18982a, r11);
            if (CronetHttpURLConnection.d(this.f18982a) == null) goto L27;
            j(null, false);
        L27:
            if (k.b() == false) goto L35;
            k.a("CronetHttpURLConnection", "onRedirectReceived loop quit url = " + this.f18982a.getURL().toString());
            return;
        }

        @Override // com.ttnet.org.chromium.net.a0.b
        public void f(String r10, t r11) {
            CronetHttpURLConnection.l(this.f18982a, r10);
            CronetHttpURLConnection.k(this.f18982a, r11);
            CronetHttpURLConnection.m(this.f18982a).countDown();
        }

        @Override // com.ttnet.org.chromium.net.a0.b
        public void g(a0 r10, b0 r11, String r12) {
            CronetHttpURLConnection.c(this.f18982a, r11);
            CronetHttpURLConnection.e(this.f18982a, true);
            if (CronetHttpURLConnection.b(this.f18982a) == null) goto L6;
            CronetHttpURLConnection r13 = this.f18982a;
            CronetHttpURLConnection.q(r13, r12, CronetHttpURLConnection.p(r13));
        L6:
            if (k.b() == false) goto L8;
            k.a("CronetHttpURLConnection", "onResponseStarted loop quit url = " + this.f18982a.getURL().toString());
        L8:
            CronetHttpURLConnection.r(this.f18982a).c();
        }

        @Override // com.ttnet.org.chromium.net.a0.b
        public void h(a0 r10, b0 r11) {
            CronetHttpURLConnection.c(this.f18982a, r11);
            if (k.b() == false) goto L5;
            k.a("CronetHttpURLConnection", "onSucceeded url = " + this.f18982a.getURL().toString());
        L5:
            j(null, true);
        }

        public final void i() {
            CronetHttpURLConnection r10 = this.f18982a;
            CronetHttpURLConnection.l(r10, CronetHttpURLConnection.d(r10).f());
        L12:
            th = move-exception;
            th.printStackTrace();
        L23:
            CronetHttpURLConnection.e(this.f18982a, true);
            CronetHttpURLConnection.r(this.f18982a).c();
            return;
        L4:
            if (CronetHttpURLConnection.g(this.f18982a) == null) goto L23;
            if (CronetHttpURLConnection.j(this.f18982a) != null) goto L8;
        L14:
            String r11 = null;
        L16:
            if (TextUtils.isEmpty(r11) == true) goto L23;
            String r12 = CronetHttpURLConnection.g(this.f18982a).getMessage();     // Catch: Throwable -> L12
            StringBuilder r13 = new StringBuilder();     // Catch: Throwable -> L12
            r13.append(r11);     // Catch: Throwable -> L12
            r13.append("|");     // Catch: Throwable -> L12
            if (r12 != null) goto L20;
            r12 = "null";
        L20:
            r13.append(r12);     // Catch: Throwable -> L12
            m.i(CronetHttpURLConnection.g(this.f18982a)).k("detailMessage", r13.toString());     // Catch: Throwable -> L12
            goto L23
        L8:
            if (CronetHttpURLConnection.j(this.f18982a).c() == null) goto L14;
            if (CronetHttpURLConnection.j(this.f18982a).c().e() == null) goto L14;
            r11 = CronetHttpURLConnection.j(this.f18982a).c().e() + ":" + CronetHttpURLConnection.j(this.f18982a).c().f();     // Catch: Throwable -> L12
            goto L16
        }

        public final void j(IOException r10, boolean r11) {
            CronetHttpURLConnection.h(this.f18982a, r10);
            if (CronetHttpURLConnection.n(this.f18982a) == null) goto L6;
            CronetHttpURLConnection.n(this.f18982a).c(r10);
        L6:
            if (CronetHttpURLConnection.o(this.f18982a) == null) goto L8;
            CronetHttpURLConnection.o(this.f18982a).f(r10);
        L8:
            CronetHttpURLConnection.e(this.f18982a, true);
            if (r11 == true) goto L12;
            i();
            return;
        }
    }

    static {
    }

    public CronetHttpURLConnection(URL r10, c r11) {
        super(r10);
        this.f18956a = r11;
        this.f18957b = new f();
        this.f18964i = new d(this);
        this.f18959d = new ArrayList();
        this.f18980y = CookieHandler.getDefault();
        this.B = new CountDownLatch(1);
        this.C = false;
    }

    public static /* synthetic */ b0 b(CronetHttpURLConnection r10) {
        return r10.f18966k;
    }

    public static /* synthetic */ b0 c(CronetHttpURLConnection r10, b0 r11) {
        r10.f18966k = r11;
        return r11;
    }

    public static /* synthetic */ a0 d(CronetHttpURLConnection r10) {
        return r10.f18958c;
    }

    public static /* synthetic */ boolean e(CronetHttpURLConnection r10, boolean r11) {
        r10.f18969n = r11;
        return r11;
    }

    public static /* synthetic */ Map f(CronetHttpURLConnection r10, URI r11) {
        return r10.a(r11);
    }

    public static /* synthetic */ IOException g(CronetHttpURLConnection r10) {
        return r10.f18967l;
    }

    public static /* synthetic */ IOException h(CronetHttpURLConnection r10, IOException r11) {
        r10.f18967l = r11;
        return r11;
    }

    public static /* synthetic */ IOException i(CronetHttpURLConnection r10, CronetException r11) {
        return r10.R(r11);
    }

    public static /* synthetic */ t j(CronetHttpURLConnection r10) {
        return r10.f18979x;
    }

    public static /* synthetic */ t k(CronetHttpURLConnection r10, t r11) {
        r10.f18979x = r11;
        return r11;
    }

    public static /* synthetic */ String l(CronetHttpURLConnection r10, String r11) {
        r10.f18978w = r11;
        return r11;
    }

    public static /* synthetic */ CountDownLatch m(CronetHttpURLConnection r10) {
        return r10.B;
    }

    public static /* synthetic */ d n(CronetHttpURLConnection r10) {
        return r10.f18964i;
    }

    public static /* synthetic */ e o(CronetHttpURLConnection r10) {
        return r10.f18965j;
    }

    public static /* synthetic */ Map p(CronetHttpURLConnection r10) {
        return r10.C();
    }

    public static /* synthetic */ void q(CronetHttpURLConnection r10, String r11, Map r12) {
        r10.O(r11, r12);
    }

    public static /* synthetic */ f r(CronetHttpURLConnection r10) {
        return r10.f18957b;
    }

    public static /* synthetic */ boolean s(CronetHttpURLConnection r10, boolean r11) {
        r10.f18968m = r11;
        return r11;
    }

    public static /* synthetic */ URL t(CronetHttpURLConnection r10) {
        return ((HttpURLConnection) r10).url;
    }

    public static /* synthetic */ boolean u(CronetHttpURLConnection r10) {
        return ((HttpURLConnection) r10).instanceFollowRedirects;
    }

    public static /* synthetic */ URL v(CronetHttpURLConnection r10, URL r11) {
        ((HttpURLConnection) r10).url = r11;
        return r11;
    }

    public static /* synthetic */ boolean w(CronetHttpURLConnection r10) {
        return ((HttpURLConnection) r10).instanceFollowRedirects;
    }

    public final void A(int r10) {
        this.f18957b.b(r10);     // Catch: Exception -> L4 SocketTimeoutException -> L8
    L17:
        return;
    L8:
        a0 r11 = this.f18958c;
        if (r11 == null) goto L16;
        r11.c();
        this.f18957b.d();
        this.f18957b.b(r10 / 2);
        return;
    L16:
        return;
    L4:
        e = move-exception;
        setException(new IOException("Unexpected request usage, caught in CronetHttpURLConnection, caused by " + e));
        if (this.f18958c == null) goto L14;
        this.f18957b.d();
        this.f18957b.b(r10 / 2);
        return;
    }

    public final int B(String r10) {
        int r11 = 0;
    L4:
        if (r11 >= this.f18959d.size()) goto L9;
        if (((String) ((Pair) this.f18959d.get(r11)).first).equalsIgnoreCase(r10) == true) goto L7;
        r11 = r11 + 1;
        goto L4
    L7:
        return r11;
    L9:
        return -1;
    }

    public final Map C() {
        Map r10 = this.f18971p;
        if (r10 == null) goto L5;
        return r10;
    L5:
        TreeMap r11 = new TreeMap(String.CASE_INSENSITIVE_ORDER);
        Iterator r12 = D().iterator();
    L7:
        if (r12.hasNext() == false) goto L12;
        Map.Entry r13 = (Map.Entry) r12.next();
        ArrayList r14 = new ArrayList();
        if (r11.containsKey(r13.getKey()) == false) goto L11;
        r14.addAll((Collection) r11.get(r13.getKey()));
    L11:
        r14.add((String) r13.getValue());
        r11.put((String) r13.getKey(), Collections.unmodifiableList(r14));
        goto L7
    L12:
        Map r15 = Collections.unmodifiableMap(r11);
        this.f18971p = r15;
        return r15;
    }

    public final List D() {
        List r10 = this.f18970o;
        if (r10 == null) goto L5;
        return r10;
    L5:
        this.f18970o = new ArrayList();
        Iterator r11 = this.f18966k.b().iterator();
    L7:
        if (r11.hasNext() == false) goto L9;
        Map.Entry r12 = (Map.Entry) r11.next();
        this.f18970o.add(new AbstractMap.SimpleImmutableEntry(r12));
        goto L7
    L9:
        List r13 = Collections.unmodifiableList(this.f18970o);
        this.f18970o = r13;
        return r13;
    }

    public int E() {
        IOException r10 = this.f18967l;
        if ((r10 instanceof NetworkException) == false) goto L7;
        return ((NetworkException) r10).getCronetInternalErrorCode();
    L7:
        if ((r10 instanceof TTRequestCanceledException) == true) goto L9;
        return 0;
    L9:
        return ((TTRequestCanceledException) r10).getCronetInternalErrorCode();
    }

    public final Map.Entry F(int r10) {
        K();     // Catch: IOException -> L9
        List r11 = D();
        if (r10 < r11.size()) goto L8;
        return null;
    L8:
        return (Map.Entry) r11.get(r10);
    L9:
        return null;
    }

    public int G() {
        return this.f18977v;
    }

    public void H(ByteBuffer r10) {
        a0 r11 = this.f18958c;
        if (r11 != null) goto L5;
        return;
    L5:
        r11.g(r10);
        A(getReadTimeout());
    }

    public t I() {
        if (this.f18979x != null) goto L11;
        if (this.C == false) goto L11;
        this.B.await(50, TimeUnit.MILLISECONDS);     // Catch: InterruptedException -> L8
    L8:
        e = move-exception;
        e.printStackTrace();
    L11:
        return this.f18979x;
    }

    public String J() {
        if (this.f18978w != null) goto L5;
        return "";
    L5:
        return this.f18978w;
    }

    public final void K() {
        e r10 = this.f18965j;
        if (r10 == null) goto L8;
        r10.c();
        if (M() == false) goto L8;
        this.f18965j.close();
    L8:
        if (this.f18969n == true) goto L13;
        Q();
        if (k.b() == false) goto L12;
        k.a("CronetHttpURLConnection", "getResponse loop url = " + getURL().toString());
    L12:
        A(getConnectTimeout() + getReadTimeout());
        this.f18969n = true;
    L13:
        x();
    }

    public final long L() {
        long r10 = ((HttpURLConnection) this).fixedContentLength;
        long r11 = getClass().getField("fixedContentLengthLong").getLong(this);     // Catch: Throwable -> L8
        if (r11 != (-1)) goto L7;
        return r10;
    L7:
        return r11;
    L12:
        return r10;
    }

    public final boolean M() {
        if (((HttpURLConnection) this).chunkLength <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    public void N() {
        a0 r10 = this.f18958c;
        if (r10 == null) goto L6;
        r10.c();
        return;
    }

    public final void O(String r10, Map r11) {
        if (k.b() == false) goto L28;
        String r12 = D;
        StringBuilder r13 = new StringBuilder();
        r13.append("Saving cookies for url: ");
        if (TextUtils.isEmpty(r10) == false) goto L7;
        String r14 = getURL().toString();
    L8:
        r13.append(r14);
        k.a(r12, r13.toString());
        goto L28
    L7:
        r14 = r10;
    L28:
    L12:
        e = move-exception;
        if (k.b() == false) goto L31;
        String r15 = D;
        StringBuilder r16 = new StringBuilder();
        r16.append("Saving cookies failed for ");
        if (TextUtils.isEmpty(r10) == false) goto L26;
        r10 = getURL().toString();
    L26:
        r16.append(r10);
        r16.append(" e = ");
        r16.append(e.getMessage());
        k.a(r15, r16.toString());
        return;
    L31:
        return;
    L10:
        if (this.f18980y != null) goto L15;
        this.f18980y = CookieHandler.getDefault();     // Catch: Exception -> L12
    L15:
        if (this.f18980y != null) goto L17;
        return;
    L17:
        if (TextUtils.isEmpty(r10) == false) goto L19;
        this.f18980y.put(S(getURL()), r11);     // Catch: Exception -> L12
        return;
    L19:
        URL r17 = new URL(r10);     // Catch: Exception -> L12
        this.f18980y.put(S(r17), r11);     // Catch: Exception -> L12
    }

    public final void P(String r10, String r11, boolean r12) {
        if (((HttpURLConnection) this).connected == true) goto L13;
        int r13 = B(r10);
        if (r13 < 0) goto L10;
        if (r12 == false) goto L9;
        this.f18959d.remove(r13);
        goto L10
    L9:
        throw new UnsupportedOperationException("Cannot add multiple headers of the same key, " + r10 + ". crbug.com/432719.");
    L10:
        this.f18959d.add(Pair.create(r10, r11));
        return;
    L13:
        throw new IllegalStateException("Cannot modify request property after connection is made.");
    }

    public final void Q() {
        if (((HttpURLConnection) this).connected == false) goto L6;
        return;
    L6:
        if (k.b() == false) goto L8;
        k.a("CronetHttpURLConnection", "start request url = " + getURL().toString());
    L8:
        g.a r10 = (g.a) this.f18956a.c(getURL().toString(), new a(this), this.f18957b);
        if (((HttpURLConnection) this).doOutput == true) goto L11;
    L27:
        Map r11 = a(S(getURL()));
        if (r11 != null) goto L30;
    L35:
        Iterator r12 = this.f18959d.iterator();
    L37:
        if (r12.hasNext() == false) goto L40;
        Pair r13 = (Pair) r12.next();
        r10.e((String) r13.first, (String) r13.second);
        goto L37
    L40:
        if (getUseCaches() == true) goto L42;
        r10.g();
    L42:
        r10.h(((HttpURLConnection) this).method);
        if (y() == false) goto L46;
        r10.j(this.f18961f);
    L46:
        if (z() == false) goto L48;
        r10.k(this.f18963h);
    L48:
        r10.i(this.f18972q);
        r10.b(this.f18973r);
        r10.c(this.f18974s);
        r10.d(this.f18975t);
        r10.a(this.f18976u);
        g r14 = r10.f();
        this.f18958c = r14;
        int r15 = this.f18981z;
        if (r15 == 0) goto L51;
        r14.h(r15);
    L51:
        this.f18958c.j();
        long r16 = this.A;
        if (r16 <= 0) goto L54;
        this.f18958c.i(r16);
    L54:
        ((HttpURLConnection) this).connected = true;
        return;
    L30:
        if (r11.isEmpty() == true) goto L35;
        Iterator r17 = r11.entrySet().iterator();
    L33:
        if (r17.hasNext() == false) goto L35;
        Map.Entry r18 = (Map.Entry) r17.next();
        r10.e((String) r18.getKey(), (String) r18.getValue());
        goto L33
    L11:
        if (((HttpURLConnection) this).method.equals("GET") == false) goto L13;
        ((HttpURLConnection) this).method = "POST";
    L13:
        e r19 = this.f18965j;
        if (r19 == null) goto L22;
        r10.l(r19.d(), this.f18957b);
        if (getRequestProperty("Content-Length") == null) goto L18;
    L20:
        this.f18965j.e();
    L25:
        if (getRequestProperty("Content-Type") != null) goto L27;
        addRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        goto L27
    L18:
        if (M() == true) goto L20;
        addRequestProperty("Content-Length", Long.toString(this.f18965j.d().a()));
        goto L20
    L22:
        if (getRequestProperty("Content-Length") != null) goto L25;
        addRequestProperty("Content-Length", AdReportParam.ClickPosType.SKIP);
        goto L25
    }

    public final IOException R(CronetException r10) {
        if ((r10 instanceof NetworkException) == true) goto L6;
        return r10;
    L6:
        switch(((NetworkException) r10).getErrorCode()) {
            case 1: goto L15;
            case 2: goto L14;
            case 3: goto L14;
            case 4: goto L13;
            case 5: goto L12;
            case 6: goto L11;
            case 7: goto L12;
            case 8: goto L10;
            case 9: goto L8;
            default: goto L17;
        };
    L8:
        IOException r11 = new NoRouteToHostException(r10.getMessage());
    L16:
        return r11;
    L10:
        r11 = new SocketException("reset by peer " + r10.getMessage());
        goto L16
    L11:
        r11 = new ConnectTimeoutException(r10.getMessage());
        goto L16
    L12:
        r11 = new ConnectException(r10.getMessage());
        goto L16
    L13:
        r11 = new SocketTimeoutException(r10.getMessage());
        goto L16
    L14:
        r11 = new ConnectException(r10.getMessage());
        goto L16
    L15:
        r11 = new UnknownHostException(r10.getMessage());
        goto L16
    L17:
        return r10;
    }

    public URI S(URL r10) {
        if (r10 != null) goto L5;
        return null;
    L5:
        String r11 = r10.toString();
        return new URI(r11);
    L8:
        e = move-exception;
        return URI.create(r11.replaceAll("[\\u0000-\\u001F\\u007F-\\u009F\\p{javaWhitespace}]", ""));
    L11:
        return URI.create(r11.substring(0, r11.indexOf("?")));
    L14:
        throw new RuntimeException(e);
    }

    public final Map a(URI r10) {
        HashMap r11 = new HashMap();
        HashMap r12 = new HashMap();
        List r13 = this.f18959d;
        if (r13 == null) goto L11;
        Iterator r14 = r13.iterator();
    L6:
        if (r14.hasNext() == false) goto L11;
        Pair r15 = (Pair) r14.next();
        String r16 = (String) r15.first;
        String r17 = (String) r15.second;
        List r18 = (List) r12.get(r16);
        if (r18 != null) goto L10;
        r18 = new LinkedList();
    L10:
        r18.add(r17);
        r12.put(r16, r18);
    L11:
        Map<String, List<String>> r19 = null;
    L15:
        e = move-exception;
        if (k.b() == false) goto L24;
        k.a(D, "Loading cookies failed for " + getURL().toString() + " e = " + e.getMessage());
    L24:
        if (r19 != null) goto L26;
    L46:
        return r11;
    L26:
        if (r19.size() <= 0) goto L46;
        Iterator<Map.Entry<String, List<String>>> r20 = r19.entrySet().iterator();
    L29:
        if (r20.hasNext() == false) goto L46;
        Map.Entry<String, List<String>> r21 = r20.next();
        String r22 = r21.getKey();
        StringBuilder r23 = new StringBuilder();
        if ("X-SS-Cookie".equalsIgnoreCase(r22) == true) goto L37;
        if ("Cookie".equalsIgnoreCase(r22) == true) goto L37;
        if (SM.COOKIE2.equalsIgnoreCase(r22) == false) goto L29;
    L37:
        if (r21.getValue().isEmpty() == true) goto L29;
        Iterator<String> r24 = r21.getValue().iterator();
        int r25 = 0;
    L40:
        if (r24.hasNext() == false) goto L45;
        String r26 = r24.next();
        if (r25 <= 0) goto L44;
        r23.append("; ");
    L44:
        r23.append(r26);
        r25 = r25 + 1;
        goto L40
    L45:
        r11.put(r22, r23.toString());
        goto L29
    L13:
        if (this.f18980y != null) goto L17;
        this.f18980y = CookieHandler.getDefault();     // Catch: Exception -> L15
    L17:
        CookieHandler r27 = this.f18980y;     // Catch: Exception -> L15
        if (r27 == null) goto L24;
        r19 = r27.get(r10, r12);     // Catch: Exception -> L15
        goto L24
    }

    @Override // java.net.URLConnection
    public final void addRequestProperty(String r10, String r11) {
        P(r10, r11, false);
    }

    @Override // java.net.URLConnection
    public void connect() {
        getOutputStream();
        Q();
    }

    @Override // java.net.HttpURLConnection
    public void disconnect() {
        if (((HttpURLConnection) this).connected == false) goto L8;
        a0 r10 = this.f18958c;
        if (r10 == null) goto L9;
        r10.d();
        this.C = true;
        return;
    L9:
        return;
    }

    @Override // java.net.HttpURLConnection
    public InputStream getErrorStream() {
        K();     // Catch: IOException -> L9
        if (this.f18966k.c() < 400) goto L8;
        return this.f18964i;
    L8:
        return null;
    }

    @Override // java.net.URLConnection
    public final String getHeaderField(String r10) {
        K();     // Catch: IOException -> L9
        Map r11 = C();
        if (r11.containsKey(r10) == true) goto L7;
        return null;
    L7:
        List r12 = (List) r11.get(r10);
        return (String) r12.get(r12.size() - 1);
    L9:
        return null;
    }

    @Override // java.net.HttpURLConnection, java.net.URLConnection
    public final String getHeaderFieldKey(int r10) {
        Map.Entry r11 = F(r10);
        if (r11 != null) goto L7;
        return null;
    L7:
        return (String) r11.getKey();
    }

    @Override // java.net.URLConnection
    public Map getHeaderFields() {
        K();     // Catch: IOException -> L5
        return C();
    L6:
        return Collections.emptyMap();
    }

    @Override // java.net.URLConnection
    public InputStream getInputStream() {
        K();
        if (((HttpURLConnection) this).instanceFollowRedirects == true) goto L10;
        if (this.f18968m == false) goto L10;
        throw new IOException("Cannot read response body of a redirect.");
    L10:
        if (this.f18966k.c() >= 400) goto L14;
        return this.f18964i;
    L14:
        throw new FileNotFoundException(((HttpURLConnection) this).url.toString());
    }

    @Override // java.net.URLConnection
    public OutputStream getOutputStream() {
        if (this.f18965j != null) goto L27;
        if (((HttpURLConnection) this).doOutput == false) goto L27;
        if (((HttpURLConnection) this).connected == true) goto L25;
        if (M() == false) goto L11;
        this.f18965j = new b(this, ((HttpURLConnection) this).chunkLength, this.f18957b);
        Q();
        goto L27
    L11:
        long r10 = L();
        if (r10 == (-1)) goto L20;
        lf.c r11 = new lf.c(this, r10, this.f18957b);
        this.f18965j = r11;
        if (r10 != 0) goto L19;
        setFixedLengthStreamingMode((int) r11.d().a());
        if (getRequestProperty("Content-Length") != null) goto L18;
        addRequestProperty("Content-Length", Long.toString(this.f18965j.d().a()));
        goto L19
    L18:
        setRequestProperty("Content-Length", Long.toString(this.f18965j.d().a()));
    L19:
        Q();
        goto L27
    L20:
        String r12 = getRequestProperty("Content-Length");
        if (r12 != null) goto L23;
        this.f18965j = new lf.a(this);
        goto L27
    L23:
        this.f18965j = new lf.a(this, Long.parseLong(r12));
        goto L27
    L25:
        throw new ProtocolException("Cannot write to OutputStream after receiving response.");
    L27:
        return this.f18965j;
    }

    @Override // java.net.URLConnection
    public Map getRequestProperties() {
        if (((HttpURLConnection) this).connected == true) goto L15;
        TreeMap r10 = new TreeMap(String.CASE_INSENSITIVE_ORDER);
        Iterator r11 = this.f18959d.iterator();
    L6:
        if (r11.hasNext() == false) goto L13;
        Pair r12 = (Pair) r11.next();
        if (r10.containsKey(r12.first) == true) goto L11;
        ArrayList r13 = new ArrayList();
        r13.add((String) r12.second);
        r10.put((String) r12.first, Collections.unmodifiableList(r13));
        goto L6
    L11:
        throw new IllegalStateException("Should not have multiple values.");
    L13:
        return Collections.unmodifiableMap(r10);
    L15:
        throw new IllegalStateException("Cannot access request headers after connection is set.");
    }

    @Override // java.net.URLConnection
    public String getRequestProperty(String r10) {
        int r11 = B(r10);
        if (r11 >= 0) goto L5;
        return null;
    L5:
        return (String) ((Pair) this.f18959d.get(r11)).second;
    }

    @Override // java.net.HttpURLConnection
    public int getResponseCode() {
        K();
        return this.f18966k.c();
    }

    @Override // java.net.HttpURLConnection
    public String getResponseMessage() {
        K();
        return this.f18966k.d();
    }

    @Override // java.net.URLConnection
    @UsedByReflection("SsCronetHttpClient.java")
    public void setConnectTimeout(int r10) {
        super.setConnectTimeout(r10);
    }

    @UsedByReflection("SsCronetHttpClient.java")
    public void setException(IOException r10) {
        d r11 = this.f18964i;
        if (r11 == null) goto L5;
        r11.c(r10);
    L5:
        e r12 = this.f18965j;
        if (r12 == null) goto L8;
        r12.f(r10);
    L8:
        this.f18969n = true;
        this.f18967l = r10;
        a0 r13 = this.f18958c;
        if (r13 == null) goto L12;
        r13.d();
        return;
    }

    @UsedByReflection("SsCronetHttpClient.java")
    public void setInputStreamBufferSize(int r10) {
        this.f18977v = r10;
    }

    @UsedByReflection("SsCronetHttpClient.java")
    public void setRequestFlag(int r10) {
        this.f18981z = r10;
    }

    @UsedByReflection("SsCronetHttpClient.java")
    public void setRequestPriority(int r10) {
        this.f18972q = r10;
    }

    @Override // java.net.URLConnection
    @UsedByReflection("SsCronetHttpClient.java")
    public final void setRequestProperty(String r10, String r11) {
        P(r10, r11, true);
    }

    @UsedByReflection("SsCronetHttpClient.java")
    public void setRequestTimeout(int r10) {
        this.f18976u = r10;
    }

    @UsedByReflection("SsCronetHttpClient.java")
    public void setSocketConnectTimeout(int r10) {
        this.f18973r = r10;
    }

    @UsedByReflection("SsCronetHttpClient.java")
    public void setSocketReadTimeout(int r10) {
        this.f18974s = r10;
    }

    @UsedByReflection("SsCronetHttpClient.java")
    public void setSocketWriteTimeout(int r10) {
        this.f18975t = r10;
    }

    @UsedByReflection("SsCronetHttpClient.java")
    public void setThrottleNetSpeed(long r10) {
        this.A = r10;
        a0 r11 = this.f18958c;
        if (r11 == null) goto L6;
        r11.i(r10);
        return;
    }

    @UsedByReflection("SsCronetHttpClient.java")
    public void setTrafficStatsTag(int r10) {
        if (((HttpURLConnection) this).connected == true) goto L7;
        this.f18960e = true;
        this.f18961f = r10;
        return;
    L7:
        throw new IllegalStateException("Cannot modify traffic stats tag after connection is made.");
    }

    @UsedByReflection("SsCronetHttpClient.java")
    public void setTrafficStatsUid(int r10) {
        if (((HttpURLConnection) this).connected == true) goto L7;
        this.f18962g = true;
        this.f18963h = r10;
        return;
    L7:
        throw new IllegalStateException("Cannot modify traffic stats UID after connection is made.");
    }

    @Override // java.net.HttpURLConnection
    public boolean usingProxy() {
        return false;
    }

    public final void x() {
        if (this.f18969n == false) goto L13;
        IOException r10 = this.f18967l;
        if (r10 == null) goto L7;
        throw r10;
    L7:
        if (this.f18966k == null) goto L10;
        return;
    L10:
        throw new NullPointerException("Response info is null when there is no exception.");
    L13:
        throw new IllegalStateException("No response.");
    }

    public final boolean y() {
        if (this.f18960e == false) goto L5;
        return true;
    L5:
        int r10 = TrafficStats.getThreadStatsTag();
        if (r10 == (-1)) goto L9;
        this.f18961f = r10;
        this.f18960e = true;
    L9:
        return this.f18960e;
    }

    public final boolean z() {
        if (this.f18962g == false) goto L5;
        return true;
    L5:
        int r10 = TrafficStats.getThreadStatsUid();
        if (r10 == (-1)) goto L9;
        this.f18963h = r10;
        this.f18962g = true;
    L9:
        return this.f18962g;
    }

    @Override // java.net.HttpURLConnection, java.net.URLConnection
    public final String getHeaderField(int r10) {
        Map.Entry r11 = F(r10);
        if (r11 != null) goto L7;
        return null;
    L7:
        return (String) r11.getValue();
    }
}
