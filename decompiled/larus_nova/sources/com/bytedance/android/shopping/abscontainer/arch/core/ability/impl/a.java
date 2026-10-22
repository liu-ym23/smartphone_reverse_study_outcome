package com.bytedance.android.shopping.abscontainer.arch.core.ability.impl;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes12.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final k33.b f164124a;

    public a(com.bytedance.android.shopping.abscontainer.arch.platform.async.b r100) {
        Intrinsics.checkNotNullParameter(r100, "asyncScope");
        this.f164124a = r100;
    }

    public final k33.a b(Function0<Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "block");
        return this.f164124a.b(r100);
    }

    public final k33.a c(Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object> r100) {
        Intrinsics.checkNotNullParameter(r100, "block");
        return this.f164124a.c(r100);
    }

    public final k33.a a(long r100, Function0<Unit> r101) {
        Intrinsics.checkNotNullParameter(r101, "block");
        return this.f164124a.a(r100, r101);
    }
}
