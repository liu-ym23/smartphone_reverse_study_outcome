package com.alibaba.fastjson.parser;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;
import org.apache.http.message.TokenParser;

/* JADX INFO: loaded from: classes.dex */
public final class JSONLexer {
    public static final char[] CA = null;
    public static final int END = 4;
    public static final char EOI = 26;
    static final int[] IA = null;
    public static final int NOT_MATCH = -1;
    public static final int NOT_MATCH_NAME = -2;
    public static final int UNKNOWN = 0;
    private static boolean V6 = false;
    public static final int VALUE = 3;
    protected static final int[] digits = null;
    public static final boolean[] firstIdentifierFlags = null;
    public static final boolean[] identifierFlags = null;
    private static final ThreadLocal<char[]> sbufLocal = null;
    protected int bp;
    public Calendar calendar;
    protected char ch;
    public boolean disableCircularReferenceDetect;
    protected int eofPos;
    protected boolean exp;
    public int features;
    protected boolean hasSpecial;
    protected boolean isDouble;
    protected final int len;
    public Locale locale;
    public int matchStat;
    protected int np;
    protected int pos;
    protected char[] sbuf;
    protected int sp;
    protected String stringDefaultValue;
    protected final String text;
    public TimeZone timeZone;
    protected int token;

    static {
        int r10 = Class.forName("android.os.Build$VERSION").getField("SDK_INT").getInt(null);     // Catch: Exception -> L5
    L6:
        char r11 = 0;
        if (r10 < 23) goto L9;
        boolean r12 = true;
    L10:
        V6 = r12;
        sbufLocal = new ThreadLocal();
        digits = new int[103];
        int r13 = 48;
    L12:
        if (r13 > 57) goto L14;
        digits[r13] = r13 - 48;
        r13 = r13 + 1;
        goto L12
    L14:
        int r14 = 97;
    L16:
        if (r14 > 102) goto L18;
        digits[r14] = r14 - 87;
        r14 = r14 + 1;
        goto L16
    L18:
        int r15 = 65;
    L20:
        if (r15 > 70) goto L22;
        digits[r15] = r15 - 55;
        r15 = r15 + 1;
        goto L20
    L22:
        char[] r16 = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".toCharArray();
        CA = r16;
        int[] r17 = new int[256];
        IA = r17;
        Arrays.fill(r17, -1);
        int r18 = r16.length;
        int r19 = 0;
    L23:
        if (r19 >= r18) goto L25;
        IA[CA[r19]] = r19;
        r19 = r19 + 1;
        goto L23
    L25:
        IA[61] = 0;
        firstIdentifierFlags = new boolean[256];
        char r20 = 0;
    L26:
        boolean[] r21 = firstIdentifierFlags;
        if (r20 >= r21.length) goto L37;
        if (r20 < 'A') goto L31;
        if (r20 > 'Z') goto L31;
        r21[r20] = true;
    L36:
        r20 = (char) (r20 + 1);
    L31:
        if (r20 < 'a') goto L34;
        if (r20 > 'z') goto L34;
        r21[r20] = true;
    L34:
        if (r20 != '_') goto L36;
        r21[r20] = true;
        goto L36
    L37:
        identifierFlags = new boolean[256];
    L38:
        boolean[] r22 = identifierFlags;
        if (r11 >= r22.length) goto L52;
        if (r11 < 'A') goto L43;
        if (r11 > 'Z') goto L43;
        r22[r11] = true;
    L51:
        r11 = (char) (r11 + 1);
    L43:
        if (r11 < 'a') goto L46;
        if (r11 > 'z') goto L46;
        r22[r11] = true;
    L46:
        if (r11 != '_') goto L48;
        r22[r11] = true;
        goto L51
    L48:
        if (r11 < '0') goto L51;
        if (r11 > '9') goto L51;
        r22[r11] = true;
        goto L51
    L52:
        return;
    L9:
        r12 = false;
    L5:
        r10 = -1;
        goto L6
    }

    public JSONLexer(String r10) {
        this(r10, JSON.DEFAULT_PARSER_FEATURE);
    }

    public static boolean checkDate(char r10, char r11, char r12, char r13, char r14, char r15, int r16, int r17) {
        if (r10 == '1') goto L7;
        if (r10 == '2') goto L7;
        return false;
    L7:
        if (r11 >= '0') goto L9;
    L43:
        return false;
    L9:
        if (r11 > '9') goto L43;
        if (r12 < '0') goto L43;
        if (r12 > '9') goto L43;
        if (r13 < '0') goto L43;
        if (r13 > '9') goto L43;
        if (r14 != '0') goto L21;
        if (r15 < '1') goto L20;
        if (r15 > '9') goto L20;
    L26:
        if (r16 != 48) goto L30;
        if (r17 < 49) goto L29;
        if (r17 > 57) goto L29;
        return true;
    L29:
        return false;
    L30:
        if (r16 == 49) goto L38;
        if (r16 == 50) goto L38;
        if (r16 != 51) goto L37;
        if (r17 == 48) goto L44;
        if (r17 != 49) goto L37;
        return true;
    L44:
        return true;
    L37:
        return false;
    L38:
        if (r17 < 48) goto L43;
        if (r17 > 57) goto L43;
        return true;
    L20:
        return false;
    L21:
        if (r14 != '1') goto L43;
        if (r15 == '0') goto L26;
        if (r15 == '1') goto L26;
        if (r15 == '2') goto L26;
        return false;
    }

    public static boolean checkTime(char r10, char r11, char r12, char r13, char r14, char r15) {
        if (r10 != '0') goto L8;
        if (r11 < '0') goto L6;
        if (r11 > '9') goto L6;
    L19:
        if (r12 < '0') goto L24;
        if (r12 > '5') goto L24;
        if (r13 < '0') goto L23;
        if (r13 > '9') goto L23;
    L27:
        if (r14 < '0') goto L32;
        if (r14 > '5') goto L32;
        if (r15 < '0') goto L31;
        if (r15 > '9') goto L31;
        return true;
    L31:
        return false;
    L32:
        if (r14 != '6') goto L37;
        if (r15 == '0') goto L38;
        return false;
    L38:
        return true;
    L37:
        return false;
    L23:
        return false;
    L24:
        if (r12 != '6') goto L37;
        if (r13 == '0') goto L27;
        return false;
    L6:
        return false;
    L8:
        if (r10 != '1') goto L13;
        if (r11 < '0') goto L11;
        if (r11 <= '9') goto L19;
    L11:
        return false;
    L13:
        if (r10 != '2') goto L37;
        if (r11 < '0') goto L37;
        if (r11 <= '4') goto L19;
        goto L37
    }

    public static final byte[] decodeFast(String r17, int r18, int r19) {
        if (r19 == 0) goto L5;
        int r10 = (r18 + r19) - 1;
        int r11 = r18;
    L7:
        if (r11 >= r10) goto L11;
        if (IA[r17.charAt(r11)] >= 0) goto L11;
        r11 = r11 + 1;
    L11:
        if (r10 <= 0) goto L16;
        if (IA[r17.charAt(r10)] >= 0) goto L16;
        r10 = r10 - 1;
    L16:
        if (r17.charAt(r10) == '=') goto L18;
        int r12 = 0;
    L22:
        int r13 = (r10 - r11) + 1;
        if (r19 > 76) goto L25;
        int r14 = 0;
    L30:
        int r15 = (((r13 - r14) * 6) >> 3) - r12;
        byte[] r16 = new byte[r15];
        int r20 = (r15 / 3) * 3;
        int r110 = 0;
        int r111 = 0;
    L31:
        if (r110 >= r20) goto L39;
        int[] r112 = IA;
        int r113 = r11 + 4;
        int r114 = r112[r17.charAt(r11 + 3)] | (((r112[r17.charAt(r11 + 1)] << 12) | (r112[r17.charAt(r11)] << 18)) | (r112[r17.charAt(r11 + 2)] << 6));
        r16[r110] = (byte) (r114 >> 16);
        int r115 = r110 + 2;
        r16[r110 + 1] = (byte) (r114 >> 8);
        r110 = r110 + 3;
        r16[r115] = (byte) r114;
        if (r14 <= 0) goto L37;
        r111 = r111 + 1;
        if (r111 != 19) goto L37;
        r11 = r11 + 6;
        r111 = 0;
    L37:
        r11 = r113;
        goto L31
    L39:
        if (r110 >= r15) goto L47;
        int r21 = 0;
        int r116 = 0;
    L42:
        if (r11 > (r10 - r12)) goto L44;
        r21 = r21 | (IA[r17.charAt(r11)] << (18 - (r116 * 6)));
        r116 = r116 + 1;
        r11 = r11 + 1;
        goto L42
    L44:
        int r22 = 16;
    L45:
        if (r110 >= r15) goto L47;
        r16[r110] = (byte) (r21 >> r22);
        r22 = r22 - 8;
        r110 = r110 + 1;
    L47:
        return r16;
    L25:
        if (r17.charAt(76) != '\r') goto L27;
        int r23 = r13 / 78;
    L28:
        r14 = r23 << 1;
        goto L30
    L27:
        r23 = 0;
        goto L28
    L18:
        if (r17.charAt(r10 - 1) != '=') goto L20;
        r12 = 2;
        goto L22
    L20:
        r12 = 1;
        goto L22
    L5:
        return new byte[0];
    }

    private int matchFieldHash(long r18) {
        char r10 = this.ch;
        int r11 = this.bp + 1;
        int r12 = 1;
    L4:
        if (r10 == '\"') goto L8;
        if (r10 == '\'') goto L8;
        if (r10 > ' ') goto L57;
        if (r10 == ' ') goto L52;
        if (r10 == '\n') goto L52;
        if (r10 == '\r') goto L52;
        if (r10 == '\t') goto L52;
        if (r10 == '\f') goto L52;
        if (r10 != '\b') goto L57;
    L52:
        int r13 = r12 + 1;
        int r14 = this.bp + r12;
        if (r14 < this.len) goto L55;
        r10 = EOI;
    L56:
        r12 = r13;
        goto L4
    L55:
        r10 = this.text.charAt(r14);
    L57:
        this.matchStat = -2;
        return 0;
    L8:
        long r15 = -2128831035;
        int r16 = r11;
    L10:
        if (r16 >= this.len) goto L16;
        char r17 = this.text.charAt(r16);
        if (r17 == r10) goto L13;
        r15 = 16777619 * (((long) r17) ^ r15);
        r16 = r16 + 1;
        goto L10
    L13:
        r12 = r12 + (r16 - r11);
    L16:
        if (r15 == r18) goto L19;
        this.matchStat = -2;
        return 0;
    L19:
        int r19 = r12 + 1;
        int r20 = this.bp + r19;
        if (r20 < this.len) goto L22;
        char r21 = EOI;
    L24:
        if (r21 == ':') goto L26;
        if (r21 > ' ') goto L42;
        if (r21 == ' ') goto L36;
        if (r21 == '\n') goto L36;
        if (r21 == '\r') goto L36;
        if (r21 == '\t') goto L36;
        if (r21 == '\f') goto L36;
        if (r21 != '\b') goto L42;
    L36:
        int r22 = r19 + 1;
        int r23 = this.bp + r19;
        if (r23 < this.len) goto L39;
        r21 = EOI;
    L40:
        r19 = r22;
        goto L24
    L39:
        r21 = this.text.charAt(r23);
    L42:
        throw new JSONException("match feild error expect ':'");
    L26:
        return r19 + 1;
    L22:
        r21 = this.text.charAt(r20);
        goto L24
    }

    private static String readString(char[] r17, int r18) {
        int r10 = 5;
        char[] r11 = new char[r18];
        int r12 = 0;
        int r13 = 0;
    L3:
        if (r12 >= r18) goto L55;
        char r14 = r17[r12];
        if (r14 == '\\') goto L7;
        r11[r13] = r14;
        int r15 = r10;
        r13 = r13 + 1;
    L53:
        r12 = r12 + 1;
        r10 = r15;
        goto L3
    L7:
        int r16 = r12 + 1;
        char r19 = r17[r16];
        if (r19 != '\"') goto L10;
        r15 = r10;
        int r20 = r13 + 1;
        r11[r13] = TokenParser.DQUOTE;
    L37:
        r13 = r20;
    L29:
        r12 = r16;
        goto L53
    L10:
        if (r19 != '\'') goto L12;
        r15 = r10;
        r20 = r13 + 1;
        r11[r13] = '\'';
        goto L37
    L12:
        if (r19 == 'F') goto L47;
        if (r19 != '\\') goto L15;
        r15 = r10;
        r20 = r13 + 1;
        r11[r13] = TokenParser.ESCAPE;
        goto L37
    L15:
        if (r19 != 'b') goto L17;
        r15 = r10;
        r20 = r13 + 1;
        r11[r13] = '\b';
        goto L37
    L17:
        if (r19 == 'f') goto L47;
        if (r19 != 'n') goto L21;
        r15 = r10;
        r20 = r13 + 1;
        r11[r13] = '\n';
        goto L37
    L21:
        if (r19 != 'r') goto L23;
        r15 = r10;
        r20 = r13 + 1;
        r11[r13] = TokenParser.CR;
        goto L37
    L23:
        if (r19 == 'x') goto L44;
        switch(r19) {
            case 47: goto L43;
            case 48: goto L42;
            case 49: goto L41;
            case 50: goto L40;
            case 51: goto L39;
            case 52: goto L38;
            case 53: goto L36;
            case 54: goto L35;
            case 55: goto L34;
            default: goto L25;
        };
    L25:
        switch(r19) {
            case 116: goto L32;
            case 117: goto L30;
            case 118: goto L28;
            default: goto L27;
        };
    L28:
        r11[r13] = 11;
        r15 = r10;
        r13 = r13 + 1;
        goto L29
    L30:
        char r110 = r17[r12 + 2];
        char r111 = r17[r12 + 3];
        char r112 = r17[r12 + 4];
        r12 = r12 + r10;
        r11[r13] = (char) Integer.parseInt(new String(new char[]{r110, r111, r112, r17[r12]}), 16);
        r13 = r13 + 1;
    L31:
        r15 = 5;
        goto L53
    L32:
        int r21 = r13 + 1;
        r11[r13] = '\t';
    L33:
        r13 = r21;
        r12 = r16;
        goto L31
    L27:
        throw new JSONException("unclosed.str.lit");
    L34:
        r21 = r13 + 1;
        r11[r13] = 7;
        goto L33
    L35:
        r21 = r13 + 1;
        r11[r13] = 6;
        goto L33
    L36:
        r20 = r13 + 1;
        r15 = 5;
        r11[r13] = 5;
        goto L37
    L38:
        r15 = r10;
        r20 = r13 + 1;
        r11[r13] = 4;
        goto L37
    L39:
        r15 = r10;
        r20 = r13 + 1;
        r11[r13] = 3;
        goto L37
    L40:
        r15 = r10;
        r20 = r13 + 1;
        r11[r13] = 2;
        goto L37
    L41:
        r15 = r10;
        r20 = r13 + 1;
        r11[r13] = 1;
        goto L37
    L42:
        r15 = r10;
        r20 = r13 + 1;
        r11[r13] = 0;
        goto L37
    L43:
        r15 = r10;
        r20 = r13 + 1;
        r11[r13] = '/';
        goto L37
    L44:
        r15 = r10;
        int[] r113 = digits;
        int r114 = r113[r17[r12 + 2]] * 16;
        r12 = r12 + 3;
        r11[r13] = (char) (r114 + r113[r17[r12]]);
        r13 = r13 + 1;
    L47:
        r15 = r10;
        r20 = r13 + 1;
        r11[r13] = '\f';
        goto L37
    L55:
        return new String(r11, 0, r13);
    }

    private void scanIdent() {
        this.np = this.bp - 1;
        this.hasSpecial = false;
    L3:
        this.sp++;
        next();
        if (Character.isLetterOrDigit(this.ch) == true) goto L3;
        String r10 = stringVal();
        if (r10.equals("null") == false) goto L10;
        this.token = 8;
        return;
    L10:
        if (r10.equals("true") == false) goto L13;
        this.token = 6;
        return;
    L13:
        if (r10.equals("false") == false) goto L16;
        this.token = 7;
        return;
    L16:
        if (r10.equals("new") == false) goto L19;
        this.token = 9;
        return;
    L19:
        if (r10.equals("undefined") == false) goto L22;
        this.token = 23;
        return;
    L22:
        if (r10.equals("Set") == false) goto L25;
        this.token = 21;
        return;
    L25:
        if (r10.equals("TreeSet") == false) goto L27;
        this.token = 22;
        return;
    L27:
        this.token = 18;
    }

    private void setCalendar(char r10, char r11, char r12, char r13, char r14, char r15, char r16, char r17) {
        Calendar r18 = Calendar.getInstance(this.timeZone, this.locale);
        this.calendar = r18;
        r18.set(1, ((((r10 - '0') * 1000) + ((r11 - '0') * 100)) + ((r12 - '0') * 10)) + (r13 - '0'));
        this.calendar.set(2, (((r14 - '0') * 10) + (r15 - '0')) - 1);
        this.calendar.set(5, ((r16 - '0') * 10) + (r17 - '0'));
    }

