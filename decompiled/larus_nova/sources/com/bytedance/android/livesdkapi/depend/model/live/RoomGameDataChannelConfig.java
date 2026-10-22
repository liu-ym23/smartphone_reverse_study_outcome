package com.bytedance.android.livesdkapi.depend.model.live;

import am3.g;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: classes12.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0006\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003R \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR \u0010\n\u001a\u0004\u0018\u00010\u00058\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\"\u0010\r\u001a\u0004\u0018\u00010\u000e8\u0016@\u0016X\u0097\u000e¢\u0006\u0010\n\u0002\u0010\u0013\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/RoomGameDataChannelConfig;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdkapi/depend/model/live/IRoomGameDataChannelConfig;", "()V", "fusionTagId", "", "getFusionTagId", "()Ljava/lang/String;", "setFusionTagId", "(Ljava/lang/String;)V", "gameId", "getGameId", "setGameId", "liveStayLimit", "", "getLiveStayLimit", "()Ljava/lang/Long;", "setLiveStayLimit", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class RoomGameDataChannelConfig extends FlexModelBase<IRoomGameDataChannelConfig> implements IRoomGameDataChannelConfig, h {

    @SerializedName("fusion_tag_id")
    protected String fusionTagId;

    @SerializedName("game_id")
    protected String gameId;

    @SerializedName("live_stay_limit")
    protected Long liveStayLimit;

    public RoomGameDataChannelConfig() {
        super(IRoomGameDataChannelConfig.class);
        this.liveStayLimit = 0L;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IRoomGameDataChannelConfig
    public String getFusionTagId() {
        return this.fusionTagId;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IRoomGameDataChannelConfig
    public String getGameId() {
        return this.gameId;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IRoomGameDataChannelConfig
    public Long getLiveStayLimit() {
        return this.liveStayLimit;
    }

    public RoomGameDataChannelConfig(g r100) {
        super(IRoomGameDataChannelConfig.class);
        setThreadSafe(false);
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L15;
        g.a r103 = decodeExtensionFields(r102, r100);
        if (r102 != 1) goto L8;
        this.fusionTagId = am3.h.c(r100);
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this.gameId = am3.h.c(r100);
        goto L3
    L10:
        if (r102 != 3) goto L11;
        this.liveStayLimit = Long.valueOf(r100.j());
        goto L3
    L11:
        am3.h.d(r103, r100);
        goto L3
    L15:
        r100.d(r101);
        setThreadSafe(true);
        if (this.liveStayLimit != null) goto L31;
        this.liveStayLimit = 0L;
        return;
    }

    public void setFusionTagId(String r100) {
        this.fusionTagId = r100;
    }

    public void setGameId(String r100) {
        this.gameId = r100;
    }

    public void setLiveStayLimit(Long r100) {
        this.liveStayLimit = r100;
    }
}
