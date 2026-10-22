package com.bytedance.android.live.revlink.impl.multianchor.service;

import com.bytedance.apm.constant.UploadTypeInf;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes47.dex */
public final class i<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ long f94663a;

    public i(long r100) {
        this.f94663a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        ((Number) r100).longValue();
        RevLinkLayoutPreloadContext r101 = RevLinkLayoutPreloadContext.Companion.getContext(Long.valueOf(this.f94663a));
        if (r101 == null) goto L10;
        com.bytedance.live.datacontext.j<f> r102 = r101.getService();
        if (r102 == null) goto L11;
        f r103 = r102.getValue();
        if (r103 == null) goto L12;
        r103.d(UploadTypeInf.TIMER);
        return;
    L12:
        return;
    L11:
        return;
    }
}
