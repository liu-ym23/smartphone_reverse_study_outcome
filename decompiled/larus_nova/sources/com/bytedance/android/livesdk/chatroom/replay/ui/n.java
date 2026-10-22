package com.bytedance.android.livesdk.chatroom.replay.ui;

import com.bytedance.android.livesdk.chatroom.vs_base.ui.uistate.ReplayDialogUIStyle;
import com.larus.nova.R;
import kotlin.NoWhenBranchMatchedException;

/* JADX INFO: loaded from: classes7.dex */
public final class n extends com.bytedance.android.livesdk.chatroom.vs_base.ui.uistate.g {
    public final int q() {
        if (l() == true) goto L5;
    L10:
        ReplayDialogUIStyle r100 = p();
        int r101 = m.f110256a[r100.ordinal()];
        if (r101 != 1) goto L13;
        return R.layout.ttlive_replay_play_list_right_bottom_style_layout;
    L13:
        if (r101 != 2) goto L15;
        return R.layout.ttlive_replay_play_list_right_style_layout;
    L15:
        if (r101 != 3) goto L18;
        return R.layout.ttlive_replay_play_list_bottom_style_layout;
    L18:
        throw new NoWhenBranchMatchedException();
    L5:
        if (i() == false) goto L10;
        if (g() == true) goto L10;
        return R.layout.ttlive_replay_play_list_bottom_style_dialog_layout;
    }

    public n() {
    }
}
