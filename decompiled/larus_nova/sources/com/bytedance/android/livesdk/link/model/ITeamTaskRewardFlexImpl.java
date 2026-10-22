package com.bytedance.android.livesdk.link.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes10.dex */
@ProtoMessage("webcast.data.TeamTask.Reward")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0011\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0012\u0010\u0013R\u001b\u0010\b\u001a\u00020\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\u000b\u001a\u00020\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\u0005\u001a\u0004\b\n\u0010\u0007R\u001b\u0010\u000e\u001a\u00020\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\u0005\u001a\u0004\b\r\u0010\u0007R\u001b\u0010\u0011\u001a\u00020\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0005\u001a\u0004\b\u0010\u0010\u0007¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/ITeamTaskRewardFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/link/model/t9;", "", "beginSecond$delegate", "Ljava/lang/Object;", "getBeginSecond", "()J", "beginSecond", "endSecond$delegate", "getEndSecond", "endSecond", "rewardScore$delegate", "getRewardScore", "rewardScore", "currentRewardBuffMultiple$delegate", "getCurrentRewardBuffMultiple", "currentRewardBuffMultiple", "<init>", "()V", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class ITeamTaskRewardFlexImpl extends FlexModelBase<t9> implements t9, vh7.h {

    @SerializedName("begin_second_relative_battle_finish")
    protected long _$$beginSecond;

    @SerializedName("current_reward_buff_multiple")
    protected long _$$currentRewardBuffMultiple;

    @SerializedName("end_second_relative_battle_finish")
    protected long _$$endSecond;

    @SerializedName("reward_score")
    protected long _$$rewardScore;

    public ITeamTaskRewardFlexImpl() {
        super(t9.class);
    }

    @Override // com.bytedance.android.livesdk.link.model.t9
    public final long getBeginSecond() {
        return this._$$beginSecond;
    }

    @Override // com.bytedance.android.livesdk.link.model.t9
    public final long getCurrentRewardBuffMultiple() {
        return this._$$currentRewardBuffMultiple;
    }

    @Override // com.bytedance.android.livesdk.link.model.t9
    public final long getEndSecond() {
        return this._$$endSecond;
    }

    @Override // com.bytedance.android.livesdk.link.model.t9
    public final long getRewardScore() {
        return this._$$rewardScore;
    }

    public ITeamTaskRewardFlexImpl(am3.g r100) {
        super(t9.class);
        setThreadSafe(false);
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L18;
        am3.g.a r103 = decodeExtensionFields(r102, r100);
        if (r102 != 1) goto L8;
        this._$$beginSecond = r100.j();
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this._$$endSecond = r100.j();
        goto L3
    L10:
        if (r102 != 3) goto L12;
        this._$$rewardScore = r100.j();
        goto L3
    L12:
        if (r102 != 4) goto L13;
        this._$$currentRewardBuffMultiple = r100.j();
        goto L3
    L13:
        am3.h.d(r103, r100);
        goto L3
    L18:
        r100.d(r101);
        setThreadSafe(true);
    }
}
