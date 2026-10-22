package org.apache.commons.compress.compressors.bzip2;

import android.hardware.tv.hdmi.cec.CecDeviceType;
import com.android.server.devicepolicy.IZswDevicePolicyData;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Array;
import java.nio.ByteOrder;
import java.util.Arrays;
import org.apache.commons.compress.compressors.CompressorInputStream;
import org.apache.commons.compress.utils.BitInputStream;
import org.apache.commons.compress.utils.CloseShieldFilterInputStream;
import org.apache.commons.compress.utils.InputStreamStatistics;

/* JADX INFO: loaded from: classes3.dex */
public class BZip2CompressorInputStream extends CompressorInputStream implements BZip2Constants, InputStreamStatistics {
    private static final int EOF = 0;
    private static final int NO_RAND_PART_A_STATE = 5;
    private static final int NO_RAND_PART_B_STATE = 6;
    private static final int NO_RAND_PART_C_STATE = 7;
    private static final int RAND_PART_A_STATE = 2;
    private static final int RAND_PART_B_STATE = 3;
    private static final int RAND_PART_C_STATE = 4;
    private static final int START_BLOCK_STATE = 1;
    private BitInputStream bin;
    private boolean blockRandomised;
    private int blockSize100k;
    private int computedBlockCRC;
    private int computedCombinedCRC;
    private final CRC crc;
    private int currentState;
    private Data data;
    private final boolean decompressConcatenated;
    private int last;
    private int nInUse;
    private int origPtr;
    private int storedBlockCRC;
    private int storedCombinedCRC;
    private int su_ch2;
    private int su_chPrev;
    private int su_count;
    private int su_i2;
    private int su_j2;
    private int su_rNToGo;
    private int su_rTPos;
    private int su_tPos;
    private char su_z;

    private static final class Data {
        final int[][] base;
        final int[] cftab;
        final char[] getAndMoveToFrontDecode_yy;
        final boolean[] inUse;
        final int[][] limit;
        byte[] ll8;
        final int[] minLens;
        final int[][] perm;
        final byte[] recvDecodingTables_pos;
        final byte[] selector;
        final byte[] selectorMtf;
        final byte[] seqToUnseq;
        final char[][] temp_charArray2d;
        int[] tt;
        final int[] unzftab;

        Data(int blockSize100k) {
            this.inUse = new boolean[256];
            this.seqToUnseq = new byte[256];
            this.selector = new byte[BZip2Constants.MAX_SELECTORS];
            this.selectorMtf = new byte[BZip2Constants.MAX_SELECTORS];
            this.unzftab = new int[256];
            this.limit = (int[][]) Array.newInstance(Integer.TYPE, new int[]{6, 258});
            this.base = (int[][]) Array.newInstance(Integer.TYPE, new int[]{6, 258});
            this.perm = (int[][]) Array.newInstance(Integer.TYPE, new int[]{6, 258});
            this.minLens = new int[6];
            this.cftab = new int[257];
            this.getAndMoveToFrontDecode_yy = new char[256];
            this.temp_charArray2d = (char[][]) Array.newInstance(Character.TYPE, new int[]{6, 258});
            this.recvDecodingTables_pos = new byte[6];
            this.ll8 = new byte[BZip2Constants.BASEBLOCKSIZE * blockSize100k];
        }

        int[] initTT(int length) {
            int[] ttShadow = this.tt;
            if (ttShadow != null) goto L5;
        L6:
            int[] ttShadow2 = new int[length];
            this.tt = ttShadow2;
            return ttShadow2;
        L5:
            if (ttShadow.length < length) goto L6;
            return ttShadow;
        }
    }

    public BZip2CompressorInputStream(InputStream in) throws IOException {
        this(in, false);
    }

    public BZip2CompressorInputStream(InputStream in, boolean decompressConcatenated) throws IOException {
        this.crc = new CRC();
        this.currentState = 1;
        if (in != System.in) goto L5;
        InputStream r2 = new CloseShieldFilterInputStream(in);
    L6:
        this.bin = new BitInputStream(r2, ByteOrder.BIG_ENDIAN);
        this.decompressConcatenated = decompressConcatenated;
        init(true);
        initBlock();
        return;
    L5:
        r2 = in;
        goto L6
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        if (this.bin == null) goto L11;
        int r = read0();
        if (r >= 0) goto L7;
        int r1 = -1;
    L8:
        count(r1);
        return r;
    L7:
        r1 = 1;
        goto L8
    L11:
        throw new IOException("stream closed");
    }

