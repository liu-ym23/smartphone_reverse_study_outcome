package com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.common.topcontrolbar.view;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes10.dex */
public final class i<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ KtvComponentTopBarControlContainer f144198a;

    public i(KtvComponentTopBarControlContainer r100) {
        this.f144198a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Boolean r101 = (Boolean) r100;
        KtvComponentTopBarControlContainer r102 = this.f144198a;
        int r103 = KtvComponentTopBarControlContainer.f144162u;
        r102.j();
    }
}
