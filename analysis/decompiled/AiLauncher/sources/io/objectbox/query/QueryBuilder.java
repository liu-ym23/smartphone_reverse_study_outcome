package io.objectbox.query;

/* loaded from: classes4.dex */
public class QueryBuilder<T> {

    /* renamed from: a, reason: collision with root package name */
    public long f34374a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f34375b;

    private native long nativeBetween(long j10, int i10, double d10, double d11);

    private native long nativeBetween(long j10, int i10, long j11, long j12);

    private native long nativeBuild(long j10);

    private native long nativeCombine(long j10, long j11, long j12, boolean z10);

    private native long nativeContains(long j10, int i10, String str, boolean z10);

    private native long nativeContainsElement(long j10, int i10, String str, boolean z10);

    private native long nativeCreate(long j10, String str);

    private native void nativeDestroy(long j10);

    private native long nativeEndsWith(long j10, int i10, String str, boolean z10);

    private native long nativeEqual(long j10, int i10, long j11);

    private native long nativeEqual(long j10, int i10, String str, boolean z10);

    private native long nativeEqual(long j10, int i10, byte[] bArr);

    private native long nativeEqualKeyValue(long j10, int i10, String str, double d10);

    private native long nativeEqualKeyValue(long j10, int i10, String str, long j11);

    private native long nativeEqualKeyValue(long j10, int i10, String str, String str2, boolean z10);

    private native long nativeGreater(long j10, int i10, double d10, boolean z10);

    private native long nativeGreater(long j10, int i10, long j11, boolean z10);

    private native long nativeGreater(long j10, int i10, String str, boolean z10, boolean z11);

    private native long nativeGreater(long j10, int i10, byte[] bArr, boolean z10);

    private native long nativeGreaterEqualsKeyValue(long j10, int i10, String str, double d10);

    private native long nativeGreaterEqualsKeyValue(long j10, int i10, String str, long j11);

    private native long nativeGreaterEqualsKeyValue(long j10, int i10, String str, String str2, boolean z10);

    private native long nativeGreaterKeyValue(long j10, int i10, String str, double d10);

    private native long nativeGreaterKeyValue(long j10, int i10, String str, long j11);

    private native long nativeGreaterKeyValue(long j10, int i10, String str, String str2, boolean z10);

    private native long nativeIn(long j10, int i10, int[] iArr, boolean z10);

    private native long nativeIn(long j10, int i10, long[] jArr, boolean z10);

    private native long nativeIn(long j10, int i10, String[] strArr, boolean z10);

    private native long nativeLess(long j10, int i10, double d10, boolean z10);

    private native long nativeLess(long j10, int i10, long j11, boolean z10);

    private native long nativeLess(long j10, int i10, String str, boolean z10, boolean z11);

    private native long nativeLess(long j10, int i10, byte[] bArr, boolean z10);

    private native long nativeLessEqualsKeyValue(long j10, int i10, String str, double d10);

    private native long nativeLessEqualsKeyValue(long j10, int i10, String str, long j11);

    private native long nativeLessEqualsKeyValue(long j10, int i10, String str, String str2, boolean z10);

    private native long nativeLessKeyValue(long j10, int i10, String str, double d10);

    private native long nativeLessKeyValue(long j10, int i10, String str, long j11);

    private native long nativeLessKeyValue(long j10, int i10, String str, String str2, boolean z10);

    private native long nativeLink(long j10, long j11, int i10, int i11, int i12, int i13, boolean z10);

    private native long nativeNearestNeighborsF32(long j10, int i10, float[] fArr, int i11);

    private native long nativeNotEqual(long j10, int i10, long j11);

    private native long nativeNotEqual(long j10, int i10, String str, boolean z10);

    private native long nativeNotNull(long j10, int i10);

    private native long nativeNull(long j10, int i10);

    private native void nativeOrder(long j10, int i10, int i11);

    private native long nativeRelationCount(long j10, long j11, int i10, int i11, int i12);

    private native void nativeSetParameterAlias(long j10, String str);

    private native long nativeStartsWith(long j10, int i10, String str, boolean z10);

    public synchronized void a() {
        long j10 = this.f34374a;
        if (j10 != 0) {
            this.f34374a = 0L;
            if (!this.f34375b) {
                nativeDestroy(j10);
            }
        }
    }

    public void finalize() throws Throwable {
        a();
        super.finalize();
    }
}
