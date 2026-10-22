package org.apache.http;

import java.io.Serializable;
import java.net.InetAddress;
import java.util.Locale;
import org.apache.http.annotation.Contract;
import org.apache.http.annotation.ThreadingBehavior;
import org.apache.http.util.Args;
import org.apache.http.util.LangUtils;

/* JADX INFO: loaded from: classes4.dex */
@Contract(threading = ThreadingBehavior.IMMUTABLE)
public final class HttpHost implements Cloneable, Serializable {
    public static final String DEFAULT_SCHEME_NAME = "http";
    private static final long serialVersionUID = -7529410654042457626L;
    protected final InetAddress address;
    protected final String hostname;
    protected final String lcHostname;
    protected final int port;
    protected final String schemeName;

    public HttpHost(String r10, int r11, String r12) {
        this.hostname = (String) Args.containsNoBlanks(r10, "Host name");
        Locale r13 = Locale.ROOT;
        this.lcHostname = r10.toLowerCase(r13);
        if (r12 == null) goto L5;
        this.schemeName = r12.toLowerCase(r13);
    L6:
        this.port = r11;
        this.address = null;
        return;
    L5:
        this.schemeName = DEFAULT_SCHEME_NAME;
        goto L6
    }

    public static HttpHost create(String r10) {
        Args.containsNoBlanks(r10, "HTTP Host");
        int r11 = r10.indexOf("://");
        if (r11 <= 0) goto L5;
        String r12 = r10.substring(0, r11);
        r10 = r10.substring(r11 + 3);
    L6:
        int r13 = r10.lastIndexOf(":");
        if (r13 > 0) goto L16;
        int r14 = -1;
    L15:
        return new HttpHost(r10, r14, r12);
    L16:
        r14 = Integer.parseInt(r10.substring(r13 + 1));     // Catch: NumberFormatException -> L11
        r10 = r10.substring(0, r13);
    L12:
        throw new IllegalArgumentException("Invalid HTTP host: " + r10);
    L5:
        r12 = null;
        goto L6
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof HttpHost) == false) goto L23;
        HttpHost r11 = (HttpHost) r10;
        if (this.lcHostname.equals(r11.lcHostname) == false) goto L22;
        if (this.port != r11.port) goto L22;
        if (this.schemeName.equals(r11.schemeName) == false) goto L22;
        InetAddress r12 = this.address;
        if (r12 != null) goto L19;
        if (r11.address != null) goto L22;
        return true;
    L19:
        if (r12.equals(r11.address) == false) goto L22;
        return true;
    L22:
        return false;
    L23:
        return false;
    }

    public InetAddress getAddress() {
        return this.address;
    }

    public String getHostName() {
        return this.hostname;
    }

    public int getPort() {
        return this.port;
    }

    public String getSchemeName() {
        return this.schemeName;
    }

    public int hashCode() {
        int r10 = LangUtils.hashCode(LangUtils.hashCode(LangUtils.hashCode(17, this.lcHostname), this.port), this.schemeName);
        InetAddress r11 = this.address;
        if (r11 != null) goto L5;
        return r10;
    L5:
        return LangUtils.hashCode(r10, r11);
    }

    public String toHostString() {
        if (this.port == (-1)) goto L7;
        StringBuilder r10 = new StringBuilder(this.hostname.length() + 6);
        r10.append(this.hostname);
        r10.append(":");
        r10.append(Integer.toString(this.port));
        return r10.toString();
    L7:
        return this.hostname;
    }

    public String toString() {
        return toURI();
    }

    public String toURI() {
        StringBuilder r10 = new StringBuilder();
        r10.append(this.schemeName);
        r10.append("://");
        r10.append(this.hostname);
        if (this.port == (-1)) goto L6;
        r10.append(':');
        r10.append(Integer.toString(this.port));
    L6:
        return r10.toString();
    }

    public HttpHost(String r10, int r11) {
        this(r10, r11, null);
    }

    public HttpHost(String r10) {
        this(r10, -1, null);
    }

    public HttpHost(InetAddress r10, int r11, String r12) {
        this((InetAddress) Args.notNull(r10, "Inet address"), r10.getHostName(), r11, r12);
    }

    public HttpHost(InetAddress r10, String r11, int r12, String r13) {
        this.address = (InetAddress) Args.notNull(r10, "Inet address");
        String r14 = (String) Args.notNull(r11, "Hostname");
        this.hostname = r14;
        Locale r15 = Locale.ROOT;
        this.lcHostname = r14.toLowerCase(r15);
        if (r13 == null) goto L5;
        this.schemeName = r13.toLowerCase(r15);
    L6:
        this.port = r12;
        return;
    L5:
        this.schemeName = DEFAULT_SCHEME_NAME;
        goto L6
    }

    public HttpHost(InetAddress r10, int r11) {
        this(r10, r11, null);
    }

    public HttpHost(InetAddress r10) {
        this(r10, -1, null);
    }

    public HttpHost(HttpHost r10) {
        Args.notNull(r10, "HTTP host");
        this.hostname = r10.hostname;
        this.lcHostname = r10.lcHostname;
        this.schemeName = r10.schemeName;
        this.port = r10.port;
        this.address = r10.address;
    }
}
