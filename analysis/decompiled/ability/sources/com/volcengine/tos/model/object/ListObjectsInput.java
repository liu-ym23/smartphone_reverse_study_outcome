package com.volcengine.tos.model.object;

import B7.a;

@Deprecated
/* loaded from: classes3.dex */
public class ListObjectsInput {
    private String delimiter;
    private String encodingType;
    private String marker;
    private int maxKeys;
    private String prefix;
    private boolean reverse;

    public String getDelimiter() {
        return this.delimiter;
    }

    public String getEncodingType() {
        return this.encodingType;
    }

    public String getMarker() {
        return this.marker;
    }

    public int getMaxKeys() {
        return this.maxKeys;
    }

    public String getPrefix() {
        return this.prefix;
    }

    public boolean isReverse() {
        return this.reverse;
    }

    public ListObjectsInput setDelimiter(String str) {
        this.delimiter = str;
        return this;
    }

    public ListObjectsInput setEncodingType(String str) {
        this.encodingType = str;
        return this;
    }

    public ListObjectsInput setMarker(String str) {
        this.marker = str;
        return this;
    }

    public ListObjectsInput setMaxKeys(int i) {
        this.maxKeys = i;
        return this;
    }

    public ListObjectsInput setPrefix(String str) {
        this.prefix = str;
        return this;
    }

    public ListObjectsInput setReverse(boolean z10) {
        this.reverse = z10;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("ListObjectsInput{prefix='");
        sb.append(this.prefix);
        sb.append("', delimiter='");
        sb.append(this.delimiter);
        sb.append("', marker='");
        sb.append(this.marker);
        sb.append("', maxKeys=");
        sb.append(this.maxKeys);
        sb.append(", reverse=");
        sb.append(this.reverse);
        sb.append(", encodingType='");
        return a.q(sb, this.encodingType, "'}");
    }
}
