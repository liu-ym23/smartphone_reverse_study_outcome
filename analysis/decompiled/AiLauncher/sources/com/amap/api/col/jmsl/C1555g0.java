package com.amap.api.col.jmsl;

import java.io.IOException;
import java.net.CacheRequest;
import java.net.CacheResponse;
import java.net.ResponseCache;
import java.net.URI;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

/* renamed from: com.amap.api.col.jmsl.g0, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1555g0 extends ResponseCache {

    /* renamed from: a, reason: collision with root package name */
    public final ResponseCache f16632a;

    public C1555g0(ResponseCache responseCache) {
        this.f16632a = responseCache;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0041 A[PHI: r0
      0x0041: PHI (r0v1 java.lang.String) = (r0v0 java.lang.String), (r0v4 java.lang.String) binds: [B:6:0x0008, B:17:0x003d] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.net.URI a(java.net.URI r11) {
        /*
            r10 = this;
            r10 = 0
            if (r11 != 0) goto L4
            return r10
        L4:
            java.lang.String r0 = r11.getQuery()
            if (r0 == 0) goto L41
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "&"
            java.lang.String[] r0 = r0.split(r2)
            int r3 = r0.length
            r4 = 0
        L17:
            if (r4 >= r3) goto L35
            r5 = r0[r4]
            java.lang.String r6 = "ts"
            boolean r6 = r5.contains(r6)
            if (r6 != 0) goto L32
            java.lang.String r6 = "scode"
            boolean r6 = r5.contains(r6)
            if (r6 == 0) goto L2c
            goto L32
        L2c:
            r1.append(r5)
            r1.append(r2)
        L32:
            int r4 = r4 + 1
            goto L17
        L35:
            java.lang.String r0 = r1.toString()
            int r1 = r0.length()
            if (r1 != 0) goto L41
            r8 = r10
            goto L42
        L41:
            r8 = r0
        L42:
            java.net.URI r2 = new java.net.URI     // Catch: java.net.URISyntaxException -> L60
            java.lang.String r3 = r11.getScheme()     // Catch: java.net.URISyntaxException -> L60
            java.lang.String r4 = r11.getUserInfo()     // Catch: java.net.URISyntaxException -> L60
            java.lang.String r5 = r11.getHost()     // Catch: java.net.URISyntaxException -> L60
            int r6 = r11.getPort()     // Catch: java.net.URISyntaxException -> L60
            java.lang.String r7 = r11.getPath()     // Catch: java.net.URISyntaxException -> L60
            java.lang.String r9 = r11.getFragment()     // Catch: java.net.URISyntaxException -> L60
            r2.<init>(r3, r4, r5, r6, r7, r8, r9)     // Catch: java.net.URISyntaxException -> L60
            return r2
        L60:
            r0 = move-exception
            r10 = r0
            r10.printStackTrace()
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.jmsl.C1555g0.a(java.net.URI):java.net.URI");
    }

    @Override // java.net.ResponseCache
    public CacheResponse get(URI uri, String str, Map<String, List<String>> map) throws IOException {
        URI uriA = a(uri);
        if (uriA == null) {
            return null;
        }
        CacheResponse cacheResponse = this.f16632a.get(uriA, str, map);
        return cacheResponse != null ? cacheResponse : this.f16632a.get(uri, str, map);
    }

    @Override // java.net.ResponseCache
    public CacheRequest put(URI uri, URLConnection uRLConnection) throws IOException {
        URI uriA = a(uri);
        if (uriA == null) {
            return null;
        }
        CacheRequest cacheRequestPut = this.f16632a.put(uriA, uRLConnection);
        return cacheRequestPut != null ? cacheRequestPut : this.f16632a.put(uri, uRLConnection);
    }
}
