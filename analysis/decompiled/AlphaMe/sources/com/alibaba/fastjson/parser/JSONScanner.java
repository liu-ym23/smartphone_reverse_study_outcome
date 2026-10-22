package com.alibaba.fastjson.parser;

import androidx.room.AbstractC0351g;
import ch.qos.logback.core.CoreConstants;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.util.ASMUtils;
import com.alibaba.fastjson.util.IOUtils;
import com.alibaba.fastjson.util.UTF8Decoder;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.TimeZone;

/* loaded from: classes.dex */
public final class JSONScanner extends JSONLexerBase {
    private final int len;
    private final String text;

    public JSONScanner(String str) {
        this(str, JSON.DEFAULT_PARSER_FEATURE);
    }

    public static boolean charArrayCompare(String str, int i4, char[] cArr) {
        int length = cArr.length;
        if (length + i4 > str.length()) {
            return false;
        }
        for (int i5 = 0; i5 < length; i5++) {
            if (cArr[i5] != str.charAt(i4 + i5)) {
                return false;
            }
        }
        return true;
    }

    public static boolean checkDate(char c4, char c5, char c6, char c7, char c8, char c9, int i4, int i5) {
        if (c4 >= '1' && c4 <= '3' && c5 >= '0' && c5 <= '9' && c6 >= '0' && c6 <= '9' && c7 >= '0' && c7 <= '9') {
            if (c8 == '0') {
                if (c9 < '1' || c9 > '9') {
                    return false;
                }
            } else if (c8 != '1' || (c9 != '0' && c9 != '1' && c9 != '2')) {
                return false;
            }
            if (i4 == 48) {
                return i5 >= 49 && i5 <= 57;
            }
            if (i4 != 49 && i4 != 50) {
                return i4 == 51 && (i5 == 48 || i5 == 49);
            }
            if (i5 >= 48 && i5 <= 57) {
                return true;
            }
        }
        return false;
    }

    private boolean checkTime(char c4, char c5, char c6, char c7, char c8, char c9) {
        if (c4 == '0') {
            if (c5 < '0' || c5 > '9') {
                return false;
            }
        } else {
            if (c4 != '1') {
                if (c4 == '2' && c5 >= '0' && c5 <= '4') {
                }
                return false;
            }
            if (c5 < '0' || c5 > '9') {
                return false;
            }
        }
        if (c6 < '0' || c6 > '5') {
            if (c6 != '6' || c7 != '0') {
                return false;
            }
        } else if (c7 < '0' || c7 > '9') {
            return false;
        }
        return (c8 < '0' || c8 > '5') ? c8 == '6' && c9 == '0' : c9 >= '0' && c9 <= '9';
    }

