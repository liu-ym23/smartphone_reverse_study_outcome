package com.google.gson.stream;

import com.google.gson.internal.JsonReaderInternalAccess;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;
import java.util.Arrays;
import org.apache.http.message.TokenParser;

/* JADX INFO: loaded from: classes3.dex */
public class JsonReader implements Closeable {
    private static final long MIN_INCOMPLETE_INTEGER = -922337203685477580L;
    private static final char[] NON_EXECUTE_PREFIX = null;
    private static final int NUMBER_CHAR_DECIMAL = 3;
    private static final int NUMBER_CHAR_DIGIT = 2;
    private static final int NUMBER_CHAR_EXP_DIGIT = 7;
    private static final int NUMBER_CHAR_EXP_E = 5;
    private static final int NUMBER_CHAR_EXP_SIGN = 6;
    private static final int NUMBER_CHAR_FRACTION_DIGIT = 4;
    private static final int NUMBER_CHAR_NONE = 0;
    private static final int NUMBER_CHAR_SIGN = 1;
    private static final int PEEKED_BEGIN_ARRAY = 3;
    private static final int PEEKED_BEGIN_OBJECT = 1;
    private static final int PEEKED_BUFFERED = 11;
    private static final int PEEKED_DOUBLE_QUOTED = 9;
    private static final int PEEKED_DOUBLE_QUOTED_NAME = 13;
    private static final int PEEKED_END_ARRAY = 4;
    private static final int PEEKED_END_OBJECT = 2;
    private static final int PEEKED_EOF = 17;
    private static final int PEEKED_FALSE = 6;
    private static final int PEEKED_LONG = 15;
    private static final int PEEKED_NONE = 0;
    private static final int PEEKED_NULL = 7;
    private static final int PEEKED_NUMBER = 16;
    private static final int PEEKED_SINGLE_QUOTED = 8;
    private static final int PEEKED_SINGLE_QUOTED_NAME = 12;
    private static final int PEEKED_TRUE = 5;
    private static final int PEEKED_UNQUOTED = 10;
    private static final int PEEKED_UNQUOTED_NAME = 14;
    private final char[] buffer;
    private final Reader in;
    private boolean lenient;
    private int limit;
    private int lineNumber;
    private int lineStart;
    private int[] pathIndices;
    private String[] pathNames;
    int peeked;
    private long peekedLong;
    private int peekedNumberLength;
    private String peekedString;
    private int pos;
    private int[] stack;
    private int stackSize;

    static {
        NON_EXECUTE_PREFIX = ")]}'\n".toCharArray();
        JsonReaderInternalAccess.INSTANCE = new AnonymousClass1();
    }

    public JsonReader(Reader r10) {
        this.lenient = false;
        this.buffer = new char[1024];
        this.pos = 0;
        this.limit = 0;
        this.lineNumber = 0;
        this.lineStart = 0;
        this.peeked = 0;
        int[] r11 = new int[32];
        this.stack = r11;
        this.stackSize = 1;
        r11[0] = 6;
        this.pathNames = new String[32];
        this.pathIndices = new int[32];
        if (r10 == null) goto L7;
        this.in = r10;
        return;
    L7:
        throw new NullPointerException("in == null");
    }

    private void checkLenient() throws IOException {
        if (this.lenient == false) goto L6;
        return;
    L6:
        throw syntaxError("Use JsonReader.setLenient(true) to accept malformed JSON");
    }

    private void consumeNonExecutePrefix() throws IOException {
        nextNonWhitespace(true);
        int r10 = this.pos - 1;
        this.pos = r10;
        char[] r11 = NON_EXECUTE_PREFIX;
        if ((r10 + r11.length) > this.limit) goto L5;
    L7:
        int r12 = 0;
    L8:
        char[] r13 = NON_EXECUTE_PREFIX;
        if (r12 >= r13.length) goto L14;
        if (this.buffer[this.pos + r12] != r13[r12]) goto L12;
        r12 = r12 + 1;
        goto L8
    L12:
        return;
    L14:
        this.pos += r13.length;
        return;
    L5:
        if (fillBuffer(r11.length) == true) goto L7;
    }

    private boolean fillBuffer(int r10) throws IOException {
        char[] r11 = this.buffer;
        int r12 = this.lineStart;
        int r13 = this.pos;
        this.lineStart = r12 - r13;
        int r14 = this.limit;
        if (r14 == r13) goto L5;
        int r15 = r14 - r13;
        this.limit = r15;
        System.arraycopy(r11, r13, r11, 0, r15);
    L6:
        this.pos = 0;
    L7:
        Reader r16 = this.in;
        int r17 = this.limit;
        int r18 = r16.read(r11, r17, r11.length - r17);
        if (r18 == (-1)) goto L19;
        int r19 = this.limit + r18;
        this.limit = r19;
        if (this.lineNumber != 0) goto L17;
        int r20 = this.lineStart;
        if (r20 != 0) goto L17;
        if (r19 <= 0) goto L17;
        if (r11[0] != 65279) goto L17;
        this.pos++;
        this.lineStart = r20 + 1;
        r10 = r10 + 1;
    L17:
        if (r19 < r10) goto L7;
        return true;
    L19:
        return false;
    L5:
        this.limit = 0;
        goto L6
    }

