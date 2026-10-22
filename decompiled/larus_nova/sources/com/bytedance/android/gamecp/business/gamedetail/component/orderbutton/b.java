package com.bytedance.android.gamecp.business.gamedetail.component.orderbutton;

import com.bytedance.android.gamecp.common.utils.l1;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes44.dex */
public final class b<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.android.gamecp.base.core.service.depend.f f54822a;

    public b(com.bytedance.android.gamecp.base.core.service.depend.f r100) {
        this.f54822a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Throwable r101 = (Throwable) r100;
        com.bytedance.android.gamecp.base.core.service.depend.f r102 = this.f54822a;
        if (r102 == null) goto L8;
        String r103 = l1.c(r101);
        if (r103 != null) goto L7;
        r103 = "";
    L7:
        r102.onFail(r103);
    L8:
        e.a.a(e.f54831i, r101);
    }
}
