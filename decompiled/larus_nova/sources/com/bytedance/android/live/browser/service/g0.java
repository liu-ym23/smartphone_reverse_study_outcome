package com.bytedance.android.live.browser.service;

import com.bytedance.android.annie.bridge.JSBridgeManager;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class g0 implements da.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.bytedance.android.live.browser.v f64284a;

    public g0(com.bytedance.android.live.browser.v r100) {
        Intrinsics.checkNotNullParameter(r100, "jsBridgeService");
        this.f64284a = r100;
    }

    @Override // da.b
    public final void J(JSBridgeManager r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "jsBridgeManager");
        Intrinsics.checkNotNullParameter(r101, "xBridgeRegisterStrategy");
        this.f64284a.registerXBridgeMethods(r100, r101);
    }
}
