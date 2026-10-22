package com.bytedance.android.livesdk.message.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@ProtoMessage("webcast.data.TeamfightEggInfo")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\t\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0013\u0010\u0014R0\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR$\u0010\r\u001a\u0004\u0018\u00010\f8\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/TeamfightEggInfo;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/message/model/yb;", "", "", "Lcom/bytedance/android/livesdk/message/model/LinkmicProfitEggInfo;", "teamEggMap", "Ljava/util/Map;", "getTeamEggMap", "()Ljava/util/Map;", "setTeamEggMap", "(Ljava/util/Map;)V", "", "teamBattleTeamType", "Ljava/lang/Integer;", "getTeamBattleTeamType", "()Ljava/lang/Integer;", "setTeamBattleTeamType", "(Ljava/lang/Integer;)V", "<init>", "()V", "livemessage-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class TeamfightEggInfo extends FlexModelBase<yb> implements yb, vh7.h {

    @SerializedName("team_battle_team_type")
    protected Integer teamBattleTeamType;

    @SerializedName("team_egg_map")
    protected Map<Long, LinkmicProfitEggInfo> teamEggMap;

    public TeamfightEggInfo() {
        super(yb.class);
    }

    @Override // com.bytedance.android.livesdk.message.model.yb
    public Integer getTeamBattleTeamType() {
        return this.teamBattleTeamType;
    }

    @Override // com.bytedance.android.livesdk.message.model.yb
    public Map<Long, LinkmicProfitEggInfo> getTeamEggMap() {
        return this.teamEggMap;
    }

    public TeamfightEggInfo(am3.g r110) {
        super(yb.class);
        this.teamEggMap = new HashMap();
        setThreadSafe(false);
        long r100 = r110.c();
    L3:
        int r101 = r110.f();
        if (r101 == (-1)) goto L26;
        am3.g.a r102 = decodeExtensionFields(r101, r110);
        if (r101 != 1) goto L7;
        long r103 = r110.c();
        Long r104 = null;
        LinkmicProfitEggInfo r105 = null;
    L11:
        int r106 = r110.f();
        if (r106 == (-1)) goto L18;
        if (r106 != 1) goto L14;
        r104 = Long.valueOf(r110.j());
        goto L11
    L14:
        if (r106 != 2) goto L15;
        r105 = new LinkmicProfitEggInfo(r110);
        goto L11
    L15:
        am3.h.e(r110);
        goto L11
    L18:
        r110.d(r103);
        Map<Long, LinkmicProfitEggInfo> r107 = this.teamEggMap;
        if (r104 == null) goto L25;
        if (r105 == null) goto L23;
        r107.put(r104, r105);
        goto L3
    L23:
        throw new IllegalStateException("Value must not be null");
    L25:
        throw new IllegalStateException("Key must not be null");
    L7:
        if (r101 != 2) goto L8;
        this.teamBattleTeamType = Integer.valueOf(r110.i());
        goto L3
    L8:
        am3.h.d(r102, r110);
        goto L3
    L26:
        r110.d(r100);
        setThreadSafe(true);
    }

    public void setTeamBattleTeamType(Integer r100) {
        this.teamBattleTeamType = r100;
    }

    public void setTeamEggMap(Map<Long, LinkmicProfitEggInfo> r100) {
        this.teamEggMap = r100;
    }
}
