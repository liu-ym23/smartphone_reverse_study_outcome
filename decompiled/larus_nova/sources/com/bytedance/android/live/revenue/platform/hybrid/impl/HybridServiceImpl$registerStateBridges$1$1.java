package com.bytedance.android.live.revenue.platform.hybrid.impl;

import bz0.l;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.google.gson.Gson;
import cq2.e;
import cq2.i;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lcom/google/gson/Gson;", "gson", "Lcq2/i;", "stub", "Lcq2/e;", AbsMethodDelegate.TAG_INVOKE, "(Lcom/google/gson/Gson;Lcq2/i;)Lcq2/e;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
final class HybridServiceImpl$registerStateBridges$1$1 extends Lambda implements Function2<Gson, i, e> {
    final /* synthetic */ l.a $builder;

    public HybridServiceImpl$registerStateBridges$1$1(l.a r100) {
        super(2);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final e invoke2(Gson r100, i r101) {
        Intrinsics.checkNotNullParameter(r100, "gson");
        Intrinsics.checkNotNullParameter(r101, "stub");
        Intrinsics.checkNotNullParameter(r100, "gson");
        Intrinsics.checkNotNullParameter(null, "builder");
        Intrinsics.checkNotNullParameter(r101, "stub");
        new com.bytedance.android.live.revenue.platform.hybrid.impl.state.b.a(r100);
        Intrinsics.checkNotNullParameter(r100, "gson");
        Intrinsics.checkNotNullParameter(r101, "stub");
        throw null;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ e invoke(Gson r100, i r101) {
        return invoke2(r100, r101);
    }
}