    private boolean isLiteral(char r10) throws IOException {
        if (r10 != '\t') goto L5;
        return false;
    L5:
        if (r10 != '\n') goto L7;
        return false;
    L7:
        if (r10 != '\f') goto L9;
        return false;
    L9:
        if (r10 != '\r') goto L11;
        return false;
    L11:
        if (r10 != ' ') goto L13;
        return false;
    L13:
        if (r10 != '#') goto L15;
    L31:
        checkLenient();
        return false;
    L15:
        if (r10 != ',') goto L17;
        return false;
    L17:
        if (r10 == '/') goto L31;
        if (r10 == '=') goto L31;
        if (r10 != '{') goto L23;
        return false;
    L23:
        if (r10 != '}') goto L25;
        return false;
    L25:
        if (r10 != ':') goto L27;
        return false;
    L27:
        if (r10 == ';') goto L31;
        switch(r10) {
            case 91: goto L43;
            case 92: goto L31;
            case 93: goto L43;
            default: goto L29;
        };
    L29:
        return true;
    L43:
        return false;
    }

    private int nextNonWhitespace(boolean r10) throws IOException {
        char[] r11 = this.buffer;
        int r12 = this.pos;
        int r13 = this.limit;
    L4:
        if (r12 != r13) goto L13;
        this.pos = r12;
        if (fillBuffer(1) == false) goto L7;
        r12 = this.pos;
        r13 = this.limit;
        goto L13
    L7:
        if (r10 == true) goto L11;
        return -1;
    L11:
        throw new EOFException("End of input" + locationString());
    L13:
        int r14 = r12 + 1;
        char r15 = r11[r12];
        if (r15 == '\n') goto L15;
        if (r15 == ' ') goto L45;
        if (r15 == '\r') goto L45;
        if (r15 == '\t') goto L45;
        if (r15 == '/') goto L25;
        if (r15 != '#') goto L43;
        this.pos = r14;
        checkLenient();
        skipToEndOfLine();
        r12 = this.pos;
        r13 = this.limit;
        goto L4
    L43:
        this.pos = r14;
        return r15;
    L25:
        this.pos = r14;
        if (r14 != r13) goto L30;
        this.pos = r12;
        boolean r16 = fillBuffer(2);
        this.pos++;
        if (r16 == true) goto L30;
        return r15;
    L30:
        checkLenient();
        int r17 = this.pos;
        char r18 = r11[r17];
        if (r18 != '*') goto L32;
        this.pos = r17 + 1;
        if (skipTo("*/") == false) goto L39;
        r12 = this.pos + 2;
        r13 = this.limit;
        goto L4
    L39:
        throw syntaxError("Unterminated comment");
    L32:
        if (r18 != '/') goto L33;
        this.pos = r17 + 1;
        skipToEndOfLine();
        r12 = this.pos;
        r13 = this.limit;
        goto L4
    L33:
        return r15;
    L45:
        r12 = r14;
        goto L4
    L15:
        this.lineNumber++;
        this.lineStart = r14;
        goto L45
    }

    private String nextQuotedValue(char r10) throws IOException {
        char[] r11 = this.buffer;
        StringBuilder r12 = null;
    L3:
        int r13 = this.pos;
        int r14 = this.limit;
    L4:
        int r15 = r14;
        int r16 = r13;
    L6:
        if (r13 >= r15) goto L25;
        int r17 = r13 + 1;
        char r18 = r11[r13];
        if (r18 == r10) goto L9;
        if (r18 == '\\') goto L17;
        if (r18 != '\n') goto L24;
        this.lineNumber++;
        this.lineStart = r17;
    L24:
        r13 = r17;
        goto L6
    L17:
        this.pos = r17;
        int r19 = r17 - r16;
        int r20 = r19 - 1;
        if (r12 != null) goto L20;
        r12 = new StringBuilder(Math.max(r19 * 2, 16));
    L20:
        r12.append(r11, r16, r20);
        r12.append(readEscapeCharacter());
        r13 = this.pos;
        r14 = this.limit;
        goto L4
    L9:
        this.pos = r17;
        int r21 = (r17 - r16) - 1;
        if (r12 == null) goto L12;
        r12.append(r11, r16, r21);
        return r12.toString();
    L12:
        return new String(r11, r16, r21);
    L25:
        if (r12 != null) goto L27;
        r12 = new StringBuilder(Math.max((r13 - r16) * 2, 16));
    L27:
        r12.append(r11, r16, r13 - r16);
        this.pos = r13;
        if (fillBuffer(1) == true) goto L3;
        throw syntaxError("Unterminated string");
    }

