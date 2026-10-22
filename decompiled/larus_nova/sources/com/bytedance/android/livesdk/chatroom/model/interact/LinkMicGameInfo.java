package com.bytedance.android.livesdk.chatroom.model.interact;

import com.bytedance.android.gamecp.business.instantplay.InstantPlayContext;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
@ProtoMessage("webcast.data.LinkmicGameInfo")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u000f\n\u0002\u0010\b\n\u0002\b\f\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u001f\u0010 J\b\u0010\u0004\u001a\u00020\u0003H\u0016R\"\u0010\u0006\u001a\u00020\u00058\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\"\u0010\f\u001a\u00020\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\"\u0010\u0012\u001a\u00020\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\r\u001a\u0004\b\u0013\u0010\u000f\"\u0004\b\u0014\u0010\u0011R\"\u0010\u0016\u001a\u00020\u00158\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\"\u0010\u001c\u001a\u00020\u00158\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u0017\u001a\u0004\b\u001d\u0010\u0019\"\u0004\b\u001e\u0010\u001b¨\u0006!"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/model/interact/LinkMicGameInfo;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/chatroom/model/interact/k0;", "", "toString", "", "playId", "J", "getPlayId", "()J", "setPlayId", "(J)V", "gameId", "Ljava/lang/String;", "getGameId", "()Ljava/lang/String;", "setGameId", "(Ljava/lang/String;)V", "gameCategory", "getGameCategory", "setGameCategory", "", "runningType", "I", "getRunningType", "()I", "setRunningType", "(I)V", "publicStreamType", "getPublicStreamType", "setPublicStreamType", "<init>", "()V", "livebase_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LinkMicGameInfo extends FlexModelBase<k0> implements k0, vh7.h {

    @SerializedName(BdpAppEventConstant.PARAMS_GAME_CATEGORY)
    protected String gameCategory;

    @SerializedName("game_id")
    protected String gameId;

    @SerializedName(InstantPlayContext.PLAY_ID)
    protected long playId;

    @SerializedName("public_stream_type")
    protected int publicStreamType;

    @SerializedName("running_type")
    protected int runningType;

    public LinkMicGameInfo() {
        super(k0.class);
        this.gameId = "";
        this.gameCategory = "";
    }

    public String toString() {
        return "LinkMicGameInfo(playId=" + getPlayId() + ", gameId='" + getGameId() + "', gameCategory='" + getGameCategory() + "', runningType=" + getRunningType() + ", publicStreamType=" + getPublicStreamType() + ')';
    }

    @Override // com.bytedance.android.livesdk.chatroom.model.interact.k0
    public String getGameCategory() {
        return this.gameCategory;
    }

    @Override // com.bytedance.android.livesdk.chatroom.model.interact.k0
    public String getGameId() {
        return this.gameId;
    }

    @Override // com.bytedance.android.livesdk.chatroom.model.interact.k0
    public long getPlayId() {
        return this.playId;
    }

    @Override // com.bytedance.android.livesdk.chatroom.model.interact.k0
    public int getPublicStreamType() {
        return this.publicStreamType;
    }

    @Override // com.bytedance.android.livesdk.chatroom.model.interact.k0
    public int getRunningType() {
        return this.runningType;
    }

    public LinkMicGameInfo(am3.g r100) {
        super(k0.class);
        setThreadSafe(false);
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L21;
        am3.g.a r103 = decodeExtensionFields(r102, r100);
        if (r102 != 1) goto L8;
        this.playId = r100.j();
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this.gameId = am3.h.c(r100);
        goto L3
    L10:
        if (r102 != 3) goto L12;
        this.gameCategory = am3.h.c(r100);
        goto L3
    L12:
        if (r102 != 4) goto L14;
        this.runningType = r100.i();
        goto L3
    L14:
        if (r102 != 5) goto L15;
        this.publicStreamType = r100.i();
        goto L3
    L15:
        am3.h.d(r103, r100);
        goto L3
    L21:
        r100.d(r101);
        setThreadSafe(true);
        if (this.gameId != null) goto L25;
        this.gameId = "";
    L25:
        if (this.gameCategory != null) goto L46;
        this.gameCategory = "";
        return;
    }

    public void setGameCategory(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.gameCategory = r100;
    }

    public void setGameId(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.gameId = r100;
    }

    public void setPlayId(long r100) {
        this.playId = r100;
    }

    public void setPublicStreamType(int r100) {
        this.publicStreamType = r100;
    }

    public void setRunningType(int r100) {
        this.runningType = r100;
    }
}
