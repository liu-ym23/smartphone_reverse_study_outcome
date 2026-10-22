package com.google.crypto.tink.shaded.protobuf;

import java.io.IOException;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public abstract class a implements q0 {
    protected int memoizedHashCode;

    public abstract int b(b1 b1Var);

    public final String c(String str) {
        return "Serializing " + getClass().getName() + " to a " + str + " threw an IOException (should never happen).";
    }

    public abstract u d();

    public final byte[] e() {
        try {
            int iB = ((w) this).b(null);
            byte[] bArr = new byte[iB];
            l lVar = new l(bArr, iB);
            f(lVar);
            if (iB - lVar.f1490f == 0) {
                return bArr;
            }
            throw new IllegalStateException("Did not write as much data as expected.");
        } catch (IOException e9) {
            throw new RuntimeException(c("byte array"), e9);
        }
    }

    public abstract void f(l lVar);
}
