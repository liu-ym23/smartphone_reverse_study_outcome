package com.bytedance.android.livesdk.floatview.inner;

import android.view.View;

/* JADX INFO: loaded from: classes8.dex */
public final class m implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ k f125222a;

    public m(k r100) {
        this.f125222a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        com.bytedance.android.livesdk.floatview.e r101 = this.f125222a.f125214v;
        if (r101 == null) goto L6;
        r101.onClose();
        return;
    }
}
