package com.bytedance.android.livesdk.business.douplus;

import io.reactivex.functions.Consumer;
import zg1.n2;

/* JADX INFO: loaded from: classes7.dex */
public final /* synthetic */ class g implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ h f104390a;

    public /* synthetic */ g(h r100) {
        this.f104390a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        this.f104390a.onEvent((n2) r100);
    }
}
