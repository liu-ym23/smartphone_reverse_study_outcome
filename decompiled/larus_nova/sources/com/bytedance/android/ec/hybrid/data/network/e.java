package com.bytedance.android.ec.hybrid.data.network;

import java.util.concurrent.Callable;
import kotlin.Unit;

/* JADX INFO: loaded from: classes44.dex */
public final class e<V> implements Callable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Runnable f46817a;

    public e(Runnable r100) {
        this.f46817a = r100;
    }

    @Override // java.util.concurrent.Callable
    public /* bridge */ /* synthetic */ Object call() {
        call();
        return Unit.INSTANCE;
    }

    @Override // java.util.concurrent.Callable
    public final void call() {
        this.f46817a.run();
    }
}
