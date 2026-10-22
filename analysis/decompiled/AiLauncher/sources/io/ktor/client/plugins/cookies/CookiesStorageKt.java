package io.ktor.client.plugins.cookies;

import La.D;
import La.H;
import Y8.t;
import e9.InterfaceC4014c;
import f9.C4063a;
import io.ktor.http.Cookie;
import io.ktor.http.URLUtilsKt;
import io.ktor.http.Url;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\u001a$\u0010\u0006\u001a\u00020\u0005*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0003H\u0086@¢\u0006\u0004\b\u0006\u0010\u0007\u001a\u0019\u0010\u000b\u001a\u00020\n*\u00020\u00032\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\f\u001a\u0019\u0010\r\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lio/ktor/client/plugins/cookies/CookiesStorage;", "", "urlString", "Lio/ktor/http/Cookie;", "cookie", "LY8/t;", "addCookie", "(Lio/ktor/client/plugins/cookies/CookiesStorage;Ljava/lang/String;Lio/ktor/http/Cookie;Le9/c;)Ljava/lang/Object;", "Lio/ktor/http/Url;", "requestUrl", "", "matches", "(Lio/ktor/http/Cookie;Lio/ktor/http/Url;)Z", "fillDefaults", "(Lio/ktor/http/Cookie;Lio/ktor/http/Url;)Lio/ktor/http/Cookie;", "ktor-client-core"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class CookiesStorageKt {
    public static final Object addCookie(CookiesStorage cookiesStorage, String str, Cookie cookie, InterfaceC4014c<? super t> interfaceC4014c) {
        Object objAddCookie = cookiesStorage.addCookie(URLUtilsKt.Url(str), cookie, interfaceC4014c);
        return objAddCookie == C4063a.g() ? objAddCookie : t.f7040a;
    }

    public static final Cookie fillDefaults(Cookie cookie, Url requestUrl) {
        p.i(cookie, "<this>");
        p.i(requestUrl, "requestUrl");
        String path = cookie.getPath();
        Cookie cookieCopy$default = (path == null || !D.X(path, "/", false, 2, null)) ? Cookie.copy$default(cookie, null, null, null, null, null, null, requestUrl.getEncodedPath(), false, false, null, 959, null) : cookie;
        String domain = cookieCopy$default.getDomain();
        return (domain == null || H.x0(domain)) ? Cookie.copy$default(cookieCopy$default, null, null, null, null, null, requestUrl.getHost(), null, false, false, null, 991, null) : cookieCopy$default;
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x008c, code lost:
    
        if (La.D.K(r8, '.' + r0, false, 2, null) == false) goto L24;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final boolean matches(io.ktor.http.Cookie r11, io.ktor.http.Url r12) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.p.i(r11, r0)
            java.lang.String r0 = "requestUrl"
            kotlin.jvm.internal.p.i(r12, r0)
            java.lang.String r0 = r11.getDomain()
            if (r0 == 0) goto Lbf
            java.lang.String r0 = io.ktor.util.TextKt.toLowerCasePreservingASCIIRules(r0)
            if (r0 == 0) goto Lbf
            r1 = 1
            char[] r2 = new char[r1]
            r3 = 0
            r4 = 46
            r2[r3] = r4
            java.lang.String r0 = La.H.I1(r0, r2)
            if (r0 == 0) goto Lbf
            r11.getPath()
            java.lang.String r2 = r11.getPath()
            if (r2 == 0) goto Lb7
            r5 = 47
            r6 = 2
            r7 = 0
            boolean r8 = La.H.j0(r2, r5, r3, r6, r7)
            if (r8 == 0) goto L38
            goto L4b
        L38:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r8 = r11.getPath()
            r2.append(r8)
            r2.append(r5)
            java.lang.String r2 = r2.toString()
        L4b:
            java.lang.String r8 = r12.getHost()
            java.lang.String r8 = io.ktor.util.TextKt.toLowerCasePreservingASCIIRules(r8)
            java.lang.String r9 = r12.getEncodedPath()
            boolean r10 = La.H.j0(r9, r5, r3, r6, r7)
            if (r10 == 0) goto L5e
            goto L6d
        L5e:
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            r10.append(r9)
            r10.append(r5)
            java.lang.String r9 = r10.toString()
        L6d:
            boolean r5 = kotlin.jvm.internal.p.d(r8, r0)
            if (r5 != 0) goto L8f
            boolean r5 = io.ktor.http.IpParserKt.hostIsIp(r8)
            if (r5 != 0) goto L8e
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            r5.append(r4)
            r5.append(r0)
            java.lang.String r0 = r5.toString()
            boolean r0 = La.D.K(r8, r0, r3, r6, r7)
            if (r0 != 0) goto L8f
        L8e:
            return r3
        L8f:
            java.lang.String r0 = "/"
            boolean r0 = kotlin.jvm.internal.p.d(r2, r0)
            if (r0 != 0) goto La4
            boolean r0 = kotlin.jvm.internal.p.d(r9, r2)
            if (r0 != 0) goto La4
            boolean r0 = La.D.X(r9, r2, r3, r6, r7)
            if (r0 != 0) goto La4
            return r3
        La4:
            boolean r11 = r11.getSecure()
            if (r11 == 0) goto Lb6
            io.ktor.http.URLProtocol r11 = r12.getProtocol()
            boolean r11 = io.ktor.http.URLProtocolKt.isSecure(r11)
            if (r11 == 0) goto Lb5
            goto Lb6
        Lb5:
            return r3
        Lb6:
            return r1
        Lb7:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "Path field should have the default value"
            r11.<init>(r12)
            throw r11
        Lbf:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "Domain field should have the default value"
            r11.<init>(r12)
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.plugins.cookies.CookiesStorageKt.matches(io.ktor.http.Cookie, io.ktor.http.Url):boolean");
    }
}
