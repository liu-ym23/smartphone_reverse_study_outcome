package com.bytedance.android.livesdk.gift.fastgift;

import android.content.DialogInterface;

/* JADX INFO: loaded from: classes9.dex */
public final class o implements DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ long f126175a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f126176b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f126177c;

    public o(long r100, int r101, String r102) {
        this.f126175a = r100;
        this.f126176b = r101;
        this.f126177c = r102;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r100, int r101) {
        r100.dismiss();
        a.b(this.f126175a, this.f126176b, this.f126177c, "cancel");
    }
}
