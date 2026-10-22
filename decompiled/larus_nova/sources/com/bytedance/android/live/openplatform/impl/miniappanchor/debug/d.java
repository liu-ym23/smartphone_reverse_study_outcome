package com.bytedance.android.live.openplatform.impl.miniappanchor.debug;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes46.dex */
public final class d<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MiniAppAnchorDebugContextService f84364a;

    public d(MiniAppAnchorDebugContextService r100) {
        this.f84364a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Long r101 = (Long) r100;
        MiniAppAnchorDebugContextService r102 = this.f84364a;
        if (r102.f84351d == true) goto L6;
        MiniAppAnchorDebugContextService.g(r102, r102.getOpenPlatformContext().getContext());
        return;
    }
}
