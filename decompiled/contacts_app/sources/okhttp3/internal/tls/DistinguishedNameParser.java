package okhttp3.internal.tls;

import javax.security.auth.x500.X500Principal;

/* JADX INFO: loaded from: classes5.dex */
final class DistinguishedNameParser {
    private int beg;
    private char[] chars;
    private int cur;
    private final String dn;
    private int end;
    private final int length;
    private int pos;

    DistinguishedNameParser(X500Principal r2) {
        String r3 = r2.getName("RFC2253");
        this.dn = r3;
        this.length = r3.length();
    }

    private String nextAT() {
    L2:
        int r0 = this.pos;
        int r1 = this.length;
        if (r0 >= r1) goto L7;
        if (this.chars[r0] != ' ') goto L7;
        this.pos = r0 + 1;
    L7:
        if (r0 != r1) goto L10;
        return null;
    L10:
        this.beg = r0;
        this.pos = r0 + 1;
    L11:
        int r2 = this.pos;
        int r3 = this.length;
        if (r2 >= r3) goto L18;
        char r4 = this.chars[r2];
        if (r4 == '=') goto L18;
        if (r4 == ' ') goto L18;
        this.pos = r2 + 1;
    L18:
        if (r2 >= r3) goto L59;
        this.end = r2;
        if (this.chars[r2] != ' ') goto L33;
    L21:
        int r5 = this.pos;
        int r6 = this.length;
        if (r5 >= r6) goto L28;
        char r7 = this.chars[r5];
        if (r7 == '=') goto L28;
        if (r7 != ' ') goto L28;
        this.pos = r5 + 1;
    L28:
        if (this.chars[r5] != '=') goto L32;
        if (r5 != r6) goto L33;
    L32:
        throw new IllegalStateException("Unexpected end of DN: " + this.dn);
    L33:
        this.pos++;
    L34:
        int r8 = this.pos;
        if (r8 >= this.length) goto L39;
        if (this.chars[r8] != ' ') goto L39;
        this.pos = r8 + 1;
    L39:
        int r9 = this.end;
        int r10 = this.beg;
        if ((r9 - r10) <= 4) goto L56;
        char[] r11 = this.chars;
        if (r11[r10 + 3] != '.') goto L56;
        char r12 = r11[r10];
        if (r12 == 'O') goto L48;
        if (r12 != 'o') goto L56;
    L48:
        if (r11[r10 + 1] == 'I') goto L52;
        if (r11[r10 + 1] != 'i') goto L56;
    L52:
        if (r11[r10 + 2] != 'D') goto L54;
    L55:
        this.beg = r10 + 4;
        goto L56
    L54:
        if (r11[r10 + 2] == 'd') goto L55;
    L56:
        char[] r13 = this.chars;
        int r14 = this.beg;
        return new String(r13, r14, this.end - r14);
    L59:
        throw new IllegalStateException("Unexpected end of DN: " + this.dn);
    }

    private String quotedAV() {
        int r0 = this.pos + 1;
        this.pos = r0;
        this.beg = r0;
        this.end = r0;
    L3:
        int r1 = this.pos;
        if (r1 == this.length) goto L21;
        char[] r2 = this.chars;
        char r3 = r2[r1];
        if (r3 == '\"') goto L7;
        if (r3 != '\\') goto L18;
        r2[this.end] = getEscaped();
    L19:
        this.pos++;
        this.end++;
        goto L3
    L18:
        r2[this.end] = r3;
        goto L19
    L7:
        this.pos = r1 + 1;
    L8:
        int r4 = this.pos;
        if (r4 >= this.length) goto L13;
        if (this.chars[r4] != ' ') goto L13;
        this.pos = r4 + 1;
    L13:
        char[] r5 = this.chars;
        int r6 = this.beg;
        return new String(r5, r6, this.end - r6);
    L21:
        throw new IllegalStateException("Unexpected end of DN: " + this.dn);
    }

