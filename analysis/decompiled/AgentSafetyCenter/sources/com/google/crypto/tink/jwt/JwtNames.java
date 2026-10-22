package com.google.crypto.tink.jwt;

import g5.f;
import k0.a;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
final class JwtNames {
    static final String CLAIM_AUDIENCE = "aud";
    static final String CLAIM_EXPIRATION = "exp";
    static final String CLAIM_ISSUED_AT = "iat";
    static final String CLAIM_ISSUER = "iss";
    static final String CLAIM_JWT_ID = "jti";
    static final String CLAIM_NOT_BEFORE = "nbf";
    static final String CLAIM_SUBJECT = "sub";
    static final String HEADER_ALGORITHM = "alg";
    static final String HEADER_CRITICAL = "crit";
    static final String HEADER_KEY_ID = "kid";
    static final String HEADER_TYPE = "typ";

    private JwtNames() {
    }

    public static boolean isRegisteredName(String str) {
        return str.equals(CLAIM_ISSUER) || str.equals(CLAIM_SUBJECT) || str.equals(CLAIM_AUDIENCE) || str.equals(CLAIM_EXPIRATION) || str.equals(CLAIM_NOT_BEFORE) || str.equals(CLAIM_ISSUED_AT) || str.equals(CLAIM_JWT_ID);
    }

    public static void validate(String str) {
        if (isRegisteredName(str)) {
            f.s(a.C("claim '", str, "' is invalid because it's a registered name; use the corresponding setter method."));
        }
    }
}
