package org.apache.commons.compress.compressors.bzip2;

import android.hardware.tv.hdmi.cec.CecDeviceType;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Array;
import org.apache.commons.compress.compressors.CompressorOutputStream;

/* JADX INFO: loaded from: classes3.dex */
public class BZip2CompressorOutputStream extends CompressorOutputStream implements BZip2Constants {
    private static final int GREATER_ICOST = 15;
    private static final int LESSER_ICOST = 0;
    public static final int MAX_BLOCKSIZE = 9;
    public static final int MIN_BLOCKSIZE = 1;
    private final int allowableBlockSize;
    private int blockCRC;
    private final int blockSize100k;
    private BlockSort blockSorter;
    private int bsBuff;
    private int bsLive;
    private volatile boolean closed;
    private int combinedCRC;
    private final CRC crc;
    private int currentChar;
    private Data data;
    private int last;
    private int nInUse;
    private int nMTF;
    private OutputStream out;
    private int runLength;

    static final class Data {
        final byte[] block;
        final int[] fmap;
        final byte[] generateMTFValues_yy;
        final int[] heap;
        final boolean[] inUse;
        final int[] mtfFreq;
        int origPtr;
        final int[] parent;
        final byte[] selector;
        final byte[] selectorMtf;
        final byte[] sendMTFValues2_pos;
        final int[][] sendMTFValues_code;
        final short[] sendMTFValues_cost;
        final int[] sendMTFValues_fave;
        final byte[][] sendMTFValues_len;
        final int[][] sendMTFValues_rfreq;
        final boolean[] sentMTFValues4_inUse16;
        final char[] sfmap;
        final byte[] unseqToSeq;
        final int[] weight;

        Data(int blockSize100k) {
            this.inUse = new boolean[256];
            this.unseqToSeq = new byte[256];
            this.mtfFreq = new int[258];
            this.selector = new byte[BZip2Constants.MAX_SELECTORS];
            this.selectorMtf = new byte[BZip2Constants.MAX_SELECTORS];
            this.generateMTFValues_yy = new byte[256];
            this.sendMTFValues_len = (byte[][]) Array.newInstance(Byte.TYPE, new int[]{6, 258});
            this.sendMTFValues_rfreq = (int[][]) Array.newInstance(Integer.TYPE, new int[]{6, 258});
            this.sendMTFValues_fave = new int[6];
            this.sendMTFValues_cost = new short[6];
            this.sendMTFValues_code = (int[][]) Array.newInstance(Integer.TYPE, new int[]{6, 258});
            this.sendMTFValues2_pos = new byte[6];
            this.sentMTFValues4_inUse16 = new boolean[16];
            this.heap = new int[260];
            this.weight = new int[516];
            this.parent = new int[516];
            int n = BZip2Constants.BASEBLOCKSIZE * blockSize100k;
            this.block = new byte[(n + 1) + 20];
            this.fmap = new int[n];
            this.sfmap = new char[n * 2];
        }
    }

