package org.apache.http.message;

import java.util.ArrayList;
import java.util.BitSet;
import org.apache.http.HeaderElement;
import org.apache.http.NameValuePair;
import org.apache.http.ParseException;
import org.apache.http.annotation.Contract;
import org.apache.http.annotation.ThreadingBehavior;
import org.apache.http.util.Args;
import org.apache.http.util.CharArrayBuffer;

/* JADX INFO: loaded from: classes4.dex */
@Contract(threading = ThreadingBehavior.IMMUTABLE)
public class BasicHeaderValueParser implements HeaderValueParser {

    @Deprecated
    public static final BasicHeaderValueParser DEFAULT = null;
    private static final char ELEM_DELIMITER = ',';
    public static final BasicHeaderValueParser INSTANCE = null;
    private static final char PARAM_DELIMITER = ';';
    private static final BitSet TOKEN_DELIMS = null;
    private static final BitSet VALUE_DELIMS = null;
    private final TokenParser tokenParser;

    static {
        DEFAULT = new BasicHeaderValueParser();
        INSTANCE = new BasicHeaderValueParser();
        TOKEN_DELIMS = TokenParser.INIT_BITSET(new int[]{61, 59, 44});
        VALUE_DELIMS = TokenParser.INIT_BITSET(new int[]{59, 44});
    }

    public BasicHeaderValueParser() {
        this.tokenParser = TokenParser.INSTANCE;
    }

    public static HeaderElement[] parseElements(String r10, HeaderValueParser r11) throws ParseException {
        Args.notNull(r10, "Value");
        CharArrayBuffer r12 = new CharArrayBuffer(r10.length());
        r12.append(r10);
        ParserCursor r13 = new ParserCursor(0, r10.length());
        if (r11 != null) goto L7;
        r11 = INSTANCE;
    L7:
        return r11.parseElements(r12, r13);
    }

    public static HeaderElement parseHeaderElement(String r10, HeaderValueParser r11) throws ParseException {
        Args.notNull(r10, "Value");
        CharArrayBuffer r12 = new CharArrayBuffer(r10.length());
        r12.append(r10);
        ParserCursor r13 = new ParserCursor(0, r10.length());
        if (r11 != null) goto L7;
        r11 = INSTANCE;
    L7:
        return r11.parseHeaderElement(r12, r13);
    }

    public static NameValuePair parseNameValuePair(String r10, HeaderValueParser r11) throws ParseException {
        Args.notNull(r10, "Value");
        CharArrayBuffer r12 = new CharArrayBuffer(r10.length());
        r12.append(r10);
        ParserCursor r13 = new ParserCursor(0, r10.length());
        if (r11 != null) goto L7;
        r11 = INSTANCE;
    L7:
        return r11.parseNameValuePair(r12, r13);
    }

    public static NameValuePair[] parseParameters(String r10, HeaderValueParser r11) throws ParseException {
        Args.notNull(r10, "Value");
        CharArrayBuffer r12 = new CharArrayBuffer(r10.length());
        r12.append(r10);
        ParserCursor r13 = new ParserCursor(0, r10.length());
        if (r11 != null) goto L7;
        r11 = INSTANCE;
    L7:
        return r11.parseParameters(r12, r13);
    }

    public HeaderElement createHeaderElement(String r10, String r11, NameValuePair[] r12) {
        return new BasicHeaderElement(r10, r11, r12);
    }

    public NameValuePair createNameValuePair(String r10, String r11) {
        return new BasicNameValuePair(r10, r11);
    }

    @Override // org.apache.http.message.HeaderValueParser
    public HeaderElement[] parseElements(CharArrayBuffer r10, ParserCursor r11) {
        Args.notNull(r10, "Char array buffer");
        Args.notNull(r11, "Parser cursor");
        ArrayList r12 = new ArrayList();
    L4:
        if (r11.atEnd() == true) goto L11;
        HeaderElement r13 = parseHeaderElement(r10, r11);
        if (r13.getName().isEmpty() == false) goto L9;
        if (r13.getValue() == null) goto L4;
    L9:
        r12.add(r13);
        goto L4
    L11:
        return (HeaderElement[]) r12.toArray(new HeaderElement[r12.size()]);
    }

    @Override // org.apache.http.message.HeaderValueParser
    public HeaderElement parseHeaderElement(CharArrayBuffer r10, ParserCursor r11) {
        Args.notNull(r10, "Char array buffer");
        Args.notNull(r11, "Parser cursor");
        NameValuePair r12 = parseNameValuePair(r10, r11);
        if (r11.atEnd() == false) goto L5;
    L7:
        NameValuePair[] r13 = null;
    L9:
        return createHeaderElement(r12.getName(), r12.getValue(), r13);
    L5:
        if (r10.charAt(r11.getPos() - 1) == ',') goto L7;
        r13 = parseParameters(r10, r11);
        goto L9
    }

    @Override // org.apache.http.message.HeaderValueParser
    public NameValuePair parseNameValuePair(CharArrayBuffer r10, ParserCursor r11) {
        Args.notNull(r10, "Char array buffer");
        Args.notNull(r11, "Parser cursor");
        String r12 = this.tokenParser.parseToken(r10, r11, TOKEN_DELIMS);
        if (r11.atEnd() == true) goto L5;
        char r13 = r10.charAt(r11.getPos());
        r11.updatePos(r11.getPos() + 1);
        if (r13 != '=') goto L9;
        String r14 = this.tokenParser.parseValue(r10, r11, VALUE_DELIMS);
        if (r11.atEnd() == true) goto L14;
        r11.updatePos(r11.getPos() + 1);
    L14:
        return createNameValuePair(r12, r14);
    L9:
        return createNameValuePair(r12, null);
    L5:
        return new BasicNameValuePair(r12, null);
    }

    @Override // org.apache.http.message.HeaderValueParser
    public NameValuePair[] parseParameters(CharArrayBuffer r10, ParserCursor r11) {
        Args.notNull(r10, "Char array buffer");
        Args.notNull(r11, "Parser cursor");
        this.tokenParser.skipWhiteSpace(r10, r11);
        ArrayList r12 = new ArrayList();
    L4:
        if (r11.atEnd() == true) goto L8;
        r12.add(parseNameValuePair(r10, r11));
        if (r10.charAt(r11.getPos() - 1) != ',') goto L4;
    L8:
        return (NameValuePair[]) r12.toArray(new NameValuePair[r12.size()]);
    }

    @Deprecated
    public NameValuePair parseNameValuePair(CharArrayBuffer r10, ParserCursor r11, char[] r12) {
        Args.notNull(r10, "Char array buffer");
        Args.notNull(r11, "Parser cursor");
        BitSet r13 = new BitSet();
        if (r12 == null) goto L7;
        int r14 = r12.length;
        int r15 = 0;
    L5:
        if (r15 >= r14) goto L7;
        r13.set(r12[r15]);
        r15 = r15 + 1;
    L7:
        r13.set(61);
        String r16 = this.tokenParser.parseToken(r10, r11, r13);
        if (r11.atEnd() == true) goto L10;
        char r17 = r10.charAt(r11.getPos());
        r11.updatePos(r11.getPos() + 1);
        if (r17 != '=') goto L14;
        r13.clear(61);
        String r18 = this.tokenParser.parseValue(r10, r11, r13);
        if (r11.atEnd() == true) goto L19;
        r11.updatePos(r11.getPos() + 1);
    L19:
        return createNameValuePair(r16, r18);
    L14:
        return createNameValuePair(r16, null);
    L10:
        return new BasicNameValuePair(r16, null);
    }
}
