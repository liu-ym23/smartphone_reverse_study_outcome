package com.google.common.hash;

import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.Immutable;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.util.Arrays;

/* JADX INFO: loaded from: classes3.dex */
@Immutable
final class MessageDigestHashFunction extends AbstractHashFunction implements Serializable {
    private final int bytes;
    private final MessageDigest prototype;
    private final boolean supportsClone;
    private final String toString;

    /* JADX INFO: renamed from: com.google.common.hash.MessageDigestHashFunction$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static final class MessageDigestHasher extends AbstractByteHasher {
        private final int bytes;
        private final MessageDigest digest;
        private boolean done;

        public /* synthetic */ MessageDigestHasher(MessageDigest r10, int r11, AnonymousClass1 r12) {
            this(r10, r11);
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

        @Override // com.google.common.hash.AbstractByteHasher
        public void update(byte r10) {
            checkNotDone();
            this.digest.update(r10);
        }

        private MessageDigestHasher(MessageDigest r10, int r11) {
            this.digest = r10;
            this.bytes = r11;
        }

        @Override // com.google.common.hash.AbstractByteHasher
        public void update(byte[] r10, int r11, int r12) {
            checkNotDone();
            this.digest.update(r10, r11, r12);
        }

        @Override // com.google.common.hash.AbstractByteHasher
        public void update(ByteBuffer r10) {
            checkNotDone();
            this.digest.update(r10);
        }
    }

    public static final class SerializedForm implements Serializable {
        private static final long serialVersionUID = 0;
        private final String algorithmName;
        private final int bytes;
        private final String toString;

        public /* synthetic */ SerializedForm(String r10, int r11, String r12, AnonymousClass1 r13) {
            this(r10, r11, r12);
        }

        private Object readResolve() {
            return new MessageDigestHashFunction(this.algorithmName, this.bytes, this.toString);
        }

        private SerializedForm(String r10, int r11, String r12) {
            this.algorithmName = r10;
            this.bytes = r11;
            this.toString = r12;
        }
    }

    public MessageDigestHashFunction(String r10, String r11) {
        MessageDigest r12 = getMessageDigest(r10);
        this.prototype = r12;
        this.bytes = r12.getDigestLength();
        this.toString = (String) Preconditions.checkNotNull(r11);
        this.supportsClone = supportsClone(r12);
    }

    private static MessageDigest getMessageDigest(String r10) {
        return MessageDigest.getInstance(r10);
    L4:
        e = move-exception;
        throw new AssertionError(e);
    }

    private static boolean supportsClone(MessageDigest r10) {
        r10.clone();     // Catch: CloneNotSupportedException -> L5
        return true;
    L5:
        return false;
    }

    @Override // com.google.common.hash.HashFunction
    public int bits() {
        return this.bytes * 8;
    }

    @Override // com.google.common.hash.HashFunction
    public Hasher newHasher() {
        AnonymousClass1 r10 = null;
        if (this.supportsClone == false) goto L7;
        return new MessageDigestHasher((MessageDigest) this.prototype.clone(), this.bytes, r10);
    L7:
        return new MessageDigestHasher(getMessageDigest(this.prototype.getAlgorithm()), this.bytes, r10);
    }

    public String toString() {
        return this.toString;
    }

    public Object writeReplace() {
        return new SerializedForm(this.prototype.getAlgorithm(), this.bytes, this.toString, null);
    }

    public MessageDigestHashFunction(String r10, int r11, String r12) {
        this.toString = (String) Preconditions.checkNotNull(r12);
        MessageDigest r13 = getMessageDigest(r10);
        this.prototype = r13;
        int r14 = r13.getDigestLength();
        if (r11 < 4) goto L6;
        if (r11 > r14) goto L6;
        boolean r15 = true;
    L7:
        Preconditions.checkArgument(r15, "bytes (%s) must be >= 4 and < %s", r11, r14);
        this.bytes = r11;
        this.supportsClone = supportsClone(r13);
        return;
    L6:
        r15 = false;
        goto L7
    }
}
