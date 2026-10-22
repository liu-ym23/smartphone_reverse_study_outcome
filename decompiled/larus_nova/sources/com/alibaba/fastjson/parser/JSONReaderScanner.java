package com.alibaba.fastjson.parser;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.util.IOUtils;
import com.obric.miniapp.alarm.AlarmSessionType;
import java.io.CharArrayReader;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.math.BigDecimal;
import java.math.MathContext;

/* JADX INFO: loaded from: classes28.dex */
public final class JSONReaderScanner extends JSONLexerBase {
    private static final ThreadLocal<char[]> BUF_LOCAL = null;
    private char[] buf;
    private int bufLength;
    private Reader reader;

    @Override // com.alibaba.fastjson.parser.JSONLexerBase, com.alibaba.fastjson.parser.JSONLexer
    public final boolean isBlankInput() {
        int r100 = 0;
    L3:
        char r101 = this.buf[r100];
        if (r101 == 26) goto L5;
        if (JSONLexerBase.isWhitespace(r101) == false) goto L9;
        r100 = r100 + 1;
        goto L3
    L9:
        return false;
    L5:
        this.token = 20;
        return true;
    }

    static {
        BUF_LOCAL = new ThreadLocal();
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase, com.alibaba.fastjson.parser.JSONLexer
    public byte[] bytesValue() {
        if (this.token == 26) goto L7;
        return IOUtils.decodeBase64(this.buf, this.f24935np + 1, this.f24936sp);
    L7:
        throw new JSONException(AlarmSessionType.TODO);
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase, com.alibaba.fastjson.parser.JSONLexer
    public final BigDecimal decimalValue() {
        int r100 = this.f24935np;
        if (r100 != (-1)) goto L5;
        r100 = 0;
    L5:
        char r101 = charAt((this.f24936sp + r100) - 1);
        int r102 = this.f24936sp;
        if (r101 != 'L') goto L8;
    L15:
        r102 = r102 - 1;
    L17:
        if (r102 > 65535) goto L21;
        return new BigDecimal(this.buf, r100, r102, MathContext.UNLIMITED);
    L21:
        throw new JSONException("decimal overflow");
    L8:
        if (r101 == 'S') goto L15;
        if (r101 == 'B') goto L15;
        if (r101 == 'F') goto L15;
        if (r101 != 'D') goto L17;
        goto L15
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public boolean isEOF() {
        if (this.bufLength == (-1)) goto L13;
        int r100 = this.f24933bp;
        char[] r101 = this.buf;
        if (r100 != r101.length) goto L7;
        return true;
    L7:
        if (this.f24934ch == 26) goto L9;
    L11:
        return false;
    L9:
        if ((r100 + 1) < r101.length) goto L11;
        return true;
    L13:
        return true;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase, com.alibaba.fastjson.parser.JSONLexer
    public final char next() {
        int r100 = this.f24933bp + 1;
        this.f24933bp = r100;
        int r101 = this.bufLength;
        if (r100 >= r101) goto L5;
    L29:
        char r102 = this.buf[r100];
        this.f24934ch = r102;
        return r102;
    L5:
        if (r101 != (-1)) goto L7;
        return JSONLexer.EOI;
    L7:
        int r103 = this.f24936sp;
        if (r103 <= 0) goto L14;
        int r104 = r101 - r103;
        if (this.f24934ch != '\"') goto L13;
        if (r104 <= 0) goto L13;
        r104 = r104 - 1;
    L13:
        char[] r105 = this.buf;
        System.arraycopy(r105, r104, r105, 0, r103);
    L14:
        this.f24935np = -1;
        int r106 = this.f24936sp;
        this.f24933bp = r106;
        char[] r107 = this.buf;     // Catch: IOException -> L26
        int r108 = r107.length - r106;     // Catch: IOException -> L26
        if (r108 != 0) goto L18;
        char[] r109 = new char[r107.length * 2];     // Catch: IOException -> L26
        System.arraycopy(r107, 0, r109, 0, r107.length);     // Catch: IOException -> L26
        this.buf = r109;     // Catch: IOException -> L26
        r108 = r109.length - r106;     // Catch: IOException -> L26
    L18:
        int r110 = this.reader.read(this.buf, this.f24933bp, r108);     // Catch: IOException -> L26
        this.bufLength = r110;     // Catch: IOException -> L26
        if (r110 == 0) goto L25;
        if (r110 != (-1)) goto L23;
        this.f24934ch = JSONLexer.EOI;
        return JSONLexer.EOI;
    L23:
        this.bufLength = r110 + this.f24933bp;
        r100 = r106;
        goto L29
    L25:
        throw new JSONException("illegal stat, textLength is zero");
    L26:
        e = move-exception;
        throw new JSONException(e.getMessage(), e);
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase, com.alibaba.fastjson.parser.JSONLexer
    public final String numberString() {
        int r100 = this.f24935np;
        if (r100 != (-1)) goto L5;
        r100 = 0;
    L5:
        char r101 = charAt((this.f24936sp + r100) - 1);
        int r102 = this.f24936sp;
        if (r101 != 'L') goto L8;
    L15:
        r102 = r102 - 1;
    L17:
        return new String(this.buf, r100, r102);
    L8:
        if (r101 == 'S') goto L15;
        if (r101 == 'B') goto L15;
        if (r101 == 'F') goto L15;
        if (r101 != 'D') goto L17;
        goto L15
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase, com.alibaba.fastjson.parser.JSONLexer
    public final String stringVal() {
        if (this.hasSpecial == true) goto L15;
        int r100 = this.f24935np + 1;
        if (r100 < 0) goto L13;
        char[] r101 = this.buf;
        int r102 = r101.length;
        int r103 = this.f24936sp;
        if (r100 > (r102 - r103)) goto L11;
        return new String(r101, r100, r103);
    L11:
        throw new IllegalStateException();
    L13:
        throw new IllegalStateException();
    L15:
        return new String(this.sbuf, 0, this.f24936sp);
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase, com.alibaba.fastjson.parser.JSONLexer, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        super.close();
        char[] r100 = this.buf;
        if (r100.length > 65536) goto L5;
        BUF_LOCAL.set(r100);
    L5:
        this.buf = null;
        IOUtils.close(this.reader);
    }

    public JSONReaderScanner(Reader r100) {
        this(r100, JSON.DEFAULT_PARSER_FEATURE);
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public final boolean charArrayCompare(char[] r100) {
        int r101 = 0;
    L4:
        if (r101 >= r100.length) goto L9;
        if (charAt(this.f24933bp + r101) != r100[r101]) goto L7;
        r101 = r101 + 1;
        goto L4
    L7:
        return false;
    L9:
        return true;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public final char charAt(int r100) {
        int r101 = this.bufLength;
        if (r100 < r101) goto L33;
        if (r101 == (-1)) goto L7;
        int r102 = this.f24933bp;
        if (r102 != 0) goto L19;
        char[] r103 = this.buf;
        int r104 = (r103.length * 3) / 2;
        char[] r105 = new char[r104];
        System.arraycopy(r103, r102, r105, 0, r101);
        int r106 = this.bufLength;
        this.bufLength += this.reader.read(r105, r106, r104 - r106);     // Catch: IOException -> L16
        this.buf = r105;     // Catch: IOException -> L16
    L16:
        e = move-exception;
        throw new JSONException(e.getMessage(), e);
    L19:
        int r107 = r101 - r102;
        if (r107 <= 0) goto L36;
        char[] r108 = this.buf;
        System.arraycopy(r108, r102, r108, 0, r107);
    L36:
        Reader r109 = this.reader;     // Catch: IOException -> L29
        char[] r110 = this.buf;     // Catch: IOException -> L29
        int r111 = r109.read(r110, r107, r110.length - r107);     // Catch: IOException -> L29
        this.bufLength = r111;     // Catch: IOException -> L29
        if (r111 == 0) goto L28;
        if (r111 != (-1)) goto L26;
        return JSONLexer.EOI;
    L26:
        this.bufLength = r111 + r107;
        int r112 = this.f24933bp;
        r100 = r100 - r112;
        this.f24935np -= r112;
        this.f24933bp = 0;
        goto L33
    L28:
        throw new JSONException("illegal state, textLength is zero");
    L29:
        e = move-exception;
        throw new JSONException(e.getMessage(), e);
    L7:
        if (r100 < this.f24936sp) goto L9;
        return JSONLexer.EOI;
    L9:
        return this.buf[r100];
    L33:
        return this.buf[r100];
    }

    public JSONReaderScanner(String r100) {
        this(r100, JSON.DEFAULT_PARSER_FEATURE);
    }

    public JSONReaderScanner(Reader r100, int r101) {
        super(r101);
        this.reader = r100;
        ThreadLocal<char[]> r102 = BUF_LOCAL;
        char[] r103 = r102.get();
        this.buf = r103;
        if (r103 == null) goto L6;
        r102.set(null);
    L6:
        if (this.buf != null) goto L16;
        this.buf = new char[16384];
    L16:
        this.bufLength = r100.read(this.buf);     // Catch: IOException -> L13
        this.f24933bp = -1;
        next();
        if (this.f24934ch != 65279) goto L18;
        next();
        return;
    L18:
        return;
    L13:
        e = move-exception;
        throw new JSONException(e.getMessage(), e);
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public final int indexOf(char r100, int r101) {
        int r102 = r101 - this.f24933bp;
    L3:
        char r103 = charAt(this.f24933bp + r102);
        if (r100 == r103) goto L6;
        if (r103 == 26) goto L9;
        r102 = r102 + 1;
        goto L3
    L9:
        return -1;
    L6:
        return r102 + this.f24933bp;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public final String subString(int r100, int r101) {
        if (r101 < 0) goto L6;
        return new String(this.buf, r100, r101);
    L6:
        throw new StringIndexOutOfBoundsException(r101);
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public final char[] sub_chars(int r100, int r101) {
        if (r101 < 0) goto L9;
        if (r100 == 0) goto L5;
        char[] r102 = new char[r101];
        System.arraycopy(this.buf, r100, r102, 0, r101);
        return r102;
    L5:
        return this.buf;
    L9:
        throw new StringIndexOutOfBoundsException(r101);
    }

    public JSONReaderScanner(String r100, int r101) {
        this(new StringReader(r100), r101);
    }

    public JSONReaderScanner(char[] r100, int r101) {
        this(r100, r101, JSON.DEFAULT_PARSER_FEATURE);
    }

    public JSONReaderScanner(char[] r100, int r101, int r102) {
        this(new CharArrayReader(r100, 0, r101), r102);
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public final void copyTo(int r100, int r101, char[] r102) {
        System.arraycopy(this.buf, r100, r102, 0, r101);
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public final String addSymbol(int r100, int r101, int r102, SymbolTable r103) {
        return r103.addSymbol(this.buf, r100, r101, r102);
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public final void arrayCopy(int r100, char[] r101, int r102, int r103) {
        System.arraycopy(this.buf, r100, r101, r102, r103);
    }
}
