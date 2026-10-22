package com.byted.cast.common.api;

import com.byted.cast.common.bean.DramaBean;
import com.byted.cast.common.sink.CastInfo;

/* JADX INFO: loaded from: classes39.dex */
public interface IActionListener {

    /* JADX INFO: renamed from: com.byted.cast.common.api.IActionListener$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static void $default$onAddDramaList(IActionListener r100, DramaBean[] r101, String r102) {
        }

        public static void $default$onAddVolume(IActionListener r100) {
        }

        public static void $default$onClearDramaList(IActionListener r100) {
        }

        public static void $default$onPlayDramaId(IActionListener r100, String r101) {
        }

        public static void $default$onPlayNextDrama(IActionListener r100) {
        }

        public static void $default$onPlayPreDrama(IActionListener r100) {
        }

        public static void $default$onRepeatMode(IActionListener r100, int r101) {
        }

        public static void $default$onSetDramaList(IActionListener r100, DramaBean[] r101) {
        }

        public static void $default$onSpeed(IActionListener r100, float r101) {
        }

        public static void $default$onSubVolume(IActionListener r100) {
        }
    }

    void onAddDramaList(DramaBean[] r100, String r101);

    void onAddVolume();

    void onClearDramaList();

    void onPause();

    void onPlay(float r100);

    void onPlayDramaId(String r100);

    void onPlayNextDrama();

    void onPlayPreDrama();

    void onRepeatMode(int r100);

    void onSeek(long r100, int r101);

    void onSetDramaList(DramaBean[] r100);

    void onSetUrlSuccess(CastInfo r100);

    void onSpeed(float r100);

    void onStop();

    void onSubVolume();

    void onVolume(int r100);
}
