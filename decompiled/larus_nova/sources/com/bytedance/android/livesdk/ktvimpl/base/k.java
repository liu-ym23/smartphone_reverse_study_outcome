package com.bytedance.android.livesdk.ktvimpl.base;

import io.reactivex.functions.Consumer;
import java.util.Map;

/* JADX INFO: loaded from: classes10.dex */
public final class k<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ i f142536a;

    public k(i r100) {
        this.f142536a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        i r101 = this.f142536a;
        r101.k((Map) r100);
    }
}
