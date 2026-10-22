package a3;

import java.util.concurrent.atomic.AtomicReferenceArray;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: c, reason: collision with root package name */
    public static final int[] f8c = {8000, 8000, 2000, 2000};

    /* renamed from: d, reason: collision with root package name */
    public static final int[] f9d = {4000, 4000, 200, 200};

    /* renamed from: a, reason: collision with root package name */
    public final AtomicReferenceArray<byte[]> f10a = new AtomicReferenceArray<>(4);

    /* renamed from: b, reason: collision with root package name */
    public final AtomicReferenceArray<char[]> f11b = new AtomicReferenceArray<>(4);

    public final byte[] a(int i10) {
        int i11 = f8c[i10];
        if (i11 <= 0) {
            i11 = 0;
        }
        byte[] andSet = this.f10a.getAndSet(i10, null);
        return (andSet == null || andSet.length < i11) ? new byte[i11] : andSet;
    }

    public final char[] b(int i10, int i11) {
        int i12 = f9d[i10];
        if (i11 < i12) {
            i11 = i12;
        }
        char[] andSet = this.f11b.getAndSet(i10, null);
        return (andSet == null || andSet.length < i11) ? new char[i11] : andSet;
    }
}
