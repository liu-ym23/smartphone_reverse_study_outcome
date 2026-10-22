package com.bytedance.applet.impl;

import com.bytedance.ai.bridge.service.IHostLogDepend;
import com.bytedance.sdk.xbridge.cn.runtime.depend.IHostLogDependV2;
import com.bytedance.sdk.xbridge.cn.runtime.depend.XBaseRuntime;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class u implements IHostLogDepend {
    public u() {
    }

    @Override // com.bytedance.ai.bridge.service.IHostLogDepend
    public final void putCommonParams(Map<String, String> r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "params");
        XBaseRuntime.f270095a.getClass();
        IHostLogDependV2 r102 = XBaseRuntime.f270118x;
        if (r102 == null) goto L6;
        r102.putCommonParams(r100, r101);
        return;
    }
}
