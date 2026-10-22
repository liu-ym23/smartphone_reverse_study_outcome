package com.bytedance.android.live.revlink.impl.pk.dialog.presenter;

import com.bytedance.android.live.revlink.impl.pk.dialog.contract.InteractDialogPkPrecisionMatchInviteContract$View;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes47.dex */
public final class m<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ k f96050a;

    public m(k r100) {
        this.f96050a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        long r101 = ((Number) r100).longValue();
        InteractDialogPkPrecisionMatchInviteContract$View r102 = (InteractDialogPkPrecisionMatchInviteContract$View) this.f96050a.f92392c;
        if (r102 == null) goto L6;
        r102.da0(r101);
        return;
    }
}
