package com.volcengine.tos.model.object;

import java.util.Map;

/* loaded from: classes3.dex */
public class PreSignedURLOutput {
    private Map<String, String> signedHeader;
    private String signedUrl;

    public PreSignedURLOutput(String str, Map<String, String> map) {
        this.signedUrl = str;
        this.signedHeader = map;
    }

    public Map<String, String> getSignedHeader() {
        return this.signedHeader;
    }

    public String getSignedUrl() {
        return this.signedUrl;
    }

    public PreSignedURLOutput setSignedHeader(Map<String, String> map) {
        this.signedHeader = map;
        return this;
    }

    public PreSignedURLOutput setSignedUrl(String str) {
        this.signedUrl = str;
        return this;
    }

    public String toString() {
        return "PreSignedURLOutput{signedUrl='" + this.signedUrl + "', signedHeader=" + this.signedHeader + '}';
    }
}
