package org.brotli.wrapper.dec;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.ReadableByteChannel;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes3.dex */
public class Decoder {
    private static final ByteBuffer EMPTY_BUFER = null;
    ByteBuffer buffer;
    boolean closed;
    private final DecoderJNI.Wrapper decoder;
    boolean eager;
    private final ReadableByteChannel source;

    /* JADX INFO: renamed from: org.brotli.wrapper.dec.Decoder$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$brotli$wrapper$dec$DecoderJNI$Status = null;

        static {
            $SwitchMap$org$brotli$wrapper$dec$DecoderJNI$Status = new int[DecoderJNI.Status.values().length];
            $SwitchMap$org$brotli$wrapper$dec$DecoderJNI$Status[DecoderJNI.Status.DONE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L5
        L22:
            $SwitchMap$org$brotli$wrapper$dec$DecoderJNI$Status[DecoderJNI.Status.OK.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L18:
            $SwitchMap$org$brotli$wrapper$dec$DecoderJNI$Status[DecoderJNI.Status.NEEDS_MORE_INPUT.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L16:
            $SwitchMap$org$brotli$wrapper$dec$DecoderJNI$Status[DecoderJNI.Status.NEEDS_MORE_OUTPUT.ordinal()] = 4;     // Catch: NoSuchFieldError -> L14
            return;
        }
    }

    static {
        EMPTY_BUFER = ByteBuffer.allocate(0);
    }

    public Decoder(ReadableByteChannel source, int inputBufferSize) throws IOException {
        if (inputBufferSize <= 0) goto L10;
        if (source == null) goto L8;
        this.source = source;
        this.decoder = new DecoderJNI.Wrapper(inputBufferSize);
        return;
    L8:
        throw new NullPointerException("source can not be null");
    L10:
        throw new IllegalArgumentException("buffer size must be positive");
    }

    private void fail(String message) throws IOException {
        close();     // Catch: IOException -> L4
    L6:
        throw new IOException(message);
    }

    public void enableEagerOutput() {
        this.eager = true;
    }

    int decode() throws IOException {
    L3:
        if (this.buffer == null) goto L10;
        if (this.buffer.hasRemaining() == true) goto L8;
        this.buffer = null;
        goto L10
    L8:
        return this.buffer.remaining();
    L10:
        switch(AnonymousClass1.$SwitchMap$org$brotli$wrapper$dec$DecoderJNI$Status[this.decoder.getStatus().ordinal()]) {
            case 1: goto L26;
            case 2: goto L25;
            case 3: goto L14;
            case 4: goto L12;
            default: goto L11;
        };
    L12:
        this.buffer = this.decoder.pull();
        goto L3
    L14:
        if (this.eager == false) goto L18;
        if (this.decoder.hasOutput() == false) goto L18;
        this.buffer = this.decoder.pull();
    L18:
        ByteBuffer inputBuffer = this.decoder.getInputBuffer();
        inputBuffer.clear();
        int bytesRead = this.source.read(inputBuffer);
        if (bytesRead != (-1)) goto L21;
        fail("unexpected end of input");
    L21:
        if (bytesRead == 0) goto L22;
        this.decoder.push(bytesRead);
        goto L3
    L22:
        this.buffer = EMPTY_BUFER;
        return 0;
    L25:
        this.decoder.push(0);
        goto L3
    L26:
        return -1;
    L11:
        fail("corrupted input");
        goto L3
    }

    void discard(int length) {
        this.buffer.position(this.buffer.position() + length);
        if (this.buffer.hasRemaining() == true) goto L6;
        this.buffer = null;
        return;
    }

    int consume(ByteBuffer dst) {
        ByteBuffer slice = this.buffer.slice();
        int limit = Math.min(slice.remaining(), dst.remaining());
        slice.limit(limit);
        dst.put(slice);
        discard(limit);
        return limit;
    }

    void close() throws IOException {
        if (this.closed == false) goto L5;
        return;
    L5:
        this.closed = true;
        this.decoder.destroy();
        this.source.close();
    }

    public static byte[] decompress(byte[] data) throws IOException {
        DecoderJNI.Wrapper decoder = new DecoderJNI.Wrapper(data.length);
        ArrayList<byte[]> output = new ArrayList();
        int totalOutputSize = 0;
        decoder.getInputBuffer().put(data);     // Catch: Throwable -> L10
        decoder.push(data.length);     // Catch: Throwable -> L10
    L5:
        if (decoder.getStatus() == DecoderJNI.Status.DONE) goto L15;
        switch(AnonymousClass1.$SwitchMap$org$brotli$wrapper$dec$DecoderJNI$Status[decoder.getStatus().ordinal()]) {
            case 2: goto L13;
            case 3: goto L9;
            case 4: goto L12;
            default: goto L9;
        };     // Catch: Throwable -> L10
    L9:
        throw new IOException("corrupted input");     // Catch: Throwable -> L10
    L13:
        decoder.push(0);     // Catch: Throwable -> L10
        goto L5
    L12:
        ByteBuffer buffer = decoder.pull();     // Catch: Throwable -> L10
        byte[] chunk = new byte[buffer.remaining()];     // Catch: Throwable -> L10
        buffer.get(chunk);     // Catch: Throwable -> L10
        output.add(chunk);     // Catch: Throwable -> L10
        totalOutputSize = totalOutputSize + chunk.length;     // Catch: Throwable -> L10
        goto L5
    L15:
        decoder.destroy();
        if (output.size() == 1) goto L18;
        byte[] result = new byte[totalOutputSize];
        int offset = 0;
        Iterator<byte[]> r6 = output.iterator();
    L21:
        if (r6.hasNext() == false) goto L23;
        byte[] chunk2 = r6.next();
        System.arraycopy(chunk2, 0, result, offset, chunk2.length);
        offset = offset + chunk2.length;
        goto L21
    L23:
        return result;
    L18:
        return output.get(0);
    L10:
        th = move-exception;
        decoder.destroy();
        throw th;
    }
}
