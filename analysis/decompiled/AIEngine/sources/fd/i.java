package fd;

import gc.n;
import gc.o;
import java.net.ProtocolException;
import okhttp3.Protocol;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    public final Protocol f8847a;

    /* renamed from: b, reason: collision with root package name */
    public final int f8848b;

    /* renamed from: c, reason: collision with root package name */
    public final String f8849c;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class a {
        public static i a(String statusLine) throws ProtocolException {
            Protocol protocol;
            int i10;
            String strSubstring;
            kotlin.jvm.internal.g.f(statusLine, "statusLine");
            if (o.k0(statusLine, "HTTP/1.", false)) {
                i10 = 9;
                if (statusLine.length() < 9 || statusLine.charAt(8) != ' ') {
                    throw new ProtocolException("Unexpected status line: ".concat(statusLine));
                }
                int iCharAt = statusLine.charAt(7) - '0';
                if (iCharAt == 0) {
                    protocol = Protocol.f10880c;
                } else {
                    if (iCharAt != 1) {
                        throw new ProtocolException("Unexpected status line: ".concat(statusLine));
                    }
                    protocol = Protocol.f10881d;
                }
            } else if (o.k0(statusLine, "ICY ", false)) {
                protocol = Protocol.f10880c;
                i10 = 4;
            } else {
                if (!o.k0(statusLine, "SOURCETABLE ", false)) {
                    throw new ProtocolException("Unexpected status line: ".concat(statusLine));
                }
                protocol = Protocol.f10881d;
                i10 = 12;
            }
            int i11 = i10 + 3;
            if (statusLine.length() < i11) {
                throw new ProtocolException("Unexpected status line: ".concat(statusLine));
            }
            String strSubstring2 = statusLine.substring(i10, i11);
            kotlin.jvm.internal.g.e(strSubstring2, "substring(...)");
            Integer numC0 = n.c0(strSubstring2);
            if (numC0 == null) {
                throw new ProtocolException("Unexpected status line: ".concat(statusLine));
            }
            int iIntValue = numC0.intValue();
            if (statusLine.length() <= i11) {
                strSubstring = "";
            } else {
                if (statusLine.charAt(i11) != ' ') {
                    throw new ProtocolException("Unexpected status line: ".concat(statusLine));
                }
                strSubstring = statusLine.substring(i10 + 4);
                kotlin.jvm.internal.g.e(strSubstring, "substring(...)");
            }
            return new i(protocol, iIntValue, strSubstring);
        }
    }

    public i(Protocol protocol, int i10, String str) {
        this.f8847a = protocol;
        this.f8848b = i10;
        this.f8849c = str;
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder();
        if (this.f8847a == Protocol.f10880c) {
            sb2.append("HTTP/1.0");
        } else {
            sb2.append("HTTP/1.1");
        }
        sb2.append(' ');
        sb2.append(this.f8848b);
        sb2.append(' ');
        sb2.append(this.f8849c);
        String string = sb2.toString();
        kotlin.jvm.internal.g.e(string, "toString(...)");
        return string;
    }
}
