package com.bytedance.android.livesdk.chatroom.replay.ui;

import android.content.Context;
import com.bytedance.android.livesdk.chatroom.vs_base.base.util.ReplayRoomFragmentScopeUtil;
import com.bytedance.android.livesdk.chatroom.vs_base.ui.uistate.ReplayDialogUIStyle;
import com.bytedance.android.livesdk.chatroom.vs_base.util.UtilityKotlinExtentionsKt;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.ttm.player.MediaPlayer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class i extends com.bytedance.android.livesdk.chatroom.vs_base.ui.uistate.g {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f110252c = 0;

    public static final class a {
        public static i a() {
            com.bytedance.android.livesdk.chatroom.vs_base.base.d r100 = ReplayRoomFragmentScopeUtil.f117917a;
            return (i) ReplayRoomFragmentScopeUtil.a(i.class);
        }
    }

    static {
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_base.ui.uistate.g
    public final ReplayDialogUIStyle p() {
        if (g() == true) goto L10;
        if (d() == true) goto L10;
        return ReplayDialogUIStyle.BottomStyle;
    L10:
        return ReplayDialogUIStyle.RightBottomStyle;
    }

    public i() {
    }

    public final int q(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        if (d() == true) goto L5;
        return -1;
    L5:
        return UtilityKotlinExtentionsKt.c(MediaPlayer.MEDIA_PLAYER_OPTION_SET_FORCE_RENDER_MS_GAPS);
    }
}
