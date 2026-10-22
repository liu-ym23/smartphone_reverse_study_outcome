package org.bouncycastle.util.io;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.bouncycastle.util.Arrays;

/* loaded from: classes.dex */
public final class Streams {
    private static int BUFFER_SIZE = 4096;

    public static void drain(InputStream inputStream) {
        int i8 = BUFFER_SIZE;
        while (inputStream.read(new byte[i8], 0, i8) >= 0) {
        }
    }

    public static void pipeAll(InputStream inputStream, OutputStream outputStream) throws IOException {
        pipeAll(inputStream, outputStream, BUFFER_SIZE);
    }

    public static long pipeAllLimited(InputStream inputStream, long j4, OutputStream outputStream) throws IOException {
        int i8 = BUFFER_SIZE;
        byte[] bArr = new byte[i8];
        long j8 = 0;
        while (true) {
            int i9 = inputStream.read(bArr, 0, i8);
            if (i9 < 0) {
                return j8;
            }
            long j9 = i9;
            if (j4 - j8 < j9) {
                throw new StreamOverflowException("Data Overflow");
            }
            j8 += j9;
            outputStream.write(bArr, 0, i9);
        }
    }

    public static byte[] readAll(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        pipeAll(inputStream, byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    public static byte[] readAllLimited(InputStream inputStream, int i8) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        pipeAllLimited(inputStream, i8, byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    public static int readFully(InputStream inputStream, byte[] bArr) {
        return readFully(inputStream, bArr, 0, bArr.length);
    }

    public static void validateBufferArguments(byte[] bArr, int i8, int i9) {
        Arrays.validateSegment(bArr, i8, i9);
    }

    public static void writeBufTo(ByteArrayOutputStream byteArrayOutputStream, OutputStream outputStream) throws IOException {
        byteArrayOutputStream.writeTo(outputStream);
    }

    public static void pipeAll(InputStream inputStream, OutputStream outputStream, int i8) throws IOException {
        byte[] bArr = new byte[i8];
        while (true) {
            int i9 = inputStream.read(bArr, 0, i8);
            if (i9 < 0) {
                return;
            } else {
                outputStream.write(bArr, 0, i9);
            }
        }
    }

    public static int readFully(InputStream inputStream, byte[] bArr, int i8, int i9) throws IOException {
        int i10 = 0;
        while (i10 < i9) {
            int i11 = inputStream.read(bArr, i8 + i10, i9 - i10);
            if (i11 < 0) {
                break;
            }
            i10 += i11;
        }
        return i10;
    }
}
