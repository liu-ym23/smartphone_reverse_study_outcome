package com.bytedance.android.livesdkapi.view;

import android.view.ViewGroup;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.android.livesdkapi.depend.model.live.StreamUrl;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Pair;

/* JADX INFO: loaded from: classes12.dex */
public interface ILivePlayerView {
    public static final int DECODE_ERROR = 2;
    public static final int DECODE_NONE = 0;
    public static final int DECODE_SUCCESS = 1;

    @Retention(RetentionPolicy.SOURCE)
    public @interface DecodeStatus {
    }

    public interface PlayerCallback {
        void onBufferingEnd();

        void onBufferingStart();

        void onError(String r100);

        void onInteractSeiUpdate(Object r100);

        void onMute(boolean r100);

        void onPlayComplete();

        void onPlayDisplayed();

        void onRoomFinish();

        void onVideoSizeChanged(int r100, int r101);
    }

    void attachParentView(ViewGroup r100);

    void detachParentView();

    Pair<Integer, Integer> getViewSize();

    boolean isMute();

    void onBackground();

    void onForeground();

    void release();

    void setDataSource(String r100, String r101, LiveMode r102);

    void setDefaultDataSource(StreamUrl r100, String r101, LiveMode r102);

    void setMute(boolean r100);

    void setPlayerCallback(PlayerCallback r100);

    boolean start();

    void stop(boolean r100);

    boolean tryResumePlay();
}
