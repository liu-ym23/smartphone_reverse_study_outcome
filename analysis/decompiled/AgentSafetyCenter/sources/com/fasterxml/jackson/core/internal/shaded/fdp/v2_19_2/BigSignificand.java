package com.fasterxml.jackson.core.internal.shaded.fdp.v2_19_2;

import g5.f;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import k0.a;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
class BigSignificand {
    private static final long LONG_MASK = 4294967295L;
    private int firstNonZeroInt;
    private final int numInts;

    /* renamed from: x, reason: collision with root package name */
    private final int[] f2290x;

    public BigSignificand(long j10) {
        if (j10 <= 0 || j10 >= 2147483647L) {
            f.s(a.m("numBits=", j10));
            throw null;
        }
        int i = (((int) ((j10 + 63) >>> 6)) + 1) << 1;
        this.numInts = i;
        this.f2290x = new int[i];
        this.firstNonZeroInt = i;
    }

    private void x(int i, int i3) {
        this.f2290x[i] = i3;
    }

    public void add(int i) {
        if (i == 0) {
            return;
        }
        long j10 = i & LONG_MASK;
        int i3 = this.numInts;
        while (true) {
            i3--;
            if (j10 == 0) {
                this.firstNonZeroInt = Math.min(this.firstNonZeroInt, i3 + 1);
                return;
            } else {
                long jX = (x(i3) & LONG_MASK) + j10;
                x(i3, (int) jX);
                j10 = jX >>> 32;
            }
        }
    }

    public void fma(int i, int i3) {
        long j10 = i & LONG_MASK;
        long j11 = i3;
        int i10 = this.numInts;
        while (true) {
            i10--;
            if (i10 < this.firstNonZeroInt) {
                break;
            }
            long jX = ((x(i10) & LONG_MASK) * j10) + j11;
            x(i10, (int) jX);
            j11 = jX >>> 32;
        }
        if (j11 != 0) {
            x(i10, (int) j11);
            this.firstNonZeroInt = i10;
        }
    }

    public BigInteger toBigInteger() {
        byte[] bArr = new byte[this.f2290x.length << 2];
        IntBuffer intBufferAsIntBuffer = ByteBuffer.wrap(bArr).asIntBuffer();
        int i = 0;
        while (true) {
            int[] iArr = this.f2290x;
            if (i >= iArr.length) {
                return new BigInteger(bArr);
            }
            intBufferAsIntBuffer.put(i, iArr[i]);
            i++;
        }
    }

    private int x(int i) {
        return this.f2290x[i];
    }
}
