package com.bytedance.android.live.revenue.common.player.vendor.link;

import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<zx0.a> f90962a;

    public b(Function1<? super List<zx0.a>, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "strategyListScope");
        ArrayList r101 = new ArrayList();
        r100.invoke(r101);
        Unit r102 = Unit.INSTANCE;
        this.f90962a = r101;
    }
}
