package com.bytedance.android.livesdkapi.depend.model.live;

import am3.g;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import com.larus.avlink.aiproactive.AiProactiveTaskViewModel;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: classes12.dex */
@ProtoMessage("webcast.data.TeamTask.Config")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR,\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/TeamTaskConfig;", "", "()V", "rewardBuffMultiple", "", "getRewardBuffMultiple", "()J", "setRewardBuffMultiple", "(J)V", "taskType", "getTaskType", "setTaskType", "teamTaskPeriodConfig", "", "Lcom/bytedance/android/livesdkapi/depend/model/live/TeamTaskPeriodConfig;", "getTeamTaskPeriodConfig", "()Ljava/util/Map;", "setTeamTaskPeriodConfig", "(Ljava/util/Map;)V", "livebase_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class TeamTaskConfig implements h {

    @SerializedName("reward_buff_multiple")
    protected long rewardBuffMultiple;

    @SerializedName(AiProactiveTaskViewModel.PARAM_TASK_TYPE)
    protected long taskType;

    @SerializedName("period_config")
    protected Map<Long, TeamTaskPeriodConfig> teamTaskPeriodConfig;

    public TeamTaskConfig() {
    }

    public final long getRewardBuffMultiple() {
        return this.rewardBuffMultiple;
    }

    public final long getTaskType() {
        return this.taskType;
    }

    public final Map<Long, TeamTaskPeriodConfig> getTeamTaskPeriodConfig() {
        return this.teamTaskPeriodConfig;
    }

    public TeamTaskConfig(g r110) {
        this.teamTaskPeriodConfig = new HashMap();
        long r100 = r110.c();
    L3:
        int r101 = r110.f();
        if (r101 == (-1)) goto L29;
        if (r101 != 1) goto L7;
        long r102 = r110.c();
        Long r103 = null;
        TeamTaskPeriodConfig r104 = null;
    L14:
        int r105 = r110.f();
        if (r105 == (-1)) goto L21;
        if (r105 != 1) goto L17;
        r103 = Long.valueOf(r110.j());
        goto L14
    L17:
        if (r105 != 2) goto L18;
        r104 = new TeamTaskPeriodConfig(r110);
        goto L14
    L18:
        am3.h.e(r110);
        goto L14
    L21:
        r110.d(r102);
        Map<Long, TeamTaskPeriodConfig> r106 = this.teamTaskPeriodConfig;
        if (r103 == null) goto L28;
        if (r104 == null) goto L26;
        r106.put(r103, r104);
        goto L3
    L26:
        throw new IllegalStateException("Value must not be null");
    L28:
        throw new IllegalStateException("Key must not be null");
    L7:
        if (r101 != 2) goto L9;
        this.rewardBuffMultiple = r110.j();
        goto L3
    L9:
        if (r101 != 3) goto L10;
        this.taskType = r110.i();
        goto L3
    L10:
        am3.h.e(r110);
        goto L3
    L29:
        r110.d(r100);
    }

    public final void setRewardBuffMultiple(long r100) {
        this.rewardBuffMultiple = r100;
    }

    public final void setTaskType(long r100) {
        this.taskType = r100;
    }

    public final void setTeamTaskPeriodConfig(Map<Long, TeamTaskPeriodConfig> r100) {
        this.teamTaskPeriodConfig = r100;
    }
}
