package com.google.crypto.tink.jwt;

import java.time.Instant;
import java.util.List;
import java.util.Set;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class VerifiedJwt {
    private final RawJwt rawJwt;

    public VerifiedJwt(RawJwt rawJwt) {
        this.rawJwt = rawJwt;
    }

    public Set<String> customClaimNames() {
        return this.rawJwt.customClaimNames();
    }

    public List<String> getAudiences() {
        return this.rawJwt.getAudiences();
    }

    public Boolean getBooleanClaim(String str) {
        return this.rawJwt.getBooleanClaim(str);
    }

    public Instant getExpiration() {
        return this.rawJwt.getExpiration();
    }

    public Instant getIssuedAt() {
        return this.rawJwt.getIssuedAt();
    }

    public String getIssuer() {
        return this.rawJwt.getIssuer();
    }

    public String getJsonArrayClaim(String str) {
        return this.rawJwt.getJsonArrayClaim(str);
    }

    public String getJsonObjectClaim(String str) {
        return this.rawJwt.getJsonObjectClaim(str);
    }

    public String getJwtId() {
        return this.rawJwt.getJwtId();
    }

    public Instant getNotBefore() {
        return this.rawJwt.getNotBefore();
    }

    public Double getNumberClaim(String str) {
        return this.rawJwt.getNumberClaim(str);
    }

    public String getStringClaim(String str) {
        return this.rawJwt.getStringClaim(str);
    }

    public String getSubject() {
        return this.rawJwt.getSubject();
    }

    public String getTypeHeader() {
        return this.rawJwt.getTypeHeader();
    }

    public boolean hasAudiences() {
        return this.rawJwt.hasAudiences();
    }

    public boolean hasBooleanClaim(String str) {
        return this.rawJwt.hasBooleanClaim(str);
    }

    public boolean hasExpiration() {
        return this.rawJwt.hasExpiration();
    }

    public boolean hasIssuedAt() {
        return this.rawJwt.hasIssuedAt();
    }

    public boolean hasIssuer() {
        return this.rawJwt.hasIssuer();
    }

    public boolean hasJsonArrayClaim(String str) {
        return this.rawJwt.hasJsonArrayClaim(str);
    }

    public boolean hasJsonObjectClaim(String str) {
        return this.rawJwt.hasJsonObjectClaim(str);
    }

    public boolean hasJwtId() {
        return this.rawJwt.hasJwtId();
    }

    public boolean hasNotBefore() {
        return this.rawJwt.hasNotBefore();
    }

    public boolean hasNumberClaim(String str) {
        return this.rawJwt.hasNumberClaim(str);
    }

    public boolean hasStringClaim(String str) {
        return this.rawJwt.hasStringClaim(str);
    }

    public boolean hasSubject() {
        return this.rawJwt.hasSubject();
    }

    public boolean hasTypeHeader() {
        return this.rawJwt.hasTypeHeader();
    }

    public boolean isNullClaim(String str) {
        return this.rawJwt.isNullClaim(str);
    }

    public String toString() {
        return "verified{" + this.rawJwt + "}";
    }
}
