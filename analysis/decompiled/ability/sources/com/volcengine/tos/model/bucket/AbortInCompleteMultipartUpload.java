package com.volcengine.tos.model.bucket;

import B7.a;
import com.fasterxml.jackson.annotation.JsonProperty;

/* loaded from: classes3.dex */
public class AbortInCompleteMultipartUpload {

    @JsonProperty("DaysAfterInitiation")
    private int daysAfterInitiation;

    public static final class AbortInCompleteMultipartUploadBuilder {
        private int daysAfterInitiation;

        public AbortInCompleteMultipartUpload build() {
            AbortInCompleteMultipartUpload abortInCompleteMultipartUpload = new AbortInCompleteMultipartUpload();
            abortInCompleteMultipartUpload.setDaysAfterInitiation(this.daysAfterInitiation);
            return abortInCompleteMultipartUpload;
        }

        public AbortInCompleteMultipartUploadBuilder daysAfterInitiation(int i) {
            this.daysAfterInitiation = i;
            return this;
        }

        private AbortInCompleteMultipartUploadBuilder() {
        }
    }

    public static AbortInCompleteMultipartUploadBuilder builder() {
        return new AbortInCompleteMultipartUploadBuilder();
    }

    public int getDaysAfterInitiation() {
        return this.daysAfterInitiation;
    }

    public AbortInCompleteMultipartUpload setDaysAfterInitiation(int i) {
        this.daysAfterInitiation = i;
        return this;
    }

    public String toString() {
        return a.o(new StringBuilder("AbortInCompleteMultipartUpload{daysAfterInitiation="), this.daysAfterInitiation, '}');
    }
}
