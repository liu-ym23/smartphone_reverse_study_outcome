package l2;

import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.security.spec.AlgorithmParameterSpec;
import java.util.Arrays;
import javax.crypto.Cipher;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class c implements y1.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3771a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f3772b;

    public c(byte[] bArr, int i8) throws GeneralSecurityException {
        this.f3771a = i8;
        switch (i8) {
            case 1:
                this.f3772b = new a2.f(bArr, 0);
                return;
            case 2:
                this.f3772b = new a2.f(bArr, 1);
                return;
            default:
                if (!a8.b.b(2)) {
                    throw new GeneralSecurityException("Can not use AES-GCM in FIPS-mode, as BoringCrypto module is not available.");
                }
                this.f3772b = new a2.c(bArr);
                return;
        }
    }

    @Override // y1.a
    public final byte[] a(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        switch (this.f3771a) {
            case 0:
                byte[] bArrA = n.a(12);
                a2.c cVar = (a2.c) this.f3772b;
                boolean z = cVar.f83b;
                if (bArrA.length != 12) {
                    throw new GeneralSecurityException("iv is wrong size");
                }
                if (bArr.length > 2147483619) {
                    throw new GeneralSecurityException("plaintext too long");
                }
                byte[] bArr3 = new byte[z ? bArr.length + 28 : bArr.length + 16];
                if (z) {
                    System.arraycopy(bArrA, 0, bArr3, 0, 12);
                }
                AlgorithmParameterSpec algorithmParameterSpecA = a2.c.a(bArrA);
                a2.b bVar = a2.c.f81c;
                ((Cipher) bVar.get()).init(1, cVar.f82a, algorithmParameterSpecA);
                if (bArr2 != null && bArr2.length != 0) {
                    ((Cipher) bVar.get()).updateAAD(bArr2);
                }
                int iDoFinal = ((Cipher) bVar.get()).doFinal(bArr, 0, bArr.length, bArr3, z ? 12 : 0);
                if (iDoFinal == bArr.length + 16) {
                    return bArr3;
                }
                throw new GeneralSecurityException(a8.b.k(iDoFinal - bArr.length, "encryption failed; GCM tag must be 16 bytes, but got only ", " bytes"));
            case 1:
                ByteBuffer byteBufferAllocate = ByteBuffer.allocate(bArr.length + 28);
                byte[] bArrA2 = n.a(12);
                byteBufferAllocate.put(bArrA2);
                ((a2.f) this.f3772b).c(byteBufferAllocate, bArrA2, bArr, bArr2);
                return byteBufferAllocate.array();
            default:
                ByteBuffer byteBufferAllocate2 = ByteBuffer.allocate(bArr.length + 40);
                byte[] bArrA3 = n.a(24);
                byteBufferAllocate2.put(bArrA3);
                ((a2.f) this.f3772b).c(byteBufferAllocate2, bArrA3, bArr, bArr2);
                return byteBufferAllocate2.array();
        }
    }

    @Override // y1.a
    public final byte[] b(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        switch (this.f3771a) {
            case 0:
                byte[] bArrCopyOf = Arrays.copyOf(bArr, 12);
                a2.c cVar = (a2.c) this.f3772b;
                boolean z = cVar.f83b;
                if (bArrCopyOf.length != 12) {
                    throw new GeneralSecurityException("iv is wrong size");
                }
                if (bArr.length < (z ? 28 : 16)) {
                    throw new GeneralSecurityException("ciphertext too short");
                }
                if (z && !ByteBuffer.wrap(bArrCopyOf).equals(ByteBuffer.wrap(bArr, 0, 12))) {
                    throw new GeneralSecurityException("iv does not match prepended iv");
                }
                AlgorithmParameterSpec algorithmParameterSpecA = a2.c.a(bArrCopyOf);
                a2.b bVar = a2.c.f81c;
                ((Cipher) bVar.get()).init(2, cVar.f82a, algorithmParameterSpecA);
                if (bArr2 != null && bArr2.length != 0) {
                    ((Cipher) bVar.get()).updateAAD(bArr2);
                }
                int i8 = z ? 12 : 0;
                int length = bArr.length;
                if (z) {
                    length -= 12;
                }
                return ((Cipher) bVar.get()).doFinal(bArr, i8, length);
            case 1:
                if (bArr.length < 28) {
                    throw new GeneralSecurityException("ciphertext too short");
                }
                return ((a2.f) this.f3772b).b(ByteBuffer.wrap(bArr, 12, bArr.length - 12), Arrays.copyOf(bArr, 12), bArr2);
            default:
                if (bArr.length < 40) {
                    throw new GeneralSecurityException("ciphertext too short");
                }
                return ((a2.f) this.f3772b).b(ByteBuffer.wrap(bArr, 24, bArr.length - 24), Arrays.copyOf(bArr, 24), bArr2);
        }
    }
}
