package com.bytedance.android.livesdk.vscore_impl.behavior;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes11.dex */
public final class d<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f159542a;

    public d(b r100) {
        this.f159542a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Integer r101 = (Integer) r100;
        this.f159542a.a();
    }
}
