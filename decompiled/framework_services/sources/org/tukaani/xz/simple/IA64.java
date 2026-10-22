package org.tukaani.xz.simple;

import com.android.server.storage.DeviceStorageMonitorServiceSmtEx;

/* JADX INFO: loaded from: classes3.dex */
public final class IA64 implements SimpleFilter {
    private static final int[] BRANCH_TABLE = null;
    private final boolean isEncoder;
    private int pos;

    static {
        BRANCH_TABLE = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 4, 4, 6, 6, 0, 0, 7, 7, 4, 4, 0, 0, 4, 4, 0, 0};
    }

    public IA64(boolean isEncoder, int startPos) {
        this.isEncoder = isEncoder;
        this.pos = startPos;
    }

    @Override // org.tukaani.xz.simple.SimpleFilter
    public int code(byte[] buf, int off, int len) {
        int src = 16;
        int end = (off + len) - 16;
        int i = off;
    L3:
        if (i > end) goto L30;
        int instrTemplate = buf[i] & 31;
        int mask = BRANCH_TABLE[instrTemplate];
        int slot = 0;
        int bitPos = 5;
    L6:
        if (slot >= 3) goto L29;
        if (((mask >>> slot) & 1) != 0) goto L10;
        int r21 = src;
        int i2 = i;
    L28:
        slot = slot + 1;
        bitPos = bitPos + 41;
        src = r21;
        i = i2;
        goto L6
    L10:
        int bytePos = bitPos >>> 3;
        int bitRes = bitPos & 7;
        long instr = 0;
        int j = 0;
    L12:
        if (j >= 6) goto L14;
        instr = instr | ((((long) buf[(i + bytePos) + j]) & 255) << (j * 8));
        j = j + 1;
        goto L12
    L14:
        long instrNorm = instr >>> bitRes;
        if (((instrNorm >>> 37) & 15) == 5) goto L17;
        r21 = src;
        i2 = i;
        goto L28
    L17:
        if (((instrNorm >>> 9) & 7) == 0) goto L19;
        r21 = src;
        i2 = i;
        goto L28
    L19:
        r21 = src;
        i2 = i;
        int src2 = (int) ((instrNorm >>> 13) & 1048575);
        int src3 = (src2 | ((((int) (instrNorm >>> 36)) & 1) << 20)) << 4;
        if (this.isEncoder == false) goto L22;
        int dest = ((this.pos + i2) - off) + src3;
    L23:
        int dest2 = dest >>> 4;
        long instr2 = (instr & ((long) ((1 << bitRes) - 1))) | (((((-77309403137L) & instrNorm) | ((((long) dest2) & 1048575) << 13)) | ((((long) dest2) & DeviceStorageMonitorServiceSmtEx.TrafficStats.MB_IN_BYTES) << r21)) << bitRes);
        int j2 = 0;
    L25:
        if (j2 >= 6) goto L28;
        buf[(i2 + bytePos) + j2] = (byte) (instr2 >>> (j2 * 8));
        j2 = j2 + 1;
        goto L25
    L22:
        int dest3 = this.pos;
        dest = src3 - ((dest3 + i2) - off);
        goto L23
    L29:
        i = i + 16;
        goto L3
    L30:
        int i3 = i - off;
        this.pos += i3;
        return i3;
    }
}
