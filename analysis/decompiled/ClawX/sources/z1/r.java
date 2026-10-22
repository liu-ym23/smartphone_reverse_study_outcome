package z1;

import com.google.crypto.tink.shaded.protobuf.c0;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.util.concurrent.atomic.AtomicReference;
import k2.a1;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class r implements y1.a {

    /* renamed from: c, reason: collision with root package name */
    public static final byte[] f6404c = new byte[0];

    /* renamed from: a, reason: collision with root package name */
    public final a1 f6405a;

    /* renamed from: b, reason: collision with root package name */
    public final e2.b f6406b;

    public r(a1 a1Var, e2.b bVar) {
        this.f6405a = a1Var;
        this.f6406b = bVar;
    }

    @Override // y1.a
    public final byte[] a(byte[] bArr, byte[] bArr2) throws InterruptedException {
        com.google.crypto.tink.shaded.protobuf.a aVarD;
        a1 a1Var = this.f6405a;
        AtomicReference atomicReference = y1.n.f6330a;
        synchronized (y1.n.class) {
            try {
                f2.e eVar = ((y1.e) y1.n.f6330a.get()).a(a1Var.B()).f6312a;
                Class cls = eVar.f2557c;
                if (!eVar.f2556b.keySet().contains(cls) && !Void.class.equals(cls)) {
                    throw new IllegalArgumentException("Given internalKeyMananger " + eVar.toString() + " does not support primitive class " + cls.getName());
                }
                if (!((Boolean) y1.n.f6332c.get(a1Var.B())).booleanValue()) {
                    throw new GeneralSecurityException("newKey-operation not permitted for key type " + a1Var.B());
                }
                com.google.crypto.tink.shaded.protobuf.i iVarC = a1Var.C();
                try {
                    f2.d dVarD = eVar.d();
                    com.google.crypto.tink.shaded.protobuf.a aVarI = dVarD.i(iVarC);
                    dVarD.k(aVarI);
                    aVarD = dVarD.d(aVarI);
                } catch (c0 e9) {
                    throw new GeneralSecurityException("Failures parsing proto of type ".concat(((Class) eVar.d().f2554a).getName()), e9);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        byte[] bArrE = aVarD.e();
        byte[] bArrA = this.f6406b.a(bArrE, f6404c);
        byte[] bArrA2 = ((y1.a) y1.n.d(this.f6405a.B(), bArrE)).a(bArr, bArr2);
        return ByteBuffer.allocate(bArrA.length + 4 + bArrA2.length).putInt(bArrA.length).put(bArrA).put(bArrA2).array();
    }

    @Override // y1.a
    public final byte[] b(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        try {
            ByteBuffer byteBufferWrap = ByteBuffer.wrap(bArr);
            int i8 = byteBufferWrap.getInt();
            if (i8 <= 0 || i8 > bArr.length - 4) {
                throw new GeneralSecurityException("invalid ciphertext");
            }
            byte[] bArr3 = new byte[i8];
            byteBufferWrap.get(bArr3, 0, i8);
            byte[] bArr4 = new byte[byteBufferWrap.remaining()];
            byteBufferWrap.get(bArr4, 0, byteBufferWrap.remaining());
            return ((y1.a) y1.n.d(this.f6405a.B(), this.f6406b.b(bArr3, f6404c))).b(bArr4, bArr2);
        } catch (IndexOutOfBoundsException | NegativeArraySizeException | BufferUnderflowException e9) {
            throw new GeneralSecurityException("invalid ciphertext", e9);
        }
    }
}
