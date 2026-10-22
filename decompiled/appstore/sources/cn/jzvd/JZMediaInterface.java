package cn.jzvd;

import android.view.Surface;

/* JADX INFO: loaded from: classes.dex */
public abstract class JZMediaInterface {
    public JZDataSource jzDataSource;

    public JZMediaInterface() {
    }

    public abstract long getCurrentPosition();

    public abstract long getDuration();

    public abstract boolean isPlaying();

    public abstract void pause();

    public abstract void prepare();

    public abstract void release();

    public abstract void seekTo(long r10);

    public abstract void setLooping(boolean r10);

    public abstract void setSpeed(float r10);

    public abstract void setSurface(Surface r10);

    public abstract void setVolume(float r10, float r11);

    public abstract void start();
}
