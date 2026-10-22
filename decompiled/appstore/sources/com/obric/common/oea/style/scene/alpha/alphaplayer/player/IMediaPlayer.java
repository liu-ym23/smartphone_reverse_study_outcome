package com.obric.common.oea.style.scene.alpha.alphaplayer.player;

import android.view.Surface;
import com.bytedance.common.wschannel.WsConstants;
import java.io.IOException;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import sb.c;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\bf\u0018\u00002\u00020\u0001:\u0004./01J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH&¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000fH&¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u0004H&¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0015H&¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u0019H&¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001d\u001a\u00020\u0004H&¢\u0006\u0004\b\u001d\u0010\u0014J\u000f\u0010\u001e\u001a\u00020\u0004H&¢\u0006\u0004\b\u001e\u0010\u0014J\u000f\u0010\u001f\u001a\u00020\u0004H&¢\u0006\u0004\b\u001f\u0010\u0014J\u000f\u0010 \u001a\u00020\u0004H&¢\u0006\u0004\b \u0010\u0014J\u000f\u0010!\u001a\u00020\u0004H&¢\u0006\u0004\b!\u0010\u0014J\u000f\u0010\"\u001a\u00020\u0004H&¢\u0006\u0004\b\"\u0010\u0014J\u0017\u0010%\u001a\u00020\u00042\u0006\u0010$\u001a\u00020#H&¢\u0006\u0004\b%\u0010&J\u0017\u0010(\u001a\u00020\u00042\u0006\u0010'\u001a\u00020#H&¢\u0006\u0004\b(\u0010&J\u000f\u0010*\u001a\u00020)H&¢\u0006\u0004\b*\u0010+J\u000f\u0010,\u001a\u00020\u0019H&¢\u0006\u0004\b,\u0010-¨\u00062"}, d2 = {"Lcom/obric/common/oea/style/scene/alpha/alphaplayer/player/IMediaPlayer;", "", "Lcom/obric/common/oea/style/scene/alpha/alphaplayer/player/IMediaPlayer$OnCompletionListener;", "completionListener", "", "setOnCompletionListener", "(Lcom/obric/common/oea/style/scene/alpha/alphaplayer/player/IMediaPlayer$OnCompletionListener;)V", "Lcom/obric/common/oea/style/scene/alpha/alphaplayer/player/IMediaPlayer$OnPreparedListener;", "preparedListener", "setOnPreparedListener", "(Lcom/obric/common/oea/style/scene/alpha/alphaplayer/player/IMediaPlayer$OnPreparedListener;)V", "Lcom/obric/common/oea/style/scene/alpha/alphaplayer/player/IMediaPlayer$OnErrorListener;", "errorListener", "setOnErrorListener", "(Lcom/obric/common/oea/style/scene/alpha/alphaplayer/player/IMediaPlayer$OnErrorListener;)V", "Lcom/obric/common/oea/style/scene/alpha/alphaplayer/player/IMediaPlayer$OnFirstFrameListener;", "firstFrameListener", "setOnFirstFrameListener", "(Lcom/obric/common/oea/style/scene/alpha/alphaplayer/player/IMediaPlayer$OnFirstFrameListener;)V", "initMediaPlayer", "()V", "Landroid/view/Surface;", "surface", "setSurface", "(Landroid/view/Surface;)V", "", "dataPath", "setDataSource", "(Ljava/lang/String;)V", "prepareAsync", "start", "pause", "stop", "reset", "release", "", "looping", "setLooping", "(Z)V", "onWhilePlaying", "setScreenOnWhilePlaying", "Lsb/c;", "getVideoInfo", "()Lsb/c;", "getPlayerType", "()Ljava/lang/String;", "OnCompletionListener", "OnErrorListener", "OnFirstFrameListener", "OnPreparedListener", "style_standardRelease"}, k = 1, mv = {1, 4, 3})
public interface IMediaPlayer {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, d2 = {"Lcom/obric/common/oea/style/scene/alpha/alphaplayer/player/IMediaPlayer$OnCompletionListener;", "", "onCompletion", "", "style_standardRelease"}, k = 1, mv = {1, 4, 3})
    public interface OnCompletionListener {
        void onCompletion();
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH&¨\u0006\t"}, d2 = {"Lcom/obric/common/oea/style/scene/alpha/alphaplayer/player/IMediaPlayer$OnErrorListener;", "", "onError", "", "what", "", WsConstants.KEY_EXTRA, "desc", "", "style_standardRelease"}, k = 1, mv = {1, 4, 3})
    public interface OnErrorListener {
        void onError(int r10, int r11, @NotNull String r12);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, d2 = {"Lcom/obric/common/oea/style/scene/alpha/alphaplayer/player/IMediaPlayer$OnFirstFrameListener;", "", "onFirstFrame", "", "style_standardRelease"}, k = 1, mv = {1, 4, 3})
    public interface OnFirstFrameListener {
        void onFirstFrame();
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, d2 = {"Lcom/obric/common/oea/style/scene/alpha/alphaplayer/player/IMediaPlayer$OnPreparedListener;", "", "onPrepared", "", "style_standardRelease"}, k = 1, mv = {1, 4, 3})
    public interface OnPreparedListener {
        void onPrepared();
    }

    @NotNull
    String getPlayerType();

    @NotNull
    c getVideoInfo() throws Exception;

    void initMediaPlayer() throws Exception;

    void pause();

    void prepareAsync();

    void release();

    void reset();

    void setDataSource(@NotNull String r10) throws IOException;

    void setLooping(boolean r10);

    void setOnCompletionListener(@NotNull OnCompletionListener r10);

    void setOnErrorListener(@NotNull OnErrorListener r10);

    void setOnFirstFrameListener(@NotNull OnFirstFrameListener r10);

    void setOnPreparedListener(@NotNull OnPreparedListener r10);

    void setScreenOnWhilePlaying(boolean r10);

    void setSurface(@NotNull Surface r10);

    void start();

    void stop();
}
