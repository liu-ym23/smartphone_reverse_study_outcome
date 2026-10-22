package com.bytedance.android.livesdk.vscore_impl.behavior;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes11.dex */
public final class e<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f159543a;

    public e(b r100) {
        this.f159543a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        com.bytedance.android.livesdk.event.f r101 = (com.bytedance.android.livesdk.event.f) r100;
        this.f159543a.a();
    }
}
