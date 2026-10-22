package com.alibaba.fastjson.parser;

import androidx.camera.video.AudioStats;
import androidx.collection.SieveCacheKt;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.util.IOUtils;
import com.alibaba.fastjson.util.TypeUtils;
import com.bytedance.ee.bear.drive.biz.upload.filepicker.model.Symlink;
import com.bytedance.mt.protector.impl.string2number.CastDoubleProtector;
import com.bytedance.mt.protector.impl.string2number.CastFloatProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import java.io.Closeable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Locale;
import java.util.TimeZone;
import java.util.UUID;
import kotlin.text.Typography;
import org.bouncycastle.pqc.math.linearalgebra.Matrix;
import r27.a;

/* JADX INFO: loaded from: classes28.dex */
public abstract class JSONLexerBase implements JSONLexer, Closeable {
    protected static final int INT_MULTMIN_RADIX_TEN = -214748364;
    protected static final long MULTMIN_RADIX_TEN = -922337203685477580L;
    private static final ThreadLocal<char[]> SBUF_LOCAL = null;
    protected static final int[] digits = null;
    protected static final char[] typeFieldName = null;

    /* JADX INFO: renamed from: bp, reason: collision with root package name */
    protected int f24933bp;
    protected Calendar calendar;

    /* JADX INFO: renamed from: ch, reason: collision with root package name */
    protected char f24934ch;
    protected int eofPos;
    protected int features;
    protected boolean hasSpecial;
    protected Locale locale;
    public int matchStat;
    protected int nanos;

    /* JADX INFO: renamed from: np, reason: collision with root package name */
    protected int f24935np;
    protected int pos;
    protected char[] sbuf;

    /* JADX INFO: renamed from: sp, reason: collision with root package name */
    protected int f24936sp;
    protected String stringDefaultValue;
    protected TimeZone timeZone;
    protected int token;

    public static boolean isWhitespace(char r100) {
        if (r100 > ' ') goto L16;
        if (r100 != ' ') goto L6;
    L15:
        return true;
    L6:
        if (r100 == '\n') goto L15;
        if (r100 == '\r') goto L15;
        if (r100 == '\t') goto L15;
        if (r100 == '\f') goto L15;
        if (r100 == '\b') goto L15;
    L16:
        return false;
    }

    public abstract String addSymbol(int r100, int r101, int r102, SymbolTable r103);

    public abstract void arrayCopy(int r100, char[] r101, int r102, int r103);

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public abstract byte[] bytesValue();

    public abstract boolean charArrayCompare(char[] r100);

    public abstract char charAt(int r100);

    public abstract void copyTo(int r100, int r101, char[] r102);

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public abstract BigDecimal decimalValue();

