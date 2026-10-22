package com.stepos.ailauncher.migu.play;

import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J%\u0010\b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004¢\u0006\u0004\b\b\u0010\tJ-\u0010\f\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0004¢\u0006\u0004\b\f\u0010\rJ\u001f\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lcom/stepos/ailauncher/migu/play/v;", "", "<init>", "()V", "", "isPlaying", "networkUsable", "alreadyHinted", Const.INTENT_KEY_PKGNAME, "(ZZZ)Z", "userOrSelfInitiatedPause", "nearEnd", "c", "(ZZZZ)Z", "Lcom/stepos/ailauncher/migu/play/b0;", "progress", "", "nearEndPercent", Const.INTENT_KEY_APIKEY, "(Lcom/stepos/ailauncher/migu/play/b0;I)Z", "migu_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.migu.play.v, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C3373v {
    public static final C3373v INSTANCE = new C3373v();

    public final boolean a(MiguPlaybackProgress progress, int nearEndPercent) {
        kotlin.jvm.internal.p.i(progress, "progress");
        return (progress.getDurationMs() > 0 && progress.getDurationMs() - progress.getPositionMs() <= (progress.getDurationMs() * ((long) (100 - nearEndPercent))) / 100) || progress.getPercent() >= nearEndPercent;
    }

    public final boolean b(boolean isPlaying, boolean networkUsable, boolean alreadyHinted) {
        return (!isPlaying || networkUsable || alreadyHinted) ? false : true;
    }

    public final boolean c(boolean networkUsable, boolean alreadyHinted, boolean userOrSelfInitiatedPause, boolean nearEnd) {
        return (networkUsable || alreadyHinted || userOrSelfInitiatedPause || nearEnd) ? false : true;
    }
}
