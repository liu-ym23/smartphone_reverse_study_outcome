package com.bytedance.android.annie.business.container;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class e implements com.bytedance.ies.bullet.flow.a {
    public e() {
    }

    @Override // com.bytedance.ies.bullet.flow.a
    public final void onRelease(String r100) {
        Intrinsics.checkNotNullParameter(r100, "sessionId");
        AnnieXLiveFlowLoaderControl$liveFlowLoadContextMap$1 r101 = AnnieXLiveFlowLoaderControl.f38916a;
        Intrinsics.checkNotNullParameter(r100, "sessionId");
        AnnieXLiveFlowLoaderControl.a r102 = (AnnieXLiveFlowLoaderControl.a) AnnieXLiveFlowLoaderControl.f38916a.remove(r100);
        if (r102 == null) goto L6;
        r102.f38922f.a();
        return;
    }
}
