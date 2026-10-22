package com.volcengine.tos.model.object;

import B7.a;

@Deprecated
/* loaded from: classes3.dex */
public class ListObjectVersionsInput {
    private String delimiter;
    private String encodingType;
    private String keyMarker;
    private int maxKeys;
    private String prefix;
    private String versionIDMarker;

    public String getDelimiter() {
        return this.delimiter;
    }

    public String getEncodingType() {
        return this.encodingType;
    }

    public String getKeyMarker() {
        return this.keyMarker;
    }

    public int getMaxKeys() {
        return this.maxKeys;
    }

    public String getPrefix() {
        return this.prefix;
    }

    public String getVersionIDMarker() {
        return this.versionIDMarker;
    }

    public ListObjectVersionsInput setDelimiter(String str) {
        this.delimiter = str;
        return this;
    }

    public ListObjectVersionsInput setEncodingType(String str) {
        this.encodingType = str;
        return this;
    }

    public ListObjectVersionsInput setKeyMarker(String str) {
        this.keyMarker = str;
        return this;
    }

    public ListObjectVersionsInput setMaxKeys(int i) {
        this.maxKeys = i;
        return this;
    }

    public ListObjectVersionsInput setPrefix(String str) {
        this.prefix = str;
        return this;
    }

    public ListObjectVersionsInput setVersionIDMarker(String str) {
        this.versionIDMarker = str;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("ListObjectVersionsInput{prefix='");
        sb.append(this.prefix);
        sb.append("', delimiter='");
        sb.append(this.delimiter);
        sb.append("', keyMarker='");
        sb.append(this.keyMarker);
        sb.append("', versionIDMarker='");
        sb.append(this.versionIDMarker);
        sb.append("', maxKeys=");
        sb.append(this.maxKeys);
        sb.append(", encodingType='");
        return a.q(sb, this.encodingType, "'}");
    }
}
