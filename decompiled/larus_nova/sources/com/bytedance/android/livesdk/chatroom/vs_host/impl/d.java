package com.bytedance.android.livesdk.chatroom.vs_host.impl;

import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.livesdk.vscore_impl.component.tabs.d0;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposables;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes8.dex */
public final class d<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ vr1.b f118294a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ CompositeDisposable f118295b;

    public d(d0 r100, CompositeDisposable r101) {
        this.f118294a = r100;
        this.f118295b = r101;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        sh6.b r101 = (sh6.b) r100;
        c r102 = new c(this);
        s22.e r103 = (s22.e) sh6.c.b(r101);
        if (r103 == null) goto L5;
        r103.addListener(r102);
    L5:
        RxUtilKt.c(Disposables.fromAction(new b(r101, r102)), this.f118295b);
        this.f118294a.b();
    }
}
