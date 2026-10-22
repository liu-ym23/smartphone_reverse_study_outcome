package com.bytedance.android.livesdk.config;

import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/livesdk/config/p41;", "", "", "gameDialogCommonBackground", "Ljava/lang/String;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/lang/String;", "gameDialogLotteryBackground", "b", "wgameInviteLoadAnimWebP", "c", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class p41 {

    @SerializedName("game_dialog_common_bg")
    private final String gameDialogCommonBackground;

    @SerializedName("game_dialog_lottery_bg")
    private final String gameDialogLotteryBackground;

    @SerializedName("wgame_invite_load_anim")
    private final String wgameInviteLoadAnimWebP;

    public p41() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof p41) == false) goto L12;
        p41 r101 = (p41) r100;
        if (Intrinsics.areEqual(this.gameDialogCommonBackground, r101.gameDialogCommonBackground) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.gameDialogLotteryBackground, r101.gameDialogLotteryBackground) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.wgameInviteLoadAnimWebP, r101.wgameInviteLoadAnimWebP) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        String r100 = this.gameDialogCommonBackground;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.gameDialogLotteryBackground;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.wgameInviteLoadAnimWebP;
        if (r107 == null) goto L14;
        r101 = r107.hashCode();
    L14:
        return r106 + r101;
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "LiveInteractGameConfig(gameDialogCommonBackground=" + this.gameDialogCommonBackground + ", gameDialogLotteryBackground=" + this.gameDialogLotteryBackground + ", wgameInviteLoadAnimWebP=" + this.wgameInviteLoadAnimWebP + ")";
    }

    public final String a() {
        return this.gameDialogCommonBackground;
    }

    public final String b() {
        return this.gameDialogLotteryBackground;
    }

    public final String c() {
        return this.wgameInviteLoadAnimWebP;
    }

    public p41(int r100) {
        StringBuilder r101 = new StringBuilder("https://");
        LiveCommonConstants r102 = LiveCommonConstants.INSTANCE;
        r101.append(r102.getObjectTosPath());
        r101.append("/obj/live-android/ttlive_bg_game_dialog.png");
        String r103 = r101.toString();
        String r104 = "https://" + r102.getObjectTosPath() + "/obj/live-android/ttlive_wgameinvite_dialog_top_bg_lottery.png";
        String r105 = "https://" + r102.getObjectTosPath() + "/obj/live-android/wgame_invite_loading.webp";
        this.gameDialogCommonBackground = r103;
        this.gameDialogLotteryBackground = r104;
        this.wgameInviteLoadAnimWebP = r105;
    }
}
