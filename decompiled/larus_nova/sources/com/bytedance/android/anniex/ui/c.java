package com.bytedance.android.anniex.ui;

import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes43.dex */
public final class c<V> implements Callable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f41392a;

    public c(Function0<Unit> r100) {
        this.f41392a = r100;
    }

    @Override // java.util.concurrent.Callable
    public /* bridge */ /* synthetic */ Object call() {
        call();
        return Unit.INSTANCE;
    }

    @Override // java.util.concurrent.Callable
    public final void call() {
        this.f41392a.invoke();
    }
}
