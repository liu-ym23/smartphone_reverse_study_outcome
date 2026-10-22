package com.stepos.policy.sdk.bean;

import kotlin.jvm.internal.g;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class PolicyNewestPathResultBean {
    private boolean isExists;
    private String newestPolicyPath = "";
    private String newestPolicyName = "";

    public final String getNewestPolicyName() {
        return this.newestPolicyName;
    }

    public final String getNewestPolicyPath() {
        return this.newestPolicyPath;
    }

    public final boolean isExists() {
        return this.isExists;
    }

    public final void setExists(boolean z) {
        this.isExists = z;
    }

    public final void setNewestPolicyName(String str) {
        g.f(str, "<set-?>");
        this.newestPolicyName = str;
    }

    public final void setNewestPolicyPath(String str) {
        g.f(str, "<set-?>");
        this.newestPolicyPath = str;
    }
}
