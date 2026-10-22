package org.brotli.dec;

import android.hardware.tv.hdmi.cec.CecDeviceType;

/* JADX INFO: loaded from: classes3.dex */
final class BitReader {
    static final int BITNESS = 0;
    private static final int BUFFER_SIZE = 4160;
    private static final int BYTENESS = 0;
    private static final int CAPACITY = 4096;
    private static final int DEBUG = 0;
    private static final int HALF_BITNESS = 0;
    private static final int HALF_BUFFER_SIZE = 0;
    private static final int HALF_SIZE = 0;
    private static final int HALF_WATERLINE = 0;
    private static final int HALVES_CAPACITY = 0;
    private static final int LOG_BITNESS = 0;
    private static final int LOG_HALF_SIZE = 0;
    private static final int SAFEGUARD = 36;
    private static final int SLACK = 64;
    private static final int WATERLINE = 4060;

    BitReader() {
    }

    static {
        LOG_BITNESS = Utils.getLogBintness();
        DEBUG = Utils.isDebugMode();
        BITNESS = 1 << LOG_BITNESS;
        BYTENESS = BITNESS / 8;
        HALF_BITNESS = BITNESS / 2;
        HALF_SIZE = BYTENESS / 2;
        HALVES_CAPACITY = 4096 / HALF_SIZE;
        HALF_BUFFER_SIZE = BUFFER_SIZE / HALF_SIZE;
        HALF_WATERLINE = WATERLINE / HALF_SIZE;
        LOG_HALF_SIZE = LOG_BITNESS - 4;
    }

    static void readMoreInput(State s) {
        if (s.halfOffset <= HALF_WATERLINE) goto L6;
        doReadMoreInput(s);
        return;
    }

    static void doReadMoreInput(State s) {
        if (s.endOfStreamReached != 0) goto L5;
        int readOffset = s.halfOffset << LOG_HALF_SIZE;
        int bytesInBuffer = 4096 - readOffset;
        Utils.copyBytesWithin(s.byteBuffer, 0, readOffset, 4096);
        s.halfOffset = 0;
    L10:
        if (bytesInBuffer >= 4096) goto L15;
        int spaceLeft = 4096 - bytesInBuffer;
        int len = Utils.readInput(s.input, s.byteBuffer, bytesInBuffer, spaceLeft);
        if (len <= 0) goto L13;
        bytesInBuffer = bytesInBuffer + len;
        goto L10
    L13:
        s.endOfStreamReached = 1;
        s.tailBytes = bytesInBuffer;
        bytesInBuffer = bytesInBuffer + (HALF_SIZE - 1);
    L15:
        bytesToNibbles(s, bytesInBuffer);
        return;
    L5:
        if (halfAvailable(s) < (-2)) goto L8;
        return;
    L8:
        throw new BrotliRuntimeException("No more input");
    }

    static void checkHealth(State s, int endOfStream) {
        if (s.endOfStreamReached != 0) goto L5;
        return;
    L5:
        int byteOffset = ((s.halfOffset << LOG_HALF_SIZE) + ((s.bitOffset + 7) >> 3)) - BYTENESS;
        if (byteOffset > s.tailBytes) goto L15;
        if (endOfStream != 0) goto L9;
        return;
    L9:
        if (byteOffset != s.tailBytes) goto L12;
        return;
    L12:
        throw new BrotliRuntimeException("Unused bytes after end");
    L15:
        throw new BrotliRuntimeException("Read after end");
    }

    static void assertAccumulatorHealthy(State s) {
        if (s.bitOffset > BITNESS) goto L6;
        return;
    L6:
        throw new IllegalStateException("Accumulator underloaded: " + s.bitOffset);
    }

    static void fillBitWindow(State s) {
        if (DEBUG == 0) goto L6;
        assertAccumulatorHealthy(s);
    L6:
        if (s.bitOffset >= HALF_BITNESS) goto L8;
        return;
    L8:
        if (BITNESS != 64) goto L10;
        int[] r0 = s.intBuffer;
        int r1 = s.halfOffset;
        s.halfOffset = r1 + 1;
        s.accumulator64 = (((long) r0[r1]) << HALF_BITNESS) | (s.accumulator64 >>> HALF_BITNESS);
    L11:
        s.bitOffset -= HALF_BITNESS;
        return;
    L10:
        short[] r2 = s.shortBuffer;
        int r3 = s.halfOffset;
        s.halfOffset = r3 + 1;
        s.accumulator32 = (r2[r3] << HALF_BITNESS) | (s.accumulator32 >>> HALF_BITNESS);
        goto L11
    }

    static void doFillBitWindow(State s) {
        if (DEBUG == 0) goto L6;
        assertAccumulatorHealthy(s);
    L6:
        if (BITNESS != 64) goto L8;
        int[] r0 = s.intBuffer;
        int r1 = s.halfOffset;
        s.halfOffset = r1 + 1;
        s.accumulator64 = (((long) r0[r1]) << HALF_BITNESS) | (s.accumulator64 >>> HALF_BITNESS);
    L9:
        s.bitOffset -= HALF_BITNESS;
        return;
    L8:
        short[] r2 = s.shortBuffer;
        int r3 = s.halfOffset;
        s.halfOffset = r3 + 1;
        s.accumulator32 = (r2[r3] << HALF_BITNESS) | (s.accumulator32 >>> HALF_BITNESS);
        goto L9
    }

