package com.stepos.policy.sdk.bean;

import kotlin.jvm.internal.g;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
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
        g.f(str, "<set-?>");
        this.category = str;
    }

    public final void setMd5(String str) {
        g.f(str, "<set-?>");
        this.md5 = str;
    }

    public final void setPolicyUid(String str) {
        g.f(str, "<set-?>");
        this.policyUid = str;
    }

    public final void setVersion(long j10) {
        this.version = j10;
    }
}
