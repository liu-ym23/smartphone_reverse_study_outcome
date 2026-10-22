package com.bumptech.glide.load.a;

import android.text.TextUtils;
import android.util.Log;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.obric.aiagent.platform.depend.ILogDepend;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Iterator;
import java.util.Map;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: compiled from: HttpUrlFetcher.java */
/* JADX INFO: loaded from: classes.dex */
public class j implements d<InputStream> {
    private static final String TAG = "HttpUrlFetcher";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final b f3381a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.bumptech.glide.load.b.g f3382b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f3383c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final b f3384d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private HttpURLConnection f3385e;
    private InputStream f;
    private volatile boolean g;

    /* JADX INFO: compiled from: HttpUrlFetcher.java */
    private static class a implements b {
        a() {
        }

        @Override // com.bumptech.glide.load.a.j.b
        public HttpURLConnection a(URL r2) {
            return (HttpURLConnection) ZeusTransformUtils.preCheckCast(b(r2), HttpURLConnection.class, "com.obric.aiagent.plugin");
        }

        @Skip({"com.obric.aiagent.okhttp"})
        public static URLConnection b(URL r4) {
            URL r0 = (URL) ZeusTransformUtils.preCheckCast(r4, URL.class, "com.obric.aiagent.plugin");
            String r1 = r0.getHost();
            String r2 = r0.getPath();
            if (com.obric.aiagent.a.b.a(r1, r2) == false) goto L5;
            ILogDepend.Companion.i("AiAgentUrlConnLancet", "openConnection drop host=" + r1 + " path=" + r2);
            com.obric.aiagent.a.b.a(com.obric.aiagent.a.b.b(r1, r2), r1, r2);
            throw new IOException("[NetGuard] dropped ");
        L5:
            return r4.openConnection();
        }
    }

    /* JADX INFO: compiled from: HttpUrlFetcher.java */
    interface b {
        HttpURLConnection a(URL r1);
    }

    static {
        f3381a = new a();
    }

    public j(com.bumptech.glide.load.b.g r2, int r3) {
        this(r2, r3, f3381a);
    }

    j(com.bumptech.glide.load.b.g r3, int r4, b r5) {
        b r6 = (b) ZeusTransformUtils.wrapperContextForParams(r5, b.class, "com.obric.aiagent.plugin");
        this.f3382b = r3;
        this.f3383c = r4;
        this.f3384d = r6;
    }

    @Override // com.bumptech.glide.load.a.d
    public void a(com.bumptech.glide.e r9, d.a<? super InputStream> r10) {
        d.a r11 = (d.a) ZeusTransformUtils.wrapperContextForParams(r10, d.a.class, "com.obric.aiagent.plugin");
        long r1 = com.bumptech.glide.f.f.a();
        r11.a(a(this.f3382b.a(), 0, null, this.f3382b.b()));     // Catch: Throwable -> L7 IOException -> L9
    L5:
        if (a(TAG, 2) == false) goto L26;
        StringBuilder r8 = new StringBuilder();
    L18:
        a(TAG, r8.append("Finished http url fetcher fetch in ").append(com.bumptech.glide.f.f.a(r1)).toString());
        return;
    L26:
        return;
    L7:
        th = move-exception;
        if (a(TAG, 2) == false) goto L23;
        a(TAG, "Finished http url fetcher fetch in " + com.bumptech.glide.f.f.a(r1));
    L23:
        throw th;
    L9:
        e = move-exception;
        if (a(TAG, 3) == false) goto L14;
        a(TAG, "Failed to load data for url", e);     // Catch: Throwable -> L7
    L14:
        r11.a(e);     // Catch: Throwable -> L7
        if (a(TAG, 2) == false) goto L27;
        r8 = new StringBuilder();
        goto L18
    }

