package com.alibaba.fastjson.parser;

import B0.g;
import androidx.room.AbstractC0351g;
import ch.qos.logback.core.CoreConstants;
import ch.qos.logback.core.net.SyslogConstants;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.util.IOUtils;
import com.baidu.entity.pb.PoiResult;
import com.stepos.alphame.utils.Property;
import java.io.Closeable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Locale;
import java.util.TimeZone;
import java.util.UUID;

/* loaded from: classes.dex */
public abstract class JSONLexerBase implements JSONLexer, Closeable {
    protected static final int INT_MULTMIN_RADIX_TEN = -214748364;
    protected static final long MULTMIN_RADIX_TEN = -922337203685477580L;
    protected int bp;

    /* renamed from: ch, reason: collision with root package name */
    protected char f4610ch;
    protected int eofPos;
    protected int features;
    protected boolean hasSpecial;
    protected int np;
    protected int pos;
    protected char[] sbuf;
    protected int sp;
    protected String stringDefaultValue;
    protected int token;
    private static final ThreadLocal<char[]> SBUF_LOCAL = new ThreadLocal<>();
    protected static final char[] typeFieldName = ("\"" + JSON.DEFAULT_TYPE_KEY + "\":\"").toCharArray();
    protected static final int[] digits = new int[103];
    protected Calendar calendar = null;
    protected TimeZone timeZone = JSON.defaultTimeZone;
    protected Locale locale = JSON.defaultLocale;
    public int matchStat = 0;

    static {
        for (int i4 = 48; i4 <= 57; i4++) {
            digits[i4] = i4 - 48;
        }
        for (int i5 = 97; i5 <= 102; i5++) {
            digits[i5] = i5 - 87;
        }
        for (int i6 = 65; i6 <= 70; i6++) {
            digits[i6] = i6 - 55;
        }
    }

    public JSONLexerBase(int i4) {
        this.stringDefaultValue = null;
        this.features = i4;
        if ((i4 & Feature.InitStringFieldAsEmpty.mask) != 0) {
            this.stringDefaultValue = "";
        }
        char[] cArr = SBUF_LOCAL.get();
        this.sbuf = cArr;
        if (cArr == null) {
            this.sbuf = new char[512];
        }
    }

    public static boolean isWhitespace(char c4) {
        return c4 <= ' ' && (c4 == ' ' || c4 == '\n' || c4 == '\r' || c4 == '\t' || c4 == '\f' || c4 == '\b');
    }

