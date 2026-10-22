package com.bytedance.android.livesdk.drawer.relax;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Function1<? super Boolean, Unit> f122624a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function3<? super n0, ? super Function0<Unit>, ? super Function0<Unit>, Unit> f122625b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function0<Unit> f122626c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Function0<Unit> f122627d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Function0<Boolean> f122628e;

    public f(Function3 r100, Function0 r101) {
        Intrinsics.checkNotNullParameter(r100, "drawerUnFollow");
        this.f122624a = null;
        this.f122625b = r100;
        this.f122626c = r101;
        this.f122627d = null;
        this.f122628e = null;
    }
}
