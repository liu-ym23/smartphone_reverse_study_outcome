package io.objectbox;

import java.io.Closeable;
import java.util.List;

/* loaded from: classes4.dex */
public abstract class Cursor<T> implements Closeable {

    /* renamed from: f, reason: collision with root package name */
    public static boolean f34324f;

    /* renamed from: a, reason: collision with root package name */
    public final Transaction f34325a;

    /* renamed from: b, reason: collision with root package name */
    public final long f34326b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f34327c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f34328d;

    /* renamed from: e, reason: collision with root package name */
    public final Throwable f34329e;

    public static native long collect002033(long j10, long j11, int i10, int i11, long j12, int i12, long j13, int i13, float f10, int i14, float f11, int i15, float f12, int i16, double d10, int i17, double d11, int i18, double d12);

    public static native long collect004000(long j10, long j11, int i10, int i11, long j12, int i12, long j13, int i13, long j14, int i14, long j15);

    public static native long collect313311(long j10, long j11, int i10, int i11, String str, int i12, String str2, int i13, String str3, int i14, byte[] bArr, int i15, long j12, int i16, long j13, int i17, long j14, int i18, int i19, int i20, int i21, int i22, int i23, int i24, float f10, int i25, double d10);

    public static native long collect400000(long j10, long j11, int i10, int i11, String str, int i12, String str2, int i13, String str3, int i14, String str4);

    public static native long collect430000(long j10, long j11, int i10, int i11, String str, int i12, String str2, int i13, String str3, int i14, String str4, int i15, byte[] bArr, int i16, byte[] bArr2, int i17, byte[] bArr3);

    public static native long collectBooleanArray(long j10, long j11, int i10, int i11, boolean[] zArr);

    public static native long collectCharArray(long j10, long j11, int i10, int i11, char[] cArr);

    public static native long collectDoubleArray(long j10, long j11, int i10, int i11, double[] dArr);

    public static native long collectFloatArray(long j10, long j11, int i10, int i11, float[] fArr);

    public static native long collectIntArray(long j10, long j11, int i10, int i11, int[] iArr);

    public static native long collectLongArray(long j10, long j11, int i10, int i11, long[] jArr);

    public static native long collectShortArray(long j10, long j11, int i10, int i11, short[] sArr);

    public static native long collectStringArray(long j10, long j11, int i10, int i11, String[] strArr);

    public static native long collectStringList(long j10, long j11, int i10, int i11, List<String> list);

    public static native boolean nativeDeleteEntity(long j10, long j11);

    public static native Object nativeFirstEntity(long j10);

    public static native Object nativeGetEntity(long j10, long j11);

    public static native long nativeLookupKeyUsingIndex(long j10, int i10, String str);

    public static native Object nativeNextEntity(long j10);

    public static native boolean nativeSeek(long j10, long j11);

    public void A() {
        nativeRenew(this.f34326b);
    }

    public long b(long j10) {
        return nativeCount(this.f34326b, j10);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        if (!this.f34328d) {
            this.f34328d = true;
            Transaction transaction = this.f34325a;
            if (transaction != null && !transaction.m().isClosed()) {
                nativeDestroy(this.f34326b);
            }
        }
    }

    public boolean e(long j10) {
        return nativeDeleteEntity(this.f34326b, j10);
    }

    public void finalize() throws Throwable {
        if (this.f34328d) {
            return;
        }
        if (!this.f34327c || f34324f) {
            System.err.println("Cursor was not closed.");
            if (this.f34329e != null) {
                System.err.println("Cursor was initially created here:");
                this.f34329e.printStackTrace();
            }
            System.err.flush();
        }
        close();
        super.finalize();
    }

    public T g() {
        return (T) nativeFirstEntity(this.f34326b);
    }

    public abstract long i(T t10);

    public boolean isClosed() {
        return this.f34328d;
    }

    public Transaction l() {
        return this.f34325a;
    }

    public T m() {
        return (T) nativeNextEntity(this.f34326b);
    }

    public abstract long n(T t10);

    public native long nativeCount(long j10, long j11);

    public native void nativeDeleteAll(long j10);

    public native void nativeDestroy(long j10);

    public native List<T> nativeGetAllEntities(long j10);

    public native List<T> nativeGetBacklinkEntities(long j10, int i10, int i11, long j11);

    public native long[] nativeGetBacklinkIds(long j10, int i10, int i11, long j11);

    public native long nativeGetCursorFor(long j10, int i10);

    public native List<T> nativeGetRelationEntities(long j10, int i10, int i11, long j11, boolean z10);

    public native long[] nativeGetRelationIds(long j10, int i10, int i11, long j11, boolean z10);

    public native void nativeModifyRelations(long j10, int i10, long j11, long[] jArr, boolean z10);

    public native void nativeModifyRelationsSingle(long j10, int i10, long j11, long j12, boolean z10);

    public native int nativePropertyId(long j10, String str);

    public native long nativeRenew(long j10);

    public native void nativeSetBoxStoreForEntities(long j10, Object obj);

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Cursor ");
        sb2.append(Long.toString(this.f34326b, 16));
        sb2.append(isClosed() ? "(closed)" : "");
        return sb2.toString();
    }
}
