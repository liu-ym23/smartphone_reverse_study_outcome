package com.alibaba.fastjson.serializer;

import androidx.room.AbstractC0351g;
import ch.qos.logback.core.CoreConstants;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.util.IOUtils;
import com.stepos.activeview.utils.Constants;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Writer;
import java.math.BigDecimal;
import java.nio.charset.Charset;
import java.util.List;
import kotlin.UByte;

/* loaded from: classes.dex */
public final class SerializeWriter extends Writer {
    private static final ThreadLocal<char[]> bufLocal = new ThreadLocal<>();
    private static final ThreadLocal<byte[]> bytesBufLocal = new ThreadLocal<>();
    static final int nonDirectFeautres = (((((((SerializerFeature.UseSingleQuotes.mask | SerializerFeature.BrowserCompatible.mask) | SerializerFeature.PrettyFormat.mask) | SerializerFeature.WriteEnumUsingToString.mask) | SerializerFeature.WriteNonStringValueAsString.mask) | SerializerFeature.WriteSlashAsSpecial.mask) | SerializerFeature.IgnoreErrorGetter.mask) | SerializerFeature.WriteClassName.mask) | SerializerFeature.NotWriteDefaultValue.mask;
    protected boolean beanToArray;
    protected boolean browserSecure;
    protected char[] buf;
    protected int count;
    protected boolean disableCircularReferenceDetect;
    protected int features;
    protected char keySeperator;
    protected int maxBufSize;
    protected boolean notWriteDefaultValue;
    protected boolean quoteFieldNames;
    protected long sepcialBits;
    protected boolean sortField;
    protected boolean useSingleQuotes;
    protected boolean writeDirect;
    protected boolean writeEnumUsingName;
    protected boolean writeEnumUsingToString;
    protected boolean writeNonStringValueAsString;
    private final Writer writer;

    public SerializeWriter() {
        this((Writer) null);
    }

    private int encodeToUTF8(OutputStream outputStream) throws IOException {
        int i4 = (int) (this.count * 3.0d);
        ThreadLocal<byte[]> threadLocal = bytesBufLocal;
        byte[] bArr = threadLocal.get();
        if (bArr == null) {
            bArr = new byte[8192];
            threadLocal.set(bArr);
        }
        if (bArr.length < i4) {
            bArr = new byte[i4];
        }
        int iEncodeUTF8 = IOUtils.encodeUTF8(this.buf, 0, this.count, bArr);
        outputStream.write(bArr, 0, iEncodeUTF8);
        return iEncodeUTF8;
    }

    private byte[] encodeToUTF8Bytes() {
        int i4 = (int) (this.count * 3.0d);
        ThreadLocal<byte[]> threadLocal = bytesBufLocal;
        byte[] bArr = threadLocal.get();
        if (bArr == null) {
            bArr = new byte[8192];
            threadLocal.set(bArr);
        }
        if (bArr.length < i4) {
            bArr = new byte[i4];
        }
        int iEncodeUTF8 = IOUtils.encodeUTF8(this.buf, 0, this.count, bArr);
        byte[] bArr2 = new byte[iEncodeUTF8];
        System.arraycopy(bArr, 0, bArr2, 0, iEncodeUTF8);
        return bArr2;
    }

    private void writeEnumFieldValue(char c4, String str, String str2) {
        if (this.useSingleQuotes) {
            writeFieldValue(c4, str, str2);
        } else {
            writeFieldValueStringWithDoubleQuote(c4, str, str2);
        }
    }

    private void writeKeyWithSingleQuoteIfHasSpecial(String str) {
        byte[] bArr = IOUtils.specicalFlags_singleQuotes;
        int length = str.length();
        boolean z4 = true;
        int i4 = this.count + length + 1;
        int i5 = 0;
        if (i4 > this.buf.length) {
            if (this.writer != null) {
                if (length == 0) {
                    write(39);
                    write(39);
                    write(58);
                    return;
                }
                int i6 = 0;
                while (true) {
                    if (i6 < length) {
                        char cCharAt = str.charAt(i6);
                        if (cCharAt < bArr.length && bArr[cCharAt] != 0) {
                            break;
                        } else {
                            i6++;
                        }
                    } else {
                        z4 = false;
                        break;
                    }
                }
                if (z4) {
                    write(39);
                }
                while (i5 < length) {
                    char cCharAt2 = str.charAt(i5);
                    if (cCharAt2 >= bArr.length || bArr[cCharAt2] == 0) {
                        write(cCharAt2);
                    } else {
                        write(92);
                        write(IOUtils.replaceChars[cCharAt2]);
                    }
                    i5++;
                }
                if (z4) {
                    write(39);
                }
                write(58);
                return;
            }
            expandCapacity(i4);
        }
        if (length == 0) {
            int i7 = this.count;
            if (i7 + 3 > this.buf.length) {
                expandCapacity(i7 + 3);
            }
            char[] cArr = this.buf;
            int i8 = this.count;
            cArr[i8] = '\'';
            cArr[i8 + 1] = '\'';
            this.count = i8 + 3;
            cArr[i8 + 2] = CoreConstants.COLON_CHAR;
            return;
        }
        int i9 = this.count;
        int i10 = i9 + length;
        str.getChars(0, length, this.buf, i9);
        this.count = i4;
        int i11 = i9;
        boolean z5 = false;
        while (i11 < i10) {
            char[] cArr2 = this.buf;
            char c4 = cArr2[i11];
            if (c4 < bArr.length && bArr[c4] != 0) {
                if (z5) {
                    i4++;
                    if (i4 > cArr2.length) {
                        expandCapacity(i4);
                    }
                    this.count = i4;
                    char[] cArr3 = this.buf;
                    int i12 = i11 + 1;
                    System.arraycopy(cArr3, i12, cArr3, i11 + 2, i10 - i11);
                    char[] cArr4 = this.buf;
                    cArr4[i11] = CoreConstants.ESCAPE_CHAR;
                    cArr4[i12] = IOUtils.replaceChars[c4];
                    i10++;
                    i11 = i12;
                } else {
                    i4 += 3;
                    if (i4 > cArr2.length) {
                        expandCapacity(i4);
                    }
                    this.count = i4;
                    char[] cArr5 = this.buf;
                    int i13 = i11 + 1;
                    System.arraycopy(cArr5, i13, cArr5, i11 + 3, (i10 - i11) - 1);
                    char[] cArr6 = this.buf;
                    System.arraycopy(cArr6, i5, cArr6, 1, i11);
                    char[] cArr7 = this.buf;
                    cArr7[i9] = '\'';
                    cArr7[i13] = CoreConstants.ESCAPE_CHAR;
                    i11 += 2;
                    cArr7[i11] = IOUtils.replaceChars[c4];
                    i10 += 2;
                    cArr7[this.count - 2] = '\'';
                    z5 = true;
                }
            }
            i11++;
            i5 = 0;
        }
        this.buf[i4 - 1] = CoreConstants.COLON_CHAR;
    }