    private static void hbMakeCodeLengths(byte[] len, int[] freq, Data dat, int alphaSize, int maxLen) {
        int[] heap = dat.heap;
        int[] weight = dat.weight;
        int[] parent = dat.parent;
        int i = alphaSize;
    L3:
        int r6 = -1;
        i = i - 1;
        int r7 = 1;
        if (i < 0) goto L10;
        int r8 = i + 1;
        if (freq[i] == 0) goto L9;
        r7 = freq[i];
    L9:
        weight[r8] = r7 << 8;
        goto L3
    L10:
        int i2 = 1;
    L11:
        if (i2 == 0) goto L68;
        i2 = 0;
        int nNodes = alphaSize;
        int nHeap = 0;
        heap[0] = 0;
        weight[0] = 0;
        parent[0] = -2;
        int i3 = 1;
    L13:
        if (i3 > alphaSize) goto L19;
        parent[i3] = r6;
        nHeap = nHeap + 1;
        heap[nHeap] = i3;
        int zz = nHeap;
        int tmp = heap[zz];
    L16:
        if (weight[tmp] >= weight[heap[zz >> 1]]) goto L18;
        heap[zz] = heap[zz >> 1];
        zz = zz >> 1;
        goto L16
    L18:
        heap[zz] = tmp;
        i3 = i3 + 1;
    L19:
        if (nHeap <= r7) goto L51;
        int n1 = heap[r7];
        heap[r7] = heap[nHeap];
        int nHeap2 = nHeap - 1;
        int zz2 = 1;
        int tmp2 = heap[r7];
    L21:
        int yy = zz2 << 1;
        if (yy > nHeap2) goto L30;
        if (yy >= nHeap2) goto L29;
        if (weight[heap[yy + 1]] >= weight[heap[yy]]) goto L29;
        yy = yy + 1;
    L29:
        if (weight[tmp2] < weight[heap[yy]]) goto L30;
        heap[zz2] = heap[yy];
        zz2 = yy;
    L30:
        heap[zz2] = tmp2;
        int n2 = heap[r7];
        heap[r7] = heap[nHeap2];
        int nHeap3 = nHeap2 - 1;
        int zz3 = 1;
        int tmp3 = heap[r7];
    L31:
        int yy2 = zz3 << 1;
        if (yy2 > nHeap3) goto L40;
        if (yy2 >= nHeap3) goto L39;
        if (weight[heap[yy2 + 1]] >= weight[heap[yy2]]) goto L39;
        yy2 = yy2 + 1;
    L39:
        if (weight[tmp3] < weight[heap[yy2]]) goto L40;
        heap[zz3] = heap[yy2];
        zz3 = yy2;
    L40:
        heap[zz3] = tmp3;
        nNodes = nNodes + 1;
        parent[n2] = nNodes;
        parent[n1] = nNodes;
        int weight_n1 = weight[n1];
        int weight_n2 = weight[n2];
        int r17 = r6;
        int r18 = r7;
        int r9 = (weight_n1 & (-256)) + (weight_n2 & (-256));
        if ((weight_n1 & 255) <= (weight_n2 & 255)) goto L43;
        int r0 = weight_n1 & 255;
    L44:
        weight[nNodes] = (r0 + 1) | r9;
        parent[nNodes] = r17;
        int nHeap4 = nHeap3 + 1;
        heap[nHeap4] = nNodes;
        int zz4 = nHeap4;
        int tmp4 = heap[zz4];
        int weight_tmp = weight[tmp4];
    L46:
        if (weight_tmp >= weight[heap[zz4 >> 1]]) goto L48;
        heap[zz4] = heap[zz4 >> 1];
        zz4 = zz4 >> 1;
        goto L46
    L48:
        heap[zz4] = tmp4;
        nHeap = nHeap4;
        r6 = r17;
        r7 = r18;
        goto L19
    L43:
        r0 = weight_n2 & 255;
        goto L44
    L51:
        int r19 = r6;
        int r110 = r7;
        int i4 = 1;
    L52:
        if (i4 > alphaSize) goto L62;
        int j = 0;
        int k = i4;
    L54:
        int parent_k = parent[k];
        if (parent_k < 0) goto L57;
        k = parent_k;
        j = j + 1;
        goto L54
    L57:
        len[i4 - 1] = (byte) j;
        if (j <= maxLen) goto L60;
        i2 = 1;
    L60:
        i4 = i4 + 1;
        goto L52
    L62:
        if (i2 == 0) goto L66;
        int i5 = 1;
    L64:
        if (i5 >= alphaSize) goto L66;
        int j2 = weight[i5] >> 8;
        weight[i5] = ((j2 >> 1) + 1) << 8;
        i5 = i5 + 1;
    L66:
        r6 = r19;
        r7 = r110;
        goto L11
    }

    public static int chooseBlockSize(long inputLength) {
        if (inputLength > 0) goto L7;
        return 9;
    L7:
        return (int) Math.min((inputLength / 132000) + 1, 9);
    }

    public BZip2CompressorOutputStream(OutputStream out) throws IOException {
        this(out, 9);
    }

    public BZip2CompressorOutputStream(OutputStream out, int blockSize) throws IOException {
        this.crc = new CRC();
        this.currentChar = -1;
        this.runLength = 0;
        if (blockSize < 1) goto L11;
        if (blockSize > 9) goto L9;
        this.blockSize100k = blockSize;
        this.out = out;
        this.allowableBlockSize = (this.blockSize100k * BZip2Constants.BASEBLOCKSIZE) - 20;
        init();
        return;
    L9:
        throw new IllegalArgumentException("blockSize(" + blockSize + ") > 9");
    L11:
        throw new IllegalArgumentException("blockSize(" + blockSize + ") < 1");
    }

    @Override // java.io.OutputStream
    public void write(int b) throws IOException {
        if (this.closed == true) goto L7;
        write0(b);
        return;
    L7:
        throw new IOException("closed");
    }

