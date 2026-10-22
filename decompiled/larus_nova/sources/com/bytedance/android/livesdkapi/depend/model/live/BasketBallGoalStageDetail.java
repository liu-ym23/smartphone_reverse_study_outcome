package com.bytedance.android.livesdkapi.depend.model.live;

import am3.g;
import com.bytedance.android.livesdkapi.depend.model.live.matchroom.IBasketBallGoalStageDetail;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: classes12.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0014\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003R\u001e\u0010\u0004\u001a\u00020\u00058\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\n\u001a\u00020\u00058\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001e\u0010\r\u001a\u00020\u00058\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\tR\u001e\u0010\u0010\u001a\u00020\u00058\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0007\"\u0004\b\u0012\u0010\tR\u001e\u0010\u0013\u001a\u00020\u00058\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0007\"\u0004\b\u0015\u0010\tR\u001e\u0010\u0016\u001a\u00020\u00058\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0007\"\u0004\b\u0018\u0010\t¨\u0006\u0019"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/BasketBallGoalStageDetail;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdkapi/depend/model/live/matchroom/IBasketBallGoalStageDetail;", "()V", "first_period", "", "getFirst_period", "()I", "setFirst_period", "(I)V", "forth_period", "getForth_period", "setForth_period", "overtime", "getOvertime", "setOvertime", "second_period", "getSecond_period", "setSecond_period", "third_period", "getThird_period", "setThird_period", "total", "getTotal", "setTotal", "vs-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class BasketBallGoalStageDetail extends FlexModelBase<IBasketBallGoalStageDetail> implements IBasketBallGoalStageDetail, h {

    @SerializedName("first_period")
    protected int first_period;

    @SerializedName("forth_period")
    protected int forth_period;

    @SerializedName("overtime")
    protected int overtime;

    @SerializedName("second_period")
    protected int second_period;

    @SerializedName("third_period")
    protected int third_period;

    @SerializedName("total")
    protected int total;

    public BasketBallGoalStageDetail() {
        super(IBasketBallGoalStageDetail.class);
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.matchroom.IBasketBallGoalStageDetail
    public int getFirst_period() {
        return this.first_period;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.matchroom.IBasketBallGoalStageDetail
    public int getForth_period() {
        return this.forth_period;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.matchroom.IBasketBallGoalStageDetail
    public int getOvertime() {
        return this.overtime;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.matchroom.IBasketBallGoalStageDetail
    public int getSecond_period() {
        return this.second_period;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.matchroom.IBasketBallGoalStageDetail
    public int getThird_period() {
        return this.third_period;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.matchroom.IBasketBallGoalStageDetail
    public int getTotal() {
        return this.total;
    }

    public BasketBallGoalStageDetail(g r100) {
        super(IBasketBallGoalStageDetail.class);
        setThreadSafe(false);
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L14;
        g.a r103 = decodeExtensionFields(r102, r100);
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
        this.total = r100.i();
        goto L3
    L9:
        this.overtime = r100.i();
        goto L3
    L10:
        this.forth_period = r100.i();
        goto L3
    L11:
        this.third_period = r100.i();
        goto L3
    L12:
        this.second_period = r100.i();
        goto L3
    L13:
        this.first_period = r100.i();
        goto L3
    L7:
        am3.h.d(r103, r100);
        goto L3
    L14:
        r100.d(r101);
        setThreadSafe(true);
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.matchroom.IBasketBallGoalStageDetail
    public void setFirst_period(int r100) {
        this.first_period = r100;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.matchroom.IBasketBallGoalStageDetail
    public void setForth_period(int r100) {
        this.forth_period = r100;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.matchroom.IBasketBallGoalStageDetail
    public void setOvertime(int r100) {
        this.overtime = r100;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.matchroom.IBasketBallGoalStageDetail
    public void setSecond_period(int r100) {
        this.second_period = r100;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.matchroom.IBasketBallGoalStageDetail
    public void setThird_period(int r100) {
        this.third_period = r100;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.matchroom.IBasketBallGoalStageDetail
    public void setTotal(int r100) {
        this.total = r100;
    }
}