    @Override // java.io.InputStream
    public int read(byte[] dest, int offs, int len) throws IOException {
        if (offs < 0) goto L29;
        if (len < 0) goto L27;
        if ((offs + len) > dest.length) goto L25;
        if (this.bin == null) goto L23;
        if (len != 0) goto L12;
        return 0;
    L12:
        int hi = offs + len;
        int destOffs = offs;
    L14:
        if (destOffs >= hi) goto L18;
        int b = read0();
        if (b < 0) goto L18;
        dest[destOffs] = (byte) b;
        count(1);
        destOffs = destOffs + 1;
    L18:
        if (destOffs != offs) goto L21;
        return -1;
    L21:
        return destOffs - offs;
    L23:
        throw new IOException("stream closed");
    L25:
        throw new IndexOutOfBoundsException("offs(" + offs + ") + len(" + len + ") > dest.length(" + dest.length + ").");
    L27:
        throw new IndexOutOfBoundsException("len(" + len + ") < 0.");
    L29:
        throw new IndexOutOfBoundsException("offs(" + offs + ") < 0.");
    }

    @Override // org.apache.commons.compress.utils.InputStreamStatistics
    public long getCompressedCount() {
        return this.bin.getBytesRead();
    }

    private void makeMaps() {
        boolean[] inUse = this.data.inUse;
        byte[] seqToUnseq = this.data.seqToUnseq;
        int nInUseShadow = 0;
        int i = 0;
    L4:
        if (i >= 256) goto L9;
        if (inUse[i] == false) goto L8;
        seqToUnseq[nInUseShadow] = (byte) i;
        nInUseShadow = nInUseShadow + 1;
    L8:
        i = i + 1;
        goto L4
    L9:
        this.nInUse = nInUseShadow;
    }

    private int read0() throws IOException {
        switch(this.currentState) {
            case 0: goto L20;
            case 1: goto L19;
            case 2: goto L17;
            case 3: goto L15;
            case 4: goto L13;
            case 5: goto L11;
            case 6: goto L9;
            case 7: goto L7;
            default: goto L5;
        };
    L20:
        return -1;
    L5:
        throw new IllegalStateException();
    L7:
        return setupNoRandPartC();
    L9:
        return setupNoRandPartB();
    L11:
        throw new IllegalStateException();
    L13:
        return setupRandPartC();
    L15:
        return setupRandPartB();
    L17:
        throw new IllegalStateException();
    L19:
        return setupBlock();
    }

    private int readNextByte(BitInputStream in) throws IOException {
        long b = in.readBits(8);
        return (int) b;
    }

    private boolean init(boolean isFirstStream) throws IOException {
        if (this.bin == null) goto L32;
        if (isFirstStream == true) goto L6;
        this.bin.clearBitCache();
    L6:
        int magic0 = readNextByte(this.bin);
        if (magic0 != (-1)) goto L10;
        if (isFirstStream == true) goto L10;
        return false;
    L10:
        int magic1 = readNextByte(this.bin);
        int magic2 = readNextByte(this.bin);
        if (magic0 != 66) goto L26;
        if (magic1 != 90) goto L26;
        if (magic2 != 104) goto L26;
        int blockSize = readNextByte(this.bin);
        if (blockSize < 49) goto L24;
        if (blockSize > 57) goto L24;
        this.blockSize100k = blockSize - 48;
        this.computedCombinedCRC = 0;
        return true;
    L24:
        throw new IOException("BZip2 block size is invalid");
    L26:
        if (isFirstStream == false) goto L28;
        String r4 = "Stream is not in the BZip2 format";
    L30:
        throw new IOException(r4);
    L28:
        r4 = "Garbage after a valid BZip2 stream";
        goto L30
    L32:
        throw new IOException("No InputStream");
    }

