package com.byted.cast.mediacommon.utils;

import com.baidu.mapapi.UIMsg;
import java.nio.charset.StandardCharsets;
import kotlin.UByte;
import kotlin.jvm.internal.ByteCompanionObject;

/* JADX INFO: loaded from: classes39.dex */
public final class SeiNalBuilder {
    private static final byte[] START_CODE = null;
    private static final String TAG = "SeiNalBuilder";
    private static final byte[] UUID_ISO_IEC_11578 = null;

    private SeiNalBuilder() {
    }

    static {
        UUID_ISO_IEC_11578 = new byte[]{109, -89, 53, -66, 103, 90, 72, 1, -86, 89, 63, -92, -62, -57, 19, 84};
        START_CODE = new byte[]{0, 0, 0, 1};
    }

    private static byte[] escapeEmulationPrevention(byte[] r110) {
        int r100 = r110.length;
        int r101 = 0;
        int r102 = 0;
        int r103 = 0;
    L4:
        if (r101 >= r100) goto L14;
        byte r104 = r110[r101];
        if (r103 >= 2) goto L8;
    L10:
        if (r104 != 0) goto L12;
        r103 = r103 + 1;
    L13:
        r101 = r101 + 1;
        goto L4
    L12:
        r103 = 0;
        goto L13
    L8:
        if ((r104 & UByte.MAX_VALUE) > 3) goto L10;
        r102 = r102 + 1;
        r103 = 0;
        goto L10
    L14:
        if (r102 != 0) goto L16;
        return r110;
    L16:
        byte[] r105 = new byte[r110.length + r102];
        int r106 = r110.length;
        int r107 = 0;
        int r108 = 0;
        int r109 = 0;
    L17:
        if (r107 >= r106) goto L28;
        byte r111 = r110[r107];
        if (r108 >= 2) goto L21;
    L23:
        int r112 = r109 + 1;
        r105[r109] = r111;
        if (r111 != 0) goto L26;
        r108 = r108 + 1;
    L27:
        r107 = r107 + 1;
        r109 = r112;
        goto L17
    L26:
        r108 = 0;
        goto L27
    L21:
        if ((r111 & UByte.MAX_VALUE) > 3) goto L23;
        r105[r109] = 3;
        r109 = r109 + 1;
        r108 = 0;
        goto L23
    L28:
        return r105;
    }

    private static byte[] buildUserDataUnregisteredRbsp(byte[] r100, boolean r101) {
        byte[] r102 = encodeTypeAndSize(5, r100.length + 16);
        byte[] r103 = new byte[(r102.length + 16) + r100.length];
        System.arraycopy(r102, 0, r103, 0, r102.length);
        int r104 = r102.length + 0;
        System.arraycopy(UUID_ISO_IEC_11578, 0, r103, r104, 16);
        System.arraycopy(r100, 0, r103, r104 + 16, r100.length);
        return r103;
    }

    private static byte[] encodeTypeAndSize(int r100, int r101) {
        byte[] r102 = new byte[((r100 / 255) + 1) + ((r101 / 255) + 1)];
        int r103 = 0;
    L4:
        if (r100 < 255) goto L6;
        r102[r103] = -1;
        r100 = r100 + UIMsg.m_AppUI.V_WM_ADDLISTUPDATE;
        r103 = r103 + 1;
        goto L4
    L6:
        int r104 = r103 + 1;
        r102[r103] = (byte) r100;
    L7:
        if (r101 < 255) goto L9;
        r102[r104] = -1;
        r101 = r101 + UIMsg.m_AppUI.V_WM_ADDLISTUPDATE;
        r104 = r104 + 1;
        goto L7
    L9:
        r102[r104] = (byte) r101;
        return r102;
    }

    public static byte[] prepend(byte[] r100, String r101, boolean r110) {
        if (r100 == null) goto L17;
        if (r101 == null) goto L17;
        if (r101.isEmpty() == true) goto L17;
        byte[] r102 = r101.getBytes(StandardCharsets.UTF_8);
        byte[] r103 = escapeEmulationPrevention(buildUserDataUnregisteredRbsp(r102, r110));
        if (r110 == false) goto L10;
        int r104 = 2;
    L11:
        byte[] r105 = START_CODE;
        int r106 = ((r105.length + r104) + r103.length) + 1;
        byte[] r107 = new byte[r100.length + r106];
        System.arraycopy(r105, 0, r107, 0, r105.length);
        int r108 = r105.length + 0;
        if (r110 == false) goto L14;
        int r109 = r108 + 1;
        r107[r108] = 78;
        int r111 = r109 + 1;
        r107[r109] = 1;
    L15:
        System.arraycopy(r103, 0, r107, r111, r103.length);
        int r112 = r111 + r103.length;
        r107[r112] = ByteCompanionObject.MIN_VALUE;
        System.arraycopy(r100, 0, r107, r112 + 1, r100.length);
        Logger.i(TAG, "prepend sei nalu: hevc=" + r110 + " seiLen=" + r102.length + " naluLen=" + r106 + " encodedLen=" + r100.length);
        return r107;
    L14:
        r107[r108] = 6;
        r111 = r108 + 1;
        goto L15
    L10:
        r104 = 1;
    L17:
        return r100;
    }
}
