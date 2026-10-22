package com.volcengine.tos.model.acl;

import B7.a;
import com.fasterxml.jackson.annotation.JsonProperty;

@Deprecated
/* loaded from: classes3.dex */
public class Grant {

    @JsonProperty("Grantee")
    private Grantee grantee;

    @JsonProperty("Permission")
    private String permission;

    public Grantee getGrantee() {
        return this.grantee;
    }

    public String getPermission() {
        return this.permission;
    }

    public Grant setGrantee(Grantee grantee) {
        this.grantee = grantee;
        return this;
    }

    public Grant setPermission(String str) {
        this.permission = str;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Grant{grantee=");
        sb.append(this.grantee);
        sb.append(", permission='");
        return a.q(sb, this.permission, "'}");
    }
}
