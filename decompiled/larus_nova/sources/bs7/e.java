package bs7;

import android.text.TextUtils;
import android.webkit.MimeTypeMap;
import androidx.collection.SieveCacheKt;
import com.alipay.sdk.m.u.i;
import com.byted.cast.proxy.Config;
import com.byted.cast.proxy.ILogger;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.danikula.videocache.InterruptedProxyCacheException;
import com.danikula.videocache.ProxyCacheException;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.network.okhttp.GlobalNetworkGate;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes22.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final cs7.b f20283a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public h f20284b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public HttpURLConnection f20285c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public InputStream f20286d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Config f20287e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f20288f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ILogger f20289g;

    public final synchronized long c() throws ProxyCacheException {
        monitor-enter(this);
    L9:
        th = move-exception;
        throw th;
    L4:
        if (this.f20284b.f20293b != SieveCacheKt.NodeMetaAndPreviousMask) goto L6;
        b();     // Catch: Throwable -> L9
    L6:
        long r100 = this.f20284b.f20293b;     // Catch: Throwable -> L9
        monitor-exit(this);
        return r100;
    }

    public final void a() throws ProxyCacheException {
        HttpURLConnection r100 = this.f20285c;
        if (r100 != null) goto L16;
        return;
    L16:
        r100.disconnect();     // Catch: ArrayIndexOutOfBoundsException -> L6 IllegalArgumentException -> L10 NullPointerException -> L12
    L20:
        return;
    L6:
        e = move-exception;
        String r101 = "Error closing connection correctly. Should happen only on Android L. Until good solution is not know, just ignore this issue : " + e;
        ILogger r102 = this.f20289g;
        if (r102 == null) goto L18;
        r102.onError("HttpUrlSource", r101);
        return;
    L18:
        return;
    L10:
        e = e;
    L14:
        throw new RuntimeException("Wait... but why? WTF!? Really shouldn't happen any more after fixing https://github.com/danikula/AndroidVideoCache/issues/43. If you read it on your device log, please, notify me danikula@gmail.com or create issue here https://github.com/danikula/AndroidVideoCache/issues.", e);
    L12:
        e = e;
        goto L14
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v2, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r2v6, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r2v7, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r6v2 */
    public final void b() throws ProxyCacheException {
        String r100 = "Read content info from " + this.f20284b.f20292a;
        if (this.f20288f == false) goto L7;
        ILogger r101 = this.f20289g;
        if (r101 == null) goto L7;
        r101.onDebug("HttpUrlSource", r100);
    L7:
        ?? r102 = 0;
        InputStream r103 = null;
        r102 = e(0, 10000);     // Catch: Throwable -> L31 IOException -> L33
        String r104 = r102.getHeaderField("Content-Length");     // Catch: Throwable -> L26 IOException -> L29
        if (r104 != null) goto L12;
        long r105 = -1;
    L13:
        String r106 = r102.getContentType();     // Catch: Throwable -> L26 IOException -> L29
        InputStream r107 = r102.getInputStream();     // Catch: Throwable -> L26 IOException -> L29
        this.f20284b = new h(this.f20284b.f20292a, r105, r106);     // Catch: Throwable -> L22 IOException -> L24
        String r108 = "Source info fetched: " + this.f20284b;     // Catch: Throwable -> L22 IOException -> L24
        if (this.f20288f == false) goto L19;
        ILogger r109 = this.f20289g;     // Catch: Throwable -> L22 IOException -> L24
        if (r109 == null) goto L19;
        r109.onDebug("HttpUrlSource", r108);     // Catch: Throwable -> L22 IOException -> L24
    L19:
        if (r107 != null) goto L55;
    L41:
        r102.disconnect();
        return;
    L55:
        r107.close();     // Catch: IOException -> L49
    L24:
        e = e;
        r103 = r107;
    L35:
        String r110 = "Error fetching info from " + this.f20284b.f20292a + ", IOException: " + e;     // Catch: Throwable -> L26
        ILogger r111 = this.f20289g;     // Catch: Throwable -> L26
        if (r111 == null) goto L38;
        r111.onError("HttpUrlSource", r110);     // Catch: Throwable -> L26
    L38:
        if (r103 != null) goto L57;
    L40:
        if (r102 != 0) goto L41;
        return;
    L57:
        r103.close();     // Catch: IOException -> L51
    L22:
        th = th;
    L43:
        ?? r112 = r102;
        r103 = r107;
    L44:
        if (r103 != null) goto L59;
    L46:
        if (r112 == 0) goto L65;
        r112.disconnect();
        throw th;
    L65:
        throw th;
    L59:
        r103.close();     // Catch: IOException -> L50
        goto L46
    L12:
        r105 = CastLongProtector.parseLong(r104);     // Catch: Throwable -> L26 IOException -> L29
    L29:
        e = e;
        goto L35
    L26:
        th = th;
        r107 = null;
    L33:
        e = e;
        r102 = 0;
    L31:
        th = th;
        r112 = 0;
        goto L44
    }

    public final String toString() {
        return "HttpUrlSource{sourceInfo='" + this.f20284b + i.f25855d;
    }

    public e(e r100) {
        this.f20288f = true;
        this.f20284b = r100.f20284b;
        this.f20283a = r100.f20283a;
        Config r101 = r100.f20287e;
        this.f20287e = r101;
        if (r101 == null) goto L7;
        this.f20288f = r101.isEnableDebug();
        this.f20289g = r101.getLogger();
        return;
    }

    public final void d(long r100) throws ProxyCacheException {
        this.f20285c = e(r100, 15000);     // Catch: IOException -> L5
        this.f20286d = new BufferedInputStream(this.f20285c.getInputStream(), 8192);     // Catch: IOException -> L5
        return;
    L5:
        e = move-exception;
        String r101 = "Error opening connection for " + this.f20284b.f20292a + " with offset " + r100 + ", IOException: " + e;
        ILogger r102 = this.f20289g;
        if (r102 == null) goto L10;
        r102.onError("HttpUrlSource", r101);
    L10:
        throw new ProxyCacheException("Error opening connection for " + this.f20284b.f20292a + " with offset " + r100, e);
    }

    public final int f(byte[] r100) throws ProxyCacheException {
        InputStream r101 = this.f20286d;
        if (r101 == null) goto L13;
        return r101.read(r100, 0, r100.length);
    L9:
        e = move-exception;
        throw new InterruptedProxyCacheException("Reading source " + this.f20284b.f20292a + " is interrupted", e);
    L6:
        e = move-exception;
        throw new ProxyCacheException("Error reading data from " + this.f20284b.f20292a, e);
    L13:
        throw new ProxyCacheException("Error reading data from " + this.f20284b.f20292a + ": connection is absent!");
    }

    public final HttpURLConnection e(long r110, int r111) throws IOException, ProxyCacheException {
        String r100 = this.f20284b.f20292a;
        int r101 = 0;
    L3:
        StringBuilder r102 = new StringBuilder("Open connection ");
        if (r110 <= 0) goto L6;
        String r103 = " with offset " + r110;
    L7:
        r102.append(r103);
        r102.append(" to ");
        r102.append(r100);
        String r104 = r102.toString();
        if (this.f20288f == false) goto L12;
        ILogger r105 = this.f20289g;
        if (r105 == null) goto L12;
        r105.onDebug("HttpUrlSource", r104);
    L12:
        URL r106 = new URL(r100);
        String r107 = r106.getHost();     // Catch: Throwable -> L18 IOException -> L45
        String r108 = r106.getPath();     // Catch: Throwable -> L18 IOException -> L45
        if (com.obric.assistant.network.okhttp.a.c(r107, r108) == false) goto L20;
        FLogger.f375446a.i("UrlConnLancet", "openConnection drop host=" + r107 + " path=" + r108);     // Catch: Throwable -> L18 IOException -> L45
        com.obric.assistant.network.okhttp.a.b(GlobalNetworkGate.a(r107, r108), r107, r108);     // Catch: Throwable -> L18 IOException -> L45
        throw new IOException("[NetGuard] dropped " + r106);     // Catch: Throwable -> L18 IOException -> L45
    L20:
        HttpURLConnection r109 = (HttpURLConnection) r106.openConnection();
        Iterator r112 = this.f20283a.a().entrySet().iterator();
    L22:
        if (r112.hasNext() == false) goto L24;
        Map.Entry r113 = (Map.Entry) r112.next();
        r109.setRequestProperty((String) r113.getKey(), (String) r113.getValue());
        goto L22
    L24:
        if (r110 <= 0) goto L26;
        r109.setRequestProperty("Range", "bytes=" + r110 + "-");
    L26:
        if (r111 <= 0) goto L28;
        r109.setConnectTimeout(r111);
        r109.setReadTimeout(r111);
    L28:
        int r114 = r109.getResponseCode();
        if (r114 != 301) goto L31;
    L36:
        boolean r115 = true;
    L37:
        if (r115 == false) goto L40;
        r100 = r109.getHeaderField("Location");
        r101 = r101 + 1;
        r109.disconnect();
    L40:
        if (r101 > 5) goto L44;
        if (r115 == true) goto L3;
        return r109;
    L44:
        throw new ProxyCacheException("Too many redirects: " + r101);
    L31:
        if (r114 == 302) goto L36;
        if (r114 == 303) goto L36;
        r115 = false;
    L45:
        e = move-exception;
        throw e;
    L18:
        th = move-exception;
        FLogger.f375446a.e("UrlConnLancet", "openConnection intercept failed, fallback to origin: " + th.getMessage());
        goto L20
    L6:
        r103 = "";
        goto L7
    }

    public e(String r100, cs7.b r101, Config r102) {
        this.f20288f = true;
        r101.getClass();
        this.f20283a = r101;
        h r103 = this.f20284b;
        if (r103 != null) goto L10;
        MimeTypeMap r104 = MimeTypeMap.getSingleton();
        String r105 = MimeTypeMap.getFileExtensionFromUrl(r100);
        if (TextUtils.isEmpty(r105) == false) goto L8;
        String r106 = null;
    L9:
        r103 = new h(r100, SieveCacheKt.NodeMetaAndPreviousMask, r106);
        goto L10
    L8:
        r106 = r104.getMimeTypeFromExtension(r105);
    L10:
        this.f20284b = r103;
        this.f20287e = r102;
        if (r102 == null) goto L15;
        this.f20288f = r102.isEnableDebug();
        this.f20289g = r102.getLogger();
        return;
    }
}
