package com.bytedance.android.ec.core.cps;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class l implements k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final l f43951a = null;

    public l() {
    }

    static {
        f43951a = new l();
    }

    @Override // com.bytedance.android.ec.core.cps.k
    public final String encode(String r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        return j.a(r100, "MD5");
    L5:
        return null;
    }
}
