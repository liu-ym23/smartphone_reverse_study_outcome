package org.apache.commons.compress.compressors.lzw;

import android.hardware.tv.hdmi.cec.CecDeviceType;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteOrder;
import org.apache.commons.compress.MemoryLimitException;
import org.apache.commons.compress.compressors.CompressorInputStream;
import org.apache.commons.compress.utils.BitInputStream;
import org.apache.commons.compress.utils.InputStreamStatistics;

/* JADX INFO: loaded from: classes3.dex */
public abstract class LZWInputStream extends CompressorInputStream implements InputStreamStatistics {
    protected static final int DEFAULT_CODE_SIZE = 9;
    protected static final int UNUSED_PREFIX = -1;
    private byte[] characters;
    private int clearCode;
    private int codeSize;
    protected final BitInputStream in;
    private final byte[] oneByte;
    private byte[] outputStack;
    private int outputStackLocation;
    private int[] prefixes;
    private int previousCode;
    private byte previousCodeFirstChar;
    private int tableSize;

    protected abstract int addEntry(int r1, byte r2) throws IOException;

    protected abstract int decompressNextSymbol() throws IOException;

    protected LZWInputStream(InputStream inputStream, ByteOrder byteOrder) {
        this.oneByte = new byte[1];
        this.clearCode = -1;
        this.codeSize = 9;
        this.previousCode = -1;
        this.in = new BitInputStream(inputStream, byteOrder);
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.in.close();
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        int ret = read(this.oneByte);
        if (ret >= 0) goto L6;
        return ret;
    L6:
        return this.oneByte[0] & CecDeviceType.INACTIVE;
    }

    @Override // java.io.InputStream
    public int read(byte[] b, int off, int len) throws IOException {
        int bytesRead = readFromStack(b, off, len);
    L4:
        if ((len - bytesRead) <= 0) goto L12;
        int result = decompressNextSymbol();
        if (result < 0) goto L7;
        bytesRead = bytesRead + readFromStack(b, off + bytesRead, len - bytesRead);
        goto L4
    L7:
        if (bytesRead <= 0) goto L10;
        count(bytesRead);
        return bytesRead;
    L10:
        return result;
    L12:
        count(bytesRead);
        return bytesRead;
    }

    @Override // org.apache.commons.compress.utils.InputStreamStatistics
    public long getCompressedCount() {
        return this.in.getBytesRead();
    }

    protected void setClearCode(int codeSize) {
        this.clearCode = 1 << (codeSize - 1);
    }

    protected void initializeTables(int maxCodeSize, int memoryLimitInKb) throws MemoryLimitException {
        if (memoryLimitInKb <= (-1)) goto L9;
        int maxTableSize = 1 << maxCodeSize;
        long memoryUsageInBytes = ((long) maxTableSize) * 6;
        long memoryUsageInKb = memoryUsageInBytes >> 10;
        if (memoryUsageInKb <= memoryLimitInKb) goto L9;
        throw new MemoryLimitException(memoryUsageInKb, memoryLimitInKb);
    L9:
        initializeTables(maxCodeSize);
    }

    protected void initializeTables(int maxCodeSize) {
        int maxTableSize = 1 << maxCodeSize;
        this.prefixes = new int[maxTableSize];
        this.characters = new byte[maxTableSize];
        this.outputStack = new byte[maxTableSize];
        this.outputStackLocation = maxTableSize;
        int i = 0;
    L4:
        if (i >= 256) goto L7;
        this.prefixes[i] = -1;
        this.characters[i] = (byte) i;
        i = i + 1;
        goto L4
    }

    protected int readNextCode() throws IOException {
        if (this.codeSize > 31) goto L7;
        return (int) this.in.readBits(this.codeSize);
    L7:
        throw new IllegalArgumentException("code size must not be bigger than 31");
    }

    protected int addEntry(int previousCode, byte character, int maxTableSize) {
        if (this.tableSize >= maxTableSize) goto L6;
        this.prefixes[this.tableSize] = previousCode;
        this.characters[this.tableSize] = character;
        int r0 = this.tableSize;
        this.tableSize = r0 + 1;
        return r0;
    L6:
        return -1;
    }

    protected int addRepeatOfPreviousCode() throws IOException {
        if (this.previousCode == (-1)) goto L7;
        return addEntry(this.previousCode, this.previousCodeFirstChar);
    L7:
        throw new IOException("The first code can't be a reference to its preceding code");
    }

    protected int expandCodeToOutputStack(int code, boolean addedUnfinishedEntry) throws IOException {
        int entry = code;
    L3:
        if (entry < 0) goto L5;
        byte[] r1 = this.outputStack;
        int r2 = this.outputStackLocation - 1;
        this.outputStackLocation = r2;
        r1[r2] = this.characters[entry];
        entry = this.prefixes[entry];
        goto L3
    L5:
        int entry2 = this.previousCode;
        if (entry2 == (-1)) goto L9;
        if (addedUnfinishedEntry == true) goto L9;
        addEntry(this.previousCode, this.outputStack[this.outputStackLocation]);
    L9:
        this.previousCode = code;
        this.previousCodeFirstChar = this.outputStack[this.outputStackLocation];
        return this.outputStackLocation;
    }

    private int readFromStack(byte[] b, int off, int len) {
        int remainingInStack = this.outputStack.length - this.outputStackLocation;
        if (remainingInStack <= 0) goto L6;
        int maxLength = Math.min(remainingInStack, len);
        System.arraycopy(this.outputStack, this.outputStackLocation, b, off, maxLength);
        this.outputStackLocation += maxLength;
        return maxLength;
    L6:
        return 0;
    }

    protected int getCodeSize() {
        return this.codeSize;
    }

    protected void resetCodeSize() {
        setCodeSize(9);
    }

    protected void setCodeSize(int cs) {
        this.codeSize = cs;
    }

    protected void incrementCodeSize() {
        this.codeSize++;
    }

    protected void resetPreviousCode() {
        this.previousCode = -1;
    }

    protected int getPrefix(int offset) {
        return this.prefixes[offset];
    }

    protected void setPrefix(int offset, int value) {
        this.prefixes[offset] = value;
    }

    protected int getPrefixesLength() {
        return this.prefixes.length;
    }

    protected int getClearCode() {
        return this.clearCode;
    }

    protected int getTableSize() {
        return this.tableSize;
    }

    protected void setTableSize(int newSize) {
        this.tableSize = newSize;
    }
}