    private void initBlock() throws IOException {
        BitInputStream bin = this.bin;
    L3:
        char magic0 = bsGetUByte(bin);
        char magic1 = bsGetUByte(bin);
        char magic2 = bsGetUByte(bin);
        char magic3 = bsGetUByte(bin);
        char magic4 = bsGetUByte(bin);
        char magic5 = bsGetUByte(bin);
        if (magic0 != 23) goto L19;
        if (magic1 != 'r') goto L19;
        if (magic2 != 'E') goto L19;
        if (magic3 != '8') goto L19;
        if (magic4 != 'P') goto L19;
        if (magic5 != 144) goto L19;
        if (complete() == false) goto L3;
        return;
    L19:
        boolean r8 = false;
        if (magic0 == '1') goto L22;
    L38:
        this.currentState = 0;
        throw new IOException("bad block header");
    L22:
        if (magic1 != 'A') goto L38;
        if (magic2 != 'Y') goto L38;
        if (magic3 != '&') goto L38;
        if (magic4 != 'S') goto L38;
        if (magic5 != 'Y') goto L38;
        this.storedBlockCRC = bsGetInt(bin);
        if (bsR(bin, 1) != 1) goto L33;
        r8 = true;
    L33:
        this.blockRandomised = r8;
        if (this.data != null) goto L36;
        this.data = new Data(this.blockSize100k);
    L36:
        getAndMoveToFrontDecode();
        this.crc.initialiseCRC();
        this.currentState = 1;
    }

    private void endBlock() throws IOException {
        this.computedBlockCRC = this.crc.getFinalCRC();
        if (this.storedBlockCRC != this.computedBlockCRC) goto L6;
        this.computedCombinedCRC = (this.computedCombinedCRC << 1) | (this.computedCombinedCRC >>> 31);
        this.computedCombinedCRC ^= this.computedBlockCRC;
        return;
    L6:
        this.computedCombinedCRC = (this.storedCombinedCRC << 1) | (this.storedCombinedCRC >>> 31);
        this.computedCombinedCRC ^= this.storedBlockCRC;
        throw new IOException("BZip2 CRC error");
    }

    private boolean complete() throws IOException {
        this.storedCombinedCRC = bsGetInt(this.bin);
        this.currentState = 0;
        this.data = null;
        if (this.storedCombinedCRC != this.computedCombinedCRC) goto L11;
        if (this.decompressConcatenated == true) goto L7;
    L8:
        return true;
    L7:
        if (init(false) == false) goto L8;
        return false;
    L11:
        throw new IOException("BZip2 CRC error");
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        BitInputStream inShadow = this.bin;
        if (inShadow != null) goto L11;
        return;
    L11:
        inShadow.close();     // Catch: Throwable -> L7
        this.data = null;
        this.bin = null;
        return;
    L7:
        th = move-exception;
        this.data = null;
        this.bin = null;
        throw th;
    }

    private static int bsR(BitInputStream bin, int n) throws IOException {
        long thech = bin.readBits(n);
        if (thech < 0) goto L7;
        return (int) thech;
    L7:
        throw new IOException("unexpected end of stream");
    }

    private static boolean bsGetBit(BitInputStream bin) throws IOException {
        if (bsR(bin, 1) != 0) goto L7;
        return false;
    L7:
        return true;
    }

    private static char bsGetUByte(BitInputStream bin) throws IOException {
        return (char) bsR(bin, 8);
    }

    private static int bsGetInt(BitInputStream bin) throws IOException {
        return bsR(bin, 32);
    }

    private static void checkBounds(int checkVal, int limitExclusive, String name) throws IOException {
        if (checkVal < 0) goto L9;
        if (checkVal >= limitExclusive) goto L7;
        return;
    L7:
        throw new IOException("Corrupted input, " + name + " value too big");
    L9:
        throw new IOException("Corrupted input, " + name + " value negative");
    }

