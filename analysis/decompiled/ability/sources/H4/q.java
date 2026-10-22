package H4;

import g1.AbstractC1451a;
import java.nio.ShortBuffer;
import java.util.Arrays;

/* loaded from: classes3.dex */
public final class q {

    /* renamed from: a, reason: collision with root package name */
    public final int f749a;
    public final int b;
    public final short[] c;
    public Long d;
    public int e;

    public q(int i, int i6) {
        this.f749a = i;
        this.b = i6;
        this.c = new short[i6];
    }

    public final synchronized int a(short[] sArr, int i, long j5) {
        if (i >= 0) {
            if (i <= sArr.length) {
                Long l = this.d;
                int iU = 0;
                if (l == null) {
                    return 0;
                }
                if (j5 < l.longValue()) {
                    iU = AbstractC1451a.u((int) Math.ceil(((r2 - j5) * this.f749a) / 1000000000), 0, i);
                }
                int i6 = i - iU;
                int i10 = this.b;
                int i11 = this.e;
                int i12 = i10 - i11;
                if (i6 > i12) {
                    i6 = i12;
                }
                System.arraycopy(sArr, iU, this.c, i11, (iU + i6) - iU);
                this.e += i6;
                return i6;
            }
        }
        throw new IllegalArgumentException("Failed requirement.");
    }

    public final synchronized int b() {
        return this.b - this.e;
    }

    public final synchronized boolean c() {
        return this.e >= this.b;
    }

    public final synchronized ShortBuffer d() {
        ShortBuffer shortBufferWrap;
        if (this.e != this.b) {
            shortBufferWrap = null;
        } else {
            short[] sArr = this.c;
            short[] sArrCopyOf = Arrays.copyOf(sArr, sArr.length);
            kotlin.jvm.internal.k.e(sArrCopyOf, "copyOf(...)");
            shortBufferWrap = ShortBuffer.wrap(sArrCopyOf);
        }
        return shortBufferWrap;
    }
}
