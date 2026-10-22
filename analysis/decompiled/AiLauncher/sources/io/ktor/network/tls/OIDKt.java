package io.ktor.network.tls;

import La.D;
import com.autonavi.aps.amapapi.security.Encrypt;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0004\u001a\u0015\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"", "algorithm", "keysGenerationAlgorithm", "(Ljava/lang/String;)Ljava/lang/String;", "ktor-network-tls"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class OIDKt {
    public static final String keysGenerationAlgorithm(String algorithm) {
        p.i(algorithm, "algorithm");
        if (D.J(algorithm, "ecdsa", true)) {
            return "EC";
        }
        if (D.J(algorithm, "dsa", true)) {
            return "DSA";
        }
        if (D.J(algorithm, "rsa", true)) {
            return Encrypt.KEY_ALGORITHM;
        }
        throw new IllegalStateException(("Couldn't find KeyPairGenerator algorithm for " + algorithm).toString());
    }
}
