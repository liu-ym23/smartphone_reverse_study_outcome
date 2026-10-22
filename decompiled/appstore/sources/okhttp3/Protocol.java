package okhttp3;

import java.io.IOException;

/* JADX INFO: loaded from: classes4.dex */
public final enum Protocol extends Enum<Protocol> {
    private static final /* synthetic */ Protocol[] $VALUES = null;
    public static final Protocol HTTP_1_0 = null;
    public static final Protocol HTTP_1_1 = null;
    public static final Protocol HTTP_2 = null;
    public static final Protocol QUIC = null;
    public static final Protocol SPDY_3 = null;
    private final String protocol;

    static {
        Protocol r10 = new Protocol("HTTP_1_0", 0, "http/1.0");
        HTTP_1_0 = r10;
        Protocol r11 = new Protocol("HTTP_1_1", 1, "http/1.1");
        HTTP_1_1 = r11;
        Protocol r12 = new Protocol("SPDY_3", 2, "spdy/3.1");
        SPDY_3 = r12;
        Protocol r13 = new Protocol("HTTP_2", 3, "h2");
        HTTP_2 = r13;
        Protocol r14 = new Protocol("QUIC", 4, "quic");
        QUIC = r14;
        $VALUES = new Protocol[]{r10, r11, r12, r13, r14};
    }

    private Protocol(String r10, int r11, String r12) {
        super(r10, r11);
        this.protocol = r12;
    }

    public static Protocol get(String r10) throws IOException {
        Protocol r11 = HTTP_1_0;
        if (r10.equals(r11.protocol) == false) goto L5;
        return r11;
    L5:
        Protocol r12 = HTTP_1_1;
        if (r10.equals(r12.protocol) == false) goto L8;
        return r12;
    L8:
        Protocol r13 = HTTP_2;
        if (r10.equals(r13.protocol) == false) goto L11;
        return r13;
    L11:
        Protocol r14 = SPDY_3;
        if (r10.equals(r14.protocol) == false) goto L14;
        return r14;
    L14:
        Protocol r15 = QUIC;
        if (r10.equals(r15.protocol) == false) goto L18;
        return r15;
    L18:
        throw new IOException("Unexpected protocol: " + r10);
    }

    public static Protocol valueOf(String r10) {
        return (Protocol) Enum.valueOf(Protocol.class, r10);
    }

    public static Protocol[] values() {
        return (Protocol[]) $VALUES.clone();
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.protocol;
    }
}
