package com.google.crypto.tink.shaded.protobuf;

import java.io.IOException;

/* loaded from: classes.dex */
public abstract class a implements p0 {
    protected int memoizedHashCode;

    public abstract int a(a1 a1Var);

    public final String b(String str) {
        return "Serializing " + getClass().getName() + " to a " + str + " threw an IOException (should never happen).";
    }

    public abstract t c();

    public final byte[] d() {
        try {
            int iA = ((v) this).a(null);
            byte[] bArr = new byte[iA];
            k kVar = new k(iA, bArr);
            e(kVar);
            if (iA - kVar.f2237d == 0) {
                return bArr;
            }
            throw new IllegalStateException("Did not write as much data as expected.");
        } catch (IOException e10) {
            throw new RuntimeException(b("byte array"), e10);
        }
    }

    public abstract void e(k kVar);
}
