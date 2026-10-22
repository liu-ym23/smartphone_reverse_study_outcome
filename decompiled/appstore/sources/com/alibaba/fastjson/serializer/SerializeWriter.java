package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.parser.JSONLexer;
import com.google.common.primitives.UnsignedBytes;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Writer;
import java.nio.charset.Charset;
import kotlinx.coroutines.channels.Channel;
import org.apache.http.message.TokenParser;
import org.threeten.bp.Year;
import org.threeten.bp.chrono.HijrahDate;

/* JADX INFO: loaded from: classes.dex */
public final class SerializeWriter extends Writer {
    public static final char[] DIGITS = null;
    static final char[] DigitOnes = null;
    static final char[] DigitTens = null;
    static final char[] ascii_chars = null;
    private static final ThreadLocal<char[]> bufLocal = null;
    static final char[] digits = null;
    static final char[] replaceChars = null;
    static final int[] sizeTable = null;
    static final byte[] specicalFlags_doubleQuotes = null;
    static final byte[] specicalFlags_singleQuotes = null;
    protected char[] buf;
    protected int count;
    protected int features;
    protected final Writer writer;

    static {
        bufLocal = new ThreadLocal();
        sizeTable = new int[]{9, 99, 999, HijrahDate.MAX_VALUE_OF_ERA, 99999, 999999, 9999999, 99999999, Year.MAX_VALUE, Channel.UNLIMITED};
        digits = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        DigitTens = new char[]{'0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '2', '2', '2', '2', '2', '2', '2', '2', '2', '2', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '4', '4', '4', '4', '4', '4', '4', '4', '4', '4', '5', '5', '5', '5', '5', '5', '5', '5', '5', '5', '6', '6', '6', '6', '6', '6', '6', '6', '6', '6', '7', '7', '7', '7', '7', '7', '7', '7', '7', '7', '8', '8', '8', '8', '8', '8', '8', '8', '8', '8', '9', '9', '9', '9', '9', '9', '9', '9', '9', '9'};
        DigitOnes = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
        ascii_chars = new char[]{'0', '0', '0', '1', '0', '2', '0', '3', '0', '4', '0', '5', '0', '6', '0', '7', '0', '8', '0', '9', '0', 'A', '0', 'B', '0', 'C', '0', 'D', '0', 'E', '0', 'F', '1', '0', '1', '1', '1', '2', '1', '3', '1', '4', '1', '5', '1', '6', '1', '7', '1', '8', '1', '9', '1', 'A', '1', 'B', '1', 'C', '1', 'D', '1', 'E', '1', 'F', '2', '0', '2', '1', '2', '2', '2', '3', '2', '4', '2', '5', '2', '6', '2', '7', '2', '8', '2', '9', '2', 'A', '2', 'B', '2', 'C', '2', 'D', '2', 'E', '2', 'F'};
        byte[] r12 = new byte[161];
        specicalFlags_doubleQuotes = r12;
        byte[] r11 = new byte[161];
        specicalFlags_singleQuotes = r11;
        replaceChars = new char[93];
        r12[0] = 4;
        r12[1] = 4;
        r12[2] = 4;
        r12[3] = 4;
        r12[4] = 4;
        r12[5] = 4;
        r12[6] = 4;
        r12[7] = 4;
        r12[8] = 1;
        r12[9] = 1;
        r12[10] = 1;
        r12[11] = 4;
        r12[12] = 1;
        r12[13] = 1;
        r12[34] = 1;
        r12[92] = 1;
        r11[0] = 4;
        r11[1] = 4;
        r11[2] = 4;
        r11[3] = 4;
        r11[4] = 4;
        r11[5] = 4;
        r11[6] = 4;
        r11[7] = 4;
        r11[8] = 1;
        r11[9] = 1;
        r11[10] = 1;
        r11[11] = 4;
        r11[12] = 1;
        r11[13] = 1;
        r11[92] = 1;
        r11[39] = 1;
        int r13 = 14;
    L4:
        if (r13 > 31) goto L6;
        specicalFlags_doubleQuotes[r13] = 4;
        specicalFlags_singleQuotes[r13] = 4;
        r13 = r13 + 1;
        goto L4
    L6:
        int r14 = 127;
    L8:
        if (r14 >= 160) goto L10;
        specicalFlags_doubleQuotes[r14] = 4;
        specicalFlags_singleQuotes[r14] = 4;
        r14 = r14 + 1;
        goto L8
    L10:
        char[] r15 = replaceChars;
        r15[0] = '0';
        r15[1] = '1';
        r15[2] = '2';
        r15[3] = '3';
        r15[4] = '4';
        r15[5] = '5';
        r15[6] = '6';
        r15[7] = '7';
        r15[8] = 'b';
        r15[9] = 't';
        r15[10] = 'n';
        r15[11] = 'v';
        r15[12] = 'f';
        r15[13] = 'r';
        r15[34] = TokenParser.DQUOTE;
        r15[39] = '\'';
        r15[47] = '/';
        r15[92] = TokenParser.ESCAPE;
        DIGITS = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    }

    public SerializeWriter() {
        this(null);
    }

    public static void getChars(long r10, int r11, char[] r12) {
        if (r10 >= 0) goto L5;
        r10 = -r10;
        char r13 = '-';
    L7:
        if (r10 <= 2147483647L) goto L9;
        long r14 = r10 / 100;
        int r15 = (int) (r10 - (((r14 << 6) + (r14 << 5)) + (r14 << 2)));
        r12[r11 - 1] = DigitOnes[r15];
        r11 = r11 - 2;
        r12[r11] = DigitTens[r15];
        r10 = r14;
        goto L7
    L9:
        int r16 = (int) r10;
    L11:
        if (r16 < 65536) goto L13;
        int r17 = r16 / 100;
        int r18 = r16 - (((r17 << 6) + (r17 << 5)) + (r17 << 2));
        r12[r11 - 1] = DigitOnes[r18];
        r11 = r11 - 2;
        r12[r11] = DigitTens[r18];
        r16 = r17;
    L13:
        int r19 = (52429 * r16) >>> 19;
        int r20 = r11 - 1;
        r12[r20] = digits[r16 - ((r19 << 3) + (r19 << 1))];
        if (r19 == 0) goto L15;
        r16 = r19;
        r11 = r20;
        goto L13
    L15:
        if (r13 == 0) goto L23;
        r12[r11 - 2] = r13;
        return;
    L23:
        return;
    L5:
        r13 = 0;
        goto L7
    }

    private void writeKeyWithDoubleQuoteIfHasSpecial(String r15) {
        int r10 = r15.length();
        boolean r11 = true;
        int r12 = (this.count + r10) + 1;
        int r13 = 0;
        if (r12 > this.buf.length) goto L5;
    L33:
        if (r10 != 0) goto L39;
        int r16 = this.count;
        if ((r16 + 3) <= this.buf.length) goto L37;
        expandCapacity(r16 + 3);
    L37:
        char[] r17 = this.buf;
        int r14 = this.count;
        int r18 = r14 + 1;
        this.count = r18;
        r17[r14] = TokenParser.DQUOTE;
        int r19 = r14 + 2;
        this.count = r19;
        r17[r18] = TokenParser.DQUOTE;
        this.count = r14 + 3;
        r17[r19] = ':';
        return;
    L39:
        int r20 = this.count;
        int r21 = r20 + r10;
        r15.getChars(0, r10, this.buf, r20);
        this.count = r12;
        int r110 = r20;
        boolean r22 = false;
    L40:
        if (r110 >= r21) goto L55;
        char[] r23 = this.buf;
        char r111 = r23[r110];
        byte[] r112 = specicalFlags_doubleQuotes;
        if (r111 >= r112.length) goto L54;
        if (r112[r111] == 0) goto L54;
        if (r22 == true) goto L50;
        r12 = r12 + 3;
        if (r12 <= r23.length) goto L49;
        expandCapacity(r12);
    L49:
        this.count = r12;
        char[] r24 = this.buf;
        int r25 = r110 + 1;
        System.arraycopy(r24, r25, r24, r110 + 3, (r21 - r110) - 1);
        char[] r26 = this.buf;
        System.arraycopy(r26, 0, r26, 1, r110);
        char[] r27 = this.buf;
        r27[r20] = TokenParser.DQUOTE;
        r27[r25] = TokenParser.ESCAPE;
        r110 = r110 + 2;
        r27[r110] = replaceChars[r111];
        r21 = r21 + 2;
        r27[this.count - 2] = TokenParser.DQUOTE;
        r22 = true;
        goto L54
    L50:
        r12 = r12 + 1;
        if (r12 <= r23.length) goto L53;
        expandCapacity(r12);
    L53:
        this.count = r12;
        char[] r28 = this.buf;
        int r113 = r110 + 1;
        System.arraycopy(r28, r113, r28, r110 + 2, r21 - r110);
        char[] r29 = this.buf;
        r29[r110] = TokenParser.ESCAPE;
        r29[r113] = replaceChars[r111];
        r21 = r21 + 1;
        r110 = r113;
    L54:
        r110 = r110 + 1;
        goto L40
    L55:
        this.buf[this.count - 1] = ':';
        return;
    L5:
        if (this.writer == null) goto L32;
        if (r10 != 0) goto L9;
        write(34);
        write(34);
        write(58);
        return;
    L9:
        int r30 = 0;
    L10:
        if (r30 >= r10) goto L17;
        char r31 = r15.charAt(r30);
        byte[] r32 = specicalFlags_doubleQuotes;
        if (r31 >= r32.length) goto L16;
        if (r32[r31] == 0) goto L16;
    L18:
        if (r11 == false) goto L20;
        write(34);
    L20:
        if (r13 >= r10) goto L28;
        char r33 = r15.charAt(r13);
        byte[] r34 = specicalFlags_doubleQuotes;
        if (r33 < r34.length) goto L24;
    L26:
        write(r33);
    L27:
        r13 = r13 + 1;
        goto L20
    L24:
        if (r34[r33] == 0) goto L26;
        write(92);
        write(replaceChars[r33]);
        goto L27
    L28:
        if (r11 == false) goto L30;
        write(34);
    L30:
        write(58);
        return;
    L16:
        r30 = r30 + 1;
        goto L10
    L17:
        r11 = false;
        goto L18
    L32:
        expandCapacity(r12);
        goto L33
    }

    private void writeKeyWithSingleQuoteIfHasSpecial(String r15) {
        int r10 = r15.length();
        boolean r11 = true;
        int r12 = (this.count + r10) + 1;
        int r13 = 0;
        if (r12 > this.buf.length) goto L5;
    L33:
        if (r10 != 0) goto L39;
        int r16 = this.count;
        if ((r16 + 3) <= this.buf.length) goto L37;
        expandCapacity(r16 + 3);
    L37:
        char[] r17 = this.buf;
        int r14 = this.count;
        int r18 = r14 + 1;
        this.count = r18;
        r17[r14] = '\'';
        int r19 = r14 + 2;
        this.count = r19;
        r17[r18] = '\'';
        this.count = r14 + 3;
        r17[r19] = ':';
        return;
    L39:
        int r20 = this.count;
        int r21 = r20 + r10;
        r15.getChars(0, r10, this.buf, r20);
        this.count = r12;
        int r110 = r20;
        boolean r22 = false;
    L40:
        if (r110 >= r21) goto L55;
        char[] r23 = this.buf;
        char r111 = r23[r110];
        byte[] r112 = specicalFlags_singleQuotes;
        if (r111 >= r112.length) goto L54;
        if (r112[r111] == 0) goto L54;
        if (r22 == true) goto L50;
        r12 = r12 + 3;
        if (r12 <= r23.length) goto L49;
        expandCapacity(r12);
    L49:
        this.count = r12;
        char[] r24 = this.buf;
        int r25 = r110 + 1;
        System.arraycopy(r24, r25, r24, r110 + 3, (r21 - r110) - 1);
        char[] r26 = this.buf;
        System.arraycopy(r26, 0, r26, 1, r110);
        char[] r27 = this.buf;
        r27[r20] = '\'';
        r27[r25] = TokenParser.ESCAPE;
        r110 = r110 + 2;
        r27[r110] = replaceChars[r111];
        r21 = r21 + 2;
        r27[this.count - 2] = '\'';
        r22 = true;
        goto L54
    L50:
        r12 = r12 + 1;
        if (r12 <= r23.length) goto L53;
        expandCapacity(r12);
    L53:
        this.count = r12;
        char[] r28 = this.buf;
        int r113 = r110 + 1;
        System.arraycopy(r28, r113, r28, r110 + 2, r21 - r110);
        char[] r29 = this.buf;
        r29[r110] = TokenParser.ESCAPE;
        r29[r113] = replaceChars[r111];
        r21 = r21 + 1;
        r110 = r113;
    L54:
        r110 = r110 + 1;
        goto L40
    L55:
        this.buf[r12 - 1] = ':';
        return;
    L5:
        if (this.writer == null) goto L32;
        if (r10 != 0) goto L9;
        write(39);
        write(39);
        write(58);
        return;
    L9:
        int r30 = 0;
    L10:
        if (r30 >= r10) goto L17;
        char r31 = r15.charAt(r30);
        byte[] r32 = specicalFlags_singleQuotes;
        if (r31 >= r32.length) goto L16;
        if (r32[r31] == 0) goto L16;
    L18:
        if (r11 == false) goto L20;
        write(39);
    L20:
        if (r13 >= r10) goto L28;
        char r33 = r15.charAt(r13);
        byte[] r34 = specicalFlags_singleQuotes;
        if (r33 < r34.length) goto L24;
    L26:
        write(r33);
    L27:
        r13 = r13 + 1;
        goto L20
    L24:
        if (r34[r33] == 0) goto L26;
        write(92);
        write(replaceChars[r33]);
        goto L27
    L28:
        if (r11 == false) goto L30;
        write(39);
    L30:
        write(58);
        return;
    L16:
        r30 = r30 + 1;
        goto L10
    L17:
        r11 = false;
        goto L18
    L32:
        expandCapacity(r12);
        goto L33
    }

    @Override // java.io.Writer, java.lang.Appendable
    public /* bridge */ /* synthetic */ Writer append(char r10) throws IOException {
        return append(r10);
    }

    @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.writer != null) goto L5;
    L7:
        char[] r10 = this.buf;
        if (r10.length > 8192) goto L10;
        bufLocal.set(r10);
    L10:
        this.buf = null;
        return;
    L5:
        if (this.count <= 0) goto L7;
        flush();
        goto L7
    }

    public void config(SerializerFeature r10, boolean r11) {
        if (r11 == false) goto L4;
        int r12 = this.features;
        this.features = r10.mask | r12;
        return;
    L4:
        int r13 = this.features;
        this.features = (~r10.mask) & r13;
    }

    public void expandCapacity(int r10) {
        char[] r11 = this.buf;
        int r12 = ((r11.length * 3) / 2) + 1;
        if (r12 < r10) goto L6;
        r10 = r12;
    L6:
        char[] r13 = new char[r10];
        System.arraycopy(r11, 0, r13, 0, this.count);
        this.buf = r13;
    }

    @Override // java.io.Writer, java.io.Flushable
    public void flush() {
        Writer r10 = this.writer;
        if (r10 != null) goto L10;
        return;
    L10:
        r10.write(this.buf, 0, this.count);     // Catch: IOException -> L7
        this.writer.flush();     // Catch: IOException -> L7
        this.count = 0;     // Catch: IOException -> L7
        return;
    L7:
        e = move-exception;
        throw new JSONException(e.getMessage(), e);
    }

    public boolean isEnabled(SerializerFeature r10) {
        if ((this.features & r10.mask) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public byte[] toBytes(String r10) {
        if (this.writer != null) goto L12;
        if (r10 != null) goto L13;
        r10 = "UTF-8";
    L13:
        return new String(this.buf, 0, this.count).getBytes(r10);
    L8:
        e = move-exception;
        throw new JSONException("toBytes error", e);
    L12:
        throw new UnsupportedOperationException("writer not null");
    }

    public String toString() {
        return new String(this.buf, 0, this.count);
    }

    @Override // java.io.Writer
    public void write(int r10) {
        int r11 = 1;
        int r12 = this.count + 1;
        if (r12 > this.buf.length) goto L5;
    L8:
        r11 = r12;
    L9:
        this.buf[this.count] = (char) r10;
        this.count = r11;
        return;
    L5:
        if (this.writer != null) goto L7;
        expandCapacity(r12);
        goto L8
    L7:
        flush();
        goto L9
    }

    public void writeByteArray(byte[] r20) {
        int r10 = r20.length;
        int r11 = 0;
        if ((this.features & SerializerFeature.UseSingleQuotes.mask) == 0) goto L5;
        boolean r12 = true;
    L6:
        if (r12 == false) goto L8;
        char r13 = '\'';
    L9:
        if (r10 != 0) goto L15;
        if (r12 == false) goto L12;
        String r14 = "''";
    L13:
        write(r14);
        return;
    L12:
        r14 = "\"\"";
        goto L13
    L15:
        char[] r15 = JSONLexer.CA;
        int r16 = (r10 / 3) * 3;
        int r17 = r10 - 1;
        int r18 = this.count;
        int r19 = (((r17 / 3) + 1) << 2) + r18;
        int r110 = r19 + 2;
        if (r110 > this.buf.length) goto L18;
    L35:
        this.count = r110;
        int r111 = r18 + 1;
        this.buf[r18] = r13;
        int r112 = 0;
    L36:
        if (r112 >= r16) goto L38;
        int r113 = r112 + 2;
        int r114 = ((r20[r112 + 1] & UnsignedBytes.MAX_VALUE) << 8) | ((r20[r112] & UnsignedBytes.MAX_VALUE) << 16);
        r112 = r112 + 3;
        int r115 = r114 | (r20[r113] & UnsignedBytes.MAX_VALUE);
        char[] r116 = this.buf;
        r116[r111] = r15[(r115 >>> 18) & 63];
        r116[r111 + 1] = r15[(r115 >>> 12) & 63];
        int r117 = r111 + 3;
        r116[r111 + 2] = r15[(r115 >>> 6) & 63];
        r111 = r111 + 4;
        r116[r117] = r15[r115 & 63];
        goto L36
    L38:
        int r21 = r10 - r16;
        if (r21 <= 0) goto L48;
        int r22 = (r20[r16] & UnsignedBytes.MAX_VALUE) << 10;
        if (r21 != 2) goto L43;
        r11 = (r20[r17] & UnsignedBytes.MAX_VALUE) << 2;
    L43:
        int r23 = r22 | r11;
        char[] r24 = this.buf;
        r24[r19 - 3] = r15[r23 >> 12];
        r24[r19 - 2] = r15[(r23 >>> 6) & 63];
        int r25 = r19 - 1;
        if (r21 != 2) goto L46;
        char r26 = r15[r23 & 63];
    L47:
        r24[r25] = r26;
        r24[r19] = '=';
        goto L48
    L46:
        r26 = '=';
    L48:
        this.buf[r19 + 1] = r13;
        return;
    L18:
        if (this.writer == null) goto L34;
        write(r13);
        int r27 = 0;
    L20:
        if (r27 >= r16) goto L22;
        int r118 = r27 + 2;
        int r28 = ((r20[r27 + 1] & UnsignedBytes.MAX_VALUE) << 8) | ((r20[r27] & UnsignedBytes.MAX_VALUE) << 16);
        r27 = r27 + 3;
        int r29 = r28 | (r20[r118] & UnsignedBytes.MAX_VALUE);
        write(r15[(r29 >>> 18) & 63]);
        write(r15[(r29 >>> 12) & 63]);
        write(r15[(r29 >>> 6) & 63]);
        write(r15[r29 & 63]);
        goto L20
    L22:
        int r30 = r10 - r16;
        if (r30 <= 0) goto L32;
        int r31 = (r20[r16] & UnsignedBytes.MAX_VALUE) << 10;
        if (r30 != 2) goto L27;
        r11 = (r20[r17] & UnsignedBytes.MAX_VALUE) << 2;
    L27:
        int r32 = r31 | r11;
        write(r15[r32 >> 12]);
        write(r15[(r32 >>> 6) & 63]);
        if (r30 != 2) goto L30;
        char r33 = r15[r32 & 63];
    L31:
        write(r33);
        write(61);
        goto L32
    L30:
        r33 = '=';
    L32:
        write(r13);
        return;
    L34:
        expandCapacity(r110);
        goto L35
    L8:
        r13 = TokenParser.DQUOTE;
        goto L9
    L5:
        r12 = false;
        goto L6
    }

    public void writeFieldName(String r10, boolean r11) {
        int r12 = this.features;
        if ((SerializerFeature.UseSingleQuotes.mask & r12) == 0) goto L9;
        if ((SerializerFeature.QuoteFieldNames.mask & r12) == 0) goto L7;
        writeStringWithSingleQuote(r10);
        write(58);
        return;
    L7:
        writeKeyWithSingleQuoteIfHasSpecial(r10);
        return;
    L9:
        if ((r12 & SerializerFeature.QuoteFieldNames.mask) == 0) goto L11;
        writeStringWithDoubleQuote(r10, ':', r11);
        return;
    L11:
        writeKeyWithDoubleQuoteIfHasSpecial(r10);
    }

    public void writeInt(int r10) {
        if (r10 != Integer.MIN_VALUE) goto L6;
        write("-2147483648");
        return;
    L6:
        if (r10 >= 0) goto L8;
        int r11 = -r10;
    L9:
        int r12 = 0;
    L11:
        if (r11 <= sizeTable[r12]) goto L12;
        r12 = r12 + 1;
        goto L11
    L12:
        int r13 = r12 + 1;
        if (r10 >= 0) goto L15;
        r13 = r12 + 2;
    L15:
        int r14 = this.count + r13;
        if (r14 > this.buf.length) goto L18;
    L22:
        getChars(r10, r14, this.buf);
        this.count = r14;
        return;
    L18:
        if (this.writer != null) goto L20;
        expandCapacity(r14);
        goto L22
    L20:
        char[] r15 = new char[r13];
        getChars(r10, r13, r15);
        write(r15, 0, r13);
        return;
    L8:
        r11 = r10;
        goto L9
    }

    public void writeLong(long r12) {
        if (r12 != Long.MIN_VALUE) goto L7;
        write("-9223372036854775808");
        return;
    L7:
        if (r12 >= 0) goto L9;
        long r10 = -r12;
    L10:
        int r11 = 1;
        long r13 = 10;
    L11:
        int r14 = 19;
        if (r11 >= 19) goto L17;
        if (r10 < r13) goto L18;
        r13 = r13 * 10;
        r11 = r11 + 1;
    L18:
        if (r11 == 0) goto L21;
        r14 = r11;
    L21:
        if (r12 >= 0) goto L23;
        r14 = r14 + 1;
    L23:
        int r15 = this.count + r14;
        if (r15 > this.buf.length) goto L26;
    L30:
        getChars(r12, r15, this.buf);
        this.count = r15;
        return;
    L26:
        if (this.writer != null) goto L28;
        expandCapacity(r15);
        goto L30
    L28:
        char[] r16 = new char[r14];
        getChars(r12, r14, r16);
        write(r16, 0, r14);
        return;
    L17:
        r11 = 0;
        goto L18
    L9:
        r10 = r12;
        goto L10
    }

    public void writeNull() {
        write("null");
    }

    public void writeString(String r10) {
        if ((this.features & SerializerFeature.UseSingleQuotes.mask) == 0) goto L5;
        writeStringWithSingleQuote(r10);
        return;
    L5:
        writeStringWithDoubleQuote(r10, 0, true);
    }

    public void writeStringWithDoubleQuote(String r19, char r20, boolean r21) {
        if (r19 != null) goto L8;
        writeNull();
        if (r20 == 0) goto L217;
        write(r20);
        return;
    L217:
        return;
    L8:
        int r10 = r19.length();
        int r11 = this.count + r10;
        int r12 = r11 + 2;
        if (r20 == 0) goto L11;
        r12 = r11 + 3;
    L11:
        int r13 = this.buf.length;
        char r14 = TokenParser.CR;
        char r15 = TokenParser.SP;
        char r16 = '/';
        if (r12 > r13) goto L14;
    L50:
        int r17 = this.count;
        int r18 = r17 + 1;
        int r110 = r18 + r10;
        char[] r22 = this.buf;
        r22[r17] = TokenParser.DQUOTE;
        char r23 = 0;
        r19.getChars(0, r10, r22, r18);
        this.count = r12;
        int r24 = -1;
        if ((this.features & SerializerFeature.BrowserCompatible.mask) == 0) goto L107;
        int r25 = r18;
    L53:
        if (r25 >= r110) goto L76;
        char r26 = this.buf[r25];
        if (r26 == '\"') goto L73;
        if (r26 == '/') goto L73;
        if (r26 == '\\') goto L73;
        if (r26 == '\b') goto L73;
        if (r26 == '\f') goto L73;
        if (r26 == '\n') goto L73;
        if (r26 == '\r') goto L73;
        if (r26 == '\t') goto L73;
        if (r26 >= ' ') goto L71;
    L68:
        r12 = r12 + 5;
    L69:
        r24 = r25;
    L74:
        r25 = r25 + 1;
        goto L53
    L71:
        if (r26 < 127) goto L74;
    L73:
        r12 = r12 + 1;
        goto L69
    L76:
        if (r12 <= this.buf.length) goto L78;
        expandCapacity(r12);
    L78:
        this.count = r12;
    L79:
        if (r24 < r18) goto L103;
        char[] r27 = this.buf;
        char r28 = r27[r24];
        if (r28 == '\b') goto L101;
        if (r28 == '\f') goto L101;
        if (r28 == '\n') goto L101;
        if (r28 == r14) goto L101;
        if (r28 == '\t') goto L101;
        if (r28 == '\"') goto L99;
        if (r28 == '/') goto L99;
        if (r28 == '\\') goto L99;
        if (r28 >= ' ') goto L97;
        int r29 = r24 + 1;
        System.arraycopy(r27, r29, r27, r24 + 6, (r110 - r24) - 1);
        char[] r30 = this.buf;
        r30[r24] = TokenParser.ESCAPE;
        r30[r29] = 'u';
        r30[r24 + 2] = '0';
        r30[r24 + 3] = '0';
        char[] r31 = ascii_chars;
        int r32 = r28 * 2;
        r30[r24 + 4] = r31[r32];
        r30[r24 + 5] = r31[r32 + 1];
    L95:
        r110 = r110 + 5;
    L102:
        r24 = r24 - 1;
        r14 = TokenParser.CR;
        goto L79
    L97:
        if (r28 < 127) goto L102;
        int r33 = r24 + 1;
        System.arraycopy(r27, r33, r27, r24 + 6, (r110 - r24) - 1);
        char[] r34 = this.buf;
        r34[r24] = TokenParser.ESCAPE;
        r34[r33] = 'u';
        char[] r35 = DIGITS;
        r34[r24 + 2] = r35[(r28 >>> '\f') & 15];
        r34[r24 + 3] = r35[(r28 >>> '\b') & 15];
        r34[r24 + 4] = r35[(r28 >>> 4) & 15];
        r34[r24 + 5] = r35[r28 & 15];
    L99:
        int r36 = r24 + 1;
        System.arraycopy(r27, r36, r27, r24 + 2, (r110 - r24) - 1);
        char[] r37 = this.buf;
        r37[r24] = TokenParser.ESCAPE;
        r37[r36] = r28;
    L100:
        r110 = r110 + 1;
    L101:
        int r38 = r24 + 1;
        System.arraycopy(r27, r38, r27, r24 + 2, (r110 - r24) - 1);
        char[] r39 = this.buf;
        r39[r24] = TokenParser.ESCAPE;
        r39[r38] = replaceChars[r28];
        goto L100
    L103:
        if (r20 == 0) goto L105;
        char[] r40 = this.buf;
        int r41 = this.count;
        r40[r41 - 2] = TokenParser.DQUOTE;
        r40[r41 - 1] = r20;
        return;
    L105:
        this.buf[this.count - 1] = TokenParser.DQUOTE;
        return;
    L107:
        if (r21 == false) goto L189;
        int r111 = 0;
        int r42 = -1;
        int r43 = -1;
        int r44 = r18;
    L110:
        if (r44 >= r110) goto L151;
        char r45 = this.buf[r44];
        if (r45 != 8232) goto L119;
        r111 = r111 + 1;
        r12 = r12 + 4;
        if (r42 != (-1)) goto L117;
    L115:
        r42 = r44;
        r43 = r42;
    L116:
        r23 = r45;
    L150:
        r44 = r44 + 1;
        r16 = '/';
    L117:
        r43 = r44;
        goto L116
    L119:
        if (r45 < ']') goto L128;
        if (r45 < 127) goto L150;
        if (r45 >= 160) goto L150;
        if (r42 != (-1)) goto L126;
        r42 = r44;
    L126:
        r111 = r111 + 1;
        r12 = r12 + 4;
        goto L117
    L128:
        if (r45 == ' ') goto L150;
        if (r45 != r16) goto L135;
        if ((SerializerFeature.WriteSlashAsSpecial.mask & this.features) == 0) goto L135;
    L143:
        r111 = r111 + 1;
        byte[] r46 = specicalFlags_doubleQuotes;
        if (r45 < r46.length) goto L146;
    L148:
        if (r42 != (-1)) goto L117;
    L146:
        if (r46[r45] != 4) goto L148;
        r12 = r12 + 4;
    L135:
        if (r45 <= '#') goto L139;
        if (r45 != '\\') goto L150;
    L139:
        if (r45 <= 31) goto L143;
        if (r45 == '\\') goto L143;
        if (r45 != '\"') goto L150;
    L151:
        if (r111 <= 0) goto L189;
        int r47 = r12 + r111;
        if (r47 <= this.buf.length) goto L155;
        expandCapacity(r47);
    L155:
        this.count = r47;
        if (r111 != 1) goto L166;
        if (r23 != 8232) goto L159;
        int r48 = r43 + 1;
        char[] r49 = this.buf;
        System.arraycopy(r49, r48, r49, r43 + 6, (r110 - r43) - 1);
        char[] r50 = this.buf;
        r50[r43] = TokenParser.ESCAPE;
        r50[r48] = 'u';
        r50[r43 + 2] = '2';
        r50[r43 + 3] = '0';
        r50[r43 + 4] = '2';
        r50[r43 + 5] = '8';
        goto L189
    L159:
        byte[] r51 = specicalFlags_doubleQuotes;
        if (r23 < r51.length) goto L162;
    L164:
        int r52 = r43 + 1;
        char[] r53 = this.buf;
        System.arraycopy(r53, r52, r53, r43 + 2, (r110 - r43) - 1);
        char[] r54 = this.buf;
        r54[r43] = TokenParser.ESCAPE;
        r54[r52] = replaceChars[r23];
        goto L189
    L162:
        if (r51[r23] != 4) goto L164;
        int r55 = r43 + 1;
        char[] r56 = this.buf;
        System.arraycopy(r56, r55, r56, r43 + 6, (r110 - r43) - 1);
        char[] r57 = this.buf;
        r57[r43] = TokenParser.ESCAPE;
        r57[r55] = 'u';
        char[] r58 = DIGITS;
        r57[r43 + 2] = r58[(r23 >>> '\f') & 15];
        r57[r43 + 3] = r58[(r23 >>> '\b') & 15];
        r57[r43 + 4] = r58[(r23 >>> 4) & 15];
        r57[r43 + 5] = r58[r23 & 15];
        goto L189
    L166:
        if (r111 <= 1) goto L189;
        int r59 = r42 - r18;
    L169:
        if (r59 >= r19.length()) goto L189;
        char r60 = r19.charAt(r59);
        byte[] r61 = specicalFlags_doubleQuotes;
        if (r60 >= r61.length) goto L176;
        if (r61[r60] == 0) goto L176;
    L179:
        char[] r62 = this.buf;
        int r63 = r42 + 1;
        r62[r42] = TokenParser.ESCAPE;
        if (r61[r60] != 4) goto L183;
        r62[r63] = 'u';
        char[] r112 = DIGITS;
        r62[r42 + 2] = r112[(r60 >>> '\f') & 15];
        r62[r42 + 3] = r112[(r60 >>> '\b') & 15];
        int r64 = r42 + 5;
        r62[r42 + 4] = r112[(r60 >>> 4) & 15];
        r42 = r42 + 6;
        r62[r64] = r112[r60 & 15];
    L188:
        r59 = r59 + 1;
        goto L169
    L183:
        r42 = r42 + 2;
        r62[r63] = replaceChars[r60];
    L176:
        if (r60 != '/') goto L185;
        if ((this.features & SerializerFeature.WriteSlashAsSpecial.mask) != 0) goto L179;
    L185:
        if (r60 != 8232) goto L187;
        char[] r65 = this.buf;
        r65[r42] = TokenParser.ESCAPE;
        r65[r42 + 1] = 'u';
        char[] r113 = DIGITS;
        r65[r42 + 2] = r113[(r60 >>> '\f') & 15];
        r65[r42 + 3] = r113[(r60 >>> '\b') & 15];
        int r66 = r42 + 5;
        r65[r42 + 4] = r113[(r60 >>> 4) & 15];
        r42 = r42 + 6;
        r65[r66] = r113[r60 & 15];
        goto L188
    L187:
        this.buf[r42] = r60;
        r42 = r42 + 1;
    L189:
        if (r20 == 0) goto L191;
        char[] r67 = this.buf;
        int r68 = this.count;
        r67[r68 - 2] = TokenParser.DQUOTE;
        r67[r68 - 1] = r20;
        return;
    L191:
        this.buf[this.count - 1] = TokenParser.DQUOTE;
        return;
    L14:
        if (this.writer == null) goto L49;
        write(34);
        int r69 = 0;
    L17:
        if (r69 >= r19.length()) goto L45;
        char r70 = r19.charAt(r69);
        int r71 = this.features;
        if ((SerializerFeature.BrowserCompatible.mask & r71) == 0) goto L35;
        if (r70 == '\b') goto L34;
        if (r70 == '\f') goto L34;
        if (r70 == '\n') goto L34;
        if (r70 == '\r') goto L34;
        if (r70 == '\t') goto L34;
        if (r70 == '\"') goto L34;
        if (r70 == '/') goto L34;
        if (r70 == '\\') goto L34;
        if (r70 >= r15) goto L32;
        write(92);
        write(117);
        write(48);
        write(48);
        char[] r72 = ascii_chars;
        int r73 = r70 * 2;
        write(r72[r73]);
        write(r72[r73 + 1]);
    L44:
        r69 = r69 + 1;
        r15 = TokenParser.SP;
        goto L17
    L32:
        if (r70 < 127) goto L43;
        write(92);
        write(117);
        char[] r74 = DIGITS;
        write(r74[(r70 >>> '\f') & 15]);
        write(r74[(r70 >>> '\b') & 15]);
        write(r74[(r70 >>> 4) & 15]);
        write(r74[r70 & 15]);
    L43:
        write(r70);
    L34:
        write(92);
        write(replaceChars[r70]);
        goto L44
    L35:
        byte[] r114 = specicalFlags_doubleQuotes;
        if (r70 < r114.length) goto L38;
    L39:
        if (r70 != '/') goto L43;
        if ((r71 & SerializerFeature.WriteSlashAsSpecial.mask) == 0) goto L43;
    L42:
        write(92);
        write(replaceChars[r70]);
        goto L44
    L38:
        if (r114[r70] != 0) goto L42;
    L45:
        write(34);
        if (r20 == 0) goto L218;
        write(r20);
        return;
    L218:
        return;
    L49:
        expandCapacity(r12);
        goto L50
    }

    public void writeStringWithSingleQuote(String r15) {
        int r10 = 0;
        if (r15 != null) goto L9;
        int r16 = this.count + 4;
        if (r16 <= this.buf.length) goto L7;
        expandCapacity(r16);
    L7:
        "null".getChars(0, 4, this.buf, this.count);
        this.count = r16;
        return;
    L9:
        int r11 = r15.length();
        int r12 = (this.count + r11) + 2;
        if (r12 > this.buf.length) goto L12;
    L30:
        int r13 = this.count;
        int r14 = r13 + 1;
        int r17 = r14 + r11;
        char[] r18 = this.buf;
        r18[r13] = '\'';
        r15.getChars(0, r11, r18, r14);
        this.count = r12;
        int r19 = -1;
        char r20 = 0;
        int r21 = r14;
    L31:
        if (r21 >= r17) goto L41;
        char r110 = this.buf[r21];
        if (r110 <= '\r') goto L39;
        if (r110 == '\\') goto L39;
        if (r110 == '\'') goto L39;
        if (r110 != '/') goto L40;
        if ((this.features & SerializerFeature.WriteSlashAsSpecial.mask) != 0) goto L39;
    L40:
        r21 = r21 + 1;
    L39:
        r10 = r10 + 1;
        r19 = r21;
        r20 = r110;
        goto L40
    L41:
        int r22 = r12 + r10;
        if (r22 <= this.buf.length) goto L44;
        expandCapacity(r22);
    L44:
        this.count = r22;
        if (r10 != 1) goto L47;
        char[] r111 = this.buf;
        int r23 = r19 + 1;
        System.arraycopy(r111, r23, r111, r19 + 2, (r17 - r19) - 1);
        char[] r112 = this.buf;
        r112[r19] = TokenParser.ESCAPE;
        r112[r23] = replaceChars[r20];
    L59:
        this.buf[this.count - 1] = '\'';
        return;
    L47:
        if (r10 <= 1) goto L59;
        char[] r24 = this.buf;
        int r25 = r19 + 1;
        System.arraycopy(r24, r25, r24, r19 + 2, (r17 - r19) - 1);
        char[] r26 = this.buf;
        r26[r19] = TokenParser.ESCAPE;
        r26[r25] = replaceChars[r20];
        int r27 = r17 + 1;
        int r113 = r19 - 1;
    L49:
        if (r113 < r14) goto L59;
        char[] r114 = this.buf;
        char r28 = r114[r113];
        if (r28 <= '\r') goto L57;
        if (r28 == '\\') goto L57;
        if (r28 == '\'') goto L57;
        if (r28 != '/') goto L58;
        if ((this.features & SerializerFeature.WriteSlashAsSpecial.mask) != 0) goto L57;
    L58:
        r113 = r113 - 1;
    L57:
        int r29 = r113 + 1;
        System.arraycopy(r114, r29, r114, r113 + 2, (r27 - r113) - 1);
        char[] r115 = this.buf;
        r115[r113] = TokenParser.ESCAPE;
        r115[r29] = replaceChars[r28];
        r27 = r27 + 1;
        goto L58
    L12:
        if (this.writer == null) goto L29;
        write(39);
    L15:
        if (r10 >= r15.length()) goto L27;
        char r30 = r15.charAt(r10);
        if (r30 <= '\r') goto L25;
        if (r30 == '\\') goto L25;
        if (r30 == '\'') goto L25;
        if (r30 == '/') goto L22;
    L24:
        write(r30);
    L26:
        r10 = r10 + 1;
        goto L15
    L22:
        if ((this.features & SerializerFeature.WriteSlashAsSpecial.mask) == 0) goto L24;
    L25:
        write(92);
        write(replaceChars[r30]);
        goto L26
    L27:
        write(39);
        return;
    L29:
        expandCapacity(r12);
        goto L30
    }

    public void writeTo(Writer r10) throws IOException {
        if (this.writer != null) goto L7;
        r10.write(this.buf, 0, this.count);
        return;
    L7:
        throw new UnsupportedOperationException("writer not null");
    }

    public SerializeWriter(Writer r10) {
        this.writer = r10;
        this.features = JSON.DEFAULT_GENERATE_FEATURE;
        ThreadLocal<char[]> r11 = bufLocal;
        this.buf = r11.get();
        if (r11 == null) goto L6;
        r11.set(null);
    L6:
        if (this.buf != null) goto L9;
        this.buf = new char[1024];
        return;
    }

    @Override // java.io.Writer, java.lang.Appendable
    public /* bridge */ /* synthetic */ Writer append(CharSequence r10) throws IOException {
        return append(r10);
    }

    @Override // java.io.Writer, java.lang.Appendable
    public /* bridge */ /* synthetic */ Writer append(CharSequence r10, int r11, int r12) throws IOException {
        return append(r10, r11, r12);
    }

    @Override // java.io.Writer, java.lang.Appendable
    public /* bridge */ /* synthetic */ Appendable append(char r10) throws IOException {
        return append(r10);
    }

    public void writeTo(OutputStream r10, String r11) throws IOException {
        writeTo(r10, Charset.forName(r11));
    }

    @Override // java.io.Writer, java.lang.Appendable
    public /* bridge */ /* synthetic */ Appendable append(CharSequence r10) throws IOException {
        return append(r10);
    }

    public void writeTo(OutputStream r10, Charset r11) throws IOException {
        if (this.writer != null) goto L7;
        r10.write(new String(this.buf, 0, this.count).getBytes(r11.name()));
        return;
    L7:
        throw new UnsupportedOperationException("writer not null");
    }

    @Override // java.io.Writer, java.lang.Appendable
    public /* bridge */ /* synthetic */ Appendable append(CharSequence r10, int r11, int r12) throws IOException {
        return append(r10, r11, r12);
    }

    @Override // java.io.Writer, java.lang.Appendable
    public SerializeWriter append(CharSequence r10) {
        if (r10 != null) goto L4;
        String r11 = "null";
    L5:
        write(r11, 0, r11.length());
        return this;
    L4:
        r11 = r10.toString();
        goto L5
    }

    @Override // java.io.Writer
    public void write(char[] r10, int r11, int r12) {
        if (r11 < 0) goto L22;
        if (r11 > r10.length) goto L22;
        if (r12 < 0) goto L22;
        int r13 = r11 + r12;
        if (r13 > r10.length) goto L22;
        if (r13 < 0) goto L22;
        if (r12 != 0) goto L11;
        return;
    L11:
        int r14 = this.count + r12;
        if (r14 > this.buf.length) goto L14;
    L19:
        System.arraycopy(r10, r11, this.buf, this.count, r12);
        this.count = r14;
        return;
    L14:
        if (this.writer != null) goto L16;
        expandCapacity(r14);
    L16:
        char[] r15 = this.buf;
        int r16 = r15.length;
        int r17 = this.count;
        int r18 = r16 - r17;
        System.arraycopy(r10, r11, r15, r17, r18);
        this.count = this.buf.length;
        flush();
        r12 = r12 - r18;
        r11 = r11 + r18;
        if (r12 > this.buf.length) goto L16;
        r14 = r12;
    L22:
        throw new IndexOutOfBoundsException();
    }

    public SerializeWriter(SerializerFeature... r10) {
        this(null, 0, r10);
    }

    @Override // java.io.Writer, java.lang.Appendable
    public SerializeWriter append(CharSequence r10, int r11, int r12) {
        if (r10 != null) goto L4;
        r10 = "null";
    L4:
        String r13 = r10.subSequence(r11, r12).toString();
        write(r13, 0, r13.length());
        return this;
    }

    public SerializeWriter(Writer r10, int r11, SerializerFeature[] r12) {
        this.writer = r10;
        ThreadLocal<char[]> r13 = bufLocal;
        char[] r14 = r13.get();
        this.buf = r14;
        if (r14 == null) goto L6;
        r13.set(null);
    L6:
        if (this.buf != null) goto L8;
        this.buf = new char[1024];
    L8:
        int r15 = r12.length;
        int r16 = 0;
    L9:
        if (r16 >= r15) goto L11;
        r11 = r11 | r12[r16].mask;
        r16 = r16 + 1;
        goto L9
    L11:
        this.features = r11;
    }

    @Override // java.io.Writer, java.lang.Appendable
    public SerializeWriter append(char r10) {
        write(r10);
        return this;
    }

    public SerializeWriter(int r10) {
        this(null, r10);
    }

    public SerializeWriter(Writer r10, int r11) {
        this.writer = r10;
        if (r11 <= 0) goto L7;
        this.buf = new char[r11];
        return;
    L7:
        throw new IllegalArgumentException("Negative initial size: " + r11);
    }

    @Override // java.io.Writer
    public void write(String r10, int r11, int r12) {
        int r13 = this.count + r12;
        if (r13 > this.buf.length) goto L5;
    L11:
        r10.getChars(r11, r12 + r11, this.buf, this.count);
        this.count = r13;
        return;
    L5:
        if (this.writer != null) goto L7;
        expandCapacity(r13);
    L7:
        char[] r14 = this.buf;
        int r15 = r14.length;
        int r16 = this.count;
        int r17 = r15 - r16;
        int r18 = r11 + r17;
        r10.getChars(r11, r18, r14, r16);
        this.count = this.buf.length;
        flush();
        r12 = r12 - r17;
        if (r12 <= this.buf.length) goto L9;
        r11 = r18;
        goto L7
    L9:
        r13 = r12;
        r11 = r18;
        goto L11
    }

    @Override // java.io.Writer
    public void write(String r10) {
        if (r10 != null) goto L5;
        writeNull();
        return;
    L5:
        write(r10, 0, r10.length());
    }

    public void write(boolean r10) {
        if (r10 == false) goto L4;
        String r11 = "true";
    L5:
        write(r11);
        return;
    L4:
        r11 = "false";
        goto L5
    }
}
