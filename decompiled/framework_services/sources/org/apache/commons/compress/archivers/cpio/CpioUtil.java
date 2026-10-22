package org.apache.commons.compress.archivers.cpio;

import android.hardware.tv.hdmi.cec.CecDeviceType;

/* JADX INFO: loaded from: classes3.dex */
class CpioUtil {
    CpioUtil() {
    }

    static long fileType(long mode) {
        return 61440 & mode;
    }

    static long byteArray2long(byte[] number, boolean swapHalfWord) {
        if ((number.length % 2) != 0) goto L16;
        byte[] tmp_number = new byte[number.length];
        System.arraycopy(number, 0, tmp_number, 0, number.length);
        if (swapHalfWord == true) goto L10;
        int pos = 0;
    L8:
        if (pos >= tmp_number.length) goto L10;
        byte tmp = tmp_number[pos];
        int pos2 = pos + 1;
        tmp_number[pos] = tmp_number[pos2];
        tmp_number[pos2] = tmp;
        pos = pos2 + 1;
    L10:
        byte tmp2 = tmp_number[0];
        long ret = tmp2 & CecDeviceType.INACTIVE;
        int pos3 = 1;
    L12:
        if (pos3 >= tmp_number.length) goto L14;
        ret = (ret << 8) | ((long) (tmp_number[pos3] & CecDeviceType.INACTIVE));
        pos3 = pos3 + 1;
        goto L12
    L14:
        return ret;
    L16:
        throw new UnsupportedOperationException();
    }

    static byte[] long2byteArray(long number, int length, boolean swapHalfWord) {
        byte[] ret = new byte[length];
        if ((length % 2) != 0) goto L15;
        if (length < 2) goto L15;
        long tmp_number = number;
        int pos = length - 1;
    L7:
        if (pos < 0) goto L9;
        ret[pos] = (byte) (255 & tmp_number);
        tmp_number = tmp_number >> 8;
        pos = pos - 1;
        goto L7
    L9:
        if (swapHalfWord == true) goto L13;
        int pos2 = 0;
    L11:
        if (pos2 >= length) goto L13;
        byte tmp = ret[pos2];
        int pos3 = pos2 + 1;
        ret[pos2] = ret[pos3];
        ret[pos3] = tmp;
        pos2 = pos3 + 1;
    L13:
        return ret;
    L15:
        throw new UnsupportedOperationException();
    }
}
