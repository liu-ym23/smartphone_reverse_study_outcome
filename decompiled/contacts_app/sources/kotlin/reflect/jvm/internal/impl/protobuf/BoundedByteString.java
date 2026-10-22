package kotlin.reflect.jvm.internal.impl.protobuf;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes4.dex */
class BoundedByteString extends LiteralByteString {
    private final int bytesLength;
    private final int bytesOffset;

    /* JADX INFO: renamed from: kotlin.reflect.jvm.internal.impl.protobuf.BoundedByteString$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private class BoundedByteIterator implements ByteString.ByteIterator {
        private final int limit;
        private int position;
        final /* synthetic */ BoundedByteString this$0;

        /* synthetic */ BoundedByteIterator(BoundedByteString r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // java.util.Iterator
        public /* bridge */ /* synthetic */ Byte next() {
            return next();
        }

        private BoundedByteIterator(BoundedByteString r2) {
            this.this$0 = r2;
            int r0 = r2.getOffsetIntoBytes();
            this.position = r0;
            this.limit = r0 + r2.size();
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
            if (this.position >= this.limit) goto L7;
            byte[] r0 = this.this$0.bytes;
            int r1 = this.position;
            this.position = r1 + 1;
            return r0[r1];
        L7:
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.LiteralByteString, kotlin.reflect.jvm.internal.impl.protobuf.ByteString, java.lang.Iterable
    public /* bridge */ /* synthetic */ Iterator<Byte> iterator() {
        return iterator2();
    }

    BoundedByteString(byte[] r5, int r6, int r7) {
        super(r5);
        if (r6 < 0) goto L14;
        if (r7 < 0) goto L12;
        if ((((long) r6) + ((long) r7)) > r5.length) goto L10;
        this.bytesOffset = r6;
        this.bytesLength = r7;
        return;
    L10:
        throw new IllegalArgumentException(new StringBuilder(48).append("Offset+Length too large: ").append(r6).append("+").append(r7).toString());
    L12:
        throw new IllegalArgumentException(new StringBuilder(29).append("Length too small: ").append(r6).toString());
    L14:
        throw new IllegalArgumentException(new StringBuilder(29).append("Offset too small: ").append(r6).toString());
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.LiteralByteString
    public byte byteAt(int r4) {
        if (r4 < 0) goto L10;
        if (r4 < size()) goto L6;
        int r3 = size();
        throw new ArrayIndexOutOfBoundsException(new StringBuilder(41).append("Index too large: ").append(r4).append(", ").append(r3).toString());
    L6:
        return this.bytes[this.bytesOffset + r4];
    L10:
        throw new ArrayIndexOutOfBoundsException(new StringBuilder(28).append("Index too small: ").append(r4).toString());
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.LiteralByteString, kotlin.reflect.jvm.internal.impl.protobuf.ByteString
    public int size() {
        return this.bytesLength;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.LiteralByteString
    protected int getOffsetIntoBytes() {
        return this.bytesOffset;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.LiteralByteString, kotlin.reflect.jvm.internal.impl.protobuf.ByteString
    protected void copyToInternal(byte[] r2, int r3, int r4, int r5) {
        System.arraycopy(this.bytes, getOffsetIntoBytes() + r3, r2, r4, r5);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.LiteralByteString, kotlin.reflect.jvm.internal.impl.protobuf.ByteString, java.lang.Iterable
    /* JADX INFO: renamed from: iterator, reason: avoid collision after fix types in other method */
    public Iterator<Byte> iterator2() {
        return new BoundedByteIterator(this, null);
    }
}
