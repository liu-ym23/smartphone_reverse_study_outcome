package okhttp3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public final enum TlsVersion extends Enum<TlsVersion> {
    private static final /* synthetic */ TlsVersion[] $VALUES = null;
    public static final TlsVersion SSL_3_0 = null;
    public static final TlsVersion TLS_1_0 = null;
    public static final TlsVersion TLS_1_1 = null;
    public static final TlsVersion TLS_1_2 = null;
    public static final TlsVersion TLS_1_3 = null;
    final String javaName;

    static {
        TlsVersion r10 = new TlsVersion("TLS_1_3", 0, "TLSv1.3");
        TLS_1_3 = r10;
        TlsVersion r11 = new TlsVersion("TLS_1_2", 1, "TLSv1.2");
        TLS_1_2 = r11;
        TlsVersion r12 = new TlsVersion("TLS_1_1", 2, "TLSv1.1");
        TLS_1_1 = r12;
        TlsVersion r13 = new TlsVersion("TLS_1_0", 3, "TLSv1");
        TLS_1_0 = r13;
        TlsVersion r14 = new TlsVersion("SSL_3_0", 4, "SSLv3");
        SSL_3_0 = r14;
        $VALUES = new TlsVersion[]{r10, r11, r12, r13, r14};
    }

    private TlsVersion(String r10, int r11, String r12) {
        super(r10, r11);
        this.javaName = r12;
    }

    public static TlsVersion forJavaName(String r10) {
        r10.hashCode();
        byte r11 = -1;
        switch(r10.hashCode()) {
            case -503070503: goto L22;
            case -503070502: goto L18;
            case -503070501: goto L14;
            case 79201641: goto L10;
            case 79923350: goto L6;
            default: goto L25;
        };
    L25:
        switch(r11) {
            case 0: goto L37;
            case 1: goto L35;
            case 2: goto L33;
            case 3: goto L31;
            case 4: goto L29;
            default: goto L27;
        };
    L27:
        throw new IllegalArgumentException("Unexpected TLS version: " + r10);
    L29:
        return TLS_1_0;
    L31:
        return SSL_3_0;
    L33:
        return TLS_1_3;
    L35:
        return TLS_1_2;
    L37:
        return TLS_1_1;
    L6:
        if (r10.equals("TLSv1") == false) goto L25;
        r11 = 4;
        goto L25
    L10:
        if (r10.equals("SSLv3") == false) goto L25;
        r11 = 3;
        goto L25
    L14:
        if (r10.equals("TLSv1.3") == false) goto L25;
        r11 = 2;
        goto L25
    L18:
        if (r10.equals("TLSv1.2") == false) goto L25;
        r11 = 1;
        goto L25
    L22:
        if (r10.equals("TLSv1.1") == false) goto L25;
        r11 = 0;
        goto L25
    }

    public static List<TlsVersion> forJavaNames(String... r10) {
        ArrayList r11 = new ArrayList(r10.length);
        int r12 = r10.length;
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L6;
        r11.add(forJavaName(r10[r13]));
        r13 = r13 + 1;
        goto L3
    L6:
        return Collections.unmodifiableList(r11);
    }

    public static TlsVersion valueOf(String r10) {
        return (TlsVersion) Enum.valueOf(TlsVersion.class, r10);
    }

    public static TlsVersion[] values() {
        return (TlsVersion[]) $VALUES.clone();
    }

    public String javaName() {
        return this.javaName;
    }
}
