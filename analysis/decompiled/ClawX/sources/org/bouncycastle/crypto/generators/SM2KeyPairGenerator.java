package org.bouncycastle.crypto.generators;

import java.math.BigInteger;
import org.bouncycastle.util.BigIntegers;
import p7.a;

/* loaded from: classes.dex */
public class SM2KeyPairGenerator extends ECKeyPairGenerator {
    public SM2KeyPairGenerator() {
        super("SM2KeyGen");
    }

    @Override // org.bouncycastle.crypto.generators.ECKeyPairGenerator
    public boolean isOutOfRangeD(BigInteger bigInteger, BigInteger bigInteger2) {
        return bigInteger.compareTo(a.f4758b) < 0 || bigInteger.compareTo(bigInteger2.subtract(BigIntegers.ONE)) >= 0;
    }
}
