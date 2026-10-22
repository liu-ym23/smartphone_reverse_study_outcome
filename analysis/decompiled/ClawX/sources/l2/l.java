package l2;

import java.security.InvalidAlgorithmParameterException;
import java.util.Arrays;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class l implements j2.a {

    /* renamed from: a, reason: collision with root package name */
    public final k f3789a;

    /* renamed from: b, reason: collision with root package name */
    public final String f3790b;

    /* renamed from: c, reason: collision with root package name */
    public final SecretKeySpec f3791c;
    public final int d;

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0026  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public l(java.lang.String r4, javax.crypto.spec.SecretKeySpec r5) throws java.security.GeneralSecurityException {
        /*
            r3 = this;
            r3.<init>()
            l2.k r0 = new l2.k
            r0.<init>(r3)
            r3.f3789a = r0
            r1 = 2
            boolean r2 = a8.b.b(r1)
            if (r2 == 0) goto L8f
            r3.f3790b = r4
            r3.f3791c = r5
            byte[] r5 = r5.getEncoded()
            int r5 = r5.length
            r2 = 16
            if (r5 < r2) goto L87
            int r5 = r4.hashCode()
            r2 = -1
            switch(r5) {
                case -1823053428: goto L52;
                case 392315023: goto L47;
                case 392315118: goto L3e;
                case 392316170: goto L33;
                case 392317873: goto L28;
                default: goto L26;
            }
        L26:
            r1 = r2
            goto L5c
        L28:
            java.lang.String r5 = "HMACSHA512"
            boolean r5 = r4.equals(r5)
            if (r5 != 0) goto L31
            goto L26
        L31:
            r1 = 4
            goto L5c
        L33:
            java.lang.String r5 = "HMACSHA384"
            boolean r5 = r4.equals(r5)
            if (r5 != 0) goto L3c
            goto L26
        L3c:
            r1 = 3
            goto L5c
        L3e:
            java.lang.String r5 = "HMACSHA256"
            boolean r5 = r4.equals(r5)
            if (r5 != 0) goto L5c
            goto L26
        L47:
            java.lang.String r5 = "HMACSHA224"
            boolean r5 = r4.equals(r5)
            if (r5 != 0) goto L50
            goto L26
        L50:
            r1 = 1
            goto L5c
        L52:
            java.lang.String r5 = "HMACSHA1"
            boolean r5 = r4.equals(r5)
            if (r5 != 0) goto L5b
            goto L26
        L5b:
            r1 = 0
        L5c:
            switch(r1) {
                case 0: goto L7f;
                case 1: goto L7a;
                case 2: goto L75;
                case 3: goto L70;
                case 4: goto L6b;
                default: goto L5f;
            }
        L5f:
            java.security.NoSuchAlgorithmException r3 = new java.security.NoSuchAlgorithmException
            java.lang.String r5 = "unknown Hmac algorithm: "
            java.lang.String r4 = r5.concat(r4)
            r3.<init>(r4)
            throw r3
        L6b:
            r4 = 64
            r3.d = r4
            goto L83
        L70:
            r4 = 48
            r3.d = r4
            goto L83
        L75:
            r4 = 32
            r3.d = r4
            goto L83
        L7a:
            r4 = 28
            r3.d = r4
            goto L83
        L7f:
            r4 = 20
            r3.d = r4
        L83:
            r0.get()
            return
        L87:
            java.security.InvalidAlgorithmParameterException r3 = new java.security.InvalidAlgorithmParameterException
            java.lang.String r4 = "key size too small, need at least 16 bytes"
            r3.<init>(r4)
            throw r3
        L8f:
            java.security.GeneralSecurityException r3 = new java.security.GeneralSecurityException
            java.lang.String r4 = "Can not use HMAC in FIPS-mode, as BoringCrypto module is not available."
            r3.<init>(r4)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: l2.l.<init>(java.lang.String, javax.crypto.spec.SecretKeySpec):void");
    }

    @Override // j2.a
    public final byte[] e(byte[] bArr, int i8) throws IllegalStateException, InvalidAlgorithmParameterException {
        if (i8 > this.d) {
            throw new InvalidAlgorithmParameterException("tag size too big");
        }
        k kVar = this.f3789a;
        ((Mac) kVar.get()).update(bArr);
        return Arrays.copyOf(((Mac) kVar.get()).doFinal(), i8);
    }
}
