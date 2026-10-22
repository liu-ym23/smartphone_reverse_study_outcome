package com.bytedance.android.ec.adapter.impl.adapters.browser;

import com.bytedance.android.ec.model.hybrid.IECBridgeMethod;
import com.bytedance.ies.web.jsbridge2.CallContext;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes43.dex */
public final class e implements IECBridgeMethod.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CallContext f42749a;

    public e(CallContext r100) {
        this.f42749a = r100;
    }

    @Override // com.bytedance.android.ec.model.hybrid.IECBridgeMethod.c
    public final void a(JSONObject r100) {
        Intrinsics.checkNotNullParameter("skuConfirmed", "name");
        Intrinsics.checkNotNullParameter(r100, "params");
        this.f42749a.b("skuConfirmed", r100);
    }
}
