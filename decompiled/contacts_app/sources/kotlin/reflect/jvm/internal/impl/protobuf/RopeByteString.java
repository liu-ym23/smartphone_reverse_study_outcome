package kotlin.reflect.jvm.internal.impl.protobuf;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Stack;

/* JADX INFO: loaded from: classes4.dex */
class RopeByteString extends ByteString {
    private static final int[] minLengthByDepth = null;
    private int hash;
    private final ByteString left;
    private final int leftLength;
    private final ByteString right;
    private final int totalLength;
    private final int treeDepth;

    /* JADX INFO: renamed from: kotlin.reflect.jvm.internal.impl.protobuf.RopeByteString$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private static class Balancer {
        private final Stack<ByteString> prefixesStack;

        private Balancer() {
            this.prefixesStack = new Stack();
        }

        /* synthetic */ Balancer(AnonymousClass1 r1) {
            this();
        }

        static /* synthetic */ ByteString access$100(Balancer r0, ByteString r1, ByteString r2) {
            return r0.balance(r1, r2);
        }

        private ByteString balance(ByteString r3, ByteString r4) {
            doBalance(r3);
            doBalance(r4);
            ByteString r5 = this.prefixesStack.pop();
        L4:
            if (this.prefixesStack.isEmpty() == true) goto L6;
            r5 = new RopeByteString(this.prefixesStack.pop(), r5, null);
            goto L4
        L6:
            return r5;
        }

        private void doBalance(ByteString r3) {
            if (r3.isBalanced() == false) goto L6;
            insert(r3);
            return;
        L6:
            if ((r3 instanceof RopeByteString) == false) goto L9;
            RopeByteString r4 = (RopeByteString) r3;
            doBalance(RopeByteString.access$400(r4));
            doBalance(RopeByteString.access$500(r4));
            return;
        L9:
            String r5 = String.valueOf(String.valueOf(r3.getClass()));
            throw new IllegalArgumentException(new StringBuilder(r5.length() + 49).append("Has a new type of ByteString been created? Found ").append(r5).toString());
        }

        private void insert(ByteString r6) {
            int r0 = getDepthBinForLength(r6.size());
            int r1 = RopeByteString.access$600()[r0 + 1];
            if (this.prefixesStack.isEmpty() == false) goto L5;
        L20:
            this.prefixesStack.push(r6);
            return;
        L5:
            if (this.prefixesStack.peek().size() >= r1) goto L20;
            int r2 = RopeByteString.access$600()[r0];
            ByteString r3 = this.prefixesStack.pop();
        L8:
            AnonymousClass1 r4 = null;
            if (this.prefixesStack.isEmpty() == true) goto L13;
            if (this.prefixesStack.peek().size() >= r2) goto L13;
            r3 = new RopeByteString(this.prefixesStack.pop(), r3, r4);
        L13:
            RopeByteString r5 = new RopeByteString(r3, r6, r4);
        L15:
            if (this.prefixesStack.isEmpty() == true) goto L19;
            int r7 = getDepthBinForLength(r5.size());
            int r8 = RopeByteString.access$600()[r7 + 1];
            if (this.prefixesStack.peek().size() >= r8) goto L19;
            r5 = new RopeByteString(this.prefixesStack.pop(), r5, r4);
        L19:
            this.prefixesStack.push(r5);
        }

