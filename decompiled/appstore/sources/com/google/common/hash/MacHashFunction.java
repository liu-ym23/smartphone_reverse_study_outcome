package com.google.common.hash;

import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.Immutable;
import java.nio.ByteBuffer;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Mac;

/* JADX INFO: loaded from: classes3.dex */
@Immutable
final class MacHashFunction extends AbstractHashFunction {
    private final int bits;
    private final Key key;
    private final Mac prototype;
    private final boolean supportsClone;
    private final String toString;

    /* JADX INFO: renamed from: com.google.common.hash.MacHashFunction$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static final class MacHasher extends AbstractByteHasher {
        private boolean done;
        private final Mac mac;

        public /* synthetic */ MacHasher(Mac r10, AnonymousClass1 r11) {
            this(r10);
        }

        private void checkNotDone() {
            Preconditions.checkState(!this.done, "Cannot re-use a Hasher after calling hash() on it");
        }

        @Override // com.google.common.hash.Hasher
        public HashCode hash() {
            checkNotDone();
            this.done = true;
            return HashCode.fromBytesNoCopy(this.mac.doFinal());
        }

        @Override // com.google.common.hash.AbstractByteHasher
        public void update(byte r10) {
            checkNotDone();
            this.mac.update(r10);
        }

        private MacHasher(Mac r10) {
            this.mac = r10;
        }

        @Override // com.google.common.hash.AbstractByteHasher
        public void update(byte[] r10) {
            checkNotDone();
            this.mac.update(r10);
        }

        @Override // com.google.common.hash.AbstractByteHasher
        public void update(byte[] r10, int r11, int r12) {
            checkNotDone();
            this.mac.update(r10, r11, r12);
        }

        @Override // com.google.common.hash.AbstractByteHasher
        public void update(ByteBuffer r10) {
            checkNotDone();
            Preconditions.checkNotNull(r10);
            this.mac.update(r10);
        }
    }

    public MacHashFunction(String r10, Key r11, String r12) {
        Mac r13 = getMac(r10, r11);
        this.prototype = r13;
        this.key = (Key) Preconditions.checkNotNull(r11);
        this.toString = (String) Preconditions.checkNotNull(r12);
        this.bits = r13.getMacLength() * 8;
        this.supportsClone = supportsClone(r13);
    }

    private static Mac getMac(String r10, Key r11) {
        Mac r12 = Mac.getInstance(r10);     // Catch: InvalidKeyException -> L4 NoSuchAlgorithmException -> L6
        r12.init(r11);     // Catch: InvalidKeyException -> L4 NoSuchAlgorithmException -> L6
        return r12;
    L4:
        e = move-exception;
        throw new IllegalArgumentException(e);
    L6:
        e = move-exception;
        throw new IllegalStateException(e);
    }

    private static boolean supportsClone(Mac r10) {
        r10.clone();     // Catch: CloneNotSupportedException -> L5
        return true;
    L5:
        return false;
    }

    @Override // com.google.common.hash.HashFunction
    public int bits() {
        return this.bits;
    }

    @Override // com.google.common.hash.HashFunction
    public Hasher newHasher() {
        AnonymousClass1 r10 = null;
        if (this.supportsClone == false) goto L7;
        return new MacHasher((Mac) this.prototype.clone(), r10);
    L7:
        return new MacHasher(getMac(this.prototype.getAlgorithm(), this.key), r10);
    }

    public String toString() {
        return this.toString;
    }
}
