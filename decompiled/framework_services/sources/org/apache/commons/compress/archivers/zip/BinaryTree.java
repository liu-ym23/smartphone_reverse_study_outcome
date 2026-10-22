package org.apache.commons.compress.archivers.zip;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

/* JADX INFO: loaded from: classes3.dex */
class BinaryTree {
    private static final int NODE = -2;
    private static final int UNDEFINED = -1;
    private final int[] tree;

    public BinaryTree(int depth) {
        this.tree = new int[(1 << (depth + 1)) - 1];
        Arrays.fill(this.tree, -1);
    }

    public void addLeaf(int node, int path, int depth, int value) {
        if (depth == 0) goto L4;
        this.tree[node] = -2;
        int nextChild = ((node * 2) + 1) + (path & 1);
        addLeaf(nextChild, path >>> 1, depth - 1, value);
        return;
    L4:
        if (this.tree[node] != (-1)) goto L7;
        this.tree[node] = value;
        return;
    L7:
        throw new IllegalArgumentException("Tree value at index " + node + " has already been assigned (" + this.tree[node] + ")");
    }

    public int read(BitStream stream) throws IOException {
        int currentIndex = 0;
    L3:
        int bit = stream.nextBit();
        if (bit == (-1)) goto L5;
        int childIndex = ((currentIndex * 2) + 1) + bit;
        int value = this.tree[childIndex];
        if (value != (-2)) goto L9;
        currentIndex = childIndex;
        goto L3
    L9:
        if (value == (-1)) goto L12;
        return value;
    L12:
        throw new IOException("The child " + bit + " of node at index " + currentIndex + " is not defined");
    L5:
        return -1;
    }

    static BinaryTree decode(InputStream in, int totalNumberOfValues) throws IOException {
        int r2 = 1;
        int size = in.read() + 1;
        if (size == 0) goto L42;
        byte[] encodedTree = new byte[size];
        new DataInputStream(in).readFully(encodedTree);
        int maxLength = 0;
        int[] originalBitLengths = new int[totalNumberOfValues];
        int pos = 0;
        int r8 = encodedTree.length;
        int r10 = 0;
    L5:
        if (r10 >= r8) goto L10;
        byte b = encodedTree[r10];
        int numberOfValues = ((b & 240) >> 4) + 1;
        int bitLength = (b & 15) + 1;
        int j = 0;
    L7:
        if (j >= numberOfValues) goto L9;
        originalBitLengths[pos] = bitLength;
        j = j + 1;
        pos = pos + 1;
        goto L7
    L9:
        maxLength = Math.max(maxLength, bitLength);
        r10 = r10 + 1;
        goto L5
    L10:
        int[] permutation = new int[originalBitLengths.length];
        int k = 0;
    L12:
        if (k >= permutation.length) goto L14;
        permutation[k] = k;
        k = k + 1;
        goto L12
    L14:
        int c = 0;
        int[] sortedBitLengths = new int[originalBitLengths.length];
        int k2 = 0;
    L16:
        if (k2 >= originalBitLengths.length) goto L25;
        int l = 0;
    L19:
        if (l >= originalBitLengths.length) goto L24;
        if (originalBitLengths[l] != k2) goto L23;
        sortedBitLengths[c] = k2;
        permutation[c] = l;
        c = c + 1;
    L23:
        l = l + 1;
        goto L19
    L24:
        k2 = k2 + 1;
        goto L16
    L25:
        int code = 0;
        int codeIncrement = 0;
        int lastBitLength = 0;
        int[] codes = new int[totalNumberOfValues];
        int i = totalNumberOfValues - 1;
    L26:
        if (i < 0) goto L31;
        code = code + codeIncrement;
        int r17 = r2;
        if (sortedBitLengths[i] == lastBitLength) goto L30;
        int lastBitLength2 = sortedBitLengths[i];
        codeIncrement = r17 << (16 - lastBitLength2);
        lastBitLength = lastBitLength2;
    L30:
        int lastBitLength3 = permutation[i];
        codes[lastBitLength3] = code;
        i = i - 1;
        r2 = r17;
        goto L26
    L31:
        BinaryTree tree = new BinaryTree(maxLength);
        int k3 = 0;
    L33:
        if (k3 >= codes.length) goto L40;
        int bitLength2 = originalBitLengths[k3];
        if (bitLength2 <= 0) goto L38;
        tree.addLeaf(0, Integer.reverse(codes[k3] << 16), bitLength2, k3);
    L38:
        k3 = k3 + 1;
        encodedTree = encodedTree;
        size = size;
        goto L33
    L40:
        return tree;
    L42:
        throw new IOException("Cannot read the size of the encoded tree, unexpected end of stream");
    }
}
