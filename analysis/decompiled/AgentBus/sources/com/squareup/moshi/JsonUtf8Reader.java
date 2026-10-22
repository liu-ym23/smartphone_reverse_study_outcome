package com.squareup.moshi;

import com.squareup.moshi.JsonReader;
import ga.a;
import h4.n;
import java.io.EOFException;
import java.io.IOException;
import java.math.BigDecimal;
import javax.annotation.Nullable;
import ob.e0;
import ob.h;
import ob.j;
import ob.k;

/* loaded from: classes.dex */
final class JsonUtf8Reader extends JsonReader {
    private static final k CLOSING_BLOCK_COMMENT;
    private static final k DOUBLE_QUOTE_OR_SLASH;
    private static final k LINEFEED_OR_CARRIAGE_RETURN;
    private static final long MIN_INCOMPLETE_INTEGER = -922337203685477580L;
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
    private static final int PEEKED_BUFFERED_NAME = 15;
    private static final int PEEKED_DOUBLE_QUOTED = 9;
    private static final int PEEKED_DOUBLE_QUOTED_NAME = 13;
    private static final int PEEKED_END_ARRAY = 4;
    private static final int PEEKED_END_OBJECT = 2;
    private static final int PEEKED_EOF = 18;
    private static final int PEEKED_FALSE = 6;
    private static final int PEEKED_LONG = 16;
    private static final int PEEKED_NONE = 0;
    private static final int PEEKED_NULL = 7;
    private static final int PEEKED_NUMBER = 17;
    private static final int PEEKED_SINGLE_QUOTED = 8;
    private static final int PEEKED_SINGLE_QUOTED_NAME = 12;
    private static final int PEEKED_TRUE = 5;
    private static final int PEEKED_UNQUOTED = 10;
    private static final int PEEKED_UNQUOTED_NAME = 14;
    private static final k SINGLE_QUOTE_OR_SLASH;
    private static final k UNQUOTED_STRING_TERMINALS;
    private final h buffer;
    private int peeked;
    private long peekedLong;
    private int peekedNumberLength;

    @Nullable
    private String peekedString;
    private final j source;

    @Nullable
    private JsonValueSource valueSource;

    static {
        k kVar = k.f7997i;
        SINGLE_QUOTE_OR_SLASH = n.j("'\\");
        DOUBLE_QUOTE_OR_SLASH = n.j("\"\\");
        UNQUOTED_STRING_TERMINALS = n.j("{}[]:, \n\t\r\f/\\;#=");
        LINEFEED_OR_CARRIAGE_RETURN = n.j("\n\r");
        CLOSING_BLOCK_COMMENT = n.j("*/");
    }

    public JsonUtf8Reader(j jVar) {
        this.peeked = 0;
        if (jVar == null) {
            throw new NullPointerException("source == null");
        }
        this.source = jVar;
        this.buffer = jVar.c();
        pushScope(6);
    }

    private void checkLenient() throws JsonEncodingException {
        if (!this.lenient) {
            throw syntaxError("Use JsonReader.setLenient(true) to accept malformed JSON");
        }
    }

