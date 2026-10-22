package com.volcengine.tos.model.acl;

import B7.a;
import com.fasterxml.jackson.annotation.JsonProperty;

/* loaded from: classes3.dex */
public class Owner {

    @JsonProperty("DisplayName")
    private String displayName;

    @JsonProperty("ID")
    private String id;

    public static final class OwnerBuilder {
        private String displayName;
        private String id;

        public Owner build() {
            Owner owner = new Owner();
            owner.setId(this.id);
            owner.setDisplayName(this.displayName);
            return owner;
        }

        public OwnerBuilder displayName(String str) {
            this.displayName = str;
            return this;
        }

        public OwnerBuilder id(String str) {
            this.id = str;
            return this;
        }

        private OwnerBuilder() {
        }
    }

    public static OwnerBuilder builder() {
        return new OwnerBuilder();
    }

    public String getDisplayName() {
        return this.displayName;
    }

    public String getId() {
        return this.id;
    }

    public Owner setDisplayName(String str) {
        this.displayName = str;
        return this;
    }

    public Owner setId(String str) {
        this.id = str;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Owner{id='");
        sb.append(this.id);
        sb.append("', displayName='");
        return a.q(sb, this.displayName, "'}");
    }
}
