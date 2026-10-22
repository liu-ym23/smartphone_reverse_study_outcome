package com.bytedance.android.livesdkapi.depend.model.live;

import am3.g;
import com.bytedance.android.livesdk.schema.AudienceGamePromoteDetailActionHandler;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.ss.android.downloadlib.constants.EventConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import vh7.h;

/* JADX INFO: loaded from: classes12.dex */
@ProtoMessage("webcast.data.GameCPData")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\b\u0007\u0018\u0000 \u00122\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002:\u0001\u0012B\u0005¢\u0006\u0002\u0010\u0003R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0016X\u0097\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00058\u0016X\u0097\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007R\u0016\u0010\n\u001a\u00020\u000b8\u0016X\u0097D¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\fR\u001a\u0010\r\u001a\u0004\u0018\u00010\u000e8\u0016X\u0097\u0004¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/GameCPData;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdkapi/depend/model/live/IGameCPData;", "()V", "gameId", "", "getGameId", "()Ljava/lang/String;", "gameName", "getGameName", "isAPromotedA", "", "()I", "promoteInstanceId", "", "getPromoteInstanceId", "()Ljava/lang/Long;", "Ljava/lang/Long;", "Companion", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class GameCPData extends FlexModelBase<IGameCPData> implements IGameCPData, h {
    public static final Companion Companion = null;
    public static final int GAME_CP_DATA_IS_A_PROMOTED_A = 1;
    public static final int GAME_CP_DATA_NOT_A_PROMOTED_A = 2;
    public static final int GAME_CP_DATA_UNKNOWN = 0;

    @SerializedName("game_id")
    protected String gameId;

    @SerializedName(EventConstants.ExtraJson.GAME_NAME)
    protected String gameName;

    @SerializedName("is_live_a_promoted_a")
    protected int isAPromotedA;

    @SerializedName(AudienceGamePromoteDetailActionHandler.PROMOTE_INSTANCE_ID)
    protected Long promoteInstanceId;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/GameCPData$Companion;", "", "()V", "GAME_CP_DATA_IS_A_PROMOTED_A", "", "GAME_CP_DATA_NOT_A_PROMOTED_A", "GAME_CP_DATA_UNKNOWN", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
    }

    public GameCPData() {
        super(IGameCPData.class);
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IGameCPData
    public String getGameId() {
        return this.gameId;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IGameCPData
    public String getGameName() {
        return this.gameName;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IGameCPData
    public Long getPromoteInstanceId() {
        return this.promoteInstanceId;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IGameCPData
    public int isAPromotedA() {
        return this.isAPromotedA;
    }

    public GameCPData(g r100) {
        super(IGameCPData.class);
        setThreadSafe(false);
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L18;
        g.a r103 = decodeExtensionFields(r102, r100);
        if (r102 != 1) goto L8;
        this.isAPromotedA = r100.i();
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this.gameId = am3.h.c(r100);
        goto L3
    L10:
        if (r102 != 3) goto L12;
        this.gameName = am3.h.c(r100);
        goto L3
    L12:
        if (r102 != 4) goto L13;
        this.promoteInstanceId = Long.valueOf(r100.j());
        goto L3
    L13:
        am3.h.d(r103, r100);
        goto L3
    L18:
        r100.d(r101);
        setThreadSafe(true);
    }
}
