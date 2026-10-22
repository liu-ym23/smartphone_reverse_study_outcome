package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper;

import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes9.dex */
public final class f<V> implements Callable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function0 f127408a;

    public f(Function0 r100) {
        this.f127408a = r100;
    }

    @Override // java.util.concurrent.Callable
    public /* bridge */ /* synthetic */ Object call() {
        call();
        return Unit.INSTANCE;
    }

    @Override // java.util.concurrent.Callable
    public final void call() {
        this.f127408a.invoke();
    }
}