    private InputStream a(URL r6, int r7, URL r8, Map<String, String> r9) {
        Map<String, String> r10 = (Map) ZeusTransformUtils.wrapperContextForParams(r9, Map.class, "com.obric.aiagent.plugin");
        if (r7 >= 5) goto L37;
        if (r8 != null) goto L39;
    L10:
        this.f3385e = this.f3384d.a(r6);
        Iterator<Map.Entry<String, String>> r11 = r10.entrySet().iterator();
    L12:
        if (r11.hasNext() == false) goto L14;
        Map.Entry r0 = (Map.Entry) ZeusTransformUtils.preCheckCast(r11.next(), Map.Entry.class, "com.obric.aiagent.plugin");
        this.f3385e.addRequestProperty((String) ZeusTransformUtils.preCheckCast(r0.getKey(), String.class, "com.obric.aiagent.plugin"), (String) ZeusTransformUtils.preCheckCast(r0.getValue(), String.class, "com.obric.aiagent.plugin"));
        goto L12
    L14:
        this.f3385e.setConnectTimeout(this.f3383c);
        this.f3385e.setReadTimeout(this.f3383c);
        this.f3385e.setUseCaches(false);
        this.f3385e.setDoInput(true);
        this.f3385e.setInstanceFollowRedirects(false);
        a(this.f3385e);
        this.f = this.f3385e.getInputStream();
        if (this.g == false) goto L18;
        return null;
    L18:
        int r12 = this.f3385e.getResponseCode();
        if (a(r12) == false) goto L23;
        return b(this.f3385e);
    L23:
        if (b(r12) == false) goto L31;
        String r13 = this.f3385e.getHeaderField("Location");
        if (TextUtils.isEmpty(r13) == true) goto L29;
        URL r1 = new URL(r6, r13);
        b();
        return a(r1, r7 + 1, r6, r10);
    L29:
        throw new com.bumptech.glide.load.e("Received empty or null redirect url");
    L31:
        if (r12 != (-1)) goto L35;
        throw new com.bumptech.glide.load.e(r12);
    L35:
        throw new com.bumptech.glide.load.e(this.f3385e.getResponseMessage(), r12);
    L39:
        if (r6.toURI().equals(r8.toURI()) == false) goto L10;
        throw new com.bumptech.glide.load.e("In re-direct loop");     // Catch: URISyntaxException -> L38
    L37:
        throw new com.bumptech.glide.load.e("Too many (> 5) redirects!");
    }

    private static boolean a(int r1) {
        if ((r1 / 100) != 2) goto L5;
        return true;
    L5:
        return false;
    }

    private static boolean b(int r1) {
        if ((r1 / 100) != 3) goto L5;
        return true;
    L5:
        return false;
    }

    private InputStream b(HttpURLConnection r4) {
        if (TextUtils.isEmpty(r4.getContentEncoding()) == false) goto L6;
        this.f = com.bumptech.glide.f.c.a(r4.getInputStream(), r4.getContentLength());
    L10:
        return this.f;
    L6:
        if (a(TAG, 3) == false) goto L8;
        b(TAG, "Got non empty content encoding: " + r4.getContentEncoding());
    L8:
        this.f = r4.getInputStream();
        goto L10
    }

    @Override // com.bumptech.glide.load.a.d
    public void b() {
        InputStream r0 = this.f;
        if (r0 != null) goto L11;
    L5:
        HttpURLConnection r1 = this.f3385e;
        if (r1 == null) goto L8;
        r1.disconnect();
    L8:
        this.f3385e = null;
        return;
    L11:
        r0.close();     // Catch: IOException -> L10
        goto L5
    }

    @Override // com.bumptech.glide.load.a.d
    public void c() {
        this.g = true;
    }

    @Override // com.bumptech.glide.load.a.d
    public Class<InputStream> a() {
        return InputStream.class;
    }

    @Override // com.bumptech.glide.load.a.d
    public com.bumptech.glide.load.a d() {
        return com.bumptech.glide.load.a.f3350b;
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static boolean a(String r1, int r2) {
        if (com.obric.aiagent.apm.impl.a.a() == true) goto L7;
        return Log.isLoggable(r1, r2);
    L7:
        if (r2 == 6) goto L9;
    L11:
        return false;
    L9:
        if (Log.isLoggable(r1, r2) == false) goto L11;
        return true;
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int a(String r1, String r2) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.v(r1, r2);
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int b(String r1, String r2) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.d(r1, r2);
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int a(String r1, String r2, Throwable r3) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.d(r1, r2, r3);
    }

    @Skip({"com.obric.aiagent.okhttp"})
    public static void a(HttpURLConnection r4) {
        if (ZeusTransformUtils.instanceOf(r4, HttpURLConnection.class) == false) goto L11;
        URL r0 = ((HttpURLConnection) ZeusTransformUtils.preCheckCast(r4, HttpURLConnection.class, "com.obric.aiagent.plugin")).getURL();
        if (r0 == null) goto L11;
        String r1 = r0.getHost();
        String r2 = r0.getPath();
        if (com.obric.aiagent.a.b.a(r1, r2) == false) goto L11;
        ILogDepend.Companion.i("AiAgentHucConnect", "huc connect drop " + r1 + r2);
        com.obric.aiagent.a.b.a(com.obric.aiagent.a.b.b(r1, r2), r1, r2);
        throw new IOException("[NetGuard] dropped ");
    L11:
        r4.connect();
    }
}
