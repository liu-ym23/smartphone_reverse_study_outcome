package okhttp3;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: TlsVersion.kt */
/* JADX INFO: loaded from: classes4.dex */
public final enum ag extends Enum<ag> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f39729a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ag f39730b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ag f39731c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final ag f39732d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final ag f39733e = null;
    public static final ag f = null;
    private static final /* synthetic */ ag[] h = null;
    private final String g;

    /* JADX INFO: compiled from: TlsVersion.kt */
    public static final class a {
        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        private a() {
        }

        public final ag a(String r3) {
            d.h.b.o.e(r3, "javaName");
            int r2 = r3.hashCode();
            if (r2 == 79201641) goto L21;
            if (r2 == 79923350) goto L18;
            switch(r2) {
                case -503070503: goto L15;
                case -503070502: goto L12;
                case -503070501: goto L9;
                default: goto L25;
            };
        L9:
            if (r3.equals("TLSv1.3") == false) goto L25;
            return ag.f39730b;
        L12:
            if (r3.equals("TLSv1.2") == false) goto L25;
            return ag.f39731c;
        L15:
            if (r3.equals("TLSv1.1") == false) goto L25;
            return ag.f39732d;
        L25:
            throw new IllegalArgumentException("Unexpected TLS version: " + r3);
        L18:
            if (r3.equals("TLSv1") == false) goto L25;
            return ag.f39733e;
        L21:
            if (r3.equals("SSLv3") == false) goto L25;
            return ag.f;
        }
    }

    private static final /* synthetic */ ag[] b() {
        return new ag[]{f39730b, f39731c, f39732d, f39733e, f};
    }

    public static ag valueOf(String r2) {
        return (ag) ZeusTransformUtils.preCheckCast(Enum.valueOf(ag.class, r2), ag.class, "com.obric.aiagent.plugin");
    }

    public static ag[] values() {
        return (ag[]) ZeusTransformUtils.preCheckCast(h.clone(), ag[].class, "com.obric.aiagent.plugin");
    }

    private ag(String r1, int r2, String r3) {
        super(r1, r2);
        this.g = r3;
    }

    public final String a() {
        return this.g;
    }

    static {
        f39730b = new ag("TLS_1_3", 0, "TLSv1.3");
        f39731c = new ag("TLS_1_2", 1, "TLSv1.2");
        f39732d = new ag("TLS_1_1", 2, "TLSv1.1");
        f39733e = new ag("TLS_1_0", 3, "TLSv1");
        f = new ag("SSL_3_0", 4, "SSLv3");
        h = b();
        f39729a = new a(null);
    }
}