    private String hexAV() {
        int r0 = this.pos;
        if ((r0 + 4) >= this.length) goto L41;
        this.beg = r0;
        this.pos = r0 + 1;
    L5:
        int r1 = this.pos;
        if (r1 == this.length) goto L28;
        char[] r2 = this.chars;
        char r3 = r2[r1];
        if (r3 == '+') goto L28;
        if (r3 == ',') goto L28;
        if (r3 == ';') goto L28;
        if (r3 == ' ') goto L16;
        if (r3 < 'A') goto L27;
        if (r3 > 'F') goto L27;
        r2[r1] = (char) (r3 + ' ');
    L27:
        this.pos = r1 + 1;
        goto L5
    L16:
        this.end = r1;
        this.pos = r1 + 1;
    L17:
        int r4 = this.pos;
        if (r4 >= this.length) goto L29;
        if (this.chars[r4] != ' ') goto L29;
        this.pos = r4 + 1;
    L29:
        int r5 = this.end;
        int r6 = this.beg;
        int r7 = r5 - r6;
        if (r7 < 5) goto L39;
        if ((r7 & 1) == 0) goto L39;
        int r8 = r7 / 2;
        byte[] r9 = new byte[r8];
        int r10 = r6 + 1;
        int r11 = 0;
    L34:
        if (r11 >= r8) goto L37;
        r9[r11] = (byte) getByte(r10);
        r10 = r10 + 2;
        r11 = r11 + 1;
        goto L34
    L37:
        return new String(this.chars, this.beg, r7);
    L39:
        throw new IllegalStateException("Unexpected end of DN: " + this.dn);
    L28:
        this.end = r1;
        goto L29
    L41:
        throw new IllegalStateException("Unexpected end of DN: " + this.dn);
    }

    private String escapedAV() {
        int r0 = this.pos;
        this.beg = r0;
        this.end = r0;
    L3:
        int r1 = this.pos;
        if (r1 >= this.length) goto L5;
        char[] r2 = this.chars;
        char r3 = r2[r1];
        if (r3 != ' ') goto L9;
        int r4 = this.end;
        this.cur = r4;
        this.pos = r1 + 1;
        this.end = r4 + 1;
        r2[r4] = ' ';
    L19:
        int r5 = this.pos;
        int r6 = this.length;
        if (r5 >= r6) goto L24;
        char[] r7 = this.chars;
        if (r7[r5] != ' ') goto L24;
        int r8 = this.end;
        this.end = r8 + 1;
        r7[r8] = ' ';
        this.pos = r5 + 1;
    L24:
        if (r5 == r6) goto L29;
        char r9 = this.chars[r5];
        if (r9 == ',') goto L29;
        if (r9 == '+') goto L29;
        if (r9 != ';') goto L3;
    L29:
        char[] r10 = this.chars;
        int r11 = this.beg;
        return new String(r10, r11, this.cur - r11);
    L9:
        if (r3 == ';') goto L16;
        if (r3 != '\\') goto L12;
        int r12 = this.end;
        this.end = r12 + 1;
        r2[r12] = getEscaped();
        this.pos++;
        goto L3
    L12:
        if (r3 == '+') goto L16;
        if (r3 == ',') goto L16;
        int r13 = this.end;
        this.end = r13 + 1;
        r2[r13] = r3;
        this.pos = r1 + 1;
    L16:
        char[] r14 = this.chars;
        int r15 = this.beg;
        return new String(r14, r15, this.end - r15);
    L5:
        char[] r16 = this.chars;
        int r17 = this.beg;
        return new String(r16, r17, this.end - r17);
    }