    private String nextUnquotedValue() throws IOException {
        StringBuilder r10 = null;
        int r11 = 0;
    L3:
        int r12 = 0;
    L4:
        int r13 = this.pos;
        if ((r13 + r12) < this.limit) goto L6;
        if (r12 >= this.buffer.length) goto L41;
        if (fillBuffer(r12 + 1) == true) goto L4;
    L40:
        r11 = r12;
    L45:
        if (r10 != null) goto L47;
        String r14 = new String(this.buffer, this.pos, r11);
    L48:
        this.pos += r11;
        return r14;
    L47:
        r10.append(this.buffer, this.pos, r11);
        r14 = r10.toString();
        goto L48
    L41:
        if (r10 != null) goto L43;
        r10 = new StringBuilder(Math.max(r12, 16));
    L43:
        r10.append(this.buffer, this.pos, r12);
        this.pos += r12;
        if (fillBuffer(1) == true) goto L3;
    L6:
        char r15 = this.buffer[r13 + r12];
        if (r15 == '\t') goto L40;
        if (r15 == '\n') goto L40;
        if (r15 == '\f') goto L40;
        if (r15 == '\r') goto L40;
        if (r15 == ' ') goto L40;
        if (r15 == '#') goto L34;
        if (r15 == ',') goto L40;
        if (r15 == '/') goto L34;
        if (r15 == '=') goto L34;
        if (r15 == '{') goto L40;
        if (r15 == '}') goto L40;
        if (r15 == ':') goto L40;
        if (r15 == ';') goto L34;
        switch(r15) {
            case 91: goto L40;
            case 92: goto L34;
            case 93: goto L40;
            default: goto L33;
        };
    L33:
        r12 = r12 + 1;
    L34:
        checkLenient();
        goto L40
    }

    private int peekKeyword() throws IOException {
        char r10 = this.buffer[this.pos];
        if (r10 != 't') goto L5;
    L20:
        String r11 = "true";
        String r12 = "TRUE";
        int r13 = 5;
    L21:
        int r14 = r11.length();
        int r15 = 1;
    L22:
        if (r15 >= r14) goto L35;
        if ((this.pos + r15) >= this.limit) goto L26;
    L28:
        char r16 = this.buffer[this.pos + r15];
        if (r16 == r11.charAt(r15)) goto L33;
        if (r16 == r12.charAt(r15)) goto L33;
        return 0;
    L33:
        r15 = r15 + 1;
        goto L22
    L26:
        if (fillBuffer(r15 + 1) == true) goto L28;
        return 0;
    L35:
        if ((this.pos + r14) < this.limit) goto L39;
        if (fillBuffer(r14 + 1) == true) goto L39;
    L41:
        this.pos += r14;
        this.peeked = r13;
        return r13;
    L39:
        if (isLiteral(this.buffer[this.pos + r14]) == false) goto L41;
        return 0;
    L5:
        if (r10 == 'T') goto L20;
        if (r10 != 'f') goto L10;
    L19:
        r11 = "false";
        r12 = "FALSE";
        r13 = 6;
        goto L21
    L10:
        if (r10 == 'F') goto L19;
        if (r10 != 'n') goto L15;
    L18:
        r11 = "null";
        r12 = "NULL";
        r13 = 7;
        goto L21
    L15:
        if (r10 == 'N') goto L18;
        return 0;
    }

    private int peekNumber() throws IOException {
        char[] r10 = this.buffer;
        int r11 = this.pos;
        int r12 = this.limit;
        int r13 = 0;
        int r14 = 0;
        char r15 = 0;
        boolean r16 = false;
        boolean r17 = true;
        long r18 = 0;
    L4:
        if ((r11 + r14) == r12) goto L6;
    L12:
        char r19 = r10[r11 + r14];
        if (r19 != '+') goto L15;
        char r20 = 6;
        r13 = 0;
        if (r15 != 5) goto L101;
    L82:
        r15 = r20;
    L100:
        r14 = r14 + 1;
        goto L4
    L101:
        return 0;
    L15:
        if (r19 != 'E') goto L17;
    L90:
        r13 = 0;
        if (r15 != 2) goto L93;
    L96:
        r15 = 5;
        goto L100
    L93:
        if (r15 == 4) goto L96;
        return 0;
    L17:
        if (r19 == 'e') goto L90;
        if (r19 == '-') goto L84;
        r20 = 3;
        if (r19 != '.') goto L23;
        r13 = 0;
        if (r15 == 2) goto L82;
        return 0;
    L23:
        if (r19 < '0') goto L54;
        if (r19 > '9') goto L54;
        if (r15 == 1) goto L52;
        if (r15 == 0) goto L52;
        if (r15 == 2) goto L32;
        if (r15 != 3) goto L48;
        r13 = 0;
        r15 = 4;
        goto L100
    L48:
        if (r15 != 5) goto L50;
    L51:
        r13 = 0;
        r15 = 7;
        goto L100
    L50:
        if (r15 == 6) goto L51;
    L44:
        r13 = 0;
        goto L100
    L32:
        if (r18 == 0) goto L33;
        long r21 = (10 * r18) - ((long) (r19 - '0'));
        if (r18 > MIN_INCOMPLETE_INTEGER) goto L42;
        if (r18 == MIN_INCOMPLETE_INTEGER) goto L39;
    L41:
        boolean r22 = false;
    L43:
        r17 = r17 & r22;
        r18 = r21;
        goto L44
    L39:
        if (r21 >= r18) goto L41;
    L42:
        r22 = true;
        goto L43
    L33:
        return 0;
    L52:
        r18 = -(r19 - '0');
        r15 = 2;
    L54:
        if (isLiteral(r19) == true) goto L78;
    L55:
        if (r15 != 2) goto L68;
        if (r17 == false) goto L68;
        if (r18 != Long.MIN_VALUE) goto L61;
        if (r16 == false) goto L68;
    L61:
        if (r18 != 0) goto L63;
        if (r16 == true) goto L68;
    L63:
        if (r16 == true) goto L66;
        r18 = -r18;
    L66:
        this.peekedLong = r18;
        this.pos += r14;
        this.peeked = 15;
        return 15;
    L68:
        if (r15 != 2) goto L70;
    L76:
        this.peekedNumberLength = r14;
        this.peeked = 16;
        return 16;
    L70:
        if (r15 == 4) goto L76;
        if (r15 == 7) goto L76;
        return 0;
    L78:
        return 0;
    L84:
        r20 = 6;
        r13 = 0;
        if (r15 != 0) goto L87;
        r15 = 1;
        r16 = true;
        goto L100
    L87:
        if (r15 == 5) goto L82;
        return 0;
    L6:
        if (r14 == r10.length) goto L7;
        if (fillBuffer(r14 + 1) == false) goto L55;
        r11 = this.pos;
        r12 = this.limit;
        goto L12
    L7:
        return r13;
    }

