package n6;

import java.io.IOException;
import java.util.LinkedHashMap;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class b implements z {

    /* renamed from: b, reason: collision with root package name */
    public static final b f3995b = new b();

    /* renamed from: c, reason: collision with root package name */
    public static final b f3996c = new b();
    public static final b d = new b();

    public static final g a(b bVar, String str) {
        g gVar = new g(str);
        g.d.put(str, gVar);
        return gVar;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public static y c(String javaName) {
        kotlin.jvm.internal.p.e(javaName, "javaName");
        int iHashCode = javaName.hashCode();
        if (iHashCode != 79201641) {
            if (iHashCode != 79923350) {
                switch (iHashCode) {
                    case -503070503:
                        if (javaName.equals("TLSv1.1")) {
                            return y.f4168e;
                        }
                        break;
                    case -503070502:
                        if (javaName.equals("TLSv1.2")) {
                            return y.d;
                        }
                        break;
                    case -503070501:
                        if (javaName.equals("TLSv1.3")) {
                            return y.f4167c;
                        }
                        break;
                }
            } else if (javaName.equals("TLSv1")) {
                return y.f4169f;
            }
        } else if (javaName.equals("SSLv3")) {
            return y.f4170g;
        }
        throw new IllegalArgumentException("Unexpected TLS version: ".concat(javaName));
    }

    public static r d(String str) throws IOException {
        r rVar = r.f4120c;
        if (str.equals("http/1.0")) {
            return rVar;
        }
        r rVar2 = r.d;
        if (str.equals("http/1.1")) {
            return rVar2;
        }
        r rVar3 = r.f4123g;
        if (str.equals("h2_prior_knowledge")) {
            return rVar3;
        }
        r rVar4 = r.f4122f;
        if (str.equals("h2")) {
            return rVar4;
        }
        r rVar5 = r.f4121e;
        if (str.equals("spdy/3.1")) {
            return rVar5;
        }
        r rVar6 = r.f4124h;
        if (str.equals("quic")) {
            return rVar6;
        }
        r rVar7 = r.f4125j;
        if (x5.u.c1(str, "h3", false)) {
            return rVar7;
        }
        throw new IOException("Unexpected protocol: ".concat(str));
    }

    public synchronized g b(String javaName) {
        g gVar;
        String strConcat;
        try {
            kotlin.jvm.internal.p.e(javaName, "javaName");
            LinkedHashMap linkedHashMap = g.d;
            gVar = (g) linkedHashMap.get(javaName);
            if (gVar == null) {
                if (x5.u.c1(javaName, "TLS_", false)) {
                    String strSubstring = javaName.substring(4);
                    kotlin.jvm.internal.p.d(strSubstring, "substring(...)");
                    strConcat = "SSL_".concat(strSubstring);
                } else if (x5.u.c1(javaName, "SSL_", false)) {
                    String strSubstring2 = javaName.substring(4);
                    kotlin.jvm.internal.p.d(strSubstring2, "substring(...)");
                    strConcat = "TLS_".concat(strSubstring2);
                } else {
                    strConcat = javaName;
                }
                gVar = (g) linkedHashMap.get(strConcat);
                if (gVar == null) {
                    gVar = new g(javaName);
                }
                linkedHashMap.put(javaName, gVar);
            }
        } catch (Throwable th) {
            throw th;
        }
        return gVar;
    }
}
