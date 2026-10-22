package com.volcengine.tos.model.object;

import B7.a;
import com.fasterxml.jackson.annotation.JsonProperty;

@Deprecated
/* loaded from: classes3.dex */
public class UploadedPart {

    @JsonProperty("ETag")
    private String etag;

    @JsonProperty("LastModified")
    private String lastModified;

    @JsonProperty("PartNumber")
    private int partNumber;

    @JsonProperty("Size")
    private long size;

    public String getEtag() {
        return this.etag;
    }

    public String getLastModified() {
        return this.lastModified;
    }

    public int getPartNumber() {
        return this.partNumber;
    }

    public long getSize() {
        return this.size;
    }

    public UploadedPart setEtag(String str) {
        this.etag = str;
        return this;
    }

    public UploadedPart setLastModified(String str) {
        this.lastModified = str;
        return this;
    }

    public UploadedPart setPartNumber(int i) {
        this.partNumber = i;
        return this;
    }

    public UploadedPart setSize(long j5) {
        this.size = j5;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("UploadedPart{partNumber=");
        sb.append(this.partNumber);
        sb.append(", lastModified='");
        sb.append(this.lastModified);
        sb.append("', etag='");
        sb.append(this.etag);
        sb.append("', size=");
        return a.p(sb, this.size, '}');
    }
}
