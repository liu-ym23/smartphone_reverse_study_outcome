package io.ktor.network.tls;

import Z8.C1168p;
import com.autonavi.aps.amapapi.utils.CoreUtil;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a1\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u0005H\u0000¢\u0006\u0004\b\u0007\u0010\b\u001a1\u0010\f\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Ljavax/crypto/SecretKey;", "secret", "", "label", "seed", "", "requiredLength", "PRF", "(Ljavax/crypto/SecretKey;[B[BI)[B", "Ljavax/crypto/Mac;", CoreUtil.STR_DEX_MAC_NAME, "secretKey", "P_hash", "([BLjavax/crypto/Mac;Ljavax/crypto/SecretKey;I)[B", "ktor-network-tls"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class HashesKt {
    public static final byte[] PRF(SecretKey secret, byte[] label, byte[] seed, int i10) throws NoSuchAlgorithmException {
        p.i(secret, "secret");
        p.i(label, "label");
        p.i(seed, "seed");
        byte[] bArrE = C1168p.E(label, seed);
        Mac mac = Mac.getInstance(secret.getAlgorithm());
        p.h(mac, "getInstance(...)");
        return P_hash(bArrE, mac, secret, i10);
    }

    public static /* synthetic */ byte[] PRF$default(SecretKey secretKey, byte[] bArr, byte[] bArr2, int i10, int i11, Object obj) {
        if ((i11 & 8) != 0) {
            i10 = 12;
        }
        return PRF(secretKey, bArr, bArr2, i10);
    }

    private static final byte[] P_hash(byte[] bArr, Mac mac, SecretKey secretKey, int i10) throws IllegalStateException, InvalidKeyException {
        if (i10 < 12) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        byte[] bArrE = new byte[0];
        byte[] bArrDoFinal = bArr;
        while (bArrE.length < i10) {
            mac.reset();
            mac.init(secretKey);
            mac.update(bArrDoFinal);
            bArrDoFinal = mac.doFinal();
            p.h(bArrDoFinal, "doFinal(...)");
            mac.reset();
            mac.init(secretKey);
            mac.update(bArrDoFinal);
            mac.update(bArr);
            byte[] bArrDoFinal2 = mac.doFinal();
            p.h(bArrDoFinal2, "doFinal(...)");
            bArrE = C1168p.E(bArrE, bArrDoFinal2);
        }
        byte[] bArrCopyOf = Arrays.copyOf(bArrE, i10);
        p.h(bArrCopyOf, "copyOf(...)");
        return bArrCopyOf;
    }

    public static /* synthetic */ byte[] P_hash$default(byte[] bArr, Mac mac, SecretKey secretKey, int i10, int i11, Object obj) {
        if ((i11 & 8) != 0) {
            i10 = 12;
        }
        return P_hash(bArr, mac, secretKey, i10);
    }
}
