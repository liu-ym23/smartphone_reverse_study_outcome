package com.bytedance.android.annie.bridge.method;

import com.bytedance.android.annie.bridge.method.abs.RequestResultModel;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes43.dex */
public final class w1<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ u1.b f38848a;

    public w1(u1.b r100) {
        this.f38848a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        u1.c r101 = this.f38848a.f38837c;
        r101.a((RequestResultModel) r100);
    }
}
