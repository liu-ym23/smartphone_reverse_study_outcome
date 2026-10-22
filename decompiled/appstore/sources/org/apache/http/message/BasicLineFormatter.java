package org.apache.http.message;

import org.apache.http.FormattedHeader;
import org.apache.http.Header;
import org.apache.http.ProtocolVersion;
import org.apache.http.RequestLine;
import org.apache.http.StatusLine;
import org.apache.http.annotation.Contract;
import org.apache.http.annotation.ThreadingBehavior;
import org.apache.http.util.Args;
import org.apache.http.util.CharArrayBuffer;

/* JADX INFO: loaded from: classes4.dex */
@Contract(threading = ThreadingBehavior.IMMUTABLE)
public class BasicLineFormatter implements LineFormatter {

    @Deprecated
    public static final BasicLineFormatter DEFAULT = null;
    public static final BasicLineFormatter INSTANCE = null;

    static {
        DEFAULT = new BasicLineFormatter();
        INSTANCE = new BasicLineFormatter();
    }

    public BasicLineFormatter() {
    }

    public static String formatHeader(Header r10, LineFormatter r11) {
        if (r11 != null) goto L6;
        r11 = INSTANCE;
    L6:
        return r11.formatHeader(null, r10).toString();
    }

    public static String formatProtocolVersion(ProtocolVersion r10, LineFormatter r11) {
        if (r11 != null) goto L6;
        r11 = INSTANCE;
    L6:
        return r11.appendProtocolVersion(null, r10).toString();
    }

    public static String formatRequestLine(RequestLine r10, LineFormatter r11) {
        if (r11 != null) goto L6;
        r11 = INSTANCE;
    L6:
        return r11.formatRequestLine(null, r10).toString();
    }

    public static String formatStatusLine(StatusLine r10, LineFormatter r11) {
        if (r11 != null) goto L6;
        r11 = INSTANCE;
    L6:
        return r11.formatStatusLine(null, r10).toString();
    }

    @Override // org.apache.http.message.LineFormatter
    public CharArrayBuffer appendProtocolVersion(CharArrayBuffer r10, ProtocolVersion r11) {
        Args.notNull(r11, "Protocol version");
        int r12 = estimateProtocolVersionLen(r11);
        if (r10 != null) goto L5;
        r10 = new CharArrayBuffer(r12);
    L6:
        r10.append(r11.getProtocol());
        r10.append('/');
        r10.append(Integer.toString(r11.getMajor()));
        r10.append('.');
        r10.append(Integer.toString(r11.getMinor()));
        return r10;
    L5:
        r10.ensureCapacity(r12);
        goto L6
    }

    public void doFormatHeader(CharArrayBuffer r10, Header r11) {
        String r12 = r11.getName();
        String r13 = r11.getValue();
        int r14 = r12.length() + 2;
        if (r13 == null) goto L5;
        r14 = r14 + r13.length();
    L5:
        r10.ensureCapacity(r14);
        r10.append(r12);
        r10.append(": ");
        if (r13 == null) goto L20;
        r10.ensureCapacity(r10.length() + r13.length());
        int r15 = 0;
    L9:
        if (r15 >= r13.length()) goto L24;
        char r16 = r13.charAt(r15);
        if (r16 != '\r') goto L13;
    L18:
        r16 = TokenParser.SP;
    L19:
        r10.append(r16);
        r15 = r15 + 1;
        goto L9
    L13:
        if (r16 == '\n') goto L18;
        if (r16 == '\f') goto L18;
        if (r16 != 11) goto L19;
    L24:
        return;
    }

    public void doFormatRequestLine(CharArrayBuffer r10, RequestLine r11) {
        String r12 = r11.getMethod();
        String r13 = r11.getUri();
        r10.ensureCapacity((((r12.length() + 1) + r13.length()) + 1) + estimateProtocolVersionLen(r11.getProtocolVersion()));
        r10.append(r12);
        r10.append(TokenParser.SP);
        r10.append(r13);
        r10.append(TokenParser.SP);
        appendProtocolVersion(r10, r11.getProtocolVersion());
    }

    public void doFormatStatusLine(CharArrayBuffer r10, StatusLine r11) {
        int r12 = estimateProtocolVersionLen(r11.getProtocolVersion()) + 5;
        String r13 = r11.getReasonPhrase();
        if (r13 == null) goto L5;
        r12 = r12 + r13.length();
    L5:
        r10.ensureCapacity(r12);
        appendProtocolVersion(r10, r11.getProtocolVersion());
        r10.append(TokenParser.SP);
        r10.append(Integer.toString(r11.getStatusCode()));
        r10.append(TokenParser.SP);
        if (r13 == null) goto L9;
        r10.append(r13);
        return;
    }

    public int estimateProtocolVersionLen(ProtocolVersion r10) {
        return r10.getProtocol().length() + 4;
    }

    public CharArrayBuffer initBuffer(CharArrayBuffer r10) {
        if (r10 == null) goto L5;
        r10.clear();
        return r10;
    L5:
        return new CharArrayBuffer(64);
    }

    @Override // org.apache.http.message.LineFormatter
    public CharArrayBuffer formatHeader(CharArrayBuffer r10, Header r11) {
        Args.notNull(r11, "Header");
        if ((r11 instanceof FormattedHeader) == true) goto L7;
        CharArrayBuffer r12 = initBuffer(r10);
        doFormatHeader(r12, r11);
        return r12;
    L7:
        return ((FormattedHeader) r11).getBuffer();
    }

    @Override // org.apache.http.message.LineFormatter
    public CharArrayBuffer formatRequestLine(CharArrayBuffer r10, RequestLine r11) {
        Args.notNull(r11, "Request line");
        CharArrayBuffer r12 = initBuffer(r10);
        doFormatRequestLine(r12, r11);
        return r12;
    }

    @Override // org.apache.http.message.LineFormatter
    public CharArrayBuffer formatStatusLine(CharArrayBuffer r10, StatusLine r11) {
        Args.notNull(r11, "Status line");
        CharArrayBuffer r12 = initBuffer(r10);
        doFormatStatusLine(r12, r11);
        return r12;
    }
}
