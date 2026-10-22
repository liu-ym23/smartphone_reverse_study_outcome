package com.volcengine.tos.model.bucket;

import B7.a;
import Y6.d;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.util.Date;

/* loaded from: classes3.dex */
public class Expiration {

    @JsonProperty("Date")
    @JsonSerialize(using = d.class)
    private Date date;

    @JsonProperty("Days")
    private int days;

    public static final class ExpirationBuilder {
        private Date date;
        private int days;

        public Expiration build() {
            Expiration expiration = new Expiration();
            expiration.setDate(this.date);
            expiration.setDays(this.days);
            return expiration;
        }

        public ExpirationBuilder date(Date date) {
            this.date = date;
            return this;
        }

        public ExpirationBuilder days(int i) {
            this.days = i;
            return this;
        }

        private ExpirationBuilder() {
        }
    }

    public static ExpirationBuilder builder() {
        return new ExpirationBuilder();
    }

    public Date getDate() {
        return this.date;
    }

    public int getDays() {
        return this.days;
    }

    public Expiration setDate(Date date) {
        this.date = date;
        return this;
    }

    public Expiration setDays(int i) {
        this.days = i;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Expiration{date=");
        sb.append(this.date);
        sb.append(", days=");
        return a.o(sb, this.days, '}');
    }
}
