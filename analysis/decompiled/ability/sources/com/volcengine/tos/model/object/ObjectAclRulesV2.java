package com.volcengine.tos.model.object;

import androidx.appfunctions.metadata.a;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.volcengine.tos.model.acl.GrantV2;
import com.volcengine.tos.model.acl.Owner;
import java.util.List;

/* loaded from: classes3.dex */
public class ObjectAclRulesV2 {

    @JsonProperty("BucketOwnerEntrusted")
    private boolean bucketOwnerEntrusted;

    @JsonProperty("Grants")
    private List<GrantV2> grants;

    @JsonProperty("Owner")
    private Owner owner;

    public static final class ObjectAclRulesV2Builder {
        private boolean bucketOwnerEntrusted;
        private List<GrantV2> grants;
        private Owner owner;

        public ObjectAclRulesV2Builder bucketOwnerEntrusted(boolean z10) {
            this.bucketOwnerEntrusted = z10;
            return this;
        }

        public ObjectAclRulesV2 build() {
            ObjectAclRulesV2 objectAclRulesV2 = new ObjectAclRulesV2();
            objectAclRulesV2.owner = this.owner;
            objectAclRulesV2.grants = this.grants;
            objectAclRulesV2.bucketOwnerEntrusted = this.bucketOwnerEntrusted;
            return objectAclRulesV2;
        }

        public ObjectAclRulesV2Builder grants(List<GrantV2> list) {
            this.grants = list;
            return this;
        }

        public ObjectAclRulesV2Builder owner(Owner owner) {
            this.owner = owner;
            return this;
        }

        private ObjectAclRulesV2Builder() {
        }
    }

    public static ObjectAclRulesV2Builder builder() {
        return new ObjectAclRulesV2Builder();
    }

    public List<GrantV2> getGrants() {
        return this.grants;
    }

    public Owner getOwner() {
        return this.owner;
    }

    public boolean isBucketOwnerEntrusted() {
        return this.bucketOwnerEntrusted;
    }

    public ObjectAclRulesV2 setBucketOwnerEntrusted(boolean z10) {
        this.bucketOwnerEntrusted = z10;
        return this;
    }

    public ObjectAclRulesV2 setGrants(List<GrantV2> list) {
        this.grants = list;
        return this;
    }

    public ObjectAclRulesV2 setOwner(Owner owner) {
        this.owner = owner;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("ObjectAclRulesV2{owner=");
        sb.append(this.owner);
        sb.append(", grants=");
        sb.append(this.grants);
        sb.append(", bucketOwnerEntrusted=");
        return a.r(sb, this.bucketOwnerEntrusted, '}');
    }
}
