package com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.common.topcontrolbar.view;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes10.dex */
public final class j<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ KtvComponentTopBarControlContainer f144199a;

    public j(KtvComponentTopBarControlContainer r100) {
        this.f144199a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        KtvComponentTopBarControlContainer r101 = this.f144199a;
        int r102 = KtvComponentTopBarControlContainer.f144162u;
        r101.k();
        this.f144199a.i(((Boolean) r100).booleanValue());
    }
}
