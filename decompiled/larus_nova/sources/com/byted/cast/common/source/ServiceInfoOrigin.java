package com.byted.cast.common.source;

import android.text.TextUtils;
import java.util.BitSet;

/* JADX INFO: loaded from: classes39.dex */
public class ServiceInfoOrigin extends BitSet {
    public static int ORIGIN_FROM_BDLINK_BLE;
    public static int ORIGIN_FROM_BDLINK_NSD;
    public static int ORIGIN_FROM_BDLINK_SSDP;
    public static int ORIGIN_FROM_BYTELINK_BLE;
    public static int ORIGIN_FROM_BYTELINK_NSD;
    public static int ORIGIN_FROM_NONE;

    static {
        ORIGIN_FROM_BDLINK_NSD = 0 + 1;
        ORIGIN_FROM_BDLINK_BLE = 0 + 2;
        ORIGIN_FROM_BDLINK_SSDP = 0 + 3;
        ORIGIN_FROM_BYTELINK_NSD = 0 + 1;
        ORIGIN_FROM_BYTELINK_BLE = 0 + 2;
    }

    public ServiceInfoOrigin() {
    }

    private static int convertBrowseCodeToOriginBit(int r100, String r101) {
        int r102 = ORIGIN_FROM_NONE;
        if (TextUtils.equals(r101, "BDLink") == false) goto L14;
        if (r100 == 1) goto L24;
        if (r100 == 5) goto L23;
        if (r100 == 8) goto L22;
        return r102;
    L22:
        return ORIGIN_FROM_BDLINK_SSDP;
    L23:
        return ORIGIN_FROM_BDLINK_BLE;
    L24:
        return ORIGIN_FROM_BDLINK_NSD;
    L14:
        if (TextUtils.equals(r101, "ByteLink") == false) goto L25;
        if (r100 == 1) goto L21;
        if (r100 == 7) goto L26;
        return r102;
    L26:
        return ORIGIN_FROM_BYTELINK_BLE;
    L21:
        return ORIGIN_FROM_BYTELINK_NSD;
    L25:
        return r102;
    }

    public BitSet clearOriginBit(int r100, String r101) {
        if (isEmpty() == false) goto L5;
        return this;
    L5:
        int r102 = convertBrowseCodeToOriginBit(r100, r101);
        if (r102 != ORIGIN_FROM_NONE) goto L9;
        clear();
        return this;
    L9:
        clear(r102);
        return this;
    }

    public BitSet setOriginBit(int r100, String r101) {
        set(convertBrowseCodeToOriginBit(r100, r101));
        return this;
    }
}
