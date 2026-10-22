package com.bytedance.android.livehostapi.business.depend.locallife.params;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J.\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\u0006H\u0016J\u001a\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\u0006H\u0002¨\u0006\r"}, d2 = {"Lcom/bytedance/android/livehostapi/business/depend/locallife/params/LiveLifeActionParamsTask;", "Lcom/bytedance/android/livehostapi/business/depend/locallife/params/ILiveLifeParamsTask;", "()V", "handleParams", "", "commonParams", "Lcom/bytedance/android/livehostapi/business/depend/locallife/params/LiveLifeEnterParams;", "clickParams", "firstShowParams", "finalParams", "handleParmas", "", "params", "hostapp-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveLifeActionParamsTask implements ILiveLifeParamsTask {
    public LiveLifeActionParamsTask() {
    }

    private final boolean handleParmas(LiveLifeEnterParams r100, LiveLifeEnterParams r101) {
        if (r100 != null) goto L5;
        return false;
    L5:
        List<LiveLifeActionParams> r102 = r100.getAction();
        if (r102 != null) goto L9;
        return false;
    L9:
        if ((!r102.isEmpty()) == false) goto L12;
        r101.setAction(r102);
        return true;
    L12:
        return false;
    }

    @Override // com.bytedance.android.livehostapi.business.depend.locallife.params.ILiveLifeParamsTask
    public void handleParams(LiveLifeEnterParams r100, LiveLifeEnterParams r101, LiveLifeEnterParams r102, LiveLifeEnterParams r103) {
        Intrinsics.checkNotNullParameter(r103, "finalParams");
        if (handleParmas(r102, r103) == false) goto L6;
        return;
    L6:
        if (handleParmas(r101, r103) == false) goto L8;
        return;
    L8:
        handleParmas(r100, r103);
    }
}
