package com.bytedance.android.gamecp.common.ui.popup.manager;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes44.dex */
public final class g<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ h f57048a;

    public g(h r100) {
        this.f57048a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Long r101 = (Long) r100;
        this.f57048a.f57050b.a(LivePopupInfo.State.DISMISSED);
    }
}
