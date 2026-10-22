package af2;

import com.bytedance.android.livesdk.link.model.api.IBaseBattleSetting;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class d {
    public static final long a(IBaseBattleSetting r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$defaultPunishDuration");
        if (r100.getPunishOptimizeOn() == false) goto L5;
        return 60;
    L5:
        return 180;
    }

    public static final long b(IBaseBattleSetting r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$optimizePunishDuration");
        if (r100.getPunishOptimizeOn() == true) goto L7;
        return r100.getPunishDuration();
    L7:
        if (r100.getPunishDuration() >= 0) goto L10;
        return 0;
    L10:
        if (r100.getPunishDuration() != 0) goto L13;
        return a(r100);
    L13:
        return r100.getPunishDuration();
    }

    public static final boolean c(IBaseBattleSetting r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$needShowLastResult");
        if (r100.getDisplayLastResult() == true) goto L5;
    L7:
        return false;
    L5:
        if (r100.getNeedCloseLinkmic() == true) goto L7;
        return true;
    }

    public static final boolean d(IBaseBattleSetting r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$needSkipPenal");
        if (r100.getPunishOptimizeOn() == true) goto L6;
    L8:
        return false;
    L6:
        if (r100.getPunishDuration() >= 0) goto L8;
        return true;
    }

    public static final String e(IBaseBattleSetting r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$toSimpleString");
        return "BattleSettings{battleId=" + r100.getBattleId() + ", battleType=" + r100.getBattleType() + ", mode=" + r100.getMode() + ", duration=" + r100.getDuration() + ", startTimeMs=" + r100.getStartTimeMs() + ", punishDuration=" + r100.getPunishDuration() + ", punishStartTimeMs=" + r100.getPunishStartTimeMs() + '}';
    }
}
