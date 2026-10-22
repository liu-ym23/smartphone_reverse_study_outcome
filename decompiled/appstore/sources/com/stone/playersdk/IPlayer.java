package com.stone.playersdk;

import android.content.Context;
import android.net.Uri;
import android.view.Surface;
import java.io.FileDescriptor;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public interface IPlayer {

    public interface OnErrorListener {
        void onError(IPlayer r10, int r11, String r12);
    }

    public interface OnLocalProxyCacheListener {
        void onCacheFinished(IPlayer r10);

        void onCacheForbidden(IPlayer r10, String r11);

        void onCacheProgressChanged(IPlayer r10, int r11, long r12);

        void onCacheReady(IPlayer r10, String r11);

        void onCacheSpeedChanged(IPlayer r10, float r11);
    }

    public interface OnPreparedListener {
        void onPrepared(IPlayer r10);
    }

    public interface OnVideoSizeChangedListener {
        void onVideoSizeChanged(IPlayer r10, int r11, int r12, int r13, float r14, float r15);
    }

    long getCurrentPosition();

    long getDuration();

    boolean isPlaying();

    void pause() throws IllegalStateException;

    void prepareAsync() throws IllegalStateException;

    void release();

    void seekTo(long r10) throws IllegalStateException;

    void setDataSource(Context r10, Uri r11) throws IOException, IllegalArgumentException, SecurityException, IllegalStateException;

    void setDataSource(Context r10, Uri r11, Map<String, String> r12) throws IOException, IllegalArgumentException, SecurityException, IllegalStateException;

    void setDataSource(FileDescriptor r10) throws IOException, IllegalArgumentException, IllegalStateException;

    void setDataSource(FileDescriptor r10, long r11, long r12) throws IOException, IllegalArgumentException, SecurityException, IllegalStateException;

    void setDataSource(String r10) throws IOException, IllegalArgumentException, SecurityException, IllegalStateException;

    void setOnErrorListener(OnErrorListener r10);

    void setOnLocalProxyCacheListener(OnLocalProxyCacheListener r10);

    void setOnPreparedListener(OnPreparedListener r10);

    void setOnVideoSizeChangedListener(OnVideoSizeChangedListener r10);

    void setOriginUrl(String r10);

    void setSpeed(float r10);

    void setSurface(Surface r10);

    void setVolume(float r10, float r11);

    void start() throws IllegalStateException;

    void startLocalProxy(String r10, HashMap<String, String> r11);

    void stop() throws IllegalStateException;
}
