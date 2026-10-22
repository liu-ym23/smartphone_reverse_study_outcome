package com.bytedance.android.livesdk.ktvimpl.mv;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final y f146197a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function1<l, Boolean> f146198b;

    /* JADX WARN: Multi-variable type inference failed */
    public s(y r100, Function1<? super l, Boolean> r101) {
        Intrinsics.checkNotNullParameter(r101, "listener");
        this.f146197a = r100;
        this.f146198b = r101;
    }
}
