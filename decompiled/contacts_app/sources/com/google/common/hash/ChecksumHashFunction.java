package com.google.common.hash;

import com.google.common.base.Preconditions;
import com.google.common.base.Supplier;
import java.io.Serializable;
import java.util.zip.Checksum;

/* JADX INFO: loaded from: classes2.dex */
final class ChecksumHashFunction extends AbstractStreamingHashFunction implements Serializable {
    private static final long serialVersionUID = 0;
    private final int bits;
    private final Supplier<? extends Checksum> checksumSupplier;
    private final String toString;

    /* JADX INFO: renamed from: com.google.common.hash.ChecksumHashFunction$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private final class ChecksumHasher extends AbstractByteHasher {
        private final Checksum checksum;
        final /* synthetic */ ChecksumHashFunction this$0;

        /* synthetic */ ChecksumHasher(ChecksumHashFunction r1, Checksum r2, AnonymousClass1 r3) {
            this(r1, r2);
        }

        private ChecksumHasher(ChecksumHashFunction r1, Checksum r2) {
            this.this$0 = r1;
            this.checksum = (Checksum) Preconditions.checkNotNull(r2);
        }

        @Override // com.google.common.hash.AbstractByteHasher
        protected void update(byte r1) {
            this.checksum.update(r1);
        }

        @Override // com.google.common.hash.AbstractByteHasher
        protected void update(byte[] r1, int r2, int r3) {
            this.checksum.update(r1, r2, r3);
        }

        @Override // com.google.common.hash.Hasher
        public HashCode hash() {
            long r0 = this.checksum.getValue();
            if (ChecksumHashFunction.access$100(this.this$0) != 32) goto L7;
            return HashCode.fromInt((int) r0);
        L7:
            return HashCode.fromLong(r0);
        }
    }

    static /* synthetic */ int access$100(ChecksumHashFunction r0) {
        return r0.bits;
    }

    ChecksumHashFunction(Supplier<? extends Checksum> r4, int r5, String r6) {
        this.checksumSupplier = (Supplier) Preconditions.checkNotNull(r4);
        if (r5 != 32) goto L5;
    L8:
        boolean r7 = true;
    L9:
        Preconditions.checkArgument(r7, "bits (%s) must be either 32 or 64", new Object[]{Integer.valueOf(r5)});
        this.bits = r5;
        this.toString = (String) Preconditions.checkNotNull(r6);
        return;
    L5:
        if (r5 == 64) goto L8;
        r7 = false;
        goto L9
    }

    @Override // com.google.common.hash.HashFunction
    public int bits() {
        return this.bits;
    }

    @Override // com.google.common.hash.HashFunction
    public Hasher newHasher() {
        return new ChecksumHasher(this, this.checksumSupplier.get(), null);
    }

    public String toString() {
        return this.toString;
    }
}
