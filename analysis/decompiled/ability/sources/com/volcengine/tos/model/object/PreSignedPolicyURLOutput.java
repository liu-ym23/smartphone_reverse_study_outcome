package com.volcengine.tos.model.object;

import B7.a;

/* loaded from: classes3.dex */
public class PreSignedPolicyURLOutput {
    private String host;
    private PreSignedPolicyURLGenerator preSignedPolicyURLGenerator;
    private String scheme;
    private String signatureQuery;

    public String getHost() {
        return this.host;
    }

    public PreSignedPolicyURLGenerator getPreSignedPolicyURLGenerator() {
        return this.preSignedPolicyURLGenerator;
    }

    public String getScheme() {
        return this.scheme;
    }

    public String getSignatureQuery() {
        return this.signatureQuery;
    }

    public PreSignedPolicyURLOutput setHost(String str) {
        this.host = str;
        return this;
    }

    public PreSignedPolicyURLOutput setPreSignedPolicyURLGenerator(PreSignedPolicyURLGenerator preSignedPolicyURLGenerator) {
        this.preSignedPolicyURLGenerator = preSignedPolicyURLGenerator;
        return this;
    }

    public PreSignedPolicyURLOutput setScheme(String str) {
        this.scheme = str;
        return this;
    }

    public PreSignedPolicyURLOutput setSignatureQuery(String str) {
        this.signatureQuery = str;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("PreSignedPolicyURLOutput{preSignedPolicyURLGenerator=");
        sb.append(this.preSignedPolicyURLGenerator);
        sb.append(", signatureQuery='");
        sb.append(this.signatureQuery);
        sb.append("', host='");
        sb.append(this.host);
        sb.append("', scheme='");
        return a.q(sb, this.scheme, "'}");
    }
}