    private void writeRun() throws IOException {
        int lastShadow = this.last;
        if (lastShadow >= this.allowableBlockSize) goto L11;
        int currentCharShadow = this.currentChar;
        Data dataShadow = this.data;
        dataShadow.inUse[currentCharShadow] = true;
        byte ch = (byte) currentCharShadow;
        int runLengthShadow = this.runLength;
        this.crc.updateCRC(currentCharShadow, runLengthShadow);
        switch(runLengthShadow) {
            case 1: goto L9;
            case 2: goto L8;
            case 3: goto L7;
            default: goto L6;
        };
    L6:
        int runLengthShadow2 = runLengthShadow - 4;
        dataShadow.inUse[runLengthShadow2] = true;
        byte[] block = dataShadow.block;
        block[lastShadow + 2] = ch;
        block[lastShadow + 3] = ch;
        block[lastShadow + 4] = ch;
        block[lastShadow + 5] = ch;
        block[lastShadow + 6] = (byte) runLengthShadow2;
        this.last = lastShadow + 5;
        return;
    L7:
        byte[] block2 = dataShadow.block;
        block2[lastShadow + 2] = ch;
        block2[lastShadow + 3] = ch;
        block2[lastShadow + 4] = ch;
        this.last = lastShadow + 3;
        return;
    L8:
        dataShadow.block[lastShadow + 2] = ch;
        dataShadow.block[lastShadow + 3] = ch;
        this.last = lastShadow + 2;
        return;
    L9:
        dataShadow.block[lastShadow + 2] = ch;
        this.last = lastShadow + 1;
        return;
    L11:
        endBlock();
        initBlock();
        writeRun();
    }

    protected void finalize() throws Throwable {
        if (this.closed == true) goto L5;
        System.err.println("Unclosed BZip2CompressorOutputStream detected, will *not* close it");
    L5:
        super.finalize();
    }

    public void finish() throws IOException {
        if (this.closed == true) goto L14;
        this.closed = true;
    L8:
        th = move-exception;
        this.out = null;
        this.blockSorter = null;
        this.data = null;
        throw th;
    L6:
        if (this.runLength <= 0) goto L10;
        writeRun();     // Catch: Throwable -> L8
    L10:
        this.currentChar = -1;     // Catch: Throwable -> L8
        endBlock();     // Catch: Throwable -> L8
        endCompression();     // Catch: Throwable -> L8
        this.out = null;
        this.blockSorter = null;
        this.data = null;
        return;
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.closed == true) goto L10;
        OutputStream outShadow = this.out;
        finish();     // Catch: Throwable -> L7
        outShadow.close();
        return;
    L7:
        th = move-exception;
        outShadow.close();
        throw th;
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public void flush() throws IOException {
        OutputStream outShadow = this.out;
        if (outShadow == null) goto L6;
        outShadow.flush();
        return;
    }

    private void init() throws IOException {
        bsPutUByte(66);
        bsPutUByte(90);
        this.data = new Data(this.blockSize100k);
        this.blockSorter = new BlockSort(this.data);
        bsPutUByte(104);
        bsPutUByte(this.blockSize100k + 48);
        this.combinedCRC = 0;
        initBlock();
    }

    private void initBlock() {
        this.crc.initialiseCRC();
        this.last = -1;
        boolean[] inUse = this.data.inUse;
        int i = 256;
    L3:
        i = i - 1;
        if (i < 0) goto L7;
        inUse[i] = false;
        goto L3
    }

    private void endBlock() throws IOException {
        this.blockCRC = this.crc.getFinalCRC();
        this.combinedCRC = (this.combinedCRC << 1) | (this.combinedCRC >>> 31);
        this.combinedCRC ^= this.blockCRC;
        if (this.last != (-1)) goto L5;
        return;
    L5:
        blockSort();
        bsPutUByte(49);
        bsPutUByte(65);
        bsPutUByte(89);
        bsPutUByte(38);
        bsPutUByte(83);
        bsPutUByte(89);
        bsPutInt(this.blockCRC);
        bsW(1, 0);
        moveToFrontCodeAndSend();
    }

    private void endCompression() throws IOException {
        bsPutUByte(23);
        bsPutUByte(114);
        bsPutUByte(69);
        bsPutUByte(56);
        bsPutUByte(80);
        bsPutUByte(144);
        bsPutInt(this.combinedCRC);
        bsFinishedWithStream();
    }

    public final int getBlockSize() {
        return this.blockSize100k;
    }

    @Override // java.io.OutputStream
    public void write(byte[] buf, int offs, int len) throws IOException {
        if (offs < 0) goto L21;
        if (len < 0) goto L19;
        if ((offs + len) > buf.length) goto L17;
        if (this.closed == true) goto L15;
        int hi = offs + len;
    L10:
        if (offs >= hi) goto L13;
        write0(buf[offs]);
        offs = offs + 1;
        goto L10
    L13:
        return;
    L15:
        throw new IOException("stream closed");
    L17:
        throw new IndexOutOfBoundsException("offs(" + offs + ") + len(" + len + ") > buf.length(" + buf.length + ").");
    L19:
        throw new IndexOutOfBoundsException("len(" + len + ") < 0.");
    L21:
        throw new IndexOutOfBoundsException("offs(" + offs + ") < 0.");
    }

