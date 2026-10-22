package com.bytedance.android.live.liveinteract.plantform.model;

import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes46.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
public class TeamFightJoinTeamInfo extends FlexModelBase<j0> implements j0 {

    @SerializedName("team_id")
    public long teamId;

    public TeamFightJoinTeamInfo() {
        super(j0.class);
    }

    public int hashCode() {
        return (int) this.teamId;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.j0
    public long getTeamId() {
        return this.teamId;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 != null) goto L9;
        return false;
    L9:
        if ((r100 instanceof TeamFightJoinTeamInfo) == true) goto L11;
        return false;
    L11:
        if (this.teamId == ((TeamFightJoinTeamInfo) r100).teamId) goto L16;
        return false;
    L16:
        return true;
    }

    public boolean isEqual(TeamFightJoinTeamInfo r100) {
        if (r100 != null) goto L6;
        return false;
    L6:
        if (this.teamId != r100.teamId) goto L9;
        return true;
    L9:
        return false;
    }
}
