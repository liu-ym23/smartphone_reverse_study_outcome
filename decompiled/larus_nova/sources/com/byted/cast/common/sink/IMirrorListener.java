package com.byted.cast.common.sink;

import com.byted.cast.common.api.CodecType;
import java.util.HashMap;

/* JADX INFO: loaded from: classes39.dex */
public interface IMirrorListener {
    public static final int ERROR_CODE_BYTELINK_SERVER_MEDIARENDER_DECODE = 10011002;
    public static final int ERROR_CODE_BYTELINK_SERVER_MEDIARENDER_INIT = 10011001;
    public static final int ERROR_CODE_BYTELINK_SERVER_MEDIARENDER_RENDER = 10011004;
    public static final int ERROR_CODE_BYTELINK_SERVER_MEDIARENDER_SURFACE = 10011003;
    public static final String ERROR_MSG_BYTELINK_SERVER_MEDIARENDER_DECODE = "bytelink server error due to media-render decode failed";
    public static final String ERROR_MSG_BYTELINK_SERVER_MEDIARENDER_INIT = "bytelink server error due to media-render int failed";
    public static final String ERROR_MSG_BYTELINK_SERVER_MEDIARENDER_RENDER = "bytelink server error due to media-render render failed";
    public static final String ERROR_MSG_BYTELINK_SERVER_MEDIARENDER_SURFACE = "bytelink server error due to media-render surface failed";

    void onAudioOutput(String r100, CodecType.ACODEC_ID r101, byte[] r102, int r103, int r104, int r105, int r106, long r107);

    void onCast(int r100, CastInfo r101);

    void onError(String r100, int r101, String r102);

    void onInviteResult(boolean r100);

    void onNotifyLatency(String r100, Long r101, HashMap<String, Long> r102);

    void onSinkLatencyStat(int r100, String r101, String r102);

    void onSinkStuckStat(int r100, String r101, String r102);

    void onStatistics(Statistics r100);

    void onVideoOutput(String r100, CodecType.VCODEC_ID r101, byte[] r102, int r103, int r104, long r105, int r106);

    void onVolume(String r100, int r101);
}
