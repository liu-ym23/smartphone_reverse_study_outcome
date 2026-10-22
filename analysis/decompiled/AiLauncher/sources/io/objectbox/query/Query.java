package io.objectbox.query;

import java.io.Closeable;
import java.util.List;

/* loaded from: classes4.dex */
public class Query<T> implements Closeable {
    private native void nativeSetParameters(long j10, int i10, int i11, String str, String str2, String str3);

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        throw null;
    }

    public void finalize() throws Throwable {
        close();
        super.finalize();
    }

    public native long nativeClone(long j10);

    public native long nativeCount(long j10, long j11);

    public native String nativeDescribeParameters(long j10);

    public native void nativeDestroy(long j10);

    public native List<T> nativeFind(long j10, long j11, long j12, long j13) throws Exception;

    public native Object nativeFindFirst(long j10, long j11);

    public native long nativeFindFirstId(long j10, long j11);

    public native long[] nativeFindIds(long j10, long j11, long j12, long j13);

    public native List<Object> nativeFindIdsWithScores(long j10, long j11, long j12, long j13);

    public native Object nativeFindUnique(long j10, long j11);

    public native long nativeFindUniqueId(long j10, long j11);

    public native List<Object> nativeFindWithScores(long j10, long j11, long j12, long j13);

    public native long nativeRemove(long j10, long j11);

    public native void nativeSetParameter(long j10, int i10, int i11, String str, double d10);

    public native void nativeSetParameter(long j10, int i10, int i11, String str, long j11);

    public native void nativeSetParameter(long j10, int i10, int i11, String str, String str2);

    public native void nativeSetParameter(long j10, int i10, int i11, String str, byte[] bArr);

    public native void nativeSetParameter(long j10, int i10, int i11, String str, float[] fArr);

    public native void nativeSetParameters(long j10, int i10, int i11, String str, double d10, double d11);

    public native void nativeSetParameters(long j10, int i10, int i11, String str, long j11, long j12);

    public native void nativeSetParameters(long j10, int i10, int i11, String str, int[] iArr);

    public native void nativeSetParameters(long j10, int i10, int i11, String str, long[] jArr);

    public native void nativeSetParameters(long j10, int i10, int i11, String str, String[] strArr);

    public native String nativeToString(long j10);
}
