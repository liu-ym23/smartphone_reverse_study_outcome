package com.bytedance.android.livesdk.utils.condition.base;

import java.util.HashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f158921a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f158922b;

    public c(String r100) {
        Intrinsics.checkNotNullParameter(r100, "repoDescripton");
        this.f158921a = LazyKt.lazy(ConditionRepo$conditions$2.INSTANCE);
        this.f158922b = LazyKt.lazy(ConditionRepo$targets$2.INSTANCE);
    }

    public final void a(Condition r100) {
        Intrinsics.checkNotNullParameter(r100, "condition");
        ((HashMap) this.f158921a.getValue()).put(r100.getType(), r100);
    }
}
