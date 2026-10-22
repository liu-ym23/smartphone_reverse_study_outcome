package j1;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import javax.crypto.AEADBadTagException;

/* loaded from: classes.dex */
public abstract class c {

    /* renamed from: a, reason: collision with root package name */
    public Object f5106a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f5107b;

    public c(byte[] bArr) throws GeneralSecurityException {
        if (!m.x.a(1)) {
            throw new GeneralSecurityException("Can not use ChaCha20Poly1305 in FIPS-mode.");
        }
        this.f5106a = g(1, bArr);
        this.f5107b = g(0, bArr);
    }

    public static byte[] f(ByteBuffer byteBuffer, byte[] bArr) {
        int length = bArr.length % 16 == 0 ? bArr.length : (bArr.length + 16) - (bArr.length % 16);
        int iRemaining = byteBuffer.remaining();
        int i2 = iRemaining % 16;
        int i10 = (i2 == 0 ? iRemaining : (iRemaining + 16) - i2) + length;
        ByteBuffer byteBufferOrder = ByteBuffer.allocate(i10 + 16).order(ByteOrder.LITTLE_ENDIAN);
        byteBufferOrder.put(bArr);
        byteBufferOrder.position(length);
        byteBufferOrder.put(byteBuffer);
        byteBufferOrder.position(i10);
        byteBufferOrder.putLong(bArr.length);
        byteBufferOrder.putLong(iRemaining);
        return byteBufferOrder.array();
    }

    public byte[] a(ByteBuffer byteBuffer, byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        if (byteBuffer.remaining() < 16) {
            throw new GeneralSecurityException("ciphertext too short");
        }
        int iPosition = byteBuffer.position();
        byte[] bArr3 = new byte[16];
        byteBuffer.position(byteBuffer.limit() - 16);
        byteBuffer.get(bArr3);
        byteBuffer.position(iPosition);
        byteBuffer.limit(byteBuffer.limit() - 16);
        if (bArr2 == null) {
            bArr2 = new byte[0];
        }
        try {
            byte[] bArr4 = new byte[32];
            ((androidx.datastore.preferences.protobuf.j) this.f5107b).a(0, bArr).get(bArr4);
            if (!MessageDigest.isEqual(n7.o.e(bArr4, f(byteBuffer, bArr2)), bArr3)) {
                throw new GeneralSecurityException("invalid MAC");
            }
            byteBuffer.position(iPosition);
            androidx.datastore.preferences.protobuf.j jVar = (androidx.datastore.preferences.protobuf.j) this.f5106a;
            jVar.getClass();
            ByteBuffer byteBufferAllocate = ByteBuffer.allocate(byteBuffer.remaining());
            jVar.k(bArr, byteBufferAllocate, byteBuffer);
            return byteBufferAllocate.array();
        } catch (GeneralSecurityException e10) {
            throw new AEADBadTagException(e10.toString());
        }
    }

    public void b(ByteBuffer byteBuffer, byte[] bArr, byte[] bArr2, byte[] bArr3) throws GeneralSecurityException {
        if (byteBuffer.remaining() < bArr2.length + 16) {
            throw new IllegalArgumentException("Given ByteBuffer output is too small");
        }
        int iPosition = byteBuffer.position();
        androidx.datastore.preferences.protobuf.j jVar = (androidx.datastore.preferences.protobuf.j) this.f5106a;
        jVar.getClass();
        if (byteBuffer.remaining() < bArr2.length) {
            throw new IllegalArgumentException("Given ByteBuffer output is too small");
        }
        jVar.k(bArr, byteBuffer, ByteBuffer.wrap(bArr2));
        byteBuffer.position(iPosition);
        byteBuffer.limit(byteBuffer.limit() - 16);
        if (bArr3 == null) {
            bArr3 = new byte[0];
        }
        ByteBuffer byteBufferA = ((androidx.datastore.preferences.protobuf.j) this.f5107b).a(0, bArr);
        byte[] bArr4 = new byte[32];
        byteBufferA.get(bArr4);
        byte[] bArrE = n7.o.e(bArr4, f(byteBuffer, bArr3));
        byteBuffer.limit(byteBuffer.limit() + 16);
        byteBuffer.put(bArrE);
    }

    public abstract int[] c(int i2);

    public int[] d(int i2, int i10) {
        if (i2 < 0 || i10 < 0 || i2 == i10) {
            return null;
        }
        int[] iArr = (int[]) this.f5107b;
        iArr[0] = i2;
        iArr[1] = i10;
        return iArr;
    }

    public String e() {
        String str = (String) this.f5106a;
        if (str != null) {
            return str;
        }
        q7.k.j("text");
        throw null;
    }

    public abstract androidx.datastore.preferences.protobuf.j g(int i2, byte[] bArr);

    public abstract int[] h(int i2);

    public c() {
        this.f5107b = new int[2];
    }
}
