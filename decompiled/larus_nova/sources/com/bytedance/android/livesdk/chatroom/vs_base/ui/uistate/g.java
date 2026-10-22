package com.bytedance.android.livesdk.chatroom.vs_base.ui.uistate;

import com.bytedance.android.live.commonui.LiveSettingKeys;
import com.bytedance.android.livesdk.chatroom.vs_base.util.UtilityKotlinExtentionsKt;
import com.ss.ttm.player.MediaPlayer;
import kotlin.NoWhenBranchMatchedException;

/* JADX INFO: loaded from: classes8.dex */
public class g extends ir1.c {

    public static final class a {
    }

    static {
    }

    public int o() {
        ReplayDialogUIStyle r100 = p();
        int r101 = h.f118177a[r100.ordinal()];
        if (r101 == 1) goto L13;
        if (r101 == 2) goto L15;
        if (r101 != 3) goto L10;
        return -2;
    L10:
        throw new NoWhenBranchMatchedException();
    L15:
        return UtilityKotlinExtentionsKt.c(MediaPlayer.MEDIA_PLAYER_OPTION_SET_FORCE_RENDER_MS_GAPS);
    L13:
        return UtilityKotlinExtentionsKt.c(MediaPlayer.MEDIA_PLAYER_OPTION_SET_FORCE_RENDER_MS_GAPS);
    }

    public ReplayDialogUIStyle p() {
        if (g() == true) goto L16;
        if (LiveSettingKeys.LIVE_VS_FOLD_FIX_CONFIG.getValue().getEnable() == false) goto L10;
        if (a() == true) goto L16;
    L10:
        if (d() == false) goto L14;
        return ReplayDialogUIStyle.RightStyle;
    L14:
        return ReplayDialogUIStyle.BottomStyle;
    L16:
        return ReplayDialogUIStyle.RightBottomStyle;
    }

    public g() {
    }
}
