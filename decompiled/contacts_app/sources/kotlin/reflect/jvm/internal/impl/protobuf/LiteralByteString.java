package kotlin.reflect.jvm.internal.impl.protobuf;

import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes4.dex */
class LiteralByteString extends ByteString {
    protected final byte[] bytes;
    private int hash;

    /* JADX INFO: renamed from: kotlin.reflect.jvm.internal.impl.protobuf.LiteralByteString$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private class LiteralByteIterator implements ByteString.ByteIterator {
        private final int limit;
        private int position;
        final /* synthetic */ LiteralByteString this$0;

        /* synthetic */ LiteralByteIterator(LiteralByteString r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // java.util.Iterator
        public /* bridge */ /* synthetic */ Byte next() {
            return next();
        }

        private LiteralByteIterator(LiteralByteString r2) {
            this.this$0 = r2;
            this.position = 0;
            this.limit = r2.size();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.position >= this.limit) goto L5;
            return true;
        L5:
            return false;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.Iterator
        public Byte next() {
            return Byte.valueOf(nextByte());
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.ByteString.ByteIterator
        public byte nextByte() {
            byte[] r0 = this.this$0.bytes;     // Catch: ArrayIndexOutOfBoundsException -> L4
            int r1 = this.position;     // Catch: ArrayIndexOutOfBoundsException -> L4
            this.position = r1 + 1;     // Catch: ArrayIndexOutOfBoundsException -> L4
            return r0[r1];
        L4:
            e = move-exception;
            throw new NoSuchElementException(e.getMessage());
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    protected int getOffsetIntoBytes() {
        return 0;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.ByteString
    protected int getTreeDepth() {
        return 0;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.ByteString
    protected boolean isBalanced() {
        return true;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.reflect.jvm.internal.impl.protobuf.ByteString, java.lang.Iterable
    public /* bridge */ /* synthetic */ Iterator<Byte> iterator() {
        return iterator();
    }

    LiteralByteString(byte[] r2) {
        this.hash = 0;
        this.bytes = r2;
    }

    public byte byteAt(int r1) {
        return this.bytes[r1];
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.ByteString
    public int size() {
        return this.bytes.length;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.ByteString
    protected void copyToInternal(byte[] r1, int r2, int r3, int r4) {
        System.arraycopy(this.bytes, r2, r1, r3, r4);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.ByteString
    void writeToInternal(OutputStream r2, int r3, int r4) throws IOException {
        r2.write(this.bytes, getOffsetIntoBytes() + r3, r4);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.ByteString
    public String toString(String r4) throws UnsupportedEncodingException {
        return new String(this.bytes, getOffsetIntoBytes(), size(), r4);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.ByteString
    public boolean isValidUtf8() {
        int r0 = getOffsetIntoBytes();
        return Utf8.isValidUtf8(this.bytes, r0, size() + r0);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.ByteString
    protected int partialIsValidUtf8(int r2, int r3, int r4) {
        int r0 = getOffsetIntoBytes() + r3;
        return Utf8.partialIsValidUtf8(r2, this.bytes, r0, r4 + r0);
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if ((r5 instanceof ByteString) == true) goto L9;
        return false;
    L9:
        if (size() == ((ByteString) r5).size()) goto L12;
        return false;
    L12:
        if (size() != 0) goto L15;
        return true;
    L15:
        if ((r5 instanceof LiteralByteString) == false) goto L19;
        return equalsRange((LiteralByteString) r5, 0, size());
    L19:
        if ((r5 instanceof RopeByteString) == true) goto L21;
        String r6 = String.valueOf(String.valueOf(r5.getClass()));
        throw new IllegalArgumentException(new StringBuilder(r6.length() + 49).append("Has a new type of ByteString been created? Found ").append(r6).toString());
    L21:
        return r5.equals(this);
    }

    boolean equalsRange(LiteralByteString r4, int r5, int r6) {
        if (r6 <= r4.size()) goto L5;
        int r3 = size();
        throw new IllegalArgumentException(new StringBuilder(40).append("Length too large: ").append(r6).append(r3).toString());
    L5:
        if ((r5 + r6) > r4.size()) goto L15;
        byte[] r0 = this.bytes;
        byte[] r1 = r4.bytes;
        int r2 = getOffsetIntoBytes() + r6;
        int r7 = getOffsetIntoBytes();
        int r8 = r4.getOffsetIntoBytes() + r5;
    L7:
        if (r7 >= r2) goto L13;
        if (r0[r7] != r1[r8]) goto L10;
        r7 = r7 + 1;
        r8 = r8 + 1;
        goto L7
    L10:
        return false;
    L13:
        return true;
    L15:
        int r9 = r4.size();
        throw new IllegalArgumentException(new StringBuilder(59).append("Ran off end of other: ").append(r5).append(", ").append(r6).append(", ").append(r9).toString());
    }

    public int hashCode() {
        int r0 = this.hash;
        if (r0 != 0) goto L8;
        int r1 = size();
        r0 = partialHash(r1, 0, r1);
        if (r0 != 0) goto L7;
        r0 = 1;
    L7:
        this.hash = r0;
    L8:
        return r0;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.ByteString
    protected int peekCachedHashCode() {
        return this.hash;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.ByteString
    protected int partialHash(int r2, int r3, int r4) {
        return hashCode(r2, this.bytes, getOffsetIntoBytes() + r3, r4);
    }

    static int hashCode(int r2, byte[] r3, int r4, int r5) {
        int r0 = r4;
    L4:
        if (r0 >= (r4 + r5)) goto L6;
        r2 = (r2 * 31) + r3[r0];
        r0 = r0 + 1;
        goto L4
    L6:
        return r2;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.ByteString
    public CodedInputStream newCodedInput() {
        return CodedInputStream.newInstance(this);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.reflect.jvm.internal.impl.protobuf.ByteString, java.lang.Iterable
    public Iterator<Byte> iterator() {
        return new LiteralByteIterator(this, null);
    }
}
