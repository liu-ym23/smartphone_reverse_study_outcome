package com.bytedance.android.ec.core.arch.state;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KFunction;

/* JADX INFO: loaded from: classes43.dex */
public final class e implements Function1<b, Unit> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ KFunction f43868a;

    public e(KFunction r100) {
        this.f43868a = r100;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Unit invoke(b r100) {
        b r101 = r100;
        Intrinsics.checkNotNullParameter(r101, "p1");
        ((Function1) this.f43868a).invoke(r101);
        return Unit.INSTANCE;
    }
}