    private void write0(int b) throws IOException {
        if (this.currentChar == (-1)) goto L10;
        int b2 = b & 255;
        if (this.currentChar != b2) goto L9;
        int r0 = this.runLength + 1;
        this.runLength = r0;
        if (r0 <= 254) goto L12;
        writeRun();
        this.currentChar = -1;
        this.runLength = 0;
        return;
    L12:
        return;
    L9:
        writeRun();
        this.runLength = 1;
        this.currentChar = b2;
        return;
    L10:
        this.currentChar = b & 255;
        this.runLength++;
    }

    private static void hbAssignCodes(int[] code, byte[] length, int minLen, int maxLen, int alphaSize) {
        int vec = 0;
        int n = minLen;
    L3:
        if (n > maxLen) goto L12;
        int i = 0;
    L5:
        if (i >= alphaSize) goto L10;
        if ((length[i] & 255) != n) goto L9;
        code[i] = vec;
        vec = vec + 1;
    L9:
        i = i + 1;
        goto L5
    L10:
        vec = vec << 1;
        n = n + 1;
        goto L3
    }

    private void bsFinishedWithStream() throws IOException {
    L3:
        if (this.bsLive <= 0) goto L5;
        int ch = this.bsBuff >> 24;
        this.out.write(ch);
        this.bsBuff <<= 8;
        this.bsLive -= 8;
        goto L3
    }

    private void bsW(int n, int v) throws IOException {
        OutputStream outShadow = this.out;
        int bsLiveShadow = this.bsLive;
        int bsBuffShadow = this.bsBuff;
    L4:
        if (bsLiveShadow < 8) goto L6;
        outShadow.write(bsBuffShadow >> 24);
        bsBuffShadow = bsBuffShadow << 8;
        bsLiveShadow = bsLiveShadow - 8;
        goto L4
    L6:
        this.bsBuff = (v << ((32 - bsLiveShadow) - n)) | bsBuffShadow;
        this.bsLive = bsLiveShadow + n;
    }

    private void bsPutUByte(int c) throws IOException {
        bsW(8, c);
    }

    private void bsPutInt(int u) throws IOException {
        bsW(8, (u >> 24) & 255);
        bsW(8, (u >> 16) & 255);
        bsW(8, (u >> 8) & 255);
        bsW(8, u & 255);
    }

    private void sendMTFValues() throws IOException {
        byte[][] len = this.data.sendMTFValues_len;
        int nGroups = 2;
        int alphaSize = this.nInUse + 2;
        int t = 6;
    L3:
        t = t - 1;
        if (t < 0) goto L10;
        byte[] len_t = len[t];
        int v = alphaSize;
    L6:
        v = v - 1;
        if (v < 0) goto L3;
        len_t[v] = 15;
        goto L6
    L10:
        int t2 = this.nMTF;
        if (t2 >= 200) goto L14;
    L23:
        sendMTFValues0(nGroups, alphaSize);
        int nSelectors = sendMTFValues1(nGroups, alphaSize);
        sendMTFValues2(nGroups, nSelectors);
        sendMTFValues3(nGroups, alphaSize);
        sendMTFValues4();
        sendMTFValues5(nGroups, nSelectors);
        sendMTFValues6(nGroups, alphaSize);
        sendMTFValues7();
        return;
    L14:
        if (this.nMTF >= 600) goto L17;
        nGroups = 3;
        goto L23
    L17:
        if (this.nMTF >= 1200) goto L20;
        nGroups = 4;
        goto L23
    L20:
        if (this.nMTF >= 2400) goto L22;
        nGroups = 5;
        goto L23
    L22:
        nGroups = 6;
        goto L23
    }

    private void sendMTFValues0(int nGroups, int alphaSize) {
        byte[][] len = this.data.sendMTFValues_len;
        int[] mtfFreq = this.data.mtfFreq;
        int remF = this.nMTF;
        int gs = 0;
        int nPart = nGroups;
    L3:
        if (nPart <= 0) goto L24;
        int tFreq = remF / nPart;
        int ge = gs - 1;
        int aFreq = 0;
        int a = alphaSize - 1;
    L5:
        if (aFreq >= tFreq) goto L8;
        if (ge >= a) goto L8;
        ge = ge + 1;
        aFreq = aFreq + mtfFreq[ge];
    L8:
        if (ge <= gs) goto L15;
        if (nPart == nGroups) goto L15;
        if (nPart == 1) goto L15;
        if ((1 & (nGroups - nPart)) == 0) goto L15;
        aFreq = aFreq - mtfFreq[ge];
        ge = ge - 1;
    L15:
        int ge2 = nPart - 1;
        byte[] len_np = len[ge2];
        int v = alphaSize;
    L16:
        v = v - 1;
        if (v < 0) goto L22;
        if (v < gs) goto L21;
        if (v > ge) goto L21;
        len_np[v] = 0;
    L21:
        len_np[v] = 15;
        goto L16
    L22:
        gs = ge + 1;
        remF = remF - aFreq;
        nPart = nPart - 1;
        goto L3
    }

