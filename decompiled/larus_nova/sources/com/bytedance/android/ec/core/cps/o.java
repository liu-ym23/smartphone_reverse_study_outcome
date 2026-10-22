package com.bytedance.android.ec.core.cps;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class o implements k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final o f43954a = null;

    public o() {
    }

    static {
        f43954a = new o();
    }

    @Override // com.bytedance.android.ec.core.cps.k
    public final String encode(String r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        return j.a(r100, "SHA-256");
    L5:
        return null;
    }
}
