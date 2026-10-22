package com.bytedance.android.livesdk.message.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@ProtoMessage("webcast.data.LinkmicProfitEggTaskInfo")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\t\n\u0002\b\f\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u001d\u0010\u001eR\"\u0010\u0004\u001a\u00020\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\"\u0010\n\u001a\u00020\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\"\u0010\r\u001a\u00020\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u0005\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\tR\"\u0010\u0010\u001a\u00020\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0005\u001a\u0004\b\u0011\u0010\u0007\"\u0004\b\u0012\u0010\tR\"\u0010\u0014\u001a\u00020\u00138\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\"\u0010\u001a\u001a\u00020\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u0005\u001a\u0004\b\u001b\u0010\u0007\"\u0004\b\u001c\u0010\t¨\u0006\u001f"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/LinkmicProfitEggTaskInfo;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/message/model/t9;", "", "targetScore", "I", "getTargetScore", "()I", "setTargetScore", "(I)V", "taskDuration", "getTaskDuration", "setTaskDuration", "taskBeginRelativeBattleEndTime", "getTaskBeginRelativeBattleEndTime", "setTaskBeginRelativeBattleEndTime", "currentScore", "getCurrentScore", "setCurrentScore", "", "taskStartTime", "J", "getTaskStartTime", "()J", "setTaskStartTime", "(J)V", "taskStatus", "getTaskStatus", "setTaskStatus", "<init>", "()V", "livemessage-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LinkmicProfitEggTaskInfo extends FlexModelBase<t9> implements t9, vh7.h {

    @SerializedName("current_score")
    protected int currentScore;

    @SerializedName("target_score")
    protected int targetScore;

    @SerializedName("task_begin_relative_battle_end_time")
    protected int taskBeginRelativeBattleEndTime;

    @SerializedName("task_duration")
    protected int taskDuration;

    @SerializedName("task_start_time")
    protected long taskStartTime;

    @SerializedName("task_status")
    protected int taskStatus;

    public LinkmicProfitEggTaskInfo() {
        super(t9.class);
    }

    @Override // com.bytedance.android.livesdk.message.model.t9
    public int getCurrentScore() {
        return this.currentScore;
    }

    @Override // com.bytedance.android.livesdk.message.model.t9
    public int getTargetScore() {
        return this.targetScore;
    }

    @Override // com.bytedance.android.livesdk.message.model.t9
    public int getTaskBeginRelativeBattleEndTime() {
        return this.taskBeginRelativeBattleEndTime;
    }

    @Override // com.bytedance.android.livesdk.message.model.t9
    public int getTaskDuration() {
        return this.taskDuration;
    }

    @Override // com.bytedance.android.livesdk.message.model.t9
    public long getTaskStartTime() {
        return this.taskStartTime;
    }

    @Override // com.bytedance.android.livesdk.message.model.t9
    public int getTaskStatus() {
        return this.taskStatus;
    }

    public LinkmicProfitEggTaskInfo(am3.g r100) {
        super(t9.class);
        setThreadSafe(false);
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L14;
        am3.g.a r103 = decodeExtensionFields(r102, r100);
        switch(r102) {
            case 1: goto L13;
            case 2: goto L12;
            case 3: goto L11;
            case 4: goto L10;
            case 5: goto L9;
            case 6: goto L8;
            default: goto L7;
        };
    L8:
        this.taskStatus = r100.i();
        goto L3
    L9:
        this.taskStartTime = r100.j();
        goto L3
    L10:
        this.currentScore = (int) r100.j();
        goto L3
    L11:
        this.taskBeginRelativeBattleEndTime = (int) r100.j();
        goto L3
    L12:
        this.taskDuration = (int) r100.j();
        goto L3
    L13:
        this.targetScore = (int) r100.j();
        goto L3
    L7:
        am3.h.d(r103, r100);
        goto L3
    L14:
        r100.d(r101);
        setThreadSafe(true);
    }

    public void setCurrentScore(int r100) {
        this.currentScore = r100;
    }

    public void setTargetScore(int r100) {
        this.targetScore = r100;
    }

    public void setTaskBeginRelativeBattleEndTime(int r100) {
        this.taskBeginRelativeBattleEndTime = r100;
    }

    public void setTaskDuration(int r100) {
        this.taskDuration = r100;
    }

    public void setTaskStartTime(long r100) {
        this.taskStartTime = r100;
    }

    public void setTaskStatus(int r100) {
        this.taskStatus = r100;
    }
}
