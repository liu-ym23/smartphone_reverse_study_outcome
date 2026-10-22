package com.bytedance.android.livehostapi.business.depend.locallife.params;

import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J.\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\u0006H\u0016J\u001a\u0010\n\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\u0006H\u0002¨\u0006\f"}, d2 = {"Lcom/bytedance/android/livehostapi/business/depend/locallife/params/LiveLifeRequestParamsTask;", "Lcom/bytedance/android/livehostapi/business/depend/locallife/params/ILiveLifeParamsTask;", "()V", "handleParams", "", "commonParams", "Lcom/bytedance/android/livehostapi/business/depend/locallife/params/LiveLifeEnterParams;", "clickParams", "firstShowParams", "finalParams", "handleParmas", "params", "hostapp-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveLifeRequestParamsTask implements ILiveLifeParamsTask {
    public LiveLifeRequestParamsTask() {
    }

    private final void handleParmas(LiveLifeEnterParams r100, LiveLifeEnterParams r101) {
        if (r100 == null) goto L28;
        Map<String, Object> r102 = r100.getRequestParams();
        boolean r103 = false;
        if (r102 != null) goto L6;
    L9:
        boolean r104 = true;
    L10:
        if (r104 == true) goto L35;
        Map<String, Object> r105 = r101.getRequestParams();
        if (r105 != null) goto L15;
    L16:
        r103 = true;
    L17:
        if (r103 == false) goto L20;
        r101.setRequestParams(r100.getRequestParams());
        return;
    L20:
        Map<String, Object> r106 = r100.getRequestParams();
        if (r106 == null) goto L34;
        Iterator<Map.Entry<String, Object>> r107 = r106.entrySet().iterator();
    L24:
        if (r107.hasNext() == false) goto L36;
        Map.Entry<String, Object> r108 = r107.next();
        String r109 = r108.getKey();
        Object r110 = r108.getValue();
        Map<String, Object> r111 = r101.getRequestParams();
        if (r111 == null) goto L24;
        r111.put(r109, r110);
        goto L24
    L36:
        return;
    L34:
        return;
    L15:
        if (r105.isEmpty() == false) goto L17;
    L35:
        return;
    L6:
        if (r102.isEmpty() == true) goto L9;
        r104 = false;
        goto L10
    }

    @Override // com.bytedance.android.livehostapi.business.depend.locallife.params.ILiveLifeParamsTask
    public void handleParams(LiveLifeEnterParams r100, LiveLifeEnterParams r101, LiveLifeEnterParams r102, LiveLifeEnterParams r103) {
        Intrinsics.checkNotNullParameter(r103, "finalParams");
        handleParmas(r100, r103);
        handleParmas(r101, r103);
        handleParmas(r102, r103);
    }
}
