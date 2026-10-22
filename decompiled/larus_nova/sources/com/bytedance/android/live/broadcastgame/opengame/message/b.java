package com.bytedance.android.live.broadcastgame.opengame.message;

import com.bytedance.android.live.liveinteract.api.utils.LiveSeiUtil;
import com.bytedance.android.livesdk.message.model.ch;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.sdk.account.platform.base.OnekeyLoginConstants;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes45.dex */
public final class b extends BaseAnchorMessageReceiver<a> {
    @Override // com.bytedance.android.live.broadcastgame.opengame.message.BaseAnchorMessageReceiver
    public final int b() {
        return MessageType.OPEN_GAME_ANCHOR_MESSAGE.getIntType();
    }

    public b(vlc.d r100) {
        Intrinsics.checkNotNullParameter(r100, "messageManager");
        super(r100);
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.message.BaseAnchorMessageReceiver
    public final Long c(tlc.d r100) {
        Intrinsics.checkNotNullParameter(r100, "message");
        if ((r100 instanceof ch) == false) goto L9;
        String r101 = ((ch) r100).extra;
        if (r101 == null) goto L9;
        Intrinsics.checkNotNullParameter(r101, "$this$getTimeStamp");
        LiveSeiUtil.f71508i.getClass();     // Catch: Exception -> L11
        return Long.valueOf(LiveSeiUtil.c(r101).optLong("time_stamp"));
    L9:
        return null;
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.message.BaseAnchorMessageReceiver
    public final boolean d(tlc.d r100) {
        Intrinsics.checkNotNullParameter(r100, "message");
        if ((r100 instanceof ch) == true) goto L5;
    L7:
        return false;
    L5:
        if (((ch) r100).sendType != 2) goto L7;
        return true;
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.message.BaseAnchorMessageReceiver
    public final a e(tlc.d r110) {
        Intrinsics.checkNotNullParameter(r110, "message");
        if ((r110 instanceof ch) == false) goto L8;
        String r100 = ((ch) r110).extra;
        if (r100 == null) goto L8;
        LiveSeiUtil.f71508i.getClass();     // Catch: Exception -> L10
        JSONObject r101 = LiveSeiUtil.c(r100);     // Catch: Exception -> L10
        return new a(r101.optString("app_id", ""), r101.optLong("room_id", 0), r101.optLong(OnekeyLoginConstants.CU_KEY_SEQ, 0), r101.optLong("conn_id", 0), ((ch) r110).data, ((ch) r110).sendType, "");
    L8:
        return null;
    }
}