    private static void hbCreateDecodeTables(int[] limit, int[] base, int[] perm, char[] length, int minLen, int maxLen, int alphaSize) throws IOException {
        int i = minLen;
        int pp = 0;
    L3:
        if (i > maxLen) goto L11;
        int j = 0;
    L5:
        if (j >= alphaSize) goto L10;
        if (length[j] != i) goto L9;
        perm[pp] = j;
        pp = pp + 1;
    L9:
        j = j + 1;
        goto L5
    L10:
        i = i + 1;
        goto L3
    L11:
        int i2 = 23;
    L12:
        i2 = i2 - 1;
        if (i2 <= 0) goto L15;
        base[i2] = 0;
        limit[i2] = 0;
        goto L12
    L15:
        int i3 = 0;
    L16:
        if (i3 >= alphaSize) goto L18;
        char r2 = length[i3];
        checkBounds(r2, 258, IZswDevicePolicyData.ATTR_LENGTH);
        int r3 = r2 + 1;
        base[r3] = base[r3] + 1;
        i3 = i3 + 1;
        goto L16
    L18:
        int i4 = 1;
        int b = base[0];
    L20:
        if (i4 >= 23) goto L22;
        b = b + base[i4];
        base[i4] = b;
        i4 = i4 + 1;
        goto L20
    L22:
        int i5 = minLen;
        int vec = 0;
        int b2 = base[i5];
    L23:
        if (i5 > maxLen) goto L25;
        int nb = base[i5 + 1];
        int vec2 = vec + (nb - b2);
        b2 = nb;
        limit[i5] = vec2 - 1;
        vec = vec2 << 1;
        i5 = i5 + 1;
        goto L23
    L25:
        int i6 = minLen + 1;
    L26:
        if (i6 > maxLen) goto L29;
        base[i6] = ((limit[i6 - 1] + 1) << 1) - base[i6];
        i6 = i6 + 1;
        goto L26
    }

    private void recvDecodingTables() throws IOException {
        BitInputStream bin = this.bin;
        Data dataShadow = this.data;
        boolean[] inUse = dataShadow.inUse;
        byte[] pos = dataShadow.recvDecodingTables_pos;
        byte[] selector = dataShadow.selector;
        byte[] selectorMtf = dataShadow.selectorMtf;
        int inUse16 = 0;
        int i = 0;
    L4:
        if (i >= 16) goto L9;
        if (bsGetBit(bin) == false) goto L8;
        inUse16 = inUse16 | (1 << i);
    L8:
        i = i + 1;
        goto L4
    L9:
        int i2 = 0;
        Arrays.fill(inUse, false);
        int i3 = 0;
    L10:
        if (i3 >= 16) goto L20;
        if (((1 << i3) & inUse16) == 0) goto L19;
        int i16 = i3 << 4;
        int j = 0;
    L14:
        if (j >= 16) goto L19;
        if (bsGetBit(bin) == false) goto L18;
        inUse[i16 + j] = true;
    L18:
        j = j + 1;
    L19:
        i3 = i3 + 1;
        goto L10
    L20:
        makeMaps();
        int alphaSize = this.nInUse + 2;
        int nGroups = bsR(bin, 3);
        int nSelectors = bsR(bin, 15);
        checkBounds(alphaSize, 259, "alphaSize");
        checkBounds(nGroups, 7, "nGroups");
        checkBounds(nSelectors, 18003, "nSelectors");
        int i4 = 0;
    L21:
        if (i4 >= nSelectors) goto L27;
        int j2 = 0;
    L24:
        if (bsGetBit(bin) == false) goto L26;
        j2 = j2 + 1;
        goto L24
    L26:
        selectorMtf[i4] = (byte) j2;
        i4 = i4 + 1;
        goto L21
    L27:
        int v = nGroups;
    L28:
        v = v - 1;
        if (v < 0) goto L31;
        pos[v] = (byte) v;
        goto L28
    L31:
        int i5 = 0;
    L32:
        if (i5 >= nSelectors) goto L37;
        int v2 = selectorMtf[i5] & CecDeviceType.INACTIVE;
        int r16 = i2;
        checkBounds(v2, 6, "selectorMtf");
        byte tmp = pos[v2];
    L34:
        if (v2 <= 0) goto L36;
        pos[v2] = pos[v2 - 1];
        v2 = v2 - 1;
        goto L34
    L36:
        pos[r16] = tmp;
        selector[i5] = tmp;
        i5 = i5 + 1;
        i2 = r16;
        goto L32
    L37:
        char[][] len = dataShadow.temp_charArray2d;
        int t = 0;
    L38:
        if (t >= nGroups) goto L50;
        int curr = bsR(bin, 5);
        char[] len_t = len[t];
        int i6 = 0;
    L40:
        if (i6 >= alphaSize) goto L49;
    L42:
        if (bsGetBit(bin) == false) goto L48;
        if (bsGetBit(bin) == false) goto L46;
        int r17 = -1;
    L47:
        curr = curr + r17;
        goto L42
    L46:
        r17 = 1;
        goto L47
    L48:
        len_t[i6] = (char) curr;
        i6 = i6 + 1;
        bin = bin;
        goto L40
    L49:
        t = t + 1;
        goto L38
    L50:
        createHuffmanDecodingTables(alphaSize, nGroups);
    }

