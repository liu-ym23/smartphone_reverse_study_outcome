package com.bytedance.android.livehostapi.foundation.depend;

import android.view.Surface;

/* JADX INFO: loaded from: classes7.dex */
public interface IExoPlayer {

    public interface PlayerListener {
        void onCompletion();

        void onError(String r100);

        void onFirstFrame();

        void onPrepared();
    }

    int getVideoHeight();

    int getVideoWidth();

    void pause();

    void prepareAsync();

    void release();

    void reset();

    void setDataSource(String r100);

    void setLooping(boolean r100);

    void setScreenOnWhilePlaying(boolean r100);

    void setSurface(Surface r100);

    void start();

    void stop();
}
