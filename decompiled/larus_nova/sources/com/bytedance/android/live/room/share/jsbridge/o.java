package com.bytedance.android.live.room.share.jsbridge;

import android.content.DialogInterface;
import android.content.Intent;
import com.bytedance.android.live.room.api.ILiveShareService;
import com.bytedance.android.livesdk.config.xr0;
import com.bytedance.ies.web.jsbridge2.CallContext;

/* JADX INFO: loaded from: classes47.dex */
public final class o implements DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CallContext f100321a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f100322b;

    public o(CallContext r100, String r101) {
        this.f100321a = r100;
        this.f100322b = r101;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r100, int r101) {
        if (xr0.f121627a.getValue().booleanValue() == false) goto L5;
        ((ILiveShareService) jc1.k.n(ILiveShareService.class)).openInstallApp(this.f100321a.getContext(), this.f100322b);
    L6:
        if (r100 == null) goto L9;
        r100.dismiss();
        return;
    L9:
        return;
    L5:
        Intent r102 = ita.k.e(this.f100321a.getContext(), this.f100322b);
        this.f100321a.getContext().startActivity(r102);
        goto L6
    }
}
