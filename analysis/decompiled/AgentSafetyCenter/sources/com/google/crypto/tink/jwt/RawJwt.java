package com.google.crypto.tink.jwt;

import g5.f;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import k0.a;
import m7.g;
import m7.i;
import m7.j;
import m7.k;
import m7.l;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class RawJwt {
    private static final long MAX_TIMESTAMP_VALUE = 253402300799L;
    private final j payload;
    private final Optional<String> typeHeader;

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public static final class Builder {
        private final j payload;
        private Optional<String> typeHeader;
        private boolean withoutExpiration;

        private Builder() {
            this.typeHeader = Optional.empty();
            this.withoutExpiration = false;
            this.payload = new j();
        }

        private void setTimestampClaim(String str, Instant instant) {
            long epochSecond = instant.getEpochSecond();
            if (epochSecond > RawJwt.MAX_TIMESTAMP_VALUE || epochSecond < 0) {
                f.s(a.C("timestamp of claim ", str, " is out of range"));
                return;
            }
            j jVar = this.payload;
            Long lValueOf = Long.valueOf(epochSecond);
            l lVar = new l();
            lVar.f8267c = lValueOf;
            jVar.j(str, lVar);
        }

        public Builder addAudience(String str) {
            m7.f fVar;
            if (!JsonUtil.isValidString(str)) {
                f.s("invalid string");
                return null;
            }
            if (this.payload.f8266c.containsKey("aud")) {
                g gVarN = this.payload.n("aud");
                gVarN.getClass();
                if (!(gVarN instanceof m7.f)) {
                    f.s("addAudience can't be used together with setAudience");
                    return null;
                }
                fVar = gVarN.d();
            } else {
                fVar = new m7.f();
            }
            fVar.j(str);
            this.payload.j("aud", fVar);
            return this;
        }

        public Builder addBooleanClaim(String str, boolean z10) {
            JwtNames.validate(str);
            j jVar = this.payload;
            Boolean boolValueOf = Boolean.valueOf(z10);
            l lVar = new l();
            lVar.f8267c = boolValueOf;
            jVar.j(str, lVar);
            return this;
        }

        public Builder addJsonArrayClaim(String str, String str2) {
            JwtNames.validate(str);
            this.payload.j(str, JsonUtil.parseJsonArray(str2));
            return this;
        }

        public Builder addJsonObjectClaim(String str, String str2) {
            JwtNames.validate(str);
            this.payload.j(str, JsonUtil.parseJson(str2));
            return this;
        }

        public Builder addNullClaim(String str) {
            JwtNames.validate(str);
            this.payload.j(str, i.f8265c);
            return this;
        }

        public Builder addNumberClaim(String str, double d7) {
            JwtNames.validate(str);
            j jVar = this.payload;
            Double dValueOf = Double.valueOf(d7);
            l lVar = new l();
            lVar.f8267c = dValueOf;
            jVar.j(str, lVar);
            return this;
        }

        public Builder addStringClaim(String str, String str2) {
            if (!JsonUtil.isValidString(str2)) {
                od.f.b();
                return null;
            }
            JwtNames.validate(str);
            this.payload.j(str, new l(str2));
            return this;
        }

        public RawJwt build() {
            return new RawJwt(this);
        }

        public Builder setAudience(String str) {
            if (this.payload.f8266c.containsKey("aud")) {
                g gVarN = this.payload.n("aud");
                gVarN.getClass();
                if (gVarN instanceof m7.f) {
                    f.s("setAudience can't be used together with setAudiences or addAudience");
                    return null;
                }
            }
            if (JsonUtil.isValidString(str)) {
                this.payload.j("aud", new l(str));
                return this;
            }
            f.s("invalid string");
            return null;
        }

        public Builder setAudiences(List<String> list) {
            if (this.payload.f8266c.containsKey("aud")) {
                g gVarN = this.payload.n("aud");
                gVarN.getClass();
                if (!(gVarN instanceof m7.f)) {
                    f.s("setAudiences can't be used together with setAudience");
                    return null;
                }
            }
            if (list.isEmpty()) {
                f.s("audiences must not be empty");
                return null;
            }
            m7.f fVar = new m7.f();
            for (String str : list) {
                if (!JsonUtil.isValidString(str)) {
                    f.s("invalid string");
                    return null;
                }
                fVar.j(str);
            }
            this.payload.j("aud", fVar);
            return this;
        }

        public Builder setExpiration(Instant instant) {
            setTimestampClaim("exp", instant);
            return this;
        }

        public Builder setIssuedAt(Instant instant) {
            setTimestampClaim("iat", instant);
            return this;
        }

        public Builder setIssuer(String str) {
            if (JsonUtil.isValidString(str)) {
                this.payload.j("iss", new l(str));
                return this;
            }
            od.f.b();
            return null;
        }

        public Builder setJwtId(String str) {
            if (JsonUtil.isValidString(str)) {
                this.payload.j("jti", new l(str));
                return this;
            }
            od.f.b();
            return null;
        }

        public Builder setNotBefore(Instant instant) {
            setTimestampClaim("nbf", instant);
            return this;
        }

        public Builder setSubject(String str) {
            if (JsonUtil.isValidString(str)) {
                this.payload.j("sub", new l(str));
                return this;
            }
            od.f.b();
            return null;
        }

        public Builder setTypeHeader(String str) {
            this.typeHeader = Optional.of(str);
            return this;
        }

        public Builder withoutExpiration() {
            this.withoutExpiration = true;
            return this;
        }
    }

    private RawJwt(Builder builder) {
        if (!builder.payload.f8266c.containsKey("exp") && !builder.withoutExpiration) {
            f.s("neither setExpiration() nor withoutExpiration() was called");
            throw null;
        }
        if (builder.payload.f8266c.containsKey("exp") && builder.withoutExpiration) {
            f.s("setExpiration() and withoutExpiration() must not be called together");
            throw null;
        }
        this.typeHeader = builder.typeHeader;
        this.payload = builder.payload.a();
    }

    public static RawJwt fromJsonPayload(Optional<String> optional, String str) {
        return new RawJwt(optional, str);
    }

    private Instant getInstant(String str) {
        if (!this.payload.f8266c.containsKey(str)) {
            throw new JwtInvalidException(a.C("claim ", str, " does not exist"));
        }
        g gVarN = this.payload.n(str);
        gVarN.getClass();
        if (!(gVarN instanceof l) || !(this.payload.n(str).f().f8267c instanceof Number)) {
            throw new JwtInvalidException(a.C("claim ", str, " is not a timestamp"));
        }
        try {
            return Instant.ofEpochMilli((long) (this.payload.n(str).f().c() * 1000.0d));
        } catch (NumberFormatException e10) {
            throw new JwtInvalidException("claim " + str + " is not a timestamp: " + e10);
        }
    }

    private String getStringClaimInternal(String str) throws JwtInvalidException {
        if (!this.payload.f8266c.containsKey(str)) {
            throw new JwtInvalidException(a.C("claim ", str, " does not exist"));
        }
        g gVarN = this.payload.n(str);
        gVarN.getClass();
        if ((gVarN instanceof l) && (this.payload.n(str).f().f8267c instanceof String)) {
            return this.payload.n(str).i();
        }
        throw new JwtInvalidException(a.C("claim ", str, " is not a string"));
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    private void validateAudienceClaim() throws JwtInvalidException {
        if (this.payload.f8266c.containsKey("aud")) {
            g gVarN = this.payload.n("aud");
            gVarN.getClass();
            if (!((gVarN instanceof l) && (this.payload.n("aud").f().f8267c instanceof String)) && getAudiences().size() < 1) {
                throw new JwtInvalidException("invalid JWT payload: claim aud is present but empty.");
            }
        }
    }

    private void validateStringClaim(String str) throws JwtInvalidException {
        if (this.payload.f8266c.containsKey(str)) {
            g gVarN = this.payload.n(str);
            gVarN.getClass();
            if (!(gVarN instanceof l) || !(this.payload.n(str).f().f8267c instanceof String)) {
                throw new JwtInvalidException(a.C("invalid JWT payload: claim ", str, " is not a string."));
            }
        }
    }

    private void validateTimestampClaim(String str) throws JwtInvalidException {
        if (this.payload.f8266c.containsKey(str)) {
            g gVarN = this.payload.n(str);
            gVarN.getClass();
            if (!(gVarN instanceof l) || !(this.payload.n(str).f().f8267c instanceof Number)) {
                throw new JwtInvalidException(a.C("invalid JWT payload: claim ", str, " is not a number."));
            }
            double dC = this.payload.n(str).f().c();
            if (dC > 2.53402300799E11d || dC < 0.0d) {
                throw new JwtInvalidException(a.C("invalid JWT payload: claim ", str, " has an invalid timestamp"));
            }
        }
    }

    public Set<String> customClaimNames() {
        HashSet hashSet = new HashSet();
        Iterator it = ((o7.l) this.payload.f8266c.keySet()).iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            if (!JwtNames.isRegisteredName(str)) {
                hashSet.add(str);
            }
        }
        return Collections.unmodifiableSet(hashSet);
    }

    public List<String> getAudiences() throws JwtInvalidException {
        if (!hasAudiences()) {
            throw new JwtInvalidException("claim aud does not exist");
        }
        g gVarN = this.payload.n("aud");
        gVarN.getClass();
        if (gVarN instanceof l) {
            if (gVarN.f().f8267c instanceof String) {
                return Collections.unmodifiableList(Arrays.asList(gVarN.i()));
            }
            throw new JwtInvalidException(String.format("invalid audience: got %s; want a string", gVarN));
        }
        if (!(gVarN instanceof m7.f)) {
            throw new JwtInvalidException("claim aud is not a string or a JSON array");
        }
        m7.f fVarD = gVarN.d();
        ArrayList arrayList = fVarD.f8264c;
        ArrayList arrayList2 = new ArrayList(arrayList.size());
        for (int i = 0; i < arrayList.size(); i++) {
            g gVarL = fVarD.l(i);
            gVarL.getClass();
            if (!(gVarL instanceof l) || !(fVarD.l(i).f().f8267c instanceof String)) {
                throw new JwtInvalidException(String.format("invalid audience: got %s; want a string", fVarD.l(i)));
            }
            arrayList2.add(fVarD.l(i).i());
        }
        return Collections.unmodifiableList(arrayList2);
    }

    public Boolean getBooleanClaim(String str) throws JwtInvalidException {
        JwtNames.validate(str);
        if (!this.payload.f8266c.containsKey(str)) {
            throw new JwtInvalidException(a.C("claim ", str, " does not exist"));
        }
        g gVarN = this.payload.n(str);
        gVarN.getClass();
        if ((gVarN instanceof l) && (this.payload.n(str).f().f8267c instanceof Boolean)) {
            return Boolean.valueOf(this.payload.n(str).b());
        }
        throw new JwtInvalidException(a.C("claim ", str, " is not a boolean"));
    }

    public Instant getExpiration() {
        return getInstant("exp");
    }

    public Instant getIssuedAt() {
        return getInstant("iat");
    }

    public String getIssuer() {
        return getStringClaimInternal("iss");
    }

    public String getJsonArrayClaim(String str) throws JwtInvalidException {
        JwtNames.validate(str);
        if (!this.payload.f8266c.containsKey(str)) {
            throw new JwtInvalidException(a.C("claim ", str, " does not exist"));
        }
        g gVarN = this.payload.n(str);
        gVarN.getClass();
        if (gVarN instanceof m7.f) {
            return this.payload.n(str).d().toString();
        }
        throw new JwtInvalidException(a.C("claim ", str, " is not a JSON array"));
    }

    public String getJsonObjectClaim(String str) throws JwtInvalidException {
        JwtNames.validate(str);
        if (!this.payload.f8266c.containsKey(str)) {
            throw new JwtInvalidException(a.C("claim ", str, " does not exist"));
        }
        g gVarN = this.payload.n(str);
        gVarN.getClass();
        if (gVarN instanceof j) {
            return this.payload.n(str).e().toString();
        }
        throw new JwtInvalidException(a.C("claim ", str, " is not a JSON object"));
    }

    public String getJsonPayload() {
        return this.payload.toString();
    }

    public String getJwtId() {
        return getStringClaimInternal("jti");
    }

    public Instant getNotBefore() {
        return getInstant("nbf");
    }

    public Double getNumberClaim(String str) throws JwtInvalidException {
        JwtNames.validate(str);
        if (!this.payload.f8266c.containsKey(str)) {
            throw new JwtInvalidException(a.C("claim ", str, " does not exist"));
        }
        g gVarN = this.payload.n(str);
        gVarN.getClass();
        if ((gVarN instanceof l) && (this.payload.n(str).f().f8267c instanceof Number)) {
            return Double.valueOf(this.payload.n(str).c());
        }
        throw new JwtInvalidException(a.C("claim ", str, " is not a number"));
    }

    public String getStringClaim(String str) {
        JwtNames.validate(str);
        return getStringClaimInternal(str);
    }

    public String getSubject() {
        return getStringClaimInternal("sub");
    }

    public String getTypeHeader() throws JwtInvalidException {
        if (this.typeHeader.isPresent()) {
            return this.typeHeader.get();
        }
        throw new JwtInvalidException("type header is not set");
    }

    public boolean hasAudiences() {
        return this.payload.f8266c.containsKey("aud");
    }

    public boolean hasBooleanClaim(String str) {
        JwtNames.validate(str);
        if (!this.payload.f8266c.containsKey(str)) {
            return false;
        }
        g gVarN = this.payload.n(str);
        gVarN.getClass();
        return (gVarN instanceof l) && (this.payload.n(str).f().f8267c instanceof Boolean);
    }

    public boolean hasExpiration() {
        return this.payload.f8266c.containsKey("exp");
    }

    public boolean hasIssuedAt() {
        return this.payload.f8266c.containsKey("iat");
    }

    public boolean hasIssuer() {
        return this.payload.f8266c.containsKey("iss");
    }

    public boolean hasJsonArrayClaim(String str) {
        JwtNames.validate(str);
        if (!this.payload.f8266c.containsKey(str)) {
            return false;
        }
        g gVarN = this.payload.n(str);
        gVarN.getClass();
        return gVarN instanceof m7.f;
    }

    public boolean hasJsonObjectClaim(String str) {
        JwtNames.validate(str);
        if (!this.payload.f8266c.containsKey(str)) {
            return false;
        }
        g gVarN = this.payload.n(str);
        gVarN.getClass();
        return gVarN instanceof j;
    }

    public boolean hasJwtId() {
        return this.payload.f8266c.containsKey("jti");
    }

    public boolean hasNotBefore() {
        return this.payload.f8266c.containsKey("nbf");
    }

    public boolean hasNumberClaim(String str) {
        JwtNames.validate(str);
        if (!this.payload.f8266c.containsKey(str)) {
            return false;
        }
        g gVarN = this.payload.n(str);
        gVarN.getClass();
        return (gVarN instanceof l) && (this.payload.n(str).f().f8267c instanceof Number);
    }

    public boolean hasStringClaim(String str) {
        JwtNames.validate(str);
        if (!this.payload.f8266c.containsKey(str)) {
            return false;
        }
        g gVarN = this.payload.n(str);
        gVarN.getClass();
        return (gVarN instanceof l) && (this.payload.n(str).f().f8267c instanceof String);
    }

    public boolean hasSubject() {
        return this.payload.f8266c.containsKey("sub");
    }

    public boolean hasTypeHeader() {
        return this.typeHeader.isPresent();
    }

    public boolean isNullClaim(String str) {
        JwtNames.validate(str);
        try {
            return this.payload.n(str) instanceof i;
        } catch (k unused) {
            return false;
        }
    }

    public String toString() {
        j jVar = new j();
        if (this.typeHeader.isPresent()) {
            jVar.j("typ", new l(this.typeHeader.get()));
        }
        return jVar + "." + this.payload;
    }

    private RawJwt(Optional<String> optional, String str) throws JwtInvalidException {
        this.typeHeader = optional;
        this.payload = JsonUtil.parseJson(str);
        validateStringClaim("iss");
        validateStringClaim("sub");
        validateStringClaim("jti");
        validateTimestampClaim("exp");
        validateTimestampClaim("nbf");
        validateTimestampClaim("iat");
        validateAudienceClaim();
    }
}
