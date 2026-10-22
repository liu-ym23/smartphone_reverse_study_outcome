package com.byted.cast.common.api;

import com.byted.cast.common.bean.DanmakuBean;
import com.byted.cast.common.bean.DramaBean;
import com.byted.cast.common.bean.Resolution;
import com.byted.cast.common.bean.Speed;
import com.byted.cast.common.sink.CastInfo;

/* JADX INFO: loaded from: classes39.dex */
public interface IMediaServiceListener {
    public static final String COMPLETED = "COMPLETED";
    public static final String LOADING = "LOADING";
    public static final String NO_MEDIA_PRESENT = "NO_MEDIA_PRESENT";
    public static final String PAUSED_PLAYBACK = "PAUSED_PLAYBACK";
    public static final String PLAYING = "PLAYING";
    public static final String STOPPED = "STOPPED";

    /* JADX INFO: renamed from: com.byted.cast.common.api.IMediaServiceListener$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static String $default$getDramaId(IMediaServiceListener r100, String r101) {
            return "";
        }

        public static DramaBean[] $default$getDramaList(IMediaServiceListener r100, String r101) {
            return null;
        }

        public static String $default$getMediaInfo(IMediaServiceListener r100, String r101) {
            return "";
        }

        public static int $default$getVolume(IMediaServiceListener r100, String r101) {
            return -1;
        }

        public static void $default$onAddDramaList(IMediaServiceListener r100, String r101, DramaBean[] r102, String r103) {
        }

        public static void $default$onAddVolume(IMediaServiceListener r100, String r101) {
        }

        public static void $default$onClearDramaList(IMediaServiceListener r100, String r101) {
        }

        public static void $default$onDanmakuSetting(IMediaServiceListener r100, String r101, DanmakuBean r102) {
        }

        public static void $default$onError(IMediaServiceListener r100, String r101, int r102, String r103) {
        }

        public static void $default$onPlayDramaId(IMediaServiceListener r100, String r101, String r102) {
        }

        public static void $default$onPlayNextDrama(IMediaServiceListener r100, String r101) {
        }

        public static void $default$onPlayPreDrama(IMediaServiceListener r100, String r101) {
        }

        public static void $default$onRepeatMode(IMediaServiceListener r100, String r101, int r102) {
        }

        public static void $default$onResolution(IMediaServiceListener r100, String r101, Resolution r102) {
        }

        public static void $default$onSetDramaList(IMediaServiceListener r100, String r101, DramaBean[] r102) {
        }

        public static void $default$onSetUrlSuccess(IMediaServiceListener r100, CastInfo r101) {
        }

        public static void $default$onSpeed(IMediaServiceListener r100, String r101, Speed r102) {
        }

        public static void $default$onSubVolume(IMediaServiceListener r100, String r101) {
        }
    }

    int getCurrentPosition(String r100);

    String getDramaId(String r100);

    DramaBean[] getDramaList(String r100);

    int getDuration(String r100);

    String getMediaInfo(String r100);

    String getPlayState(String r100);

    int getVolume(String r100);

    void onAddDramaList(String r100, DramaBean[] r101, String r102);

    void onAddVolume(String r100);

    void onClearDramaList(String r100);

    void onDanmakuSetting(String r100, DanmakuBean r101);

    void onError(String r100, int r101, String r102);

    void onPause(String r100);

    void onPlay(String r100, float r101);

    void onPlayDramaId(String r100, String r101);

    void onPlayNextDrama(String r100);

    void onPlayPreDrama(String r100);

    void onRepeatMode(String r100, int r101);

    void onResolution(String r100, Resolution r101);

    void onSeek(String r100, long r101, int r102);

    void onSetDramaList(String r100, DramaBean[] r101);

    void onSetUrlSuccess(CastInfo r100);

    void onSpeed(String r100, float r101);

    void onSpeed(String r100, Speed r101);

    void onStop(String r100);

    void onSubVolume(String r100);

    void onVolume(String r100, int r101);
}
