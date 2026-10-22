package com.bytedance.android.live.revlink.impl.multianchor.scope;

import android.content.DialogInterface;

/* JADX INFO: loaded from: classes47.dex */
public final class d implements DialogInterface.OnDismissListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c f94637a;

    public d(c r100) {
        this.f94637a = r100;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface r100) {
        this.f94637a.f94634a = null;
    }
}
