package com.bytedance.android.live.recharge.exchange.dialog;

import android.content.DialogInterface;

/* JADX INFO: loaded from: classes47.dex */
public final class d implements DialogInterface.OnDismissListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ e f89854a;

    public d(e r100) {
        this.f89854a = r100;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface r100) {
        this.f89854a.f89855a = null;
    }
}