    /* JADX WARN: Removed duplicated region for block: B:47:0x00f1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String readString(char[] r17, int r18) {
        /*
            Method dump skipped, instructions count: 318
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.JSONLexerBase.readString(char[], int):java.lang.String");
    }

    private void scanStringSingleQuote() {
        this.np = this.bp;
        this.hasSpecial = false;
        while (true) {
            char next = next();
            if (next == '\'') {
                this.token = 4;
                next();
                return;
            }
            if (next == 26) {
                if (isEOF()) {
                    throw new JSONException("unclosed single-quote string");
                }
                putChar(JSONLexer.EOI);
            } else if (next == '\\') {
                if (!this.hasSpecial) {
                    this.hasSpecial = true;
                    int i4 = this.sp;
                    char[] cArr = this.sbuf;
                    if (i4 > cArr.length) {
                        char[] cArr2 = new char[i4 * 2];
                        System.arraycopy(cArr, 0, cArr2, 0, cArr.length);
                        this.sbuf = cArr2;
                    }
                    copyTo(this.np + 1, this.sp, this.sbuf);
                }
                char next2 = next();
                if (next2 == '\"') {
                    putChar('\"');
                } else if (next2 != '\'') {
                    if (next2 != 'F') {
                        if (next2 == '\\') {
                            putChar(CoreConstants.ESCAPE_CHAR);
                        } else if (next2 == 'b') {
                            putChar('\b');
                        } else if (next2 != 'f') {
                            if (next2 == 'n') {
                                putChar('\n');
                            } else if (next2 == 'r') {
                                putChar('\r');
                            } else if (next2 != 'x') {
                                switch (next2) {
                                    case '/':
                                        putChar('/');
                                        break;
                                    case '0':
                                        putChar((char) 0);
                                        break;
                                    case '1':
                                        putChar((char) 1);
                                        break;
                                    case '2':
                                        putChar((char) 2);
                                        break;
                                    case '3':
                                        putChar((char) 3);
                                        break;
                                    case '4':
                                        putChar((char) 4);
                                        break;
                                    case '5':
                                        putChar((char) 5);
                                        break;
                                    case '6':
                                        putChar((char) 6);
                                        break;
                                    case '7':
                                        putChar((char) 7);
                                        break;
                                    default:
                                        switch (next2) {
                                            case 't':
                                                putChar('\t');
                                                break;
                                            case 'u':
                                                putChar((char) Integer.parseInt(new String(new char[]{next(), next(), next(), next()}), 16));
                                                break;
                                            case 'v':
                                                putChar((char) 11);
                                                break;
                                            default:
                                                this.f4610ch = next2;
                                                throw new JSONException("unclosed single-quote string");
                                        }
                                }
                            } else {
                                int[] iArr = digits;
                                putChar((char) ((iArr[next()] * 16) + iArr[next()]));
                            }
                        }
                    }
                    putChar('\f');
                } else {
                    putChar('\'');
                }
            } else if (this.hasSpecial) {
                int i5 = this.sp;
                char[] cArr3 = this.sbuf;
                if (i5 == cArr3.length) {
                    putChar(next);
                } else {
                    this.sp = i5 + 1;
                    cArr3[i5] = next;
                }
            } else {
                this.sp++;
            }
        }
    }

    public abstract String addSymbol(int i4, int i5, int i6, SymbolTable symbolTable);

    public abstract void arrayCopy(int i4, char[] cArr, int i5, int i6);

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public abstract byte[] bytesValue();

    public abstract boolean charArrayCompare(char[] cArr);

    public abstract char charAt(int i4);

    @Override // com.alibaba.fastjson.parser.JSONLexer, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        char[] cArr = this.sbuf;
        if (cArr.length <= 8192) {
            SBUF_LOCAL.set(cArr);
        }
        this.sbuf = null;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public void config(Feature feature, boolean z4) {
        int iConfig = Feature.config(this.features, feature, z4);
        this.features = iConfig;
        if ((iConfig & Feature.InitStringFieldAsEmpty.mask) != 0) {
            this.stringDefaultValue = "";
        }
    }

    public abstract void copyTo(int i4, int i5, char[] cArr);

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public final Number decimalValue(boolean z4) {
        char cCharAt = charAt((this.np + this.sp) - 1);
        try {
            return cCharAt == 'F' ? Float.valueOf(Float.parseFloat(numberString())) : cCharAt == 'D' ? Double.valueOf(Double.parseDouble(numberString())) : z4 ? decimalValue() : Double.valueOf(doubleValue());
        } catch (NumberFormatException e4) {
            throw new JSONException(e4.getMessage() + ", " + info());
        }
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public abstract BigDecimal decimalValue();

    public double doubleValue() {
        return Double.parseDouble(numberString());
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public float floatValue() throws NumberFormatException {
        char cCharAt;
        String strNumberString = numberString();
        float f4 = Float.parseFloat(strNumberString);
        if ((f4 == Property.DEFAULT_FLOAT_VALUE || f4 == Float.POSITIVE_INFINITY) && (cCharAt = strNumberString.charAt(0)) > '0' && cCharAt <= '9') {
            throw new JSONException("float overflow : ".concat(strNumberString));
        }
        return f4;
    }

    public Calendar getCalendar() {
        return this.calendar;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public final char getCurrent() {
        return this.f4610ch;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public Locale getLocale() {
        return this.locale;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public TimeZone getTimeZone() {
        return this.timeZone;
    }

    public abstract int indexOf(char c4, int i4);

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public String info() {
        return "";
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public final int intValue() {
        int i4;
        boolean z4;
        int i5 = 0;
        if (this.np == -1) {
            this.np = 0;
        }
        int i6 = this.np;
        int i7 = this.sp + i6;
        if (charAt(i6) == '-') {
            i6++;
            i4 = Integer.MIN_VALUE;
            z4 = true;
        } else {
            i4 = -2147483647;
            z4 = false;
        }
        if (i6 < i7) {
            i5 = -(charAt(i6) - '0');
            i6++;
        }
        while (i6 < i7) {
            int i8 = i6 + 1;
            char cCharAt = charAt(i6);
            if (cCharAt == 'L' || cCharAt == 'S' || cCharAt == 'B') {
                i6 = i8;
                break;
            }
            int i9 = cCharAt - '0';
            if (i5 < -214748364) {
                throw new NumberFormatException(numberString());
            }
            int i10 = i5 * 10;
            if (i10 < i4 + i9) {
                throw new NumberFormatException(numberString());
            }
            i5 = i10 - i9;
            i6 = i8;
        }
        if (!z4) {
            return -i5;
        }
        if (i6 > this.np + 1) {
            return i5;
        }
        throw new NumberFormatException(numberString());
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0088  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:30:0x0086 -> B:19:0x0051). Please report as a decompilation issue!!! */
    @Override // com.alibaba.fastjson.parser.JSONLexer
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Number integerValue() throws java.lang.NumberFormatException {
        /*
            Method dump skipped, instructions count: 230
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.JSONLexerBase.integerValue():java.lang.Number");
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public boolean isBlankInput() {
        int i4 = 0;
        while (true) {
            char cCharAt = charAt(i4);
            if (cCharAt == 26) {
                this.token = 20;
                return true;
            }
            if (!isWhitespace(cCharAt)) {
                return false;
            }
            i4++;
        }
    }

    public abstract boolean isEOF();

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public final boolean isEnabled(Feature feature) {
        return isEnabled(feature.mask);
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public final boolean isRef() {
        return this.sp == 4 && charAt(this.np + 1) == '$' && charAt(this.np + 2) == 'r' && charAt(this.np + 3) == 'e' && charAt(this.np + 4) == 'f';
    }

    public void lexError(String str, Object... objArr) {
        this.token = 1;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0085  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x005c -> B:11:0x002e). Please report as a decompilation issue!!! */
    @Override // com.alibaba.fastjson.parser.JSONLexer
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final long longValue() throws java.lang.NumberFormatException {
        /*
            r13 = this;
            int r0 = r13.np
            r1 = -1
            r2 = 0
            if (r0 != r1) goto L8
            r13.np = r2
        L8:
            int r0 = r13.np
            int r1 = r13.sp
            int r1 = r1 + r0
            char r3 = r13.charAt(r0)
            r4 = 45
            r5 = 1
            if (r3 != r4) goto L1d
            int r0 = r0 + 1
            r2 = -9223372036854775808
            r3 = r2
            r2 = r5
            goto L22
        L1d:
            r3 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
        L22:
            if (r0 >= r1) goto L30
            int r6 = r0 + 1
            char r0 = r13.charAt(r0)
            int r0 = r0 + (-48)
            int r0 = -r0
            long r7 = (long) r0
        L2e:
            r0 = r6
            goto L32
        L30:
            r7 = 0
        L32:
            if (r0 >= r1) goto L73
            int r6 = r0 + 1
            char r0 = r13.charAt(r0)
            r9 = 76
            if (r0 == r9) goto L72
            r9 = 83
            if (r0 == r9) goto L72
            r9 = 66
            if (r0 != r9) goto L47
            goto L72
        L47:
            int r0 = r0 + (-48)
            r9 = -922337203685477580(0xf333333333333334, double:-8.390303882365713E246)
            int r9 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r9 < 0) goto L68
            r9 = 10
            long r7 = r7 * r9
            long r9 = (long) r0
            long r11 = r3 + r9
            int r0 = (r7 > r11 ? 1 : (r7 == r11 ? 0 : -1))
            if (r0 < 0) goto L5e
            long r7 = r7 - r9
            goto L2e
        L5e:
            java.lang.NumberFormatException r0 = new java.lang.NumberFormatException
            java.lang.String r13 = r13.numberString()
            r0.<init>(r13)
            throw r0
        L68:
            java.lang.NumberFormatException r0 = new java.lang.NumberFormatException
            java.lang.String r13 = r13.numberString()
            r0.<init>(r13)
            throw r0
        L72:
            r0 = r6
        L73:
            if (r2 == 0) goto L85
            int r1 = r13.np
            int r1 = r1 + r5
            if (r0 <= r1) goto L7b
            return r7
        L7b:
            java.lang.NumberFormatException r0 = new java.lang.NumberFormatException
            java.lang.String r13 = r13.numberString()
            r0.<init>(r13)
            throw r0
        L85:
            long r0 = -r7
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.JSONLexerBase.longValue():long");
    }

    public final boolean matchField(char[] cArr) {
        while (!charArrayCompare(cArr)) {
            if (!isWhitespace(this.f4610ch)) {
                return false;
            }
            next();
        }
        int length = this.bp + cArr.length;
        this.bp = length;
        char cCharAt = charAt(length);
        this.f4610ch = cCharAt;
        if (cCharAt == '{') {
            next();
            this.token = 12;
        } else if (cCharAt == '[') {
            next();
            this.token = 14;
        } else if (cCharAt == 'S' && charAt(this.bp + 1) == 'e' && charAt(this.bp + 2) == 't' && charAt(this.bp + 3) == '[') {
            int i4 = this.bp + 3;
            this.bp = i4;
            this.f4610ch = charAt(i4);
            this.token = 21;
        } else {
            nextToken();
        }
        return true;
    }

    public boolean matchField2(char[] cArr) {
        throw new UnsupportedOperationException();
    }

    public final int matchStat() {
        return this.matchStat;
    }

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

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public abstract char next();

    public final void nextIdent() {
        while (isWhitespace(this.f4610ch)) {
            next();
        }
        char c4 = this.f4610ch;
        if (c4 == '_' || Character.isLetter(c4)) {
            scanIdent();
        } else {
            nextToken();
        }
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public final void nextToken() {
        this.sp = 0;
        while (true) {
            this.pos = this.bp;
            char c4 = this.f4610ch;
            if (c4 == '/') {
                skipComment();
            } else {
                if (c4 == '\"') {
                    scanString();
                    return;
                }
                if (c4 == ',') {
                    next();
                    this.token = 16;
                    return;
                }
                if (c4 >= '0' && c4 <= '9') {
                    scanNumber();
                    return;
                }
                if (c4 != '-') {
                    switch (c4) {
                        case '\b':
                        case '\t':
                        case '\n':
                        case '\f':
                        case '\r':
                        case ' ':
                            next();
                            break;
                        case '\'':
                            if (!isEnabled(Feature.AllowSingleQuotes)) {
                                throw new JSONException("Feature.AllowSingleQuotes is false");
                            }
                            scanStringSingleQuote();
                            return;
                        case '(':
                            next();
                            this.token = 10;
                            return;
                        case ')':
                            next();
                            this.token = 11;
                            return;
                        case '+':
                            next();
                            scanNumber();
                            return;
                        case '.':
                            next();
                            this.token = 25;
                            return;
                        case ':':
                            next();
                            this.token = 17;
                            return;
                        case PoiResult.Contents.CITY_FIELD_NUMBER /* 59 */:
                            next();
                            this.token = 24;
                            return;
                        case PoiResult.Contents.ADVERTISE_INFO_FIELD_NUMBER /* 78 */:
                        case 'S':
                        case PoiResult.Contents.FAV_BUBBLE_FIELD_NUMBER /* 84 */:
                        case 'u':
                            scanIdent();
                            return;
                        case '[':
                            next();
                            this.token = 14;
                            return;
                        case ']':
                            next();
                            this.token = 15;
                            return;
                        case 'f':
                            scanFalse();
                            return;
                        case 'n':
                            scanNullOrNew();
                            return;
                        case 't':
                            scanTrue();
                            return;
                        case SyslogConstants.LOG_CLOCK /* 120 */:
                            scanHex();
                            return;
                        case '{':
                            next();
                            this.token = 12;
                            return;
                        case '}':
                            next();
                            this.token = 13;
                            return;
                        default:
                            if (isEOF()) {
                                if (this.token == 20) {
                                    throw new JSONException("EOF error");
                                }
                                this.token = 20;
                                int i4 = this.eofPos;
                                this.bp = i4;
                                this.pos = i4;
                                return;
                            }
                            char c5 = this.f4610ch;
                            if (c5 > 31 && c5 != 127) {
                                lexError("illegal.char", String.valueOf((int) c5));
                                next();
                                return;
                            } else {
                                next();
                                break;
                            }
                            break;
                    }
                } else {
                    scanNumber();
                    return;
                }
            }
        }
    }

    public final void nextTokenWithChar(char c4) {
        this.sp = 0;
        while (true) {
            char c5 = this.f4610ch;
            if (c5 == c4) {
                next();
                nextToken();
                return;
            }
            if (c5 != ' ' && c5 != '\n' && c5 != '\r' && c5 != '\t' && c5 != '\f' && c5 != '\b') {
                throw new JSONException("not match " + c4 + " - " + this.f4610ch + ", info : " + info());
            }
            next();
        }
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public final void nextTokenWithColon() {
        nextTokenWithChar(CoreConstants.COLON_CHAR);
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public abstract String numberString();

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public final int pos() {
        return this.pos;
    }

    public final void putChar(char c4) {
        int i4 = this.sp;
        char[] cArr = this.sbuf;
        if (i4 == cArr.length) {
            char[] cArr2 = new char[cArr.length * 2];
            System.arraycopy(cArr, 0, cArr2, 0, cArr.length);
            this.sbuf = cArr2;
        }
        char[] cArr3 = this.sbuf;
        int i5 = this.sp;
        this.sp = i5 + 1;
        cArr3[i5] = c4;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public final void resetStringPosition() {
        this.sp = 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x00a6  */
    @Override // com.alibaba.fastjson.parser.JSONLexer
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean scanBoolean(char r10) {
        /*
            r9 = this;
            r0 = 0
            r9.matchStat = r0
            int r1 = r9.bp
            char r1 = r9.charAt(r1)
            r2 = 116(0x74, float:1.63E-43)
            r3 = 5
            r4 = 101(0x65, float:1.42E-43)
            r5 = -1
            r6 = 3
            r7 = 2
            r8 = 1
            if (r1 != r2) goto L40
            int r1 = r9.bp
            int r1 = r1 + r8
            char r1 = r9.charAt(r1)
            r2 = 114(0x72, float:1.6E-43)
            if (r1 != r2) goto L3d
            int r1 = r9.bp
            int r1 = r1 + r7
            char r1 = r9.charAt(r1)
            r2 = 117(0x75, float:1.64E-43)
            if (r1 != r2) goto L3d
            int r1 = r9.bp
            int r1 = r1 + r6
            char r1 = r9.charAt(r1)
            if (r1 != r4) goto L3d
            int r0 = r9.bp
            int r0 = r0 + 4
            char r1 = r9.charAt(r0)
        L3b:
            r0 = r8
            goto L96
        L3d:
            r9.matchStat = r5
            return r0
        L40:
            r2 = 102(0x66, float:1.43E-43)
            if (r1 != r2) goto L7b
            int r1 = r9.bp
            int r1 = r1 + r8
            char r1 = r9.charAt(r1)
            r2 = 97
            if (r1 != r2) goto L78
            int r1 = r9.bp
            int r1 = r1 + r7
            char r1 = r9.charAt(r1)
            r2 = 108(0x6c, float:1.51E-43)
            if (r1 != r2) goto L78
            int r1 = r9.bp
            int r1 = r1 + r6
            char r1 = r9.charAt(r1)
            r2 = 115(0x73, float:1.61E-43)
            if (r1 != r2) goto L78
            int r1 = r9.bp
            int r1 = r1 + 4
            char r1 = r9.charAt(r1)
            if (r1 != r4) goto L78
            int r1 = r9.bp
            int r1 = r1 + r3
            char r1 = r9.charAt(r1)
            r3 = 6
            goto L96
        L78:
            r9.matchStat = r5
            return r0
        L7b:
            r2 = 49
            if (r1 != r2) goto L88
            int r0 = r9.bp
            int r0 = r0 + r8
            char r1 = r9.charAt(r0)
            r3 = r7
            goto L3b
        L88:
            r2 = 48
            if (r1 != r2) goto L95
            int r1 = r9.bp
            int r1 = r1 + r8
            char r1 = r9.charAt(r1)
            r3 = r7
            goto L96
        L95:
            r3 = r8
        L96:
            if (r1 != r10) goto La6
            int r10 = r9.bp
            int r10 = r10 + r3
            r9.bp = r10
            char r10 = r9.charAt(r10)
            r9.f4610ch = r10
            r9.matchStat = r6
            return r0
        La6:
            boolean r1 = isWhitespace(r1)
            if (r1 == 0) goto Lb7
            int r1 = r9.bp
            int r2 = r3 + 1
            int r1 = r1 + r3
            char r1 = r9.charAt(r1)
            r3 = r2
            goto L96
        Lb7:
            r9.matchStat = r5
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.JSONLexerBase.scanBoolean(char):boolean");
    }

    public Date scanDate(char c4) {
        long j4;
        char cCharAt;
        int i4;
        Date date;
        int i5;
        char cCharAt2;
        boolean z4 = false;
        this.matchStat = 0;
        char cCharAt3 = charAt(this.bp);
        int i6 = 1;
        if (cCharAt3 == '\"') {
            int iIndexOf = indexOf('\"', this.bp + 1);
            if (iIndexOf == -1) {
                throw new JSONException("unclosed str");
            }
            int i7 = this.bp + 1;
            String strSubString = subString(i7, iIndexOf - i7);
            if (strSubString.indexOf(92) != -1) {
                while (true) {
                    int i8 = 0;
                    for (int i9 = iIndexOf - 1; i9 >= 0 && charAt(i9) == '\\'; i9--) {
                        i8++;
                    }
                    if (i8 % 2 == 0) {
                        break;
                    }
                    iIndexOf = indexOf('\"', iIndexOf + 1);
                }
                int i10 = this.bp;
                int i11 = iIndexOf - (i10 + 1);
                strSubString = readString(sub_chars(i10 + 1, i11), i11);
            }
            int i12 = this.bp;
            int i13 = iIndexOf - (i12 + 1);
            int i14 = i13 + 2;
            i4 = i13 + 3;
            cCharAt = charAt(i12 + i14);
            JSONScanner jSONScanner = new JSONScanner(strSubString);
            try {
                if (!jSONScanner.scanISO8601DateIfMatch(false)) {
                    this.matchStat = -1;
                    return null;
                }
                date = jSONScanner.getCalendar().getTime();
            } finally {
                jSONScanner.close();
            }
        } else {
            char c5 = '9';
            if (cCharAt3 == '-' || (cCharAt3 >= '0' && cCharAt3 <= '9')) {
                if (cCharAt3 == '-') {
                    cCharAt3 = charAt(this.bp + 1);
                    z4 = true;
                    i6 = 2;
                }
                if (cCharAt3 < '0' || cCharAt3 > '9') {
                    j4 = 0;
                    int i15 = i6;
                    cCharAt = cCharAt3;
                    i4 = i15;
                } else {
                    j4 = cCharAt3 - '0';
                    while (true) {
                        i5 = i6 + 1;
                        cCharAt2 = charAt(this.bp + i6);
                        if (cCharAt2 < '0' || cCharAt2 > c5) {
                            break;
                        }
                        j4 = (j4 * 10) + (cCharAt2 - '0');
                        i6 = i5;
                        c5 = '9';
                    }
                    cCharAt = cCharAt2;
                    i4 = i5;
                }
                if (j4 < 0) {
                    this.matchStat = -1;
                    return null;
                }
                if (z4) {
                    j4 = -j4;
                }
                date = new Date(j4);
            } else {
                if (cCharAt3 != 'n' || charAt(this.bp + 1) != 'u' || charAt(this.bp + 2) != 'l' || charAt(this.bp + 3) != 'l') {
                    this.matchStat = -1;
                    return null;
                }
                i4 = 5;
                this.matchStat = 5;
                cCharAt = charAt(this.bp + 4);
                date = null;
            }
        }
        if (cCharAt == ',') {
            int i16 = this.bp + i4;
            this.bp = i16;
            this.f4610ch = charAt(i16);
            this.matchStat = 3;
            this.token = 16;
            return date;
        }
        if (cCharAt != ']') {
            this.matchStat = -1;
            return null;
        }
        int i17 = i4 + 1;
        char cCharAt4 = charAt(this.bp + i4);
        if (cCharAt4 == ',') {
            this.token = 16;
            int i18 = this.bp + i17;
            this.bp = i18;
            this.f4610ch = charAt(i18);
        } else if (cCharAt4 == ']') {
            this.token = 15;
            int i19 = this.bp + i17;
            this.bp = i19;
            this.f4610ch = charAt(i19);
        } else if (cCharAt4 == '}') {
            this.token = 13;
            int i20 = this.bp + i17;
            this.bp = i20;
            this.f4610ch = charAt(i20);
        } else {
            if (cCharAt4 != 26) {
                this.matchStat = -1;
                return null;
            }
            this.token = 20;
            this.bp += i4;
            this.f4610ch = JSONLexer.EOI;
        }
        this.matchStat = 4;
        return date;
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x009b A[ADDED_TO_REGION] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:45:0x009d -> B:41:0x008d). Please report as a decompilation issue!!! */
    @Override // com.alibaba.fastjson.parser.JSONLexer
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.math.BigDecimal scanDecimal(char r18) {
        /*
            Method dump skipped, instructions count: 442
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.JSONLexerBase.scanDecimal(char):java.math.BigDecimal");
    }

    /* JADX WARN: Removed duplicated region for block: B:54:0x00c2 A[ADDED_TO_REGION] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:55:0x00c4 -> B:51:0x00b3). Please report as a decompilation issue!!! */
    @Override // com.alibaba.fastjson.parser.JSONLexer
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public double scanDouble(char r22) throws java.lang.NumberFormatException {
        /*
            Method dump skipped, instructions count: 431
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.JSONLexerBase.scanDouble(char):double");
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public Enum<?> scanEnum(Class<?> cls, SymbolTable symbolTable, char c4) {
        String strScanSymbolWithSeperator = scanSymbolWithSeperator(symbolTable, c4);
        if (strScanSymbolWithSeperator == null) {
            return null;
        }
        return Enum.valueOf(cls, strScanSymbolWithSeperator);
    }

    public final void scanFalse() {
        if (this.f4610ch != 'f') {
            throw new JSONException("error parse false");
        }
        next();
        if (this.f4610ch != 'a') {
            throw new JSONException("error parse false");
        }
        next();
        if (this.f4610ch != 'l') {
            throw new JSONException("error parse false");
        }
        next();
        if (this.f4610ch != 's') {
            throw new JSONException("error parse false");
        }
        next();
        if (this.f4610ch != 'e') {
            throw new JSONException("error parse false");
        }
        next();
        char c4 = this.f4610ch;
        if (c4 != ' ' && c4 != ',' && c4 != '}' && c4 != ']' && c4 != '\n' && c4 != '\r' && c4 != '\t' && c4 != 26 && c4 != '\f' && c4 != '\b' && c4 != ':' && c4 != '/') {
            throw new JSONException("scan false error");
        }
        this.token = 7;
    }

    public BigInteger scanFieldBigInteger(char[] cArr) {
        int i4;
        char cCharAt;
        int length;
        int iE;
        BigInteger bigIntegerValueOf;
        this.matchStat = 0;
        if (!charArrayCompare(cArr)) {
            this.matchStat = -2;
            return null;
        }
        int length2 = cArr.length;
        int i5 = length2 + 1;
        char cCharAt2 = charAt(this.bp + length2);
        boolean z4 = cCharAt2 == '\"';
        if (z4) {
            cCharAt2 = charAt(this.bp + i5);
            i5 = length2 + 2;
        }
        boolean z5 = cCharAt2 == '-';
        if (z5) {
            char cCharAt3 = charAt(this.bp + i5);
            i5++;
            cCharAt2 = cCharAt3;
        }
        if (cCharAt2 < '0' || cCharAt2 > '9') {
            if (cCharAt2 != 'n' || charAt(this.bp + i5) != 'u' || AbstractC0351g.b(this.bp, i5, 1, this) != 'l' || AbstractC0351g.b(this.bp, i5, 2, this) != 'l') {
                this.matchStat = -1;
                return null;
            }
            this.matchStat = 5;
            int i6 = i5 + 4;
            char cCharAt4 = charAt(this.bp + i5 + 3);
            if (z4 && cCharAt4 == '\"') {
                cCharAt4 = charAt(this.bp + i6);
                i6 = i5 + 5;
            }
            while (cCharAt4 != ',') {
                if (cCharAt4 == '}') {
                    int i7 = this.bp + i6;
                    this.bp = i7;
                    this.f4610ch = charAt(i7);
                    this.matchStat = 5;
                    this.token = 13;
                    return null;
                }
                if (!isWhitespace(cCharAt4)) {
                    this.matchStat = -1;
                    return null;
                }
                cCharAt4 = charAt(this.bp + i6);
                i6++;
            }
            int i8 = this.bp + i6;
            this.bp = i8;
            this.f4610ch = charAt(i8);
            this.matchStat = 5;
            this.token = 16;
            return null;
        }
        long j4 = cCharAt2 - '0';
        while (true) {
            i4 = i5 + 1;
            cCharAt = charAt(this.bp + i5);
            if (cCharAt < '0' || cCharAt > '9') {
                break;
            }
            j4 = (j4 * 10) + (cCharAt - '0');
            i5 = i4;
        }
        if (!z4) {
            int i9 = this.bp;
            length = cArr.length + i9;
            iE = g.e(i9, i4, length, 1);
        } else {
            if (cCharAt != '\"') {
                this.matchStat = -1;
                return null;
            }
            int i10 = i5 + 2;
            cCharAt = charAt(this.bp + i4);
            int i11 = this.bp;
            length = cArr.length + i11 + 1;
            iE = g.e(i11, i10, length, 2);
            i4 = i10;
        }
        if (iE < 20 || (z5 && iE < 21)) {
            if (z5) {
                j4 = -j4;
            }
            bigIntegerValueOf = BigInteger.valueOf(j4);
        } else {
            bigIntegerValueOf = new BigInteger(subString(length, iE));
        }
        if (cCharAt == ',') {
            int i12 = this.bp + i4;
            this.bp = i12;
            this.f4610ch = charAt(i12);
            this.matchStat = 3;
            this.token = 16;
            return bigIntegerValueOf;
        }
        if (cCharAt != '}') {
            this.matchStat = -1;
            return null;
        }
        int i13 = i4 + 1;
        char cCharAt5 = charAt(this.bp + i4);
        if (cCharAt5 == ',') {
            this.token = 16;
            int i14 = this.bp + i13;
            this.bp = i14;
            this.f4610ch = charAt(i14);
        } else if (cCharAt5 == ']') {
            this.token = 15;
            int i15 = this.bp + i13;
            this.bp = i15;
            this.f4610ch = charAt(i15);
        } else if (cCharAt5 == '}') {
            this.token = 13;
            int i16 = this.bp + i13;
            this.bp = i16;
            this.f4610ch = charAt(i16);
        } else {
            if (cCharAt5 != 26) {
                this.matchStat = -1;
                return null;
            }
            this.token = 20;
            this.bp += i4;
            this.f4610ch = JSONLexer.EOI;
        }
        this.matchStat = 4;
        return bigIntegerValueOf;
    }

    public boolean scanFieldBoolean(char[] cArr) {
        int i4;
        boolean z4;
        this.matchStat = 0;
        if (!charArrayCompare(cArr)) {
            this.matchStat = -2;
            return false;
        }
        int length = cArr.length;
        int i5 = length + 1;
        char cCharAt = charAt(this.bp + length);
        if (cCharAt == 't') {
            int i6 = length + 2;
            if (charAt(this.bp + i5) != 'r') {
                this.matchStat = -1;
                return false;
            }
            int i7 = length + 3;
            if (charAt(this.bp + i6) != 'u') {
                this.matchStat = -1;
                return false;
            }
            i4 = length + 4;
            if (charAt(this.bp + i7) != 'e') {
                this.matchStat = -1;
                return false;
            }
            z4 = true;
        } else {
            if (cCharAt != 'f') {
                this.matchStat = -1;
                return false;
            }
            int i8 = length + 2;
            if (charAt(this.bp + i5) != 'a') {
                this.matchStat = -1;
                return false;
            }
            int i9 = length + 3;
            if (charAt(this.bp + i8) != 'l') {
                this.matchStat = -1;
                return false;
            }
            int i10 = length + 4;
            if (charAt(this.bp + i9) != 's') {
                this.matchStat = -1;
                return false;
            }
            i4 = length + 5;
            if (charAt(this.bp + i10) != 'e') {
                this.matchStat = -1;
                return false;
            }
            z4 = false;
        }
        int i11 = i4 + 1;
        char cCharAt2 = charAt(this.bp + i4);
        if (cCharAt2 == ',') {
            int i12 = this.bp + i11;
            this.bp = i12;
            this.f4610ch = charAt(i12);
            this.matchStat = 3;
            this.token = 16;
            return z4;
        }
        if (cCharAt2 != '}') {
            this.matchStat = -1;
            return false;
        }
        int i13 = i4 + 2;
        char cCharAt3 = charAt(this.bp + i11);
        if (cCharAt3 == ',') {
            this.token = 16;
            int i14 = this.bp + i13;
            this.bp = i14;
            this.f4610ch = charAt(i14);
        } else if (cCharAt3 == ']') {
            this.token = 15;
            int i15 = this.bp + i13;
            this.bp = i15;
            this.f4610ch = charAt(i15);
        } else if (cCharAt3 == '}') {
            this.token = 13;
            int i16 = this.bp + i13;
            this.bp = i16;
            this.f4610ch = charAt(i16);
        } else {
            if (cCharAt3 != 26) {
                this.matchStat = -1;
                return false;
            }
            this.token = 20;
            this.bp = i4 + 1 + this.bp;
            this.f4610ch = JSONLexer.EOI;
        }
        this.matchStat = 4;
        return z4;
    }

    public Date scanFieldDate(char[] cArr) {
        char cCharAt;
        int i4;
        long j4;
        Date date;
        int i5;
        char cCharAt2;
        boolean z4 = false;
        this.matchStat = 0;
        if (!charArrayCompare(cArr)) {
            this.matchStat = -2;
            return null;
        }
        int length = cArr.length;
        int i6 = length + 1;
        char cCharAt3 = charAt(this.bp + length);
        if (cCharAt3 == '\"') {
            int iIndexOf = indexOf('\"', this.bp + cArr.length + 1);
            if (iIndexOf == -1) {
                throw new JSONException("unclosed str");
            }
            int length2 = this.bp + cArr.length + 1;
            String strSubString = subString(length2, iIndexOf - length2);
            if (strSubString.indexOf(92) != -1) {
                while (true) {
                    int i7 = 0;
                    for (int i8 = iIndexOf - 1; i8 >= 0 && charAt(i8) == '\\'; i8--) {
                        i7++;
                    }
                    if (i7 % 2 == 0) {
                        break;
                    }
                    iIndexOf = indexOf('\"', iIndexOf + 1);
                }
                int i9 = this.bp;
                int length3 = iIndexOf - ((cArr.length + i9) + 1);
                strSubString = readString(sub_chars(i9 + cArr.length + 1, length3), length3);
            }
            int i10 = this.bp;
            int length4 = (iIndexOf - ((cArr.length + i10) + 1)) + 1 + i6;
            i4 = length4 + 1;
            cCharAt = charAt(i10 + length4);
            JSONScanner jSONScanner = new JSONScanner(strSubString);
            try {
                if (!jSONScanner.scanISO8601DateIfMatch(false)) {
                    this.matchStat = -1;
                    return null;
                }
                date = jSONScanner.getCalendar().getTime();
            } finally {
                jSONScanner.close();
            }
        } else {
            if (cCharAt3 != '-' && (cCharAt3 < '0' || cCharAt3 > '9')) {
                this.matchStat = -1;
                return null;
            }
            if (cCharAt3 == '-') {
                cCharAt3 = charAt(this.bp + i6);
                i6 = length + 2;
                z4 = true;
            }
            if (cCharAt3 < '0' || cCharAt3 > '9') {
                cCharAt = cCharAt3;
                i4 = i6;
                j4 = 0;
            } else {
                j4 = cCharAt3 - '0';
                while (true) {
                    i5 = i6 + 1;
                    cCharAt2 = charAt(this.bp + i6);
                    if (cCharAt2 < '0' || cCharAt2 > '9') {
                        break;
                    }
                    j4 = (j4 * 10) + (cCharAt2 - '0');
                    i6 = i5;
                }
                cCharAt = cCharAt2;
                i4 = i5;
            }
            if (j4 < 0) {
                this.matchStat = -1;
                return null;
            }
            if (z4) {
                j4 = -j4;
            }
            date = new Date(j4);
        }
        if (cCharAt == ',') {
            int i11 = this.bp + i4;
            this.bp = i11;
            this.f4610ch = charAt(i11);
            this.matchStat = 3;
            return date;
        }
        if (cCharAt != '}') {
            this.matchStat = -1;
            return null;
        }
        int i12 = i4 + 1;
        char cCharAt4 = charAt(this.bp + i4);
        if (cCharAt4 == ',') {
            this.token = 16;
            int i13 = this.bp + i12;
            this.bp = i13;
            this.f4610ch = charAt(i13);
        } else if (cCharAt4 == ']') {
            this.token = 15;
            int i14 = this.bp + i12;
            this.bp = i14;
            this.f4610ch = charAt(i14);
        } else if (cCharAt4 == '}') {
            this.token = 13;
            int i15 = this.bp + i12;
            this.bp = i15;
            this.f4610ch = charAt(i15);
        } else {
            if (cCharAt4 != 26) {
                this.matchStat = -1;
                return null;
            }
            this.token = 20;
            this.bp += i4;
            this.f4610ch = JSONLexer.EOI;
        }
        this.matchStat = 4;
        return date;
    }

    public BigDecimal scanFieldDecimal(char[] cArr) {
        int i4;
        char cCharAt;
        int length;
        int iE;
        char cCharAt2;
        int i5;
        this.matchStat = 0;
        if (!charArrayCompare(cArr)) {
            this.matchStat = -2;
            return null;
        }
        int length2 = cArr.length;
        int i6 = length2 + 1;
        char cCharAt3 = charAt(this.bp + length2);
        boolean z4 = cCharAt3 == '\"';
        if (z4) {
            cCharAt3 = charAt(this.bp + i6);
            i6 = length2 + 2;
        }
        if (cCharAt3 == '-') {
            cCharAt3 = charAt(this.bp + i6);
            i6++;
        }
        if (cCharAt3 < '0' || cCharAt3 > '9') {
            if (cCharAt3 != 'n' || charAt(this.bp + i6) != 'u' || AbstractC0351g.b(this.bp, i6, 1, this) != 'l' || AbstractC0351g.b(this.bp, i6, 2, this) != 'l') {
                this.matchStat = -1;
                return null;
            }
            this.matchStat = 5;
            int i7 = i6 + 4;
            char cCharAt4 = charAt(this.bp + i6 + 3);
            if (z4 && cCharAt4 == '\"') {
                int i8 = i6 + 5;
                cCharAt4 = charAt(this.bp + i7);
                i7 = i8;
            }
            while (cCharAt4 != ',') {
                if (cCharAt4 == '}') {
                    int i9 = this.bp + i7;
                    this.bp = i9;
                    this.f4610ch = charAt(i9);
                    this.matchStat = 5;
                    this.token = 13;
                    return null;
                }
                if (!isWhitespace(cCharAt4)) {
                    this.matchStat = -1;
                    return null;
                }
                int i10 = i7 + 1;
                cCharAt4 = charAt(this.bp + i7);
                i7 = i10;
            }
            int i11 = this.bp + i7;
            this.bp = i11;
            this.f4610ch = charAt(i11);
            this.matchStat = 5;
            this.token = 16;
            return null;
        }
        while (true) {
            i4 = i6 + 1;
            cCharAt = charAt(this.bp + i6);
            if (cCharAt < '0' || cCharAt > '9') {
                break;
            }
            i6 = i4;
        }
        if (cCharAt == '.') {
            int i12 = i6 + 2;
            char cCharAt5 = charAt(this.bp + i4);
            if (cCharAt5 < '0' || cCharAt5 > '9') {
                this.matchStat = -1;
                return null;
            }
            while (true) {
                i4 = i12 + 1;
                cCharAt = charAt(this.bp + i12);
                if (cCharAt < '0' || cCharAt > '9') {
                    break;
                }
                i12 = i4;
            }
        }
        if (cCharAt == 'e' || cCharAt == 'E') {
            int i13 = i4 + 1;
            cCharAt = charAt(this.bp + i4);
            if (cCharAt == '+' || cCharAt == '-') {
                i4 += 2;
                cCharAt = charAt(this.bp + i13);
            } else {
                i4 = i13;
            }
            while (cCharAt >= '0' && cCharAt <= '9') {
                char cCharAt6 = charAt(this.bp + i4);
                i4++;
                cCharAt = cCharAt6;
            }
        }
        int i14 = i4;
        if (!z4) {
            int i15 = this.bp;
            length = cArr.length + i15;
            iE = g.e(i15, i14, length, 1);
            cCharAt2 = cCharAt;
            i5 = i14;
        } else {
            if (cCharAt != '\"') {
                this.matchStat = -1;
                return null;
            }
            i5 = i14 + 1;
            cCharAt2 = charAt(this.bp + i14);
            int i16 = this.bp;
            length = cArr.length + i16 + 1;
            iE = g.e(i16, i5, length, 2);
        }
        BigDecimal bigDecimal = new BigDecimal(sub_chars(length, iE));
        if (cCharAt2 == ',') {
            int i17 = this.bp + i5;
            this.bp = i17;
            this.f4610ch = charAt(i17);
            this.matchStat = 3;
            this.token = 16;
            return bigDecimal;
        }
        if (cCharAt2 != '}') {
            this.matchStat = -1;
            return null;
        }
        int i18 = i5 + 1;
        char cCharAt7 = charAt(this.bp + i5);
        if (cCharAt7 == ',') {
            this.token = 16;
            int i19 = this.bp + i18;
            this.bp = i19;
            this.f4610ch = charAt(i19);
        } else if (cCharAt7 == ']') {
            this.token = 15;
            int i20 = this.bp + i18;
            this.bp = i20;
            this.f4610ch = charAt(i20);
        } else if (cCharAt7 == '}') {
            this.token = 13;
            int i21 = this.bp + i18;
            this.bp = i21;
            this.f4610ch = charAt(i21);
        } else {
            if (cCharAt7 != 26) {
                this.matchStat = -1;
                return null;
            }
            this.token = 20;
            this.bp += i5;
            this.f4610ch = JSONLexer.EOI;
        }
        this.matchStat = 4;
        return bigDecimal;
    }

    public final double scanFieldDouble(char[] cArr) throws NumberFormatException {
        int i4;
        char cCharAt;
        boolean z4;
        long j4;
        int length;
        int i5;
        int iE;
        double d4;
        this.matchStat = 0;
        if (!charArrayCompare(cArr)) {
            this.matchStat = -2;
            return 0.0d;
        }
        int length2 = cArr.length;
        int i6 = length2 + 1;
        char cCharAt2 = charAt(this.bp + length2);
        boolean z5 = cCharAt2 == '\"';
        if (z5) {
            cCharAt2 = charAt(this.bp + i6);
            i6 = length2 + 2;
        }
        boolean z6 = cCharAt2 == '-';
        if (z6) {
            cCharAt2 = charAt(this.bp + i6);
            i6++;
        }
        if (cCharAt2 < '0' || cCharAt2 > '9') {
            if (cCharAt2 != 'n' || charAt(this.bp + i6) != 'u' || AbstractC0351g.b(this.bp, i6, 1, this) != 'l' || AbstractC0351g.b(this.bp, i6, 2, this) != 'l') {
                this.matchStat = -1;
                return 0.0d;
            }
            this.matchStat = 5;
            int i7 = i6 + 4;
            char cCharAt3 = charAt(this.bp + i6 + 3);
            if (z5 && cCharAt3 == '\"') {
                cCharAt3 = charAt(this.bp + i7);
                i7 = i6 + 5;
            }
            while (cCharAt3 != ',') {
                if (cCharAt3 == '}') {
                    int i8 = this.bp + i7;
                    this.bp = i8;
                    this.f4610ch = charAt(i8);
                    this.matchStat = 5;
                    this.token = 13;
                    return 0.0d;
                }
                if (!isWhitespace(cCharAt3)) {
                    this.matchStat = -1;
                    return 0.0d;
                }
                cCharAt3 = charAt(this.bp + i7);
                i7++;
            }
            int i9 = this.bp + i7;
            this.bp = i9;
            this.f4610ch = charAt(i9);
            this.matchStat = 5;
            this.token = 16;
            return 0.0d;
        }
        long j5 = cCharAt2 - '0';
        while (true) {
            i4 = i6 + 1;
            cCharAt = charAt(this.bp + i6);
            if (cCharAt < '0' || cCharAt > '9') {
                break;
            }
            j5 = (j5 * 10) + (cCharAt - '0');
            i6 = i4;
        }
        if (cCharAt == '.') {
            int i10 = i6 + 2;
            char cCharAt4 = charAt(this.bp + i4);
            if (cCharAt4 < '0' || cCharAt4 > '9') {
                this.matchStat = -1;
                return 0.0d;
            }
            z4 = z6;
            j5 = (j5 * 10) + (cCharAt4 - '0');
            j4 = 10;
            while (true) {
                i4 = i10 + 1;
                cCharAt = charAt(this.bp + i10);
                if (cCharAt < '0' || cCharAt > '9') {
                    break;
                }
                j5 = (j5 * 10) + (cCharAt - '0');
                j4 *= 10;
                i10 = i4;
            }
        } else {
            z4 = z6;
            j4 = 1;
        }
        boolean z7 = cCharAt == 'e' || cCharAt == 'E';
        if (z7) {
            int i11 = i4 + 1;
            cCharAt = charAt(this.bp + i4);
            if (cCharAt == '+' || cCharAt == '-') {
                i4 += 2;
                cCharAt = charAt(this.bp + i11);
            } else {
                i4 = i11;
            }
            while (cCharAt >= '0' && cCharAt <= '9') {
                cCharAt = charAt(this.bp + i4);
                i4++;
            }
        }
        int i12 = i4;
        if (!z5) {
            int i13 = this.bp;
            length = cArr.length + i13;
            int iE2 = g.e(i13, i12, length, 1);
            i5 = i12;
            iE = iE2;
        } else {
            if (cCharAt != '\"') {
                this.matchStat = -1;
                return 0.0d;
            }
            i5 = i12 + 1;
            cCharAt = charAt(this.bp + i12);
            int i14 = this.bp;
            length = cArr.length + i14 + 1;
            iE = g.e(i14, i5, length, 2);
        }
        if (z7 || iE >= 20) {
            d4 = Double.parseDouble(subString(length, iE));
        } else {
            d4 = j5 / j4;
            if (z4) {
                d4 = -d4;
            }
        }
        if (cCharAt == ',') {
            int i15 = this.bp + i5;
            this.bp = i15;
            this.f4610ch = charAt(i15);
            this.matchStat = 3;
            this.token = 16;
            return d4;
        }
        if (cCharAt != '}') {
            this.matchStat = -1;
            return 0.0d;
        }
        int i16 = i5 + 1;
        char cCharAt5 = charAt(this.bp + i5);
        if (cCharAt5 == ',') {
            this.token = 16;
            int i17 = this.bp + i16;
            this.bp = i17;
            this.f4610ch = charAt(i17);
        } else if (cCharAt5 == ']') {
            this.token = 15;
            int i18 = this.bp + i16;
            this.bp = i18;
            this.f4610ch = charAt(i18);
        } else if (cCharAt5 == '}') {
            this.token = 13;
            int i19 = this.bp + i16;
            this.bp = i19;
            this.f4610ch = charAt(i19);
        } else {
            if (cCharAt5 != 26) {
                this.matchStat = -1;
                return 0.0d;
            }
            this.token = 20;
            this.bp += i5;
            this.f4610ch = JSONLexer.EOI;
        }
        this.matchStat = 4;
        return d4;
    }

    public final float scanFieldFloat(char[] cArr) throws NumberFormatException {
        int i4;
        char cCharAt;
        int i5;
        int length;
        int i6;
        int iE;
        float f4;
        this.matchStat = 0;
        if (!charArrayCompare(cArr)) {
            this.matchStat = -2;
            return Property.DEFAULT_FLOAT_VALUE;
        }
        int length2 = cArr.length;
        int i7 = length2 + 1;
        char cCharAt2 = charAt(this.bp + length2);
        boolean z4 = cCharAt2 == '\"';
        if (z4) {
            cCharAt2 = charAt(this.bp + i7);
            i7 = length2 + 2;
        }
        boolean z5 = cCharAt2 == '-';
        if (z5) {
            cCharAt2 = charAt(this.bp + i7);
            i7++;
        }
        if (cCharAt2 < '0' || cCharAt2 > '9') {
            if (cCharAt2 != 'n' || charAt(this.bp + i7) != 'u' || AbstractC0351g.b(this.bp, i7, 1, this) != 'l' || AbstractC0351g.b(this.bp, i7, 2, this) != 'l') {
                this.matchStat = -1;
                return Property.DEFAULT_FLOAT_VALUE;
            }
            this.matchStat = 5;
            int i8 = i7 + 4;
            char cCharAt3 = charAt(this.bp + i7 + 3);
            if (z4 && cCharAt3 == '\"') {
                cCharAt3 = charAt(this.bp + i8);
                i8 = i7 + 5;
            }
            while (cCharAt3 != ',') {
                if (cCharAt3 == '}') {
                    int i9 = this.bp + i8;
                    this.bp = i9;
                    this.f4610ch = charAt(i9);
                    this.matchStat = 5;
                    this.token = 13;
                    return Property.DEFAULT_FLOAT_VALUE;
                }
                if (!isWhitespace(cCharAt3)) {
                    this.matchStat = -1;
                    return Property.DEFAULT_FLOAT_VALUE;
                }
                cCharAt3 = charAt(this.bp + i8);
                i8++;
            }
            int i10 = this.bp + i8;
            this.bp = i10;
            this.f4610ch = charAt(i10);
            this.matchStat = 5;
            this.token = 16;
            return Property.DEFAULT_FLOAT_VALUE;
        }
        int i11 = cCharAt2 - '0';
        while (true) {
            i4 = i7 + 1;
            cCharAt = charAt(this.bp + i7);
            if (cCharAt < '0' || cCharAt > '9') {
                break;
            }
            i11 = (i11 * 10) + (cCharAt - '0');
            i7 = i4;
        }
        if (cCharAt == '.') {
            int i12 = i7 + 2;
            char cCharAt4 = charAt(this.bp + i4);
            if (cCharAt4 < '0' || cCharAt4 > '9') {
                this.matchStat = -1;
                return Property.DEFAULT_FLOAT_VALUE;
            }
            i5 = 10;
            i11 = (cCharAt4 - '0') + (i11 * 10);
            int i13 = i12;
            while (true) {
                i4 = i13 + 1;
                cCharAt = charAt(this.bp + i13);
                if (cCharAt < '0' || cCharAt > '9') {
                    break;
                }
                i11 = (i11 * 10) + (cCharAt - '0');
                i5 *= 10;
                i13 = i4;
            }
        } else {
            i5 = 1;
        }
        boolean z6 = cCharAt == 'e' || cCharAt == 'E';
        if (z6) {
            int i14 = i4 + 1;
            cCharAt = charAt(this.bp + i4);
            if (cCharAt == '+' || cCharAt == '-') {
                i4 += 2;
                cCharAt = charAt(this.bp + i14);
            } else {
                i4 = i14;
            }
            while (cCharAt >= '0' && cCharAt <= '9') {
                cCharAt = charAt(this.bp + i4);
                i4++;
            }
        }
        int i15 = i4;
        if (!z4) {
            int i16 = this.bp;
            length = cArr.length + i16;
            i6 = i15;
            iE = g.e(i16, i15, length, 1);
        } else {
            if (cCharAt != '\"') {
                this.matchStat = -1;
                return Property.DEFAULT_FLOAT_VALUE;
            }
            i6 = i15 + 1;
            cCharAt = charAt(this.bp + i15);
            int i17 = this.bp;
            length = cArr.length + i17 + 1;
            iE = g.e(i17, i6, length, 2);
        }
        if (z6 || iE >= 20) {
            f4 = Float.parseFloat(subString(length, iE));
        } else {
            f4 = i11 / i5;
            if (z5) {
                f4 = -f4;
            }
        }
        if (cCharAt == ',') {
            int i18 = this.bp + i6;
            this.bp = i18;
            this.f4610ch = charAt(i18);
            this.matchStat = 3;
            this.token = 16;
            return f4;
        }
        if (cCharAt != '}') {
            this.matchStat = -1;
            return Property.DEFAULT_FLOAT_VALUE;
        }
        int i19 = i6 + 1;
        char cCharAt5 = charAt(this.bp + i6);
        if (cCharAt5 == ',') {
            this.token = 16;
            int i20 = this.bp + i19;
            this.bp = i20;
            this.f4610ch = charAt(i20);
        } else if (cCharAt5 == ']') {
            this.token = 15;
            int i21 = this.bp + i19;
            this.bp = i21;
            this.f4610ch = charAt(i21);
        } else if (cCharAt5 == '}') {
            this.token = 13;
            int i22 = this.bp + i19;
            this.bp = i22;
            this.f4610ch = charAt(i22);
        } else {
            if (cCharAt5 != 26) {
                this.matchStat = -1;
                return Property.DEFAULT_FLOAT_VALUE;
            }
            this.bp += i6;
            this.token = 20;
            this.f4610ch = JSONLexer.EOI;
        }
        this.matchStat = 4;
        return f4;
    }

    /* JADX WARN: Code restructure failed: missing block: B:36:0x009e, code lost:
    
        r19.matchStat = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x00a0, code lost:
    
        return r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x01ad, code lost:
    
        r1 = r4;
        r19.matchStat = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x01b0, code lost:
    
        return r1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final float[] scanFieldFloatArray(char[] r20) throws java.lang.NumberFormatException {
        /*
            Method dump skipped, instructions count: 433
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.JSONLexerBase.scanFieldFloatArray(char[]):float[]");
    }

    /* JADX WARN: Code restructure failed: missing block: B:115:0x0216, code lost:
    
        r5 = r4;
        r19.matchStat = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:116:0x0219, code lost:
    
        return r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00b4, code lost:
    
        r19.matchStat = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00b6, code lost:
    
        return r4;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final float[][] scanFieldFloatArray2(char[] r20) throws java.lang.NumberFormatException {
        /*
            Method dump skipped, instructions count: 538
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.JSONLexerBase.scanFieldFloatArray2(char[]):float[][]");
    }

    public int scanFieldInt(char[] cArr) {
        int i4;
        char cCharAt;
        this.matchStat = 0;
        if (!charArrayCompare(cArr)) {
            this.matchStat = -2;
            return 0;
        }
        int length = cArr.length;
        int i5 = length + 1;
        char cCharAt2 = charAt(this.bp + length);
        boolean z4 = cCharAt2 == '-';
        if (z4) {
            cCharAt2 = charAt(this.bp + i5);
            i5 = length + 2;
        }
        if (cCharAt2 < '0' || cCharAt2 > '9') {
            this.matchStat = -1;
            return 0;
        }
        int i6 = cCharAt2 - '0';
        while (true) {
            i4 = i5 + 1;
            cCharAt = charAt(this.bp + i5);
            if (cCharAt < '0' || cCharAt > '9') {
                break;
            }
            i6 = (i6 * 10) + (cCharAt - '0');
            i5 = i4;
        }
        if (cCharAt == '.') {
            this.matchStat = -1;
            return 0;
        }
        if ((i6 < 0 || i4 > cArr.length + 14) && !(i6 == Integer.MIN_VALUE && i4 == 17 && z4)) {
            this.matchStat = -1;
            return 0;
        }
        if (cCharAt == ',') {
            int i7 = this.bp + i4;
            this.bp = i7;
            this.f4610ch = charAt(i7);
            this.matchStat = 3;
            this.token = 16;
            return z4 ? -i6 : i6;
        }
        if (cCharAt != '}') {
            this.matchStat = -1;
            return 0;
        }
        int i8 = i5 + 2;
        char cCharAt3 = charAt(this.bp + i4);
        if (cCharAt3 == ',') {
            this.token = 16;
            int i9 = this.bp + i8;
            this.bp = i9;
            this.f4610ch = charAt(i9);
        } else if (cCharAt3 == ']') {
            this.token = 15;
            int i10 = this.bp + i8;
            this.bp = i10;
            this.f4610ch = charAt(i10);
        } else if (cCharAt3 == '}') {
            this.token = 13;
            int i11 = this.bp + i8;
            this.bp = i11;
            this.f4610ch = charAt(i11);
        } else {
            if (cCharAt3 != 26) {
                this.matchStat = -1;
                return 0;
            }
            this.token = 20;
            this.bp = i5 + 1 + this.bp;
            this.f4610ch = JSONLexer.EOI;
        }
        this.matchStat = 4;
        return z4 ? -i6 : i6;
    }

    /* JADX WARN: Code restructure failed: missing block: B:64:0x011c, code lost:
    
        r2 = r4;
        r18.matchStat = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x011f, code lost:
    
        return r2;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int[] scanFieldIntArray(char[] r19) {
        /*
            Method dump skipped, instructions count: 288
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.JSONLexerBase.scanFieldIntArray(char[]):int[]");
    }

    public long scanFieldLong(char[] cArr) {
        int i4;
        char cCharAt;
        boolean z4 = false;
        this.matchStat = 0;
        if (!charArrayCompare(cArr)) {
            this.matchStat = -2;
            return 0L;
        }
        int length = cArr.length;
        int i5 = length + 1;
        char cCharAt2 = charAt(this.bp + length);
        if (cCharAt2 == '-') {
            cCharAt2 = charAt(this.bp + i5);
            i5 = length + 2;
            z4 = true;
        }
        if (cCharAt2 < '0' || cCharAt2 > '9') {
            this.matchStat = -1;
            return 0L;
        }
        long j4 = cCharAt2 - '0';
        while (true) {
            i4 = i5 + 1;
            cCharAt = charAt(this.bp + i5);
            if (cCharAt < '0' || cCharAt > '9') {
                break;
            }
            j4 = (j4 * 10) + (cCharAt - '0');
            i5 = i4;
        }
        if (cCharAt == '.') {
            this.matchStat = -1;
            return 0L;
        }
        if (i4 - cArr.length >= 21 || (j4 < 0 && !(j4 == Long.MIN_VALUE && z4))) {
            this.matchStat = -1;
            return 0L;
        }
        if (cCharAt == ',') {
            int i6 = this.bp + i4;
            this.bp = i6;
            this.f4610ch = charAt(i6);
            this.matchStat = 3;
            this.token = 16;
            return z4 ? -j4 : j4;
        }
        if (cCharAt != '}') {
            this.matchStat = -1;
            return 0L;
        }
        int i7 = i5 + 2;
        char cCharAt3 = charAt(this.bp + i4);
        if (cCharAt3 == ',') {
            this.token = 16;
            int i8 = this.bp + i7;
            this.bp = i8;
            this.f4610ch = charAt(i8);
        } else if (cCharAt3 == ']') {
            this.token = 15;
            int i9 = this.bp + i7;
            this.bp = i9;
            this.f4610ch = charAt(i9);
        } else if (cCharAt3 == '}') {
            this.token = 13;
            int i10 = this.bp + i7;
            this.bp = i10;
            this.f4610ch = charAt(i10);
        } else {
            if (cCharAt3 != 26) {
                this.matchStat = -1;
                return 0L;
            }
            this.token = 20;
            this.bp = i5 + 1 + this.bp;
            this.f4610ch = JSONLexer.EOI;
        }
        this.matchStat = 4;
        return z4 ? -j4 : j4;
    }

    public String scanFieldString(char[] cArr) {
        this.matchStat = 0;
        if (!charArrayCompare(cArr)) {
            this.matchStat = -2;
            return stringDefaultValue();
        }
        int length = cArr.length;
        int i4 = length + 1;
        if (charAt(this.bp + length) != '\"') {
            this.matchStat = -1;
            return stringDefaultValue();
        }
        int iIndexOf = indexOf('\"', this.bp + cArr.length + 1);
        if (iIndexOf == -1) {
            throw new JSONException("unclosed str");
        }
        int length2 = this.bp + cArr.length + 1;
        String strSubString = subString(length2, iIndexOf - length2);
        if (strSubString.indexOf(92) != -1) {
            while (true) {
                int i5 = 0;
                for (int i6 = iIndexOf - 1; i6 >= 0 && charAt(i6) == '\\'; i6--) {
                    i5++;
                }
                if (i5 % 2 == 0) {
                    break;
                }
                iIndexOf = indexOf('\"', iIndexOf + 1);
            }
            int i7 = this.bp;
            int length3 = iIndexOf - ((cArr.length + i7) + 1);
            strSubString = readString(sub_chars(i7 + cArr.length + 1, length3), length3);
        }
        int i8 = this.bp;
        int length4 = (iIndexOf - ((cArr.length + i8) + 1)) + 1 + i4;
        int i9 = length4 + 1;
        char cCharAt = charAt(i8 + length4);
        if (cCharAt == ',') {
            int i10 = this.bp + i9;
            this.bp = i10;
            this.f4610ch = charAt(i10);
            this.matchStat = 3;
            return strSubString;
        }
        if (cCharAt != '}') {
            this.matchStat = -1;
            return stringDefaultValue();
        }
        int i11 = length4 + 2;
        char cCharAt2 = charAt(this.bp + i9);
        if (cCharAt2 == ',') {
            this.token = 16;
            int i12 = this.bp + i11;
            this.bp = i12;
            this.f4610ch = charAt(i12);
        } else if (cCharAt2 == ']') {
            this.token = 15;
            int i13 = this.bp + i11;
            this.bp = i13;
            this.f4610ch = charAt(i13);
        } else if (cCharAt2 == '}') {
            this.token = 13;
            int i14 = this.bp + i11;
            this.bp = i14;
            this.f4610ch = charAt(i14);
        } else {
            if (cCharAt2 != 26) {
                this.matchStat = -1;
                return stringDefaultValue();
            }
            this.token = 20;
            this.bp = length4 + 1 + this.bp;
            this.f4610ch = JSONLexer.EOI;
        }
        this.matchStat = 4;
        return strSubString;
    }

    /* JADX WARN: Code restructure failed: missing block: B:44:0x00e1, code lost:
    
        if (r1 != ']') goto L69;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x00e7, code lost:
    
        if (r15.size() != 0) goto L69;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x00e9, code lost:
    
        r1 = r14 + 1;
        r14 = charAt(r13.bp + r14);
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x0166, code lost:
    
        throw new com.alibaba.fastjson.JSONException("illega str");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.util.Collection<java.lang.String> scanFieldStringArray(char[] r14, java.lang.Class<?> r15) {
        /*
            Method dump skipped, instructions count: 359
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.JSONLexerBase.scanFieldStringArray(char[], java.lang.Class):java.util.Collection");
    }

    public long scanFieldSymbol(char[] cArr) {
        this.matchStat = 0;
        if (!charArrayCompare(cArr)) {
            this.matchStat = -2;
            return 0L;
        }
        int length = cArr.length;
        int i4 = length + 1;
        if (charAt(this.bp + length) != '\"') {
            this.matchStat = -1;
            return 0L;
        }
        long j4 = -3750763034362895579L;
        while (true) {
            int i5 = i4 + 1;
            char cCharAt = charAt(this.bp + i4);
            if (cCharAt == '\"') {
                int i6 = i4 + 2;
                char cCharAt2 = charAt(this.bp + i5);
                if (cCharAt2 == ',') {
                    int i7 = this.bp + i6;
                    this.bp = i7;
                    this.f4610ch = charAt(i7);
                    this.matchStat = 3;
                    return j4;
                }
                if (cCharAt2 != '}') {
                    this.matchStat = -1;
                    return 0L;
                }
                int i8 = i4 + 3;
                char cCharAt3 = charAt(this.bp + i6);
                if (cCharAt3 == ',') {
                    this.token = 16;
                    int i9 = this.bp + i8;
                    this.bp = i9;
                    this.f4610ch = charAt(i9);
                } else if (cCharAt3 == ']') {
                    this.token = 15;
                    int i10 = this.bp + i8;
                    this.bp = i10;
                    this.f4610ch = charAt(i10);
                } else if (cCharAt3 == '}') {
                    this.token = 13;
                    int i11 = this.bp + i8;
                    this.bp = i11;
                    this.f4610ch = charAt(i11);
                } else {
                    if (cCharAt3 != 26) {
                        this.matchStat = -1;
                        return 0L;
                    }
                    this.token = 20;
                    this.bp = i4 + 2 + this.bp;
                    this.f4610ch = JSONLexer.EOI;
                }
                this.matchStat = 4;
                return j4;
            }
            j4 = (j4 ^ cCharAt) * 1099511628211L;
            if (cCharAt == '\\') {
                this.matchStat = -1;
                return 0L;
            }
            i4 = i5;
        }
    }

    public UUID scanFieldUUID(char[] cArr) {
        int i4;
        char cCharAt;
        UUID uuid;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        this.matchStat = 0;
        if (!charArrayCompare(cArr)) {
            this.matchStat = -2;
            return null;
        }
        int length = cArr.length;
        int i12 = length + 1;
        char cCharAt2 = charAt(this.bp + length);
        char c4 = 4;
        if (cCharAt2 != '\"') {
            if (cCharAt2 == 'n') {
                int i13 = length + 2;
                if (charAt(this.bp + i12) == 'u') {
                    int i14 = length + 3;
                    if (charAt(this.bp + i13) == 'l') {
                        int i15 = length + 4;
                        if (charAt(this.bp + i14) == 'l') {
                            i4 = length + 5;
                            cCharAt = charAt(this.bp + i15);
                            uuid = null;
                        }
                    }
                }
            }
            this.matchStat = -1;
            return null;
        }
        int iIndexOf = indexOf('\"', this.bp + cArr.length + 1);
        if (iIndexOf == -1) {
            throw new JSONException("unclosed str");
        }
        int length2 = this.bp + cArr.length + 1;
        int i16 = iIndexOf - length2;
        char c5 = 'F';
        char c6 = 'A';
        char c7 = 'f';
        char c8 = 'a';
        char c9 = '9';
        if (i16 == 36) {
            int i17 = 0;
            long j4 = 0;
            while (i17 < 8) {
                char cCharAt3 = charAt(length2 + i17);
                if (cCharAt3 >= '0' && cCharAt3 <= '9') {
                    i11 = cCharAt3 - '0';
                } else if (cCharAt3 >= 'a' && cCharAt3 <= 'f') {
                    i11 = cCharAt3 - 'W';
                } else {
                    if (cCharAt3 < 'A' || cCharAt3 > 'F') {
                        this.matchStat = -2;
                        return null;
                    }
                    i11 = cCharAt3 - '7';
                }
                j4 = (j4 << c4) | i11;
                i17++;
                c4 = 4;
            }
            for (int i18 = 9; i18 < 13; i18++) {
                char cCharAt4 = charAt(length2 + i18);
                if (cCharAt4 >= '0' && cCharAt4 <= '9') {
                    i10 = cCharAt4 - '0';
                } else if (cCharAt4 >= 'a' && cCharAt4 <= 'f') {
                    i10 = cCharAt4 - 'W';
                } else {
                    if (cCharAt4 < 'A' || cCharAt4 > 'F') {
                        this.matchStat = -2;
                        return null;
                    }
                    i10 = cCharAt4 - '7';
                }
                j4 = (j4 << 4) | i10;
            }
            int i19 = 14;
            long j5 = j4;
            while (i19 < 18) {
                char cCharAt5 = charAt(length2 + i19);
                if (cCharAt5 >= '0' && cCharAt5 <= '9') {
                    i9 = cCharAt5 - '0';
                } else if (cCharAt5 >= 'a' && cCharAt5 <= 'f') {
                    i9 = cCharAt5 - 'W';
                } else {
                    if (cCharAt5 < 'A' || cCharAt5 > c5) {
                        this.matchStat = -2;
                        return null;
                    }
                    i9 = cCharAt5 - '7';
                }
                j5 = (j5 << 4) | i9;
                i19++;
                iIndexOf = iIndexOf;
                c5 = 'F';
            }
            int i20 = iIndexOf;
            int i21 = 19;
            long j6 = 0;
            while (i21 < 23) {
                char cCharAt6 = charAt(length2 + i21);
                if (cCharAt6 >= '0' && cCharAt6 <= '9') {
                    i8 = cCharAt6 - '0';
                } else if (cCharAt6 >= 'a' && cCharAt6 <= c7) {
                    i8 = cCharAt6 - 'W';
                } else {
                    if (cCharAt6 < c6 || cCharAt6 > 'F') {
                        this.matchStat = -2;
                        return null;
                    }
                    i8 = cCharAt6 - '7';
                }
                j6 = (j6 << 4) | i8;
                i21++;
                c6 = 'A';
                c7 = 'f';
            }
            int i22 = 24;
            long j7 = j6;
            int i23 = 36;
            while (i22 < i23) {
                char cCharAt7 = charAt(length2 + i22);
                if (cCharAt7 >= '0' && cCharAt7 <= c9) {
                    i7 = cCharAt7 - '0';
                } else if (cCharAt7 >= c8 && cCharAt7 <= 'f') {
                    i7 = cCharAt7 - 'W';
                } else {
                    if (cCharAt7 < 'A' || cCharAt7 > 'F') {
                        this.matchStat = -2;
                        return null;
                    }
                    i7 = cCharAt7 - '7';
                }
                j7 = (j7 << 4) | i7;
                i22++;
                i23 = 36;
                c9 = '9';
                c8 = 'a';
            }
            uuid = new UUID(j5, j7);
            int i24 = this.bp;
            int length3 = (i20 - ((cArr.length + i24) + 1)) + 1 + i12;
            i4 = length3 + 1;
            cCharAt = charAt(i24 + length3);
        } else {
            if (i16 != 32) {
                this.matchStat = -1;
                return null;
            }
            int i25 = 0;
            long j8 = 0;
            for (int i26 = 16; i25 < i26; i26 = 16) {
                char cCharAt8 = charAt(length2 + i25);
                if (cCharAt8 >= '0' && cCharAt8 <= '9') {
                    i6 = cCharAt8 - '0';
                } else if (cCharAt8 >= 'a' && cCharAt8 <= 'f') {
                    i6 = cCharAt8 - 'W';
                } else {
                    if (cCharAt8 < 'A' || cCharAt8 > 'F') {
                        this.matchStat = -2;
                        return null;
                    }
                    i6 = cCharAt8 - '7';
                }
                j8 = (j8 << 4) | i6;
                i25++;
            }
            int i27 = 16;
            long j9 = 0;
            for (int i28 = 32; i27 < i28; i28 = 32) {
                char cCharAt9 = charAt(length2 + i27);
                if (cCharAt9 >= '0' && cCharAt9 <= '9') {
                    i5 = cCharAt9 - '0';
                } else if (cCharAt9 >= 'a' && cCharAt9 <= 'f') {
                    i5 = cCharAt9 - 'W';
                } else {
                    if (cCharAt9 < 'A' || cCharAt9 > 'F') {
                        this.matchStat = -2;
                        return null;
                    }
                    i5 = cCharAt9 - '7';
                    j9 = (j9 << 4) | i5;
                    i27++;
                }
                j9 = (j9 << 4) | i5;
                i27++;
            }
            uuid = new UUID(j8, j9);
            int i29 = this.bp;
            int length4 = (iIndexOf - ((cArr.length + i29) + 1)) + 1 + i12;
            i4 = length4 + 1;
            cCharAt = charAt(i29 + length4);
        }
        if (cCharAt == ',') {
            int i30 = this.bp + i4;
            this.bp = i30;
            this.f4610ch = charAt(i30);
            this.matchStat = 3;
            return uuid;
        }
        if (cCharAt != '}') {
            this.matchStat = -1;
            return null;
        }
        int i31 = i4 + 1;
        char cCharAt10 = charAt(this.bp + i4);
        if (cCharAt10 == ',') {
            this.token = 16;
            int i32 = this.bp + i31;
            this.bp = i32;
            this.f4610ch = charAt(i32);
        } else if (cCharAt10 == ']') {
            this.token = 15;
            int i33 = this.bp + i31;
            this.bp = i33;
            this.f4610ch = charAt(i33);
        } else if (cCharAt10 == '}') {
            this.token = 13;
            int i34 = this.bp + i31;
            this.bp = i34;
            this.f4610ch = charAt(i34);
        } else {
            if (cCharAt10 != 26) {
                this.matchStat = -1;
                return null;
            }
            this.token = 20;
            this.bp += i4;
            this.f4610ch = JSONLexer.EOI;
        }
        this.matchStat = 4;
        return uuid;
    }

    /* JADX WARN: Removed duplicated region for block: B:54:0x00c3 A[ADDED_TO_REGION] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:55:0x00c5 -> B:51:0x00b4). Please report as a decompilation issue!!! */
    @Override // com.alibaba.fastjson.parser.JSONLexer
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final float scanFloat(char r22) throws java.lang.NumberFormatException {
        /*
            Method dump skipped, instructions count: 426
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.JSONLexerBase.scanFloat(char):float");
    }

    public final void scanHex() {
        char next;
        if (this.f4610ch != 'x') {
            throw new JSONException("illegal state. " + this.f4610ch);
        }
        next();
        if (this.f4610ch != '\'') {
            throw new JSONException("illegal state. " + this.f4610ch);
        }
        this.np = this.bp;
        next();
        while (true) {
            next = next();
            if ((next < '0' || next > '9') && (next < 'A' || next > 'F')) {
                break;
            } else {
                this.sp++;
            }
        }
        if (next != '\'') {
            throw new JSONException("illegal state. " + next);
        }
        this.sp++;
        next();
        this.token = 26;
    }

    public final void scanIdent() {
        this.np = this.bp - 1;
        this.hasSpecial = false;
        do {
            this.sp++;
            next();
        } while (Character.isLetterOrDigit(this.f4610ch));
        String strStringVal = stringVal();
        if ("null".equalsIgnoreCase(strStringVal)) {
            this.token = 8;
            return;
        }
        if ("new".equals(strStringVal)) {
            this.token = 9;
            return;
        }
        if ("true".equals(strStringVal)) {
            this.token = 6;
            return;
        }
        if ("false".equals(strStringVal)) {
            this.token = 7;
            return;
        }
        if ("undefined".equals(strStringVal)) {
            this.token = 23;
            return;
        }
        if ("Set".equals(strStringVal)) {
            this.token = 21;
        } else if ("TreeSet".equals(strStringVal)) {
            this.token = 22;
        } else {
            this.token = 18;
        }
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public int scanInt(char c4) {
        int i4;
        int i5;
        char cCharAt;
        this.matchStat = 0;
        char cCharAt2 = charAt(this.bp);
        boolean z4 = cCharAt2 == '\"';
        if (z4) {
            cCharAt2 = charAt(this.bp + 1);
            i4 = 2;
        } else {
            i4 = 1;
        }
        boolean z5 = cCharAt2 == '-';
        if (z5) {
            cCharAt2 = charAt(this.bp + i4);
            i4++;
        }
        if (cCharAt2 >= '0' && cCharAt2 <= '9') {
            int i6 = cCharAt2 - '0';
            while (true) {
                i5 = i4 + 1;
                cCharAt = charAt(this.bp + i4);
                if (cCharAt < '0' || cCharAt > '9') {
                    break;
                }
                i6 = (i6 * 10) + (cCharAt - '0');
                i4 = i5;
            }
            if (cCharAt == '.') {
                this.matchStat = -1;
                return 0;
            }
            if (i6 < 0) {
                this.matchStat = -1;
                return 0;
            }
            while (cCharAt != c4) {
                if (!isWhitespace(cCharAt)) {
                    this.matchStat = -1;
                    return z5 ? -i6 : i6;
                }
                char cCharAt3 = charAt(this.bp + i5);
                i5++;
                cCharAt = cCharAt3;
            }
            int i7 = this.bp + i5;
            this.bp = i7;
            this.f4610ch = charAt(i7);
            this.matchStat = 3;
            this.token = 16;
            return z5 ? -i6 : i6;
        }
        if (cCharAt2 != 'n' || charAt(this.bp + i4) != 'u' || AbstractC0351g.b(this.bp, i4, 1, this) != 'l' || AbstractC0351g.b(this.bp, i4, 2, this) != 'l') {
            this.matchStat = -1;
            return 0;
        }
        this.matchStat = 5;
        int i8 = i4 + 4;
        char cCharAt4 = charAt(this.bp + i4 + 3);
        if (z4 && cCharAt4 == '\"') {
            cCharAt4 = charAt(this.bp + i8);
            i8 = i4 + 5;
        }
        while (cCharAt4 != ',') {
            if (cCharAt4 == ']') {
                int i9 = this.bp + i8;
                this.bp = i9;
                this.f4610ch = charAt(i9);
                this.matchStat = 5;
                this.token = 15;
                return 0;
            }
            if (!isWhitespace(cCharAt4)) {
                this.matchStat = -1;
                return 0;
            }
            cCharAt4 = charAt(this.bp + i8);
            i8++;
        }
        int i10 = this.bp + i8;
        this.bp = i10;
        this.f4610ch = charAt(i10);
        this.matchStat = 5;
        this.token = 16;
        return 0;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public long scanLong(char c4) {
        int i4;
        int i5;
        char cCharAt;
        char c5;
        this.matchStat = 0;
        char cCharAt2 = charAt(this.bp);
        boolean z4 = cCharAt2 == '\"';
        if (z4) {
            cCharAt2 = charAt(this.bp + 1);
            i4 = 2;
        } else {
            i4 = 1;
        }
        boolean z5 = cCharAt2 == '-';
        if (z5) {
            cCharAt2 = charAt(this.bp + i4);
            i4++;
        }
        if (cCharAt2 >= '0') {
            char c6 = '9';
            if (cCharAt2 <= '9') {
                long j4 = cCharAt2 - '0';
                while (true) {
                    i5 = i4 + 1;
                    cCharAt = charAt(this.bp + i4);
                    if (cCharAt < '0' || cCharAt > c6) {
                        break;
                    }
                    j4 = (j4 * 10) + (cCharAt - '0');
                    i4 = i5;
                    c6 = '9';
                }
                if (cCharAt == '.') {
                    this.matchStat = -1;
                    return 0L;
                }
                if (j4 < 0 && (j4 != Long.MIN_VALUE || !z5)) {
                    throw new NumberFormatException(subString(this.bp, i4));
                }
                if (!z4) {
                    c5 = c4;
                } else {
                    if (cCharAt != '\"') {
                        this.matchStat = -1;
                        return 0L;
                    }
                    cCharAt = charAt(this.bp + i5);
                    c5 = c4;
                    i5 = i4 + 2;
                }
                while (cCharAt != c5) {
                    if (!isWhitespace(cCharAt)) {
                        this.matchStat = -1;
                        return j4;
                    }
                    cCharAt = charAt(this.bp + i5);
                    i5++;
                }
                int i6 = this.bp + i5;
                this.bp = i6;
                this.f4610ch = charAt(i6);
                this.matchStat = 3;
                this.token = 16;
                return z5 ? -j4 : j4;
            }
        }
        if (cCharAt2 != 'n' || charAt(this.bp + i4) != 'u' || AbstractC0351g.b(this.bp, i4, 1, this) != 'l' || AbstractC0351g.b(this.bp, i4, 2, this) != 'l') {
            this.matchStat = -1;
            return 0L;
        }
        this.matchStat = 5;
        int i7 = i4 + 4;
        char cCharAt3 = charAt(this.bp + i4 + 3);
        if (z4 && cCharAt3 == '\"') {
            cCharAt3 = charAt(this.bp + i7);
            i7 = i4 + 5;
        }
        while (cCharAt3 != ',') {
            if (cCharAt3 == ']') {
                int i8 = this.bp + i7;
                this.bp = i8;
                this.f4610ch = charAt(i8);
                this.matchStat = 5;
                this.token = 15;
                return 0L;
            }
            if (!isWhitespace(cCharAt3)) {
                this.matchStat = -1;
                return 0L;
            }
            cCharAt3 = charAt(this.bp + i7);
            i7++;
        }
        int i9 = this.bp + i7;
        this.bp = i9;
        this.f4610ch = charAt(i9);
        this.matchStat = 5;
        this.token = 16;
        return 0L;
    }

    public final void scanNullOrNew() {
        if (this.f4610ch != 'n') {
            throw new JSONException("error parse null or new");
        }
        next();
        char c4 = this.f4610ch;
        if (c4 != 'u') {
            if (c4 != 'e') {
                throw new JSONException("error parse new");
            }
            next();
            if (this.f4610ch != 'w') {
                throw new JSONException("error parse new");
            }
            next();
            char c5 = this.f4610ch;
            if (c5 != ' ' && c5 != ',' && c5 != '}' && c5 != ']' && c5 != '\n' && c5 != '\r' && c5 != '\t' && c5 != 26 && c5 != '\f' && c5 != '\b') {
                throw new JSONException("scan new error");
            }
            this.token = 9;
            return;
        }
        next();
        if (this.f4610ch != 'l') {
            throw new JSONException("error parse null");
        }
        next();
        if (this.f4610ch != 'l') {
            throw new JSONException("error parse null");
        }
        next();
        char c6 = this.f4610ch;
        if (c6 != ' ' && c6 != ',' && c6 != '}' && c6 != ']' && c6 != '\n' && c6 != '\r' && c6 != '\t' && c6 != 26 && c6 != '\f' && c6 != '\b') {
            throw new JSONException("scan null error");
        }
        this.token = 8;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public final void scanNumber() {
        char c4;
        boolean z4;
        char c5;
        this.np = this.bp;
        if (this.f4610ch == '-') {
            this.sp++;
            next();
        }
        while (true) {
            c4 = this.f4610ch;
            if (c4 < '0' || c4 > '9') {
                break;
            }
            this.sp++;
            next();
        }
        if (c4 == '.') {
            this.sp++;
            next();
            while (true) {
                char c6 = this.f4610ch;
                if (c6 < '0' || c6 > '9') {
                    break;
                }
                this.sp++;
                next();
            }
            z4 = true;
        } else {
            z4 = false;
        }
        char c7 = this.f4610ch;
        if (c7 != 'L' && c7 != 'S' && c7 != 'B') {
            if (c7 == 'F' || c7 == 'D') {
                this.sp++;
                next();
            } else if (c7 == 'e' || c7 == 'E') {
                this.sp++;
                next();
                char c8 = this.f4610ch;
                if (c8 == '+' || c8 == '-') {
                    this.sp++;
                    next();
                }
                while (true) {
                    c5 = this.f4610ch;
                    if (c5 < '0' || c5 > '9') {
                        break;
                    }
                    this.sp++;
                    next();
                }
                if (c5 == 'D' || c5 == 'F') {
                    this.sp++;
                    next();
                }
            }
            this.token = 3;
        }
        this.sp++;
        next();
        if (!z4) {
            this.token = 2;
            return;
        }
        this.token = 3;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public final void scanString() {
        this.np = this.bp;
        this.hasSpecial = false;
        while (true) {
            char next = next();
            if (next == '\"') {
                this.token = 4;
                this.f4610ch = next();
                return;
            }
            if (next == 26) {
                if (isEOF()) {
                    throw new JSONException("unclosed string : " + next);
                }
                putChar(JSONLexer.EOI);
            } else if (next == '\\') {
                if (!this.hasSpecial) {
                    this.hasSpecial = true;
                    int i4 = this.sp;
                    char[] cArr = this.sbuf;
                    if (i4 >= cArr.length) {
                        int length = cArr.length * 2;
                        if (i4 <= length) {
                            i4 = length;
                        }
                        char[] cArr2 = new char[i4];
                        System.arraycopy(cArr, 0, cArr2, 0, cArr.length);
                        this.sbuf = cArr2;
                    }
                    copyTo(this.np + 1, this.sp, this.sbuf);
                }
                char next2 = next();
                if (next2 == '\"') {
                    putChar('\"');
                } else if (next2 != '\'') {
                    if (next2 != 'F') {
                        if (next2 == '\\') {
                            putChar(CoreConstants.ESCAPE_CHAR);
                        } else if (next2 == 'b') {
                            putChar('\b');
                        } else if (next2 != 'f') {
                            if (next2 == 'n') {
                                putChar('\n');
                            } else if (next2 == 'r') {
                                putChar('\r');
                            } else if (next2 != 'x') {
                                switch (next2) {
                                    case '/':
                                        putChar('/');
                                        break;
                                    case '0':
                                        putChar((char) 0);
                                        break;
                                    case '1':
                                        putChar((char) 1);
                                        break;
                                    case '2':
                                        putChar((char) 2);
                                        break;
                                    case '3':
                                        putChar((char) 3);
                                        break;
                                    case '4':
                                        putChar((char) 4);
                                        break;
                                    case '5':
                                        putChar((char) 5);
                                        break;
                                    case '6':
                                        putChar((char) 6);
                                        break;
                                    case '7':
                                        putChar((char) 7);
                                        break;
                                    default:
                                        switch (next2) {
                                            case 't':
                                                putChar('\t');
                                                break;
                                            case 'u':
                                                putChar((char) Integer.parseInt(new String(new char[]{next(), next(), next(), next()}), 16));
                                                break;
                                            case 'v':
                                                putChar((char) 11);
                                                break;
                                            default:
                                                this.f4610ch = next2;
                                                throw new JSONException("unclosed string : " + next2);
                                        }
                                }
                            } else {
                                char next3 = next();
                                char next4 = next();
                                int[] iArr = digits;
                                putChar((char) ((iArr[next3] * 16) + iArr[next4]));
                            }
                        }
                    }
                    putChar('\f');
                } else {
                    putChar('\'');
                }
            } else if (this.hasSpecial) {
                int i5 = this.sp;
                char[] cArr3 = this.sbuf;
                if (i5 == cArr3.length) {
                    putChar(next);
                } else {
                    this.sp = i5 + 1;
                    cArr3[i5] = next;
                }
            } else {
                this.sp++;
            }
        }
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public void scanStringArray(Collection<String> collection, char c4) {
        int i4;
        char cCharAt;
        int i5;
        char cCharAt2;
        this.matchStat = 0;
        char cCharAt3 = charAt(this.bp);
        char c5 = 'u';
        char c6 = 'l';
        int i6 = 2;
        if (cCharAt3 == 'n' && charAt(this.bp + 1) == 'u' && charAt(this.bp + 2) == 'l' && charAt(this.bp + 3) == 'l' && charAt(this.bp + 4) == c4) {
            int i7 = this.bp + 5;
            this.bp = i7;
            this.f4610ch = charAt(i7);
            this.matchStat = 5;
            return;
        }
        if (cCharAt3 != '[') {
            this.matchStat = -1;
            return;
        }
        char cCharAt4 = charAt(this.bp + 1);
        int i8 = 2;
        while (true) {
            if (cCharAt4 == 'n' && charAt(this.bp + i8) == c5 && AbstractC0351g.b(this.bp, i8, 1, this) == c6 && AbstractC0351g.b(this.bp, i8, i6, this) == c6) {
                int i9 = i8 + 3;
                i4 = i8 + 4;
                cCharAt = charAt(this.bp + i9);
                collection.add(null);
            } else {
                if (cCharAt4 == ']' && collection.size() == 0) {
                    i5 = i8 + 1;
                    cCharAt2 = charAt(this.bp + i8);
                    break;
                }
                if (cCharAt4 != '\"') {
                    this.matchStat = -1;
                    return;
                }
                int i10 = this.bp + i8;
                int iIndexOf = indexOf('\"', i10);
                if (iIndexOf == -1) {
                    throw new JSONException("unclosed str");
                }
                String strSubString = subString(this.bp + i8, iIndexOf - i10);
                if (strSubString.indexOf(92) != -1) {
                    while (true) {
                        int i11 = 0;
                        for (int i12 = iIndexOf - 1; i12 >= 0 && charAt(i12) == '\\'; i12--) {
                            i11++;
                        }
                        if (i11 % 2 == 0) {
                            break;
                        } else {
                            iIndexOf = indexOf('\"', iIndexOf + 1);
                        }
                    }
                    int i13 = iIndexOf - i10;
                    strSubString = readString(sub_chars(this.bp + i8, i13), i13);
                }
                int i14 = this.bp;
                int i15 = (iIndexOf - (i14 + i8)) + 1 + i8;
                i4 = i15 + 1;
                cCharAt = charAt(i14 + i15);
                collection.add(strSubString);
            }
            if (cCharAt == ',') {
                char cCharAt5 = charAt(this.bp + i4);
                i8 = i4 + 1;
                c5 = 'u';
                c6 = 'l';
                i6 = 2;
                cCharAt4 = cCharAt5;
            } else if (cCharAt != ']') {
                this.matchStat = -1;
                return;
            } else {
                i5 = i4 + 1;
                cCharAt2 = charAt(this.bp + i4);
            }
        }
        if (cCharAt2 != c4) {
            this.matchStat = -1;
            return;
        }
        int i16 = this.bp + i5;
        this.bp = i16;
        this.f4610ch = charAt(i16);
        this.matchStat = 3;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public final String scanSymbol(SymbolTable symbolTable) {
        skipWhitespace();
        char c4 = this.f4610ch;
        if (c4 == '\"') {
            return scanSymbol(symbolTable, '\"');
        }
        if (c4 == '\'') {
            if (isEnabled(Feature.AllowSingleQuotes)) {
                return scanSymbol(symbolTable, '\'');
            }
            throw new JSONException("syntax error");
        }
        if (c4 == '}') {
            next();
            this.token = 13;
            return null;
        }
        if (c4 == ',') {
            next();
            this.token = 16;
            return null;
        }
        if (c4 == 26) {
            this.token = 20;
            return null;
        }
        if (isEnabled(Feature.AllowUnQuotedFieldNames)) {
            return scanSymbolUnQuoted(symbolTable);
        }
        throw new JSONException("syntax error");
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public final String scanSymbolUnQuoted(SymbolTable symbolTable) {
        if (this.token == 1 && this.pos == 0 && this.bp == 1) {
            this.bp = 0;
        }
        boolean[] zArr = IOUtils.firstIdentifierFlags;
        int i4 = this.f4610ch;
        if (i4 < zArr.length && !zArr[i4]) {
            throw new JSONException("illegal identifier : " + this.f4610ch + info());
        }
        boolean[] zArr2 = IOUtils.identifierFlags;
        this.np = this.bp;
        this.sp = 1;
        while (true) {
            char next = next();
            if (next < zArr2.length && !zArr2[next]) {
                break;
            }
            i4 = (i4 * 31) + next;
            this.sp++;
        }
        this.f4610ch = charAt(this.bp);
        this.token = 18;
        if (this.sp == 4 && i4 == 3392903 && charAt(this.np) == 'n' && charAt(this.np + 1) == 'u' && charAt(this.np + 2) == 'l' && charAt(this.np + 3) == 'l') {
            return null;
        }
        return symbolTable == null ? subString(this.np, this.sp) : addSymbol(this.np, this.sp, i4, symbolTable);
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public String scanSymbolWithSeperator(SymbolTable symbolTable, char c4) {
        int i4 = 0;
        this.matchStat = 0;
        char cCharAt = charAt(this.bp);
        if (cCharAt == 'n') {
            if (charAt(this.bp + 1) != 'u' || charAt(this.bp + 2) != 'l' || charAt(this.bp + 3) != 'l') {
                this.matchStat = -1;
                return null;
            }
            if (charAt(this.bp + 4) != c4) {
                this.matchStat = -1;
                return null;
            }
            int i5 = this.bp + 5;
            this.bp = i5;
            this.f4610ch = charAt(i5);
            this.matchStat = 3;
            return null;
        }
        if (cCharAt != '\"') {
            this.matchStat = -1;
            return null;
        }
        int i6 = 1;
        while (true) {
            int i7 = i6 + 1;
            char cCharAt2 = charAt(this.bp + i6);
            if (cCharAt2 == '\"') {
                int i8 = this.bp;
                int i9 = i8 + 1;
                String strAddSymbol = addSymbol(i9, g.e(i8, i7, i9, 1), i4, symbolTable);
                int i10 = i6 + 2;
                char cCharAt3 = charAt(this.bp + i7);
                while (cCharAt3 != c4) {
                    if (!isWhitespace(cCharAt3)) {
                        this.matchStat = -1;
                        return strAddSymbol;
                    }
                    cCharAt3 = charAt(this.bp + i10);
                    i10++;
                }
                int i11 = this.bp + i10;
                this.bp = i11;
                this.f4610ch = charAt(i11);
                this.matchStat = 3;
                return strAddSymbol;
            }
            i4 = (i4 * 31) + cCharAt2;
            if (cCharAt2 == '\\') {
                this.matchStat = -1;
                return null;
            }
            i6 = i7;
        }
    }

    public final void scanTrue() {
        if (this.f4610ch != 't') {
            throw new JSONException("error parse true");
        }
        next();
        if (this.f4610ch != 'r') {
            throw new JSONException("error parse true");
        }
        next();
        if (this.f4610ch != 'u') {
            throw new JSONException("error parse true");
        }
        next();
        if (this.f4610ch != 'e') {
            throw new JSONException("error parse true");
        }
        next();
        char c4 = this.f4610ch;
        if (c4 != ' ' && c4 != ',' && c4 != '}' && c4 != ']' && c4 != '\n' && c4 != '\r' && c4 != '\t' && c4 != 26 && c4 != '\f' && c4 != '\b' && c4 != ':' && c4 != '/') {
            throw new JSONException("scan true error");
        }
        this.token = 6;
    }

    public final int scanType(String str) {
        int i4;
        this.matchStat = 0;
        char[] cArr = typeFieldName;
        if (!charArrayCompare(cArr)) {
            return -2;
        }
        int length = this.bp + cArr.length;
        int length2 = str.length();
        for (int i5 = 0; i5 < length2; i5++) {
            if (str.charAt(i5) != charAt(length + i5)) {
                return -1;
            }
        }
        int i6 = length + length2;
        if (charAt(i6) != '\"') {
            return -1;
        }
        int i7 = i6 + 1;
        char cCharAt = charAt(i7);
        this.f4610ch = cCharAt;
        if (cCharAt == ',') {
            int i8 = i6 + 2;
            this.f4610ch = charAt(i8);
            this.bp = i8;
            this.token = 16;
            return 3;
        }
        if (cCharAt == '}') {
            i7 = i6 + 2;
            char cCharAt2 = charAt(i7);
            this.f4610ch = cCharAt2;
            if (cCharAt2 == ',') {
                this.token = 16;
                i4 = i6 + 3;
                this.f4610ch = charAt(i4);
            } else if (cCharAt2 == ']') {
                this.token = 15;
                i4 = i6 + 3;
                this.f4610ch = charAt(i4);
            } else if (cCharAt2 == '}') {
                this.token = 13;
                i4 = i6 + 3;
                this.f4610ch = charAt(i4);
            } else {
                if (cCharAt2 != 26) {
                    return -1;
                }
                this.token = 20;
                this.matchStat = 4;
            }
            i7 = i4;
            this.matchStat = 4;
        }
        this.bp = i7;
        return this.matchStat;
    }

    public UUID scanUUID(char c4) {
        char cCharAt;
        int i4;
        UUID uuid;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        this.matchStat = 0;
        char cCharAt2 = charAt(this.bp);
        if (cCharAt2 == '\"') {
            int iIndexOf = indexOf('\"', this.bp + 1);
            if (iIndexOf == -1) {
                throw new JSONException("unclosed str");
            }
            int i12 = this.bp + 1;
            int i13 = iIndexOf - i12;
            char c5 = 'A';
            char c6 = 'f';
            char c7 = 'a';
            char c8 = '9';
            if (i13 == 36) {
                int i14 = 0;
                long j4 = 0;
                while (i14 < 8) {
                    char cCharAt3 = charAt(i12 + i14);
                    if (cCharAt3 >= '0' && cCharAt3 <= '9') {
                        i11 = cCharAt3 - '0';
                    } else if (cCharAt3 >= 'a' && cCharAt3 <= 'f') {
                        i11 = cCharAt3 - 'W';
                    } else {
                        if (cCharAt3 < c5 || cCharAt3 > 'F') {
                            this.matchStat = -2;
                            return null;
                        }
                        i11 = cCharAt3 - '7';
                    }
                    j4 = (j4 << 4) | i11;
                    i14++;
                    iIndexOf = iIndexOf;
                    c5 = 'A';
                }
                int i15 = iIndexOf;
                int i16 = 9;
                while (i16 < 13) {
                    char cCharAt4 = charAt(i12 + i16);
                    if (cCharAt4 >= '0' && cCharAt4 <= '9') {
                        i10 = cCharAt4 - '0';
                    } else if (cCharAt4 >= 'a' && cCharAt4 <= c6) {
                        i10 = cCharAt4 - 'W';
                    } else {
                        if (cCharAt4 < 'A' || cCharAt4 > 'F') {
                            this.matchStat = -2;
                            return null;
                        }
                        i10 = cCharAt4 - '7';
                    }
                    j4 = (j4 << 4) | i10;
                    i16++;
                    c6 = 'f';
                }
                int i17 = 14;
                long j5 = j4;
                while (i17 < 18) {
                    char cCharAt5 = charAt(i12 + i17);
                    if (cCharAt5 >= '0' && cCharAt5 <= c8) {
                        i9 = cCharAt5 - '0';
                    } else if (cCharAt5 >= 'a' && cCharAt5 <= 'f') {
                        i9 = cCharAt5 - 'W';
                    } else {
                        if (cCharAt5 < 'A' || cCharAt5 > 'F') {
                            this.matchStat = -2;
                            return null;
                        }
                        i9 = cCharAt5 - '7';
                    }
                    j5 = (j5 << 4) | i9;
                    i17++;
                    c8 = '9';
                }
                int i18 = 19;
                long j6 = 0;
                while (i18 < 23) {
                    char cCharAt6 = charAt(i12 + i18);
                    if (cCharAt6 >= '0' && cCharAt6 <= '9') {
                        i8 = cCharAt6 - '0';
                    } else if (cCharAt6 >= c7 && cCharAt6 <= 'f') {
                        i8 = cCharAt6 - 'W';
                    } else {
                        if (cCharAt6 < 'A' || cCharAt6 > 'F') {
                            this.matchStat = -2;
                            return null;
                        }
                        i8 = cCharAt6 - '7';
                    }
                    j6 = (j6 << 4) | i8;
                    i18++;
                    c7 = 'a';
                }
                long j7 = j6;
                for (int i19 = 24; i19 < 36; i19++) {
                    char cCharAt7 = charAt(i12 + i19);
                    if (cCharAt7 >= '0' && cCharAt7 <= '9') {
                        i7 = cCharAt7 - '0';
                    } else if (cCharAt7 >= 'a' && cCharAt7 <= 'f') {
                        i7 = cCharAt7 - 'W';
                    } else {
                        if (cCharAt7 < 'A' || cCharAt7 > 'F') {
                            this.matchStat = -2;
                            return null;
                        }
                        i7 = cCharAt7 - '7';
                    }
                    j7 = (j7 << 4) | i7;
                }
                uuid = new UUID(j5, j7);
                int i20 = this.bp;
                int i21 = i15 - (i20 + 1);
                int i22 = i21 + 2;
                i4 = i21 + 3;
                cCharAt = charAt(i20 + i22);
            } else {
                if (i13 != 32) {
                    this.matchStat = -1;
                    return null;
                }
                int i23 = 0;
                long j8 = 0;
                for (int i24 = 16; i23 < i24; i24 = 16) {
                    char cCharAt8 = charAt(i12 + i23);
                    if (cCharAt8 >= '0' && cCharAt8 <= '9') {
                        i6 = cCharAt8 - '0';
                    } else if (cCharAt8 >= 'a' && cCharAt8 <= 'f') {
                        i6 = cCharAt8 - 'W';
                    } else {
                        if (cCharAt8 < 'A' || cCharAt8 > 'F') {
                            this.matchStat = -2;
                            return null;
                        }
                        i6 = cCharAt8 - '7';
                    }
                    j8 = (j8 << 4) | i6;
                    i23++;
                }
                int i25 = 16;
                long j9 = 0;
                for (int i26 = 32; i25 < i26; i26 = 32) {
                    char cCharAt9 = charAt(i12 + i25);
                    if (cCharAt9 >= '0' && cCharAt9 <= '9') {
                        i5 = cCharAt9 - '0';
                    } else if (cCharAt9 >= 'a' && cCharAt9 <= 'f') {
                        i5 = cCharAt9 - 'W';
                    } else {
                        if (cCharAt9 < 'A' || cCharAt9 > 'F') {
                            this.matchStat = -2;
                            return null;
                        }
                        i5 = cCharAt9 - '7';
                        j9 = (j9 << 4) | i5;
                        i25++;
                    }
                    j9 = (j9 << 4) | i5;
                    i25++;
                }
                uuid = new UUID(j8, j9);
                int i27 = this.bp;
                int i28 = iIndexOf - (i27 + 1);
                int i29 = i28 + 2;
                i4 = i28 + 3;
                cCharAt = charAt(i27 + i29);
            }
        } else {
            if (cCharAt2 != 'n' || charAt(this.bp + 1) != 'u' || charAt(this.bp + 2) != 'l' || charAt(this.bp + 3) != 'l') {
                this.matchStat = -1;
                return null;
            }
            cCharAt = charAt(this.bp + 4);
            i4 = 5;
            uuid = null;
        }
        if (cCharAt == ',') {
            int i30 = this.bp + i4;
            this.bp = i30;
            this.f4610ch = charAt(i30);
            this.matchStat = 3;
            return uuid;
        }
        if (cCharAt != ']') {
            this.matchStat = -1;
            return null;
        }
        int i31 = i4 + 1;
        char cCharAt10 = charAt(this.bp + i4);
        if (cCharAt10 == ',') {
            this.token = 16;
            int i32 = this.bp + i31;
            this.bp = i32;
            this.f4610ch = charAt(i32);
        } else if (cCharAt10 == ']') {
            this.token = 15;
            int i33 = this.bp + i31;
            this.bp = i33;
            this.f4610ch = charAt(i33);
        } else if (cCharAt10 == '}') {
            this.token = 13;
            int i34 = this.bp + i31;
            this.bp = i34;
            this.f4610ch = charAt(i34);
        } else {
            if (cCharAt10 != 26) {
                this.matchStat = -1;
                return null;
            }
            this.token = 20;
            this.bp += i4;
            this.f4610ch = JSONLexer.EOI;
        }
        this.matchStat = 4;
        return uuid;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public void setLocale(Locale locale) {
        this.locale = locale;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public void setTimeZone(TimeZone timeZone) {
        this.timeZone = timeZone;
    }

    public void setToken(int i4) {
        this.token = i4;
    }

    public void skipComment() {
        char c4;
        next();
        char c5 = this.f4610ch;
        if (c5 == '/') {
            do {
                next();
                c4 = this.f4610ch;
                if (c4 == '\n') {
                    next();
                    return;
                }
            } while (c4 != 26);
            return;
        }
        if (c5 != '*') {
            throw new JSONException("invalid comment");
        }
        next();
        while (true) {
            char c6 = this.f4610ch;
            if (c6 == 26) {
                return;
            }
            if (c6 == '*') {
                next();
                if (this.f4610ch == '/') {
                    next();
                    return;
                }
            } else {
                next();
            }
        }
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public final void skipWhitespace() {
        while (true) {
            char c4 = this.f4610ch;
            if (c4 > '/') {
                return;
            }
            if (c4 == ' ' || c4 == '\r' || c4 == '\n' || c4 == '\t' || c4 == '\f' || c4 == '\b') {
                next();
            } else if (c4 != '/') {
                return;
            } else {
                skipComment();
            }
        }
    }

    public final String stringDefaultValue() {
        return this.stringDefaultValue;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public abstract String stringVal();

    public abstract String subString(int i4, int i5);

    public abstract char[] sub_chars(int i4, int i5);

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public final int token() {
        return this.token;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public final String tokenName() {
        return JSONToken.name(this.token);
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public final boolean isEnabled(int i4) {
        return (this.features & i4) != 0;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public final void nextTokenWithColon(int i4) {
        nextTokenWithChar(CoreConstants.COLON_CHAR);
    }

    public final boolean isEnabled(int i4, int i5) {
        return ((this.features & i5) == 0 && (i4 & i5) == 0) ? false : true;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public final String scanSymbol(SymbolTable symbolTable, char c4) throws NumberFormatException {
        String strAddSymbol;
        this.np = this.bp;
        this.sp = 0;
        boolean z4 = false;
        int i4 = 0;
        while (true) {
            char next = next();
            if (next == c4) {
                this.token = 4;
                if (!z4) {
                    int i5 = this.np;
                    strAddSymbol = addSymbol(i5 == -1 ? 0 : i5 + 1, this.sp, i4, symbolTable);
                } else {
                    strAddSymbol = symbolTable.addSymbol(this.sbuf, 0, this.sp, i4);
                }
                this.sp = 0;
                next();
                return strAddSymbol;
            }
            if (next == 26) {
                throw new JSONException("unclosed.str");
            }
            if (next == '\\') {
                if (!z4) {
                    int i6 = this.sp;
                    char[] cArr = this.sbuf;
                    if (i6 >= cArr.length) {
                        int length = cArr.length * 2;
                        if (i6 <= length) {
                            i6 = length;
                        }
                        char[] cArr2 = new char[i6];
                        System.arraycopy(cArr, 0, cArr2, 0, cArr.length);
                        this.sbuf = cArr2;
                    }
                    arrayCopy(this.np + 1, this.sbuf, 0, this.sp);
                    z4 = true;
                }
                char next2 = next();
                if (next2 == '\"') {
                    i4 = (i4 * 31) + 34;
                    putChar('\"');
                } else if (next2 != '\'') {
                    if (next2 != 'F') {
                        if (next2 == '\\') {
                            i4 = (i4 * 31) + 92;
                            putChar(CoreConstants.ESCAPE_CHAR);
                        } else if (next2 == 'b') {
                            i4 = (i4 * 31) + 8;
                            putChar('\b');
                        } else if (next2 != 'f') {
                            if (next2 == 'n') {
                                i4 = (i4 * 31) + 10;
                                putChar('\n');
                            } else if (next2 == 'r') {
                                i4 = (i4 * 31) + 13;
                                putChar('\r');
                            } else if (next2 != 'x') {
                                switch (next2) {
                                    case '/':
                                        i4 = (i4 * 31) + 47;
                                        putChar('/');
                                        break;
                                    case '0':
                                        i4 = (i4 * 31) + next2;
                                        putChar((char) 0);
                                        break;
                                    case '1':
                                        i4 = (i4 * 31) + next2;
                                        putChar((char) 1);
                                        break;
                                    case '2':
                                        i4 = (i4 * 31) + next2;
                                        putChar((char) 2);
                                        break;
                                    case '3':
                                        i4 = (i4 * 31) + next2;
                                        putChar((char) 3);
                                        break;
                                    case '4':
                                        i4 = (i4 * 31) + next2;
                                        putChar((char) 4);
                                        break;
                                    case '5':
                                        i4 = (i4 * 31) + next2;
                                        putChar((char) 5);
                                        break;
                                    case '6':
                                        i4 = (i4 * 31) + next2;
                                        putChar((char) 6);
                                        break;
                                    case '7':
                                        i4 = (i4 * 31) + next2;
                                        putChar((char) 7);
                                        break;
                                    default:
                                        switch (next2) {
                                            case 't':
                                                i4 = (i4 * 31) + 9;
                                                putChar('\t');
                                                break;
                                            case 'u':
                                                int i7 = Integer.parseInt(new String(new char[]{next(), next(), next(), next()}), 16);
                                                i4 = (i4 * 31) + i7;
                                                putChar((char) i7);
                                                break;
                                            case 'v':
                                                i4 = (i4 * 31) + 11;
                                                putChar((char) 11);
                                                break;
                                            default:
                                                this.f4610ch = next2;
                                                throw new JSONException("unclosed.str.lit");
                                        }
                                }
                            } else {
                                char next3 = next();
                                this.f4610ch = next3;
                                char next4 = next();
                                this.f4610ch = next4;
                                int[] iArr = digits;
                                char c5 = (char) ((iArr[next3] * 16) + iArr[next4]);
                                i4 = (i4 * 31) + c5;
                                putChar(c5);
                            }
                        }
                    }
                    i4 = (i4 * 31) + 12;
                    putChar('\f');
                } else {
                    i4 = (i4 * 31) + 39;
                    putChar('\'');
                }
            } else {
                i4 = (i4 * 31) + next;
                if (!z4) {
                    this.sp++;
                } else {
                    int i8 = this.sp;
                    char[] cArr3 = this.sbuf;
                    if (i8 == cArr3.length) {
                        putChar(next);
                    } else {
                        this.sp = i8 + 1;
                        cArr3[i8] = next;
                    }
                }
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:103:0x0073 A[SYNTHETIC] */
    @Override // com.alibaba.fastjson.parser.JSONLexer
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void nextToken(int r10) {
        /*
            Method dump skipped, instructions count: 262
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.JSONLexerBase.nextToken(int):void");
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public String scanString(char c4) {
        this.matchStat = 0;
        char cCharAt = charAt(this.bp);
        if (cCharAt == 'n') {
            if (charAt(this.bp + 1) == 'u' && charAt(this.bp + 2) == 'l' && charAt(this.bp + 3) == 'l') {
                if (charAt(this.bp + 4) == c4) {
                    int i4 = this.bp + 5;
                    this.bp = i4;
                    this.f4610ch = charAt(i4);
                    this.matchStat = 3;
                    return null;
                }
                this.matchStat = -1;
                return null;
            }
            this.matchStat = -1;
            return null;
        }
        int i5 = 1;
        while (cCharAt != '\"') {
            if (isWhitespace(cCharAt)) {
                cCharAt = charAt(this.bp + i5);
                i5++;
            } else {
                this.matchStat = -1;
                return stringDefaultValue();
            }
        }
        int i6 = this.bp + i5;
        int iIndexOf = indexOf('\"', i6);
        if (iIndexOf != -1) {
            String strSubString = subString(this.bp + i5, iIndexOf - i6);
            if (strSubString.indexOf(92) != -1) {
                while (true) {
                    int i7 = 0;
                    for (int i8 = iIndexOf - 1; i8 >= 0 && charAt(i8) == '\\'; i8--) {
                        i7++;
                    }
                    if (i7 % 2 == 0) {
                        break;
                    }
                    iIndexOf = indexOf('\"', iIndexOf + 1);
                }
                int i9 = iIndexOf - i6;
                strSubString = readString(sub_chars(this.bp + 1, i9), i9);
            }
            int i10 = (iIndexOf - i6) + 1 + i5;
            int i11 = i10 + 1;
            char cCharAt2 = charAt(this.bp + i10);
            while (cCharAt2 != c4) {
                if (isWhitespace(cCharAt2)) {
                    cCharAt2 = charAt(this.bp + i11);
                    i11++;
                } else {
                    this.matchStat = -1;
                    return strSubString;
                }
            }
            int i12 = this.bp + i11;
            this.bp = i12;
            this.f4610ch = charAt(i12);
            this.matchStat = 3;
            return strSubString;
        }
        throw new JSONException("unclosed str");
    }

    public String[] scanFieldStringArray(char[] cArr, int i4, SymbolTable symbolTable) {
        throw new UnsupportedOperationException();
    }
}
