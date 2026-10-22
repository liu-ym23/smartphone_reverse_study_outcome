package com.baidu.bbalbscesium.k.a;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import org.bouncycastle.crypto.signers.PSSSigner;

/* JADX INFO: loaded from: classes39.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile byte[] f30345a;

    public g() {
    }

    public static byte[] a() throws InvalidAlgorithmParameterException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
        if (f30345a != null) goto L15;
        monitor-enter(g.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f30345a != null) goto L9;
        byte[] r100 = new byte[16];     // Catch: Throwable -> L11
        System.arraycopy(com.baidu.bbalbscesium.k.c.b.a(), 0, r100, 0, 16);     // Catch: Throwable -> L11
        c r101 = new c();     // Catch: Throwable -> L11
        r101.a(2, r100, r100);     // Catch: Throwable -> L11
        f30345a = r101.a(new byte[]{-71, -100, -115, 26, 39, -124, 14, 14, -31, -46, -56, 1, 25, -127, -99, -107, -54, 51, 46, 14, 68, PSSSigner.TRAILER_IMPLICIT, -19, 28, 66, 19, -113, 5, 25, -11, -123, 50});     // Catch: Throwable -> L11
    L9:
        monitor-exit(g.class);     // Catch: Throwable -> L11
    L15:
        return f30345a;
    }
}
