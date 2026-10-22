package com.volcengine.tos.model.bucket;

import B7.a;
import com.fasterxml.jackson.annotation.JsonProperty;

/* loaded from: classes3.dex */
public class NoncurrentVersionExpiration {

    @JsonProperty("NoncurrentDays")
    private int noncurrentDays;

    public static final class NoncurrentVersionExpirationBuilder {
        private int noncurrentDays;

        public NoncurrentVersionExpiration build() {
            NoncurrentVersionExpiration noncurrentVersionExpiration = new NoncurrentVersionExpiration();
            noncurrentVersionExpiration.setNoncurrentDays(this.noncurrentDays);
            return noncurrentVersionExpiration;
        }

        public NoncurrentVersionExpirationBuilder noncurrentDays(int i) {
            this.noncurrentDays = i;
            return this;
        }

        private NoncurrentVersionExpirationBuilder() {
        }
    }

    public static NoncurrentVersionExpirationBuilder builder() {
        return new NoncurrentVersionExpirationBuilder();
    }

    public int getNoncurrentDays() {
        return this.noncurrentDays;
    }

    public NoncurrentVersionExpiration setNoncurrentDays(int i) {
        this.noncurrentDays = i;
        return this;
    }

    public String toString() {
        return a.o(new StringBuilder("NoncurrentVersionExpiration{noncurrentDays="), this.noncurrentDays, '}');
    }
}
