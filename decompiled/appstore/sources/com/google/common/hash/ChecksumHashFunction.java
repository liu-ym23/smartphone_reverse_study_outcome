package com.google.common.hash;

import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.Immutable;
import java.io.Serializable;
import java.util.zip.Checksum;

/* JADX INFO: loaded from: classes3.dex */
@Immutable
final class ChecksumHashFunction extends AbstractHashFunction implements Serializable {
    private static final long serialVersionUID = 0;
    private final int bits;
    private final ImmutableSupplier<? extends Checksum> checksumSupplier;
    private final String toString;

    /* JADX INFO: renamed from: com.google.common.hash.ChecksumHashFunction$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public final class ChecksumHasher extends AbstractByteHasher {
        private final Checksum checksum;
        final /* synthetic */ ChecksumHashFunction this$0;

        public /* synthetic */ ChecksumHasher(ChecksumHashFunction r10, Checksum r11, AnonymousClass1 r12) {
            this(r10, r11);
        }

        @Override // com.google.common.hash.Hasher
        public HashCode hash() {
            long r10 = this.checksum.getValue();
            if (ChecksumHashFunction.access$100(this.this$0) != 32) goto L7;
            return HashCode.fromInt((int) r10);
        L7:
            return HashCode.fromLong(r10);
        }

        @Override // com.google.common.hash.AbstractByteHasher
        public void update(byte r10) {
            this.checksum.update(r10);
        }

        private ChecksumHasher(ChecksumHashFunction r10, Checksum r11) {
            this.this$0 = r10;
            this.checksum = (Checksum) Preconditions.checkNotNull(r11);
        }

        @Override // com.google.common.hash.AbstractByteHasher
        public void update(byte[] r10, int r11, int r12) {
            this.checksum.update(r10, r11, r12);
        }
    }

    public ChecksumHashFunction(ImmutableSupplier<? extends Checksum> r10, int r11, String r12) {
        this.checksumSupplier = (ImmutableSupplier) Preconditions.checkNotNull(r10);
        if (r11 != 32) goto L5;
    L8:
        boolean r13 = true;
    L9:
        Preconditions.checkArgument(r13, "bits (%s) must be either 32 or 64", r11);
        this.bits = r11;
        this.toString = (String) Preconditions.checkNotNull(r12);
        return;
    L5:
        if (r11 == 64) goto L8;
        r13 = false;
        goto L9
    }

    public static /* synthetic */ int access$100(ChecksumHashFunction r10) {
        return r10.bits;
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
