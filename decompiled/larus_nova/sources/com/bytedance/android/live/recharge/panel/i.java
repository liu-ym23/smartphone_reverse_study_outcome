package com.bytedance.android.live.recharge.panel;

import io.reactivex.functions.Consumer;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes47.dex */
public final class i<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ h.b f90221a;

    public i(h.b r100) {
        this.f90221a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(T r100) {
        h r101 = this.f90221a.f90220b;
        KProperty[] r102 = h.B;
        r101.a();
    }
}
