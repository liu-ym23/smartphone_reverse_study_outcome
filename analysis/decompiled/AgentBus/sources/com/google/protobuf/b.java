package com.google.protobuf;

import com.google.protobuf.MessageLite;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes.dex */
public abstract class b implements MessageLite.Builder {
    public final String a() {
        return "Reading " + getClass().getName() + " from a ByteString threw an IOException (should never happen).";
    }

    @Override // com.google.protobuf.MessageLite.Builder
    public final boolean mergeDelimitedFrom(InputStream inputStream, u1 u1Var) throws IOException {
        int i2 = inputStream.read();
        if (i2 == -1) {
            return false;
        }
        if ((i2 & 128) != 0) {
            i2 &= 127;
            int i10 = 7;
            while (true) {
                if (i10 >= 32) {
                    while (i10 < 64) {
                        int i11 = inputStream.read();
                        if (i11 == -1) {
                            throw r2.g();
                        }
                        if ((i11 & 128) != 0) {
                            i10 += 7;
                        }
                    }
                    throw r2.d();
                }
                int i12 = inputStream.read();
                if (i12 == -1) {
                    throw r2.g();
                }
                i2 |= (i12 & 127) << i10;
                if ((i12 & 128) == 0) {
                    break;
                }
                i10 += 7;
            }
        }
        n nVar = new n(new a(inputStream, i2, 0));
        ((f2) this).f(nVar, u1Var);
        nVar.a(0);
        return true;
    }

    @Override // com.google.protobuf.MessageLite.Builder
    public final MessageLite.Builder mergeFrom(InputStream inputStream) {
        o nVar;
        if (inputStream == null) {
            byte[] bArr = p2.f2496b;
            nVar = o.f(bArr, 0, bArr.length, false);
        } else {
            nVar = new n(inputStream);
        }
        ((f2) this).f(nVar, u1.b());
        nVar.a(0);
        return this;
    }

    @Override // com.google.protobuf.MessageLite.Builder
    public final MessageLite.Builder mergeFrom(InputStream inputStream, u1 u1Var) {
        o nVar;
        if (inputStream == null) {
            byte[] bArr = p2.f2496b;
            nVar = o.f(bArr, 0, bArr.length, false);
        } else {
            nVar = new n(inputStream);
        }
        ((f2) this).f(nVar, u1Var);
        nVar.a(0);
        return this;
    }

    @Override // com.google.protobuf.MessageLite.Builder
    public final boolean mergeDelimitedFrom(InputStream inputStream) {
        return mergeDelimitedFrom(inputStream, u1.b());
    }

    @Override // com.google.protobuf.MessageLite.Builder
    public final MessageLite.Builder mergeFrom(o oVar) {
        f2 f2Var = (f2) this;
        f2Var.f(oVar, u1.b());
        return f2Var;
    }

    @Override // com.google.protobuf.MessageLite.Builder
    public final MessageLite.Builder mergeFrom(l lVar) throws r2 {
        try {
            k kVar = (k) lVar;
            m mVarF = o.f(kVar.f2418i, kVar.k(), kVar.size(), true);
            ((f2) this).f(mVarF, u1.b());
            mVarF.a(0);
            return this;
        } catch (r2 e10) {
            throw e10;
        } catch (IOException e11) {
            throw new RuntimeException(a(), e11);
        }
    }

    @Override // com.google.protobuf.MessageLite.Builder
    public final MessageLite.Builder mergeFrom(l lVar, u1 u1Var) throws r2 {
        try {
            k kVar = (k) lVar;
            m mVarF = o.f(kVar.f2418i, kVar.k(), kVar.size(), true);
            ((f2) this).f(mVarF, u1Var);
            mVarF.a(0);
            return this;
        } catch (r2 e10) {
            throw e10;
        } catch (IOException e11) {
            throw new RuntimeException(a(), e11);
        }
    }

    @Override // com.google.protobuf.MessageLite.Builder
    public final MessageLite.Builder mergeFrom(byte[] bArr) {
        f2 f2Var = (f2) this;
        f2Var.g(bArr, 0, bArr.length, u1.b());
        return f2Var;
    }

    @Override // com.google.protobuf.MessageLite.Builder
    public final MessageLite.Builder mergeFrom(byte[] bArr, u1 u1Var) {
        f2 f2Var = (f2) this;
        f2Var.g(bArr, 0, bArr.length, u1Var);
        return f2Var;
    }

    @Override // com.google.protobuf.MessageLite.Builder
    public final MessageLite.Builder mergeFrom(MessageLite messageLite) {
        f2 f2Var = (f2) this;
        i2 i2Var = f2Var.f2350f;
        if (i2Var.getClass().isInstance(messageLite)) {
            i2 i2Var2 = (i2) ((c) messageLite);
            if (i2Var.equals(i2Var2)) {
                return f2Var;
            }
            f2Var.d();
            f2.h(f2Var.f2351g, i2Var2);
            return f2Var;
        }
        throw new IllegalArgumentException("mergeFrom(MessageLite) can only merge messages of the same type.");
    }
}
