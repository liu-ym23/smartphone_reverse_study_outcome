package com.bytedance.android.livesdk.message.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@ProtoMessage("webcast.data.LinkmicProfitEggRewardInfo")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\t\n\u0002\b\f\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u001a\u0010\u001bR\"\u0010\u0004\u001a\u00020\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\"\u0010\n\u001a\u00020\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\"\u0010\r\u001a\u00020\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u0005\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\tR\"\u0010\u0011\u001a\u00020\u00108\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\"\u0010\u0017\u001a\u00020\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0005\u001a\u0004\b\u0018\u0010\u0007\"\u0004\b\u0019\u0010\t¨\u0006\u001c"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/LinkmicProfitEggRewardInfo;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/message/model/s9;", "", "rewardBuffMultiple", "I", "getRewardBuffMultiple", "()I", "setRewardBuffMultiple", "(I)V", "rewardDuration", "getRewardDuration", "setRewardDuration", "rewardBeginRelativeBattleEndTime", "getRewardBeginRelativeBattleEndTime", "setRewardBeginRelativeBattleEndTime", "", "rewardStartTime", "J", "getRewardStartTime", "()J", "setRewardStartTime", "(J)V", "totalRewardScore", "getTotalRewardScore", "setTotalRewardScore", "<init>", "()V", "livemessage-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LinkmicProfitEggRewardInfo extends FlexModelBase<s9> implements s9, vh7.h {

    @SerializedName("reward_begin_relative_battle_end_time")
    protected int rewardBeginRelativeBattleEndTime;

    @SerializedName("reward_buff_multiple")
    protected int rewardBuffMultiple;

    @SerializedName("reward_duration")
    protected int rewardDuration;

    @SerializedName("reward_start_time")
    protected long rewardStartTime;

    @SerializedName("total_reward_score")
    protected int totalRewardScore;

    public LinkmicProfitEggRewardInfo() {
        super(s9.class);
    }

    @Override // com.bytedance.android.livesdk.message.model.s9
    public int getRewardBeginRelativeBattleEndTime() {
        return this.rewardBeginRelativeBattleEndTime;
    }

    @Override // com.bytedance.android.livesdk.message.model.s9
    public int getRewardBuffMultiple() {
        return this.rewardBuffMultiple;
    }

    @Override // com.bytedance.android.livesdk.message.model.s9
    public int getRewardDuration() {
        return this.rewardDuration;
    }

    @Override // com.bytedance.android.livesdk.message.model.s9
    public long getRewardStartTime() {
        return this.rewardStartTime;
    }

    @Override // com.bytedance.android.livesdk.message.model.s9
    public int getTotalRewardScore() {
        return this.totalRewardScore;
    }

    public LinkmicProfitEggRewardInfo(am3.g r100) {
        super(s9.class);
        setThreadSafe(false);
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L21;
        am3.g.a r103 = decodeExtensionFields(r102, r100);
        if (r102 != 1) goto L8;
        this.rewardBuffMultiple = (int) r100.j();
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this.rewardDuration = (int) r100.j();
        goto L3
    L10:
        if (r102 != 3) goto L12;
        this.rewardBeginRelativeBattleEndTime = (int) r100.j();
        goto L3
    L12:
        if (r102 != 4) goto L14;
        this.rewardStartTime = r100.j();
        goto L3
    L14:
        if (r102 != 5) goto L15;
        this.totalRewardScore = (int) r100.j();
        goto L3
    L15:
        am3.h.d(r103, r100);
        goto L3
    L21:
        r100.d(r101);
        setThreadSafe(true);
    }

    public void setRewardBeginRelativeBattleEndTime(int r100) {
        this.rewardBeginRelativeBattleEndTime = r100;
    }

    public void setRewardBuffMultiple(int r100) {
        this.rewardBuffMultiple = r100;
    }

    public void setRewardDuration(int r100) {
        this.rewardDuration = r100;
    }

    public void setRewardStartTime(long r100) {
        this.rewardStartTime = r100;
    }

    public void setTotalRewardScore(int r100) {
        this.totalRewardScore = r100;
    }
}
