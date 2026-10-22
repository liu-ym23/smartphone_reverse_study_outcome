package ya;

import com.tonyodev.fetch2core.Downloader;
import java.io.IOException;
import java.io.InputStream;
import java.net.CookieHandler;
import java.net.CookieManager;
import java.net.CookiePolicy;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.collections.EmptyList;
import mb.x;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class h implements Downloader<HttpURLConnection, Void> {

    /* renamed from: a, reason: collision with root package name */
    public final Downloader.FileDownloaderType f14198a = Downloader.FileDownloaderType.f8203a;

    /* renamed from: b, reason: collision with root package name */
    public final a f14199b = new a();

    /* renamed from: c, reason: collision with root package name */
    public final Map<Downloader.a, HttpURLConnection> f14200c;

    /* renamed from: d, reason: collision with root package name */
    public final CookieManager f14201d;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static class a {
    }

    public h() {
        Map<Downloader.a, HttpURLConnection> mapSynchronizedMap = Collections.synchronizedMap(new HashMap());
        kotlin.jvm.internal.g.e(mapSynchronizedMap, "synchronizedMap(...)");
        this.f14200c = mapSynchronizedMap;
        CookieManager cookieManager = new CookieManager();
        cookieManager.setCookiePolicy(CookiePolicy.ACCEPT_ALL);
        this.f14201d = cookieManager;
    }

    public static LinkedHashMap a(Map map) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry entry : map.entrySet()) {
            String str = (String) entry.getKey();
            if (str != null) {
                Collection collection = (List) entry.getValue();
                if (collection == null) {
                    collection = EmptyList.f10001a;
                }
                linkedHashMap.put(str, collection);
            }
        }
        return linkedHashMap;
    }

    @Override // com.tonyodev.fetch2core.Downloader
    public final Downloader.a D0(Downloader.b bVar, hb.h interruptMonitor) throws IOException {
        String str;
        boolean z;
        long jF;
        String strD;
        kotlin.jvm.internal.g.f(interruptMonitor, "interruptMonitor");
        CookieHandler.setDefault(this.f14201d);
        String str2 = bVar.f8212a;
        URLConnection uRLConnectionOpenConnection = new URL(str2).openConnection();
        kotlin.jvm.internal.g.d(uRLConnectionOpenConnection, "null cannot be cast to non-null type java.net.HttpURLConnection");
        HttpURLConnection httpURLConnection = (HttpURLConnection) uRLConnectionOpenConnection;
        o(httpURLConnection, bVar);
        if (httpURLConnection.getRequestProperty("Referer") == null) {
            httpURLConnection.addRequestProperty("Referer", com.tonyodev.fetch2core.b.m(str2));
        }
        httpURLConnection.connect();
        Map<String, List<String>> headerFields = httpURLConnection.getHeaderFields();
        kotlin.jvm.internal.g.e(headerFields, "getHeaderFields(...)");
        LinkedHashMap linkedHashMapA = a(headerFields);
        int responseCode = httpURLConnection.getResponseCode();
        str = "";
        if ((responseCode == 302 || responseCode == 301 || responseCode == 303) && com.tonyodev.fetch2core.b.k(linkedHashMapA, "Location") != null) {
            try {
                httpURLConnection.disconnect();
            } catch (Exception unused) {
            }
            String strK = com.tonyodev.fetch2core.b.k(linkedHashMapA, "Location");
            if (strK == null) {
                strK = "";
            }
            URLConnection uRLConnectionOpenConnection2 = new URL(strK).openConnection();
            kotlin.jvm.internal.g.d(uRLConnectionOpenConnection2, "null cannot be cast to non-null type java.net.HttpURLConnection");
            httpURLConnection = (HttpURLConnection) uRLConnectionOpenConnection2;
            o(httpURLConnection, bVar);
            if (httpURLConnection.getRequestProperty("Referer") == null) {
                httpURLConnection.addRequestProperty("Referer", com.tonyodev.fetch2core.b.m(str2));
            }
            httpURLConnection.connect();
            Map<String, List<String>> headerFields2 = httpURLConnection.getHeaderFields();
            kotlin.jvm.internal.g.e(headerFields2, "getHeaderFields(...)");
            linkedHashMapA = a(headerFields2);
            responseCode = httpURLConnection.getResponseCode();
        }
        HttpURLConnection httpURLConnection2 = httpURLConnection;
        LinkedHashMap linkedHashMap = linkedHashMapA;
        int i10 = responseCode;
        InputStream inputStream = null;
        if (200 > i10 || i10 >= 300) {
            z = false;
            jF = -1;
            strD = com.tonyodev.fetch2core.b.d(httpURLConnection2.getErrorStream());
        } else {
            jF = com.tonyodev.fetch2core.b.f(linkedHashMap);
            InputStream inputStream2 = httpURLConnection2.getInputStream();
            String strK2 = com.tonyodev.fetch2core.b.k(linkedHashMap, "Content-MD5");
            str = strK2 != null ? strK2 : "";
            z = true;
            strD = null;
            inputStream = inputStream2;
        }
        boolean zA = com.tonyodev.fetch2core.b.a(i10, linkedHashMap);
        kotlin.jvm.internal.g.e(httpURLConnection2.getHeaderFields(), "getHeaderFields(...)");
        Downloader.a aVar = new Downloader.a(i10, z, jF, inputStream, bVar, str, linkedHashMap, zA, strD);
        this.f14200c.put(aVar, httpURLConnection2);
        return aVar;
    }

    @Override // com.tonyodev.fetch2core.Downloader
    public final void E(Downloader.a aVar) {
        Map<Downloader.a, HttpURLConnection> map = this.f14200c;
        if (map.containsKey(aVar)) {
            HttpURLConnection httpURLConnection = map.get(aVar);
            map.remove(aVar);
            if (httpURLConnection != null) {
                try {
                    httpURLConnection.disconnect();
                } catch (Exception unused) {
                }
            }
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        Map<Downloader.a, HttpURLConnection> map = this.f14200c;
        Iterator<T> it = map.entrySet().iterator();
        while (it.hasNext()) {
            HttpURLConnection httpURLConnection = (HttpURLConnection) ((Map.Entry) it.next()).getValue();
            if (httpURLConnection != null) {
                try {
                    httpURLConnection.disconnect();
                } catch (Exception unused) {
                }
            }
        }
        map.clear();
    }

    public final void o(HttpURLConnection httpURLConnection, Downloader.b bVar) throws ProtocolException {
        httpURLConnection.setRequestMethod(bVar.f8215d);
        this.f14199b.getClass();
        httpURLConnection.setReadTimeout(20000);
        httpURLConnection.setConnectTimeout(15000);
        httpURLConnection.setUseCaches(false);
        httpURLConnection.setDefaultUseCaches(false);
        httpURLConnection.setInstanceFollowRedirects(true);
        httpURLConnection.setDoInput(true);
        for (Map.Entry entry : bVar.f8213b.entrySet()) {
            httpURLConnection.addRequestProperty((String) entry.getKey(), (String) entry.getValue());
        }
    }

    @Override // com.tonyodev.fetch2core.Downloader
    public final Downloader.FileDownloaderType q0(Downloader.b bVar, Set<? extends Downloader.FileDownloaderType> supportedFileDownloaderTypes) {
        kotlin.jvm.internal.g.f(supportedFileDownloaderTypes, "supportedFileDownloaderTypes");
        return this.f14198a;
    }

    @Override // com.tonyodev.fetch2core.Downloader
    public final Set<Downloader.FileDownloaderType> y0(Downloader.b bVar) {
        Downloader.FileDownloaderType fileDownloaderType = Downloader.FileDownloaderType.f8203a;
        Downloader.FileDownloaderType fileDownloaderType2 = this.f14198a;
        if (fileDownloaderType2 == fileDownloaderType) {
            return x.U(fileDownloaderType2);
        }
        try {
            return com.tonyodev.fetch2core.b.n(bVar, this);
        } catch (Exception unused) {
            return x.U(fileDownloaderType2);
        }
    }

    @Override // com.tonyodev.fetch2core.Downloader
    public final void G(Downloader.b bVar) {
    }

    @Override // com.tonyodev.fetch2core.Downloader
    public final void L(Downloader.b bVar) {
    }

    @Override // com.tonyodev.fetch2core.Downloader
    public final void W(Downloader.b bVar) {
    }
}