    private void createHuffmanDecodingTables(int alphaSize, int nGroups) throws IOException {
        Data dataShadow = this.data;
        char[][] len = dataShadow.temp_charArray2d;
        int[] minLens = dataShadow.minLens;
        int[][] limit = dataShadow.limit;
        int[][] base = dataShadow.base;
        int[][] perm = dataShadow.perm;
        int t = 0;
    L4:
        if (t >= nGroups) goto L16;
        int minLen = 32;
        int maxLen = 0;
        char[] len_t = len[t];
        int i = alphaSize;
    L6:
        i = i - 1;
        if (i < 0) goto L14;
        char lent = len_t[i];
        if (lent <= maxLen) goto L11;
        maxLen = lent;
    L11:
        if (lent >= minLen) goto L6;
        minLen = lent;
        goto L6
    L14:
        int minLen2 = minLen;
        hbCreateDecodeTables(limit[t], base[t], perm[t], len[t], minLen2, maxLen, alphaSize);
        minLens[t] = minLen2;
        t = t + 1;
        goto L4
    }

    private void getAndMoveToFrontDecode() throws IOException {
        BitInputStream bin = this.bin;
        this.origPtr = bsR(bin, 24);
        recvDecodingTables();
        Data dataShadow = this.data;
        byte[] ll8 = dataShadow.ll8;
        int[] unzftab = dataShadow.unzftab;
        byte[] selector = dataShadow.selector;
        byte[] seqToUnseq = dataShadow.seqToUnseq;
        char[] yy = dataShadow.getAndMoveToFrontDecode_yy;
        int[] minLens = dataShadow.minLens;
        int[][] limit = dataShadow.limit;
        int[][] base = dataShadow.base;
        int[][] perm = dataShadow.perm;
        int limitLast = this.blockSize100k * BZip2Constants.BASEBLOCKSIZE;
        int i = 256;
    L3:
        i = i - 1;
        if (i < 0) goto L6;
        yy[i] = (char) i;
        unzftab[i] = 0;
        goto L3
    L6:
        int groupNo = 0;
        int groupPos = 49;
        int eob = this.nInUse + 1;
        int nextSym = getAndMoveToFrontDecode0();
        int zt = selector[0] & CecDeviceType.INACTIVE;
        String r5 = "zt";
        checkBounds(zt, 6, "zt");
        int[] base_zt = base[zt];
        int[] limit_zt = limit[zt];
        int[] perm_zt = perm[zt];
        int minLens_zt = minLens[zt];
        int lastShadow = zt;
        int lastShadow2 = -1;
        int zn = nextSym;
    L7:
        if (zn == eob) goto L53;
        seqToUnseq = seqToUnseq;
        minLens = minLens;
        limit = limit;
        base = base;
        perm = perm;
        int groupNo2 = groupNo;
        if (zn == 0) goto L34;
        if (zn == 1) goto L34;
        lastShadow2 = lastShadow2 + 1;
        if (lastShadow2 >= limitLast) goto L32;
        checkBounds(zn, 257, "nextSym");
        char tmp = yy[zn - 1];
        checkBounds(tmp, 256, "yy");
        int r9 = seqToUnseq[tmp] & CecDeviceType.INACTIVE;
        unzftab[r9] = unzftab[r9] + 1;
        ll8[lastShadow2] = seqToUnseq[tmp];
        if (zn > 16) goto L21;
        int j = zn - 1;
    L18:
        if (j <= 0) goto L20;
        int j2 = j - 1;
        yy[j] = yy[j2];
        j = j2;
        goto L18
    L20:
        char r13 = 0;
    L22:
        yy[r13] = tmp;
        if (groupPos != 0) goto L25;
        groupNo = groupNo2 + 1;
        checkBounds(groupNo, BZip2Constants.MAX_SELECTORS, "groupNo");
        int zt2 = selector[groupNo] & CecDeviceType.INACTIVE;
        checkBounds(zt2, 6, r5);
        int[] base_zt2 = base[zt2];
        int[] limit_zt2 = limit[zt2];
        int[] perm_zt2 = perm[zt2];
        limit_zt = limit_zt2;
        perm_zt = perm_zt2;
        minLens_zt = minLens[zt2];
        groupPos = 49;
        lastShadow = zt2;
        base_zt = base_zt2;
    L26:
        int zn2 = minLens_zt;
        checkBounds(zn2, 258, "zn");
        int zvec = bsR(bin, zn2);
    L28:
        if (zvec <= limit_zt[zn2]) goto L30;
        zn2 = zn2 + 1;
        checkBounds(zn2, 258, "zn");
        zvec = (zvec << 1) | bsR(bin, 1);
        goto L28
    L30:
        int idx = zvec - base_zt[zn2];
        checkBounds(idx, 258, "zvec");
        zn = perm_zt[idx];
        goto L7
    L25:
        groupPos = groupPos - 1;
        groupNo = groupNo2;
        goto L26
    L21:
        r13 = 0;
        System.arraycopy(yy, 0, yy, 1, zn - 1);
        goto L22
    L32:
        throw new IOException("block overrun in MTF, " + lastShadow2 + " exceeds " + limitLast);
    L34:
        int s = -1;
        int zvec2 = zn;
        int minLens_zt2 = minLens_zt;
        int[] perm_zt3 = perm_zt;
        int[] limit_zt3 = limit_zt;
        int[] base_zt3 = base_zt;
        int zt3 = lastShadow;
        int groupPos2 = groupPos;
        int groupPos3 = 1;
    L35:
        if (zvec2 != 0) goto L37;
        s = s + groupPos3;
        char[] yy2 = yy;
    L40:
        if (groupPos2 != 0) goto L42;
        int nextSym2 = groupNo2 + 1;
        groupPos2 = 49;
        checkBounds(nextSym2, BZip2Constants.MAX_SELECTORS, "groupNo");
        int zt4 = selector[nextSym2] & CecDeviceType.INACTIVE;
        groupNo2 = nextSym2;
        checkBounds(zt4, 6, r5);
        base_zt3 = base[zt4];
        limit_zt3 = limit[zt4];
        perm_zt3 = perm[zt4];
        minLens_zt2 = minLens[zt4];
        zt3 = zt4;
    L43:
        int zn3 = minLens_zt2;
        checkBounds(zn3, 258, "zn");
        int zvec3 = bsR(bin, zn3);
    L44:
        String r39 = r5;
        if (zvec3 <= limit_zt3[zn3]) goto L47;
        zn3 = zn3 + 1;
        checkBounds(zn3, 258, "zn");
        zvec3 = (zvec3 << 1) | bsR(bin, 1);
        r5 = r39;
        goto L44
    L47:
        int tmp2 = zvec3 - base_zt3[zn3];
        checkBounds(tmp2, 258, "zvec");
        zvec2 = perm_zt3[tmp2];
        groupPos3 = groupPos3 << 1;
        bin = bin;
        yy = yy2;
        r5 = r39;
        goto L35
    L42:
        groupPos2 = groupPos2 - 1;
        goto L43
    L37:
        yy2 = yy;
        if (zvec2 != 1) goto L48;
        s = s + (groupPos3 << 1);
        goto L40
    L48:
        BitInputStream bin2 = bin;
        int nextSym3 = zvec2;
        String r310 = r5;
        char r1 = yy2[0];
        checkBounds(r1, 256, "yy");
        byte ch = seqToUnseq[r1];
        int r6 = ch & CecDeviceType.INACTIVE;
        unzftab[r6] = unzftab[r6] + (s + 1);
        int lastShadow3 = lastShadow2 + 1;
        lastShadow2 = lastShadow3 + s;
        Arrays.fill(ll8, lastShadow3, lastShadow2 + 1, ch);
        if (lastShadow2 >= limitLast) goto L52;
        groupPos = groupPos2;
        bin = bin2;
        lastShadow = zt3;
        base_zt = base_zt3;
        limit_zt = limit_zt3;
        perm_zt = perm_zt3;
        groupNo = groupNo2;
        minLens_zt = minLens_zt2;
        yy = yy2;
        zn = nextSym3;
        r5 = r310;
        goto L7
    L52:
        throw new IOException("block overrun while expanding RLE in MTF, " + lastShadow2 + " exceeds " + limitLast);
    L53:
        this.last = lastShadow2;
    }

