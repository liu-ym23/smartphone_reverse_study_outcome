package h4;

import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.security.spec.AlgorithmParameterSpec;
import java.util.Arrays;
import javax.crypto.Cipher;

/* loaded from: classes.dex */
public final class g implements t3.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4134a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f4135b;

    public g(int i2, byte[] bArr) throws GeneralSecurityException {
        this.f4134a = i2;
        switch (i2) {
            case 1:
                this.f4135b = new v3.d(0, bArr);
                return;
            case 2:
                this.f4135b = new v3.d(1, bArr);
                return;
            default:
                if (!m.x.b(2)) {
                    throw new GeneralSecurityException("Can not use AES-GCM in FIPS-mode, as BoringCrypto module is not available.");
                }
                this.f4135b = new v3.b(bArr);
                return;
        }
    }

    @Override // t3.a
    public final byte[] a(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        switch (this.f4134a) {
            case 0:
                byte[] bArrA = u.a(12);
                v3.b bVar = (v3.b) this.f4135b;
                boolean z4 = bVar.f10387b;
                if (bArrA.length != 12) {
                    throw new GeneralSecurityException("iv is wrong size");
                }
                if (bArr.length > 2147483619) {
                    throw new GeneralSecurityException("plaintext too long");
                }
                byte[] bArr3 = new byte[z4 ? bArr.length + 28 : bArr.length + 16];
                if (z4) {
                    System.arraycopy(bArrA, 0, bArr3, 0, 12);
                }
                AlgorithmParameterSpec algorithmParameterSpecA = v3.b.a(bArrA);
                fb.c cVar = v3.b.f10385c;
                ((Cipher) cVar.get()).init(1, bVar.f10386a, algorithmParameterSpecA);
                if (bArr2 != null && bArr2.length != 0) {
                    ((Cipher) cVar.get()).updateAAD(bArr2);
                }
                int iDoFinal = ((Cipher) cVar.get()).doFinal(bArr, 0, bArr.length, bArr3, z4 ? 12 : 0);
                if (iDoFinal == bArr.length + 16) {
                    return bArr3;
                }
                throw new GeneralSecurityException(a1.a.f(iDoFinal - bArr.length, "encryption failed; GCM tag must be 16 bytes, but got only ", " bytes"));
            case 1:
                ByteBuffer byteBufferAllocate = ByteBuffer.allocate(bArr.length + 28);
                byte[] bArrA2 = u.a(12);
                byteBufferAllocate.put(bArrA2);
                ((v3.d) this.f4135b).b(byteBufferAllocate, bArrA2, bArr, bArr2);
                return byteBufferAllocate.array();
            default:
                ByteBuffer byteBufferAllocate2 = ByteBuffer.allocate(bArr.length + 40);
                byte[] bArrA3 = u.a(24);
                byteBufferAllocate2.put(bArrA3);
                ((v3.d) this.f4135b).b(byteBufferAllocate2, bArrA3, bArr, bArr2);
                return byteBufferAllocate2.array();
        }
    }

    @Override // t3.a
    public final byte[] b(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        switch (this.f4134a) {
            case 0:
                byte[] bArrCopyOf = Arrays.copyOf(bArr, 12);
                v3.b bVar = (v3.b) this.f4135b;
                boolean z4 = bVar.f10387b;
                if (bArrCopyOf.length != 12) {
                    throw new GeneralSecurityException("iv is wrong size");
                }
                if (bArr.length < (z4 ? 28 : 16)) {
                    throw new GeneralSecurityException("ciphertext too short");
                }
                if (z4 && !ByteBuffer.wrap(bArrCopyOf).equals(ByteBuffer.wrap(bArr, 0, 12))) {
                    throw new GeneralSecurityException("iv does not match prepended iv");
                }
                AlgorithmParameterSpec algorithmParameterSpecA = v3.b.a(bArrCopyOf);
                fb.c cVar = v3.b.f10385c;
                ((Cipher) cVar.get()).init(2, bVar.f10386a, algorithmParameterSpecA);
                if (bArr2 != null && bArr2.length != 0) {
                    ((Cipher) cVar.get()).updateAAD(bArr2);
                }
                int i2 = z4 ? 12 : 0;
                int length = bArr.length;
                if (z4) {
                    length -= 12;
                }
                return ((Cipher) cVar.get()).doFinal(bArr, i2, length);
            case 1:
                if (bArr.length < 28) {
                    throw new GeneralSecurityException("ciphertext too short");
                }
                return ((v3.d) this.f4135b).a(ByteBuffer.wrap(bArr, 12, bArr.length - 12), Arrays.copyOf(bArr, 12), bArr2);
            default:
                if (bArr.length < 40) {
                    throw new GeneralSecurityException("ciphertext too short");
                }
                return ((v3.d) this.f4135b).a(ByteBuffer.wrap(bArr, 24, bArr.length - 24), Arrays.copyOf(bArr, 24), bArr2);
        }
    }
}