    private int sendMTFValues1(int nGroups, int alphaSize) {
        Data dataShadow = this.data;
        int[][] rfreq = dataShadow.sendMTFValues_rfreq;
        int[] fave = dataShadow.sendMTFValues_fave;
        short[] cost = dataShadow.sendMTFValues_cost;
        char[] sfmap = dataShadow.sfmap;
        byte[] selector = dataShadow.selector;
        byte[][] len = dataShadow.sendMTFValues_len;
        byte[] len_0 = len[0];
        byte[] len_1 = len[1];
        byte[] len_2 = len[2];
        char r15 = 3;
        byte[] len_3 = len[3];
        int r9 = 4;
        byte[] len_4 = len[4];
        byte[] len_5 = len[5];
        int nMTFShadow = this.nMTF;
        int nSelectors = 0;
        int iter = 0;
    L3:
        if (iter >= r9) goto L49;
        int t = nGroups;
    L5:
        t = t - 1;
        if (t < 0) goto L12;
        fave[t] = 0;
        int[] rfreqt = rfreq[t];
        int i = alphaSize;
    L8:
        i = i - 1;
        if (i < 0) goto L5;
        rfreqt[i] = 0;
        goto L8
    L12:
        nSelectors = 0;
        int r24 = r9;
        int gs = 0;
    L13:
        char r25 = r15;
        if (gs >= this.nMTF) goto L44;
        Data dataShadow2 = dataShadow;
        int ge = Math.min((gs + 50) - 1, nMTFShadow - 1);
        if (nGroups != 6) goto L21;
        short cost0 = 0;
        short cost1 = 0;
        short cost2 = 0;
        short cost3 = 0;
        short cost4 = 0;
        short cost5 = 0;
        int i2 = gs;
    L18:
        if (i2 > ge) goto L20;
        char r33 = sfmap[i2];
        int i3 = i2;
        int i4 = len_0[r33];
        cost0 = (short) ((i4 & 255) + cost0);
        cost1 = (short) (cost1 + (len_1[r33] & CecDeviceType.INACTIVE));
        short cost6 = len_2[r33];
        cost2 = (short) (cost2 + (cost6 & 255));
        short cost7 = len_3[r33];
        cost3 = (short) (cost3 + (cost7 & 255));
        short cost8 = len_4[r33];
        cost4 = (short) (cost4 + (cost8 & 255));
        short cost9 = len_5[r33];
        cost5 = (short) (cost5 + (cost9 & 255));
        i2 = i3 + 1;
        goto L18
    L20:
        cost[0] = cost0;
        cost[1] = cost1;
        cost[2] = cost2;
        cost[r25] = cost3;
        cost[r24] = cost4;
        cost[5] = cost5;
    L33:
        int bt = -1;
        int t2 = nGroups;
        int[] fave2 = fave;
        int bc = 999999999;
    L34:
        t2 = t2 - 1;
        if (t2 < 0) goto L40;
        short[] cost10 = cost;
        short r5 = cost10[t2];
        if (r5 >= bc) goto L39;
        bc = r5;
        bt = t2;
    L39:
        cost = cost10;
        goto L34
    L40:
        short[] cost11 = cost;
        int bc2 = fave2[bt];
        fave2[bt] = bc2 + 1;
        selector[nSelectors] = (byte) bt;
        nSelectors = nSelectors + 1;
        int[] rfreq_bt = rfreq[bt];
        int i5 = gs;
    L41:
        if (i5 > ge) goto L43;
        char r16 = sfmap[i5];
        rfreq_bt[r16] = rfreq_bt[r16] + 1;
        i5 = i5 + 1;
        goto L41
    L43:
        gs = ge + 1;
        r15 = r25;
        dataShadow = dataShadow2;
        fave = fave2;
        cost = cost11;
        rfreq = rfreq;
        goto L13
    L21:
        int t3 = nGroups;
    L22:
        t3 = t3 - 1;
        if (t3 < 0) goto L25;
        cost[t3] = 0;
        goto L22
    L25:
        int i6 = gs;
    L26:
        if (i6 > ge) goto L33;
        char r17 = sfmap[i6];
        int t4 = nGroups;
    L28:
        t4 = t4 - 1;
        if (t4 < 0) goto L31;
        short r28 = cost[t4];
        int i7 = i6;
        int i8 = len[t4][r17];
        cost[t4] = (short) (r28 + (i8 & 255));
        i6 = i7;
        goto L28
    L31:
        i6 = i6 + 1;
        goto L26
    L44:
        Data dataShadow3 = dataShadow;
        int[][] rfreq2 = rfreq;
        int[] fave3 = fave;
        short[] cost12 = cost;
        int t5 = 0;
    L45:
        if (t5 >= nGroups) goto L47;
        hbMakeCodeLengths(len[t5], rfreq2[t5], this.data, alphaSize, 20);
        t5 = t5 + 1;
        goto L45
    L47:
        iter = iter + 1;
        r9 = r24;
        r15 = r25;
        dataShadow = dataShadow3;
        fave = fave3;
        cost = cost12;
        rfreq = rfreq2;
        goto L3
    L49:
        return nSelectors;
    }

