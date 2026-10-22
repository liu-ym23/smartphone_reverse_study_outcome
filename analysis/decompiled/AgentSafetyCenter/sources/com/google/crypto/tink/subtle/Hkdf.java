package com.google.crypto.tink.subtle;

import b8.z;
import java.security.GeneralSecurityException;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class Hkdf {
    private Hkdf() {
    }

    public static byte[] computeEciesHkdfSymmetricKey(byte[] bArr, byte[] bArr2, String str, byte[] bArr3, byte[] bArr4, int i) {
        return computeHkdf(str, Bytes.concat(bArr, bArr2), bArr3, bArr4, i);
    }

    public static byte[] computeHkdf(String str, byte[] bArr, byte[] bArr2, byte[] bArr3, int i) throws IllegalStateException, GeneralSecurityException {
        Mac engineFactory = EngineFactory.MAC.getInstance(str);
        if (i > engineFactory.getMacLength() * 255) {
            z.l("size too large");
            return null;
        }
        if (bArr2 == null || bArr2.length == 0) {
            engineFactory.init(new SecretKeySpec(new byte[engineFactory.getMacLength()], str));
        } else {
            engineFactory.init(new SecretKeySpec(bArr2, str));
        }
        byte[] bArr4 = new byte[i];
        engineFactory.init(new SecretKeySpec(engineFactory.doFinal(bArr), str));
        byte[] bArrDoFinal = new byte[0];
        int i3 = 1;
        int length = 0;
        while (true) {
            engineFactory.update(bArrDoFinal);
            engineFactory.update(bArr3);
            engineFactory.update((byte) i3);
            bArrDoFinal = engineFactory.doFinal();
            if (bArrDoFinal.length + length >= i) {
                System.arraycopy(bArrDoFinal, 0, bArr4, length, i - length);
                return bArr4;
            }
            System.arraycopy(bArrDoFinal, 0, bArr4, length, bArrDoFinal.length);
            length += bArrDoFinal.length;
            i3++;
        }
    }
}