    private void push(int r10) {
        int r11 = this.stackSize;
        int[] r12 = this.stack;
        if (r11 != r12.length) goto L5;
        int r13 = r11 * 2;
        this.stack = Arrays.copyOf(r12, r13);
        this.pathIndices = Arrays.copyOf(this.pathIndices, r13);
        this.pathNames = (String[]) Arrays.copyOf(this.pathNames, r13);
    L5:
        int[] r14 = this.stack;
        int r15 = this.stackSize;
        this.stackSize = r15 + 1;
        r14[r15] = r10;
    }

    private char readEscapeCharacter() throws IOException {
        if (this.pos == this.limit) goto L5;
    L9:
        char[] r10 = this.buffer;
        int r11 = this.pos;
        int r12 = r11 + 1;
        this.pos = r12;
        char r13 = r10[r11];
        if (r13 != '\n') goto L12;
        this.lineNumber++;
        this.lineStart = r12;
    L72:
        return r13;
    L12:
        if (r13 == '\"') goto L72;
        if (r13 == '\'') goto L72;
        if (r13 == '/') goto L72;
        if (r13 == '\\') goto L72;
        if (r13 != 'b') goto L22;
        return '\b';
    L22:
        if (r13 != 'f') goto L24;
        return '\f';
    L24:
        if (r13 != 'n') goto L26;
        return '\n';
    L26:
        if (r13 != 'r') goto L28;
        return TokenParser.CR;
    L28:
        if (r13 != 't') goto L30;
        return '\t';
    L30:
        if (r13 != 'u') goto L61;
        if ((r11 + 5) > this.limit) goto L34;
    L38:
        int r14 = this.pos;
        int r15 = r14 + 4;
        char r16 = 0;
    L39:
        if (r14 >= r15) goto L58;
        char r17 = this.buffer[r14];
        char r18 = (char) (r16 << 4);
        if (r17 < '0') goto L47;
        if (r17 > '9') goto L47;
        int r19 = r17 - '0';
    L45:
        r16 = (char) (r18 + r19);
        r14 = r14 + 1;
    L47:
        if (r17 < 'a') goto L51;
        if (r17 > 'f') goto L51;
        r19 = r17 - 'W';
    L51:
        if (r17 < 'A') goto L57;
        if (r17 > 'F') goto L57;
        r19 = r17 - '7';
    L57:
        throw new NumberFormatException("\\u" + new String(this.buffer, this.pos, 4));
    L58:
        this.pos += 4;
        return r16;
    L34:
        if (fillBuffer(4) == true) goto L38;
        throw syntaxError("Unterminated escape sequence");
    L61:
        throw syntaxError("Invalid escape sequence");
    L5:
        if (fillBuffer(1) == true) goto L9;
        throw syntaxError("Unterminated escape sequence");
    }

    private void skipQuotedValue(char r10) throws IOException {
        char[] r11 = this.buffer;
    L3:
        int r12 = this.pos;
        int r13 = this.limit;
    L5:
        if (r12 >= r13) goto L17;
        int r14 = r12 + 1;
        char r15 = r11[r12];
        if (r15 == r10) goto L8;
        if (r15 == '\\') goto L12;
        if (r15 != '\n') goto L16;
        this.lineNumber++;
        this.lineStart = r14;
    L16:
        r12 = r14;
        goto L5
    L12:
        this.pos = r14;
        readEscapeCharacter();
        r12 = this.pos;
        r13 = this.limit;
        goto L5
    L8:
        this.pos = r14;
        return;
    L17:
        this.pos = r12;
        if (fillBuffer(1) == true) goto L3;
        throw syntaxError("Unterminated string");
    }

    private boolean skipTo(String r10) throws IOException {
        int r11 = r10.length();
    L3:
        int r12 = 0;
        if ((this.pos + r11) > this.limit) goto L6;
    L9:
        char[] r13 = this.buffer;
        int r14 = this.pos;
        if (r13[r14] != '\n') goto L12;
        this.lineNumber++;
        this.lineStart = r14 + 1;
    L15:
        this.pos++;
    L12:
        if (r12 >= r11) goto L17;
        if (this.buffer[this.pos + r12] != r10.charAt(r12)) goto L15;
        r12 = r12 + 1;
        goto L12
    L17:
        return true;
    L6:
        if (fillBuffer(r11) == true) goto L9;
        return false;
    }

