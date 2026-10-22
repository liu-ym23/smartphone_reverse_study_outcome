package com.stepos.ailauncher.migu.play;

import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u000e\b\u0080\b\u0018\u0000 \u00192\u00020\u0001:\u0001\u001aB'\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ0\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u0004HÆ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0011\u001a\u00020\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0013\u001a\u0004\b\u0014\u0010\fR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0017\u0010\u0006\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0015\u001a\u0004\b\u0018\u0010\u0017¨\u0006\u001b"}, d2 = {"Lcom/stepos/ailauncher/migu/play/c0;", "", "", "songId", "", "isPlaying", "confirmed", "<init>", "(Ljava/lang/String;ZZ)V", Const.INTENT_KEY_PKGNAME, "(Ljava/lang/String;ZZ)Lcom/stepos/ailauncher/migu/play/c0;", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "e", "Z", "f", "()Z", Const.INTENT_KEY_UMID, "Companion", Const.INTENT_KEY_APIKEY, "migu_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.migu.play.c0, reason: from toString */
/* loaded from: classes3.dex */
public final /* data */ class MiguPlaybackSnapshot {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final MiguPlaybackSnapshot IDLE = new MiguPlaybackSnapshot(null, false, false, 7, null);
    private final boolean confirmed;
    private final boolean isPlaying;
    private final String songId;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/stepos/ailauncher/migu/play/c0$a;", "", "<init>", "()V", "Lcom/stepos/ailauncher/migu/play/c0;", "IDLE", "Lcom/stepos/ailauncher/migu/play/c0;", Const.INTENT_KEY_APIKEY, "()Lcom/stepos/ailauncher/migu/play/c0;", "migu_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.migu.play.c0$a, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }

        public final MiguPlaybackSnapshot a() {
            return MiguPlaybackSnapshot.IDLE;
        }

        public Companion() {
        }
    }

    public MiguPlaybackSnapshot() {
        this(null, false, false, 7, null);
    }

    public static /* synthetic */ MiguPlaybackSnapshot c(MiguPlaybackSnapshot miguPlaybackSnapshot, String str, boolean z10, boolean z11, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = miguPlaybackSnapshot.songId;
        }
        if ((i10 & 2) != 0) {
            z10 = miguPlaybackSnapshot.isPlaying;
        }
        if ((i10 & 4) != 0) {
            z11 = miguPlaybackSnapshot.confirmed;
        }
        return miguPlaybackSnapshot.b(str, z10, z11);
    }

    public final MiguPlaybackSnapshot b(String songId, boolean isPlaying, boolean confirmed) {
        return new MiguPlaybackSnapshot(songId, isPlaying, confirmed);
    }

    /* renamed from: d, reason: from getter */
    public final boolean getConfirmed() {
        return this.confirmed;
    }

    /* renamed from: e, reason: from getter */
    public final String getSongId() {
        return this.songId;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MiguPlaybackSnapshot)) {
            return false;
        }
        MiguPlaybackSnapshot miguPlaybackSnapshot = (MiguPlaybackSnapshot) other;
        return kotlin.jvm.internal.p.d(this.songId, miguPlaybackSnapshot.songId) && this.isPlaying == miguPlaybackSnapshot.isPlaying && this.confirmed == miguPlaybackSnapshot.confirmed;
    }

    /* renamed from: f, reason: from getter */
    public final boolean getIsPlaying() {
        return this.isPlaying;
    }

    public int hashCode() {
        String str = this.songId;
        return ((((str == null ? 0 : str.hashCode()) * 31) + Boolean.hashCode(this.isPlaying)) * 31) + Boolean.hashCode(this.confirmed);
    }

    public String toString() {
        return "MiguPlaybackSnapshot(songId=" + this.songId + ", isPlaying=" + this.isPlaying + ", confirmed=" + this.confirmed + ")";
    }

    public MiguPlaybackSnapshot(String str, boolean z10, boolean z11) {
        this.songId = str;
        this.isPlaying = z10;
        this.confirmed = z11;
    }

    public /* synthetic */ MiguPlaybackSnapshot(String str, boolean z10, boolean z11, int i10, kotlin.jvm.internal.i iVar) {
        this((i10 & 1) != 0 ? null : str, (i10 & 2) != 0 ? false : z10, (i10 & 4) != 0 ? false : z11);
    }
}