    private int getAndMoveToFrontDecode0() throws IOException {
        Data dataShadow = this.data;
        int zt = dataShadow.selector[0] & CecDeviceType.INACTIVE;
        checkBounds(zt, 6, "zt");
        int[] limit_zt = dataShadow.limit[zt];
        int zn = dataShadow.minLens[zt];
        checkBounds(zn, 258, "zn");
        int zvec = bsR(this.bin, zn);
    L4:
        if (zvec <= limit_zt[zn]) goto L6;
        zn = zn + 1;
        checkBounds(zn, 258, "zn");
        zvec = (zvec << 1) | bsR(this.bin, 1);
        goto L4
    L6:
        int tmp = zvec - dataShadow.base[zt][zn];
        checkBounds(tmp, 258, "zvec");
        return dataShadow.perm[zt][tmp];
    }

    private int setupBlock() throws IOException {
        if (this.currentState != 0) goto L5;
        return -1;
    L5:
        if (this.data == null) goto L29;
        int[] cftab = this.data.cftab;
        int ttLen = this.last + 1;
        int[] tt = this.data.initTT(ttLen);
        byte[] ll8 = this.data.ll8;
        cftab[0] = 0;
        System.arraycopy(this.data.unzftab, 0, cftab, 1, 256);
        int i = 1;
        int c = cftab[0];
    L8:
        if (i > 256) goto L10;
        c = c + cftab[i];
        cftab[i] = c;
        i = i + 1;
        goto L8
    L10:
        int i2 = 0;
        int lastShadow = this.last;
    L11:
        if (i2 > lastShadow) goto L13;
        int r8 = ll8[i2] & CecDeviceType.INACTIVE;
        int tmp = cftab[r8];
        cftab[r8] = tmp + 1;
        checkBounds(tmp, ttLen, "tt index");
        tt[tmp] = i2;
        i2 = i2 + 1;
        goto L11
    L13:
        int i3 = this.origPtr;
        if (i3 < 0) goto L24;
        if (this.origPtr >= tt.length) goto L24;
        this.su_tPos = tt[this.origPtr];
        this.su_count = 0;
        this.su_i2 = 0;
        this.su_ch2 = 256;
        if (this.blockRandomised == false) goto L22;
        this.su_rNToGo = 0;
        this.su_rTPos = 0;
        return setupRandPartA();
    L22:
        return setupNoRandPartA();
    L24:
        throw new IOException("stream corrupted");
    L29:
        return -1;
    }