    private final String subString(int r10, int r11) {
        char[] r12 = this.sbuf;
        if (r11 >= r12.length) goto L6;
        this.text.getChars(r10, r10 + r11, r12, 0);
        return new String(this.sbuf, 0, r11);
    L6:
        char[] r13 = new char[r11];
        this.text.getChars(r10, r11 + r10, r13, 0);
        return new String(r13);
    }

    public byte[] bytesValue() {
        return decodeFast(this.text, this.np + 1, this.sp);
    }

    public char charAt(int r10) {
        if (r10 < this.len) goto L6;
        return EOI;
    L6:
        return this.text.charAt(r10);
    }

    public void close() {
        char[] r10 = this.sbuf;
        if (r10.length > 8196) goto L5;
        sbufLocal.set(r10);
    L5:
        this.sbuf = null;
    }

    public final void config(Feature r10, boolean r11) {
        if (r11 == false) goto L4;
        this.features |= r10.mask;
    L6:
        if (r10 != Feature.InitStringFieldAsEmpty) goto L12;
        if (r11 == false) goto L9;
        String r12 = "";
    L10:
        this.stringDefaultValue = r12;
        goto L12
    L9:
        r12 = null;
    L12:
        if ((this.features & Feature.DisableCircularReferenceDetect.mask) == 0) goto L14;
        boolean r13 = true;
    L15:
        this.disableCircularReferenceDetect = r13;
        return;
    L14:
        r13 = false;
        goto L15
    L4:
        this.features &= ~r10.mask;
        goto L6
    }

    public final Number decimalValue(boolean r10) {
        int r11 = (this.np + this.sp) - 1;
        if (r11 < this.len) goto L5;
        char r12 = EOI;
    L62:
        if (r12 != 'F') goto L13;
        return Float.valueOf(Float.parseFloat(numberString()));
    L13:
        if (r12 == 'D') goto L15;
        if (r10 == true) goto L18;
        char r13 = this.text.charAt((this.np + this.sp) - 1);     // Catch: NumberFormatException -> L10
        int r14 = this.sp;     // Catch: NumberFormatException -> L10
        if (r13 != 'L') goto L22;
    L27:
        r14 = r14 - 1;     // Catch: NumberFormatException -> L10
    L28:
        int r15 = this.np;     // Catch: NumberFormatException -> L10
        char[] r16 = this.sbuf;     // Catch: NumberFormatException -> L10
        int r17 = 0;
        if (r14 >= r16.length) goto L31;
        this.text.getChars(r15, r15 + r14, r16, 0);     // Catch: NumberFormatException -> L10
        char[] r18 = this.sbuf;     // Catch: NumberFormatException -> L10
    L33:
        if (r14 > 9) goto L59;
        if (this.exp == true) goto L59;
        char r19 = r18[0];     // Catch: NumberFormatException -> L10
        int r20 = 2;
        if (r19 != '-') goto L40;
        r19 = r18[1];     // Catch: NumberFormatException -> L10
        boolean r21 = true;
    L44:
        int r22 = r19 - '0';     // Catch: NumberFormatException -> L10
    L45:
        if (r20 >= r14) goto L53;
        char r23 = r18[r20];     // Catch: NumberFormatException -> L10
        if (r23 != '.') goto L49;
        r17 = 1;
    L52:
        r20 = r20 + 1;     // Catch: NumberFormatException -> L10
        goto L45
    L49:
        r22 = (r22 * 10) + (r23 - '0');     // Catch: NumberFormatException -> L10
        if (r17 == 0) goto L52;
        r17 = r17 * 10;     // Catch: NumberFormatException -> L10
        goto L52
    L53:
        double r24 = ((double) r22) / ((double) r17);     // Catch: NumberFormatException -> L10
        if (r21 == false) goto L57;
        r24 = -r24;
    L57:
        return Double.valueOf(r24);
    L40:
        if (r19 != '+') goto L43;
        r19 = r18[1];     // Catch: NumberFormatException -> L10
    L42:
        r21 = false;
        goto L44
    L43:
        r20 = 1;
    L59:
        return Double.valueOf(Double.parseDouble(new String(r18, 0, r14)));
    L31:
        char[] r25 = new char[r14];     // Catch: NumberFormatException -> L10
        this.text.getChars(r15, r15 + r14, r25, 0);     // Catch: NumberFormatException -> L10
        r18 = r25;
        goto L33
    L22:
        if (r13 == 'S') goto L27;
        if (r13 == 'B') goto L27;
        if (r13 == 'F') goto L27;
        if (r13 != 'D') goto L28;
    L18:
        return decimalValue();
    L15:
        return Double.valueOf(Double.parseDouble(numberString()));
    L10:
        e = move-exception;
        throw new JSONException(e.getMessage() + ", " + info());
    L5:
        r12 = this.text.charAt(r11);
        goto L62
    }

    public String info() {
        StringBuilder r10 = new StringBuilder();
        r10.append("pos ");
        r10.append(this.bp);
        r10.append(", json : ");
        int r11 = this.len;
        String r12 = this.text;
        if (r11 < 65536) goto L6;
        r12 = r12.substring(0, 65536);
    L6:
        r10.append(r12);
        return r10.toString();
    }

    public final int intValue() {
        int r10 = this.np;
        int r11 = this.sp + r10;
        if (r10 < this.len) goto L5;
        char r12 = 26;
    L6:
        int r13 = 0;
        if (r12 != '-') goto L9;
        r10 = r10 + 1;
        int r14 = Integer.MIN_VALUE;
        boolean r15 = true;
    L10:
        if (r10 >= r11) goto L16;
        int r16 = r10 + 1;
        if (r10 < this.len) goto L14;
        char r17 = 26;
    L15:
        r13 = -(r17 - '0');
        r10 = r16;
        goto L16
    L14:
        r17 = this.text.charAt(r10);
    L16:
        if (r10 >= r11) goto L38;
        int r18 = r10 + 1;
        if (r10 < this.len) goto L20;
        char r19 = 26;
    L22:
        if (r19 == 'L') goto L37;
        if (r19 == 'S') goto L37;
        if (r19 == 'B') goto L37;
        int r20 = r19 - '0';
        if (r13 < (-214748364)) goto L36;
        int r21 = r13 * 10;
        if (r21 < (r14 + r20)) goto L34;
        r13 = r21 - r20;
        r10 = r18;
        goto L16
    L34:
        throw new NumberFormatException(numberString());
    L36:
        throw new NumberFormatException(numberString());
    L37:
        r10 = r18;
        goto L38
    L20:
        r19 = this.text.charAt(r10);
    L38:
        if (r15 == false) goto L45;
        if (r10 <= (this.np + 1)) goto L43;
        return r13;
    L43:
        throw new NumberFormatException(numberString());
    L45:
        return -r13;
    L9:
        r14 = -2147483647;
        r15 = false;
        goto L10
    L5:
        r12 = this.text.charAt(r10);
        goto L6
    }

    public final Number integerValue() throws NumberFormatException {
        int r10 = this.np;
        int r11 = this.sp + r10;
        int r12 = r11 - 1;
        if (r12 < this.len) goto L5;
        char r13 = EOI;
    L7:
        if (r13 == 'B') goto L13;
        if (r13 == 'L') goto L12;
        if (r13 == 'S') goto L11;
        char r14 = TokenParser.SP;
    L14:
        int r15 = this.np;
        if (r15 < this.len) goto L17;
        char r16 = EOI;
    L19:
        if (r16 != '-') goto L21;
        r10 = r10 + 1;
        long r17 = Long.MIN_VALUE;
        boolean r18 = true;
    L22:
        if (r10 >= r11) goto L28;
        int r19 = r10 + 1;
        if (r10 < this.len) goto L26;
        char r20 = EOI;
    L27:
        long r110 = -(r20 - '0');
        r10 = r19;
    L29:
        if (r10 >= r11) goto L43;
        int r21 = r10 + 1;
        if (r10 < this.len) goto L33;
        char r22 = EOI;
    L34:
        int r23 = r22 - '0';
        if (r110 < (-922337203685477580L)) goto L37;
        long r111 = r110 * 10;
        long r24 = r23;
        if (r111 < (r17 + r24)) goto L41;
        r110 = r111 - r24;
        r10 = r21;
        goto L29
    L41:
        return new BigInteger(numberString());
    L37:
        return new BigInteger(numberString());
    L33:
        r22 = this.text.charAt(r10);
        goto L34
    L43:
        if (r18 == true) goto L45;
        long r25 = -r110;
        if (r25 > 2147483647L) goto L75;
        if (r14 == 'L') goto L75;
        if (r14 == 'S') goto L68;
        if (r14 != 'B') goto L73;
        return Byte.valueOf((byte) r25);
    L73:
        return Integer.valueOf((int) r25);
    L68:
        return Short.valueOf((short) r25);
    L75:
        return Long.valueOf(r25);
    L45:
        if (r10 <= (this.np + 1)) goto L61;
        if (r110 < (-2147483648L)) goto L59;
        if (r14 == 'L') goto L59;
        if (r14 == 'S') goto L52;
        if (r14 != 'B') goto L57;
        return Byte.valueOf((byte) r110);
    L57:
        return Integer.valueOf((int) r110);
    L52:
        return Short.valueOf((short) r110);
    L59:
        return Long.valueOf(r110);
    L61:
        throw new NumberFormatException(numberString());
    L26:
        r20 = this.text.charAt(r10);
        goto L27
    L28:
        r110 = 0;
        goto L29
    L21:
        r18 = false;
        r17 = -9223372036854775807L;
        goto L22
    L17:
        r16 = this.text.charAt(r15);
        goto L19
    L11:
        r11 = r11 - 1;
        r14 = 'S';
        goto L14
    L12:
        r11 = r11 - 1;
        r14 = 'L';
        goto L14
    L13:
        r11 = r11 - 1;
        r14 = 'B';
        goto L14
    L5:
        r13 = this.text.charAt(r12);
        goto L7
    }

    public final boolean isBlankInput() {
        int r10 = 0;
    L3:
        char r11 = charAt(r10);
        if (r11 == 26) goto L5;
        if (r11 > ' ') goto L21;
        if (r11 == ' ') goto L20;
        if (r11 == '\n') goto L20;
        if (r11 == '\r') goto L20;
        if (r11 == '\t') goto L20;
        if (r11 == '\f') goto L20;
        if (r11 != '\b') goto L21;
    L20:
        r10 = r10 + 1;
    L21:
        return false;
    L5:
        return true;
    }

