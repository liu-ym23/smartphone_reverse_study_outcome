package com.google.common.hash;

import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.Immutable;
import java.io.Serializable;
import java.nio.ByteBuffer;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: loaded from: classes3.dex */
@Immutable
final class SipHashFunction extends AbstractHashFunction implements Serializable {
    static final HashFunction SIP_HASH_24 = null;
    private static final long serialVersionUID = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f10359c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f10360d;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    private final long f10361k0;

    /* JADX INFO: renamed from: k1, reason: collision with root package name */
    private final long f10362k1;

    public static final class SipHasher extends AbstractStreamingHasher {
        private static final int CHUNK_SIZE = 8;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private long f10363b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final int f10364c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final int f10365d;
        private long finalM;

        /* JADX INFO: renamed from: v0, reason: collision with root package name */
        private long f10366v0;

        /* JADX INFO: renamed from: v1, reason: collision with root package name */
        private long f10367v1;

        /* JADX INFO: renamed from: v2, reason: collision with root package name */
        private long f10368v2;

        /* JADX INFO: renamed from: v3, reason: collision with root package name */
        private long f10369v3;

        public SipHasher(int r10, int r11, long r12, long r13) {
            super(8);
            this.f10363b = 0;
            this.finalM = 0;
            this.f10364c = r10;
            this.f10365d = r11;
            this.f10366v0 = 8317987319222330741L ^ r12;
            this.f10367v1 = 7237128888997146477L ^ r13;
            this.f10368v2 = 7816392313619706465L ^ r12;
            this.f10369v3 = 8387220255154660723L ^ r13;
        }

        private void processM(long r10) {
            this.f10369v3 ^= r10;
            sipRound(this.f10364c);
            this.f10366v0 = r10 ^ this.f10366v0;
        }

        private void sipRound(int r10) {
            int r11 = 0;
        L3:
            if (r11 >= r10) goto L5;
            long r12 = this.f10366v0;
            long r13 = this.f10367v1;
            this.f10366v0 = r12 + r13;
            this.f10368v2 += this.f10369v3;
            this.f10367v1 = Long.rotateLeft(r13, 13);
            long r14 = Long.rotateLeft(this.f10369v3, 16);
            long r15 = this.f10367v1;
            long r16 = this.f10366v0;
            this.f10367v1 = r15 ^ r16;
            this.f10369v3 = r14 ^ this.f10368v2;
            long r17 = Long.rotateLeft(r16, 32);
            long r18 = this.f10368v2;
            long r19 = this.f10367v1;
            this.f10368v2 = r18 + r19;
            this.f10366v0 = r17 + this.f10369v3;
            this.f10367v1 = Long.rotateLeft(r19, 17);
            long r20 = Long.rotateLeft(this.f10369v3, 21);
            long r21 = this.f10367v1;
            long r22 = this.f10368v2;
            this.f10367v1 = r21 ^ r22;
            this.f10369v3 = r20 ^ this.f10366v0;
            this.f10368v2 = Long.rotateLeft(r22, 32);
            r11 = r11 + 1;
            goto L3
        }

        @Override // com.google.common.hash.AbstractStreamingHasher
        public HashCode makeHash() {
            long r10 = this.finalM ^ (this.f10363b << 56);
            this.finalM = r10;
            processM(r10);
            this.f10368v2 ^= 255;
            sipRound(this.f10365d);
            return HashCode.fromLong(((this.f10366v0 ^ this.f10367v1) ^ this.f10368v2) ^ this.f10369v3);
        }

        @Override // com.google.common.hash.AbstractStreamingHasher
        public void process(ByteBuffer r10) {
            this.f10363b += 8;
            processM(r10.getLong());
        }

        @Override // com.google.common.hash.AbstractStreamingHasher
        public void processRemaining(ByteBuffer r10) {
            this.f10363b += (long) r10.remaining();
            int r11 = 0;
        L4:
            if (r10.hasRemaining() == false) goto L6;
            this.finalM ^= (((long) r10.get()) & 255) << r11;
            r11 = r11 + 8;
            goto L4
        }
    }

    static {
        SIP_HASH_24 = new SipHashFunction(2, 4, 506097522914230528L, 1084818905618843912L);
    }

    public SipHashFunction(int r10, int r11, long r12, long r13) {
        boolean r14 = false;
        if (r10 <= 0) goto L5;
        boolean r15 = true;
    L6:
        Preconditions.checkArgument(r15, "The number of SipRound iterations (c=%s) during Compression must be positive.", r10);
        if (r11 <= 0) goto L9;
        r14 = true;
    L9:
        Preconditions.checkArgument(r14, "The number of SipRound iterations (d=%s) during Finalization must be positive.", r11);
        this.f10359c = r10;
        this.f10360d = r11;
        this.f10361k0 = r12;
        this.f10362k1 = r13;
        return;
    L5:
        r15 = false;
        goto L6
    }

    @Override // com.google.common.hash.HashFunction
    public int bits() {
        return 64;
    }

    public boolean equals(@NullableDecl Object r10) {
        if ((r10 instanceof SipHashFunction) == false) goto L14;
        SipHashFunction r11 = (SipHashFunction) r10;
        if (this.f10359c == r11.f10359c) goto L7;
        return false;
    L7:
        if (this.f10360d == r11.f10360d) goto L9;
        return false;
    L9:
        if (this.f10361k0 == r11.f10361k0) goto L11;
        return false;
    L11:
        if (this.f10362k1 != r11.f10362k1) goto L18;
        return true;
    L18:
        return false;
    L14:
        return false;
    }

    public int hashCode() {
        return (int) ((((long) ((SipHashFunction.class.hashCode() ^ this.f10359c) ^ this.f10360d)) ^ this.f10361k0) ^ this.f10362k1);
    }

    @Override // com.google.common.hash.HashFunction
    public Hasher newHasher() {
        return new SipHasher(this.f10359c, this.f10360d, this.f10361k0, this.f10362k1);
    }

    public String toString() {
        return "Hashing.sipHash" + this.f10359c + "" + this.f10360d + "(" + this.f10361k0 + ", " + this.f10362k1 + ")";
    }
}