    private void skipToEndOfLine() throws IOException {
    L3:
        if (this.pos >= this.limit) goto L5;
    L6:
        char[] r10 = this.buffer;
        int r11 = this.pos;
        int r12 = r11 + 1;
        this.pos = r12;
        char r13 = r10[r11];
        if (r13 == '\n') goto L8;
        if (r13 != '\r') goto L3;
        return;
    L8:
        this.lineNumber++;
        this.lineStart = r12;
        return;
    L5:
        if (fillBuffer(1) == true) goto L6;
    }

    private void skipUnquotedValue() throws IOException {
    L2:
        int r10 = 0;
    L3:
        int r11 = this.pos;
        if ((r11 + r10) >= this.limit) goto L36;
        char r12 = this.buffer[r11 + r10];
        if (r12 == '\t') goto L34;
        if (r12 == '\n') goto L34;
        if (r12 == '\f') goto L34;
        if (r12 == '\r') goto L34;
        if (r12 == ' ') goto L34;
        if (r12 == '#') goto L33;
        if (r12 == ',') goto L34;
        if (r12 == '/') goto L33;
        if (r12 == '=') goto L33;
        if (r12 == '{') goto L34;
        if (r12 == '}') goto L34;
        if (r12 == ':') goto L34;
        if (r12 == ';') goto L33;
        switch(r12) {
            case 91: goto L34;
            case 92: goto L33;
            case 93: goto L34;
            default: goto L32;
        };
    L32:
        r10 = r10 + 1;
    L33:
        checkLenient();
    L34:
        this.pos += r10;
        return;
    L36:
        this.pos = r11 + r10;
        if (fillBuffer(1) == true) goto L2;
    }

    private IOException syntaxError(String r10) throws IOException {
        throw new MalformedJsonException(r10 + locationString());
    }

    public void beginArray() throws IOException {
        int r10 = this.peeked;
        if (r10 != 0) goto L6;
        r10 = doPeek();
    L6:
        if (r10 != 3) goto L10;
        push(1);
        this.pathIndices[this.stackSize - 1] = 0;
        this.peeked = 0;
        return;
    L10:
        throw new IllegalStateException("Expected BEGIN_ARRAY but was " + peek() + locationString());
    }

    public void beginObject() throws IOException {
        int r10 = this.peeked;
        if (r10 != 0) goto L6;
        r10 = doPeek();
    L6:
        if (r10 != 1) goto L10;
        push(3);
        this.peeked = 0;
        return;
    L10:
        throw new IllegalStateException("Expected BEGIN_OBJECT but was " + peek() + locationString());
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.peeked = 0;
        this.stack[0] = 8;
        this.stackSize = 1;
        this.in.close();
    }

    public int doPeek() throws IOException {
        int[] r10 = this.stack;
        int r11 = this.stackSize;
        int r12 = r10[r11 - 1];
        if (r12 != 1) goto L5;
        r10[r11 - 1] = 2;
    L46:
        int r13 = nextNonWhitespace(true);
        if (r13 == 34) goto L84;
        if (r13 == 39) goto L82;
        if (r13 == 44) goto L75;
        if (r13 == 59) goto L75;
        if (r13 == 91) goto L73;
        if (r13 != 93) goto L55;
        if (r12 != 1) goto L75;
        this.peeked = 4;
        return 4;
    L55:
        if (r13 == 123) goto L68;
        this.pos--;
        int r14 = peekKeyword();
        if (r14 == 0) goto L59;
        return r14;
    L59:
        int r15 = peekNumber();
        if (r15 == 0) goto L63;
        return r15;
    L63:
        if (isLiteral(this.buffer[this.pos]) == false) goto L67;
        checkLenient();
        this.peeked = 10;
        return 10;
    L67:
        throw syntaxError("Expected value");
    L68:
        this.peeked = 1;
        return 1;
    L73:
        this.peeked = 3;
        return 3;
    L75:
        if (r12 == 1) goto L80;
        if (r12 == 2) goto L80;
        throw syntaxError("Unexpected value");
    L80:
        checkLenient();
        this.pos--;
        this.peeked = 7;
        return 7;
    L82:
        checkLenient();
        this.peeked = 8;
        return 8;
    L84:
        this.peeked = 9;
        return 9;
    L5:
        if (r12 != 2) goto L16;
        int r16 = nextNonWhitespace(true);
        if (r16 == 44) goto L46;
        if (r16 == 59) goto L14;
        if (r16 != 93) goto L13;
        this.peeked = 4;
        return 4;
    L13:
        throw syntaxError("Unterminated array");
    L14:
        checkLenient();
        goto L46
    L16:
        if (r12 == 3) goto L88;
        if (r12 == 5) goto L88;
        if (r12 != 4) goto L34;
        r10[r11 - 1] = 5;
        int r17 = nextNonWhitespace(true);
        if (r17 == 58) goto L46;
        if (r17 != 61) goto L32;
        checkLenient();
        if (this.pos >= this.limit) goto L27;
    L28:
        char[] r18 = this.buffer;
        int r19 = this.pos;
        if (r18[r19] != '>') goto L46;
        this.pos = r19 + 1;
        goto L46
    L27:
        if (fillBuffer(1) == false) goto L46;
    L32:
        throw syntaxError("Expected ':'");
    L34:
        if (r12 == 6) goto L36;
        if (r12 == 7) goto L41;
        if (r12 != 8) goto L46;
        throw new IllegalStateException("JsonReader is closed");
    L41:
        if (nextNonWhitespace(false) != (-1)) goto L44;
        this.peeked = 17;
        return 17;
    L44:
        checkLenient();
        this.pos--;
        goto L46
    L36:
        if (this.lenient == false) goto L38;
        consumeNonExecutePrefix();
    L38:
        this.stack[this.stackSize - 1] = 7;
    L88:
        r10[r11 - 1] = 4;
        if (r12 != 5) goto L99;
        int r20 = nextNonWhitespace(true);
        if (r20 == 44) goto L99;
        if (r20 == 59) goto L98;
        if (r20 != 125) goto L97;
        this.peeked = 2;
        return 2;
    L97:
        throw syntaxError("Unterminated object");
    L98:
        checkLenient();
    L99:
        int r21 = nextNonWhitespace(true);
        if (r21 == 34) goto L117;
        if (r21 != 39) goto L103;
        checkLenient();
        this.peeked = 12;
        return 12;
    L103:
        if (r21 == 125) goto L110;
        checkLenient();
        this.pos--;
        if (isLiteral((char) r21) == false) goto L109;
        this.peeked = 14;
        return 14;
    L109:
        throw syntaxError("Expected name");
    L110:
        if (r12 == 5) goto L114;
        this.peeked = 2;
        return 2;
    L114:
        throw syntaxError("Expected name");
    L117:
        this.peeked = 13;
        return 13;
    }

