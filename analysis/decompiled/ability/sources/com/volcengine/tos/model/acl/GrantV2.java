package com.volcengine.tos.model.acl;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.volcengine.tos.comm.common.PermissionType;

/* loaded from: classes3.dex */
public class GrantV2 {

    @JsonProperty("Grantee")
    private GranteeV2 grantee;

    @JsonProperty("Permission")
    private PermissionType permission;

    public static final class GrantV2Builder {
        private GranteeV2 grantee;
        private PermissionType permission;

        public GrantV2 build() {
            GrantV2 grantV2 = new GrantV2();
            grantV2.permission = this.permission;
            grantV2.grantee = this.grantee;
            return grantV2;
        }

        public GrantV2Builder grantee(GranteeV2 granteeV2) {
            this.grantee = granteeV2;
            return this;
        }

        public GrantV2Builder permission(PermissionType permissionType) {
            this.permission = permissionType;
            return this;
        }

        private GrantV2Builder() {
        }
    }

    public static GrantV2Builder builder() {
        return new GrantV2Builder();
    }

    public GranteeV2 getGrantee() {
        return this.grantee;
    }

    public PermissionType getPermission() {
        return this.permission;
    }

    public GrantV2 setGrantee(GranteeV2 granteeV2) {
        this.grantee = granteeV2;
        return this;
    }

    public GrantV2 setPermission(PermissionType permissionType) {
        this.permission = permissionType;
        return this;
    }

    public String toString() {
        return "GrantV2{grantee=" + this.grantee + ", permission=" + this.permission + '}';
    }
}
