package com.bytedance.location.protobuf;

import android.hardware.tv.hdmi.cec.CecDeviceType;
import com.android.internal.util.FrameworkStatsLog;
import java.io.IOException;
import java.io.InputStream;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes3.dex */
final class RopeByteString extends ByteString {
    static final int[] minLengthByDepth = null;
    private static final long serialVersionUID = 1;
    private final ByteString left;
    private final int leftLength;
    private final ByteString right;
    private final int totalLength;
    private final int treeDepth;

    private static class Balancer {
        private final ArrayDeque<ByteString> prefixesStack;

        private Balancer() {
            this.prefixesStack = new ArrayDeque();
        }

        /* synthetic */ Balancer(AnonymousClass1 x0) {
            this();
        }

        static /* synthetic */ ByteString access$100(Balancer x0, ByteString x1, ByteString x2) {
            return x0.balance(x1, x2);
        }

        private ByteString balance(ByteString left, ByteString right) {
            doBalance(left);
            doBalance(right);
            ByteString partialString = this.prefixesStack.pop();
        L4:
            if (this.prefixesStack.isEmpty() == true) goto L6;
            ByteString newLeft = this.prefixesStack.pop();
            partialString = new RopeByteString(newLeft, partialString, null);
            goto L4
        L6:
            return partialString;
        }

        private void doBalance(ByteString root) {
            if (root.isBalanced() == false) goto L6;
            insert(root);
            return;
        L6:
            if ((root instanceof RopeByteString) == false) goto L10;
            RopeByteString rbs = (RopeByteString) root;
            doBalance(RopeByteString.access$400(rbs));
            doBalance(RopeByteString.access$500(rbs));
            return;
        L10:
            throw new IllegalArgumentException("Has a new type of ByteString been created? Found " + root.getClass());
        }

        private void insert(ByteString byteString) {
            int depthBin = getDepthBinForLength(byteString.size());
            int binEnd = RopeByteString.minLength(depthBin + 1);
            if (this.prefixesStack.isEmpty() == false) goto L5;
        L20:
            this.prefixesStack.push(byteString);
            return;
        L5:
            if (this.prefixesStack.peek().size() >= binEnd) goto L20;
            int binStart = RopeByteString.minLength(depthBin);
            ByteString newTree = this.prefixesStack.pop();
        L8:
            AnonymousClass1 r5 = null;
            if (this.prefixesStack.isEmpty() == true) goto L13;
            if (this.prefixesStack.peek().size() >= binStart) goto L13;
            ByteString left = this.prefixesStack.pop();
            newTree = new RopeByteString(left, newTree, r5);
        L13:
            ByteString newTree2 = new RopeByteString(newTree, byteString, r5);
        L15:
            if (this.prefixesStack.isEmpty() == true) goto L19;
            int binEnd2 = RopeByteString.minLength(getDepthBinForLength(newTree2.size()) + 1);
            if (this.prefixesStack.peek().size() >= binEnd2) goto L19;
            ByteString left2 = this.prefixesStack.pop();
            newTree2 = new RopeByteString(left2, newTree2, r5);
        L19:
            this.prefixesStack.push(newTree2);
        }

        private int getDepthBinForLength(int length) {
            int depth = Arrays.binarySearch(RopeByteString.minLengthByDepth, length);
            if (depth >= 0) goto L6;
            int insertionPoint = -(depth + 1);
            return insertionPoint - 1;
        L6:
            return depth;
        }
    }

    private static final class PieceIterator implements Iterator<ByteString.LeafByteString> {
        private final ArrayDeque<RopeByteString> breadCrumbs;
        private ByteString.LeafByteString next;

        /* synthetic */ PieceIterator(ByteString x0, AnonymousClass1 x1) {
            this(x0);
        }

        @Override // java.util.Iterator
        public /* bridge */ /* synthetic */ ByteString.LeafByteString next() {
            return next();
        }

        private PieceIterator(ByteString root) {
            if ((root instanceof RopeByteString) == false) goto L5;
            RopeByteString rbs = (RopeByteString) root;
            this.breadCrumbs = new ArrayDeque(rbs.getTreeDepth());
            this.breadCrumbs.push(rbs);
            this.next = getLeafByLeft(RopeByteString.access$400(rbs));
            return;
        L5:
            this.breadCrumbs = null;
            this.next = (ByteString.LeafByteString) root;
        }

