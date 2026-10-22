package hf;

import android.content.Context;
import android.net.Uri;
import android.view.Surface;
import java.io.FileDescriptor;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public class a extends d {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Context f20455k;

    public a(Context r10, gf.a r11) {
        super(r10, r11);
        this.f20455k = r10;
    }

    @Override // hf.d, com.stone.playersdk.IPlayer
    public long getCurrentPosition() {
        return super.getCurrentPosition();
    }

    @Override // hf.d, com.stone.playersdk.IPlayer
    public long getDuration() {
        return super.getDuration();
    }

    @Override // hf.d, com.stone.playersdk.IPlayer
    public boolean isPlaying() {
        return super.isPlaying();
    }

    @Override // hf.d, com.stone.playersdk.IPlayer
    public void pause() {
        super.pause();
    }

    @Override // hf.d, com.stone.playersdk.IPlayer
    public void prepareAsync() {
        super.prepareAsync();
    }

    @Override // hf.d, com.stone.playersdk.IPlayer
    public void release() {
        super.release();
    }

    @Override // hf.d, com.stone.playersdk.IPlayer
    public void seekTo(long r10) {
        super.seekTo(r10);
    }

    @Override // hf.d, com.stone.playersdk.IPlayer
    public void setDataSource(Context r10, Uri r11) {
        super.setDataSource(r10, r11);
    }

    @Override // hf.d, com.stone.playersdk.IPlayer
    public void setSpeed(float r10) {
        super.setSpeed(r10);
    }

    @Override // hf.d, com.stone.playersdk.IPlayer
    public void setSurface(Surface r10) {
        super.setSurface(r10);
    }

    @Override // hf.d, com.stone.playersdk.IPlayer
    public void setVolume(float r10, float r11) {
        super.setVolume(r10, r11);
    }

    @Override // hf.d, com.stone.playersdk.IPlayer
    public void start() {
        super.start();
    }

    @Override // hf.d, com.stone.playersdk.IPlayer
    public void stop() {
        super.stop();
    }

    @Override // hf.d, com.stone.playersdk.IPlayer
    public void setDataSource(String r10) {
        super.setDataSource(r10);
    }

    @Override // hf.d, com.stone.playersdk.IPlayer
    public void setDataSource(Context r10, Uri r11, Map r12) {
        super.setDataSource(r10, r11, r12);
    }

    @Override // hf.d, com.stone.playersdk.IPlayer
    public void setDataSource(FileDescriptor r10) {
        super.setDataSource(r10);
    }

    @Override // hf.d, com.stone.playersdk.IPlayer
    public void setDataSource(FileDescriptor r10, long r11, long r12) {
        super.setDataSource(r10, r11, r12);
    }
}
