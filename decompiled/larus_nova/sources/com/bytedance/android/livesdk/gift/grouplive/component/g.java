package com.bytedance.android.livesdk.gift.grouplive.component;

import io.reactivex.functions.Consumer;
import io.reactivex.subjects.PublishSubject;

/* JADX INFO: loaded from: classes9.dex */
public final class g<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ h f126299a;

    public g(h r100) {
        this.f126299a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        PublishSubject<fa0.b> r101 = this.f126299a.f126300a;
        r101.onNext((fa0.b) r100);
    }
}
