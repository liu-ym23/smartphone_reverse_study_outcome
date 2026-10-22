package abc;

import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte[] f2520a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f2521b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f2522c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f2523d;

    public final String toString() {
        return "AudioFrame(data=" + Arrays.toString(this.f2520a) + ", size=" + this.f2521b + ", timestampMs=" + this.f2522c + ", isFinish=" + this.f2523d + ')';
    }

    public final int hashCode() {
        int r100 = this.f2521b * 31;
        long r101 = this.f2522c;
        return ((r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31) + Arrays.hashCode(this.f2520a);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (this.f2521b == r101.f2521b) goto L12;
        return false;
    L12:
        if (this.f2522c == r101.f2522c) goto L15;
        return false;
    L15:
        if (Arrays.equals(this.f2520a, r101.f2520a) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public a(byte[] r100, int r101, long r102, boolean r103) {
        Intrinsics.checkNotNullParameter(r100, "data");
        this.f2520a = r100;
        this.f2521b = r101;
        this.f2522c = r102;
        this.f2523d = r103;
    }
}