    private void setCalendar(char c4, char c5, char c6, char c7, char c8, char c9, char c10, char c11) {
        Calendar calendar = Calendar.getInstance(this.timeZone, this.locale);
        this.calendar = calendar;
        int i4 = c7 - '0';
        calendar.set(1, i4 + ((c6 - '0') * 10) + ((c5 - '0') * 100) + ((c4 - '0') * 1000));
        this.calendar.set(2, ((c9 - '0') + ((c8 - '0') * 10)) - 1);
        this.calendar.set(5, (c11 - '0') + ((c10 - '0') * 10));
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public final String addSymbol(int i4, int i5, int i6, SymbolTable symbolTable) {
        return symbolTable.addSymbol(this.text, i4, i5, i6);
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public final void arrayCopy(int i4, char[] cArr, int i5, int i6) {
        this.text.getChars(i4, i6 + i4, cArr, i5);
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase, com.alibaba.fastjson.parser.JSONLexer
    public byte[] bytesValue() {
        if (this.token != 26) {
            return IOUtils.decodeBase64(this.text, this.np + 1, this.sp);
        }
        int i4 = this.np + 1;
        int i5 = this.sp;
        if (i5 % 2 != 0) {
            throw new JSONException(AbstractC0351g.m("illegal state. ", i5));
        }
        int i6 = i5 / 2;
        byte[] bArr = new byte[i6];
        for (int i7 = 0; i7 < i6; i7++) {
            int i8 = (i7 * 2) + i4;
            char cCharAt = this.text.charAt(i8);
            char cCharAt2 = this.text.charAt(i8 + 1);
            char c4 = '7';
            int i9 = cCharAt - (cCharAt <= '9' ? '0' : '7');
            if (cCharAt2 <= '9') {
                c4 = '0';
            }
            bArr[i7] = (byte) ((i9 << 4) | (cCharAt2 - c4));
        }
        return bArr;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public final char charAt(int i4) {
        return i4 >= this.len ? JSONLexer.EOI : this.text.charAt(i4);
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public final void copyTo(int i4, int i5, char[] cArr) {
        this.text.getChars(i4, i5 + i4, cArr, 0);
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase, com.alibaba.fastjson.parser.JSONLexer
    public final BigDecimal decimalValue() {
        char cCharAt = charAt((this.np + this.sp) - 1);
        int i4 = this.sp;
        if (cCharAt == 'L' || cCharAt == 'S' || cCharAt == 'B' || cCharAt == 'F' || cCharAt == 'D') {
            i4--;
        }
        int i5 = this.np;
        char[] cArr = this.sbuf;
        if (i4 < cArr.length) {
            this.text.getChars(i5, i5 + i4, cArr, 0);
            return new BigDecimal(this.sbuf, 0, i4);
        }
        char[] cArr2 = new char[i4];
        this.text.getChars(i5, i4 + i5, cArr2, 0);
        return new BigDecimal(cArr2);
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public final int indexOf(char c4, int i4) {
        return this.text.indexOf(c4, i4);
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase, com.alibaba.fastjson.parser.JSONLexer
    public String info() {
        StringBuilder sb = new StringBuilder("pos ");
        sb.append(this.bp);
        sb.append(", json : ");
        int length = this.text.length();
        String strSubstring = this.text;
        if (length >= 65536) {
            strSubstring = strSubstring.substring(0, UTF8Decoder.Surrogate.UCS4_MIN);
        }
        sb.append(strSubstring);
        return sb.toString();
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public boolean isEOF() {
        int i4 = this.bp;
        int i5 = this.len;
        if (i4 != i5) {
            return this.f4610ch == 26 && i4 + 1 == i5;
        }
        return true;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public boolean matchField2(char[] cArr) {
        while (JSONLexerBase.isWhitespace(this.f4610ch)) {
            next();
        }
        if (!charArrayCompare(cArr)) {
            this.matchStat = -2;
            return false;
        }
        int length = this.bp + cArr.length;
        int i4 = length + 1;
        char cCharAt = this.text.charAt(length);
        while (JSONLexerBase.isWhitespace(cCharAt)) {
            cCharAt = this.text.charAt(i4);
            i4++;
        }
        if (cCharAt != ':') {
            this.matchStat = -2;
            return false;
        }
        this.bp = i4;
        this.f4610ch = charAt(i4);
        return true;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public Collection<String> newCollectionByType(Class<?> cls) {
        if (cls.isAssignableFrom(HashSet.class)) {
            return new HashSet();
        }
        if (cls.isAssignableFrom(ArrayList.class)) {
            return new ArrayList();
        }
        try {
            return (Collection) cls.newInstance();
        } catch (Exception e4) {
            throw new JSONException(e4.getMessage(), e4);
        }
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase, com.alibaba.fastjson.parser.JSONLexer
    public final char next() {
        int i4 = this.bp + 1;
        this.bp = i4;
        char cCharAt = i4 >= this.len ? JSONLexer.EOI : this.text.charAt(i4);
        this.f4610ch = cCharAt;
        return cCharAt;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase, com.alibaba.fastjson.parser.JSONLexer
    public final String numberString() {
        char cCharAt = charAt((this.np + this.sp) - 1);
        int i4 = this.sp;
        if (cCharAt == 'L' || cCharAt == 'S' || cCharAt == 'B' || cCharAt == 'F' || cCharAt == 'D') {
            i4--;
        }
        return subString(this.np, i4);
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public Date scanDate(char c4) {
        char cCharAt;
        long j4;
        Date date;
        char cCharAt2;
        boolean z4 = false;
        this.matchStat = 0;
        int i4 = this.bp;
        char c5 = this.f4610ch;
        int i5 = i4 + 1;
        char cCharAt3 = charAt(i4);
        if (cCharAt3 == '\"') {
            int iIndexOf = indexOf('\"', i5);
            if (iIndexOf == -1) {
                throw new JSONException("unclosed str");
            }
            this.bp = i5;
            if (!scanISO8601DateIfMatch(false, iIndexOf - i5)) {
                this.bp = i4;
                this.f4610ch = c5;
                this.matchStat = -1;
                return null;
            }
            date = this.calendar.getTime();
            cCharAt = charAt(iIndexOf + 1);
            this.bp = i4;
            while (cCharAt != ',' && cCharAt != ']') {
                if (!JSONLexerBase.isWhitespace(cCharAt)) {
                    this.bp = i4;
                    this.f4610ch = c5;
                    this.matchStat = -1;
                    return null;
                }
                int i6 = iIndexOf + 1;
                char cCharAt4 = charAt(iIndexOf + 2);
                iIndexOf = i6;
                cCharAt = cCharAt4;
            }
            this.bp = iIndexOf + 1;
            this.f4610ch = cCharAt;
        } else {
            char c6 = '9';
            char c7 = '0';
            if (cCharAt3 != '-' && (cCharAt3 < '0' || cCharAt3 > '9')) {
                if (cCharAt3 == 'n') {
                    int i7 = i4 + 2;
                    if (charAt(i5) == 'u') {
                        int i8 = i4 + 3;
                        if (charAt(i7) == 'l') {
                            int i9 = i4 + 4;
                            if (charAt(i8) == 'l') {
                                cCharAt = charAt(i9);
                                this.bp = i9;
                                date = null;
                            }
                        }
                    }
                }
                this.bp = i4;
                this.f4610ch = c5;
                this.matchStat = -1;
                return null;
            }
            if (cCharAt3 == '-') {
                cCharAt3 = charAt(i5);
                i5 = i4 + 2;
                z4 = true;
            }
            if (cCharAt3 < '0' || cCharAt3 > '9') {
                cCharAt = cCharAt3;
                j4 = 0;
            } else {
                j4 = cCharAt3 - '0';
                while (true) {
                    int i10 = i5 + 1;
                    cCharAt2 = charAt(i5);
                    if (cCharAt2 < c7 || cCharAt2 > c6) {
                        break;
                    }
                    j4 = (j4 * 10) + (cCharAt2 - '0');
                    i5 = i10;
                    c6 = '9';
                    c7 = '0';
                }
                if (cCharAt2 == ',' || cCharAt2 == ']') {
                    this.bp = i5;
                }
                cCharAt = cCharAt2;
            }
            if (j4 < 0) {
                this.bp = i4;
                this.f4610ch = c5;
                this.matchStat = -1;
                return null;
            }
            if (z4) {
                j4 = -j4;
            }
            date = new Date(j4);
        }
        if (cCharAt == ',') {
            int i11 = this.bp + 1;
            this.bp = i11;
            this.f4610ch = charAt(i11);
            this.matchStat = 3;
            return date;
        }
        int i12 = this.bp + 1;
        this.bp = i12;
        char cCharAt5 = charAt(i12);
        if (cCharAt5 == ',') {
            this.token = 16;
            int i13 = this.bp + 1;
            this.bp = i13;
            this.f4610ch = charAt(i13);
        } else if (cCharAt5 == ']') {
            this.token = 15;
            int i14 = this.bp + 1;
            this.bp = i14;
            this.f4610ch = charAt(i14);
        } else if (cCharAt5 == '}') {
            this.token = 13;
            int i15 = this.bp + 1;
            this.bp = i15;
            this.f4610ch = charAt(i15);
        } else {
            if (cCharAt5 != 26) {
                this.bp = i4;
                this.f4610ch = c5;
                this.matchStat = -1;
                return null;
            }
            this.f4610ch = JSONLexer.EOI;
            this.token = 20;
        }
        this.matchStat = 4;
        return date;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase, com.alibaba.fastjson.parser.JSONLexer
    public double scanDouble(char c4) throws NumberFormatException {
        int i4;
        char cCharAt;
        long j4;
        int i5;
        int i6;
        double d4;
        char cCharAt2;
        this.matchStat = 0;
        int i7 = this.bp;
        int i8 = i7 + 1;
        char cCharAt3 = charAt(i7);
        boolean z4 = cCharAt3 == '\"';
        if (z4) {
            cCharAt3 = charAt(i8);
            i8 = i7 + 2;
        }
        boolean z5 = cCharAt3 == '-';
        if (z5) {
            cCharAt3 = charAt(i8);
            i8++;
        }
        if (cCharAt3 >= '0') {
            char c5 = '9';
            if (cCharAt3 <= '9') {
                long j5 = cCharAt3 - '0';
                while (true) {
                    i4 = i8 + 1;
                    cCharAt = charAt(i8);
                    if (cCharAt < '0' || cCharAt > '9') {
                        break;
                    }
                    j5 = (j5 * 10) + (cCharAt - '0');
                    i8 = i4;
                }
                if (cCharAt == '.') {
                    int i9 = i8 + 2;
                    char cCharAt4 = charAt(i4);
                    if (cCharAt4 < '0' || cCharAt4 > '9') {
                        this.matchStat = -1;
                        return 0.0d;
                    }
                    j5 = (j5 * 10) + (cCharAt4 - '0');
                    long j6 = 10;
                    while (true) {
                        i4 = i9 + 1;
                        cCharAt2 = charAt(i9);
                        if (cCharAt2 < '0' || cCharAt2 > c5) {
                            break;
                        }
                        j5 = (j5 * 10) + (cCharAt2 - '0');
                        j6 *= 10;
                        i9 = i4;
                        c5 = '9';
                    }
                    long j7 = j6;
                    cCharAt = cCharAt2;
                    j4 = j7;
                } else {
                    j4 = 1;
                }
                boolean z6 = cCharAt == 'e' || cCharAt == 'E';
                if (z6) {
                    int i10 = i4 + 1;
                    char cCharAt5 = charAt(i4);
                    if (cCharAt5 == '+' || cCharAt5 == '-') {
                        i4 += 2;
                        cCharAt = charAt(i10);
                    } else {
                        i4 = i10;
                        cCharAt = cCharAt5;
                    }
                    while (cCharAt >= '0' && cCharAt <= '9') {
                        int i11 = i4 + 1;
                        char cCharAt6 = charAt(i4);
                        i4 = i11;
                        cCharAt = cCharAt6;
                    }
                }
                if (!z4) {
                    i5 = this.bp;
                    i6 = (i4 - i5) - 1;
                } else {
                    if (cCharAt != '\"') {
                        this.matchStat = -1;
                        return 0.0d;
                    }
                    int i12 = i4 + 1;
                    char cCharAt7 = charAt(i4);
                    i5 = this.bp + 1;
                    i6 = (i12 - i5) - 2;
                    i4 = i12;
                    cCharAt = cCharAt7;
                }
                if (z6 || i6 >= 20) {
                    d4 = Double.parseDouble(subString(i5, i6));
                } else {
                    d4 = j5 / j4;
                    if (z5) {
                        d4 = -d4;
                    }
                }
                if (cCharAt != c4) {
                    this.matchStat = -1;
                    return d4;
                }
                this.bp = i4;
                this.f4610ch = charAt(i4);
                this.matchStat = 3;
                this.token = 16;
                return d4;
            }
        }
        if (cCharAt3 == 'n') {
            int i13 = i8 + 1;
            if (charAt(i8) == 'u') {
                int i14 = i8 + 2;
                if (charAt(i13) == 'l') {
                    int i15 = i8 + 3;
                    if (charAt(i14) == 'l') {
                        this.matchStat = 5;
                        int i16 = i8 + 4;
                        char cCharAt8 = charAt(i15);
                        if (z4 && cCharAt8 == '\"') {
                            cCharAt8 = charAt(i16);
                            i16 = i8 + 5;
                        }
                        while (cCharAt8 != ',') {
                            if (cCharAt8 == ']') {
                                this.bp = i16;
                                this.f4610ch = charAt(i16);
                                this.matchStat = 5;
                                this.token = 15;
                                return 0.0d;
                            }
                            if (!JSONLexerBase.isWhitespace(cCharAt8)) {
                                this.matchStat = -1;
                                return 0.0d;
                            }
                            char cCharAt9 = charAt(i16);
                            i16++;
                            cCharAt8 = cCharAt9;
                        }
                        this.bp = i16;
                        this.f4610ch = charAt(i16);
                        this.matchStat = 5;
                        this.token = 16;
                        return 0.0d;
                    }
                }
            }
        }
        this.matchStat = -1;
        return 0.0d;
    }

    /* JADX WARN: Removed duplicated region for block: B:110:0x00f3 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0104  */
    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean scanFieldBoolean(char[] r12) {
        /*
            Method dump skipped, instructions count: 385
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.JSONScanner.scanFieldBoolean(char[]):boolean");
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public Date scanFieldDate(char[] cArr) {
        long j4;
        Date date;
        char cCharAt;
        char cCharAt2;
        boolean z4 = false;
        this.matchStat = 0;
        int i4 = this.bp;
        char c4 = this.f4610ch;
        if (!charArrayCompare(this.text, i4, cArr)) {
            this.matchStat = -2;
            return null;
        }
        int length = this.bp + cArr.length;
        int i5 = length + 1;
        char cCharAt3 = charAt(length);
        if (cCharAt3 == '\"') {
            int iIndexOf = indexOf('\"', i5);
            if (iIndexOf == -1) {
                throw new JSONException("unclosed str");
            }
            this.bp = i5;
            if (!scanISO8601DateIfMatch(false, iIndexOf - i5)) {
                this.bp = i4;
                this.matchStat = -1;
                return null;
            }
            date = this.calendar.getTime();
            cCharAt = charAt(iIndexOf + 1);
            this.bp = i4;
            while (cCharAt != ',' && cCharAt != '}') {
                if (!JSONLexerBase.isWhitespace(cCharAt)) {
                    this.matchStat = -1;
                    return null;
                }
                int i6 = iIndexOf + 1;
                char cCharAt4 = charAt(iIndexOf + 2);
                iIndexOf = i6;
                cCharAt = cCharAt4;
            }
            this.bp = iIndexOf + 1;
            this.f4610ch = cCharAt;
        } else {
            char c5 = '9';
            char c6 = '0';
            if (cCharAt3 != '-' && (cCharAt3 < '0' || cCharAt3 > '9')) {
                this.matchStat = -1;
                return null;
            }
            if (cCharAt3 == '-') {
                cCharAt3 = charAt(i5);
                i5 = length + 2;
                z4 = true;
            }
            if (cCharAt3 < '0' || cCharAt3 > '9') {
                j4 = 0;
            } else {
                long j5 = cCharAt3 - '0';
                while (true) {
                    int i7 = i5 + 1;
                    cCharAt2 = charAt(i5);
                    if (cCharAt2 < c6 || cCharAt2 > c5) {
                        break;
                    }
                    j5 = (j5 * 10) + (cCharAt2 - '0');
                    i5 = i7;
                    c5 = '9';
                    c6 = '0';
                }
                if (cCharAt2 == ',' || cCharAt2 == '}') {
                    this.bp = i5;
                }
                long j6 = j5;
                cCharAt3 = cCharAt2;
                j4 = j6;
            }
            if (j4 < 0) {
                this.matchStat = -1;
                return null;
            }
            if (z4) {
                j4 = -j4;
            }
            date = new Date(j4);
            cCharAt = cCharAt3;
        }
        if (cCharAt == ',') {
            int i8 = this.bp + 1;
            this.bp = i8;
            this.f4610ch = charAt(i8);
            this.matchStat = 3;
            return date;
        }
        int i9 = this.bp + 1;
        this.bp = i9;
        char cCharAt5 = charAt(i9);
        if (cCharAt5 == ',') {
            this.token = 16;
            int i10 = this.bp + 1;
            this.bp = i10;
            this.f4610ch = charAt(i10);
        } else if (cCharAt5 == ']') {
            this.token = 15;
            int i11 = this.bp + 1;
            this.bp = i11;
            this.f4610ch = charAt(i11);
        } else if (cCharAt5 == '}') {
            this.token = 13;
            int i12 = this.bp + 1;
            this.bp = i12;
            this.f4610ch = charAt(i12);
        } else {
            if (cCharAt5 != 26) {
                this.bp = i4;
                this.f4610ch = c4;
                this.matchStat = -1;
                return null;
            }
            this.token = 20;
        }
        this.matchStat = 4;
        return date;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public int scanFieldInt(char[] cArr) {
        int i4;
        char cCharAt;
        this.matchStat = 0;
        int i5 = this.bp;
        char c4 = this.f4610ch;
        if (!charArrayCompare(this.text, i5, cArr)) {
            this.matchStat = -2;
            return 0;
        }
        int length = this.bp + cArr.length;
        int i6 = length + 1;
        char cCharAt2 = charAt(length);
        boolean z4 = cCharAt2 == '\"';
        if (z4) {
            cCharAt2 = charAt(i6);
            i6 = length + 2;
        }
        boolean z5 = cCharAt2 == '-';
        if (z5) {
            cCharAt2 = charAt(i6);
            i6++;
        }
        if (cCharAt2 < '0' || cCharAt2 > '9') {
            this.matchStat = -1;
            return 0;
        }
        int i7 = cCharAt2 - '0';
        while (true) {
            i4 = i6 + 1;
            cCharAt = charAt(i6);
            if (cCharAt < '0' || cCharAt > '9') {
                break;
            }
            i7 = (i7 * 10) + (cCharAt - '0');
            i6 = i4;
        }
        if (cCharAt == '.') {
            this.matchStat = -1;
            return 0;
        }
        if (i7 < 0) {
            this.matchStat = -1;
            return 0;
        }
        if (z4) {
            if (cCharAt != '\"') {
                this.matchStat = -1;
                return 0;
            }
            int i8 = i6 + 2;
            cCharAt = charAt(i4);
            i4 = i8;
        }
        while (cCharAt != ',' && cCharAt != '}') {
            if (!JSONLexerBase.isWhitespace(cCharAt)) {
                this.matchStat = -1;
                return 0;
            }
            int i9 = i4 + 1;
            cCharAt = charAt(i4);
            i4 = i9;
        }
        this.bp = i4 - 1;
        if (cCharAt == ',') {
            this.bp = i4;
            this.f4610ch = charAt(i4);
            this.matchStat = 3;
            this.token = 16;
            return z5 ? -i7 : i7;
        }
        if (cCharAt == '}') {
            this.bp = i4;
            char cCharAt3 = charAt(i4);
            while (true) {
                if (cCharAt3 == ',') {
                    this.token = 16;
                    int i10 = this.bp + 1;
                    this.bp = i10;
                    this.f4610ch = charAt(i10);
                    break;
                }
                if (cCharAt3 == ']') {
                    this.token = 15;
                    int i11 = this.bp + 1;
                    this.bp = i11;
                    this.f4610ch = charAt(i11);
                    break;
                }
                if (cCharAt3 == '}') {
                    this.token = 13;
                    int i12 = this.bp + 1;
                    this.bp = i12;
                    this.f4610ch = charAt(i12);
                    break;
                }
                if (cCharAt3 == 26) {
                    this.token = 20;
                    break;
                }
                if (!JSONLexerBase.isWhitespace(cCharAt3)) {
                    this.bp = i5;
                    this.f4610ch = c4;
                    this.matchStat = -1;
                    return 0;
                }
                int i13 = this.bp + 1;
                this.bp = i13;
                cCharAt3 = charAt(i13);
            }
            this.matchStat = 4;
        }
        return z5 ? -i7 : i7;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public long scanFieldLong(char[] cArr) {
        int i4;
        char cCharAt;
        boolean z4 = false;
        this.matchStat = 0;
        int i5 = this.bp;
        char c4 = this.f4610ch;
        if (!charArrayCompare(this.text, i5, cArr)) {
            this.matchStat = -2;
            return 0L;
        }
        int length = this.bp + cArr.length;
        int i6 = length + 1;
        char cCharAt2 = charAt(length);
        boolean z5 = cCharAt2 == '\"';
        if (z5) {
            cCharAt2 = charAt(i6);
            i6 = length + 2;
        }
        if (cCharAt2 == '-') {
            cCharAt2 = charAt(i6);
            i6++;
            z4 = true;
        }
        if (cCharAt2 < '0' || cCharAt2 > '9') {
            this.bp = i5;
            this.f4610ch = c4;
            this.matchStat = -1;
            return 0L;
        }
        long j4 = cCharAt2 - '0';
        while (true) {
            i4 = i6 + 1;
            cCharAt = charAt(i6);
            if (cCharAt < '0' || cCharAt > '9') {
                break;
            }
            j4 = (j4 * 10) + (cCharAt - '0');
            i6 = i4;
        }
        if (cCharAt == '.') {
            this.matchStat = -1;
            return 0L;
        }
        if (z5) {
            if (cCharAt != '\"') {
                this.matchStat = -1;
                return 0L;
            }
            cCharAt = charAt(i4);
            i4 = i6 + 2;
        }
        if (cCharAt == ',' || cCharAt == '}') {
            this.bp = i4 - 1;
        }
        if (j4 < 0 && (j4 != Long.MIN_VALUE || !z4)) {
            this.bp = i5;
            this.f4610ch = c4;
            this.matchStat = -1;
            return 0L;
        }
        while (cCharAt != ',') {
            if (cCharAt == '}') {
                int i7 = 1;
                int i8 = this.bp + 1;
                this.bp = i8;
                char cCharAt3 = charAt(i8);
                while (true) {
                    if (cCharAt3 == ',') {
                        this.token = 16;
                        int i9 = this.bp + i7;
                        this.bp = i9;
                        this.f4610ch = charAt(i9);
                        break;
                    }
                    if (cCharAt3 == ']') {
                        this.token = 15;
                        int i10 = this.bp + i7;
                        this.bp = i10;
                        this.f4610ch = charAt(i10);
                        break;
                    }
                    if (cCharAt3 == '}') {
                        this.token = 13;
                        int i11 = this.bp + i7;
                        this.bp = i11;
                        this.f4610ch = charAt(i11);
                        break;
                    }
                    if (cCharAt3 == 26) {
                        this.token = 20;
                        break;
                    }
                    if (!JSONLexerBase.isWhitespace(cCharAt3)) {
                        this.bp = i5;
                        this.f4610ch = c4;
                        this.matchStat = -1;
                        return 0L;
                    }
                    int i12 = this.bp + 1;
                    this.bp = i12;
                    cCharAt3 = charAt(i12);
                    i7 = 1;
                }
                this.matchStat = 4;
                return z4 ? -j4 : j4;
            }
            if (!JSONLexerBase.isWhitespace(cCharAt)) {
                this.matchStat = -1;
                return 0L;
            }
            this.bp = i4;
            cCharAt = charAt(i4);
            i4++;
        }
        int i13 = this.bp + 1;
        this.bp = i13;
        this.f4610ch = charAt(i13);
        this.matchStat = 3;
        this.token = 16;
        return z4 ? -j4 : j4;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public String scanFieldString(char[] cArr) {
        this.matchStat = 0;
        int i4 = this.bp;
        char c4 = this.f4610ch;
        while (!charArrayCompare(this.text, this.bp, cArr)) {
            if (!JSONLexerBase.isWhitespace(this.f4610ch)) {
                this.matchStat = -2;
                return stringDefaultValue();
            }
            next();
        }
        int length = this.bp + cArr.length;
        int i5 = length + 1;
        if (charAt(length) != '\"') {
            this.matchStat = -1;
            return stringDefaultValue();
        }
        int iIndexOf = indexOf('\"', i5);
        if (iIndexOf == -1) {
            throw new JSONException("unclosed str");
        }
        String strSubString = subString(i5, iIndexOf - i5);
        if (strSubString.indexOf(92) != -1) {
            while (true) {
                int i6 = 0;
                for (int i7 = iIndexOf - 1; i7 >= 0 && charAt(i7) == '\\'; i7--) {
                    i6++;
                }
                if (i6 % 2 == 0) {
                    break;
                }
                iIndexOf = indexOf('\"', iIndexOf + 1);
            }
            int i8 = this.bp;
            int length2 = iIndexOf - ((cArr.length + i8) + 1);
            strSubString = JSONLexerBase.readString(sub_chars(i8 + cArr.length + 1, length2), length2);
        }
        char cCharAt = charAt(iIndexOf + 1);
        while (cCharAt != ',' && cCharAt != '}') {
            if (!JSONLexerBase.isWhitespace(cCharAt)) {
                this.matchStat = -1;
                return stringDefaultValue();
            }
            char cCharAt2 = charAt(iIndexOf + 2);
            iIndexOf++;
            cCharAt = cCharAt2;
        }
        this.bp = iIndexOf + 1;
        this.f4610ch = cCharAt;
        if (cCharAt == ',') {
            int i9 = iIndexOf + 2;
            this.bp = i9;
            this.f4610ch = charAt(i9);
            this.matchStat = 3;
            return strSubString;
        }
        int i10 = iIndexOf + 2;
        this.bp = i10;
        char cCharAt3 = charAt(i10);
        if (cCharAt3 == ',') {
            this.token = 16;
            int i11 = this.bp + 1;
            this.bp = i11;
            this.f4610ch = charAt(i11);
        } else if (cCharAt3 == ']') {
            this.token = 15;
            int i12 = this.bp + 1;
            this.bp = i12;
            this.f4610ch = charAt(i12);
        } else if (cCharAt3 == '}') {
            this.token = 13;
            int i13 = this.bp + 1;
            this.bp = i13;
            this.f4610ch = charAt(i13);
        } else {
            if (cCharAt3 != 26) {
                this.bp = i4;
                this.f4610ch = c4;
                this.matchStat = -1;
                return stringDefaultValue();
            }
            this.token = 20;
        }
        this.matchStat = 4;
        return strSubString;
    }

    /* JADX WARN: Code restructure failed: missing block: B:41:0x00c1, code lost:
    
        if (r14 != ']') goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x00c7, code lost:
    
        if (r15.size() != 0) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00c9, code lost:
    
        r14 = r1 + 1;
        r1 = charAt(r1);
        r1 = r14;
        r14 = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x00d3, code lost:
    
        r13.matchStat = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x00d5, code lost:
    
        return null;
     */
    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.util.Collection<java.lang.String> scanFieldStringArray(char[] r14, java.lang.Class<?> r15) {
        /*
            Method dump skipped, instructions count: 354
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.JSONScanner.scanFieldStringArray(char[], java.lang.Class):java.util.Collection");
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public long scanFieldSymbol(char[] cArr) {
        this.matchStat = 0;
        if (!charArrayCompare(this.text, this.bp, cArr)) {
            this.matchStat = -2;
            return 0L;
        }
        int length = this.bp + cArr.length;
        int i4 = length + 1;
        if (charAt(length) != '\"') {
            this.matchStat = -1;
            return 0L;
        }
        long j4 = -3750763034362895579L;
        while (true) {
            int i5 = i4 + 1;
            char cCharAt = charAt(i4);
            if (cCharAt == '\"') {
                this.bp = i5;
                char cCharAt2 = charAt(i5);
                this.f4610ch = cCharAt2;
                while (cCharAt2 != ',') {
                    if (cCharAt2 == '}') {
                        next();
                        skipWhitespace();
                        char current = getCurrent();
                        if (current == ',') {
                            this.token = 16;
                            int i6 = this.bp + 1;
                            this.bp = i6;
                            this.f4610ch = charAt(i6);
                        } else if (current == ']') {
                            this.token = 15;
                            int i7 = this.bp + 1;
                            this.bp = i7;
                            this.f4610ch = charAt(i7);
                        } else if (current == '}') {
                            this.token = 13;
                            int i8 = this.bp + 1;
                            this.bp = i8;
                            this.f4610ch = charAt(i8);
                        } else {
                            if (current != 26) {
                                this.matchStat = -1;
                                return 0L;
                            }
                            this.token = 20;
                        }
                        this.matchStat = 4;
                        return j4;
                    }
                    if (!JSONLexerBase.isWhitespace(cCharAt2)) {
                        this.matchStat = -1;
                        return 0L;
                    }
                    int i9 = this.bp + 1;
                    this.bp = i9;
                    cCharAt2 = charAt(i9);
                }
                int i10 = this.bp + 1;
                this.bp = i10;
                this.f4610ch = charAt(i10);
                this.matchStat = 3;
                return j4;
            }
            if (i5 > this.len) {
                this.matchStat = -1;
                return 0L;
            }
            j4 = (j4 ^ cCharAt) * 1099511628211L;
            i4 = i5;
        }
    }

    public boolean scanISO8601DateIfMatch() {
        return scanISO8601DateIfMatch(true);
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase, com.alibaba.fastjson.parser.JSONLexer
    public final int scanInt(char c4) {
        int i4;
        char cCharAt;
        this.matchStat = 0;
        int i5 = this.bp;
        int i6 = i5 + 1;
        char cCharAt2 = charAt(i5);
        while (JSONLexerBase.isWhitespace(cCharAt2)) {
            int i7 = i6 + 1;
            char cCharAt3 = charAt(i6);
            i6 = i7;
            cCharAt2 = cCharAt3;
        }
        boolean z4 = cCharAt2 == '\"';
        if (z4) {
            int i8 = i6 + 1;
            char cCharAt4 = charAt(i6);
            i6 = i8;
            cCharAt2 = cCharAt4;
        }
        boolean z5 = cCharAt2 == '-';
        if (z5) {
            int i9 = i6 + 1;
            char cCharAt5 = charAt(i6);
            i6 = i9;
            cCharAt2 = cCharAt5;
        }
        if (cCharAt2 >= '0' && cCharAt2 <= '9') {
            int i10 = cCharAt2 - '0';
            while (true) {
                i4 = i6 + 1;
                cCharAt = charAt(i6);
                if (cCharAt < '0' || cCharAt > '9') {
                    break;
                }
                i10 = (i10 * 10) + (cCharAt - '0');
                i6 = i4;
            }
            if (cCharAt == '.') {
                this.matchStat = -1;
                return 0;
            }
            if (z4) {
                if (cCharAt != '\"') {
                    this.matchStat = -1;
                    return 0;
                }
                cCharAt = charAt(i4);
                i4 = i6 + 2;
            }
            if (i10 < 0) {
                this.matchStat = -1;
                return 0;
            }
            while (cCharAt != c4) {
                if (!JSONLexerBase.isWhitespace(cCharAt)) {
                    this.matchStat = -1;
                    return z5 ? -i10 : i10;
                }
                cCharAt = charAt(i4);
                i4++;
            }
            this.bp = i4;
            this.f4610ch = charAt(i4);
            this.matchStat = 3;
            this.token = 16;
            return z5 ? -i10 : i10;
        }
        if (cCharAt2 == 'n') {
            int i11 = i6 + 1;
            if (charAt(i6) == 'u') {
                int i12 = i6 + 2;
                if (charAt(i11) == 'l') {
                    int i13 = i6 + 3;
                    if (charAt(i12) == 'l') {
                        this.matchStat = 5;
                        int i14 = i6 + 4;
                        char cCharAt6 = charAt(i13);
                        if (z4 && cCharAt6 == '\"') {
                            cCharAt6 = charAt(i14);
                            i14 = i6 + 5;
                        }
                        while (cCharAt6 != ',') {
                            if (cCharAt6 == ']') {
                                this.bp = i14;
                                this.f4610ch = charAt(i14);
                                this.matchStat = 5;
                                this.token = 15;
                                return 0;
                            }
                            if (!JSONLexerBase.isWhitespace(cCharAt6)) {
                                this.matchStat = -1;
                                return 0;
                            }
                            char cCharAt7 = charAt(i14);
                            i14++;
                            cCharAt6 = cCharAt7;
                        }
                        this.bp = i14;
                        this.f4610ch = charAt(i14);
                        this.matchStat = 5;
                        this.token = 16;
                        return 0;
                    }
                }
            }
        }
        this.matchStat = -1;
        return 0;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase, com.alibaba.fastjson.parser.JSONLexer
    public long scanLong(char c4) {
        int i4;
        char cCharAt;
        this.matchStat = 0;
        int i5 = this.bp;
        int i6 = i5 + 1;
        char cCharAt2 = charAt(i5);
        boolean z4 = cCharAt2 == '\"';
        if (z4) {
            cCharAt2 = charAt(i6);
            i6 = i5 + 2;
        }
        boolean z5 = cCharAt2 == '-';
        if (z5) {
            cCharAt2 = charAt(i6);
            i6++;
        }
        if (cCharAt2 >= '0' && cCharAt2 <= '9') {
            long j4 = cCharAt2 - '0';
            while (true) {
                i4 = i6 + 1;
                cCharAt = charAt(i6);
                if (cCharAt < '0' || cCharAt > '9') {
                    break;
                }
                j4 = (j4 * 10) + (cCharAt - '0');
                i6 = i4;
            }
            if (cCharAt == '.') {
                this.matchStat = -1;
                return 0L;
            }
            if (z4) {
                if (cCharAt != '\"') {
                    this.matchStat = -1;
                    return 0L;
                }
                cCharAt = charAt(i4);
                i4 = i6 + 2;
            }
            if (j4 < 0 && (j4 != Long.MIN_VALUE || !z5)) {
                this.matchStat = -1;
                return 0L;
            }
            while (cCharAt != c4) {
                if (!JSONLexerBase.isWhitespace(cCharAt)) {
                    this.matchStat = -1;
                    return j4;
                }
                cCharAt = charAt(i4);
                i4++;
            }
            this.bp = i4;
            this.f4610ch = charAt(i4);
            this.matchStat = 3;
            this.token = 16;
            return z5 ? -j4 : j4;
        }
        if (cCharAt2 == 'n') {
            int i7 = i6 + 1;
            if (charAt(i6) == 'u') {
                int i8 = i6 + 2;
                if (charAt(i7) == 'l') {
                    int i9 = i6 + 3;
                    if (charAt(i8) == 'l') {
                        this.matchStat = 5;
                        int i10 = i6 + 4;
                        char cCharAt3 = charAt(i9);
                        if (z4 && cCharAt3 == '\"') {
                            cCharAt3 = charAt(i10);
                            i10 = i6 + 5;
                        }
                        while (cCharAt3 != ',') {
                            if (cCharAt3 == ']') {
                                this.bp = i10;
                                this.f4610ch = charAt(i10);
                                this.matchStat = 5;
                                this.token = 15;
                                return 0L;
                            }
                            if (!JSONLexerBase.isWhitespace(cCharAt3)) {
                                this.matchStat = -1;
                                return 0L;
                            }
                            char cCharAt4 = charAt(i10);
                            i10++;
                            cCharAt3 = cCharAt4;
                        }
                        this.bp = i10;
                        this.f4610ch = charAt(i10);
                        this.matchStat = 5;
                        this.token = 16;
                        return 0L;
                    }
                }
            }
        }
        this.matchStat = -1;
        return 0L;
    }

    public void setTime(char c4, char c5, char c6, char c7, char c8, char c9) {
        this.calendar.set(11, (c5 - '0') + ((c4 - '0') * 10));
        this.calendar.set(12, (c7 - '0') + ((c6 - '0') * 10));
        this.calendar.set(13, (c9 - '0') + ((c8 - '0') * 10));
    }

    public void setTimeZone(char c4, char c5, char c6) {
        int i4 = ((c6 - '0') + ((c5 - '0') * 10)) * CoreConstants.MILLIS_IN_ONE_HOUR;
        if (c4 == '-') {
            i4 = -i4;
        }
        if (this.calendar.getTimeZone().getRawOffset() != i4) {
            String[] availableIDs = TimeZone.getAvailableIDs(i4);
            if (availableIDs.length > 0) {
                this.calendar.setTimeZone(TimeZone.getTimeZone(availableIDs[0]));
            }
        }
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase, com.alibaba.fastjson.parser.JSONLexer
    public final String stringVal() {
        return !this.hasSpecial ? subString(this.np + 1, this.sp) : new String(this.sbuf, 0, this.sp);
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public final String subString(int i4, int i5) {
        if (!ASMUtils.IS_ANDROID) {
            return this.text.substring(i4, i5 + i4);
        }
        char[] cArr = this.sbuf;
        if (i5 < cArr.length) {
            this.text.getChars(i4, i4 + i5, cArr, 0);
            return new String(this.sbuf, 0, i5);
        }
        char[] cArr2 = new char[i5];
        this.text.getChars(i4, i5 + i4, cArr2, 0);
        return new String(cArr2);
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public final char[] sub_chars(int i4, int i5) {
        if (ASMUtils.IS_ANDROID) {
            char[] cArr = this.sbuf;
            if (i5 < cArr.length) {
                this.text.getChars(i4, i5 + i4, cArr, 0);
                return this.sbuf;
            }
        }
        char[] cArr2 = new char[i5];
        this.text.getChars(i4, i5 + i4, cArr2, 0);
        return cArr2;
    }

    public JSONScanner(String str, int i4) {
        super(i4);
        this.text = str;
        this.len = str.length();
        this.bp = -1;
        next();
        if (this.f4610ch == 65279) {
            next();
        }
    }

    public boolean scanISO8601DateIfMatch(boolean z4) {
        return scanISO8601DateIfMatch(z4, this.len - this.bp);
    }

    /* JADX WARN: Removed duplicated region for block: B:124:0x01fe A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:126:0x0200  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00f6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private boolean scanISO8601DateIfMatch(boolean r36, int r37) throws java.lang.NumberFormatException {
        /*
            Method dump skipped, instructions count: 1556
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.JSONScanner.scanISO8601DateIfMatch(boolean, int):boolean");
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public final boolean charArrayCompare(char[] cArr) {
        return charArrayCompare(this.text, this.bp, cArr);
    }

    public JSONScanner(char[] cArr, int i4) {
        this(cArr, i4, JSON.DEFAULT_PARSER_FEATURE);
    }

    public JSONScanner(char[] cArr, int i4, int i5) {
        this(new String(cArr, 0, i4), i5);
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public String[] scanFieldStringArray(char[] cArr, int i4, SymbolTable symbolTable) throws NumberFormatException {
        int i5;
        char cCharAt;
        int i6 = this.bp;
        char c4 = this.f4610ch;
        while (JSONLexerBase.isWhitespace(this.f4610ch)) {
            next();
        }
        if (cArr != null) {
            this.matchStat = 0;
            if (!charArrayCompare(cArr)) {
                this.matchStat = -2;
                return null;
            }
            int length = this.bp + cArr.length;
            int i7 = length + 1;
            char cCharAt2 = this.text.charAt(length);
            while (JSONLexerBase.isWhitespace(cCharAt2)) {
                cCharAt2 = this.text.charAt(i7);
                i7++;
            }
            if (cCharAt2 == ':') {
                i5 = i7 + 1;
                cCharAt = this.text.charAt(i7);
                while (JSONLexerBase.isWhitespace(cCharAt)) {
                    cCharAt = this.text.charAt(i5);
                    i5++;
                }
            } else {
                this.matchStat = -1;
                return null;
            }
        } else {
            i5 = this.bp + 1;
            cCharAt = this.f4610ch;
        }
        if (cCharAt == '[') {
            this.bp = i5;
            this.f4610ch = this.text.charAt(i5);
            String[] strArr = i4 >= 0 ? new String[i4] : new String[4];
            int i8 = 0;
            while (true) {
                if (JSONLexerBase.isWhitespace(this.f4610ch)) {
                    next();
                } else {
                    if (this.f4610ch != '\"') {
                        this.bp = i6;
                        this.f4610ch = c4;
                        this.matchStat = -1;
                        return null;
                    }
                    String strScanSymbol = scanSymbol(symbolTable, '\"');
                    if (i8 == strArr.length) {
                        String[] strArr2 = new String[strArr.length + (strArr.length >> 1) + 1];
                        System.arraycopy(strArr, 0, strArr2, 0, strArr.length);
                        strArr = strArr2;
                    }
                    int i9 = i8 + 1;
                    strArr[i8] = strScanSymbol;
                    while (JSONLexerBase.isWhitespace(this.f4610ch)) {
                        next();
                    }
                    if (this.f4610ch == ',') {
                        next();
                        i8 = i9;
                    } else {
                        if (strArr.length != i9) {
                            String[] strArr3 = new String[i9];
                            System.arraycopy(strArr, 0, strArr3, 0, i9);
                            strArr = strArr3;
                        }
                        while (JSONLexerBase.isWhitespace(this.f4610ch)) {
                            next();
                        }
                        if (this.f4610ch == ']') {
                            next();
                            return strArr;
                        }
                        this.bp = i6;
                        this.f4610ch = c4;
                        this.matchStat = -1;
                        return null;
                    }
                }
            }
        } else {
            if (cCharAt == 'n' && this.text.startsWith("ull", this.bp + 1)) {
                int i10 = this.bp + 4;
                this.bp = i10;
                this.f4610ch = this.text.charAt(i10);
                return null;
            }
            this.matchStat = -1;
            return null;
        }
    }
}