    public void endArray() throws IOException {
        int r10 = this.peeked;
        if (r10 != 0) goto L6;
        r10 = doPeek();
    L6:
        if (r10 != 4) goto L10;
        int r11 = this.stackSize;
        this.stackSize = r11 - 1;
        int[] r12 = this.pathIndices;
        int r13 = r11 - 2;
        r12[r13] = r12[r13] + 1;
        this.peeked = 0;
        return;
    L10:
        throw new IllegalStateException("Expected END_ARRAY but was " + peek() + locationString());
    }

    public void endObject() throws IOException {
        int r10 = this.peeked;
        if (r10 != 0) goto L6;
        r10 = doPeek();
    L6:
        if (r10 != 2) goto L10;
        int r11 = this.stackSize;
        int r12 = r11 - 1;
        this.stackSize = r12;
        this.pathNames[r12] = null;
        int[] r13 = this.pathIndices;
        int r14 = r11 - 2;
        r13[r14] = r13[r14] + 1;
        this.peeked = 0;
        return;
    L10:
        throw new IllegalStateException("Expected END_OBJECT but was " + peek() + locationString());
    }

    public String getPath() {
        StringBuilder r10 = new StringBuilder();
        r10.append('$');
        int r11 = this.stackSize;
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L21;
        int r13 = this.stack[r12];
        if (r13 != 1) goto L7;
    L18:
        r10.append('[');
        r10.append(this.pathIndices[r12]);
        r10.append(']');
    L19:
        r12 = r12 + 1;
        goto L3
    L7:
        if (r13 == 2) goto L18;
        if (r13 != 3) goto L11;
    L15:
        r10.append('.');
        String r14 = this.pathNames[r12];
        if (r14 == null) goto L19;
        r10.append(r14);
        goto L19
    L11:
        if (r13 == 4) goto L15;
        if (r13 == 5) goto L15;
    L21:
        return r10.toString();
    }

    public boolean hasNext() throws IOException {
        int r10 = this.peeked;
        if (r10 != 0) goto L6;
        r10 = doPeek();
    L6:
        if (r10 != 2) goto L8;
    L10:
        return false;
    L8:
        if (r10 == 4) goto L10;
        return true;
    }

    public final boolean isLenient() {
        return this.lenient;
    }

    public String locationString() {
        return " at line " + (this.lineNumber + 1) + " column " + ((this.pos - this.lineStart) + 1) + " path " + getPath();
    }

    public boolean nextBoolean() throws IOException {
        int r10 = this.peeked;
        if (r10 != 0) goto L6;
        r10 = doPeek();
    L6:
        if (r10 != 5) goto L10;
        this.peeked = 0;
        int[] r11 = this.pathIndices;
        int r12 = this.stackSize - 1;
        r11[r12] = r11[r12] + 1;
        return true;
    L10:
        if (r10 != 6) goto L14;
        this.peeked = 0;
        int[] r13 = this.pathIndices;
        int r14 = this.stackSize - 1;
        r13[r14] = r13[r14] + 1;
        return false;
    L14:
        throw new IllegalStateException("Expected a boolean but was " + peek() + locationString());
    }

