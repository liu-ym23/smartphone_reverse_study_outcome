package com.bytedance.android.live.revlink.impl.pk.dialog.presenter;

import com.bytedance.android.live.revlink.impl.pk.dialog.contract.InteractDialogPKSearchContract$View;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes47.dex */
public final class i<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ j f96009a;

    public i(j r100) {
        this.f96009a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        j r101 = this.f96009a;
        r101.d((Throwable) r100);
        InteractDialogPKSearchContract$View r102 = (InteractDialogPKSearchContract$View) this.f96009a.f92392c;
        if (r102 == null) goto L7;
        r102.ba0();
        return;
    }
}
