package org.tukaani.xz.simple;

/* JADX INFO: loaded from: classes3.dex */
public final class X86 implements SimpleFilter {
    private static final boolean[] MASK_TO_ALLOWED_STATUS = null;
    private static final int[] MASK_TO_BIT_NUMBER = null;
    private final boolean isEncoder;
    private int pos;
    private int prevMask;

    static {
        MASK_TO_ALLOWED_STATUS = new boolean[]{true, true, true, false, true, false, false, false};
        MASK_TO_BIT_NUMBER = new int[]{0, 1, 2, 2, 3, 3, 3, 3};
    }

    private static boolean test86MSByte(byte b) {
        int i = b & 255;
        if (i != 0) goto L5;
    L8:
        return true;
    L5:
        if (i == 255) goto L8;
        return false;
    }

    public X86(boolean isEncoder, int startPos) {
        this.prevMask = 0;
        this.isEncoder = isEncoder;
        this.pos = startPos + 5;
    }

    @Override // org.tukaani.xz.simple.SimpleFilter
    public int code(byte[] buf, int off, int len) {
        int prevPos = off - 1;
        int end = (off + len) - 5;
        int i = off;
    L3:
        int r3 = 0;
        if (i > end) goto L34;
        if ((buf[i] & 254) != 232) goto L33;
        int prevPos2 = i - prevPos;
        if ((prevPos2 & (-4)) == 0) goto L11;
        this.prevMask = 0;
    L18:
        prevPos = i;
        if (test86MSByte(buf[i + 4]) == false) goto L32;
        int src = (((buf[i + 1] & 255) | ((buf[i + 2] & 255) << 8)) | ((buf[i + 3] & 255) << 16)) | ((buf[i + 4] & 255) << 24);
    L22:
        if (this.isEncoder == false) goto L24;
        int dest = ((this.pos + i) - off) + src;
    L26:
        if (this.prevMask == 0) goto L30;
        int index = MASK_TO_BIT_NUMBER[this.prevMask] * 8;
        if (test86MSByte((byte) (dest >>> (24 - index))) == false) goto L30;
        src = dest ^ ((1 << (32 - index)) - 1);
    L30:
        buf[i + 1] = (byte) dest;
        buf[i + 2] = (byte) (dest >>> 8);
        buf[i + 3] = (byte) (dest >>> 16);
        buf[i + 4] = (byte) (~(((dest >>> 24) & 1) - 1));
        i = i + 4;
        goto L33
    L24:
        int dest2 = this.pos;
        dest = src - ((dest2 + i) - off);
        goto L26
    L32:
        int src2 = this.prevMask;
        this.prevMask = (src2 << 1) | 1;
        goto L33
    L11:
        this.prevMask = (this.prevMask << (prevPos2 - 1)) & 7;
        if (this.prevMask == 0) goto L18;
        if (MASK_TO_ALLOWED_STATUS[this.prevMask] == true) goto L16;
    L17:
        prevPos = i;
        this.prevMask = (this.prevMask << 1) | 1;
        goto L33
    L16:
        if (test86MSByte(buf[(i + 4) - MASK_TO_BIT_NUMBER[this.prevMask]]) == false) goto L18;
    L33:
        i = i + 1;
        goto L3
    L34:
        int prevPos3 = i - prevPos;
        if ((prevPos3 & (-4)) != 0) goto L38;
        r3 = this.prevMask << (prevPos3 - 1);
    L38:
        this.prevMask = r3;
        int i2 = i - off;
        this.pos += i2;
        return i2;
    }
}