    private int setupRandPartA() throws IOException {
        if (this.su_i2 > this.last) goto L15;
        this.su_chPrev = this.su_ch2;
        int su_ch2Shadow = this.data.ll8[this.su_tPos] & CecDeviceType.INACTIVE;
        checkBounds(this.su_tPos, this.data.tt.length, "su_tPos");
        this.su_tPos = this.data.tt[this.su_tPos];
        int r2 = 0;
        if (this.su_rNToGo != 0) goto L9;
        this.su_rNToGo = Rand.rNums(this.su_rTPos) - 1;
        int r1 = this.su_rTPos + 1;
        this.su_rTPos = r1;
        if (r1 != 512) goto L11;
        this.su_rTPos = 0;
    L11:
        if (this.su_rNToGo != 1) goto L13;
        r2 = 1;
    L13:
        int su_ch2Shadow2 = su_ch2Shadow ^ r2;
        this.su_ch2 = su_ch2Shadow2;
        this.su_i2++;
        this.currentState = 3;
        this.crc.updateCRC(su_ch2Shadow2);
        return su_ch2Shadow2;
    L9:
        this.su_rNToGo--;
        goto L11
    L15:
        endBlock();
        initBlock();
        return setupBlock();
    }

    private int setupNoRandPartA() throws IOException {
        if (this.su_i2 > this.last) goto L6;
        this.su_chPrev = this.su_ch2;
        int su_ch2Shadow = this.data.ll8[this.su_tPos] & CecDeviceType.INACTIVE;
        this.su_ch2 = su_ch2Shadow;
        checkBounds(this.su_tPos, this.data.tt.length, "su_tPos");
        this.su_tPos = this.data.tt[this.su_tPos];
        this.su_i2++;
        this.currentState = 6;
        this.crc.updateCRC(su_ch2Shadow);
        return su_ch2Shadow;
    L6:
        this.currentState = 5;
        endBlock();
        initBlock();
        return setupBlock();
    }

