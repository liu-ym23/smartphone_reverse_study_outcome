package com.volcengine.tos.model.object;

import B7.a;
import com.fasterxml.jackson.annotation.JsonProperty;

/* loaded from: classes3.dex */
public class ObjectTobeDeleted {

    @JsonProperty("Key")
    private String key;

    @JsonProperty("VersionId")
    private String versionID;

    public static final class ObjectTobeDeletedBuilder {
        private String key;
        private String versionID;

        public ObjectTobeDeleted build() {
            ObjectTobeDeleted objectTobeDeleted = new ObjectTobeDeleted();
            objectTobeDeleted.key = this.key;
            objectTobeDeleted.versionID = this.versionID;
            return objectTobeDeleted;
        }

        public ObjectTobeDeletedBuilder key(String str) {
            this.key = str;
            return this;
        }

        public ObjectTobeDeletedBuilder versionID(String str) {
            this.versionID = str;
            return this;
        }

        private ObjectTobeDeletedBuilder() {
        }
    }

    public static ObjectTobeDeletedBuilder builder() {
        return new ObjectTobeDeletedBuilder();
    }

    public String getKey() {
        return this.key;
    }

    public String getVersionID() {
        return this.versionID;
    }

    public ObjectTobeDeleted setKey(String str) {
        this.key = str;
        return this;
    }

    public ObjectTobeDeleted setVersionID(String str) {
        this.versionID = str;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("ObjectTobeDeleted{key='");
        sb.append(this.key);
        sb.append("', versionID='");
        return a.q(sb, this.versionID, "'}");
    }
}
