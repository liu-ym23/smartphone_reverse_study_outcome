package com.volcengine.tos.model.acl;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.volcengine.tos.comm.common.CannedType;
import com.volcengine.tos.comm.common.GranteeType;

/* loaded from: classes3.dex */
public class GranteeV2 {

    @JsonProperty("Canned")
    private CannedType canned;

    @JsonProperty("DisplayName")
    private String displayName;

    @JsonProperty("ID")
    private String id;

    @JsonProperty("Type")
    private GranteeType type;

    public static final class GranteeV2Builder {
        private CannedType canned;
        private String displayName;
        private String id;
        private GranteeType type;

        public GranteeV2 build() {
            GranteeV2 granteeV2 = new GranteeV2();
            granteeV2.type = this.type;
            granteeV2.canned = this.canned;
            granteeV2.displayName = this.displayName;
            granteeV2.id = this.id;
            return granteeV2;
        }

        public GranteeV2Builder canned(CannedType cannedType) {
            this.canned = cannedType;
            return this;
        }

        public GranteeV2Builder displayName(String str) {
            this.displayName = str;
            return this;
        }

        public GranteeV2Builder id(String str) {
            this.id = str;
            return this;
        }

        public GranteeV2Builder type(GranteeType granteeType) {
            this.type = granteeType;
            return this;
        }

        private GranteeV2Builder() {
        }
    }

    public static GranteeV2Builder builder() {
        return new GranteeV2Builder();
    }

    public CannedType getCanned() {
        return this.canned;
    }

    public String getDisplayName() {
        return this.displayName;
    }

    public String getId() {
        return this.id;
    }

    public GranteeType getType() {
        return this.type;
    }

    public GranteeV2 setCanned(CannedType cannedType) {
        this.canned = cannedType;
        return this;
    }

    public GranteeV2 setDisplayName(String str) {
        this.displayName = str;
        return this;
    }

    public GranteeV2 setId(String str) {
        this.id = str;
        return this;
    }

    public GranteeV2 setType(GranteeType granteeType) {
        this.type = granteeType;
        return this;
    }

    public String toString() {
        return "GranteeV2{id='" + this.id + "', displayName='" + this.displayName + "', type=" + this.type + ", uri=" + this.canned + '}';
    }
}
