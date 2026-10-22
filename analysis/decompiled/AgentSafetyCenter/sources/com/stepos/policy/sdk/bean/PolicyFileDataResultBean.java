package com.stepos.policy.sdk.bean;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class PolicyFileDataResultBean {
    private long version;
    private String policyUid = "";
    private String category = "";
    private String md5 = "";

    public final String getCategory() {
        return this.category;
    }

    public final String getMd5() {
        return this.md5;
    }

    public final String getPolicyUid() {
        return this.policyUid;
    }

    public final long getVersion() {
        return this.version;
    }

    public final void setCategory(String str) {
        str.getClass();
        this.category = str;
    }

    public final void setMd5(String str) {
        str.getClass();
        this.md5 = str;
    }

    public final void setPolicyUid(String str) {
        str.getClass();
        this.policyUid = str;
    }

    public final void setVersion(long j10) {
        this.version = j10;
    }
}
