package l2;

import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.util.Arrays;
import k4.v;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class g implements y1.a {

    /* renamed from: a, reason: collision with root package name */
    public final j f3780a;

    /* renamed from: b, reason: collision with root package name */
    public final y1.j f3781b;

    /* renamed from: c, reason: collision with root package name */
    public final int f3782c;

    public g(j jVar, y1.j jVar2, int i8) {
        this.f3780a = jVar;
        this.f3781b = jVar2;
        this.f3782c = i8;
    }

    @Override // y1.a
    public final byte[] a(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        a aVar = (a) this.f3780a;
        aVar.getClass();
        int length = bArr.length;
        int i8 = aVar.f3764b;
        int i9 = Integer.MAX_VALUE - i8;
        if (length > i9) {
            throw new GeneralSecurityException(a8.b.j(i9, "plaintext length can not exceed "));
        }
        byte[] bArr3 = new byte[bArr.length + i8];
        byte[] bArrA = n.a(i8);
        System.arraycopy(bArrA, 0, bArr3, 0, i8);
        aVar.a(bArr, 0, bArr.length, bArr3, aVar.f3764b, bArrA, true);
        if (bArr2 == null) {
            bArr2 = new byte[0];
        }
        return v.q(bArr3, this.f3781b.b(v.q(bArr2, bArr3, Arrays.copyOf(ByteBuffer.allocate(8).putLong(bArr2.length * 8).array(), 8))));
    }

    @Override // y1.a
    public final byte[] b(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        int length = bArr.length;
        int i8 = this.f3782c;
        if (length < i8) {
            throw new GeneralSecurityException("ciphertext too short");
        }
        byte[] bArrCopyOfRange = Arrays.copyOfRange(bArr, 0, bArr.length - i8);
        byte[] bArrCopyOfRange2 = Arrays.copyOfRange(bArr, bArr.length - i8, bArr.length);
        if (bArr2 == null) {
            bArr2 = new byte[0];
        }
        this.f3781b.a(bArrCopyOfRange2, v.q(bArr2, bArrCopyOfRange, Arrays.copyOf(ByteBuffer.allocate(8).putLong(bArr2.length * 8).array(), 8)));
        a aVar = (a) this.f3780a;
        aVar.getClass();
        int length2 = bArrCopyOfRange.length;
        int i9 = aVar.f3764b;
        if (length2 < i9) {
            throw new GeneralSecurityException("ciphertext too short");
        }
        byte[] bArr3 = new byte[i9];
        System.arraycopy(bArrCopyOfRange, 0, bArr3, 0, i9);
        int length3 = bArrCopyOfRange.length;
        int i10 = aVar.f3764b;
        byte[] bArr4 = new byte[length3 - i10];
        aVar.a(bArrCopyOfRange, i10, bArrCopyOfRange.length - i10, bArr4, 0, bArr3, false);
        return bArr4;
    }
}