    @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.writer != null && this.count > 0) {
            flush();
        }
        char[] cArr = this.buf;
        if (cArr.length <= 65536) {
            bufLocal.set(cArr);
        }
        this.buf = null;
    }

    public void computeFeatures() {
        int i4 = this.features;
        boolean z4 = (SerializerFeature.QuoteFieldNames.mask & i4) != 0;
        this.quoteFieldNames = z4;
        boolean z5 = (SerializerFeature.UseSingleQuotes.mask & i4) != 0;
        this.useSingleQuotes = z5;
        this.sortField = (SerializerFeature.SortField.mask & i4) != 0;
        this.disableCircularReferenceDetect = (SerializerFeature.DisableCircularReferenceDetect.mask & i4) != 0;
        boolean z6 = (SerializerFeature.BeanToArray.mask & i4) != 0;
        this.beanToArray = z6;
        this.writeNonStringValueAsString = (SerializerFeature.WriteNonStringValueAsString.mask & i4) != 0;
        this.notWriteDefaultValue = (SerializerFeature.NotWriteDefaultValue.mask & i4) != 0;
        boolean z7 = (SerializerFeature.WriteEnumUsingName.mask & i4) != 0;
        this.writeEnumUsingName = z7;
        this.writeEnumUsingToString = (SerializerFeature.WriteEnumUsingToString.mask & i4) != 0;
        this.writeDirect = z4 && (nonDirectFeautres & i4) == 0 && (z6 || z7);
        this.keySeperator = z5 ? '\'' : '\"';
        boolean z8 = (SerializerFeature.BrowserSecure.mask & i4) != 0;
        this.browserSecure = z8;
        this.sepcialBits = z8 ? 5764610843043954687L : (i4 & SerializerFeature.WriteSlashAsSpecial.mask) != 0 ? 140758963191807L : 21474836479L;
    }

    public void config(SerializerFeature serializerFeature, boolean z4) {
        if (z4) {
            int mask = this.features | serializerFeature.getMask();
            this.features = mask;
            SerializerFeature serializerFeature2 = SerializerFeature.WriteEnumUsingToString;
            if (serializerFeature == serializerFeature2) {
                this.features = (~SerializerFeature.WriteEnumUsingName.getMask()) & mask;
            } else if (serializerFeature == SerializerFeature.WriteEnumUsingName) {
                this.features = (~serializerFeature2.getMask()) & mask;
            }
        } else {
            this.features = (~serializerFeature.getMask()) & this.features;
        }
        computeFeatures();
    }

    public void expandCapacity(int i4) {
        int i5 = this.maxBufSize;
        if (i5 != -1 && i4 >= i5) {
            throw new JSONException("serialize exceeded MAX_OUTPUT_LENGTH=" + this.maxBufSize + ", minimumCapacity=" + i4);
        }
        char[] cArr = this.buf;
        int length = cArr.length + (cArr.length >> 1) + 1;
        if (length >= i4) {
            i4 = length;
        }
        char[] cArr2 = new char[i4];
        System.arraycopy(cArr, 0, cArr2, 0, this.count);
        this.buf = cArr2;
    }

    @Override // java.io.Writer, java.io.Flushable
    public void flush() throws IOException {
        Writer writer = this.writer;
        if (writer == null) {
            return;
        }
        try {
            writer.write(this.buf, 0, this.count);
            this.writer.flush();
            this.count = 0;
        } catch (IOException e4) {
            throw new JSONException(e4.getMessage(), e4);
        }
    }

    public int getBufferLength() {
        return this.buf.length;
    }

    public int getMaxBufSize() {
        return this.maxBufSize;
    }

    public boolean isEnabled(SerializerFeature serializerFeature) {
        return (this.features & serializerFeature.mask) != 0;
    }

    public boolean isNotWriteDefaultValue() {
        return this.notWriteDefaultValue;
    }

    public boolean isSortField() {
        return this.sortField;
    }

    public void setMaxBufSize(int i4) {
        if (i4 >= this.buf.length) {
            this.maxBufSize = i4;
        } else {
            throw new JSONException("must > " + this.buf.length);
        }
    }

    public int size() {
        return this.count;
    }

    public byte[] toBytes(String str) {
        return toBytes((str == null || Constants.UTF_8_CODE.equals(str)) ? IOUtils.UTF8 : Charset.forName(str));
    }

    public char[] toCharArray() {
        if (this.writer != null) {
            throw new UnsupportedOperationException("writer not null");
        }
        int i4 = this.count;
        char[] cArr = new char[i4];
        System.arraycopy(this.buf, 0, cArr, 0, i4);
        return cArr;
    }

    public char[] toCharArrayForSpringWebSocket() {
        if (this.writer != null) {
            throw new UnsupportedOperationException("writer not null");
        }
        int i4 = this.count;
        char[] cArr = new char[i4 - 2];
        System.arraycopy(this.buf, 1, cArr, 0, i4 - 2);
        return cArr;
    }

    public String toString() {
        return new String(this.buf, 0, this.count);
    }

    @Override // java.io.Writer
    public void write(int i4) {
        int i5 = 1;
        int i6 = this.count + 1;
        if (i6 <= this.buf.length) {
            i5 = i6;
        } else if (this.writer == null) {
            expandCapacity(i6);
            i5 = i6;
        } else {
            flush();
        }
        this.buf[this.count] = (char) i4;
        this.count = i5;
    }

    public void writeByteArray(byte[] bArr) {
        if (isEnabled(SerializerFeature.WriteClassName.mask)) {
            writeHex(bArr);
            return;
        }
        int length = bArr.length;
        boolean z4 = this.useSingleQuotes;
        char c4 = z4 ? '\'' : '\"';
        if (length == 0) {
            write(z4 ? "''" : "\"\"");
            return;
        }
        char[] cArr = IOUtils.CA;
        int i4 = (length / 3) * 3;
        int i5 = length - 1;
        int i6 = this.count;
        int i7 = (((i5 / 3) + 1) << 2) + i6;
        int i8 = i7 + 2;
        if (i8 > this.buf.length) {
            if (this.writer != null) {
                write(c4);
                int i9 = 0;
                while (i9 < i4) {
                    int i10 = i9 + 2;
                    int i11 = ((bArr[i9 + 1] & UByte.MAX_VALUE) << 8) | ((bArr[i9] & UByte.MAX_VALUE) << 16);
                    i9 += 3;
                    int i12 = i11 | (bArr[i10] & UByte.MAX_VALUE);
                    write(cArr[(i12 >>> 18) & 63]);
                    write(cArr[(i12 >>> 12) & 63]);
                    write(cArr[(i12 >>> 6) & 63]);
                    write(cArr[i12 & 63]);
                }
                int i13 = length - i4;
                if (i13 > 0) {
                    int i14 = ((bArr[i4] & UByte.MAX_VALUE) << 10) | (i13 == 2 ? (bArr[i5] & UByte.MAX_VALUE) << 2 : 0);
                    write(cArr[i14 >> 12]);
                    write(cArr[(i14 >>> 6) & 63]);
                    write(i13 == 2 ? cArr[i14 & 63] : '=');
                    write(61);
                }
                write(c4);
                return;
            }
            expandCapacity(i8);
        }
        this.count = i8;
        int i15 = i6 + 1;
        this.buf[i6] = c4;
        int i16 = 0;
        while (i16 < i4) {
            int i17 = i16 + 2;
            int i18 = ((bArr[i16 + 1] & UByte.MAX_VALUE) << 8) | ((bArr[i16] & UByte.MAX_VALUE) << 16);
            i16 += 3;
            int i19 = i18 | (bArr[i17] & UByte.MAX_VALUE);
            char[] cArr2 = this.buf;
            cArr2[i15] = cArr[(i19 >>> 18) & 63];
            cArr2[i15 + 1] = cArr[(i19 >>> 12) & 63];
            int i20 = i15 + 3;
            cArr2[i15 + 2] = cArr[(i19 >>> 6) & 63];
            i15 += 4;
            cArr2[i20] = cArr[i19 & 63];
        }
        int i21 = length - i4;
        if (i21 > 0) {
            int i22 = ((bArr[i4] & UByte.MAX_VALUE) << 10) | (i21 == 2 ? (bArr[i5] & UByte.MAX_VALUE) << 2 : 0);
            char[] cArr3 = this.buf;
            cArr3[i7 - 3] = cArr[i22 >> 12];
            cArr3[i7 - 2] = cArr[(i22 >>> 6) & 63];
            cArr3[i7 - 1] = i21 == 2 ? cArr[i22 & 63] : '=';
            cArr3[i7] = '=';
        }
        this.buf[i7 + 1] = c4;
    }

    public void writeDouble(double d4, boolean z4) {
        if (Double.isNaN(d4) || Double.isInfinite(d4)) {
            writeNull();
            return;
        }
        String string = Double.toString(d4);
        if (isEnabled(SerializerFeature.WriteNullNumberAsZero) && string.endsWith(".0")) {
            string = string.substring(0, string.length() - 2);
        }
        write(string);
        if (z4 && isEnabled(SerializerFeature.WriteClassName)) {
            write(68);
        }
    }

    public void writeEnum(Enum<?> r22) throws IOException {
        if (r22 == null) {
            writeNull();
            return;
        }
        String string = (!this.writeEnumUsingName || this.writeEnumUsingToString) ? this.writeEnumUsingToString ? r22.toString() : null : r22.name();
        if (string == null) {
            writeInt(r22.ordinal());
            return;
        }
        int i4 = isEnabled(SerializerFeature.UseSingleQuotes) ? 39 : 34;
        write(i4);
        write(string);
        write(i4);
    }

    public void writeFieldName(String str) {
        writeFieldName(str, false);
    }

    public void writeFieldNameDirect(String str) {
        int length = str.length();
        int i4 = this.count + length;
        int i5 = i4 + 3;
        if (i5 > this.buf.length) {
            expandCapacity(i5);
        }
        int i6 = this.count;
        char[] cArr = this.buf;
        cArr[i6] = '\"';
        str.getChars(0, length, cArr, i6 + 1);
        this.count = i5;
        char[] cArr2 = this.buf;
        cArr2[i4 + 1] = '\"';
        cArr2[i4 + 2] = CoreConstants.COLON_CHAR;
    }

    public void writeFieldValue(char c4, String str, char c5) {
        write(c4);
        writeFieldName(str);
        if (c5 == 0) {
            writeString("\u0000");
        } else {
            writeString(Character.toString(c5));
        }
    }

    public void writeFieldValueStringWithDoubleQuote(char c4, String str, String str2) {
        int length = str.length();
        int i4 = this.count;
        int length2 = str2.length();
        int i5 = length + length2 + 6 + i4;
        if (i5 > this.buf.length) {
            if (this.writer != null) {
                write(c4);
                writeStringWithDoubleQuote(str, CoreConstants.COLON_CHAR);
                writeStringWithDoubleQuote(str2, (char) 0);
                return;
            }
            expandCapacity(i5);
        }
        char[] cArr = this.buf;
        int i6 = this.count;
        cArr[i6] = c4;
        int i7 = i6 + 2;
        int i8 = i7 + length;
        cArr[i6 + 1] = '\"';
        str.getChars(0, length, cArr, i7);
        this.count = i5;
        char[] cArr2 = this.buf;
        cArr2[i8] = '\"';
        cArr2[i8 + 1] = CoreConstants.COLON_CHAR;
        cArr2[i8 + 2] = '\"';
        str2.getChars(0, length2, cArr2, i8 + 3);
        this.buf[this.count - 1] = '\"';
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x00a2 A[PHI: r1 r4 r6 r9 r10
      0x00a2: PHI (r1v50 int) = (r1v41 int), (r1v3 int) binds: [B:53:0x00db, B:30:0x009d] A[DONT_GENERATE, DONT_INLINE]
      0x00a2: PHI (r4v17 char) = (r4v16 char), (r4v19 char) binds: [B:53:0x00db, B:30:0x009d] A[DONT_GENERATE, DONT_INLINE]
      0x00a2: PHI (r6v21 int) = (r6v20 int), (r6v23 int) binds: [B:53:0x00db, B:30:0x009d] A[DONT_GENERATE, DONT_INLINE]
      0x00a2: PHI (r9v11 int) = (r9v10 int), (r9v13 int) binds: [B:53:0x00db, B:30:0x009d] A[DONT_GENERATE, DONT_INLINE]
      0x00a2: PHI (r10v13 int) = (r10v3 int), (r10v15 int) binds: [B:53:0x00db, B:30:0x009d] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00d7  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00dd  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void writeFieldValueStringWithDoubleQuoteCheck(char r23, java.lang.String r24, java.lang.String r25) {
        /*
            Method dump skipped, instructions count: 788
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.serializer.SerializeWriter.writeFieldValueStringWithDoubleQuoteCheck(char, java.lang.String, java.lang.String):void");
    }

    public void writeFloat(float f4, boolean z4) {
        if (Float.isNaN(f4) || Float.isInfinite(f4)) {
            writeNull();
            return;
        }
        String string = Float.toString(f4);
        if (isEnabled(SerializerFeature.WriteNullNumberAsZero) && string.endsWith(".0")) {
            string = string.substring(0, string.length() - 2);
        }
        write(string);
        if (z4 && isEnabled(SerializerFeature.WriteClassName)) {
            write(70);
        }
    }

    public void writeHex(byte[] bArr) {
        int i4 = 2;
        int length = (bArr.length * 2) + this.count + 3;
        int i5 = 0;
        if (length > this.buf.length) {
            if (this.writer != null) {
                char[] cArr = new char[bArr.length + 3];
                cArr[0] = 'x';
                cArr[1] = '\'';
                while (i5 < bArr.length) {
                    byte b4 = bArr[i5];
                    int i6 = (b4 & UByte.MAX_VALUE) >> 4;
                    int i7 = b4 & 15;
                    int i8 = i4 + 1;
                    cArr[i4] = (char) (i6 + (i6 < 10 ? 48 : 55));
                    i4 += 2;
                    cArr[i8] = (char) (i7 + (i7 < 10 ? 48 : 55));
                    i5++;
                }
                cArr[i4] = '\'';
                try {
                    this.writer.write(cArr);
                    return;
                } catch (IOException e4) {
                    throw new JSONException("writeBytes error.", e4);
                }
            }
            expandCapacity(length);
        }
        char[] cArr2 = this.buf;
        int i9 = this.count;
        cArr2[i9] = 'x';
        this.count = i9 + 2;
        cArr2[i9 + 1] = '\'';
        while (i5 < bArr.length) {
            byte b5 = bArr[i5];
            int i10 = (b5 & UByte.MAX_VALUE) >> 4;
            int i11 = b5 & 15;
            char[] cArr3 = this.buf;
            int i12 = this.count;
            int i13 = i12 + 1;
            this.count = i13;
            cArr3[i12] = (char) (i10 + (i10 < 10 ? 48 : 55));
            this.count = i12 + 2;
            cArr3[i13] = (char) (i11 + (i11 < 10 ? 48 : 55));
            i5++;
        }
        char[] cArr4 = this.buf;
        int i14 = this.count;
        this.count = i14 + 1;
        cArr4[i14] = '\'';
    }

    public void writeInt(int i4) throws IOException {
        if (i4 == Integer.MIN_VALUE) {
            write("-2147483648");
            return;
        }
        int iStringSize = i4 < 0 ? IOUtils.stringSize(-i4) + 1 : IOUtils.stringSize(i4);
        int i5 = this.count + iStringSize;
        if (i5 > this.buf.length) {
            if (this.writer != null) {
                char[] cArr = new char[iStringSize];
                IOUtils.getChars(i4, iStringSize, cArr);
                write(cArr, 0, iStringSize);
                return;
            }
            expandCapacity(i5);
        }
        IOUtils.getChars(i4, i5, this.buf);
        this.count = i5;
    }

    public void writeLong(long j4) throws IOException {
        boolean z4 = isEnabled(SerializerFeature.BrowserCompatible) && !isEnabled(SerializerFeature.WriteClassName) && (j4 > 9007199254740991L || j4 < -9007199254740991L);
        if (j4 == Long.MIN_VALUE) {
            if (z4) {
                write("\"-9223372036854775808\"");
                return;
            } else {
                write("-9223372036854775808");
                return;
            }
        }
        int iStringSize = j4 < 0 ? IOUtils.stringSize(-j4) + 1 : IOUtils.stringSize(j4);
        int i4 = this.count + iStringSize;
        if (z4) {
            i4 += 2;
        }
        if (i4 > this.buf.length) {
            if (this.writer != null) {
                char[] cArr = new char[iStringSize];
                IOUtils.getChars(j4, iStringSize, cArr);
                if (!z4) {
                    write(cArr, 0, iStringSize);
                    return;
                }
                write(34);
                write(cArr, 0, iStringSize);
                write(34);
                return;
            }
            expandCapacity(i4);
        }
        if (z4) {
            char[] cArr2 = this.buf;
            cArr2[this.count] = '\"';
            int i5 = i4 - 1;
            IOUtils.getChars(j4, i5, cArr2);
            this.buf[i5] = '\"';
        } else {
            IOUtils.getChars(j4, i4, this.buf);
        }
        this.count = i4;
    }

    public void writeNull() {
        write("null");
    }

    public void writeString(String str, char c4) {
        if (!this.useSingleQuotes) {
            writeStringWithDoubleQuote(str, c4);
        } else {
            writeStringWithSingleQuote(str);
            write(c4);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:144:0x02b3 A[PHI: r5 r9 r11 r15
      0x02b3: PHI (r5v27 int) = (r5v25 int), (r5v29 int) binds: [B:166:0x02ed, B:143:0x02af] A[DONT_GENERATE, DONT_INLINE]
      0x02b3: PHI (r9v22 int) = (r9v15 int), (r9v3 int) binds: [B:166:0x02ed, B:143:0x02af] A[DONT_GENERATE, DONT_INLINE]
      0x02b3: PHI (r11v14 int) = (r11v12 int), (r11v16 int) binds: [B:166:0x02ed, B:143:0x02af] A[DONT_GENERATE, DONT_INLINE]
      0x02b3: PHI (r15v13 int) = (r15v2 int), (r15v15 int) binds: [B:166:0x02ed, B:143:0x02af] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:165:0x02ea  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x02ef  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x014f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void writeStringWithDoubleQuote(java.lang.String r23, char r24) {
        /*
            Method dump skipped, instructions count: 1345
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.serializer.SerializeWriter.writeStringWithDoubleQuote(java.lang.String, char):void");
    }

    public void writeStringWithSingleQuote(String str) {
        int i4 = 0;
        if (str == null) {
            int i5 = this.count + 4;
            if (i5 > this.buf.length) {
                expandCapacity(i5);
            }
            "null".getChars(0, 4, this.buf, this.count);
            this.count = i5;
            return;
        }
        int length = str.length();
        int i6 = this.count + length + 2;
        if (i6 > this.buf.length) {
            if (this.writer != null) {
                write(39);
                while (i4 < str.length()) {
                    char cCharAt = str.charAt(i4);
                    if (cCharAt <= '\r' || cCharAt == '\\' || cCharAt == '\'' || (cCharAt == '/' && isEnabled(SerializerFeature.WriteSlashAsSpecial))) {
                        write(92);
                        write(IOUtils.replaceChars[cCharAt]);
                    } else {
                        write(cCharAt);
                    }
                    i4++;
                }
                write(39);
                return;
            }
            expandCapacity(i6);
        }
        int i7 = this.count;
        int i8 = i7 + 1;
        int i9 = i8 + length;
        char[] cArr = this.buf;
        cArr[i7] = '\'';
        str.getChars(0, length, cArr, i8);
        this.count = i6;
        int i10 = -1;
        char c4 = 0;
        for (int i11 = i8; i11 < i9; i11++) {
            char c5 = this.buf[i11];
            if (c5 <= '\r' || c5 == '\\' || c5 == '\'' || (c5 == '/' && isEnabled(SerializerFeature.WriteSlashAsSpecial))) {
                i4++;
                i10 = i11;
                c4 = c5;
            }
        }
        int i12 = i6 + i4;
        if (i12 > this.buf.length) {
            expandCapacity(i12);
        }
        this.count = i12;
        if (i4 == 1) {
            char[] cArr2 = this.buf;
            int i13 = i10 + 1;
            System.arraycopy(cArr2, i13, cArr2, i10 + 2, (i9 - i10) - 1);
            char[] cArr3 = this.buf;
            cArr3[i10] = CoreConstants.ESCAPE_CHAR;
            cArr3[i13] = IOUtils.replaceChars[c4];
        } else if (i4 > 1) {
            char[] cArr4 = this.buf;
            int i14 = i10 + 1;
            System.arraycopy(cArr4, i14, cArr4, i10 + 2, (i9 - i10) - 1);
            char[] cArr5 = this.buf;
            cArr5[i10] = CoreConstants.ESCAPE_CHAR;
            cArr5[i14] = IOUtils.replaceChars[c4];
            int i15 = i9 + 1;
            for (int i16 = i10 - 1; i16 >= i8; i16--) {
                char c6 = this.buf[i16];
                if (c6 <= '\r' || c6 == '\\' || c6 == '\'' || (c6 == '/' && isEnabled(SerializerFeature.WriteSlashAsSpecial))) {
                    char[] cArr6 = this.buf;
                    int i17 = i16 + 1;
                    System.arraycopy(cArr6, i17, cArr6, i16 + 2, (i15 - i16) - 1);
                    char[] cArr7 = this.buf;
                    cArr7[i16] = CoreConstants.ESCAPE_CHAR;
                    cArr7[i17] = IOUtils.replaceChars[c6];
                    i15++;
                }
            }
        }
        this.buf[this.count - 1] = '\'';
    }

    public void writeTo(Writer writer) throws IOException {
        if (this.writer != null) {
            throw new UnsupportedOperationException("writer not null");
        }
        writer.write(this.buf, 0, this.count);
    }

    public int writeToEx(OutputStream outputStream, Charset charset) throws IOException {
        if (this.writer != null) {
            throw new UnsupportedOperationException("writer not null");
        }
        if (charset == IOUtils.UTF8) {
            return encodeToUTF8(outputStream);
        }
        byte[] bytes = new String(this.buf, 0, this.count).getBytes(charset);
        outputStream.write(bytes);
        return bytes.length;
    }

    public SerializeWriter(Writer writer) {
        this(writer, JSON.DEFAULT_GENERATE_FEATURE, SerializerFeature.EMPTY);
    }

    public boolean isEnabled(int i4) {
        return (this.features & i4) != 0;
    }

    public void writeFieldName(String str, boolean z4) {
        if (str == null) {
            write("null:");
            return;
        }
        if (this.useSingleQuotes) {
            if (!this.quoteFieldNames) {
                writeKeyWithSingleQuoteIfHasSpecial(str);
                return;
            } else {
                writeStringWithSingleQuote(str);
                write(58);
                return;
            }
        }
        if (this.quoteFieldNames) {
            writeStringWithDoubleQuote(str, CoreConstants.COLON_CHAR);
            return;
        }
        int i4 = 0;
        boolean z5 = str.length() == 0;
        while (true) {
            if (i4 < str.length()) {
                char cCharAt = str.charAt(i4);
                if ((cCharAt < '@' && (this.sepcialBits & (1 << cCharAt)) != 0) || cCharAt == '\\') {
                    break;
                } else {
                    i4++;
                }
            } else if (!z5) {
                write(str);
                write(58);
                return;
            }
        }
        writeStringWithDoubleQuote(str, CoreConstants.COLON_CHAR);
    }

    public void writeNull(SerializerFeature serializerFeature) {
        writeNull(0, serializerFeature.mask);
    }

    public SerializeWriter(SerializerFeature... serializerFeatureArr) {
        this((Writer) null, serializerFeatureArr);
    }

    public void writeNull(int i4, int i5) {
        if ((i4 & i5) == 0 && (this.features & i5) == 0) {
            writeNull();
            return;
        }
        if (i5 == SerializerFeature.WriteNullListAsEmpty.mask) {
            write("[]");
            return;
        }
        if (i5 == SerializerFeature.WriteNullStringAsEmpty.mask) {
            writeString("");
            return;
        }
        if (i5 == SerializerFeature.WriteNullBooleanAsFalse.mask) {
            write("false");
        } else if (i5 == SerializerFeature.WriteNullNumberAsZero.mask) {
            write(48);
        } else {
            writeNull();
        }
    }

    public SerializeWriter(Writer writer, SerializerFeature... serializerFeatureArr) {
        this(writer, 0, serializerFeatureArr);
    }

    public byte[] toBytes(Charset charset) {
        if (this.writer == null) {
            if (charset == IOUtils.UTF8) {
                return encodeToUTF8Bytes();
            }
            return new String(this.buf, 0, this.count).getBytes(charset);
        }
        throw new UnsupportedOperationException("writer not null");
    }

    public void writeTo(OutputStream outputStream, String str) throws IOException {
        writeTo(outputStream, Charset.forName(str));
    }

    public SerializeWriter(Writer writer, int i4, SerializerFeature... serializerFeatureArr) {
        this.maxBufSize = -1;
        this.writer = writer;
        ThreadLocal<char[]> threadLocal = bufLocal;
        char[] cArr = threadLocal.get();
        this.buf = cArr;
        if (cArr != null) {
            threadLocal.set(null);
        } else {
            this.buf = new char[2048];
        }
        for (SerializerFeature serializerFeature : serializerFeatureArr) {
            i4 |= serializerFeature.getMask();
        }
        this.features = i4;
        computeFeatures();
    }

    public void writeFieldValue(char c4, String str, boolean z4) {
        if (!this.quoteFieldNames) {
            write(c4);
            writeFieldName(str);
            write(z4);
            return;
        }
        int i4 = z4 ? 4 : 5;
        int length = str.length();
        int i5 = this.count + length + 4 + i4;
        if (i5 > this.buf.length) {
            if (this.writer != null) {
                write(c4);
                writeString(str);
                write(58);
                write(z4);
                return;
            }
            expandCapacity(i5);
        }
        int i6 = this.count;
        this.count = i5;
        char[] cArr = this.buf;
        cArr[i6] = c4;
        int i7 = i6 + length;
        cArr[i6 + 1] = this.keySeperator;
        str.getChars(0, length, cArr, i6 + 2);
        this.buf[i7 + 2] = this.keySeperator;
        if (z4) {
            System.arraycopy(":true".toCharArray(), 0, this.buf, i7 + 3, 5);
        } else {
            System.arraycopy(":false".toCharArray(), 0, this.buf, i7 + 3, 6);
        }
    }

    public void writeString(String str) {
        if (this.useSingleQuotes) {
            writeStringWithSingleQuote(str);
        } else {
            writeStringWithDoubleQuote(str, (char) 0);
        }
    }

    public void writeTo(OutputStream outputStream, Charset charset) throws IOException {
        writeToEx(outputStream, charset);
    }

    @Override // java.io.Writer, java.lang.Appendable
    public SerializeWriter append(CharSequence charSequence) throws IOException {
        String string = charSequence == null ? "null" : charSequence.toString();
        write(string, 0, string.length());
        return this;
    }

    @Override // java.io.Writer
    public void write(char[] cArr, int i4, int i5) throws IOException {
        int i6;
        if (i4 < 0 || i4 > cArr.length || i5 < 0 || (i6 = i4 + i5) > cArr.length || i6 < 0) {
            throw new IndexOutOfBoundsException();
        }
        if (i5 == 0) {
            return;
        }
        int i7 = this.count + i5;
        if (i7 > this.buf.length) {
            if (this.writer == null) {
                expandCapacity(i7);
            } else {
                do {
                    char[] cArr2 = this.buf;
                    int length = cArr2.length;
                    int i8 = this.count;
                    int i9 = length - i8;
                    System.arraycopy(cArr, i4, cArr2, i8, i9);
                    this.count = this.buf.length;
                    flush();
                    i5 -= i9;
                    i4 += i9;
                } while (i5 > this.buf.length);
                i7 = i5;
            }
        }
        System.arraycopy(cArr, i4, this.buf, this.count, i5);
        this.count = i7;
    }

    @Override // java.io.Writer, java.lang.Appendable
    public SerializeWriter append(CharSequence charSequence, int i4, int i5) throws IOException {
        if (charSequence == null) {
            charSequence = "null";
        }
        String string = charSequence.subSequence(i4, i5).toString();
        write(string, 0, string.length());
        return this;
    }

    @Override // java.io.Writer, java.lang.Appendable
    public SerializeWriter append(char c4) {
        write(c4);
        return this;
    }

    public SerializeWriter(int i4) {
        this((Writer) null, i4);
    }

    public SerializeWriter(Writer writer, int i4) {
        this.maxBufSize = -1;
        this.writer = writer;
        if (i4 > 0) {
            this.buf = new char[i4];
            computeFeatures();
            return;
        }
        throw new IllegalArgumentException(AbstractC0351g.m("Negative initial size: ", i4));
    }

    @Override // java.io.Writer
    public void write(String str, int i4, int i5) throws IOException {
        int i6;
        int i7 = this.count + i5;
        if (i7 > this.buf.length) {
            if (this.writer == null) {
                expandCapacity(i7);
            } else {
                while (true) {
                    char[] cArr = this.buf;
                    int length = cArr.length;
                    int i8 = this.count;
                    int i9 = length - i8;
                    i6 = i4 + i9;
                    str.getChars(i4, i6, cArr, i8);
                    this.count = this.buf.length;
                    flush();
                    i5 -= i9;
                    if (i5 <= this.buf.length) {
                        break;
                    } else {
                        i4 = i6;
                    }
                }
                i7 = i5;
                i4 = i6;
            }
        }
        str.getChars(i4, i5 + i4, this.buf, this.count);
        this.count = i7;
    }

    public void writeFieldValue(char c4, String str, int i4) throws IOException {
        if (i4 != Integer.MIN_VALUE && this.quoteFieldNames) {
            int iStringSize = i4 < 0 ? IOUtils.stringSize(-i4) + 1 : IOUtils.stringSize(i4);
            int length = str.length();
            int i5 = this.count + length + 4 + iStringSize;
            if (i5 > this.buf.length) {
                if (this.writer != null) {
                    write(c4);
                    writeFieldName(str);
                    writeInt(i4);
                    return;
                }
                expandCapacity(i5);
            }
            int i6 = this.count;
            this.count = i5;
            char[] cArr = this.buf;
            cArr[i6] = c4;
            int i7 = i6 + length;
            cArr[i6 + 1] = this.keySeperator;
            str.getChars(0, length, cArr, i6 + 2);
            char[] cArr2 = this.buf;
            cArr2[i7 + 2] = this.keySeperator;
            cArr2[i7 + 3] = CoreConstants.COLON_CHAR;
            IOUtils.getChars(i4, this.count, cArr2);
            return;
        }
        write(c4);
        writeFieldName(str);
        writeInt(i4);
    }

    @Override // java.io.Writer
    public void write(String str) {
        if (str == null) {
            writeNull();
        } else {
            write(str, 0, str.length());
        }
    }

    public void write(List<String> list) {
        int i4;
        if (list.isEmpty()) {
            write("[]");
            return;
        }
        int i5 = this.count;
        int size = list.size();
        int i6 = i5;
        int i7 = 0;
        while (i7 < size) {
            String str = list.get(i7);
            if (str != null) {
                int length = str.length();
                boolean z4 = false;
                for (int i8 = 0; i8 < length; i8++) {
                    char cCharAt = str.charAt(i8);
                    z4 = cCharAt < ' ' || cCharAt > '~' || cCharAt == '\"' || cCharAt == '\\';
                    if (z4) {
                        break;
                    }
                }
                if (!z4) {
                    int length2 = str.length() + i6;
                    int i9 = length2 + 3;
                    if (i7 == list.size() - 1) {
                        i9 = length2 + 4;
                    }
                    if (i9 > this.buf.length) {
                        this.count = i6;
                        expandCapacity(i9);
                    }
                    if (i7 == 0) {
                        i4 = i6 + 1;
                        this.buf[i6] = '[';
                    } else {
                        this.buf[i6] = ',';
                        i4 = i6 + 1;
                    }
                    int i10 = i4 + 1;
                    this.buf[i4] = '\"';
                    str.getChars(0, str.length(), this.buf, i10);
                    int length3 = str.length() + i10;
                    this.buf[length3] = '\"';
                    i7++;
                    i6 = length3 + 1;
                }
            }
            this.count = i5;
            write(91);
            for (int i11 = 0; i11 < list.size(); i11++) {
                String str2 = list.get(i11);
                if (i11 != 0) {
                    write(44);
                }
                if (str2 == null) {
                    write("null");
                } else {
                    writeStringWithDoubleQuote(str2, (char) 0);
                }
            }
            write(93);
            return;
        }
        this.buf[i6] = ']';
        this.count = i6 + 1;
    }

    public void writeFieldValue(char c4, String str, long j4) throws IOException {
        if (j4 != Long.MIN_VALUE && this.quoteFieldNames) {
            int iStringSize = j4 < 0 ? IOUtils.stringSize(-j4) + 1 : IOUtils.stringSize(j4);
            int length = str.length();
            int i4 = this.count + length + 4 + iStringSize;
            if (i4 > this.buf.length) {
                if (this.writer != null) {
                    write(c4);
                    writeFieldName(str);
                    writeLong(j4);
                    return;
                }
                expandCapacity(i4);
            }
            int i5 = this.count;
            this.count = i4;
            char[] cArr = this.buf;
            cArr[i5] = c4;
            int i6 = i5 + length;
            cArr[i5 + 1] = this.keySeperator;
            str.getChars(0, length, cArr, i5 + 2);
            char[] cArr2 = this.buf;
            cArr2[i6 + 2] = this.keySeperator;
            cArr2[i6 + 3] = CoreConstants.COLON_CHAR;
            IOUtils.getChars(j4, this.count, cArr2);
            return;
        }
        write(c4);
        writeFieldName(str);
        writeLong(j4);
    }

    public void write(boolean z4) {
        if (z4) {
            write("true");
        } else {
            write("false");
        }
    }

    public void writeFieldValue(char c4, String str, float f4) {
        write(c4);
        writeFieldName(str);
        writeFloat(f4, false);
    }

    public void writeFieldValue(char c4, String str, double d4) {
        write(c4);
        writeFieldName(str);
        writeDouble(d4, false);
    }

    public void writeFieldValue(char c4, String str, String str2) {
        if (this.quoteFieldNames) {
            if (this.useSingleQuotes) {
                write(c4);
                writeFieldName(str);
                if (str2 == null) {
                    writeNull();
                    return;
                } else {
                    writeString(str2);
                    return;
                }
            }
            if (isEnabled(SerializerFeature.BrowserCompatible)) {
                write(c4);
                writeStringWithDoubleQuote(str, CoreConstants.COLON_CHAR);
                writeStringWithDoubleQuote(str2, (char) 0);
                return;
            }
            writeFieldValueStringWithDoubleQuoteCheck(c4, str, str2);
            return;
        }
        write(c4);
        writeFieldName(str);
        if (str2 == null) {
            writeNull();
        } else {
            writeString(str2);
        }
    }

    public void writeFieldValue(char c4, String str, Enum<?> r4) throws IOException {
        if (r4 == null) {
            write(c4);
            writeFieldName(str);
            writeNull();
        } else if (this.writeEnumUsingName && !this.writeEnumUsingToString) {
            writeEnumFieldValue(c4, str, r4.name());
        } else if (this.writeEnumUsingToString) {
            writeEnumFieldValue(c4, str, r4.toString());
        } else {
            writeFieldValue(c4, str, r4.ordinal());
        }
    }

    public void writeFieldValue(char c4, String str, BigDecimal bigDecimal) {
        write(c4);
        writeFieldName(str);
        if (bigDecimal == null) {
            writeNull();
        } else {
            write(bigDecimal.toString());
        }
    }
}
