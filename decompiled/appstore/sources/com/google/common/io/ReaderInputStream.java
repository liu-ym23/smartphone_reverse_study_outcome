package com.google.common.io;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.primitives.UnsignedBytes;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CoderResult;
import java.nio.charset.CodingErrorAction;
import java.util.Arrays;

/* JADX INFO: loaded from: classes3.dex */
@GwtIncompatible
final class ReaderInputStream extends InputStream {
    private ByteBuffer byteBuffer;
    private CharBuffer charBuffer;
    private boolean doneFlushing;
    private boolean draining;
    private final CharsetEncoder encoder;
    private boolean endOfInput;
    private final Reader reader;
    private final byte[] singleByte;

    public ReaderInputStream(Reader r10, Charset r11, int r12) {
        CharsetEncoder r13 = r11.newEncoder();
        CodingErrorAction r14 = CodingErrorAction.REPLACE;
        this(r10, r13.onMalformedInput(r14).onUnmappableCharacter(r14), r12);
    }

    private static int availableCapacity(Buffer r10) {
        return r10.capacity() - r10.limit();
    }

    private int drain(byte[] r10, int r11, int r12) {
        int r13 = Math.min(r12, this.byteBuffer.remaining());
        this.byteBuffer.get(r10, r11, r13);
        return r13;
    }

    private static CharBuffer grow(CharBuffer r10) {
        CharBuffer r11 = CharBuffer.wrap(Arrays.copyOf(r10.array(), r10.capacity() * 2));
        r11.position(r10.position());
        r11.limit(r10.limit());
        return r11;
    }

    private void readMoreChars() throws IOException {
        if (availableCapacity(this.charBuffer) == 0) goto L5;
    L8:
        int r10 = this.charBuffer.limit();
        int r11 = this.reader.read(this.charBuffer.array(), r10, availableCapacity(this.charBuffer));
        if (r11 != (-1)) goto L11;
        this.endOfInput = true;
        return;
    L11:
        this.charBuffer.limit(r10 + r11);
        return;
    L5:
        if (this.charBuffer.position() <= 0) goto L7;
        this.charBuffer.compact().flip();
        goto L8
    L7:
        this.charBuffer = grow(this.charBuffer);
        goto L8
    }

    private void startDraining(boolean r10) {
        this.byteBuffer.flip();
        if (r10 == true) goto L5;
    L7:
        this.draining = true;
        return;
    L5:
        if (this.byteBuffer.remaining() != 0) goto L7;
        this.byteBuffer = ByteBuffer.allocate(this.byteBuffer.capacity() * 2);
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.reader.close();
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        if (read(this.singleByte) == 1) goto L7;
        return -1;
    L7:
        return UnsignedBytes.toInt(this.singleByte[0]);
    }

    @Override // java.io.InputStream
    public int read(byte[] r10, int r11, int r12) throws IOException {
        Preconditions.checkPositionIndexes(r11, r11 + r12, r10.length);
        if (r12 != 0) goto L5;
        return 0;
    L5:
        boolean r13 = this.endOfInput;
        int r14 = 0;
    L7:
        if (this.draining == false) goto L19;
        r14 = r14 + drain(r10, r11 + r14, r12 - r14);
        if (r14 == r12) goto L14;
        if (this.doneFlushing == true) goto L14;
        this.draining = false;
        this.byteBuffer.clear();
    L14:
        if (r14 > 0) goto L56;
        return -1;
    L56:
        return r14;
    L19:
        if (this.doneFlushing == false) goto L21;
        CoderResult r15 = CoderResult.UNDERFLOW;
    L25:
        if (r15.isOverflow() == true) goto L26;
        if (r15.isUnderflow() == true) goto L29;
        if (r15.isError() == false) goto L19;
        r15.throwException();
        return 0;
    L29:
        if (r13 == true) goto L30;
        if (this.endOfInput == true) goto L33;
        readMoreChars();
        goto L19
    L33:
        r13 = true;
        goto L19
    L30:
        this.doneFlushing = true;
        startDraining(false);
        goto L7
    L26:
        startDraining(true);
        goto L7
    L21:
        if (r13 == false) goto L23;
        r15 = this.encoder.flush(this.byteBuffer);
        goto L25
    L23:
        r15 = this.encoder.encode(this.charBuffer, this.byteBuffer, this.endOfInput);
        goto L25
    }

    public ReaderInputStream(Reader r10, CharsetEncoder r11, int r12) {
        boolean r13 = true;
        this.singleByte = new byte[1];
        this.reader = (Reader) Preconditions.checkNotNull(r10);
        this.encoder = (CharsetEncoder) Preconditions.checkNotNull(r11);
        if (r12 > 0) goto L6;
        r13 = false;
    L6:
        Preconditions.checkArgument(r13, "bufferSize must be positive: %s", r12);
        r11.reset();
        CharBuffer r14 = CharBuffer.allocate(r12);
        this.charBuffer = r14;
        r14.flip();
        this.byteBuffer = ByteBuffer.allocate(r12);
    }
}
