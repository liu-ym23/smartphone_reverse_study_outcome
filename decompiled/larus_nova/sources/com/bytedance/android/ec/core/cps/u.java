package com.bytedance.android.ec.core.cps;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class u implements k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final u f43960a = null;

    public u() {
    }

    static {
        f43960a = new u();
    }

    @Override // com.bytedance.android.ec.core.cps.k
    public final String encode(String r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        return j.a(r100, "SHA-512");
    L5:
        return null;
    }
}
