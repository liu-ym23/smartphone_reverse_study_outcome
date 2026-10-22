package com.bytedance.android.annie.bridge.method;

import android.content.DialogInterface;
import com.bytedance.android.annie.bridge.ShowModalResultModel;

/* JADX INFO: loaded from: classes43.dex */
public final class l2 implements DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ m2 f38722a;

    public l2(m2 r100) {
        this.f38722a = r100;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r100, int r101) {
        ShowModalResultModel r102 = new ShowModalResultModel();
        r102.b(ShowModalResultModel.Code.Success);
        r102.a("confirm");
        this.f38722a.finishWithResult(r102);
    }
}
