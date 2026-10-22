package okhttp3.internal.tls;

import javax.security.auth.x500.X500Principal;
import org.apache.http.message.TokenParser;

/* JADX INFO: loaded from: classes4.dex */
final class DistinguishedNameParser {
    private int beg;
    private char[] chars;
    private int cur;
    private final String dn;
    private int end;
    private final int length;
    private int pos;

    public DistinguishedNameParser(X500Principal r10) {
        String r11 = r10.getName("RFC2253");
        this.dn = r11;
        this.length = r11.length();
    }

    private String escapedAV() {
        int r10 = this.pos;
        this.beg = r10;
        this.end = r10;
    L3:
        int r11 = this.pos;
        if (r11 >= this.length) goto L5;
        char[] r12 = this.chars;
        char r13 = r12[r11];
        if (r13 != ' ') goto L9;
        int r14 = this.end;
        this.cur = r14;
        this.pos = r11 + 1;
        this.end = r14 + 1;
        r12[r14] = TokenParser.SP;
    L19:
        int r15 = this.pos;
        int r16 = this.length;
        if (r15 >= r16) goto L24;
        char[] r17 = this.chars;
        if (r17[r15] != ' ') goto L24;
        int r18 = this.end;
        this.end = r18 + 1;
        r17[r18] = TokenParser.SP;
        this.pos = r15 + 1;
    L24:
        if (r15 == r16) goto L29;
        char r19 = this.chars[r15];
        if (r19 == ',') goto L29;
        if (r19 == '+') goto L29;
        if (r19 != ';') goto L3;
    L29:
        char[] r20 = this.chars;
        int r21 = this.beg;
        return new String(r20, r21, this.cur - r21);
    L9:
        if (r13 == ';') goto L16;
        if (r13 != '\\') goto L12;
        int r22 = this.end;
        this.end = r22 + 1;
        r12[r22] = getEscaped();
        this.pos++;
        goto L3
    L12:
        if (r13 == '+') goto L16;
        if (r13 == ',') goto L16;
        int r23 = this.end;
        this.end = r23 + 1;
        r12[r23] = r13;
        this.pos = r11 + 1;
    L16:
        char[] r24 = this.chars;
        int r25 = this.beg;
        return new String(r24, r25, this.end - r25);
    L5:
        char[] r26 = this.chars;
        int r27 = this.beg;
        return new String(r26, r27, this.end - r27);
    }

    private int getByte(int r10) {
        int r11 = r10 + 1;
        if (r11 >= this.length) goto L31;
        char[] r12 = this.chars;
        char r13 = r12[r10];
        if (r13 < '0') goto L8;
        if (r13 > '9') goto L8;
        int r14 = r13 - '0';
    L14:
        char r15 = r12[r11];
        if (r15 < '0') goto L18;
        if (r15 > '9') goto L18;
        int r16 = r15 - '0';
    L25:
        return (r14 << 4) + r16;
    L18:
        if (r15 < 'a') goto L21;
        if (r15 > 'f') goto L21;
        r16 = r15 - 'W';
    L21:
        if (r15 < 'A') goto L27;
        if (r15 > 'F') goto L27;
        r16 = r15 - '7';
    L27:
        throw new IllegalStateException("Malformed DN: " + this.dn);
    L8:
        if (r13 < 'a') goto L11;
        if (r13 > 'f') goto L11;
        r14 = r13 - 'W';
    L11:
        if (r13 < 'A') goto L29;
        if (r13 > 'F') goto L29;
        r14 = r13 - '7';
    L29:
        throw new IllegalStateException("Malformed DN: " + this.dn);
    L31:
        throw new IllegalStateException("Malformed DN: " + this.dn);
    }

