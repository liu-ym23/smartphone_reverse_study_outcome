package com.stepos.policy.sdk.bean;

import j4.k;
import org.libpag.BuildConfig;

/* loaded from: classes.dex */
public final class PolicyFileDataResultBean {
    private long version;
    private String policyUid = BuildConfig.FLAVOR;
    private String category = BuildConfig.FLAVOR;
    private String md5 = BuildConfig.FLAVOR;

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
        k.g(str, "<set-?>");
        this.category = str;
    }

    public final void setMd5(String str) {
        k.g(str, "<set-?>");
        this.md5 = str;
    }

    public final void setPolicyUid(String str) {
        k.g(str, "<set-?>");
        this.policyUid = str;
    }

    public final void setVersion(long j5) {
        this.version = j5;
    }
}