        private ByteString.LeafByteString getLeafByLeft(ByteString root) {
            ByteString pos = root;
        L4:
            if ((pos instanceof RopeByteString) == false) goto L7;
            RopeByteString rbs = (RopeByteString) pos;
            this.breadCrumbs.push(rbs);
            pos = RopeByteString.access$400(rbs);
            goto L4
        L7:
            return (ByteString.LeafByteString) pos;
        }

        private ByteString.LeafByteString getNextNonEmptyLeaf() {
        L3:
            if (this.breadCrumbs == null) goto L11;
            if (this.breadCrumbs.isEmpty() == true) goto L17;
            ByteString.LeafByteString result = getLeafByLeft(RopeByteString.access$500(this.breadCrumbs.pop()));
            if (result.isEmpty() == true) goto L3;
            return result;
        L17:
            return null;
        L11:
            return null;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.next == null) goto L5;
            return true;
        L5:
            return false;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.Iterator
        public ByteString.LeafByteString next() {
            if (this.next == null) goto L7;
            ByteString.LeafByteString result = this.next;
            this.next = getNextNonEmptyLeaf();
            return result;
        L7:
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    private class RopeInputStream extends InputStream {
        private ByteString.LeafByteString currentPiece;
        private int currentPieceIndex;
        private int currentPieceOffsetInRope;
        private int currentPieceSize;
        private int mark;
        private PieceIterator pieceIterator;
        final /* synthetic */ RopeByteString this$0;

        public RopeInputStream(RopeByteString r1) {
            this.this$0 = r1;
            initialize();
        }

        @Override // java.io.InputStream
        public int read(byte[] b, int offset, int length) {
            if (b == null) goto L18;
            if (offset < 0) goto L16;
            if (length < 0) goto L16;
            if (length > (b.length - offset)) goto L16;
            int bytesRead = readSkipInternal(b, offset, length);
            if (bytesRead != 0) goto L14;
            if (length <= 0) goto L11;
            return -1;
        L11:
            if (availableInternal() != 0) goto L14;
            return -1;
        L14:
            return bytesRead;
        L16:
            throw new IndexOutOfBoundsException();
        L18:
            throw new NullPointerException();
        }

        @Override // java.io.InputStream
        public long skip(long length) {
            if (length < 0) goto L10;
            if (length <= 2147483647L) goto L8;
            length = 2147483647L;
        L8:
            return readSkipInternal(null, 0, (int) length);
        L10:
            throw new IndexOutOfBoundsException();
        }

        private int readSkipInternal(byte[] b, int offset, int length) {
            int bytesRemaining = length;
        L3:
            if (bytesRemaining <= 0) goto L12;
            advanceIfCurrentPieceFullyRead();
            if (this.currentPiece == null) goto L12;
            int currentPieceRemaining = this.currentPieceSize - this.currentPieceIndex;
            int count = Math.min(currentPieceRemaining, bytesRemaining);
            if (b == null) goto L10;
            this.currentPiece.copyTo(b, this.currentPieceIndex, offset, count);
            offset = offset + count;
        L10:
            this.currentPieceIndex += count;
            bytesRemaining = bytesRemaining - count;
        L12:
            return length - bytesRemaining;
        }

        @Override // java.io.InputStream
        public int read() throws IOException {
            advanceIfCurrentPieceFullyRead();
            if (this.currentPiece != null) goto L6;
            return -1;
        L6:
            ByteString.LeafByteString r0 = this.currentPiece;
            int r1 = this.currentPieceIndex;
            this.currentPieceIndex = r1 + 1;
            return r0.byteAt(r1) & CecDeviceType.INACTIVE;
        }

        @Override // java.io.InputStream
        public int available() throws IOException {
            return availableInternal();
        }

        @Override // java.io.InputStream
        public boolean markSupported() {
            return true;
        }

        @Override // java.io.InputStream
        public void mark(int readAheadLimit) {
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
            this.pieceIterator = new PieceIterator(this.this$0, null);
            this.currentPiece = this.pieceIterator.next();
            this.currentPieceSize = this.currentPiece.size();
            this.currentPieceIndex = 0;
            this.currentPieceOffsetInRope = 0;
        }

        private void advanceIfCurrentPieceFullyRead() {
            if (this.currentPiece != null) goto L5;
            return;
        L5:
            if (this.currentPieceIndex != this.currentPieceSize) goto L12;
            this.currentPieceOffsetInRope += this.currentPieceSize;
            this.currentPieceIndex = 0;
            if (this.pieceIterator.hasNext() == false) goto L9;
            this.currentPiece = this.pieceIterator.next();
            this.currentPieceSize = this.currentPiece.size();
            return;
        L9:
            this.currentPiece = null;
            this.currentPieceSize = 0;
            return;
        }

        private int availableInternal() {
            int bytesRead = this.currentPieceOffsetInRope + this.currentPieceIndex;
            return this.this$0.size() - bytesRead;
        }
    }

    /* synthetic */ RopeByteString(ByteString x0, ByteString x1, AnonymousClass1 x2) {
        this(x0, x1);
    }

    static /* synthetic */ ByteString access$400(RopeByteString x0) {
        return x0.left;
    }

    static /* synthetic */ ByteString access$500(RopeByteString x0) {
        return x0.right;
    }

    @Override // com.bytedance.location.protobuf.ByteString, java.lang.Iterable
    /* JADX INFO: renamed from: iterator, reason: avoid collision after fix types in other method */
    public /* bridge */ /* synthetic */ Iterator<Byte> iterator2() {
        return iterator();
    }

    static {
        minLengthByDepth = new int[]{1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, FrameworkStatsLog.BACKPORTED_FIX_STATUS_REPORTED, 1597, 2584, 4181, 6765, 10946, 17711, 28657, 46368, 75025, 121393, 196418, 317811, 514229, 832040, 1346269, 2178309, 3524578, 5702887, 9227465, 14930352, 24157817, 39088169, 63245986, 102334155, 165580141, 267914296, 433494437, 701408733, 1134903170, 1836311903, Integer.MAX_VALUE};
    }

    private RopeByteString(ByteString left, ByteString right) {
        this.left = left;
        this.right = right;
        this.leftLength = left.size();
        this.totalLength = this.leftLength + right.size();
        this.treeDepth = Math.max(left.getTreeDepth(), right.getTreeDepth()) + 1;
    }

    static ByteString concatenate(ByteString left, ByteString right) {
        if (right.size() != 0) goto L6;
        return left;
    L6:
        if (left.size() != 0) goto L8;
        return right;
    L8:
        int newLength = left.size() + right.size();
        if (newLength >= 128) goto L13;
        return concatenateBytes(left, right);
    L13:
        if ((left instanceof RopeByteString) == false) goto L24;
        RopeByteString leftRope = (RopeByteString) left;
        if ((leftRope.right.size() + right.size()) >= 128) goto L18;
        ByteString newRight = concatenateBytes(leftRope.right, right);
        return new RopeByteString(leftRope.left, newRight);
    L18:
        ByteString newRight2 = leftRope.left;
        if (newRight2.getTreeDepth() <= leftRope.right.getTreeDepth()) goto L24;
        if (leftRope.getTreeDepth() <= right.getTreeDepth()) goto L24;
        ByteString newRight3 = new RopeByteString(leftRope.right, right);
        return new RopeByteString(leftRope.left, newRight3);
    L24:
        int newDepth = Math.max(left.getTreeDepth(), right.getTreeDepth()) + 1;
        if (newLength < minLength(newDepth)) goto L29;
        return new RopeByteString(left, right);
    L29:
        return Balancer.access$100(new Balancer(null), left, right);
    }

    private static ByteString concatenateBytes(ByteString left, ByteString right) {
        int leftSize = left.size();
        int rightSize = right.size();
        byte[] bytes = new byte[leftSize + rightSize];
        left.copyTo(bytes, 0, 0, leftSize);
        right.copyTo(bytes, 0, leftSize, rightSize);
        return ByteString.wrap(bytes);
    }

    static RopeByteString newInstanceForTest(ByteString left, ByteString right) {
        return new RopeByteString(left, right);
    }

    static int minLength(int depth) {
        if (depth < minLengthByDepth.length) goto L7;
        return Integer.MAX_VALUE;
    L7:
        return minLengthByDepth[depth];
    }

    @Override // com.bytedance.location.protobuf.ByteString
    public byte byteAt(int index) {
        ByteString.checkIndex(index, this.totalLength);
        return internalByteAt(index);
    }

    @Override // com.bytedance.location.protobuf.ByteString
    byte internalByteAt(int index) {
        if (index >= this.leftLength) goto L7;
        return this.left.internalByteAt(index);
    L7:
        return this.right.internalByteAt(index - this.leftLength);
    }

    @Override // com.bytedance.location.protobuf.ByteString
    public int size() {
        return this.totalLength;
    }

    @Override // com.bytedance.location.protobuf.ByteString, java.lang.Iterable
    public Iterator<Byte> iterator() {
        return new AnonymousClass1(this);
    }

    @Override // com.bytedance.location.protobuf.ByteString
    protected int getTreeDepth() {
        return this.treeDepth;
    }

    @Override // com.bytedance.location.protobuf.ByteString
    protected boolean isBalanced() {
        if (this.totalLength < minLength(this.treeDepth)) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.bytedance.location.protobuf.ByteString
    public ByteString substring(int beginIndex, int endIndex) {
        int length = ByteString.checkRange(beginIndex, endIndex, this.totalLength);
        if (length != 0) goto L7;
        return ByteString.EMPTY;
    L7:
        if (length != this.totalLength) goto L10;
        return this;
    L10:
        if (endIndex > this.leftLength) goto L14;
        return this.left.substring(beginIndex, endIndex);
    L14:
        if (beginIndex >= this.leftLength) goto L16;
        ByteString leftSub = this.left.substring(beginIndex);
        ByteString rightSub = this.right.substring(0, endIndex - this.leftLength);
        return new RopeByteString(leftSub, rightSub);
    L16:
        return this.right.substring(beginIndex - this.leftLength, endIndex - this.leftLength);
    }

    @Override // com.bytedance.location.protobuf.ByteString
    protected void copyToInternal(byte[] target, int sourceOffset, int targetOffset, int numberToCopy) {
        if ((sourceOffset + numberToCopy) > this.leftLength) goto L6;
        this.left.copyToInternal(target, sourceOffset, targetOffset, numberToCopy);
        return;
    L6:
        if (sourceOffset < this.leftLength) goto L8;
        this.right.copyToInternal(target, sourceOffset - this.leftLength, targetOffset, numberToCopy);
        return;
    L8:
        int leftLength = this.leftLength - sourceOffset;
        this.left.copyToInternal(target, sourceOffset, targetOffset, leftLength);
        this.right.copyToInternal(target, 0, targetOffset + leftLength, numberToCopy - leftLength);
    }

    @Override // com.bytedance.location.protobuf.ByteString
    public void copyTo(ByteBuffer target) {
        this.left.copyTo(target);
        this.right.copyTo(target);
    }

    @Override // com.bytedance.location.protobuf.ByteString
    public ByteBuffer asReadOnlyByteBuffer() {
        ByteBuffer byteBuffer = ByteBuffer.wrap(toByteArray());
        return byteBuffer.asReadOnlyBuffer();
    }

    @Override // com.bytedance.location.protobuf.ByteString
    public List<ByteBuffer> asReadOnlyByteBufferList() {
        List<ByteBuffer> result = new ArrayList();
        PieceIterator pieces = new PieceIterator(this, null);
    L4:
        if (pieces.hasNext() == false) goto L6;
        ByteString.LeafByteString byteString = pieces.next();
        result.add(byteString.asReadOnlyByteBuffer());
        goto L4
    L6:
        return result;
    }

    @Override // com.bytedance.location.protobuf.ByteString
    public void writeTo(OutputStream outputStream) throws IOException {
        this.left.writeTo(outputStream);
        this.right.writeTo(outputStream);
    }

    @Override // com.bytedance.location.protobuf.ByteString
    void writeToInternal(OutputStream out, int sourceOffset, int numberToWrite) throws IOException {
        if ((sourceOffset + numberToWrite) > this.leftLength) goto L6;
        this.left.writeToInternal(out, sourceOffset, numberToWrite);
        return;
    L6:
        if (sourceOffset < this.leftLength) goto L8;
        this.right.writeToInternal(out, sourceOffset - this.leftLength, numberToWrite);
        return;
    L8:
        int numberToWriteInLeft = this.leftLength - sourceOffset;
        this.left.writeToInternal(out, sourceOffset, numberToWriteInLeft);
        this.right.writeToInternal(out, 0, numberToWrite - numberToWriteInLeft);
    }

    @Override // com.bytedance.location.protobuf.ByteString
    void writeTo(ByteOutput output) throws IOException {
        this.left.writeTo(output);
        this.right.writeTo(output);
    }

    @Override // com.bytedance.location.protobuf.ByteString
    void writeToReverse(ByteOutput output) throws IOException {
        this.right.writeToReverse(output);
        this.left.writeToReverse(output);
    }

    @Override // com.bytedance.location.protobuf.ByteString
    protected String toStringInternal(Charset charset) {
        return new String(toByteArray(), charset);
    }

    @Override // com.bytedance.location.protobuf.ByteString
    public boolean isValidUtf8() {
        int leftPartial = this.left.partialIsValidUtf8(0, 0, this.leftLength);
        int state = this.right.partialIsValidUtf8(leftPartial, 0, this.right.size());
        if (state != 0) goto L6;
        return true;
    L6:
        return false;
    }

    @Override // com.bytedance.location.protobuf.ByteString
    protected int partialIsValidUtf8(int state, int offset, int length) {
        int toIndex = offset + length;
        if (toIndex > this.leftLength) goto L7;
        return this.left.partialIsValidUtf8(state, offset, length);
    L7:
        if (offset >= this.leftLength) goto L9;
        int leftLength = this.leftLength - offset;
        int leftPartial = this.left.partialIsValidUtf8(state, offset, leftLength);
        return this.right.partialIsValidUtf8(leftPartial, 0, length - leftLength);
    L9:
        return this.right.partialIsValidUtf8(state, offset - this.leftLength, length);
    }

    @Override // com.bytedance.location.protobuf.ByteString
    public boolean equals(Object other) {
        if (other != this) goto L6;
        return true;
    L6:
        if ((other instanceof ByteString) == true) goto L8;
        return false;
    L8:
        ByteString otherByteString = (ByteString) other;
        if (this.totalLength == otherByteString.size()) goto L12;
        return false;
    L12:
        if (this.totalLength != 0) goto L14;
        return true;
    L14:
        int thisHash = peekCachedHashCode();
        int thatHash = otherByteString.peekCachedHashCode();
        if (thisHash == 0) goto L20;
        if (thatHash == 0) goto L20;
        if (thisHash == thatHash) goto L20;
        return false;
    L20:
        return equalsFragments(otherByteString);
    }

    private boolean equalsFragments(ByteString r13) {
        int r0 = 0;
        AnonymousClass1 r2 = null;
        PieceIterator r1 = new PieceIterator(this, r2);
        ByteString.LeafByteString r3 = r1.next();
        int r4 = 0;
        PieceIterator r5 = new PieceIterator(r13, r2);
        ByteString.LeafByteString r6 = r5.next();
        int r7 = 0;
    L3:
        int r8 = r3.size() - r0;
        int r9 = r6.size() - r4;
        int r10 = Math.min(r8, r9);
        if (r0 != 0) goto L6;
        boolean r11 = r3.equalsRange(r6, r4, r10);
    L8:
        if (r11 == false) goto L9;
        r7 = r7 + r10;
        if (r7 >= this.totalLength) goto L14;
        if (r10 != r8) goto L21;
        r0 = 0;
        r3 = r1.next();
    L22:
        if (r10 == r9) goto L23;
        r4 = r4 + r10;
        goto L3
    L23:
        r4 = 0;
        r6 = r5.next();
        goto L3
    L21:
        r0 = r0 + r10;
        r3 = r3;
        goto L22
    L14:
        if (r7 != this.totalLength) goto L18;
        return true;
    L18:
        throw new IllegalStateException();
    L9:
        return false;
    L6:
        r11 = r6.equalsRange(r3, r0, r10);
        goto L8
    }

    @Override // com.bytedance.location.protobuf.ByteString
    protected int partialHash(int h, int offset, int length) {
        int toIndex = offset + length;
        if (toIndex > this.leftLength) goto L7;
        return this.left.partialHash(h, offset, length);
    L7:
        if (offset >= this.leftLength) goto L9;
        int leftLength = this.leftLength - offset;
        int leftPartial = this.left.partialHash(h, offset, leftLength);
        return this.right.partialHash(leftPartial, 0, length - leftLength);
    L9:
        return this.right.partialHash(h, offset - this.leftLength, length);
    }

    @Override // com.bytedance.location.protobuf.ByteString
    public CodedInputStream newCodedInput() {
        return CodedInputStream.newInstance(asReadOnlyByteBufferList(), true);
    }

    @Override // com.bytedance.location.protobuf.ByteString
    public InputStream newInput() {
        return new RopeInputStream(this);
    }

    Object writeReplace() {
        return ByteString.wrap(toByteArray());
    }

    private void readObject(ObjectInputStream in) throws IOException {
        throw new InvalidObjectException("RopeByteStream instances are not to be serialized directly");
    }
}
