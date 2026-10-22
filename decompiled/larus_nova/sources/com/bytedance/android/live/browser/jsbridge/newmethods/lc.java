package com.bytedance.android.live.browser.jsbridge.newmethods;

import androidx.core.util.Consumer;
import com.bytedance.android.live.browser.jsbridge.base.ShareItemResultModel;
import kotlin.Unit;

/* JADX INFO: loaded from: classes45.dex */
public final class lc<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ mc f63548a;

    public lc(mc r100) {
        this.f63548a = r100;
    }

    @Override // androidx.core.util.Consumer
    public final void accept(Object r100) {
        if (((Boolean) r100).booleanValue() == false) goto L5;
        mc r101 = this.f63548a;
        ShareItemResultModel r102 = new ShareItemResultModel();
        ShareItemResultModel.a r103 = new ShareItemResultModel.a();
        r103.a(Boolean.TRUE);
        Unit r104 = Unit.INSTANCE;
        r102.a(r103);
        r101.finishWithResult(r102);
        return;
    L5:
        mc r105 = this.f63548a;
        ShareItemResultModel r106 = new ShareItemResultModel();
        ShareItemResultModel.a r107 = new ShareItemResultModel.a();
        r107.a(Boolean.FALSE);
        Unit r108 = Unit.INSTANCE;
        r106.a(r107);
        r105.finishWithResult(r106);
    }
}
