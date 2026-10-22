package com.ttnet.org.chromium.net.urlconnection;

import android.net.TrafficStats;
import android.os.Build;
import android.text.TextUtils;
import android.util.Pair;
import com.ss.android.socialbase.downloader.utils.DownloadHelper;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import com.ttnet.org.chromium.base.j;
import com.ttnet.org.chromium.base.k;
import com.ttnet.org.chromium.base.n;
import com.ttnet.org.chromium.net.ai;
import com.ttnet.org.chromium.net.aj;
import com.ttnet.org.chromium.net.o;
import com.ttnet.org.chromium.net.w;
import com.volcengine.zeus.transform.ZeusTransformUtils;
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
import java.util.Objects;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicBoolean;
import org.apache.http.conn.ConnectTimeoutException;

/* JADX INFO: loaded from: classes4.dex */
public class CronetHttpURLConnection extends HttpURLConnection {
    private static final String TAG = "CronetHttpURLConnection";
    private long A;
    private int B;
    private String C;
    private String D;
    private int E;
    private String F;
    private final AtomicBoolean G;
    private final AtomicBoolean H;
    private boolean I;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.ttnet.org.chromium.net.d f38259a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final g f38260b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private ai f38261c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final List<Pair<String, String>> f38262d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f38263e;
    private int f;
    private boolean g;
    private int h;
    private d i;
    private f j;
    private aj k;
    private IOException l;
    private boolean m;
    private boolean n;
    private List<Map.Entry<String, String>> o;
    private Map<String, List<String>> p;
    private int q;
    private int r;
    private int s;
    private int t;
    private int u;
    private int v;
    private int w;
    private w.a x;
    private CookieHandler y;
    private int z;

    private class a extends ai.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ CronetHttpURLConnection f38264a;

        public a(CronetHttpURLConnection r1) {
            this.f38264a = r1;
        }

        @Override // com.ttnet.org.chromium.net.ai.b
        public void a(ai r4, aj r5, String r6) {
            CronetHttpURLConnection.a(this.f38264a, r5);
            CronetHttpURLConnection.a(this.f38264a, true);
            if (CronetHttpURLConnection.a(this.f38264a) == null) goto L8;
            long r0 = System.nanoTime();
            CronetHttpURLConnection r7 = this.f38264a;
            CronetHttpURLConnection.a(r7, r6, CronetHttpURLConnection.b(r7));
            long r8 = (System.nanoTime() - r0) / 1000;
            if (r4 == null) goto L8;
            r4.c(r8);
        L8:
            if (k.a() == false) goto L10;
            k.a("CronetHttpURLConnection", "onResponseStarted loop quit url = " + this.f38264a.getURL().toString());
        L10:
            CronetHttpURLConnection.c(this.f38264a).c();
        }

        @Override // com.ttnet.org.chromium.net.ai.b
        public void a(ai r1, aj r2, ByteBuffer r3) {
            CronetHttpURLConnection.a(this.f38264a, r2);
            CronetHttpURLConnection.c(this.f38264a).c();
        }

        @Override // com.ttnet.org.chromium.net.ai.b
        public void a(ai r5, aj r6, String r7, String r8) {
            boolean r1 = true;
            CronetHttpURLConnection.b(this.f38264a, true);
            if (r6 == null) goto L5;
            CronetHttpURLConnection.a(this.f38264a, r8, r6.d());
        L5:
            URL r0 = CronetHttpURLConnection.d(this.f38264a);
            if (TextUtils.isEmpty(r8) == true) goto L43;
            r0 = new URL(r8);     // Catch: Throwable -> L39
        L43:
            URL r9 = new URL(r7);     // Catch: MalformedURLException -> L40
            if (CronetHttpURLConnection.e(this.f38264a) == false) goto L13;
            CronetHttpURLConnection.a(this.f38264a, r9);     // Catch: MalformedURLException -> L40
        L13:
            if (CronetHttpURLConnection.f(this.f38264a) == false) goto L35;
            if (CronetHttpURLConnection.g(this.f38264a) != null) goto L17;
            return;
        L17:
            if ("http".equals(r9.getProtocol()) == true) goto L19;
        L21:
            r1 = false;
        L23:
            if (r9.getHost().equals(r0.getHost()) == false) goto L25;
            if (r1 == true) goto L25;
        L33:
            CronetHttpURLConnection.g(this.f38264a).b();     // Catch: MalformedURLException -> L40
            return;
        L25:
            CronetHttpURLConnection.g(this.f38264a).d();     // Catch: MalformedURLException -> L40
            URL r10 = new URL(r7);     // Catch: MalformedURLException -> L40
            CronetHttpURLConnection r11 = this.f38264a;     // Catch: MalformedURLException -> L40
            Map r12 = CronetHttpURLConnection.a(r11, r11.a(r10));     // Catch: MalformedURLException -> L40
            if (r12 == null) goto L33;
            if (r12.isEmpty() == true) goto L33;
            Iterator r13 = r12.entrySet().iterator();     // Catch: MalformedURLException -> L40
        L31:
            if (r13.hasNext() == false) goto L33;
            Map.Entry r14 = (Map.Entry) ZeusTransformUtils.preCheckCast(r13.next(), Map.Entry.class, "com.obric.aiagent.plugin");     // Catch: MalformedURLException -> L40
            CronetHttpURLConnection.g(this.f38264a).b((String) ZeusTransformUtils.preCheckCast(r14.getKey(), String.class, "com.obric.aiagent.plugin"), (String) ZeusTransformUtils.preCheckCast(r14.getValue(), String.class, "com.obric.aiagent.plugin"));     // Catch: MalformedURLException -> L40
            goto L31
        L19:
            if ("https".equals(r0.getProtocol()) == false) goto L21;
        L35:
            CronetHttpURLConnection.a(this.f38264a, r6);
            if (CronetHttpURLConnection.g(this.f38264a) == null) goto L47;
            CronetHttpURLConnection.g(this.f38264a).e();
            return;
        }

