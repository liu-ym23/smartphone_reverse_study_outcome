package org.tukaani.xz.simple;

import android.hardware.tv.hdmi.cec.CecDeviceType;

/* JADX INFO: loaded from: classes3.dex */
public final class ARM implements SimpleFilter {
    private final boolean isEncoder;
    private int pos;

    public ARM(boolean isEncoder, int startPos) {
        this.isEncoder = isEncoder;
        this.pos = startPos + 8;
    }

    @Override // org.tukaani.xz.simple.SimpleFilter
    public int code(byte[] buf, int off, int len) {
        int end = (off + len) - 4;
        int i = off;
    L3:
        if (i > end) goto L12;
        if ((buf[i + 3] & CecDeviceType.INACTIVE) != 235) goto L11;
        int src = ((((buf[i + 2] & 255) << 16) | ((buf[i + 1] & 255) << 8)) | (buf[i] & 255)) << 2;
        if (this.isEncoder == false) goto L9;
        int dest = ((this.pos + i) - off) + src;
    L10:
        int dest2 = dest >>> 2;
        buf[i + 2] = (byte) (dest2 >>> 16);
        buf[i + 1] = (byte) (dest2 >>> 8);
        buf[i] = (byte) dest2;
        goto L11
    L9:
        int dest3 = this.pos;
        dest = src - ((dest3 + i) - off);
    L11:
        i = i + 4;
        goto L3
    L12:
        int i2 = i - off;
        this.pos += i2;
        return i2;
    }
}
