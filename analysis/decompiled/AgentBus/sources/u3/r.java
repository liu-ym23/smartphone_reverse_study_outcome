package u3;

import com.google.crypto.tink.shaded.protobuf.b0;
import f4.m1;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes.dex */
public final class r implements t3.a {

    /* renamed from: c, reason: collision with root package name */
    public static final byte[] f10050c = new byte[0];

    /* renamed from: a, reason: collision with root package name */
    public final m1 f10051a;

    /* renamed from: b, reason: collision with root package name */
    public final z3.b f10052b;

    public r(m1 m1Var, z3.b bVar) {
        this.f10051a = m1Var;
        this.f10052b = bVar;
    }

    @Override // t3.a
    public final byte[] a(byte[] bArr, byte[] bArr2) throws InterruptedException {
        com.google.crypto.tink.shaded.protobuf.a aVarJ0;
        m1 m1Var = this.f10051a;
        AtomicReference atomicReference = t3.n.f9726a;
        synchronized (t3.n.class) {
            try {
                a4.e eVar = ((t3.e) t3.n.f9726a.get()).a(m1Var.A()).f9706a;
                Class cls = (Class) eVar.f175c;
                if (!((Map) eVar.f176d).keySet().contains(cls) && !Void.class.equals(cls)) {
                    throw new IllegalArgumentException("Given internalKeyMananger " + eVar.toString() + " does not support primitive class " + cls.getName());
                }
                if (!((Boolean) t3.n.f9728c.get(m1Var.A())).booleanValue()) {
                    throw new GeneralSecurityException("newKey-operation not permitted for key type " + m1Var.A());
                }
                com.google.crypto.tink.shaded.protobuf.h hVarB = m1Var.B();
                try {
                    a4.d dVarG = eVar.g();
                    com.google.crypto.tink.shaded.protobuf.a aVarC0 = dVarG.C0(hVarB);
                    dVarG.D0(aVarC0);
                    aVarJ0 = dVarG.j0(aVarC0);
                } catch (b0 e10) {
                    throw new GeneralSecurityException("Failures parsing proto of type ".concat(((Class) eVar.g().f172f).getName()), e10);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        byte[] bArrD = aVarJ0.d();
        byte[] bArrA = this.f10052b.a(bArrD, f10050c);
        byte[] bArrA2 = ((t3.a) t3.n.c(this.f10051a.A(), com.google.crypto.tink.shaded.protobuf.h.h(bArrD, 0, bArrD.length), t3.a.class)).a(bArr, bArr2);
        return ByteBuffer.allocate(bArrA.length + 4 + bArrA2.length).putInt(bArrA.length).put(bArrA).put(bArrA2).array();
    }

    @Override // t3.a
    public final byte[] b(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        try {
            ByteBuffer byteBufferWrap = ByteBuffer.wrap(bArr);
            int i2 = byteBufferWrap.getInt();
            if (i2 <= 0 || i2 > bArr.length - 4) {
                throw new GeneralSecurityException("invalid ciphertext");
            }
            byte[] bArr3 = new byte[i2];
            byteBufferWrap.get(bArr3, 0, i2);
            byte[] bArr4 = new byte[byteBufferWrap.remaining()];
            byteBufferWrap.get(bArr4, 0, byteBufferWrap.remaining());
            byte[] bArrB = this.f10052b.b(bArr3, f10050c);
            String strA = this.f10051a.A();
            AtomicReference atomicReference = t3.n.f9726a;
            com.google.crypto.tink.shaded.protobuf.g gVar = com.google.crypto.tink.shaded.protobuf.h.f2209g;
            return ((t3.a) t3.n.c(strA, com.google.crypto.tink.shaded.protobuf.h.h(bArrB, 0, bArrB.length), t3.a.class)).b(bArr4, bArr2);
        } catch (IndexOutOfBoundsException | NegativeArraySizeException | BufferUnderflowException e10) {
            throw new GeneralSecurityException("invalid ciphertext", e10);
        }
    }
}
