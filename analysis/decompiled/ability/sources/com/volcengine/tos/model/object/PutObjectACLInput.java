package com.volcengine.tos.model.object;

import com.volcengine.tos.comm.common.ACLType;
import com.volcengine.tos.model.acl.GrantV2;
import com.volcengine.tos.model.acl.Owner;
import java.util.List;

/* loaded from: classes3.dex */
public class PutObjectACLInput {
    private ACLType acl;
    private String bucket;
    private String grantFullControl;
    private String grantRead;
    private String grantReadAcp;
    private String grantWriteAcp;
    private String key;
    private ObjectAclRulesV2 objectAclRules;
    private String versionID;

    public static final class PutObjectACLInputBuilder {
        private ACLType acl;
        private String bucket;
        private boolean bucketOwnerEntrusted;
        private String grantFullControl;
        private String grantRead;
        private String grantReadAcp;
        private String grantWriteAcp;
        private List<GrantV2> grants;
        private String key;
        private Owner owner;
        private String versionID;

        public PutObjectACLInputBuilder acl(ACLType aCLType) {
            this.acl = aCLType;
            return this;
        }

        public PutObjectACLInputBuilder bucket(String str) {
            this.bucket = str;
            return this;
        }

        public PutObjectACLInputBuilder bucketOwnerEntrusted(boolean z10) {
            this.bucketOwnerEntrusted = z10;
            return this;
        }

        public PutObjectACLInput build() {
            PutObjectACLInput putObjectACLInput = new PutObjectACLInput();
            putObjectACLInput.key = this.key;
            putObjectACLInput.grantReadAcp = this.grantReadAcp;
            putObjectACLInput.grantWriteAcp = this.grantWriteAcp;
            putObjectACLInput.bucket = this.bucket;
            putObjectACLInput.acl = this.acl;
            putObjectACLInput.grantRead = this.grantRead;
            putObjectACLInput.grantFullControl = this.grantFullControl;
            putObjectACLInput.versionID = this.versionID;
            putObjectACLInput.objectAclRules = new ObjectAclRulesV2().setOwner(this.owner).setGrants(this.grants).setBucketOwnerEntrusted(this.bucketOwnerEntrusted);
            return putObjectACLInput;
        }

        public PutObjectACLInputBuilder grantFullControl(String str) {
            this.grantFullControl = str;
            return this;
        }

        public PutObjectACLInputBuilder grantRead(String str) {
            this.grantRead = str;
            return this;
        }

        public PutObjectACLInputBuilder grantReadAcp(String str) {
            this.grantReadAcp = str;
            return this;
        }

        public PutObjectACLInputBuilder grantWriteAcp(String str) {
            this.grantWriteAcp = str;
            return this;
        }

        public PutObjectACLInputBuilder grants(List<GrantV2> list) {
            this.grants = list;
            return this;
        }

        public PutObjectACLInputBuilder key(String str) {
            this.key = str;
            return this;
        }

        public PutObjectACLInputBuilder owner(Owner owner) {
            this.owner = owner;
            return this;
        }

        public PutObjectACLInputBuilder versionID(String str) {
            this.versionID = str;
            return this;
        }

        private PutObjectACLInputBuilder() {
        }
    }

    public static PutObjectACLInputBuilder builder() {
        return new PutObjectACLInputBuilder();
    }

    public ACLType getAcl() {
        return this.acl;
    }

    public String getBucket() {
        return this.bucket;
    }

    public String getGrantFullControl() {
        return this.grantFullControl;
    }

    public String getGrantRead() {
        return this.grantRead;
    }

    public String getGrantReadAcp() {
        return this.grantReadAcp;
    }

    public String getGrantWriteAcp() {
        return this.grantWriteAcp;
    }

    public List<GrantV2> getGrants() {
        ObjectAclRulesV2 objectAclRulesV2 = this.objectAclRules;
        if (objectAclRulesV2 != null) {
            return objectAclRulesV2.getGrants();
        }
        return null;
    }

    public String getKey() {
        return this.key;
    }

    public ObjectAclRulesV2 getObjectAclRules() {
        return this.objectAclRules;
    }

    public Owner getOwner() {
        ObjectAclRulesV2 objectAclRulesV2 = this.objectAclRules;
        if (objectAclRulesV2 != null) {
            return objectAclRulesV2.getOwner();
        }
        return null;
    }

    public String getVersionID() {
        return this.versionID;
    }

    public boolean isBucketOwnerEntrusted() {
        ObjectAclRulesV2 objectAclRulesV2 = this.objectAclRules;
        return objectAclRulesV2 != null && objectAclRulesV2.isBucketOwnerEntrusted();
    }

    public PutObjectACLInput setAcl(ACLType aCLType) {
        this.acl = aCLType;
        return this;
    }

    public PutObjectACLInput setBucket(String str) {
        this.bucket = str;
        return this;
    }

    public PutObjectACLInput setBucketOwnerEntrusted(boolean z10) {
        if (this.objectAclRules == null) {
            this.objectAclRules = new ObjectAclRulesV2();
        }
        this.objectAclRules.setBucketOwnerEntrusted(z10);
        return this;
    }

    public PutObjectACLInput setGrantFullControl(String str) {
        this.grantFullControl = str;
        return this;
    }

    public PutObjectACLInput setGrantRead(String str) {
        this.grantRead = str;
        return this;
    }

    public PutObjectACLInput setGrantReadAcp(String str) {
        this.grantReadAcp = str;
        return this;
    }

    public PutObjectACLInput setGrantWriteAcp(String str) {
        this.grantWriteAcp = str;
        return this;
    }

    public PutObjectACLInput setGrants(List<GrantV2> list) {
        if (this.objectAclRules == null) {
            this.objectAclRules = new ObjectAclRulesV2();
        }
        this.objectAclRules.setGrants(list);
        return this;
    }

    public PutObjectACLInput setKey(String str) {
        this.key = str;
        return this;
    }

    public PutObjectACLInput setObjectAclRules(ObjectAclRulesV2 objectAclRulesV2) {
        this.objectAclRules = objectAclRulesV2;
        return this;
    }

    public PutObjectACLInput setOwner(Owner owner) {
        if (this.objectAclRules == null) {
            this.objectAclRules = new ObjectAclRulesV2();
        }
        this.objectAclRules.setOwner(owner);
        return this;
    }

    public PutObjectACLInput setVersionID(String str) {
        this.versionID = str;
        return this;
    }

    public String toString() {
        return "PutObjectACLInput{bucket='" + this.bucket + "', key='" + this.key + "', versionID='" + this.versionID + "', acl=" + this.acl + ", grantFullControl='" + this.grantFullControl + "', grantRead='" + this.grantRead + "', grantReadAcp='" + this.grantReadAcp + "', grantWriteAcp='" + this.grantWriteAcp + "', objectAclRules=" + this.objectAclRules + '}';
    }
}
