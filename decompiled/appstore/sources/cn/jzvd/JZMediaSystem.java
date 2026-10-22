package cn.jzvd;

import android.media.MediaPlayer;
import android.view.Surface;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class JZMediaSystem extends JZMediaInterface implements MediaPlayer.OnPreparedListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnBufferingUpdateListener, MediaPlayer.OnSeekCompleteListener, MediaPlayer.OnErrorListener, MediaPlayer.OnInfoListener, MediaPlayer.OnVideoSizeChangedListener {
    public MediaPlayer mediaPlayer;

    public JZMediaSystem() {
    }

    @Override // cn.jzvd.JZMediaInterface
    public long getCurrentPosition() {
        MediaPlayer r10 = this.mediaPlayer;
        if (r10 != null) goto L5;
        return 0;
    L5:
        return r10.getCurrentPosition();
    }

    @Override // cn.jzvd.JZMediaInterface
    public long getDuration() {
        MediaPlayer r10 = this.mediaPlayer;
        if (r10 != null) goto L10;
    L8:
        return 0;
    L10:
        return r10.getDuration();
    L6:
        e = move-exception;
        e.printStackTrace();
        goto L8
    }

    @Override // cn.jzvd.JZMediaInterface
    public boolean isPlaying() {
        return this.mediaPlayer.isPlaying();
    }

    @Override // android.media.MediaPlayer.OnBufferingUpdateListener
    public void onBufferingUpdate(MediaPlayer r10, final int r11) {
        JZMediaManager.instance().mainThreadHandler.post(new AnonymousClass3(this, r11));
    }

    @Override // android.media.MediaPlayer.OnCompletionListener
    public void onCompletion(final MediaPlayer r10) {
        JZMediaManager.instance().mainThreadHandler.post(new AnonymousClass2(this, r10));
    }

    @Override // android.media.MediaPlayer.OnErrorListener
    public boolean onError(final MediaPlayer r10, final int r11, final int r12) {
        JZMediaManager.instance().mainThreadHandler.post(new AnonymousClass5(this, r10, r11, r12));
        return true;
    }

    @Override // android.media.MediaPlayer.OnInfoListener
    public boolean onInfo(final MediaPlayer r10, final int r11, final int r12) {
        JZMediaManager.instance().mainThreadHandler.post(new AnonymousClass6(this, r11, r10, r12));
        return false;
    }

    @Override // android.media.MediaPlayer.OnPreparedListener
    public void onPrepared(final MediaPlayer r10) {
        r10.start();
        JZDataSource r11 = this.jzDataSource;
        if (r11 != null) goto L5;
        return;
    L5:
        if (r11.getCurrentUrl().toString().toLowerCase().contains("mp3") == false) goto L7;
    L8:
        JZMediaManager.instance().mainThreadHandler.post(new AnonymousClass1(this, r10));
        return;
    L7:
        if (this.jzDataSource.getCurrentUrl().toString().toLowerCase().contains("wav") == true) goto L8;
    }

    @Override // android.media.MediaPlayer.OnSeekCompleteListener
    public void onSeekComplete(MediaPlayer r10) {
        JZMediaManager.instance().mainThreadHandler.post(new AnonymousClass4(this));
    }

    @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
    public void onVideoSizeChanged(MediaPlayer r10, int r11, int r12) {
        JZMediaManager.instance().currentVideoWidth = r11;
        JZMediaManager.instance().currentVideoHeight = r12;
        JZMediaManager.instance().mainThreadHandler.post(new AnonymousClass7(this));
    }

    @Override // cn.jzvd.JZMediaInterface
    public void pause() {
        this.mediaPlayer.pause();
    }

    @Override // cn.jzvd.JZMediaInterface
    public void prepare() {
        MediaPlayer r10 = new MediaPlayer();     // Catch: Exception -> L4
        this.mediaPlayer = r10;     // Catch: Exception -> L4
        r10.setAudioStreamType(3);     // Catch: Exception -> L4
        this.mediaPlayer.setLooping(this.jzDataSource.looping);     // Catch: Exception -> L4
        this.mediaPlayer.setOnPreparedListener(this);     // Catch: Exception -> L4
        this.mediaPlayer.setOnCompletionListener(this);     // Catch: Exception -> L4
        this.mediaPlayer.setOnBufferingUpdateListener(this);     // Catch: Exception -> L4
        this.mediaPlayer.setScreenOnWhilePlaying(true);     // Catch: Exception -> L4
        this.mediaPlayer.setOnSeekCompleteListener(this);     // Catch: Exception -> L4
        this.mediaPlayer.setOnErrorListener(this);     // Catch: Exception -> L4
        this.mediaPlayer.setOnInfoListener(this);     // Catch: Exception -> L4
        this.mediaPlayer.setOnVideoSizeChangedListener(this);     // Catch: Exception -> L4
        MediaPlayer.class.getDeclaredMethod("setDataSource", new Class[]{String.class, Map.class}).invoke(this.mediaPlayer, new Object[]{this.jzDataSource.getCurrentUrl().toString(), this.jzDataSource.headerMap});     // Catch: Exception -> L4
        this.mediaPlayer.prepareAsync();     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
    }

    @Override // cn.jzvd.JZMediaInterface
    public void release() {
        MediaPlayer r10 = this.mediaPlayer;
        if (r10 == null) goto L6;
        r10.release();
        return;
    }

    @Override // cn.jzvd.JZMediaInterface
    public void seekTo(long r10) {
        this.mediaPlayer.seekTo((int) r10);     // Catch: IllegalStateException -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
    }

    @Override // cn.jzvd.JZMediaInterface
    public void setLooping(boolean r10) {
        this.mediaPlayer.setLooping(r10);
    }

    @Override // cn.jzvd.JZMediaInterface
    public void setSpeed(float r10) {
    }

    @Override // cn.jzvd.JZMediaInterface
    public void setSurface(Surface r10) {
        this.mediaPlayer.setSurface(r10);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
    }

    @Override // cn.jzvd.JZMediaInterface
    public void setVolume(float r10, float r11) {
        this.mediaPlayer.setVolume(r10, r11);
    }

    @Override // cn.jzvd.JZMediaInterface
    public void start() {
        this.mediaPlayer.start();     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
    }
}