    private void sendMTFValues2(int nGroups, int nSelectors) {
        Data dataShadow = this.data;
        byte[] pos = dataShadow.sendMTFValues2_pos;
        int i = nGroups;
    L3:
        i = i - 1;
        if (i < 0) goto L6;
        pos[i] = (byte) i;
        goto L3
    L6:
        int i2 = 0;
    L7:
        if (i2 >= nSelectors) goto L13;
        byte ll_i = dataShadow.selector[i2];
        byte tmp = pos[0];
        int j = 0;
    L9:
        if (ll_i == tmp) goto L11;
        j = j + 1;
        byte tmp2 = tmp;
        tmp = pos[j];
        pos[j] = tmp2;
        goto L9
    L11:
        pos[0] = tmp;
        dataShadow.selectorMtf[i2] = (byte) j;
        i2 = i2 + 1;
        goto L7
    }

    private void sendMTFValues3(int nGroups, int alphaSize) {
        int[][] code = this.data.sendMTFValues_code;
        byte[][] len = this.data.sendMTFValues_len;
        int t = 0;
    L3:
        if (t >= nGroups) goto L15;
        int minLen = 32;
        int maxLen = 0;
        byte[] len_t = len[t];
        int i = alphaSize;
    L5:
        i = i - 1;
        if (i < 0) goto L13;
        int l = len_t[i] & CecDeviceType.INACTIVE;
        if (l <= maxLen) goto L10;
        maxLen = l;
    L10:
        if (l >= minLen) goto L5;
        minLen = l;
        goto L5
    L13:
        hbAssignCodes(code[t], len[t], minLen, maxLen, alphaSize);
        t = t + 1;
        goto L3
    }

    private void sendMTFValues4() throws IOException {
        boolean[] r0 = this.data.inUse;
        boolean[] r1 = this.data.sentMTFValues4_inUse16;
        int r2 = 16;
    L3:
        r2 = r2 - 1;
        if (r2 < 0) goto L12;
        r1[r2] = false;
        int r4 = r2 * 16;
        int r5 = 16;
    L6:
        r5 = r5 - 1;
        if (r5 < 0) goto L3;
        if (r0[r4 + r5] == false) goto L6;
        r1[r2] = true;
        goto L6
    L12:
        int r3 = 0;
    L14:
        if (r3 >= 16) goto L16;
        bsW(1, r1[r3] ? 1 : 0);
        r3 = r3 + 1;
        goto L14
    L16:
        OutputStream r6 = this.out;
        int r7 = this.bsLive;
        int r8 = this.bsBuff;
        int r9 = 0;
    L17:
        if (r9 >= 16) goto L31;
        if (r1[r9] == false) goto L30;
        int r10 = r9 * 16;
        int r11 = 0;
    L22:
        if (r11 >= 16) goto L30;
    L24:
        if (r7 < 8) goto L27;
        r6.write(r8 >> 24);
        r8 = r8 << 8;
        r7 = r7 - 8;
        goto L24
    L27:
        if (r0[r10 + r11] == false) goto L29;
        r8 = r8 | (1 << ((32 - r7) - 1));
    L29:
        r7 = r7 + 1;
        r11 = r11 + 1;
    L30:
        r9 = r9 + 1;
        goto L17
    L31:
        this.bsBuff = r8;
        this.bsLive = r7;
    }

