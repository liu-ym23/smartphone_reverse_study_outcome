package com.bytedance.android.ec.adapter.impl.adapters.browser;

import com.bytedance.android.ec.model.hybrid.IECBridgeMethod;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes43.dex */
public final class a implements IECBridgeMethod.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c f42745a;

    public a(c r100) {
        this.f42745a = r100;
    }

    @Override // com.bytedance.android.ec.model.hybrid.IECBridgeMethod.b
    public final void onComplete(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        this.f42745a.finishWithResult(r100);
    }

    @Override // com.bytedance.android.ec.model.hybrid.IECBridgeMethod.b
    public final void onError(int r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "message");
        this.f42745a.finishWithFailure(new Throwable(r101));
    }
}
