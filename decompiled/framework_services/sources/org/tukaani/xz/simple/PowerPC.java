package org.tukaani.xz.simple;

import android.hardware.audio.common.V2_0.AudioChannelMask;

/* JADX INFO: loaded from: classes3.dex */
public final class PowerPC implements SimpleFilter {
    private final boolean isEncoder;
    private int pos;

    public PowerPC(boolean isEncoder, int startPos) {
        this.isEncoder = isEncoder;
        this.pos = startPos;
    }

    @Override // org.tukaani.xz.simple.SimpleFilter
    public int code(byte[] buf, int off, int len) {
        int end = (off + len) - 4;
        int i = off;
    L3:
        if (i > end) goto L14;
        if ((buf[i] & 252) != 72) goto L13;
        if ((buf[i + 3] & 3) != 1) goto L13;
        int src = ((((buf[i] & 3) << 24) | ((buf[i + 1] & 255) << 16)) | ((buf[i + 2] & 255) << 8)) | (buf[i + 3] & AudioChannelMask.IN_6);
        if (this.isEncoder == false) goto L11;
        int dest = ((this.pos + i) - off) + src;
    L12:
        buf[i] = (byte) (72 | ((dest >>> 24) & 3));
        buf[i + 1] = (byte) (dest >>> 16);
        buf[i + 2] = (byte) (dest >>> 8);
        buf[i + 3] = (byte) ((buf[i + 3] & 3) | dest);
        goto L13
    L11:
        int dest2 = this.pos;
        dest = src - ((dest2 + i) - off);
    L13:
        i = i + 4;
        goto L3
    L14:
        int i2 = i - off;
        this.pos += i2;
        return i2;
    }
}
