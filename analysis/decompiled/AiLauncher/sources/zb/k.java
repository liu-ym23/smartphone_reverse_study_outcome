package zb;

import La.C;
import La.D;
import com.autonavi.aps.amapapi.config.Const;
import java.io.IOException;
import java.net.ProtocolException;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import okhttp3.Protocol;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\u0018\u0000 \u00122\u00020\u0001:\u0001\fB\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\n\u0010\u000bR\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u0005\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0007\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011¨\u0006\u0013"}, d2 = {"Lzb/k;", "", "Lokhttp3/Protocol;", "protocol", "", "code", "", "message", "<init>", "(Lokhttp3/Protocol;ILjava/lang/String;)V", "toString", "()Ljava/lang/String;", Const.INTENT_KEY_APIKEY, "Lokhttp3/Protocol;", Const.INTENT_KEY_PKGNAME, "I", "c", "Ljava/lang/String;", Const.INTENT_KEY_UMID, "okhttp"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class k {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final Protocol protocol;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final int code;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final String message;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lzb/k$a;", "", "<init>", "()V", "", "statusLine", "Lzb/k;", Const.INTENT_KEY_APIKEY, "(Ljava/lang/String;)Lzb/k;", "okhttp"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* renamed from: zb.k$a, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }

        public final k a(String statusLine) throws IOException {
            Protocol protocol;
            int i10;
            String strSubstring;
            p.i(statusLine, "statusLine");
            if (D.X(statusLine, "HTTP/1.", false, 2, null)) {
                i10 = 9;
                if (statusLine.length() < 9 || statusLine.charAt(8) != ' ') {
                    throw new ProtocolException("Unexpected status line: " + statusLine);
                }
                int iCharAt = statusLine.charAt(7) - '0';
                if (iCharAt == 0) {
                    protocol = Protocol.HTTP_1_0;
                } else {
                    if (iCharAt != 1) {
                        throw new ProtocolException("Unexpected status line: " + statusLine);
                    }
                    protocol = Protocol.HTTP_1_1;
                }
            } else if (D.X(statusLine, "ICY ", false, 2, null)) {
                protocol = Protocol.HTTP_1_0;
                i10 = 4;
            } else {
                if (!D.X(statusLine, "SOURCETABLE ", false, 2, null)) {
                    throw new ProtocolException("Unexpected status line: " + statusLine);
                }
                protocol = Protocol.HTTP_1_1;
                i10 = 12;
            }
            int i11 = i10 + 3;
            if (statusLine.length() < i11) {
                throw new ProtocolException("Unexpected status line: " + statusLine);
            }
            String strSubstring2 = statusLine.substring(i10, i11);
            p.h(strSubstring2, "substring(...)");
            Integer numW = C.w(strSubstring2);
            if (numW == null) {
                throw new ProtocolException("Unexpected status line: " + statusLine);
            }
            int iIntValue = numW.intValue();
            if (statusLine.length() <= i11) {
                strSubstring = "";
            } else {
                if (statusLine.charAt(i11) != ' ') {
                    throw new ProtocolException("Unexpected status line: " + statusLine);
                }
                strSubstring = statusLine.substring(i10 + 4);
                p.h(strSubstring, "substring(...)");
            }
            return new k(protocol, iIntValue, strSubstring);
        }

        public Companion() {
        }
    }

    public k(Protocol protocol, int i10, String message) {
        p.i(protocol, "protocol");
        p.i(message, "message");
        this.protocol = protocol;
        this.code = i10;
        this.message = message;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        if (this.protocol == Protocol.HTTP_1_0) {
            sb2.append("HTTP/1.0");
        } else {
            sb2.append("HTTP/1.1");
        }
        sb2.append(' ');
        sb2.append(this.code);
        sb2.append(' ');
        sb2.append(this.message);
        return sb2.toString();
    }
}
