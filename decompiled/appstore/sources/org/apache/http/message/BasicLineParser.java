package org.apache.http.message;

import org.apache.http.Header;
import org.apache.http.HttpVersion;
import org.apache.http.ParseException;
import org.apache.http.ProtocolVersion;
import org.apache.http.RequestLine;
import org.apache.http.StatusLine;
import org.apache.http.annotation.Contract;
import org.apache.http.annotation.ThreadingBehavior;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.Args;
import org.apache.http.util.CharArrayBuffer;

/* JADX INFO: loaded from: classes4.dex */
@Contract(threading = ThreadingBehavior.IMMUTABLE)
public class BasicLineParser implements LineParser {

    @Deprecated
    public static final BasicLineParser DEFAULT = null;
    public static final BasicLineParser INSTANCE = null;
    protected final ProtocolVersion protocol;

    static {
        DEFAULT = new BasicLineParser();
        INSTANCE = new BasicLineParser();
    }

    public BasicLineParser(ProtocolVersion r10) {
        if (r10 != null) goto L6;
        r10 = HttpVersion.HTTP_1_1;
    L6:
        this.protocol = r10;
    }

    public static Header parseHeader(String r10, LineParser r11) throws ParseException {
        Args.notNull(r10, "Value");
        CharArrayBuffer r12 = new CharArrayBuffer(r10.length());
        r12.append(r10);
        if (r11 != null) goto L7;
        r11 = INSTANCE;
    L7:
        return r11.parseHeader(r12);
    }

    public static ProtocolVersion parseProtocolVersion(String r10, LineParser r11) throws ParseException {
        Args.notNull(r10, "Value");
        CharArrayBuffer r12 = new CharArrayBuffer(r10.length());
        r12.append(r10);
        ParserCursor r13 = new ParserCursor(0, r10.length());
        if (r11 != null) goto L7;
        r11 = INSTANCE;
    L7:
        return r11.parseProtocolVersion(r12, r13);
    }

    public static RequestLine parseRequestLine(String r10, LineParser r11) throws ParseException {
        Args.notNull(r10, "Value");
        CharArrayBuffer r12 = new CharArrayBuffer(r10.length());
        r12.append(r10);
        ParserCursor r13 = new ParserCursor(0, r10.length());
        if (r11 != null) goto L7;
        r11 = INSTANCE;
    L7:
        return r11.parseRequestLine(r12, r13);
    }

    public static StatusLine parseStatusLine(String r10, LineParser r11) throws ParseException {
        Args.notNull(r10, "Value");
        CharArrayBuffer r12 = new CharArrayBuffer(r10.length());
        r12.append(r10);
        ParserCursor r13 = new ParserCursor(0, r10.length());
        if (r11 != null) goto L7;
        r11 = INSTANCE;
    L7:
        return r11.parseStatusLine(r12, r13);
    }

    public ProtocolVersion createProtocolVersion(int r10, int r11) {
        return this.protocol.forVersion(r10, r11);
    }

    public RequestLine createRequestLine(String r10, String r11, ProtocolVersion r12) {
        return new BasicRequestLine(r10, r11, r12);
    }

    public StatusLine createStatusLine(ProtocolVersion r10, int r11, String r12) {
        return new BasicStatusLine(r10, r11, r12);
    }

    @Override // org.apache.http.message.LineParser
    public boolean hasProtocolVersion(CharArrayBuffer r10, ParserCursor r11) {
        Args.notNull(r10, "Char array buffer");
        Args.notNull(r11, "Parser cursor");
        int r12 = r11.getPos();
        String r13 = this.protocol.getProtocol();
        int r14 = r13.length();
        boolean r15 = false;
        if (r10.length() >= (r14 + 4)) goto L5;
        return false;
    L5:
        if (r12 >= 0) goto L7;
        r12 = (r10.length() - 4) - r14;
    L13:
        int r16 = r12 + r14;
        if ((r16 + 4) <= r10.length()) goto L16;
        return false;
    L16:
        boolean r17 = true;
        int r18 = 0;
    L17:
        if (r17 == false) goto L24;
        if (r18 >= r14) goto L24;
        if (r10.charAt(r12 + r18) != r13.charAt(r18)) goto L22;
        r17 = true;
    L23:
        r18 = r18 + 1;
        goto L17
    L22:
        r17 = false;
    L24:
        if (r17 == true) goto L26;
        return r17;
    L26:
        if (r10.charAt(r16) != '/') goto L29;
        r15 = true;
    L29:
        return r15;
    L7:
        if (r12 != 0) goto L13;
    L9:
        if (r12 >= r10.length()) goto L13;
        if (HTTP.isWhitespace(r10.charAt(r12)) == false) goto L13;
        r12 = r12 + 1;
        goto L9
    }