    public double nextDouble() throws IOException {
        int r10 = this.peeked;
        if (r10 != 0) goto L6;
        r10 = doPeek();
    L6:
        if (r10 != 15) goto L10;
        this.peeked = 0;
        int[] r11 = this.pathIndices;
        int r12 = this.stackSize - 1;
        r11[r12] = r11[r12] + 1;
        return this.peekedLong;
    L10:
        if (r10 != 16) goto L13;
        this.peekedString = new String(this.buffer, this.pos, this.peekedNumberLength);
        this.pos += this.peekedNumberLength;
    L28:
        this.peeked = 11;
        double r13 = Double.parseDouble(this.peekedString);
        if (this.lenient == false) goto L31;
    L37:
        this.peekedString = null;
        this.peeked = 0;
        int[] r14 = this.pathIndices;
        int r15 = this.stackSize - 1;
        r14[r15] = r14[r15] + 1;
        return r13;
    L31:
        if (Double.isNaN(r13) == true) goto L36;
        if (Double.isInfinite(r13) == false) goto L37;
    L36:
        throw new MalformedJsonException("JSON forbids NaN and infinities: " + r13 + locationString());
    L13:
        if (r10 != 8) goto L15;
    L24:
        if (r10 != 8) goto L26;
        char r16 = '\'';
    L27:
        this.peekedString = nextQuotedValue(r16);
        goto L28
    L26:
        r16 = TokenParser.DQUOTE;
        goto L27
    L15:
        if (r10 == 9) goto L24;
        if (r10 != 10) goto L20;
        this.peekedString = nextUnquotedValue();
        goto L28
    L20:
        if (r10 == 11) goto L28;
        throw new IllegalStateException("Expected a double but was " + peek() + locationString());
    }

    public int nextInt() throws IOException {
        int r10 = this.peeked;
        if (r10 != 0) goto L6;
        r10 = doPeek();
    L6:
        if (r10 != 15) goto L14;
        long r11 = this.peekedLong;
        int r12 = (int) r11;
        if (r11 != r12) goto L12;
        this.peeked = 0;
        int[] r13 = this.pathIndices;
        int r14 = this.stackSize - 1;
        r13[r14] = r13[r14] + 1;
        return r12;
    L12:
        throw new NumberFormatException("Expected an int but was " + this.peekedLong + locationString());
    L14:
        if (r10 != 16) goto L17;
        this.peekedString = new String(this.buffer, this.pos, this.peekedNumberLength);
        this.pos += this.peekedNumberLength;
    L32:
        this.peeked = 11;
        double r15 = Double.parseDouble(this.peekedString);
        int r16 = (int) r15;
        if (r16 != r15) goto L37;
        this.peekedString = null;
        this.peeked = 0;
        int[] r17 = this.pathIndices;
        int r18 = this.stackSize - 1;
        r17[r18] = r17[r18] + 1;
        return r16;
    L37:
        throw new NumberFormatException("Expected an int but was " + this.peekedString + locationString());
    L17:
        if (r10 != 8) goto L19;
    L24:
        if (r10 != 10) goto L26;
        this.peekedString = nextUnquotedValue();
    L39:
        int r19 = Integer.parseInt(this.peekedString);     // Catch: NumberFormatException -> L38
        this.peeked = 0;     // Catch: NumberFormatException -> L38
        int[] r20 = this.pathIndices;     // Catch: NumberFormatException -> L38
        int r21 = this.stackSize - 1;     // Catch: NumberFormatException -> L38
        r20[r21] = r20[r21] + 1;     // Catch: NumberFormatException -> L38
        return r19;
    L26:
        if (r10 != 8) goto L28;
        char r22 = '\'';
    L29:
        this.peekedString = nextQuotedValue(r22);
        goto L39
    L28:
        r22 = TokenParser.DQUOTE;
        goto L29
    L19:
        if (r10 == 9) goto L24;
        if (r10 == 10) goto L24;
        throw new IllegalStateException("Expected an int but was " + peek() + locationString());
    }

    public long nextLong() throws IOException {
        int r10 = this.peeked;
        if (r10 != 0) goto L6;
        r10 = doPeek();
    L6:
        if (r10 != 15) goto L10;
        this.peeked = 0;
        int[] r11 = this.pathIndices;
        int r12 = this.stackSize - 1;
        r11[r12] = r11[r12] + 1;
        return this.peekedLong;
    L10:
        if (r10 != 16) goto L13;
        this.peekedString = new String(this.buffer, this.pos, this.peekedNumberLength);
        this.pos += this.peekedNumberLength;
    L28:
        this.peeked = 11;
        double r13 = Double.parseDouble(this.peekedString);
        long r14 = (long) r13;
        if (r14 != r13) goto L33;
        this.peekedString = null;
        this.peeked = 0;
        int[] r15 = this.pathIndices;
        int r16 = this.stackSize - 1;
        r15[r16] = r15[r16] + 1;
        return r14;
    L33:
        throw new NumberFormatException("Expected a long but was " + this.peekedString + locationString());
    L13:
        if (r10 != 8) goto L15;
    L20:
        if (r10 != 10) goto L22;
        this.peekedString = nextUnquotedValue();
    L35:
        long r17 = Long.parseLong(this.peekedString);     // Catch: NumberFormatException -> L34
        this.peeked = 0;     // Catch: NumberFormatException -> L34
        int[] r18 = this.pathIndices;     // Catch: NumberFormatException -> L34
        int r19 = this.stackSize - 1;     // Catch: NumberFormatException -> L34
        r18[r19] = r18[r19] + 1;     // Catch: NumberFormatException -> L34
        return r17;
    L22:
        if (r10 != 8) goto L24;
        char r20 = '\'';
    L25:
        this.peekedString = nextQuotedValue(r20);
        goto L35
    L24:
        r20 = TokenParser.DQUOTE;
        goto L25
    L15:
        if (r10 == 9) goto L20;
        if (r10 == 10) goto L20;
        throw new IllegalStateException("Expected a long but was " + peek() + locationString());
    }

