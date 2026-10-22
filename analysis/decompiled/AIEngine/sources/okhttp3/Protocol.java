package okhttp3;

import gc.o;
import java.io.IOException;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class Protocol {

    /* renamed from: b, reason: collision with root package name */
    public static final a f10879b;

    /* renamed from: c, reason: collision with root package name */
    public static final Protocol f10880c;

    /* renamed from: d, reason: collision with root package name */
    public static final Protocol f10881d;

    /* renamed from: e, reason: collision with root package name */
    public static final Protocol f10882e;
    public static final Protocol h;

    /* renamed from: j, reason: collision with root package name */
    public static final Protocol f10883j;

    /* renamed from: k, reason: collision with root package name */
    public static final Protocol f10884k;

    /* renamed from: l, reason: collision with root package name */
    public static final Protocol f10885l;

    /* renamed from: m, reason: collision with root package name */
    public static final /* synthetic */ Protocol[] f10886m;

    /* renamed from: a, reason: collision with root package name */
    public final String f10887a;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class a {
        public static Protocol a(String str) throws IOException {
            Protocol protocol = Protocol.f10880c;
            if (str.equals("http/1.0")) {
                return protocol;
            }
            Protocol protocol2 = Protocol.f10881d;
            if (str.equals("http/1.1")) {
                return protocol2;
            }
            Protocol protocol3 = Protocol.f10883j;
            if (str.equals("h2_prior_knowledge")) {
                return protocol3;
            }
            Protocol protocol4 = Protocol.h;
            if (str.equals("h2")) {
                return protocol4;
            }
            Protocol protocol5 = Protocol.f10882e;
            if (str.equals("spdy/3.1")) {
                return protocol5;
            }
            Protocol protocol6 = Protocol.f10884k;
            if (str.equals("quic")) {
                return protocol6;
            }
            Protocol protocol7 = Protocol.f10885l;
            if (o.k0(str, "h3", false)) {
                return protocol7;
            }
            throw new IOException("Unexpected protocol: ".concat(str));
        }
    }

    static {
        Protocol protocol = new Protocol("HTTP_1_0", 0, "http/1.0");
        f10880c = protocol;
        Protocol protocol2 = new Protocol("HTTP_1_1", 1, "http/1.1");
        f10881d = protocol2;
        Protocol protocol3 = new Protocol("SPDY_3", 2, "spdy/3.1");
        f10882e = protocol3;
        Protocol protocol4 = new Protocol("HTTP_2", 3, "h2");
        h = protocol4;
        Protocol protocol5 = new Protocol("H2_PRIOR_KNOWLEDGE", 4, "h2_prior_knowledge");
        f10883j = protocol5;
        Protocol protocol6 = new Protocol("QUIC", 5, "quic");
        f10884k = protocol6;
        Protocol protocol7 = new Protocol("HTTP_3", 6, "h3");
        f10885l = protocol7;
        Protocol[] protocolArr = {protocol, protocol2, protocol3, protocol4, protocol5, protocol6, protocol7};
        f10886m = protocolArr;
        kotlin.enums.a.a(protocolArr);
        f10879b = new a();
    }

    public Protocol(String str, int i10, String str2) {
        this.f10887a = str2;
    }

    public static Protocol valueOf(String str) {
        return (Protocol) Enum.valueOf(Protocol.class, str);
    }

    public static Protocol[] values() {
        return (Protocol[]) f10886m.clone();
    }

    @Override // java.lang.Enum
    public final String toString() {
        return this.f10887a;
    }
}
