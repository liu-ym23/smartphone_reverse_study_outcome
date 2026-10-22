package com.bytedance.android.live.openplatform.impl.miniappaudience.toolbar;

import android.content.DialogInterface;

/* JADX INFO: loaded from: classes46.dex */
public final class e implements DialogInterface.OnDismissListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d f85005a;

    public e(d r100) {
        this.f85005a = r100;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface r100) {
        this.f85005a.f85004c.b();
        this.f85005a.f85002a = null;
    }
}
