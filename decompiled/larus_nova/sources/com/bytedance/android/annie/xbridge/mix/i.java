package com.bytedance.android.annie.xbridge.mix;

import com.bytedance.ies.web.jsbridge2.a0;

/* JADX INFO: loaded from: classes43.dex */
public final class i implements a0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BaseA2BBridgeMethod.a f40171a;

    public i(BaseA2BBridgeMethod.b r100) {
        this.f40171a = r100;
    }

    @Override // com.bytedance.ies.web.jsbridge2.a0
    public final void terminate() {
        this.f40171a.onFailed(new Jsb2TerminateException(0));
    }
}
