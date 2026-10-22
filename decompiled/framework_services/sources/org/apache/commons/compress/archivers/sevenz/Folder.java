package org.apache.commons.compress.archivers.sevenz;

import java.util.LinkedList;

/* JADX INFO: loaded from: classes3.dex */
class Folder {
    BindPair[] bindPairs;
    Coder[] coders;
    long crc;
    boolean hasCrc;
    int numUnpackSubStreams;
    long[] packedStreams;
    long totalInputStreams;
    long totalOutputStreams;
    long[] unpackSizes;

    Folder() {
    }

    Iterable<Coder> getOrderedCoders() {
        LinkedList<Coder> l = new LinkedList();
        int current = (int) this.packedStreams[0];
    L3:
        int r2 = -1;
        if (current == (-1)) goto L9;
        l.addLast(this.coders[current]);
        int pair = findBindPairForOutStream(current);
        if (pair == (-1)) goto L8;
        r2 = (int) this.bindPairs[pair].inIndex;
    L8:
        current = r2;
        goto L3
    L9:
        return l;
    }

    int findBindPairForInStream(int index) {
        int i = 0;
    L4:
        if (i >= this.bindPairs.length) goto L9;
        if (this.bindPairs[i].inIndex == index) goto L7;
        i = i + 1;
        goto L4
    L7:
        return i;
    L9:
        return -1;
    }

    int findBindPairForOutStream(int index) {
        int i = 0;
    L4:
        if (i >= this.bindPairs.length) goto L9;
        if (this.bindPairs[i].outIndex == index) goto L7;
        i = i + 1;
        goto L4
    L7:
        return i;
    L9:
        return -1;
    }

    long getUnpackSize() {
        if (this.totalOutputStreams != 0) goto L5;
        return 0;
    L5:
        int i = ((int) this.totalOutputStreams) - 1;
    L6:
        if (i < 0) goto L13;
        if (findBindPairForOutStream(i) < 0) goto L10;
        i = i - 1;
        goto L6
    L10:
        return this.unpackSizes[i];
    L13:
        return 0;
    }

    long getUnpackSizeForCoder(Coder coder) {
        if (this.coders == null) goto L12;
        int i = 0;
    L6:
        if (i >= this.coders.length) goto L16;
        if (this.coders[i] == coder) goto L10;
        i = i + 1;
        goto L6
    L10:
        return this.unpackSizes[i];
    L16:
        return 0;
    L12:
        return 0;
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder();
        r0.append("Folder with ");
        r0.append(this.coders.length);
        r0.append(" coders, ");
        r0.append(this.totalInputStreams);
        r0.append(" input streams, ");
        r0.append(this.totalOutputStreams);
        r0.append(" output streams, ");
        r0.append(this.bindPairs.length);
        r0.append(" bind pairs, ");
        r0.append(this.packedStreams.length);
        r0.append(" packed streams, ");
        r0.append(this.unpackSizes.length);
        r0.append(" unpack sizes, ");
        if (this.hasCrc == false) goto L5;
        String r1 = "with CRC " + this.crc;
    L6:
        r0.append(r1);
        r0.append(" and ");
        r0.append(this.numUnpackSubStreams);
        r0.append(" unpack streams");
        return r0.toString();
    L5:
        r1 = "without CRC";
        goto L6
    }
}
