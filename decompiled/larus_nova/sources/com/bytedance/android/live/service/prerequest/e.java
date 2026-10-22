package com.bytedance.android.live.service.prerequest;

import io.reactivex.functions.Consumer;
import kc0.j;

/* JADX INFO: loaded from: classes47.dex */
public final class e<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f100914a;

    public e(b r100) {
        this.f100914a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Long r101 = (Long) r100;
        boolean r102 = com.bytedance.android.live.revenue.core.util.h.f91037a;
        kc0.e r103 = ((j) com.bytedance.android.live.revenue.core.util.h.d(j.class)).getRevLinkControlService();
        if (r103 == null) goto L6;
        r103.l(this.f100914a.f100902g);
        return;
    }
}
