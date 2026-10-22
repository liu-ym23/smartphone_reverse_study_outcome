package com.bytedance.android.live.browser.jsbridge.newmethods;

import com.bytedance.android.live.browser.jsbridge.base.AlertCheckDialogResultModel;
import kotlin.Unit;

/* JADX INFO: loaded from: classes45.dex */
public final class f0 implements lm3.c.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ h0 f63365b;

    public f0(h0 r100) {
        this.f63365b = r100;
    }

    @Override // lm3.c.a
    public final void onAction(lm3.d r100) {
        h0 r101 = this.f63365b;
        r101.getClass();
        AlertCheckDialogResultModel r102 = new AlertCheckDialogResultModel();
        r102.a(AlertCheckDialogResultModel.Code.Success);
        AlertCheckDialogResultModel.a r103 = new AlertCheckDialogResultModel.a();
        r103.c(Boolean.TRUE);
        r103.a(Boolean.FALSE);
        r103.b(Boolean.valueOf(r101.f63407a));
        Unit r104 = Unit.INSTANCE;
        r102.b(r103);
        r101.finishWithResult(r102);
        r101.f63408b = true;
    }
}
