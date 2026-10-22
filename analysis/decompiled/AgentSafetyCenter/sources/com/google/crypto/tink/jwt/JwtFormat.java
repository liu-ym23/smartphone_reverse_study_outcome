package com.google.crypto.tink.jwt;

import androidx.activity.b;
import com.google.crypto.tink.internal.Util;
import com.google.crypto.tink.proto.OutputPrefixType;
import com.google.crypto.tink.subtle.Base64;
import java.nio.ByteBuffer;
import java.nio.charset.CharacterCodingException;
import java.security.InvalidAlgorithmParameterException;
import java.util.Optional;
import k0.a;
import m7.g;
import m7.j;
import m7.l;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
final class JwtFormat {

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public static class Parts {
        String header;
        String payload;
        byte[] signatureOrMac;
        String unsignedCompact;

        public Parts(String str, byte[] bArr, String str2, String str3) {
            this.unsignedCompact = str;
            this.signatureOrMac = bArr;
            this.header = str2;
            this.payload = str3;
        }
    }

    private JwtFormat() {
    }

    public static String createHeader(String str, Optional<String> optional, Optional<String> optional2) throws InvalidAlgorithmParameterException {
        validateAlgorithm(str);
        j jVar = new j();
        if (optional2.isPresent()) {
            jVar.l("kid", optional2.get());
        }
        jVar.l("alg", str);
        if (optional.isPresent()) {
            jVar.l("typ", optional.get());
        }
        return Base64.urlSafeEncode(jVar.toString().getBytes(Util.UTF_8));
    }

    public static String createSignedCompact(String str, byte[] bArr) {
        StringBuilder sbV = a.v(str, ".");
        sbV.append(encodeSignature(bArr));
        return sbV.toString();
    }

    public static String createUnsignedCompact(String str, Optional<String> optional, RawJwt rawJwt) {
        String jsonPayload = rawJwt.getJsonPayload();
        return createHeader(str, rawJwt.hasTypeHeader() ? Optional.of(rawJwt.getTypeHeader()) : Optional.empty(), optional) + "." + encodePayload(jsonPayload);
    }

    public static String decodeHeader(String str) throws JwtInvalidException, CharacterCodingException {
        byte[] bArrStrictUrlSafeDecode = strictUrlSafeDecode(str);
        validateUtf8(bArrStrictUrlSafeDecode);
        return new String(bArrStrictUrlSafeDecode, Util.UTF_8);
    }

    public static String decodePayload(String str) throws JwtInvalidException, CharacterCodingException {
        byte[] bArrStrictUrlSafeDecode = strictUrlSafeDecode(str);
        validateUtf8(bArrStrictUrlSafeDecode);
        return new String(bArrStrictUrlSafeDecode, Util.UTF_8);
    }

    public static byte[] decodeSignature(String str) {
        return strictUrlSafeDecode(str);
    }

    public static String encodePayload(String str) {
        return Base64.urlSafeEncode(str.getBytes(Util.UTF_8));
    }

    public static String encodeSignature(byte[] bArr) {
        return Base64.urlSafeEncode(bArr);
    }

    public static Optional<Integer> getKeyId(String str) {
        byte[] bArrUrlSafeDecode = Base64.urlSafeDecode(str);
        return bArrUrlSafeDecode.length != 4 ? Optional.empty() : Optional.of(Integer.valueOf(ByteBuffer.wrap(bArrUrlSafeDecode).getInt()));
    }

    public static Optional<String> getKid(int i, OutputPrefixType outputPrefixType) throws JwtInvalidException {
        if (outputPrefixType == OutputPrefixType.RAW) {
            return Optional.empty();
        }
        if (outputPrefixType == OutputPrefixType.TINK) {
            return Optional.of(Base64.urlSafeEncode(ByteBuffer.allocate(4).putInt(i).array()));
        }
        throw new JwtInvalidException("unsupported output prefix type");
    }

    private static String getStringHeader(j jVar, String str) throws JwtInvalidException {
        if (!jVar.f8266c.containsKey(str)) {
            throw new JwtInvalidException(a.C("header ", str, " does not exist"));
        }
        g gVarN = jVar.n(str);
        gVarN.getClass();
        if ((gVarN instanceof l) && (jVar.n(str).f().f8267c instanceof String)) {
            return jVar.n(str).i();
        }
        throw new JwtInvalidException(a.C("header ", str, " is not a string"));
    }

