package com.bytedance.android.livesdk.chatroom.record;

import android.content.Context;
import android.media.ImageReader;
import android.net.Uri;
import android.os.Handler;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.ss.ttm.player.IMediaDataSource;
import com.ss.ttm.player.MediaPlayer;
import com.ss.ttm.player.MediaPlayerClient;
import com.ss.ttm.player.MediaTransport;
import com.ss.ttm.player.OSPlayerClient;
import com.ss.ttm.player.PlaybackParams;
import com.ss.ttm.player.TTAVWindowClient;
import com.ss.ttm.player.TTPlayerConfiger;
import com.ss.ttm.player.TraitObject;
import java.io.FileDescriptor;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes7.dex */
public final class x implements MediaPlayer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public MediaPlayerClient f108087a;

    @Override // com.ss.ttm.player.MediaPlayer
    public final /* synthetic */ void preDemux() {
        MediaPlayer.CC.$default$preDemux(this);
    }

    @Override // com.ss.ttm.player.MediaPlayer
    public final void selectTrack(int r100) {
    }

    @Override // com.ss.ttm.player.MediaPlayer
    public final void setDataSource(IMediaDataSource r100) throws IllegalArgumentException, IOException {
    }

    @Override // com.ss.ttm.player.MediaPlayer
    public final void setDataSource(FileDescriptor r100, long r101, long r102) throws IllegalStateException, IllegalArgumentException, IOException {
    }

    @Override // com.ss.ttm.player.MediaPlayer
    public final /* synthetic */ void setFloatOptionArray(int[] r100, float[] r101) {
        MediaPlayer.CC.$default$setFloatOptionArray(this, r100, r101);
    }

    @Override // com.ss.ttm.player.MediaPlayer
    public final /* synthetic */ void setIntOptionArray(int[] r100, int[] r101) {
        MediaPlayer.CC.$default$setIntOptionArray(this, r100, r101);
    }

    @Override // com.ss.ttm.player.MediaPlayer
    public final /* synthetic */ void setLongOptionArray(int[] r100, long[] r101) {
        MediaPlayer.CC.$default$setLongOptionArray(this, r100, r101);
    }

    @Override // com.ss.ttm.player.MediaPlayer
    public final void setMediaTransport(MediaTransport r100) {
    }

    @Override // com.ss.ttm.player.MediaPlayer
    public final /* synthetic */ void setOnImageAvailableListener(ImageReader.OnImageAvailableListener r100, Handler r101) {
        MediaPlayer.CC.$default$setOnImageAvailableListener(this, r100, r101);
    }

    @Override // com.ss.ttm.player.MediaPlayer
    public final void setOnSARChangedListener(MediaPlayer.onSARChangedListener r100) {
    }

    @Override // com.ss.ttm.player.MediaPlayer
    public final /* synthetic */ void setStringOptionArray(int[] r100, String[] r101) {
        MediaPlayer.CC.$default$setStringOptionArray(this, r100, r101);
    }

    @Override // com.ss.ttm.player.MediaPlayer
    public final /* synthetic */ void setSurfaceTimeOut(Surface r100, int r101) {
        MediaPlayer.CC.$default$setSurfaceTimeOut(this, r100, r101);
    }

    @Override // com.ss.ttm.player.MediaPlayer
    public final /* synthetic */ void setTraitObject(int r100, TraitObject r101) {
        MediaPlayer.CC.$default$setTraitObject(this, r100, r101);
    }

    @Override // com.ss.ttm.player.MediaPlayer
    public final /* synthetic */ void setWindowClient(TTAVWindowClient r100) {
        MediaPlayer.CC.$default$setWindowClient(this, r100);
    }

    @Override // com.ss.ttm.player.MediaPlayer
    public final void switchStream(int r100, int r101) {
    }

    @Override // com.ss.ttm.player.MediaPlayer
    public final int getCurrentPosition() {
        MediaPlayerClient r100 = this.f108087a;
        if (r100 != null) goto L5;
        return 0;
    L5:
        return r100.getCurrentPosition();
    }

    @Override // com.ss.ttm.player.MediaPlayer
    public final String getDataSource() {
        MediaPlayerClient r100 = this.f108087a;
        if (r100 != null) goto L5;
        return null;
    L5:
        return r100.getDataSource();
    }

    @Override // com.ss.ttm.player.MediaPlayer
    public final int getDuration() {
        MediaPlayerClient r100 = this.f108087a;
        if (r100 != null) goto L5;
        return 0;
    L5:
        return r100.getDuration();
    }

    @Override // com.ss.ttm.player.MediaPlayer
    public final int getPlayerType() {
        MediaPlayerClient r100 = this.f108087a;
        if (r100 != null) goto L5;
        return 0;
    L5:
        return r100.getType();
    }

    @Override // com.ss.ttm.player.MediaPlayer
    public final MediaPlayer.TrackInfo[] getTrackInfo() {
        MediaPlayerClient r100 = this.f108087a;
        if (r100 == null) goto L7;
        r100.getTrackInfo();
        return null;
    L7:
        return null;
    }

    @Override // com.ss.ttm.player.MediaPlayer
    public final int getVideoHeight() {
        MediaPlayerClient r100 = this.f108087a;
        if (r100 != null) goto L5;
        return 0;
    L5:
        return r100.getVideoHeight();
    }

    @Override // com.ss.ttm.player.MediaPlayer
    public final int getVideoType() {
        MediaPlayerClient r100 = this.f108087a;
        if (r100 != null) goto L5;
        return 0;
    L5:
        return r100.getVideoType();
    }

    @Override // com.ss.ttm.player.MediaPlayer
    public final int getVideoWidth() {
        MediaPlayerClient r100 = this.f108087a;
        if (r100 != null) goto L5;
        return 0;
    L5:
        return r100.getVideoWidth();
    }

    @Override // com.ss.ttm.player.MediaPlayer
    public final boolean isLooping() {
        MediaPlayerClient r100 = this.f108087a;
        if (r100 != null) goto L5;
        return false;
    L5:
        return r100.isLooping();
    }

    @Override // com.ss.ttm.player.MediaPlayer
    public final boolean isMute() {
        MediaPlayerClient r100 = this.f108087a;
        if (r100 != null) goto L5;
        return false;
    L5:
        return r100.isMute();
    }

    @Override // com.ss.ttm.player.MediaPlayer
    public final boolean isOSPlayer() {
        MediaPlayerClient r100 = this.f108087a;
        if (r100 != null) goto L5;
    L8:
        return true;
    L5:
        if (r100.getType() == 0) goto L8;
        return false;
    }

    @Override // com.ss.ttm.player.MediaPlayer
    public final boolean isPlaying() {
        MediaPlayerClient r100 = this.f108087a;
        if (r100 != null) goto L5;
        return false;
    L5:
        return r100.isPlaying();
    }

    @Override // com.ss.ttm.player.MediaPlayer
    public final void pause() {
        MediaPlayerClient r100 = this.f108087a;
        if (r100 == null) goto L6;
        r100.pause();
        return;
    }

    @Override // com.ss.ttm.player.MediaPlayer
    public final void prepare() {
        MediaPlayerClient r100 = this.f108087a;
        if (r100 == null) goto L6;
        r100.prepare();
        return;
    }

    @Override // com.ss.ttm.player.MediaPlayer
    public final void prepareAsync() {
        MediaPlayerClient r100 = this.f108087a;
        if (r100 == null) goto L6;
        r100.prepareAsync();
        return;
    }

    @Override // com.ss.ttm.player.MediaPlayer
    public final void prevClose() {
        MediaPlayerClient r100 = this.f108087a;
        if (r100 == null) goto L6;
        r100.prevClose();
        return;
    }

    @Override // com.ss.ttm.player.MediaPlayer
    public final void release() {
        MediaPlayerClient r100 = this.f108087a;
        if (r100 == null) goto L6;
        r100.release();
        return;
    }

    @Override // com.ss.ttm.player.MediaPlayer
    public final void releaseAsync() {
        MediaPlayerClient r100 = this.f108087a;
        if (r100 == null) goto L6;
        r100.releaseAsync();
        return;
    }

    @Override // com.ss.ttm.player.MediaPlayer
    public final void reset() {
        MediaPlayerClient r100 = this.f108087a;
        if (r100 == null) goto L6;
        r100.reset();
        return;
    }

    @Override // com.ss.ttm.player.MediaPlayer
    public final void start() {
        MediaPlayerClient r100 = this.f108087a;
        if (r100 == null) goto L6;
        r100.start();
        return;
    }

    @Override // com.ss.ttm.player.MediaPlayer
    public final void stop() {
        MediaPlayerClient r100 = this.f108087a;
        if (r100 == null) goto L6;
        r100.stop();
        return;
    }

    public x() {
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class a(String r100) throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r101 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r102 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class<?> r103 = Class.forName(r100);     // Catch: Throwable -> L8
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L8
    L7:
        return r103;
    L8:
        th = move-exception;
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b(r100);
    L12:
        throw th;
    L34:
        Class<?> r104 = Class.forName(r100);     // Catch: Throwable -> L17
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L17
    L16:
        return r104;
    L17:
        th = move-exception;
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b(r100);
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName(r100);
    }

    public static x b(Context r100) {
        TTPlayerConfiger.setValue(2, false);
        TTPlayerConfiger.setValue(1, true);
        TTPlayerConfiger.setValue(11, true);
        x r101 = new x();
        monitor-enter(x.class);
    L23:
        th = move-exception;
        throw th;
    L5:
        if (TTPlayerConfiger.isOnTTPlayer() == false) goto L19;
        Class r102 = a("com.ss.ttm.player.TTPlayerClient");     // Catch: Throwable -> L9
        Method r103 = r102.getDeclaredMethod("create", new Class[]{MediaPlayer.class, Context.class});     // Catch: Throwable -> L9
        r103.setAccessible(true);     // Catch: Throwable -> L9
        r101.f108087a = (MediaPlayerClient) r103.invoke(r102, new Object[]{r101, r100});     // Catch: Throwable -> L9
    L12:
        if (r101.f108087a != null) goto L19;
        Class r104 = a("com.ss.ttmplayer.player.TTPlayerClient");     // Catch: Throwable -> L16
        Method r105 = r104.getDeclaredMethod("create", new Class[]{MediaPlayer.class, Context.class});     // Catch: Throwable -> L16
        r105.setAccessible(true);     // Catch: Throwable -> L16
        r101.f108087a = (MediaPlayerClient) r105.invoke(r104, new Object[]{r101, r100});     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L23
        th.toString();     // Catch: Throwable -> L23
    L9:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L23
        th.toString();     // Catch: Throwable -> L23
    L19:
        if (r101.f108087a != null) goto L21;
        r101.f108087a = OSPlayerClient.create(r101, r100);     // Catch: Throwable -> L23
    L21:
        monitor-exit(x.class);     // Catch: Throwable -> L23
        return r101;
    }

    @Override // com.ss.ttm.player.MediaPlayer
    public final void deselectTrack(int r100) {
        MediaPlayerClient r101 = this.f108087a;
        if (r101 == null) goto L6;
        r101.deselectTrack(r100);
        return;
    }

    @Override // com.ss.ttm.player.MediaPlayer
    public final int getSelectedTrack(int r100) {
        MediaPlayerClient r101 = this.f108087a;
        if (r101 == null) goto L7;
        r101.getSelectedTrack(r100);
        return 0;
    L7:
        return 0;
    }

    @Override // com.ss.ttm.player.MediaPlayer
    public final String getStringOption(int r100) {
        MediaPlayerClient r101 = this.f108087a;
        if (r101 != null) goto L5;
        return null;
    L5:
        return r101.getStringOption(r100);
    }

    @Override // com.ss.ttm.player.MediaPlayer
    public final void seekTo(int r100) {
        MediaPlayerClient r101 = this.f108087a;
        if (r101 == null) goto L6;
        r101.seekTo(r100);
        return;
    }

    @Override // com.ss.ttm.player.MediaPlayer
    public final void setDataSource(String r100) throws IllegalArgumentException, SecurityException, IllegalStateException, IOException {
        MediaPlayerClient r101 = this.f108087a;
        if (r101 == null) goto L6;
        r101.setDataSource(r100);
        return;
    }

    @Override // com.ss.ttm.player.MediaPlayer
    public final void setDisplay(SurfaceHolder r100) {
        MediaPlayerClient r101 = this.f108087a;
        if (r101 == null) goto L6;
        r101.setDisplay(r100);
        return;
    }

    @Override // com.ss.ttm.player.MediaPlayer
    public final void setIsMute(boolean r100) {
        MediaPlayerClient r101 = this.f108087a;
        if (r101 == null) goto L6;
        r101.setIsMute(r100);
        return;
    }

    @Override // com.ss.ttm.player.MediaPlayer
    public final void setLooping(boolean r100) {
        MediaPlayerClient r101 = this.f108087a;
        if (r101 == null) goto L6;
        r101.setLooping(r100);
        return;
    }

    @Override // com.ss.ttm.player.MediaPlayer
    public final void setOnBufferingUpdateListener(MediaPlayer.OnBufferingUpdateListener r100) {
        MediaPlayerClient r101 = this.f108087a;
        if (r101 == null) goto L6;
        r101.setOnBufferingUpdateListener(r100);
        return;
    }

    @Override // com.ss.ttm.player.MediaPlayer
    public final void setOnCompletionListener(MediaPlayer.OnCompletionListener r100) {
        MediaPlayerClient r101 = this.f108087a;
        if (r101 == null) goto L6;
        r101.setOnCompletionListener(r100);
        return;
    }

    @Override // com.ss.ttm.player.MediaPlayer
    public final void setOnErrorListener(MediaPlayer.OnErrorListener r100) {
        MediaPlayerClient r101 = this.f108087a;
        if (r101 == null) goto L6;
        r101.setOnErrorListener(r100);
        return;
    }

    @Override // com.ss.ttm.player.MediaPlayer
    public final void setOnExternInfoListener(MediaPlayer.OnExternInfoListener r100) {
        MediaPlayerClient r101 = this.f108087a;
        if (r101 == null) goto L6;
        r101.setOnExternInfoListener(r100);
        return;
    }

    @Override // com.ss.ttm.player.MediaPlayer
    public final void setOnInfoListener(MediaPlayer.OnInfoListener r100) {
        MediaPlayerClient r101 = this.f108087a;
        if (r101 == null) goto L6;
        r101.setOnInfoListener(r100);
        return;
    }

    @Override // com.ss.ttm.player.MediaPlayer
    public final void setOnLogListener(MediaPlayer.OnLogListener r100) {
        MediaPlayerClient r101 = this.f108087a;
        if (r101 == null) goto L6;
        r101.setOnLogListener(r100);
        return;
    }

    @Override // com.ss.ttm.player.MediaPlayer
    public final void setOnPreparedListener(MediaPlayer.OnPreparedListener r100) {
        MediaPlayerClient r101 = this.f108087a;
        if (r101 == null) goto L6;
        r101.setOnPreparedListener(r100);
        return;
    }

    @Override // com.ss.ttm.player.MediaPlayer
    public final void setOnSeekCompleteListener(MediaPlayer.OnSeekCompleteListener r100) {
        MediaPlayerClient r101 = this.f108087a;
        if (r101 == null) goto L6;
        r101.setOnSeekCompleteListener(r100);
        return;
    }

    @Override // com.ss.ttm.player.MediaPlayer
    public final void setOnVideoSizeChangedListener(MediaPlayer.OnVideoSizeChangedListener r100) {
        MediaPlayerClient r101 = this.f108087a;
        if (r101 == null) goto L6;
        r101.setOnVideoSizeChangedListener(r100);
        return;
    }

    @Override // com.ss.ttm.player.MediaPlayer
    public final void setPanoVideoControlModel(int r100) {
        MediaPlayerClient r101 = this.f108087a;
        if (r101 == null) goto L6;
        r101.setPanoVideoControlModel(r100);
        return;
    }

    @Override // com.ss.ttm.player.MediaPlayer
    public final void setPlaybackParams(PlaybackParams r100) {
        MediaPlayerClient r101 = this.f108087a;
        if (r101 == null) goto L6;
        r101.setPlaybackParams(r100);
        return;
    }

    @Override // com.ss.ttm.player.MediaPlayer
    public final void setScreenOnWhilePlaying(boolean r100) {
        MediaPlayerClient r101 = this.f108087a;
        if (r101 == null) goto L6;
        r101.setScreenOnWhilePlaying(r100);
        return;
    }

    @Override // com.ss.ttm.player.MediaPlayer
    public final void setSurface(Surface r100) {
        if (r100 != null) goto L4;
    L5:
        MediaPlayerClient r101 = this.f108087a;
        if (r101 == null) goto L10;
        r101.setSurface(r100);
        return;
    L10:
        return;
    L4:
        if (r100.isValid() == true) goto L5;
    }

    @Override // com.ss.ttm.player.MediaPlayer
    public final void takeScreenshot(MediaPlayer.OnScreenshotListener r100) {
        MediaPlayerClient r101 = this.f108087a;
        if (r101 == null) goto L6;
        r101.takeScreenshot(r100);
        return;
    }

    @Override // com.ss.ttm.player.MediaPlayer
    public final float getFloatOption(int r100, float r101) {
        MediaPlayerClient r102 = this.f108087a;
        if (r102 != null) goto L5;
        return r101;
    L5:
        return r102.getFloatOption(r100, r101);
    }

    @Override // com.ss.ttm.player.MediaPlayer
    public final int getIntOption(int r100, int r101) {
        MediaPlayerClient r102 = this.f108087a;
        if (r102 != null) goto L5;
        return r101;
    L5:
        return r102.getIntOption(r100, r101);
    }

    @Override // com.ss.ttm.player.MediaPlayer
    public final long getLongOption(int r100, long r101) {
        MediaPlayerClient r102 = this.f108087a;
        if (r102 != null) goto L5;
        return r101;
    L5:
        return r102.getLongOption(r100, r101);
    }

    @Override // com.ss.ttm.player.MediaPlayer
    public final void rotateCamera(float r100, float r101) {
        MediaPlayerClient r102 = this.f108087a;
        if (r102 == null) goto L6;
        r102.rotateCamera(r100, r101);
        return;
    }

    @Override // com.ss.ttm.player.MediaPlayer
    public final void setCacheFile(String r100, int r101) {
        MediaPlayerClient r102 = this.f108087a;
        if (r102 == null) goto L6;
        r102.setCacheFile(r100, r101);
        return;
    }

    @Override // com.ss.ttm.player.MediaPlayer
    public final void setDataSource(Context r100, Uri r101) throws IllegalArgumentException, SecurityException, IllegalStateException, IOException {
        MediaPlayerClient r102 = this.f108087a;
        if (r102 == null) goto L6;
        r102.setDataSource(r100, r101);
        return;
    }

    @Override // com.ss.ttm.player.MediaPlayer
    public final int setFloatOption(int r100, float r101) {
        MediaPlayerClient r102 = this.f108087a;
        if (r102 == null) goto L7;
        r102.setFloatOption(r100, r101);
        return 0;
    L7:
        return 0;
    }

    @Override // com.ss.ttm.player.MediaPlayer
    public final void setIntOption(int r100, int r101) {
        MediaPlayerClient r102 = this.f108087a;
        if (r102 == null) goto L6;
        r102.setIntOption(r100, r101);
        return;
    }

    @Override // com.ss.ttm.player.MediaPlayer
    public final long setLongOption(int r100, long r101) {
        MediaPlayerClient r102 = this.f108087a;
        if (r102 != null) goto L5;
        return -1;
    L5:
        return r102.setLongOption(r100, r101);
    }

    @Override // com.ss.ttm.player.MediaPlayer
    public final void setStringOption(int r100, String r101) {
        MediaPlayerClient r102 = this.f108087a;
        if (r102 == null) goto L6;
        r102.setStringOption(r100, r101);
        return;
    }

    @Override // com.ss.ttm.player.MediaPlayer
    public final void setVolume(float r100, float r101) {
        MediaPlayerClient r102 = this.f108087a;
        if (r102 == null) goto L6;
        r102.setVolume(r100, r101);
        return;
    }

    @Override // com.ss.ttm.player.MediaPlayer
    public final void setWakeMode(Context r100, int r101) {
        MediaPlayerClient r102 = this.f108087a;
        if (r102 == null) goto L6;
        r102.setWakeMode(r100, r101);
        return;
    }

    @Override // com.ss.ttm.player.MediaPlayer
    public final void mouseEvent(int r100, int r101, int r102) {
        MediaPlayerClient r103 = this.f108087a;
        if (r103 == null) goto L6;
        r103.mouseEvent(r100, r101, r102);
        return;
    }

    @Override // com.ss.ttm.player.MediaPlayer
    public final void setDataSource(Context r100, Uri r101, Map<String, String> r102) throws IllegalArgumentException, SecurityException, IllegalStateException, IOException {
        MediaPlayerClient r103 = this.f108087a;
        if (r103 == null) goto L6;
        r103.setDataSource(r100, r101, r102);
        return;
    }
}
