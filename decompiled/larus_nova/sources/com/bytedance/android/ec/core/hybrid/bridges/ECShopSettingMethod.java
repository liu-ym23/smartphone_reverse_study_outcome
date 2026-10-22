package com.bytedance.android.ec.core.hybrid.bridges;

import com.bytedance.android.ec.core.opt.ab.p;
import com.bytedance.android.ec.host.api.hybrid.ECBaseBridgeMethod;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/ec/core/hybrid/bridges/ECShopSettingMethod;", "Lcom/bytedance/android/ec/host/api/hybrid/ECBaseBridgeMethod;", "<init>", "()V", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECShopSettingMethod extends ECBaseBridgeMethod {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f44138e;

    public ECShopSettingMethod() {
        this.f44138e = "optShopSetting";
    }

    @Override // com.bytedance.android.ec.model.hybrid.IECBridgeMethod
    public final String getName() {
        return this.f44138e;
    }

    @Override // com.bytedance.android.ec.host.api.hybrid.ECBaseBridgeMethod
    public final void c(JSONObject r100, ECBaseBridgeMethod.a r101) {
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r101, "iReturn");
        String r102 = r100.optString("key");
        Object r103 = r100.optString("defaultValue");
        if (r102.length() <= 0) goto L5;
        boolean r104 = true;
    L6:
        if (r104 == false) goto L20;
        int r105 = p.f45243a;
        Result.Companion r106 = Result.Companion;     // Catch: Throwable -> L12
        jj4.b r107 = jj4.b.f499326b;     // Catch: Throwable -> L12
        Object r108 = jj4.a.a(r102, String.class, r103, false);     // Catch: Throwable -> L12
        if (r108 != null) goto L18;
        Intrinsics.throwNpe();     // Catch: Throwable -> L12
    L18:
        r101.onSuccess(r108);
        return;
    L12:
        th = move-exception;
        Result.Companion r109 = Result.Companion;
        Object r110 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        if (Result.m9455isFailureimpl(r110) == true) goto L17;
        r103 = r110;
    L17:
        r108 = r103;
        goto L18
    L20:
        r101.onFailed(0, "key 不能为空");
        return;
    L5:
        r104 = false;
        goto L6
    }
}
