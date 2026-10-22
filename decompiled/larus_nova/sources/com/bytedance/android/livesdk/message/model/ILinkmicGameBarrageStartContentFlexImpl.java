package com.bytedance.android.livesdk.message.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@ProtoMessage("webcast.im.LinkmicGameBarrageStartContent")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0010\t\n\u0002\b\u000e\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u001d\u0010\u001eR$\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001d\u0010\u000f\u001a\u0004\u0018\u00010\n8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR#\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u00108VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\f\u001a\u0004\b\u0013\u0010\u0014R+\u0010\u001c\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u00118V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u0017\u0010\f\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b¨\u0006\u001f"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/ILinkmicGameBarrageStartContentFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/message/model/i9;", "Lcom/bytedance/android/livesdk/chatroom/model/interact/k0;", "gameInfo", "Lcom/bytedance/android/livesdk/chatroom/model/interact/k0;", "getGameInfo", "()Lcom/bytedance/android/livesdk/chatroom/model/interact/k0;", "setGameInfo", "(Lcom/bytedance/android/livesdk/chatroom/model/interact/k0;)V", "", "audienceToast$delegate", "Ljava/lang/Object;", "getAudienceToast", "()Ljava/lang/String;", "audienceToast", "", "", "kickOutUserIds$delegate", "getKickOutUserIds", "()Ljava/util/List;", "kickOutUserIds", "<set-?>", "targetUiLayout$delegate", "getTargetUiLayout", "()J", "setTargetUiLayout", "(J)V", "targetUiLayout", "<init>", "()V", "live-business-message-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class ILinkmicGameBarrageStartContentFlexImpl extends FlexModelBase<i9> implements i9, vh7.h {

    @SerializedName("audience_toast")
    protected String _$$audienceToast;

    @SerializedName("kick_out_user_ids")
    protected List<Long> _$$kickOutUserIds;

    @SerializedName("target_ui_layout")
    protected long _$$targetUiLayout;

    @SerializedName("game_info")
    protected com.bytedance.android.livesdk.chatroom.model.interact.k0 gameInfo;

    public ILinkmicGameBarrageStartContentFlexImpl() {
        super(i9.class);
    }

    @Override // com.bytedance.android.livesdk.message.model.i9
    public final String getAudienceToast() {
        return this._$$audienceToast;
    }

    @Override // com.bytedance.android.livesdk.message.model.i9
    public com.bytedance.android.livesdk.chatroom.model.interact.k0 getGameInfo() {
        return this.gameInfo;
    }

    @Override // com.bytedance.android.livesdk.message.model.i9
    public final List<Long> getKickOutUserIds() {
        return this._$$kickOutUserIds;
    }

    @Override // com.bytedance.android.livesdk.message.model.i9
    public final long getTargetUiLayout() {
        return this._$$targetUiLayout;
    }

    /* JADX WARN: Type inference failed for: r2v5, types: [com.bytedance.android.livesdk.chatroom.model.interact.k0, java.lang.Object] */
    public ILinkmicGameBarrageStartContentFlexImpl(am3.g r100) {
        super(i9.class);
        this._$$kickOutUserIds = new ArrayList();
        setThreadSafe(false);
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L18;
        am3.g.a r103 = decodeExtensionFields(r102, r100);
        if (r102 != 1) goto L8;
        this.gameInfo = vh7.f.a(r100, com.bytedance.android.livesdk.chatroom.model.interact.k0.class);
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this._$$audienceToast = am3.h.c(r100);
        goto L3
    L10:
        if (r102 != 3) goto L12;
        this._$$kickOutUserIds.add(Long.valueOf(r100.j()));
        goto L3
    L12:
        if (r102 != 4) goto L13;
        this._$$targetUiLayout = r100.j();
        goto L3
    L13:
        am3.h.d(r103, r100);
        goto L3
    L18:
        r100.d(r101);
        setThreadSafe(true);
    }

    public void setGameInfo(com.bytedance.android.livesdk.chatroom.model.interact.k0 r100) {
        this.gameInfo = r100;
    }

    @Override // com.bytedance.android.livesdk.message.model.i9
    public final void setTargetUiLayout(long r100) {
        this._$$targetUiLayout = r100;
    }
}
