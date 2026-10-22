package com.stepos.ailauncher.migu.play;

import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0006\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001d\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nJ%\u0010\f\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\b¢\u0006\u0004\b\f\u0010\rJ'\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0012\u0010\u0013J\u001f\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lcom/stepos/ailauncher/migu/play/Z;", "", "<init>", "()V", "Lcom/stepos/ailauncher/migu/play/c0;", "snapshot", "", "tappedSongId", "Lcom/stepos/ailauncher/migu/play/MiguPlayAction;", "c", "(Lcom/stepos/ailauncher/migu/play/c0;Ljava/lang/String;)Lcom/stepos/ailauncher/migu/play/MiguPlayAction;", "action", Const.INTENT_KEY_UMID, "(Lcom/stepos/ailauncher/migu/play/c0;Ljava/lang/String;Lcom/stepos/ailauncher/migu/play/MiguPlayAction;)Lcom/stepos/ailauncher/migu/play/c0;", "prev", "songId", "", "isPlaying", Const.INTENT_KEY_APIKEY, "(Lcom/stepos/ailauncher/migu/play/c0;Ljava/lang/String;Z)Lcom/stepos/ailauncher/migu/play/c0;", Const.INTENT_KEY_PKGNAME, "(Lcom/stepos/ailauncher/migu/play/c0;Ljava/lang/String;)Lcom/stepos/ailauncher/migu/play/c0;", "migu_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class Z {
    public static final Z INSTANCE = new Z();

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class a {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[MiguPlayAction.values().length];
            try {
                iArr[MiguPlayAction.PLAY_NEW.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[MiguPlayAction.PAUSE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public final MiguPlaybackSnapshot a(MiguPlaybackSnapshot prev, String songId, boolean isPlaying) {
        kotlin.jvm.internal.p.i(prev, "prev");
        return (isPlaying || songId == null || songId.length() == 0 || prev.getSongId() == null || kotlin.jvm.internal.p.d(songId, prev.getSongId())) ? (songId == null || songId.length() == 0) ? MiguPlaybackSnapshot.c(prev, null, isPlaying, true, 1, null) : new MiguPlaybackSnapshot(songId, isPlaying, true) : prev;
    }

    public final MiguPlaybackSnapshot b(MiguPlaybackSnapshot prev, String songId) {
        kotlin.jvm.internal.p.i(prev, "prev");
        return (songId == null || songId.length() == 0) ? prev : MiguPlaybackSnapshot.c(prev, songId, false, false, 6, null);
    }

    public final MiguPlayAction c(MiguPlaybackSnapshot snapshot, String tappedSongId) {
        kotlin.jvm.internal.p.i(snapshot, "snapshot");
        kotlin.jvm.internal.p.i(tappedSongId, "tappedSongId");
        return (kotlin.jvm.internal.p.d(tappedSongId, snapshot.getSongId()) && snapshot.getIsPlaying()) ? MiguPlayAction.PAUSE : MiguPlayAction.PLAY_NEW;
    }

    public final MiguPlaybackSnapshot d(MiguPlaybackSnapshot snapshot, String tappedSongId, MiguPlayAction action) {
        kotlin.jvm.internal.p.i(snapshot, "snapshot");
        kotlin.jvm.internal.p.i(tappedSongId, "tappedSongId");
        kotlin.jvm.internal.p.i(action, "action");
        int i10 = a.$EnumSwitchMapping$0[action.ordinal()];
        if (i10 == 1) {
            return new MiguPlaybackSnapshot(tappedSongId, true, false);
        }
        if (i10 == 2) {
            return MiguPlaybackSnapshot.c(snapshot, null, false, false, 5, null);
        }
        throw new NoWhenBranchMatchedException();
    }
}
