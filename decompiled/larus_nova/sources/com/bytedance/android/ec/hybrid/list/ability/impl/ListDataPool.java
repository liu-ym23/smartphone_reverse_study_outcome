package com.bytedance.android.ec.hybrid.list.ability.impl;

import com.bytedance.android.ec.hybrid.list.ability.z;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class ListDataPool implements z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f46974a;

    @Override // com.bytedance.android.ec.hybrid.list.ability.s
    public final void release() {
        ((Map) this.f46974a.getValue()).clear();
    }

    public ListDataPool() {
        this.f46974a = LazyKt.lazy(ListDataPool$dataPool$2.INSTANCE);
    }

    @Override // com.bytedance.android.ec.hybrid.list.ability.z
    public final Object l8(String r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        return ((Map) this.f46974a.getValue()).get(r100);
    }

    @Override // com.bytedance.android.ec.hybrid.list.ability.z
    public final void Lm(String r100, Object r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        ((Map) this.f46974a.getValue()).put(r100, r101);
    }
}
