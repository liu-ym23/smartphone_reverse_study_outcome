package org.apache.commons.compress.utils;

import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.ReadableByteChannel;

/* JADX INFO: loaded from: classes3.dex */
public final class IOUtils {
    private static final int COPY_BUF_SIZE = 8024;
    private static final byte[] SKIP_BUF = null;
    private static final int SKIP_BUF_SIZE = 4096;

    static {
        SKIP_BUF = new byte[4096];
    }

    private IOUtils() {
    }

    public static long copy(InputStream input, OutputStream output) throws IOException {
        return copy(input, output, COPY_BUF_SIZE);
    }

    public static long copy(InputStream input, OutputStream output, int buffersize) throws IOException {
        if (buffersize < 1) goto L10;
        byte[] buffer = new byte[buffersize];
        long count = 0;
    L5:
        int n = input.read(buffer);
        if ((-1) == n) goto L8;
        output.write(buffer, 0, n);
        count = count + ((long) n);
        goto L5
    L8:
        return count;
    L10:
        throw new IllegalArgumentException("buffersize must be bigger than 0");
    }

    public static long skip(InputStream input, long numToSkip) throws IOException {
    L4:
        if (numToSkip <= 0) goto L10;
        long skipped = input.skip(numToSkip);
        if (skipped == 0) goto L10;
        numToSkip = numToSkip - skipped;
    L10:
        if (numToSkip <= 0) goto L16;
        int read = readFully(input, SKIP_BUF, 0, (int) Math.min(numToSkip, 4096));
        if (read < 1) goto L16;
        numToSkip = numToSkip - ((long) read);
    L16:
        return numToSkip - numToSkip;
    }

    public static int readFully(InputStream input, byte[] b) throws IOException {
        return readFully(input, b, 0, b.length);
    }

    public static int readFully(InputStream input, byte[] b, int offset, int len) throws IOException {
        if (len < 0) goto L14;
        if (offset < 0) goto L14;
        if ((len + offset) > b.length) goto L14;
        int count = 0;
    L7:
        if (count == len) goto L12;
        int x = input.read(b, offset + count, len - count);
        if (x == (-1)) goto L12;
        count = count + x;
    L12:
        return count;
    L14:
        throw new IndexOutOfBoundsException();
    }

    public static void readFully(ReadableByteChannel channel, ByteBuffer b) throws IOException {
        int expectedLength = b.remaining();
        int read = 0;
    L3:
        if (read >= expectedLength) goto L8;
        int readNow = channel.read(b);
        if (readNow <= 0) goto L8;
        read = read + readNow;
    L8:
        if (read < expectedLength) goto L11;
        return;
    L11:
        throw new EOFException();
    }

    public static byte[] toByteArray(InputStream input) throws IOException {
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        copy(input, output);
        return output.toByteArray();
    }

    public static void closeQuietly(Closeable c) {
        if (c == null) goto L9;
        c.close();     // Catch: IOException -> L5
        return;
    L6:
        return;
    }
}
