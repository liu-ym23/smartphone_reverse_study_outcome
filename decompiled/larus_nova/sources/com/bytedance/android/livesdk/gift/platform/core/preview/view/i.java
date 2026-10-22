package com.bytedance.android.livesdk.gift.platform.core.preview.view;

import android.content.DialogInterface;

/* JADX INFO: loaded from: classes9.dex */
public final class i implements DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ UgcGiftSaleAdapter f131095a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f131096b;

    public i(UgcGiftSaleAdapter r100, int r101) {
        this.f131095a = r100;
        this.f131096b = r101;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r100, int r101) {
        this.f131095a.C2(this.f131096b);
        r100.dismiss();
    }
}
