package com.bytedance.android.ec.hybrid.card.impl;

import com.bytedance.android.ec.hybrid.card.bridge.ECBridgeMethodFinder;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class ECLynxCardBridgeInfoRegistry extends a07.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.bytedance.android.ec.hybrid.card.bridge.c f46507a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f46508b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ECBridgeMethodFinder f46509c;

    public ECLynxCardBridgeInfoRegistry(ECBridgeMethodFinder r100) {
        Intrinsics.checkNotNullParameter(r100, "customMethodFinder");
        this.f46509c = r100;
        this.f46507a = new com.bytedance.android.ec.hybrid.card.bridge.c();
        this.f46508b = LazyKt.lazy(new ECLynxCardBridgeInfoRegistry$methodFinders$2(this));
    }
}
