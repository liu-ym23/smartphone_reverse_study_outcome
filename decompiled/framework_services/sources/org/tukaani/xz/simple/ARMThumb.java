package org.tukaani.xz.simple;

/* JADX INFO: loaded from: classes3.dex */
public final class ARMThumb implements SimpleFilter {
    private final boolean isEncoder;
    private int pos;

    public ARMThumb(boolean isEncoder, int startPos) {
        this.isEncoder = isEncoder;
        this.pos = startPos + 4;
    }

    @Override // org.tukaani.xz.simple.SimpleFilter
    public int code(byte[] buf, int off, int len) {
        int end = (off + len) - 4;
        int i = off;
    L3:
        if (i > end) goto L14;
        if ((buf[i + 1] & 248) != 240) goto L13;
        if ((buf[i + 3] & 248) != 248) goto L13;
        int src = (((((buf[i + 1] & 7) << 19) | ((buf[i] & 255) << 11)) | ((buf[i + 3] & 7) << 8)) | (buf[i + 2] & 255)) << 1;
        if (this.isEncoder == false) goto L11;
        int dest = ((this.pos + i) - off) + src;
    L12:
        int dest2 = dest >>> 1;
        buf[i + 1] = (byte) (240 | ((dest2 >>> 19) & 7));
        buf[i] = (byte) (dest2 >>> 11);
        buf[i + 3] = (byte) (248 | ((dest2 >>> 8) & 7));
        buf[i + 2] = (byte) dest2;
        i = i + 2;
        goto L13
    L11:
        int dest3 = this.pos;
        dest = src - ((dest3 + i) - off);
    L13:
        i = i + 2;
        goto L3
    L14:
        int i2 = i - off;
        this.pos += i2;
        return i2;
    }
}
