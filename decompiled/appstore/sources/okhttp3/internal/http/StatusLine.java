package okhttp3.internal.http;

import java.io.IOException;
import java.net.ProtocolException;
import okhttp3.Protocol;
import okhttp3.Response;
import org.apache.http.message.TokenParser;

/* JADX INFO: loaded from: classes4.dex */
public final class StatusLine {
    public static final int HTTP_CONTINUE = 100;
    public static final int HTTP_PERM_REDIRECT = 308;
    public static final int HTTP_TEMP_REDIRECT = 307;
    public final int code;
    public final String message;
    public final Protocol protocol;

    public StatusLine(Protocol r10, int r11, String r12) {
        this.protocol = r10;
        this.code = r11;
        this.message = r12;
    }

    public static StatusLine get(Response r10) {
        return new StatusLine(r10.p(), r10.d(), r10.l());
    }

    public static StatusLine parse(String r10) throws IOException {
        if (r10.startsWith("HTTP/1.") == false) goto L19;
        int r11 = 9;
        if (r10.length() < 9) goto L17;
        if (r10.charAt(8) != ' ') goto L17;
        int r12 = r10.charAt(7) - '0';
        if (r12 != 0) goto L12;
        Protocol r13 = Protocol.HTTP_1_0;
    L21:
        int r14 = r11 + 3;
        if (r10.length() < r14) goto L37;
        int r15 = Integer.parseInt(r10.substring(r11, r14));     // Catch: NumberFormatException -> L34
        if (r10.length() > r14) goto L27;
        String r16 = "";
    L33:
        return new StatusLine(r13, r15, r16);
    L27:
        if (r10.charAt(r14) != ' ') goto L30;
        r16 = r10.substring(r11 + 4);
        goto L33
    L30:
        throw new ProtocolException("Unexpected status line: " + r10);
    L35:
        throw new ProtocolException("Unexpected status line: " + r10);
    L37:
        throw new ProtocolException("Unexpected status line: " + r10);
    L12:
        if (r12 != 1) goto L15;
        r13 = Protocol.HTTP_1_1;
        goto L21
    L15:
        throw new ProtocolException("Unexpected status line: " + r10);
    L17:
        throw new ProtocolException("Unexpected status line: " + r10);
    L19:
        if (r10.startsWith("ICY ") == false) goto L39;
        r13 = Protocol.HTTP_1_0;
        r11 = 4;
        goto L21
    L39:
        throw new ProtocolException("Unexpected status line: " + r10);
    }

    public String toString() {
        StringBuilder r10 = new StringBuilder();
        if (this.protocol != Protocol.HTTP_1_0) goto L5;
        String r11 = "HTTP/1.0";
    L6:
        r10.append(r11);
        r10.append(TokenParser.SP);
        r10.append(this.code);
        if (this.message == null) goto L10;
        r10.append(TokenParser.SP);
        r10.append(this.message);
    L10:
        return r10.toString();
    L5:
        r11 = "HTTP/1.1";
        goto L6
    }
}
