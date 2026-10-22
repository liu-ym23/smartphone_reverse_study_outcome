package org.apache.http;

import org.apache.http.annotation.Contract;
import org.apache.http.annotation.ThreadingBehavior;

/* JADX INFO: loaded from: classes4.dex */
@Contract(threading = ThreadingBehavior.IMMUTABLE)
public final class HttpVersion extends ProtocolVersion {
    public static final String HTTP = "HTTP";
    public static final HttpVersion HTTP_0_9 = null;
    public static final HttpVersion HTTP_1_0 = null;
    public static final HttpVersion HTTP_1_1 = null;
    private static final long serialVersionUID = -5856653513894415344L;

    static {
        HTTP_0_9 = new HttpVersion(0, 9);
        HTTP_1_0 = new HttpVersion(1, 0);
        HTTP_1_1 = new HttpVersion(1, 1);
    }

    public HttpVersion(int r10, int r11) {
        super(HTTP, r10, r11);
    }

    @Override // org.apache.http.ProtocolVersion
    public ProtocolVersion forVersion(int r10, int r11) {
        if (r10 != this.major) goto L8;
        if (r11 != this.minor) goto L8;
        return this;
    L8:
        if (r10 != 1) goto L15;
        if (r11 == 0) goto L11;
        if (r11 != 1) goto L15;
        return HTTP_1_1;
    L11:
        return HTTP_1_0;
    L15:
        if (r10 != 0) goto L21;
        if (r11 != 9) goto L21;
        return HTTP_0_9;
    L21:
        return new HttpVersion(r10, r11);
    }
}