        private int getDepthBinForLength(int r1) {
            int r0 = Arrays.binarySearch(RopeByteString.access$600(), r1);
            if (r0 < 0) goto L5;
            return r0;
        L5:
            return (-(r0 + 1)) - 1;
        }
    }

    private static class PieceIterator implements Iterator<LiteralByteString> {
        private final Stack<RopeByteString> breadCrumbs;
        private LiteralByteString next;

        /* synthetic */ PieceIterator(ByteString r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // java.util.Iterator
        public /* bridge */ /* synthetic */ LiteralByteString next() {
            return next2();
        }

        private PieceIterator(ByteString r2) {
            this.breadCrumbs = new Stack();
            this.next = getLeafByLeft(r2);
        }

        private LiteralByteString getLeafByLeft(ByteString r2) {
        L3:
            if ((r2 instanceof RopeByteString) == false) goto L6;
            RopeByteString r3 = (RopeByteString) r2;
            this.breadCrumbs.push(r3);
            r2 = RopeByteString.access$400(r3);
            goto L3
        L6:
            return (LiteralByteString) r2;
        }

        private LiteralByteString getNextNonEmptyLeaf() {
        L3:
            if (this.breadCrumbs.isEmpty() == true) goto L4;
            LiteralByteString r0 = getLeafByLeft(RopeByteString.access$500(this.breadCrumbs.pop()));
            if (r0.isEmpty() == true) goto L3;
            return r0;
        L4:
            return null;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.next == null) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // java.util.Iterator
        /* JADX INFO: renamed from: next, reason: avoid collision after fix types in other method */
        public LiteralByteString next2() {
            LiteralByteString r0 = this.next;
            if (r0 == null) goto L7;
            this.next = getNextNonEmptyLeaf();
            return r0;
        L7:
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    private class RopeByteIterator implements ByteString.ByteIterator {
        private ByteString.ByteIterator bytes;
        int bytesRemaining;
        private final PieceIterator pieces;
        final /* synthetic */ RopeByteString this$0;

        /* synthetic */ RopeByteIterator(RopeByteString r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // java.util.Iterator
        public /* bridge */ /* synthetic */ Byte next() {
            return next();
        }

        /* JADX WARN: Type inference failed for: r0v2, types: [kotlin.reflect.jvm.internal.impl.protobuf.ByteString$ByteIterator] */
        private RopeByteIterator(RopeByteString r3) {
            this.this$0 = r3;
            PieceIterator r0 = new PieceIterator(r3, null);
            this.pieces = r0;
            this.bytes = r0.next2().iterator();
            this.bytesRemaining = r3.size();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.bytesRemaining <= 0) goto L5;
            return true;
        L5:
            return false;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.Iterator
        public Byte next() {
            return Byte.valueOf(nextByte());
        }

        /* JADX WARN: Type inference failed for: r0v6, types: [kotlin.reflect.jvm.internal.impl.protobuf.ByteString$ByteIterator] */
        @Override // kotlin.reflect.jvm.internal.impl.protobuf.ByteString.ByteIterator
        public byte nextByte() {
            if (this.bytes.hasNext() == true) goto L5;
            this.bytes = this.pieces.next2().iterator();
        L5:
            this.bytesRemaining--;
            return this.bytes.nextByte();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    private class RopeInputStream extends InputStream {
        private LiteralByteString currentPiece;
        private int currentPieceIndex;
        private int currentPieceOffsetInRope;
        private int currentPieceSize;
        private int mark;
        private PieceIterator pieceIterator;
        final /* synthetic */ RopeByteString this$0;

        @Override // java.io.InputStream
        public boolean markSupported() {
            return true;
        }

        public RopeInputStream(RopeByteString r1) {
            this.this$0 = r1;
            initialize();
        }

        @Override // java.io.InputStream
        public int read(byte[] r2, int r3, int r4) {
            r2.getClass();
            if (r3 < 0) goto L10;
            if (r4 < 0) goto L10;
            if (r4 > (r2.length - r3)) goto L10;
            return readSkipInternal(r2, r3, r4);
        L10:
            throw new IndexOutOfBoundsException();
        }

        @Override // java.io.InputStream
        public long skip(long r4) {
            if (r4 < 0) goto L10;
            if (r4 <= 2147483647L) goto L8;
            r4 = 2147483647L;
        L8:
            return readSkipInternal(null, 0, (int) r4);
        L10:
            throw new IndexOutOfBoundsException();
        }

        private int readSkipInternal(byte[] r5, int r6, int r7) {
            int r0 = r7;
        L3:
            if (r0 <= 0) goto L14;
            advanceIfCurrentPieceFullyRead();
            if (this.currentPiece == null) goto L6;
            int r1 = Math.min(this.currentPieceSize - this.currentPieceIndex, r0);
            if (r5 == null) goto L12;
            this.currentPiece.copyTo(r5, this.currentPieceIndex, r6, r1);
            r6 = r6 + r1;
        L12:
            this.currentPieceIndex += r1;
            r0 = r0 - r1;
            goto L3
        L6:
            if (r0 != r7) goto L14;
            return -1;
        L14:
            return r7 - r0;
        }

        @Override // java.io.InputStream
        public int read() throws IOException {
            advanceIfCurrentPieceFullyRead();
            LiteralByteString r0 = this.currentPiece;
            if (r0 != null) goto L6;
            return -1;
        L6:
            int r1 = this.currentPieceIndex;
            this.currentPieceIndex = r1 + 1;
            return r0.byteAt(r1) & 255;
        }

        @Override // java.io.InputStream
        public int available() throws IOException {
            int r0 = this.currentPieceOffsetInRope + this.currentPieceIndex;
            return this.this$0.size() - r0;
        }

        @Override // java.io.InputStream
        public void mark(int r2) {
            this.mark = this.currentPieceOffsetInRope + this.currentPieceIndex;
        }

        @Override // java.io.InputStream
        public synchronized void reset() {
            monitor-enter(this);
            initialize();     // Catch: Throwable -> L6
            readSkipInternal(null, 0, this.mark);     // Catch: Throwable -> L6
            monitor-exit(this);
            return;
        L6:
            th = move-exception;
            throw th;
        }

        private void initialize() {
            PieceIterator r0 = new PieceIterator(this.this$0, null);
            this.pieceIterator = r0;
            LiteralByteString r1 = r0.next2();
            this.currentPiece = r1;
            this.currentPieceSize = r1.size();
            this.currentPieceIndex = 0;
            this.currentPieceOffsetInRope = 0;
        }

        private void advanceIfCurrentPieceFullyRead() {
            if (this.currentPiece == null) goto L11;
            int r0 = this.currentPieceIndex;
            int r1 = this.currentPieceSize;
            if (r0 != r1) goto L12;
            this.currentPieceOffsetInRope += r1;
            this.currentPieceIndex = 0;
            if (this.pieceIterator.hasNext() == false) goto L9;
            LiteralByteString r2 = this.pieceIterator.next2();
            this.currentPiece = r2;
            this.currentPieceSize = r2.size();
            return;
        L9:
            this.currentPiece = null;
            this.currentPieceSize = 0;
            return;
        L12:
            return;
        }
    }

    /* synthetic */ RopeByteString(ByteString r1, ByteString r2, AnonymousClass1 r3) {
        this(r1, r2);
    }

    static /* synthetic */ ByteString access$400(RopeByteString r0) {
        return r0.left;
    }

    static /* synthetic */ ByteString access$500(RopeByteString r0) {
        return r0.right;
    }

    static /* synthetic */ int[] access$600() {
        return minLengthByDepth;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.ByteString, java.lang.Iterable
    public /* bridge */ /* synthetic */ Iterator<Byte> iterator() {
        return iterator2();
    }

    static {
        ArrayList r0 = new ArrayList();
        int r1 = 1;
        int r2 = 1;
    L3:
        if (r1 <= 0) goto L5;
        r0.add(Integer.valueOf(r1));
        int r3 = r2 + r1;
        r2 = r1;
        r1 = r3;
        goto L3
    L5:
        r0.add(Integer.MAX_VALUE);
        minLengthByDepth = new int[r0.size()];
        int r4 = 0;
    L6:
        int[] r5 = minLengthByDepth;
        if (r4 >= r5.length) goto L9;
        r5[r4] = ((Integer) r0.get(r4)).intValue();
        r4 = r4 + 1;
        goto L6
    }

    private RopeByteString(ByteString r3, ByteString r4) {
        this.hash = 0;
        this.left = r3;
        this.right = r4;
        int r0 = r3.size();
        this.leftLength = r0;
        this.totalLength = r0 + r4.size();
        this.treeDepth = Math.max(r3.getTreeDepth(), r4.getTreeDepth()) + 1;
    }

    static ByteString concatenate(ByteString r6, ByteString r7) {
        AnonymousClass1 r1 = null;
        if ((r6 instanceof RopeByteString) == false) goto L5;
        RopeByteString r0 = (RopeByteString) r6;
    L7:
        if (r7.size() != 0) goto L10;
        return r6;
    L10:
        if (r6.size() == 0) goto L30;
        int r2 = r6.size() + r7.size();
        if (r2 < 128) goto L31;
        if (r0 != null) goto L17;
    L19:
        if (r0 == null) goto L26;
        if (r0.left.getTreeDepth() <= r0.right.getTreeDepth()) goto L26;
        if (r0.getTreeDepth() <= r7.getTreeDepth()) goto L26;
        r7 = new RopeByteString(r0.left, new RopeByteString(r0.right, r7));
    L26:
        if (r2 < minLengthByDepth[Math.max(r6.getTreeDepth(), r7.getTreeDepth()) + 1]) goto L29;
        return new RopeByteString(r6, r7);
    L29:
        return Balancer.access$100(new Balancer(r1), r6, r7);
    L17:
        if ((r0.right.size() + r7.size()) >= 128) goto L19;
        r7 = new RopeByteString(r0.left, concatenateBytes(r0.right, r7));
        goto L30
    L31:
        return concatenateBytes(r6, r7);
    L30:
        return r7;
    L5:
        r0 = null;
        goto L7
    }

    private static LiteralByteString concatenateBytes(ByteString r4, ByteString r5) {
        int r0 = r4.size();
        int r1 = r5.size();
        byte[] r2 = new byte[r0 + r1];
        r4.copyTo(r2, 0, 0, r0);
        r5.copyTo(r2, 0, r0, r1);
        return new LiteralByteString(r2);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.ByteString
    public int size() {
        return this.totalLength;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.ByteString
    protected int getTreeDepth() {
        return this.treeDepth;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.ByteString
    protected boolean isBalanced() {
        if (this.totalLength < minLengthByDepth[this.treeDepth]) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.ByteString
    protected void copyToInternal(byte[] r3, int r4, int r5, int r6) {
        int r0 = r4 + r6;
        int r1 = this.leftLength;
        if (r0 > r1) goto L5;
        this.left.copyToInternal(r3, r4, r5, r6);
        return;
    L5:
        if (r4 < r1) goto L7;
        this.right.copyToInternal(r3, r4 - r1, r5, r6);
        return;
    L7:
        int r2 = r1 - r4;
        this.left.copyToInternal(r3, r4, r5, r2);
        this.right.copyToInternal(r3, 0, r5 + r2, r6 - r2);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.ByteString
    void writeToInternal(OutputStream r3, int r4, int r5) throws IOException {
        int r0 = r4 + r5;
        int r1 = this.leftLength;
        if (r0 > r1) goto L5;
        this.left.writeToInternal(r3, r4, r5);
        return;
    L5:
        if (r4 < r1) goto L7;
        this.right.writeToInternal(r3, r4 - r1, r5);
        return;
    L7:
        int r2 = r1 - r4;
        this.left.writeToInternal(r3, r4, r2);
        this.right.writeToInternal(r3, 0, r5 - r2);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.ByteString
    public String toString(String r2) throws UnsupportedEncodingException {
        return new String(toByteArray(), r2);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.ByteString
    public boolean isValidUtf8() {
        int r0 = this.left.partialIsValidUtf8(0, 0, this.leftLength);
        ByteString r3 = this.right;
        if (r3.partialIsValidUtf8(r0, 0, r3.size()) != 0) goto L6;
        return true;
    L6:
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.ByteString
    protected int partialIsValidUtf8(int r3, int r4, int r5) {
        int r0 = r4 + r5;
        int r1 = this.leftLength;
        if (r0 <= r1) goto L5;
        if (r4 >= r1) goto L8;
        int r2 = r1 - r4;
        int r6 = this.left.partialIsValidUtf8(r3, r4, r2);
        return this.right.partialIsValidUtf8(r6, 0, r5 - r2);
    L8:
        return this.right.partialIsValidUtf8(r3, r4 - r1, r5);
    L5:
        return this.left.partialIsValidUtf8(r3, r4, r5);
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if ((r5 instanceof ByteString) == true) goto L8;
        return false;
    L8:
        ByteString r6 = (ByteString) r5;
        if (this.totalLength == r6.size()) goto L12;
        return false;
    L12:
        if (this.totalLength != 0) goto L15;
        return true;
    L15:
        if (this.hash == 0) goto L22;
        int r0 = r6.peekCachedHashCode();
        if (r0 == 0) goto L22;
        if (this.hash == r0) goto L22;
        return false;
    L22:
        return equalsFragments(r6);
    }

    private boolean equalsFragments(ByteString r12) {
        AnonymousClass1 r1 = null;
        PieceIterator r0 = new PieceIterator(this, r1);
        LiteralByteString r2 = r0.next();
        PieceIterator r3 = new PieceIterator(r12, r1);
        LiteralByteString r13 = r3.next();
        int r4 = 0;
        int r5 = 0;
        int r6 = 0;
    L3:
        int r7 = r2.size() - r4;
        int r8 = r13.size() - r5;
        int r9 = Math.min(r7, r8);
        if (r4 != 0) goto L6;
        boolean r10 = r2.equalsRange(r13, r5, r9);
    L7:
        if (r10 == false) goto L8;
        r6 = r6 + r9;
        int r11 = this.totalLength;
        if (r6 >= r11) goto L11;
        if (r9 != r7) goto L18;
        r2 = r0.next();
        r4 = 0;
    L19:
        if (r9 == r8) goto L20;
        r5 = r5 + r9;
        goto L3
    L20:
        r13 = r3.next();
        r5 = 0;
        goto L3
    L18:
        r4 = r4 + r9;
        goto L19
    L11:
        if (r6 != r11) goto L15;
        return true;
    L15:
        throw new IllegalStateException();
    L8:
        return false;
    L6:
        r10 = r13.equalsRange(r2, r4, r9);
        goto L7
    }

    public int hashCode() {
        int r0 = this.hash;
        if (r0 != 0) goto L8;
        int r1 = this.totalLength;
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
    protected int partialHash(int r3, int r4, int r5) {
        int r0 = r4 + r5;
        int r1 = this.leftLength;
        if (r0 <= r1) goto L5;
        if (r4 >= r1) goto L8;
        int r2 = r1 - r4;
        int r6 = this.left.partialHash(r3, r4, r2);
        return this.right.partialHash(r6, 0, r5 - r2);
    L8:
        return this.right.partialHash(r3, r4 - r1, r5);
    L5:
        return this.left.partialHash(r3, r4, r5);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.ByteString
    public CodedInputStream newCodedInput() {
        return CodedInputStream.newInstance(new RopeInputStream(this));
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.ByteString, java.lang.Iterable
    /* JADX INFO: renamed from: iterator, reason: avoid collision after fix types in other method */
    public Iterator<Byte> iterator2() {
        return new RopeByteIterator(this, null);
    }
}
