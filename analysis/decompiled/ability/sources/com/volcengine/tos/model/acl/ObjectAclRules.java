package com.volcengine.tos.model.acl;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Arrays;

@Deprecated
/* loaded from: classes3.dex */
public class ObjectAclRules {

    @JsonProperty("Grants")
    private Grant[] grants;

    @JsonProperty("Owner")
    private Owner owner;

    public Grant[] getGrants() {
        return this.grants;
    }

    public Owner getOwner() {
        return this.owner;
    }

    public ObjectAclRules setGrants(Grant[] grantArr) {
        this.grants = grantArr;
        return this;
    }

    public ObjectAclRules setOwner(Owner owner) {
        this.owner = owner;
        return this;
    }

    public String toString() {
        return "ObjectAclRules{owner=" + this.owner + ", grants=" + Arrays.toString(this.grants) + '}';
    }
}
