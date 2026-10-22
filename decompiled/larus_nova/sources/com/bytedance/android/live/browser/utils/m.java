package com.bytedance.android.live.browser.utils;

import com.bytedance.android.live.browser.IH5AssistService;
import com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class m extends s26.a implements ga.c {
    public m() {
    }

    @Override // ga.c
    public final Map<String, IDLXBridgeMethod> providerMethod(String r100) {
        Intrinsics.checkNotNullParameter(r100, "bid");
        IH5AssistService r101 = (IH5AssistService) jc1.k.f(IH5AssistService.class);
        if (r101 != null) goto L7;
        return null;
    L7:
        return r101.providerMethod(r100);
    }
}
