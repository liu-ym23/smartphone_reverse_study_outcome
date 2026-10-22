package com.bytedance.android.livesdk.chatroom.widget;

import com.bytedance.android.live.broadcastgame.api.InteractGameContext;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.ies.sdk.widgets.DataCenter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/widget/AnchorGameStateWidget;", "Lcom/bytedance/android/live/core/tetris/widgets/LiveRecyclableWidget;", "Lvlc/l;", "<init>", "()V", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AnchorGameStateWidget extends LiveRecyclableWidget implements vlc.l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public vlc.d f118446a;

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveWidget, tw2.b
    public final String getSpm() {
        return "a100.a100.a164";
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onClear() {
        super.onClear();
        this.f118446a = null;
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onUnload() {
        com.bytedance.android.livesdk.chatroom.ui.framework.utils.f.d(this);
        vlc.d r100 = this.f118446a;
        if (r100 == null) goto L6;
        r100.removeMessageListener(MessageType.ANCHOR_GAME_STATE_MESSAGE.getIntType(), this);
        return;
    }

    public AnchorGameStateWidget() {
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onInit(Object[] r100) {
        this.f118446a = (vlc.d) this.dataCenter.get("data_message_manager", null);
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onLoad(Object[] r100) {
        com.bytedance.android.livesdk.chatroom.ui.framework.utils.f.c(this);
        vlc.d r101 = this.f118446a;
        if (r101 == null) goto L6;
        r101.addMessageListener(MessageType.ANCHOR_GAME_STATE_MESSAGE.getIntType(), this);
        return;
    }

    @Override // vlc.l
    public final void onMessage(tlc.d r100) {
        Intrinsics.checkNotNullParameter(r100, "message");
        if (r100.getIntType() != MessageType.ANCHOR_GAME_STATE_MESSAGE.getIntType()) goto L30;
        com.bytedance.android.livesdk.message.model.p r101 = (com.bytedance.android.livesdk.message.model.p) r100;
        boolean r102 = true;
        if (r101.getGameStatus() != 1) goto L7;
        boolean r103 = true;
    L28:
    L17:
        e = move-exception;
        ALogger.d("AnchorGameStateWidget", e.getMessage());
    L19:
        ALogger.d("AnchorGameStateWidget", "设置游戏状态为" + r103);
        InteractGameContext r104 = InteractGameContext.Companion.getContext();
        if (r104 == null) goto L24;
        com.bytedance.live.datacontext.m<Boolean> r105 = r104.isPlayingGame();
        if (r105 == null) goto L24;
        r105.setValue(Boolean.valueOf(r103));
    L24:
        DataCenter r106 = this.dataCenter;
        if (r106 == null) goto L31;
        r106.put("cmd_update_mini_game_conflict", Boolean.valueOf(r103));
        return;
    L31:
        return;
    L9:
        if (r101.getExtra() == null) goto L19;
        int r107 = new JSONObject(r101.getExtra()).optInt("game_kind", 0);     // Catch: Exception -> L17
        int r108 = com.bytedance.android.live.broadcastgame.api.interactgame.j.f59311a;     // Catch: Exception -> L17
        int r109 = com.bytedance.android.live.broadcastgame.api.interactgame.k.f59312a;     // Catch: Exception -> L17
        if (r107 != 6) goto L14;
        r102 = false;
    L14:
        if (r102 == true) goto L19;
        ALogger.d("AnchorGameStateWidget", "不设置游戏状态");     // Catch: Exception -> L17
        return;
    L7:
        r103 = false;
        goto L28
    }
}
