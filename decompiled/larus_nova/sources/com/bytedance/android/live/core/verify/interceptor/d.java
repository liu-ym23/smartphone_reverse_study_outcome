package com.bytedance.android.live.core.verify.interceptor;

import java.util.Map;

/* JADX INFO: loaded from: classes45.dex */
public final class d implements com.bytedance.android.live.core.verify.utils.a.g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ t80.a f66485a;

    public d(b r100) {
        this.f66485a = r100;
    }

    @Override // com.bytedance.android.live.core.verify.utils.a.g
    public final void onVerify(boolean r100, Map<String, ? extends Object> r101) {
        t80.a r102 = this.f66485a;
        if (r102 == null) goto L9;
        if (r100 == false) goto L6;
        int r103 = 3;
    L7:
        r102.onVerifyResult(r103);
        return;
    L6:
        r103 = 1;
        goto L7
    }
}
