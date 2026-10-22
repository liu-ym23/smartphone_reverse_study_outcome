package com.stepos.policy.sdk.bean;

import j4.k;
import org.libpag.BuildConfig;

/* loaded from: classes.dex */
public final class PolicyNewestPathResultBean {
    private boolean isExists;
    private String newestPolicyPath = BuildConfig.FLAVOR;
    private String newestPolicyName = BuildConfig.FLAVOR;

    public final String getNewestPolicyName() {
        return this.newestPolicyName;
    }

    public final String getNewestPolicyPath() {
        return this.newestPolicyPath;
    }

    public final boolean isExists() {
        return this.isExists;
    }

    public final void setExists(boolean z5) {
        this.isExists = z5;
    }

    public final void setNewestPolicyName(String str) {
        k.g(str, "<set-?>");
        this.newestPolicyName = str;
    }

    public final void setNewestPolicyPath(String str) {
        k.g(str, "<set-?>");
        this.newestPolicyPath = str;
    }
}
