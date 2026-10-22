package org.apache.http.message;

import java.util.BitSet;
import org.apache.http.annotation.Contract;
import org.apache.http.annotation.ThreadingBehavior;
import org.apache.http.util.CharArrayBuffer;

/* JADX INFO: loaded from: classes4.dex */
@Contract(threading = ThreadingBehavior.IMMUTABLE)
public class TokenParser {
    public static final char CR = '\r';
    public static final char DQUOTE = '\"';
    public static final char ESCAPE = '\\';
    public static final char HT = '\t';
    public static final TokenParser INSTANCE = null;
    public static final char LF = '\n';
    public static final char SP = ' ';

    static {
        INSTANCE = new TokenParser();
    }

    public TokenParser() {
    }

    public static BitSet INIT_BITSET(int... r10) {
        BitSet r11 = new BitSet();
        int r12 = r10.length;
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L5;
        r11.set(r10[r13]);
        r13 = r13 + 1;
        goto L3
    L5:
        return r11;
    }

    public static boolean isWhitespace(char r10) {
        if (r10 != ' ') goto L5;
    L12:
        return true;
    L5:
        if (r10 == '\t') goto L12;
        if (r10 == '\r') goto L12;
        if (r10 == '\n') goto L12;
        return false;
    }

    public void copyContent(CharArrayBuffer r10, ParserCursor r11, BitSet r12, StringBuilder r13) {
        int r14 = r11.getPos();
        int r15 = r11.getPos();
        int r16 = r11.getUpperBound();
    L3:
        if (r15 >= r16) goto L12;
        char r17 = r10.charAt(r15);
        if (r12 == null) goto L9;
        if (r12.get(r17) == true) goto L12;
    L9:
        if (isWhitespace(r17) == true) goto L12;
        r14 = r14 + 1;
        r13.append(r17);
        r15 = r15 + 1;
    L12:
        r11.updatePos(r14);
    }

    public void copyQuotedContent(CharArrayBuffer r10, ParserCursor r11, StringBuilder r12) {
        if (r11.atEnd() == false) goto L5;
        return;
    L5:
        int r13 = r11.getPos();
        int r14 = r11.getPos();
        int r15 = r11.getUpperBound();
        if (r10.charAt(r13) == '\"') goto L8;
        return;
    L8:
        int r16 = r13 + 1;
        int r17 = r14 + 1;
        boolean r18 = false;
    L9:
        if (r17 >= r15) goto L26;
        char r19 = r10.charAt(r17);
        if (r18 == false) goto L16;
        if (r19 == '\"') goto L15;
        if (r19 == '\\') goto L15;
        r12.append(ESCAPE);
    L15:
        r12.append(r19);
        r18 = false;
    L25:
        r17 = r17 + 1;
        r16 = r16 + 1;
        goto L9
    L16:
        if (r19 == '\"') goto L17;
        if (r19 != '\\') goto L21;
        r18 = true;
        goto L25
    L21:
        if (r19 == '\r') goto L25;
        if (r19 == '\n') goto L25;
        r12.append(r19);
        goto L25
    L17:
        r16 = r16 + 1;
    L26:
        r11.updatePos(r16);
    }

    public void copyUnquotedContent(CharArrayBuffer r10, ParserCursor r11, BitSet r12, StringBuilder r13) {
        int r14 = r11.getPos();
        int r15 = r11.getPos();
        int r16 = r11.getUpperBound();
    L3:
        if (r15 >= r16) goto L14;
        char r17 = r10.charAt(r15);
        if (r12 == null) goto L9;
        if (r12.get(r17) == true) goto L14;
    L9:
        if (isWhitespace(r17) == true) goto L14;
        if (r17 == '\"') goto L14;
        r14 = r14 + 1;
        r13.append(r17);
        r15 = r15 + 1;
    L14:
        r11.updatePos(r14);
    }

    public String parseToken(CharArrayBuffer r10, ParserCursor r11, BitSet r12) {
        StringBuilder r13 = new StringBuilder();
    L3:
        boolean r14 = false;
    L5:
        if (r11.atEnd() == true) goto L20;
        char r15 = r10.charAt(r11.getPos());
        if (r12 == null) goto L12;
        if (r12.get(r15) == true) goto L20;
    L12:
        if (isWhitespace(r15) == false) goto L14;
        skipWhiteSpace(r10, r11);
        r14 = true;
        goto L5
    L14:
        if (r14 == false) goto L18;
        if (r13.length() <= 0) goto L18;
        r13.append(SP);
    L18:
        copyContent(r10, r11, r12, r13);
    L20:
        return r13.toString();
    }

    public String parseValue(CharArrayBuffer r10, ParserCursor r11, BitSet r12) {
        StringBuilder r13 = new StringBuilder();
    L3:
        boolean r14 = false;
    L5:
        if (r11.atEnd() == true) goto L27;
        char r15 = r10.charAt(r11.getPos());
        if (r12 == null) goto L12;
        if (r12.get(r15) == true) goto L27;
    L12:
        if (isWhitespace(r15) == false) goto L15;
        skipWhiteSpace(r10, r11);
        r14 = true;
        goto L5
    L15:
        if (r15 == '\"') goto L16;
        if (r14 == true) goto L23;
    L25:
        copyUnquotedContent(r10, r11, r12, r13);
        goto L3
    L23:
        if (r13.length() <= 0) goto L25;
        r13.append(SP);
        goto L25
    L16:
        if (r14 == true) goto L18;
    L20:
        copyQuotedContent(r10, r11, r13);
        goto L3
    L18:
        if (r13.length() <= 0) goto L20;
        r13.append(SP);
    L27:
        return r13.toString();
    }

    public void skipWhiteSpace(CharArrayBuffer r10, ParserCursor r11) {
        int r12 = r11.getPos();
        int r13 = r11.getPos();
        int r14 = r11.getUpperBound();
    L3:
        if (r13 >= r14) goto L8;
        if (isWhitespace(r10.charAt(r13)) == false) goto L8;
        r12 = r12 + 1;
        r13 = r13 + 1;
    L8:
        r11.updatePos(r12);
    }
}
