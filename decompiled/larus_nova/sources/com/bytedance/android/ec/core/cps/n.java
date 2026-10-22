package com.bytedance.android.ec.core.cps;

import kotlin.jvm.internal.Intrinsics;
import org.bouncycastle.pqc.jcajce.spec.McElieceCCA2KeyGenParameterSpec;

/* JADX INFO: loaded from: classes43.dex */
public final class n implements k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final n f43953a = null;

    public n() {
    }

    static {
        f43953a = new n();
    }

    @Override // com.bytedance.android.ec.core.cps.k
    public final String encode(String r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        return j.a(r100, McElieceCCA2KeyGenParameterSpec.SHA224);
    L5:
        return null;
    }
}
