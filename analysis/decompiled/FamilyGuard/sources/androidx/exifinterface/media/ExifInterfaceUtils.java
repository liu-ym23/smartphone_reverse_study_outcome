package androidx.exifinterface.media;

import android.media.MediaDataSource;
import android.media.MediaMetadataRetriever;
import android.system.ErrnoException;
import android.system.Os;
import android.util.Log;
import java.io.Closeable;
import java.io.FileDescriptor;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* loaded from: classes.dex */
class ExifInterfaceUtils {
    private static final String TAG = "ExifInterfaceUtils";

    static class Api21Impl {
        private Api21Impl() {
        }

        static void close(FileDescriptor fileDescriptor) throws ErrnoException {
            Os.close(fileDescriptor);
        }

        static FileDescriptor dup(FileDescriptor fileDescriptor) {
            return Os.dup(fileDescriptor);
        }

        static long lseek(FileDescriptor fileDescriptor, long j5, int i5) {
            return Os.lseek(fileDescriptor, j5, i5);
        }
    }

    static class Api23Impl {
        private Api23Impl() {
        }

        static void setDataSource(MediaMetadataRetriever mediaMetadataRetriever, MediaDataSource mediaDataSource) throws IllegalArgumentException {
            mediaMetadataRetriever.setDataSource(mediaDataSource);
        }
    }

    private ExifInterfaceUtils() {
    }

    static String byteArrayToHexString(byte[] bArr) {
        StringBuilder sb = new StringBuilder(bArr.length * 2);
        for (byte b6 : bArr) {
            sb.append(String.format("%02x", Byte.valueOf(b6)));
        }
        return sb.toString();
    }

    static void closeFileDescriptor(FileDescriptor fileDescriptor) {
        try {
            Api21Impl.close(fileDescriptor);
        } catch (Exception unused) {
            Log.e(TAG, "Error closing fd.");
        }
    }

    static void closeQuietly(Closeable closeable) throws IOException {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (RuntimeException e6) {
                throw e6;
            } catch (Exception unused) {
            }
        }
    }

    static long[] convertToLongArray(Object obj) {
        if (!(obj instanceof int[])) {
            if (obj instanceof long[]) {
                return (long[]) obj;
            }
            return null;
        }
        int[] iArr = (int[]) obj;
        long[] jArr = new long[iArr.length];
        for (int i5 = 0; i5 < iArr.length; i5++) {
            jArr[i5] = iArr[i5];
        }
        return jArr;
    }

    static int copy(InputStream inputStream, OutputStream outputStream) throws IOException {
        byte[] bArr = new byte[8192];
        int i5 = 0;
        while (true) {
            int i6 = inputStream.read(bArr);
            if (i6 == -1) {
                return i5;
            }
            i5 += i6;
            outputStream.write(bArr, 0, i6);
        }
    }

    static long parseSubSeconds(String str) throws NumberFormatException {
        try {
            int iMin = Math.min(str.length(), 3);
            long j5 = Long.parseLong(str.substring(0, iMin));
            while (iMin < 3) {
                j5 *= 10;
                iMin++;
            }
            return j5;
        } catch (NumberFormatException unused) {
            return 0L;
        }
    }

    static boolean startsWith(byte[] bArr, byte[] bArr2) {
        if (bArr == null || bArr2 == null || bArr.length < bArr2.length) {
            return false;
        }
        for (int i5 = 0; i5 < bArr2.length; i5++) {
            if (bArr[i5] != bArr2[i5]) {
                return false;
            }
        }
        return true;
    }

    static void copy(InputStream inputStream, OutputStream outputStream, int i5) throws IOException {
        byte[] bArr = new byte[8192];
        while (i5 > 0) {
            int iMin = Math.min(i5, 8192);
            int i6 = inputStream.read(bArr, 0, iMin);
            if (i6 == iMin) {
                i5 -= i6;
                outputStream.write(bArr, 0, i6);
            } else {
                throw new IOException("Failed to copy the given amount of bytes from the inputstream to the output stream.");
            }
        }
    }
}
