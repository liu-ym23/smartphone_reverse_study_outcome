package com.bytedance.android.live.broadcastgame.opengame.message;

import com.bytedance.android.live.liveinteract.api.utils.LiveSeiUtil;
import com.bytedance.android.livesdk.message.model.dh;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes45.dex */
public final class h implements com.bytedance.android.live.broadcastgame.c0<f>, vlc.l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public com.bytedance.android.live.broadcastgame.b0 f60231a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final vlc.d f60232b;

    @Override // com.bytedance.android.live.broadcastgame.c0
    public final void release() {
        this.f60232b.removeMessageListener(this);
    }

    public h(vlc.d r100) {
        Intrinsics.checkNotNullParameter(r100, "messageManager");
        this.f60232b = r100;
    }

    @Override // com.bytedance.android.live.broadcastgame.c0
    public final void a(com.bytedance.android.live.broadcastgame.b0 r100) {
        Intrinsics.checkNotNullParameter(r100, "queue");
        this.f60231a = r100;
        this.f60232b.addMessageListener(MessageType.OPEN_GAME_AUDIENCE_MESSAGE.getIntType(), this);
    }

    @Override // vlc.l
    public final void onMessage(tlc.d r110) {
        Intrinsics.checkNotNullParameter(r110, "message");
        if ((r110 instanceof dh) == false) goto L13;
        String r100 = ((dh) r110).extra;
        if (r100 == null) goto L14;
        LiveSeiUtil.f71508i.getClass();     // Catch: Exception -> L10
        JSONObject r101 = LiveSeiUtil.c(r100);     // Catch: Exception -> L10
        String r102 = JSONObjectProtectorUtils.getString(r101, "app_id");     // Catch: Exception -> L10
        long r103 = JSONObjectProtectorUtils.getLong(r101, "room_id");     // Catch: Exception -> L10
        long r104 = JSONObjectProtectorUtils.getLong(r101, "conn_id");     // Catch: Exception -> L10
        com.bytedance.android.live.broadcastgame.b0 r105 = this.f60231a;     // Catch: Exception -> L10
        if (r105 == null) goto L15;
        r105.insert(new f(r103, r102, r104, ((dh) r110).data));     // Catch: Exception -> L10
        Unit r111 = Unit.INSTANCE;     // Catch: Exception -> L10
        return;
    L15:
        return;
    L16:
        return;
    L14:
        return;
    }
}