    private int doPeek() throws EOFException, JsonEncodingException {
        int[] iArr = this.scopes;
        int i2 = this.stackSize;
        int i10 = iArr[i2 - 1];
        if (i10 == 1) {
            iArr[i2 - 1] = 2;
        } else if (i10 == 2) {
            int iNextNonWhitespace = nextNonWhitespace(true);
            this.buffer.readByte();
            if (iNextNonWhitespace != 44) {
                if (iNextNonWhitespace != 59) {
                    if (iNextNonWhitespace != 93) {
                        throw syntaxError("Unterminated array");
                    }
                    this.peeked = 4;
                    return 4;
                }
                checkLenient();
            }
        } else {
            if (i10 == 3 || i10 == 5) {
                iArr[i2 - 1] = 4;
                if (i10 == 5) {
                    int iNextNonWhitespace2 = nextNonWhitespace(true);
                    this.buffer.readByte();
                    if (iNextNonWhitespace2 != 44) {
                        if (iNextNonWhitespace2 != 59) {
                            if (iNextNonWhitespace2 != 125) {
                                throw syntaxError("Unterminated object");
                            }
                            this.peeked = 2;
                            return 2;
                        }
                        checkLenient();
                    }
                }
                int iNextNonWhitespace3 = nextNonWhitespace(true);
                if (iNextNonWhitespace3 == 34) {
                    this.buffer.readByte();
                    this.peeked = PEEKED_DOUBLE_QUOTED_NAME;
                    return PEEKED_DOUBLE_QUOTED_NAME;
                }
                if (iNextNonWhitespace3 == 39) {
                    this.buffer.readByte();
                    checkLenient();
                    this.peeked = 12;
                    return 12;
                }
                if (iNextNonWhitespace3 != 125) {
                    checkLenient();
                    if (!isLiteral((char) iNextNonWhitespace3)) {
                        throw syntaxError("Expected name");
                    }
                    this.peeked = 14;
                    return 14;
                }
                if (i10 == 5) {
                    throw syntaxError("Expected name");
                }
                this.buffer.readByte();
                this.peeked = 2;
                return 2;
            }
            if (i10 == 4) {
                iArr[i2 - 1] = 5;
                int iNextNonWhitespace4 = nextNonWhitespace(true);
                this.buffer.readByte();
                if (iNextNonWhitespace4 != 58) {
                    if (iNextNonWhitespace4 != 61) {
                        throw syntaxError("Expected ':'");
                    }
                    checkLenient();
                    if (this.source.p(1L) && this.buffer.g(0L) == 62) {
                        this.buffer.readByte();
                    }
                }
            } else if (i10 == 6) {
                iArr[i2 - 1] = 7;
            } else if (i10 == 7) {
                if (nextNonWhitespace(false) == -1) {
                    this.peeked = 18;
                    return 18;
                }
                checkLenient();
            } else {
                if (i10 == 9) {
                    this.valueSource.discard();
                    this.valueSource = null;
                    this.stackSize--;
                    return doPeek();
                }
                if (i10 == 8) {
                    throw new IllegalStateException("JsonReader is closed");
                }
            }
        }
        int iNextNonWhitespace5 = nextNonWhitespace(true);
        if (iNextNonWhitespace5 == 34) {
            this.buffer.readByte();
            this.peeked = 9;
            return 9;
        }
        if (iNextNonWhitespace5 == 39) {
            checkLenient();
            this.buffer.readByte();
            this.peeked = 8;
            return 8;
        }
        if (iNextNonWhitespace5 != 44 && iNextNonWhitespace5 != 59) {
            if (iNextNonWhitespace5 == 91) {
                this.buffer.readByte();
                this.peeked = 3;
                return 3;
            }
            if (iNextNonWhitespace5 != 93) {
                if (iNextNonWhitespace5 == 123) {
                    this.buffer.readByte();
                    this.peeked = 1;
                    return 1;
                }
                int iPeekKeyword = peekKeyword();
                if (iPeekKeyword != 0) {
                    return iPeekKeyword;
                }
                int iPeekNumber = peekNumber();
                if (iPeekNumber != 0) {
                    return iPeekNumber;
                }
                if (!isLiteral(this.buffer.g(0L))) {
                    throw syntaxError("Expected value");
                }
                checkLenient();
                this.peeked = 10;
                return 10;
            }
            if (i10 == 1) {
                this.buffer.readByte();
                this.peeked = 4;
                return 4;
            }
        }
        if (i10 != 1 && i10 != 2) {
            throw syntaxError("Unexpected value");
        }
        checkLenient();
        this.peeked = 7;
        return 7;
    }

