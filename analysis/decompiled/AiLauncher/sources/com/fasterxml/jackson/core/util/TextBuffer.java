package com.fasterxml.jackson.core.util;

import com.fasterxml.jackson.core.io.NumberInput;
import java.io.IOException;
import java.io.Writer;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;

/* loaded from: classes.dex */
public class TextBuffer {
    static final int MAX_SEGMENT_LEN = 65536;
    static final int MIN_SEGMENT_LEN = 500;
    static final char[] NO_CHARS = new char[0];
    private final BufferRecycler _allocator;
    private char[] _currentSegment;
    private int _currentSize;
    private boolean _hasSegments;
    private char[] _inputBuffer;
    private int _inputLen;
    private int _inputStart;
    private char[] _resultArray;
    private String _resultString;
    private int _segmentSize;
    private ArrayList<char[]> _segments;

    public TextBuffer(BufferRecycler bufferRecycler) {
        this._allocator = bufferRecycler;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0015, code lost:
    
        r5 = r4._segments;
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0017, code lost:
    
        if (r5 == null) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x001d, code lost:
    
        if (r5.isEmpty() == false) goto L15;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private java.lang.String _doTrim(int r5) throws java.io.IOException {
        /*
            r4 = this;
        L0:
            char[] r0 = r4._currentSegment
        L2:
            int r1 = r5 + (-1)
            if (r1 < 0) goto L15
            char r2 = r0[r1]
            r3 = 32
            if (r2 <= r3) goto L13
            r4._currentSize = r5
            java.lang.String r4 = r4.contentsAsString()
            return r4
        L13:
            r5 = r1
            goto L2
        L15:
            java.util.ArrayList<char[]> r5 = r4._segments
            if (r5 == 0) goto L32
            boolean r5 = r5.isEmpty()
            if (r5 == 0) goto L20
            goto L32
        L20:
            java.util.ArrayList<char[]> r5 = r4._segments
            int r0 = r5.size()
            int r0 = r0 + (-1)
            java.lang.Object r5 = r5.remove(r0)
            char[] r5 = (char[]) r5
            r4._currentSegment = r5
            int r5 = r5.length
            goto L0
        L32:
            r5 = 0
            r4._currentSize = r5
            r4._hasSegments = r5
            java.lang.String r4 = r4.contentsAsString()
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.core.util.TextBuffer._doTrim(int):java.lang.String");
    }

    private char[] buf(int i10) {
        BufferRecycler bufferRecycler = this._allocator;
        return bufferRecycler != null ? bufferRecycler.allocCharBuffer(2, i10) : new char[Math.max(i10, 500)];
    }

    private char[] carr(int i10) {
        return new char[i10];
    }

    private void clearSegments() {
        this._hasSegments = false;
        this._segments.clear();
        this._segmentSize = 0;
        this._currentSize = 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002e A[PHI: r1
      0x002e: PHI (r1v8 int) = (r1v6 int), (r1v7 int) binds: [B:9:0x002c, B:12:0x0032] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void expand() {
        /*
            r3 = this;
            java.util.ArrayList<char[]> r0 = r3._segments
            if (r0 != 0) goto Lb
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r3._segments = r0
        Lb:
            char[] r0 = r3._currentSegment
            r1 = 1
            r3._hasSegments = r1
            java.util.ArrayList<char[]> r1 = r3._segments
            r1.add(r0)
            int r1 = r3._segmentSize
            int r2 = r0.length
            int r1 = r1 + r2
            r3._segmentSize = r1
            if (r1 >= 0) goto L23
            int r2 = r0.length
            int r1 = r1 - r2
            int r2 = r0.length
            r3._reportBufferOverflow(r1, r2)
        L23:
            r1 = 0
            r3._currentSize = r1
            int r0 = r0.length
            int r1 = r0 >> 1
            int r0 = r0 + r1
            r1 = 500(0x1f4, float:7.0E-43)
            if (r0 >= r1) goto L30
        L2e:
            r0 = r1
            goto L35
        L30:
            r1 = 65536(0x10000, float:9.1835E-41)
            if (r0 <= r1) goto L35
            goto L2e
        L35:
            char[] r0 = r3.carr(r0)
            r3._currentSegment = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.core.util.TextBuffer.expand():void");
    }

    public static TextBuffer fromInitial(char[] cArr) {
        return new TextBuffer(null, cArr);
    }

    private char[] resultArray() throws IOException {
        int i10;
        String str = this._resultString;
        if (str != null) {
            return str.toCharArray();
        }
        if (this._inputStart >= 0) {
            int i11 = this._inputLen;
            if (i11 < 1) {
                return NO_CHARS;
            }
            validateStringLength(i11);
            int i12 = this._inputStart;
            return i12 == 0 ? Arrays.copyOf(this._inputBuffer, i11) : Arrays.copyOfRange(this._inputBuffer, i12, i11 + i12);
        }
        int size = size();
        if (size < 1) {
            if (size < 0) {
                _reportBufferOverflow(this._segmentSize, this._currentSize);
            }
            return NO_CHARS;
        }
        validateStringLength(size);
        char[] carr = carr(size);
        ArrayList<char[]> arrayList = this._segments;
        if (arrayList != null) {
            int size2 = arrayList.size();
            i10 = 0;
            for (int i13 = 0; i13 < size2; i13++) {
                char[] cArr = this._segments.get(i13);
                int length = cArr.length;
                System.arraycopy(cArr, 0, carr, i10, length);
                i10 += length;
            }
        } else {
            i10 = 0;
        }
        System.arraycopy(this._currentSegment, 0, carr, i10, this._currentSize);
        return carr;
    }

    private void unshare(int i10) {
        int i11 = this._inputLen;
        this._inputLen = 0;
        char[] cArr = this._inputBuffer;
        this._inputBuffer = null;
        int i12 = this._inputStart;
        this._inputStart = -1;
        int i13 = i10 + i11;
        char[] cArr2 = this._currentSegment;
        if (cArr2 == null || i13 > cArr2.length) {
            this._currentSegment = buf(i13);
        }
        if (i11 > 0) {
            System.arraycopy(cArr, i12, this._currentSegment, 0, i11);
        }
        this._segmentSize = 0;
        this._currentSize = i11;
    }

    private void validateAppend(int i10) throws IOException {
        int i11 = this._segmentSize + this._currentSize + i10;
        if (i11 < 0) {
            i11 = Integer.MAX_VALUE;
        }
        validateStringLength(i11);
    }

    public void _reportBufferOverflow(int i10, int i11) {
        throw new IllegalStateException("TextBuffer overrun: size reached (" + (i10 + i11) + ") exceeds maximum of 2147483647");
    }

    public void append(char c10) throws IOException {
        if (this._inputStart >= 0) {
            unshare(16);
        }
        this._resultString = null;
        this._resultArray = null;
        char[] cArr = this._currentSegment;
        if (this._currentSize >= cArr.length) {
            validateAppend(1);
            expand();
            cArr = this._currentSegment;
        }
        int i10 = this._currentSize;
        this._currentSize = i10 + 1;
        cArr[i10] = c10;
    }

    public BufferRecycler bufferRecycler() {
        return this._allocator;
    }

    public char[] contentsAsArray() throws IOException {
        char[] cArr = this._resultArray;
        if (cArr != null) {
            return cArr;
        }
        char[] cArrResultArray = resultArray();
        this._resultArray = cArrResultArray;
        return cArrResultArray;
    }

    @Deprecated
    public BigDecimal contentsAsDecimal() throws NumberFormatException {
        return contentsAsDecimal(false);
    }

    public double contentsAsDouble(boolean z10) throws NumberFormatException {
        String str = this._resultString;
        if (str != null) {
            return NumberInput.parseDouble(str, z10);
        }
        int i10 = this._inputStart;
        if (i10 >= 0) {
            return NumberInput.parseDouble(this._inputBuffer, i10, this._inputLen, z10);
        }
        if (!this._hasSegments) {
            return NumberInput.parseDouble(this._currentSegment, 0, this._currentSize, z10);
        }
        char[] cArr = this._resultArray;
        if (cArr != null) {
            return NumberInput.parseDouble(cArr, z10);
        }
        try {
            return NumberInput.parseDouble(contentsAsString(), z10);
        } catch (IOException e10) {
            throw new NumberFormatException(e10.getMessage());
        }
    }

    @Deprecated
    public float contentsAsFloat() throws NumberFormatException {
        return contentsAsFloat(false);
    }

    public int contentsAsInt(boolean z10) {
        char[] cArr;
        int i10 = this._inputStart;
        return (i10 < 0 || (cArr = this._inputBuffer) == null) ? z10 ? -NumberInput.parseInt(this._currentSegment, 1, this._currentSize - 1) : NumberInput.parseInt(this._currentSegment, 0, this._currentSize) : z10 ? -NumberInput.parseInt(cArr, i10 + 1, this._inputLen - 1) : NumberInput.parseInt(cArr, i10, this._inputLen);
    }

    public long contentsAsLong(boolean z10) {
        char[] cArr;
        int i10 = this._inputStart;
        return (i10 < 0 || (cArr = this._inputBuffer) == null) ? z10 ? -NumberInput.parseLong(this._currentSegment, 1, this._currentSize - 1) : NumberInput.parseLong(this._currentSegment, 0, this._currentSize) : z10 ? -NumberInput.parseLong(cArr, i10 + 1, this._inputLen - 1) : NumberInput.parseLong(cArr, i10, this._inputLen);
    }

    public String contentsAsString() throws IOException {
        if (this._resultString == null) {
            char[] cArr = this._resultArray;
            if (cArr != null) {
                this._resultString = new String(cArr);
            } else if (this._inputStart >= 0) {
                int i10 = this._inputLen;
                if (i10 < 1) {
                    this._resultString = "";
                    return "";
                }
                validateStringLength(i10);
                this._resultString = new String(this._inputBuffer, this._inputStart, this._inputLen);
            } else {
                int i11 = this._segmentSize;
                int i12 = this._currentSize;
                if (i11 != 0) {
                    int i13 = i11 + i12;
                    if (i13 < 0) {
                        _reportBufferOverflow(i11, i12);
                    }
                    validateStringLength(i13);
                    StringBuilder sb2 = new StringBuilder(i13);
                    ArrayList<char[]> arrayList = this._segments;
                    if (arrayList != null) {
                        int size = arrayList.size();
                        for (int i14 = 0; i14 < size; i14++) {
                            char[] cArr2 = this._segments.get(i14);
                            sb2.append(cArr2, 0, cArr2.length);
                        }
                    }
                    sb2.append(this._currentSegment, 0, this._currentSize);
                    this._resultString = sb2.toString();
                } else if (i12 == 0) {
                    this._resultString = "";
                } else {
                    validateStringLength(i12);
                    this._resultString = new String(this._currentSegment, 0, i12);
                }
            }
        }
        return this._resultString;
    }

    public int contentsToWriter(Writer writer) throws IOException {
        int i10;
        char[] cArr = this._resultArray;
        if (cArr != null) {
            writer.write(cArr);
            return this._resultArray.length;
        }
        String str = this._resultString;
        if (str != null) {
            writer.write(str);
            return this._resultString.length();
        }
        int i11 = this._inputStart;
        if (i11 >= 0) {
            int i12 = this._inputLen;
            if (i12 > 0) {
                writer.write(this._inputBuffer, i11, i12);
            }
            return i12;
        }
        ArrayList<char[]> arrayList = this._segments;
        if (arrayList != null) {
            int size = arrayList.size();
            i10 = 0;
            for (int i13 = 0; i13 < size; i13++) {
                char[] cArr2 = this._segments.get(i13);
                int length = cArr2.length;
                i10 += length;
                writer.write(cArr2, 0, length);
            }
        } else {
            i10 = 0;
        }
        int i14 = this._currentSize;
        if (i14 <= 0) {
            return i10;
        }
        int i15 = i10 + i14;
        writer.write(this._currentSegment, 0, i14);
        return i15;
    }

    public char[] emptyAndGetCurrentSegment() {
        this._inputStart = -1;
        this._currentSize = 0;
        this._inputLen = 0;
        this._inputBuffer = null;
        this._resultString = null;
        this._resultArray = null;
        if (this._hasSegments) {
            clearSegments();
        }
        char[] cArr = this._currentSegment;
        if (cArr != null) {
            return cArr;
        }
        char[] cArrBuf = buf(0);
        this._currentSegment = cArrBuf;
        return cArrBuf;
    }

    public void ensureNotShared() {
        if (this._inputStart >= 0) {
            unshare(16);
        }
    }

    public char[] expandCurrentSegment() {
        char[] cArr = this._currentSegment;
        int length = cArr.length;
        int i10 = (length >> 1) + length;
        if (i10 > 65536) {
            i10 = (length >> 2) + length;
        }
        char[] cArrCopyOf = Arrays.copyOf(cArr, i10);
        this._currentSegment = cArrCopyOf;
        return cArrCopyOf;
    }

    public String finishAndReturn(int i10, boolean z10) throws IOException {
        int i11;
        if (z10 && (i10 - 1 < 0 || this._currentSegment[i11] <= ' ')) {
            return _doTrim(i11);
        }
        this._currentSize = i10;
        return contentsAsString();
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0032 A[PHI: r1
      0x0032: PHI (r1v8 int) = (r1v6 int), (r1v7 int) binds: [B:9:0x0030, B:12:0x0036] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public char[] finishCurrentSegment() throws java.io.IOException {
        /*
            r2 = this;
            java.util.ArrayList<char[]> r0 = r2._segments
            if (r0 != 0) goto Lb
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r2._segments = r0
        Lb:
            r0 = 1
            r2._hasSegments = r0
            java.util.ArrayList<char[]> r0 = r2._segments
            char[] r1 = r2._currentSegment
            r0.add(r1)
            char[] r0 = r2._currentSegment
            int r0 = r0.length
            int r1 = r2._segmentSize
            int r1 = r1 + r0
            r2._segmentSize = r1
            if (r1 >= 0) goto L23
            int r1 = r1 - r0
            r2._reportBufferOverflow(r1, r0)
        L23:
            r1 = 0
            r2._currentSize = r1
            int r1 = r2._segmentSize
            r2.validateStringLength(r1)
            int r1 = r0 >> 1
            int r0 = r0 + r1
            r1 = 500(0x1f4, float:7.0E-43)
            if (r0 >= r1) goto L34
        L32:
            r0 = r1
            goto L39
        L34:
            r1 = 65536(0x10000, float:9.1835E-41)
            if (r0 <= r1) goto L39
            goto L32
        L39:
            char[] r0 = r2.carr(r0)
            r2._currentSegment = r0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.core.util.TextBuffer.finishCurrentSegment():char[]");
    }

    public char[] getBufferWithoutReset() {
        return this._currentSegment;
    }

    public char[] getCurrentSegment() {
        if (this._inputStart >= 0) {
            unshare(1);
        } else {
            char[] cArr = this._currentSegment;
            if (cArr == null) {
                this._currentSegment = buf(0);
            } else if (this._currentSize >= cArr.length) {
                expand();
            }
        }
        return this._currentSegment;
    }

    public int getCurrentSegmentSize() {
        return this._currentSize;
    }

    public char[] getTextBuffer() throws IOException {
        if (this._inputStart >= 0) {
            return this._inputBuffer;
        }
        char[] cArr = this._resultArray;
        if (cArr != null) {
            return cArr;
        }
        String str = this._resultString;
        if (str != null) {
            char[] charArray = str.toCharArray();
            this._resultArray = charArray;
            return charArray;
        }
        if (this._hasSegments) {
            return contentsAsArray();
        }
        char[] cArr2 = this._currentSegment;
        return cArr2 == null ? NO_CHARS : cArr2;
    }

    public int getTextOffset() {
        int i10 = this._inputStart;
        if (i10 >= 0) {
            return i10;
        }
        return 0;
    }

    public boolean hasTextAsCharacters() {
        return this._inputStart >= 0 || this._resultArray != null || this._resultString == null;
    }

    public void releaseBuffers() {
        char[] cArr;
        this._inputStart = -1;
        this._currentSize = 0;
        this._inputLen = 0;
        this._inputBuffer = null;
        this._resultArray = null;
        if (this._hasSegments) {
            clearSegments();
        }
        BufferRecycler bufferRecycler = this._allocator;
        if (bufferRecycler == null || (cArr = this._currentSegment) == null) {
            return;
        }
        this._currentSegment = null;
        bufferRecycler.releaseCharBuffer(2, cArr);
    }

    public void resetWith(char c10) {
        this._inputStart = -1;
        this._inputLen = 0;
        this._resultString = null;
        this._resultArray = null;
        if (this._hasSegments) {
            clearSegments();
        } else if (this._currentSegment == null) {
            this._currentSegment = buf(1);
        }
        this._currentSegment[0] = c10;
        this._segmentSize = 1;
        this._currentSize = 1;
    }

    public void resetWithCopy(char[] cArr, int i10, int i11) throws IOException {
        this._inputBuffer = null;
        this._inputStart = -1;
        this._inputLen = 0;
        this._resultString = null;
        this._resultArray = null;
        if (this._hasSegments) {
            clearSegments();
        } else if (this._currentSegment == null) {
            this._currentSegment = buf(i11);
        }
        this._segmentSize = 0;
        this._currentSize = 0;
        append(cArr, i10, i11);
    }

    public void resetWithEmpty() {
        this._inputStart = -1;
        this._currentSize = 0;
        this._inputLen = 0;
        this._inputBuffer = null;
        this._resultString = null;
        this._resultArray = null;
        if (this._hasSegments) {
            clearSegments();
        }
    }

    public void resetWithShared(char[] cArr, int i10, int i11) {
        this._resultString = null;
        this._resultArray = null;
        this._inputBuffer = cArr;
        this._inputStart = i10;
        this._inputLen = i11;
        if (this._hasSegments) {
            clearSegments();
        }
    }

    public void resetWithString(String str) throws IOException {
        this._inputBuffer = null;
        this._inputStart = -1;
        this._inputLen = 0;
        validateStringLength(str.length());
        this._resultString = str;
        this._resultArray = null;
        if (this._hasSegments) {
            clearSegments();
        }
        this._currentSize = 0;
    }

    public String setCurrentAndReturn(int i10) throws IOException {
        this._currentSize = i10;
        if (this._segmentSize > 0) {
            return contentsAsString();
        }
        validateStringLength(i10);
        String str = i10 == 0 ? "" : new String(this._currentSegment, 0, i10);
        this._resultString = str;
        return str;
    }

    public void setCurrentLength(int i10) {
        this._currentSize = i10;
    }

    public int size() {
        if (this._inputStart >= 0) {
            return this._inputLen;
        }
        char[] cArr = this._resultArray;
        if (cArr != null) {
            return cArr.length;
        }
        String str = this._resultString;
        return str != null ? str.length() : this._segmentSize + this._currentSize;
    }

    public String toString() {
        try {
            return contentsAsString();
        } catch (IOException unused) {
            return "TextBuffer: Exception when reading contents";
        }
    }

    public void validateStringLength(int i10) throws IOException {
    }

    public BigDecimal contentsAsDecimal(boolean z10) throws NumberFormatException {
        String str = this._resultString;
        if (str != null) {
            return NumberInput.parseBigDecimal(str, z10);
        }
        int i10 = this._inputStart;
        if (i10 >= 0) {
            return NumberInput.parseBigDecimal(this._inputBuffer, i10, this._inputLen, z10);
        }
        if (!this._hasSegments) {
            return NumberInput.parseBigDecimal(this._currentSegment, 0, this._currentSize, z10);
        }
        char[] cArr = this._resultArray;
        if (cArr != null) {
            return NumberInput.parseBigDecimal(cArr, z10);
        }
        try {
            return NumberInput.parseBigDecimal(contentsAsArray(), z10);
        } catch (IOException e10) {
            throw new NumberFormatException(e10.getMessage());
        }
    }

    public float contentsAsFloat(boolean z10) throws NumberFormatException {
        String str = this._resultString;
        if (str != null) {
            return NumberInput.parseFloat(str, z10);
        }
        int i10 = this._inputStart;
        if (i10 >= 0) {
            return NumberInput.parseFloat(this._inputBuffer, i10, this._inputLen, z10);
        }
        if (!this._hasSegments) {
            return NumberInput.parseFloat(this._currentSegment, 0, this._currentSize, z10);
        }
        char[] cArr = this._resultArray;
        if (cArr != null) {
            return NumberInput.parseFloat(cArr, z10);
        }
        try {
            return NumberInput.parseFloat(contentsAsString(), z10);
        } catch (IOException e10) {
            throw new NumberFormatException(e10.getMessage());
        }
    }

    public TextBuffer(BufferRecycler bufferRecycler, char[] cArr) {
        this(bufferRecycler);
        this._currentSegment = cArr;
        this._currentSize = cArr.length;
        this._inputStart = -1;
    }

    public char[] expandCurrentSegment(int i10) {
        char[] cArr = this._currentSegment;
        if (cArr.length >= i10) {
            return cArr;
        }
        char[] cArrCopyOf = Arrays.copyOf(cArr, i10);
        this._currentSegment = cArrCopyOf;
        return cArrCopyOf;
    }

    public void append(char[] cArr, int i10, int i11) throws IOException {
        if (this._inputStart >= 0) {
            unshare(i11);
        }
        this._resultString = null;
        this._resultArray = null;
        char[] cArr2 = this._currentSegment;
        int length = cArr2.length;
        int i12 = this._currentSize;
        int i13 = length - i12;
        if (i13 >= i11) {
            System.arraycopy(cArr, i10, cArr2, i12, i11);
            this._currentSize += i11;
            return;
        }
        validateAppend(i11);
        if (i13 > 0) {
            System.arraycopy(cArr, i10, cArr2, this._currentSize, i13);
            i10 += i13;
            i11 -= i13;
        }
        do {
            expand();
            int iMin = Math.min(this._currentSegment.length, i11);
            System.arraycopy(cArr, i10, this._currentSegment, 0, iMin);
            this._currentSize += iMin;
            i10 += iMin;
            i11 -= iMin;
        } while (i11 > 0);
    }

    @Deprecated
    public double contentsAsDouble() throws NumberFormatException {
        return contentsAsDouble(false);
    }

    public void resetWithCopy(String str, int i10, int i11) throws IOException {
        this._inputBuffer = null;
        this._inputStart = -1;
        this._inputLen = 0;
        this._resultString = null;
        this._resultArray = null;
        if (this._hasSegments) {
            clearSegments();
        } else if (this._currentSegment == null) {
            this._currentSegment = buf(i11);
        }
        this._segmentSize = 0;
        this._currentSize = 0;
        append(str, i10, i11);
    }

    public void append(String str, int i10, int i11) throws IOException {
        if (this._inputStart >= 0) {
            unshare(i11);
        }
        this._resultString = null;
        this._resultArray = null;
        char[] cArr = this._currentSegment;
        int length = cArr.length;
        int i12 = this._currentSize;
        int i13 = length - i12;
        if (i13 >= i11) {
            str.getChars(i10, i10 + i11, cArr, i12);
            this._currentSize += i11;
            return;
        }
        validateAppend(i11);
        if (i13 > 0) {
            int i14 = i10 + i13;
            str.getChars(i10, i14, cArr, this._currentSize);
            i11 -= i13;
            i10 = i14;
        }
        while (true) {
            expand();
            int iMin = Math.min(this._currentSegment.length, i11);
            int i15 = i10 + iMin;
            str.getChars(i10, i15, this._currentSegment, 0);
            this._currentSize += iMin;
            i11 -= iMin;
            if (i11 <= 0) {
                return;
            } else {
                i10 = i15;
            }
        }
    }
}
