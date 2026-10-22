package org.bouncycastle.crypto.constraints;

import java.math.BigInteger;
import org.bouncycastle.asn1.BERTags;
import p7.h;

/* loaded from: classes.dex */
public class ConstraintUtils {
    public static int bitsOfSecurityFor(BigInteger bigInteger) {
        return bitsOfSecurityForFF(bigInteger.bitLength());
    }

    public static int bitsOfSecurityForFF(int i8) {
        if (i8 < 2048) {
            return i8 >= 1024 ? 80 : 20;
        }
        if (i8 < 3072) {
            return 112;
        }
        if (i8 < 7680) {
            return 128;
        }
        if (i8 >= 15360) {
            return 256;
        }
        return BERTags.PRIVATE;
    }

    public static int bitsOfSecurityFor(h hVar) {
        int iL = (hVar.l() + 1) / 2;
        if (iL > 256) {
            return 256;
        }
        return iL;
    }
}
