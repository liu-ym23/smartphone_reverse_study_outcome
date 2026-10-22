package com.stepos.policy.sdk.bean;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
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

    public final void setExists(boolean z10) {
        this.isExists = z10;
    }

    public final void setNewestPolicyName(String str) {
        str.getClass();
        this.newestPolicyName = str;
    }

    public final void setNewestPolicyPath(String str) {
        str.getClass();
        this.newestPolicyPath = str;
    }
}
