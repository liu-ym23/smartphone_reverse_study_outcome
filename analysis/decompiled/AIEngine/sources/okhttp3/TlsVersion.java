package okhttp3;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class TlsVersion {

    /* renamed from: b, reason: collision with root package name */
    public static final a f10916b;

    /* renamed from: c, reason: collision with root package name */
    public static final TlsVersion f10917c;

    /* renamed from: d, reason: collision with root package name */
    public static final TlsVersion f10918d;

    /* renamed from: e, reason: collision with root package name */
    public static final TlsVersion f10919e;
    public static final TlsVersion h;

    /* renamed from: j, reason: collision with root package name */
    public static final TlsVersion f10920j;

    /* renamed from: k, reason: collision with root package name */
    public static final /* synthetic */ TlsVersion[] f10921k;

    /* renamed from: a, reason: collision with root package name */
    public final String f10922a;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class a {
        /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
        public static TlsVersion a(String javaName) {
            kotlin.jvm.internal.g.f(javaName, "javaName");
            int iHashCode = javaName.hashCode();
            if (iHashCode != 79201641) {
                if (iHashCode != 79923350) {
                    switch (iHashCode) {
                        case -503070503:
                            if (javaName.equals("TLSv1.1")) {
                                return TlsVersion.f10919e;
                            }
                            break;
                        case -503070502:
                            if (javaName.equals("TLSv1.2")) {
                                return TlsVersion.f10918d;
                            }
                            break;
                        case -503070501:
                            if (javaName.equals("TLSv1.3")) {
                                return TlsVersion.f10917c;
                            }
                            break;
                    }
                } else if (javaName.equals("TLSv1")) {
                    return TlsVersion.h;
                }
            } else if (javaName.equals("SSLv3")) {
                return TlsVersion.f10920j;
            }
            throw new IllegalArgumentException("Unexpected TLS version: ".concat(javaName));
        }
    }

    static {
        TlsVersion tlsVersion = new TlsVersion("TLS_1_3", 0, "TLSv1.3");
        f10917c = tlsVersion;
        TlsVersion tlsVersion2 = new TlsVersion("TLS_1_2", 1, "TLSv1.2");
        f10918d = tlsVersion2;
        TlsVersion tlsVersion3 = new TlsVersion("TLS_1_1", 2, "TLSv1.1");
        f10919e = tlsVersion3;
        TlsVersion tlsVersion4 = new TlsVersion("TLS_1_0", 3, "TLSv1");
        h = tlsVersion4;
        TlsVersion tlsVersion5 = new TlsVersion("SSL_3_0", 4, "SSLv3");
        f10920j = tlsVersion5;
        TlsVersion[] tlsVersionArr = {tlsVersion, tlsVersion2, tlsVersion3, tlsVersion4, tlsVersion5};
        f10921k = tlsVersionArr;
        kotlin.enums.a.a(tlsVersionArr);
        f10916b = new a();
    }

    public TlsVersion(String str, int i10, String str2) {
        this.f10922a = str2;
    }

    public static TlsVersion valueOf(String str) {
        return (TlsVersion) Enum.valueOf(TlsVersion.class, str);
    }

    public static TlsVersion[] values() {
        return (TlsVersion[]) f10921k.clone();
    }
}
