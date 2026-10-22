package com.bytedance.android.livesdk.utils.ntp;

import java.util.Arrays;

/* JADX INFO: loaded from: classes11.dex */
public final class SntpClient {

    public static class InvalidServerReplyException extends Exception {
        public InvalidServerReplyException(String r100) {
            super(r100);
        }
    }

    public static long b(byte[] r100, int r101) {
        int r102 = r100[r101];
        int r103 = r100[r101 + 1];
        int r104 = r100[r101 + 2];
        int r105 = r100[r101 + 3];
        if ((r102 & 128) != 128) goto L6;
        r102 = (r102 & 127) + 128;
    L6:
        if ((r103 & 128) != 128) goto L9;
        r103 = (r103 & 127) + 128;
    L9:
        if ((r104 & 128) != 128) goto L12;
        r104 = (r104 & 127) + 128;
    L12:
        if ((r105 & 128) != 128) goto L15;
        r105 = (r105 & 127) + 128;
    L15:
        return (((((long) r102) << 24) + (((long) r103) << 16)) + (((long) r104) << 8)) + ((long) r105);
    }

    public static long c(byte[] r100, int r101) {
        long r102 = b(r100, r101);
        long r103 = b(r100, r101 + 4);
        if (r102 != 0) goto L8;
        if (r103 != 0) goto L8;
        return 0;
    L8:
        return ((r102 - 2208988800L) * 1000) + ((r103 * 1000) / 4294967296L);
    }

    public static void d(byte[] r110, long r111) {
        if (r111 != 0) goto L6;
        Arrays.fill(r110, 40, 48, (byte) 0);
        return;
    L6:
        long r100 = r111 / 1000;
        long r112 = r111 - (r100 * 1000);
        long r101 = r100 + 2208988800L;
        r110[40] = (byte) (r101 >> 24);
        r110[41] = (byte) (r101 >> 16);
        r110[42] = (byte) (r101 >> 8);
        r110[43] = (byte) (r101 >> 0);
        long r113 = (r112 * 4294967296L) / 1000;
        r110[44] = (byte) (r113 >> 24);
        r110[45] = (byte) (r113 >> 16);
        r110[46] = (byte) (r113 >> 8);
        r110[47] = (byte) (Math.random() * 255.0d);
    }

    public static void a(byte r100, byte r101, int r102, long r103) throws InvalidServerReplyException {
        if (r100 == 3) goto L22;
        if (r101 != 4) goto L7;
    L11:
        if (r102 == 0) goto L20;
        if (r102 > 15) goto L20;
        if (r103 == 0) goto L18;
        return;
    L18:
        throw new InvalidServerReplyException("zero transmitTime");
    L20:
        throw new InvalidServerReplyException("untrusted stratum: " + r102);
    L7:
        if (r101 == 5) goto L11;
        throw new InvalidServerReplyException("untrusted mode: " + r101);
    L22:
        throw new InvalidServerReplyException("unsynchronized server");
    }
}
