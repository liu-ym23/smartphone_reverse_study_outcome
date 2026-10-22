package com.volcengine.tos.model.object;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

/* loaded from: classes3.dex */
public class RestoreObjectInput {

    @JsonIgnore
    private String bucket;

    @JsonProperty("Days")
    private int days;

    @JsonIgnore
    private String key;

    @JsonProperty("RestoreJobParameters")
    private RestoreJobParameters restoreJobParameters;

    @JsonIgnore
    private String versionID;

    public static final class RestoreObjectInputBuilder {
        private String bucket;
        private int days;
        private String key;
        private RestoreJobParameters restoreJobParameters;
        private String versionID;

        public RestoreObjectInputBuilder bucket(String str) {
            this.bucket = str;
            return this;
        }

        public RestoreObjectInput build() {
            RestoreObjectInput restoreObjectInput = new RestoreObjectInput();
            restoreObjectInput.setBucket(this.bucket);
            restoreObjectInput.setKey(this.key);
            restoreObjectInput.setVersionID(this.versionID);
            restoreObjectInput.setDays(this.days);
            restoreObjectInput.setRestoreJobParameters(this.restoreJobParameters);
            return restoreObjectInput;
        }

        public RestoreObjectInputBuilder days(int i) {
            this.days = i;
            return this;
        }

        public RestoreObjectInputBuilder key(String str) {
            this.key = str;
            return this;
        }

        public RestoreObjectInputBuilder restoreJobParameters(RestoreJobParameters restoreJobParameters) {
            this.restoreJobParameters = restoreJobParameters;
            return this;
        }

        public RestoreObjectInputBuilder versionID(String str) {
            this.versionID = str;
            return this;
        }

        private RestoreObjectInputBuilder() {
        }
    }

    public static RestoreObjectInputBuilder builder() {
        return new RestoreObjectInputBuilder();
    }

    public String getBucket() {
        return this.bucket;
    }

    public int getDays() {
        return this.days;
    }

    public String getKey() {
        return this.key;
    }

    public RestoreJobParameters getRestoreJobParameters() {
        return this.restoreJobParameters;
    }

    public String getVersionID() {
        return this.versionID;
    }

    public RestoreObjectInput setBucket(String str) {
        this.bucket = str;
        return this;
    }

    public RestoreObjectInput setDays(int i) {
        this.days = i;
        return this;
    }

    public RestoreObjectInput setKey(String str) {
        this.key = str;
        return this;
    }

    public RestoreObjectInput setRestoreJobParameters(RestoreJobParameters restoreJobParameters) {
        this.restoreJobParameters = restoreJobParameters;
        return this;
    }

    public RestoreObjectInput setVersionID(String str) {
        this.versionID = str;
        return this;
    }

    public String toString() {
        return "RestoreObjectInput{bucket='" + this.bucket + "', key='" + this.key + "', versionID='" + this.versionID + "', days=" + this.days + ", restoreJobParameters=" + this.restoreJobParameters + '}';
    }
}