    private char getEscaped() {
        int r0 = this.pos + 1;
        this.pos = r0;
        if (r0 == this.length) goto L22;
        char r1 = this.chars[r0];
        if (r1 != ' ') goto L7;
    L20:
        return r1;
    L7:
        if (r1 == '%') goto L20;
        if (r1 == '\\') goto L20;
        if (r1 == '_') goto L20;
        if (r1 == '\"') goto L20;
        if (r1 == '#') goto L20;
        switch(r1) {
            case 42: goto L20;
            case 43: goto L20;
            case 44: goto L20;
            default: goto L17;
        };
    L17:
        switch(r1) {
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
        int r0 = getByte(this.pos);
        this.pos++;
        if (r0 >= 128) goto L7;
        return (char) r0;
    L7:
        if (r0 >= 192) goto L9;
    L31:
        return '?';
    L9:
        if (r0 > 247) goto L31;
        if (r0 > 223) goto L14;
        int r1 = r0 & 31;
        int r3 = 1;
    L17:
        int r5 = 0;
    L18:
        if (r5 >= r3) goto L30;
        int r6 = this.pos + 1;
        this.pos = r6;
        if (r6 == this.length) goto L28;
        if (this.chars[r6] != '\\') goto L28;
        int r7 = r6 + 1;
        this.pos = r7;
        int r8 = getByte(r7);
        this.pos++;
        if ((r8 & 192) != 128) goto L26;
        r1 = (r1 << 6) + (r8 & 63);
        r5 = r5 + 1;
        goto L18
    L26:
        return '?';
    L28:
        return '?';
    L30:
        return (char) r1;
    L14:
        if (r0 > 239) goto L16;
        r1 = r0 & 15;
        r3 = 2;
        goto L17
    L16:
        r1 = r0 & 7;
        r3 = 3;
        goto L17
    }

    private int getByte(int r10) {
        int r0 = r10 + 1;
        if (r0 >= this.length) goto L31;
        char[] r1 = this.chars;
        char r11 = r1[r10];
        if (r11 < '0') goto L8;
        if (r11 > '9') goto L8;
        int r12 = r11 - '0';
    L14:
        char r2 = r1[r0];
        if (r2 < '0') goto L18;
        if (r2 > '9') goto L18;
        int r3 = r2 - '0';
    L25:
        return (r12 << 4) + r3;
    L18:
        if (r2 < 'a') goto L21;
        if (r2 > 'f') goto L21;
        r3 = r2 - 'W';
    L21:
        if (r2 < 'A') goto L27;
        if (r2 > 'F') goto L27;
        r3 = r2 - '7';
    L27:
        throw new IllegalStateException("Malformed DN: " + this.dn);
    L8:
        if (r11 < 'a') goto L11;
        if (r11 > 'f') goto L11;
        r12 = r11 - 'W';
    L11:
        if (r11 < 'A') goto L29;
        if (r11 > 'F') goto L29;
        r12 = r11 - '7';
    L29:
        throw new IllegalStateException("Malformed DN: " + this.dn);
    L31:
        throw new IllegalStateException("Malformed DN: " + this.dn);
    }

    public String findMostSpecific(String r8) {
        this.pos = 0;
        this.beg = 0;
        this.end = 0;
        this.cur = 0;
        this.chars = this.dn.toCharArray();
        String r0 = nextAT();
        if (r0 != null) goto L5;
        return null;
    L5:
        int r2 = this.pos;
        if (r2 == this.length) goto L7;
        char r3 = this.chars[r2];
        if (r3 != '\"') goto L11;
        String r4 = quotedAV();
    L20:
        if (r8.equalsIgnoreCase(r0) == true) goto L21;
        int r1 = this.pos;
        if (r1 >= this.length) goto L24;
        char r5 = this.chars[r1];
        if (r5 == ',') goto L33;
        if (r5 == ';') goto L33;
        if (r5 == '+') goto L33;
        throw new IllegalStateException("Malformed DN: " + this.dn);
    L33:
        this.pos = r1 + 1;
        r0 = nextAT();
        if (r0 != null) goto L5;
        throw new IllegalStateException("Malformed DN: " + this.dn);
    L24:
        return null;
    L21:
        return r4;
    L11:
        if (r3 == '#') goto L17;
        if (r3 == '+') goto L16;
        if (r3 == ',') goto L16;
        if (r3 == ';') goto L16;
        r4 = escapedAV();
    L16:
        r4 = "";
        goto L20
    L17:
        r4 = hexAV();
        goto L20
    L7:
        return null;
    }
}