    private char getEscaped() {
        int r10 = this.pos + 1;
        this.pos = r10;
        if (r10 == this.length) goto L22;
        char r11 = this.chars[r10];
        if (r11 != ' ') goto L7;
    L20:
        return r11;
    L7:
        if (r11 == '%') goto L20;
        if (r11 == '\\') goto L20;
        if (r11 == '_') goto L20;
        if (r11 == '\"') goto L20;
        if (r11 == '#') goto L20;
        switch(r11) {
            case 42: goto L20;
            case 43: goto L20;
            case 44: goto L20;
            default: goto L17;
        };
    L17:
        switch(r11) {
            case 59: goto L20;
            case 60: goto L20;
            case 61: goto L20;
            case 62: goto L20;
            default: goto L19;
        };
    L19:
        return getUTF8();
    L22:
        throw new IllegalStateException("Unexpected end of DN: " + this.dn);
    }

    private char getUTF8() {
        int r10 = getByte(this.pos);
        this.pos++;
        if (r10 >= 128) goto L7;
        return (char) r10;
    L7:
        if (r10 >= 192) goto L9;
    L31:
        return '?';
    L9:
        if (r10 > 247) goto L31;
        if (r10 > 223) goto L14;
        int r11 = r10 & 31;
        int r12 = 1;
    L17:
        int r13 = 0;
    L18:
        if (r13 >= r12) goto L30;
        int r14 = this.pos;
        int r15 = r14 + 1;
        this.pos = r15;
        if (r15 == this.length) goto L28;
        if (this.chars[r15] != '\\') goto L28;
        int r16 = r14 + 2;
        this.pos = r16;
        int r17 = getByte(r16);
        this.pos++;
        if ((r17 & 192) != 128) goto L26;
        r11 = (r11 << 6) + (r17 & 63);
        r13 = r13 + 1;
        goto L18
    L26:
        return '?';
    L28:
        return '?';
    L30:
        return (char) r11;
    L14:
        if (r10 > 239) goto L16;
        r11 = r10 & 15;
        r12 = 2;
        goto L17
    L16:
        r11 = r10 & 7;
        r12 = 3;
        goto L17
    }

    private String hexAV() {
        int r10 = this.pos;
        if ((r10 + 4) >= this.length) goto L41;
        this.beg = r10;
        this.pos = r10 + 1;
    L5:
        int r11 = this.pos;
        if (r11 == this.length) goto L28;
        char[] r12 = this.chars;
        char r13 = r12[r11];
        if (r13 == '+') goto L28;
        if (r13 == ',') goto L28;
        if (r13 == ';') goto L28;
        if (r13 == ' ') goto L16;
        if (r13 < 'A') goto L27;
        if (r13 > 'F') goto L27;
        r12[r11] = (char) (r13 + TokenParser.SP);
    L27:
        this.pos = r11 + 1;
        goto L5
    L16:
        this.end = r11;
        this.pos = r11 + 1;
    L17:
        int r14 = this.pos;
        if (r14 >= this.length) goto L29;
        if (this.chars[r14] != ' ') goto L29;
        this.pos = r14 + 1;
    L29:
        int r15 = this.end;
        int r16 = this.beg;
        int r17 = r15 - r16;
        if (r17 < 5) goto L39;
        if ((r17 & 1) == 0) goto L39;
        int r18 = r17 / 2;
        byte[] r19 = new byte[r18];
        int r20 = r16 + 1;
        int r21 = 0;
    L34:
        if (r21 >= r18) goto L37;
        r19[r21] = (byte) getByte(r20);
        r20 = r20 + 2;
        r21 = r21 + 1;
        goto L34
    L37:
        return new String(this.chars, this.beg, r17);
    L39:
        throw new IllegalStateException("Unexpected end of DN: " + this.dn);
    L28:
        this.end = r11;
        goto L29
    L41:
        throw new IllegalStateException("Unexpected end of DN: " + this.dn);
    }

