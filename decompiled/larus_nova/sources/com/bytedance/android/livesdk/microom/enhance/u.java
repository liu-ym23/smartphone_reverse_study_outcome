package com.bytedance.android.livesdk.microom.enhance;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes11.dex */
public final class u<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ h80.a f153888a;

    public u(t r100) {
        this.f153888a = r100;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        this.f153888a.accept(sh6.c.b((sh6.b) r100));
    }
}
