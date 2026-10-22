package com.bytedance.android.livesdkapi.depend.model.live;

import am3.g;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: classes12.dex */
@ProtoMessage("webcast.data.TeamTask.Info")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001e\u0010\f\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\u001e\u0010\u000f\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\u001e\u0010\u0012\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR \u0010\u0015\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a¨\u0006\u001b"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/TeamTaskInfo;", "", "()V", "finishUserCount", "", "getFinishUserCount", "()J", "setFinishUserCount", "(J)V", MapBundleKey.OfflineMapKey.OFFLINE_RATION, "getRatio", "setRatio", "role", "getRole", "setRole", "targetUserCount", "getTargetUserCount", "setTargetUserCount", "teamTaskResult", "getTeamTaskResult", "setTeamTaskResult", "teamTaskReward", "Lcom/bytedance/android/livesdkapi/depend/model/live/TeamTaskReward;", "getTeamTaskReward", "()Lcom/bytedance/android/livesdkapi/depend/model/live/TeamTaskReward;", "setTeamTaskReward", "(Lcom/bytedance/android/livesdkapi/depend/model/live/TeamTaskReward;)V", "livebase_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class TeamTaskInfo implements h {

    @SerializedName("finish_user_count")
    protected long finishUserCount;

    @SerializedName(MapBundleKey.OfflineMapKey.OFFLINE_RATION)
    protected long ratio;

    @SerializedName("role")
    protected long role;

    @SerializedName("target_user_count")
    protected long targetUserCount;

    @SerializedName("result")
    protected long teamTaskResult;

    @SerializedName("reward")
    protected TeamTaskReward teamTaskReward;

    public TeamTaskInfo() {
    }

    public final long getFinishUserCount() {
        return this.finishUserCount;
    }

    public final long getRatio() {
        return this.ratio;
    }

    public final long getRole() {
        return this.role;
    }

    public final long getTargetUserCount() {
        return this.targetUserCount;
    }

    public final long getTeamTaskResult() {
        return this.teamTaskResult;
    }

    public final TeamTaskReward getTeamTaskReward() {
        return this.teamTaskReward;
    }

    public TeamTaskInfo(g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L13;
        switch(r102) {
            case 1: goto L12;
            case 2: goto L11;
            case 3: goto L10;
            case 4: goto L9;
            case 5: goto L8;
            case 6: goto L7;
            default: goto L6;
        };
    L7:
        this.role = r100.i();
        goto L3
    L8:
        this.ratio = r100.j();
        goto L3
    L9:
        this.teamTaskReward = new TeamTaskReward(r100);
        goto L3
    L10:
        this.teamTaskResult = r100.i();
        goto L3
    L11:
        this.finishUserCount = r100.j();
        goto L3
    L12:
        this.targetUserCount = r100.j();
        goto L3
    L6:
        am3.h.e(r100);
        goto L3
    L13:
        r100.d(r101);
    }

    public final void setFinishUserCount(long r100) {
        this.finishUserCount = r100;
    }

    public final void setRatio(long r100) {
        this.ratio = r100;
    }

    public final void setRole(long r100) {
        this.role = r100;
    }

    public final void setTargetUserCount(long r100) {
        this.targetUserCount = r100;
    }

    public final void setTeamTaskResult(long r100) {
        this.teamTaskResult = r100;
    }

    public final void setTeamTaskReward(TeamTaskReward r100) {
        this.teamTaskReward = r100;
    }
}
