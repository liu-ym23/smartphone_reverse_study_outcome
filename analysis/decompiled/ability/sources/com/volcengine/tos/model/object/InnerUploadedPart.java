package com.volcengine.tos.model.object;

import B7.a;
import com.fasterxml.jackson.annotation.JsonProperty;

@Deprecated
/* loaded from: classes3.dex */
public class InnerUploadedPart implements Comparable<InnerUploadedPart> {

    @JsonProperty("ETag")
    String etag;

    @JsonProperty("PartNumber")
    int partNumber;

    public InnerUploadedPart(int i, String str) {
        this.partNumber = i;
        this.etag = str;
    }

    public String getEtag() {
        return this.etag;
    }

    public int getPartNumber() {
        return this.partNumber;
    }

    public InnerUploadedPart setEtag(String str) {
        this.etag = str;
        return this;
    }

    public InnerUploadedPart setPartNumber(int i) {
        this.partNumber = i;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        sb.append(this.partNumber);
        sb.append(" ");
        return a.q(sb, this.etag, "}");
    }

    @Override // java.lang.Comparable
    public int compareTo(InnerUploadedPart innerUploadedPart) {
        return this.partNumber - innerUploadedPart.partNumber;
    }
}
