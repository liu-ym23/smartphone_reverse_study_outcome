package org.apache.commons.compress.compressors.z;

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteOrder;
import org.apache.commons.compress.compressors.lzw.LZWInputStream;

/* JADX INFO: loaded from: classes3.dex */
public class ZCompressorInputStream extends LZWInputStream {
    private static final int BLOCK_MODE_MASK = 128;
    private static final int MAGIC_1 = 31;
    private static final int MAGIC_2 = 157;
    private static final int MAX_CODE_SIZE_MASK = 31;
    private final boolean blockMode;
    private final int maxCodeSize;
    private long totalCodesRead;

    public ZCompressorInputStream(InputStream inputStream, int memoryLimitInKb) throws IOException {
        super(inputStream, ByteOrder.LITTLE_ENDIAN);
        this.totalCodesRead = 0;
        int firstByte = (int) this.in.readBits(8);
        int secondByte = (int) this.in.readBits(8);
        int thirdByte = (int) this.in.readBits(8);
        if (firstByte != 31) goto L17;
        if (secondByte != 157) goto L17;
        if (thirdByte < 0) goto L17;
        if ((thirdByte & 128) == 0) goto L10;
        boolean r3 = true;
    L11:
        this.blockMode = r3;
        this.maxCodeSize = thirdByte & 31;
        if (this.blockMode == false) goto L14;
        setClearCode(9);
    L14:
        initializeTables(this.maxCodeSize, memoryLimitInKb);
        clearEntries();
        return;
    L10:
        r3 = false;
    L17:
        throw new IOException("Input is not in .Z format");
    }

    public ZCompressorInputStream(InputStream inputStream) throws IOException {
        this(inputStream, -1);
    }

    private void clearEntries() {
        setTableSize((this.blockMode ? 1 : 0) + 256);
    }

    @Override // org.apache.commons.compress.compressors.lzw.LZWInputStream
    protected int readNextCode() throws IOException {
        int code = super.readNextCode();
        if (code < 0) goto L5;
        this.totalCodesRead++;
    L5:
        return code;
    }

    private void reAlignReading() throws IOException {
        long codeReadsToThrowAway = 8 - (this.totalCodesRead % 8);
        if (codeReadsToThrowAway != 8) goto L5;
        codeReadsToThrowAway = 0;
    L5:
        long i = 0;
    L7:
        if (i >= codeReadsToThrowAway) goto L9;
        readNextCode();
        i = i + 1;
        goto L7
    L9:
        this.in.clearBitCache();
    }

    @Override // org.apache.commons.compress.compressors.lzw.LZWInputStream
    protected int addEntry(int previousCode, byte character) throws IOException {
        int maxTableSize = 1 << getCodeSize();
        int r = addEntry(previousCode, character, maxTableSize);
        if (getTableSize() == maxTableSize) goto L5;
    L7:
        return r;
    L5:
        if (getCodeSize() >= this.maxCodeSize) goto L7;
        reAlignReading();
        incrementCodeSize();
        goto L7
    }

    @Override // org.apache.commons.compress.compressors.lzw.LZWInputStream
    protected int decompressNextSymbol() throws IOException {
        int code = readNextCode();
        if (code >= 0) goto L7;
        return -1;
    L7:
        if (this.blockMode == true) goto L9;
    L12:
        boolean addedUnfinishedEntry = false;
        if (code != getTableSize()) goto L16;
        addRepeatOfPreviousCode();
        addedUnfinishedEntry = true;
    L18:
        return expandCodeToOutputStack(code, addedUnfinishedEntry);
    L16:
        if (code <= getTableSize()) goto L18;
        throw new IOException(String.format("Invalid %d bit code 0x%x", new Object[]{Integer.valueOf(getCodeSize()), Integer.valueOf(code)}));
    L9:
        if (code != getClearCode()) goto L12;
        clearEntries();
        reAlignReading();
        resetCodeSize();
        resetPreviousCode();
        return 0;
    }

    public static boolean matches(byte[] signature, int length) {
        if (length > 3) goto L5;
        return false;
    L5:
        if (signature[0] == 31) goto L7;
        return false;
    L7:
        if (signature[1] == (-99)) goto L9;
        return false;
    L9:
        return true;
    }
}
