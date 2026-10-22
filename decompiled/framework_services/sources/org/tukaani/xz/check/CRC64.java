package org.tukaani.xz.check;

import android.hardware.tv.hdmi.cec.CecDeviceType;
import java.lang.reflect.Array;

/* JADX INFO: loaded from: classes3.dex */
public class CRC64 extends Check {
    private static final long[][] TABLE = null;
    private long crc;

    static {
        TABLE = (long[][]) Array.newInstance(Long.TYPE, new int[]{4, 256});
        int s = 0;
    L3:
        if (s >= 4) goto L20;
        int b = 0;
    L5:
        if (b >= 256) goto L18;
        if (s != 0) goto L8;
        long r = b;
    L9:
        int i = 0;
    L11:
        if (i >= 8) goto L17;
        if ((r & 1) != 1) goto L15;
        r = (r >>> 1) ^ (-3932672073523589310L);
    L16:
        i = i + 1;
        goto L11
    L15:
        r = r >>> 1;
        goto L16
    L17:
        TABLE[s][b] = r;
        b = b + 1;
        goto L5
    L8:
        r = TABLE[s - 1][b];
        goto L9
    L18:
        s = s + 1;
        goto L3
    }

    public CRC64() {
        this.crc = -1;
        this.size = 8;
        this.name = "CRC64";
    }

    @Override // org.tukaani.xz.check.Check
    public void update(byte[] buf, int off, int len) {
        int end = off + len;
        int i = off;
        int end4 = end - 3;
    L4:
        if (i >= end4) goto L6;
        int tmp = (int) this.crc;
        this.crc = (((TABLE[3][(tmp & 255) ^ (buf[i] & CecDeviceType.INACTIVE)] ^ TABLE[2][((tmp >>> 8) & 255) ^ (buf[i + 1] & CecDeviceType.INACTIVE)]) ^ (this.crc >>> 32)) ^ TABLE[1][((tmp >>> 16) & 255) ^ (buf[i + 2] & CecDeviceType.INACTIVE)]) ^ TABLE[0][((tmp >>> 24) & 255) ^ (buf[i + 3] & CecDeviceType.INACTIVE)];
        i = i + 4;
    L6:
        if (i >= end) goto L8;
        this.crc = TABLE[0][(buf[i] & 255) ^ (((int) this.crc) & 255)] ^ (this.crc >>> 8);
        i = i + 1;
        goto L6
    }

    @Override // org.tukaani.xz.check.Check
    public byte[] finish() {
        long value = ~this.crc;
        this.crc = -1;
        byte[] buf = new byte[8];
        int i = 0;
    L4:
        if (i >= buf.length) goto L7;
        buf[i] = (byte) (value >> (i * 8));
        i = i + 1;
        goto L4
    L7:
        return buf;
    }
}
