package com.bytedance.android.livesdk.link.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.larus.avlink.aiproactive.AiProactiveTaskViewModel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes10.dex */
@ProtoMessage("webcast.data.TeamTask.Config")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010 \n\u0002\b\n\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\"\u0010#R)\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tR\u001b\u0010\u000e\u001a\u00020\u00048VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\u0007\u001a\u0004\b\f\u0010\rR\u001b\u0010\u0013\u001a\u00020\u000f8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0007\u001a\u0004\b\u0011\u0010\u0012R\u001b\u0010\u0016\u001a\u00020\u000f8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u0007\u001a\u0004\b\u0015\u0010\u0012R\u001b\u0010\u0019\u001a\u00020\u000f8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u0007\u001a\u0004\b\u0018\u0010\u0012R#\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u001a8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u0007\u001a\u0004\b\u001c\u0010\u001dR\u001b\u0010!\u001a\u00020\u000f8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u001f\u0010\u0007\u001a\u0004\b \u0010\u0012¨\u0006$"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/ITeamTaskConfigFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/link/model/q9;", "", "", "Lcom/bytedance/android/livesdk/link/model/ITeamTaskPeriodConfigFlexImpl;", "teamTaskPeriodConfig$delegate", "Ljava/lang/Object;", "getTeamTaskPeriodConfig", "()Ljava/util/Map;", "teamTaskPeriodConfig", "rewardBuffMultiple$delegate", "getRewardBuffMultiple", "()J", "rewardBuffMultiple", "", "taskType$delegate", "getTaskType", "()I", "taskType", "targetType$delegate", "getTargetType", "targetType", "rewardType$delegate", "getRewardType", "rewardType", "", "stageRewardBuffMultiple$delegate", "getStageRewardBuffMultiple", "()Ljava/util/List;", "stageRewardBuffMultiple", "workType$delegate", "getWorkType", "workType", "<init>", "()V", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class ITeamTaskConfigFlexImpl extends FlexModelBase<q9> implements q9, vh7.h {

    @SerializedName("reward_buff_multiple")
    protected long _$$rewardBuffMultiple;

    @SerializedName("reward_type")
    protected int _$$rewardType;

    @SerializedName("stage_reward_buff_multiple")
    protected List<Long> _$$stageRewardBuffMultiple;

    @SerializedName("target_type")
    protected int _$$targetType;

    @SerializedName(AiProactiveTaskViewModel.PARAM_TASK_TYPE)
    protected int _$$taskType;

    @SerializedName("period_config")
    protected Map<Long, ITeamTaskPeriodConfigFlexImpl> _$$teamTaskPeriodConfig;

    @SerializedName("team_work_team_task_type")
    protected int _$$workType;

    public ITeamTaskConfigFlexImpl() {
        super(q9.class);
    }

    @Override // com.bytedance.android.livesdk.link.model.q9
    public final long getRewardBuffMultiple() {
        return this._$$rewardBuffMultiple;
    }

    @Override // com.bytedance.android.livesdk.link.model.q9
    public final int getRewardType() {
        return this._$$rewardType;
    }

    @Override // com.bytedance.android.livesdk.link.model.q9
    public final List<Long> getStageRewardBuffMultiple() {
        return this._$$stageRewardBuffMultiple;
    }

    @Override // com.bytedance.android.livesdk.link.model.q9
    public final int getTargetType() {
        return this._$$targetType;
    }

    @Override // com.bytedance.android.livesdk.link.model.q9
    public final int getTaskType() {
        return this._$$taskType;
    }

    @Override // com.bytedance.android.livesdk.link.model.q9
    public final Map<Long, ITeamTaskPeriodConfigFlexImpl> getTeamTaskPeriodConfig() {
        return this._$$teamTaskPeriodConfig;
    }

    @Override // com.bytedance.android.livesdk.link.model.q9
    public final int getWorkType() {
        return this._$$workType;
    }

    public ITeamTaskConfigFlexImpl(am3.g r110) {
        super(q9.class);
        this._$$teamTaskPeriodConfig = new HashMap();
        this._$$stageRewardBuffMultiple = new ArrayList();
        setThreadSafe(false);
        long r100 = r110.c();
    L3:
        int r101 = r110.f();
        if (r101 == (-1)) goto L31;
        am3.g.a r102 = decodeExtensionFields(r101, r110);
        switch(r101) {
            case 1: goto L14;
            case 2: goto L13;
            case 3: goto L12;
            case 4: goto L7;
            case 5: goto L11;
            case 6: goto L10;
            case 7: goto L9;
            case 8: goto L8;
            default: goto L7;
        };
    L8:
        this._$$stageRewardBuffMultiple.add(Long.valueOf(r110.j()));
        goto L3
    L9:
        this._$$workType = r110.i();
        goto L3
    L10:
        this._$$rewardType = r110.i();
        goto L3
    L11:
        this._$$targetType = r110.i();
        goto L3
    L12:
        this._$$taskType = r110.i();
        goto L3
    L13:
        this._$$rewardBuffMultiple = r110.j();
        goto L3
    L14:
        long r103 = r110.c();
        Long r104 = null;
        ITeamTaskPeriodConfigFlexImpl r105 = null;
    L15:
        int r106 = r110.f();
        if (r106 == (-1)) goto L23;
        if (r106 != 1) goto L19;
        r104 = Long.valueOf(r110.j());
        goto L15
    L19:
        if (r106 != 2) goto L20;
        r105 = new ITeamTaskPeriodConfigFlexImpl(r110);
        goto L15
    L20:
        am3.h.e(r110);
        goto L15
    L23:
        r110.d(r103);
        Map<Long, ITeamTaskPeriodConfigFlexImpl> r107 = this._$$teamTaskPeriodConfig;
        if (r104 == null) goto L30;
        if (r105 == null) goto L28;
        r107.put(r104, r105);
        goto L3
    L28:
        throw new IllegalStateException("Value must not be null");
    L30:
        throw new IllegalStateException("Key must not be null");
    L7:
        am3.h.d(r102, r110);
        goto L3
    L31:
        r110.d(r100);
        setThreadSafe(true);
    }
}