    public abstract int indexOf(char r100, int r101);

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public String info() {
        return "";
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public boolean isBlankInput() {
        int r100 = 0;
    L3:
        char r101 = charAt(r100);
        if (r101 == 26) goto L5;
        if (isWhitespace(r101) == false) goto L9;
        r100 = r100 + 1;
        goto L3
    L9:
        return false;
    L5:
        this.token = 20;
        return true;
    }

    public abstract boolean isEOF();

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public abstract char next();

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public final void nextToken() {
        this.f24936sp = 0;
    L3:
        this.pos = this.f24933bp;
        char r100 = this.f24934ch;
        if (r100 == '/') goto L5;
        if (r100 == '\"') goto L8;
        if (r100 == ',') goto L12;
        if (r100 < '0') goto L21;
        if (r100 > '9') goto L21;
        scanNumber();
        return;
    L21:
        if (r100 == '-') goto L22;
        switch(r100) {
            case 8: goto L66;
            case 9: goto L66;
            case 10: goto L66;
            case 12: goto L66;
            case 13: goto L66;
            case 32: goto L66;
            case 39: goto L61;
            case 40: goto L58;
            case 41: goto L56;
            case 43: goto L54;
            case 46: goto L52;
            case 58: goto L50;
            case 59: goto L48;
            case 78: goto L46;
            case 83: goto L46;
            case 84: goto L46;
            case 91: goto L44;
            case 93: goto L42;
            case 102: goto L40;
            case 110: goto L38;
            case 116: goto L36;
            case 117: goto L46;
            case 120: goto L34;
            case 123: goto L32;
            case 125: goto L30;
            default: goto L26;
        };
    L30:
        next();
        this.token = 13;
        return;
    L32:
        next();
        this.token = 12;
        return;
    L34:
        scanHex();
        return;
    L36:
        scanTrue();
        return;
    L38:
        scanNullOrNew();
        return;
    L40:
        scanFalse();
        return;
    L42:
        next();
        this.token = 15;
        return;
    L44:
        next();
        this.token = 14;
        return;
    L46:
        scanIdent();
        return;
    L48:
        next();
        this.token = 24;
        return;
    L50:
        next();
        this.token = 17;
        return;
    L52:
        next();
        this.token = 25;
        return;
    L54:
        next();
        scanNumber();
        return;
    L56:
        next();
        this.token = 11;
        return;
    L58:
        next();
        this.token = 10;
        return;
    L61:
        if (isEnabled(Feature.AllowSingleQuotes) == false) goto L65;
        scanStringSingleQuote();
        return;
    L65:
        throw new JSONException("Feature.AllowSingleQuotes is false");
    L66:
        next();
        goto L3
    L26:
        if (isEOF() == true) goto L28;
        char r101 = this.f24934ch;
        if (r101 > 31) goto L72;
    L76:
        next();
        goto L3
    L72:
        if (r101 == 127) goto L76;
        lexError("illegal.char", new Object[]{String.valueOf(r101)});
        next();
        return;
    L28:
        if (this.token == 20) goto L68;
        this.token = 20;
        int r102 = this.f24933bp;
        this.pos = r102;
        this.eofPos = r102;
        return;
    L68:
        throw new JSONException("EOF error");
    L22:
        scanNumber();
        return;
    L12:
        next();
        this.token = 16;
        return;
    L8:
        scanString();
        return;
    L5:
        skipComment();
        goto L3
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public abstract String numberString();

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public final void resetStringPosition() {
        this.f24936sp = 0;
    }

    public final void scanNullOrNew() {
        scanNullOrNew(true);
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public String scanTypeName(SymbolTable r100) {
        return null;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public abstract String stringVal();

    public abstract String subString(int r100, int r101);

    public abstract char[] sub_chars(int r100, int r101);

    static {
        SBUF_LOCAL = new ThreadLocal();
        typeFieldName = ("\"" + JSON.DEFAULT_TYPE_KEY + "\":\"").toCharArray();
        digits = new int[103];
        int r100 = 48;
    L4:
        if (r100 > 57) goto L6;
        digits[r100] = r100 - 48;
        r100 = r100 + 1;
        goto L4
    L6:
        int r101 = 97;
    L8:
        if (r101 > 102) goto L10;
        digits[r101] = (r101 - 97) + 10;
        r101 = r101 + 1;
        goto L8
    L10:
        int r102 = 65;
    L12:
        if (r102 > 70) goto L14;
        digits[r102] = (r102 - 65) + 10;
        r102 = r102 + 1;
        goto L12
    }

    private void scanStringSingleQuote() {
        this.f24935np = this.f24933bp;
        this.hasSpecial = false;
    L3:
        char r100 = next();
        if (r100 == '\'') goto L5;
        if (r100 == 26) goto L10;
        boolean r101 = true;
        if (r100 == '\\') goto L17;
        if (this.hasSpecial == false) goto L86;
        int r102 = this.f24936sp;
        char[] r103 = this.sbuf;
        if (r102 == r103.length) goto L89;
        this.f24936sp = r102 + 1;
        r103[r102] = r100;
        goto L3
    L89:
        putChar(r100);
        goto L3
    L86:
        this.f24936sp++;
        goto L3
    L17:
        if (this.hasSpecial == true) goto L22;
        this.hasSpecial = true;
        int r104 = this.f24936sp;
        char[] r105 = this.sbuf;
        if (r104 <= r105.length) goto L21;
        char[] r106 = new char[r104 * 2];
        System.arraycopy(r105, 0, r106, 0, r105.length);
        this.sbuf = r106;
    L21:
        copyTo(this.f24935np + 1, this.f24936sp, this.sbuf);
    L22:
        char r107 = next();
        if (r107 != '\"') goto L24;
        putChar(Typography.quote);
        goto L3
    L24:
        if (r107 != '\'') goto L26;
        putChar('\'');
        goto L3
    L26:
        if (r107 == 'F') goto L81;
        if (r107 != '\\') goto L29;
        putChar('\\');
        goto L3
    L29:
        if (r107 != 'b') goto L31;
        putChar('\b');
        goto L3
    L31:
        if (r107 == 'f') goto L81;
        if (r107 != 'n') goto L35;
        putChar('\n');
        goto L3
    L35:
        if (r107 != 'r') goto L37;
        putChar('\r');
        goto L3
    L37:
        if (r107 != 'x') goto L39;
        char r108 = next();
        char r109 = next();
        if (r108 < '0') goto L58;
        if (r108 > '9') goto L58;
    L62:
        boolean r110 = true;
    L64:
        if (r109 < '0') goto L66;
        if (r109 > '9') goto L66;
    L72:
        if (r110 == false) goto L76;
        if (r101 == false) goto L76;
        int[] r111 = digits;
        putChar((char) ((r111[r108] * 16) + r111[r109]));
    L76:
        throw new JSONException("invalid escape character \\x" + r108 + r109);
    L66:
        if (r109 < 'a') goto L68;
        if (r109 <= 'f') goto L72;
    L68:
        if (r109 < 'A') goto L71;
        if (r109 <= 'F') goto L72;
    L71:
        r101 = false;
    L58:
        if (r108 < 'a') goto L60;
        if (r108 <= 'f') goto L62;
    L60:
        if (r108 < 'A') goto L63;
        if (r108 <= 'F') goto L62;
    L63:
        r110 = false;
        goto L64
    L39:
        switch(r107) {
            case 47: goto L54;
            case 48: goto L53;
            case 49: goto L52;
            case 50: goto L51;
            case 51: goto L50;
            case 52: goto L49;
            case 53: goto L48;
            case 54: goto L47;
            case 55: goto L46;
            default: goto L40;
        };
    L46:
        putChar(7);
        goto L3
    L47:
        putChar(6);
        goto L3
    L48:
        putChar(5);
        goto L3
    L49:
        putChar(4);
        goto L3
    L50:
        putChar(3);
        goto L3
    L51:
        putChar(2);
        goto L3
    L52:
        putChar(1);
        goto L3
    L53:
        putChar(0);
        goto L3
    L54:
        putChar('/');
        goto L3
    L40:
        switch(r107) {
            case 116: goto L45;
            case 117: goto L44;
            case 118: goto L43;
            default: goto L41;
        };
    L41:
        this.f24934ch = r107;
        throw new JSONException("unclosed single-quote string");
    L44:
        putChar((char) CastIntegerProtector.parseInt(new String(new char[]{next(), next(), next(), next()}), 16));
        goto L3
    L45:
        putChar('\t');
        goto L3
    L43:
        putChar(11);
    L81:
        putChar('\f');
        goto L3
    L10:
        if (isEOF() == true) goto L13;
        putChar(JSONLexer.EOI);
        goto L3
    L13:
        throw new JSONException("unclosed single-quote string");
    L5:
        this.token = 4;
        next();
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        char[] r100 = this.sbuf;
        if (r100.length > 8192) goto L5;
        SBUF_LOCAL.set(r100);
    L5:
        this.sbuf = null;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public final int intValue() {
        int r100 = 0;
        if (this.f24935np != (-1)) goto L5;
        this.f24935np = 0;
    L5:
        int r101 = this.f24935np;
        int r102 = this.f24936sp + r101;
        if (charAt(r101) != '-') goto L8;
        r101 = r101 + 1;
        int r103 = Integer.MIN_VALUE;
        boolean r104 = true;
    L9:
        if (r101 >= r102) goto L11;
        r100 = -(charAt(r101) - '0');
        r101 = r101 + 1;
    L11:
        if (r101 >= r102) goto L29;
        int r105 = r101 + 1;
        char r106 = charAt(r101);
        if (r106 == 'L') goto L28;
        if (r106 == 'S') goto L28;
        if (r106 == 'B') goto L28;
        int r107 = r106 - '0';
        if (r100 < (-214748364)) goto L27;
        int r108 = r100 * 10;
        if (r108 < (r103 + r107)) goto L25;
        r100 = r108 - r107;
        r101 = r105;
        goto L11
    L25:
        throw new NumberFormatException(numberString());
    L27:
        throw new NumberFormatException(numberString());
    L28:
        r101 = r105;
    L29:
        if (r104 == false) goto L36;
        if (r101 <= (this.f24935np + 1)) goto L34;
        return r100;
    L34:
        throw new NumberFormatException(numberString());
    L36:
        return -r100;
    L8:
        r103 = -2147483647;
        r104 = false;
        goto L9
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public final Number integerValue() throws NumberFormatException {
        boolean r100 = false;
        if (this.f24935np != (-1)) goto L5;
        this.f24935np = 0;
    L5:
        int r101 = this.f24935np;
        int r102 = this.f24936sp + r101;
        char r103 = charAt(r102 - 1);
        if (r103 == 'B') goto L12;
        if (r103 == 'L') goto L11;
        if (r103 == 'S') goto L10;
        char r104 = ' ';
    L14:
        if (charAt(this.f24935np) != '-') goto L16;
        r101 = r101 + 1;
        long r105 = Long.MIN_VALUE;
        r100 = true;
    L17:
        if (r101 >= r102) goto L19;
        long r110 = -(charAt(r101) - '0');
        r101 = r101 + 1;
    L20:
        if (r101 >= r102) goto L30;
        int r111 = r101 + 1;
        int r106 = charAt(r101) - '0';
        if (r110 < MULTMIN_RADIX_TEN) goto L24;
        long r112 = r110 * 10;
        long r107 = r106;
        if (r112 < (r105 + r107)) goto L28;
        r110 = r112 - r107;
        r101 = r111;
        goto L20
    L28:
        return new BigInteger(numberString(), 10);
    L24:
        return new BigInteger(numberString(), 10);
    L30:
        if (r100 == true) goto L32;
        long r108 = -r110;
        if (r108 > SieveCacheKt.NodeLinkMask) goto L64;
        if (r104 == 'L') goto L64;
        if (r104 == 'S') goto L57;
        if (r104 != 'B') goto L62;
        return Byte.valueOf((byte) r108);
    L62:
        return Integer.valueOf((int) r108);
    L57:
        return Short.valueOf((short) r108);
    L64:
        return Long.valueOf(r108);
    L32:
        if (r101 <= (this.f24935np + 1)) goto L49;
        if (r110 < SieveCacheKt.NodeMetaAndPreviousMask) goto L47;
        if (r104 == 'L') goto L47;
        if (r104 == 'S') goto L40;
        if (r104 != 'B') goto L45;
        return Byte.valueOf((byte) r110);
    L45:
        return Integer.valueOf((int) r110);
    L40:
        return Short.valueOf((short) r110);
    L47:
        return Long.valueOf(r110);
    L49:
        throw new JSONException("illegal number format : " + numberString());
    L19:
        r110 = 0;
        goto L20
    L16:
        r105 = -9223372036854775807L;
        goto L17
    L10:
        r102 = r102 - 1;
        r104 = 'S';
        goto L14
    L11:
        r102 = r102 - 1;
        r104 = Matrix.MATRIX_TYPE_RANDOM_LT;
        goto L14
    L12:
        r102 = r102 - 1;
        r104 = 'B';
        goto L14
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public final boolean isRef() {
        if (this.f24936sp == 4) goto L6;
        return false;
    L6:
        if (charAt(this.f24935np + 1) == '$') goto L8;
        return false;
    L8:
        if (charAt(this.f24935np + 2) == 'r') goto L10;
        return false;
    L10:
        if (charAt(this.f24935np + 3) == 'e') goto L12;
        return false;
    L12:
        if (charAt(this.f24935np + 4) != 'f') goto L18;
        return true;
    L18:
        return false;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x005d -> B:11:0x002e). Please report as a decompilation issue!!! */
    @Override // com.alibaba.fastjson.parser.JSONLexer
    public final long longValue() throws NumberFormatException {
        boolean r100 = false;
        if (this.f24935np != (-1)) goto L5;
        this.f24935np = 0;
    L5:
        int r101 = this.f24935np;
        int r102 = this.f24936sp + r101;
        if (charAt(r101) != '-') goto L8;
        r101 = r101 + 1;
        long r103 = Long.MIN_VALUE;
        r100 = true;
    L9:
        if (r101 >= r102) goto L12;
        int r104 = r101 + 1;
        long r105 = -(charAt(r101) - '0');
    L11:
        r101 = r104;
    L13:
        if (r101 >= r102) goto L31;
        r104 = r101 + 1;
        char r106 = charAt(r101);
        if (r106 != 'L') goto L17;
    L30:
        r101 = r104;
        goto L31
    L17:
        if (r106 == 'S') goto L30;
        if (r106 == 'B') goto L30;
        int r107 = r106 - '0';
        if (r105 < MULTMIN_RADIX_TEN) goto L29;
        long r108 = r105 * 10;
        long r109 = r107;
        if (r108 < (r103 + r109)) goto L27;
        r105 = r108 - r109;
        goto L11
    L27:
        throw new NumberFormatException(numberString());
    L29:
        throw new NumberFormatException(numberString());
    L31:
        if (r100 == false) goto L38;
        if (r101 <= (this.f24935np + 1)) goto L36;
        return r105;
    L36:
        throw new NumberFormatException(numberString());
    L38:
        return -r105;
    L12:
        r105 = 0;
        goto L13
    L8:
        r103 = -9223372036854775807L;
        goto L9
    }

    public final void nextIdent() {
    L3:
        if (isWhitespace(this.f24934ch) == false) goto L5;
        next();
        goto L3
    L5:
        char r100 = this.f24934ch;
        if (r100 != '_') goto L8;
    L13:
        scanIdent();
        return;
    L8:
        if (r100 == '$') goto L13;
        if (Character.isLetter(r100) == true) goto L13;
        nextToken();
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public final void nextTokenWithColon() {
        nextTokenWithChar(':');
    }

    public final void scanFalse() {
        if (this.f24934ch != 'f') goto L50;
        next();
        if (this.f24934ch != 'a') goto L48;
        next();
        if (this.f24934ch != 'l') goto L46;
        next();
        if (this.f24934ch != 's') goto L44;
        next();
        if (this.f24934ch != 'e') goto L42;
        next();
        char r100 = this.f24934ch;
        if (r100 != ' ') goto L15;
    L39:
        this.token = 7;
        return;
    L15:
        if (r100 == ',') goto L39;
        if (r100 == '}') goto L39;
        if (r100 == ']') goto L39;
        if (r100 == '\n') goto L39;
        if (r100 == '\r') goto L39;
        if (r100 == '\t') goto L39;
        if (r100 == 26) goto L39;
        if (r100 == '\f') goto L39;
        if (r100 == '\b') goto L39;
        if (r100 == ':') goto L39;
        if (r100 == '/') goto L39;
        throw new JSONException("scan false error");
    L42:
        throw new JSONException("error parse false");
    L44:
        throw new JSONException("error parse false");
    L46:
        throw new JSONException("error parse false");
    L48:
        throw new JSONException("error parse false");
    L50:
        throw new JSONException("error parse false");
    }

    public final void scanHex() {
        if (this.f24934ch != 'x') goto L27;
        next();
        if (this.f24934ch != '\'') goto L25;
        this.f24935np = this.f24933bp;
        next();
        if (this.f24934ch != '\'') goto L10;
        next();
        this.token = 26;
        return;
    L10:
        char r100 = next();
        if (r100 < '0') goto L15;
        if (r100 > '9') goto L15;
    L18:
        this.f24936sp++;
    L15:
        if (r100 < 'A') goto L19;
        if (r100 <= 'F') goto L18;
    L19:
        if (r100 != '\'') goto L23;
        this.f24936sp++;
        next();
        this.token = 26;
        return;
    L23:
        throw new JSONException("illegal state. " + r100);
    L25:
        throw new JSONException("illegal state. " + this.f24934ch);
    L27:
        throw new JSONException("illegal state. " + this.f24934ch);
    }

    public final void scanIdent() {
        this.f24935np = this.f24933bp - 1;
        this.hasSpecial = false;
    L3:
        this.f24936sp++;
        next();
        if (Character.isLetterOrDigit(this.f24934ch) == true) goto L3;
        String r100 = stringVal();
        if ("null".equalsIgnoreCase(r100) == false) goto L10;
        this.token = 8;
        return;
    L10:
        if ("new".equals(r100) == false) goto L13;
        this.token = 9;
        return;
    L13:
        if ("true".equals(r100) == false) goto L16;
        this.token = 6;
        return;
    L16:
        if ("false".equals(r100) == false) goto L19;
        this.token = 7;
        return;
    L19:
        if ("undefined".equals(r100) == false) goto L22;
        this.token = 23;
        return;
    L22:
        if ("Set".equals(r100) == false) goto L25;
        this.token = 21;
        return;
    L25:
        if ("TreeSet".equals(r100) == false) goto L27;
        this.token = 22;
        return;
    L27:
        this.token = 18;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public final void scanNumber() {
        this.f24935np = this.f24933bp;
        boolean r100 = true;
        if (this.f24934ch != '-') goto L5;
        this.f24936sp++;
        next();
    L5:
        char r101 = this.f24934ch;
        if (r101 < '0') goto L10;
        if (r101 > '9') goto L10;
        this.f24936sp++;
        next();
    L10:
        if (r101 != '.') goto L17;
        this.f24936sp++;
        next();
    L12:
        char r102 = this.f24934ch;
        if (r102 < '0') goto L16;
        if (r102 > '9') goto L16;
        this.f24936sp++;
        next();
    L16:
        boolean r103 = true;
    L18:
        int r104 = this.f24936sp;
        if (r104 > 65535) goto L57;
        char r105 = this.f24934ch;
        if (r105 != 'L') goto L24;
        this.f24936sp = r104 + 1;
        next();
    L40:
        r100 = r103;
    L52:
        if (r100 == false) goto L54;
        this.token = 3;
        return;
    L54:
        this.token = 2;
        return;
    L24:
        if (r105 != 'S') goto L27;
        this.f24936sp = r104 + 1;
        next();
        goto L40
    L27:
        if (r105 != 'B') goto L30;
        this.f24936sp = r104 + 1;
        next();
        goto L40
    L30:
        if (r105 != 'F') goto L33;
        this.f24936sp = r104 + 1;
        next();
        goto L52
    L33:
        if (r105 != 'D') goto L36;
        this.f24936sp = r104 + 1;
        next();
        goto L52
    L36:
        if (r105 != 'e') goto L38;
    L41:
        this.f24936sp = r104 + 1;
        next();
        char r106 = this.f24934ch;
        if (r106 == '+') goto L44;
        if (r106 == '-') goto L44;
    L45:
        char r107 = this.f24934ch;
        if (r107 < '0') goto L49;
        if (r107 > '9') goto L49;
        this.f24936sp++;
        next();
    L49:
        if (r107 == 'D') goto L51;
        if (r107 != 'F') goto L52;
    L51:
        this.f24936sp++;
        next();
    L44:
        this.f24936sp++;
        next();
        goto L45
    L38:
        if (r105 != 'E') goto L40;
    L57:
        throw new JSONException("scanNumber overflow");
    L17:
        r103 = false;
        goto L18
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public final void scanString() {
        this.f24935np = this.f24933bp;
        this.hasSpecial = false;
    L3:
        char r100 = next();
        if (r100 == '\"') goto L5;
        if (r100 == 26) goto L10;
        boolean r101 = true;
        if (r100 == '\\') goto L17;
        if (this.hasSpecial == false) goto L91;
        int r102 = this.f24936sp;
        char[] r103 = this.sbuf;
        if (r102 == r103.length) goto L94;
        this.f24936sp = r102 + 1;
        r103[r102] = r100;
        goto L3
    L94:
        putChar(r100);
        goto L3
    L91:
        this.f24936sp++;
        goto L3
    L17:
        if (this.hasSpecial == true) goto L26;
        this.hasSpecial = true;
        int r104 = this.f24936sp;
        char[] r105 = this.sbuf;
        if (r104 < r105.length) goto L25;
        int r106 = r105.length * 2;
        if (r104 > r106) goto L24;
        r104 = r106;
    L24:
        char[] r107 = new char[r104];
        System.arraycopy(r105, 0, r107, 0, r105.length);
        this.sbuf = r107;
    L25:
        copyTo(this.f24935np + 1, this.f24936sp, this.sbuf);
    L26:
        char r108 = next();
        if (r108 != '\"') goto L29;
        putChar(Typography.quote);
        goto L3
    L29:
        if (r108 != '\'') goto L31;
        putChar('\'');
        goto L3
    L31:
        if (r108 == 'F') goto L86;
        if (r108 != '\\') goto L34;
        putChar('\\');
        goto L3
    L34:
        if (r108 != 'b') goto L36;
        putChar('\b');
        goto L3
    L36:
        if (r108 == 'f') goto L86;
        if (r108 != 'n') goto L40;
        putChar('\n');
        goto L3
    L40:
        if (r108 != 'r') goto L42;
        putChar('\r');
        goto L3
    L42:
        if (r108 != 'x') goto L44;
        char r109 = next();
        char r110 = next();
        if (r109 < '0') goto L63;
        if (r109 > '9') goto L63;
    L67:
        boolean r111 = true;
    L69:
        if (r110 < '0') goto L71;
        if (r110 > '9') goto L71;
    L77:
        if (r111 == false) goto L81;
        if (r101 == false) goto L81;
        int[] r112 = digits;
        putChar((char) ((r112[r109] * 16) + r112[r110]));
    L81:
        throw new JSONException("invalid escape character \\x" + r109 + r110);
    L71:
        if (r110 < 'a') goto L73;
        if (r110 <= 'f') goto L77;
    L73:
        if (r110 < 'A') goto L76;
        if (r110 <= 'F') goto L77;
    L76:
        r101 = false;
    L63:
        if (r109 < 'a') goto L65;
        if (r109 <= 'f') goto L67;
    L65:
        if (r109 < 'A') goto L68;
        if (r109 <= 'F') goto L67;
    L68:
        r111 = false;
        goto L69
    L44:
        switch(r108) {
            case 47: goto L59;
            case 48: goto L58;
            case 49: goto L57;
            case 50: goto L56;
            case 51: goto L55;
            case 52: goto L54;
            case 53: goto L53;
            case 54: goto L52;
            case 55: goto L51;
            default: goto L45;
        };
    L51:
        putChar(7);
        goto L3
    L52:
        putChar(6);
        goto L3
    L53:
        putChar(5);
        goto L3
    L54:
        putChar(4);
        goto L3
    L55:
        putChar(3);
        goto L3
    L56:
        putChar(2);
        goto L3
    L57:
        putChar(1);
        goto L3
    L58:
        putChar(0);
        goto L3
    L59:
        putChar('/');
        goto L3
    L45:
        switch(r108) {
            case 116: goto L50;
            case 117: goto L49;
            case 118: goto L48;
            default: goto L46;
        };
    L46:
        this.f24934ch = r108;
        throw new JSONException("unclosed string : " + r108);
    L49:
        putChar((char) CastIntegerProtector.parseInt(new String(new char[]{next(), next(), next(), next()}), 16));
        goto L3
    L50:
        putChar('\t');
        goto L3
    L48:
        putChar(11);
    L86:
        putChar('\f');
        goto L3
    L10:
        if (isEOF() == true) goto L13;
        putChar(JSONLexer.EOI);
        goto L3
    L13:
        throw new JSONException("unclosed string : " + r100);
    L5:
        this.token = 4;
        this.f24934ch = next();
    }

    public final void scanTrue() {
        if (this.f24934ch != 't') goto L46;
        next();
        if (this.f24934ch != 'r') goto L44;
        next();
        if (this.f24934ch != 'u') goto L42;
        next();
        if (this.f24934ch != 'e') goto L40;
        next();
        char r100 = this.f24934ch;
        if (r100 != ' ') goto L13;
    L37:
        this.token = 6;
        return;
    L13:
        if (r100 == ',') goto L37;
        if (r100 == '}') goto L37;
        if (r100 == ']') goto L37;
        if (r100 == '\n') goto L37;
        if (r100 == '\r') goto L37;
        if (r100 == '\t') goto L37;
        if (r100 == 26) goto L37;
        if (r100 == '\f') goto L37;
        if (r100 == '\b') goto L37;
        if (r100 == ':') goto L37;
        if (r100 == '/') goto L37;
        throw new JSONException("scan true error");
    L40:
        throw new JSONException("error parse true");
    L42:
        throw new JSONException("error parse true");
    L44:
        throw new JSONException("error parse true");
    L46:
        throw new JSONException("error parse true");
    }

    public void skipArray() {
        throw new UnsupportedOperationException();
    }

    public void skipObject() {
        throw new UnsupportedOperationException();
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public final void skipWhitespace() {
    L2:
        char r100 = this.f24934ch;
        if (r100 > '/') goto L20;
        if (r100 == ' ') goto L19;
        if (r100 == '\r') goto L19;
        if (r100 == '\n') goto L19;
        if (r100 == '\t') goto L19;
        if (r100 == '\f') goto L19;
        if (r100 == '\b') goto L19;
        if (r100 != '/') goto L33;
        skipComment();
        goto L2
    L33:
        return;
    L19:
        next();
        goto L2
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public final String tokenName() {
        return JSONToken.name(this.token);
    }

    public double doubleValue() {
        return CastDoubleProtector.parseDouble(numberString());
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public float floatValue() {
        String r100 = numberString();
        float r101 = CastFloatProtector.parseFloat(r100);
        if (r101 != 0.0f) goto L5;
    L6:
        char r102 = r100.charAt(0);
        if (r102 > '0') goto L9;
    L13:
        return r101;
    L9:
        if (r102 > '9') goto L13;
        throw new JSONException("float overflow : ".concat(r100));
    L5:
        if (r101 != Float.POSITIVE_INFINITY) goto L13;
        goto L6
    }

    public void skipComment() {
        next();
        char r100 = this.f24934ch;
        if (r100 != '/') goto L11;
    L4:
        next();
        char r101 = this.f24934ch;
        if (r101 == '\n') goto L6;
        if (r101 != 26) goto L4;
        return;
    L6:
        next();
        return;
    L11:
        if (r100 != '*') goto L23;
        next();
    L13:
        char r102 = this.f24934ch;
        if (r102 == 26) goto L21;
        if (r102 == '*') goto L16;
        next();
        goto L13
    L16:
        next();
        if (this.f24934ch != '/') goto L13;
        next();
        return;
    L21:
        return;
    L23:
        throw new JSONException("invalid comment");
    }

    public Calendar getCalendar() {
        return this.calendar;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public final char getCurrent() {
        return this.f24934ch;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public int getFeatures() {
        return this.features;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public Locale getLocale() {
        return this.locale;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public TimeZone getTimeZone() {
        return this.timeZone;
    }

    public final int matchStat() {
        return this.matchStat;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public final int pos() {
        return this.pos;
    }

    public final String stringDefaultValue() {
        return this.stringDefaultValue;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public final int token() {
        return this.token;
    }

    public JSONLexerBase(int r100) {
        this.calendar = null;
        this.timeZone = JSON.defaultTimeZone;
        this.locale = JSON.defaultLocale;
        this.matchStat = 0;
        this.stringDefaultValue = null;
        this.nanos = 0;
        this.features = r100;
        if ((r100 & Feature.InitStringFieldAsEmpty.mask) == 0) goto L5;
        this.stringDefaultValue = "";
    L5:
        char[] r101 = SBUF_LOCAL.get();
        this.sbuf = r101;
        if (r101 != null) goto L9;
        this.sbuf = new char[512];
        return;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public final Number decimalValue(boolean r100) {
        char r101 = charAt((this.f24935np + this.f24936sp) - 1);
        if (r101 != 'F') goto L9;
        return Float.valueOf(CastFloatProtector.parseFloat(numberString()));
    L9:
        if (r101 == 'D') goto L11;
        if (r100 == false) goto L16;
        return decimalValue();
    L16:
        return Double.valueOf(doubleValue());
    L11:
        return Double.valueOf(CastDoubleProtector.parseDouble(numberString()));
    L6:
        e = move-exception;
        throw new JSONException(e.getMessage() + ", " + info());
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public final boolean isEnabled(int r100) {
        if ((r100 & this.features) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean matchField(char[] r100) {
    L3:
        if (charArrayCompare(r100) == true) goto L9;
        if (isWhitespace(this.f24934ch) == false) goto L7;
        next();
        goto L3
    L7:
        return false;
    L9:
        int r101 = this.f24933bp + r100.length;
        this.f24933bp = r101;
        char r102 = charAt(r101);
        this.f24934ch = r102;
        if (r102 != '{') goto L13;
        next();
        this.token = 12;
    L25:
        return true;
    L13:
        if (r102 != '[') goto L16;
        next();
        this.token = 14;
        goto L25
    L16:
        if (r102 == 'S') goto L18;
    L24:
        nextToken();
        goto L25
    L18:
        if (charAt(this.f24933bp + 1) != 'e') goto L24;
        if (charAt(this.f24933bp + 2) != 't') goto L24;
        if (charAt(this.f24933bp + 3) != '[') goto L24;
        int r103 = this.f24933bp + 3;
        this.f24933bp = r103;
        this.f24934ch = charAt(r103);
        this.token = 21;
        goto L25
    }

    public boolean matchField2(char[] r100) {
        throw new UnsupportedOperationException();
    }

    public Collection<String> newCollectionByType(Class<?> r100) {
        if (r100.isAssignableFrom(HashSet.class) == false) goto L7;
        return new HashSet();
    L7:
        if (r100.isAssignableFrom(ArrayList.class) == false) goto L11;
        return new ArrayList();
    L11:
        if (r100.isAssignableFrom(LinkedList.class) == true) goto L13;
        return (Collection) r100.newInstance();
    L16:
        e = move-exception;
        throw new JSONException(e.getMessage(), e);
    L13:
        return new LinkedList();
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public final void nextToken(int r110) {
        this.f24936sp = 0;
    L4:
        if (r110 != 2) goto L6;
        char r100 = this.f24934ch;
        if (r100 < '0') goto L76;
        if (r100 > '9') goto L76;
        this.pos = this.f24933bp;
        scanNumber();
        return;
    L76:
        if (r100 == '\"') goto L77;
        if (r100 == '[') goto L80;
        if (r100 == '{') goto L83;
    L85:
        char r101 = this.f24934ch;
        if (r101 == ' ') goto L98;
        if (r101 == '\n') goto L98;
        if (r101 == '\r') goto L98;
        if (r101 == '\t') goto L98;
        if (r101 == '\f') goto L98;
        if (r101 == '\b') goto L98;
        nextToken();
        return;
    L98:
        next();
        goto L4
    L83:
        this.token = 12;
        next();
        return;
    L80:
        this.token = 14;
        next();
        return;
    L77:
        this.pos = this.f24933bp;
        scanString();
        return;
    L6:
        if (r110 == 4) goto L57;
        if (r110 != 12) goto L9;
        char r102 = this.f24934ch;
        if (r102 == '{') goto L52;
        if (r102 != '[') goto L85;
        this.token = 14;
        next();
        return;
    L52:
        this.token = 12;
        next();
        return;
    L9:
        if (r110 == 18) goto L48;
        if (r110 == 20) goto L45;
        switch(r110) {
            case 14: goto L37;
            case 15: goto L34;
            case 16: goto L15;
            default: goto L85;
        };
    L15:
        char r103 = this.f24934ch;
        if (r103 == ',') goto L17;
        if (r103 == '}') goto L21;
        if (r103 == ']') goto L24;
        if (r103 == 26) goto L27;
        if (r103 != 'n') goto L85;
        scanNullOrNew(false);
        return;
    L27:
        this.token = 20;
        return;
    L24:
        this.token = 15;
        next();
        return;
    L21:
        this.token = 13;
        next();
        return;
    L17:
        this.token = 16;
        next();
        return;
    L37:
        char r104 = this.f24934ch;
        if (r104 == '[') goto L39;
        if (r104 != '{') goto L85;
        this.token = 12;
        next();
        return;
    L39:
        this.token = 14;
        next();
        return;
    L34:
        if (this.f24934ch != ']') goto L45;
        this.token = 15;
        next();
        return;
    L45:
        if (this.f24934ch != 26) goto L85;
        this.token = 20;
        return;
    L48:
        nextIdent();
        return;
    L57:
        char r105 = this.f24934ch;
        if (r105 == '\"') goto L59;
        if (r105 < '0') goto L65;
        if (r105 > '9') goto L65;
        this.pos = this.f24933bp;
        scanNumber();
        return;
    L65:
        if (r105 == '[') goto L66;
        if (r105 != '{') goto L85;
        this.token = 12;
        next();
        return;
    L66:
        this.token = 14;
        next();
        return;
    L59:
        this.pos = this.f24933bp;
        scanString();
    }

    public final void nextTokenWithChar(char r100) {
        this.f24936sp = 0;
    L3:
        char r101 = this.f24934ch;
        if (r101 == r100) goto L5;
        if (r101 == ' ') goto L22;
        if (r101 == '\n') goto L22;
        if (r101 == '\r') goto L22;
        if (r101 == '\t') goto L22;
        if (r101 == '\f') goto L22;
        if (r101 == '\b') goto L22;
        throw new JSONException("not match " + r100 + " - " + this.f24934ch + ", info : " + info());
    L22:
        next();
        goto L3
    L5:
        next();
        nextToken();
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public final void nextTokenWithColon(int r100) {
        nextTokenWithChar(':');
    }

    public final void putChar(char r100) {
        int r101 = this.f24936sp;
        char[] r102 = this.sbuf;
        if (r101 < r102.length) goto L8;
        int r103 = r102.length * 2;
        if (r103 >= r101) goto L7;
        r103 = r101 + 1;
    L7:
        char[] r104 = new char[r103];
        System.arraycopy(r102, 0, r104, 0, r102.length);
        this.sbuf = r104;
    L8:
        char[] r105 = this.sbuf;
        int r106 = this.f24936sp;
        this.f24936sp = r106 + 1;
        r105[r106] = r100;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public boolean scanBoolean(char r110) {
        boolean r100 = false;
        this.matchStat = 0;
        char r101 = charAt(this.f24933bp + 0);
        int r102 = 5;
        if (r101 != 't') goto L14;
        if (charAt(this.f24933bp + 1) == 'r') goto L7;
    L11:
        this.matchStat = -1;
        return false;
    L7:
        if (charAt((this.f24933bp + 1) + 1) != 'u') goto L11;
        if (charAt((this.f24933bp + 1) + 2) != 'e') goto L11;
        r101 = charAt(this.f24933bp + 4);
        r100 = true;
    L34:
        if (r101 == r110) goto L35;
        if (isWhitespace(r101) == false) goto L40;
        r101 = charAt(this.f24933bp + r102);
        r102 = r102 + 1;
        goto L34
    L40:
        this.matchStat = -1;
        return r100;
    L35:
        int r111 = this.f24933bp + r102;
        this.f24933bp = r111;
        this.f24934ch = charAt(r111);
        this.matchStat = 3;
        return r100;
    L14:
        if (r101 != 'f') goto L27;
        if (charAt(this.f24933bp + 1) == 'a') goto L18;
    L24:
        this.matchStat = -1;
        return false;
    L18:
        if (charAt((this.f24933bp + 1) + 1) != 'l') goto L24;
        if (charAt((this.f24933bp + 1) + 2) != 's') goto L24;
        if (charAt((this.f24933bp + 1) + 3) != 'e') goto L24;
        r101 = charAt(this.f24933bp + 5);
        r102 = 6;
        goto L34
    L27:
        if (r101 != '1') goto L31;
        r101 = charAt(this.f24933bp + 1);
        r100 = true;
    L29:
        r102 = 2;
        goto L34
    L31:
        if (r101 != '0') goto L33;
        r101 = charAt(this.f24933bp + 1);
        goto L29
    L33:
        r102 = 1;
        goto L34
    }

    public Date scanDate(char r110) {
        boolean r100 = false;
        this.matchStat = 0;
        char r101 = charAt(this.f24933bp + 0);
        if (r101 != '\"') goto L30;
        int r102 = indexOf(Typography.quote, this.f24933bp + 1);
        if (r102 == (-1)) goto L29;
        int r103 = this.f24933bp + 1;
        String r104 = subString(r103, r102 - r103);
        if (r104.indexOf(92) == (-1)) goto L17;
    L8:
        int r105 = r102 - 1;
        int r111 = 0;
    L9:
        if (r105 < 0) goto L14;
        if (charAt(r105) != '\\') goto L14;
        r111 = r111 + 1;
        r105 = r105 - 1;
    L14:
        if ((r111 % 2) == 0) goto L15;
        r102 = indexOf(Typography.quote, r102 + 1);
        goto L8
    L15:
        int r106 = this.f24933bp;
        int r107 = r102 - (r106 + 1);
        r104 = readString(sub_chars(r106 + 1, r107), r107);
    L17:
        int r108 = this.f24933bp;
        int r109 = ((r102 - (r108 + 1)) + 1) + 1;
        int r112 = r109 + 1;
        r101 = charAt(r108 + r109);
        JSONScanner r113 = new JSONScanner(r104);
    L25:
        th = move-exception;
        r113.close();
        throw th;
    L19:
        if (r113.scanISO8601DateIfMatch(false) == false) goto L22;
        Date r114 = r113.getCalendar().getTime();     // Catch: Throwable -> L25
        r113.close();
    L67:
        if (r101 != ',') goto L71;
        int r115 = this.f24933bp + r112;
        this.f24933bp = r115;
        this.f24934ch = charAt(r115);
        this.matchStat = 3;
        this.token = 16;
        return r114;
    L71:
        if (r101 != ']') goto L87;
        int r116 = r112 + 1;
        char r117 = charAt(this.f24933bp + r112);
        if (r117 != ',') goto L75;
        this.token = 16;
        int r118 = this.f24933bp + r116;
        this.f24933bp = r118;
        this.f24934ch = charAt(r118);
    L83:
        this.matchStat = 4;
        return r114;
    L75:
        if (r117 != ']') goto L78;
        this.token = 15;
        int r119 = this.f24933bp + r116;
        this.f24933bp = r119;
        this.f24934ch = charAt(r119);
        goto L83
    L78:
        if (r117 != '}') goto L81;
        this.token = 13;
        int r120 = this.f24933bp + r116;
        this.f24933bp = r120;
        this.f24934ch = charAt(r120);
        goto L83
    L81:
        if (r117 != 26) goto L85;
        this.token = 20;
        this.f24933bp += r116 - 1;
        this.f24934ch = JSONLexer.EOI;
        goto L83
    L85:
        this.matchStat = -1;
        return null;
    L87:
        this.matchStat = -1;
        return null;
    L22:
        this.matchStat = -1;     // Catch: Throwable -> L25
        r113.close();
        return null;
    L29:
        throw new JSONException("unclosed str");
    L30:
        char r121 = '9';
        r112 = 2;
        if (r101 == '-') goto L46;
        if (r101 < '0') goto L36;
        if (r101 <= '9') goto L46;
    L36:
        if (r101 == 'n') goto L38;
    L44:
        this.matchStat = -1;
        return null;
    L38:
        if (charAt(this.f24933bp + 1) != 'u') goto L44;
        if (charAt((this.f24933bp + 1) + 1) != 'l') goto L44;
        if (charAt((this.f24933bp + 1) + 2) != 'l') goto L44;
        r112 = 5;
        this.matchStat = 5;
        r101 = charAt(this.f24933bp + 4);
        r114 = null;
    L46:
        if (r101 != '-') goto L48;
        r101 = charAt(this.f24933bp + 1);
        r100 = true;
    L50:
        if (r101 < '0') goto L58;
        if (r101 > '9') goto L58;
        long r122 = r101 - '0';
    L53:
        int r123 = r112 + 1;
        r101 = charAt(this.f24933bp + r112);
        if (r101 < '0') goto L57;
        if (r101 > r121) goto L57;
        r122 = (r122 * 10) + ((long) (r101 - '0'));
        r112 = r123;
        r121 = '9';
    L57:
        r112 = r123;
    L60:
        if (r122 >= 0) goto L63;
        this.matchStat = -1;
        return null;
    L63:
        if (r100 == false) goto L65;
        r122 = -r122;
    L65:
        r114 = new Date(r122);
    L58:
        r122 = 0;
        goto L60
    L48:
        r112 = 1;
        goto L50
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:54:0x00af -> B:50:0x009d). Please report as a decompilation issue!!! */
    @Override // com.alibaba.fastjson.parser.JSONLexer
    public BigDecimal scanDecimal(char r110) {
        this.matchStat = 0;
        char r100 = charAt(this.f24933bp + 0);
        if (r100 != '\"') goto L5;
        boolean r101 = true;
    L7:
        if (r101 == false) goto L9;
        r100 = charAt(this.f24933bp + 1);
        int r102 = 2;
    L11:
        if (r100 != '-') goto L13;
        boolean r103 = true;
    L14:
        if (r103 == false) goto L17;
        r100 = charAt(this.f24933bp + r102);
        r102 = r102 + 1;
    L17:
        if (r100 < '0') goto L89;
        if (r100 > '9') goto L89;
    L20:
        int r111 = r102 + 1;
        char r104 = charAt(this.f24933bp + r102);
        if (r104 < '0') goto L25;
        if (r104 > '9') goto L25;
        r102 = r111;
    L25:
        if (r104 != '.') goto L27;
        boolean r105 = true;
    L28:
        if (r105 == false) goto L39;
        int r106 = r111 + 1;
        char r107 = charAt(this.f24933bp + r111);
        if (r107 < '0') goto L36;
        if (r107 > '9') goto L36;
    L32:
        r111 = r106 + 1;
        r104 = charAt(this.f24933bp + r106);
        if (r104 < '0') goto L39;
        if (r104 > '9') goto L39;
        r106 = r111;
    L36:
        this.matchStat = -1;
        return null;
    L39:
        if (r104 != 'e') goto L41;
    L44:
        boolean r108 = true;
    L45:
        if (r108 == false) goto L55;
        int r109 = r111 + 1;
        r104 = charAt(this.f24933bp + r111);
        if (r104 == '+') goto L51;
        if (r104 == '-') goto L51;
    L50:
        r111 = r109;
    L52:
        if (r104 < '0') goto L55;
        if (r104 > '9') goto L55;
        r109 = r111 + 1;
        r104 = charAt(this.f24933bp + r111);
    L51:
        r104 = charAt(this.f24933bp + r109);
        r111 = r109 + 1;
    L55:
        if (r101 == false) goto L60;
        if (r104 == '\"') goto L59;
        this.matchStat = -1;
        return null;
    L59:
        int r112 = r111 + 1;
        r104 = charAt(this.f24933bp + r111);
        int r113 = this.f24933bp;
        int r114 = r113 + 1;
        int r115 = ((r113 + r112) - r114) - 2;
        r111 = r112;
    L62:
        if (r115 > 65535) goto L87;
        char[] r116 = sub_chars(r114, r115);
        BigDecimal r117 = new BigDecimal(r116, 0, r116.length, MathContext.UNLIMITED);
        if (r104 != ',') goto L68;
        int r118 = this.f24933bp + r111;
        this.f24933bp = r118;
        this.f24934ch = charAt(r118);
        this.matchStat = 3;
        this.token = 16;
        return r117;
    L68:
        if (r104 != ']') goto L84;
        int r119 = r111 + 1;
        char r120 = charAt(this.f24933bp + r111);
        if (r120 != ',') goto L72;
        this.token = 16;
        int r121 = this.f24933bp + r119;
        this.f24933bp = r121;
        this.f24934ch = charAt(r121);
    L80:
        this.matchStat = 4;
        return r117;
    L72:
        if (r120 != ']') goto L75;
        this.token = 15;
        int r122 = this.f24933bp + r119;
        this.f24933bp = r122;
        this.f24934ch = charAt(r122);
        goto L80
    L75:
        if (r120 != '}') goto L78;
        this.token = 13;
        int r123 = this.f24933bp + r119;
        this.f24933bp = r123;
        this.f24934ch = charAt(r123);
        goto L80
    L78:
        if (r120 != 26) goto L82;
        this.token = 20;
        this.f24933bp += r119 - 1;
        this.f24934ch = JSONLexer.EOI;
        goto L80
    L82:
        this.matchStat = -1;
        return null;
    L84:
        this.matchStat = -1;
        return null;
    L87:
        throw new JSONException("decimal overflow");
    L60:
        r114 = this.f24933bp;
        r115 = ((r114 + r111) - r114) - 1;
        goto L62
    L41:
        if (r104 == 'E') goto L44;
        r108 = false;
        goto L45
    L27:
        r105 = false;
    L89:
        if (r100 == 'n') goto L91;
    L112:
        this.matchStat = -1;
        return null;
    L91:
        if (charAt(this.f24933bp + r102) != 'u') goto L112;
        if (charAt((this.f24933bp + r102) + 1) != 'l') goto L112;
        if (charAt((this.f24933bp + r102) + 2) != 'l') goto L112;
        this.matchStat = 5;
        int r124 = r102 + 3;
        int r125 = r124 + 1;
        char r126 = charAt(this.f24933bp + r124);
        if (r101 == false) goto L100;
        if (r126 != '\"') goto L100;
        r126 = charAt(this.f24933bp + r125);
        r125 = r125 + 1;
    L100:
        if (r126 == ',') goto L101;
        if (r126 == '}') goto L105;
        if (isWhitespace(r126) == false) goto L110;
        r126 = charAt(this.f24933bp + r125);
        r125 = r125 + 1;
        goto L100
    L110:
        this.matchStat = -1;
        return null;
    L105:
        int r127 = this.f24933bp + r125;
        this.f24933bp = r127;
        this.f24934ch = charAt(r127);
        this.matchStat = 5;
        this.token = 13;
        return null;
    L101:
        int r128 = this.f24933bp + r125;
        this.f24933bp = r128;
        this.f24934ch = charAt(r128);
        this.matchStat = 5;
        this.token = 16;
        return null;
    L13:
        r103 = false;
        goto L14
    L9:
        r102 = 1;
        goto L11
    L5:
        r101 = false;
        goto L7
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:57:0x00cc -> B:53:0x00ba). Please report as a decompilation issue!!! */
    @Override // com.alibaba.fastjson.parser.JSONLexer
    public double scanDouble(char r210) {
        this.matchStat = 0;
        char r100 = charAt(this.f24933bp + 0);
        if (r100 != '\"') goto L5;
        boolean r101 = true;
    L6:
        if (r101 == false) goto L8;
        r100 = charAt(this.f24933bp + 1);
        int r102 = 2;
    L10:
        if (r100 != '-') goto L12;
        boolean r103 = true;
    L13:
        if (r103 == false) goto L16;
        r100 = charAt(this.f24933bp + r102);
        r102 = r102 + 1;
    L16:
        if (r100 < '0') goto L79;
        if (r100 > '9') goto L79;
        long r110 = r100 - '0';
    L20:
        int r111 = r102 + 1;
        char r104 = charAt(this.f24933bp + r102);
        if (r104 < '0') goto L25;
        if (r104 > '9') goto L25;
        r110 = (r110 * 10) + ((long) (r104 - '0'));
        r102 = r111;
    L25:
        if (r104 != '.') goto L27;
        boolean r105 = true;
    L28:
        if (r105 == false) goto L40;
        int r106 = r111 + 1;
        char r107 = charAt(this.f24933bp + r111);
        if (r107 < '0') goto L38;
        if (r107 > '9') goto L38;
        r110 = (r110 * 10) + ((long) (r107 - '0'));
        long r108 = 10;
    L33:
        r111 = r106 + 1;
        char r109 = charAt(this.f24933bp + r106);
        if (r109 < '0') goto L37;
        if (r109 > '9') goto L37;
        r110 = (r110 * 10) + ((long) (r109 - '0'));
        r108 = r108 * 10;
        r106 = r111;
    L37:
        long r211 = r108;
        r104 = r109;
        long r112 = r211;
    L42:
        if (r104 != 'e') goto L44;
    L47:
        boolean r113 = true;
    L48:
        if (r113 == false) goto L58;
        int r114 = r111 + 1;
        r104 = charAt(this.f24933bp + r111);
        if (r104 == '+') goto L54;
        if (r104 == '-') goto L54;
    L53:
        r111 = r114;
    L55:
        if (r104 < '0') goto L58;
        if (r104 > '9') goto L58;
        r114 = r111 + 1;
        r104 = charAt(this.f24933bp + r111);
    L54:
        r104 = charAt(this.f24933bp + r114);
        r111 = r114 + 1;
    L58:
        if (r101 == true) goto L60;
        int r115 = this.f24933bp;
        int r116 = ((r115 + r111) - r115) - 1;
    L65:
        if (r113 == false) goto L67;
    L71:
        double r117 = CastDoubleProtector.parseDouble(subString(r115, r116));
    L73:
        if (r104 != r210) goto L76;
        int r118 = this.f24933bp + r111;
        this.f24933bp = r118;
        this.f24934ch = charAt(r118);
        this.matchStat = 3;
        this.token = 16;
        return r117;
    L76:
        this.matchStat = -1;
        return r117;
    L67:
        if (r116 >= 17) goto L71;
        r117 = r110 / r112;
        if (r103 == false) goto L73;
        r117 = -r117;
        goto L73
    L60:
        if (r104 == '\"') goto L63;
        this.matchStat = -1;
        return AudioStats.AUDIO_AMPLITUDE_NONE;
    L63:
        int r119 = r111 + 1;
        char r120 = charAt(this.f24933bp + r111);
        int r121 = this.f24933bp;
        r115 = r121 + 1;
        r116 = ((r121 + r119) - r115) - 2;
        r111 = r119;
        r104 = r120;
        goto L65
    L44:
        if (r104 == 'E') goto L47;
        r113 = false;
    L38:
        this.matchStat = -1;
        return AudioStats.AUDIO_AMPLITUDE_NONE;
    L40:
        r112 = 1;
        goto L42
    L27:
        r105 = false;
    L79:
        if (r100 == 'n') goto L81;
    L104:
        this.matchStat = -1;
        return AudioStats.AUDIO_AMPLITUDE_NONE;
    L81:
        if (charAt(this.f24933bp + r102) != 'u') goto L104;
        if (charAt((this.f24933bp + r102) + 1) != 'l') goto L104;
        if (charAt((this.f24933bp + r102) + 2) != 'l') goto L104;
        this.matchStat = 5;
        int r122 = r102 + 3;
        int r123 = r122 + 1;
        char r124 = charAt(this.f24933bp + r122);
        if (r101 == false) goto L92;
        if (r124 != '\"') goto L92;
        r124 = charAt(this.f24933bp + r123);
        r123 = r123 + 1;
    L92:
        if (r124 == ',') goto L93;
        if (r124 == ']') goto L97;
        if (isWhitespace(r124) == false) goto L102;
        r124 = charAt(this.f24933bp + r123);
        r123 = r123 + 1;
        goto L92
    L102:
        this.matchStat = -1;
        return AudioStats.AUDIO_AMPLITUDE_NONE;
    L97:
        int r125 = this.f24933bp + r123;
        this.f24933bp = r125;
        this.f24934ch = charAt(r125);
        this.matchStat = 5;
        this.token = 15;
        return AudioStats.AUDIO_AMPLITUDE_NONE;
    L93:
        int r126 = this.f24933bp + r123;
        this.f24933bp = r126;
        this.f24934ch = charAt(r126);
        this.matchStat = 5;
        this.token = 16;
        return AudioStats.AUDIO_AMPLITUDE_NONE;
    L12:
        r103 = false;
        goto L13
    L8:
        r102 = 1;
        goto L10
    L5:
        r101 = false;
        goto L6
    }

    public long scanEnumSymbol(char[] r110) {
        this.matchStat = 0;
        if (charArrayCompare(r110) == true) goto L6;
        this.matchStat = -2;
        return 0;
    L6:
        int r111 = r110.length;
        int r100 = r111 + 1;
        if (charAt(this.f24933bp + r111) == '\"') goto L10;
        this.matchStat = -1;
        return 0;
    L10:
        long r101 = TypeUtils.fnv1a_64_magic_hashcode;
    L11:
        int r102 = r100 + 1;
        char r112 = charAt(this.f24933bp + r100);
        if (r112 == '\"') goto L13;
        if (r112 >= 'A') goto L39;
    L41:
        int r103 = r112;
    L42:
        r101 = (r101 ^ ((long) r103)) * TypeUtils.fnv1a_64_magic_prime;
        if (r112 == '\\') goto L44;
        r100 = r102;
        goto L11
    L44:
        this.matchStat = -1;
        return 0;
    L39:
        if (r112 > 'Z') goto L41;
        r103 = r112 + ' ';
        goto L42
    L13:
        int r104 = r102 + 1;
        char r113 = charAt(this.f24933bp + r102);
        if (r113 != ',') goto L18;
        int r114 = this.f24933bp + r104;
        this.f24933bp = r114;
        this.f24934ch = charAt(r114);
        this.matchStat = 3;
        return r101;
    L18:
        if (r113 != '}') goto L34;
        int r105 = r104 + 1;
        char r115 = charAt(this.f24933bp + r104);
        if (r115 != ',') goto L23;
        this.token = 16;
        int r116 = this.f24933bp + r105;
        this.f24933bp = r116;
        this.f24934ch = charAt(r116);
    L30:
        this.matchStat = 4;
        return r101;
    L23:
        if (r115 != ']') goto L25;
        this.token = 15;
        int r117 = this.f24933bp + r105;
        this.f24933bp = r117;
        this.f24934ch = charAt(r117);
        goto L30
    L25:
        if (r115 != '}') goto L28;
        this.token = 13;
        int r118 = this.f24933bp + r105;
        this.f24933bp = r118;
        this.f24934ch = charAt(r118);
        goto L30
    L28:
        if (r115 != 26) goto L32;
        this.token = 20;
        this.f24933bp += r105 - 1;
        this.f24934ch = JSONLexer.EOI;
        goto L30
    L32:
        this.matchStat = -1;
        return 0;
    L34:
        this.matchStat = -1;
        return 0;
    }

    public BigInteger scanFieldBigInteger(char[] r210) {
        this.matchStat = 0;
        if (charArrayCompare(r210) == true) goto L6;
        this.matchStat = -2;
        return null;
    L6:
        int r100 = r210.length;
        int r101 = r100 + 1;
        char r102 = charAt(this.f24933bp + r100);
        if (r102 != '\"') goto L9;
        boolean r103 = true;
    L10:
        if (r103 == false) goto L13;
        r102 = charAt(this.f24933bp + r101);
        r101 = r101 + 1;
    L13:
        if (r102 != '-') goto L15;
        boolean r104 = true;
    L16:
        if (r104 == false) goto L19;
        r102 = charAt(this.f24933bp + r101);
        r101 = r101 + 1;
    L19:
        if (r102 < '0') goto L75;
        char r110 = '9';
        if (r102 > '9') goto L75;
        long r111 = r102 - '0';
    L23:
        int r112 = r101 + 1;
        char r105 = charAt(this.f24933bp + r101);
        if (r105 < '0') goto L30;
        if (r105 > r110) goto L30;
        long r113 = (10 * r111) + ((long) (r105 - '0'));
        if (r113 < r111) goto L28;
        r111 = r113;
        r101 = r112;
        r110 = '9';
        goto L23
    L28:
        boolean r114 = true;
    L31:
        if (r103 == false) goto L36;
        if (r105 == '\"') goto L35;
        this.matchStat = -1;
        return null;
    L35:
        int r106 = r112 + 1;
        r105 = charAt(this.f24933bp + r112);
        int r107 = this.f24933bp;
        int r108 = (r210.length + r107) + 1;
        int r109 = ((r107 + r106) - r108) - 2;
        r112 = r106;
    L38:
        if (r114 == true) goto L47;
        if (r109 < 20) goto L43;
        if (r104 == false) goto L47;
        if (r109 >= 21) goto L47;
    L43:
        if (r104 == false) goto L45;
        r111 = -r111;
    L45:
        BigInteger r115 = BigInteger.valueOf(r111);
    L49:
        if (r105 != ',') goto L53;
        int r116 = this.f24933bp + r112;
        this.f24933bp = r116;
        this.f24934ch = charAt(r116);
        this.matchStat = 3;
        this.token = 16;
        return r115;
    L53:
        if (r105 != '}') goto L70;
        int r117 = r112 + 1;
        char r118 = charAt(this.f24933bp + r112);
        if (r118 != ',') goto L58;
        this.token = 16;
        int r119 = this.f24933bp + r117;
        this.f24933bp = r119;
        this.f24934ch = charAt(r119);
    L66:
        this.matchStat = 4;
        return r115;
    L58:
        if (r118 != ']') goto L61;
        this.token = 15;
        int r120 = this.f24933bp + r117;
        this.f24933bp = r120;
        this.f24934ch = charAt(r120);
        goto L66
    L61:
        if (r118 != '}') goto L64;
        this.token = 13;
        int r121 = this.f24933bp + r117;
        this.f24933bp = r121;
        this.f24934ch = charAt(r121);
        goto L66
    L64:
        if (r118 != 26) goto L68;
        this.token = 20;
        this.f24933bp += r117 - 1;
        this.f24934ch = JSONLexer.EOI;
        goto L66
    L68:
        this.matchStat = -1;
        return null;
    L70:
        this.matchStat = -1;
        return null;
    L47:
        if (r109 > 65535) goto L73;
        r115 = new BigInteger(subString(r108, r109), 10);
        goto L49
    L73:
        throw new JSONException("scanInteger overflow");
    L36:
        int r122 = this.f24933bp;
        r108 = r210.length + r122;
        r109 = ((r122 + r112) - r108) - 1;
    L30:
        r114 = false;
    L75:
        if (r102 == 'n') goto L77;
    L98:
        this.matchStat = -1;
        return null;
    L77:
        if (charAt(this.f24933bp + r101) != 'u') goto L98;
        if (charAt((this.f24933bp + r101) + 1) != 'l') goto L98;
        if (charAt((this.f24933bp + r101) + 2) != 'l') goto L98;
        this.matchStat = 5;
        int r123 = r101 + 3;
        int r124 = r123 + 1;
        char r125 = charAt(this.f24933bp + r123);
        if (r103 == false) goto L86;
        if (r125 != '\"') goto L86;
        r125 = charAt(this.f24933bp + r124);
        r124 = r124 + 1;
    L86:
        if (r125 == ',') goto L87;
        if (r125 == '}') goto L91;
        if (isWhitespace(r125) == false) goto L96;
        r125 = charAt(this.f24933bp + r124);
        r124 = r124 + 1;
        goto L86
    L96:
        this.matchStat = -1;
        return null;
    L91:
        int r126 = this.f24933bp + r124;
        this.f24933bp = r126;
        this.f24934ch = charAt(r126);
        this.matchStat = 5;
        this.token = 13;
        return null;
    L87:
        int r127 = this.f24933bp + r124;
        this.f24933bp = r127;
        this.f24934ch = charAt(r127);
        this.matchStat = 5;
        this.token = 16;
        return null;
    L15:
        r104 = false;
        goto L16
    L9:
        r103 = false;
        goto L10
    }

    public boolean scanFieldBoolean(char[] r110) {
        this.matchStat = 0;
        if (charArrayCompare(r110) == true) goto L6;
        this.matchStat = -2;
        return false;
    L6:
        int r111 = r110.length;
        int r100 = r111 + 1;
        char r112 = charAt(this.f24933bp + r111);
        if (r112 != 't') goto L22;
        int r101 = r100 + 1;
        if (charAt(this.f24933bp + r100) == 'r') goto L12;
        this.matchStat = -1;
        return false;
    L12:
        int r102 = r101 + 1;
        if (charAt(this.f24933bp + r101) == 'u') goto L16;
        this.matchStat = -1;
        return false;
    L16:
        int r103 = r102 + 1;
        if (charAt(this.f24933bp + r102) == 'e') goto L20;
        this.matchStat = -1;
        return false;
    L20:
        boolean r113 = true;
    L40:
        int r104 = r103 + 1;
        char r105 = charAt(this.f24933bp + r103);
        if (r105 != ',') goto L45;
        int r106 = this.f24933bp + r104;
        this.f24933bp = r106;
        this.f24934ch = charAt(r106);
        this.matchStat = 3;
        this.token = 16;
        return r113;
    L45:
        if (r105 != '}') goto L61;
        int r107 = r104 + 1;
        char r108 = charAt(this.f24933bp + r104);
        if (r108 != ',') goto L50;
        this.token = 16;
        int r109 = this.f24933bp + r107;
        this.f24933bp = r109;
        this.f24934ch = charAt(r109);
    L57:
        this.matchStat = 4;
        return r113;
    L50:
        if (r108 != ']') goto L52;
        this.token = 15;
        int r114 = this.f24933bp + r107;
        this.f24933bp = r114;
        this.f24934ch = charAt(r114);
        goto L57
    L52:
        if (r108 != '}') goto L55;
        this.token = 13;
        int r115 = this.f24933bp + r107;
        this.f24933bp = r115;
        this.f24934ch = charAt(r115);
        goto L57
    L55:
        if (r108 != 26) goto L59;
        this.token = 20;
        this.f24933bp += r107 - 1;
        this.f24934ch = JSONLexer.EOI;
        goto L57
    L59:
        this.matchStat = -1;
        return false;
    L61:
        this.matchStat = -1;
        return false;
    L22:
        if (r112 != 'f') goto L63;
        int r116 = r100 + 1;
        if (charAt(this.f24933bp + r100) == 'a') goto L27;
        this.matchStat = -1;
        return false;
    L27:
        int r117 = r116 + 1;
        if (charAt(this.f24933bp + r116) == 'l') goto L31;
        this.matchStat = -1;
        return false;
    L31:
        int r118 = r117 + 1;
        if (charAt(this.f24933bp + r117) == 's') goto L35;
        this.matchStat = -1;
        return false;
    L35:
        int r119 = r118 + 1;
        if (charAt(this.f24933bp + r118) == 'e') goto L39;
        this.matchStat = -1;
        return false;
    L39:
        r103 = r119;
        r113 = false;
        goto L40
    L63:
        this.matchStat = -1;
        return false;
    }

    public Date scanFieldDate(char[] r110) {
        boolean r100 = false;
        this.matchStat = 0;
        if (charArrayCompare(r110) == true) goto L6;
        this.matchStat = -2;
        return null;
    L6:
        int r101 = r110.length;
        int r102 = r101 + 1;
        char r103 = charAt(this.f24933bp + r101);
        if (r103 != '\"') goto L35;
        int r104 = indexOf(Typography.quote, (this.f24933bp + r110.length) + 1);
        if (r104 == (-1)) goto L33;
        int r105 = (this.f24933bp + r110.length) + 1;
        String r106 = subString(r105, r104 - r105);
        if (r106.indexOf(92) == (-1)) goto L21;
    L12:
        int r107 = r104 - 1;
        int r111 = 0;
    L13:
        if (r107 < 0) goto L18;
        if (charAt(r107) != '\\') goto L18;
        r111 = r111 + 1;
        r107 = r107 - 1;
    L18:
        if ((r111 % 2) == 0) goto L19;
        r104 = indexOf(Typography.quote, r104 + 1);
        goto L12
    L19:
        int r108 = this.f24933bp;
        int r109 = r104 - ((r110.length + r108) + 1);
        r106 = readString(sub_chars((r108 + r110.length) + 1, r109), r109);
    L21:
        int r112 = this.f24933bp;
        int r113 = r102 + ((r104 - ((r110.length + r112) + 1)) + 1);
        int r114 = r113 + 1;
        r103 = charAt(r112 + r113);
        JSONScanner r115 = new JSONScanner(r106);
    L29:
        th = move-exception;
        r115.close();
        throw th;
    L23:
        if (r115.scanISO8601DateIfMatch(false) == false) goto L26;
        Date r116 = r115.getCalendar().getTime();     // Catch: Throwable -> L29
        r115.close();
    L61:
        if (r103 != ',') goto L65;
        int r117 = this.f24933bp + r114;
        this.f24933bp = r117;
        this.f24934ch = charAt(r117);
        this.matchStat = 3;
        return r116;
    L65:
        if (r103 != '}') goto L81;
        int r118 = r114 + 1;
        char r119 = charAt(this.f24933bp + r114);
        if (r119 != ',') goto L70;
        this.token = 16;
        int r120 = this.f24933bp + r118;
        this.f24933bp = r120;
        this.f24934ch = charAt(r120);
    L77:
        this.matchStat = 4;
        return r116;
    L70:
        if (r119 != ']') goto L72;
        this.token = 15;
        int r121 = this.f24933bp + r118;
        this.f24933bp = r121;
        this.f24934ch = charAt(r121);
        goto L77
    L72:
        if (r119 != '}') goto L75;
        this.token = 13;
        int r122 = this.f24933bp + r118;
        this.f24933bp = r122;
        this.f24934ch = charAt(r122);
        goto L77
    L75:
        if (r119 != 26) goto L79;
        this.token = 20;
        this.f24933bp += r118 - 1;
        this.f24934ch = JSONLexer.EOI;
        goto L77
    L79:
        this.matchStat = -1;
        return null;
    L81:
        this.matchStat = -1;
        return null;
    L26:
        this.matchStat = -1;     // Catch: Throwable -> L29
        r115.close();
        return null;
    L33:
        throw new JSONException("unclosed str");
    L35:
        if (r103 == '-') goto L41;
        if (r103 < '0') goto L39;
        if (r103 <= '9') goto L41;
    L39:
        this.matchStat = -1;
        return null;
    L41:
        if (r103 != '-') goto L44;
        r103 = charAt(this.f24933bp + r102);
        r102 = r102 + 1;
        r100 = true;
    L44:
        if (r103 < '0') goto L52;
        if (r103 > '9') goto L52;
        long r123 = r103 - '0';
    L47:
        int r124 = r102 + 1;
        char r125 = charAt(this.f24933bp + r102);
        if (r125 < '0') goto L51;
        if (r125 > '9') goto L51;
        r123 = (r123 * 10) + ((long) (r125 - '0'));
        r102 = r124;
    L51:
        r103 = r125;
        r114 = r124;
    L54:
        if (r123 >= 0) goto L57;
        this.matchStat = -1;
        return null;
    L57:
        if (r100 == false) goto L59;
        r123 = -r123;
    L59:
        r116 = new Date(r123);
    L52:
        r114 = r102;
        r123 = 0;
        goto L54
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:56:0x00ba -> B:52:0x00a8). Please report as a decompilation issue!!! */
    public BigDecimal scanFieldDecimal(char[] r110) {
        this.matchStat = 0;
        if (charArrayCompare(r110) == true) goto L6;
        this.matchStat = -2;
        return null;
    L6:
        int r100 = r110.length;
        int r101 = r100 + 1;
        char r102 = charAt(this.f24933bp + r100);
        if (r102 != '\"') goto L9;
        boolean r103 = true;
    L10:
        if (r103 == false) goto L13;
        r102 = charAt(this.f24933bp + r101);
        r101 = r101 + 1;
    L13:
        if (r102 != '-') goto L15;
        boolean r111 = true;
    L16:
        if (r111 == false) goto L19;
        r102 = charAt(this.f24933bp + r101);
        r101 = r101 + 1;
    L19:
        if (r102 < '0') goto L92;
        if (r102 > '9') goto L92;
    L22:
        int r112 = r101 + 1;
        char r104 = charAt(this.f24933bp + r101);
        if (r104 < '0') goto L27;
        if (r104 > '9') goto L27;
        r101 = r112;
    L27:
        if (r104 != '.') goto L29;
        boolean r105 = true;
    L30:
        if (r105 == false) goto L41;
        int r106 = r112 + 1;
        char r107 = charAt(this.f24933bp + r112);
        if (r107 < '0') goto L38;
        if (r107 > '9') goto L38;
    L34:
        r112 = r106 + 1;
        r104 = charAt(this.f24933bp + r106);
        if (r104 < '0') goto L41;
        if (r104 > '9') goto L41;
        r106 = r112;
    L38:
        this.matchStat = -1;
        return null;
    L41:
        if (r104 != 'e') goto L43;
    L46:
        boolean r108 = true;
    L47:
        if (r108 == false) goto L57;
        int r109 = r112 + 1;
        r104 = charAt(this.f24933bp + r112);
        if (r104 == '+') goto L53;
        if (r104 == '-') goto L53;
    L52:
        r112 = r109;
    L54:
        if (r104 < '0') goto L57;
        if (r104 > '9') goto L57;
        r109 = r112 + 1;
        r104 = charAt(this.f24933bp + r112);
    L53:
        r104 = charAt(this.f24933bp + r109);
        r112 = r109 + 1;
    L57:
        if (r103 == false) goto L62;
        if (r104 == '\"') goto L61;
        this.matchStat = -1;
        return null;
    L61:
        int r113 = r112 + 1;
        r104 = charAt(this.f24933bp + r112);
        int r114 = this.f24933bp;
        int r115 = (r110.length + r114) + 1;
        int r116 = ((r114 + r113) - r115) - 2;
        r112 = r113;
    L64:
        if (r116 > 65535) goto L90;
        char[] r117 = sub_chars(r115, r116);
        BigDecimal r118 = new BigDecimal(r117, 0, r117.length, MathContext.UNLIMITED);
        if (r104 != ',') goto L70;
        int r119 = this.f24933bp + r112;
        this.f24933bp = r119;
        this.f24934ch = charAt(r119);
        this.matchStat = 3;
        this.token = 16;
        return r118;
    L70:
        if (r104 != '}') goto L87;
        int r120 = r112 + 1;
        char r121 = charAt(this.f24933bp + r112);
        if (r121 != ',') goto L75;
        this.token = 16;
        int r122 = this.f24933bp + r120;
        this.f24933bp = r122;
        this.f24934ch = charAt(r122);
    L83:
        this.matchStat = 4;
        return r118;
    L75:
        if (r121 != ']') goto L78;
        this.token = 15;
        int r123 = this.f24933bp + r120;
        this.f24933bp = r123;
        this.f24934ch = charAt(r123);
        goto L83
    L78:
        if (r121 != '}') goto L81;
        this.token = 13;
        int r124 = this.f24933bp + r120;
        this.f24933bp = r124;
        this.f24934ch = charAt(r124);
        goto L83
    L81:
        if (r121 != 26) goto L85;
        this.token = 20;
        this.f24933bp += r120 - 1;
        this.f24934ch = JSONLexer.EOI;
        goto L83
    L85:
        this.matchStat = -1;
        return null;
    L87:
        this.matchStat = -1;
        return null;
    L90:
        throw new JSONException("scan decimal overflow");
    L62:
        int r125 = this.f24933bp;
        r115 = r110.length + r125;
        r116 = ((r125 + r112) - r115) - 1;
        goto L64
    L43:
        if (r104 == 'E') goto L46;
        r108 = false;
        goto L47
    L29:
        r105 = false;
    L92:
        if (r102 == 'n') goto L94;
    L115:
        this.matchStat = -1;
        return null;
    L94:
        if (charAt(this.f24933bp + r101) != 'u') goto L115;
        if (charAt((this.f24933bp + r101) + 1) != 'l') goto L115;
        if (charAt((this.f24933bp + r101) + 2) != 'l') goto L115;
        this.matchStat = 5;
        int r126 = r101 + 3;
        int r127 = r126 + 1;
        char r128 = charAt(this.f24933bp + r126);
        if (r103 == false) goto L103;
        if (r128 != '\"') goto L103;
        r128 = charAt(this.f24933bp + r127);
        r127 = r127 + 1;
    L103:
        if (r128 == ',') goto L104;
        if (r128 == '}') goto L108;
        if (isWhitespace(r128) == false) goto L113;
        r128 = charAt(this.f24933bp + r127);
        r127 = r127 + 1;
        goto L103
    L113:
        this.matchStat = -1;
        return null;
    L108:
        int r129 = this.f24933bp + r127;
        this.f24933bp = r129;
        this.f24934ch = charAt(r129);
        this.matchStat = 5;
        this.token = 13;
        return null;
    L104:
        int r130 = this.f24933bp + r127;
        this.f24933bp = r130;
        this.f24934ch = charAt(r130);
        this.matchStat = 5;
        this.token = 16;
        return null;
    L15:
        r111 = false;
        goto L16
    L9:
        r103 = false;
        goto L10
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:59:0x00dc -> B:55:0x00c8). Please report as a decompilation issue!!! */
    public final double scanFieldDouble(char[] r210) {
        this.matchStat = 0;
        if (charArrayCompare(r210) == true) goto L6;
        this.matchStat = -2;
        return AudioStats.AUDIO_AMPLITUDE_NONE;
    L6:
        int r100 = r210.length;
        int r101 = r100 + 1;
        char r102 = charAt(this.f24933bp + r100);
        if (r102 != '\"') goto L9;
        boolean r103 = true;
    L10:
        if (r103 == false) goto L13;
        r102 = charAt(this.f24933bp + r101);
        r101 = r101 + 1;
    L13:
        if (r102 != '-') goto L15;
        boolean r110 = true;
    L16:
        if (r110 == false) goto L19;
        r102 = charAt(this.f24933bp + r101);
        r101 = r101 + 1;
    L19:
        if (r102 >= '0') goto L21;
    L98:
        boolean r211 = r103;
        if (r102 == 'n') goto L101;
    L124:
        this.matchStat = -1;
        return AudioStats.AUDIO_AMPLITUDE_NONE;
    L101:
        if (charAt(this.f24933bp + r101) != 'u') goto L124;
        if (charAt((this.f24933bp + r101) + 1) != 'l') goto L124;
        if (charAt((this.f24933bp + r101) + 2) != 'l') goto L124;
        this.matchStat = 5;
        int r104 = r101 + 3;
        int r105 = r104 + 1;
        char r106 = charAt(this.f24933bp + r104);
        if (r211 == false) goto L112;
        if (r106 != '\"') goto L112;
        r106 = charAt(this.f24933bp + r105);
        r105 = r105 + 1;
    L112:
        if (r106 == ',') goto L113;
        if (r106 == '}') goto L117;
        if (isWhitespace(r106) == false) goto L122;
        r106 = charAt(this.f24933bp + r105);
        r105 = r105 + 1;
        goto L112
    L122:
        this.matchStat = -1;
        return AudioStats.AUDIO_AMPLITUDE_NONE;
    L117:
        int r107 = this.f24933bp + r105;
        this.f24933bp = r107;
        this.f24934ch = charAt(r107);
        this.matchStat = 5;
        this.token = 13;
        return AudioStats.AUDIO_AMPLITUDE_NONE;
    L113:
        int r108 = this.f24933bp + r105;
        this.f24933bp = r108;
        this.f24934ch = charAt(r108);
        this.matchStat = 5;
        this.token = 16;
        return AudioStats.AUDIO_AMPLITUDE_NONE;
    L21:
        if (r102 > '9') goto L98;
        long r109 = r102 - '0';
    L23:
        int r111 = r101 + 1;
        char r112 = charAt(this.f24933bp + r101);
        if (r112 < '0') goto L28;
        if (r112 > '9') goto L28;
        r109 = (r109 * 10) + ((long) (r112 - '0'));
        r101 = r111;
    L28:
        if (r112 != '.') goto L30;
        boolean r113 = true;
    L31:
        if (r113 == false) goto L42;
        int r114 = r111 + 1;
        char r115 = charAt(this.f24933bp + r111);
        if (r115 < '0') goto L40;
        if (r115 > '9') goto L40;
        boolean r212 = r103;
        r109 = (r109 * 10) + ((long) (r115 - '0'));
        long r116 = 10;
    L36:
        r111 = r114 + 1;
        r112 = charAt(this.f24933bp + r114);
        if (r112 < '0') goto L44;
        if (r112 > '9') goto L44;
        r109 = (r109 * 10) + ((long) (r112 - '0'));
        r116 = r116 * 10;
        r114 = r111;
    L44:
        if (r112 != 'e') goto L46;
    L49:
        boolean r117 = true;
    L50:
        if (r117 == false) goto L60;
        int r118 = r111 + 1;
        char r119 = charAt(this.f24933bp + r111);
        if (r119 == '+') goto L56;
        if (r119 == '-') goto L56;
    L55:
        r111 = r118;
        r112 = r119;
    L57:
        if (r112 < '0') goto L60;
        if (r112 > '9') goto L60;
        r118 = r111 + 1;
        r119 = charAt(this.f24933bp + r111);
    L56:
        int r120 = r118 + 1;
        r112 = charAt(this.f24933bp + r118);
        r111 = r120;
    L60:
        if (r212 == true) goto L62;
        int r121 = this.f24933bp;
        int r122 = r210.length + r121;
        int r123 = ((r121 + r111) - r122) - 1;
    L67:
        if (r117 == false) goto L69;
    L73:
        double r124 = CastDoubleProtector.parseDouble(subString(r122, r123));
    L75:
        if (r112 != ',') goto L79;
        int r125 = this.f24933bp + r111;
        this.f24933bp = r125;
        this.f24934ch = charAt(r125);
        this.matchStat = 3;
        this.token = 16;
        return r124;
    L79:
        if (r112 != '}') goto L96;
        int r126 = r111 + 1;
        char r127 = charAt(this.f24933bp + r111);
        if (r127 != ',') goto L84;
        this.token = 16;
        int r128 = this.f24933bp + r126;
        this.f24933bp = r128;
        this.f24934ch = charAt(r128);
    L92:
        this.matchStat = 4;
        return r124;
    L84:
        if (r127 != ']') goto L87;
        this.token = 15;
        int r129 = this.f24933bp + r126;
        this.f24933bp = r129;
        this.f24934ch = charAt(r129);
        goto L92
    L87:
        if (r127 != '}') goto L90;
        this.token = 13;
        int r130 = this.f24933bp + r126;
        this.f24933bp = r130;
        this.f24934ch = charAt(r130);
        goto L92
    L90:
        if (r127 != 26) goto L94;
        this.token = 20;
        this.f24933bp += r126 - 1;
        this.f24934ch = JSONLexer.EOI;
        goto L92
    L94:
        this.matchStat = -1;
        return AudioStats.AUDIO_AMPLITUDE_NONE;
    L96:
        this.matchStat = -1;
        return AudioStats.AUDIO_AMPLITUDE_NONE;
    L69:
        if (r123 >= 17) goto L73;
        r124 = r109 / r116;
        if (r110 == false) goto L75;
        r124 = -r124;
        goto L75
    L62:
        if (r112 == '\"') goto L65;
        this.matchStat = -1;
        return AudioStats.AUDIO_AMPLITUDE_NONE;
    L65:
        int r131 = r111 + 1;
        char r132 = charAt(this.f24933bp + r111);
        int r133 = this.f24933bp;
        r122 = (r210.length + r133) + 1;
        r123 = ((r133 + r131) - r122) - 2;
        r111 = r131;
        r112 = r132;
        goto L67
    L46:
        if (r112 == 'E') goto L49;
        r117 = false;
    L40:
        this.matchStat = -1;
        return AudioStats.AUDIO_AMPLITUDE_NONE;
    L42:
        r212 = r103;
        r116 = 1;
        goto L44
    L30:
        r113 = false;
        goto L31
    L15:
        r110 = false;
        goto L16
    L9:
        r103 = false;
        goto L10
    }

    public final float scanFieldFloat(char[] r210) {
        this.matchStat = 0;
        if (charArrayCompare(r210) == true) goto L6;
        this.matchStat = -2;
        return 0.0f;
    L6:
        int r100 = r210.length;
        int r101 = r100 + 1;
        char r102 = charAt(this.f24933bp + r100);
        if (r102 != '\"') goto L9;
        boolean r103 = true;
    L10:
        if (r103 == false) goto L13;
        r102 = charAt(this.f24933bp + r101);
        r101 = r101 + 1;
    L13:
        if (r102 != '-') goto L15;
        boolean r110 = true;
    L16:
        if (r110 == false) goto L19;
        r102 = charAt(this.f24933bp + r101);
        r101 = r101 + 1;
    L19:
        if (r102 < '0') goto L100;
        char r111 = '9';
        if (r102 > '9') goto L100;
        long r112 = r102 - '0';
    L23:
        int r113 = r101 + 1;
        char r104 = charAt(this.f24933bp + r101);
        if (r104 < '0') goto L28;
        if (r104 > '9') goto L28;
        r112 = (r112 * 10) + ((long) (r104 - '0'));
        r101 = r113;
    L28:
        if (r104 != '.') goto L30;
        boolean r105 = true;
    L31:
        if (r105 == false) goto L42;
        int r106 = r113 + 1;
        char r107 = charAt(this.f24933bp + r113);
        if (r107 < '0') goto L40;
        if (r107 > '9') goto L40;
        boolean r211 = r103;
        r112 = (r112 * 10) + ((long) (r107 - '0'));
        long r108 = 10;
    L36:
        r113 = r106 + 1;
        r104 = charAt(this.f24933bp + r106);
        if (r104 < '0') goto L44;
        if (r104 > r111) goto L44;
        r112 = (r112 * 10) + ((long) (r104 - '0'));
        r108 = r108 * 10;
        r106 = r113;
        r111 = '9';
    L44:
        if (r104 != 'e') goto L46;
    L49:
        boolean r114 = true;
    L50:
        if (r114 == false) goto L62;
        int r115 = r113 + 1;
        r104 = charAt(this.f24933bp + r113);
        if (r104 == '+') goto L56;
        if (r104 == '-') goto L56;
        r113 = r115;
    L58:
        if (r104 < '0') goto L62;
        if (r104 > '9') goto L62;
        int r109 = r113 + 1;
        r104 = charAt(this.f24933bp + r113);
        r113 = r109;
    L56:
        int r116 = r115 + 1;
        r104 = charAt(this.f24933bp + r115);
        r113 = r116;
    L62:
        if (r211 == true) goto L64;
        int r117 = this.f24933bp;
        int r118 = r210.length + r117;
        int r119 = ((r117 + r113) - r118) - 1;
    L69:
        if (r114 == false) goto L71;
    L75:
        float r120 = CastFloatProtector.parseFloat(subString(r118, r119));
    L77:
        if (r104 != ',') goto L81;
        int r121 = this.f24933bp + r113;
        this.f24933bp = r121;
        this.f24934ch = charAt(r121);
        this.matchStat = 3;
        this.token = 16;
        return r120;
    L81:
        if (r104 != '}') goto L98;
        int r122 = r113 + 1;
        char r123 = charAt(this.f24933bp + r113);
        if (r123 != ',') goto L86;
        this.token = 16;
        int r124 = this.f24933bp + r122;
        this.f24933bp = r124;
        this.f24934ch = charAt(r124);
    L94:
        this.matchStat = 4;
        return r120;
    L86:
        if (r123 != ']') goto L89;
        this.token = 15;
        int r125 = this.f24933bp + r122;
        this.f24933bp = r125;
        this.f24934ch = charAt(r125);
        goto L94
    L89:
        if (r123 != '}') goto L92;
        this.token = 13;
        int r126 = this.f24933bp + r122;
        this.f24933bp = r126;
        this.f24934ch = charAt(r126);
        goto L94
    L92:
        if (r123 != 26) goto L96;
        this.f24933bp += r122 - 1;
        this.token = 20;
        this.f24934ch = JSONLexer.EOI;
        goto L94
    L96:
        this.matchStat = -1;
        return 0.0f;
    L98:
        this.matchStat = -1;
        return 0.0f;
    L71:
        if (r119 >= 17) goto L75;
        r120 = (float) (r112 / r108);
        if (r110 == false) goto L77;
        r120 = -r120;
        goto L77
    L64:
        if (r104 == '\"') goto L67;
        this.matchStat = -1;
        return 0.0f;
    L67:
        int r127 = r113 + 1;
        r104 = charAt(this.f24933bp + r113);
        int r128 = this.f24933bp;
        r118 = (r210.length + r128) + 1;
        r119 = ((r128 + r127) - r118) - 2;
        r113 = r127;
        goto L69
    L46:
        if (r104 == 'E') goto L49;
        r114 = false;
    L40:
        this.matchStat = -1;
        return 0.0f;
    L42:
        r211 = r103;
        r108 = 1;
        goto L44
    L30:
        r105 = false;
    L100:
        boolean r212 = r103;
        if (r102 == 'n') goto L103;
    L126:
        this.matchStat = -1;
        return 0.0f;
    L103:
        if (charAt(this.f24933bp + r101) != 'u') goto L126;
        if (charAt((this.f24933bp + r101) + 1) != 'l') goto L126;
        if (charAt((this.f24933bp + r101) + 2) != 'l') goto L126;
        this.matchStat = 5;
        int r129 = r101 + 3;
        int r130 = r129 + 1;
        char r131 = charAt(this.f24933bp + r129);
        if (r212 == false) goto L114;
        if (r131 != '\"') goto L114;
        r131 = charAt(this.f24933bp + r130);
        r130 = r130 + 1;
    L114:
        if (r131 == ',') goto L115;
        if (r131 == '}') goto L119;
        if (isWhitespace(r131) == false) goto L124;
        r131 = charAt(this.f24933bp + r130);
        r130 = r130 + 1;
        goto L114
    L124:
        this.matchStat = -1;
        return 0.0f;
    L119:
        int r132 = this.f24933bp + r130;
        this.f24933bp = r132;
        this.f24934ch = charAt(r132);
        this.matchStat = 5;
        this.token = 13;
        return 0.0f;
    L115:
        int r133 = this.f24933bp + r130;
        this.f24933bp = r133;
        this.f24934ch = charAt(r133);
        this.matchStat = 5;
        this.token = 16;
        return 0.0f;
    L15:
        r110 = false;
        goto L16
    L9:
        r103 = false;
        goto L10
    }

    public final float[] scanFieldFloatArray(char[] r210) {
        this.matchStat = 0;
        float[] r100 = null;
        if (charArrayCompare(r210) == true) goto L6;
        this.matchStat = -2;
        return null;
    L6:
        int r101 = r210.length;
        int r102 = r101 + 1;
        if (charAt(this.f24933bp + r101) == '[') goto L10;
        this.matchStat = -2;
        return null;
    L10:
        int r103 = r102 + 1;
        char r104 = charAt(this.f24933bp + r102);
        float[] r105 = new float[16];
        int r106 = 0;
    L11:
        int r107 = this.f24933bp;
        int r108 = (r107 + r103) - 1;
        if (r104 != '-') goto L14;
        boolean r110 = true;
    L15:
        if (r110 == false) goto L18;
        int r109 = r103 + 1;
        char r111 = charAt(r107 + r103);
        r103 = r109;
        r104 = r111;
    L18:
        if (r104 < '0') goto L103;
        if (r104 > '9') goto L103;
        int r112 = r104 - '0';
    L22:
        int r113 = r103 + 1;
        char r114 = charAt(this.f24933bp + r103);
        if (r114 < '0') goto L27;
        if (r114 > '9') goto L27;
        r112 = (r112 * 10) + (r114 - '0');
        r103 = r113;
    L27:
        if (r114 != '.') goto L29;
        boolean r115 = true;
    L31:
        if (r115 == false) goto L43;
        int r116 = r113 + 1;
        char r117 = charAt(this.f24933bp + r113);
        if (r117 < '0') goto L41;
        if (r117 > '9') goto L41;
        r112 = (r112 * 10) + (r117 - '0');
        int r118 = 10;
    L36:
        r113 = r116 + 1;
        char r119 = charAt(this.f24933bp + r116);
        if (r119 < '0') goto L40;
        if (r119 > '9') goto L40;
        r112 = (r112 * 10) + (r119 - '0');
        r118 = r118 * 10;
        r116 = r113;
    L40:
        int r120 = r118;
        r114 = r119;
        int r121 = r120;
    L45:
        if (r114 != 'e') goto L47;
    L50:
        boolean r122 = true;
    L51:
        if (r122 == false) goto L62;
        int r123 = r113 + 1;
        r114 = charAt(this.f24933bp + r113);
        if (r114 == '+') goto L57;
        if (r114 == '-') goto L57;
        r113 = r123;
    L59:
        if (r114 < '0') goto L62;
        if (r114 > '9') goto L62;
        int r124 = r113 + 1;
        r114 = charAt(this.f24933bp + r113);
        r113 = r124;
    L57:
        int r125 = r123 + 1;
        r114 = charAt(this.f24933bp + r123);
        r113 = r125;
    L62:
        int r126 = ((this.f24933bp + r113) - r108) - 1;
        if (r122 == true) goto L68;
        if (r126 >= 10) goto L68;
        float r127 = r112 / r121;
        if (r110 == false) goto L70;
        r127 = -r127;
    L70:
        if (r106 < r105.length) goto L72;
        float[] r128 = new float[(r105.length * 3) / 2];
        System.arraycopy(r105, 0, r128, 0, r106);
        r105 = r128;
    L72:
        int r129 = r106 + 1;
        r105[r106] = r127;
        if (r114 != ',') goto L76;
        r103 = r113 + 1;
        r104 = charAt(this.f24933bp + r113);
        float[] r130 = null;
    L102:
        r100 = r130;
        r106 = r129;
        goto L11
    L76:
        if (r114 == ']') goto L77;
        r130 = null;
        r104 = r114;
        r103 = r113;
        goto L102
    L77:
        int r131 = r113 + 1;
        char r132 = charAt(this.f24933bp + r113);
        if (r129 == r105.length) goto L80;
        float[] r133 = new float[r129];
        System.arraycopy(r105, 0, r133, 0, r129);
        r105 = r133;
    L80:
        if (r132 != ',') goto L84;
        this.f24933bp += r131 - 1;
        next();
        this.matchStat = 3;
        this.token = 16;
        return r105;
    L84:
        if (r132 != '}') goto L99;
        int r134 = r131 + 1;
        char r135 = charAt(this.f24933bp + r131);
        if (r135 != ',') goto L88;
        this.token = 16;
        this.f24933bp += r134 - 1;
        next();
    L95:
        this.matchStat = 4;
        return r105;
    L88:
        if (r135 != ']') goto L90;
        this.token = 15;
        this.f24933bp += r134 - 1;
        next();
        goto L95
    L90:
        if (r135 != '}') goto L93;
        this.token = 13;
        this.f24933bp += r134 - 1;
        next();
        goto L95
    L93:
        if (r135 != 26) goto L97;
        this.f24933bp += r134 - 1;
        this.token = 20;
        this.f24934ch = JSONLexer.EOI;
        goto L95
    L97:
        this.matchStat = -1;
        return null;
    L99:
        this.matchStat = -1;
        return null;
    L68:
        r127 = CastFloatProtector.parseFloat(subString(r108, r126));
        goto L70
    L47:
        if (r114 == 'E') goto L50;
        r122 = false;
    L41:
        this.matchStat = -1;
        return r100;
    L43:
        r121 = 1;
        goto L45
    L29:
        r115 = false;
    L103:
        float[] r136 = r100;
        this.matchStat = -1;
        return r136;
    L14:
        r110 = false;
        goto L15
    }

    public final float[][] scanFieldFloatArray2(char[] r210) {
        this.matchStat = 0;
        float[][] r100 = null;
        if (charArrayCompare(r210) == true) goto L6;
        this.matchStat = -2;
        return null;
    L6:
        int r101 = r210.length;
        int r102 = r101 + 1;
        char r103 = '[';
        if (charAt(this.f24933bp + r101) == '[') goto L10;
        this.matchStat = -2;
        return null;
    L10:
        int r104 = r102 + 1;
        char r105 = charAt(this.f24933bp + r102);
        int r106 = 16;
        float[][] r107 = new float[16][];
        int r108 = 0;
    L12:
        if (r105 != r103) goto L97;
        int r110 = r104 + 1;
        char r109 = charAt(this.f24933bp + r104);
        float[] r111 = new float[r106];
        int r112 = 0;
    L14:
        int r113 = this.f24933bp;
        int r114 = (r113 + r110) - 1;
        if (r109 != '-') goto L17;
        boolean r115 = true;
    L18:
        if (r115 == false) goto L21;
        char r116 = charAt(r113 + r110);
        r110 = r110 + 1;
        r109 = r116;
    L21:
        if (r109 < '0') goto L94;
        if (r109 > '9') goto L94;
        int r117 = r109 - '0';
    L25:
        int r118 = r110 + 1;
        char r119 = charAt(this.f24933bp + r110);
        if (r119 < '0') goto L30;
        if (r119 > '9') goto L30;
        r117 = (r117 * 10) + (r119 - '0');
        r110 = r118;
    L30:
        if (r119 != '.') goto L42;
        int r120 = r118 + 1;
        char r121 = charAt(this.f24933bp + r118);
        if (r121 < '0') goto L40;
        if (r121 > '9') goto L40;
        int r122 = (r117 * 10) + (r121 - '0');
        int r123 = 10;
    L35:
        r118 = r120 + 1;
        char r124 = charAt(this.f24933bp + r120);
        if (r124 < '0') goto L39;
        if (r124 > '9') goto L39;
        r122 = (r122 * 10) + (r124 - '0');
        r123 = r123 * 10;
        r120 = r118;
    L39:
        int r211 = r122;
        int r125 = r123;
        r119 = r124;
        int r126 = r211;
    L44:
        if (r119 != 'e') goto L46;
    L49:
        boolean r127 = true;
    L50:
        if (r127 == false) goto L61;
        int r128 = r118 + 1;
        r119 = charAt(this.f24933bp + r118);
        if (r119 == '+') goto L56;
        if (r119 == '-') goto L56;
        r118 = r128;
    L58:
        if (r119 < '0') goto L61;
        if (r119 > '9') goto L61;
        int r129 = r118 + 1;
        r119 = charAt(this.f24933bp + r118);
        r118 = r129;
    L56:
        int r130 = r128 + 1;
        r119 = charAt(this.f24933bp + r128);
        r118 = r130;
    L61:
        int r131 = ((this.f24933bp + r118) - r114) - 1;
        if (r127 == false) goto L64;
    L68:
        float r132 = CastFloatProtector.parseFloat(subString(r114, r131));
    L70:
        if (r112 < r111.length) goto L72;
        float[] r133 = new float[(r111.length * 3) / 2];
        System.arraycopy(r111, 0, r133, 0, r112);
        r111 = r133;
    L72:
        int r134 = r112 + 1;
        r111[r112] = r132;
        if (r119 != ',') goto L76;
        r119 = charAt(this.f24933bp + r118);
        r110 = r118 + 1;
    L93:
        r112 = r134;
        r100 = null;
        r109 = r119;
        goto L14
    L76:
        if (r119 == ']') goto L77;
        r110 = r118;
        goto L93
    L77:
        int r135 = r118 + 1;
        char r136 = charAt(this.f24933bp + r118);
        if (r134 == r111.length) goto L80;
        float[] r137 = new float[r134];
        int r138 = 0;
        System.arraycopy(r111, 0, r137, 0, r134);
        r111 = r137;
    L82:
        if (r108 < r107.length) goto L84;
        float[][] r139 = new float[(r107.length * 3) / 2][];
        System.arraycopy(r111, r138, r139, r138, r134);
        r107 = r139;
    L84:
        int r140 = r108 + 1;
        r107[r108] = r111;
        if (r136 != ',') goto L88;
        r104 = r135 + 1;
        r105 = charAt(this.f24933bp + r135);
    L91:
        r108 = r140;
        r100 = null;
        r103 = '[';
        r106 = 16;
        goto L12
    L88:
        if (r136 == ']') goto L89;
        r105 = r136;
        r104 = r135;
        goto L91
    L89:
        r104 = r135 + 1;
        r105 = charAt(this.f24933bp + r135);
        r108 = r140;
        goto L97
    L80:
        r138 = 0;
        goto L82
    L64:
        if (r131 >= 10) goto L68;
        r132 = r126 / r125;
        if (r115 == false) goto L70;
        r132 = -r132;
        goto L70
    L46:
        if (r119 == 'E') goto L49;
        r127 = false;
    L40:
        this.matchStat = -1;
        return r100;
    L42:
        r126 = r117;
        r125 = 1;
    L94:
        this.matchStat = -1;
        return null;
    L17:
        r115 = false;
    L97:
        if (r108 == r107.length) goto L100;
        float[][] r141 = new float[r108][];
        System.arraycopy(r107, 0, r141, 0, r108);
        r107 = r141;
    L100:
        if (r105 != ',') goto L104;
        this.f24933bp += r104 - 1;
        next();
        this.matchStat = 3;
        this.token = 16;
        return r107;
    L104:
        if (r105 != '}') goto L120;
        int r142 = r104 + 1;
        char r143 = charAt(this.f24933bp + r104);
        if (r143 != ',') goto L109;
        this.token = 16;
        this.f24933bp += r142 - 1;
        next();
    L116:
        this.matchStat = 4;
        return r107;
    L109:
        if (r143 != ']') goto L111;
        this.token = 15;
        this.f24933bp += r142 - 1;
        next();
        goto L116
    L111:
        if (r143 != '}') goto L114;
        this.token = 13;
        this.f24933bp += r142 - 1;
        next();
        goto L116
    L114:
        if (r143 != 26) goto L118;
        this.f24933bp += r142 - 1;
        this.token = 20;
        this.f24934ch = JSONLexer.EOI;
        goto L116
    L118:
        this.matchStat = -1;
        return null;
    L120:
        this.matchStat = -1;
        return null;
    }

    public int scanFieldInt(char[] r110) {
        this.matchStat = 0;
        if (charArrayCompare(r110) == true) goto L6;
        this.matchStat = -2;
        return 0;
    L6:
        int r100 = r110.length;
        int r101 = r100 + 1;
        char r102 = charAt(this.f24933bp + r100);
        if (r102 != '-') goto L9;
        boolean r103 = true;
    L10:
        if (r103 == false) goto L13;
        r102 = charAt(this.f24933bp + r101);
        r101 = r101 + 1;
    L13:
        if (r102 >= '0') goto L15;
    L63:
        this.matchStat = -1;
        return 0;
    L15:
        if (r102 > '9') goto L63;
        int r104 = r102 - '0';
    L17:
        int r105 = r101 + 1;
        char r106 = charAt(this.f24933bp + r101);
        if (r106 < '0') goto L22;
        if (r106 > '9') goto L22;
        r104 = (r104 * 10) + (r106 - '0');
        r101 = r105;
    L22:
        if (r106 != '.') goto L25;
        this.matchStat = -1;
        return 0;
    L25:
        if (r104 < 0) goto L29;
        if (r105 > (r110.length + 14)) goto L29;
    L35:
        if (r106 != ',') goto L41;
        int r107 = this.f24933bp + r105;
        this.f24933bp = r107;
        this.f24934ch = charAt(r107);
        this.matchStat = 3;
        this.token = 16;
        if (r103 == true) goto L39;
        return r104;
    L39:
        return -r104;
    L41:
        if (r106 != '}') goto L59;
        int r108 = r105 + 1;
        char r109 = charAt(this.f24933bp + r105);
        if (r109 != ',') goto L46;
        this.token = 16;
        int r111 = this.f24933bp + r108;
        this.f24933bp = r111;
        this.f24934ch = charAt(r111);
    L53:
        this.matchStat = 4;
        if (r103 == true) goto L56;
        return r104;
    L56:
        return -r104;
    L46:
        if (r109 != ']') goto L48;
        this.token = 15;
        int r112 = this.f24933bp + r108;
        this.f24933bp = r112;
        this.f24934ch = charAt(r112);
        goto L53
    L48:
        if (r109 != '}') goto L51;
        this.token = 13;
        int r113 = this.f24933bp + r108;
        this.f24933bp = r113;
        this.f24934ch = charAt(r113);
        goto L53
    L51:
        if (r109 != 26) goto L57;
        this.token = 20;
        this.f24933bp += r108 - 1;
        this.f24934ch = JSONLexer.EOI;
        goto L53
    L57:
        this.matchStat = -1;
        return 0;
    L59:
        this.matchStat = -1;
        return 0;
    L29:
        if (r104 == Integer.MIN_VALUE) goto L31;
    L61:
        this.matchStat = -1;
        return 0;
    L31:
        if (r105 != 17) goto L61;
        if (r103 == true) goto L35;
    L9:
        r103 = false;
        goto L10
    }

    public final int[] scanFieldIntArray(char[] r110) {
        this.matchStat = 0;
        int[] r100 = null;
        if (charArrayCompare(r110) == true) goto L6;
        this.matchStat = -2;
        return null;
    L6:
        int r101 = r110.length;
        int r102 = r101 + 1;
        if (charAt(this.f24933bp + r101) == '[') goto L10;
        this.matchStat = -2;
        return null;
    L10:
        int r103 = r102 + 1;
        char r104 = charAt(this.f24933bp + r102);
        int[] r105 = new int[16];
        if (r104 != ']') goto L13;
        int r111 = r103 + 1;
        char r106 = charAt(this.f24933bp + r103);
        int r107 = 0;
    L39:
        if (r107 == r105.length) goto L41;
        int[] r108 = new int[r107];
        System.arraycopy(r105, 0, r108, 0, r107);
        r105 = r108;
    L41:
        if (r106 != ',') goto L45;
        this.f24933bp += r111 - 1;
        next();
        this.matchStat = 3;
        this.token = 16;
        return r105;
    L45:
        if (r106 != '}') goto L60;
        int r109 = r111 + 1;
        char r112 = charAt(this.f24933bp + r111);
        if (r112 != ',') goto L49;
        this.token = 16;
        this.f24933bp += r109 - 1;
        next();
    L56:
        this.matchStat = 4;
        return r105;
    L49:
        if (r112 != ']') goto L51;
        this.token = 15;
        this.f24933bp += r109 - 1;
        next();
        goto L56
    L51:
        if (r112 != '}') goto L54;
        this.token = 13;
        this.f24933bp += r109 - 1;
        next();
        goto L56
    L54:
        if (r112 != 26) goto L58;
        this.f24933bp += r109 - 1;
        this.token = 20;
        this.f24934ch = JSONLexer.EOI;
        goto L56
    L58:
        this.matchStat = -1;
        return null;
    L60:
        this.matchStat = -1;
        return null;
    L13:
        int r113 = 0;
    L15:
        if (r104 != '-') goto L17;
        r104 = charAt(this.f24933bp + r103);
        r103 = r103 + 1;
        boolean r114 = true;
    L19:
        if (r104 < '0') goto L63;
        if (r104 > '9') goto L63;
        int r115 = r104 - '0';
    L23:
        int r116 = r103 + 1;
        char r117 = charAt(this.f24933bp + r103);
        if (r117 < '0') goto L28;
        if (r117 > '9') goto L28;
        r115 = (r115 * 10) + (r117 - '0');
        r103 = r116;
    L28:
        if (r113 < r105.length) goto L30;
        int[] r118 = new int[(r105.length * 3) / 2];
        System.arraycopy(r105, 0, r118, 0, r113);
        r105 = r118;
    L30:
        r107 = r113 + 1;
        if (r114 == false) goto L33;
        r115 = -r115;
    L33:
        r105[r113] = r115;
        if (r117 != ',') goto L36;
        char r119 = charAt(this.f24933bp + r116);
        r116 = r116 + 1;
        r117 = r119;
    L62:
        r113 = r107;
        r100 = null;
        r104 = r117;
        r103 = r116;
        goto L15
    L36:
        if (r117 != ']') goto L62;
        r111 = r116 + 1;
        r106 = charAt(this.f24933bp + r116);
    L63:
        int[] r120 = r100;
        this.matchStat = -1;
        return r120;
    L17:
        r114 = false;
        goto L19
    }

    public long scanFieldLong(char[] r110) {
        this.matchStat = 0;
        if (charArrayCompare(r110) == true) goto L6;
        this.matchStat = -2;
        return 0;
    L6:
        int r100 = r110.length;
        int r101 = r100 + 1;
        char r102 = charAt(this.f24933bp + r100);
        if (r102 != '-') goto L9;
        r102 = charAt(this.f24933bp + r101);
        r101 = r101 + 1;
        boolean r103 = true;
    L11:
        if (r102 >= '0') goto L13;
    L62:
        this.matchStat = -1;
        return 0;
    L13:
        if (r102 > '9') goto L62;
        long r111 = r102 - '0';
    L15:
        int r112 = r101 + 1;
        char r104 = charAt(this.f24933bp + r101);
        if (r104 < '0') goto L20;
        if (r104 > '9') goto L20;
        r111 = (r111 * 10) + ((long) (r104 - '0'));
        r101 = r112;
    L20:
        if (r104 != '.') goto L24;
        this.matchStat = -1;
        return 0;
    L24:
        if ((r112 - r110.length) < 21) goto L26;
    L31:
        boolean r105 = false;
    L32:
        if (r105 == true) goto L36;
        this.matchStat = -1;
        return 0;
    L36:
        if (r104 != ',') goto L42;
        int r106 = this.f24933bp + r112;
        this.f24933bp = r106;
        this.f24934ch = charAt(r106);
        this.matchStat = 3;
        this.token = 16;
        if (r103 == true) goto L40;
        return r111;
    L40:
        return -r111;
    L42:
        if (r104 != '}') goto L60;
        int r107 = r112 + 1;
        char r108 = charAt(this.f24933bp + r112);
        if (r108 != ',') goto L47;
        this.token = 16;
        int r109 = this.f24933bp + r107;
        this.f24933bp = r109;
        this.f24934ch = charAt(r109);
    L54:
        this.matchStat = 4;
        if (r103 == true) goto L57;
        return r111;
    L57:
        return -r111;
    L47:
        if (r108 != ']') goto L49;
        this.token = 15;
        int r113 = this.f24933bp + r107;
        this.f24933bp = r113;
        this.f24934ch = charAt(r113);
        goto L54
    L49:
        if (r108 != '}') goto L52;
        this.token = 13;
        int r114 = this.f24933bp + r107;
        this.f24933bp = r114;
        this.f24934ch = charAt(r114);
        goto L54
    L52:
        if (r108 != 26) goto L58;
        this.token = 20;
        this.f24933bp += r107 - 1;
        this.f24934ch = JSONLexer.EOI;
        goto L54
    L58:
        this.matchStat = -1;
        return 0;
    L60:
        this.matchStat = -1;
        return 0;
    L26:
        if (r111 < 0) goto L28;
    L30:
        r105 = true;
        goto L32
    L28:
        if (r111 != Long.MIN_VALUE) goto L31;
        if (r103 == false) goto L31;
    L9:
        r103 = false;
        goto L11
    }

    public String scanFieldString(char[] r110) {
        this.matchStat = 0;
        if (charArrayCompare(r110) == true) goto L6;
        this.matchStat = -2;
        return stringDefaultValue();
    L6:
        int r100 = r110.length;
        int r101 = r100 + 1;
        if (charAt(this.f24933bp + r100) == '\"') goto L10;
        this.matchStat = -1;
        return stringDefaultValue();
    L10:
        int r102 = indexOf(Typography.quote, (this.f24933bp + r110.length) + 1);
        if (r102 == (-1)) goto L47;
        int r103 = (this.f24933bp + r110.length) + 1;
        String r104 = subString(r103, r102 - r103);
        if (r104.indexOf(92) == (-1)) goto L23;
    L14:
        int r105 = r102 - 1;
        int r106 = 0;
    L15:
        if (r105 < 0) goto L20;
        if (charAt(r105) != '\\') goto L20;
        r106 = r106 + 1;
        r105 = r105 - 1;
    L20:
        if ((r106 % 2) == 0) goto L21;
        r102 = indexOf(Typography.quote, r102 + 1);
        goto L14
    L21:
        int r107 = this.f24933bp;
        int r108 = r102 - ((r110.length + r107) + 1);
        r104 = readString(sub_chars((r107 + r110.length) + 1, r108), r108);
    L23:
        int r109 = this.f24933bp;
        int r111 = r101 + ((r102 - ((r110.length + r109) + 1)) + 1);
        int r112 = r111 + 1;
        char r113 = charAt(r109 + r111);
        if (r113 != ',') goto L28;
        int r114 = this.f24933bp + r112;
        this.f24933bp = r114;
        this.f24934ch = charAt(r114);
        this.matchStat = 3;
        return r104;
    L28:
        if (r113 != '}') goto L44;
        int r115 = r112 + 1;
        char r116 = charAt(this.f24933bp + r112);
        if (r116 != ',') goto L33;
        this.token = 16;
        int r117 = this.f24933bp + r115;
        this.f24933bp = r117;
        this.f24934ch = charAt(r117);
    L40:
        this.matchStat = 4;
        return r104;
    L33:
        if (r116 != ']') goto L35;
        this.token = 15;
        int r118 = this.f24933bp + r115;
        this.f24933bp = r118;
        this.f24934ch = charAt(r118);
        goto L40
    L35:
        if (r116 != '}') goto L38;
        this.token = 13;
        int r119 = this.f24933bp + r115;
        this.f24933bp = r119;
        this.f24934ch = charAt(r119);
        goto L40
    L38:
        if (r116 != 26) goto L42;
        this.token = 20;
        this.f24933bp += r115 - 1;
        this.f24934ch = JSONLexer.EOI;
        goto L40
    L42:
        this.matchStat = -1;
        return stringDefaultValue();
    L44:
        this.matchStat = -1;
        return stringDefaultValue();
    L47:
        throw new JSONException("unclosed str");
    }

    public long scanFieldSymbol(char[] r110) {
        this.matchStat = 0;
        if (charArrayCompare(r110) == true) goto L6;
        this.matchStat = -2;
        return 0;
    L6:
        int r111 = r110.length;
        int r100 = r111 + 1;
        if (charAt(this.f24933bp + r111) == '\"') goto L10;
        this.matchStat = -1;
        return 0;
    L10:
        long r101 = TypeUtils.fnv1a_64_magic_hashcode;
    L11:
        int r102 = r100 + 1;
        char r112 = charAt(this.f24933bp + r100);
        if (r112 == '\"') goto L13;
        r101 = (r101 ^ ((long) r112)) * TypeUtils.fnv1a_64_magic_prime;
        if (r112 == '\\') goto L38;
        r100 = r102;
        goto L11
    L38:
        this.matchStat = -1;
        return 0;
    L13:
        int r103 = r102 + 1;
        char r113 = charAt(this.f24933bp + r102);
        if (r113 != ',') goto L18;
        int r114 = this.f24933bp + r103;
        this.f24933bp = r114;
        this.f24934ch = charAt(r114);
        this.matchStat = 3;
        return r101;
    L18:
        if (r113 != '}') goto L34;
        int r104 = r103 + 1;
        char r115 = charAt(this.f24933bp + r103);
        if (r115 != ',') goto L23;
        this.token = 16;
        int r116 = this.f24933bp + r104;
        this.f24933bp = r116;
        this.f24934ch = charAt(r116);
    L30:
        this.matchStat = 4;
        return r101;
    L23:
        if (r115 != ']') goto L25;
        this.token = 15;
        int r117 = this.f24933bp + r104;
        this.f24933bp = r117;
        this.f24934ch = charAt(r117);
        goto L30
    L25:
        if (r115 != '}') goto L28;
        this.token = 13;
        int r118 = this.f24933bp + r104;
        this.f24933bp = r118;
        this.f24934ch = charAt(r118);
        goto L30
    L28:
        if (r115 != 26) goto L32;
        this.token = 20;
        this.f24933bp += r104 - 1;
        this.f24934ch = JSONLexer.EOI;
        goto L30
    L32:
        this.matchStat = -1;
        return 0;
    L34:
        this.matchStat = -1;
        return 0;
    }

    public UUID scanFieldUUID(char[] r210) {
        this.matchStat = 0;
        if (charArrayCompare(r210) == true) goto L6;
        this.matchStat = -2;
        return null;
    L6:
        int r100 = r210.length;
        int r101 = r100 + 1;
        char r102 = charAt(this.f24933bp + r100);
        char r110 = 4;
        if (r102 != '\"') goto L155;
        int r103 = indexOf(Typography.quote, (this.f24933bp + r210.length) + 1);
        if (r103 == (-1)) goto L153;
        int r104 = (this.f24933bp + r210.length) + 1;
        int r111 = r103 - r104;
        char r105 = 'F';
        char r112 = 'f';
        char r113 = 'A';
        char r106 = '0';
        if (r111 != 36) goto L106;
        int r114 = 0;
        long r115 = 0;
    L14:
        if (r114 >= 8) goto L29;
        char r116 = charAt(r104 + r114);
        if (r116 < '0') goto L19;
        if (r116 > '9') goto L19;
        int r117 = r116 - '0';
    L26:
        r115 = (r115 << 4) | ((long) r117);
        r114 = r114 + 1;
        r103 = r103;
        r105 = 'F';
    L19:
        if (r116 < 'a') goto L23;
        if (r116 > 'f') goto L23;
        int r118 = r116 - 'a';
    L22:
        r117 = r118 + 10;
    L23:
        if (r116 < 'A') goto L27;
        if (r116 > r105) goto L27;
        r118 = r116 - 'A';
    L27:
        this.matchStat = -2;
        return null;
    L29:
        int r211 = r103;
        int r107 = 9;
        int r108 = 13;
    L30:
        if (r107 >= r108) goto L46;
        char r109 = charAt(r104 + r107);
        if (r109 < '0') goto L35;
        if (r109 > '9') goto L35;
        int r119 = r109 - '0';
    L43:
        r115 = (r115 << r110) | ((long) r119);
        r107 = r107 + 1;
        r108 = 13;
        r113 = 'A';
        r110 = 4;
    L35:
        if (r109 < 'a') goto L39;
        if (r109 > 'f') goto L39;
        int r120 = r109 - 'a';
    L38:
        r119 = r120 + 10;
    L39:
        if (r109 < r113) goto L44;
        if (r109 > 'F') goto L44;
        r120 = r109 - 'A';
    L44:
        this.matchStat = -2;
        return null;
    L46:
        int r121 = 14;
        long r122 = r115;
    L48:
        if (r121 >= 18) goto L66;
        char r123 = charAt(r104 + r121);
        if (r123 < '0') goto L54;
        if (r123 > '9') goto L54;
        int r124 = r123 - '0';
    L63:
        r122 = (r122 << 4) | ((long) r124);
        r121 = r121 + 1;
    L54:
        if (r123 < 'a') goto L59;
        if (r123 > 'f') goto L59;
        int r125 = r123 - 'a';
    L57:
        r124 = r125 + 10;
    L59:
        if (r123 < 'A') goto L64;
        if (r123 > 'F') goto L64;
        r125 = r123 - 'A';
    L64:
        this.matchStat = -2;
        return null;
    L66:
        int r126 = 19;
        long r127 = 0;
    L68:
        if (r126 >= 23) goto L86;
        char r128 = charAt(r104 + r126);
        if (r128 < '0') goto L74;
        if (r128 > '9') goto L74;
        int r129 = r128 - '0';
    L83:
        r127 = (r127 << 4) | ((long) r129);
        r126 = r126 + 1;
    L74:
        if (r128 < 'a') goto L79;
        if (r128 > 'f') goto L79;
        int r130 = r128 - 'a';
    L77:
        r129 = r130 + 10;
    L79:
        if (r128 < 'A') goto L84;
        if (r128 > 'F') goto L84;
        r130 = r128 - 'A';
    L84:
        this.matchStat = -2;
        return null;
    L86:
        int r131 = 24;
        long r132 = r127;
        int r133 = 36;
    L87:
        if (r131 >= r133) goto L105;
        char r134 = charAt(r104 + r131);
        if (r134 < r106) goto L93;
        if (r134 > '9') goto L93;
        int r135 = r134 - '0';
    L102:
        r132 = (r132 << 4) | ((long) r135);
        r131 = r131 + 1;
        r101 = r101;
        r133 = 36;
        r106 = '0';
        r112 = 'f';
    L93:
        if (r134 < 'a') goto L98;
        if (r134 > r112) goto L98;
        int r136 = r134 - 'a';
    L96:
        r135 = r136 + 10;
    L98:
        if (r134 < 'A') goto L103;
        if (r134 > 'F') goto L103;
        r136 = r134 - 'A';
    L103:
        this.matchStat = -2;
        return null;
    L105:
        UUID r137 = new UUID(r122, r132);
        int r138 = this.f24933bp;
        int r139 = r101 + ((r211 - ((r210.length + r138) + 1)) + 1);
        int r140 = r139 + 1;
        char r141 = charAt(r138 + r139);
    L164:
        if (r141 != ',') goto L168;
        int r142 = this.f24933bp + r140;
        this.f24933bp = r142;
        this.f24934ch = charAt(r142);
        this.matchStat = 3;
        return r137;
    L168:
        if (r141 != '}') goto L185;
        int r143 = r140 + 1;
        char r144 = charAt(this.f24933bp + r140);
        if (r144 != ',') goto L174;
        this.token = 16;
        int r145 = this.f24933bp + r143;
        this.f24933bp = r145;
        this.f24934ch = charAt(r145);
    L181:
        this.matchStat = 4;
        return r137;
    L174:
        if (r144 != ']') goto L176;
        this.token = 15;
        int r146 = this.f24933bp + r143;
        this.f24933bp = r146;
        this.f24934ch = charAt(r146);
        goto L181
    L176:
        if (r144 != '}') goto L179;
        this.token = 13;
        int r147 = this.f24933bp + r143;
        this.f24933bp = r147;
        this.f24934ch = charAt(r147);
        goto L181
    L179:
        if (r144 != 26) goto L183;
        this.token = 20;
        this.f24933bp += r143 - 1;
        this.f24934ch = JSONLexer.EOI;
        goto L181
    L183:
        this.matchStat = -1;
        return null;
    L185:
        this.matchStat = -1;
        return null;
    L106:
        int r148 = 32;
        if (r111 != 32) goto L150;
        int r149 = 0;
        long r150 = 0;
    L110:
        if (r149 >= 16) goto L129;
        char r151 = charAt(r104 + r149);
        if (r151 < '0') goto L116;
        if (r151 > '9') goto L116;
        int r152 = r151 - '0';
    L126:
        r150 = (r150 << 4) | ((long) r152);
        r149 = r149 + 1;
    L116:
        if (r151 < 'a') goto L122;
        if (r151 > 'f') goto L122;
        int r153 = r151 - 'a';
    L120:
        r152 = r153 + 10;
    L122:
        if (r151 < 'A') goto L127;
        if (r151 > 'F') goto L127;
        r153 = r151 - 'A';
    L127:
        this.matchStat = -2;
        return null;
    L129:
        int r154 = 16;
        long r155 = 0;
    L130:
        if (r154 >= r148) goto L149;
        char r156 = charAt(r104 + r154);
        if (r156 < '0') goto L137;
        if (r156 > '9') goto L137;
        int r157 = r156 - '0';
    L146:
        r155 = (r155 << 4) | ((long) r157);
        r154 = r154 + 1;
        r148 = 32;
    L137:
        if (r156 < 'a') goto L142;
        if (r156 > 'f') goto L142;
        r157 = (r156 - 'a') + 10;
    L142:
        if (r156 < 'A') goto L147;
        if (r156 > 'F') goto L147;
        r157 = (r156 - 'A') + 10;
    L147:
        this.matchStat = -2;
        return null;
    L149:
        r137 = new UUID(r150, r155);
        int r158 = this.f24933bp;
        int r159 = r101 + ((r103 - ((r210.length + r158) + 1)) + 1);
        r140 = r159 + 1;
        r141 = charAt(r158 + r159);
        goto L164
    L150:
        this.matchStat = -1;
        return null;
    L153:
        throw new JSONException("unclosed str");
    L155:
        if (r102 != 'n') goto L187;
        int r160 = r101 + 1;
        if (charAt(this.f24933bp + r101) != 'u') goto L187;
        int r161 = r160 + 1;
        if (charAt(this.f24933bp + r160) != 'l') goto L187;
        int r162 = r161 + 1;
        if (charAt(this.f24933bp + r161) != 'l') goto L187;
        r141 = charAt(this.f24933bp + r162);
        r140 = r162 + 1;
        r137 = null;
    L187:
        this.matchStat = -1;
        return null;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public final float scanFloat(char r210) {
        this.matchStat = 0;
        char r100 = charAt(this.f24933bp + 0);
        if (r100 != '\"') goto L5;
        boolean r101 = true;
    L6:
        if (r101 == false) goto L8;
        r100 = charAt(this.f24933bp + 1);
        int r102 = 2;
    L10:
        if (r100 != '-') goto L12;
        boolean r103 = true;
    L13:
        if (r103 == false) goto L16;
        r100 = charAt(this.f24933bp + r102);
        r102 = r102 + 1;
    L16:
        if (r100 < '0') goto L78;
        if (r100 > '9') goto L78;
        long r104 = r100 - '0';
    L20:
        int r110 = r102 + 1;
        char r105 = charAt(this.f24933bp + r102);
        if (r105 < '0') goto L25;
        if (r105 > '9') goto L25;
        r104 = (r104 * 10) + ((long) (r105 - '0'));
        r102 = r110;
    L25:
        if (r105 != '.') goto L27;
        boolean r106 = true;
    L28:
        if (r106 == false) goto L39;
        int r107 = r110 + 1;
        char r108 = charAt(this.f24933bp + r110);
        if (r108 < '0') goto L37;
        if (r108 > '9') goto L37;
        r104 = (r104 * 10) + ((long) (r108 - '0'));
        long r111 = 10;
    L33:
        r110 = r107 + 1;
        r105 = charAt(this.f24933bp + r107);
        if (r105 < '0') goto L41;
        if (r105 > '9') goto L41;
        r104 = (r104 * 10) + ((long) (r105 - '0'));
        r111 = r111 * 10;
        r107 = r110;
    L41:
        if (r105 != 'e') goto L43;
    L46:
        boolean r112 = true;
    L47:
        if (r112 == false) goto L58;
        int r109 = r110 + 1;
        char r113 = charAt(this.f24933bp + r110);
        if (r113 == '+') goto L53;
        if (r113 == '-') goto L53;
        r110 = r109;
        r105 = r113;
    L55:
        if (r105 < '0') goto L58;
        if (r105 > '9') goto L58;
        int r114 = r110 + 1;
        r105 = charAt(this.f24933bp + r110);
        r110 = r114;
    L53:
        int r115 = r109 + 1;
        r105 = charAt(this.f24933bp + r109);
        r110 = r115;
    L58:
        if (r101 == false) goto L63;
        if (r105 == '\"') goto L62;
        this.matchStat = -1;
        return 0.0f;
    L62:
        int r116 = r110 + 1;
        r105 = charAt(this.f24933bp + r110);
        int r117 = this.f24933bp;
        int r118 = r117 + 1;
        int r119 = ((r117 + r116) - r118) - 2;
        r110 = r116;
    L64:
        if (r112 == false) goto L66;
    L70:
        float r120 = CastFloatProtector.parseFloat(subString(r118, r119));
    L72:
        if (r105 != r210) goto L75;
        int r121 = this.f24933bp + r110;
        this.f24933bp = r121;
        this.f24934ch = charAt(r121);
        this.matchStat = 3;
        this.token = 16;
        return r120;
    L75:
        this.matchStat = -1;
        return r120;
    L66:
        if (r119 >= 17) goto L70;
        r120 = (float) (r104 / r111);
        if (r103 == false) goto L72;
        r120 = -r120;
        goto L72
    L63:
        r118 = this.f24933bp;
        r119 = ((r118 + r110) - r118) - 1;
        goto L64
    L43:
        if (r105 == 'E') goto L46;
        r112 = false;
    L37:
        this.matchStat = -1;
        return 0.0f;
    L39:
        r111 = 1;
        goto L41
    L27:
        r106 = false;
    L78:
        if (r100 == 'n') goto L80;
    L102:
        this.matchStat = -1;
        return 0.0f;
    L80:
        if (charAt(this.f24933bp + r102) != 'u') goto L102;
        if (charAt((this.f24933bp + r102) + 1) != 'l') goto L102;
        if (charAt((this.f24933bp + r102) + 2) != 'l') goto L102;
        this.matchStat = 5;
        int r122 = r102 + 3;
        int r123 = r122 + 1;
        char r124 = charAt(this.f24933bp + r122);
        if (r101 == false) goto L90;
        if (r124 != '\"') goto L90;
        r124 = charAt(this.f24933bp + r123);
        r123 = r123 + 1;
    L90:
        if (r124 == ',') goto L91;
        if (r124 == ']') goto L95;
        if (isWhitespace(r124) == false) goto L100;
        r124 = charAt(this.f24933bp + r123);
        r123 = r123 + 1;
        goto L90
    L100:
        this.matchStat = -1;
        return 0.0f;
    L95:
        int r125 = this.f24933bp + r123;
        this.f24933bp = r125;
        this.f24934ch = charAt(r125);
        this.matchStat = 5;
        this.token = 15;
        return 0.0f;
    L91:
        int r126 = this.f24933bp + r123;
        this.f24933bp = r126;
        this.f24934ch = charAt(r126);
        this.matchStat = 5;
        this.token = 16;
        return 0.0f;
    L12:
        r103 = false;
        goto L13
    L8:
        r102 = 1;
        goto L10
    L5:
        r101 = false;
        goto L6
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public int scanInt(char r110) {
        this.matchStat = 0;
        char r100 = charAt(this.f24933bp + 0);
        if (r100 != '\"') goto L5;
        boolean r101 = true;
    L7:
        if (r101 == false) goto L9;
        r100 = charAt(this.f24933bp + 1);
        int r102 = 2;
    L11:
        if (r100 != '-') goto L13;
        boolean r103 = true;
    L14:
        if (r103 == false) goto L17;
        r100 = charAt(this.f24933bp + r102);
        r102 = r102 + 1;
    L17:
        if (r100 < '0') goto L45;
        if (r100 > '9') goto L45;
        int r104 = r100 - '0';
    L21:
        int r105 = r102 + 1;
        char r106 = charAt(this.f24933bp + r102);
        if (r106 < '0') goto L26;
        if (r106 > '9') goto L26;
        r104 = (r104 * 10) + (r106 - '0');
        r102 = r105;
    L26:
        if (r106 != '.') goto L29;
        this.matchStat = -1;
        return 0;
    L29:
        if (r104 >= 0) goto L32;
        this.matchStat = -1;
        return 0;
    L32:
        if (r106 == r110) goto L33;
        if (isWhitespace(r106) == false) goto L40;
        char r107 = charAt(this.f24933bp + r105);
        r105 = r105 + 1;
        r106 = r107;
        goto L32
    L40:
        this.matchStat = -1;
        if (r103 == true) goto L43;
        return r104;
    L43:
        return -r104;
    L33:
        int r111 = this.f24933bp + r105;
        this.f24933bp = r111;
        this.f24934ch = charAt(r111);
        this.matchStat = 3;
        this.token = 16;
        if (r103 == true) goto L36;
        return r104;
    L36:
        return -r104;
    L45:
        if (r100 == 'n') goto L47;
    L70:
        this.matchStat = -1;
        return 0;
    L47:
        if (charAt(this.f24933bp + r102) != 'u') goto L70;
        if (charAt((this.f24933bp + r102) + 1) != 'l') goto L70;
        if (charAt((this.f24933bp + r102) + 2) != 'l') goto L70;
        this.matchStat = 5;
        int r108 = r102 + 3;
        int r109 = r108 + 1;
        char r112 = charAt(this.f24933bp + r108);
        if (r101 == false) goto L58;
        if (r112 != '\"') goto L58;
        int r113 = r109 + 1;
        r112 = charAt(this.f24933bp + r109);
        r109 = r113;
    L58:
        if (r112 == ',') goto L59;
        if (r112 == ']') goto L63;
        if (isWhitespace(r112) == false) goto L68;
        int r114 = r109 + 1;
        r112 = charAt(this.f24933bp + r109);
        r109 = r114;
        goto L58
    L68:
        this.matchStat = -1;
        return 0;
    L63:
        int r115 = this.f24933bp + r109;
        this.f24933bp = r115;
        this.f24934ch = charAt(r115);
        this.matchStat = 5;
        this.token = 15;
        return 0;
    L59:
        int r116 = this.f24933bp + r109;
        this.f24933bp = r116;
        this.f24934ch = charAt(r116);
        this.matchStat = 5;
        this.token = 16;
        return 0;
    L13:
        r103 = false;
        goto L14
    L9:
        r102 = 1;
        goto L11
    L5:
        r101 = false;
        goto L7
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public long scanLong(char r210) {
        this.matchStat = 0;
        char r100 = charAt(this.f24933bp + 0);
        if (r100 != '\"') goto L5;
        boolean r101 = true;
    L7:
        if (r101 == false) goto L9;
        r100 = charAt(this.f24933bp + 1);
        int r102 = 2;
    L11:
        if (r100 != '-') goto L13;
        boolean r103 = true;
    L14:
        if (r103 == false) goto L17;
        r100 = charAt(this.f24933bp + r102);
        r102 = r102 + 1;
    L17:
        if (r100 < '0') goto L57;
        if (r100 > '9') goto L57;
        long r104 = r100 - '0';
    L21:
        int r110 = r102 + 1;
        char r105 = charAt(this.f24933bp + r102);
        if (r105 < '0') goto L26;
        if (r105 > '9') goto L26;
        r104 = (r104 * 10) + ((long) (r105 - '0'));
        r102 = r110;
    L26:
        if (r105 != '.') goto L30;
        this.matchStat = -1;
        return 0;
    L30:
        if (r104 < 0) goto L32;
    L36:
        boolean r111 = true;
    L37:
        if (r111 == false) goto L55;
        if (r101 == false) goto L44;
        if (r105 == '\"') goto L42;
        this.matchStat = -1;
        return 0;
    L42:
        r105 = charAt(this.f24933bp + r110);
        r110 = r110 + 1;
    L44:
        if (r105 == r210) goto L45;
        if (isWhitespace(r105) == false) goto L52;
        r105 = charAt(this.f24933bp + r110);
        r110 = r110 + 1;
        goto L44
    L52:
        this.matchStat = -1;
        return r104;
    L45:
        int r106 = this.f24933bp + r110;
        this.f24933bp = r106;
        this.f24934ch = charAt(r106);
        this.matchStat = 3;
        this.token = 16;
        if (r103 == true) goto L48;
        return r104;
    L48:
        return -r104;
    L55:
        throw new NumberFormatException(subString(this.f24933bp, r110 - 1));
    L32:
        if (r104 != Long.MIN_VALUE) goto L35;
        if (r103 == true) goto L36;
    L35:
        r111 = false;
    L57:
        if (r100 == 'n') goto L59;
    L82:
        this.matchStat = -1;
        return 0;
    L59:
        if (charAt(this.f24933bp + r102) != 'u') goto L82;
        if (charAt((this.f24933bp + r102) + 1) != 'l') goto L82;
        if (charAt((this.f24933bp + r102) + 2) != 'l') goto L82;
        this.matchStat = 5;
        int r107 = r102 + 3;
        int r108 = r107 + 1;
        char r109 = charAt(this.f24933bp + r107);
        if (r101 == false) goto L70;
        if (r109 != '\"') goto L70;
        int r112 = r108 + 1;
        r109 = charAt(this.f24933bp + r108);
        r108 = r112;
    L70:
        if (r109 == ',') goto L71;
        if (r109 == ']') goto L75;
        if (isWhitespace(r109) == false) goto L80;
        int r113 = r108 + 1;
        r109 = charAt(this.f24933bp + r108);
        r108 = r113;
        goto L70
    L80:
        this.matchStat = -1;
        return 0;
    L75:
        int r114 = this.f24933bp + r108;
        this.f24933bp = r114;
        this.f24934ch = charAt(r114);
        this.matchStat = 5;
        this.token = 15;
        return 0;
    L71:
        int r115 = this.f24933bp + r108;
        this.f24933bp = r115;
        this.f24934ch = charAt(r115);
        this.matchStat = 5;
        this.token = 16;
        return 0;
    L13:
        r103 = false;
        goto L14
    L9:
        r102 = 1;
        goto L11
    L5:
        r101 = false;
        goto L7
    }

    public final void scanNullOrNew(boolean r110) {
        if (this.f24934ch != 'n') goto L58;
        next();
        char r100 = this.f24934ch;
        if (r100 != 'u') goto L34;
        next();
        if (this.f24934ch != 'l') goto L32;
        next();
        if (this.f24934ch != 'l') goto L30;
        next();
        char r101 = this.f24934ch;
        if (r101 == ' ') goto L27;
        if (r101 == ',') goto L27;
        if (r101 == '}') goto L27;
        if (r101 == ']') goto L27;
        if (r101 == '\n') goto L27;
        if (r101 == '\r') goto L27;
        if (r101 == '\t') goto L27;
        if (r101 == 26) goto L27;
        if (r101 != ':') goto L22;
        if (r110 == true) goto L27;
    L22:
        if (r101 == '\f') goto L27;
        if (r101 == '\b') goto L27;
        throw new JSONException("scan null error");
    L27:
        this.token = 8;
        return;
    L30:
        throw new JSONException("error parse null");
    L32:
        throw new JSONException("error parse null");
    L34:
        if (r100 != 'e') goto L56;
        next();
        if (this.f24934ch != 'w') goto L54;
        next();
        char r111 = this.f24934ch;
        if (r111 == ' ') goto L51;
        if (r111 == ',') goto L51;
        if (r111 == '}') goto L51;
        if (r111 == ']') goto L51;
        if (r111 == '\n') goto L51;
        if (r111 == '\r') goto L51;
        if (r111 == '\t') goto L51;
        if (r111 == 26) goto L51;
        if (r111 == '\f') goto L51;
        if (r111 == '\b') goto L51;
        throw new JSONException("scan new error");
    L51:
        this.token = 9;
        return;
    L54:
        throw new JSONException("error parse new");
    L56:
        throw new JSONException("error parse new");
    L58:
        throw new JSONException("error parse null or new");
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public String scanString(char r110) {
        this.matchStat = 0;
        char r100 = charAt(this.f24933bp + 0);
        if (r100 == 'n') goto L5;
        int r101 = 1;
    L20:
        if (r100 == '\"') goto L21;
        if (isWhitespace(r100) == false) goto L50;
        r100 = charAt(this.f24933bp + r101);
        r101 = r101 + 1;
        goto L20
    L50:
        this.matchStat = -1;
        return stringDefaultValue();
    L21:
        int r102 = this.f24933bp + r101;
        int r103 = indexOf(Typography.quote, r102);
        if (r103 == (-1)) goto L46;
        String r104 = subString(this.f24933bp + r101, r103 - r102);
        if (r104.indexOf(92) == (-1)) goto L34;
    L25:
        int r105 = r103 - 1;
        int r111 = 0;
    L26:
        if (r105 < 0) goto L31;
        if (charAt(r105) != '\\') goto L31;
        r111 = r111 + 1;
        r105 = r105 - 1;
    L31:
        if ((r111 % 2) == 0) goto L32;
        r103 = indexOf(Typography.quote, r103 + 1);
        goto L25
    L32:
        int r106 = r103 - r102;
        r104 = readString(sub_chars(this.f24933bp + 1, r106), r106);
    L34:
        int r107 = r101 + ((r103 - r102) + 1);
        int r108 = r107 + 1;
        char r109 = charAt(this.f24933bp + r107);
    L35:
        if (r109 == r110) goto L36;
        if (isWhitespace(r109) == false) goto L42;
        r109 = charAt(this.f24933bp + r108);
        r108 = r108 + 1;
        goto L35
    L42:
        if (r109 != ']') goto L44;
        int r112 = this.f24933bp + r108;
        this.f24933bp = r112;
        this.f24934ch = charAt(r112);
        this.matchStat = -1;
    L44:
        return r104;
    L36:
        int r113 = this.f24933bp + r108;
        this.f24933bp = r113;
        this.f24934ch = charAt(r113);
        this.matchStat = 3;
        this.token = 16;
        return r104;
    L46:
        throw new JSONException("unclosed str");
    L5:
        if (charAt(this.f24933bp + 1) == 'u') goto L7;
    L16:
        this.matchStat = -1;
        return null;
    L7:
        if (charAt((this.f24933bp + 1) + 1) != 'l') goto L16;
        if (charAt((this.f24933bp + 1) + 2) != 'l') goto L16;
        if (charAt(this.f24933bp + 4) != r110) goto L14;
        int r114 = this.f24933bp + 5;
        this.f24933bp = r114;
        this.f24934ch = charAt(r114);
        this.matchStat = 3;
        return null;
    L14:
        this.matchStat = -1;
        return null;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public final String scanSymbol(SymbolTable r100) {
        skipWhitespace();
        char r101 = this.f24934ch;
        if (r101 != '\"') goto L7;
        return scanSymbol(r100, Typography.quote);
    L7:
        if (r101 != '\'') goto L15;
        if (isEnabled(Feature.AllowSingleQuotes) == false) goto L13;
        return scanSymbol(r100, '\'');
    L13:
        throw new JSONException("syntax error");
    L15:
        if (r101 != '}') goto L19;
        next();
        this.token = 13;
        return null;
    L19:
        if (r101 != ',') goto L23;
        next();
        this.token = 16;
        return null;
    L23:
        if (r101 != 26) goto L27;
        this.token = 20;
        return null;
    L27:
        if (isEnabled(Feature.AllowUnQuotedFieldNames) == false) goto L31;
        return scanSymbolUnQuoted(r100);
    L31:
        throw new JSONException("syntax error");
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public final String scanSymbolUnQuoted(SymbolTable r100) {
        boolean r101 = false;
        if (this.token == 1) goto L5;
    L9:
        boolean[] r102 = IOUtils.firstIdentifierFlags;
        int r103 = this.f24934ch;
        if (r103 < r102.length) goto L12;
    L13:
        r101 = true;
    L14:
        if (r101 == false) goto L41;
        boolean[] r104 = IOUtils.identifierFlags;
        this.f24935np = this.f24933bp;
        this.f24936sp = 1;
    L16:
        char r105 = next();
        if (r105 >= r104.length) goto L39;
        if (r104[r105] == true) goto L39;
        this.f24934ch = charAt(this.f24933bp);
        this.token = 18;
        if (this.f24936sp == 4) goto L23;
    L34:
        if (r100 != null) goto L38;
        return subString(this.f24935np, this.f24936sp);
    L38:
        return addSymbol(this.f24935np, this.f24936sp, r103, r100);
    L23:
        if (r103 != 3392903) goto L34;
        if (charAt(this.f24935np) != 'n') goto L34;
        if (charAt(this.f24935np + 1) != 'u') goto L34;
        if (charAt(this.f24935np + 2) != 'l') goto L34;
        if (charAt(this.f24935np + 3) != 'l') goto L34;
        return null;
    L39:
        r103 = (r103 * 31) + r105;
        this.f24936sp++;
        goto L16
    L41:
        throw new JSONException("illegal identifier : " + this.f24934ch + info());
    L12:
        if (r102[r103] == false) goto L14;
    L5:
        if (this.pos != 0) goto L9;
        if (this.f24933bp != 1) goto L9;
        this.f24933bp = 0;
        goto L9
    }

    public final int scanType(String r100) {
        int r101 = 0;
        this.matchStat = 0;
        char[] r102 = typeFieldName;
        if (charArrayCompare(r102) == true) goto L6;
        return -2;
    L6:
        int r103 = this.f24933bp + r102.length;
        int r104 = r100.length();
    L8:
        if (r101 >= r104) goto L13;
        if (r100.charAt(r101) != charAt(r103 + r101)) goto L11;
        r101 = r101 + 1;
        goto L8
    L11:
        return -1;
    L13:
        int r105 = r103 + r104;
        if (charAt(r105) == '\"') goto L16;
        return -1;
    L16:
        int r106 = r105 + 1;
        char r107 = charAt(r106);
        this.f24934ch = r107;
        if (r107 != ',') goto L21;
        int r108 = r106 + 1;
        this.f24934ch = charAt(r108);
        this.f24933bp = r108;
        this.token = 16;
        return 3;
    L21:
        if (r107 != '}') goto L35;
        r106 = r106 + 1;
        char r109 = charAt(r106);
        this.f24934ch = r109;
        if (r109 != ',') goto L26;
        this.token = 16;
        r106 = r106 + 1;
        this.f24934ch = charAt(r106);
    L33:
        this.matchStat = 4;
        goto L35
    L26:
        if (r109 != ']') goto L28;
        this.token = 15;
        r106 = r106 + 1;
        this.f24934ch = charAt(r106);
        goto L33
    L28:
        if (r109 != '}') goto L31;
        this.token = 13;
        r106 = r106 + 1;
        this.f24934ch = charAt(r106);
        goto L33
    L31:
        if (r109 != 26) goto L34;
        this.token = 20;
        goto L33
    L34:
        return -1;
    L35:
        this.f24933bp = r106;
        return this.matchStat;
    }

    public UUID scanUUID(char r210) {
        this.matchStat = 0;
        char r100 = charAt(this.f24933bp + 0);
        int r101 = 13;
        char r102 = 4;
        if (r100 != '\"') goto L152;
        int r103 = indexOf(Typography.quote, this.f24933bp + 1);
        if (r103 == (-1)) goto L150;
        int r110 = this.f24933bp + 1;
        int r111 = r103 - r110;
        char r112 = 'f';
        char r113 = '9';
        char r104 = 'A';
        char r105 = 'a';
        if (r111 != 36) goto L103;
        int r114 = 0;
        long r115 = 0;
    L10:
        if (r114 >= 8) goto L25;
        char r106 = charAt(r110 + r114);
        if (r106 < '0') goto L15;
        if (r106 > '9') goto L15;
        int r107 = r106 - '0';
    L22:
        r115 = (r115 << 4) | ((long) r107);
        r114 = r114 + 1;
        r112 = 'f';
    L15:
        if (r106 < 'a') goto L19;
        if (r106 > r112) goto L19;
        int r108 = r106 - 'a';
    L18:
        r107 = r108 + 10;
    L19:
        if (r106 < 'A') goto L23;
        if (r106 > 'F') goto L23;
        r108 = r106 - 'A';
    L23:
        this.matchStat = -2;
        return null;
    L25:
        int r109 = 9;
    L26:
        if (r109 >= r101) goto L42;
        char r116 = charAt(r110 + r109);
        if (r116 < '0') goto L31;
        if (r116 > '9') goto L31;
        int r117 = r116 - '0';
    L39:
        r115 = (r115 << 4) | ((long) r117);
        r109 = r109 + 1;
        r101 = 13;
        r104 = 'A';
    L31:
        if (r116 >= 'a') goto L33;
    L36:
        if (r116 < r104) goto L40;
        if (r116 > 'F') goto L40;
        int r118 = r116 - 'A';
    L35:
        r117 = r118 + 10;
    L40:
        this.matchStat = -2;
        return null;
    L33:
        if (r116 > 'f') goto L36;
        r118 = r116 - 'a';
        goto L35
    L42:
        int r119 = 14;
        long r120 = r115;
    L44:
        if (r119 >= 18) goto L61;
        char r121 = charAt(r110 + r119);
        if (r121 < '0') goto L49;
        if (r121 > '9') goto L49;
        int r122 = r121 - '0';
    L58:
        r120 = (r120 << r102) | ((long) r122);
        r119 = r119 + 1;
        r105 = 'a';
        r102 = 4;
    L49:
        if (r121 < r105) goto L55;
        if (r121 > 'f') goto L55;
        int r123 = r121 - 'a';
    L53:
        r122 = r123 + 10;
    L55:
        if (r121 < 'A') goto L59;
        if (r121 > 'F') goto L59;
        r123 = r121 - 'A';
    L59:
        this.matchStat = -2;
        return null;
    L61:
        int r124 = 19;
        long r125 = 0;
    L63:
        if (r124 >= 23) goto L82;
        char r126 = charAt(r110 + r124);
        if (r126 < '0') goto L70;
        if (r126 > '9') goto L70;
        int r127 = r126 - '0';
    L79:
        r125 = (r125 << 4) | ((long) r127);
        r124 = r124 + 1;
    L70:
        if (r126 < 'a') goto L76;
        if (r126 > 'f') goto L76;
        int r128 = r126 - 'a';
    L74:
        r127 = r128 + 10;
    L76:
        if (r126 < 'A') goto L80;
        if (r126 > 'F') goto L80;
        r128 = r126 - 'A';
    L80:
        this.matchStat = -2;
        return null;
    L82:
        int r129 = 24;
        long r130 = r125;
        int r131 = 36;
    L83:
        if (r129 >= r131) goto L102;
        char r132 = charAt(r110 + r129);
        if (r132 < '0') goto L90;
        if (r132 > r113) goto L90;
        int r133 = r132 - '0';
    L99:
        r130 = (r130 << 4) | ((long) r133);
        r129 = r129 + 1;
        r131 = 36;
        r113 = '9';
    L90:
        if (r132 < 'a') goto L96;
        if (r132 > 'f') goto L96;
        int r134 = r132 - 'a';
    L94:
        r133 = r134 + 10;
    L96:
        if (r132 < 'A') goto L100;
        if (r132 > 'F') goto L100;
        r134 = r132 - 'A';
    L100:
        this.matchStat = -2;
        return null;
    L102:
        UUID r135 = new UUID(r120, r130);
        int r136 = this.f24933bp;
        int r137 = ((r103 - (r136 + 1)) + 1) + 1;
        int r138 = r137 + 1;
        char r139 = charAt(r136 + r137);
    L161:
        if (r139 != ',') goto L165;
        int r140 = this.f24933bp + r138;
        this.f24933bp = r140;
        this.f24934ch = charAt(r140);
        this.matchStat = 3;
        return r135;
    L165:
        if (r139 != ']') goto L183;
        int r141 = r138 + 1;
        char r142 = charAt(this.f24933bp + r138);
        if (r142 != ',') goto L171;
        this.token = 16;
        int r143 = this.f24933bp + r141;
        this.f24933bp = r143;
        this.f24934ch = charAt(r143);
    L179:
        this.matchStat = 4;
        return r135;
    L171:
        if (r142 != ']') goto L174;
        this.token = 15;
        int r144 = this.f24933bp + r141;
        this.f24933bp = r144;
        this.f24934ch = charAt(r144);
        goto L179
    L174:
        if (r142 != '}') goto L177;
        this.token = 13;
        int r145 = this.f24933bp + r141;
        this.f24933bp = r145;
        this.f24934ch = charAt(r145);
        goto L179
    L177:
        if (r142 != 26) goto L181;
        this.token = 20;
        this.f24933bp += r141 - 1;
        this.f24934ch = JSONLexer.EOI;
        goto L179
    L181:
        this.matchStat = -1;
        return null;
    L183:
        this.matchStat = -1;
        return null;
    L103:
        int r146 = 32;
        if (r111 != 32) goto L147;
        int r147 = 0;
        long r148 = 0;
    L107:
        if (r147 >= 16) goto L127;
        char r149 = charAt(r110 + r147);
        if (r149 < '0') goto L115;
        if (r149 > '9') goto L115;
        int r150 = r149 - '0';
    L124:
        r148 = (r148 << 4) | ((long) r150);
        r147 = r147 + 1;
    L115:
        if (r149 < 'a') goto L121;
        if (r149 > 'f') goto L121;
        int r151 = r149 - 'a';
    L119:
        r150 = r151 + 10;
    L121:
        if (r149 < 'A') goto L125;
        if (r149 > 'F') goto L125;
        r151 = r149 - 'A';
    L125:
        this.matchStat = -2;
        return null;
    L127:
        int r152 = 16;
        long r153 = 0;
    L128:
        if (r152 >= r146) goto L146;
        char r154 = charAt(r110 + r152);
        if (r154 < '0') goto L134;
        if (r154 > '9') goto L134;
        int r155 = r154 - '0';
        char r156 = 4;
    L143:
        r153 = (r153 << r156) | ((long) r155);
        r152 = r152 + 1;
        r146 = 32;
    L134:
        if (r154 < 'a') goto L140;
        if (r154 > 'f') goto L140;
        r155 = (r154 - 'a') + 10;
    L138:
        r156 = 4;
    L140:
        if (r154 < 'A') goto L144;
        if (r154 > 'F') goto L144;
        r155 = (r154 - 'A') + 10;
    L144:
        this.matchStat = -2;
        return null;
    L146:
        r135 = new UUID(r148, r153);
        int r157 = this.f24933bp;
        int r158 = ((r103 - (r157 + 1)) + 1) + 1;
        r138 = r158 + 1;
        r139 = charAt(r157 + r158);
        goto L161
    L147:
        this.matchStat = -1;
        return null;
    L150:
        throw new JSONException("unclosed str");
    L152:
        if (r100 == 'n') goto L154;
    L185:
        this.matchStat = -1;
        return null;
    L154:
        if (charAt(this.f24933bp + 1) != 'u') goto L185;
        if (charAt(this.f24933bp + 2) != 'l') goto L185;
        if (charAt(this.f24933bp + 3) != 'l') goto L185;
        r139 = charAt(this.f24933bp + 4);
        r138 = 5;
        r135 = null;
        goto L161
    }

    public boolean seekArrayToItem(int r100) {
        throw new UnsupportedOperationException();
    }

    public int seekObjectToField(long[] r100) {
        throw new UnsupportedOperationException();
    }

    public int seekObjectToFieldDeepScan(long r100) {
        throw new UnsupportedOperationException();
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public void setFeatures(int r100) {
        this.features = r100;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public void setLocale(Locale r100) {
        this.locale = r100;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public void setTimeZone(TimeZone r100) {
        this.timeZone = r100;
    }

    public void setToken(int r100) {
        this.token = r100;
    }

    public void skipObject(boolean r100) {
        throw new UnsupportedOperationException();
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public final boolean isEnabled(Feature r100) {
        return isEnabled(r100.mask);
    }

    public int matchField(long r100) {
        throw new UnsupportedOperationException();
    }

    public static String readString(char[] r110, int r111) {
        char[] r100 = new char[r111];
        int r101 = 0;
        int r102 = 0;
    L3:
        if (r101 >= r111) goto L52;
        char r103 = r110[r101];
        if (r103 == '\\') goto L7;
        r100[r102] = r103;
        r102 = r102 + 1;
    L50:
        r101 = r101 + 1;
        goto L3
    L7:
        r101 = r101 + 1;
        char r104 = r110[r101];
        if (r104 != '\"') goto L10;
        int r105 = r102 + 1;
        r100[r102] = Typography.quote;
    L49:
        r102 = r105;
        goto L50
    L10:
        if (r104 != '\'') goto L12;
        r105 = r102 + 1;
        r100[r102] = '\'';
        goto L49
    L12:
        if (r104 == 'F') goto L46;
        if (r104 != '\\') goto L15;
        r105 = r102 + 1;
        r100[r102] = '\\';
        goto L49
    L15:
        if (r104 != 'b') goto L17;
        r105 = r102 + 1;
        r100[r102] = '\b';
        goto L49
    L17:
        if (r104 == 'f') goto L46;
        if (r104 != 'n') goto L21;
        r105 = r102 + 1;
        r100[r102] = '\n';
        goto L49
    L21:
        if (r104 != 'r') goto L23;
        r105 = r102 + 1;
        r100[r102] = '\r';
        goto L49
    L23:
        if (r104 != 'x') goto L25;
        r105 = r102 + 1;
        int[] r106 = digits;
        int r107 = r101 + 1;
        int r108 = r106[r110[r107]] * 16;
        r101 = r107 + 1;
        r100[r102] = (char) (r108 + r106[r110[r101]]);
        goto L49
    L25:
        switch(r104) {
            case 47: goto L40;
            case 48: goto L39;
            case 49: goto L38;
            case 50: goto L37;
            case 51: goto L36;
            case 52: goto L35;
            case 53: goto L34;
            case 54: goto L33;
            case 55: goto L32;
            default: goto L26;
        };
    L26:
        switch(r104) {
            case 116: goto L31;
            case 117: goto L30;
            case 118: goto L29;
            default: goto L28;
        };
    L29:
        r105 = r102 + 1;
        r100[r102] = 11;
        goto L49
    L30:
        r105 = r102 + 1;
        int r109 = r101 + 1;
        int r112 = r109 + 1;
        int r113 = r112 + 1;
        r101 = r113 + 1;
        r100[r102] = (char) CastIntegerProtector.parseInt(new String(new char[]{r110[r109], r110[r112], r110[r113], r110[r101]}), 16);
        goto L49
    L31:
        r105 = r102 + 1;
        r100[r102] = '\t';
        goto L49
    L28:
        throw new JSONException("unclosed.str.lit");
    L32:
        r105 = r102 + 1;
        r100[r102] = 7;
        goto L49
    L33:
        r105 = r102 + 1;
        r100[r102] = 6;
        goto L49
    L34:
        r105 = r102 + 1;
        r100[r102] = 5;
        goto L49
    L35:
        r105 = r102 + 1;
        r100[r102] = 4;
        goto L49
    L36:
        r105 = r102 + 1;
        r100[r102] = 3;
        goto L49
    L37:
        r105 = r102 + 1;
        r100[r102] = 2;
        goto L49
    L38:
        r105 = r102 + 1;
        r100[r102] = 1;
        goto L49
    L39:
        r105 = r102 + 1;
        r100[r102] = 0;
        goto L49
    L40:
        r105 = r102 + 1;
        r100[r102] = '/';
    L46:
        r105 = r102 + 1;
        r100[r102] = '\f';
        goto L49
    L52:
        return new String(r100, 0, r102);
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public void config(Feature r100, boolean r101) {
        int r102 = Feature.config(this.features, r100, r101);
        this.features = r102;
        if ((r102 & Feature.InitStringFieldAsEmpty.mask) == 0) goto L6;
        this.stringDefaultValue = "";
        return;
    }

    public final boolean isEnabled(int r100, int r101) {
        if ((this.features & r101) == 0) goto L5;
    L8:
        return true;
    L5:
        if ((r100 & r101) != 0) goto L8;
        return false;
    }

    public void lexError(String r100, Object... r101) {
        this.token = 1;
    }

    public Collection<String> scanFieldStringArray(char[] r110, Class<?> r111) {
        this.matchStat = 0;
        if (charArrayCompare(r110) == true) goto L6;
        this.matchStat = -2;
        return null;
    L6:
        Collection<String> r112 = newCollectionByType(r111);
        int r113 = r110.length;
        int r100 = r113 + 1;
        if (charAt(this.f24933bp + r113) == '[') goto L10;
        this.matchStat = -1;
        return null;
    L10:
        int r101 = r100 + 1;
        char r114 = charAt(this.f24933bp + r100);
    L12:
        if (r114 != '\"') goto L30;
        int r115 = indexOf(Typography.quote, this.f24933bp + r101);
        if (r115 == (-1)) goto L28;
        int r102 = this.f24933bp + r101;
        String r103 = subString(r102, r115 - r102);
        if (r103.indexOf(92) == (-1)) goto L26;
    L17:
        int r104 = r115 - 1;
        int r105 = 0;
    L18:
        if (r104 < 0) goto L23;
        if (charAt(r104) != '\\') goto L23;
        r105 = r105 + 1;
        r104 = r104 - 1;
    L23:
        if ((r105 % 2) == 0) goto L24;
        r115 = indexOf(Typography.quote, r115 + 1);
        goto L17
    L24:
        int r106 = this.f24933bp;
        int r107 = r115 - (r106 + r101);
        r103 = readString(sub_chars(r106 + r101, r107), r107);
    L26:
        int r108 = this.f24933bp;
        int r109 = r101 + ((r115 - (r108 + r101)) + 1);
        int r116 = r109 + 1;
        char r117 = charAt(r108 + r109);
        r112.add(r103);
    L38:
        if (r117 != ',') goto L40;
        int r118 = r116 + 1;
        r114 = charAt(this.f24933bp + r116);
        r101 = r118;
        goto L12
    L40:
        if (r117 != ']') goto L42;
        int r119 = r116 + 1;
        char r120 = charAt(this.f24933bp + r116);
    L48:
        if (r120 != ',') goto L52;
        int r121 = this.f24933bp + r119;
        this.f24933bp = r121;
        this.f24934ch = charAt(r121);
        this.matchStat = 3;
        return r112;
    L52:
        if (r120 != '}') goto L67;
        int r122 = r119 + 1;
        char r123 = charAt(this.f24933bp + r119);
        if (r123 != ',') goto L56;
        this.token = 16;
        int r124 = this.f24933bp + r122;
        this.f24933bp = r124;
        this.f24934ch = charAt(r124);
    L63:
        this.matchStat = 4;
        return r112;
    L56:
        if (r123 != ']') goto L58;
        this.token = 15;
        int r125 = this.f24933bp + r122;
        this.f24933bp = r125;
        this.f24934ch = charAt(r125);
        goto L63
    L58:
        if (r123 != '}') goto L61;
        this.token = 13;
        int r126 = this.f24933bp + r122;
        this.f24933bp = r126;
        this.f24934ch = charAt(r126);
        goto L63
    L61:
        if (r123 != 26) goto L65;
        this.f24933bp += r122 - 1;
        this.token = 20;
        this.f24934ch = JSONLexer.EOI;
        goto L63
    L65:
        this.matchStat = -1;
        return null;
    L67:
        this.matchStat = -1;
        return null;
    L42:
        this.matchStat = -1;
        return null;
    L28:
        throw new JSONException("unclosed str");
    L30:
        if (r114 != 'n') goto L44;
        if (charAt(this.f24933bp + r101) != 'u') goto L44;
        if (charAt((this.f24933bp + r101) + 1) != 'l') goto L44;
        if (charAt((this.f24933bp + r101) + 2) != 'l') goto L44;
        int r127 = r101 + 3;
        int r128 = r127 + 1;
        r117 = charAt(this.f24933bp + r127);
        r112.add(null);
        r116 = r128;
    L44:
        if (r114 != ']') goto L70;
        if (r112.size() != 0) goto L70;
        r120 = charAt(this.f24933bp + r101);
        r119 = r101 + 1;
    L70:
        throw new JSONException("illega str");
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public void scanStringArray(Collection<String> r110, char r111) {
        this.matchStat = 0;
        char r100 = charAt(this.f24933bp + 0);
        char r101 = 'u';
        char r102 = Symlink.UNIX_ID;
        if (r100 != 'n') goto L15;
        if (charAt(this.f24933bp + 1) != 'u') goto L15;
        if (charAt((this.f24933bp + 1) + 1) != 'l') goto L15;
        if (charAt((this.f24933bp + 1) + 2) != 'l') goto L15;
        if (charAt((this.f24933bp + 1) + 3) != r111) goto L15;
        int r103 = this.f24933bp + 5;
        this.f24933bp = r103;
        this.f24934ch = charAt(r103);
        this.matchStat = 5;
        return;
    L15:
        if (r100 == '[') goto L18;
        this.matchStat = -1;
        return;
    L18:
        char r104 = charAt(this.f24933bp + 1);
        int r112 = 2;
    L20:
        if (r104 == 'n') goto L22;
    L28:
        if (r104 != ']') goto L33;
        if (r110.size() != 0) goto L33;
        int r105 = r112 + 1;
        char r106 = charAt(this.f24933bp + r112);
    L55:
        if (r106 != r111) goto L58;
        int r107 = this.f24933bp + r105;
        this.f24933bp = r107;
        this.f24934ch = charAt(r107);
        this.matchStat = 3;
        return;
    L58:
        this.matchStat = -1;
        return;
    L33:
        if (r104 != '\"') goto L34;
        int r108 = this.f24933bp + r112;
        int r113 = indexOf(Typography.quote, r108);
        if (r113 == (-1)) goto L63;
        String r109 = subString(this.f24933bp + r112, r113 - r108);
        if (r109.indexOf(92) == (-1)) goto L49;
    L40:
        int r114 = r113 - 1;
        int r115 = 0;
    L41:
        if (r114 < 0) goto L46;
        if (charAt(r114) != '\\') goto L46;
        r115 = r115 + 1;
        r114 = r114 - 1;
    L46:
        if ((r115 % 2) == 0) goto L47;
        r113 = indexOf(Typography.quote, r113 + 1);
        goto L40
    L47:
        int r116 = r113 - r108;
        r109 = readString(sub_chars(this.f24933bp + r112, r116), r116);
    L49:
        int r117 = this.f24933bp;
        int r118 = r112 + ((r113 - (r117 + r112)) + 1);
        int r119 = r118 + 1;
        char r120 = charAt(r117 + r118);
        r110.add(r109);
    L51:
        if (r120 != ',') goto L53;
        r112 = r119 + 1;
        r104 = charAt(this.f24933bp + r119);
        r101 = 'u';
        r102 = Symlink.UNIX_ID;
        goto L20
    L53:
        if (r120 != ']') goto L60;
        r105 = r119 + 1;
        r106 = charAt(this.f24933bp + r119);
        goto L55
    L60:
        this.matchStat = -1;
        return;
    L63:
        throw new JSONException("unclosed str");
    L34:
        this.matchStat = -1;
        return;
    L22:
        if (charAt(this.f24933bp + r112) != r101) goto L28;
        if (charAt((this.f24933bp + r112) + 1) != r102) goto L28;
        if (charAt((this.f24933bp + r112) + 2) != r102) goto L28;
        int r121 = r112 + 3;
        r119 = r121 + 1;
        r120 = charAt(this.f24933bp + r121);
        r110.add(null);
        goto L51
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public final String scanSymbol(SymbolTable r110, char r111) {
        this.f24935np = this.f24933bp;
        this.f24936sp = 0;
        boolean r100 = false;
        int r101 = 0;
    L3:
        char r102 = next();
        if (r102 == r111) goto L5;
        if (r102 == 26) goto L79;
        if (r102 == '\\') goto L20;
        r101 = (r101 * 31) + r102;
        if (r100 == false) goto L73;
        int r103 = this.f24936sp;
        char[] r104 = this.sbuf;
        if (r103 == r104.length) goto L76;
        this.f24936sp = r103 + 1;
        r104[r103] = r102;
        goto L3
    L76:
        putChar(r102);
        goto L3
    L73:
        this.f24936sp++;
        goto L3
    L20:
        if (r100 == true) goto L29;
        int r105 = this.f24936sp;
        char[] r106 = this.sbuf;
        if (r105 < r106.length) goto L28;
        int r107 = r106.length * 2;
        if (r105 > r107) goto L27;
        r105 = r107;
    L27:
        char[] r108 = new char[r105];
        System.arraycopy(r106, 0, r108, 0, r106.length);
        this.sbuf = r108;
    L28:
        arrayCopy(this.f24935np + 1, this.sbuf, 0, this.f24936sp);
        r100 = true;
    L29:
        char r109 = next();
        if (r109 != '\"') goto L32;
        r101 = (r101 * 31) + 34;
        putChar(Typography.quote);
        goto L3
    L32:
        if (r109 != '\'') goto L34;
        r101 = (r101 * 31) + 39;
        putChar('\'');
        goto L3
    L34:
        if (r109 == 'F') goto L68;
        if (r109 != '\\') goto L37;
        r101 = (r101 * 31) + 92;
        putChar('\\');
        goto L3
    L37:
        if (r109 != 'b') goto L39;
        r101 = (r101 * 31) + 8;
        putChar('\b');
        goto L3
    L39:
        if (r109 == 'f') goto L68;
        if (r109 != 'n') goto L43;
        r101 = (r101 * 31) + 10;
        putChar('\n');
        goto L3
    L43:
        if (r109 != 'r') goto L45;
        r101 = (r101 * 31) + 13;
        putChar('\r');
        goto L3
    L45:
        if (r109 != 'x') goto L47;
        char r112 = next();
        this.f24934ch = r112;
        char r113 = next();
        this.f24934ch = r113;
        int[] r114 = digits;
        char r115 = (char) ((r114[r112] * 16) + r114[r113]);
        r101 = (r101 * 31) + r115;
        putChar(r115);
        goto L3
    L47:
        switch(r109) {
            case 47: goto L62;
            case 48: goto L61;
            case 49: goto L60;
            case 50: goto L59;
            case 51: goto L58;
            case 52: goto L57;
            case 53: goto L56;
            case 54: goto L55;
            case 55: goto L54;
            default: goto L48;
        };
    L54:
        r101 = (r101 * 31) + r109;
        putChar(7);
        goto L3
    L55:
        r101 = (r101 * 31) + r109;
        putChar(6);
        goto L3
    L56:
        r101 = (r101 * 31) + r109;
        putChar(5);
        goto L3
    L57:
        r101 = (r101 * 31) + r109;
        putChar(4);
        goto L3
    L58:
        r101 = (r101 * 31) + r109;
        putChar(3);
        goto L3
    L59:
        r101 = (r101 * 31) + r109;
        putChar(2);
        goto L3
    L60:
        r101 = (r101 * 31) + r109;
        putChar(1);
        goto L3
    L61:
        r101 = (r101 * 31) + r109;
        putChar(0);
        goto L3
    L62:
        r101 = (r101 * 31) + 47;
        putChar('/');
        goto L3
    L48:
        switch(r109) {
            case 116: goto L53;
            case 117: goto L52;
            case 118: goto L51;
            default: goto L49;
        };
    L49:
        this.f24934ch = r109;
        throw new JSONException("unclosed.str.lit");
    L52:
        int r116 = CastIntegerProtector.parseInt(new String(new char[]{next(), next(), next(), next()}), 16);
        r101 = (r101 * 31) + r116;
        putChar((char) r116);
        goto L3
    L53:
        r101 = (r101 * 31) + 9;
        putChar('\t');
        goto L3
    L51:
        r101 = (r101 * 31) + 11;
        putChar(11);
    L68:
        r101 = (r101 * 31) + 12;
        putChar('\f');
        goto L3
    L79:
        throw new JSONException("unclosed.str");
    L5:
        this.token = 4;
        if (r100 == true) goto L12;
        int r117 = this.f24935np;
        if (r117 != (-1)) goto L10;
        int r118 = 0;
    L11:
        String r119 = addSymbol(r118, this.f24936sp, r101, r110);
    L13:
        this.f24936sp = 0;
        next();
        return r119;
    L10:
        r118 = r117 + 1;
        goto L11
    L12:
        r119 = r110.addSymbol(this.sbuf, 0, this.f24936sp, r101);
        goto L13
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public String scanSymbolWithSeperator(SymbolTable r110, char r111) {
        int r100 = 0;
        this.matchStat = 0;
        char r101 = charAt(this.f24933bp + 0);
        if (r101 != 'n') goto L19;
        if (charAt(this.f24933bp + 1) == 'u') goto L7;
    L16:
        this.matchStat = -1;
        return null;
    L7:
        if (charAt((this.f24933bp + 1) + 1) != 'l') goto L16;
        if (charAt((this.f24933bp + 1) + 2) != 'l') goto L16;
        if (charAt(this.f24933bp + 4) != r111) goto L14;
        int r112 = this.f24933bp + 5;
        this.f24933bp = r112;
        this.f24934ch = charAt(r112);
        this.matchStat = 3;
        return null;
    L14:
        this.matchStat = -1;
        return null;
    L19:
        if (r101 == '\"') goto L22;
        this.matchStat = -1;
        return null;
    L22:
        int r102 = 1;
    L23:
        int r103 = r102 + 1;
        char r104 = charAt(this.f24933bp + r102);
        if (r104 == '\"') goto L25;
        r100 = (r100 * 31) + r104;
        if (r104 == '\\') goto L36;
        r102 = r103;
        goto L23
    L36:
        this.matchStat = -1;
        return null;
    L25:
        int r105 = this.f24933bp;
        int r106 = (r105 + 0) + 1;
        String r113 = addSymbol(r106, ((r105 + r103) - r106) - 1, r100, r110);
        int r107 = r103 + 1;
        char r108 = charAt(this.f24933bp + r103);
    L26:
        if (r108 == r111) goto L27;
        if (isWhitespace(r108) == false) goto L32;
        r108 = charAt(this.f24933bp + r107);
        r107 = r107 + 1;
        goto L26
    L32:
        this.matchStat = -1;
        return r113;
    L27:
        int r114 = this.f24933bp + r107;
        this.f24933bp = r114;
        this.f24934ch = charAt(r114);
        this.matchStat = 3;
        return r113;
    }

    public int seekObjectToField(long r100, boolean r101) {
        throw new UnsupportedOperationException();
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public Enum<?> scanEnum(Class<?> r100, SymbolTable r101, char r102) {
        String r103 = scanSymbolWithSeperator(r101, r102);
        if (r103 != null) goto L7;
        return null;
    L7:
        return a.a(r100, r103);
    }

    public String[] scanFieldStringArray(char[] r100, int r101, SymbolTable r102) {
        throw new UnsupportedOperationException();
    }
}
