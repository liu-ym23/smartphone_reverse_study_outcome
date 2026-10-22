package com.stepos.activeview.download;

import com.alibaba.fastjson.asm.Opcodes;
import com.baidu.entity.pb.PoiResult;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.security.auth.x500.X500Principal;

/* loaded from: classes.dex */
final class DownloadDistinguishedNameParser {
    private int beg;
    private char[] chars;
    private int cur;
    private final String dn;
    private int end;
    private final int length;
    private int pos;

    public DownloadDistinguishedNameParser(X500Principal x500Principal) {
        String name = x500Principal.getName("RFC2253");
        this.dn = name;
        this.length = name.length();
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0051, code lost:
    
        r2 = r8.beg;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x005b, code lost:
    
        return new java.lang.String(r1, r2, r8.end - r2);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private java.lang.String escapedAV() {
        /*
            r8 = this;
            int r0 = r8.pos
            r8.beg = r0
            r8.end = r0
        L6:
            int r0 = r8.pos
            int r1 = r8.length
            if (r0 < r1) goto L19
            java.lang.String r0 = new java.lang.String
            char[] r1 = r8.chars
            int r2 = r8.beg
            int r8 = r8.end
            int r8 = r8 - r2
            r0.<init>(r1, r2, r8)
            return r0
        L19:
            char[] r1 = r8.chars
            char r2 = r1[r0]
            r3 = 44
            r4 = 43
            r5 = 59
            r6 = 32
            if (r2 == r6) goto L5c
            if (r2 == r5) goto L51
            r5 = 92
            if (r2 == r5) goto L3e
            if (r2 == r4) goto L51
            if (r2 == r3) goto L51
            int r3 = r8.end
            int r4 = r3 + 1
            r8.end = r4
            r1[r3] = r2
            int r0 = r0 + 1
            r8.pos = r0
            goto L6
        L3e:
            int r0 = r8.end
            int r2 = r0 + 1
            r8.end = r2
            char r2 = r8.getEscaped()
            r1[r0] = r2
            int r0 = r8.pos
            int r0 = r0 + 1
            r8.pos = r0
            goto L6
        L51:
            java.lang.String r0 = new java.lang.String
            int r2 = r8.beg
            int r8 = r8.end
            int r8 = r8 - r2
            r0.<init>(r1, r2, r8)
            return r0
        L5c:
            int r2 = r8.end
            r8.cur = r2
            int r0 = r0 + 1
            r8.pos = r0
            int r0 = r2 + 1
            r8.end = r0
            r1[r2] = r6
        L6a:
            int r0 = r8.pos
            int r1 = r8.length
            if (r0 >= r1) goto L83
            char[] r2 = r8.chars
            char r7 = r2[r0]
            if (r7 != r6) goto L83
            int r1 = r8.end
            int r7 = r1 + 1
            r8.end = r7
            r2[r1] = r6
            int r0 = r0 + 1
            r8.pos = r0
            goto L6a
        L83:
            if (r0 == r1) goto L8f
            char[] r1 = r8.chars
            char r0 = r1[r0]
            if (r0 == r3) goto L8f
            if (r0 == r4) goto L8f
            if (r0 != r5) goto L6
        L8f:
            java.lang.String r0 = new java.lang.String
            char[] r1 = r8.chars
            int r2 = r8.beg
            int r8 = r8.cur
            int r8 = r8 - r2
            r0.<init>(r1, r2, r8)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.activeview.download.DownloadDistinguishedNameParser.escapedAV():java.lang.String");
    }

    private int getByte(int i4) {
        int i5;
        int i6;
        int i7 = i4 + 1;
        if (i7 >= this.length) {
            throw new IllegalStateException("Malformed DN: " + this.dn);
        }
        char[] cArr = this.chars;
        char c4 = cArr[i4];
        if (c4 >= '0' && c4 <= '9') {
            i5 = c4 - '0';
        } else if (c4 >= 'a' && c4 <= 'f') {
            i5 = c4 - 'W';
        } else {
            if (c4 < 'A' || c4 > 'F') {
                throw new IllegalStateException("Malformed DN: " + this.dn);
            }
            i5 = c4 - '7';
        }
        char c5 = cArr[i7];
        if (c5 >= '0' && c5 <= '9') {
            i6 = c5 - '0';
        } else if (c5 >= 'a' && c5 <= 'f') {
            i6 = c5 - 'W';
        } else {
            if (c5 < 'A' || c5 > 'F') {
                throw new IllegalStateException("Malformed DN: " + this.dn);
            }
            i6 = c5 - '7';
        }
        return (i5 << 4) + i6;
    }

    private char getEscaped() {
        int i4 = this.pos + 1;
        this.pos = i4;
        if (i4 == this.length) {
            throw new IllegalStateException("Unexpected end of DN: " + this.dn);
        }
        char c4 = this.chars[i4];
        if (c4 != ' ' && c4 != '%' && c4 != '\\' && c4 != '_' && c4 != '\"' && c4 != '#') {
            switch (c4) {
                default:
                    switch (c4) {
                        case PoiResult.Contents.CITY_FIELD_NUMBER /* 59 */:
                        case PoiResult.Contents.PROVINCE_FIELD_NUMBER /* 60 */:
                        case '=':
                        case '>':
                            break;
                        default:
                            return getUTF8();
                    }
                case '*':
                case '+':
                case ',':
                    return c4;
            }
        }
        return c4;
    }

    private char getUTF8() {
        int i4;
        int i5;
        int i6 = getByte(this.pos);
        this.pos++;
        if (i6 < 128) {
            return (char) i6;
        }
        if (i6 < 192 || i6 > 247) {
            return '?';
        }
        if (i6 <= 223) {
            i4 = i6 & 31;
            i5 = 1;
        } else if (i6 <= 239) {
            i4 = i6 & 15;
            i5 = 2;
        } else {
            i4 = i6 & 7;
            i5 = 3;
        }
        for (int i7 = 0; i7 < i5; i7++) {
            int i8 = this.pos;
            int i9 = i8 + 1;
            this.pos = i9;
            if (i9 == this.length || this.chars[i9] != '\\') {
                return '?';
            }
            int i10 = i8 + 2;
            this.pos = i10;
            int i11 = getByte(i10);
            this.pos++;
            if ((i11 & Opcodes.CHECKCAST) != 128) {
                return '?';
            }
            i4 = (i4 << 6) + (i11 & 63);
        }
        return (char) i4;
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x0054, code lost:
    
        r6.end = r0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private java.lang.String hexAV() {
        /*
            r6 = this;
            int r0 = r6.pos
            int r1 = r0 + 4
            int r2 = r6.length
            java.lang.String r3 = "Unexpected end of DN: "
            if (r1 >= r2) goto L95
            r6.beg = r0
            int r0 = r0 + 1
            r6.pos = r0
        L10:
            int r0 = r6.pos
            int r1 = r6.length
            if (r0 == r1) goto L54
            char[] r1 = r6.chars
            char r2 = r1[r0]
            r4 = 43
            if (r2 == r4) goto L54
            r4 = 44
            if (r2 == r4) goto L54
            r4 = 59
            if (r2 != r4) goto L27
            goto L54
        L27:
            r4 = 32
            if (r2 != r4) goto L42
            r6.end = r0
            int r0 = r0 + 1
            r6.pos = r0
        L31:
            int r0 = r6.pos
            int r1 = r6.length
            if (r0 >= r1) goto L56
            char[] r1 = r6.chars
            char r1 = r1[r0]
            if (r1 != r4) goto L56
            int r0 = r0 + 1
            r6.pos = r0
            goto L31
        L42:
            r4 = 65
            if (r2 < r4) goto L4f
            r4 = 70
            if (r2 > r4) goto L4f
            int r2 = r2 + 32
            char r2 = (char) r2
            r1[r0] = r2
        L4f:
            int r0 = r0 + 1
            r6.pos = r0
            goto L10
        L54:
            r6.end = r0
        L56:
            int r0 = r6.end
            int r1 = r6.beg
            int r0 = r0 - r1
            r2 = 5
            if (r0 < r2) goto L81
            r2 = r0 & 1
            if (r2 == 0) goto L81
            int r2 = r0 / 2
            byte[] r3 = new byte[r2]
            int r1 = r1 + 1
            r4 = 0
        L69:
            if (r4 >= r2) goto L77
            int r5 = r6.getByte(r1)
            byte r5 = (byte) r5
            r3[r4] = r5
            int r1 = r1 + 2
            int r4 = r4 + 1
            goto L69
        L77:
            java.lang.String r1 = new java.lang.String
            char[] r2 = r6.chars
            int r6 = r6.beg
            r1.<init>(r2, r6, r0)
            return r1
        L81:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>(r3)
            java.lang.String r6 = r6.dn
            r1.append(r6)
            java.lang.String r6 = r1.toString()
            r0.<init>(r6)
            throw r0
        L95:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>(r3)
            java.lang.String r6 = r6.dn
            r1.append(r6)
            java.lang.String r6 = r1.toString()
            r0.<init>(r6)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.activeview.download.DownloadDistinguishedNameParser.hexAV():java.lang.String");
    }

    private String nextAT() {
        int i4;
        int i5;
        int i6;
        int i7;
        char c4;
        int i8;
        int i9;
        char c5;
        char c6;
        while (true) {
            i4 = this.pos;
            i5 = this.length;
            if (i4 >= i5 || this.chars[i4] != ' ') {
                break;
            }
            this.pos = i4 + 1;
        }
        if (i4 == i5) {
            return null;
        }
        this.beg = i4;
        this.pos = i4 + 1;
        while (true) {
            i6 = this.pos;
            i7 = this.length;
            if (i6 >= i7 || (c6 = this.chars[i6]) == '=' || c6 == ' ') {
                break;
            }
            this.pos = i6 + 1;
        }
        if (i6 >= i7) {
            throw new IllegalStateException("Unexpected end of DN: " + this.dn);
        }
        this.end = i6;
        if (this.chars[i6] == ' ') {
            while (true) {
                i8 = this.pos;
                i9 = this.length;
                if (i8 >= i9 || (c5 = this.chars[i8]) == '=' || c5 != ' ') {
                    break;
                }
                this.pos = i8 + 1;
            }
            if (this.chars[i8] != '=' || i8 == i9) {
                throw new IllegalStateException("Unexpected end of DN: " + this.dn);
            }
        }
        this.pos++;
        while (true) {
            int i10 = this.pos;
            if (i10 >= this.length || this.chars[i10] != ' ') {
                break;
            }
            this.pos = i10 + 1;
        }
        int i11 = this.end;
        int i12 = this.beg;
        if (i11 - i12 > 4) {
            char[] cArr = this.chars;
            if (cArr[i12 + 3] == '.' && (((c4 = cArr[i12]) == 'O' || c4 == 'o') && ((cArr[i12 + 1] == 'I' || cArr[i12 + 1] == 'i') && (cArr[i12 + 2] == 'D' || cArr[i12 + 2] == 'd')))) {
                this.beg = i12 + 4;
            }
        }
        char[] cArr2 = this.chars;
        int i13 = this.beg;
        return new String(cArr2, i13, i11 - i13);
    }

    private String quotedAV() {
        int i4 = this.pos + 1;
        this.pos = i4;
        this.beg = i4;
        this.end = i4;
        while (true) {
            int i5 = this.pos;
            if (i5 == this.length) {
                throw new IllegalStateException("Unexpected end of DN: " + this.dn);
            }
            char[] cArr = this.chars;
            char c4 = cArr[i5];
            if (c4 == '\"') {
                this.pos = i5 + 1;
                while (true) {
                    int i6 = this.pos;
                    if (i6 >= this.length || this.chars[i6] != ' ') {
                        break;
                    }
                    this.pos = i6 + 1;
                }
                char[] cArr2 = this.chars;
                int i7 = this.beg;
                return new String(cArr2, i7, this.end - i7);
            }
            if (c4 == '\\') {
                cArr[this.end] = getEscaped();
            } else {
                cArr[this.end] = c4;
            }
            this.pos++;
            this.end++;
        }
    }

    public String findMostSpecific(String str) {
        this.pos = 0;
        this.beg = 0;
        this.end = 0;
        this.cur = 0;
        this.chars = this.dn.toCharArray();
        String strNextAT = nextAT();
        if (strNextAT == null) {
            return null;
        }
        do {
            int i4 = this.pos;
            if (i4 == this.length) {
                return null;
            }
            char c4 = this.chars[i4];
            String strEscapedAV = c4 != '\"' ? c4 != '#' ? (c4 == '+' || c4 == ',' || c4 == ';') ? "" : escapedAV() : hexAV() : quotedAV();
            if (str.equalsIgnoreCase(strNextAT)) {
                return strEscapedAV;
            }
            int i5 = this.pos;
            if (i5 >= this.length) {
                return null;
            }
            char c5 = this.chars[i5];
            if (c5 != ',' && c5 != ';' && c5 != '+') {
                throw new IllegalStateException("Malformed DN: " + this.dn);
            }
            this.pos = i5 + 1;
            strNextAT = nextAT();
        } while (strNextAT != null);
        throw new IllegalStateException("Malformed DN: " + this.dn);
    }

    public List<String> getAllMostSpecificFirst(String str) {
        this.pos = 0;
        this.beg = 0;
        this.end = 0;
        this.cur = 0;
        this.chars = this.dn.toCharArray();
        List<String> listEmptyList = Collections.emptyList();
        String strNextAT = nextAT();
        if (strNextAT == null) {
            return listEmptyList;
        }
        do {
            int i4 = this.pos;
            if (i4 < this.length) {
                char c4 = this.chars[i4];
                String strEscapedAV = c4 != '\"' ? c4 != '#' ? (c4 == '+' || c4 == ',' || c4 == ';') ? "" : escapedAV() : hexAV() : quotedAV();
                if (str.equalsIgnoreCase(strNextAT)) {
                    if (listEmptyList.isEmpty()) {
                        listEmptyList = new ArrayList<>();
                    }
                    listEmptyList.add(strEscapedAV);
                }
                int i5 = this.pos;
                if (i5 < this.length) {
                    char c5 = this.chars[i5];
                    if (c5 != ',' && c5 != ';' && c5 != '+') {
                        throw new IllegalStateException("Malformed DN: " + this.dn);
                    }
                    this.pos = i5 + 1;
                    strNextAT = nextAT();
                }
            }
            return listEmptyList;
        } while (strNextAT != null);
        throw new IllegalStateException("Malformed DN: " + this.dn);
    }
}
