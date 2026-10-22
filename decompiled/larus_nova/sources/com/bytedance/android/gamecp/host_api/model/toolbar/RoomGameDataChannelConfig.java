package com.bytedance.android.gamecp.host_api.model.toolbar;

import am3.g;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: classes44.dex */
@ProtoMessage("webcast.data.RoomGameDataChannelConfig")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\t\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\f\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0012\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/gamecp/host_api/model/toolbar/RoomGameDataChannelConfig;", "", "()V", "fusionTagId", "", "getFusionTagId", "()Ljava/lang/String;", "setFusionTagId", "(Ljava/lang/String;)V", "gameId", "getGameId", "setGameId", "liveStayLimit", "", "getLiveStayLimit", "()Ljava/lang/Long;", "setLiveStayLimit", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "gamecp-host-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class RoomGameDataChannelConfig implements h {

    @SerializedName("fusion_tag_id")
    protected String fusionTagId;

    @SerializedName("game_id")
    protected String gameId;

    @SerializedName("live_stay_limit")
    protected Long liveStayLimit;

    public RoomGameDataChannelConfig() {
        this.liveStayLimit = 0L;
    }

    public final String getFusionTagId() {
        return this.fusionTagId;
    }

    public final String getGameId() {
        return this.gameId;
    }

    public final Long getLiveStayLimit() {
        return this.liveStayLimit;
    }

    public RoomGameDataChannelConfig(g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L15;
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
        am3.h.e(r100);
        goto L3
    L15:
        r100.d(r101);
        if (this.liveStayLimit != null) goto L31;
        this.liveStayLimit = 0L;
        return;
    }

    public final void setFusionTagId(String r100) {
        this.fusionTagId = r100;
    }

    public final void setGameId(String r100) {
        this.gameId = r100;
    }

    public final void setLiveStayLimit(Long r100) {
        this.liveStayLimit = r100;
    }
}
