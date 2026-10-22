package l2;

import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.security.MessageDigest;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class m implements y1.j {

    /* renamed from: a, reason: collision with root package name */
    public final j2.a f3792a;

    /* renamed from: b, reason: collision with root package name */
    public final int f3793b;

    public m(j2.a aVar, int i8) throws InvalidAlgorithmParameterException {
        this.f3792a = aVar;
        this.f3793b = i8;
        if (i8 < 10) {
            throw new InvalidAlgorithmParameterException("tag size too small, need at least 10 bytes");
        }
        aVar.e(new byte[0], i8);
    }

    @Override // y1.j
    public final void a(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        if (!MessageDigest.isEqual(b(bArr2), bArr)) {
            throw new GeneralSecurityException("invalid MAC");
        }
    }

    @Override // y1.j
    public final byte[] b(byte[] bArr) {
        return this.f3792a.e(bArr, this.f3793b);
    }
}