        @Override // com.ttnet.org.chromium.net.ai.b
        public void a(ai r1, aj r2) {
            CronetHttpURLConnection.a(this.f38264a, r2);
            a(null);
        }

        @Override // com.ttnet.org.chromium.net.ai.b
        public void a(ai r2, aj r3, com.ttnet.org.chromium.net.e r4) {
            if (r4 == null) goto L6;
            CronetHttpURLConnection r5 = this.f38264a;
            CronetHttpURLConnection.a(r5, CronetHttpURLConnection.a(r5, r4));
            CronetHttpURLConnection.a(this.f38264a, r3);
            a(r4);
            return;
        L6:
            throw new IllegalStateException("Exception cannot be null in onFailed.");
        }

        @Override // com.ttnet.org.chromium.net.ai.b
        public void b(ai r2, aj r3) {
            CronetHttpURLConnection.a(this.f38264a, r3);
            if (k.a() == false) goto L6;
            k.a("CronetHttpURLConnection", "onCanceled loop quit url = " + this.f38264a.getURL().toString());
        L6:
            if (CronetHttpURLConnection.h(this.f38264a) == null) goto L8;
        L10:
            a(CronetHttpURLConnection.h(this.f38264a));
            return;
        L8:
            if (CronetHttpURLConnection.i(this.f38264a) == true) goto L10;
            StringBuilder r4 = new StringBuilder("request canceled");
            r4.append(", ErrorCode=").append(11).append(", InternalErrorCode=").append(-999);
            CronetHttpURLConnection.a(this.f38264a, new i(r4.toString()));
            goto L10
        }

