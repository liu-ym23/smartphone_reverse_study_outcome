package org.brotli.dec;

import android.hardware.tv.hdmi.cec.CecDeviceType;
import com.android.internal.util.FrameworkStatsLog;
import com.android.server.ISmartService;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes3.dex */
final class Decode {
    static final int[] BLOCK_LENGTH_N_BITS = null;
    static final int[] BLOCK_LENGTH_OFFSET = null;
    private static final int BLOCK_START = 2;
    private static final int CD_BLOCK_MAP_BITS = 8;
    private static final int CLOSED = 11;
    static final short[] CMD_LOOKUP = null;
    private static final int CODE_LENGTH_CODES = 18;
    private static final int[] CODE_LENGTH_CODE_ORDER = null;
    private static final int CODE_LENGTH_REPEAT_CODE = 16;
    private static final int COMPRESSED_BLOCK_START = 3;
    private static final int COPY_FROM_COMPOUND_DICTIONARY = 14;
    static final short[] COPY_LENGTH_N_BITS = null;
    private static final int COPY_LOOP = 8;
    private static final int COPY_UNCOMPRESSED = 6;
    private static final int DEFAULT_CODE_LENGTH = 8;
    private static final int DISTANCE_CONTEXT_BITS = 2;
    private static final int[] DISTANCE_SHORT_CODE_INDEX_OFFSET = null;
    private static final int[] DISTANCE_SHORT_CODE_VALUE_OFFSET = null;
    private static final int FINISHED = 10;
    private static final int[] FIXED_TABLE = null;
    private static final int HUFFMAN_TABLE_BITS = 8;
    private static final int HUFFMAN_TABLE_MASK = 255;
    private static final int HUFFMAN_TABLE_SIZE_258 = 632;
    private static final int HUFFMAN_TABLE_SIZE_26 = 396;
    private static final int INITIALIZED = 1;
    private static final int INIT_WRITE = 12;
    static final short[] INSERT_LENGTH_N_BITS = null;
    private static final int INSERT_LOOP = 7;
    private static final int LITERAL_CONTEXT_BITS = 6;
    private static final int MAIN_LOOP = 4;
    private static final int MAX_ALLOWED_DISTANCE = 2147483644;
    private static final int MAX_DISTANCE_BITS = 24;
    static final int[] MAX_HUFFMAN_TABLE_SIZE = null;
    static final int MAX_LARGE_WINDOW_BITS = 30;
    private static final int MAX_LARGE_WINDOW_DISTANCE_BITS = 62;
    static final int MAX_TRANSFORMED_WORD_LENGTH = 37;
    static final int MIN_LARGE_WINDOW_BITS = 10;
    private static final int NUM_BLOCK_LENGTH_CODES = 26;
    private static final int NUM_COMMAND_CODES = 704;
    private static final int NUM_DISTANCE_SHORT_CODES = 16;
    private static final int NUM_LITERAL_CODES = 256;
    private static final int READ_METADATA = 5;
    private static final int UNINITIALIZED = 0;
    private static final int USE_DICTIONARY = 9;
    private static final int WRITE = 13;

    Decode() {
    }

