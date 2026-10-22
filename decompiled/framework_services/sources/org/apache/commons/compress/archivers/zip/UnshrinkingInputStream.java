package org.apache.commons.compress.archivers.zip;

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteOrder;
import org.apache.commons.compress.compressors.lzw.LZWInputStream;

/* JADX INFO: loaded from: classes3.dex */
class UnshrinkingInputStream extends LZWInputStream {
    private static final int MAX_CODE_SIZE = 13;
    private static final int MAX_TABLE_SIZE = 8192;
    private final boolean[] isUsed;

    public UnshrinkingInputStream(InputStream inputStream) throws IOException {
        super(inputStream, ByteOrder.LITTLE_ENDIAN);
        setClearCode(9);
        initializeTables(13);
        this.isUsed = new boolean[getPrefixesLength()];
        int i = 0;
    L4:
        if (i >= 256) goto L6;
        this.isUsed[i] = true;
        i = i + 1;
        goto L4
    L6:
        int i2 = getClearCode();
        setTableSize(i2 + 1);
    }

    @Override // org.apache.commons.compress.compressors.lzw.LZWInputStream
    protected int addEntry(int previousCode, byte character) throws IOException {
        int tableSize = getTableSize();
    L4:
        if (tableSize >= 8192) goto L8;
        if (this.isUsed[tableSize] == false) goto L8;
        tableSize = tableSize + 1;
    L8:
        setTableSize(tableSize);
        int idx = addEntry(previousCode, character, 8192);
        if (idx < 0) goto L11;
        this.isUsed[idx] = true;
    L11:
        return idx;
    }

    private void partialClear() {
        boolean[] isParent = new boolean[8192];
        int i = 0;
    L4:
        if (i >= this.isUsed.length) goto L11;
        if (this.isUsed[i] == false) goto L10;
        if (getPrefix(i) == (-1)) goto L10;
        isParent[getPrefix(i)] = true;
    L10:
        i = i + 1;
        goto L4
    L11:
        int i2 = getClearCode();
        int i3 = i2 + 1;
    L13:
        if (i3 >= isParent.length) goto L19;
        if (isParent[i3] == true) goto L17;
        this.isUsed[i3] = false;
        setPrefix(i3, -1);
    L17:
        i3 = i3 + 1;
        goto L13
    }

    @Override // org.apache.commons.compress.compressors.lzw.LZWInputStream
    protected int decompressNextSymbol() throws IOException {
        int code = readNextCode();
        if (code >= 0) goto L7;
        return -1;
    L7:
        if (code != getClearCode()) goto L26;
        int subCode = readNextCode();
        if (subCode < 0) goto L25;
        if (subCode != 1) goto L18;
        if (getCodeSize() >= 13) goto L16;
        incrementCodeSize();
        return 0;
    L16:
        throw new IOException("Attempt to increase code size beyond maximum");
    L18:
        if (subCode != 2) goto L23;
        partialClear();
        setTableSize(getClearCode() + 1);
        return 0;
    L23:
        throw new IOException("Invalid clear code subcode " + subCode);
    L25:
        throw new IOException("Unexpected EOF;");
    L26:
        boolean addedUnfinishedEntry = false;
        int effectiveCode = code;
        if (this.isUsed[code] == true) goto L30;
        effectiveCode = addRepeatOfPreviousCode();
        addedUnfinishedEntry = true;
    L30:
        return expandCodeToOutputStack(effectiveCode, addedUnfinishedEntry);
    }
}
