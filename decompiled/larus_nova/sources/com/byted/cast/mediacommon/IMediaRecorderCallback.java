package com.byted.cast.mediacommon;

/* JADX INFO: loaded from: classes39.dex */
public interface IMediaRecorderCallback {
    void onAudioEncoder(String r100, int r101, int r102, int r103, int r104);

    void onAudioFrameAvailable(byte[] r100, int r101, MediaSetting.ACODEC_ID r102, long r103);

    void onAudioPcm(byte[] r100, int r101, int r102, int r103, int r104, long r105);

    void onAudioRecordFailed(int r100);

    void onFocusChanged(int r100);

    void onPaused();

    void onResumed();

    void onStopped();

    void onVideoEncoder(String r100, int r101, int r102, int r103, int r104, boolean r105, int r106);

    void onVideoFrameAvailable(byte[] r100, int r101, int r102, int r103, MediaSetting.VideoFormat r104, long r105, int r106, int r107);

    void onVideoFrameCodec(byte[] r100, int r101, int r102, int r103, MediaSetting.VideoFormat r104, long r105, int r106);

    void onVideoFrameStatistic(double r100, long r101, long r102);

    void onVideoRecordError(int r100, String r101);
}