    private void sendMTFValues5(int nGroups, int nSelectors) throws IOException {
        bsW(3, nGroups);
        bsW(15, nSelectors);
        OutputStream outShadow = this.out;
        byte[] selectorMtf = this.data.selectorMtf;
        int bsLiveShadow = this.bsLive;
        int bsBuffShadow = this.bsBuff;
        int i = 0;
    L3:
        if (i >= nSelectors) goto L13;
        int j = 0;
        int hj = selectorMtf[i] & CecDeviceType.INACTIVE;
    L6:
        if (j >= hj) goto L10;
    L7:
        if (bsLiveShadow < 8) goto L9;
        outShadow.write(bsBuffShadow >> 24);
        bsBuffShadow = bsBuffShadow << 8;
        bsLiveShadow = bsLiveShadow - 8;
        goto L7
    L9:
        bsBuffShadow = bsBuffShadow | (1 << ((32 - bsLiveShadow) - 1));
        bsLiveShadow = bsLiveShadow + 1;
        j = j + 1;
    L10:
        if (bsLiveShadow < 8) goto L12;
        outShadow.write(bsBuffShadow >> 24);
        bsBuffShadow = bsBuffShadow << 8;
        bsLiveShadow = bsLiveShadow - 8;
        goto L10
    L12:
        bsLiveShadow = bsLiveShadow + 1;
        i = i + 1;
        goto L3
    L13:
        this.bsBuff = bsBuffShadow;
        this.bsLive = bsLiveShadow;
    }

    private void sendMTFValues6(int nGroups, int alphaSize) throws IOException {
        byte[][] len = this.data.sendMTFValues_len;
        OutputStream outShadow = this.out;
        int bsLiveShadow = this.bsLive;
        int bsBuffShadow = this.bsBuff;
        int t = 0;
    L3:
        if (t >= nGroups) goto L25;
        byte[] len_t = len[t];
        int curr = len_t[0] & CecDeviceType.INACTIVE;
    L6:
        if (bsLiveShadow < 8) goto L8;
        outShadow.write(bsBuffShadow >> 24);
        bsBuffShadow = bsBuffShadow << 8;
        bsLiveShadow = bsLiveShadow - 8;
        goto L6
    L8:
        bsBuffShadow = bsBuffShadow | (curr << ((32 - bsLiveShadow) - 5));
        bsLiveShadow = bsLiveShadow + 5;
        int i = 0;
    L9:
        if (i >= alphaSize) goto L24;
        int lti = len_t[i] & CecDeviceType.INACTIVE;
    L12:
        if (curr >= lti) goto L17;
    L13:
        if (bsLiveShadow < 8) goto L15;
        outShadow.write(bsBuffShadow >> 24);
        bsBuffShadow = bsBuffShadow << 8;
        bsLiveShadow = bsLiveShadow - 8;
        goto L13
    L15:
        bsBuffShadow = bsBuffShadow | (2 << ((32 - bsLiveShadow) - 2));
        bsLiveShadow = bsLiveShadow + 2;
        curr = curr + 1;
    L17:
        if (curr <= lti) goto L21;
    L18:
        if (bsLiveShadow < 8) goto L20;
        outShadow.write(bsBuffShadow >> 24);
        bsBuffShadow = bsBuffShadow << 8;
        bsLiveShadow = bsLiveShadow - 8;
        goto L18
    L20:
        bsBuffShadow = bsBuffShadow | (3 << ((32 - bsLiveShadow) - 2));
        bsLiveShadow = bsLiveShadow + 2;
        curr = curr - 1;
    L21:
        if (bsLiveShadow < 8) goto L23;
        outShadow.write(bsBuffShadow >> 24);
        bsBuffShadow = bsBuffShadow << 8;
        bsLiveShadow = bsLiveShadow - 8;
        goto L21
    L23:
        bsLiveShadow = bsLiveShadow + 1;
        i = i + 1;
        goto L9
    L24:
        t = t + 1;
        goto L3
    L25:
        this.bsBuff = bsBuffShadow;
        this.bsLive = bsLiveShadow;
    }

    private void sendMTFValues7() throws IOException {
        Data dataShadow = this.data;
        byte[][] len = dataShadow.sendMTFValues_len;
        int[][] code = dataShadow.sendMTFValues_code;
        OutputStream outShadow = this.out;
        byte[] selector = dataShadow.selector;
        char[] sfmap = dataShadow.sfmap;
        int nMTFShadow = this.nMTF;
        int selCtr = 0;
        int bsLiveShadow = this.bsLive;
        int bsBuffShadow = this.bsBuff;
        int gs = 0;
    L3:
        if (gs >= nMTFShadow) goto L12;
        int ge = Math.min((gs + 50) - 1, nMTFShadow - 1);
        int selector_selCtr = selector[selCtr] & 255;
        int[] code_selCtr = code[selector_selCtr];
        byte[] len_selCtr = len[selector_selCtr];
    L5:
        if (gs > ge) goto L11;
        char r16 = sfmap[gs];
    L7:
        Data dataShadow2 = dataShadow;
        if (bsLiveShadow < 8) goto L10;
        outShadow.write(bsBuffShadow >> 24);
        bsBuffShadow = bsBuffShadow << 8;
        bsLiveShadow = bsLiveShadow - 8;
        dataShadow = dataShadow2;
        goto L7
    L10:
        int n = len_selCtr[r16] & CecDeviceType.INACTIVE;
        bsBuffShadow = bsBuffShadow | (code_selCtr[r16] << ((32 - bsLiveShadow) - n));
        bsLiveShadow = bsLiveShadow + n;
        gs = gs + 1;
        dataShadow = dataShadow2;
        goto L5
    L11:
        gs = ge + 1;
        selCtr = selCtr + 1;
        goto L3
    L12:
        this.bsBuff = bsBuffShadow;
        this.bsLive = bsLiveShadow;
    }