    static int peekBits(State s) {
        if (BITNESS != 64) goto L7;
        return (int) (s.accumulator64 >>> s.bitOffset);
    L7:
        return s.accumulator32 >>> s.bitOffset;
    }

    static int readFewBits(State s, int n) {
        int val = peekBits(s) & ((1 << n) - 1);
        s.bitOffset += n;
        return val;
    }

    static int readBits(State s, int n) {
        if (HALF_BITNESS < 24) goto L7;
        return readFewBits(s, n);
    L7:
        if (n > 16) goto L10;
        return readFewBits(s, n);
    L10:
        return readManyBits(s, n);
    }

    private static int readManyBits(State s, int n) {
        int low = readFewBits(s, 16);
        doFillBitWindow(s);
        return (readFewBits(s, n - 16) << 16) | low;
    }

    static void initBitReader(State s) {
        s.byteBuffer = new byte[BUFFER_SIZE];
        if (BITNESS != 64) goto L5;
        s.accumulator64 = 0;
        s.intBuffer = new int[HALF_BUFFER_SIZE];
    L6:
        s.bitOffset = BITNESS;
        s.halfOffset = HALVES_CAPACITY;
        s.endOfStreamReached = 0;
        prepare(s);
        return;
    L5:
        s.accumulator32 = 0;
        s.shortBuffer = new short[HALF_BUFFER_SIZE];
        goto L6
    }

    private static void prepare(State s) {
        readMoreInput(s);
        checkHealth(s, 0);
        doFillBitWindow(s);
        doFillBitWindow(s);
    }

    static void reload(State s) {
        if (s.bitOffset != BITNESS) goto L6;
        prepare(s);
        return;
    }

    static void jumpToByteBoundary(State s) {
        int padding = (BITNESS - s.bitOffset) & 7;
        if (padding == 0) goto L9;
        int paddingBits = readFewBits(s, padding);
        if (paddingBits != 0) goto L8;
        return;
    L8:
        throw new BrotliRuntimeException("Corrupted padding bits");
    }

    static int halfAvailable(State s) {
        int limit = HALVES_CAPACITY;
        if (s.endOfStreamReached == 0) goto L6;
        limit = (s.tailBytes + (HALF_SIZE - 1)) >> LOG_HALF_SIZE;
    L6:
        return limit - s.halfOffset;
    }

    static void copyBytes(State s, byte[] data, int offset, int length) {
        if ((s.bitOffset & 7) != 0) goto L30;
    L5:
        if (s.bitOffset == BITNESS) goto L8;
        if (length == 0) goto L8;
        data[offset] = (byte) peekBits(s);
        s.bitOffset += 8;
        length = length - 1;
        offset = offset + 1;
    L8:
        if (length != 0) goto L10;
        return;
    L10:
        int copyNibbles = Math.min(halfAvailable(s), length >> LOG_HALF_SIZE);
        if (copyNibbles <= 0) goto L13;
        int readOffset = s.halfOffset << LOG_HALF_SIZE;
        int delta = copyNibbles << LOG_HALF_SIZE;
        System.arraycopy(s.byteBuffer, readOffset, data, offset, delta);
        offset = offset + delta;
        length = length - delta;
        s.halfOffset += copyNibbles;
    L13:
        if (length != 0) goto L16;
        return;
    L16:
        if (halfAvailable(s) <= 0) goto L22;
        fillBitWindow(s);
    L18:
        if (length == 0) goto L20;
        data[offset] = (byte) peekBits(s);
        s.bitOffset += 8;
        length = length - 1;
        offset = offset + 1;
        goto L18
    L20:
        checkHealth(s, 0);
        return;
    L22:
        if (length <= 0) goto L28;
        int len = Utils.readInput(s.input, data, offset, length);
        if (len == (-1)) goto L27;
        offset = offset + len;
        length = length - len;
        goto L22
    L27:
        throw new BrotliRuntimeException("Unexpected end of input");
    L28:
        return;
    L30:
        throw new BrotliRuntimeException("Unaligned copyBytes");
    }

    static void bytesToNibbles(State s, int byteLen) {
        byte[] byteBuffer = s.byteBuffer;
        int halfLen = byteLen >> LOG_HALF_SIZE;
        if (BITNESS != 64) goto L8;
        int[] intBuffer = s.intBuffer;
        int i = 0;
    L5:
        if (i >= halfLen) goto L11;
        intBuffer[i] = (((byteBuffer[i * 4] & CecDeviceType.INACTIVE) | ((byteBuffer[(i * 4) + 1] & CecDeviceType.INACTIVE) << 8)) | ((byteBuffer[(i * 4) + 2] & CecDeviceType.INACTIVE) << 16)) | ((byteBuffer[(i * 4) + 3] & CecDeviceType.INACTIVE) << 24);
        i = i + 1;
        goto L5
    L11:
        return;
    L8:
        short[] shortBuffer = s.shortBuffer;
        int i2 = 0;
    L9:
        if (i2 >= halfLen) goto L14;
        shortBuffer[i2] = (short) ((byteBuffer[i2 * 2] & CecDeviceType.INACTIVE) | ((byteBuffer[(i2 * 2) + 1] & CecDeviceType.INACTIVE) << 8));
        i2 = i2 + 1;
        goto L9
    }
}
