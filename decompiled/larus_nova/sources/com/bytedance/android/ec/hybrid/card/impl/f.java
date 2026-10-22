package com.bytedance.android.ec.hybrid.card.impl;

import java.util.concurrent.Callable;
import kotlin.Unit;

/* JADX INFO: loaded from: classes44.dex */
public final class f<V> implements Callable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Runnable f46531a;

    public f(g r100) {
        this.f46531a = r100;
    }

    @Override // java.util.concurrent.Callable
    public /* bridge */ /* synthetic */ Object call() {
        call();
        return Unit.INSTANCE;
    }

    @Override // java.util.concurrent.Callable
    public final void call() {
        this.f46531a.run();
    }
}
