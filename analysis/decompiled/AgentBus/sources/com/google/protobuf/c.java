package com.google.protobuf;

import java.io.IOException;
import java.io.OutputStream;
import java.util.logging.Logger;

/* loaded from: classes.dex */
public abstract class c implements MessageLite {
    protected int memoizedHashCode;

    public abstract int a(t3 t3Var);

    public final String b(String str) {
        return "Serializing " + getClass().getName() + " to a " + str + " threw an IOException (should never happen).";
    }

    @Override // com.google.protobuf.MessageLite
    public final byte[] toByteArray() {
        try {
            int iA = ((i2) this).a(null);
            byte[] bArr = new byte[iA];
            Logger logger = r.f2504b;
            p pVar = new p(iA, bArr);
            ((i2) this).writeTo(pVar);
            if (pVar.u0() == 0) {
                return bArr;
            }
            throw new IllegalStateException("Did not write as much data as expected.");
        } catch (IOException e10) {
            throw new RuntimeException(b("byte array"), e10);
        }
    }

    @Override // com.google.protobuf.MessageLite
    public final l toByteString() {
        try {
            int iA = ((i2) this).a(null);
            k kVar = l.f2424g;
            byte[] bArr = new byte[iA];
            Logger logger = r.f2504b;
            p pVar = new p(iA, bArr);
            ((i2) this).writeTo(pVar);
            if (pVar.u0() == 0) {
                return new k(bArr);
            }
            throw new IllegalStateException("Did not write as much data as expected.");
        } catch (IOException e10) {
            throw new RuntimeException(b("ByteString"), e10);
        }
    }

    @Override // com.google.protobuf.MessageLite
    public final void writeDelimitedTo(OutputStream outputStream) {
        i2 i2Var = (i2) this;
        int iA = i2Var.a(null);
        int iV = r.V(iA) + iA;
        if (iV > 4096) {
            iV = 4096;
        }
        q qVar = new q(outputStream, iV);
        qVar.r0(iA);
        i2Var.writeTo(qVar);
        if (qVar.f2499f > 0) {
            qVar.z0();
        }
    }

    @Override // com.google.protobuf.MessageLite
    public final void writeTo(OutputStream outputStream) {
        i2 i2Var = (i2) this;
        int iA = i2Var.a(null);
        Logger logger = r.f2504b;
        if (iA > 4096) {
            iA = 4096;
        }
        q qVar = new q(outputStream, iA);
        i2Var.writeTo(qVar);
        if (qVar.f2499f > 0) {
            qVar.z0();
        }
    }
}
