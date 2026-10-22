package org.tukaani.xz.simple;

/* JADX INFO: loaded from: classes3.dex */
public final class SPARC implements SimpleFilter {
    private final boolean isEncoder;
    private int pos;

    public SPARC(boolean isEncoder, int startPos) {
        this.isEncoder = isEncoder;
        this.pos = startPos;
    }

    @Override // org.tukaani.xz.simple.SimpleFilter
    public int code(byte[] buf, int off, int len) {
        int end = (off + len) - 4;
        int i = off;
    L3:
        if (i > end) goto L18;
        if (buf[i] != 64) goto L9;
        if ((buf[i + 1] & 192) != 0) goto L9;
    L12:
        int src = (((((buf[i] & 255) << 24) | ((buf[i + 1] & 255) << 16)) | ((buf[i + 2] & 255) << 8)) | (buf[i + 3] & 255)) << 2;
        if (this.isEncoder == false) goto L15;
        int dest = ((this.pos + i) - off) + src;
    L16:
        int dest2 = dest >>> 2;
        int dest3 = ((((0 - ((dest2 >>> 22) & 1)) << 22) & 1073741823) | (4194303 & dest2)) | 1073741824;
        buf[i] = (byte) (dest3 >>> 24);
        buf[i + 1] = (byte) (dest3 >>> 16);
        buf[i + 2] = (byte) (dest3 >>> 8);
        buf[i + 3] = (byte) dest3;
    L17:
        i = i + 4;
        goto L3
    L15:
        int dest4 = this.pos;
        dest = src - ((dest4 + i) - off);
    L9:
        if (buf[i] != 127) goto L17;
        if ((buf[i + 1] & 192) != 192) goto L17;
    L18:
        int i2 = i - off;
        this.pos += i2;
        return i2;
    }
}
