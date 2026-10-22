package com.bytedance.android.livesdk.message.model;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\t\n\u0002\b\b\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u001a\u0010\u0007\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0003\u0010\u0004R\u001a\u0010\n\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\t\u0010\u0006\u001a\u0004\b\b\u0010\u0004R\u001a\u0010\r\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\f\u0010\u0006\u001a\u0004\b\u000b\u0010\u0004R\u001a\u0010\u0012\u001a\u00020\u000e8&X§\u0004¢\u0006\f\u0012\u0004\b\u0011\u0010\u0006\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0015\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u0014\u0010\u0006\u001a\u0004\b\u0013\u0010\u0004¨\u0006\u0016"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/s9;", "Lvh7/c;", "", "getRewardBuffMultiple", "()I", "getRewardBuffMultiple$annotations", "()V", "rewardBuffMultiple", "getRewardDuration", "getRewardDuration$annotations", "rewardDuration", "getRewardBeginRelativeBattleEndTime", "getRewardBeginRelativeBattleEndTime$annotations", "rewardBeginRelativeBattleEndTime", "", "getRewardStartTime", "()J", "getRewardStartTime$annotations", "rewardStartTime", "getTotalRewardScore", "getTotalRewardScore$annotations", "totalRewardScore", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface s9 extends vh7.c<s9> {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    @Override // vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    @FieldName(name = "reward_begin_relative_battle_end_time")
    int getRewardBeginRelativeBattleEndTime();

    @FieldName(name = "reward_buff_multiple")
    int getRewardBuffMultiple();

    @FieldName(name = "reward_duration")
    int getRewardDuration();

    @FieldName(name = "reward_start_time")
    long getRewardStartTime();

    @FieldName(name = "total_reward_score")
    int getTotalRewardScore();
}
