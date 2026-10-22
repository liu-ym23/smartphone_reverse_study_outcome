package com.volcengine.tos.model.acl;

import com.fasterxml.jackson.annotation.JsonProperty;

@Deprecated
/* loaded from: classes3.dex */
public class PutObjectAclInput {

    @JsonProperty("AclGrant")
    private ObjectAclGrant aclGrant;

    @JsonProperty("AclRules")
    private ObjectAclRules aclRules;

    @JsonProperty("Key")
    private String key;

    @JsonProperty("VersionId")
    private String versionId;

    public ObjectAclGrant getAclGrant() {
        return this.aclGrant;
    }

    public ObjectAclRules getAclRules() {
        return this.aclRules;
    }

    public String getKey() {
        return this.key;
    }

    public String getVersionId() {
        return this.versionId;
    }

    public PutObjectAclInput setAclGrant(ObjectAclGrant objectAclGrant) {
        this.aclGrant = objectAclGrant;
        return this;
    }

    public PutObjectAclInput setAclRules(ObjectAclRules objectAclRules) {
        this.aclRules = objectAclRules;
        return this;
    }

    public PutObjectAclInput setKey(String str) {
        this.key = str;
        return this;
    }

    public PutObjectAclInput setVersionId(String str) {
        this.versionId = str;
        return this;
    }

    public String toString() {
        return "PutObjectAclInput{key='" + this.key + "', versionId='" + this.versionId + "', aclGrant=" + this.aclGrant + ", aclRules=" + this.aclRules + '}';
    }
}
