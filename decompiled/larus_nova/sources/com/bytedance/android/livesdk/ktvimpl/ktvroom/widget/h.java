package com.bytedance.android.livesdk.ktvimpl.ktvroom.widget;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes10.dex */
public final class h<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ l f145801a;

    public h(l r100) {
        this.f145801a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        this.f145801a.f145823i.setSelected(((Boolean) r100).booleanValue());
    }
}
