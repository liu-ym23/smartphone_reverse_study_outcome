package com.byted.cast.sdk.render.video;

import com.byted.cast.sdk.RTCSetting;

/* JADX INFO: loaded from: classes43.dex */
public class NAL {
    public static final int H265_NAL_TYPE_IDR_W_RADL = 19;
    public static final int H265_NAL_TYPE_SEI = 39;
    public static final int H265_NAL_TYPE_VPS = 32;
    public static final int NAL_TYPE_IDR = 5;
    public static final int NAL_TYPE_P = 1;
    public static final int NAL_TYPE_SEI = 6;
    public static final int NAL_TYPE_SPS = 7;
    private static final String TAG = "NAL";
    public byte[] buf;
    public long frameIndex;
    public int length;
    public int type;
    public RTCSetting.VCODEC_ID vCodecId;

    public static int detectNALType(NAL r100) {
        RTCSetting.VCODEC_ID r101 = r100.vCodecId;
        RTCSetting.VCODEC_ID r102 = RTCSetting.VCODEC_ID.H264;
        if (r101 != r102) goto L5;
        int r103 = r100.buf[4] & 31;
    L7:
        if (r101 != r102) goto L9;
        if (r103 != 7) goto L9;
    L13:
        r100.type = 7;
    L30:
        return r100.type;
    L9:
        RTCSetting.VCODEC_ID r104 = RTCSetting.VCODEC_ID.H265;
        if (r101 != r104) goto L15;
        if (r103 == 32) goto L13;
    L15:
        if (r101 != r102) goto L17;
        if (r103 != 5) goto L17;
    L20:
        r100.type = 5;
    L17:
        if (r101 != r104) goto L22;
        if (r103 == 19) goto L20;
    L22:
        if (r101 != r102) goto L24;
        if (r103 != 6) goto L24;
    L27:
        r100.type = 6;
    L24:
        if (r101 == r104) goto L26;
    L28:
        r100.type = 1;
        goto L30
    L26:
        if (r103 != 39) goto L28;
    L5:
        r103 = (r100.buf[4] >> 1) & 63;
        goto L7
    }

    public NAL(byte[] r100, int r101, RTCSetting.VCODEC_ID r102) {
        this.frameIndex = 0;
        this.buf = r100;
        this.length = r101;
        this.vCodecId = r102;
    }
}
