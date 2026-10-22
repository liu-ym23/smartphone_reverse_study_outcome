package com.bytedance.android.livesdk.message.model;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\t\n\u0002\b\b\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u001a\u0010\u0007\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0003\u0010\u0004R\u001a\u0010\n\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\t\u0010\u0006\u001a\u0004\b\b\u0010\u0004R\u001a\u0010\r\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\f\u0010\u0006\u001a\u0004\b\u000b\u0010\u0004R\u001a\u0010\u0010\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u000f\u0010\u0006\u001a\u0004\b\u000e\u0010\u0004R\u001a\u0010\u0015\u001a\u00020\u00118&X§\u0004¢\u0006\f\u0012\u0004\b\u0014\u0010\u0006\u001a\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0018\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u0017\u0010\u0006\u001a\u0004\b\u0016\u0010\u0004¨\u0006\u0019"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/t9;", "Lvh7/c;", "", "getTargetScore", "()I", "getTargetScore$annotations", "()V", "targetScore", "getTaskDuration", "getTaskDuration$annotations", "taskDuration", "getTaskBeginRelativeBattleEndTime", "getTaskBeginRelativeBattleEndTime$annotations", "taskBeginRelativeBattleEndTime", "getCurrentScore", "getCurrentScore$annotations", "currentScore", "", "getTaskStartTime", "()J", "getTaskStartTime$annotations", "taskStartTime", "getTaskStatus", "getTaskStatus$annotations", "taskStatus", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface t9 extends vh7.c<t9> {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    @Override // vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    @FieldName(name = "current_score")
    int getCurrentScore();

    @FieldName(name = "target_score")
    int getTargetScore();

    @FieldName(name = "task_begin_relative_battle_end_time")
    int getTaskBeginRelativeBattleEndTime();

    @FieldName(name = "task_duration")
    int getTaskDuration();

    @FieldName(name = "task_start_time")
    long getTaskStartTime();

    @FieldName(name = "task_status")
    int getTaskStatus();
}
