package org.brotli.dec;

/* JADX INFO: loaded from: classes3.dex */
final class Huffman {
    private static final int MAX_LENGTH = 15;

    Huffman() {
    }

    private static int getNextKey(int key, int len) {
        int step = 1 << (len - 1);
    L4:
        if ((key & step) == 0) goto L7;
        step = step >> 1;
        goto L4
    L7:
        return ((step - 1) & key) + step;
    }

    private static void replicateValue(int[] table, int offset, int step, int end, int item) {
    L2:
        end = end - step;
        table[offset + end] = item;
        if (end > 0) goto L2;
    }

    private static int nextTableBitSize(int[] count, int len, int rootBits) {
        int left = 1 << (len - rootBits);
    L4:
        if (len >= 15) goto L10;
        int left2 = left - count[len];
        if (left2 <= 0) goto L10;
        len = len + 1;
        left = left2 << 1;
    L10:
        return len - rootBits;
    }

    static int buildHuffmanTable(int[] tableGroup, int tableIdx, int rootBits, int[] codeLengths, int codeLengthsSize) {
        int tableOffset = tableGroup[tableIdx];
        int[] sorted = new int[codeLengthsSize];
        int[] count = new int[16];
        int[] offset = new int[16];
        int symbol = 0;
    L3:
        int r9 = 1;
        if (symbol >= codeLengthsSize) goto L6;
        int r10 = codeLengths[symbol];
        count[r10] = count[r10] + 1;
        symbol = symbol + 1;
        goto L3
    L6:
        offset[1] = 0;
        int len = 1;
    L7:
        int r12 = 15;
        if (len >= 15) goto L10;
        offset[len + 1] = offset[len] + count[len];
        len = len + 1;
        goto L7
    L10:
        int symbol2 = 0;
    L11:
        if (symbol2 >= codeLengthsSize) goto L16;
        if (codeLengths[symbol2] == 0) goto L15;
        int r11 = codeLengths[symbol2];
        int r13 = offset[r11];
        offset[r11] = r13 + 1;
        sorted[r13] = symbol2;
    L15:
        symbol2 = symbol2 + 1;
        goto L11
    L16:
        int tableSize = 1 << rootBits;
        int totalSize = tableSize;
        if (offset[15] != 1) goto L22;
        int key = 0;
    L19:
        if (key >= totalSize) goto L21;
        tableGroup[tableOffset + key] = sorted[0];
        key = key + 1;
        goto L19
    L21:
        return totalSize;
    L22:
        int key2 = 0;
        int symbol3 = 0;
        int len2 = 1;
        int step = 2;
    L23:
        if (len2 > rootBits) goto L28;
    L25:
        if (count[len2] <= 0) goto L27;
        replicateValue(tableGroup, tableOffset + key2, step, tableSize, (len2 << 16) | sorted[symbol3]);
        key2 = getNextKey(key2, len2);
        count[len2] = count[len2] - 1;
        r9 = r9;
        symbol3 = symbol3 + 1;
        goto L25
    L27:
        len2 = len2 + 1;
        step = step << 1;
        goto L23
    L28:
        int r17 = r9;
        int step2 = totalSize - 1;
        int low = -1;
        int currentOffset = tableOffset;
        int len3 = rootBits + 1;
        int len4 = len3;
        int step3 = 2;
    L30:
        if (len4 > r12) goto L38;
    L32:
        if (count[len4] <= 0) goto L37;
        if ((key2 & step2) == low) goto L36;
        currentOffset = currentOffset + tableSize;
        int tableBits = nextTableBitSize(count, len4, rootBits);
        tableSize = r17 << tableBits;
        totalSize = totalSize + tableSize;
        low = key2 & step2;
        tableGroup[tableOffset + low] = ((tableBits + rootBits) << 16) | ((currentOffset - tableOffset) - low);
    L36:
        replicateValue(tableGroup, (key2 >> rootBits) + currentOffset, step3, tableSize, ((len4 - rootBits) << 16) | sorted[symbol3]);
        key2 = getNextKey(key2, len4);
        count[len4] = count[len4] - 1;
        symbol3 = symbol3 + 1;
        goto L32
    L37:
        len4 = len4 + 1;
        step3 = step3 << 1;
        r12 = 15;
        goto L30
    L38:
        return totalSize;
    }
}
