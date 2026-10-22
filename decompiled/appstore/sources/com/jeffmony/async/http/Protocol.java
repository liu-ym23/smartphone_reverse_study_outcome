package com.jeffmony.async.http;

import java.util.Hashtable;
import java.util.Locale;

/* JADX INFO: loaded from: classes3.dex */
public enum Protocol extends Enum<Protocol> {
    private static final /* synthetic */ Protocol[] $VALUES = null;
    public static final Protocol HTTP_1_0 = null;
    public static final Protocol HTTP_1_1 = null;
    public static final Protocol HTTP_2 = null;
    public static final Protocol SPDY_3 = null;
    private static final Hashtable<String, Protocol> protocols = null;
    private final String protocol;

    static {
        Protocol r10 = new Protocol("HTTP_1_0", 0, "http/1.0");
        HTTP_1_0 = r10;
        Protocol r11 = new Protocol("HTTP_1_1", 1, "http/1.1");
        HTTP_1_1 = r11;
        final int r12 = 2;
        final String r13 = "spdy/3.1";
        final String r14 = "SPDY_3";
        Protocol r15 = new AnonymousClass1(r14, r12, r13);
        SPDY_3 = r15;
        final int r16 = 3;
        final String r17 = "h2-13";
        final String r18 = "HTTP_2";
        Protocol r19 = new AnonymousClass2(r18, r16, r17);
        HTTP_2 = r19;
        $VALUES = new Protocol[]{r10, r11, r15, r19};
        Hashtable<String, Protocol> r20 = new Hashtable();
        protocols = r20;
        r20.put(r10.toString(), r10);
        r20.put(r11.toString(), r11);
        r20.put(r15.toString(), r15);
        r20.put(r19.toString(), r19);
    }

    public /* synthetic */ Protocol(String r10, int r11, String r12, AnonymousClass1 r13) {
        this(r10, r11, r12);
    }

    public static Protocol get(String r10) {
        if (r10 != null) goto L6;
        return null;
    L6:
        return protocols.get(r10.toLowerCase(Locale.US));
    }

    public static Protocol valueOf(String r10) {
        return (Protocol) Enum.valueOf(Protocol.class, r10);
    }

    public static Protocol[] values() {
        return (Protocol[]) $VALUES.clone();
    }

    public boolean needsSpdyConnection() {
        return false;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.protocol;
    }

    private Protocol(String r10, int r11, String r12) {
        super(r10, r11);
        this.protocol = r12;
    }
}
