package com.bytedance.android.ec.core.cps;

import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.bouncycastle.crypto.digests.SM3Digest;

/* JADX INFO: loaded from: classes43.dex */
public final class v implements k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final v f43961a = null;

    public v() {
    }

    static {
        f43961a = new v();
    }

    @Override // com.bytedance.android.ec.core.cps.k
    public final String encode(String r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        byte[] r101 = r100.getBytes(Charsets.UTF_8);     // Catch: Throwable -> L5
        SM3Digest r102 = new SM3Digest();     // Catch: Throwable -> L5
        r102.update(r101, 0, r101.length);     // Catch: Throwable -> L5
        byte[] r103 = new byte[r102.getDigestSize()];     // Catch: Throwable -> L5
        r102.doFinal(r103, 0);     // Catch: Throwable -> L5
        return j.d(r103);
    L5:
        return null;
    }
}
