package com.bytedance.android.livehostapi.business.depend.ad;

import android.view.TextureView;
import android.view.View;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes7.dex */
public interface IAdVideoView {
    public static final int END = 8;
    public static final int ERROR = 7;
    public static final int IDLE = 0;
    public static final int INITAILIZED = 1;
    public static final int PAUSED = 5;
    public static final int PREPARED = 3;
    public static final int PREPARING = 2;
    public static final int STARTED = 4;
    public static final int STOPPED = 6;
    public static final int UNAVAILABLE = -1;

    public interface OnSizeChangedListener {
        void onSizeChanged(int r100, int r101, int r102, int r103);
    }

    public interface StateListener {
        void onEachPlayEnd();

        void onPausePlay();

        void onRelease();

        void onRender();

        void onStartPlay();
    }

    long getCurrentId();

    int getState();

    View getView();

    void init();

    boolean isPlaying();

    void pausePlay();

    void release();

    void releaseEffecttivePlayCheck();

    void removePlayListener();

    void resize(int r100, int r101);

    void resumePlay();

    void sendPlayBreakStats();

    void setData(JSONObject r100);

    void setOnSizeChangeListener(OnSizeChangedListener r100);

    void setStateListener(StateListener r100);

    void setTextureView(TextureView r100);

    void tryPlay();
}
