package okhttp3;

import com.android.contacts.common.SimContactsConstants;
import com.bytedance.frameworks.baselib.network.http.util.HttpHost;
import java.net.Proxy;
import java.net.ProxySelector;
import java.util.List;
import javax.annotation.Nullable;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import okhttp3.internal.Util;
import okhttp3.ttnet.TTNetDns;

/* JADX INFO: loaded from: classes5.dex */
public final class Address {

    @Nullable
    final CertificatePinner certificatePinner;
    final List<ConnectionSpec> connectionSpecs;
    final Dns dns;

    @Nullable
    final HostnameVerifier hostnameVerifier;
    final List<Protocol> protocols;

    @Nullable
    final Proxy proxy;
    final Authenticator proxyAuthenticator;
    final ProxySelector proxySelector;
    final SocketFactory socketFactory;

    @Nullable
    final SSLSocketFactory sslSocketFactory;
    TTNetDns ttnetDns;
    final HttpUrl url;

    public Address(String r3, int r4, Dns r5, SocketFactory r6, @Nullable SSLSocketFactory r7, @Nullable HostnameVerifier r8, @Nullable CertificatePinner r9, Authenticator r10, @Nullable Proxy r11, List<Protocol> r12, List<ConnectionSpec> r13, ProxySelector r14) {
        HttpUrl.Builder r0 = new HttpUrl.Builder();
        if (r7 == null) goto L5;
        String r1 = "https";
    L6:
        this.url = r0.scheme(r1).host(r3).port(r4).build();
        if (r5 == null) goto L31;
        this.dns = r5;
        if (r6 == null) goto L29;
        this.socketFactory = r6;
        if (r10 == null) goto L27;
        this.proxyAuthenticator = r10;
        if (r12 == null) goto L25;
        this.protocols = Util.immutableList(r12);
        if (r13 == null) goto L23;
        this.connectionSpecs = Util.immutableList(r13);
        if (r14 == null) goto L21;
        this.proxySelector = r14;
        this.proxy = r11;
        this.sslSocketFactory = r7;
        this.hostnameVerifier = r8;
        this.certificatePinner = r9;
        return;
    L21:
        throw new NullPointerException("proxySelector == null");
    L23:
        throw new NullPointerException("connectionSpecs == null");
    L25:
        throw new NullPointerException("protocols == null");
    L27:
        throw new NullPointerException("proxyAuthenticator == null");
    L29:
        throw new NullPointerException("socketFactory == null");
    L31:
        throw new NullPointerException("dns == null");
    L5:
        r1 = HttpHost.DEFAULT_SCHEME_NAME;
        goto L6
    }

    public Address(String r1, int r2, Dns r3, SocketFactory r4, @Nullable SSLSocketFactory r5, @Nullable HostnameVerifier r6, @Nullable CertificatePinner r7, Authenticator r8, @Nullable Proxy r9, List<Protocol> r10, List<ConnectionSpec> r11, ProxySelector r12, TTNetDns r13) {
        this(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12);
        this.ttnetDns = r13;
    }

    public HttpUrl url() {
        return this.url;
    }

    public Dns dns() {
        return this.dns;
    }

    public SocketFactory socketFactory() {
        return this.socketFactory;
    }

    public Authenticator proxyAuthenticator() {
        return this.proxyAuthenticator;
    }

    public List<Protocol> protocols() {
        return this.protocols;
    }

    public List<ConnectionSpec> connectionSpecs() {
        return this.connectionSpecs;
    }

    public ProxySelector proxySelector() {
        return this.proxySelector;
    }

    @Nullable
    public Proxy proxy() {
        return this.proxy;
    }

    @Nullable
    public SSLSocketFactory sslSocketFactory() {
        return this.sslSocketFactory;
    }

    @Nullable
    public HostnameVerifier hostnameVerifier() {
        return this.hostnameVerifier;
    }

    @Nullable
    public CertificatePinner certificatePinner() {
        return this.certificatePinner;
    }

    @Nullable
    public TTNetDns ttnetDns() {
        return this.ttnetDns;
    }

    public boolean equals(@Nullable Object r3) {
        if ((r3 instanceof Address) == false) goto L9;
        Address r4 = (Address) r3;
        if (this.url.equals(r4.url) == false) goto L9;
        if (equalsNonHost(r4) == false) goto L9;
        return true;
    L9:
        return false;
    }

    public int hashCode() {
        int r1 = (((((((((((527 + this.url.hashCode()) * 31) + this.dns.hashCode()) * 31) + this.proxyAuthenticator.hashCode()) * 31) + this.protocols.hashCode()) * 31) + this.connectionSpecs.hashCode()) * 31) + this.proxySelector.hashCode()) * 31;
        Proxy r0 = this.proxy;
        int r2 = 0;
        if (r0 == null) goto L5;
        int r3 = r0.hashCode();
    L6:
        int r4 = (r1 + r3) * 31;
        SSLSocketFactory r5 = this.sslSocketFactory;
        if (r5 == null) goto L9;
        int r6 = r5.hashCode();
    L10:
        int r7 = (r4 + r6) * 31;
        HostnameVerifier r8 = this.hostnameVerifier;
        if (r8 == null) goto L13;
        int r9 = r8.hashCode();
    L14:
        int r10 = (r7 + r9) * 31;
        CertificatePinner r11 = this.certificatePinner;
        if (r11 == null) goto L18;
        r2 = r11.hashCode();
    L18:
        return r10 + r2;
    L13:
        r9 = 0;
        goto L14
    L9:
        r6 = 0;
        goto L10
    L5:
        r3 = 0;
        goto L6
    }

    boolean equalsNonHost(Address r3) {
        if (this.dns.equals(r3.dns) == true) goto L5;
    L23:
        return false;
    L5:
        if (this.proxyAuthenticator.equals(r3.proxyAuthenticator) == false) goto L23;
        if (this.protocols.equals(r3.protocols) == false) goto L23;
        if (this.connectionSpecs.equals(r3.connectionSpecs) == false) goto L23;
        if (this.proxySelector.equals(r3.proxySelector) == false) goto L23;
        if (Util.equal(this.proxy, r3.proxy) == false) goto L23;
        if (Util.equal(this.sslSocketFactory, r3.sslSocketFactory) == false) goto L23;
        if (Util.equal(this.hostnameVerifier, r3.hostnameVerifier) == false) goto L23;
        if (Util.equal(this.certificatePinner, r3.certificatePinner) == false) goto L23;
        if (url().port() != r3.url().port()) goto L23;
        return true;
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder("Address{").append(this.url.host()).append(SimContactsConstants.ANR_SEP).append(this.url.port());
        if (this.proxy == null) goto L5;
        r0.append(", proxy=").append(this.proxy);
    L6:
        r0.append("}");
        return r0.toString();
    L5:
        r0.append(", proxySelector=").append(this.proxySelector);
        goto L6
    }
}
