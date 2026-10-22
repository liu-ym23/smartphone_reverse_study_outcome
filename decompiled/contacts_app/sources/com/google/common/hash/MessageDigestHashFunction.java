package com.google.common.hash;

import com.google.common.base.Preconditions;
import java.io.Serializable;
import java.security.MessageDigest;
import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
final class MessageDigestHashFunction extends AbstractStreamingHashFunction implements Serializable {
    private final int bytes;
    private final MessageDigest prototype;
    private final boolean supportsClone;
    private final String toString;

    /* JADX INFO: renamed from: com.google.common.hash.MessageDigestHashFunction$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private static final class MessageDigestHasher extends AbstractByteHasher {
        private final int bytes;
        private final MessageDigest digest;
        private boolean done;

        /* synthetic */ MessageDigestHasher(MessageDigest r1, int r2, AnonymousClass1 r3) {
            this(r1, r2);
        }

        private MessageDigestHasher(MessageDigest r1, int r2) {
            this.digest = r1;
            this.bytes = r2;
        }

        @Override // com.google.common.hash.AbstractByteHasher
        protected void update(byte r1) {
            checkNotDone();
            this.digest.update(r1);
        }

        @Override // com.google.common.hash.AbstractByteHasher
        protected void update(byte[] r1) {
            checkNotDone();
            this.digest.update(r1);
        }

        @Override // com.google.common.hash.AbstractByteHasher
        protected void update(byte[] r1, int r2, int r3) {
            checkNotDone();
            this.digest.update(r1, r2, r3);
        }

        private void checkNotDone() {
            Preconditions.checkState(!this.done, "Cannot re-use a Hasher after calling hash() on it");
        }

        @Override // com.google.common.hash.Hasher
        public HashCode hash() {
            checkNotDone();
            this.done = true;
            if (this.bytes != this.digest.getDigestLength()) goto L6;
            return HashCode.fromBytesNoCopy(this.digest.digest());
        L6:
            return HashCode.fromBytesNoCopy(Arrays.copyOf(this.digest.digest(), this.bytes));
        }
    }

    private static final class SerializedForm implements Serializable {
        private static final long serialVersionUID = 0;
        private final String algorithmName;
        private final int bytes;
        private final String toString;

        /* synthetic */ SerializedForm(String r1, int r2, String r3, AnonymousClass1 r4) {
            this(r1, r2, r3);
        }

        private SerializedForm(String r1, int r2, String r3) {
            this.algorithmName = r1;
            this.bytes = r2;
            this.toString = r3;
        }

        private Object readResolve() {
            return new MessageDigestHashFunction(this.algorithmName, this.bytes, this.toString);
        }
    }

    MessageDigestHashFunction(String r1, String r2) {
        MessageDigest r3 = getMessageDigest(r1);
        this.prototype = r3;
        this.bytes = r3.getDigestLength();
        this.toString = (String) Preconditions.checkNotNull(r2);
        this.supportsClone = supportsClone();
    }

    MessageDigestHashFunction(String r5, int r6, String r7) {
        this.toString = (String) Preconditions.checkNotNull(r7);
        MessageDigest r8 = getMessageDigest(r5);
        this.prototype = r8;
        int r9 = r8.getDigestLength();
        if (r6 < 4) goto L6;
        if (r6 > r9) goto L6;
        boolean r10 = true;
    L7:
        Preconditions.checkArgument(r10, "bytes (%s) must be >= 4 and < %s", new Object[]{Integer.valueOf(r6), Integer.valueOf(r9)});
        this.bytes = r6;
        this.supportsClone = supportsClone();
        return;
    L6:
        r10 = false;
        goto L7
    }

    private boolean supportsClone() {
        this.prototype.clone();     // Catch: CloneNotSupportedException -> L5
        return true;
    L5:
        return false;
    }

    @Override // com.google.common.hash.HashFunction
    public int bits() {
        return this.bytes * 8;
    }

    public String toString() {
        return this.toString;
    }

    private static MessageDigest getMessageDigest(String r1) {
        return MessageDigest.getInstance(r1);
    L4:
        e = move-exception;
        throw new AssertionError(e);
    }

    @Override // com.google.common.hash.HashFunction
    public Hasher newHasher() {
        AnonymousClass1 r1 = null;
        if (this.supportsClone == false) goto L7;
        return new MessageDigestHasher((MessageDigest) this.prototype.clone(), this.bytes, r1);
    L7:
        return new MessageDigestHasher(getMessageDigest(this.prototype.getAlgorithm()), this.bytes, r1);
    }

    Object writeReplace() {
        return new SerializedForm(this.prototype.getAlgorithm(), this.bytes, this.toString, null);
    }
}
