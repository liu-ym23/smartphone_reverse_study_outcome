package fg;

import com.ttnet.org.chromium.net.PrivateKeyType;

/* JADX INFO: loaded from: classes4.dex */
public abstract class c {
    public static final boolean a(byte[] r10, int r11, byte[] r12, int r13, int r14) {
        kotlin.jvm.internal.q.h(r10, "a");
        kotlin.jvm.internal.q.h(r12, "b");
        int r15 = 0;
    L3:
        if (r15 >= r14) goto L8;
        if (r10[r15 + r11] != r12[r15 + r13]) goto L6;
        r15 = r15 + 1;
        goto L3
    L6:
        return false;
    L8:
        return true;
    }

    public static final void b(long r10, long r11, long r12) {
        if ((r11 | r12) < 0) goto L10;
        if (r11 > r10) goto L10;
        if ((r10 - r11) < r12) goto L10;
        return;
    L10:
        throw new ArrayIndexOutOfBoundsException("size=" + r10 + " offset=" + r11 + " byteCount=" + r12);
    }

    public static final int c(int r10) {
        int r11 = ((((-16777216) & r10) >>> 24) | ((16711680 & r10) >>> 8)) | ((65280 & r10) << 8);
        return ((r10 & PrivateKeyType.INVALID) << 24) | r11;
    }

    public static final long d(long r10) {
        long r11 = ((((((((-72057594037927936L) & r10) >>> 56) | ((71776119061217280L & r10) >>> 40)) | ((280375465082880L & r10) >>> 24)) | ((1095216660480L & r10) >>> 8)) | ((4278190080L & r10) << 8)) | ((16711680 & r10) << 24)) | ((65280 & r10) << 40);
        return ((r10 & 255) << 56) | r11;
    }

    public static final short e(short r10) {
        int r11 = (65280 & r10) >>> 8;
        return (short) (((r10 & 255) << 8) | r11);
    }
}