        private void a(IOException r2) {
            CronetHttpURLConnection.a(this.f38264a, r2);
            if (CronetHttpURLConnection.j(this.f38264a) == null) goto L6;
            CronetHttpURLConnection.j(this.f38264a).a(r2);
        L6:
            if (CronetHttpURLConnection.k(this.f38264a) == null) goto L8;
            CronetHttpURLConnection.k(this.f38264a).a(r2);
        L8:
            CronetHttpURLConnection.a(this.f38264a, true);
            CronetHttpURLConnection.l(this.f38264a).set(true);
            CronetHttpURLConnection.c(this.f38264a).c();
        }
    }

    static {
    }

    @Override // java.net.HttpURLConnection
    public boolean usingProxy() {
        return false;
    }

    static /* synthetic */ aj a(CronetHttpURLConnection r0) {
        return r0.k;
    }

    static /* synthetic */ aj a(CronetHttpURLConnection r0, aj r1) {
        r0.k = r1;
        return r1;
    }

    static /* synthetic */ IOException a(CronetHttpURLConnection r0, com.ttnet.org.chromium.net.e r1) {
        return r0.a(r1);
    }

    static /* synthetic */ IOException a(CronetHttpURLConnection r0, IOException r1) {
        r0.l = r1;
        return r1;
    }

    static /* synthetic */ URL a(CronetHttpURLConnection r0, URL r1) {
        r0.url = r1;
        return r1;
    }

    static /* synthetic */ Map a(CronetHttpURLConnection r0, URI r1) {
        return r0.a(r1);
    }

    static /* synthetic */ void a(CronetHttpURLConnection r2, String r3, Map r4) {
        r2.a(r3, (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.aiagent.plugin"));
    }

    static /* synthetic */ boolean a(CronetHttpURLConnection r0, boolean r1) {
        r0.n = r1;
        return r1;
    }

    static /* synthetic */ Map b(CronetHttpURLConnection r0) {
        return r0.l();
    }

    static /* synthetic */ boolean b(CronetHttpURLConnection r0, boolean r1) {
        r0.m = r1;
        return r1;
    }

    static /* synthetic */ g c(CronetHttpURLConnection r0) {
        return r0.f38260b;
    }

    static /* synthetic */ URL d(CronetHttpURLConnection r0) {
        return r0.url;
    }

    static /* synthetic */ boolean e(CronetHttpURLConnection r0) {
        return r0.instanceFollowRedirects;
    }

    static /* synthetic */ boolean f(CronetHttpURLConnection r0) {
        return r0.instanceFollowRedirects;
    }

    static /* synthetic */ ai g(CronetHttpURLConnection r0) {
        return r0.f38261c;
    }

    static /* synthetic */ IOException h(CronetHttpURLConnection r0) {
        return r0.l;
    }

    static /* synthetic */ boolean i(CronetHttpURLConnection r0) {
        return r0.m;
    }

    static /* synthetic */ d j(CronetHttpURLConnection r0) {
        return r0.i;
    }

    static /* synthetic */ f k(CronetHttpURLConnection r0) {
        return r0.j;
    }

    static /* synthetic */ AtomicBoolean l(CronetHttpURLConnection r0) {
        return r0.H;
    }

    public CronetHttpURLConnection(URL r2, com.ttnet.org.chromium.net.d r3, boolean r4) {
        super(r2);
        this.G = new AtomicBoolean(false);
        this.H = new AtomicBoolean(false);
        this.I = false;
        this.f38259a = r3;
        this.f38260b = new g();
        if (r4 == false) goto L5;
        this.i = new e(this);
    L6:
        this.f38262d = new ArrayList();
        this.y = CookieHandler.getDefault();
        this.E = -1;
        return;
    L5:
        this.i = new d(this);
        goto L6
    }

    @Override // java.net.URLConnection
    public void connect() {
        getOutputStream();
        f();
    }

    @Override // java.net.HttpURLConnection
    public void disconnect() {
        if (this.connected == false) goto L27;
        ai r0 = this.f38261c;
        if (r0 == null) goto L28;
        r0.e();
    L22:
        e = move-exception;
        e.printStackTrace();
        return;
    L8:
        if (this.G.compareAndSet(false, true) == true) goto L11;
        return;
    L11:
        if (this.I == true) goto L14;
        return;
    L14:
        if (this.H.get() == false) goto L17;
        return;
    L17:
        if (this.f38260b.a() == true) goto L19;
        return;
    L19:
        if (this.f38260b.d() == true) goto L30;
        this.f38260b.a(50);     // Catch: Exception -> L22
        return;
    L30:
        return;
    L28:
        return;
    }

    @Override // java.net.HttpURLConnection
    public String getResponseMessage() {
        i();
        return this.k.b();
    }

    @Override // java.net.HttpURLConnection
    public int getResponseCode() {
        i();
        return this.k.a();
    }

    @Override // java.net.URLConnection
    public Map<String, List<String>> getHeaderFields() {
        i();     // Catch: IOException -> L5
        return l();
    L6:
        return Collections.emptyMap();
    }

    @Override // java.net.URLConnection
    public final String getHeaderField(String r3) {
        i();     // Catch: IOException -> L9
        Map<String, List<String>> r2 = l();
        if (r2.containsKey(r3) == true) goto L7;
        return null;
    L7:
        List r4 = (List) ZeusTransformUtils.preCheckCast(r2.get(r3), List.class, "com.obric.aiagent.plugin");
        return (String) ZeusTransformUtils.preCheckCast(r4.get(r4.size() - 1), String.class, "com.obric.aiagent.plugin");
    L9:
        return null;
    }

    @Override // java.net.HttpURLConnection, java.net.URLConnection
    public final String getHeaderFieldKey(int r2) {
        Map.Entry<String, String> r1 = b(r2);
        if (r1 != null) goto L7;
        return null;
    L7:
        return (String) ZeusTransformUtils.preCheckCast(r1.getKey(), String.class, "com.obric.aiagent.plugin");
    }

    @Override // java.net.HttpURLConnection, java.net.URLConnection
    public final String getHeaderField(int r2) {
        Map.Entry<String, String> r1 = b(r2);
        if (r1 != null) goto L7;
        return null;
    L7:
        return (String) ZeusTransformUtils.preCheckCast(r1.getValue(), String.class, "com.obric.aiagent.plugin");
    }

    @Override // java.net.URLConnection
    public InputStream getInputStream() {
        i();
        if (this.instanceFollowRedirects == true) goto L10;
        if (this.m == false) goto L10;
        throw new IOException("Cannot read response body of a redirect.");
    L10:
        if (this.k.a() >= 400) goto L14;
        return this.i;
    L14:
        throw new FileNotFoundException(this.url.toString());
    }

    @Override // java.net.URLConnection
    public OutputStream getOutputStream() {
        if (this.j != null) goto L27;
        if (this.doOutput == false) goto L27;
        if (this.connected == true) goto L25;
        if (k() == false) goto L11;
        this.j = new b(this, this.chunkLength, this.f38260b);
        f();
        goto L27
    L11:
        long r0 = d();
        if (r0 == (-1)) goto L20;
        c r2 = new c(this, r0, this.w, this.f38260b);
        this.j = r2;
        if (r0 != 0) goto L19;
        setFixedLengthStreamingMode((int) r2.c().a());
        if (getRequestProperty(DownloadUtils.CONTENT_LENGTH) != null) goto L18;
        addRequestProperty(DownloadUtils.CONTENT_LENGTH, Long.toString(this.j.c().a()));
        goto L19
    L18:
        setRequestProperty(DownloadUtils.CONTENT_LENGTH, Long.toString(this.j.c().a()));
    L19:
        f();
        goto L27
    L20:
        j.b(TAG, "Outputstream is being buffered in memory.", new Object[0]);
        String r1 = getRequestProperty(DownloadUtils.CONTENT_LENGTH);
        if (r1 != null) goto L23;
        this.j = new com.ttnet.org.chromium.net.urlconnection.a(this);
        goto L27
    L23:
        this.j = new com.ttnet.org.chromium.net.urlconnection.a(this, Long.parseLong(r1));
        goto L27
    L25:
        throw new ProtocolException("Cannot write to OutputStream after receiving response.");
    L27:
        return this.j;
    }

    private long d() {
        long r0 = this.fixedContentLength;
        if (this.fixedContentLengthLong != (-1)) goto L5;
        return r0;
    L5:
        return this.fixedContentLengthLong;
    }

    private Map<String, String> a(URI r11) {
        HashMap r0 = new HashMap();
        if ((this.B & 2) > 0) goto L67;
        if (e() == false) goto L67;
        HashMap r1 = new HashMap();
        List<Pair<String, String>> r2 = this.f38262d;
        if (r2 == null) goto L16;
        Iterator<Pair<String, String>> r3 = r2.iterator();
    L11:
        if (r3.hasNext() == false) goto L16;
        Pair r4 = (Pair) ZeusTransformUtils.preCheckCast(r3.next(), Pair.class, "com.obric.aiagent.plugin");
        String r5 = (String) ZeusTransformUtils.preCheckCast(r4.first, String.class, "com.obric.aiagent.plugin");
        String r6 = (String) ZeusTransformUtils.preCheckCast(r4.second, String.class, "com.obric.aiagent.plugin");
        List r7 = (List) ZeusTransformUtils.preCheckCast(r1.get(r5), List.class, "com.obric.aiagent.plugin");
        if (r7 != null) goto L15;
        r7 = new LinkedList();
    L15:
        r7.add(r6);
        r1.put(r5, r7);
    L16:
        r1.put("x-tt-get-cookie-source", new LinkedList());
        r1.put("x-tt-cookie-rel-metric", new LinkedList());
        if ((this.B & 1) == 0) goto L19;
        r1.put("x-tt-webview-request", new LinkedList());
    L19:
        Map<String, List<String>> r8 = null;
    L27:
        e = move-exception;
        if (k.a() == false) goto L31;
        k.a(TAG, "Loading cookies failed for " + getURL().toString() + " e = " + e.getMessage());
    L31:
        if (r8 != null) goto L33;
    L65:
        return r0;
    L33:
        if (r8.size() <= 0) goto L65;
        Iterator<Map.Entry<String, List<String>>> r12 = r8.entrySet().iterator();
    L36:
        if (r12.hasNext() == false) goto L65;
        Map.Entry r9 = (Map.Entry) ZeusTransformUtils.preCheckCast(r12.next(), Map.Entry.class, "com.obric.aiagent.plugin");
        String r10 = (String) ZeusTransformUtils.preCheckCast(r9.getKey(), String.class, "com.obric.aiagent.plugin");
        int r13 = 0;
        if ("x-tt-get-cookie-source".equals(r10) == false) goto L45;
        if (((List) ZeusTransformUtils.preCheckCast(r9.getValue(), List.class, "com.obric.aiagent.plugin")).isEmpty() == true) goto L45;
        this.E = Integer.parseInt((String) ZeusTransformUtils.preCheckCast(((List) ZeusTransformUtils.preCheckCast(r9.getValue(), List.class, "com.obric.aiagent.plugin")).get(0), String.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L43
    L49:
        StringBuilder r14 = new StringBuilder();
        if ("X-SS-Cookie".equalsIgnoreCase(r10) == true) goto L56;
        if ("Cookie".equalsIgnoreCase(r10) == true) goto L56;
        if ("Cookie2".equalsIgnoreCase(r10) == false) goto L36;
    L56:
        if (((List) ZeusTransformUtils.preCheckCast(r9.getValue(), List.class, "com.obric.aiagent.plugin")).isEmpty() == true) goto L36;
        Iterator r15 = ((List) ZeusTransformUtils.preCheckCast(r9.getValue(), List.class, "com.obric.aiagent.plugin")).iterator();
    L59:
        if (r15.hasNext() == false) goto L64;
        String r16 = (String) ZeusTransformUtils.preCheckCast(r15.next(), String.class, "com.obric.aiagent.plugin");
        if (r13 <= 0) goto L63;
        r14.append("; ");
    L63:
        r14.append(r16);
        r13 = r13 + 1;
        goto L59
    L64:
        r0.put(r10, r14.toString());
    L43:
        this.E = -1;
    L45:
        if ("x-tt-cookie-rel-metric".equals(r10) == false) goto L49;
        if (((List) ZeusTransformUtils.preCheckCast(r9.getValue(), List.class, "com.obric.aiagent.plugin")).isEmpty() == true) goto L49;
        this.F = (String) ZeusTransformUtils.preCheckCast(((List) ZeusTransformUtils.preCheckCast(r9.getValue(), List.class, "com.obric.aiagent.plugin")).get(0), String.class, "com.obric.aiagent.plugin");
        goto L49
    L21:
        if (this.y != null) goto L23;
        this.y = CookieHandler.getDefault();     // Catch: Exception -> L27
    L23:
        CookieHandler r17 = this.y;     // Catch: Exception -> L27
        if (r17 == null) goto L31;
        r8 = r17.get(r11, r1);     // Catch: Exception -> L27
    L67:
        if (k.a() == false) goto L69;
        k.a(TAG, "Do not read cookie from TTNet, url:" + r11);
    L69:
        return r0;
    }

    private void a(String r4, Map<String, List<String>> r5) {
        Map<String, List<String>> r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.aiagent.plugin");
        if (e() == true) goto L9;
        if (k.a() == false) goto L37;
        k.a(TAG, "Do not write cookie from TTNet, url:" + r4);
        return;
    L37:
        return;
    L9:
        if (k.a() == false) goto L36;
        String r0 = TAG;
        StringBuilder r1 = new StringBuilder().append("Saving cookies for url: ");
        if (TextUtils.isEmpty(r4) == false) goto L13;
        String r2 = getURL().toString();
    L14:
        k.a(r0, r1.append(r2).toString());
        goto L36
    L13:
        r2 = r4;
    L36:
    L28:
        e = move-exception;
        if (k.a() == false) goto L41;
        String r3 = TAG;
        StringBuilder r7 = new StringBuilder().append("Saving cookies failed for ");
        if (TextUtils.isEmpty(r4) == false) goto L34;
        r4 = getURL().toString();
    L34:
        k.a(r3, r7.append(r4).append(" e = ").append(e.getMessage()).toString());
        return;
    L41:
        return;
    L16:
        if (this.y != null) goto L19;
        this.y = CookieHandler.getDefault();     // Catch: Exception -> L28
    L19:
        if (this.y != null) goto L21;
        return;
    L21:
        if (TextUtils.isEmpty(r4) == false) goto L23;
        this.y.put(a(getURL()), r6);     // Catch: Exception -> L28
        return;
    L23:
        URI r8 = a(new URL(r4));     // Catch: Exception -> L28
        if ((this.B & 1) == 0) goto L26;
        TreeMap r9 = new TreeMap(r6);     // Catch: Exception -> L28
        r9.put("webview-origin-url", Collections.singletonList(getURL().getHost()));     // Catch: Exception -> L28
        this.y.put(r8, r9);     // Catch: Exception -> L28
        return;
    L26:
        this.y.put(r8, r6);     // Catch: Exception -> L28
    }

    private boolean e() {
        String r1 = getRequestProperty("x-ttnet-bypass-cookie");
        if (TextUtils.isEmpty(r1) == false) goto L5;
        return true;
    L5:
        if ("0".equals(r1) == false) goto L10;
        return false;
    L10:
        return true;
    }

    public void configureConnection(String r6, Object... r7) {
        r6.hashCode();
        byte r4 = -1;
        switch(r6.hashCode()) {
            case -2098478356: goto L50;
            case -1400774487: goto L46;
            case -1262337831: goto L42;
            case -976756188: goto L38;
            case -722926986: goto L34;
            case -534987466: goto L30;
            case -107284268: goto L26;
            case 166051698: goto L22;
            case 423591456: goto L18;
            case 1221363607: goto L14;
            case 1880243345: goto L10;
            case 2141877079: goto L6;
            default: goto L54;
        };
    L6:
        if (r6.equals("enableFixCancelRequestReport") == false) goto L54;
        r4 = 11;
        goto L54
    L10:
        if (r6.equals("setRequestPriority") == false) goto L54;
        r4 = 10;
        goto L54
    L14:
        if (r6.equals("setSocketWriteTimeout") == false) goto L54;
        r4 = 9;
        goto L54
    L18:
        if (r6.equals("setRequestTypeFlags") == false) goto L54;
        r4 = 8;
        goto L54
    L22:
        if (r6.equals("setAuthCredentials") == false) goto L54;
        r4 = 7;
        goto L54
    L26:
        if (r6.equals("setRequestTimeout") == false) goto L54;
        r4 = 6;
        goto L54
    L30:
        if (r6.equals("setSocketReadTimeout") == false) goto L54;
        r4 = 5;
        goto L54
    L34:
        if (r6.equals("setThrottleNetSpeed") == false) goto L54;
        r4 = 4;
        goto L54
    L38:
        if (r6.equals("setOutputStreamBufferSize") == false) goto L54;
        r4 = 3;
        goto L54
    L42:
        if (r6.equals("setRequestFlag") == false) goto L54;
        r4 = 2;
        goto L54
    L46:
        if (r6.equals("setInputStreamBufferSize") == false) goto L54;
        r4 = 1;
        goto L54
    L50:
        if (r6.equals("setSocketConnectTimeout") == false) goto L54;
        r4 = 0;
    L54:
        switch(r4) {
            case 0: goto L70;
            case 1: goto L69;
            case 2: goto L68;
            case 3: goto L67;
            case 4: goto L64;
            case 5: goto L63;
            case 6: goto L62;
            case 7: goto L61;
            case 8: goto L60;
            case 9: goto L59;
            case 10: goto L58;
            case 11: goto L57;
            default: goto L56;
        };
    L57:
        n.a(new Class[0], r7);
        this.I = true;
        return;
    L58:
        n.a(new Class[]{Integer.TYPE}, r7);
        this.q = ((Integer) ZeusTransformUtils.preCheckCast(r7[0], Integer.class, "com.obric.aiagent.plugin")).intValue();
        return;
    L59:
        n.a(new Class[]{Integer.TYPE}, r7);
        this.t = ((Integer) ZeusTransformUtils.preCheckCast(r7[0], Integer.class, "com.obric.aiagent.plugin")).intValue();
        return;
    L60:
        n.a(new Class[]{Integer.TYPE}, r7);
        this.B = ((Integer) ZeusTransformUtils.preCheckCast(r7[0], Integer.class, "com.obric.aiagent.plugin")).intValue();
        return;
    L61:
        n.a(new Class[]{String.class, String.class}, r7);
        this.C = (String) ZeusTransformUtils.preCheckCast(r7[0], String.class, "com.obric.aiagent.plugin");
        this.D = (String) ZeusTransformUtils.preCheckCast(r7[1], String.class, "com.obric.aiagent.plugin");
        return;
    L62:
        n.a(new Class[]{Integer.TYPE}, r7);
        this.u = ((Integer) ZeusTransformUtils.preCheckCast(r7[0], Integer.class, "com.obric.aiagent.plugin")).intValue();
        return;
    L63:
        n.a(new Class[]{Integer.TYPE}, r7);
        this.s = ((Integer) ZeusTransformUtils.preCheckCast(r7[0], Integer.class, "com.obric.aiagent.plugin")).intValue();
        return;
    L64:
        n.a(new Class[]{Long.TYPE}, r7);
        long r8 = ((Long) ZeusTransformUtils.preCheckCast(r7[0], Long.class, "com.obric.aiagent.plugin")).longValue();
        this.A = r8;
        ai r5 = this.f38261c;
        if (r5 == null) goto L79;
        r5.a(r8);
        return;
    L79:
        return;
    L67:
        n.a(new Class[]{Integer.TYPE}, r7);
        this.w = ((Integer) ZeusTransformUtils.preCheckCast(r7[0], Integer.class, "com.obric.aiagent.plugin")).intValue();
        return;
    L68:
        n.a(new Class[]{Integer.TYPE}, r7);
        this.z = ((Integer) ZeusTransformUtils.preCheckCast(r7[0], Integer.class, "com.obric.aiagent.plugin")).intValue();
        return;
    L69:
        n.a(new Class[]{Integer.TYPE}, r7);
        this.v = ((Integer) ZeusTransformUtils.preCheckCast(r7[0], Integer.class, "com.obric.aiagent.plugin")).intValue();
        return;
    L70:
        n.a(new Class[]{Integer.TYPE}, r7);
        this.r = ((Integer) ZeusTransformUtils.preCheckCast(r7[0], Integer.class, "com.obric.aiagent.plugin")).intValue();
        return;
    L56:
        throw new IllegalArgumentException("Unknown method name: " + r6);
    }

    public void setRequestPriority(int r1) {
        this.q = r1;
    }

    public void setSocketConnectTimeout(int r1) {
        this.r = r1;
    }

    public void setSocketReadTimeout(int r1) {
        this.s = r1;
    }

    public void setSocketWriteTimeout(int r1) {
        this.t = r1;
    }

    public void setRequestTimeout(int r1) {
        this.u = r1;
    }

    public void setThrottleNetSpeed(long r1) {
        this.A = r1;
        ai r0 = this.f38261c;
        if (r0 == null) goto L6;
        r0.a(r1);
        return;
    }

    public void setRequestTypeFlags(int r2) {
        this.B = r2 | this.B;
    }

    public void setInputStreamBufferSize(int r1) {
        this.v = r1;
    }

    public void setOutputStreamBufferSize(int r1) {
        this.w = r1;
    }

    public int a() {
        return this.v;
    }

    public void b() {
        ai r0 = this.f38261c;
        if (r0 == null) goto L6;
        r0.c();
        return;
    }

    public void setRequestFlag(int r1) {
        this.z = r1;
    }

    public void setAuthCredentials(String r1, String r2) {
        this.C = r1;
        this.D = r2;
    }

    public void enableFixCancelRequestReport() {
        this.I = true;
    }

    public void a(w.a r1) {
        this.x = r1;
    }

    public int c() {
        if (ZeusTransformUtils.instanceOf(this.l, o.class) == false) goto L7;
        return ((o) ZeusTransformUtils.preCheckCast(this.l, o.class, "com.obric.aiagent.plugin")).getCronetInternalErrorCode();
    L7:
        if (ZeusTransformUtils.instanceOf(this.l, i.class) == true) goto L9;
        return 0;
    L9:
        return ((i) ZeusTransformUtils.preCheckCast(this.l, i.class, "com.obric.aiagent.plugin")).a();
    }

    @Override // java.net.HttpURLConnection
    public void setRequestMethod(String r2) {
        if ("PATCH".equals(r2) == true) goto L5;
        super.setRequestMethod(r2);
        return;
    L5:
        if (this.connected == true) goto L8;
        this.method = r2;
        return;
    L8:
        throw new ProtocolException("Can't reset method: already connected");
    }

    public URI a(URL r3) {
        if (r3 != null) goto L5;
        return null;
    L5:
        String r2 = r3.toString();
        return new URI(r2);
    L8:
        e = move-exception;
        return URI.create(r2.replaceAll("[\\u0000-\\u001F\\u007F-\\u009F\\p{javaWhitespace}]", ""));
    L16:
        return URI.create(r2.substring(0, r2.indexOf("?")));
    L15:
        throw new RuntimeException(e);
    }

    private IOException a(com.ttnet.org.chromium.net.e r3) {
        if (ZeusTransformUtils.instanceOf(r3, o.class) == true) goto L6;
        return r3;
    L6:
        switch(((o) ZeusTransformUtils.preCheckCast(r3, o.class, "com.obric.aiagent.plugin")).getErrorCode()) {
            case 1: goto L14;
            case 2: goto L13;
            case 3: goto L13;
            case 4: goto L12;
            case 5: goto L11;
            case 6: goto L10;
            case 7: goto L11;
            case 8: goto L9;
            case 9: goto L8;
            default: goto L17;
        };
    L8:
        IOException r2 = new NoRouteToHostException(r3.getMessage());
    L16:
        return r2;
    L9:
        r2 = new SocketException("reset by peer " + r3.getMessage());
        goto L16
    L10:
        r2 = new ConnectTimeoutException(r3.getMessage());
        goto L16
    L11:
        r2 = new ConnectException(r3.getMessage());
        goto L16
    L12:
        r2 = new SocketTimeoutException(r3.getMessage());
        goto L16
    L13:
        r2 = new ConnectException(r3.getMessage());
        goto L16
    L14:
        r2 = new UnknownHostException(r3.getMessage());
        goto L16
    L17:
        return r3;
    }

    private void a(int r3) {
        this.f38260b.a(r3);     // Catch: Exception -> L4 SocketTimeoutException -> L6
    L14:
        return;
    L6:
        ai r0 = this.f38261c;
        if (r0 == null) goto L13;
        r0.c();
        this.f38260b.b();
        this.f38260b.a(r3 / 2);
        return;
    L13:
        return;
    L4:
        e = move-exception;
        a("Unexpected request usage, caught in CronetHttpURLConnection.", e);
        this.f38260b.b();
        this.f38260b.a(r3 / 2);
    }

    public void a(String r1, Throwable r2) {
        ai r0 = this.f38261c;
        if (r0 == null) goto L6;
        r0.a(r1, r2);
        return;
    }

    private void f() {
        if (this.connected == false) goto L6;
        return;
    L6:
        if (k.a() == false) goto L8;
        k.a("CronetHttpURLConnection", "start request url = " + getURL().toString());
    L8:
        com.ttnet.org.chromium.net.i.a r0 = (com.ttnet.org.chromium.net.i.a) ZeusTransformUtils.preCheckCast(this.f38259a.a(getURL().toString(), new a(this), this.f38260b), com.ttnet.org.chromium.net.i.a.class, "com.obric.aiagent.plugin");
        if (this.doOutput == true) goto L11;
    L27:
        long r3 = System.nanoTime();
        Map<String, String> r1 = a(a(getURL()));
        if (r1 != null) goto L30;
    L35:
        long r5 = (System.nanoTime() - r3) / 1000;
        Iterator<Pair<String, String>> r2 = this.f38262d.iterator();
    L37:
        if (r2.hasNext() == false) goto L40;
        Pair r4 = (Pair) ZeusTransformUtils.preCheckCast(r2.next(), Pair.class, "com.obric.aiagent.plugin");
        r0.a((String) ZeusTransformUtils.preCheckCast(r4.first, String.class, "com.obric.aiagent.plugin"), (String) ZeusTransformUtils.preCheckCast(r4.second, String.class, "com.obric.aiagent.plugin"));
        goto L37
    L40:
        if (getUseCaches() == true) goto L42;
        r0.a();
    L42:
        r0.a(this.method);
        if (g() == false) goto L46;
        r0.a(this.f);
    L46:
        if (h() == false) goto L48;
        r0.b(this.h);
    L48:
        r0.c(this.q);
        r0.d(this.r);
        r0.e(this.s);
        r0.f(this.t);
        r0.g(this.u);
        r0.a(this.x);
        com.ttnet.org.chromium.net.i r6 = r0.b();
        this.f38261c = r6;
        int r7 = this.z;
        if (r7 == 0) goto L51;
        r6.b(r7);
    L51:
        int r8 = this.B;
        if (r8 <= 0) goto L54;
        this.f38261c.a(r8);
    L54:
        String r9 = this.C;
        if (r9 == null) goto L59;
        String r10 = this.D;
        if (r10 == null) goto L59;
        this.f38261c.a(r9, r10);
    L59:
        this.f38261c.b(r5);
        this.f38261c.c(this.E);
        this.f38261c.a(this.F);
        this.f38261c.a();
        long r11 = this.A;
        if (r11 <= 0) goto L62;
        this.f38261c.a(r11);
    L62:
        this.connected = true;
        return;
    L30:
        if (r1.isEmpty() == true) goto L35;
        Iterator<Map.Entry<String, String>> r12 = r1.entrySet().iterator();
    L33:
        if (r12.hasNext() == false) goto L35;
        Map.Entry r13 = (Map.Entry) ZeusTransformUtils.preCheckCast(r12.next(), Map.Entry.class, "com.obric.aiagent.plugin");
        r0.a((String) ZeusTransformUtils.preCheckCast(r13.getKey(), String.class, "com.obric.aiagent.plugin"), (String) ZeusTransformUtils.preCheckCast(r13.getValue(), String.class, "com.obric.aiagent.plugin"));
        goto L33
    L11:
        if (this.method.equals("GET") == false) goto L13;
        this.method = "POST";
    L13:
        f r14 = this.j;
        if (r14 == null) goto L22;
        r0.a(r14.c(), this.f38260b);
        if (getRequestProperty(DownloadUtils.CONTENT_LENGTH) == null) goto L18;
    L20:
        this.j.a();
    L25:
        if (getRequestProperty(DownloadHelper.CONTENT_TYPE) != null) goto L27;
        addRequestProperty(DownloadHelper.CONTENT_TYPE, "application/x-www-form-urlencoded");
        goto L27
    L18:
        if (k() == true) goto L20;
        addRequestProperty(DownloadUtils.CONTENT_LENGTH, Long.toString(this.j.c().a()));
        goto L20
    L22:
        if (getRequestProperty(DownloadUtils.CONTENT_LENGTH) != null) goto L25;
        addRequestProperty(DownloadUtils.CONTENT_LENGTH, "0");
        goto L25
    }

    private boolean g() {
        if (this.f38263e == false) goto L5;
        return true;
    L5:
        int r0 = TrafficStats.getThreadStatsTag();
        if (r0 == (-1)) goto L9;
        this.f = r0;
        this.f38263e = true;
    L9:
        return this.f38263e;
    }

    private boolean h() {
        if (this.g == false) goto L6;
        return true;
    L6:
        if (Build.VERSION.SDK_INT >= 28) goto L9;
        return false;
    L9:
        int r0 = TrafficStats.getThreadStatsUid();
        if (r0 == (-1)) goto L13;
        this.h = r0;
        this.g = true;
    L13:
        return this.g;
    }

    @Override // java.net.HttpURLConnection
    public InputStream getErrorStream() {
        i();     // Catch: IOException -> L9
        if (this.k.a() < 400) goto L8;
        return this.i;
    L8:
        return null;
    }

    @Override // java.net.URLConnection
    public final void addRequestProperty(String r2, String r3) {
        a(r2, r3, false);
    }

    @Override // java.net.URLConnection
    public final void setRequestProperty(String r2, String r3) {
        a(r2, r3, true);
    }

    private final void a(String r2, String r3, boolean r4) {
        if (this.connected == true) goto L13;
        int r0 = a(r2);
        if (r0 < 0) goto L10;
        if (r4 == false) goto L9;
        this.f38262d.remove(r0);
        goto L10
    L9:
        throw new UnsupportedOperationException("Cannot add multiple headers of the same key, " + r2 + ". crbug.com/432719.");
    L10:
        this.f38262d.add(Pair.create(r2, r3));
        return;
    L13:
        throw new IllegalStateException("Cannot modify request property after connection is made.");
    }

    @Override // java.net.URLConnection
    public Map<String, List<String>> getRequestProperties() {
        if (this.connected == true) goto L15;
        TreeMap r0 = new TreeMap(String.CASE_INSENSITIVE_ORDER);
        Iterator<Pair<String, String>> r6 = this.f38262d.iterator();
    L6:
        if (r6.hasNext() == false) goto L13;
        Pair r1 = (Pair) ZeusTransformUtils.preCheckCast(r6.next(), Pair.class, "com.obric.aiagent.plugin");
        if (r0.containsKey(r1.first) == true) goto L11;
        ArrayList r2 = new ArrayList();
        r2.add((String) ZeusTransformUtils.preCheckCast(r1.second, String.class, "com.obric.aiagent.plugin"));
        r0.put((String) ZeusTransformUtils.preCheckCast(r1.first, String.class, "com.obric.aiagent.plugin"), Collections.unmodifiableList(r2));
        goto L6
    L11:
        throw new IllegalStateException("Should not have multiple values.");
    L13:
        return Collections.unmodifiableMap(r0);
    L15:
        throw new IllegalStateException("Cannot access request headers after connection is set.");
    }

    @Override // java.net.URLConnection
    public String getRequestProperty(String r2) {
        int r3 = a(r2);
        if (r3 >= 0) goto L5;
        return null;
    L5:
        return (String) ZeusTransformUtils.preCheckCast(((Pair) ZeusTransformUtils.preCheckCast(this.f38262d.get(r3), Pair.class, "com.obric.aiagent.plugin")).second, String.class, "com.obric.aiagent.plugin");
    }

    @Override // java.net.URLConnection
    public void setConnectTimeout(int r1) {
        super.setConnectTimeout(r1);
    }

    void a(ByteBuffer r2) {
        ai r0 = this.f38261c;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.a(r2);
        a(getReadTimeout());
    }

    public void setTrafficStatsTag(int r2) {
        if (this.connected == true) goto L7;
        this.f38263e = true;
        this.f = r2;
        return;
    L7:
        throw new IllegalStateException("Cannot modify traffic stats tag after connection is made.");
    }

    public void setTrafficStatsUid(int r2) {
        if (this.connected == true) goto L7;
        this.g = true;
        this.h = r2;
        return;
    L7:
        throw new IllegalStateException("Cannot modify traffic stats UID after connection is made.");
    }

    private int a(String r5) {
        int r0 = 0;
    L4:
        if (r0 >= this.f38262d.size()) goto L9;
        if (((String) ZeusTransformUtils.preCheckCast(((Pair) ZeusTransformUtils.preCheckCast(this.f38262d.get(r0), Pair.class, "com.obric.aiagent.plugin")).first, String.class, "com.obric.aiagent.plugin")).equalsIgnoreCase(r5) == true) goto L7;
        r0 = r0 + 1;
        goto L4
    L7:
        return r0;
    L9:
        return -1;
    }

    private void i() {
        f r0 = this.j;
        if (r0 == null) goto L8;
        r0.b();
        if (k() == false) goto L8;
        this.j.close();
    L8:
        if (this.n == true) goto L13;
        f();
        if (k.a() == false) goto L12;
        k.a("CronetHttpURLConnection", "getResponse loop url = " + getURL().toString());
    L12:
        a(getConnectTimeout() + getReadTimeout());
        this.n = true;
    L13:
        j();
    }

    private void j() {
        if (this.n == false) goto L10;
        IOException r0 = this.l;
        if (r0 != null) goto L8;
        Objects.requireNonNull(this.k, "Response info is null when there is no exception.");
        return;
    L8:
        throw r0;
    L10:
        throw new IllegalStateException("No response.");
    }

    private Map.Entry<String, String> b(int r3) {
        i();     // Catch: IOException -> L9
        List<Map.Entry<String, String>> r2 = m();
        if (r3 < r2.size()) goto L8;
        return null;
    L8:
        return (Map.Entry) ZeusTransformUtils.preCheckCast(r2.get(r3), Map.Entry.class, "com.obric.aiagent.plugin");
    L9:
        return null;
    }

    private boolean k() {
        if (this.chunkLength <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    private Map<String, List<String>> l() {
        Map<String, List<String>> r0 = this.p;
        if (r0 == null) goto L5;
        return r0;
    L5:
        TreeMap r1 = new TreeMap(String.CASE_INSENSITIVE_ORDER);
        Iterator<Map.Entry<String, String>> r2 = m().iterator();
    L7:
        if (r2.hasNext() == false) goto L12;
        Map.Entry r3 = (Map.Entry) ZeusTransformUtils.preCheckCast(r2.next(), Map.Entry.class, "com.obric.aiagent.plugin");
        ArrayList r4 = new ArrayList();
        if (r1.containsKey(r3.getKey()) == false) goto L11;
        r4.addAll((Collection) ZeusTransformUtils.preCheckCast(r1.get(r3.getKey()), Collection.class, "com.obric.aiagent.plugin"));
    L11:
        r4.add((String) ZeusTransformUtils.preCheckCast(r3.getValue(), String.class, "com.obric.aiagent.plugin"));
        r1.put((String) ZeusTransformUtils.preCheckCast(r3.getKey(), String.class, "com.obric.aiagent.plugin"), Collections.unmodifiableList(r4));
        goto L7
    L12:
        Map<String, List<String>> r5 = Collections.unmodifiableMap(r1);
        this.p = r5;
        return r5;
    }

    private List<Map.Entry<String, String>> m() {
        List<Map.Entry<String, String>> r0 = this.o;
        if (r0 == null) goto L5;
        return r0;
    L5:
        this.o = new ArrayList();
        Iterator<Map.Entry<String, String>> r1 = this.k.c().iterator();
    L7:
        if (r1.hasNext() == false) goto L9;
        Map.Entry r2 = (Map.Entry) ZeusTransformUtils.preCheckCast(r1.next(), Map.Entry.class, "com.obric.aiagent.plugin");
        this.o.add(new AbstractMap.SimpleImmutableEntry(r2));
        goto L7
    L9:
        List<Map.Entry<String, String>> r3 = Collections.unmodifiableList(this.o);
        this.o = r3;
        return r3;
    }
}
