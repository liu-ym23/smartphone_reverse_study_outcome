package com.stepos.core.ota.crypto;

import java.io.File;
import java.io.FileInputStream;
import kotlin.Result;
import kotlin.c;
import kotlin.jvm.internal.g;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class AtRestFormat {
    public static final AtRestFormat INSTANCE = new AtRestFormat();
    private static final int MAGIC_LEN = 4;

    private AtRestFormat() {
    }

    public final boolean isEncrypted(File file) {
        Object objA;
        g.f(file, "file");
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            try {
                byte[] bArr = new byte[4];
                boolean z = false;
                int i10 = 0;
                while (i10 < 4) {
                    int i11 = fileInputStream.read(bArr, i10, 4 - i10);
                    if (i11 < 0) {
                        break;
                    }
                    i10 += i11;
                }
                if (i10 == 4) {
                    if (CryptoHeaderParser.INSTANCE.peekMagic(bArr) == 1398031696) {
                        z = true;
                    }
                }
                fileInputStream.close();
                objA = Boolean.valueOf(z);
            } finally {
            }
        } catch (Throwable th) {
            objA = c.a(th);
        }
        Object obj = Boolean.FALSE;
        if (objA instanceof Result.Failure) {
            objA = obj;
        }
        return ((Boolean) objA).booleanValue();
    }
}
