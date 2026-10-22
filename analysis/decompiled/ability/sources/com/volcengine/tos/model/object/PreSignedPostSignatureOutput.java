package com.volcengine.tos.model.object;

import B7.a;

/* loaded from: classes3.dex */
public class PreSignedPostSignatureOutput {
    private String algorithm;
    private String credential;
    private String date;
    private String originPolicy;
    private String policy;
    private String signature;

    public String getAlgorithm() {
        return this.algorithm;
    }

    public String getCredential() {
        return this.credential;
    }

    public String getDate() {
        return this.date;
    }

    public String getOriginPolicy() {
        return this.originPolicy;
    }

    public String getPolicy() {
        return this.policy;
    }

    public String getSignature() {
        return this.signature;
    }

    public PreSignedPostSignatureOutput setAlgorithm(String str) {
        this.algorithm = str;
        return this;
    }

    public PreSignedPostSignatureOutput setCredential(String str) {
        this.credential = str;
        return this;
    }

    public PreSignedPostSignatureOutput setDate(String str) {
        this.date = str;
        return this;
    }

    public PreSignedPostSignatureOutput setOriginPolicy(String str) {
        this.originPolicy = str;
        return this;
    }

    public PreSignedPostSignatureOutput setPolicy(String str) {
        this.policy = str;
        return this;
    }

    public PreSignedPostSignatureOutput setSignature(String str) {
        this.signature = str;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("PreSignedPostSignatureOutput{originPolicy='");
        sb.append(this.originPolicy);
        sb.append("', policy='");
        sb.append(this.policy);
        sb.append("', algorithm='");
        sb.append(this.algorithm);
        sb.append("', credential='");
        sb.append(this.credential);
        sb.append("', date='");
        sb.append(this.date);
        sb.append("', signature='");
        return a.q(sb, this.signature, "'}");
    }
}
