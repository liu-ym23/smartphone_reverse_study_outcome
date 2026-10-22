package com.bytedance.android.live.effect.api;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class i0 implements p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LiveEffectContextFactoryDelegate$Type f66768a;

    public final j0 a() {
        Map<LiveEffectContextFactoryDelegate$Type, e> r100 = u.f66774a;
        return new j0(u.b(this.f66768a).b());
    }

    public i0(LiveEffectContextFactoryDelegate$Type r100) {
        Intrinsics.checkNotNullParameter(r100, "type");
        this.f66768a = r100;
    }
}
