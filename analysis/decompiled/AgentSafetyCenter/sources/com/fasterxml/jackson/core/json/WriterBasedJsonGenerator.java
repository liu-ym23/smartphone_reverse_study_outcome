package com.fasterxml.jackson.core.json;

import com.fasterxml.jackson.core.Base64Variant;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonStreamContext;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.core.PrettyPrinter;
import com.fasterxml.jackson.core.SerializableString;
import com.fasterxml.jackson.core.io.CharTypes;
import com.fasterxml.jackson.core.io.IOContext;
import com.fasterxml.jackson.core.io.NumberOutput;
import com.fasterxml.jackson.databind.deser.DeserializerCache;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.io.Writer;
import java.math.BigDecimal;
import java.math.BigInteger;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public class WriterBasedJsonGenerator extends JsonGeneratorImpl {
    protected static final int SHORT_WRITE = 32;
    protected char[] _copyBuffer;
    protected SerializableString _currentEscape;
    protected char[] _entityBuffer;
    protected char[] _outputBuffer;
    protected int _outputEnd;
    protected int _outputHead;
    protected int _outputTail;
    protected char _quoteChar;
    protected final Writer _writer;
    protected static final char[] HEX_CHARS_UPPER = CharTypes.copyHexChars(true);
    protected static final char[] HEX_CHARS_LOWER = CharTypes.copyHexChars(false);

    public WriterBasedJsonGenerator(IOContext iOContext, int i, ObjectCodec objectCodec, Writer writer, char c9) {
        super(iOContext, i, objectCodec);
        this._writer = writer;
        char[] cArrAllocConcatBuffer = iOContext.allocConcatBuffer();
        this._outputBuffer = cArrAllocConcatBuffer;
        this._outputEnd = cArrAllocConcatBuffer.length;
        this._quoteChar = c9;
        boolean zIsEnabled = isEnabled(JsonWriteFeature.ESCAPE_FORWARD_SLASHES.mappedFeature());
        if (c9 != '\"' || zIsEnabled) {
            this._outputEscapes = CharTypes.get7BitOutputEscapes(c9, zIsEnabled);
        }
    }

    private char[] _allocateCopyBuffer() {
        if (this._copyBuffer == null) {
            this._copyBuffer = this._ioContext.allocNameCopyBuffer(DeserializerCache.DEFAULT_MAX_CACHE_SIZE);
        }
        return this._copyBuffer;
    }

    private char[] _allocateEntityBuffer() {
        char[] cArr = {'\\', 0, '\\', 'u', '0', '0', 0, 0, '\\', 'u', 0, 0, 0, 0};
        this._entityBuffer = cArr;
        return cArr;
    }

    private void _appendCharacterEscape(char c9, int i) throws IOException {
        String value;
        int i3;
        if (i >= 0) {
            if (this._outputTail + 2 > this._outputEnd) {
                _flushBuffer();
            }
            char[] cArr = this._outputBuffer;
            int i10 = this._outputTail;
            int i11 = i10 + 1;
            this._outputTail = i11;
            cArr[i10] = '\\';
            this._outputTail = i10 + 2;
            cArr[i11] = (char) i;
            return;
        }
        if (i == -2) {
            SerializableString serializableString = this._currentEscape;
            if (serializableString == null) {
                value = this._characterEscapes.getEscapeSequence(c9).getValue();
            } else {
                value = serializableString.getValue();
                this._currentEscape = null;
            }
            int length = value.length();
            if (this._outputTail + length > this._outputEnd) {
                _flushBuffer();
                if (length > this._outputEnd) {
                    this._writer.write(value);
                    return;
                }
            }
            value.getChars(0, length, this._outputBuffer, this._outputTail);
            this._outputTail += length;
            return;
        }
        if (this._outputTail + 5 >= this._outputEnd) {
            _flushBuffer();
        }
        int i12 = this._outputTail;
        char[] cArr2 = this._outputBuffer;
        char[] hexChars = getHexChars();
        cArr2[i12] = '\\';
        int i13 = i12 + 2;
        cArr2[i12 + 1] = 'u';
        if (c9 > 255) {
            int i14 = c9 >> '\b';
            int i15 = i12 + 3;
            cArr2[i13] = hexChars[(i14 & 255) >> 4];
            i3 = i12 + 4;
            cArr2[i15] = hexChars[i14 & 15];
            c9 = (char) (c9 & 255);
        } else {
            int i16 = i12 + 3;
            cArr2[i13] = '0';
            i3 = i12 + 4;
            cArr2[i16] = '0';
        }
        cArr2[i3] = hexChars[c9 >> 4];
        cArr2[i3 + 1] = hexChars[c9 & 15];
        this._outputTail = i3 + 2;
    }

    private void _prependOrWriteCharacterEscape(char c9, int i) throws IOException {
        String value;
        int i3;
        if (i >= 0) {
            int i10 = this._outputTail;
            if (i10 >= 2) {
                int i11 = i10 - 2;
                this._outputHead = i11;
                char[] cArr = this._outputBuffer;
                cArr[i11] = '\\';
                cArr[i10 - 1] = (char) i;
                return;
            }
            char[] cArr_allocateEntityBuffer = this._entityBuffer;
            if (cArr_allocateEntityBuffer == null) {
                cArr_allocateEntityBuffer = _allocateEntityBuffer();
            }
            this._outputHead = this._outputTail;
            cArr_allocateEntityBuffer[1] = (char) i;
            this._writer.write(cArr_allocateEntityBuffer, 0, 2);
            return;
        }
        if (i == -2) {
            SerializableString serializableString = this._currentEscape;
            if (serializableString == null) {
                value = this._characterEscapes.getEscapeSequence(c9).getValue();
            } else {
                value = serializableString.getValue();
                this._currentEscape = null;
            }
            int length = value.length();
            int i12 = this._outputTail;
            if (i12 < length) {
                this._outputHead = i12;
                this._writer.write(value);
                return;
            } else {
                int i13 = i12 - length;
                this._outputHead = i13;
                value.getChars(0, length, this._outputBuffer, i13);
                return;
            }
        }
        char[] hexChars = getHexChars();
        int i14 = this._outputTail;
        if (i14 < 6) {
            char[] cArr_allocateEntityBuffer2 = this._entityBuffer;
            if (cArr_allocateEntityBuffer2 == null) {
                cArr_allocateEntityBuffer2 = _allocateEntityBuffer();
            }
            this._outputHead = this._outputTail;
            if (c9 <= 255) {
                cArr_allocateEntityBuffer2[6] = hexChars[c9 >> 4];
                cArr_allocateEntityBuffer2[7] = hexChars[c9 & 15];
                this._writer.write(cArr_allocateEntityBuffer2, 2, 6);
                return;
            } else {
                int i15 = c9 >> '\b';
                cArr_allocateEntityBuffer2[10] = hexChars[(i15 & 255) >> 4];
                cArr_allocateEntityBuffer2[11] = hexChars[i15 & 15];
                cArr_allocateEntityBuffer2[12] = hexChars[(c9 & 255) >> 4];
                cArr_allocateEntityBuffer2[13] = hexChars[c9 & 15];
                this._writer.write(cArr_allocateEntityBuffer2, 8, 6);
                return;
            }
        }
        char[] cArr2 = this._outputBuffer;
        int i16 = i14 - 6;
        this._outputHead = i16;
        cArr2[i16] = '\\';
        cArr2[i14 - 5] = 'u';
        if (c9 > 255) {
            int i17 = c9 >> '\b';
            cArr2[i14 - 4] = hexChars[(i17 & 255) >> 4];
            i3 = i14 - 3;
            cArr2[i3] = hexChars[i17 & 15];
            c9 = (char) (c9 & 255);
        } else {
            cArr2[i14 - 4] = '0';
            i3 = i14 - 3;
            cArr2[i3] = '0';
        }
        cArr2[i3 + 1] = hexChars[c9 >> 4];
        cArr2[i3 + 2] = hexChars[c9 & 15];
    }

    private int _readMore(InputStream inputStream, byte[] bArr, int i, int i3, int i10) {
        int i11;
        int i12 = 0;
        while (i < i3) {
            bArr[i12] = bArr[i];
            i12++;
            i++;
        }
        int iMin = Math.min(i10, bArr.length);
        do {
            int i13 = iMin - i12;
            if (i13 == 0 || (i11 = inputStream.read(bArr, i12, i13)) < 0) {
                return i12;
            }
            i12 += i11;
        } while (i12 < 3);
        return i12;
    }

    private void _writeLongString(String str) throws IOException {
        _flushBuffer();
        int length = str.length();
        int i = 0;
        while (true) {
            int i3 = this._outputEnd;
            if (i + i3 > length) {
                i3 = length - i;
            }
            int i10 = i + i3;
            str.getChars(i, i10, this._outputBuffer, 0);
            if (this._characterEscapes != null) {
                _writeSegmentCustom(i3);
            } else {
                int i11 = this._maximumNonEscapedChar;
                if (i11 != 0) {
                    _writeSegmentASCII(i3, i11);
                } else {
                    _writeSegment(i3);
                }
            }
            if (i10 >= length) {
                return;
            } else {
                i = i10;
            }
        }
    }

    private final void _writeNull() throws IOException {
        if (this._outputTail + 4 >= this._outputEnd) {
            _flushBuffer();
        }
        int i = this._outputTail;
        char[] cArr = this._outputBuffer;
        cArr[i] = 'n';
        cArr[i + 1] = 'u';
        cArr[i + 2] = 'l';
        cArr[i + 3] = 'l';
        this._outputTail = i + 4;
    }

    private void _writeQuotedInt(int i) throws IOException {
        if (this._outputTail + 13 >= this._outputEnd) {
            _flushBuffer();
        }
        char[] cArr = this._outputBuffer;
        int i3 = this._outputTail;
        int i10 = i3 + 1;
        this._outputTail = i10;
        cArr[i3] = this._quoteChar;
        int iOutputInt = NumberOutput.outputInt(i, cArr, i10);
        char[] cArr2 = this._outputBuffer;
        this._outputTail = iOutputInt + 1;
        cArr2[iOutputInt] = this._quoteChar;
    }

    private void _writeQuotedLong(long j10) throws IOException {
        if (this._outputTail + 23 >= this._outputEnd) {
            _flushBuffer();
        }
        char[] cArr = this._outputBuffer;
        int i = this._outputTail;
        int i3 = i + 1;
        this._outputTail = i3;
        cArr[i] = this._quoteChar;
        int iOutputLong = NumberOutput.outputLong(j10, cArr, i3);
        char[] cArr2 = this._outputBuffer;
        this._outputTail = iOutputLong + 1;
        cArr2[iOutputLong] = this._quoteChar;
    }

    private void _writeQuotedRaw(String str) throws IOException {
        if (this._outputTail >= this._outputEnd) {
            _flushBuffer();
        }
        char[] cArr = this._outputBuffer;
        int i = this._outputTail;
        this._outputTail = i + 1;
        cArr[i] = this._quoteChar;
        writeRaw(str);
        if (this._outputTail >= this._outputEnd) {
            _flushBuffer();
        }
        char[] cArr2 = this._outputBuffer;
        int i3 = this._outputTail;
        this._outputTail = i3 + 1;
        cArr2[i3] = this._quoteChar;
    }

    private void _writeQuotedShort(short s6) throws IOException {
        if (this._outputTail + 8 >= this._outputEnd) {
            _flushBuffer();
        }
        char[] cArr = this._outputBuffer;
        int i = this._outputTail;
        int i3 = i + 1;
        this._outputTail = i3;
        cArr[i] = this._quoteChar;
        int iOutputInt = NumberOutput.outputInt(s6, cArr, i3);
        char[] cArr2 = this._outputBuffer;
        this._outputTail = iOutputInt + 1;
        cArr2[iOutputInt] = this._quoteChar;
    }

    private void _writeSegment(int i) throws IOException {
        char[] cArr;
        char c9;
        int[] iArr = this._outputEscapes;
        int length = iArr.length;
        int i3 = 0;
        int i_prependOrWriteCharacterEscape = 0;
        while (i3 < i) {
            do {
                cArr = this._outputBuffer;
                c9 = cArr[i3];
                if (c9 < length && iArr[c9] != 0) {
                    break;
                } else {
                    i3++;
                }
            } while (i3 < i);
            int i10 = i3 - i_prependOrWriteCharacterEscape;
            if (i10 > 0) {
                this._writer.write(cArr, i_prependOrWriteCharacterEscape, i10);
                if (i3 >= i) {
                    return;
                }
            }
            int i11 = i3 + 1;
            i_prependOrWriteCharacterEscape = _prependOrWriteCharacterEscape(this._outputBuffer, i11, i, c9, iArr[c9]);
            i3 = i11;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x001e A[PHI: r4
      0x001e: PHI (r4v7 int) = (r4v2 int), (r4v8 int) binds: [B:9:0x001a, B:7:0x0016] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void _writeSegmentASCII(int r13, int r14) throws java.io.IOException {
        /*
            r12 = this;
            int[] r0 = r12._outputEscapes
            int r1 = r0.length
            int r2 = r14 + 1
            int r1 = java.lang.Math.min(r1, r2)
            r2 = 0
            r3 = r2
            r4 = r3
        Lc:
            if (r2 >= r13) goto L3c
        Le:
            char[] r5 = r12._outputBuffer
            char r10 = r5[r2]
            if (r10 >= r1) goto L1a
            r4 = r0[r10]
            if (r4 == 0) goto L1e
        L18:
            r11 = r4
            goto L23
        L1a:
            if (r10 <= r14) goto L1e
            r4 = -1
            goto L18
        L1e:
            int r2 = r2 + 1
            if (r2 < r13) goto Le
            goto L18
        L23:
            int r4 = r2 - r3
            if (r4 <= 0) goto L2f
            java.io.Writer r6 = r12._writer
            r6.write(r5, r3, r4)
            if (r2 < r13) goto L2f
            goto L3c
        L2f:
            int r8 = r2 + 1
            char[] r7 = r12._outputBuffer
            r6 = r12
            r9 = r13
            int r3 = r6._prependOrWriteCharacterEscape(r7, r8, r9, r10, r11)
            r2 = r8
            r4 = r11
            goto Lc
        L3c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.core.json.WriterBasedJsonGenerator._writeSegmentASCII(int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0032 A[PHI: r6
      0x0032: PHI (r6v8 int) = (r6v2 int), (r6v9 int) binds: [B:15:0x002e, B:10:0x0020] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void _writeSegmentCustom(int r15) throws java.io.IOException {
        /*
            r14 = this;
            int[] r0 = r14._outputEscapes
            int r1 = r14._maximumNonEscapedChar
            r2 = 1
            if (r1 >= r2) goto La
            r1 = 65535(0xffff, float:9.1834E-41)
        La:
            int r2 = r0.length
            int r3 = r1 + 1
            int r2 = java.lang.Math.min(r2, r3)
            com.fasterxml.jackson.core.io.CharacterEscapes r3 = r14._characterEscapes
            r4 = 0
            r5 = r4
            r6 = r5
        L16:
            if (r4 >= r15) goto L52
        L18:
            char[] r7 = r14._outputBuffer
            char r12 = r7[r4]
            if (r12 >= r2) goto L24
            r6 = r0[r12]
            if (r6 == 0) goto L32
        L22:
            r13 = r6
            goto L37
        L24:
            if (r12 <= r1) goto L28
            r6 = -1
            goto L22
        L28:
            com.fasterxml.jackson.core.SerializableString r7 = r3.getEscapeSequence(r12)
            r14._currentEscape = r7
            if (r7 == 0) goto L32
            r6 = -2
            goto L22
        L32:
            int r4 = r4 + 1
            if (r4 < r15) goto L18
            goto L22
        L37:
            int r6 = r4 - r5
            if (r6 <= 0) goto L45
            java.io.Writer r7 = r14._writer
            char[] r8 = r14._outputBuffer
            r7.write(r8, r5, r6)
            if (r4 < r15) goto L45
            goto L52
        L45:
            int r10 = r4 + 1
            char[] r9 = r14._outputBuffer
            r8 = r14
            r11 = r15
            int r5 = r8._prependOrWriteCharacterEscape(r9, r10, r11, r12, r13)
            r4 = r10
            r6 = r13
            goto L16
        L52:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.core.json.WriterBasedJsonGenerator._writeSegmentCustom(int):void");
    }

    private void _writeString(char[] cArr, int i, int i3) throws IOException {
        if (this._characterEscapes != null) {
            _writeStringCustom(cArr, i, i3);
            return;
        }
        int i10 = this._maximumNonEscapedChar;
        if (i10 != 0) {
            _writeStringASCII(cArr, i, i3, i10);
            return;
        }
        int i11 = i3 + i;
        int[] iArr = this._outputEscapes;
        int length = iArr.length;
        while (i < i11) {
            int i12 = i;
            do {
                char c9 = cArr[i12];
                if (c9 < length && iArr[c9] != 0) {
                    break;
                } else {
                    i12++;
                }
            } while (i12 < i11);
            int i13 = i12 - i;
            if (i13 < 32) {
                if (this._outputTail + i13 > this._outputEnd) {
                    _flushBuffer();
                }
                if (i13 > 0) {
                    System.arraycopy(cArr, i, this._outputBuffer, this._outputTail, i13);
                    this._outputTail += i13;
                }
            } else {
                _flushBuffer();
                this._writer.write(cArr, i, i13);
            }
            if (i12 >= i11) {
                return;
            }
            i = i12 + 1;
            char c10 = cArr[i12];
            _appendCharacterEscape(c10, iArr[c10]);
        }
    }

    private void _writeString2(SerializableString serializableString) throws IOException {
        char[] cArrAsQuotedChars = serializableString.asQuotedChars();
        int length = cArrAsQuotedChars.length;
        if (length < 32) {
            if (length > this._outputEnd - this._outputTail) {
                _flushBuffer();
            }
            System.arraycopy(cArrAsQuotedChars, 0, this._outputBuffer, this._outputTail, length);
            this._outputTail += length;
        } else {
            _flushBuffer();
            this._writer.write(cArrAsQuotedChars, 0, length);
        }
        if (this._outputTail >= this._outputEnd) {
            _flushBuffer();
        }
        char[] cArr = this._outputBuffer;
        int i = this._outputTail;
        this._outputTail = i + 1;
        cArr[i] = this._quoteChar;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x001b A[PHI: r2
      0x001b: PHI (r2v6 int) = (r2v3 int), (r2v7 int) binds: [B:10:0x0017, B:8:0x0014] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void _writeStringASCII(char[] r9, int r10, int r11, int r12) throws java.io.IOException {
        /*
            r8 = this;
            int r11 = r11 + r10
            int[] r0 = r8._outputEscapes
            int r1 = r0.length
            int r2 = r12 + 1
            int r1 = java.lang.Math.min(r1, r2)
            r2 = 0
        Lb:
            if (r10 >= r11) goto L4f
            r3 = r10
        Le:
            char r4 = r9[r3]
            if (r4 >= r1) goto L17
            r2 = r0[r4]
            if (r2 == 0) goto L1b
            goto L1f
        L17:
            if (r4 <= r12) goto L1b
            r2 = -1
            goto L1f
        L1b:
            int r3 = r3 + 1
            if (r3 < r11) goto Le
        L1f:
            int r5 = r3 - r10
            r6 = 32
            if (r5 >= r6) goto L3e
            int r6 = r8._outputTail
            int r6 = r6 + r5
            int r7 = r8._outputEnd
            if (r6 <= r7) goto L2f
            r8._flushBuffer()
        L2f:
            if (r5 <= 0) goto L46
            char[] r6 = r8._outputBuffer
            int r7 = r8._outputTail
            java.lang.System.arraycopy(r9, r10, r6, r7, r5)
            int r10 = r8._outputTail
            int r10 = r10 + r5
            r8._outputTail = r10
            goto L46
        L3e:
            r8._flushBuffer()
            java.io.Writer r6 = r8._writer
            r6.write(r9, r10, r5)
        L46:
            if (r3 < r11) goto L49
            goto L4f
        L49:
            int r10 = r3 + 1
            r8._appendCharacterEscape(r4, r2)
            goto Lb
        L4f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.core.json.WriterBasedJsonGenerator._writeStringASCII(char[], int, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x002f A[PHI: r4
      0x002f: PHI (r4v6 int) = (r4v2 int), (r4v7 int) binds: [B:16:0x002b, B:11:0x001e] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void _writeStringCustom(char[] r11, int r12, int r13) throws java.io.IOException {
        /*
            r10 = this;
            int r13 = r13 + r12
            int[] r0 = r10._outputEscapes
            int r1 = r10._maximumNonEscapedChar
            r2 = 1
            if (r1 >= r2) goto Lb
            r1 = 65535(0xffff, float:9.1834E-41)
        Lb:
            int r2 = r0.length
            int r3 = r1 + 1
            int r2 = java.lang.Math.min(r2, r3)
            com.fasterxml.jackson.core.io.CharacterEscapes r3 = r10._characterEscapes
            r4 = 0
        L15:
            if (r12 >= r13) goto L63
            r5 = r12
        L18:
            char r6 = r11[r5]
            if (r6 >= r2) goto L21
            r4 = r0[r6]
            if (r4 == 0) goto L2f
            goto L33
        L21:
            if (r6 <= r1) goto L25
            r4 = -1
            goto L33
        L25:
            com.fasterxml.jackson.core.SerializableString r7 = r3.getEscapeSequence(r6)
            r10._currentEscape = r7
            if (r7 == 0) goto L2f
            r4 = -2
            goto L33
        L2f:
            int r5 = r5 + 1
            if (r5 < r13) goto L18
        L33:
            int r7 = r5 - r12
            r8 = 32
            if (r7 >= r8) goto L52
            int r8 = r10._outputTail
            int r8 = r8 + r7
            int r9 = r10._outputEnd
            if (r8 <= r9) goto L43
            r10._flushBuffer()
        L43:
            if (r7 <= 0) goto L5a
            char[] r8 = r10._outputBuffer
            int r9 = r10._outputTail
            java.lang.System.arraycopy(r11, r12, r8, r9, r7)
            int r12 = r10._outputTail
            int r12 = r12 + r7
            r10._outputTail = r12
            goto L5a
        L52:
            r10._flushBuffer()
            java.io.Writer r8 = r10._writer
            r8.write(r11, r12, r7)
        L5a:
            if (r5 < r13) goto L5d
            goto L63
        L5d:
            int r12 = r5 + 1
            r10._appendCharacterEscape(r6, r4)
            goto L15
        L63:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.core.json.WriterBasedJsonGenerator._writeStringCustom(char[], int, int):void");
    }

    private char[] getHexChars() {
        return this._cfgWriteHexUppercase ? HEX_CHARS_UPPER : HEX_CHARS_LOWER;
    }

    private void writeRawLong(String str) throws IOException {
        int i = this._outputEnd;
        int i3 = this._outputTail;
        int i10 = i - i3;
        str.getChars(0, i10, this._outputBuffer, i3);
        this._outputTail += i10;
        _flushBuffer();
        int length = str.length() - i10;
        while (true) {
            int i11 = this._outputEnd;
            char[] cArr = this._outputBuffer;
            if (length <= i11) {
                str.getChars(i10, i10 + length, cArr, 0);
                this._outputHead = 0;
                this._outputTail = length;
                return;
            } else {
                int i12 = i10 + i11;
                str.getChars(i10, i12, cArr, 0);
                this._outputHead = 0;
                this._outputTail = i11;
                _flushBuffer();
                length -= i11;
                i10 = i12;
            }
        }
    }

    public void _flushBuffer() throws IOException {
        int i = this._outputTail;
        int i3 = this._outputHead;
        int i10 = i - i3;
        if (i10 > 0) {
            this._outputHead = 0;
            this._outputTail = 0;
            this._writer.write(this._outputBuffer, i3, i10);
        }
    }

    @Override // com.fasterxml.jackson.core.base.GeneratorBase
    public void _releaseBuffers() {
        char[] cArr = this._outputBuffer;
        if (cArr != null) {
            this._outputBuffer = null;
            this._ioContext.releaseConcatBuffer(cArr);
        }
        char[] cArr2 = this._copyBuffer;
        if (cArr2 != null) {
            this._copyBuffer = null;
            this._ioContext.releaseNameCopyBuffer(cArr2);
        }
    }

    @Override // com.fasterxml.jackson.core.base.GeneratorBase
    public void _verifyValueWrite(String str) throws IOException {
        char c9;
        int iWriteValue = this._writeContext.writeValue();
        if (this._cfgPrettyPrinter != null) {
            _verifyPrettyValueWrite(str, iWriteValue);
            return;
        }
        if (iWriteValue == 1) {
            c9 = ',';
        } else {
            if (iWriteValue != 2) {
                if (iWriteValue != 3) {
                    if (iWriteValue != 5) {
                        return;
                    }
                    _reportCantWriteValueExpectName(str);
                    return;
                } else {
                    SerializableString serializableString = this._rootValueSeparator;
                    if (serializableString != null) {
                        writeRaw(serializableString.getValue());
                        return;
                    }
                    return;
                }
            }
            c9 = ':';
        }
        if (this._outputTail >= this._outputEnd) {
            _flushBuffer();
        }
        char[] cArr = this._outputBuffer;
        int i = this._outputTail;
        this._outputTail = i + 1;
        cArr[i] = c9;
    }

    public int _writeBinary(Base64Variant base64Variant, InputStream inputStream, byte[] bArr, int i) throws IOException {
        WriterBasedJsonGenerator writerBasedJsonGenerator;
        InputStream inputStream2;
        byte[] bArr2;
        int i_readMore;
        int i3 = this._outputEnd - 6;
        int i10 = 2;
        int maxLineLength = base64Variant.getMaxLineLength() >> 2;
        int i11 = -3;
        int i12 = i;
        int i13 = 0;
        int i_readMore2 = 0;
        while (true) {
            if (i12 <= 2) {
                writerBasedJsonGenerator = this;
                inputStream2 = inputStream;
                bArr2 = bArr;
                break;
            }
            writerBasedJsonGenerator = this;
            inputStream2 = inputStream;
            bArr2 = bArr;
            if (i13 > i11) {
                i_readMore2 = writerBasedJsonGenerator._readMore(inputStream2, bArr2, i13, i_readMore2, i12);
                if (i_readMore2 < 3) {
                    i13 = 0;
                    break;
                }
                i11 = i_readMore2 - 3;
                i13 = 0;
            }
            if (writerBasedJsonGenerator._outputTail > i3) {
                writerBasedJsonGenerator._flushBuffer();
            }
            int i14 = i13 + 2;
            int i15 = ((bArr2[i13 + 1] & 255) | (bArr2[i13] << 8)) << 8;
            i13 += 3;
            i12 -= 3;
            int iEncodeBase64Chunk = base64Variant.encodeBase64Chunk(i15 | (bArr2[i14] & 255), writerBasedJsonGenerator._outputBuffer, writerBasedJsonGenerator._outputTail);
            writerBasedJsonGenerator._outputTail = iEncodeBase64Chunk;
            maxLineLength--;
            if (maxLineLength <= 0) {
                char[] cArr = writerBasedJsonGenerator._outputBuffer;
                int i16 = iEncodeBase64Chunk + 1;
                writerBasedJsonGenerator._outputTail = i16;
                cArr[iEncodeBase64Chunk] = '\\';
                writerBasedJsonGenerator._outputTail = iEncodeBase64Chunk + 2;
                cArr[i16] = 'n';
                maxLineLength = base64Variant.getMaxLineLength() >> 2;
            }
            this = writerBasedJsonGenerator;
            inputStream = inputStream2;
            bArr = bArr2;
        }
        if (i12 <= 0 || (i_readMore = writerBasedJsonGenerator._readMore(inputStream2, bArr2, i13, i_readMore2, i12)) <= 0) {
            return i12;
        }
        if (writerBasedJsonGenerator._outputTail > i3) {
            writerBasedJsonGenerator._flushBuffer();
        }
        int i17 = bArr2[0] << 16;
        if (1 < i_readMore) {
            i17 |= (bArr2[1] & 255) << 8;
        } else {
            i10 = 1;
        }
        writerBasedJsonGenerator._outputTail = base64Variant.encodeBase64Partial(i17, i10, writerBasedJsonGenerator._outputBuffer, writerBasedJsonGenerator._outputTail);
        return i12 - i10;
    }

    public void _writeFieldName(SerializableString serializableString, boolean z10) throws IOException {
        if (this._cfgPrettyPrinter != null) {
            _writePPFieldName(serializableString, z10);
            return;
        }
        if (this._outputTail + 1 >= this._outputEnd) {
            _flushBuffer();
        }
        if (z10) {
            char[] cArr = this._outputBuffer;
            int i = this._outputTail;
            this._outputTail = i + 1;
            cArr[i] = ',';
        }
        if (this._cfgUnqNames) {
            char[] cArrAsQuotedChars = serializableString.asQuotedChars();
            writeRaw(cArrAsQuotedChars, 0, cArrAsQuotedChars.length);
            return;
        }
        char[] cArr2 = this._outputBuffer;
        int i3 = this._outputTail;
        int i10 = i3 + 1;
        this._outputTail = i10;
        cArr2[i3] = this._quoteChar;
        int iAppendQuoted = serializableString.appendQuoted(cArr2, i10);
        if (iAppendQuoted < 0) {
            _writeFieldNameTail(serializableString);
            return;
        }
        int i11 = this._outputTail + iAppendQuoted;
        this._outputTail = i11;
        if (i11 >= this._outputEnd) {
            _flushBuffer();
        }
        char[] cArr3 = this._outputBuffer;
        int i12 = this._outputTail;
        this._outputTail = i12 + 1;
        cArr3[i12] = this._quoteChar;
    }

    public void _writeFieldNameTail(SerializableString serializableString) throws IOException {
        char[] cArrAsQuotedChars = serializableString.asQuotedChars();
        writeRaw(cArrAsQuotedChars, 0, cArrAsQuotedChars.length);
        if (this._outputTail >= this._outputEnd) {
            _flushBuffer();
        }
        char[] cArr = this._outputBuffer;
        int i = this._outputTail;
        this._outputTail = i + 1;
        cArr[i] = this._quoteChar;
    }

    public void _writePPFieldName(SerializableString serializableString, boolean z10) throws IOException {
        PrettyPrinter prettyPrinter = this._cfgPrettyPrinter;
        if (z10) {
            prettyPrinter.writeObjectEntrySeparator(this);
        } else {
            prettyPrinter.beforeObjectEntries(this);
        }
        char[] cArrAsQuotedChars = serializableString.asQuotedChars();
        if (this._cfgUnqNames) {
            writeRaw(cArrAsQuotedChars, 0, cArrAsQuotedChars.length);
            return;
        }
        if (this._outputTail >= this._outputEnd) {
            _flushBuffer();
        }
        char[] cArr = this._outputBuffer;
        int i = this._outputTail;
        this._outputTail = i + 1;
        cArr[i] = this._quoteChar;
        writeRaw(cArrAsQuotedChars, 0, cArrAsQuotedChars.length);
        if (this._outputTail >= this._outputEnd) {
            _flushBuffer();
        }
        char[] cArr2 = this._outputBuffer;
        int i3 = this._outputTail;
        this._outputTail = i3 + 1;
        cArr2[i3] = this._quoteChar;
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public boolean canWriteFormattedNumbers() {
        return true;
    }

    @Override // com.fasterxml.jackson.core.base.GeneratorBase, com.fasterxml.jackson.core.JsonGenerator, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws Throwable {
        super.close();
        try {
            if (this._outputBuffer != null && isEnabled(JsonGenerator.Feature.AUTO_CLOSE_JSON_CONTENT)) {
                while (true) {
                    JsonStreamContext outputContext = getOutputContext();
                    if (!outputContext.inArray()) {
                        if (!outputContext.inObject()) {
                            break;
                        } else {
                            writeEndObject();
                        }
                    } else {
                        writeEndArray();
                    }
                }
            }
            _flushBuffer();
            e = null;
        } catch (IOException e10) {
            e = e10;
        }
        this._outputHead = 0;
        this._outputTail = 0;
        if (this._writer != null) {
            try {
                if (this._ioContext.isResourceManaged() || isEnabled(JsonGenerator.Feature.AUTO_CLOSE_TARGET)) {
                    this._writer.close();
                } else if (isEnabled(JsonGenerator.Feature.FLUSH_PASSED_TO_STREAM)) {
                    this._writer.flush();
                }
            } catch (IOException | RuntimeException e11) {
                if (e != null) {
                    e11.addSuppressed(e);
                }
                throw e11;
            }
        }
        _releaseBuffers();
        if (e != null) {
            throw e;
        }
    }

    @Override // com.fasterxml.jackson.core.base.GeneratorBase, com.fasterxml.jackson.core.JsonGenerator, java.io.Flushable
    public void flush() throws IOException {
        _flushBuffer();
        if (this._writer == null || !isEnabled(JsonGenerator.Feature.FLUSH_PASSED_TO_STREAM)) {
            return;
        }
        this._writer.flush();
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public int getOutputBuffered() {
        return Math.max(0, this._outputTail - this._outputHead);
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public Object getOutputTarget() {
        return this._writer;
    }

    @Override // com.fasterxml.jackson.core.base.GeneratorBase, com.fasterxml.jackson.core.JsonGenerator
    public int writeBinary(Base64Variant base64Variant, InputStream inputStream, int i) throws IOException {
        _verifyValueWrite("write a binary value");
        if (this._outputTail >= this._outputEnd) {
            _flushBuffer();
        }
        char[] cArr = this._outputBuffer;
        int i3 = this._outputTail;
        this._outputTail = i3 + 1;
        cArr[i3] = this._quoteChar;
        byte[] bArrAllocBase64Buffer = this._ioContext.allocBase64Buffer();
        try {
            if (i < 0) {
                i = _writeBinary(base64Variant, inputStream, bArrAllocBase64Buffer);
            } else {
                int i_writeBinary = _writeBinary(base64Variant, inputStream, bArrAllocBase64Buffer, i);
                if (i_writeBinary > 0) {
                    _reportError("Too few bytes available: missing " + i_writeBinary + " bytes (out of " + i + ")");
                }
            }
            this._ioContext.releaseBase64Buffer(bArrAllocBase64Buffer);
            if (this._outputTail >= this._outputEnd) {
                _flushBuffer();
            }
            char[] cArr2 = this._outputBuffer;
            int i10 = this._outputTail;
            this._outputTail = i10 + 1;
            cArr2[i10] = this._quoteChar;
            return i;
        } catch (Throwable th) {
            this._ioContext.releaseBase64Buffer(bArrAllocBase64Buffer);
            throw th;
        }
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void writeBoolean(boolean z10) throws IOException {
        int i;
        _verifyValueWrite("write a boolean value");
        if (this._outputTail + 5 >= this._outputEnd) {
            _flushBuffer();
        }
        int i3 = this._outputTail;
        char[] cArr = this._outputBuffer;
        if (z10) {
            cArr[i3] = 't';
            cArr[i3 + 1] = 'r';
            cArr[i3 + 2] = 'u';
            i = i3 + 3;
            cArr[i] = 'e';
        } else {
            cArr[i3] = 'f';
            cArr[i3 + 1] = 'a';
            cArr[i3 + 2] = 'l';
            cArr[i3 + 3] = 's';
            i = i3 + 4;
            cArr[i] = 'e';
        }
        this._outputTail = i + 1;
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void writeEndArray() throws IOException {
        if (!this._writeContext.inArray()) {
            _reportError("Current context not Array but " + this._writeContext.typeDesc());
        }
        PrettyPrinter prettyPrinter = this._cfgPrettyPrinter;
        if (prettyPrinter != null) {
            prettyPrinter.writeEndArray(this, this._writeContext.getEntryCount());
        } else {
            if (this._outputTail >= this._outputEnd) {
                _flushBuffer();
            }
            char[] cArr = this._outputBuffer;
            int i = this._outputTail;
            this._outputTail = i + 1;
            cArr[i] = ']';
        }
        this._writeContext = this._writeContext.clearAndGetParent();
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void writeEndObject() throws IOException {
        if (!this._writeContext.inObject()) {
            _reportError("Current context not Object but " + this._writeContext.typeDesc());
        }
        PrettyPrinter prettyPrinter = this._cfgPrettyPrinter;
        if (prettyPrinter != null) {
            prettyPrinter.writeEndObject(this, this._writeContext.getEntryCount());
        } else {
            if (this._outputTail >= this._outputEnd) {
                _flushBuffer();
            }
            char[] cArr = this._outputBuffer;
            int i = this._outputTail;
            this._outputTail = i + 1;
            cArr[i] = '}';
        }
        this._writeContext = this._writeContext.clearAndGetParent();
    }

    @Override // com.fasterxml.jackson.core.base.GeneratorBase, com.fasterxml.jackson.core.JsonGenerator
    public void writeFieldName(SerializableString serializableString) throws IOException {
        int iWriteFieldName = this._writeContext.writeFieldName(serializableString.getValue());
        if (iWriteFieldName == 4) {
            _reportError("Can not write a field name, expecting a value");
        }
        _writeFieldName(serializableString, iWriteFieldName == 1);
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void writeNull() throws IOException {
        _verifyValueWrite("write a null");
        _writeNull();
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void writeNumber(double d7) throws IOException {
        if (this._cfgNumbersAsStrings || (NumberOutput.notFinite(d7) && isEnabled(JsonGenerator.Feature.QUOTE_NON_NUMERIC_NUMBERS))) {
            writeString(NumberOutput.toString(d7, isEnabled(JsonGenerator.Feature.USE_FAST_DOUBLE_WRITER)));
        } else {
            _verifyValueWrite("write a number");
            writeRaw(NumberOutput.toString(d7, isEnabled(JsonGenerator.Feature.USE_FAST_DOUBLE_WRITER)));
        }
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void writeRaw(String str, int i, int i3) throws IOException {
        _checkRangeBoundsForString(str, i, i3);
        int i10 = this._outputEnd - this._outputTail;
        if (i10 < i3) {
            _flushBuffer();
            i10 = this._outputEnd - this._outputTail;
        }
        if (i10 < i3) {
            writeRawLong(str.substring(i, i3 + i));
        } else {
            str.getChars(i, i + i3, this._outputBuffer, this._outputTail);
            this._outputTail += i3;
        }
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void writeRawUTF8String(byte[] bArr, int i, int i3) {
        _reportUnsupportedOperation();
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void writeStartArray() throws IOException {
        _verifyValueWrite("start an array");
        this._writeContext = this._writeContext.createChildArrayContext();
        streamWriteConstraints().validateNestingDepth(this._writeContext.getNestingDepth());
        PrettyPrinter prettyPrinter = this._cfgPrettyPrinter;
        if (prettyPrinter != null) {
            prettyPrinter.writeStartArray(this);
            return;
        }
        if (this._outputTail >= this._outputEnd) {
            _flushBuffer();
        }
        char[] cArr = this._outputBuffer;
        int i = this._outputTail;
        this._outputTail = i + 1;
        cArr[i] = '[';
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void writeStartObject() throws IOException {
        _verifyValueWrite("start an object");
        this._writeContext = this._writeContext.createChildObjectContext();
        streamWriteConstraints().validateNestingDepth(this._writeContext.getNestingDepth());
        PrettyPrinter prettyPrinter = this._cfgPrettyPrinter;
        if (prettyPrinter != null) {
            prettyPrinter.writeStartObject(this);
            return;
        }
        if (this._outputTail >= this._outputEnd) {
            _flushBuffer();
        }
        char[] cArr = this._outputBuffer;
        int i = this._outputTail;
        this._outputTail = i + 1;
        cArr[i] = '{';
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void writeString(Reader reader, int i) throws IOException {
        _verifyValueWrite("write a string");
        if (reader == null) {
            _reportError("null reader");
            return;
        }
        int i3 = i >= 0 ? i : com.google.crypto.tink.shaded.protobuf.Reader.READ_DONE;
        if (this._outputTail >= this._outputEnd) {
            _flushBuffer();
        }
        char[] cArr = this._outputBuffer;
        int i10 = this._outputTail;
        this._outputTail = i10 + 1;
        cArr[i10] = this._quoteChar;
        char[] cArr_allocateCopyBuffer = _allocateCopyBuffer();
        while (i3 > 0) {
            int i11 = reader.read(cArr_allocateCopyBuffer, 0, Math.min(i3, cArr_allocateCopyBuffer.length));
            if (i11 <= 0) {
                break;
            }
            _writeString(cArr_allocateCopyBuffer, 0, i11);
            i3 -= i11;
        }
        if (this._outputTail >= this._outputEnd) {
            _flushBuffer();
        }
        char[] cArr2 = this._outputBuffer;
        int i12 = this._outputTail;
        this._outputTail = i12 + 1;
        cArr2[i12] = this._quoteChar;
        if (i3 <= 0 || i < 0) {
            return;
        }
        _reportError("Didn't read enough from reader");
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void writeUTF8String(byte[] bArr, int i, int i3) {
        _reportUnsupportedOperation();
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void writeFieldName(String str) throws IOException {
        int iWriteFieldName = this._writeContext.writeFieldName(str);
        if (iWriteFieldName == 4) {
            _reportError("Can not write a field name, expecting a value");
        }
        _writeFieldName(str, iWriteFieldName == 1);
    }

    @Deprecated
    public WriterBasedJsonGenerator(IOContext iOContext, int i, ObjectCodec objectCodec, Writer writer) {
        this(iOContext, i, objectCodec, writer, JsonFactory.DEFAULT_QUOTE_CHAR);
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void writeRaw(String str) throws IOException {
        int length = str.length();
        int i = this._outputEnd - this._outputTail;
        if (i == 0) {
            _flushBuffer();
            i = this._outputEnd - this._outputTail;
        }
        if (i >= length) {
            str.getChars(0, length, this._outputBuffer, this._outputTail);
            this._outputTail += length;
        } else {
            writeRawLong(str);
        }
    }

    private void _writeQuotedRaw(char[] cArr, int i, int i3) throws IOException {
        if (this._outputTail >= this._outputEnd) {
            _flushBuffer();
        }
        char[] cArr2 = this._outputBuffer;
        int i10 = this._outputTail;
        this._outputTail = i10 + 1;
        cArr2[i10] = this._quoteChar;
        writeRaw(cArr, i, i3);
        if (this._outputTail >= this._outputEnd) {
            _flushBuffer();
        }
        char[] cArr3 = this._outputBuffer;
        int i11 = this._outputTail;
        this._outputTail = i11 + 1;
        cArr3[i11] = this._quoteChar;
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void writeRaw(SerializableString serializableString) throws IOException {
        int iAppendUnquoted = serializableString.appendUnquoted(this._outputBuffer, this._outputTail);
        if (iAppendUnquoted < 0) {
            writeRaw(serializableString.getValue());
        } else {
            this._outputTail += iAppendUnquoted;
        }
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void writeNumber(int i) throws IOException {
        _verifyValueWrite("write a number");
        if (this._cfgNumbersAsStrings) {
            _writeQuotedInt(i);
            return;
        }
        if (this._outputTail + 11 >= this._outputEnd) {
            _flushBuffer();
        }
        this._outputTail = NumberOutput.outputInt(i, this._outputBuffer, this._outputTail);
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void writeRaw(char[] cArr, int i, int i3) throws IOException {
        _checkRangeBoundsForCharArray(cArr, i, i3);
        if (i3 < 32) {
            if (i3 > this._outputEnd - this._outputTail) {
                _flushBuffer();
            }
            System.arraycopy(cArr, i, this._outputBuffer, this._outputTail, i3);
            this._outputTail += i3;
            return;
        }
        _flushBuffer();
        this._writer.write(cArr, i, i3);
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void writeStartArray(Object obj) throws IOException {
        _verifyValueWrite("start an array");
        this._writeContext = this._writeContext.createChildArrayContext(obj);
        streamWriteConstraints().validateNestingDepth(this._writeContext.getNestingDepth());
        PrettyPrinter prettyPrinter = this._cfgPrettyPrinter;
        if (prettyPrinter != null) {
            prettyPrinter.writeStartArray(this);
            return;
        }
        if (this._outputTail >= this._outputEnd) {
            _flushBuffer();
        }
        char[] cArr = this._outputBuffer;
        int i = this._outputTail;
        this._outputTail = i + 1;
        cArr[i] = '[';
    }

    @Override // com.fasterxml.jackson.core.base.GeneratorBase, com.fasterxml.jackson.core.JsonGenerator
    public void writeStartObject(Object obj) throws IOException {
        _verifyValueWrite("start an object");
        JsonWriteContext jsonWriteContextCreateChildObjectContext = this._writeContext.createChildObjectContext(obj);
        streamWriteConstraints().validateNestingDepth(this._writeContext.getNestingDepth());
        this._writeContext = jsonWriteContextCreateChildObjectContext;
        PrettyPrinter prettyPrinter = this._cfgPrettyPrinter;
        if (prettyPrinter != null) {
            prettyPrinter.writeStartObject(this);
            return;
        }
        if (this._outputTail >= this._outputEnd) {
            _flushBuffer();
        }
        char[] cArr = this._outputBuffer;
        int i = this._outputTail;
        this._outputTail = i + 1;
        cArr[i] = '{';
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void writeNumber(long j10) throws IOException {
        _verifyValueWrite("write a number");
        if (this._cfgNumbersAsStrings) {
            _writeQuotedLong(j10);
            return;
        }
        if (this._outputTail + 21 >= this._outputEnd) {
            _flushBuffer();
        }
        this._outputTail = NumberOutput.outputLong(j10, this._outputBuffer, this._outputTail);
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void writeRaw(char c9) throws IOException {
        if (this._outputTail >= this._outputEnd) {
            _flushBuffer();
        }
        char[] cArr = this._outputBuffer;
        int i = this._outputTail;
        this._outputTail = i + 1;
        cArr[i] = c9;
    }

    private void _writeString2(int i) throws IOException {
        int i3;
        int i10 = this._outputTail + i;
        int[] iArr = this._outputEscapes;
        int length = iArr.length;
        while (this._outputTail < i10) {
            do {
                char[] cArr = this._outputBuffer;
                int i11 = this._outputTail;
                char c9 = cArr[i11];
                if (c9 < length && iArr[c9] != 0) {
                    int i12 = this._outputHead;
                    int i13 = i11 - i12;
                    if (i13 > 0) {
                        this._writer.write(cArr, i12, i13);
                    }
                    char[] cArr2 = this._outputBuffer;
                    int i14 = this._outputTail;
                    this._outputTail = i14 + 1;
                    char c10 = cArr2[i14];
                    _prependOrWriteCharacterEscape(c10, iArr[c10]);
                } else {
                    i3 = i11 + 1;
                    this._outputTail = i3;
                }
            } while (i3 < i10);
            return;
        }
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void writeNumber(BigInteger bigInteger) throws IOException {
        _verifyValueWrite("write a number");
        if (bigInteger == null) {
            _writeNull();
        } else if (this._cfgNumbersAsStrings) {
            _writeQuotedRaw(bigInteger.toString());
        } else {
            writeRaw(bigInteger.toString());
        }
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void writeStartArray(Object obj, int i) throws IOException {
        _verifyValueWrite("start an array");
        this._writeContext = this._writeContext.createChildArrayContext(obj);
        streamWriteConstraints().validateNestingDepth(this._writeContext.getNestingDepth());
        PrettyPrinter prettyPrinter = this._cfgPrettyPrinter;
        if (prettyPrinter != null) {
            prettyPrinter.writeStartArray(this);
            return;
        }
        if (this._outputTail >= this._outputEnd) {
            _flushBuffer();
        }
        char[] cArr = this._outputBuffer;
        int i3 = this._outputTail;
        this._outputTail = i3 + 1;
        cArr[i3] = '[';
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void writeStartObject(Object obj, int i) throws IOException {
        writeStartObject(obj);
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void writeNumber(short s6) throws IOException {
        _verifyValueWrite("write a number");
        if (this._cfgNumbersAsStrings) {
            _writeQuotedShort(s6);
            return;
        }
        if (this._outputTail + 6 >= this._outputEnd) {
            _flushBuffer();
        }
        this._outputTail = NumberOutput.outputInt(s6, this._outputBuffer, this._outputTail);
    }

    public void _writePPFieldName(String str, boolean z10) throws IOException {
        PrettyPrinter prettyPrinter = this._cfgPrettyPrinter;
        if (z10) {
            prettyPrinter.writeObjectEntrySeparator(this);
        } else {
            prettyPrinter.beforeObjectEntries(this);
        }
        if (this._cfgUnqNames) {
            _writeString(str);
            return;
        }
        if (this._outputTail >= this._outputEnd) {
            _flushBuffer();
        }
        char[] cArr = this._outputBuffer;
        int i = this._outputTail;
        this._outputTail = i + 1;
        cArr[i] = this._quoteChar;
        _writeString(str);
        if (this._outputTail >= this._outputEnd) {
            _flushBuffer();
        }
        char[] cArr2 = this._outputBuffer;
        int i3 = this._outputTail;
        this._outputTail = i3 + 1;
        cArr2[i3] = this._quoteChar;
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void writeNumber(float f5) throws IOException {
        if (!this._cfgNumbersAsStrings && (!NumberOutput.notFinite(f5) || !isEnabled(JsonGenerator.Feature.QUOTE_NON_NUMERIC_NUMBERS))) {
            _verifyValueWrite("write a number");
            writeRaw(NumberOutput.toString(f5, isEnabled(JsonGenerator.Feature.USE_FAST_DOUBLE_WRITER)));
        } else {
            writeString(NumberOutput.toString(f5, isEnabled(JsonGenerator.Feature.USE_FAST_DOUBLE_WRITER)));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x002a A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void _writeStringASCII(int r9, int r10) throws java.io.IOException {
        /*
            r8 = this;
            int r0 = r8._outputTail
            int r0 = r0 + r9
            int[] r9 = r8._outputEscapes
            int r1 = r9.length
            int r2 = r10 + 1
            int r1 = java.lang.Math.min(r1, r2)
        Lc:
            int r2 = r8._outputTail
            if (r2 >= r0) goto L3a
        L10:
            char[] r2 = r8._outputBuffer
            int r3 = r8._outputTail
            char r4 = r2[r3]
            if (r4 >= r1) goto L1d
            r5 = r9[r4]
            if (r5 == 0) goto L34
            goto L20
        L1d:
            if (r4 <= r10) goto L34
            r5 = -1
        L20:
            int r6 = r8._outputHead
            int r3 = r3 - r6
            if (r3 <= 0) goto L2a
            java.io.Writer r7 = r8._writer
            r7.write(r2, r6, r3)
        L2a:
            int r2 = r8._outputTail
            int r2 = r2 + 1
            r8._outputTail = r2
            r8._prependOrWriteCharacterEscape(r4, r5)
            goto Lc
        L34:
            int r3 = r3 + 1
            r8._outputTail = r3
            if (r3 < r0) goto L10
        L3a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.core.json.WriterBasedJsonGenerator._writeStringASCII(int, int):void");
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void writeNumber(BigDecimal bigDecimal) throws IOException {
        _verifyValueWrite("write a number");
        if (bigDecimal == null) {
            _writeNull();
        } else if (this._cfgNumbersAsStrings) {
            _writeQuotedRaw(_asString(bigDecimal));
        } else {
            writeRaw(_asString(bigDecimal));
        }
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void writeNumber(String str) throws IOException {
        _verifyValueWrite("write a number");
        if (str == null) {
            _writeNull();
        } else if (this._cfgNumbersAsStrings) {
            _writeQuotedRaw(str);
        } else {
            writeRaw(str);
        }
    }

    private void _writeString(String str) throws IOException {
        int length = str.length();
        int i = this._outputEnd;
        if (length > i) {
            _writeLongString(str);
            return;
        }
        if (this._outputTail + length > i) {
            _flushBuffer();
        }
        str.getChars(0, length, this._outputBuffer, this._outputTail);
        if (this._characterEscapes != null) {
            _writeStringCustom(length);
            return;
        }
        int i3 = this._maximumNonEscapedChar;
        if (i3 != 0) {
            _writeStringASCII(length, i3);
        } else {
            _writeString2(length);
        }
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void writeNumber(char[] cArr, int i, int i3) throws IOException {
        _verifyValueWrite("write a number");
        if (this._cfgNumbersAsStrings) {
            _writeQuotedRaw(cArr, i, i3);
        } else {
            writeRaw(cArr, i, i3);
        }
    }

    public void _writeFieldName(String str, boolean z10) throws IOException {
        if (this._cfgPrettyPrinter != null) {
            _writePPFieldName(str, z10);
            return;
        }
        if (this._outputTail + 1 >= this._outputEnd) {
            _flushBuffer();
        }
        if (z10) {
            char[] cArr = this._outputBuffer;
            int i = this._outputTail;
            this._outputTail = i + 1;
            cArr[i] = ',';
        }
        if (this._cfgUnqNames) {
            _writeString(str);
            return;
        }
        char[] cArr2 = this._outputBuffer;
        int i3 = this._outputTail;
        this._outputTail = i3 + 1;
        cArr2[i3] = this._quoteChar;
        _writeString(str);
        if (this._outputTail >= this._outputEnd) {
            _flushBuffer();
        }
        char[] cArr3 = this._outputBuffer;
        int i10 = this._outputTail;
        this._outputTail = i10 + 1;
        cArr3[i10] = this._quoteChar;
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void writeString(String str) throws IOException {
        _verifyValueWrite("write a string");
        if (str == null) {
            _writeNull();
            return;
        }
        if (this._outputTail >= this._outputEnd) {
            _flushBuffer();
        }
        char[] cArr = this._outputBuffer;
        int i = this._outputTail;
        this._outputTail = i + 1;
        cArr[i] = this._quoteChar;
        _writeString(str);
        if (this._outputTail >= this._outputEnd) {
            _flushBuffer();
        }
        char[] cArr2 = this._outputBuffer;
        int i3 = this._outputTail;
        this._outputTail = i3 + 1;
        cArr2[i3] = this._quoteChar;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x003b  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0042 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void _writeStringCustom(int r12) throws java.io.IOException {
        /*
            r11 = this;
            int r0 = r11._outputTail
            int r0 = r0 + r12
            int[] r12 = r11._outputEscapes
            int r1 = r11._maximumNonEscapedChar
            r2 = 1
            if (r1 >= r2) goto Ld
            r1 = 65535(0xffff, float:9.1834E-41)
        Ld:
            int r3 = r12.length
            int r4 = r1 + 1
            int r3 = java.lang.Math.min(r3, r4)
            com.fasterxml.jackson.core.io.CharacterEscapes r4 = r11._characterEscapes
        L16:
            int r5 = r11._outputTail
            if (r5 >= r0) goto L52
        L1a:
            char[] r5 = r11._outputBuffer
            int r6 = r11._outputTail
            char r5 = r5[r6]
            if (r5 >= r3) goto L27
            r6 = r12[r5]
            if (r6 == 0) goto L4b
            goto L34
        L27:
            if (r5 <= r1) goto L2b
            r6 = -1
            goto L34
        L2b:
            com.fasterxml.jackson.core.SerializableString r6 = r4.getEscapeSequence(r5)
            r11._currentEscape = r6
            if (r6 == 0) goto L4b
            r6 = -2
        L34:
            int r7 = r11._outputTail
            int r8 = r11._outputHead
            int r7 = r7 - r8
            if (r7 <= 0) goto L42
            java.io.Writer r9 = r11._writer
            char[] r10 = r11._outputBuffer
            r9.write(r10, r8, r7)
        L42:
            int r7 = r11._outputTail
            int r7 = r7 + r2
            r11._outputTail = r7
            r11._prependOrWriteCharacterEscape(r5, r6)
            goto L16
        L4b:
            int r5 = r11._outputTail
            int r5 = r5 + r2
            r11._outputTail = r5
            if (r5 < r0) goto L1a
        L52:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.core.json.WriterBasedJsonGenerator._writeStringCustom(int):void");
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void writeString(char[] cArr, int i, int i3) throws IOException {
        _verifyValueWrite("write a string");
        if (this._outputTail >= this._outputEnd) {
            _flushBuffer();
        }
        char[] cArr2 = this._outputBuffer;
        int i10 = this._outputTail;
        this._outputTail = i10 + 1;
        cArr2[i10] = this._quoteChar;
        _writeString(cArr, i, i3);
        if (this._outputTail >= this._outputEnd) {
            _flushBuffer();
        }
        char[] cArr3 = this._outputBuffer;
        int i11 = this._outputTail;
        this._outputTail = i11 + 1;
        cArr3[i11] = this._quoteChar;
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void writeBinary(Base64Variant base64Variant, byte[] bArr, int i, int i3) throws IOException {
        _checkRangeBoundsForByteArray(bArr, i, i3);
        _verifyValueWrite("write a binary value");
        if (this._outputTail >= this._outputEnd) {
            _flushBuffer();
        }
        char[] cArr = this._outputBuffer;
        int i10 = this._outputTail;
        this._outputTail = i10 + 1;
        cArr[i10] = this._quoteChar;
        _writeBinary(base64Variant, bArr, i, i3 + i);
        if (this._outputTail >= this._outputEnd) {
            _flushBuffer();
        }
        char[] cArr2 = this._outputBuffer;
        int i11 = this._outputTail;
        this._outputTail = i11 + 1;
        cArr2[i11] = this._quoteChar;
    }

    @Override // com.fasterxml.jackson.core.base.GeneratorBase, com.fasterxml.jackson.core.JsonGenerator
    public void writeString(SerializableString serializableString) throws IOException {
        _verifyValueWrite("write a string");
        if (this._outputTail >= this._outputEnd) {
            _flushBuffer();
        }
        char[] cArr = this._outputBuffer;
        int i = this._outputTail;
        int i3 = i + 1;
        this._outputTail = i3;
        cArr[i] = this._quoteChar;
        int iAppendQuoted = serializableString.appendQuoted(cArr, i3);
        if (iAppendQuoted < 0) {
            _writeString2(serializableString);
            return;
        }
        int i10 = this._outputTail + iAppendQuoted;
        this._outputTail = i10;
        if (i10 >= this._outputEnd) {
            _flushBuffer();
        }
        char[] cArr2 = this._outputBuffer;
        int i11 = this._outputTail;
        this._outputTail = i11 + 1;
        cArr2[i11] = this._quoteChar;
    }

    public void _writeBinary(Base64Variant base64Variant, byte[] bArr, int i, int i3) throws IOException {
        int iEncodeBase64Chunk;
        int i10 = i3 - 3;
        int i11 = this._outputEnd - 6;
        int maxLineLength = base64Variant.getMaxLineLength();
        loop0: while (true) {
            int i12 = maxLineLength >> 2;
            while (i <= i10) {
                if (this._outputTail > i11) {
                    _flushBuffer();
                }
                int i13 = i + 2;
                int i14 = ((bArr[i + 1] & 255) | (bArr[i] << 8)) << 8;
                i += 3;
                iEncodeBase64Chunk = base64Variant.encodeBase64Chunk(i14 | (bArr[i13] & 255), this._outputBuffer, this._outputTail);
                this._outputTail = iEncodeBase64Chunk;
                i12--;
                if (i12 <= 0) {
                    break;
                }
            }
            char[] cArr = this._outputBuffer;
            int i15 = iEncodeBase64Chunk + 1;
            this._outputTail = i15;
            cArr[iEncodeBase64Chunk] = '\\';
            this._outputTail = iEncodeBase64Chunk + 2;
            cArr[i15] = 'n';
            maxLineLength = base64Variant.getMaxLineLength();
        }
        int i16 = i3 - i;
        if (i16 > 0) {
            if (this._outputTail > i11) {
                _flushBuffer();
            }
            int i17 = i + 1;
            int i18 = bArr[i] << 16;
            if (i16 == 2) {
                i18 |= (bArr[i17] & 255) << 8;
            }
            this._outputTail = base64Variant.encodeBase64Partial(i18, i16, this._outputBuffer, this._outputTail);
        }
    }

    public int _writeBinary(Base64Variant base64Variant, InputStream inputStream, byte[] bArr) throws IOException {
        byte[] bArr2 = bArr;
        int i = this._outputEnd - 6;
        int i3 = 2;
        int i10 = -3;
        int maxLineLength = base64Variant.getMaxLineLength() >> 2;
        int i11 = 0;
        int i_readMore = 0;
        int i12 = 0;
        while (true) {
            if (i11 > i10) {
                i_readMore = _readMore(inputStream, bArr2, i11, i_readMore, bArr2.length);
                if (i_readMore < 3) {
                    break;
                }
                i10 = i_readMore - 3;
                i11 = 0;
            }
            if (this._outputTail > i) {
                _flushBuffer();
            }
            int i13 = i11 + 2;
            int i14 = ((bArr[i11 + 1] & 255) | (bArr[i11] << 8)) << 8;
            i11 += 3;
            i12 += 3;
            int iEncodeBase64Chunk = base64Variant.encodeBase64Chunk(i14 | (bArr[i13] & 255), this._outputBuffer, this._outputTail);
            this._outputTail = iEncodeBase64Chunk;
            maxLineLength--;
            if (maxLineLength <= 0) {
                char[] cArr = this._outputBuffer;
                int i15 = iEncodeBase64Chunk + 1;
                this._outputTail = i15;
                cArr[iEncodeBase64Chunk] = '\\';
                this._outputTail = iEncodeBase64Chunk + 2;
                cArr[i15] = 'n';
                maxLineLength = base64Variant.getMaxLineLength() >> 2;
            }
            bArr2 = bArr;
        }
        if (i_readMore <= 0) {
            return i12;
        }
        if (this._outputTail > i) {
            _flushBuffer();
        }
        int i16 = bArr[0] << 16;
        if (1 < i_readMore) {
            i16 |= (bArr[1] & 255) << 8;
        } else {
            i3 = 1;
        }
        int i17 = i12 + i3;
        this._outputTail = base64Variant.encodeBase64Partial(i16, i3, this._outputBuffer, this._outputTail);
        return i17;
    }

    private int _prependOrWriteCharacterEscape(char[] cArr, int i, int i3, char c9, int i10) throws IOException {
        String value;
        int i11;
        if (i10 >= 0) {
            if (i > 1 && i < i3) {
                int i12 = i - 2;
                cArr[i12] = '\\';
                cArr[i - 1] = (char) i10;
                return i12;
            }
            char[] cArr_allocateEntityBuffer = this._entityBuffer;
            if (cArr_allocateEntityBuffer == null) {
                cArr_allocateEntityBuffer = _allocateEntityBuffer();
            }
            cArr_allocateEntityBuffer[1] = (char) i10;
            this._writer.write(cArr_allocateEntityBuffer, 0, 2);
            return i;
        }
        if (i10 != -2) {
            char[] hexChars = getHexChars();
            if (i > 5 && i < i3) {
                cArr[i - 6] = '\\';
                int i13 = i - 4;
                cArr[i - 5] = 'u';
                if (c9 > 255) {
                    int i14 = c9 >> '\b';
                    int i15 = i - 3;
                    cArr[i13] = hexChars[(i14 & 255) >> 4];
                    i11 = i - 2;
                    cArr[i15] = hexChars[i14 & 15];
                    c9 = (char) (c9 & 255);
                } else {
                    int i16 = i - 3;
                    cArr[i13] = '0';
                    i11 = i - 2;
                    cArr[i16] = '0';
                }
                cArr[i11] = hexChars[c9 >> 4];
                cArr[i11 + 1] = hexChars[c9 & 15];
                return i11 - 4;
            }
            char[] cArr_allocateEntityBuffer2 = this._entityBuffer;
            if (cArr_allocateEntityBuffer2 == null) {
                cArr_allocateEntityBuffer2 = _allocateEntityBuffer();
            }
            this._outputHead = this._outputTail;
            if (c9 > 255) {
                int i17 = c9 >> '\b';
                cArr_allocateEntityBuffer2[10] = hexChars[(i17 & 255) >> 4];
                cArr_allocateEntityBuffer2[11] = hexChars[i17 & 15];
                cArr_allocateEntityBuffer2[12] = hexChars[(c9 & 255) >> 4];
                cArr_allocateEntityBuffer2[13] = hexChars[c9 & 15];
                this._writer.write(cArr_allocateEntityBuffer2, 8, 6);
                return i;
            }
            cArr_allocateEntityBuffer2[6] = hexChars[c9 >> 4];
            cArr_allocateEntityBuffer2[7] = hexChars[c9 & 15];
            this._writer.write(cArr_allocateEntityBuffer2, 2, 6);
            return i;
        }
        SerializableString serializableString = this._currentEscape;
        if (serializableString == null) {
            value = this._characterEscapes.getEscapeSequence(c9).getValue();
        } else {
            value = serializableString.getValue();
            this._currentEscape = null;
        }
        int length = value.length();
        if (i >= length && i < i3) {
            int i18 = i - length;
            value.getChars(0, length, cArr, i18);
            return i18;
        }
        this._writer.write(value);
        return i;
    }
}
