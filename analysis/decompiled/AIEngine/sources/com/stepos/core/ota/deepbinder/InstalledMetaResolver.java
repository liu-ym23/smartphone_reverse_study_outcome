package com.stepos.core.ota.deepbinder;

import kotlin.jvm.internal.g;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class InstalledMetaResolver {
    public static final InstalledMetaResolver INSTANCE = new InstalledMetaResolver();

    private InstalledMetaResolver() {
    }

    public final boolean isInstalled(boolean z, boolean z3, zb.a<Boolean> usableOnDisk) {
        g.f(usableOnDisk, "usableOnDisk");
        if (z3 || !z) {
            return usableOnDisk.invoke().booleanValue();
        }
        return false;
    }
}
