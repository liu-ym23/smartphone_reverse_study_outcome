package com.bytedance.android.shopping.anchorv4.bottom;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes12.dex */
public final class g0<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ e0 f165818a;

    public g0(e0 r100) {
        this.f165818a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Throwable r101 = (Throwable) r100;
        com.bytedance.android.ec.sdk.helper.g r102 = com.bytedance.android.ec.sdk.helper.g.f48122a;
        if ((r101 instanceof Exception) == true) goto L5;
        r101 = null;
    L5:
        r102.e((Exception) r101);
        int r103 = com.bytedance.android.shopping.anchorv3.utils.v.f165357a;
        com.bytedance.android.shopping.anchorv3.utils.v.g(this.f165818a.f165809c.isLike());
    }
}
