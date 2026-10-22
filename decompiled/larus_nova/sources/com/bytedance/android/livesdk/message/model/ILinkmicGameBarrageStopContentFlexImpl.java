package com.bytedance.android.livesdk.message.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@ProtoMessage("webcast.im.LinkmicGameBarrageStopContent")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\n\u0010\u000bR$\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/ILinkmicGameBarrageStopContentFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/message/model/j9;", "Lcom/bytedance/android/livesdk/chatroom/model/interact/k0;", "gameInfo", "Lcom/bytedance/android/livesdk/chatroom/model/interact/k0;", "getGameInfo", "()Lcom/bytedance/android/livesdk/chatroom/model/interact/k0;", "setGameInfo", "(Lcom/bytedance/android/livesdk/chatroom/model/interact/k0;)V", "<init>", "()V", "live-business-message-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class ILinkmicGameBarrageStopContentFlexImpl extends FlexModelBase<j9> implements j9, vh7.h {

    @SerializedName("game_info")
    protected com.bytedance.android.livesdk.chatroom.model.interact.k0 gameInfo;

    public ILinkmicGameBarrageStopContentFlexImpl() {
        super(j9.class);
    }

    /* JADX WARN: Type inference failed for: r2v2, types: [com.bytedance.android.livesdk.chatroom.model.interact.k0, java.lang.Object] */
    public ILinkmicGameBarrageStopContentFlexImpl(am3.g r100) {
        super(j9.class);
        setThreadSafe(false);
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L9;
        am3.g.a r103 = decodeExtensionFields(r102, r100);
        if (r102 != 1) goto L7;
        this.gameInfo = vh7.f.a(r100, com.bytedance.android.livesdk.chatroom.model.interact.k0.class);
        goto L3
    L7:
        am3.h.d(r103, r100);
        goto L3
    L9:
        r100.d(r101);
        setThreadSafe(true);
    }

    @Override // com.bytedance.android.livesdk.message.model.j9
    public com.bytedance.android.livesdk.chatroom.model.interact.k0 getGameInfo() {
        return this.gameInfo;
    }

    public void setGameInfo(com.bytedance.android.livesdk.chatroom.model.interact.k0 r100) {
        this.gameInfo = r100;
    }
}
