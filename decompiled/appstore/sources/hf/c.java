package hf;

import android.content.Context;
import android.media.MediaPlayer;
import android.media.PlaybackParams;
import android.net.Uri;
import android.text.TextUtils;
import android.view.Surface;
import java.io.FileDescriptor;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public class c extends d implements MediaPlayer.OnPreparedListener, MediaPlayer.OnBufferingUpdateListener, MediaPlayer.OnErrorListener, MediaPlayer.OnInfoListener, MediaPlayer.OnVideoSizeChangedListener, MediaPlayer.OnSeekCompleteListener, MediaPlayer.OnCompletionListener {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Context f20456k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public MediaPlayer f20457l;

    public c(Context r10, gf.a r11) {
        super(r10, r11);
        this.f20457l = null;
        this.f20456k = r10.getApplicationContext();
        MediaPlayer r12 = new MediaPlayer();
        this.f20457l = r12;
        r12.setAudioStreamType(3);
        this.f20457l.setOnCompletionListener(this);
        this.f20457l.setOnErrorListener(this);
        this.f20457l.setOnInfoListener(this);
        this.f20457l.setOnPreparedListener(this);
        this.f20457l.setOnSeekCompleteListener(this);
        this.f20457l.setOnVideoSizeChangedListener(this);
        this.f20457l.setOnBufferingUpdateListener(this);
    }

    @Override // hf.d, com.stone.playersdk.IPlayer
    public long getCurrentPosition() {
        return this.f20457l.getCurrentPosition();
    }

    @Override // hf.d, com.stone.playersdk.IPlayer
    public long getDuration() {
        return this.f20457l.getDuration();
    }

    @Override // hf.d, com.stone.playersdk.IPlayer
    public boolean isPlaying() {
        return this.f20457l.isPlaying();
    }

    @Override // android.media.MediaPlayer.OnBufferingUpdateListener
    public void onBufferingUpdate(MediaPlayer r10, int r11) {
    }

    @Override // android.media.MediaPlayer.OnCompletionListener
    public void onCompletion(MediaPlayer r10) {
    }

    @Override // android.media.MediaPlayer.OnErrorListener
    public boolean onError(MediaPlayer r10, int r11, int r12) {
        a(r11, Integer.toString(r12));
        return true;
    }

    @Override // android.media.MediaPlayer.OnInfoListener
    public boolean onInfo(MediaPlayer r10, int r11, int r12) {
        return false;
    }

    @Override // android.media.MediaPlayer.OnPreparedListener
    public void onPrepared(MediaPlayer r10) {
        b();
    }

    @Override // android.media.MediaPlayer.OnSeekCompleteListener
    public void onSeekComplete(MediaPlayer r10) {
    }

    @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
    public void onVideoSizeChanged(MediaPlayer r10, int r11, int r12) {
        c(r11, r12, 0, 1.0f, 1.0f);
    }

    @Override // hf.d, com.stone.playersdk.IPlayer
    public void pause() {
        this.f20457l.pause();
    }

    @Override // hf.d, com.stone.playersdk.IPlayer
    public void prepareAsync() {
        this.f20457l.prepareAsync();
    }

    @Override // hf.d, com.stone.playersdk.IPlayer
    public void release() {
        this.f20457l.release();
    }

    @Override // hf.d, com.stone.playersdk.IPlayer
    public void seekTo(long r10) {
        this.f20457l.seekTo((int) r10);
    }

    @Override // hf.d, com.stone.playersdk.IPlayer
    public void setDataSource(String r10) {
        Uri r11 = Uri.parse(r10);
        this.f20464g = r11.getPath();
        String r12 = r11.getScheme();
        if (TextUtils.isEmpty(r12) == false) goto L5;
    L7:
        this.f20457l.setDataSource(r10);
        return;
    L5:
        if (r12.equalsIgnoreCase("file") == false) goto L7;
        this.f20457l.setDataSource(r11.getPath());
    }

    @Override // hf.d, com.stone.playersdk.IPlayer
    public void setSpeed(float r10) {
        PlaybackParams r11 = new PlaybackParams();
        r11.setSpeed(r10);
        this.f20457l.setPlaybackParams(r11);
    }

    @Override // hf.d, com.stone.playersdk.IPlayer
    public void setSurface(Surface r10) {
        this.f20457l.setSurface(r10);
    }

    @Override // hf.d, com.stone.playersdk.IPlayer
    public void setVolume(float r10, float r11) {
        this.f20457l.setVolume(r10, r11);
    }

    @Override // hf.d, com.stone.playersdk.IPlayer
    public void start() {
        this.f20457l.start();
    }

    @Override // hf.d, com.stone.playersdk.IPlayer
    public void stop() {
        this.f20457l.stop();
    }

    @Override // hf.d, com.stone.playersdk.IPlayer
    public void setDataSource(FileDescriptor r10, long r11, long r12) {
        this.f20457l.setDataSource(r10, r11, r12);
    }

    @Override // hf.d, com.stone.playersdk.IPlayer
    public void setDataSource(FileDescriptor r10) {
        this.f20457l.setDataSource(r10);
    }

    @Override // hf.d, com.stone.playersdk.IPlayer
    public void setDataSource(Context r10, Uri r11) {
        this.f20464g = r11.getPath();
        this.f20457l.setDataSource(r10, r11);
    }

    @Override // hf.d, com.stone.playersdk.IPlayer
    public void setDataSource(Context r10, Uri r11, Map r12) {
        this.f20464g = r11.getPath();
        this.f20457l.setDataSource(r10, r11, r12);
    }
}
