package com.bytedance.android.live.browser.jsbridge.newmethods;

import com.bytedance.android.livehostapi.platform.IHostAction;

/* JADX INFO: loaded from: classes45.dex */
public final class p5 implements IHostAction.BusinessInHomeSideBarCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ q5 f63602a;

    public p5(q5 r100) {
        this.f63602a = r100;
    }

    @Override // com.bytedance.android.livehostapi.platform.IHostAction.BusinessInHomeSideBarCallback
    public final void onResult(boolean r100) {
        IsBizEntryInHomeSideBarResultModel r101 = new IsBizEntryInHomeSideBarResultModel();
        r101.a(Boolean.valueOf(r100));
        this.f63602a.finishWithResult(r101);
    }
}
