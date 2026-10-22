package org.bouncycastle.asn1.util;

import com.stepos.stepclaw.SecurePrefs;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1Primitive;

/* loaded from: classes.dex */
public class DERDump extends ASN1Dump {
    public static String dumpAsString(ASN1Encodable aSN1Encodable) {
        return dumpAsString(aSN1Encodable.toASN1Primitive());
    }

    public static String dumpAsString(ASN1Primitive aSN1Primitive) {
        StringBuilder sb = new StringBuilder();
        ASN1Dump._dumpAsString(SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, false, aSN1Primitive, sb);
        return sb.toString();
    }
}
