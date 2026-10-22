package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver;

import java.util.concurrent.Callable;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final /* synthetic */ class b implements Callable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function0 f128453a;

    public b(Function0 r100) {
        Intrinsics.checkNotNullParameter(r100, "function");
        this.f128453a = r100;
    }

    @Override // java.util.concurrent.Callable
    public final /* synthetic */ Object call() {
        return this.f128453a.invoke();
    }
}