    private int findName(String str, JsonReader.Options options) {
        int length = options.strings.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (str.equals(options.strings[i2])) {
                this.peeked = 0;
                this.pathNames[this.stackSize - 1] = str;
                return i2;
            }
        }
        return -1;
    }

    private int findString(String str, JsonReader.Options options) {
        int length = options.strings.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (str.equals(options.strings[i2])) {
                this.peeked = 0;
                int[] iArr = this.pathIndices;
                int i10 = this.stackSize - 1;
                iArr[i10] = iArr[i10] + 1;
                return i2;
            }
        }
        return -1;
    }

    private boolean isLiteral(int i2) throws JsonEncodingException {
        if (i2 == 9 || i2 == 10 || i2 == 12 || i2 == PEEKED_DOUBLE_QUOTED_NAME || i2 == 32) {
            return false;
        }
        if (i2 != 35) {
            if (i2 == 44) {
                return false;
            }
            if (i2 != 47 && i2 != 61) {
                if (i2 == 123 || i2 == 125 || i2 == 58) {
                    return false;
                }
                if (i2 != 59) {
                    switch (i2) {
                        case 91:
                        case 93:
                            return false;
                        case 92:
                            break;
                        default:
                            return true;
                    }
                }
            }
        }
        checkLenient();
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0025, code lost:
    
        r6.buffer.skip(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x002d, code lost:
    
        if (r2 != 47) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0037, code lost:
    
        if (r6.source.p(2) != false) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x003a, code lost:
    
        checkLenient();
        r3 = r6.buffer.g(1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0047, code lost:
    
        if (r3 == 42) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0049, code lost:
    
        if (r3 == 47) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x004c, code lost:
    
        r6.buffer.readByte();
        r6.buffer.readByte();
        skipToEndOfLine();
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x005a, code lost:
    
        r6.buffer.readByte();
        r6.buffer.readByte();
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0068, code lost:
    
        if (skipToEndOfBlockComment() == false) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0071, code lost:
    
        throw syntaxError("Unterminated comment");
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0074, code lost:
    
        if (r2 != 35) goto L48;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0076, code lost:
    
        checkLenient();
        skipToEndOfLine();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private int nextNonWhitespace(boolean r7) throws java.io.EOFException, com.squareup.moshi.JsonEncodingException {
        /*
            r6 = this;
            r0 = 0
        L1:
            r1 = r0
        L2:
            ob.j r2 = r6.source
            int r3 = r1 + 1
            long r4 = (long) r3
            boolean r2 = r2.p(r4)
            if (r2 == 0) goto L80
            ob.h r2 = r6.buffer
            long r4 = (long) r1
            byte r2 = r2.g(r4)
            r4 = 10
            if (r2 == r4) goto L7e
            r4 = 32
            if (r2 == r4) goto L7e
            r4 = 13
            if (r2 == r4) goto L7e
            r4 = 9
            if (r2 != r4) goto L25
            goto L7e
        L25:
            ob.h r3 = r6.buffer
            long r4 = (long) r1
            r3.skip(r4)
            r1 = 47
            if (r2 != r1) goto L72
            ob.j r3 = r6.source
            r4 = 2
            boolean r3 = r3.p(r4)
            if (r3 != 0) goto L3a
            goto L7d
        L3a:
            r6.checkLenient()
            ob.h r3 = r6.buffer
            r4 = 1
            byte r3 = r3.g(r4)
            r4 = 42
            if (r3 == r4) goto L5a
            if (r3 == r1) goto L4c
            goto L7d
        L4c:
            ob.h r1 = r6.buffer
            r1.readByte()
            ob.h r1 = r6.buffer
            r1.readByte()
            r6.skipToEndOfLine()
            goto L1
        L5a:
            ob.h r1 = r6.buffer
            r1.readByte()
            ob.h r1 = r6.buffer
            r1.readByte()
            boolean r1 = r6.skipToEndOfBlockComment()
            if (r1 == 0) goto L6b
            goto L1
        L6b:
            java.lang.String r7 = "Unterminated comment"
            com.squareup.moshi.JsonEncodingException r6 = r6.syntaxError(r7)
            throw r6
        L72:
            r1 = 35
            if (r2 != r1) goto L7d
            r6.checkLenient()
            r6.skipToEndOfLine()
            goto L1
        L7d:
            return r2
        L7e:
            r1 = r3
            goto L2
        L80:
            if (r7 != 0) goto L84
            r6 = -1
            return r6
        L84:
            java.io.EOFException r6 = new java.io.EOFException
            java.lang.String r7 = "End of input"
            r6.<init>(r7)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.squareup.moshi.JsonUtf8Reader.nextNonWhitespace(boolean):int");
    }

    private String nextQuotedValue(k kVar) throws EOFException, JsonEncodingException {
        StringBuilder sb2 = null;
        while (true) {
            long jY = this.source.y(kVar);
            if (jY == -1) {
                throw syntaxError("Unterminated string");
            }
            if (this.buffer.g(jY) != 92) {
                if (sb2 == null) {
                    h hVar = this.buffer;
                    hVar.getClass();
                    String strT = hVar.t(jY, a.f4005a);
                    this.buffer.readByte();
                    return strT;
                }
                h hVar2 = this.buffer;
                hVar2.getClass();
                sb2.append(hVar2.t(jY, a.f4005a));
                this.buffer.readByte();
                return sb2.toString();
            }
            if (sb2 == null) {
                sb2 = new StringBuilder();
            }
            h hVar3 = this.buffer;
            hVar3.getClass();
            sb2.append(hVar3.t(jY, a.f4005a));
            this.buffer.readByte();
            sb2.append(readEscapeCharacter());
        }
    }

    private String nextUnquotedValue() {
        long jY = this.source.y(UNQUOTED_STRING_TERMINALS);
        h hVar = this.buffer;
        if (jY == -1) {
            return hVar.z();
        }
        hVar.getClass();
        return hVar.t(jY, a.f4005a);
    }

    private int peekKeyword() throws EOFException {
        String str;
        String str2;
        int i2;
        byte bG = this.buffer.g(0L);
        if (bG == 116 || bG == 84) {
            str = "true";
            str2 = "TRUE";
            i2 = 5;
        } else if (bG == 102 || bG == 70) {
            str = "false";
            str2 = "FALSE";
            i2 = 6;
        } else {
            if (bG != 110 && bG != 78) {
                return 0;
            }
            str = "null";
            str2 = "NULL";
            i2 = 7;
        }
        int length = str.length();
        int i10 = 1;
        while (i10 < length) {
            int i11 = i10 + 1;
            if (!this.source.p(i11)) {
                return 0;
            }
            byte bG2 = this.buffer.g(i10);
            if (bG2 != str.charAt(i10) && bG2 != str2.charAt(i10)) {
                return 0;
            }
            i10 = i11;
        }
        if (this.source.p(length + 1) && isLiteral(this.buffer.g(length))) {
            return 0;
        }
        this.buffer.skip(length);
        this.peeked = i2;
        return i2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:44:0x0089, code lost:
    
        if (isLiteral(r1) != false) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x008b, code lost:
    
        if (r6 != 2) goto L58;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x008d, code lost:
    
        if (r7 == false) goto L58;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x0093, code lost:
    
        if (r8 != Long.MIN_VALUE) goto L50;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x0095, code lost:
    
        if (r10 == false) goto L58;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x0099, code lost:
    
        if (r8 != r16) goto L53;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x009b, code lost:
    
        if (r10 != false) goto L58;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x009d, code lost:
    
        if (r10 == false) goto L55;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x00a0, code lost:
    
        r8 = -r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x00a1, code lost:
    
        r19.peekedLong = r8;
        r19.buffer.skip(r5);
        r19.peeked = 16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x00ad, code lost:
    
        return 16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x00ae, code lost:
    
        if (r6 == 2) goto L64;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x00b0, code lost:
    
        if (r6 == 4) goto L64;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x00b3, code lost:
    
        if (r6 != 7) goto L63;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x00b6, code lost:
    
        return r18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x00b7, code lost:
    
        r19.peekedNumberLength = r5;
        r19.peeked = 17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x00bd, code lost:
    
        return 17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x00be, code lost:
    
        return 0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private int peekNumber() throws java.io.EOFException {
        /*
            Method dump skipped, instructions count: 221
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.squareup.moshi.JsonUtf8Reader.peekNumber():int");
    }

    private char readEscapeCharacter() throws EOFException, JsonEncodingException {
        int i2;
        if (!this.source.p(1L)) {
            throw syntaxError("Unterminated escape sequence");
        }
        byte b10 = this.buffer.readByte();
        if (b10 == 10 || b10 == 34 || b10 == 39 || b10 == 47 || b10 == 92) {
            return (char) b10;
        }
        if (b10 == 98) {
            return '\b';
        }
        if (b10 == 102) {
            return '\f';
        }
        if (b10 == 110) {
            return '\n';
        }
        if (b10 == 114) {
            return '\r';
        }
        if (b10 == 116) {
            return '\t';
        }
        if (b10 != 117) {
            if (this.lenient) {
                return (char) b10;
            }
            throw syntaxError("Invalid escape sequence: \\" + ((char) b10));
        }
        if (!this.source.p(4L)) {
            throw new EOFException("Unterminated escape sequence at path " + getPath());
        }
        char c10 = 0;
        for (int i10 = 0; i10 < 4; i10++) {
            byte bG = this.buffer.g(i10);
            char c11 = (char) (c10 << 4);
            if (bG >= 48 && bG <= 57) {
                i2 = bG - 48;
            } else if (bG >= 97 && bG <= 102) {
                i2 = bG - 87;
            } else {
                if (bG < 65 || bG > 70) {
                    h hVar = this.buffer;
                    hVar.getClass();
                    throw syntaxError("\\u".concat(hVar.t(4L, a.f4005a)));
                }
                i2 = bG - 55;
            }
            c10 = (char) (i2 + c11);
        }
        this.buffer.skip(4L);
        return c10;
    }

    private void skipQuotedValue(k kVar) throws EOFException, JsonEncodingException {
        while (true) {
            long jY = this.source.y(kVar);
            if (jY == -1) {
                throw syntaxError("Unterminated string");
            }
            if (this.buffer.g(jY) != 92) {
                this.buffer.skip(jY + 1);
                return;
            } else {
                this.buffer.skip(jY + 1);
                readEscapeCharacter();
            }
        }
    }

    private boolean skipToEndOfBlockComment() throws EOFException {
        long jD = this.source.D(CLOSING_BLOCK_COMMENT);
        boolean z4 = jD != -1;
        h hVar = this.buffer;
        hVar.skip(z4 ? jD + r1.d() : hVar.f7993g);
        return z4;
    }

    private void skipToEndOfLine() throws EOFException {
        long jY = this.source.y(LINEFEED_OR_CARRIAGE_RETURN);
        h hVar = this.buffer;
        hVar.skip(jY != -1 ? jY + 1 : hVar.f7993g);
    }

    private void skipUnquotedValue() throws EOFException {
        long jY = this.source.y(UNQUOTED_STRING_TERMINALS);
        h hVar = this.buffer;
        if (jY == -1) {
            jY = hVar.f7993g;
        }
        hVar.skip(jY);
    }

    @Override // com.squareup.moshi.JsonReader
    public void beginArray() throws EOFException, JsonEncodingException {
        int iDoPeek = this.peeked;
        if (iDoPeek == 0) {
            iDoPeek = doPeek();
        }
        if (iDoPeek == 3) {
            pushScope(1);
            this.pathIndices[this.stackSize - 1] = 0;
            this.peeked = 0;
        } else {
            throw new JsonDataException("Expected BEGIN_ARRAY but was " + peek() + " at path " + getPath());
        }
    }

    @Override // com.squareup.moshi.JsonReader
    public void beginObject() throws EOFException, JsonEncodingException {
        int iDoPeek = this.peeked;
        if (iDoPeek == 0) {
            iDoPeek = doPeek();
        }
        if (iDoPeek == 1) {
            pushScope(3);
            this.peeked = 0;
        } else {
            throw new JsonDataException("Expected BEGIN_OBJECT but was " + peek() + " at path " + getPath());
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.peeked = 0;
        this.scopes[0] = 8;
        this.stackSize = 1;
        this.buffer.a();
        this.source.close();
    }

    @Override // com.squareup.moshi.JsonReader
    public void endArray() throws EOFException, JsonEncodingException {
        int iDoPeek = this.peeked;
        if (iDoPeek == 0) {
            iDoPeek = doPeek();
        }
        if (iDoPeek != 4) {
            throw new JsonDataException("Expected END_ARRAY but was " + peek() + " at path " + getPath());
        }
        int i2 = this.stackSize;
        this.stackSize = i2 - 1;
        int[] iArr = this.pathIndices;
        int i10 = i2 - 2;
        iArr[i10] = iArr[i10] + 1;
        this.peeked = 0;
    }

    @Override // com.squareup.moshi.JsonReader
    public void endObject() throws EOFException, JsonEncodingException {
        int iDoPeek = this.peeked;
        if (iDoPeek == 0) {
            iDoPeek = doPeek();
        }
        if (iDoPeek != 2) {
            throw new JsonDataException("Expected END_OBJECT but was " + peek() + " at path " + getPath());
        }
        int i2 = this.stackSize;
        int i10 = i2 - 1;
        this.stackSize = i10;
        this.pathNames[i10] = null;
        int[] iArr = this.pathIndices;
        int i11 = i2 - 2;
        iArr[i11] = iArr[i11] + 1;
        this.peeked = 0;
    }

    @Override // com.squareup.moshi.JsonReader
    public boolean hasNext() throws EOFException, JsonEncodingException {
        int iDoPeek = this.peeked;
        if (iDoPeek == 0) {
            iDoPeek = doPeek();
        }
        return (iDoPeek == 2 || iDoPeek == 4 || iDoPeek == 18) ? false : true;
    }

    @Override // com.squareup.moshi.JsonReader
    public boolean nextBoolean() throws EOFException, JsonEncodingException {
        int iDoPeek = this.peeked;
        if (iDoPeek == 0) {
            iDoPeek = doPeek();
        }
        if (iDoPeek == 5) {
            this.peeked = 0;
            int[] iArr = this.pathIndices;
            int i2 = this.stackSize - 1;
            iArr[i2] = iArr[i2] + 1;
            return true;
        }
        if (iDoPeek == 6) {
            this.peeked = 0;
            int[] iArr2 = this.pathIndices;
            int i10 = this.stackSize - 1;
            iArr2[i10] = iArr2[i10] + 1;
            return false;
        }
        throw new JsonDataException("Expected a boolean but was " + peek() + " at path " + getPath());
    }

    @Override // com.squareup.moshi.JsonReader
    public double nextDouble() throws NumberFormatException, EOFException, JsonEncodingException {
        int iDoPeek = this.peeked;
        if (iDoPeek == 0) {
            iDoPeek = doPeek();
        }
        if (iDoPeek == 16) {
            this.peeked = 0;
            int[] iArr = this.pathIndices;
            int i2 = this.stackSize - 1;
            iArr[i2] = iArr[i2] + 1;
            return this.peekedLong;
        }
        if (iDoPeek == 17) {
            h hVar = this.buffer;
            long j2 = this.peekedNumberLength;
            hVar.getClass();
            this.peekedString = hVar.t(j2, a.f4005a);
        } else if (iDoPeek == 9) {
            this.peekedString = nextQuotedValue(DOUBLE_QUOTE_OR_SLASH);
        } else if (iDoPeek == 8) {
            this.peekedString = nextQuotedValue(SINGLE_QUOTE_OR_SLASH);
        } else if (iDoPeek == 10) {
            this.peekedString = nextUnquotedValue();
        } else if (iDoPeek != 11) {
            throw new JsonDataException("Expected a double but was " + peek() + " at path " + getPath());
        }
        this.peeked = 11;
        try {
            double d6 = Double.parseDouble(this.peekedString);
            if (!this.lenient && (Double.isNaN(d6) || Double.isInfinite(d6))) {
                throw new JsonEncodingException("JSON forbids NaN and infinities: " + d6 + " at path " + getPath());
            }
            this.peekedString = null;
            this.peeked = 0;
            int[] iArr2 = this.pathIndices;
            int i10 = this.stackSize - 1;
            iArr2[i10] = iArr2[i10] + 1;
            return d6;
        } catch (NumberFormatException unused) {
            throw new JsonDataException("Expected a double but was " + this.peekedString + " at path " + getPath());
        }
    }

    @Override // com.squareup.moshi.JsonReader
    public int nextInt() throws NumberFormatException, EOFException, JsonEncodingException {
        int iDoPeek = this.peeked;
        if (iDoPeek == 0) {
            iDoPeek = doPeek();
        }
        if (iDoPeek == 16) {
            long j2 = this.peekedLong;
            int i2 = (int) j2;
            if (j2 == i2) {
                this.peeked = 0;
                int[] iArr = this.pathIndices;
                int i10 = this.stackSize - 1;
                iArr[i10] = iArr[i10] + 1;
                return i2;
            }
            throw new JsonDataException("Expected an int but was " + this.peekedLong + " at path " + getPath());
        }
        if (iDoPeek == 17) {
            h hVar = this.buffer;
            long j4 = this.peekedNumberLength;
            hVar.getClass();
            this.peekedString = hVar.t(j4, a.f4005a);
        } else if (iDoPeek == 9 || iDoPeek == 8) {
            String strNextQuotedValue = iDoPeek == 9 ? nextQuotedValue(DOUBLE_QUOTE_OR_SLASH) : nextQuotedValue(SINGLE_QUOTE_OR_SLASH);
            this.peekedString = strNextQuotedValue;
            try {
                int i11 = Integer.parseInt(strNextQuotedValue);
                this.peeked = 0;
                int[] iArr2 = this.pathIndices;
                int i12 = this.stackSize - 1;
                iArr2[i12] = iArr2[i12] + 1;
                return i11;
            } catch (NumberFormatException unused) {
            }
        } else if (iDoPeek != 11) {
            throw new JsonDataException("Expected an int but was " + peek() + " at path " + getPath());
        }
        this.peeked = 11;
        try {
            double d6 = Double.parseDouble(this.peekedString);
            int i13 = (int) d6;
            if (i13 != d6) {
                throw new JsonDataException("Expected an int but was " + this.peekedString + " at path " + getPath());
            }
            this.peekedString = null;
            this.peeked = 0;
            int[] iArr3 = this.pathIndices;
            int i14 = this.stackSize - 1;
            iArr3[i14] = iArr3[i14] + 1;
            return i13;
        } catch (NumberFormatException unused2) {
            throw new JsonDataException("Expected an int but was " + this.peekedString + " at path " + getPath());
        }
    }

    @Override // com.squareup.moshi.JsonReader
    public long nextLong() throws NumberFormatException, EOFException, JsonEncodingException {
        int iDoPeek = this.peeked;
        if (iDoPeek == 0) {
            iDoPeek = doPeek();
        }
        if (iDoPeek == 16) {
            this.peeked = 0;
            int[] iArr = this.pathIndices;
            int i2 = this.stackSize - 1;
            iArr[i2] = iArr[i2] + 1;
            return this.peekedLong;
        }
        if (iDoPeek == 17) {
            h hVar = this.buffer;
            long j2 = this.peekedNumberLength;
            hVar.getClass();
            this.peekedString = hVar.t(j2, a.f4005a);
        } else if (iDoPeek == 9 || iDoPeek == 8) {
            String strNextQuotedValue = iDoPeek == 9 ? nextQuotedValue(DOUBLE_QUOTE_OR_SLASH) : nextQuotedValue(SINGLE_QUOTE_OR_SLASH);
            this.peekedString = strNextQuotedValue;
            try {
                long j4 = Long.parseLong(strNextQuotedValue);
                this.peeked = 0;
                int[] iArr2 = this.pathIndices;
                int i10 = this.stackSize - 1;
                iArr2[i10] = iArr2[i10] + 1;
                return j4;
            } catch (NumberFormatException unused) {
            }
        } else if (iDoPeek != 11) {
            throw new JsonDataException("Expected a long but was " + peek() + " at path " + getPath());
        }
        this.peeked = 11;
        try {
            long jLongValueExact = new BigDecimal(this.peekedString).longValueExact();
            this.peekedString = null;
            this.peeked = 0;
            int[] iArr3 = this.pathIndices;
            int i11 = this.stackSize - 1;
            iArr3[i11] = iArr3[i11] + 1;
            return jLongValueExact;
        } catch (ArithmeticException | NumberFormatException unused2) {
            throw new JsonDataException("Expected a long but was " + this.peekedString + " at path " + getPath());
        }
    }

    @Override // com.squareup.moshi.JsonReader
    public String nextName() throws EOFException, JsonEncodingException {
        String strNextQuotedValue;
        int iDoPeek = this.peeked;
        if (iDoPeek == 0) {
            iDoPeek = doPeek();
        }
        if (iDoPeek == 14) {
            strNextQuotedValue = nextUnquotedValue();
        } else if (iDoPeek == PEEKED_DOUBLE_QUOTED_NAME) {
            strNextQuotedValue = nextQuotedValue(DOUBLE_QUOTE_OR_SLASH);
        } else if (iDoPeek == 12) {
            strNextQuotedValue = nextQuotedValue(SINGLE_QUOTE_OR_SLASH);
        } else {
            if (iDoPeek != 15) {
                throw new JsonDataException("Expected a name but was " + peek() + " at path " + getPath());
            }
            strNextQuotedValue = this.peekedString;
            this.peekedString = null;
        }
        this.peeked = 0;
        this.pathNames[this.stackSize - 1] = strNextQuotedValue;
        return strNextQuotedValue;
    }

    @Override // com.squareup.moshi.JsonReader
    @Nullable
    public <T> T nextNull() throws EOFException, JsonEncodingException {
        int iDoPeek = this.peeked;
        if (iDoPeek == 0) {
            iDoPeek = doPeek();
        }
        if (iDoPeek == 7) {
            this.peeked = 0;
            int[] iArr = this.pathIndices;
            int i2 = this.stackSize - 1;
            iArr[i2] = iArr[i2] + 1;
            return null;
        }
        throw new JsonDataException("Expected null but was " + peek() + " at path " + getPath());
    }

    /* JADX WARN: Removed duplicated region for block: B:50:0x00ba  */
    @Override // com.squareup.moshi.JsonReader
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public ob.j nextSource() throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 217
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.squareup.moshi.JsonUtf8Reader.nextSource():ob.j");
    }

    @Override // com.squareup.moshi.JsonReader
    public String nextString() throws EOFException, JsonEncodingException {
        String strT;
        int iDoPeek = this.peeked;
        if (iDoPeek == 0) {
            iDoPeek = doPeek();
        }
        if (iDoPeek == 10) {
            strT = nextUnquotedValue();
        } else if (iDoPeek == 9) {
            strT = nextQuotedValue(DOUBLE_QUOTE_OR_SLASH);
        } else if (iDoPeek == 8) {
            strT = nextQuotedValue(SINGLE_QUOTE_OR_SLASH);
        } else if (iDoPeek == 11) {
            strT = this.peekedString;
            this.peekedString = null;
        } else if (iDoPeek == 16) {
            strT = Long.toString(this.peekedLong);
        } else {
            if (iDoPeek != 17) {
                throw new JsonDataException("Expected a string but was " + peek() + " at path " + getPath());
            }
            h hVar = this.buffer;
            long j2 = this.peekedNumberLength;
            hVar.getClass();
            strT = hVar.t(j2, a.f4005a);
        }
        this.peeked = 0;
        int[] iArr = this.pathIndices;
        int i2 = this.stackSize - 1;
        iArr[i2] = iArr[i2] + 1;
        return strT;
    }

    @Override // com.squareup.moshi.JsonReader
    public JsonReader.Token peek() throws EOFException, JsonEncodingException {
        int iDoPeek = this.peeked;
        if (iDoPeek == 0) {
            iDoPeek = doPeek();
        }
        switch (iDoPeek) {
            case 1:
                return JsonReader.Token.BEGIN_OBJECT;
            case 2:
                return JsonReader.Token.END_OBJECT;
            case 3:
                return JsonReader.Token.BEGIN_ARRAY;
            case 4:
                return JsonReader.Token.END_ARRAY;
            case 5:
            case 6:
                return JsonReader.Token.BOOLEAN;
            case 7:
                return JsonReader.Token.NULL;
            case 8:
            case 9:
            case 10:
            case 11:
                return JsonReader.Token.STRING;
            case 12:
            case PEEKED_DOUBLE_QUOTED_NAME /* 13 */:
            case 14:
            case 15:
                return JsonReader.Token.NAME;
            case 16:
            case 17:
                return JsonReader.Token.NUMBER;
            case 18:
                return JsonReader.Token.END_DOCUMENT;
            default:
                throw new AssertionError();
        }
    }

    @Override // com.squareup.moshi.JsonReader
    public JsonReader peekJson() {
        return new JsonUtf8Reader(this);
    }

    @Override // com.squareup.moshi.JsonReader
    public void promoteNameToValue() {
        if (hasNext()) {
            this.peekedString = nextName();
            this.peeked = 11;
        }
    }

    @Override // com.squareup.moshi.JsonReader
    public int selectName(JsonReader.Options options) throws EOFException, JsonEncodingException {
        int iDoPeek = this.peeked;
        if (iDoPeek == 0) {
            iDoPeek = doPeek();
        }
        if (iDoPeek < 12 || iDoPeek > 15) {
            return -1;
        }
        if (iDoPeek == 15) {
            return findName(this.peekedString, options);
        }
        int iB = this.source.B(options.doubleQuoteSuffix);
        if (iB != -1) {
            this.peeked = 0;
            this.pathNames[this.stackSize - 1] = options.strings[iB];
            return iB;
        }
        String str = this.pathNames[this.stackSize - 1];
        String strNextName = nextName();
        int iFindName = findName(strNextName, options);
        if (iFindName == -1) {
            this.peeked = 15;
            this.peekedString = strNextName;
            this.pathNames[this.stackSize - 1] = str;
        }
        return iFindName;
    }

    @Override // com.squareup.moshi.JsonReader
    public int selectString(JsonReader.Options options) throws EOFException, JsonEncodingException {
        int iDoPeek = this.peeked;
        if (iDoPeek == 0) {
            iDoPeek = doPeek();
        }
        if (iDoPeek < 8 || iDoPeek > 11) {
            return -1;
        }
        if (iDoPeek == 11) {
            return findString(this.peekedString, options);
        }
        int iB = this.source.B(options.doubleQuoteSuffix);
        if (iB != -1) {
            this.peeked = 0;
            int[] iArr = this.pathIndices;
            int i2 = this.stackSize - 1;
            iArr[i2] = iArr[i2] + 1;
            return iB;
        }
        String strNextString = nextString();
        int iFindString = findString(strNextString, options);
        if (iFindString == -1) {
            this.peeked = 11;
            this.peekedString = strNextString;
            this.pathIndices[this.stackSize - 1] = r0[r4] - 1;
        }
        return iFindString;
    }

    @Override // com.squareup.moshi.JsonReader
    public void skipName() throws EOFException, JsonEncodingException {
        if (this.failOnUnknown) {
            JsonReader.Token tokenPeek = peek();
            nextName();
            throw new JsonDataException("Cannot skip unexpected " + tokenPeek + " at " + getPath());
        }
        int iDoPeek = this.peeked;
        if (iDoPeek == 0) {
            iDoPeek = doPeek();
        }
        if (iDoPeek == 14) {
            skipUnquotedValue();
        } else if (iDoPeek == PEEKED_DOUBLE_QUOTED_NAME) {
            skipQuotedValue(DOUBLE_QUOTE_OR_SLASH);
        } else if (iDoPeek == 12) {
            skipQuotedValue(SINGLE_QUOTE_OR_SLASH);
        } else if (iDoPeek != 15) {
            throw new JsonDataException("Expected a name but was " + peek() + " at path " + getPath());
        }
        this.peeked = 0;
        this.pathNames[this.stackSize - 1] = "null";
    }

    @Override // com.squareup.moshi.JsonReader
    public void skipValue() throws EOFException, JsonEncodingException {
        if (this.failOnUnknown) {
            throw new JsonDataException("Cannot skip unexpected " + peek() + " at " + getPath());
        }
        int i2 = 0;
        do {
            int iDoPeek = this.peeked;
            if (iDoPeek == 0) {
                iDoPeek = doPeek();
            }
            if (iDoPeek == 3) {
                pushScope(1);
            } else if (iDoPeek == 1) {
                pushScope(3);
            } else {
                if (iDoPeek == 4) {
                    i2--;
                    if (i2 < 0) {
                        throw new JsonDataException("Expected a value but was " + peek() + " at path " + getPath());
                    }
                    this.stackSize--;
                } else if (iDoPeek == 2) {
                    i2--;
                    if (i2 < 0) {
                        throw new JsonDataException("Expected a value but was " + peek() + " at path " + getPath());
                    }
                    this.stackSize--;
                } else if (iDoPeek == 14 || iDoPeek == 10) {
                    skipUnquotedValue();
                } else if (iDoPeek == 9 || iDoPeek == PEEKED_DOUBLE_QUOTED_NAME) {
                    skipQuotedValue(DOUBLE_QUOTE_OR_SLASH);
                } else if (iDoPeek == 8 || iDoPeek == 12) {
                    skipQuotedValue(SINGLE_QUOTE_OR_SLASH);
                } else if (iDoPeek == 17) {
                    this.buffer.skip(this.peekedNumberLength);
                } else if (iDoPeek == 18) {
                    throw new JsonDataException("Expected a value but was " + peek() + " at path " + getPath());
                }
                this.peeked = 0;
            }
            i2++;
            this.peeked = 0;
        } while (i2 != 0);
        int[] iArr = this.pathIndices;
        int i10 = this.stackSize;
        int i11 = i10 - 1;
        iArr[i11] = iArr[i11] + 1;
        this.pathNames[i10 - 1] = "null";
    }

    public String toString() {
        return "JsonReader(" + this.source + ")";
    }

    public JsonUtf8Reader(JsonUtf8Reader jsonUtf8Reader) {
        super(jsonUtf8Reader);
        this.peeked = 0;
        e0 e0VarPeek = jsonUtf8Reader.source.peek();
        this.source = e0VarPeek;
        this.buffer = e0VarPeek.f7965g;
        this.peeked = jsonUtf8Reader.peeked;
        this.peekedLong = jsonUtf8Reader.peekedLong;
        this.peekedNumberLength = jsonUtf8Reader.peekedNumberLength;
        this.peekedString = jsonUtf8Reader.peekedString;
        try {
            e0VarPeek.L(jsonUtf8Reader.buffer.f7993g);
        } catch (IOException unused) {
            throw new AssertionError();
        }
    }
}
