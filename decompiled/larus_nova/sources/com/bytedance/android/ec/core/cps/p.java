package com.bytedance.android.ec.core.cps;

import kotlin.jvm.internal.Intrinsics;
import org.bouncycastle.pqc.jcajce.spec.McElieceCCA2KeyGenParameterSpec;

/* JADX INFO: loaded from: classes43.dex */
public final class p implements k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final p f43955a = null;

    public p() {
    }

    static {
        f43955a = new p();
    }

    @Override // com.bytedance.android.ec.core.cps.k
    public final String encode(String r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        return j.a(r100, McElieceCCA2KeyGenParameterSpec.SHA384);
    L5:
        return null;
    }
}