    private String nextAT() {
    L2:
        int r10 = this.pos;
        int r11 = this.length;
        if (r10 >= r11) goto L7;
        if (this.chars[r10] != ' ') goto L7;
        this.pos = r10 + 1;
    L7:
        if (r10 != r11) goto L10;
        return null;
    L10:
        this.beg = r10;
        this.pos = r10 + 1;
    L11:
        int r12 = this.pos;
        int r13 = this.length;
        if (r12 >= r13) goto L18;
        char r14 = this.chars[r12];
        if (r14 == '=') goto L18;
        if (r14 == ' ') goto L18;
        this.pos = r12 + 1;
    L18:
        if (r12 >= r13) goto L59;
        this.end = r12;
        if (this.chars[r12] != ' ') goto L33;
    L21:
        int r15 = this.pos;
        int r16 = this.length;
        if (r15 >= r16) goto L28;
        char r17 = this.chars[r15];
        if (r17 == '=') goto L28;
        if (r17 != ' ') goto L28;
        this.pos = r15 + 1;
    L28:
        if (this.chars[r15] != '=') goto L32;
        if (r15 != r16) goto L33;
    L32:
        throw new IllegalStateException("Unexpected end of DN: " + this.dn);
    L33:
        this.pos++;
    L34:
        int r18 = this.pos;
        if (r18 >= this.length) goto L39;
        if (this.chars[r18] != ' ') goto L39;
        this.pos = r18 + 1;
    L39:
        int r19 = this.end;
        int r20 = this.beg;
        if ((r19 - r20) <= 4) goto L56;
        char[] r21 = this.chars;
        if (r21[r20 + 3] != '.') goto L56;
        char r22 = r21[r20];
        if (r22 == 'O') goto L48;
        if (r22 != 'o') goto L56;
    L48:
        if (r21[r20 + 1] == 'I') goto L52;
        if (r21[r20 + 1] != 'i') goto L56;
    L52:
        if (r21[r20 + 2] != 'D') goto L54;
    L55:
        this.beg = r20 + 4;
        goto L56
    L54:
        if (r21[r20 + 2] == 'd') goto L55;
    L56:
        char[] r23 = this.chars;
        int r24 = this.beg;
        return new String(r23, r24, this.end - r24);
    L59:
        throw new IllegalStateException("Unexpected end of DN: " + this.dn);
    }

    private String quotedAV() {
        int r10 = this.pos + 1;
        this.pos = r10;
        this.beg = r10;
        this.end = r10;
    L3:
        int r11 = this.pos;
        if (r11 == this.length) goto L21;
        char[] r12 = this.chars;
        char r13 = r12[r11];
        if (r13 == '\"') goto L7;
        if (r13 != '\\') goto L18;
        r12[this.end] = getEscaped();
    L19:
        this.pos++;
        this.end++;
        goto L3
    L18:
        r12[this.end] = r13;
        goto L19
    L7:
        this.pos = r11 + 1;
    L8:
        int r14 = this.pos;
        if (r14 >= this.length) goto L13;
        if (this.chars[r14] != ' ') goto L13;
        this.pos = r14 + 1;
    L13:
        char[] r15 = this.chars;
        int r16 = this.beg;
        return new String(r15, r16, this.end - r16);
    L21:
        throw new IllegalStateException("Unexpected end of DN: " + this.dn);
    }

    public String findMostSpecific(String r10) {
        this.pos = 0;
        this.beg = 0;
        this.end = 0;
        this.cur = 0;
        this.chars = this.dn.toCharArray();
        String r11 = nextAT();
        if (r11 != null) goto L5;
        return null;
    L5:
        int r12 = this.pos;
        if (r12 == this.length) goto L7;
        char r13 = this.chars[r12];
        if (r13 != '\"') goto L11;
        String r14 = quotedAV();
    L20:
        if (r10.equalsIgnoreCase(r11) == true) goto L21;
        int r15 = this.pos;
        if (r15 >= this.length) goto L24;
        char r16 = this.chars[r15];
        if (r16 == ',') goto L33;
        if (r16 == ';') goto L33;
        if (r16 == '+') goto L33;
        throw new IllegalStateException("Malformed DN: " + this.dn);
    L33:
        this.pos = r15 + 1;
        r11 = nextAT();
        if (r11 != null) goto L5;
        throw new IllegalStateException("Malformed DN: " + this.dn);
    L24:
        return null;
    L21:
        return r14;
    L11:
        if (r13 == '#') goto L17;
        if (r13 == '+') goto L16;
        if (r13 == ',') goto L16;
        if (r13 == ';') goto L16;
        r14 = escapedAV();
    L16:
        r14 = "";
        goto L20
    L17:
        r14 = hexAV();
        goto L20
    L7:
        return null;
    }
}
