package org.brotli.wrapper.enc;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.WritableByteChannel;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes3.dex */
public class Encoder {
    private ByteBuffer buffer;
    boolean closed;
    private final WritableByteChannel destination;
    private final EncoderJNI.Wrapper encoder;
    final ByteBuffer inputBuffer;

    public static final class Parameters {
        private int lgwin;
        private int quality;

        /* JADX INFO: renamed from: -$$Nest$fgetlgwin, reason: not valid java name */
        static /* bridge */ /* synthetic */ int m10583$$Nest$fgetlgwin(Parameters r0) {
            return r0.lgwin;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetquality, reason: not valid java name */
        static /* bridge */ /* synthetic */ int m10584$$Nest$fgetquality(Parameters r0) {
            return r0.quality;
        }

        public Parameters() {
            this.quality = -1;
            this.lgwin = -1;
        }

        private Parameters(Parameters other) {
            this.quality = -1;
            this.lgwin = -1;
            this.quality = other.quality;
            this.lgwin = other.lgwin;
        }

        public Parameters setQuality(int quality) {
            if (quality < (-1)) goto L9;
            if (quality > 11) goto L9;
            this.quality = quality;
            return this;
        L9:
            throw new IllegalArgumentException("quality should be in range [0, 11], or -1");
        }

        public Parameters setWindow(int lgwin) {
            if (lgwin != (-1)) goto L5;
        L11:
            this.lgwin = lgwin;
            return this;
        L5:
            if (lgwin < 10) goto L10;
            if (lgwin <= 24) goto L11;
        L10:
            throw new IllegalArgumentException("lgwin should be in range [10, 24], or -1");
        }
    }

    Encoder(WritableByteChannel destination, Parameters params, int inputBufferSize) throws IOException {
        if (inputBufferSize <= 0) goto L10;
        if (destination == null) goto L8;
        this.destination = destination;
        this.encoder = new EncoderJNI.Wrapper(inputBufferSize, Parameters.m10584$$Nest$fgetquality(params), Parameters.m10583$$Nest$fgetlgwin(params));
        this.inputBuffer = this.encoder.getInputBuffer();
        return;
    L8:
        throw new NullPointerException("destination can not be null");
    L10:
        throw new IllegalArgumentException("buffer size must be positive");
    }

    private void fail(String message) throws IOException {
        close();     // Catch: IOException -> L4
    L6:
        throw new IOException(message);
    }

    boolean pushOutput(boolean force) throws IOException {
    L3:
        if (this.buffer == null) goto L13;
        if (this.buffer.hasRemaining() == false) goto L8;
        this.destination.write(this.buffer);
    L8:
        if (this.buffer.hasRemaining() == false) goto L9;
        if (force == true) goto L3;
        return false;
    L9:
        this.buffer = null;
        goto L3
    L13:
        return true;
    }

    boolean encode(EncoderJNI.Operation op) throws IOException {
        if (op == EncoderJNI.Operation.PROCESS) goto L5;
        boolean force = true;
    L6:
        if (force == false) goto L9;
        this.inputBuffer.limit(this.inputBuffer.position());
    L11:
        boolean hasInput = true;
    L13:
        if (this.encoder.isSuccess() == false) goto L14;
        if (pushOutput(force) == false) goto L17;
        if (this.encoder.hasMoreOutput() == true) goto L20;
        if (this.encoder.hasRemainingInput() == true) goto L23;
        if (hasInput == false) goto L26;
        this.encoder.push(op, this.inputBuffer.limit());
        hasInput = false;
        goto L13
    L26:
        this.inputBuffer.clear();
        return true;
    L23:
        this.encoder.push(op, 0);
        goto L13
    L20:
        this.buffer = this.encoder.pull();
        goto L13
    L17:
        return false;
    L14:
        fail("encoding failed");
        goto L13
    L9:
        if (this.inputBuffer.hasRemaining() == false) goto L11;
        return true;
    L5:
        force = false;
        goto L6
    }

    void flush() throws IOException {
        encode(EncoderJNI.Operation.FLUSH);
    }

    void close() throws IOException {
        if (this.closed == false) goto L5;
        return;
    L5:
        this.closed = true;
        encode(EncoderJNI.Operation.FINISH);     // Catch: Throwable -> L9
        this.encoder.destroy();
        this.destination.close();
        return;
    L9:
        th = move-exception;
        this.encoder.destroy();
        this.destination.close();
        throw th;
    }

    public static byte[] compress(byte[] data, Parameters params) throws IOException {
        if (data.length != 0) goto L6;
        byte[] empty = {6};
        return empty;
    L6:
        EncoderJNI.Wrapper encoder = new EncoderJNI.Wrapper(data.length, Parameters.m10584$$Nest$fgetquality(params), Parameters.m10583$$Nest$fgetlgwin(params));
        ArrayList<byte[]> output = new ArrayList();
        int totalOutputSize = 0;
        encoder.getInputBuffer().put(data);     // Catch: Throwable -> L13
        encoder.push(EncoderJNI.Operation.FINISH, data.length);     // Catch: Throwable -> L13
    L9:
        if (encoder.isSuccess() == false) goto L29;
        if (encoder.hasMoreOutput() == true) goto L12;
        if (encoder.isFinished() == true) goto L19;
        encoder.push(EncoderJNI.Operation.FINISH, 0);     // Catch: Throwable -> L13
        goto L9
    L19:
        encoder.destroy();
        if (output.size() == 1) goto L22;
        byte[] result = new byte[totalOutputSize];
        int offset = 0;
        Iterator<byte[]> r6 = output.iterator();
    L25:
        if (r6.hasNext() == false) goto L27;
        byte[] chunk = r6.next();
        System.arraycopy(chunk, 0, result, offset, chunk.length);
        offset = offset + chunk.length;
        goto L25
    L27:
        return result;
    L22:
        return output.get(0);
    L12:
        ByteBuffer buffer = encoder.pull();     // Catch: Throwable -> L13
        byte[] chunk2 = new byte[buffer.remaining()];     // Catch: Throwable -> L13
        buffer.get(chunk2);     // Catch: Throwable -> L13
        output.add(chunk2);     // Catch: Throwable -> L13
        totalOutputSize = totalOutputSize + chunk2.length;     // Catch: Throwable -> L13
        goto L9
    L29:
        throw new IOException("encoding failed");     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        encoder.destroy();
        throw th;
    }

    public static byte[] compress(byte[] data) throws IOException {
        return compress(data, new Parameters());
    }
}
