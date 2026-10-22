package com.stepos.core.ota.deepbinder;

import kotlin.Pair;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class ModelInstallStatusResolver {
    public static final ModelInstallStatusResolver INSTANCE = new ModelInstallStatusResolver();

    private ModelInstallStatusResolver() {
    }

    public final Pair<Integer, Integer> resolve(boolean z, boolean z3, boolean z10, boolean z11, boolean z12, int i10, boolean z13, int i11, int i12, boolean z14) {
        return z11 ? new Pair<>(4, Integer.valueOf(i10)) : z12 ? new Pair<>(4, Integer.valueOf(i10)) : z14 ? (z13 || z10) ? new Pair<>(1, 0) : new Pair<>(0, 0) : (z && z13 && i11 < i12) ? new Pair<>(3, 0) : z ? new Pair<>(2, 0) : z3 ? new Pair<>(5, 0) : z10 ? new Pair<>(1, 0) : z13 ? new Pair<>(1, 0) : new Pair<>(0, 0);
    }
}
