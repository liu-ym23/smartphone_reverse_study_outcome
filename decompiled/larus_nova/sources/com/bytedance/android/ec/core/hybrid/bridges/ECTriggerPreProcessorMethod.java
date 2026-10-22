package com.bytedance.android.ec.core.hybrid.bridges;

import bolts.Task;
import com.bytedance.android.ec.host.api.hybrid.ECBaseBridgeMethod;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/ec/core/hybrid/bridges/ECTriggerPreProcessorMethod;", "Lcom/bytedance/android/ec/host/api/hybrid/ECBaseBridgeMethod;", "<init>", "()V", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECTriggerPreProcessorMethod extends ECBaseBridgeMethod {
    @Override // com.bytedance.android.ec.model.hybrid.IECBridgeMethod
    public final String getName() {
        return "ec.triggerPreProcessor";
    }

    public ECTriggerPreProcessorMethod() {
    }

    public static void d(Integer r100, ECBaseBridgeMethod.a r101) {
        boolean r102 = false;
        if (r100 != null) goto L6;
    L8:
        JSONObject r103 = new JSONObject();
        Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L21
        JSONObject r105 = null;
        if (r100 != null) goto L12;
    L19:
        Result.m9449constructorimpl(r105);     // Catch: Throwable -> L21
    L23:
        Unit r106 = Unit.INSTANCE;
        r101.a(r103);
        return;
    L12:
        if (r100.intValue() <= 0) goto L14;
        r102 = true;
    L14:
        if (r102 == true) goto L17;
        r100 = null;
    L17:
        if (r100 == null) goto L19;
        r105 = r103.putOpt("sub_code", Integer.valueOf(r100.intValue()));     // Catch: Throwable -> L21
    L21:
        th = move-exception;
        Result.Companion r107 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L23
    L6:
        if (r100.intValue() != (-100)) goto L8;
        r101.onFailed(0, "url is empty");
    }

    @Override // com.bytedance.android.ec.host.api.hybrid.ECBaseBridgeMethod
    public final void c(JSONObject r100, final ECBaseBridgeMethod.a r101) {
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r101, "iReturn");
        int r102 = r100.optInt("optimization");
        JSONObject r103 = r100.optJSONObject("data");
        Integer r104 = null;
        if (r103 == null) goto L5;
        String r105 = r103.optString("template_url");
    L6:
        if (r103 == null) goto L8;
        String r106 = r103.optString("na_prefetch_cert");
    L9:
        if (r103 == null) goto L11;
        r104 = Integer.valueOf(r103.optInt("thread_strategy", 0));
    L11:
        bh.b r107 = new bh.b(r102);
        r107.f18989a = r105;
        r107.f18990b = r106;
        if (r104 != null) goto L15;
    L17:
        if (r104 != null) goto L20;
    L22:
        d(r107.b(), r101);
        return;
    L20:
        if (r104.intValue() != 1) goto L22;
        Function1<Integer, Unit> r108 = new ECTriggerPreProcessorMethod$handle$1(this, r101);
        Intrinsics.checkNotNullParameter(r108, "callback");
        Task.callInBackground(new bh.a(r107, r108));
        return;
    L15:
        if (r104.intValue() != 0) goto L17;
        d(r107.b(), r101);
        return;
    L8:
        r106 = null;
        goto L9
    L5:
        r105 = null;
        goto L6
    }
}
