package okhttp3;

import java.security.cert.Certificate;
import java.util.Collections;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
import okhttp3.internal.Util;

/* JADX INFO: loaded from: classes4.dex */
public final class Handshake {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TlsVersion f22693a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final d f22694b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List f22695c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List f22696d;

    public Handshake(TlsVersion r10, d r11, List r12, List r13) {
        this.f22693a = r10;
        this.f22694b = r11;
        this.f22695c = r12;
        this.f22696d = r13;
    }

    public static Handshake b(SSLSession r10) {
        String r11 = r10.getCipherSuite();
        if (r11 == null) goto L22;
        d r12 = d.a(r11);
        String r13 = r10.getProtocol();
        if (r13 == null) goto L20;
        TlsVersion r14 = TlsVersion.forJavaName(r13);
        Certificate[] r15 = r10.getPeerCertificates();     // Catch: SSLPeerUnverifiedException -> L9
    L10:
        if (r15 == null) goto L12;
        List r16 = Util.immutableList(r15);
    L13:
        Certificate[] r17 = r10.getLocalCertificates();
        if (r17 == null) goto L16;
        List r18 = Util.immutableList(r17);
    L18:
        return new Handshake(r14, r12, r16, r18);
    L16:
        r18 = Collections.emptyList();
        goto L18
    L12:
        r16 = Collections.emptyList();
    L9:
        r15 = null;
        goto L10
    L20:
        throw new IllegalStateException("tlsVersion == null");
    L22:
        throw new IllegalStateException("cipherSuite == null");
    }

    public static Handshake c(TlsVersion r10, d r11, List r12, List r13) {
        if (r10 == null) goto L9;
        if (r11 == null) goto L7;
        return new Handshake(r10, r11, Util.immutableList(r12), Util.immutableList(r13));
    L7:
        throw new NullPointerException("cipherSuite == null");
    L9:
        throw new NullPointerException("tlsVersion == null");
    }

    public d a() {
        return this.f22694b;
    }

    public List d() {
        return this.f22696d;
    }

    public List e() {
        return this.f22695c;
    }

    public boolean equals(Object r10) {
        if ((r10 instanceof Handshake) == true) goto L5;
        return false;
    L5:
        Handshake r11 = (Handshake) r10;
        if (this.f22693a.equals(r11.f22693a) == true) goto L8;
        return false;
    L8:
        if (this.f22694b.equals(r11.f22694b) == true) goto L10;
        return false;
    L10:
        if (this.f22695c.equals(r11.f22695c) == true) goto L12;
        return false;
    L12:
        if (this.f22696d.equals(r11.f22696d) == false) goto L18;
        return true;
    L18:
        return false;
    }

    public TlsVersion f() {
        return this.f22693a;
    }

    public int hashCode() {
        return ((((((527 + this.f22693a.hashCode()) * 31) + this.f22694b.hashCode()) * 31) + this.f22695c.hashCode()) * 31) + this.f22696d.hashCode();
    }
}
