package com.bytedance.android.livesdk.chatroom.room.apm;

import com.bytedance.android.gamecp.live_impl.GamePromoteDataContext;
import com.bytedance.android.live.core.monitor.LiveTracingMonitor;
import com.bytedance.android.livesdk.config.ww;
import com.bytedance.android.livesdk.room.data.EndReason;
import com.ss.android.update.UpdateService;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes7.dex */
public final class z implements q81.h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final z f110770a = null;

    public z() {
    }

    static {
        f110770a = new z();
    }

    @Override // q81.h
    public final void c() {
        JSONObject r100 = new JSONObject();
        if (ww.f121557a.getValue().booleanValue() == false) goto L5;
        r100.put("reason", "context_is_null_after_fix");
    L6:
        JSONObject r101 = new JSONObject();
        JSONObject r102 = new JSONObject();
        LiveTracingMonitor.f("ttlive_start_room_error", LiveTracingMonitor.EventModule.INTERACTION_OPT, r100, r102, r101);
        return;
    L5:
        r100.put("reason", UpdateService.REASON_CONTEXT_IS_NULL);
        goto L6
    }

    @Override // q81.h
    public final boolean a(EndReason r100) {
        Intrinsics.checkNotNullParameter(r100, "endReason");
        if (Intrinsics.areEqual(r100, EndReason.FINAL_CLEANUP.INSTANCE) == false) goto L5;
        return true;
    L5:
        if (Intrinsics.areEqual(r100, EndReason.JUMP_TO_OTHER.INSTANCE) == false) goto L7;
        return true;
    L7:
        if (Intrinsics.areEqual(r100, EndReason.JUMP_TO_OTHER_MIX_ROOM.INSTANCE) == false) goto L9;
        return true;
    L9:
        if (Intrinsics.areEqual(r100, EndReason.USER_CLOSE.INSTANCE) == false) goto L11;
        return true;
    L11:
        if (Intrinsics.areEqual(r100, EndReason.STOP_WITHOUT_RELEASE_PLAYER.INSTANCE) == false) goto L13;
        return true;
    L13:
        if (Intrinsics.areEqual(r100, EndReason.SLIDE_OUT.INSTANCE) == true) goto L23;
        return false;
    L23:
        return true;
    }

    @Override // q81.h
    public final String b(EndReason r100) {
        if (r100 != null) goto L6;
        return "unknown";
    L6:
        if (Intrinsics.areEqual(r100, EndReason.ENTER_FAILED.INSTANCE) == false) goto L9;
        return "enter_request_error";
    L9:
        if (Intrinsics.areEqual(r100, EndReason.AUDIENCE_BAN.INSTANCE) == false) goto L12;
        return "audience_ban_error";
    L12:
        if (Intrinsics.areEqual(r100, EndReason.EMPTY_URL.INSTANCE) == false) goto L15;
        return "empty_url";
    L15:
        if (Intrinsics.areEqual(r100, EndReason.PING_KICK_OUT.INSTANCE) == false) goto L18;
        return "ping_kick_out";
    L18:
        if (Intrinsics.areEqual(r100, EndReason.PING_LOST_FOCUS.INSTANCE) == false) goto L21;
        return "ping_lost_focus";
    L21:
        if (Intrinsics.areEqual(r100, EndReason.BACKGROUND_TIMEOUT.INSTANCE) == false) goto L24;
        return "background_timeout";
    L24:
        if (Intrinsics.areEqual(r100, EndReason.MEDIA_END.INSTANCE) == false) goto L27;
        return "media_end";
    L27:
        if (Intrinsics.areEqual(r100, EndReason.USER_CLOSE.INSTANCE) == false) goto L30;
        return GamePromoteDataContext.ACTION_TYPE_USER_CLOSE;
    L30:
        if (Intrinsics.areEqual(r100, EndReason.USER_KICK_OUT.INSTANCE) == false) goto L33;
        return "user_kick_out";
    L33:
        if (Intrinsics.areEqual(r100, EndReason.WATCHER_KIT_OUT.INSTANCE) == false) goto L36;
        return "watcher_kit_out";
    L36:
        if (Intrinsics.areEqual(r100, EndReason.JUMP_TO_OTHER.INSTANCE) == false) goto L39;
        return "jump_to_other";
    L39:
        if (Intrinsics.areEqual(r100, EndReason.JUMP_TO_OTHER_MIX_ROOM.INSTANCE) == false) goto L42;
        return "jump_to_other_mix_room";
    L42:
        if (Intrinsics.areEqual(r100, EndReason.STOP_WITHOUT_RELEASE_PLAYER.INSTANCE) == false) goto L45;
        return "scroll_to_other_room";
    L45:
        if (Intrinsics.areEqual(r100, EndReason.PLAYER_ERROR.INSTANCE) == false) goto L48;
        return "player_error";
    L48:
        if (Intrinsics.areEqual(r100, EndReason.FINAL_CLEANUP.INSTANCE) == false) goto L51;
        return "final_cleanup";
    L51:
        if ((r100 instanceof EndReason.FETCH_FAILED) == false) goto L54;
        return "invalid_data_error";
    L54:
        if ((r100 instanceof EndReason.LIVE_END) == false) goto L57;
        return "live_end";
    L57:
        if ((r100 instanceof EndReason.LIVE_END_NO_INTERCEPT) == false) goto L60;
        return "live_end_no_intercept";
    L60:
        if ((r100 instanceof EndReason.SECRET_KICK_OUT) == false) goto L63;
        return "live_secret_kick_out";
    L63:
        if ((r100 instanceof EndReason.PAD_SPLIT_REPEAT) == false) goto L66;
        return "pad_split_repeat";
    L66:
        if ((r100 instanceof EndReason.FORCE_LOGIN_CANCEL) == false) goto L69;
        return "force_login_cancel";
    L69:
        if ((r100 instanceof EndReason.KICK_OUT_AFTER_LOGIN) == false) goto L72;
        return "kick_out_after_login";
    L72:
        if ((r100 instanceof EndReason.SLIDE_OUT) == false) goto L75;
        return "slide_out";
    L75:
        if ((r100 instanceof EndReason.DETAIL_SCROLL) == false) goto L101;
        return "detail_scroll";
    L101:
        return "unknown";
    }
}
