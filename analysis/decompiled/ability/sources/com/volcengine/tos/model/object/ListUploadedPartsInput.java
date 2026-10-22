package com.volcengine.tos.model.object;

import B7.a;

@Deprecated
/* loaded from: classes3.dex */
public class ListUploadedPartsInput {
    private String key;
    private int maxParts;
    private int partNumberMarker;
    private String uploadID;

    public String getKey() {
        return this.key;
    }

    public int getMaxParts() {
        return this.maxParts;
    }

    public int getPartNumberMarker() {
        return this.partNumberMarker;
    }

    public String getUploadID() {
        return this.uploadID;
    }

    public ListUploadedPartsInput setKey(String str) {
        this.key = str;
        return this;
    }

    public ListUploadedPartsInput setMaxParts(int i) {
        this.maxParts = i;
        return this;
    }

    public ListUploadedPartsInput setPartNumberMarker(int i) {
        this.partNumberMarker = i;
        return this;
    }

    public ListUploadedPartsInput setUploadID(String str) {
        this.uploadID = str;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("ListUploadedPartsInput{key='");
        sb.append(this.key);
        sb.append("', uploadID='");
        sb.append(this.uploadID);
        sb.append("', maxParts=");
        sb.append(this.maxParts);
        sb.append(", partNumberMarker=");
        return a.o(sb, this.partNumberMarker, '}');
    }
}
