package com.bytedance.android.livehostapi.business.depend.locallife.params;

import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J.\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\u0006H\u0016J\u001a\u0010\n\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\u0006H\u0002J,\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0018\u00010\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u000fH\u0002¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/livehostapi/business/depend/locallife/params/LiveLifeLogParamsTask;", "Lcom/bytedance/android/livehostapi/business/depend/locallife/params/ILiveLifeParamsTask;", "()V", "handleParams", "", "commonParams", "Lcom/bytedance/android/livehostapi/business/depend/locallife/params/LiveLifeEnterParams;", "clickParams", "firstShowParams", "finalParams", "handleParmas", "params", "mergeLifeExtraInfo", "", "", "", "current", "final", "hostapp-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveLifeLogParamsTask implements ILiveLifeParamsTask {
    public LiveLifeLogParamsTask() {
    }

    private final void handleParmas(LiveLifeEnterParams r100, LiveLifeEnterParams r101) {
        if (r100 == null) goto L38;
        Map<String, Object> r102 = r100.getLogInfo();
        boolean r103 = false;
        if (r102 != null) goto L6;
    L9:
        boolean r104 = true;
    L10:
        if (r104 == true) goto L52;
        Map<String, Object> r105 = r101.getLogInfo();
        if (r105 != null) goto L15;
    L16:
        r103 = true;
    L17:
        if (r103 == false) goto L20;
        r101.setLogInfo(r100.getLogInfo());
        return;
    L20:
        Map<String, Object> r106 = r100.getLogInfo();
        if (r106 == null) goto L51;
        Iterator<Map.Entry<String, Object>> r107 = r106.entrySet().iterator();
    L24:
        if (r107.hasNext() == false) goto L53;
        Map.Entry<String, Object> r108 = r107.next();
        String r109 = r108.getKey();
        Object r110 = r108.getValue();
        if (Intrinsics.areEqual(r109, BdpAppEventConstant.PARAMS_LIFE_EXTRA_INFO) == true) goto L27;
        if (r110 == null) goto L24;
        Map<String, Object> r111 = r101.getLogInfo();
        if (r111 == null) goto L24;
        r111.put(r109, r110);
        goto L24
    L27:
        Map<String, Object> r112 = r101.getLogInfo();
        if (r112 == null) goto L24;
        Map<String, Object> r113 = r101.getLogInfo();
        if (r113 == null) goto L32;
        Object r114 = r113.get(r109);
    L33:
        r112.put(r109, mergeLifeExtraInfo(r110, r114));
        goto L24
    L32:
        r114 = null;
        goto L33
    L53:
        return;
    L51:
        return;
    L15:
        if (r105.isEmpty() == false) goto L17;
    L52:
        return;
    L6:
        if (r102.isEmpty() == true) goto L9;
        r104 = false;
        goto L10
    }

    private final Map<String, Object> mergeLifeExtraInfo(Object r100, Object r101) {
        if (TypeIntrinsics.isMutableMap(r100) == true) goto L5;
        r100 = null;
    L5:
        Map<String, Object> r102 = (Map) r100;
        if (TypeIntrinsics.isMutableMap(r101) == true) goto L8;
        r101 = null;
    L8:
        Map<String, Object> r103 = (Map) r101;
        if (r102 != null) goto L11;
        return r103;
    L11:
        if (r103 != null) goto L13;
        return r102;
    L13:
        Iterator<Map.Entry<String, Object>> r104 = r102.entrySet().iterator();
    L15:
        if (r104.hasNext() == false) goto L19;
        Map.Entry<String, Object> r105 = r104.next();
        String r106 = r105.getKey();
        Object r107 = r105.getValue();
        if (r107 == null) goto L15;
        r103.put(r106, r107);
        goto L15
    L19:
        return r103;
    }

    @Override // com.bytedance.android.livehostapi.business.depend.locallife.params.ILiveLifeParamsTask
    public void handleParams(LiveLifeEnterParams r100, LiveLifeEnterParams r101, LiveLifeEnterParams r102, LiveLifeEnterParams r103) {
        Intrinsics.checkNotNullParameter(r103, "finalParams");
        handleParmas(r100, r103);
        handleParmas(r101, r103);
        handleParmas(r102, r103);
    }
}
