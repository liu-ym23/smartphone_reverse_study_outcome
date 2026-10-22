package com.bytedance.android.ec.core.cps;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class m implements k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final m f43952a = null;

    public m() {
    }

    static {
        f43952a = new m();
    }

    @Override // com.bytedance.android.ec.core.cps.k
    public final String encode(String r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        return j.a(r100, "SHA-1");
    L5:
        return null;
    }
}
