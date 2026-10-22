package G4;

import C4.B;
import java.net.ProtocolException;
import org.libpag.BuildConfig;

/* loaded from: classes.dex */
public final class k {

    /* renamed from: a, reason: collision with root package name */
    public final B f1936a;

    /* renamed from: b, reason: collision with root package name */
    public final int f1937b;

    /* renamed from: c, reason: collision with root package name */
    public final String f1938c;

    public k(B b6, int i5, String str) {
        this.f1936a = b6;
        this.f1937b = i5;
        this.f1938c = str;
    }

    public static k a(String str) throws ProtocolException, NumberFormatException {
        B b6;
        int i5;
        String strSubstring;
        if (str.startsWith("HTTP/1.")) {
            i5 = 9;
            if (str.length() < 9 || str.charAt(8) != ' ') {
                throw new ProtocolException("Unexpected status line: " + str);
            }
            int iCharAt = str.charAt(7) - '0';
            if (iCharAt == 0) {
                b6 = B.HTTP_1_0;
            } else {
                if (iCharAt != 1) {
                    throw new ProtocolException("Unexpected status line: " + str);
                }
                b6 = B.HTTP_1_1;
            }
        } else {
            if (!str.startsWith("ICY ")) {
                throw new ProtocolException("Unexpected status line: " + str);
            }
            b6 = B.HTTP_1_0;
            i5 = 4;
        }
        int i6 = i5 + 3;
        if (str.length() < i6) {
            throw new ProtocolException("Unexpected status line: " + str);
        }
        try {
            int i7 = Integer.parseInt(str.substring(i5, i6));
            if (str.length() <= i6) {
                strSubstring = BuildConfig.FLAVOR;
            } else {
                if (str.charAt(i6) != ' ') {
                    throw new ProtocolException("Unexpected status line: " + str);
                }
                strSubstring = str.substring(i5 + 4);
            }
            return new k(b6, i7, strSubstring);
        } catch (NumberFormatException unused) {
            throw new ProtocolException("Unexpected status line: " + str);
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f1936a == B.HTTP_1_0 ? "HTTP/1.0" : "HTTP/1.1");
        sb.append(' ');
        sb.append(this.f1937b);
        if (this.f1938c != null) {
            sb.append(' ');
            sb.append(this.f1938c);
        }
        return sb.toString();
    }
}