    public void skipWhitespace(CharArrayBuffer r10, ParserCursor r11) {
        int r12 = r11.getPos();
        int r13 = r11.getUpperBound();
    L3:
        if (r12 >= r13) goto L7;
        if (HTTP.isWhitespace(r10.charAt(r12)) == false) goto L7;
        r12 = r12 + 1;
    L7:
        r11.updatePos(r12);
    }

    public BasicLineParser() {
        this(null);
    }

    @Override // org.apache.http.message.LineParser
    public Header parseHeader(CharArrayBuffer r10) throws ParseException {
        return new BufferedHeader(r10);
    }

    @Override // org.apache.http.message.LineParser
    public ProtocolVersion parseProtocolVersion(CharArrayBuffer r13, ParserCursor r14) throws ParseException {
        Args.notNull(r13, "Char array buffer");
        Args.notNull(r14, "Parser cursor");
        String r10 = this.protocol.getProtocol();
        int r11 = r10.length();
        int r12 = r14.getPos();
        int r15 = r14.getUpperBound();
        skipWhitespace(r13, r14);
        int r16 = r14.getPos();
        int r17 = r16 + r11;
        if ((r17 + 4) > r15) goto L36;
        boolean r18 = false;
        int r19 = 0;
        boolean r20 = true;
    L5:
        if (r20 == false) goto L12;
        if (r19 >= r11) goto L12;
        if (r13.charAt(r16 + r19) != r10.charAt(r19)) goto L10;
        r20 = true;
    L11:
        r19 = r19 + 1;
        goto L5
    L10:
        r20 = false;
    L12:
        if (r20 == true) goto L14;
    L17:
        if (r20 == false) goto L34;
        int r21 = r16 + (r11 + 1);
        int r22 = r13.indexOf(46, r21, r15);
        if (r22 == (-1)) goto L32;
        int r23 = Integer.parseInt(r13.substringTrimmed(r21, r22));     // Catch: NumberFormatException -> L29
        int r24 = r22 + 1;
        int r25 = r13.indexOf(32, r24, r15);
        if (r25 != (-1)) goto L37;
        r25 = r15;
    L37:
        int r110 = Integer.parseInt(r13.substringTrimmed(r24, r25));     // Catch: NumberFormatException -> L27
        r14.updatePos(r25);
        return createProtocolVersion(r23, r110);
    L28:
        throw new ParseException("Invalid protocol minor version number: " + r13.substring(r12, r15));
    L30:
        throw new ParseException("Invalid protocol major version number: " + r13.substring(r12, r15));
    L32:
        throw new ParseException("Invalid protocol version number: " + r13.substring(r12, r15));
    L34:
        throw new ParseException("Not a valid protocol version: " + r13.substring(r12, r15));
    L14:
        if (r13.charAt(r17) != '/') goto L16;
        r18 = true;
    L16:
        r20 = r18;
        goto L17
    L36:
        throw new ParseException("Not a valid protocol version: " + r13.substring(r12, r15));
    }