    public final boolean isEnabled(Feature r10) {
        if ((this.features & r10.mask) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x005e -> B:8:0x0027). Please report as a decompilation issue!!! */
    public final long longValue() throws NumberFormatException {
        int r10 = this.np;
        int r11 = this.sp + r10;
        if (charAt(r10) != '-') goto L5;
        r10 = r10 + 1;
        long r12 = Long.MIN_VALUE;
        boolean r13 = true;
    L6:
        if (r10 >= r11) goto L9;
        int r14 = r10 + 1;
        long r15 = -(charAt(r10) - '0');
    L8:
        r10 = r14;
    L10:
        if (r10 >= r11) goto L32;
        r14 = r10 + 1;
        if (r10 < this.len) goto L14;
        char r16 = EOI;
    L16:
        if (r16 != 'L') goto L18;
    L31:
        r10 = r14;
        goto L32
    L18:
        if (r16 == 'S') goto L31;
        if (r16 == 'B') goto L31;
        int r17 = r16 - '0';
        if (r15 < (-922337203685477580L)) goto L30;
        long r18 = r15 * 10;
        long r19 = r17;
        if (r18 < (r12 + r19)) goto L28;
        r15 = r18 - r19;
        goto L8
    L28:
        throw new NumberFormatException(numberString());
    L30:
        throw new NumberFormatException(numberString());
    L14:
        r16 = this.text.charAt(r10);
    L32:
        if (r13 == false) goto L39;
        if (r10 <= (this.np + 1)) goto L37;
        return r15;
    L37:
        throw new NumberFormatException(numberString());
    L39:
        return -r15;
    L9:
        r15 = 0;
        goto L10
    L5:
        r13 = false;
        r12 = -9223372036854775807L;
        goto L6
    }

    public boolean matchField(long r18) {
        char r10 = this.ch;
        int r11 = this.bp + 1;
        int r12 = 1;
    L4:
        if (r10 == '\"') goto L8;
        if (r10 == '\'') goto L8;
        if (r10 > ' ') goto L79;
        if (r10 == ' ') goto L74;
        if (r10 == '\n') goto L74;
        if (r10 == '\r') goto L74;
        if (r10 == '\t') goto L74;
        if (r10 == '\f') goto L74;
        if (r10 != '\b') goto L79;
    L74:
        int r13 = r12 + 1;
        int r14 = this.bp + r12;
        if (r14 < this.len) goto L77;
        r10 = EOI;
    L78:
        r12 = r13;
        goto L4
    L77:
        r10 = this.text.charAt(r14);
    L79:
        this.matchStat = -2;
        return false;
    L8:
        long r15 = -2128831035;
        int r16 = r11;
    L10:
        if (r16 >= this.len) goto L16;
        char r17 = this.text.charAt(r16);
        if (r17 == r10) goto L13;
        r15 = (((long) r17) ^ r15) * 16777619;
        r16 = r16 + 1;
        goto L10
    L13:
        r12 = r12 + ((r16 - r11) + 1);
    L16:
        if (r15 == r18) goto L19;
        this.matchStat = -2;
        return false;
    L19:
        int r19 = r12 + 1;
        int r20 = this.bp + r12;
        if (r20 < this.len) goto L22;
        char r21 = EOI;
    L24:
        if (r21 == ':') goto L25;
        if (r21 > ' ') goto L64;
        if (r21 == ' ') goto L58;
        if (r21 == '\n') goto L58;
        if (r21 == '\r') goto L58;
        if (r21 == '\t') goto L58;
        if (r21 == '\f') goto L58;
        if (r21 != '\b') goto L64;
    L58:
        int r22 = r19 + 1;
        int r23 = this.bp + r19;
        if (r23 < this.len) goto L61;
        r21 = EOI;
    L62:
        r19 = r22;
        goto L24
    L61:
        r21 = this.text.charAt(r23);
    L64:
        throw new JSONException("match feild error expect ':'");
    L25:
        int r24 = this.bp + r19;
        if (r24 < this.len) goto L28;
        char r25 = EOI;
    L30:
        if (r25 != '{') goto L37;
        int r26 = r24 + 1;
        this.bp = r26;
        if (r26 < this.len) goto L34;
        char r110 = EOI;
    L35:
        this.ch = r110;
        this.token = 12;
    L48:
        return true;
    L34:
        r110 = this.text.charAt(r26);
        goto L35
    L37:
        if (r25 != '[') goto L43;
        int r27 = r24 + 1;
        this.bp = r27;
        if (r27 < this.len) goto L41;
        char r111 = EOI;
    L42:
        this.ch = r111;
        this.token = 14;
        goto L48
    L41:
        r111 = this.text.charAt(r27);
        goto L42
    L43:
        this.bp = r24;
        if (r24 < this.len) goto L46;
        char r112 = EOI;
    L47:
        this.ch = r112;
        nextToken();
        goto L48
    L46:
        r112 = this.text.charAt(r24);
        goto L47
    L28:
        r25 = this.text.charAt(r24);
        goto L30
    L22:
        r21 = this.text.charAt(r20);
        goto L24
    }

    public char next() {
        int r10 = this.bp + 1;
        this.bp = r10;
        if (r10 < this.len) goto L5;
        char r11 = EOI;
    L6:
        this.ch = r11;
        return r11;
    L5:
        r11 = this.text.charAt(r10);
        goto L6
    }

    public final void nextIdent() {
    L2:
        char r10 = this.ch;
        if (r10 > ' ') goto L17;
        if (r10 == ' ') goto L15;
        if (r10 == '\n') goto L15;
        if (r10 == '\r') goto L15;
        if (r10 == '\t') goto L15;
        if (r10 == '\f') goto L15;
        if (r10 != '\b') goto L17;
    L15:
        next();
    L17:
        if (r10 != '_') goto L19;
    L22:
        scanIdent();
        return;
    L19:
        if (Character.isLetter(r10) == true) goto L22;
        nextToken();
    }

    public final void nextToken() {
        this.sp = 0;
    L3:
        int r10 = this.bp;
        this.pos = r10;
        char r11 = this.ch;
        if (r11 == '/') goto L5;
        if (r11 == '\"') goto L8;
        if (r11 < '0') goto L15;
        if (r11 > '9') goto L15;
    L16:
        scanNumber();
        return;
    L15:
        if (r11 == '-') goto L16;
        if (r11 == ',') goto L20;
        if (r11 != '\f') goto L25;
    L159:
        next();
        goto L3
    L25:
        if (r11 == '\r') goto L159;
        if (r11 == ' ') goto L159;
        if (r11 == ':') goto L157;
        char r12 = EOI;
        if (r11 == '[') goto L151;
        if (r11 == ']') goto L149;
        if (r11 == 'f') goto L132;
        if (r11 == 'n') goto L109;
        if (r11 == '{') goto L102;
        if (r11 == '}') goto L96;
        if (r11 == 'S') goto L94;
        if (r11 == 'T') goto L94;
        if (r11 == 't') goto L77;
        if (r11 == 'u') goto L94;
        switch(r11) {
            case 8: goto L159;
            case 9: goto L159;
            case 10: goto L159;
            default: goto L50;
        };
    L50:
        switch(r11) {
            case 39: goto L74;
            case 40: goto L72;
            case 41: goto L70;
            default: goto L51;
        };
    L51:
        int r13 = this.len;
        if (r10 == r13) goto L65;
        if (r11 != 26) goto L58;
        if ((r10 + 1) == r13) goto L65;
    L58:
        if (r11 > 31) goto L60;
    L63:
        next();
        goto L3
    L60:
        if (r11 == 127) goto L63;
        this.token = 1;
        next();
        return;
    L65:
        if (this.token == 20) goto L69;
        this.token = 20;
        int r14 = this.eofPos;
        this.bp = r14;
        this.pos = r14;
        return;
    L69:
        throw new JSONException("EOF error");
    L70:
        next();
        this.token = 11;
        return;
    L72:
        next();
        this.token = 10;
        return;
    L74:
        scanString();
        return;
    L77:
        if (this.text.startsWith("true", r10) == false) goto L93;
        int r15 = this.bp + 4;
        this.bp = r15;
        char r16 = charAt(r15);
        this.ch = r16;
        if (r16 == ' ') goto L90;
        if (r16 == ',') goto L90;
        if (r16 == '}') goto L90;
        if (r16 == ']') goto L90;
        if (r16 == '\n') goto L90;
        if (r16 == '\r') goto L90;
        if (r16 == '\t') goto L90;
        if (r16 == 26) goto L90;
        if (r16 == '\f') goto L90;
        if (r16 == '\b') goto L90;
        if (r16 != ':') goto L93;
    L90:
        this.token = 6;
        return;
    L93:
        throw new JSONException("scan true error");
    L94:
        scanIdent();
        return;
    L96:
        int r17 = r10 + 1;
        this.bp = r17;
        if (r17 >= this.len) goto L100;
        r12 = this.text.charAt(r17);
    L100:
        this.ch = r12;
        this.token = 13;
        return;
    L102:
        int r18 = r10 + 1;
        this.bp = r18;
        if (r18 >= this.len) goto L106;
        r12 = this.text.charAt(r18);
    L106:
        this.ch = r12;
        this.token = 12;
        return;
    L109:
        if (this.text.startsWith("null", r10) == false) goto L112;
        this.bp += 4;
        int r19 = 8;
    L115:
        if (r19 == 0) goto L130;
        char r20 = charAt(this.bp);
        this.ch = r20;
        if (r20 == ' ') goto L127;
        if (r20 == ',') goto L127;
        if (r20 == '}') goto L127;
        if (r20 == ']') goto L127;
        if (r20 == '\n') goto L127;
        if (r20 == '\r') goto L127;
        if (r20 == '\t') goto L127;
        if (r20 == 26) goto L127;
        if (r20 == '\f') goto L127;
        if (r20 != '\b') goto L130;
    L127:
        this.token = r19;
        return;
    L130:
        throw new JSONException("scan null/new error");
    L112:
        if (this.text.startsWith("new", this.bp) == false) goto L114;
        this.bp += 3;
        r19 = 9;
        goto L115
    L114:
        r19 = 0;
        goto L115
    L132:
        if (this.text.startsWith("false", r10) == false) goto L148;
        int r21 = this.bp + 5;
        this.bp = r21;
        char r22 = charAt(r21);
        this.ch = r22;
        if (r22 == ' ') goto L145;
        if (r22 == ',') goto L145;
        if (r22 == '}') goto L145;
        if (r22 == ']') goto L145;
        if (r22 == '\n') goto L145;
        if (r22 == '\r') goto L145;
        if (r22 == '\t') goto L145;
        if (r22 == 26) goto L145;
        if (r22 == '\f') goto L145;
        if (r22 == '\b') goto L145;
        if (r22 != ':') goto L148;
    L145:
        this.token = 7;
        return;
    L148:
        throw new JSONException("scan false error");
    L149:
        next();
        this.token = 15;
        return;
    L151:
        int r23 = r10 + 1;
        this.bp = r23;
        if (r23 >= this.len) goto L155;
        r12 = this.text.charAt(r23);
    L155:
        this.ch = r12;
        this.token = 14;
        return;
    L157:
        next();
        this.token = 17;
        return;
    L20:
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

    public final void nextTokenWithChar(char r10) {
        this.sp = 0;
    L3:
        char r11 = this.ch;
        if (r11 == r10) goto L5;
        if (r11 == ' ') goto L26;
        if (r11 == '\n') goto L26;
        if (r11 == '\r') goto L26;
        if (r11 == '\t') goto L26;
        if (r11 == '\f') goto L26;
        if (r11 == '\b') goto L26;
        throw new JSONException("not match " + r10 + " - " + this.ch);
    L26:
        next();
        goto L3
    L5:
        int r12 = this.bp + 1;
        this.bp = r12;
        if (r12 < this.len) goto L8;
        char r13 = EOI;
    L9:
        this.ch = r13;
        nextToken();
        return;
    L8:
        r13 = this.text.charAt(r12);
        goto L9
    }

    public final String numberString() {
        char r10 = this.text.charAt((this.np + this.sp) - 1);
        int r11 = this.sp;
        if (r10 != 'L') goto L5;
    L12:
        r11 = r11 - 1;
    L14:
        return subString(this.np, r11);
    L5:
        if (r10 == 'S') goto L12;
        if (r10 == 'B') goto L12;
        if (r10 == 'F') goto L12;
        if (r10 != 'D') goto L14;
        goto L12
    }

    public boolean scanBoolean() {
        boolean r10 = false;
        if (this.text.startsWith("false", this.bp) == false) goto L6;
        int r11 = 5;
    L14:
        int r12 = this.bp + r11;
        this.bp = r12;
        this.ch = charAt(r12);
        return r10;
    L6:
        if (this.text.startsWith("true", this.bp) == false) goto L8;
        r11 = 4;
        r10 = true;
        goto L14
    L8:
        char r13 = this.ch;
        if (r13 != '1') goto L12;
        r11 = 1;
        r10 = true;
        goto L14
    L12:
        if (r13 != '0') goto L16;
        r11 = 1;
        goto L14
    L16:
        this.matchStat = -1;
        return false;
    }

    public boolean scanFieldBoolean(long r11) {
        this.matchStat = 0;
        int r12 = matchFieldHash(r11);
        if (r12 != 0) goto L6;
        return false;
    L6:
        if (this.text.startsWith("false", this.bp + r12) == false) goto L10;
        int r13 = r12 + 5;
    L8:
        boolean r14 = false;
    L19:
        int r10 = r13 + 1;
        int r15 = this.bp + r13;
        int r16 = this.len;
        char r17 = EOI;
        if (r15 < r16) goto L22;
        char r18 = 26;
    L24:
        if (r18 != ',') goto L32;
        int r19 = (this.bp + r13) + 1;
        this.bp = r19;
        if (r19 >= this.len) goto L29;
        r17 = this.text.charAt(r19);
    L29:
        this.ch = r17;
        this.matchStat = 3;
        this.token = 16;
        return r14;
    L32:
        if (r18 != '}') goto L59;
        char r20 = charAt(this.bp + r10);
        if (r20 != ',') goto L41;
        this.token = 16;
        int r21 = (this.bp + (r13 + 1)) + 1;
        this.bp = r21;
        if (r21 >= this.len) goto L39;
        r17 = this.text.charAt(r21);
    L39:
        this.ch = r17;
    L55:
        this.matchStat = 4;
        return r14;
    L41:
        if (r20 != ']') goto L47;
        this.token = 15;
        int r22 = (this.bp + (r13 + 1)) + 1;
        this.bp = r22;
        if (r22 >= this.len) goto L46;
        r17 = this.text.charAt(r22);
    L46:
        this.ch = r17;
        goto L55
    L47:
        if (r20 != '}') goto L53;
        this.token = 13;
        int r23 = (this.bp + (r13 + 1)) + 1;
        this.bp = r23;
        if (r23 >= this.len) goto L52;
        r17 = this.text.charAt(r23);
    L52:
        this.ch = r17;
        goto L55
    L53:
        if (r20 != 26) goto L57;
        this.token = 20;
        this.bp += r13 + 1;
        this.ch = EOI;
        goto L55
    L57:
        this.matchStat = -1;
        return false;
    L59:
        this.matchStat = -1;
        return false;
    L22:
        r18 = this.text.charAt(r15);
        goto L24
    L10:
        if (this.text.startsWith("true", this.bp + r12) == false) goto L14;
        r13 = r12 + 4;
    L12:
        r14 = true;
        goto L19
    L14:
        if (this.text.startsWith("\"false\"", this.bp + r12) == false) goto L17;
        r13 = r12 + 7;
        goto L8
    L17:
        if (this.text.startsWith("\"true\"", this.bp + r12) == false) goto L61;
        r13 = r12 + 6;
        goto L12
    L61:
        this.matchStat = -1;
        return false;
    }

    public final double scanFieldDouble(long r19) {
        this.matchStat = 0;
        int r10 = matchFieldHash(r19);
        if (r10 != 0) goto L5;
        return 0.0d;
    L5:
        int r11 = r10 + 1;
        char r12 = charAt(this.bp + r10);
        int r13 = this.bp;
        int r14 = (r13 + r11) - 1;
        if (r12 != '-') goto L8;
        boolean r15 = true;
    L9:
        if (r15 == false) goto L12;
        r12 = charAt(r13 + r11);
        r11 = r10 + 2;
    L12:
        if (r12 >= '0') goto L14;
    L81:
        this.matchStat = -1;
        return 0.0d;
    L14:
        if (r12 > '9') goto L81;
        int r16 = r12 - '0';
    L16:
        int r17 = r11 + 1;
        char r18 = charAt(this.bp + r11);
        if (r18 < '0') goto L21;
        if (r18 > '9') goto L21;
        r16 = (r16 * 10) + (r18 - '0');
        r11 = r17;
    L21:
        if (r18 != '.') goto L33;
        int r20 = r11 + 2;
        char r110 = charAt(this.bp + r17);
        if (r110 < '0') goto L31;
        if (r110 > '9') goto L31;
        r16 = (r16 * 10) + (r110 - '0');
        int r111 = 10;
    L26:
        int r112 = r20 + 1;
        char r21 = charAt(this.bp + r20);
        if (r21 < '0') goto L30;
        if (r21 > '9') goto L30;
        r16 = (r16 * 10) + (r21 - '0');
        r111 = r111 * 10;
        r20 = r112;
    L30:
        r17 = r112;
        int r113 = r111;
        r18 = r21;
        int r22 = r113;
    L35:
        if (r18 != 'e') goto L37;
    L40:
        boolean r114 = true;
    L41:
        if (r114 == false) goto L51;
        int r115 = r17 + 1;
        r18 = charAt(this.bp + r17);
        if (r18 == '+') goto L47;
        if (r18 == '-') goto L47;
        r17 = r115;
    L48:
        if (r18 < '0') goto L51;
        if (r18 > '9') goto L51;
        r18 = charAt(this.bp + r17);
        r17 = r17 + 1;
    L47:
        r17 = r17 + 2;
        r18 = charAt(this.bp + r115);
    L51:
        int r23 = ((this.bp + r17) - r14) - 1;
        if (r114 == true) goto L57;
        if (r23 >= 10) goto L57;
        double r24 = ((double) r16) / ((double) r22);
        if (r15 == false) goto L59;
        r24 = -r24;
    L59:
        if (r18 != ',') goto L63;
        this.bp += r17 - 1;
        next();
        this.matchStat = 3;
        this.token = 16;
        return r24;
    L63:
        if (r18 != '}') goto L79;
        char r25 = charAt(this.bp + r17);
        if (r25 != ',') goto L68;
        this.token = 16;
        this.bp += r17;
        next();
    L75:
        this.matchStat = 4;
        return r24;
    L68:
        if (r25 != ']') goto L70;
        this.token = 15;
        this.bp += r17;
        next();
        goto L75
    L70:
        if (r25 != '}') goto L73;
        this.token = 13;
        this.bp += r17;
        next();
        goto L75
    L73:
        if (r25 != 26) goto L77;
        this.bp += r17;
        this.token = 20;
        this.ch = EOI;
        goto L75
    L77:
        this.matchStat = -1;
        return 0.0d;
    L79:
        this.matchStat = -1;
        return 0.0d;
    L57:
        r24 = Double.parseDouble(subString(r14, r23));
        goto L59
    L37:
        if (r18 == 'E') goto L40;
        r114 = false;
    L31:
        this.matchStat = -1;
        return 0.0d;
    L33:
        r22 = 1;
        goto L35
    L8:
        r15 = false;
        goto L9
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:85:0x011e -> B:86:0x011f). Please report as a decompilation issue!!! */
    public final double[] scanFieldDoubleArray(long r20) {
        boolean r10 = false;
        this.matchStat = 0;
        int r11 = matchFieldHash(r20);
        double[] r12 = null;
        if (r11 != 0) goto L5;
        return null;
    L5:
        int r13 = r11 + 1;
        int r14 = this.bp + r11;
        if (r14 < this.len) goto L8;
        char r15 = EOI;
    L10:
        if (r15 == '[') goto L13;
        this.matchStat = -2;
        return null;
    L13:
        int r16 = r11 + 2;
        int r17 = this.bp + r13;
        if (r17 < this.len) goto L16;
        char r18 = EOI;
    L17:
        double[] r19 = new double[16];
        int r21 = 0;
    L18:
        int r22 = this.bp;
        int r110 = (r22 + r16) - 1;
        if (r18 != '-') goto L21;
        boolean r111 = true;
    L22:
        if (r111 == false) goto L29;
        int r23 = r16 + 1;
        int r24 = r22 + r16;
        if (r24 < this.len) goto L26;
        char r25 = EOI;
    L27:
        r18 = r25;
        r16 = r23;
        goto L29
    L26:
        r25 = this.text.charAt(r24);
    L29:
        if (r18 < '0') goto L145;
        if (r18 > '9') goto L145;
        int r26 = r18 - '0';
    L33:
        int r112 = r16 + 1;
        int r27 = this.bp + r16;
        if (r27 < this.len) goto L36;
        char r28 = EOI;
    L37:
        if (r28 < '0') goto L41;
        if (r28 > '9') goto L41;
        r26 = (r26 * 10) + (r28 - '0');
        r16 = r112;
    L41:
        if (r28 != '.') goto L43;
        boolean r29 = true;
    L45:
        if (r29 == false) goto L63;
        int r30 = r16 + 2;
        int r31 = this.bp + r112;
        if (r31 < this.len) goto L49;
        char r32 = EOI;
    L50:
        if (r32 < '0') goto L61;
        if (r32 > '9') goto L61;
        r26 = (r26 * 10) + (r32 - '0');
        int r33 = 10;
    L53:
        r112 = r30 + 1;
        int r34 = this.bp + r30;
        if (r34 < this.len) goto L56;
        char r35 = EOI;
    L57:
        if (r35 < '0') goto L60;
        if (r35 > '9') goto L60;
        r26 = (r26 * 10) + (r35 - '0');
        r33 = r33 * 10;
        r30 = r112;
    L60:
        int r113 = r33;
        r28 = r35;
        int r36 = r113;
    L65:
        if (r28 != 'e') goto L67;
    L70:
        boolean r37 = true;
    L71:
        if (r37 == false) goto L93;
        int r114 = r112 + 1;
        int r38 = this.bp + r112;
        if (r38 < this.len) goto L75;
        char r39 = EOI;
    L77:
        if (r39 == '+') goto L81;
        if (r39 == '-') goto L81;
        r28 = r39;
        r112 = r114;
    L86:
        if (r28 < '0') goto L93;
        if (r28 > '9') goto L93;
        int r40 = r112 + 1;
        int r41 = this.bp + r112;
        if (r41 < this.len) goto L91;
        char r42 = EOI;
    L92:
        r112 = r40;
    L85:
        r28 = r42;
        goto L86
    L91:
        r42 = this.text.charAt(r41);
    L81:
        r112 = r112 + 2;
        int r43 = this.bp + r114;
        if (r43 < this.len) goto L84;
        r42 = EOI;
        goto L85
    L84:
        r42 = this.text.charAt(r43);
        goto L85
    L75:
        r39 = this.text.charAt(r38);
    L93:
        int r44 = ((this.bp + r112) - r110) - 1;
        if (r37 == true) goto L99;
        if (r44 >= 10) goto L99;
        double r45 = ((double) r26) / ((double) r36);
        if (r111 == false) goto L101;
        r45 = -r45;
    L101:
        if (r21 < r19.length) goto L103;
        double[] r46 = new double[(r19.length * 3) / 2];
        System.arraycopy(r19, 0, r46, 0, r21);
        r19 = r46;
    L103:
        int r47 = r21 + 1;
        r19[r21] = r45;
        if (r28 != ',') goto L111;
        int r48 = r112 + 1;
        int r49 = this.bp + r112;
        if (r49 < this.len) goto L108;
        char r50 = EOI;
    L109:
        r18 = r50;
        r112 = r48;
        char r51 = 16;
        r12 = null;
        boolean r115 = false;
    L144:
        r21 = r47;
        r10 = r115;
        r16 = r112;
        goto L18
    L108:
        r50 = this.text.charAt(r49);
        goto L109
    L111:
        if (r28 == ']') goto L112;
        r51 = 16;
        r12 = null;
        r115 = false;
        r18 = r28;
        goto L144
    L112:
        int r52 = r112 + 1;
        int r53 = this.bp + r112;
        if (r53 < this.len) goto L115;
        char r54 = EOI;
    L117:
        if (r47 == r19.length) goto L119;
        double[] r55 = new double[r47];
        System.arraycopy(r19, 0, r55, 0, r47);
        r19 = r55;
    L119:
        if (r54 != ',') goto L123;
        this.bp += r112;
        next();
        this.matchStat = 3;
        this.token = 16;
        return r19;
    L123:
        if (r54 != '}') goto L141;
        int r56 = this.bp + r52;
        if (r56 < this.len) goto L127;
        char r57 = EOI;
    L128:
        if (r57 != ',') goto L130;
        this.token = 16;
        this.bp += r112 + 1;
        next();
    L137:
        this.matchStat = 4;
        return r19;
    L130:
        if (r57 != ']') goto L132;
        this.token = 15;
        this.bp += r112 + 1;
        next();
        goto L137
    L132:
        if (r57 != '}') goto L135;
        this.token = 13;
        this.bp += r112 + 1;
        next();
        goto L137
    L135:
        if (r57 != 26) goto L139;
        this.bp += r112 + 1;
        this.token = 20;
        this.ch = EOI;
        goto L137
    L139:
        this.matchStat = -1;
        return null;
    L127:
        r57 = this.text.charAt(r56);
        goto L128
    L141:
        this.matchStat = -1;
        return null;
    L115:
        r54 = this.text.charAt(r53);
    L99:
        r45 = Double.parseDouble(subString(r110, r44));
        goto L101
    L67:
        if (r28 == 'E') goto L70;
        r37 = false;
        goto L71
    L56:
        r35 = this.text.charAt(r34);
    L61:
        this.matchStat = -1;
        return r12;
    L49:
        r32 = this.text.charAt(r31);
        goto L50
    L63:
        r36 = 1;
        goto L65
    L43:
        r29 = r10;
        goto L45
    L36:
        r28 = this.text.charAt(r27);
    L145:
        this.matchStat = -1;
        return r12;
    L21:
        r111 = r10;
        goto L22
    L16:
        r18 = this.text.charAt(r17);
        goto L17
    L8:
        r15 = this.text.charAt(r14);
        goto L10
    }

    public final double[][] scanFieldDoubleArray2(long r21) {
        int r10 = 0;
        this.matchStat = 0;
        int r11 = matchFieldHash(r21);
        double[][] r12 = null;
        if (r11 != 0) goto L5;
        return null;
    L5:
        int r13 = r11 + 1;
        int r14 = this.bp + r11;
        if (r14 < this.len) goto L8;
        char r15 = EOI;
    L9:
        char r16 = '[';
        if (r15 == '[') goto L13;
        this.matchStat = -2;
        return null;
    L13:
        int r17 = r11 + 2;
        int r18 = this.bp + r13;
        if (r18 < this.len) goto L16;
        char r19 = EOI;
    L17:
        int r20 = 16;
        double[][] r22 = new double[16][];
        int r23 = 0;
    L18:
        if (r19 != r16) goto L163;
        int r110 = r17 + 1;
        int r24 = this.bp + r17;
        if (r24 < this.len) goto L22;
        char r25 = EOI;
    L23:
        double[] r26 = new double[r20];
        int r111 = r10;
    L24:
        int r112 = this.bp;
        int r113 = (r112 + r110) - 1;
        if (r25 != '-') goto L27;
        int r114 = 1;
    L28:
        if (r114 == 0) goto L35;
        int r27 = r110 + 1;
        int r115 = r112 + r110;
        if (r115 < this.len) goto L32;
        char r116 = EOI;
    L33:
        char r117 = r116;
        r110 = r27;
        r25 = r117;
        goto L35
    L32:
        r116 = this.text.charAt(r115);
    L35:
        if (r25 < '0') goto L165;
        if (r25 > '9') goto L165;
        int r28 = r25 - '0';
    L39:
        int r118 = r110 + 1;
        int r29 = this.bp + r110;
        if (r29 < this.len) goto L42;
        char r30 = EOI;
    L43:
        if (r30 < '0') goto L47;
        if (r30 > '9') goto L47;
        r28 = (r28 * 10) + (r30 - '0');
        r110 = r118;
    L47:
        if (r30 != '.') goto L65;
        int r119 = r110 + 2;
        int r31 = this.bp + r118;
        if (r31 < this.len) goto L51;
        char r32 = EOI;
    L52:
        if (r32 < '0') goto L63;
        if (r32 > '9') goto L63;
        int r33 = (r28 * 10) + (r32 - '0');
        int r34 = 10;
    L55:
        r118 = r119 + 1;
        int r35 = this.bp + r119;
        if (r35 < this.len) goto L58;
        char r36 = EOI;
    L59:
        if (r36 < '0') goto L62;
        if (r36 > '9') goto L62;
        r33 = (r33 * 10) + (r36 - '0');
        r34 = r34 * 10;
        r119 = r118;
    L62:
        int r120 = r33;
        int r37 = r34;
        r30 = r36;
        int r38 = r120;
    L67:
        if (r30 != 'e') goto L69;
    L72:
        boolean r121 = true;
    L73:
        if (r121 == false) goto L94;
        int r122 = r118 + 1;
        int r39 = this.bp + r118;
        if (r39 < this.len) goto L77;
        r30 = EOI;
    L79:
        if (r30 == '+') goto L83;
        if (r30 == '-') goto L83;
        r118 = r122;
    L87:
        if (r30 < '0') goto L94;
        if (r30 > '9') goto L94;
        int r40 = r118 + 1;
        int r41 = this.bp + r118;
        if (r41 < this.len) goto L92;
        r30 = EOI;
    L93:
        r118 = r40;
        goto L87
    L92:
        r30 = this.text.charAt(r41);
    L83:
        r118 = r118 + 2;
        int r42 = this.bp + r122;
        if (r42 < this.len) goto L86;
        r30 = EOI;
        goto L87
    L86:
        r30 = this.text.charAt(r42);
        goto L87
    L77:
        r30 = this.text.charAt(r39);
    L94:
        int r43 = ((this.bp + r118) - r113) - 1;
        if (r121 == true) goto L100;
        if (r43 >= 10) goto L100;
        double r44 = ((double) r38) / ((double) r37);
        if (r114 == 0) goto L102;
        r44 = -r44;
    L102:
        if (r111 < r26.length) goto L104;
        double[] r45 = new double[(r26.length * 3) / 2];
        System.arraycopy(r26, 0, r45, 0, r111);
        r26 = r45;
    L104:
        int r46 = r111 + 1;
        r26[r111] = r44;
        if (r30 != ',') goto L113;
        int r47 = r118 + 1;
        int r48 = this.bp + r118;
        if (r48 < this.len) goto L109;
        r30 = EOI;
    L110:
        r118 = r47;
    L164:
        r111 = r46;
        r12 = null;
        r25 = r30;
        r10 = 0;
        r110 = r118;
        goto L24
    L109:
        r30 = this.text.charAt(r48);
        goto L110
    L113:
        if (r30 != ']') goto L164;
        int r49 = r118 + 1;
        int r50 = this.bp + r118;
        if (r50 < this.len) goto L117;
        char r51 = EOI;
    L119:
        if (r46 == r26.length) goto L121;
        double[] r123 = new double[r46];
        int r124 = 0;
        System.arraycopy(r26, 0, r123, 0, r46);
        r26 = r123;
    L123:
        if (r23 < r22.length) goto L125;
        r22 = new double[(r22.length * 3) / 2][];
        System.arraycopy(r26, r124, r22, r124, r46);
    L125:
        int r52 = r23 + 1;
        r22[r23] = r26;
        if (r51 != ',') goto L132;
        int r125 = r118 + 2;
        int r53 = this.bp + r49;
        if (r53 < this.len) goto L130;
        char r54 = EOI;
    L131:
        r19 = r54;
        int r55 = 16;
        double[][] r56 = null;
        int r126 = 0;
    L162:
        r23 = r52;
        r20 = r55;
        r12 = r56;
        r10 = r126;
        r17 = r125;
        goto L163
    L130:
        r54 = this.text.charAt(r53);
        goto L131
    L132:
        if (r51 == ']') goto L133;
        r55 = 16;
        r56 = null;
        r126 = 0;
        r19 = r51;
        r125 = r49;
        goto L162
    L133:
        int r57 = r118 + 2;
        int r58 = this.bp + r49;
        if (r58 < this.len) goto L136;
        char r59 = EOI;
    L138:
        if (r52 == r22.length) goto L140;
        double[][] r60 = new double[r52][];
        System.arraycopy(r22, 0, r60, 0, r52);
        r22 = r60;
    L140:
        if (r59 != ',') goto L144;
        this.bp += r118 + 1;
        next();
        this.matchStat = 3;
        this.token = 16;
        return r22;
    L144:
        if (r59 != '}') goto L159;
        char r61 = charAt(this.bp + r57);
        if (r61 != ',') goto L148;
        this.token = 16;
        this.bp += r118 + 2;
        next();
    L155:
        this.matchStat = 4;
        return r22;
    L148:
        if (r61 != ']') goto L150;
        this.token = 15;
        this.bp += r118 + 2;
        next();
        goto L155
    L150:
        if (r61 != '}') goto L153;
        this.token = 13;
        this.bp += r118 + 2;
        next();
        goto L155
    L153:
        if (r61 != 26) goto L157;
        this.bp += r118 + 2;
        this.token = 20;
        this.ch = EOI;
        goto L155
    L157:
        this.matchStat = -1;
        return null;
    L159:
        this.matchStat = -1;
        return null;
    L136:
        r59 = this.text.charAt(r58);
        goto L138
    L121:
        r124 = 0;
        goto L123
    L117:
        r51 = this.text.charAt(r50);
    L100:
        r44 = Double.parseDouble(subString(r113, r43));
        goto L102
    L69:
        if (r30 == 'E') goto L72;
        r121 = false;
        goto L73
    L58:
        r36 = this.text.charAt(r35);
    L63:
        this.matchStat = -1;
        return r12;
    L51:
        r32 = this.text.charAt(r31);
        goto L52
    L65:
        r38 = r28;
        r37 = 1;
        goto L67
    L42:
        r30 = this.text.charAt(r29);
    L165:
        double[][] r62 = r12;
        this.matchStat = -1;
        return r62;
    L27:
        r114 = r10;
        goto L28
    L22:
        r25 = this.text.charAt(r24);
    L163:
        r16 = '[';
        goto L18
    L16:
        r19 = this.text.charAt(r18);
        goto L17
    L8:
        r15 = this.text.charAt(r14);
        goto L9
    }

    public final float scanFieldFloat(long r18) {
        boolean r10 = false;
        this.matchStat = 0;
        int r11 = matchFieldHash(r18);
        if (r11 != 0) goto L5;
        return 0.0f;
    L5:
        int r12 = r11 + 1;
        char r13 = charAt(this.bp + r11);
        int r14 = this.bp;
        int r15 = (r14 + r12) - 1;
        if (r13 != '-') goto L8;
        boolean r16 = true;
    L9:
        if (r16 == false) goto L12;
        r13 = charAt(r14 + r12);
        r12 = r11 + 2;
    L12:
        if (r13 >= '0') goto L14;
    L79:
        this.matchStat = -1;
        return 0.0f;
    L14:
        if (r13 > '9') goto L79;
        int r17 = r13 - '0';
    L16:
        int r19 = r12 + 1;
        char r110 = charAt(this.bp + r12);
        if (r110 < '0') goto L21;
        if (r110 > '9') goto L21;
        r17 = (r17 * 10) + (r110 - '0');
        r12 = r19;
    L21:
        if (r110 != '.') goto L33;
        int r20 = r12 + 2;
        char r111 = charAt(this.bp + r19);
        if (r111 < '0') goto L31;
        if (r111 > '9') goto L31;
        r17 = (r17 * 10) + (r111 - '0');
        int r112 = 10;
    L26:
        int r113 = r20 + 1;
        char r21 = charAt(this.bp + r20);
        if (r21 < '0') goto L30;
        if (r21 > '9') goto L30;
        r17 = (r17 * 10) + (r21 - '0');
        r112 = r112 * 10;
        r20 = r113;
    L30:
        r19 = r113;
        int r114 = r112;
        r110 = r21;
        int r22 = r114;
    L35:
        if (r110 != 'e') goto L37;
    L38:
        r10 = true;
    L39:
        if (r10 == false) goto L49;
        int r115 = r19 + 1;
        r110 = charAt(this.bp + r19);
        if (r110 == '+') goto L45;
        if (r110 == '-') goto L45;
        r19 = r115;
    L46:
        if (r110 < '0') goto L49;
        if (r110 > '9') goto L49;
        r110 = charAt(this.bp + r19);
        r19 = r19 + 1;
    L45:
        r19 = r19 + 2;
        r110 = charAt(this.bp + r115);
    L49:
        int r23 = ((this.bp + r19) - r15) - 1;
        if (r10 == true) goto L55;
        if (r23 >= 10) goto L55;
        float r24 = r17 / r22;
        if (r16 == false) goto L57;
        r24 = -r24;
    L57:
        if (r110 != ',') goto L61;
        this.bp += r19 - 1;
        next();
        this.matchStat = 3;
        this.token = 16;
        return r24;
    L61:
        if (r110 != '}') goto L77;
        char r25 = charAt(this.bp + r19);
        if (r25 != ',') goto L66;
        this.token = 16;
        this.bp += r19;
        next();
    L73:
        this.matchStat = 4;
        return r24;
    L66:
        if (r25 != ']') goto L68;
        this.token = 15;
        this.bp += r19;
        next();
        goto L73
    L68:
        if (r25 != '}') goto L71;
        this.token = 13;
        this.bp += r19;
        next();
        goto L73
    L71:
        if (r25 != 26) goto L75;
        this.bp += r19;
        this.token = 20;
        this.ch = EOI;
        goto L73
    L75:
        this.matchStat = -1;
        return 0.0f;
    L77:
        this.matchStat = -1;
        return 0.0f;
    L55:
        r24 = Float.parseFloat(subString(r15, r23));
        goto L57
    L37:
        if (r110 != 'E') goto L39;
    L31:
        this.matchStat = -1;
        return 0.0f;
    L33:
        r22 = 1;
        goto L35
    L8:
        r16 = false;
        goto L9
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:85:0x011e -> B:86:0x011f). Please report as a decompilation issue!!! */
    public final float[] scanFieldFloatArray(long r20) {
        boolean r10 = false;
        this.matchStat = 0;
        int r11 = matchFieldHash(r20);
        float[] r12 = null;
        if (r11 != 0) goto L5;
        return null;
    L5:
        int r13 = r11 + 1;
        int r14 = this.bp + r11;
        if (r14 < this.len) goto L8;
        char r15 = EOI;
    L10:
        if (r15 == '[') goto L13;
        this.matchStat = -2;
        return null;
    L13:
        int r16 = r11 + 2;
        int r17 = this.bp + r13;
        if (r17 < this.len) goto L16;
        char r18 = EOI;
    L17:
        float[] r19 = new float[16];
        int r21 = 0;
    L18:
        int r22 = this.bp;
        int r110 = (r22 + r16) - 1;
        if (r18 != '-') goto L21;
        boolean r111 = true;
    L22:
        if (r111 == false) goto L29;
        int r23 = r16 + 1;
        int r24 = r22 + r16;
        if (r24 < this.len) goto L26;
        char r25 = EOI;
    L27:
        r18 = r25;
        r16 = r23;
        goto L29
    L26:
        r25 = this.text.charAt(r24);
    L29:
        if (r18 < '0') goto L145;
        if (r18 > '9') goto L145;
        int r26 = r18 - '0';
    L33:
        int r112 = r16 + 1;
        int r27 = this.bp + r16;
        if (r27 < this.len) goto L36;
        char r28 = EOI;
    L37:
        if (r28 < '0') goto L41;
        if (r28 > '9') goto L41;
        r26 = (r26 * 10) + (r28 - '0');
        r16 = r112;
    L41:
        if (r28 != '.') goto L43;
        boolean r29 = true;
    L45:
        if (r29 == false) goto L63;
        int r30 = r16 + 2;
        int r31 = this.bp + r112;
        if (r31 < this.len) goto L49;
        char r32 = EOI;
    L50:
        if (r32 < '0') goto L61;
        if (r32 > '9') goto L61;
        r26 = (r26 * 10) + (r32 - '0');
        int r33 = 10;
    L53:
        r112 = r30 + 1;
        int r34 = this.bp + r30;
        if (r34 < this.len) goto L56;
        char r35 = EOI;
    L57:
        if (r35 < '0') goto L60;
        if (r35 > '9') goto L60;
        r26 = (r26 * 10) + (r35 - '0');
        r33 = r33 * 10;
        r30 = r112;
    L60:
        int r113 = r33;
        r28 = r35;
        int r36 = r113;
    L65:
        if (r28 != 'e') goto L67;
    L70:
        boolean r37 = true;
    L71:
        if (r37 == false) goto L93;
        int r114 = r112 + 1;
        int r38 = this.bp + r112;
        if (r38 < this.len) goto L75;
        char r39 = EOI;
    L77:
        if (r39 == '+') goto L81;
        if (r39 == '-') goto L81;
        r28 = r39;
        r112 = r114;
    L86:
        if (r28 < '0') goto L93;
        if (r28 > '9') goto L93;
        int r40 = r112 + 1;
        int r41 = this.bp + r112;
        if (r41 < this.len) goto L91;
        char r42 = EOI;
    L92:
        r112 = r40;
    L85:
        r28 = r42;
        goto L86
    L91:
        r42 = this.text.charAt(r41);
    L81:
        r112 = r112 + 2;
        int r43 = this.bp + r114;
        if (r43 < this.len) goto L84;
        r42 = EOI;
        goto L85
    L84:
        r42 = this.text.charAt(r43);
        goto L85
    L75:
        r39 = this.text.charAt(r38);
    L93:
        int r44 = ((this.bp + r112) - r110) - 1;
        if (r37 == true) goto L99;
        if (r44 >= 10) goto L99;
        float r45 = r26 / r36;
        if (r111 == false) goto L101;
        r45 = -r45;
    L101:
        if (r21 < r19.length) goto L103;
        float[] r46 = new float[(r19.length * 3) / 2];
        System.arraycopy(r19, 0, r46, 0, r21);
        r19 = r46;
    L103:
        int r47 = r21 + 1;
        r19[r21] = r45;
        if (r28 != ',') goto L112;
        int r48 = r112 + 1;
        int r49 = this.bp + r112;
        if (r49 < this.len) goto L108;
        char r50 = EOI;
    L109:
        r28 = r50;
        r112 = r48;
    L110:
        r12 = null;
        r21 = r47;
        r18 = r28;
        r16 = r112;
        r10 = false;
        goto L18
    L108:
        r50 = this.text.charAt(r49);
        goto L109
    L112:
        if (r28 != ']') goto L110;
        int r51 = r112 + 1;
        int r52 = this.bp + r112;
        if (r52 < this.len) goto L116;
        char r53 = EOI;
    L118:
        if (r47 == r19.length) goto L120;
        float[] r54 = new float[r47];
        System.arraycopy(r19, 0, r54, 0, r47);
        r19 = r54;
    L120:
        if (r53 != ',') goto L124;
        this.bp += r112;
        next();
        this.matchStat = 3;
        this.token = 16;
        return r19;
    L124:
        if (r53 != '}') goto L142;
        int r55 = this.bp + r51;
        if (r55 < this.len) goto L128;
        char r56 = EOI;
    L129:
        if (r56 != ',') goto L131;
        this.token = 16;
        this.bp += r112 + 1;
        next();
    L138:
        this.matchStat = 4;
        return r19;
    L131:
        if (r56 != ']') goto L133;
        this.token = 15;
        this.bp += r112 + 1;
        next();
        goto L138
    L133:
        if (r56 != '}') goto L136;
        this.token = 13;
        this.bp += r112 + 1;
        next();
        goto L138
    L136:
        if (r56 != 26) goto L140;
        this.bp += r112 + 1;
        this.token = 20;
        this.ch = EOI;
        goto L138
    L140:
        this.matchStat = -1;
        return null;
    L128:
        r56 = this.text.charAt(r55);
        goto L129
    L142:
        this.matchStat = -1;
        return null;
    L116:
        r53 = this.text.charAt(r52);
    L99:
        r45 = Float.parseFloat(subString(r110, r44));
        goto L101
    L67:
        if (r28 == 'E') goto L70;
        r37 = false;
        goto L71
    L56:
        r35 = this.text.charAt(r34);
    L61:
        this.matchStat = -1;
        return r12;
    L49:
        r32 = this.text.charAt(r31);
        goto L50
    L63:
        r36 = 1;
        goto L65
    L43:
        r29 = r10;
        goto L45
    L36:
        r28 = this.text.charAt(r27);
    L145:
        this.matchStat = -1;
        return r12;
    L21:
        r111 = r10;
        goto L22
    L16:
        r18 = this.text.charAt(r17);
        goto L17
    L8:
        r15 = this.text.charAt(r14);
        goto L10
    }

    public final float[][] scanFieldFloatArray2(long r21) {
        int r10 = 0;
        this.matchStat = 0;
        int r11 = matchFieldHash(r21);
        float[][] r12 = null;
        if (r11 != 0) goto L5;
        return null;
    L5:
        int r13 = r11 + 1;
        int r14 = this.bp + r11;
        if (r14 < this.len) goto L8;
        char r15 = EOI;
    L9:
        char r16 = '[';
        if (r15 == '[') goto L13;
        this.matchStat = -2;
        return null;
    L13:
        int r17 = r11 + 2;
        int r18 = this.bp + r13;
        if (r18 < this.len) goto L16;
        char r19 = EOI;
    L17:
        int r20 = 16;
        float[][] r22 = new float[16][];
        int r23 = 0;
    L18:
        if (r19 != r16) goto L163;
        int r110 = r17 + 1;
        int r24 = this.bp + r17;
        if (r24 < this.len) goto L22;
        char r25 = EOI;
    L23:
        float[] r26 = new float[r20];
        int r111 = r10;
    L24:
        int r112 = this.bp;
        int r113 = (r112 + r110) - 1;
        if (r25 != '-') goto L27;
        int r114 = 1;
    L28:
        if (r114 == 0) goto L35;
        int r27 = r110 + 1;
        int r115 = r112 + r110;
        if (r115 < this.len) goto L32;
        char r116 = EOI;
    L33:
        char r117 = r116;
        r110 = r27;
        r25 = r117;
        goto L35
    L32:
        r116 = this.text.charAt(r115);
    L35:
        if (r25 < '0') goto L165;
        if (r25 > '9') goto L165;
        int r28 = r25 - '0';
    L39:
        int r118 = r110 + 1;
        int r29 = this.bp + r110;
        if (r29 < this.len) goto L42;
        char r30 = EOI;
    L43:
        if (r30 < '0') goto L47;
        if (r30 > '9') goto L47;
        r28 = (r28 * 10) + (r30 - '0');
        r110 = r118;
    L47:
        if (r30 != '.') goto L65;
        int r119 = r110 + 2;
        int r31 = this.bp + r118;
        if (r31 < this.len) goto L51;
        char r32 = EOI;
    L52:
        if (r32 < '0') goto L63;
        if (r32 > '9') goto L63;
        int r33 = (r28 * 10) + (r32 - '0');
        int r34 = 10;
    L55:
        r118 = r119 + 1;
        int r35 = this.bp + r119;
        if (r35 < this.len) goto L58;
        char r36 = EOI;
    L59:
        if (r36 < '0') goto L62;
        if (r36 > '9') goto L62;
        r33 = (r33 * 10) + (r36 - '0');
        r34 = r34 * 10;
        r119 = r118;
    L62:
        int r120 = r33;
        int r37 = r34;
        r30 = r36;
        int r38 = r120;
    L67:
        if (r30 != 'e') goto L69;
    L72:
        boolean r121 = true;
    L73:
        if (r121 == false) goto L94;
        int r122 = r118 + 1;
        int r39 = this.bp + r118;
        if (r39 < this.len) goto L77;
        r30 = EOI;
    L79:
        if (r30 == '+') goto L83;
        if (r30 == '-') goto L83;
        r118 = r122;
    L87:
        if (r30 < '0') goto L94;
        if (r30 > '9') goto L94;
        int r40 = r118 + 1;
        int r41 = this.bp + r118;
        if (r41 < this.len) goto L92;
        r30 = EOI;
    L93:
        r118 = r40;
        goto L87
    L92:
        r30 = this.text.charAt(r41);
    L83:
        r118 = r118 + 2;
        int r42 = this.bp + r122;
        if (r42 < this.len) goto L86;
        r30 = EOI;
        goto L87
    L86:
        r30 = this.text.charAt(r42);
        goto L87
    L77:
        r30 = this.text.charAt(r39);
    L94:
        int r43 = ((this.bp + r118) - r113) - 1;
        if (r121 == true) goto L100;
        if (r43 >= 10) goto L100;
        float r44 = r38 / r37;
        if (r114 == 0) goto L102;
        r44 = -r44;
    L102:
        if (r111 < r26.length) goto L104;
        float[] r45 = new float[(r26.length * 3) / 2];
        System.arraycopy(r26, 0, r45, 0, r111);
        r26 = r45;
    L104:
        int r46 = r111 + 1;
        r26[r111] = r44;
        if (r30 != ',') goto L113;
        int r47 = r118 + 1;
        int r48 = this.bp + r118;
        if (r48 < this.len) goto L109;
        r30 = EOI;
    L110:
        r118 = r47;
    L164:
        r111 = r46;
        r12 = null;
        r25 = r30;
        r10 = 0;
        r110 = r118;
        goto L24
    L109:
        r30 = this.text.charAt(r48);
        goto L110
    L113:
        if (r30 != ']') goto L164;
        int r49 = r118 + 1;
        int r50 = this.bp + r118;
        if (r50 < this.len) goto L117;
        char r51 = EOI;
    L119:
        if (r46 == r26.length) goto L121;
        float[] r123 = new float[r46];
        int r124 = 0;
        System.arraycopy(r26, 0, r123, 0, r46);
        r26 = r123;
    L123:
        if (r23 < r22.length) goto L125;
        r22 = new float[(r22.length * 3) / 2][];
        System.arraycopy(r26, r124, r22, r124, r46);
    L125:
        int r52 = r23 + 1;
        r22[r23] = r26;
        if (r51 != ',') goto L132;
        int r125 = r118 + 2;
        int r53 = this.bp + r49;
        if (r53 < this.len) goto L130;
        char r54 = EOI;
    L131:
        r19 = r54;
        r20 = 16;
        float[][] r55 = null;
        int r126 = 0;
    L162:
        r23 = r52;
        r12 = r55;
        r10 = r126;
        r17 = r125;
        goto L163
    L130:
        r54 = this.text.charAt(r53);
        goto L131
    L132:
        if (r51 == ']') goto L133;
        r20 = 16;
        r55 = null;
        r126 = 0;
        r19 = r51;
        r125 = r49;
        goto L162
    L133:
        int r56 = r118 + 2;
        int r57 = this.bp + r49;
        if (r57 < this.len) goto L136;
        char r58 = EOI;
    L138:
        if (r52 == r22.length) goto L140;
        float[][] r59 = new float[r52][];
        System.arraycopy(r22, 0, r59, 0, r52);
        r22 = r59;
    L140:
        if (r58 != ',') goto L144;
        this.bp += r118 + 1;
        next();
        this.matchStat = 3;
        this.token = 16;
        return r22;
    L144:
        if (r58 != '}') goto L159;
        char r60 = charAt(this.bp + r56);
        if (r60 != ',') goto L148;
        this.token = 16;
        this.bp += r118 + 2;
        next();
    L155:
        this.matchStat = 4;
        return r22;
    L148:
        if (r60 != ']') goto L150;
        this.token = 15;
        this.bp += r118 + 2;
        next();
        goto L155
    L150:
        if (r60 != '}') goto L153;
        this.token = 13;
        this.bp += r118 + 2;
        next();
        goto L155
    L153:
        if (r60 != 26) goto L157;
        this.bp += r118 + 2;
        this.token = 20;
        this.ch = EOI;
        goto L155
    L157:
        this.matchStat = -1;
        return null;
    L159:
        this.matchStat = -1;
        return null;
    L136:
        r58 = this.text.charAt(r57);
        goto L138
    L121:
        r124 = 0;
        goto L123
    L117:
        r51 = this.text.charAt(r50);
    L100:
        r44 = Float.parseFloat(subString(r113, r43));
        goto L102
    L69:
        if (r30 == 'E') goto L72;
        r121 = false;
        goto L73
    L58:
        r36 = this.text.charAt(r35);
    L63:
        this.matchStat = -1;
        return r12;
    L51:
        r32 = this.text.charAt(r31);
        goto L52
    L65:
        r38 = r28;
        r37 = 1;
        goto L67
    L42:
        r30 = this.text.charAt(r29);
    L165:
        float[][] r61 = r12;
        this.matchStat = -1;
        return r61;
    L27:
        r114 = r10;
        goto L28
    L22:
        r25 = this.text.charAt(r24);
    L163:
        r16 = '[';
        goto L18
    L16:
        r19 = this.text.charAt(r18);
        goto L17
    L8:
        r15 = this.text.charAt(r14);
        goto L9
    }

    public int scanFieldInt(long r12) {
        this.matchStat = 0;
        int r13 = matchFieldHash(r12);
        if (r13 != 0) goto L5;
        return 0;
    L5:
        int r10 = r13 + 1;
        int r14 = this.bp + r13;
        int r11 = this.len;
        char r15 = EOI;
        if (r14 < r11) goto L8;
        char r16 = 26;
    L10:
        if (r16 != '\"') goto L16;
        int r17 = r13 + 2;
        int r18 = this.bp + r10;
        if (r18 < this.len) goto L14;
        r16 = 26;
    L15:
        r10 = r17;
        boolean r19 = true;
    L18:
        if (r16 >= '0') goto L20;
    L83:
        this.matchStat = -1;
        return 0;
    L20:
        if (r16 > '9') goto L83;
        int r110 = r16 - '0';
    L22:
        int r20 = r10 + 1;
        int r21 = this.bp + r10;
        if (r21 < this.len) goto L25;
        char r22 = 26;
    L26:
        if (r22 < '0') goto L30;
        if (r22 > '9') goto L30;
        r110 = (r110 * 10) + (r22 - '0');
        r10 = r20;
    L30:
        if (r22 != '.') goto L33;
        this.matchStat = -1;
        return 0;
    L33:
        if (r22 != '\"') goto L42;
        if (r19 == true) goto L37;
        this.matchStat = -1;
        return 0;
    L37:
        int r23 = r10 + 2;
        int r111 = this.bp + r20;
        if (r111 < this.len) goto L40;
        r22 = 26;
    L41:
        r20 = r23;
        goto L42
    L40:
        r22 = this.text.charAt(r111);
    L42:
        if (r110 >= 0) goto L46;
        this.matchStat = -1;
        return 0;
    L46:
        if (r22 != ',') goto L54;
        int r24 = (this.bp + (r20 - 1)) + 1;
        this.bp = r24;
        if (r24 >= this.len) goto L51;
        r15 = this.text.charAt(r24);
    L51:
        this.ch = r15;
        this.matchStat = 3;
        this.token = 16;
        return r110;
    L54:
        if (r22 != '}') goto L81;
        char r25 = charAt(this.bp + r20);
        if (r25 != ',') goto L63;
        this.token = 16;
        int r112 = (this.bp + r20) + 1;
        this.bp = r112;
        if (r112 >= this.len) goto L61;
        r15 = this.text.charAt(r112);
    L61:
        this.ch = r15;
    L77:
        this.matchStat = 4;
        return r110;
    L63:
        if (r25 != ']') goto L69;
        this.token = 15;
        int r113 = (this.bp + r20) + 1;
        this.bp = r113;
        if (r113 >= this.len) goto L68;
        r15 = this.text.charAt(r113);
    L68:
        this.ch = r15;
        goto L77
    L69:
        if (r25 != '}') goto L75;
        this.token = 13;
        int r114 = (this.bp + r20) + 1;
        this.bp = r114;
        if (r114 >= this.len) goto L74;
        r15 = this.text.charAt(r114);
    L74:
        this.ch = r15;
        goto L77
    L75:
        if (r25 != 26) goto L79;
        this.token = 20;
        this.bp += r20;
        this.ch = EOI;
        goto L77
    L79:
        this.matchStat = -1;
        return 0;
    L81:
        this.matchStat = -1;
        return 0;
    L25:
        r22 = this.text.charAt(r21);
        goto L26
    L14:
        r16 = this.text.charAt(r18);
        goto L15
    L16:
        r19 = false;
        goto L18
    L8:
        r16 = this.text.charAt(r14);
        goto L10
    }

    public final int[] scanFieldIntArray(long r19) {
        this.matchStat = 0;
        int r10 = matchFieldHash(r19);
        int[] r11 = null;
        if (r10 != 0) goto L5;
        return null;
    L5:
        int r12 = r10 + 1;
        int r13 = this.bp + r10;
        if (r13 < this.len) goto L8;
        char r14 = EOI;
    L10:
        if (r14 == '[') goto L13;
        this.matchStat = -2;
        return null;
    L13:
        int r15 = r10 + 2;
        int r16 = this.bp + r12;
        if (r16 < this.len) goto L16;
        char r17 = EOI;
    L17:
        int[] r18 = new int[16];
        if (r17 != ']') goto L24;
        int r20 = r10 + 3;
        int r21 = this.bp + r15;
        if (r21 < this.len) goto L22;
        char r22 = EOI;
    L23:
        int r23 = 0;
    L66:
        if (r23 == r18.length) goto L68;
        int[] r24 = new int[r23];
        System.arraycopy(r18, 0, r24, 0, r23);
        r18 = r24;
    L68:
        if (r22 != ',') goto L72;
        this.bp += r20 - 1;
        next();
        this.matchStat = 3;
        this.token = 16;
        return r18;
    L72:
        if (r22 != '}') goto L87;
        char r25 = charAt(this.bp + r20);
        if (r25 != ',') goto L76;
        this.token = 16;
        this.bp += r20;
        next();
    L83:
        this.matchStat = 4;
        return r18;
    L76:
        if (r25 != ']') goto L78;
        this.token = 15;
        this.bp += r20;
        next();
        goto L83
    L78:
        if (r25 != '}') goto L81;
        this.token = 13;
        this.bp += r20;
        next();
        goto L83
    L81:
        if (r25 != 26) goto L85;
        this.bp += r20;
        this.token = 20;
        this.ch = EOI;
        goto L83
    L85:
        this.matchStat = -1;
        return null;
    L87:
        this.matchStat = -1;
        return null;
    L22:
        r22 = this.text.charAt(r21);
        goto L23
    L24:
        int r26 = 0;
    L26:
        if (r17 != '-') goto L32;
        int r110 = r15 + 1;
        int r27 = this.bp + r15;
        if (r27 < this.len) goto L30;
        r17 = EOI;
    L31:
        r15 = r110;
        boolean r111 = true;
    L34:
        if (r17 < '0') goto L91;
        if (r17 > '9') goto L90;
        int r28 = r17 - '0';
    L38:
        int r112 = r15 + 1;
        int r29 = this.bp + r15;
        if (r29 < this.len) goto L41;
        char r30 = EOI;
    L42:
        if (r30 < '0') goto L46;
        if (r30 > '9') goto L46;
        r28 = (r28 * 10) + (r30 - '0');
        r15 = r112;
    L46:
        if (r26 < r18.length) goto L48;
        int[] r31 = new int[(r18.length * 3) / 2];
        System.arraycopy(r18, 0, r31, 0, r26);
        r18 = r31;
    L48:
        r23 = r26 + 1;
        if (r111 == false) goto L51;
        r28 = -r28;
    L51:
        r18[r26] = r28;
        if (r30 != ',') goto L59;
        int r32 = r15 + 2;
        int r33 = this.bp + r112;
        if (r33 < this.len) goto L56;
        char r34 = EOI;
    L57:
        r30 = r34;
        r112 = r32;
    L89:
        r26 = r23;
        r11 = null;
        r17 = r30;
        r15 = r112;
        goto L26
    L56:
        r34 = this.text.charAt(r33);
        goto L57
    L59:
        if (r30 != ']') goto L89;
        int r35 = r15 + 2;
        int r36 = this.bp + r112;
        if (r36 < this.len) goto L63;
        char r37 = EOI;
    L64:
        r22 = r37;
        r20 = r35;
        goto L66
    L63:
        r37 = this.text.charAt(r36);
        goto L64
    L41:
        r30 = this.text.charAt(r29);
        goto L42
    L90:
        int r38 = -1;
        int[] r39 = null;
    L92:
        this.matchStat = r38;
        return r39;
    L91:
        r39 = r11;
        r38 = -1;
        goto L92
    L30:
        r17 = this.text.charAt(r27);
        goto L31
    L32:
        r111 = false;
        goto L34
    L16:
        r17 = this.text.charAt(r16);
        goto L17
    L8:
        r14 = this.text.charAt(r13);
        goto L10
    }

    public long scanFieldLong(long r18) {
        boolean r10 = false;
        this.matchStat = 0;
        int r11 = matchFieldHash(r18);
        if (r11 != 0) goto L5;
        return 0;
    L5:
        int r12 = r11 + 1;
        int r13 = this.bp + r11;
        int r14 = this.len;
        char r15 = EOI;
        if (r13 < r14) goto L8;
        char r16 = 26;
    L10:
        if (r16 != '\"') goto L17;
        int r17 = r11 + 2;
        int r19 = this.bp + r12;
        if (r19 < this.len) goto L14;
        r16 = 26;
    L15:
        r12 = r17;
        r10 = true;
        goto L17
    L14:
        r16 = this.text.charAt(r19);
    L17:
        if (r16 >= '0') goto L19;
    L83:
        this.matchStat = -1;
        return 0;
    L19:
        if (r16 > '9') goto L83;
        long r110 = r16 - '0';
    L21:
        int r111 = r12 + 1;
        int r20 = this.bp + r12;
        if (r20 < this.len) goto L24;
        char r21 = 26;
    L25:
        if (r21 < '0') goto L29;
        if (r21 > '9') goto L29;
        r110 = (r110 * 10) + ((long) (r21 - '0'));
        r12 = r111;
    L29:
        if (r21 != '.') goto L32;
        this.matchStat = -1;
        return 0;
    L32:
        if (r21 != '\"') goto L42;
        if (r10 == true) goto L36;
        this.matchStat = -1;
        return 0;
    L36:
        int r22 = r12 + 2;
        int r23 = this.bp + r111;
        if (r23 < this.len) goto L39;
        r21 = 26;
    L40:
        r111 = r22;
        goto L42
    L39:
        r21 = this.text.charAt(r23);
    L42:
        if (r110 >= 0) goto L46;
        this.matchStat = -1;
        return 0;
    L46:
        if (r21 != ',') goto L54;
        int r24 = (this.bp + (r111 - 1)) + 1;
        this.bp = r24;
        if (r24 >= this.len) goto L51;
        r15 = this.text.charAt(r24);
    L51:
        this.ch = r15;
        this.matchStat = 3;
        this.token = 16;
        return r110;
    L54:
        if (r21 != '}') goto L81;
        char r25 = charAt(this.bp + r111);
        if (r25 != ',') goto L63;
        this.token = 16;
        int r26 = (this.bp + r111) + 1;
        this.bp = r26;
        if (r26 >= this.len) goto L61;
        r15 = this.text.charAt(r26);
    L61:
        this.ch = r15;
    L77:
        this.matchStat = 4;
        return r110;
    L63:
        if (r25 != ']') goto L69;
        this.token = 15;
        int r27 = (this.bp + r111) + 1;
        this.bp = r27;
        if (r27 >= this.len) goto L68;
        r15 = this.text.charAt(r27);
    L68:
        this.ch = r15;
        goto L77
    L69:
        if (r25 != '}') goto L75;
        this.token = 13;
        int r28 = (this.bp + r111) + 1;
        this.bp = r28;
        if (r28 >= this.len) goto L74;
        r15 = this.text.charAt(r28);
    L74:
        this.ch = r15;
        goto L77
    L75:
        if (r25 != 26) goto L79;
        this.token = 20;
        this.bp += r111;
        this.ch = EOI;
        goto L77
    L79:
        this.matchStat = -1;
        return 0;
    L81:
        this.matchStat = -1;
        return 0;
    L24:
        r21 = this.text.charAt(r20);
        goto L25
    L8:
        r16 = this.text.charAt(r13);
        goto L10
    }

    public String scanFieldString(long r10) {
        this.matchStat = 0;
        int r11 = matchFieldHash(r10);
        if (r11 != 0) goto L6;
        return null;
    L6:
        int r12 = r11 + 1;
        int r13 = this.bp + r11;
        if (r13 >= this.len) goto L71;
        if (this.text.charAt(r13) == '\"') goto L12;
        this.matchStat = -1;
        return this.stringDefaultValue;
    L12:
        int r14 = this.bp + r12;
        int r15 = this.text.indexOf(34, r14);
        if (r15 == (-1)) goto L69;
        if (V6 == false) goto L17;
        String r16 = this.text.substring(r14, r15);
    L19:
        if (r16.indexOf(92) == (-1)) goto L35;
        boolean r17 = false;
    L21:
        int r18 = r15 - 1;
        int r19 = 0;
    L22:
        if (r18 < 0) goto L27;
        if (this.text.charAt(r18) != '\\') goto L27;
        r19 = r19 + 1;
        r18 = r18 - 1;
        r17 = true;
    L27:
        if ((r19 % 2) == 0) goto L28;
        r15 = this.text.indexOf(34, r15 + 1);
        goto L21
    L28:
        int r110 = r15 - r14;
        char[] r111 = sub_chars(this.bp + r12, r110);
        if (r17 == false) goto L31;
        r16 = readString(r111, r110);
        goto L35
    L31:
        r16 = new String(r111, 0, r110);
        if (r16.indexOf(92) == (-1)) goto L35;
        r16 = readString(r111, r110);
    L35:
        int r112 = r15 + 1;
        int r113 = this.len;
        char r20 = EOI;
        if (r112 < r113) goto L38;
        char r114 = 26;
    L40:
        if (r114 != ',') goto L48;
        int r21 = r15 + 2;
        this.bp = r21;
        if (r21 >= this.len) goto L45;
        r20 = this.text.charAt(r21);
    L45:
        this.ch = r20;
        this.matchStat = 3;
        this.token = 16;
        return r16;
    L48:
        if (r114 != '}') goto L66;
        int r22 = r15 + 2;
        if (r22 < this.len) goto L52;
        char r115 = 26;
    L53:
        if (r115 != ',') goto L56;
        this.token = 16;
        this.bp = r22;
        next();
    L62:
        this.matchStat = 4;
        return r16;
    L56:
        if (r115 != ']') goto L58;
        this.token = 15;
        this.bp = r22;
        next();
        goto L62
    L58:
        if (r115 != '}') goto L60;
        this.token = 13;
        this.bp = r22;
        next();
        goto L62
    L60:
        if (r115 != 26) goto L64;
        this.token = 20;
        this.bp = r22;
        this.ch = EOI;
        goto L62
    L64:
        this.matchStat = -1;
        return this.stringDefaultValue;
    L52:
        r115 = this.text.charAt(r22);
        goto L53
    L66:
        this.matchStat = -1;
        return this.stringDefaultValue;
    L38:
        r114 = this.text.charAt(r112);
        goto L40
    L17:
        int r23 = r15 - r14;
        r16 = new String(sub_chars(this.bp + r12, r23), 0, r23);
        goto L19
    L69:
        throw new JSONException("unclosed str, " + info());
    L71:
        throw new JSONException("unclosed str, " + info());
    }

    public long scanFieldSymbol(long r11) {
        this.matchStat = 0;
        int r12 = matchFieldHash(r11);
        if (r12 != 0) goto L5;
        return 0;
    L5:
        int r10 = r12 + 1;
        int r13 = this.bp + r12;
        int r14 = this.len;
        char r15 = EOI;
        if (r13 < r14) goto L8;
        char r16 = 26;
    L10:
        if (r16 == '\"') goto L13;
        this.matchStat = -1;
        return 0;
    L13:
        long r17 = -2128831035;
    L14:
        int r18 = r10 + 1;
        int r19 = this.bp + r10;
        if (r19 < this.len) goto L17;
        char r110 = 26;
    L18:
        if (r110 == '\"') goto L19;
        r17 = (r17 ^ ((long) r110)) * 16777619;
        if (r110 == '\\') goto L54;
        r10 = r18;
        goto L14
    L54:
        this.matchStat = -1;
        return 0;
    L19:
        int r111 = r10 + 2;
        int r112 = this.bp + r18;
        if (r112 < this.len) goto L22;
        char r113 = 26;
    L24:
        if (r113 != ',') goto L32;
        int r114 = (this.bp + (r10 + 1)) + 1;
        this.bp = r114;
        if (r114 >= this.len) goto L29;
        r15 = this.text.charAt(r114);
    L29:
        this.ch = r15;
        this.matchStat = 3;
        return r17;
    L32:
        if (r113 != '}') goto L50;
        int r115 = this.bp + r111;
        if (r115 < this.len) goto L36;
        char r116 = 26;
    L37:
        if (r116 != ',') goto L40;
        this.token = 16;
        this.bp += r10 + 2;
        next();
    L46:
        this.matchStat = 4;
        return r17;
    L40:
        if (r116 != ']') goto L42;
        this.token = 15;
        this.bp += r10 + 2;
        next();
        goto L46
    L42:
        if (r116 != '}') goto L44;
        this.token = 13;
        this.bp += r10 + 2;
        next();
        goto L46
    L44:
        if (r116 != 26) goto L48;
        this.token = 20;
        this.bp += r10 + 2;
        this.ch = EOI;
        goto L46
    L48:
        this.matchStat = -1;
        return 0;
    L36:
        r116 = this.text.charAt(r115);
        goto L37
    L50:
        this.matchStat = -1;
        return 0;
    L22:
        r113 = this.text.charAt(r112);
        goto L24
    L17:
        r110 = this.text.charAt(r19);
        goto L18
    L8:
        r16 = this.text.charAt(r13);
        goto L10
    }

    public boolean scanISO8601DateIfMatch(boolean r36) {
        int r10 = this.len;
        int r11 = this.bp;
        int r12 = r10 - r11;
        if (r36 == true) goto L25;
        if (r12 <= 13) goto L25;
        if (this.text.startsWith("/Date(", r11) == false) goto L25;
        if (charAt((this.bp + r12) - 1) != '/') goto L25;
        if (charAt((this.bp + r12) - 2) != ')') goto L25;
        int r13 = -1;
        int r14 = 6;
    L12:
        if (r14 >= r12) goto L20;
        char r15 = charAt(this.bp + r14);
        if (r15 != '+') goto L16;
        r13 = r14;
    L19:
        r14 = r14 + 1;
        goto L12
    L16:
        if (r15 < '0') goto L20;
        if (r15 <= '9') goto L19;
    L20:
        if (r13 != (-1)) goto L22;
        return false;
    L22:
        int r16 = this.bp + 6;
        long r17 = Long.parseLong(subString(r16, r13 - r16), 10);
        Calendar r18 = Calendar.getInstance(this.timeZone, this.locale);
        this.calendar = r18;
        r18.setTimeInMillis(r17);
        this.token = 5;
        return true;
    L25:
        if (r12 == 8) goto L28;
        if (r12 == 14) goto L28;
        if (r12 == 17) goto L28;
        if (r12 >= 10) goto L32;
        return false;
    L32:
        if (charAt(this.bp + 4) == '-') goto L35;
        return false;
    L35:
        if (charAt(this.bp + 7) == '-') goto L37;
        return false;
    L37:
        char r26 = charAt(this.bp);
        char r27 = charAt(this.bp + 1);
        char r28 = charAt(this.bp + 2);
        char r29 = charAt(this.bp + 3);
        char r30 = charAt(this.bp + 5);
        char r31 = charAt(this.bp + 6);
        char r32 = charAt(this.bp + 8);
        char r33 = charAt(this.bp + 9);
        if (checkDate(r26, r27, r28, r29, r30, r31, r32, r33) == true) goto L40;
        return false;
    L40:
        setCalendar(r26, r27, r28, r29, r30, r31, r32, r33);
        char r19 = charAt(this.bp + 10);
        if (r19 == 'T') goto L55;
        if (r19 != ' ') goto L47;
        if (r36 == false) goto L55;
    L47:
        if (r19 != '\"') goto L49;
    L52:
        this.calendar.set(11, 0);
        this.calendar.set(12, 0);
        this.calendar.set(13, 0);
        this.calendar.set(14, 0);
        int r20 = this.bp + 10;
        this.bp = r20;
        this.ch = charAt(r20);
        this.token = 5;
        return true;
    L49:
        if (r19 == 26) goto L52;
        return false;
    L55:
        if (r12 >= 19) goto L58;
        return false;
    L58:
        if (charAt(this.bp + 13) == ':') goto L61;
        return false;
    L61:
        if (charAt(this.bp + 16) == ':') goto L63;
        return false;
    L63:
        char r21 = charAt(this.bp + 11);
        char r23 = charAt(this.bp + 12);
        char r24 = charAt(this.bp + 14);
        char r25 = charAt(this.bp + 15);
        char r210 = charAt(this.bp + 17);
        char r211 = charAt(this.bp + 18);
        if (checkTime(r21, r23, r24, r25, r210, r211) == true) goto L66;
        return false;
    L66:
        this.calendar.set(11, ((r21 - '0') * 10) + (r23 - '0'));
        this.calendar.set(12, ((r24 - '0') * 10) + (r25 - '0'));
        this.calendar.set(13, ((r210 - '0') * 10) + (r211 - '0'));
        char r22 = charAt(this.bp + 19);
        if (r22 == '.') goto L69;
        this.calendar.set(14, 0);
        int r34 = this.bp + 19;
        this.bp = r34;
        this.ch = charAt(r34);
        this.token = 5;
        if (r22 == 'Z') goto L149;
    L153:
        return true;
    L149:
        if (this.calendar.getTimeZone().getRawOffset() == 0) goto L153;
        String[] r35 = TimeZone.getAvailableIDs(0);
        if (r35.length <= 0) goto L153;
        this.calendar.setTimeZone(TimeZone.getTimeZone(r35[0]));
        goto L153
    L69:
        if (r12 >= 21) goto L71;
        return false;
    L71:
        char r37 = charAt(this.bp + 20);
        if (r37 >= '0') goto L74;
    L145:
        return false;
    L74:
        if (r37 > '9') goto L145;
        int[] r38 = digits;
        int r39 = r38[r37];
        if (r12 <= 21) goto L83;
        char r40 = charAt(this.bp + 21);
        if (r40 < '0') goto L83;
        if (r40 > '9') goto L83;
        r39 = (r39 * 10) + r38[r40];
        int r41 = 2;
    L84:
        if (r41 != 2) goto L90;
        char r42 = charAt(this.bp + 22);
        if (r42 < '0') goto L90;
        if (r42 > '9') goto L90;
        r39 = (r39 * 10) + r38[r42];
        r41 = 3;
    L90:
        this.calendar.set(14, r39);
        char r43 = charAt((this.bp + 20) + r41);
        if (r43 != '+') goto L93;
    L104:
        char r44 = charAt(((this.bp + 20) + r41) + 1);
        if (r44 < '0') goto L145;
        if (r44 > '1') goto L145;
        char r45 = charAt(((this.bp + 20) + r41) + 2);
        if (r45 < '0') goto L145;
        if (r45 > '9') goto L145;
        char r46 = charAt(((this.bp + 20) + r41) + 3);
        if (r46 == ':') goto L117;
        if (r46 == '0') goto L125;
        int r110 = 3;
    L129:
        int r47 = ((r38[r44] * 10) + r38[r45]) * 3600000;
        if (r43 != '-') goto L133;
        r47 = -r47;
    L133:
        if (this.calendar.getTimeZone().getRawOffset() == r47) goto L137;
        String[] r48 = TimeZone.getAvailableIDs(r47);
        if (r48.length <= 0) goto L137;
        this.calendar.setTimeZone(TimeZone.getTimeZone(r48[0]));
    L137:
        int r49 = r110;
    L138:
        int r50 = (r41 + 20) + r49;
        char r51 = charAt(this.bp + r50);
        if (r51 != 26) goto L141;
    L143:
        int r52 = this.bp + r50;
        this.bp = r52;
        this.ch = charAt(r52);
        this.token = 5;
        return true;
    L141:
        if (r51 == '\"') goto L143;
        return false;
    L125:
        if (charAt(((this.bp + 20) + r41) + 4) == '0') goto L127;
        return false;
    L127:
        r110 = 5;
        goto L129
    L117:
        if (charAt(((this.bp + 20) + r41) + 4) == '0') goto L120;
        return false;
    L120:
        if (charAt(((this.bp + 20) + r41) + 5) == '0') goto L122;
        return false;
    L122:
        r110 = 6;
        goto L129
    L93:
        if (r43 == '-') goto L104;
        if (r43 == 'Z') goto L98;
        r49 = 0;
        goto L138
    L98:
        if (this.calendar.getTimeZone().getRawOffset() == 0) goto L102;
        String[] r53 = TimeZone.getAvailableIDs(0);
        if (r53.length <= 0) goto L102;
        this.calendar.setTimeZone(TimeZone.getTimeZone(r53[0]));
    L102:
        r49 = 1;
    L83:
        r41 = 1;
    L28:
        int r111 = 0;
        if (r36 == false) goto L156;
        return false;
    L156:
        char r54 = charAt(this.bp);
        char r55 = charAt(this.bp + 1);
        char r56 = charAt(this.bp + 2);
        char r57 = charAt(this.bp + 3);
        char r58 = charAt(this.bp + 4);
        char r112 = charAt(this.bp + 5);
        char r113 = charAt(this.bp + 6);
        char r114 = charAt(this.bp + 7);
        if (checkDate(r54, r55, r56, r57, r58, r112, r113, r114) == true) goto L159;
        return false;
    L159:
        setCalendar(r54, r55, r56, r57, r58, r112, r113, r114);
        if (r12 == 8) goto L181;
        char r59 = charAt(this.bp + 8);
        char r60 = charAt(this.bp + 9);
        char r61 = charAt(this.bp + 10);
        char r115 = charAt(this.bp + 11);
        char r116 = charAt(this.bp + 12);
        char r117 = charAt(this.bp + 13);
        if (checkTime(r59, r60, r61, r115, r116, r117) == true) goto L165;
        return false;
    L165:
        if (r12 != 17) goto L179;
        char r62 = charAt(this.bp + 14);
        char r63 = charAt(this.bp + 15);
        char r64 = charAt(this.bp + 16);
        char r65 = '0';
        if (r62 >= '0') goto L169;
    L178:
        return false;
    L169:
        if (r62 > '9') goto L178;
        if (r63 < '0') goto L178;
        if (r63 > '9') goto L178;
        if (r64 < '0') goto L178;
        if (r64 > '9') goto L178;
        int r66 = (((r62 - '0') * 100) + ((r63 - '0') * 10)) + (r64 - '0');
    L180:
        int r67 = ((r116 - '0') * 10) + (r117 - '0');
        r111 = ((r61 - r65) * 10) + (r115 - r65);
        int r310 = r66;
        int r68 = ((r59 - r65) * 10) + (r60 - r65);
        int r69 = r310;
    L182:
        this.calendar.set(11, r68);
        this.calendar.set(12, r111);
        this.calendar.set(13, r67);
        this.calendar.set(14, r69);
        this.token = 5;
        return true;
    L179:
        r65 = '0';
        r66 = 0;
        goto L180
    L181:
        r69 = 0;
        r67 = 0;
        r68 = 0;
        goto L182
    }

    public final long scanLongValue() {
        boolean r10 = false;
        this.np = 0;
        if (this.ch != '-') goto L9;
        this.np = 1;
        int r11 = this.bp + 1;
        this.bp = r11;
        if (r11 >= this.len) goto L8;
        this.ch = this.text.charAt(r11);
        long r12 = Long.MIN_VALUE;
        r10 = true;
    L10:
        long r13 = 0;
    L11:
        char r14 = this.ch;
        if (r14 < '0') goto L28;
        if (r14 > '9') goto L28;
        int r15 = r14 - '0';
        if (r13 < (-922337203685477580L)) goto L27;
        long r16 = r13 * 10;
        long r17 = r15;
        if (r16 < (r12 + r17)) goto L25;
        r13 = r16 - r17;
        this.np++;
        int r18 = this.bp + 1;
        this.bp = r18;
        if (r18 < this.len) goto L22;
        char r19 = EOI;
    L23:
        this.ch = r19;
        goto L11
    L22:
        r19 = this.text.charAt(r18);
        goto L23
    L25:
        throw new JSONException("error long value, " + r16 + ", " + info());
    L27:
        throw new JSONException("error long value, " + r13 + ", " + info());
    L28:
        if (r10 == false) goto L30;
        return r13;
    L30:
        return -r13;
    L8:
        throw new JSONException("syntax error, " + info());
    L9:
        r12 = -9223372036854775807L;
        goto L10
    }

    public final void scanNumber() {
        int r10 = this.bp;
        this.np = r10;
        this.exp = false;
        if (this.ch != '-') goto L9;
        this.sp++;
        int r11 = r10 + 1;
        this.bp = r11;
        if (r11 < this.len) goto L7;
        char r12 = 26;
    L8:
        this.ch = r12;
        goto L9
    L7:
        r12 = this.text.charAt(r11);
    L9:
        char r13 = this.ch;
        if (r13 < '0') goto L17;
        if (r13 > '9') goto L17;
        this.sp++;
        int r14 = this.bp + 1;
        this.bp = r14;
        if (r14 < this.len) goto L15;
        char r15 = 26;
    L16:
        this.ch = r15;
        goto L9
    L15:
        r15 = this.text.charAt(r14);
    L17:
        this.isDouble = false;
        if (r13 != '.') goto L32;
        this.sp++;
        int r16 = this.bp + 1;
        this.bp = r16;
        if (r16 < this.len) goto L22;
        char r17 = 26;
    L23:
        this.ch = r17;
        this.isDouble = true;
    L24:
        char r18 = this.ch;
        if (r18 < '0') goto L32;
        if (r18 > '9') goto L32;
        this.sp++;
        int r19 = this.bp + 1;
        this.bp = r19;
        if (r19 < this.len) goto L30;
        char r20 = 26;
    L31:
        this.ch = r20;
        goto L24
    L30:
        r20 = this.text.charAt(r19);
        goto L31
    L22:
        r17 = this.text.charAt(r16);
    L32:
        char r21 = this.ch;
        if (r21 != 'L') goto L36;
        this.sp++;
        next();
    L76:
        if (this.isDouble == false) goto L78;
        this.token = 3;
        return;
    L78:
        this.token = 2;
        return;
    L36:
        if (r21 != 'S') goto L39;
        this.sp++;
        next();
        goto L76
    L39:
        if (r21 != 'B') goto L42;
        this.sp++;
        next();
        goto L76
    L42:
        if (r21 != 'F') goto L45;
        this.sp++;
        next();
        this.isDouble = true;
        goto L76
    L45:
        if (r21 != 'D') goto L48;
        this.sp++;
        next();
        this.isDouble = true;
        goto L76
    L48:
        if (r21 != 'e') goto L50;
    L51:
        this.sp++;
        int r22 = this.bp + 1;
        this.bp = r22;
        if (r22 < this.len) goto L54;
        char r23 = 26;
    L55:
        this.ch = r23;
        if (r23 == '+') goto L58;
        if (r23 == '-') goto L58;
    L63:
        char r24 = this.ch;
        if (r24 < '0') goto L71;
        if (r24 > '9') goto L71;
        this.sp++;
        int r25 = this.bp + 1;
        this.bp = r25;
        if (r25 < this.len) goto L69;
        char r26 = 26;
    L70:
        this.ch = r26;
        goto L63
    L69:
        r26 = this.text.charAt(r25);
    L71:
        if (r24 == 'D') goto L73;
        if (r24 == 'F') goto L73;
    L74:
        this.exp = true;
        this.isDouble = true;
    L73:
        this.sp++;
        next();
    L58:
        this.sp++;
        int r27 = this.bp + 1;
        this.bp = r27;
        if (r27 < this.len) goto L61;
        char r28 = 26;
    L62:
        this.ch = r28;
        goto L63
    L61:
        r28 = this.text.charAt(r27);
        goto L62
    L54:
        r23 = this.text.charAt(r22);
        goto L55
    L50:
        if (r21 != 'E') goto L76;
        goto L51
    }

    public final Number scanNumberValue() {
        int r10 = this.bp;
        this.np = 0;
        if (this.ch != '-') goto L9;
        this.np = 1;
        int r11 = r10 + 1;
        this.bp = r11;
        if (r11 < this.len) goto L7;
        char r12 = EOI;
    L8:
        this.ch = r12;
        long r13 = Long.MIN_VALUE;
        boolean r14 = true;
    L10:
        long r15 = 0;
        boolean r16 = false;
    L11:
        char r17 = this.ch;
        if (r17 < '0') goto L25;
        if (r17 > '9') goto L25;
        int r18 = r17 - '0';
        if (r15 >= (-922337203685477580L)) goto L17;
        r16 = true;
    L17:
        long r19 = r15 * 10;
        long r110 = r18;
        if (r19 >= (r13 + r110)) goto L20;
        r16 = true;
    L20:
        r15 = r19 - r110;
        this.np++;
        int r111 = this.bp + 1;
        this.bp = r111;
        if (r111 < this.len) goto L23;
        char r112 = EOI;
    L24:
        this.ch = r112;
        goto L11
    L23:
        r112 = this.text.charAt(r111);
    L25:
        if (r14 == true) goto L28;
        r15 = -r15;
    L28:
        if (r17 != 'L') goto L32;
        this.np++;
        next();
        Number r20 = Long.valueOf(r15);
    L30:
        Number r21 = r20;
    L43:
        if (this.ch != '.') goto L58;
        this.np++;
        int r22 = this.bp + 1;
        this.bp = r22;
        if (r22 < this.len) goto L47;
        char r23 = EOI;
    L48:
        this.ch = r23;
    L49:
        char r24 = this.ch;
        if (r24 < '0') goto L57;
        if (r24 > '9') goto L57;
        this.np++;
        int r25 = this.bp + 1;
        this.bp = r25;
        if (r25 < this.len) goto L55;
        char r26 = EOI;
    L56:
        this.ch = r26;
        goto L49
    L55:
        r26 = this.text.charAt(r25);
    L57:
        boolean r27 = true;
    L59:
        char r28 = this.ch;
        if (r28 != 'e') goto L62;
    L65:
        this.np++;
        int r29 = this.bp + 1;
        this.bp = r29;
        if (r29 < this.len) goto L68;
        char r30 = EOI;
    L69:
        this.ch = r30;
        if (r30 == '+') goto L72;
        if (r30 == '-') goto L72;
    L77:
        char r31 = this.ch;
        if (r31 < '0') goto L85;
        if (r31 > '9') goto L85;
        this.np++;
        int r32 = this.bp + 1;
        this.bp = r32;
        if (r32 < this.len) goto L83;
        char r33 = EOI;
    L84:
        this.ch = r33;
        goto L77
    L83:
        r33 = this.text.charAt(r32);
    L85:
        if (r31 != 'D') goto L87;
    L90:
        this.np++;
        next();
    L91:
        boolean r34 = true;
    L92:
        if (r27 == true) goto L104;
        if (r34 == true) goto L104;
        if (r16 == false) goto L96;
        int r35 = this.bp;
        char[] r36 = new char[r35 - r10];
        this.text.getChars(r10, r35, r36, 0);
        r21 = new BigInteger(new String(r36));
    L96:
        if (r21 == null) goto L98;
        return r21;
    L98:
        if (r15 <= (-2147483648L)) goto L103;
        if (r15 >= 2147483647L) goto L103;
        return Integer.valueOf((int) r15);
    L103:
        return Long.valueOf(r15);
    L104:
        int r37 = this.bp - r10;
        if (r31 == 0) goto L107;
        r37 = r37 - 1;
    L107:
        char[] r38 = this.sbuf;
        if (r37 >= r38.length) goto L110;
        int r39 = 0;
        this.text.getChars(r10, r10 + r37, r38, 0);
        char[] r40 = this.sbuf;
    L111:
        if (r34 == true) goto L156;
        if ((this.features & Feature.UseBigDecimal.mask) == 0) goto L156;
        return new BigDecimal(r40, r39, r37);
    L156:
        if (r37 > 9) goto L147;
        if (r34 == true) goto L147;
        char r41 = r40[r39];     // Catch: NumberFormatException -> L133
        if (r41 == '-') goto L123;
        if (r41 == '+') goto L123;
        int r42 = 1;
    L124:
        int r43 = r41 - '0';     // Catch: NumberFormatException -> L133
        int r44 = 0;
    L125:
        if (r42 >= r37) goto L136;
        char r45 = r40[r42];     // Catch: NumberFormatException -> L133
        if (r45 != '.') goto L129;
        r44 = 1;
    L132:
        r42 = r42 + 1;     // Catch: NumberFormatException -> L133
        goto L125
    L129:
        r43 = (r43 * 10) + (r45 - '0');     // Catch: NumberFormatException -> L133
        if (r44 == 0) goto L132;
        r44 = r44 * 10;     // Catch: NumberFormatException -> L133
        goto L132
    L136:
        if (r31 != 'F') goto L142;
        float r46 = r43 / r44;     // Catch: NumberFormatException -> L133
        if (r14 == false) goto L141;
        r46 = -r46;
    L141:
        return Float.valueOf(r46);
    L142:
        double r47 = ((double) r43) / ((double) r44);     // Catch: NumberFormatException -> L133
        if (r14 == 0) goto L146;
        r47 = -r47;
    L146:
        return Double.valueOf(r47);
    L123:
        r41 = r40[1];     // Catch: NumberFormatException -> L133
        r42 = 2;
    L147:
        String r48 = new String(r40, 0, r37);     // Catch: NumberFormatException -> L133
        if (r31 != 'F') goto L151;
        Number r49 = Float.valueOf(r48);     // Catch: NumberFormatException -> L133
    L176:
        return r49;
    L151:
        r49 = Double.valueOf(Double.parseDouble(r48));     // Catch: NumberFormatException -> L133
    L133:
        e = move-exception;
        throw new JSONException(e.getMessage() + ", " + info(), e);
    L110:
        r39 = 0;
        char[] r50 = new char[r37];
        this.text.getChars(r10, r10 + r37, r50, 0);
        r40 = r50;
        goto L111
    L87:
        if (r31 == 'F') goto L90;
        r31 = 0;
    L72:
        this.np++;
        int r51 = this.bp + 1;
        this.bp = r51;
        if (r51 < this.len) goto L75;
        char r52 = EOI;
    L76:
        this.ch = r52;
        goto L77
    L75:
        r52 = this.text.charAt(r51);
        goto L76
    L68:
        r30 = this.text.charAt(r29);
        goto L69
    L62:
        if (r28 == 'E') goto L65;
        r31 = 0;
        r34 = false;
        goto L92
    L47:
        r23 = this.text.charAt(r22);
        goto L48
    L58:
        r27 = false;
        goto L59
    L32:
        if (r17 != 'S') goto L35;
        this.np++;
        next();
        r20 = Short.valueOf((short) r15);
        goto L30
    L35:
        if (r17 != 'B') goto L37;
        this.np++;
        next();
        r20 = Byte.valueOf((byte) r15);
        goto L30
    L37:
        if (r17 != 'F') goto L39;
        this.np++;
        next();
        r20 = Float.valueOf(r15);
        goto L30
    L39:
        if (r17 != 'D') goto L41;
        this.np++;
        next();
        r21 = Double.valueOf(r15);
        goto L43
    L41:
        r21 = null;
        goto L43
    L7:
        r12 = this.text.charAt(r11);
        goto L8
    L9:
        r13 = -9223372036854775807L;
        r14 = false;
        goto L10
    }

    public final void scanString() {
        char r10 = this.ch;
        int r11 = this.bp + 1;
        int r12 = this.text.indexOf(r10, r11);
        if (r12 == (-1)) goto L37;
        int r13 = r12 - r11;
        char[] r14 = sub_chars(this.bp + 1, r13);
        int r15 = 0;
        boolean r16 = false;
    L6:
        if (r13 <= 0) goto L24;
        if (r14[r13 - 1] != '\\') goto L24;
        int r17 = r13 - 2;
        int r18 = 1;
    L10:
        if (r17 < 0) goto L15;
        if (r14[r17] != '\\') goto L15;
        r18 = r18 + 1;
        r17 = r17 - 1;
    L15:
        if ((r18 % 2) == 0) goto L24;
        int r19 = this.text.indexOf(r10, r12 + 1);
        int r20 = (r19 - r12) + r13;
        if (r20 < r14.length) goto L23;
        int r21 = (r14.length * 3) / 2;
        if (r21 >= r20) goto L22;
        r21 = r20;
    L22:
        char[] r22 = new char[r21];
        System.arraycopy(r14, 0, r22, 0, r14.length);
        r14 = r22;
    L23:
        this.text.getChars(r12, r19, r14, r13);
        r12 = r19;
        r13 = r20;
        r16 = true;
    L24:
        if (r16 == true) goto L30;
    L25:
        if (r15 >= r13) goto L30;
        if (r14[r15] != '\\') goto L29;
        r16 = true;
    L29:
        r15 = r15 + 1;
    L30:
        this.sbuf = r14;
        this.sp = r13;
        this.np = this.bp;
        this.hasSpecial = r16;
        int r23 = r12 + 1;
        this.bp = r23;
        if (r23 < this.len) goto L33;
        char r24 = EOI;
    L34:
        this.ch = r24;
        this.token = 4;
        return;
    L33:
        r24 = this.text.charAt(r23);
        goto L34
    L37:
        throw new JSONException("unclosed str, " + info());
    }

    public String scanStringValue(char r10) {
        int r11 = this.bp + 1;
        int r12 = this.text.indexOf(r10, r11);
        if (r12 == (-1)) goto L26;
        if (V6 == false) goto L7;
        String r13 = this.text.substring(r11, r12);
    L9:
        if (r13.indexOf(92) == (-1)) goto L19;
    L10:
        int r14 = r12 - 1;
        int r15 = 0;
    L11:
        if (r14 < 0) goto L16;
        if (this.text.charAt(r14) != '\\') goto L16;
        r15 = r15 + 1;
        r14 = r14 - 1;
    L16:
        if ((r15 % 2) == 0) goto L17;
        r12 = this.text.indexOf(r10, r12 + 1);
        goto L10
    L17:
        int r16 = r12 - r11;
        r13 = readString(sub_chars(this.bp + 1, r16), r16);
    L19:
        int r17 = r12 + 1;
        this.bp = r17;
        if (r17 < this.len) goto L22;
        char r18 = EOI;
    L23:
        this.ch = r18;
        return r13;
    L22:
        r18 = this.text.charAt(r17);
        goto L23
    L7:
        int r19 = r12 - r11;
        r13 = new String(sub_chars(this.bp + 1, r19), 0, r19);
        goto L9
    L26:
        throw new JSONException("unclosed str, " + info());
    }

    public final String scanSymbol(SymbolTable r10) {
    L2:
        char r11 = this.ch;
        if (r11 == ' ') goto L37;
        if (r11 == '\n') goto L37;
        if (r11 == '\r') goto L37;
        if (r11 == '\t') goto L37;
        if (r11 == '\f') goto L37;
        if (r11 == '\b') goto L37;
        if (r11 != '\"') goto L20;
        return scanSymbol(r10, TokenParser.DQUOTE);
    L20:
        if (r11 != '\'') goto L24;
        return scanSymbol(r10, '\'');
    L24:
        if (r11 != '}') goto L28;
        next();
        this.token = 13;
        return null;
    L28:
        if (r11 != ',') goto L32;
        next();
        this.token = 16;
        return null;
    L32:
        if (r11 != 26) goto L36;
        this.token = 20;
        return null;
    L36:
        return scanSymbolUnQuoted(r10);
    L37:
        next();
        goto L2
    }

    public final String scanSymbolUnQuoted(SymbolTable r10) {
        int r11 = this.ch;
        boolean[] r12 = firstIdentifierFlags;
        if (r11 < r12.length) goto L5;
    L9:
        this.np = this.bp;
        this.sp = 1;
    L10:
        char r13 = next();
        boolean[] r14 = identifierFlags;
        if (r13 >= r14.length) goto L22;
        if (r14[r13] == true) goto L22;
        this.ch = charAt(this.bp);
        this.token = 18;
        if (this.sp != 4) goto L21;
        if (this.text.startsWith("null", this.np) == false) goto L21;
        return null;
    L21:
        return r10.addSymbol(this.text, this.np, this.sp, r11);
    L22:
        r11 = (r11 * 31) + r13;
        this.sp++;
        goto L10
    L5:
        if (r12[r11] == true) goto L9;
        throw new JSONException("illegal identifier : " + this.ch + ", " + info());
    }

    public void skipComment() {
        next();
        char r10 = this.ch;
        if (r10 != '/') goto L9;
    L4:
        next();
        if (this.ch != '\n') goto L4;
        next();
        return;
    L9:
        if (r10 != '*') goto L20;
        next();
    L11:
        char r11 = this.ch;
        if (r11 == 26) goto L30;
        if (r11 == '*') goto L14;
        next();
        goto L11
    L14:
        next();
        if (this.ch != '/') goto L11;
        next();
        return;
    L30:
        return;
    L20:
        throw new JSONException("invalid comment");
    }

    public final void skipWhitespace() {
    L2:
        char r10 = this.ch;
        if (r10 > '/') goto L20;
        if (r10 == ' ') goto L19;
        if (r10 == '\r') goto L19;
        if (r10 == '\n') goto L19;
        if (r10 == '\t') goto L19;
        if (r10 == '\f') goto L19;
        if (r10 == '\b') goto L19;
        if (r10 != '/') goto L33;
        skipComment();
        goto L2
    L33:
        return;
    L19:
        next();
        goto L2
    }

    public final String stringVal() {
        if (this.hasSpecial == false) goto L6;
        return readString(this.sbuf, this.sp);
    L6:
        return subString(this.np + 1, this.sp);
    }

    public final char[] sub_chars(int r10, int r11) {
        char[] r12 = this.sbuf;
        if (r11 >= r12.length) goto L6;
        this.text.getChars(r10, r11 + r10, r12, 0);
        return this.sbuf;
    L6:
        char[] r13 = new char[r11];
        this.sbuf = r13;
        this.text.getChars(r10, r11 + r10, r13, 0);
        return r13;
    }

    public final int token() {
        return this.token;
    }

    public JSONLexer(char[] r10, int r11) {
        this(r10, r11, JSON.DEFAULT_PARSER_FEATURE);
    }

    public JSONLexer(char[] r10, int r11, int r12) {
        this(new String(r10, 0, r11), r12);
    }

    public JSONLexer(String r10, int r11) {
        this.features = JSON.DEFAULT_PARSER_FEATURE;
        boolean r12 = false;
        this.exp = false;
        this.isDouble = false;
        this.timeZone = JSON.defaultTimeZone;
        this.locale = JSON.defaultLocale;
        String r13 = null;
        this.calendar = null;
        this.matchStat = 0;
        char[] r14 = sbufLocal.get();
        this.sbuf = r14;
        if (r14 != null) goto L5;
        this.sbuf = new char[512];
    L5:
        this.features = r11;
        this.text = r10;
        int r15 = r10.length();
        this.len = r15;
        int r16 = (-1) + 1;
        this.bp = r16;
        if (r16 < r15) goto L8;
        char r17 = EOI;
    L9:
        this.ch = r17;
        if (r17 != 65279) goto L13;
        next();
    L13:
        if ((Feature.InitStringFieldAsEmpty.mask & r11) == 0) goto L15;
        r13 = "";
    L15:
        this.stringDefaultValue = r13;
        if ((Feature.DisableCircularReferenceDetect.mask & r11) == 0) goto L18;
        r12 = true;
    L18:
        this.disableCircularReferenceDetect = r12;
        return;
    L8:
        r17 = r10.charAt(r16);
        goto L9
    }

    public String scanSymbol(SymbolTable r11, char r12) {
        int r10 = this.bp + 1;
        int r13 = this.text.indexOf(r12, r10);
        if (r13 == (-1)) goto L45;
        int r14 = r13 - r10;
        char[] r15 = sub_chars(this.bp + 1, r14);
        boolean r16 = false;
    L6:
        if (r14 <= 0) goto L24;
        if (r15[r14 - 1] != '\\') goto L24;
        int r17 = r14 - 2;
        int r18 = 1;
    L10:
        if (r17 < 0) goto L15;
        if (r15[r17] != '\\') goto L15;
        r18 = r18 + 1;
        r17 = r17 - 1;
    L15:
        if ((r18 % 2) == 0) goto L24;
        int r19 = this.text.indexOf(r12, r13 + 1);
        int r20 = (r19 - r13) + r14;
        if (r20 < r15.length) goto L23;
        int r21 = (r15.length * 3) / 2;
        if (r21 >= r20) goto L22;
        r21 = r20;
    L22:
        char[] r22 = new char[r21];
        System.arraycopy(r15, 0, r22, 0, r15.length);
        r15 = r22;
    L23:
        this.text.getChars(r13, r19, r15, r14);
        r13 = r19;
        r14 = r20;
        r16 = true;
    L24:
        if (r16 == true) goto L37;
        int r110 = 0;
        int r23 = 0;
    L26:
        if (r110 >= r14) goto L31;
        char r24 = r15[r110];
        r23 = (r23 * 31) + r24;
        if (r24 != '\\') goto L30;
        r16 = true;
    L30:
        r110 = r110 + 1;
        goto L26
    L31:
        if (r16 == false) goto L34;
        String r111 = readString(r15, r14);
    L38:
        int r25 = r13 + 1;
        this.bp = r25;
        if (r25 < this.len) goto L41;
        char r112 = EOI;
    L42:
        this.ch = r112;
        return r111;
    L41:
        r112 = this.text.charAt(r25);
        goto L42
    L34:
        if (r14 >= 20) goto L36;
        r111 = r11.addSymbol(r15, 0, r14, r23);
        goto L38
    L36:
        r111 = new String(r15, 0, r14);
        goto L38
    L37:
        r111 = readString(r15, r14);
        goto L38
    L45:
        throw new JSONException("unclosed str, " + info());
    }

    public final BigDecimal decimalValue() {
        char r10 = this.text.charAt((this.np + this.sp) - 1);
        int r11 = this.sp;
        if (r10 != 'L') goto L5;
    L12:
        r11 = r11 - 1;
    L13:
        int r12 = this.np;
        char[] r13 = this.sbuf;
        if (r11 >= r13.length) goto L17;
        this.text.getChars(r12, r12 + r11, r13, 0);
        return new BigDecimal(this.sbuf, 0, r11);
    L17:
        char[] r14 = new char[r11];
        this.text.getChars(r12, r11 + r12, r14, 0);
        return new BigDecimal(r14);
    L5:
        if (r10 == 'S') goto L12;
        if (r10 == 'B') goto L12;
        if (r10 == 'F') goto L12;
        if (r10 != 'D') goto L13;
        goto L12
    }

    public final void nextToken(int r11) {
        this.sp = 0;
    L4:
        if (r11 == 2) goto L88;
        char r10 = EOI;
        if (r11 == 4) goto L73;
        if (r11 != 12) goto L9;
        char r12 = this.ch;
        if (r12 == '{') goto L60;
        if (r12 == '[') goto L67;
    L102:
        char r13 = this.ch;
        if (r13 == ' ') goto L115;
        if (r13 == '\n') goto L115;
        if (r13 == '\r') goto L115;
        if (r13 == '\t') goto L115;
        if (r13 == '\f') goto L115;
        if (r13 == '\b') goto L115;
        nextToken();
        return;
    L115:
        next();
        goto L4
    L67:
        this.token = 14;
        int r14 = this.bp + 1;
        this.bp = r14;
        if (r14 >= this.len) goto L71;
        r10 = this.text.charAt(r14);
    L71:
        this.ch = r10;
        return;
    L60:
        this.token = 12;
        int r15 = this.bp + 1;
        this.bp = r15;
        if (r15 >= this.len) goto L64;
        r10 = this.text.charAt(r15);
    L64:
        this.ch = r10;
        return;
    L9:
        if (r11 == 18) goto L56;
        if (r11 == 20) goto L53;
        switch(r11) {
            case 14: goto L45;
            case 15: goto L42;
            case 16: goto L15;
            default: goto L102;
        };
    L15:
        char r16 = this.ch;
        if (r16 == ',') goto L17;
        if (r16 == '}') goto L25;
        if (r16 == ']') goto L32;
        if (r16 != 26) goto L102;
        this.token = 20;
        return;
    L32:
        this.token = 15;
        int r17 = this.bp + 1;
        this.bp = r17;
        if (r17 >= this.len) goto L36;
        r10 = this.text.charAt(r17);
    L36:
        this.ch = r10;
        return;
    L25:
        this.token = 13;
        int r18 = this.bp + 1;
        this.bp = r18;
        if (r18 >= this.len) goto L29;
        r10 = this.text.charAt(r18);
    L29:
        this.ch = r10;
        return;
    L17:
        this.token = 16;
        int r19 = this.bp + 1;
        this.bp = r19;
        if (r19 >= this.len) goto L21;
        r10 = this.text.charAt(r19);
    L21:
        this.ch = r10;
        return;
    L45:
        char r20 = this.ch;
        if (r20 == '[') goto L47;
        if (r20 != '{') goto L102;
        this.token = 12;
        next();
        return;
    L47:
        this.token = 14;
        next();
        return;
    L42:
        if (this.ch != ']') goto L53;
        this.token = 15;
        next();
        return;
    L53:
        if (this.ch != 26) goto L102;
        this.token = 20;
        return;
    L56:
        nextIdent();
        return;
    L73:
        char r21 = this.ch;
        if (r21 == '\"') goto L75;
        if (r21 < '0') goto L81;
        if (r21 > '9') goto L81;
        this.pos = this.bp;
        scanNumber();
        return;
    L81:
        if (r21 != '{') goto L102;
        this.token = 12;
        int r110 = this.bp + 1;
        this.bp = r110;
        if (r110 >= this.len) goto L86;
        r10 = this.text.charAt(r110);
    L86:
        this.ch = r10;
        return;
    L75:
        this.pos = this.bp;
        scanString();
        return;
    L88:
        char r22 = this.ch;
        if (r22 < '0') goto L93;
        if (r22 > '9') goto L93;
        this.pos = this.bp;
        scanNumber();
        return;
    L93:
        if (r22 == '\"') goto L94;
        if (r22 == '[') goto L97;
        if (r22 != '{') goto L102;
        this.token = 12;
        next();
        return;
    L97:
        this.token = 14;
        next();
        return;
    L94:
        this.pos = this.bp;
        scanString();
    }
}
