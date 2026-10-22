package com.byted.cast.common.api;

import java.util.HashMap;

/* JADX INFO: loaded from: classes39.dex */
public interface ISinkDataListener {

    /* JADX INFO: renamed from: com.byted.cast.common.api.ISinkDataListener$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static void $default$onAudioOutput(ISinkDataListener r100, String r101, CodecType.ACODEC_ID r102, byte[] r103, int r104, int r105, int r106, int r107, long r108) {
        }

        public static void $default$onNotifyLatency(ISinkDataListener r100, String r101, Long r102, HashMap r103) {
        }

        public static void $default$onVideoOutput(ISinkDataListener r100, String r101, CodecType.VCODEC_ID r102, byte[] r103, int r104, int r105, long r106, int r107) {
        }

        public static void $default$onVideoRenderTimeInfo(ISinkDataListener r100, String r101, long r102, long r103) {
        }
    }

    void onAudioOutput(String r100, CodecType.ACODEC_ID r101, byte[] r102, int r103, int r104, int r105, int r106, long r107);

    void onNotifyLatency(String r100, Long r101, HashMap<String, Long> r102);

    void onVideoOutput(String r100, CodecType.VCODEC_ID r101, byte[] r102, int r103, int r104, long r105, int r106);

    void onVideoRenderTimeInfo(String r100, long r101, long r102);
}