    @Override // org.apache.http.message.LineParser
    public RequestLine parseRequestLine(CharArrayBuffer r10, ParserCursor r11) throws ParseException {
        Args.notNull(r10, "Char array buffer");
        Args.notNull(r11, "Parser cursor");
        int r12 = r11.getPos();
        int r13 = r11.getUpperBound();
        skipWhitespace(r10, r11);     // Catch: IndexOutOfBoundsException -> L17
        int r14 = r11.getPos();     // Catch: IndexOutOfBoundsException -> L17
        int r15 = r10.indexOf(32, r14, r13);     // Catch: IndexOutOfBoundsException -> L17
        if (r15 < 0) goto L16;
        String r16 = r10.substringTrimmed(r14, r15);     // Catch: IndexOutOfBoundsException -> L17
        r11.updatePos(r15);     // Catch: IndexOutOfBoundsException -> L17
        skipWhitespace(r10, r11);     // Catch: IndexOutOfBoundsException -> L17
        int r17 = r11.getPos();     // Catch: IndexOutOfBoundsException -> L17
        int r18 = r10.indexOf(32, r17, r13);     // Catch: IndexOutOfBoundsException -> L17
        if (r18 < 0) goto L14;
        String r19 = r10.substringTrimmed(r17, r18);     // Catch: IndexOutOfBoundsException -> L17
        r11.updatePos(r18);     // Catch: IndexOutOfBoundsException -> L17
        ProtocolVersion r20 = parseProtocolVersion(r10, r11);     // Catch: IndexOutOfBoundsException -> L17
        skipWhitespace(r10, r11);     // Catch: IndexOutOfBoundsException -> L17
        if (r11.atEnd() == false) goto L12;
        return createRequestLine(r16, r19, r20);
    L12:
        throw new ParseException("Invalid request line: " + r10.substring(r12, r13));     // Catch: IndexOutOfBoundsException -> L17
    L14:
        throw new ParseException("Invalid request line: " + r10.substring(r12, r13));     // Catch: IndexOutOfBoundsException -> L17
    L16:
        throw new ParseException("Invalid request line: " + r10.substring(r12, r13));     // Catch: IndexOutOfBoundsException -> L17
    L18:
        throw new ParseException("Invalid request line: " + r10.substring(r12, r13));
    }

    @Override // org.apache.http.message.LineParser
    public StatusLine parseStatusLine(CharArrayBuffer r10, ParserCursor r11) throws ParseException {
        Args.notNull(r10, "Char array buffer");
        Args.notNull(r11, "Parser cursor");
        int r12 = r11.getPos();
        int r13 = r11.getUpperBound();
        ProtocolVersion r14 = parseProtocolVersion(r10, r11);     // Catch: IndexOutOfBoundsException -> L23
        skipWhitespace(r10, r11);     // Catch: IndexOutOfBoundsException -> L23
        int r15 = r11.getPos();     // Catch: IndexOutOfBoundsException -> L23
        int r16 = r10.indexOf(32, r15, r13);     // Catch: IndexOutOfBoundsException -> L23
        if (r16 >= 0) goto L6;
        r16 = r13;
    L6:
        String r17 = r10.substringTrimmed(r15, r16);     // Catch: IndexOutOfBoundsException -> L23
        int r18 = 0;
    L9:
        if (r18 < r17.length()) goto L11;
        int r19 = Integer.parseInt(r17);     // Catch: NumberFormatException -> L21 IndexOutOfBoundsException -> L23
        if (r16 >= r13) goto L18;
        String r20 = r10.substringTrimmed(r16, r13);     // Catch: IndexOutOfBoundsException -> L23
    L20:
        return createStatusLine(r14, r19, r20);
    L18:
        r20 = "";
        goto L20
    L22:
        throw new ParseException("Status line contains invalid status code: " + r10.substring(r12, r13));     // Catch: IndexOutOfBoundsException -> L23
    L11:
        if (Character.isDigit(r17.charAt(r18)) == false) goto L14;
        r18 = r18 + 1;     // Catch: IndexOutOfBoundsException -> L23
        goto L9
    L14:
        throw new ParseException("Status line contains invalid status code: " + r10.substring(r12, r13));     // Catch: IndexOutOfBoundsException -> L23
    L24:
        throw new ParseException("Invalid status line: " + r10.substring(r12, r13));
    }
}
