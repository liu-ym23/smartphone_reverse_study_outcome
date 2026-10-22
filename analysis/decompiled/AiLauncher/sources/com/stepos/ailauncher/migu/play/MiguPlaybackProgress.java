package com.stepos.ailauncher.migu.play;

import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;
import v9.C5685n;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u0007\n\u0002\b\u0006\b\u0080\b\u0018\u0000 \u001f2\u00020\u0001:\u0001 B1\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0004\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\r\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0013\u001a\u0004\b\u0014\u0010\fR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0017\u0010\u0006\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0015\u001a\u0004\b\u0018\u0010\u0017R\u0017\u0010\b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010\u0019\u001a\u0004\b\u001a\u0010\u000eR\u0011\u0010\u001e\u001a\u00020\u001b8F¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001d¨\u0006!"}, d2 = {"Lcom/stepos/ailauncher/migu/play/b0;", "", "", "songId", "", "positionMs", "durationMs", "", "percent", "<init>", "(Ljava/lang/String;JJI)V", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "f", "J", "e", "()J", Const.INTENT_KEY_PKGNAME, "I", Const.INTENT_KEY_UMID, "", "c", "()F", "fraction", "Companion", Const.INTENT_KEY_APIKEY, "migu_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.migu.play.b0, reason: from toString */
/* loaded from: classes3.dex */
public final /* data */ class MiguPlaybackProgress {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final MiguPlaybackProgress IDLE = new MiguPlaybackProgress(null, 0, 0, 0, 15, null);
    private final long durationMs;
    private final int percent;
    private final long positionMs;
    private final String songId;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/stepos/ailauncher/migu/play/b0$a;", "", "<init>", "()V", "Lcom/stepos/ailauncher/migu/play/b0;", "IDLE", "Lcom/stepos/ailauncher/migu/play/b0;", Const.INTENT_KEY_APIKEY, "()Lcom/stepos/ailauncher/migu/play/b0;", "migu_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.migu.play.b0$a, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }

        public final MiguPlaybackProgress a() {
            return MiguPlaybackProgress.IDLE;
        }

        public Companion() {
        }
    }

    public MiguPlaybackProgress() {
        this(null, 0L, 0L, 0, 15, null);
    }

    /* renamed from: b, reason: from getter */
    public final long getDurationMs() {
        return this.durationMs;
    }

    public final float c() {
        float f10;
        float f11;
        long j10 = this.durationMs;
        if (j10 > 0) {
            f10 = this.positionMs;
            f11 = j10;
        } else {
            f10 = this.percent;
            f11 = 100.0f;
        }
        return C5685n.m(f10 / f11, 0.0f, 1.0f);
    }

    /* renamed from: d, reason: from getter */
    public final int getPercent() {
        return this.percent;
    }

    /* renamed from: e, reason: from getter */
    public final long getPositionMs() {
        return this.positionMs;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MiguPlaybackProgress)) {
            return false;
        }
        MiguPlaybackProgress miguPlaybackProgress = (MiguPlaybackProgress) other;
        return kotlin.jvm.internal.p.d(this.songId, miguPlaybackProgress.songId) && this.positionMs == miguPlaybackProgress.positionMs && this.durationMs == miguPlaybackProgress.durationMs && this.percent == miguPlaybackProgress.percent;
    }

    /* renamed from: f, reason: from getter */
    public final String getSongId() {
        return this.songId;
    }

    public int hashCode() {
        String str = this.songId;
        return ((((((str == null ? 0 : str.hashCode()) * 31) + Long.hashCode(this.positionMs)) * 31) + Long.hashCode(this.durationMs)) * 31) + Integer.hashCode(this.percent);
    }

    public String toString() {
        return "MiguPlaybackProgress(songId=" + this.songId + ", positionMs=" + this.positionMs + ", durationMs=" + this.durationMs + ", percent=" + this.percent + ")";
    }

    public MiguPlaybackProgress(String str, long j10, long j11, int i10) {
        this.songId = str;
        this.positionMs = j10;
        this.durationMs = j11;
        this.percent = i10;
    }

    public /* synthetic */ MiguPlaybackProgress(String str, long j10, long j11, int i10, int i11, kotlin.jvm.internal.i iVar) {
        this((i11 & 1) != 0 ? null : str, (i11 & 2) != 0 ? 0L : j10, (i11 & 4) != 0 ? 0L : j11, (i11 & 8) != 0 ? 0 : i10);
    }
}