    private void moveToFrontCodeAndSend() throws IOException {
        bsW(24, this.data.origPtr);
        generateMTFValues();
        sendMTFValues();
    }

    private void blockSort() {
        this.blockSorter.blockSort(this.data, this.last);
    }

    private void generateMTFValues() {
        int lastShadow = this.last;
        Data dataShadow = this.data;
        boolean[] inUse = dataShadow.inUse;
        byte[] block = dataShadow.block;
        int[] fmap = dataShadow.fmap;
        char[] sfmap = dataShadow.sfmap;
        int[] mtfFreq = dataShadow.mtfFreq;
        byte[] unseqToSeq = dataShadow.unseqToSeq;
        byte[] yy = dataShadow.generateMTFValues_yy;
        int nInUseShadow = 0;
        int i = 0;
    L4:
        if (i >= 256) goto L9;
        if (inUse[i] == false) goto L8;
        unseqToSeq[i] = (byte) nInUseShadow;
        nInUseShadow = nInUseShadow + 1;
    L8:
        i = i + 1;
        goto L4
    L9:
        this.nInUse = nInUseShadow;
        int eob = nInUseShadow + 1;
        int i2 = eob;
    L10:
        char r13 = 0;
        if (i2 < 0) goto L13;
        mtfFreq[i2] = 0;
        i2 = i2 - 1;
        goto L10
    L13:
        int i3 = nInUseShadow;
    L14:
        i3 = i3 - 1;
        if (i3 < 0) goto L17;
        yy[i3] = (byte) i3;
        goto L14
    L17:
        int wr = 0;
        int zPend = 0;
        int i4 = 0;
    L18:
        char r16 = r13;
        if (i4 > lastShadow) goto L40;
        byte ll_i = unseqToSeq[block[fmap[i4]] & CecDeviceType.INACTIVE];
        byte tmp = yy[r16];
        int j = 0;
        int lastShadow2 = lastShadow;
        byte tmp2 = tmp;
    L21:
        if (ll_i == tmp2) goto L23;
        j = j + 1;
        byte tmp3 = tmp2;
        tmp2 = yy[j];
        yy[j] = tmp3;
        goto L21
    L23:
        yy[r16] = tmp2;
        if (j != 0) goto L26;
        zPend = zPend + 1;
    L38:
        i4 = i4 + 1;
        r13 = r16;
        lastShadow = lastShadow2;
        goto L18
    L26:
        if (zPend <= 0) goto L37;
        int zPend2 = zPend - 1;
    L29:
        if ((zPend2 & 1) != 0) goto L31;
        sfmap[wr] = r16;
        wr = wr + 1;
        mtfFreq[r16] = mtfFreq[r16] + 1;
    L32:
        byte tmp4 = tmp2;
        if (zPend2 < 2) goto L35;
        zPend2 = (zPend2 - 2) >> 1;
        tmp2 = tmp4;
        goto L29
    L35:
        zPend = 0;
        goto L37
    L31:
        sfmap[wr] = 1;
        wr = wr + 1;
        mtfFreq[1] = mtfFreq[1] + 1;
    L37:
        sfmap[wr] = (char) (j + 1);
        wr = wr + 1;
        int r1 = j + 1;
        mtfFreq[r1] = mtfFreq[r1] + 1;
        goto L38
    L40:
        if (zPend <= 0) goto L49;
        int zPend3 = zPend - 1;
    L43:
        if ((zPend3 & 1) != 0) goto L45;
        sfmap[wr] = r16;
        wr = wr + 1;
        mtfFreq[r16] = mtfFreq[r16] + 1;
    L47:
        if (zPend3 < 2) goto L49;
        zPend3 = (zPend3 - 2) >> 1;
        goto L43
    L45:
        sfmap[wr] = 1;
        wr = wr + 1;
        mtfFreq[1] = mtfFreq[1] + 1;
    L49:
        sfmap[wr] = (char) eob;
        mtfFreq[eob] = mtfFreq[eob] + 1;
        this.nMTF = wr + 1;
    }
}