    public String nextName() throws IOException {
        int r10 = this.peeked;
        if (r10 != 0) goto L6;
        r10 = doPeek();
    L6:
        if (r10 != 14) goto L9;
        String r11 = nextUnquotedValue();
    L14:
        this.peeked = 0;
        this.pathNames[this.stackSize - 1] = r11;
        return r11;
    L9:
        if (r10 != 12) goto L12;
        r11 = nextQuotedValue('\'');
        goto L14
    L12:
        if (r10 != 13) goto L17;
        r11 = nextQuotedValue(TokenParser.DQUOTE);
        goto L14
    L17:
        throw new IllegalStateException("Expected a name but was " + peek() + locationString());
    }

    public void nextNull() throws IOException {
        int r10 = this.peeked;
        if (r10 != 0) goto L6;
        r10 = doPeek();
    L6:
        if (r10 != 7) goto L10;
        this.peeked = 0;
        int[] r11 = this.pathIndices;
        int r12 = this.stackSize - 1;
        r11[r12] = r11[r12] + 1;
        return;
    L10:
        throw new IllegalStateException("Expected null but was " + peek() + locationString());
    }

    public String nextString() throws IOException {
        int r10 = this.peeked;
        if (r10 != 0) goto L6;
        r10 = doPeek();
    L6:
        if (r10 != 10) goto L9;
        String r11 = nextUnquotedValue();
    L23:
        this.peeked = 0;
        int[] r12 = this.pathIndices;
        int r13 = this.stackSize - 1;
        r12[r13] = r12[r13] + 1;
        return r11;
    L9:
        if (r10 != 8) goto L12;
        r11 = nextQuotedValue('\'');
        goto L23
    L12:
        if (r10 != 9) goto L15;
        r11 = nextQuotedValue(TokenParser.DQUOTE);
        goto L23
    L15:
        if (r10 != 11) goto L18;
        r11 = this.peekedString;
        this.peekedString = null;
        goto L23
    L18:
        if (r10 != 15) goto L21;
        r11 = Long.toString(this.peekedLong);
        goto L23
    L21:
        if (r10 != 16) goto L26;
        r11 = new String(this.buffer, this.pos, this.peekedNumberLength);
        this.pos += this.peekedNumberLength;
        goto L23
    L26:
        throw new IllegalStateException("Expected a string but was " + peek() + locationString());
    }

    public JsonToken peek() throws IOException {
        int r10 = this.peeked;
        if (r10 != 0) goto L5;
        r10 = doPeek();
    L5:
        switch(r10) {
            case 1: goto L27;
            case 2: goto L25;
            case 3: goto L23;
            case 4: goto L21;
            case 5: goto L19;
            case 6: goto L19;
            case 7: goto L17;
            case 8: goto L15;
            case 9: goto L15;
            case 10: goto L15;
            case 11: goto L15;
            case 12: goto L13;
            case 13: goto L13;
            case 14: goto L13;
            case 15: goto L11;
            case 16: goto L11;
            case 17: goto L9;
            default: goto L7;
        };
    L7:
        throw new AssertionError();
    L9:
        return JsonToken.END_DOCUMENT;
    L11:
        return JsonToken.NUMBER;
    L13:
        return JsonToken.NAME;
    L15:
        return JsonToken.STRING;
    L17:
        return JsonToken.NULL;
    L19:
        return JsonToken.BOOLEAN;
    L21:
        return JsonToken.END_ARRAY;
    L23:
        return JsonToken.BEGIN_ARRAY;
    L25:
        return JsonToken.END_OBJECT;
    L27:
        return JsonToken.BEGIN_OBJECT;
    }

    public final void setLenient(boolean r10) {
        this.lenient = r10;
    }

    public void skipValue() throws IOException {
        int r10 = 0;
    L3:
        int r11 = this.peeked;
        if (r11 != 0) goto L7;
        r11 = doPeek();
    L7:
        if (r11 != 3) goto L10;
        push(1);
    L9:
        r10 = r10 + 1;
    L40:
        this.peeked = 0;
        if (r10 != 0) goto L3;
        int[] r12 = this.pathIndices;
        int r13 = this.stackSize;
        int r14 = r13 - 1;
        r12[r14] = r12[r14] + 1;
        this.pathNames[r13 - 1] = "null";
        return;
    L10:
        if (r11 != 1) goto L13;
        push(3);
        goto L9
    L13:
        if (r11 != 4) goto L17;
        this.stackSize--;
    L15:
        r10 = r10 - 1;
        goto L40
    L17:
        if (r11 != 2) goto L20;
        this.stackSize--;
        goto L15
    L20:
        if (r11 != 14) goto L22;
    L39:
        skipUnquotedValue();
        goto L40
    L22:
        if (r11 == 10) goto L39;
        if (r11 != 8) goto L27;
    L38:
        skipQuotedValue('\'');
        goto L40
    L27:
        if (r11 == 12) goto L38;
        if (r11 != 9) goto L32;
    L37:
        skipQuotedValue(TokenParser.DQUOTE);
        goto L40
    L32:
        if (r11 == 13) goto L37;
        if (r11 != 16) goto L40;
        this.pos += this.peekedNumberLength;
        goto L40
    }

    public String toString() {
        return getClass().getSimpleName() + locationString();
    }
}
