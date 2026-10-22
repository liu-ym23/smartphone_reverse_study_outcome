package com.bytedance.android.livesdk.message.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@ProtoMessage("webcast.im.LinkmicGameBarrageRtcRoomCreateContent")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\b\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0010\u0010\u0011R$\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001d\u0010\u000f\u001a\u0004\u0018\u00010\n8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/ILinkmicGameBarrageRtcRoomCreateContentFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/message/model/h9;", "Lcom/bytedance/android/livesdk/chatroom/model/interact/k0;", "gameInfo", "Lcom/bytedance/android/livesdk/chatroom/model/interact/k0;", "getGameInfo", "()Lcom/bytedance/android/livesdk/chatroom/model/interact/k0;", "setGameInfo", "(Lcom/bytedance/android/livesdk/chatroom/model/interact/k0;)V", "", "cloudGamePublicStreamId$delegate", "Ljava/lang/Object;", "getCloudGamePublicStreamId", "()Ljava/lang/String;", "cloudGamePublicStreamId", "<init>", "()V", "live-business-message-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class ILinkmicGameBarrageRtcRoomCreateContentFlexImpl extends FlexModelBase<h9> implements h9, vh7.h {

    @SerializedName("cd_game_public_stream_id")
    protected String _$$cloudGamePublicStreamId;

    @SerializedName("game_info")
    protected com.bytedance.android.livesdk.chatroom.model.interact.k0 gameInfo;

    public ILinkmicGameBarrageRtcRoomCreateContentFlexImpl() {
        super(h9.class);
    }

    /* JADX WARN: Type inference failed for: r2v3, types: [com.bytedance.android.livesdk.chatroom.model.interact.k0, java.lang.Object] */
    public ILinkmicGameBarrageRtcRoomCreateContentFlexImpl(am3.g r100) {
        super(h9.class);
        setThreadSafe(false);
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L12;
        am3.g.a r103 = decodeExtensionFields(r102, r100);
        if (r102 != 1) goto L8;
        this.gameInfo = vh7.f.a(r100, com.bytedance.android.livesdk.chatroom.model.interact.k0.class);
        goto L3
    L8:
        if (r102 != 2) goto L9;
        this._$$cloudGamePublicStreamId = am3.h.c(r100);
        goto L3
    L9:
        am3.h.d(r103, r100);
        goto L3
    L12:
        r100.d(r101);
        setThreadSafe(true);
    }

    @Override // com.bytedance.android.livesdk.message.model.h9
    public final String getCloudGamePublicStreamId() {
        return this._$$cloudGamePublicStreamId;
    }

    @Override // com.bytedance.android.livesdk.message.model.h9
    public com.bytedance.android.livesdk.chatroom.model.interact.k0 getGameInfo() {
        return this.gameInfo;
    }

    public void setGameInfo(com.bytedance.android.livesdk.chatroom.model.interact.k0 r100) {
        this.gameInfo = r100;
    }
}
