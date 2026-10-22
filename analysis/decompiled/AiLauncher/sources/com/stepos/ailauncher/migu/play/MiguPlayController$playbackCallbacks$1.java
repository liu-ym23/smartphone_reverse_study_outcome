package com.stepos.ailauncher.migu.play;

import android.util.Log;
import com.migu.music.ipc.IMusicPlayCallbacks;
import com.migu.music.ipc.MgSong;
import kotlin.Metadata;
import kotlin.Pair;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u00003\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u000b*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J!\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\t\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\t\u0010\nJ+\u0010\u000f\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u000f\u0010\u0010J1\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u000b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u0019\u0010\u0017\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0017\u0010\nJ\u0019\u0010\u0018\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0018\u0010\nJ)\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u000b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u001a\u0010\u001b¨\u0006\u001c"}, d2 = {"com/stepos/ailauncher/migu/play/MiguPlayController$playbackCallbacks$1", "Lcom/migu/music/ipc/IMusicPlayCallbacks$Stub;", "", "isPlaying", "Lcom/migu/music/ipc/MgSong;", "song", "LY8/t;", "onPlayStateChanged", "(ZLcom/migu/music/ipc/MgSong;)V", "onSongChanged", "(Lcom/migu/music/ipc/MgSong;)V", "", "errorCode", "", "message", "onPlayFailed", "(ILjava/lang/String;Lcom/migu/music/ipc/MgSong;)V", "", "position", "duration", "percent", "onProgress", "(JJILcom/migu/music/ipc/MgSong;)V", "onSeekComplete", "onPrepared", "buffering", "onBuffering", "(ZILcom/migu/music/ipc/MgSong;)V", "migu_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class MiguPlayController$playbackCallbacks$1 extends IMusicPlayCallbacks.Stub {
    /* JADX INFO: Access modifiers changed from: private */
    public static final void onBuffering$lambda$7(MgSong mgSong) {
        MiguPlayController.INSTANCE.a0(mgSong != null ? mgSong.songId : null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MiguPlaybackSnapshot onPlayFailed$lambda$3(MiguPlaybackSnapshot it) {
        kotlin.jvm.internal.p.i(it, "it");
        return MiguPlaybackSnapshot.c(it, null, false, false, 5, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onPlayFailed$lambda$5(int i10, MiguPlayError miguPlayError, String str) {
        MiguPlayController.INSTANCE.A0(i10, miguPlayError, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MiguPlaybackSnapshot onPlayStateChanged$lambda$0(String str, boolean z10, MiguPlaybackSnapshot it) {
        kotlin.jvm.internal.p.i(it, "it");
        return Z.INSTANCE.a(it, str, z10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onPlayStateChanged$lambda$1(String str) {
        MiguPlayController.INSTANCE.b0(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onProgress$lambda$6(MiguPlaybackProgress miguPlaybackProgress) {
        MiguPlayController.INSTANCE.u0(miguPlaybackProgress);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MiguPlaybackSnapshot onSongChanged$lambda$2(String str, MiguPlaybackSnapshot it) {
        kotlin.jvm.internal.p.i(it, "it");
        return Z.INSTANCE.b(it, str);
    }

    @Override // com.migu.music.ipc.IMusicPlayCallbacks
    public void onBuffering(boolean buffering, int percent, final MgSong song) {
        Log.w("wld____7", "onBuffering:  " + buffering + ", " + percent + ", " + song);
        if (buffering) {
            MiguPlayController.mainHandler.post(new Runnable() { // from class: com.stepos.ailauncher.migu.play.Q
                @Override // java.lang.Runnable
                public final void run() {
                    MiguPlayController$playbackCallbacks$1.onBuffering$lambda$7(song);
                }
            });
        }
    }

    @Override // com.migu.music.ipc.IMusicPlayCallbacks
    public void onPlayFailed(final int errorCode, final String message, MgSong song) {
        String strName;
        String str;
        Log.w("wld____3", "onPlayFailed:  " + errorCode + " , " + message + ", " + song);
        final MiguPlayError miguPlayErrorB = MiguPlayError.INSTANCE.b(errorCode);
        R5.b bVar = R5.b.INSTANCE;
        Pair pairA = Y8.j.a("errorCode", Integer.valueOf(errorCode));
        if (miguPlayErrorB == null || (strName = miguPlayErrorB.name()) == null) {
            strName = "UNKNOWN";
        }
        Pair pairA2 = Y8.j.a("error", strName);
        String str2 = "";
        Pair pairA3 = Y8.j.a("message", message == null ? "" : message);
        if (song != null && (str = song.songId) != null) {
            str2 = str;
        }
        bVar.h("music.playFailed", pairA, pairA2, pairA3, Y8.j.a("songId", str2));
        if (miguPlayErrorB == MiguPlayError.ALREADY_PLAYING) {
            return;
        }
        MiguPlayController miguPlayController = MiguPlayController.INSTANCE;
        miguPlayController.L0(new InterfaceC5074l() { // from class: com.stepos.ailauncher.migu.play.T
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return MiguPlayController$playbackCallbacks$1.onPlayFailed$lambda$3((MiguPlaybackSnapshot) obj);
            }
        });
        miguPlayController.J();
        if (miguPlayErrorB == MiguPlayError.NETWORK_ERROR) {
            MiguPlayController.mainHandler.post(new Runnable() { // from class: com.stepos.ailauncher.migu.play.U
                @Override // java.lang.Runnable
                public final void run() {
                    MiguPlayController.D(true);
                }
            });
        }
        MiguPlayController.mainHandler.post(new Runnable() { // from class: com.stepos.ailauncher.migu.play.V
            @Override // java.lang.Runnable
            public final void run() {
                MiguPlayController$playbackCallbacks$1.onPlayFailed$lambda$5(errorCode, miguPlayErrorB, message);
            }
        });
    }

    @Override // com.migu.music.ipc.IMusicPlayCallbacks
    public void onPlayStateChanged(final boolean isPlaying, MgSong song) {
        Log.w("wld____1", "onPlayStateChanged: " + isPlaying + ", " + song);
        final String str = song != null ? song.songId : null;
        MiguPlayController.INSTANCE.L0(new InterfaceC5074l() { // from class: com.stepos.ailauncher.migu.play.W
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return MiguPlayController$playbackCallbacks$1.onPlayStateChanged$lambda$0(str, isPlaying, (MiguPlaybackSnapshot) obj);
            }
        });
        if (isPlaying) {
            return;
        }
        MiguPlayController.mainHandler.post(new Runnable() { // from class: com.stepos.ailauncher.migu.play.X
            @Override // java.lang.Runnable
            public final void run() {
                MiguPlayController$playbackCallbacks$1.onPlayStateChanged$lambda$1(str);
            }
        });
    }

    @Override // com.migu.music.ipc.IMusicPlayCallbacks
    public void onPrepared(MgSong song) {
        Log.w("wld____6", "onPrepared:  " + song);
    }

    @Override // com.migu.music.ipc.IMusicPlayCallbacks
    public void onProgress(long position, long duration, int percent, MgSong song) {
        Log.w("wld____4", "onProgress:  " + position + " , " + duration + ", " + percent + ", " + song);
        String str = song != null ? song.songId : null;
        MiguPlayController.INSTANCE.I0(str, position, duration, percent);
        if (kotlin.jvm.internal.p.d(str, MiguPlayController.lastForwardedSongId) && percent == MiguPlayController.lastForwardedPercent) {
            return;
        }
        MiguPlayController.lastForwardedSongId = str;
        MiguPlayController.lastForwardedPercent = percent;
        final MiguPlaybackProgress miguPlaybackProgress = new MiguPlaybackProgress(str, position, duration, percent);
        MiguPlayController.mainHandler.post(new Runnable() { // from class: com.stepos.ailauncher.migu.play.Y
            @Override // java.lang.Runnable
            public final void run() {
                MiguPlayController$playbackCallbacks$1.onProgress$lambda$6(miguPlaybackProgress);
            }
        });
    }

    @Override // com.migu.music.ipc.IMusicPlayCallbacks
    public void onSeekComplete(MgSong song) {
        Log.w("wld____5", "onSeekComplete:  " + song);
    }

    @Override // com.migu.music.ipc.IMusicPlayCallbacks
    public void onSongChanged(MgSong song) {
        Log.w("wld____2", "onSongChanged:  " + song);
        final String str = song != null ? song.songId : null;
        if (str != null) {
            MiguPlayController.INSTANCE.c0(str);
        }
        MiguPlayController.INSTANCE.L0(new InterfaceC5074l() { // from class: com.stepos.ailauncher.migu.play.S
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return MiguPlayController$playbackCallbacks$1.onSongChanged$lambda$2(str, (MiguPlaybackSnapshot) obj);
            }
        });
    }
}
