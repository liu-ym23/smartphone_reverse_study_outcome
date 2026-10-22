package com.bytedance.android.livesdkapi.depend.model.live;

import am3.g;
import com.bytedance.android.livesdkapi.depend.model.live.matchroom.IGoalStageDetail;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: classes12.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0011\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003R \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR \u0010\n\u001a\u0004\u0018\u00010\u00058\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR \u0010\r\u001a\u0004\u0018\u00010\u00058\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\tR \u0010\u0010\u001a\u0004\u0018\u00010\u00058\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0007\"\u0004\b\u0012\u0010\tR \u0010\u0013\u001a\u0004\u0018\u00010\u00058\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0007\"\u0004\b\u0015\u0010\t¨\u0006\u0016"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/GoalStageDetail;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdkapi/depend/model/live/matchroom/IGoalStageDetail;", "()V", "firstHalfGoal", "", "getFirstHalfGoal", "()Ljava/lang/String;", "setFirstHalfGoal", "(Ljava/lang/String;)V", "overtime", "getOvertime", "setOvertime", "secondHalfGoal", "getSecondHalfGoal", "setSecondHalfGoal", "shots", "getShots", "setShots", "total", "getTotal", "setTotal", "vs-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class GoalStageDetail extends FlexModelBase<IGoalStageDetail> implements IGoalStageDetail, h {

    @SerializedName("first_half_goal")
    protected String firstHalfGoal;

    @SerializedName("overtime")
    protected String overtime;

    @SerializedName("second_half_goal")
    protected String secondHalfGoal;

    @SerializedName("shots")
    protected String shots;

    @SerializedName("total")
    protected String total;

    public GoalStageDetail() {
        super(IGoalStageDetail.class);
    }

    public GoalStageDetail(g r100) {
        super(IGoalStageDetail.class);
        setThreadSafe(false);
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L21;
        g.a r103 = decodeExtensionFields(r102, r100);
        if (r102 != 1) goto L8;
        this.firstHalfGoal = am3.h.c(r100);
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this.secondHalfGoal = am3.h.c(r100);
        goto L3
    L10:
        if (r102 != 3) goto L12;
        this.overtime = am3.h.c(r100);
        goto L3
    L12:
        if (r102 != 4) goto L14;
        this.shots = am3.h.c(r100);
        goto L3
    L14:
        if (r102 != 5) goto L15;
        this.total = am3.h.c(r100);
        goto L3
    L15:
        am3.h.d(r103, r100);
        goto L3
    L21:
        r100.d(r101);
        setThreadSafe(true);
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.matchroom.IGoalStageDetail
    public String getFirstHalfGoal() {
        return this.firstHalfGoal;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.matchroom.IGoalStageDetail
    public String getOvertime() {
        return this.overtime;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.matchroom.IGoalStageDetail
    public String getSecondHalfGoal() {
        return this.secondHalfGoal;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.matchroom.IGoalStageDetail
    public String getShots() {
        return this.shots;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.matchroom.IGoalStageDetail
    public String getTotal() {
        return this.total;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.matchroom.IGoalStageDetail
    public void setFirstHalfGoal(String r100) {
        this.firstHalfGoal = r100;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.matchroom.IGoalStageDetail
    public void setOvertime(String r100) {
        this.overtime = r100;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.matchroom.IGoalStageDetail
    public void setSecondHalfGoal(String r100) {
        this.secondHalfGoal = r100;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.matchroom.IGoalStageDetail
    public void setShots(String r100) {
        this.shots = r100;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.matchroom.IGoalStageDetail
    public void setTotal(String r100) {
        this.total = r100;
    }
}
