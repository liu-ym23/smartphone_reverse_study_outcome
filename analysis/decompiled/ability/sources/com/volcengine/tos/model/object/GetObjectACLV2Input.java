package com.volcengine.tos.model.object;

import B7.a;

/* loaded from: classes3.dex */
public class GetObjectACLV2Input {
    private String bucket;
    private String key;
    private String versionID;

    public static final class GetObjectACLInputV2Builder {
        private String bucket;
        private String key;
        private String versionID;

        public GetObjectACLInputV2Builder bucket(String str) {
            this.bucket = str;
            return this;
        }

        public GetObjectACLV2Input build() {
            GetObjectACLV2Input getObjectACLV2Input = new GetObjectACLV2Input();
            getObjectACLV2Input.versionID = this.versionID;
            getObjectACLV2Input.key = this.key;
            getObjectACLV2Input.bucket = this.bucket;
            return getObjectACLV2Input;
        }

        public GetObjectACLInputV2Builder key(String str) {
            this.key = str;
            return this;
        }

        public GetObjectACLInputV2Builder versionID(String str) {
            this.versionID = str;
            return this;
        }

        private GetObjectACLInputV2Builder() {
        }
    }

    public static GetObjectACLInputV2Builder builder() {
        return new GetObjectACLInputV2Builder();
    }

    public String getBucket() {
        return this.bucket;
    }

    public String getKey() {
        return this.key;
    }

    public String getVersionID() {
        return this.versionID;
    }

    public GetObjectACLV2Input setBucket(String str) {
        this.bucket = str;
        return this;
    }

    public GetObjectACLV2Input setKey(String str) {
        this.key = str;
        return this;
    }

    public GetObjectACLV2Input setVersionID(String str) {
        this.versionID = str;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("GetObjectACLInputV2{bucket='");
        sb.append(this.bucket);
        sb.append("', key='");
        sb.append(this.key);
        sb.append("', versionID='");
        return a.q(sb, this.versionID, "'}");
    }
}
