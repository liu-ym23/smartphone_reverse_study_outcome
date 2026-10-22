package com.bytedance.android.live.browser.jsbridge.newmethods;

import android.content.DialogInterface;
import com.bytedance.android.live.browser.jsbridge.base.AlertResultModel;
import kotlin.Unit;

/* JADX INFO: loaded from: classes45.dex */
public final class l0 implements DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ m0 f63536a;

    public l0(m0 r100) {
        this.f63536a = r100;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r100, int r101) {
        if (r100 == null) goto L4;
        r100.dismiss();
    L4:
        m0 r102 = this.f63536a;
        if (r102.f63550a == true) goto L8;
        AlertResultModel r103 = new AlertResultModel();
        r103.a(AlertResultModel.Code.action);
        Unit r104 = Unit.INSTANCE;
        r102.finishWithResult(r103);
        return;
    }
}