    private int setupRandPartB() throws IOException {
        if (this.su_ch2 == this.su_chPrev) goto L6;
        this.currentState = 2;
        this.su_count = 1;
        return setupRandPartA();
    L6:
        int r0 = this.su_count + 1;
        this.su_count = r0;
        if (r0 < 4) goto L19;
        this.su_z = (char) (this.data.ll8[this.su_tPos] & CecDeviceType.INACTIVE);
        checkBounds(this.su_tPos, this.data.tt.length, "su_tPos");
        this.su_tPos = this.data.tt[this.su_tPos];
        if (this.su_rNToGo != 0) goto L13;
        this.su_rNToGo = Rand.rNums(this.su_rTPos) - 1;
        int r1 = this.su_rTPos + 1;
        this.su_rTPos = r1;
        if (r1 != 512) goto L14;
        this.su_rTPos = 0;
    L14:
        this.su_j2 = 0;
        this.currentState = 4;
        if (this.su_rNToGo != 1) goto L18;
        this.su_z = (char) (this.su_z ^ 1);
    L18:
        return setupRandPartC();
    L13:
        this.su_rNToGo--;
        goto L14
    L19:
        this.currentState = 2;
        return setupRandPartA();
    }

    private int setupRandPartC() throws IOException {
        if (this.su_j2 >= this.su_z) goto L6;
        this.crc.updateCRC(this.su_ch2);
        this.su_j2++;
        return this.su_ch2;
    L6:
        this.currentState = 2;
        this.su_i2++;
        this.su_count = 0;
        return setupRandPartA();
    }

    private int setupNoRandPartB() throws IOException {
        if (this.su_ch2 == this.su_chPrev) goto L6;
        this.su_count = 1;
        return setupNoRandPartA();
    L6:
        int r0 = this.su_count + 1;
        this.su_count = r0;
        if (r0 < 4) goto L11;
        checkBounds(this.su_tPos, this.data.ll8.length, "su_tPos");
        this.su_z = (char) (this.data.ll8[this.su_tPos] & CecDeviceType.INACTIVE);
        this.su_tPos = this.data.tt[this.su_tPos];
        this.su_j2 = 0;
        return setupNoRandPartC();
    L11:
        return setupNoRandPartA();
    }

    private int setupNoRandPartC() throws IOException {
        if (this.su_j2 >= this.su_z) goto L6;
        int su_ch2Shadow = this.su_ch2;
        this.crc.updateCRC(su_ch2Shadow);
        this.su_j2++;
        this.currentState = 7;
        return su_ch2Shadow;
    L6:
        this.su_i2++;
        this.su_count = 0;
        return setupNoRandPartA();
    }

    public static boolean matches(byte[] signature, int length) {
        if (length >= 3) goto L5;
        return false;
    L5:
        if (signature[0] == 66) goto L7;
        return false;
    L7:
        if (signature[1] == 90) goto L9;
        return false;
    L9:
        if (signature[2] == 104) goto L11;
        return false;
    L11:
        return true;
    }
}