    static {
        MAX_HUFFMAN_TABLE_SIZE = new int[]{256, 402, 436, FrameworkStatsLog.SYNC_EXEMPTION_OCCURRED, 500, FrameworkStatsLog.BRIGHTNESS_CONFIGURATION_UPDATED, FrameworkStatsLog.MOBILE_BUNDLED_APP_INFO_GATHERED, 598, 630, 662, 694, 726, 758, 790, 822, 854, 886, ISmartService.PROTECT_LRU_PARAM, 952, 984, 1016, FrameworkStatsLog.CLIPBOARD_GET_EVENT_REPORTED, 1080};
        CODE_LENGTH_CODE_ORDER = new int[]{1, 2, 3, 4, 0, 5, 17, 6, 16, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        DISTANCE_SHORT_CODE_INDEX_OFFSET = new int[]{0, 3, 2, 1, 0, 0, 0, 0, 0, 0, 3, 3, 3, 3, 3, 3};
        DISTANCE_SHORT_CODE_VALUE_OFFSET = new int[]{0, 0, 0, 0, -1, 1, -2, 2, -3, 3, -1, 1, -2, 2, -3, 3};
        FIXED_TABLE = new int[]{131072, 131076, 131075, 196610, 131072, 131076, 131075, 262145, 131072, 131076, 131075, 196610, 131072, 131076, 131075, 262149};
        BLOCK_LENGTH_OFFSET = new int[]{1, 5, 9, 13, 17, 25, 33, 41, 49, 65, 81, 97, 113, 145, 177, 209, 241, 305, 369, 497, 753, 1265, 2289, 4337, 8433, 16625};
        BLOCK_LENGTH_N_BITS = new int[]{2, 2, 2, 2, 3, 3, 3, 3, 4, 4, 4, 4, 5, 5, 5, 5, 6, 6, 7, 8, 9, 10, 11, 12, 13, 24};
        INSERT_LENGTH_N_BITS = new short[]{0, 0, 0, 0, 0, 0, 1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 7, 8, 9, 10, 12, 14, 24};
        COPY_LENGTH_N_BITS = new short[]{0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 7, 8, 9, 10, 24};
        CMD_LOOKUP = new short[2816];
        unpackCommandLookupTable(CMD_LOOKUP);
    }

    private static int log2floor(int i) {
        int result = -1;
        int step = 16;
    L3:
        if (step <= 0) goto L9;
        if ((i >>> step) == 0) goto L7;
        result = result + step;
        i = i >>> step;
    L7:
        step = step >> 1;
        goto L3
    L9:
        return result + i;
    }

    private static int calculateDistanceAlphabetSize(int npostfix, int ndirect, int maxndistbits) {
        return (ndirect + 16) + ((maxndistbits << npostfix) * 2);
    }

    private static int calculateDistanceAlphabetLimit(int maxDistance, int npostfix, int ndirect) {
        if (maxDistance < ((2 << npostfix) + ndirect)) goto L7;
        int offset = ((maxDistance - ndirect) >> npostfix) + 4;
        int ndistbits = log2floor(offset) - 1;
        int group = ((ndistbits - 1) << 1) | ((offset >> ndistbits) & 1);
        return ((((group - 1) << npostfix) + (1 << npostfix)) + ndirect) + 16;
    L7:
        throw new IllegalArgumentException("maxDistance is too small");
    }

    private static void unpackCommandLookupTable(short[] cmdLookup) {
        short[] insertLengthOffsets = new short[24];
        short[] copyLengthOffsets = new short[24];
        copyLengthOffsets[0] = 2;
        int i = 0;
    L4:
        if (i >= 23) goto L6;
        insertLengthOffsets[i + 1] = (short) (insertLengthOffsets[i] + (1 << INSERT_LENGTH_N_BITS[i]));
        copyLengthOffsets[i + 1] = (short) (copyLengthOffsets[i] + (1 << COPY_LENGTH_N_BITS[i]));
        i = i + 1;
        goto L4
    L6:
        int cmdCode = 0;
    L8:
        if (cmdCode >= NUM_COMMAND_CODES) goto L18;
        int rangeIdx = cmdCode >>> 6;
        int distanceContextOffset = -4;
        if (rangeIdx < 2) goto L12;
        rangeIdx = rangeIdx - 2;
        distanceContextOffset = 0;
    L12:
        int r7 = 3;
        int insertCode = (((170064 >>> (rangeIdx * 2)) & 3) << 3) | ((cmdCode >>> 3) & 7);
        int copyCode = (((156228 >>> (rangeIdx * 2)) & 3) << 3) | (cmdCode & 7);
        short copyLengthOffset = copyLengthOffsets[copyCode];
        if (copyLengthOffset > 4) goto L16;
        r7 = copyLengthOffset - 2;
    L16:
        int distanceContext = r7 + distanceContextOffset;
        int index = cmdCode * 4;
        cmdLookup[index + 0] = (short) (INSERT_LENGTH_N_BITS[insertCode] | (COPY_LENGTH_N_BITS[copyCode] << 8));
        cmdLookup[index + 1] = insertLengthOffsets[insertCode];
        cmdLookup[index + 2] = copyLengthOffsets[copyCode];
        cmdLookup[index + 3] = (short) distanceContext;
        cmdCode = cmdCode + 1;
        goto L8
    }

    private static int decodeWindowBits(State s) {
        int largeWindowEnabled = s.isLargeWindow;
        s.isLargeWindow = 0;
        BitReader.fillBitWindow(s);
        if (BitReader.readFewBits(s, 1) != 0) goto L6;
        return 16;
    L6:
        int n = BitReader.readFewBits(s, 3);
        if (n != 0) goto L9;
        int n2 = BitReader.readFewBits(s, 3);
        if (n2 == 0) goto L28;
        if (n2 != 1) goto L27;
        if (largeWindowEnabled != 0) goto L16;
        return -1;
    L16:
        s.isLargeWindow = 1;
        if (BitReader.readFewBits(s, 1) != 1) goto L19;
        return -1;
    L19:
        int n3 = BitReader.readFewBits(s, 6);
        if (n3 >= 10) goto L22;
    L25:
        return -1;
    L22:
        if (n3 > 30) goto L25;
        return n3;
    L27:
        return n2 + 8;
    L28:
        return 17;
    L9:
        return n + 17;
    }

    static void enableEagerOutput(State s) {
        if (s.runningState != 1) goto L7;
        s.isEager = 1;
        return;
    L7:
        throw new IllegalStateException("State MUST be freshly initialized");
    }

    static void enableLargeWindow(State s) {
        if (s.runningState != 1) goto L7;
        s.isLargeWindow = 1;
        return;
    L7:
        throw new IllegalStateException("State MUST be freshly initialized");
    }

    static void attachDictionaryChunk(State s, byte[] data) {
        if (s.runningState != 1) goto L14;
        if (s.cdNumChunks != 0) goto L8;
        s.cdChunks = new byte[16][];
        s.cdChunkOffsets = new int[16];
        s.cdBlockBits = -1;
    L8:
        if (s.cdNumChunks == 15) goto L12;
        s.cdChunks[s.cdNumChunks] = data;
        s.cdNumChunks++;
        s.cdTotalSize += data.length;
        s.cdChunkOffsets[s.cdNumChunks] = s.cdTotalSize;
        return;
    L12:
        throw new IllegalStateException("Too many dictionary chunks");
    L14:
        throw new IllegalStateException("State MUST be freshly initialized");
    }

    static void initState(State s, InputStream input) {
        if (s.runningState != 0) goto L7;
        s.blockTrees = new int[3091];
        s.blockTrees[0] = 7;
        s.distRbIdx = 3;
        int maxDistanceAlphabetLimit = calculateDistanceAlphabetLimit(MAX_ALLOWED_DISTANCE, 3, 120);
        s.distExtraBits = new byte[maxDistanceAlphabetLimit];
        s.distOffset = new int[maxDistanceAlphabetLimit];
        s.input = input;
        BitReader.initBitReader(s);
        s.runningState = 1;
        return;
    L7:
        throw new IllegalStateException("State MUST be uninitialized");
    }

    static void close(State s) throws IOException {
        if (s.runningState == 0) goto L12;
        if (s.runningState != 11) goto L7;
        return;
    L7:
        s.runningState = 11;
        if (s.input == null) goto L13;
        Utils.closeInput(s.input);
        s.input = null;
        return;
    L13:
        return;
    L12:
        throw new IllegalStateException("State MUST be initialized");
    }

    private static int decodeVarLenUnsignedByte(State s) {
        BitReader.fillBitWindow(s);
        if (BitReader.readFewBits(s, 1) == 0) goto L9;
        int n = BitReader.readFewBits(s, 3);
        if (n != 0) goto L8;
        return 1;
    L8:
        return BitReader.readFewBits(s, n) + (1 << n);
    L9:
        return 0;
    }

    private static void decodeMetaBlockLength(State s) {
        BitReader.fillBitWindow(s);
        s.inputEnd = BitReader.readFewBits(s, 1);
        s.metaBlockLength = 0;
        s.isUncompressed = 0;
        s.isMetadata = 0;
        if (s.inputEnd != 0) goto L5;
    L7:
        int sizeNibbles = BitReader.readFewBits(s, 2) + 4;
        if (sizeNibbles != 7) goto L28;
        s.isMetadata = 1;
        if (BitReader.readFewBits(s, 1) != 0) goto L27;
        int sizeBytes = BitReader.readFewBits(s, 2);
        if (sizeBytes != 0) goto L14;
        return;
    L14:
        int i = 0;
    L15:
        if (i >= sizeBytes) goto L39;
        BitReader.fillBitWindow(s);
        int bits = BitReader.readFewBits(s, 8);
        if (bits != 0) goto L24;
        if ((i + 1) != sizeBytes) goto L24;
        if (sizeBytes <= 1) goto L24;
        throw new BrotliRuntimeException("Exuberant nibble");
    L24:
        s.metaBlockLength |= bits << (i * 8);
        i = i + 1;
    L39:
        int i2 = s.metaBlockLength;
        s.metaBlockLength = i2 + 1;
        if (s.inputEnd != 0) goto L53;
        s.isUncompressed = BitReader.readFewBits(s, 1);
        return;
    L53:
        return;
    L27:
        throw new BrotliRuntimeException("Corrupted reserved bit");
    L28:
        int i3 = 0;
    L29:
        if (i3 >= sizeNibbles) goto L39;
        BitReader.fillBitWindow(s);
        int bits2 = BitReader.readFewBits(s, 4);
        if (bits2 != 0) goto L38;
        if ((i3 + 1) != sizeNibbles) goto L38;
        if (sizeNibbles <= 4) goto L38;
        throw new BrotliRuntimeException("Exuberant nibble");
    L38:
        s.metaBlockLength |= bits2 << (i3 * 4);
        i3 = i3 + 1;
        goto L29
    L5:
        if (BitReader.readFewBits(s, 1) == 0) goto L7;
    }

    private static int readSymbol(int[] tableGroup, int tableIdx, State s) {
        int offset = tableGroup[tableIdx];
        int val = BitReader.peekBits(s);
        int offset2 = offset + (val & 255);
        int bits = tableGroup[offset2] >> 16;
        int sym = tableGroup[offset2] & 65535;
        if (bits > 8) goto L6;
        s.bitOffset += bits;
        return sym;
    L6:
        int mask = (1 << bits) - 1;
        int offset3 = (offset2 + sym) + ((val & mask) >>> 8);
        s.bitOffset += (tableGroup[offset3] >> 16) + 8;
        return 65535 & tableGroup[offset3];
    }

    private static int readBlockLength(int[] tableGroup, int tableIdx, State s) {
        BitReader.fillBitWindow(s);
        int code = readSymbol(tableGroup, tableIdx, s);
        int n = BLOCK_LENGTH_N_BITS[code];
        BitReader.fillBitWindow(s);
        return BLOCK_LENGTH_OFFSET[code] + BitReader.readBits(s, n);
    }

    private static void moveToFront(int[] v, int index) {
        int value = v[index];
    L3:
        if (index <= 0) goto L5;
        v[index] = v[index - 1];
        index = index - 1;
        goto L3
    L5:
        v[0] = value;
    }

    private static void inverseMoveToFrontTransform(byte[] v, int vLen) {
        int[] mtf = new int[256];
        int i = 0;
    L3:
        if (i >= 256) goto L5;
        mtf[i] = i;
        i = i + 1;
        goto L3
    L5:
        int i2 = 0;
    L6:
        if (i2 >= vLen) goto L12;
        int index = v[i2] & CecDeviceType.INACTIVE;
        v[i2] = (byte) mtf[index];
        if (index == 0) goto L10;
        moveToFront(mtf, index);
    L10:
        i2 = i2 + 1;
        goto L6
    }

    private static void readHuffmanCodeLengths(int[] codeLengthCodeLengths, int numSymbols, int[] codeLengths, State s) {
        int prevCodeLen = 0;
        int prevCodeLen2 = 8;
        int repeat = 0;
        int repeatCodeLen = 0;
        int space = 32768;
        int[] table = new int[33];
        int tableIdx = table.length - 1;
        Huffman.buildHuffmanTable(table, tableIdx, 5, codeLengthCodeLengths, 18);
    L3:
        if (prevCodeLen >= numSymbols) goto L32;
        if (space <= 0) goto L32;
        BitReader.readMoreInput(s);
        BitReader.fillBitWindow(s);
        int p = BitReader.peekBits(s) & 31;
        s.bitOffset += table[p] >> 16;
        int codeLen = table[p] & 65535;
        if (codeLen >= 16) goto L11;
        repeat = 0;
        int symbol = prevCodeLen + 1;
        codeLengths[prevCodeLen] = codeLen;
        if (codeLen == 0) goto L10;
        space = space - (32768 >> codeLen);
        prevCodeLen2 = codeLen;
        prevCodeLen = symbol;
        goto L3
    L10:
        prevCodeLen = symbol;
        goto L3
    L11:
        int symbol2 = codeLen - 14;
        int newLen = 0;
        if (codeLen != 16) goto L14;
        newLen = prevCodeLen2;
    L14:
        if (repeatCodeLen == newLen) goto L16;
        repeat = 0;
        repeatCodeLen = newLen;
    L16:
        int oldRepeat = repeat;
        if (repeat <= 0) goto L19;
        repeat = (repeat - 2) << symbol2;
    L19:
        BitReader.fillBitWindow(s);
        repeat = repeat + (BitReader.readFewBits(s, symbol2) + 3);
        int repeatDelta = repeat - oldRepeat;
        int prevCodeLen3 = prevCodeLen2;
        if ((prevCodeLen + repeatDelta) > numSymbols) goto L30;
        int i = 0;
    L22:
        if (i >= repeatDelta) goto L25;
        codeLengths[prevCodeLen] = repeatCodeLen;
        i = i + 1;
        prevCodeLen = prevCodeLen + 1;
        goto L22
    L25:
        if (repeatCodeLen == 0) goto L27;
        space = space - (repeatDelta << (15 - repeatCodeLen));
        prevCodeLen2 = prevCodeLen3;
        goto L3
    L27:
        prevCodeLen2 = prevCodeLen3;
        goto L3
    L30:
        throw new BrotliRuntimeException("symbol + repeatDelta > numSymbols");
    L32:
        if (space != 0) goto L36;
        Utils.fillIntsWithZeroes(codeLengths, prevCodeLen, numSymbols);
        return;
    L36:
        throw new BrotliRuntimeException("Unused space");
    }

    private static void checkDupes(int[] symbols, int length) {
        int i = 0;
    L4:
        if (i >= (length - 1)) goto L14;
        int j = i + 1;
    L6:
        if (j >= length) goto L12;
        if (symbols[i] == symbols[j]) goto L11;
        j = j + 1;
        goto L6
    L11:
        throw new BrotliRuntimeException("Duplicate simple Huffman code symbol");
    L12:
        i = i + 1;
        goto L4
    }

    private static int readSimpleHuffmanCode(int alphabetSizeMax, int alphabetSizeLimit, int[] tableGroup, int tableIdx, State s) {
        int[] codeLengths = new int[alphabetSizeLimit];
        int[] symbols = new int[4];
        int maxBits = log2floor(alphabetSizeMax - 1) + 1;
        int numSymbols = BitReader.readFewBits(s, 2) + 1;
        int i = 0;
    L3:
        if (i >= numSymbols) goto L9;
        BitReader.fillBitWindow(s);
        int symbol = BitReader.readFewBits(s, maxBits);
        if (symbol >= alphabetSizeLimit) goto L8;
        symbols[i] = symbol;
        i = i + 1;
        goto L3
    L8:
        throw new BrotliRuntimeException("Can't readHuffmanCode");
    L9:
        checkDupes(symbols, numSymbols);
        int histogramId = numSymbols;
        if (numSymbols != 4) goto L13;
        histogramId = histogramId + BitReader.readFewBits(s, 1);
    L13:
        switch(histogramId) {
            case 1: goto L19;
            case 2: goto L18;
            case 3: goto L17;
            case 4: goto L16;
            case 5: goto L15;
            default: goto L21;
        };
    L15:
        codeLengths[symbols[0]] = 1;
        codeLengths[symbols[1]] = 2;
        codeLengths[symbols[2]] = 3;
        codeLengths[symbols[3]] = 3;
        goto L21
    L16:
        codeLengths[symbols[0]] = 2;
        codeLengths[symbols[1]] = 2;
        codeLengths[symbols[2]] = 2;
        codeLengths[symbols[3]] = 2;
        goto L21
    L17:
        codeLengths[symbols[0]] = 1;
        codeLengths[symbols[1]] = 2;
        codeLengths[symbols[2]] = 2;
        goto L21
    L18:
        codeLengths[symbols[0]] = 1;
        codeLengths[symbols[1]] = 1;
        goto L21
    L19:
        codeLengths[symbols[0]] = 1;
    L21:
        return Huffman.buildHuffmanTable(tableGroup, tableIdx, 8, codeLengths, alphabetSizeLimit);
    }

    private static int readComplexHuffmanCode(int alphabetSizeLimit, int skip, int[] tableGroup, int tableIdx, State s) {
        int[] codeLengths = new int[alphabetSizeLimit];
        int[] codeLengthCodeLengths = new int[18];
        int space = 32;
        int numCodes = 0;
        int i = skip;
    L3:
        if (i >= 18) goto L9;
        if (space <= 0) goto L9;
        int codeLenIdx = CODE_LENGTH_CODE_ORDER[i];
        BitReader.fillBitWindow(s);
        int p = BitReader.peekBits(s) & 15;
        s.bitOffset += FIXED_TABLE[p] >> 16;
        int v = FIXED_TABLE[p] & 65535;
        codeLengthCodeLengths[codeLenIdx] = v;
        if (v == 0) goto L8;
        space = space - (32 >> v);
        numCodes = numCodes + 1;
    L8:
        i = i + 1;
    L9:
        if (space != 0) goto L11;
    L15:
        readHuffmanCodeLengths(codeLengthCodeLengths, alphabetSizeLimit, codeLengths, s);
        return Huffman.buildHuffmanTable(tableGroup, tableIdx, 8, codeLengths, alphabetSizeLimit);
    L11:
        if (numCodes == 1) goto L15;
        throw new BrotliRuntimeException("Corrupted Huffman code histogram");
    }

    private static int readHuffmanCode(int alphabetSizeMax, int alphabetSizeLimit, int[] tableGroup, int tableIdx, State s) {
        BitReader.readMoreInput(s);
        BitReader.fillBitWindow(s);
        int simpleCodeOrSkip = BitReader.readFewBits(s, 2);
        if (simpleCodeOrSkip != 1) goto L7;
        return readSimpleHuffmanCode(alphabetSizeMax, alphabetSizeLimit, tableGroup, tableIdx, s);
    L7:
        return readComplexHuffmanCode(alphabetSizeLimit, simpleCodeOrSkip, tableGroup, tableIdx, s);
    }

    private static int decodeContextMap(int contextMapSize, byte[] contextMap, State s) {
        BitReader.readMoreInput(s);
        int numTrees = decodeVarLenUnsignedByte(s) + 1;
        if (numTrees != 1) goto L6;
        Utils.fillBytesWithZeroes(contextMap, 0, contextMapSize);
        return numTrees;
    L6:
        BitReader.fillBitWindow(s);
        int useRleForZeros = BitReader.readFewBits(s, 1);
        int maxRunLengthPrefix = 0;
        if (useRleForZeros == 0) goto L9;
        maxRunLengthPrefix = BitReader.readFewBits(s, 4) + 1;
    L9:
        int alphabetSize = numTrees + maxRunLengthPrefix;
        int tableSize = MAX_HUFFMAN_TABLE_SIZE[(alphabetSize + 31) >> 5];
        int[] table = new int[tableSize + 1];
        int tableIdx = table.length - 1;
        readHuffmanCode(alphabetSize, alphabetSize, table, tableIdx, s);
        int i = 0;
    L10:
        if (i >= contextMapSize) goto L24;
        BitReader.readMoreInput(s);
        BitReader.fillBitWindow(s);
        int code = readSymbol(table, tableIdx, s);
        if (code == 0) goto L13;
        if (code <= maxRunLengthPrefix) goto L15;
        contextMap[i] = (byte) (code - maxRunLengthPrefix);
        i = i + 1;
        goto L10
    L15:
        BitReader.fillBitWindow(s);
        int reps = (1 << code) + BitReader.readFewBits(s, code);
    L16:
        if (reps == 0) goto L10;
        if (i >= contextMapSize) goto L20;
        contextMap[i] = 0;
        i = i + 1;
        reps = reps - 1;
        goto L16
    L20:
        throw new BrotliRuntimeException("Corrupted context map");
    L13:
        contextMap[i] = 0;
        i = i + 1;
        goto L10
    L24:
        BitReader.fillBitWindow(s);
        if (BitReader.readFewBits(s, 1) != 1) goto L27;
        inverseMoveToFrontTransform(contextMap, contextMapSize);
    L27:
        return numTrees;
    }

    private static int decodeBlockTypeAndLength(State s, int treeType, int numBlockTypes) {
        int[] ringBuffers = s.rings;
        int offset = (treeType * 2) + 4;
        BitReader.fillBitWindow(s);
        int blockType = readSymbol(s.blockTrees, treeType * 2, s);
        int result = readBlockLength(s.blockTrees, (treeType * 2) + 1, s);
        if (blockType != 1) goto L5;
        int blockType2 = ringBuffers[offset + 1] + 1;
    L8:
        if (blockType2 < numBlockTypes) goto L10;
        blockType2 = blockType2 - numBlockTypes;
    L10:
        ringBuffers[offset] = ringBuffers[offset + 1];
        ringBuffers[offset + 1] = blockType2;
        return result;
    L5:
        if (blockType != 0) goto L7;
        blockType2 = ringBuffers[offset];
        goto L8
    L7:
        blockType2 = blockType - 2;
        goto L8
    }

    private static void decodeLiteralBlockSwitch(State s) {
        s.literalBlockLength = decodeBlockTypeAndLength(s, 0, s.numLiteralBlockTypes);
        int literalBlockType = s.rings[5];
        s.contextMapSlice = literalBlockType << 6;
        s.literalTreeIdx = s.contextMap[s.contextMapSlice] & CecDeviceType.INACTIVE;
        int contextMode = s.contextModes[literalBlockType];
        s.contextLookupOffset1 = contextMode << 9;
        s.contextLookupOffset2 = s.contextLookupOffset1 + 256;
    }

    private static void decodeCommandBlockSwitch(State s) {
        s.commandBlockLength = decodeBlockTypeAndLength(s, 1, s.numCommandBlockTypes);
        s.commandTreeIdx = s.rings[7];
    }

    private static void decodeDistanceBlockSwitch(State s) {
        s.distanceBlockLength = decodeBlockTypeAndLength(s, 2, s.numDistanceBlockTypes);
        s.distContextMapSlice = s.rings[9] << 2;
    }

    private static void maybeReallocateRingBuffer(State s) {
        int newSize = s.maxRingBufferSize;
        if (newSize <= s.expectedTotalSize) goto L15;
        int minimalNewSize = s.expectedTotalSize;
    L6:
        if ((newSize >> 1) <= minimalNewSize) goto L9;
        newSize = newSize >> 1;
        goto L6
    L9:
        if (s.inputEnd != 0) goto L15;
        if (newSize >= 16384) goto L15;
        if (s.maxRingBufferSize < 16384) goto L15;
        newSize = 16384;
    L15:
        int minimalNewSize2 = s.ringBufferSize;
        if (newSize > minimalNewSize2) goto L18;
        return;
    L18:
        int ringBufferSizeWithSlack = newSize + 37;
        byte[] newBuffer = new byte[ringBufferSizeWithSlack];
        if (s.ringBuffer.length == 0) goto L21;
        System.arraycopy(s.ringBuffer, 0, newBuffer, 0, s.ringBufferSize);
    L21:
        s.ringBuffer = newBuffer;
        s.ringBufferSize = newSize;
    }

    private static void readNextMetablockHeader(State s) {
        if (s.inputEnd == 0) goto L6;
        s.nextRunningState = 10;
        s.runningState = 12;
        return;
    L6:
        s.literalTreeGroup = new int[0];
        s.commandTreeGroup = new int[0];
        s.distanceTreeGroup = new int[0];
        BitReader.readMoreInput(s);
        decodeMetaBlockLength(s);
        if (s.metaBlockLength != 0) goto L12;
        if (s.isMetadata != 0) goto L12;
        return;
    L12:
        if (s.isUncompressed == 0) goto L14;
    L17:
        BitReader.jumpToByteBoundary(s);
        if (s.isMetadata == 0) goto L20;
        int r0 = 5;
    L21:
        s.runningState = r0;
    L23:
        if (s.isMetadata == 0) goto L25;
        return;
    L25:
        s.expectedTotalSize += s.metaBlockLength;
        if (s.expectedTotalSize <= 1073741824) goto L29;
        s.expectedTotalSize = 1073741824;
    L29:
        if (s.ringBufferSize >= s.maxRingBufferSize) goto L32;
        maybeReallocateRingBuffer(s);
        return;
    L32:
        return;
    L20:
        r0 = 6;
        goto L21
    L14:
        if (s.isMetadata != 0) goto L17;
        s.runningState = 3;
        goto L23
    }

    private static int readMetablockPartition(State s, int treeType, int numBlockTypes) {
        int offset = s.blockTrees[treeType * 2];
        if (numBlockTypes > 1) goto L6;
        s.blockTrees[(treeType * 2) + 1] = offset;
        s.blockTrees[(treeType * 2) + 2] = offset;
        return 268435456;
    L6:
        int blockTypeAlphabetSize = numBlockTypes + 2;
        int offset2 = offset + readHuffmanCode(blockTypeAlphabetSize, blockTypeAlphabetSize, s.blockTrees, treeType * 2, s);
        s.blockTrees[(treeType * 2) + 1] = offset2;
        int offset3 = offset2 + readHuffmanCode(26, 26, s.blockTrees, (treeType * 2) + 1, s);
        s.blockTrees[(treeType * 2) + 2] = offset3;
        return readBlockLength(s.blockTrees, (treeType * 2) + 1, s);
    }

    private static void calculateDistanceLut(State s, int alphabetSizeLimit) {
        byte[] distExtraBits = s.distExtraBits;
        int[] distOffset = s.distOffset;
        int npostfix = s.distancePostfixBits;
        int ndirect = s.numDirectDistanceCodes;
        int postfix = 1 << npostfix;
        int bits = 1;
        int half = 0;
        int i = 16;
        int j = 0;
    L3:
        if (j >= ndirect) goto L5;
        distExtraBits[i] = 0;
        distOffset[i] = j + 1;
        i = i + 1;
        j = j + 1;
    L5:
        if (i >= alphabetSizeLimit) goto L10;
        int base = (((((half + 2) << bits) - 4) << npostfix) + ndirect) + 1;
        int j2 = 0;
    L7:
        if (j2 >= postfix) goto L9;
        distExtraBits[i] = (byte) bits;
        distOffset[i] = base + j2;
        i = i + 1;
        j2 = j2 + 1;
        goto L7
    L9:
        bits = bits + half;
        half = half ^ 1;
        goto L5
    }

    private static void readMetablockHuffmanCodesAndContextMaps(State s) {
        s.numLiteralBlockTypes = decodeVarLenUnsignedByte(s) + 1;
        s.literalBlockLength = readMetablockPartition(s, 0, s.numLiteralBlockTypes);
        s.numCommandBlockTypes = decodeVarLenUnsignedByte(s) + 1;
        s.commandBlockLength = readMetablockPartition(s, 1, s.numCommandBlockTypes);
        s.numDistanceBlockTypes = decodeVarLenUnsignedByte(s) + 1;
        s.distanceBlockLength = readMetablockPartition(s, 2, s.numDistanceBlockTypes);
        BitReader.readMoreInput(s);
        BitReader.fillBitWindow(s);
        s.distancePostfixBits = BitReader.readFewBits(s, 2);
        s.numDirectDistanceCodes = BitReader.readFewBits(s, 4) << s.distancePostfixBits;
        s.contextModes = new byte[s.numLiteralBlockTypes];
        int i = 0;
    L4:
        if (i >= s.numLiteralBlockTypes) goto L9;
        int limit = Math.min(i + 96, s.numLiteralBlockTypes);
    L6:
        if (i >= limit) goto L8;
        BitReader.fillBitWindow(s);
        s.contextModes[i] = (byte) BitReader.readFewBits(s, 2);
        i = i + 1;
        goto L6
    L8:
        BitReader.readMoreInput(s);
        goto L4
    L9:
        int i2 = s.numLiteralBlockTypes;
        s.contextMap = new byte[i2 << 6];
        int numLiteralTrees = decodeContextMap(s.numLiteralBlockTypes << 6, s.contextMap, s);
        s.trivialLiteralContext = 1;
        int j = 0;
    L11:
        if (j >= (s.numLiteralBlockTypes << 6)) goto L16;
        if (s.contextMap[j] != (j >> 6)) goto L14;
        j = j + 1;
        goto L11
    L14:
        s.trivialLiteralContext = 0;
    L16:
        int j2 = s.numDistanceBlockTypes;
        s.distContextMap = new byte[j2 << 2];
        int numDistTrees = decodeContextMap(s.numDistanceBlockTypes << 2, s.distContextMap, s);
        s.literalTreeGroup = decodeHuffmanTreeGroup(256, 256, numLiteralTrees, s);
        s.commandTreeGroup = decodeHuffmanTreeGroup(NUM_COMMAND_CODES, NUM_COMMAND_CODES, s.numCommandBlockTypes, s);
        int distanceAlphabetSizeMax = calculateDistanceAlphabetSize(s.distancePostfixBits, s.numDirectDistanceCodes, 24);
        int distanceAlphabetSizeLimit = distanceAlphabetSizeMax;
        if (s.isLargeWindow != 1) goto L19;
        distanceAlphabetSizeMax = calculateDistanceAlphabetSize(s.distancePostfixBits, s.numDirectDistanceCodes, 62);
        distanceAlphabetSizeLimit = calculateDistanceAlphabetLimit(MAX_ALLOWED_DISTANCE, s.distancePostfixBits, s.numDirectDistanceCodes);
    L19:
        s.distanceTreeGroup = decodeHuffmanTreeGroup(distanceAlphabetSizeMax, distanceAlphabetSizeLimit, numDistTrees, s);
        calculateDistanceLut(s, distanceAlphabetSizeLimit);
        s.contextMapSlice = 0;
        s.distContextMapSlice = 0;
        s.contextLookupOffset1 = s.contextModes[0] * 512;
        s.contextLookupOffset2 = s.contextLookupOffset1 + 256;
        s.literalTreeIdx = 0;
        s.commandTreeIdx = 0;
        s.rings[4] = 1;
        s.rings[5] = 0;
        s.rings[6] = 1;
        s.rings[7] = 0;
        s.rings[8] = 1;
        s.rings[9] = 0;
    }

    private static void copyUncompressedData(State s) {
        byte[] ringBuffer = s.ringBuffer;
        if (s.metaBlockLength > 0) goto L6;
        BitReader.reload(s);
        s.runningState = 2;
        return;
    L6:
        int chunkLength = Math.min(s.ringBufferSize - s.pos, s.metaBlockLength);
        BitReader.copyBytes(s, ringBuffer, s.pos, chunkLength);
        s.metaBlockLength -= chunkLength;
        s.pos += chunkLength;
        if (s.pos != s.ringBufferSize) goto L10;
        s.nextRunningState = 6;
        s.runningState = 12;
        return;
    L10:
        BitReader.reload(s);
        s.runningState = 2;
    }

    private static int writeRingBuffer(State s) {
        int toWrite = Math.min(s.outputLength - s.outputUsed, s.ringBufferBytesReady - s.ringBufferBytesWritten);
        if (toWrite == 0) goto L6;
        System.arraycopy(s.ringBuffer, s.ringBufferBytesWritten, s.output, s.outputOffset + s.outputUsed, toWrite);
        s.outputUsed += toWrite;
        s.ringBufferBytesWritten += toWrite;
    L6:
        if (s.outputUsed >= s.outputLength) goto L9;
        return 1;
    L9:
        return 0;
    }

    private static int[] decodeHuffmanTreeGroup(int alphabetSizeMax, int alphabetSizeLimit, int n, State s) {
        int maxTableSize = MAX_HUFFMAN_TABLE_SIZE[(alphabetSizeLimit + 31) >> 5];
        int[] group = new int[(n * maxTableSize) + n];
        int next = n;
        int i = 0;
    L3:
        if (i >= n) goto L6;
        group[i] = next;
        next = next + readHuffmanCode(alphabetSizeMax, alphabetSizeLimit, group, i, s);
        i = i + 1;
        goto L3
    L6:
        return group;
    }

    private static int calculateFence(State s) {
        int result = s.ringBufferSize;
        if (s.isEager != 0) goto L5;
        return result;
    L5:
        return Math.min(result, (s.ringBufferBytesWritten + s.outputLength) - s.outputUsed);
    }

    private static void doUseDictionary(State s, int fence) {
        if (s.distance > MAX_ALLOWED_DISTANCE) goto L26;
        int address = ((s.distance - s.maxDistance) - 1) - s.cdTotalSize;
        if (address >= 0) goto L7;
        initializeCompoundDictionaryCopy(s, (-address) - 1, s.copyLength);
        s.runningState = 14;
        return;
    L7:
        ByteBuffer dictionaryData = Dictionary.getData();
        int wordLength = s.copyLength;
        if (wordLength > 31) goto L24;
        int shift = Dictionary.sizeBits[wordLength];
        if (shift == 0) goto L22;
        int offset = Dictionary.offsets[wordLength];
        int mask = (1 << shift) - 1;
        int wordIdx = address & mask;
        int transformIdx = address >>> shift;
        int offset2 = (wordIdx * wordLength) + offset;
        Transform.Transforms transforms = Transform.RFC_TRANSFORMS;
        if (transformIdx >= transforms.numTransforms) goto L20;
        int len = Transform.transformDictionaryWord(s.ringBuffer, s.pos, dictionaryData, offset2, wordLength, transforms, transformIdx);
        s.pos += len;
        s.metaBlockLength -= len;
        if (s.pos < fence) goto L17;
        s.nextRunningState = 4;
        s.runningState = 12;
        return;
    L17:
        s.runningState = 4;
        return;
    L20:
        throw new BrotliRuntimeException("Invalid backward reference");
    L22:
        throw new BrotliRuntimeException("Invalid backward reference");
    L24:
        throw new BrotliRuntimeException("Invalid backward reference");
    L26:
        throw new BrotliRuntimeException("Invalid backward reference");
    }

    private static void initializeCompoundDictionary(State s) {
        s.cdBlockMap = new byte[256];
        int blockBits = 8;
    L4:
        if (((s.cdTotalSize - 1) >>> blockBits) == 0) goto L6;
        blockBits = blockBits + 1;
        goto L4
    L6:
        int blockBits2 = blockBits - 8;
        s.cdBlockBits = blockBits2;
        int cursor = 0;
        int index = 0;
    L8:
        if (cursor >= s.cdTotalSize) goto L13;
    L10:
        if (s.cdChunkOffsets[index + 1] >= cursor) goto L12;
        index = index + 1;
        goto L10
    L12:
        s.cdBlockMap[cursor >>> blockBits2] = (byte) index;
        cursor = cursor + (1 << blockBits2);
        goto L8
    }

    private static void initializeCompoundDictionaryCopy(State s, int address, int length) {
        if (s.cdBlockBits != (-1)) goto L5;
        initializeCompoundDictionary(s);
    L5:
        int r0 = s.cdBlockMap[address >>> s.cdBlockBits];
    L7:
        if (address < s.cdChunkOffsets[r0 + 1]) goto L10;
        r0 = r0 + 1;
        goto L7
    L10:
        if (s.cdTotalSize > (address + length)) goto L14;
        s.distRbIdx = (s.distRbIdx + 1) & 3;
        s.rings[s.distRbIdx] = s.distance;
        s.metaBlockLength -= length;
        s.cdBrIndex = r0;
        s.cdBrOffset = address - s.cdChunkOffsets[r0];
        s.cdBrLength = length;
        s.cdBrCopied = 0;
        return;
    L14:
        throw new BrotliRuntimeException("Invalid backward reference");
    }

    private static int copyFromCompoundDictionary(State s, int fence) {
        int pos = s.pos;
    L4:
        if (s.cdBrLength == s.cdBrCopied) goto L17;
        int space = fence - pos;
        int chunkLength = s.cdChunkOffsets[s.cdBrIndex + 1] - s.cdChunkOffsets[s.cdBrIndex];
        int remChunkLength = chunkLength - s.cdBrOffset;
        int length = s.cdBrLength - s.cdBrCopied;
        if (length <= remChunkLength) goto L8;
        length = remChunkLength;
    L8:
        if (length <= space) goto L10;
        length = space;
    L10:
        Utils.copyBytes(s.ringBuffer, pos, s.cdChunks[s.cdBrIndex], s.cdBrOffset, s.cdBrOffset + length);
        pos = pos + length;
        s.cdBrOffset += length;
        s.cdBrCopied += length;
        if (length != remChunkLength) goto L13;
        s.cdBrIndex++;
        s.cdBrOffset = 0;
    L13:
        if (pos < fence) goto L4;
    L17:
        return pos - pos;
    }

    static void decompress(State s) {
        if (s.runningState == 0) goto L153;
        if (s.runningState == 11) goto L151;
        int distanceCode = 2;
        int dst = 1;
        if (s.runningState != 1) goto L13;
        int windowBits = decodeWindowBits(s);
        if (windowBits == (-1)) goto L12;
        s.maxRingBufferSize = 1 << windowBits;
        s.maxBackwardDistance = s.maxRingBufferSize - 16;
        s.runningState = 2;
        goto L13
    L12:
        throw new BrotliRuntimeException("Invalid 'windowBits' code");
    L13:
        int fence = calculateFence(s);
        int ringBufferMask = s.ringBufferSize - 1;
        byte[] ringBuffer = s.ringBuffer;
    L15:
        if (s.runningState == 10) goto L142;
        switch(s.runningState) {
            case 2: goto L137;
            case 3: goto L47;
            case 4: goto L49;
            case 5: goto L44;
            case 6: goto L42;
            case 7: goto L56;
            case 8: goto L40;
            case 9: goto L39;
            case 10: goto L19;
            case 11: goto L19;
            case 12: goto L25;
            case 13: goto L27;
            case 14: goto L20;
            default: goto L19;
        };
    L19:
        throw new BrotliRuntimeException("Unexpected state " + s.runningState);
    L137:
        int r18 = distanceCode;
        int r17 = dst;
        if (s.metaBlockLength < 0) goto L141;
        readNextMetablockHeader(s);
        fence = calculateFence(s);
        ringBufferMask = s.ringBufferSize - 1;
        ringBuffer = s.ringBuffer;
        dst = r17;
        distanceCode = r18;
        goto L15
    L141:
        throw new BrotliRuntimeException("Invalid metablock length");
    L20:
        s.pos += copyFromCompoundDictionary(s, fence);
        if (s.pos >= fence) goto L22;
        s.runningState = 4;
        distanceCode = distanceCode;
        dst = dst;
    L134:
        dst = dst;
        distanceCode = distanceCode;
        goto L15
    L22:
        s.nextRunningState = 14;
        s.runningState = 12;
        return;
    L25:
        s.ringBufferBytesReady = Math.min(s.pos, s.ringBufferSize);
        s.runningState = 13;
    L27:
        if (writeRingBuffer(s) == 0) goto L28;
        if (s.pos < s.maxBackwardDistance) goto L33;
        s.maxDistance = s.maxBackwardDistance;
    L33:
        if (s.pos >= s.ringBufferSize) goto L35;
    L38:
        s.runningState = s.nextRunningState;
        distanceCode = distanceCode;
        dst = dst;
        goto L134
    L35:
        if (s.pos <= s.ringBufferSize) goto L37;
        Utils.copyBytesWithin(ringBuffer, 0, s.ringBufferSize, s.pos);
    L37:
        s.pos &= ringBufferMask;
        s.ringBufferBytesWritten = 0;
        goto L38
    L28:
        return;
    L39:
        doUseDictionary(s, fence);
        distanceCode = distanceCode;
        dst = dst;
        goto L134
    L40:
        distanceCode = distanceCode;
        dst = dst;
    L113:
        int distanceCode2 = s.pos;
        int src = (distanceCode2 - s.distance) & ringBufferMask;
        int dst2 = s.pos;
        int copyLength = s.copyLength - s.j;
        int srcEnd = src + copyLength;
        int dstEnd = dst2 + copyLength;
        if (srcEnd >= ringBufferMask) goto L127;
        if (dstEnd >= ringBufferMask) goto L127;
        if (copyLength < 12) goto L121;
        if (srcEnd <= dst2) goto L120;
        if (dstEnd > src) goto L121;
    L120:
        Utils.copyBytesWithin(ringBuffer, dst2, src, srcEnd);
    L125:
        int k = s.j;
        s.j = k + copyLength;
        s.metaBlockLength -= copyLength;
        s.pos += copyLength;
    L132:
        if (s.runningState != 8) goto L134;
        s.runningState = 4;
    L121:
        int k2 = 0;
    L122:
        if (k2 >= copyLength) goto L125;
        int dst3 = dst2 + 1;
        int src2 = src + 1;
        ringBuffer[dst2] = ringBuffer[src];
        int dst4 = dst3 + 1;
        int src3 = src2 + 1;
        ringBuffer[dst3] = ringBuffer[src2];
        int dst5 = dst4 + 1;
        int src4 = src3 + 1;
        ringBuffer[dst4] = ringBuffer[src3];
        dst2 = dst5 + 1;
        src = src4 + 1;
        ringBuffer[dst5] = ringBuffer[src4];
        k2 = k2 + 4;
    L127:
        if (s.j >= s.copyLength) goto L132;
        ringBuffer[s.pos] = ringBuffer[(s.pos - s.distance) & ringBufferMask];
        s.metaBlockLength--;
        s.pos++;
        s.j++;
        if (s.pos < fence) goto L127;
        s.nextRunningState = 8;
        s.runningState = 12;
    L56:
        if (s.trivialLiteralContext != 0) goto L58;
        int prevByte1 = ringBuffer[(s.pos - 1) & ringBufferMask] & CecDeviceType.INACTIVE;
        int prevByte2 = ringBuffer[(s.pos - 2) & ringBufferMask] & CecDeviceType.INACTIVE;
    L67:
        if (s.j >= s.insertLength) goto L75;
        BitReader.readMoreInput(s);
        if (s.literalBlockLength != 0) goto L71;
        decodeLiteralBlockSwitch(s);
    L71:
        int literalContext = Context.LOOKUP[s.contextLookupOffset1 + prevByte1] | Context.LOOKUP[s.contextLookupOffset2 + prevByte2];
        int literalTreeIdx = s.contextMap[s.contextMapSlice + literalContext] & CecDeviceType.INACTIVE;
        s.literalBlockLength--;
        prevByte2 = prevByte1;
        BitReader.fillBitWindow(s);
        prevByte1 = readSymbol(s.literalTreeGroup, literalTreeIdx, s);
        ringBuffer[s.pos] = (byte) prevByte1;
        s.pos++;
        s.j++;
        if (s.pos < fence) goto L67;
        s.nextRunningState = 7;
        s.runningState = 12;
    L75:
        int prevByte3 = s.runningState;
        if (prevByte3 != 7) goto L134;
        s.metaBlockLength -= s.insertLength;
        if (s.metaBlockLength > 0) goto L81;
        s.runningState = 4;
        goto L134
    L81:
        int distanceCode3 = s.distanceCode;
        if (distanceCode3 >= 0) goto L84;
        s.distance = s.rings[s.distRbIdx];
    L99:
        int distTreeIdx = s.maxDistance;
        if (distTreeIdx != s.maxBackwardDistance) goto L102;
    L104:
        s.maxDistance = s.maxBackwardDistance;
    L106:
        if (s.distance <= s.maxDistance) goto L108;
        s.runningState = 9;
        goto L134
    L108:
        if (distanceCode3 <= 0) goto L111;
        s.distRbIdx = (s.distRbIdx + 1) & 3;
        s.rings[s.distRbIdx] = s.distance;
    L111:
        if (s.copyLength > s.metaBlockLength) goto L136;
        s.j = 0;
        s.runningState = 8;
        goto L113
    L136:
        throw new BrotliRuntimeException("Invalid backward reference");
    L102:
        if (s.pos >= s.maxBackwardDistance) goto L104;
        s.maxDistance = s.pos;
        goto L106
    L84:
        BitReader.readMoreInput(s);
        if (s.distanceBlockLength != 0) goto L87;
        decodeDistanceBlockSwitch(s);
    L87:
        s.distanceBlockLength--;
        BitReader.fillBitWindow(s);
        int distTreeIdx2 = s.distContextMap[s.distContextMapSlice + distanceCode3] & CecDeviceType.INACTIVE;
        distanceCode3 = readSymbol(s.distanceTreeGroup, distTreeIdx2, s);
        if (distanceCode3 >= 16) goto L94;
        int index = (s.distRbIdx + DISTANCE_SHORT_CODE_INDEX_OFFSET[distanceCode3]) & 3;
        s.distance = s.rings[index] + DISTANCE_SHORT_CODE_VALUE_OFFSET[distanceCode3];
        if (s.distance >= 0) goto L99;
        throw new BrotliRuntimeException("Negative distance");
    L94:
        int extraBits = s.distExtraBits[distanceCode3];
        if ((s.bitOffset + extraBits) > BitReader.BITNESS) goto L97;
        int bits = BitReader.readFewBits(s, extraBits);
    L98:
        s.distance = s.distOffset[distanceCode3] + (bits << s.distancePostfixBits);
        goto L99
    L97:
        BitReader.fillBitWindow(s);
        bits = BitReader.readBits(s, extraBits);
    L58:
        if (s.j >= s.insertLength) goto L75;
        BitReader.readMoreInput(s);
        if (s.literalBlockLength != 0) goto L62;
        decodeLiteralBlockSwitch(s);
    L62:
        s.literalBlockLength--;
        BitReader.fillBitWindow(s);
        ringBuffer[s.pos] = (byte) readSymbol(s.literalTreeGroup, s.literalTreeIdx, s);
        s.pos++;
        s.j++;
        if (s.pos < fence) goto L58;
        s.nextRunningState = 7;
        s.runningState = 12;
        goto L75
    L42:
        copyUncompressedData(s);
        distanceCode = distanceCode;
        dst = dst;
    L44:
        if (s.metaBlockLength <= 0) goto L46;
        BitReader.readMoreInput(s);
        BitReader.fillBitWindow(s);
        BitReader.readFewBits(s, 8);
        s.metaBlockLength -= dst;
        goto L44
    L46:
        s.runningState = distanceCode;
        distanceCode = distanceCode;
        dst = dst;
        goto L134
    L47:
        readMetablockHuffmanCodesAndContextMaps(s);
        s.runningState = 4;
    L49:
        if (s.metaBlockLength > 0) goto L51;
        s.runningState = distanceCode;
        distanceCode = distanceCode;
        dst = dst;
        goto L134
    L51:
        BitReader.readMoreInput(s);
        if (s.commandBlockLength != 0) goto L54;
        decodeCommandBlockSwitch(s);
    L54:
        s.commandBlockLength -= dst;
        BitReader.fillBitWindow(s);
        int cmdCode = readSymbol(s.commandTreeGroup, s.commandTreeIdx, s) << distanceCode;
        short insertAndCopyExtraBits = CMD_LOOKUP[cmdCode];
        short r14 = CMD_LOOKUP[cmdCode + 1];
        short r15 = CMD_LOOKUP[cmdCode + 2];
        s.distanceCode = CMD_LOOKUP[cmdCode + 3];
        BitReader.fillBitWindow(s);
        int extraBits2 = insertAndCopyExtraBits & 255;
        s.insertLength = r14 + BitReader.readBits(s, extraBits2);
        BitReader.fillBitWindow(s);
        int extraBits3 = insertAndCopyExtraBits >> 8;
        s.copyLength = BitReader.readBits(s, extraBits3) + r15;
        s.j = 0;
        s.runningState = 7;
        goto L56
    L142:
        int r19 = dst;
        if (s.runningState == 10) goto L145;
        return;
    L145:
        if (s.metaBlockLength < 0) goto L148;
        BitReader.jumpToByteBoundary(s);
        BitReader.checkHealth(s, r19);
        return;
    L148:
        throw new BrotliRuntimeException("Invalid metablock length");
    L151:
        throw new IllegalStateException("Can't decompress after close");
    L153:
        throw new IllegalStateException("Can't decompress until initialized");
    }
}