    public static Optional<String> getTypeHeader(j jVar) {
        return jVar.f8266c.containsKey("typ") ? Optional.of(getStringHeader(jVar, "typ")) : Optional.empty();
    }

    public static boolean isValidUrlsafeBase64Char(char c9) {
        if (c9 >= 'a' && c9 <= 'z') {
            return true;
        }
        if (c9 < 'A' || c9 > 'Z') {
            return (c9 >= '0' && c9 <= '9') || c9 == '-' || c9 == '_';
        }
        return true;
    }

    public static Parts splitSignedCompact(String str) throws JwtInvalidException {
        validateASCII(str);
        int iLastIndexOf = str.lastIndexOf(46);
        if (iLastIndexOf < 0) {
            throw new JwtInvalidException("only tokens in JWS compact serialization format are supported");
        }
        String strSubstring = str.substring(0, iLastIndexOf);
        byte[] bArrDecodeSignature = decodeSignature(str.substring(iLastIndexOf + 1));
        int iIndexOf = strSubstring.indexOf(46);
        if (iIndexOf < 0) {
            throw new JwtInvalidException("only tokens in JWS compact serialization format are supported");
        }
        String strSubstring2 = strSubstring.substring(0, iIndexOf);
        String strSubstring3 = strSubstring.substring(iIndexOf + 1);
        if (strSubstring3.indexOf(46) <= 0) {
            return new Parts(strSubstring, bArrDecodeSignature, decodeHeader(strSubstring2), decodePayload(strSubstring3));
        }
        throw new JwtInvalidException("only tokens in JWS compact serialization format are supported");
    }

    public static byte[] strictUrlSafeDecode(String str) throws JwtInvalidException {
        for (int i = 0; i < str.length(); i++) {
            if (!isValidUrlsafeBase64Char(str.charAt(i))) {
                throw new JwtInvalidException("invalid encoding");
            }
        }
        try {
            return Base64.urlSafeDecode(str);
        } catch (IllegalArgumentException e10) {
            throw new JwtInvalidException("invalid encoding: " + e10);
        }
    }

    public static void validateASCII(String str) throws JwtInvalidException {
        for (int i = 0; i < str.length(); i++) {
            if ((str.charAt(i) & 128) > 0) {
                throw new JwtInvalidException("Non ascii character");
            }
        }
    }

    private static void validateAlgorithm(String str) throws InvalidAlgorithmParameterException {
        str.getClass();
        switch (str) {
            case "ES256":
            case "ES384":
            case "ES512":
            case "HS256":
            case "HS384":
            case "HS512":
            case "PS256":
            case "PS384":
            case "PS512":
            case "RS256":
            case "RS384":
            case "RS512":
                return;
            default:
                throw new InvalidAlgorithmParameterException("invalid algorithm: ".concat(str));
        }
    }

    public static void validateHeader(String str, Optional<String> optional, Optional<String> optional2, j jVar) throws JwtInvalidException, InvalidAlgorithmParameterException {
        validateAlgorithm(str);
        String stringHeader = getStringHeader(jVar, "alg");
        if (!stringHeader.equals(str)) {
            throw new InvalidAlgorithmParameterException(b.j("invalid algorithm; expected ", str, ", got ", stringHeader));
        }
        if (jVar.f8266c.containsKey("crit")) {
            throw new JwtInvalidException("all tokens with crit headers are rejected");
        }
        if (optional.isPresent() && optional2.isPresent()) {
            throw new JwtInvalidException("custom_kid can only be set for RAW keys.");
        }
        boolean zContainsKey = jVar.f8266c.containsKey("kid");
        if (optional.isPresent()) {
            if (!zContainsKey) {
                throw new JwtInvalidException("missing kid in header");
            }
            validateKidInHeader(optional.get(), jVar);
        }
        if (optional2.isPresent() && zContainsKey) {
            validateKidInHeader(optional2.get(), jVar);
        }
    }

    private static void validateKidInHeader(String str, j jVar) throws JwtInvalidException {
        if (!getStringHeader(jVar, "kid").equals(str)) {
            throw new JwtInvalidException("invalid kid in header");
        }
    }

    public static void validateUtf8(byte[] bArr) throws JwtInvalidException, CharacterCodingException {
        try {
            Util.UTF_8.newDecoder().decode(ByteBuffer.wrap(bArr));
        } catch (CharacterCodingException e10) {
            throw new JwtInvalidException(e10.getMessage());
        }
    }
}
