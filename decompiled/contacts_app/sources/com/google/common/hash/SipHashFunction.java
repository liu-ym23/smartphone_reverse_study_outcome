package com.google.common.hash;

import com.google.common.base.Preconditions;
import java.io.Serializable;
import java.nio.ByteBuffer;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes2.dex */
final class SipHashFunction extends AbstractStreamingHashFunction implements Serializable {
    private static final long serialVersionUID = 0;
    private final int c;
    private final int d;
    private final long k0;
    private final long k1;

    private static final class SipHasher extends AbstractStreamingHashFunction.AbstractStreamingHasher {
        private static final int CHUNK_SIZE = 8;
        private long b;
        private final int c;
        private final int d;
        private long finalM;
        private long v0;
        private long v1;
        private long v2;
        private long v3;

        SipHasher(int r3, int r4, long r5, long r7) {
            super(8);
            this.b = 0;
            this.finalM = 0;
            this.c = r3;
            this.d = r4;
            this.v0 = 8317987319222330741L ^ r5;
            this.v1 = 7237128888997146477L ^ r7;
            this.v2 = 7816392313619706465L ^ r5;
            this.v3 = 8387220255154660723L ^ r7;
        }

        @Override // com.google.common.hash.AbstractStreamingHashFunction.AbstractStreamingHasher
        protected void process(ByteBuffer r5) {
            this.b += 8;
            processM(r5.getLong());
        }

        @Override // com.google.common.hash.AbstractStreamingHashFunction.AbstractStreamingHasher
        protected void processRemaining(ByteBuffer r8) {
            this.b += (long) r8.remaining();
            int r0 = 0;
        L4:
            if (r8.hasRemaining() == false) goto L6;
            this.finalM ^= (((long) r8.get()) & 255) << r0;
            r0 = r0 + 8;
            goto L4
        }

        @Override // com.google.common.hash.AbstractStreamingHashFunction.AbstractStreamingHasher
        public HashCode makeHash() {
            long r0 = this.finalM ^ (this.b << 56);
            this.finalM = r0;
            processM(r0);
            this.v2 ^= 255;
            sipRound(this.d);
            return HashCode.fromLong(((this.v0 ^ this.v1) ^ this.v2) ^ this.v3);
        }

        private void processM(long r3) {
            this.v3 ^= r3;
            sipRound(this.c);
            this.v0 = r3 ^ this.v0;
        }

        private void sipRound(int r9) {
            int r0 = 0;
        L3:
            if (r0 >= r9) goto L5;
            long r1 = this.v0;
            long r3 = this.v1;
            this.v0 = r1 + r3;
            this.v2 += this.v3;
            this.v1 = Long.rotateLeft(r3, 13);
            long r2 = Long.rotateLeft(this.v3, 16);
            long r4 = this.v1;
            long r5 = this.v0;
            this.v1 = r4 ^ r5;
            this.v3 = r2 ^ this.v2;
            long r6 = Long.rotateLeft(r5, 32);
            long r7 = this.v2;
            long r8 = this.v1;
            this.v2 = r7 + r8;
            this.v0 = r6 + this.v3;
            this.v1 = Long.rotateLeft(r8, 17);
            long r10 = Long.rotateLeft(this.v3, 21);
            long r11 = this.v1;
            long r12 = this.v2;
            this.v1 = r11 ^ r12;
            this.v3 = r10 ^ this.v0;
            this.v2 = Long.rotateLeft(r12, 32);
            r0 = r0 + 1;
            goto L3
        }
    }

    @Override // com.google.common.hash.HashFunction
    public int bits() {
        return 64;
    }

    SipHashFunction(int r6, int r7, long r8, long r10) {
        if (r6 <= 0) goto L5;
        boolean r2 = true;
    L6:
        Preconditions.checkArgument(r2, "The number of SipRound iterations (c=%s) during Compression must be positive.", new Object[]{Integer.valueOf(r6)});
        if (r7 <= 0) goto L9;
        boolean r3 = true;
    L10:
        Preconditions.checkArgument(r3, "The number of SipRound iterations (d=%s) during Finalization must be positive.", new Object[]{Integer.valueOf(r7)});
        this.c = r6;
        this.d = r7;
        this.k0 = r8;
        this.k1 = r10;
        return;
    L9:
        r3 = false;
        goto L10
    L5:
        r2 = false;
        goto L6
    }

    @Override // com.google.common.hash.HashFunction
    public Hasher newHasher() {
        return new SipHasher(this.c, this.d, this.k0, this.k1);
    }

    public String toString() {
        return "Hashing.sipHash" + this.c + "" + this.d + "(" + this.k0 + ", " + this.k1 + ")";
    }

    public boolean equals(@Nullable Object r7) {
        if ((r7 instanceof SipHashFunction) == false) goto L14;
        SipHashFunction r8 = (SipHashFunction) r7;
        if (this.c == r8.c) goto L7;
        return false;
    L7:
        if (this.d == r8.d) goto L9;
        return false;
    L9:
        if (this.k0 == r8.k0) goto L11;
        return false;
    L11:
        if (this.k1 != r8.k1) goto L18;
        return true;
    L18:
        return false;
    L14:
        return false;
    }

    public int hashCode() {
        return (int) ((((long) ((getClass().hashCode() ^ this.c) ^ this.d)) ^ this.k0) ^ this.k1);
    }
}
