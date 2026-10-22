package io.ktor.network.tls.extensions;

import Z8.C1173v;
import com.stepos.statsapp.v3.lib.plugin.constants.Parameters;
import fb.v;
import io.ktor.network.tls.OID;
import io.ktor.network.tls.TLSException;
import io.ktor.network.tls.extensions.HashAndSign;
import io.ktor.utils.io.core.ByteReadPacketKt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000*\n\u0002\u0010\u0005\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\u001a-\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00002\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0000¢\u0006\u0004\b\u0006\u0010\u0007\u001a\u0019\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\t*\u00020\bH\u0000¢\u0006\u0004\b\n\u0010\u000b\u001a\u0015\u0010\f\u001a\u0004\u0018\u00010\u0005*\u00020\bH\u0000¢\u0006\u0004\b\f\u0010\r\u001a#\u0010\u0011\u001a\u0004\u0018\u00010\u0005*\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u0000¢\u0006\u0004\b\u0011\u0010\u0012\"\u001d\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00050\t8\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"", "hashValue", "signValue", "", "oidValue", "Lio/ktor/network/tls/extensions/HashAndSign;", "HashAndSign", "(BBLjava/lang/String;)Lio/ktor/network/tls/extensions/HashAndSign;", "Lfb/v;", "", "parseSignatureAlgorithms", "(Lfb/v;)Ljava/util/List;", "readHashAndSign", "(Lfb/v;)Lio/ktor/network/tls/extensions/HashAndSign;", "Lio/ktor/network/tls/extensions/HashAndSign$Companion;", "hash", Parameters.UXIP_REQUEST_PARAM_SIGN, "byCode", "(Lio/ktor/network/tls/extensions/HashAndSign$Companion;BB)Lio/ktor/network/tls/extensions/HashAndSign;", "SupportedSignatureAlgorithms", "Ljava/util/List;", "getSupportedSignatureAlgorithms", "()Ljava/util/List;", "ktor-network-tls"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class SignatureAlgorithmKt {
    private static final List<HashAndSign> SupportedSignatureAlgorithms;

    static {
        HashAlgorithm hashAlgorithm = HashAlgorithm.SHA384;
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.ECDSA;
        OID.Companion companion = OID.INSTANCE;
        HashAndSign hashAndSign = new HashAndSign(hashAlgorithm, signatureAlgorithm, companion.getECDSAwithSHA384Encryption());
        HashAlgorithm hashAlgorithm2 = HashAlgorithm.SHA256;
        HashAndSign hashAndSign2 = new HashAndSign(hashAlgorithm2, signatureAlgorithm, companion.getECDSAwithSHA256Encryption());
        HashAlgorithm hashAlgorithm3 = HashAlgorithm.SHA512;
        SignatureAlgorithm signatureAlgorithm2 = SignatureAlgorithm.RSA;
        SupportedSignatureAlgorithms = C1173v.p(hashAndSign, hashAndSign2, new HashAndSign(hashAlgorithm3, signatureAlgorithm2, companion.getRSAwithSHA512Encryption()), new HashAndSign(hashAlgorithm, signatureAlgorithm2, companion.getRSAwithSHA384Encryption()), new HashAndSign(hashAlgorithm2, signatureAlgorithm2, companion.getRSAwithSHA256Encryption()), new HashAndSign(HashAlgorithm.SHA1, signatureAlgorithm2, companion.getRSAwithSHA1Encryption()));
    }

    public static final HashAndSign HashAndSign(byte b10, byte b11, String str) throws TLSException {
        HashAlgorithm hashAlgorithmByCode = HashAlgorithm.INSTANCE.byCode(b10);
        SignatureAlgorithm signatureAlgorithmByCode = SignatureAlgorithm.INSTANCE.byCode(b11);
        if (signatureAlgorithmByCode == null) {
            return null;
        }
        return new HashAndSign(hashAlgorithmByCode, signatureAlgorithmByCode, str != null ? new OID(str) : null);
    }

    public static /* synthetic */ HashAndSign HashAndSign$default(byte b10, byte b11, String str, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            str = null;
        }
        return HashAndSign(b10, b11, str);
    }

    public static final HashAndSign byCode(HashAndSign.Companion companion, byte b10, byte b11) {
        Object next;
        p.i(companion, "<this>");
        if (b11 == SignatureAlgorithm.ANON.getCode()) {
            throw new IllegalStateException("Anonymous signature not allowed.");
        }
        Iterator<T> it = SupportedSignatureAlgorithms.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            HashAndSign hashAndSign = (HashAndSign) next;
            if (hashAndSign.getHash().getCode() == b10 && hashAndSign.getSign().getCode() == b11) {
                break;
            }
        }
        HashAndSign hashAndSign2 = (HashAndSign) next;
        return hashAndSign2 == null ? HashAndSign$default(b10, b11, null, 4, null) : hashAndSign2;
    }

    public static final List<HashAndSign> getSupportedSignatureAlgorithms() {
        return SupportedSignatureAlgorithms;
    }

    public static final List<HashAndSign> parseSignatureAlgorithms(v vVar) throws TLSException {
        p.i(vVar, "<this>");
        int i10 = vVar.readShort() & 65535;
        ArrayList arrayList = new ArrayList();
        while (ByteReadPacketKt.getRemaining(vVar) > 0) {
            HashAndSign hashAndSign = readHashAndSign(vVar);
            if (hashAndSign != null) {
                arrayList.add(hashAndSign);
            }
        }
        if (((int) ByteReadPacketKt.getRemaining(vVar)) == i10) {
            return arrayList;
        }
        throw new TLSException("Invalid hash and sign packet size: expected " + i10 + ", actual " + arrayList.size(), null, 2, null);
    }

    public static final HashAndSign readHashAndSign(v vVar) {
        p.i(vVar, "<this>");
        return byCode(HashAndSign.INSTANCE, vVar.readByte(), vVar.readByte());
    }
}
