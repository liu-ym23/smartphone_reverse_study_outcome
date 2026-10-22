package tb;

import android.content.Context;
import com.obric.common.oea.style.scene.alpha.alphaplayer.player.IMediaPlayer;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
public abstract class a implements IMediaPlayer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public IMediaPlayer.OnCompletionListener f24767a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public IMediaPlayer.OnPreparedListener f24768b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public IMediaPlayer.OnErrorListener f24769c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public IMediaPlayer.OnFirstFrameListener f24770d;

    public a(Context r10) {
    }

    public final IMediaPlayer.OnCompletionListener a() {
        return this.f24767a;
    }

    public final IMediaPlayer.OnErrorListener b() {
        return this.f24769c;
    }

    public final IMediaPlayer.OnFirstFrameListener c() {
        return this.f24770d;
    }

    public final IMediaPlayer.OnPreparedListener d() {
        return this.f24768b;
    }

    public final void setCompletionListener(@Nullable IMediaPlayer.OnCompletionListener r10) {
        this.f24767a = r10;
    }

    public final void setErrorListener(@Nullable IMediaPlayer.OnErrorListener r10) {
        this.f24769c = r10;
    }

    public final void setFirstFrameListener(@Nullable IMediaPlayer.OnFirstFrameListener r10) {
        this.f24770d = r10;
    }

    @Override // com.obric.common.oea.style.scene.alpha.alphaplayer.player.IMediaPlayer
    public void setOnCompletionListener(@NotNull IMediaPlayer.OnCompletionListener r10) {
        q.g(r10, "completionListener");
        this.f24767a = r10;
    }

    @Override // com.obric.common.oea.style.scene.alpha.alphaplayer.player.IMediaPlayer
    public void setOnErrorListener(@NotNull IMediaPlayer.OnErrorListener r10) {
        q.g(r10, "errorListener");
        this.f24769c = r10;
    }

    @Override // com.obric.common.oea.style.scene.alpha.alphaplayer.player.IMediaPlayer
    public void setOnFirstFrameListener(@NotNull IMediaPlayer.OnFirstFrameListener r10) {
        q.g(r10, "firstFrameListener");
        this.f24770d = r10;
    }

    @Override // com.obric.common.oea.style.scene.alpha.alphaplayer.player.IMediaPlayer
    public void setOnPreparedListener(@NotNull IMediaPlayer.OnPreparedListener r10) {
        q.g(r10, "preparedListener");
        this.f24768b = r10;
    }

    public final void setPreparedListener(@Nullable IMediaPlayer.OnPreparedListener r10) {
        this.f24768b = r10;
    }

    public /* synthetic */ a(Context r10, int r11, DefaultConstructorMarker r12) {
        if ((r11 & 1) == 0) goto L5;
        r10 = null;
    L5:
        this(r10);
    }
}
