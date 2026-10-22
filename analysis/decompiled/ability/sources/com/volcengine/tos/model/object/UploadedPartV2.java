package com.volcengine.tos.model.object;

import B7.a;
import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Date;

/* loaded from: classes3.dex */
public class UploadedPartV2 {

    @JsonProperty("ETag")
    private String etag;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @JsonAlias({"LastModified"})
    private Date lastModified;

    @JsonProperty("PartNumber")
    private int partNumber;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @JsonAlias({"Size"})
    private long size;

    public static final class UploadedPartV2Builder {
        private String etag;
        private Date lastModified;
        private int partNumber;
        private long size;

        public UploadedPartV2 build() {
            UploadedPartV2 uploadedPartV2 = new UploadedPartV2();
            uploadedPartV2.setPartNumber(this.partNumber);
            uploadedPartV2.setEtag(this.etag);
            uploadedPartV2.setLastModified(this.lastModified);
            uploadedPartV2.setSize(this.size);
            return uploadedPartV2;
        }

        public UploadedPartV2Builder etag(String str) {
            this.etag = str;
            return this;
        }

        public UploadedPartV2Builder lastModified(Date date) {
            this.lastModified = date;
            return this;
        }

        public UploadedPartV2Builder partNumber(int i) {
            this.partNumber = i;
            return this;
        }

        public UploadedPartV2Builder size(long j5) {
            this.size = j5;
            return this;
        }

        private UploadedPartV2Builder() {
        }
    }

    public static UploadedPartV2Builder builder() {
        return new UploadedPartV2Builder();
    }

    public String getEtag() {
        return this.etag;
    }

    public Date getLastModified() {
        return this.lastModified;
    }

    public int getPartNumber() {
        return this.partNumber;
    }

    public long getSize() {
        return this.size;
    }

    public UploadedPartV2 setEtag(String str) {
        this.etag = str;
        return this;
    }

    public UploadedPartV2 setLastModified(Date date) {
        this.lastModified = date;
        return this;
    }

    public UploadedPartV2 setPartNumber(int i) {
        this.partNumber = i;
        return this;
    }

    public UploadedPartV2 setSize(long j5) {
        this.size = j5;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("UploadedPartV2{partNumber=");
        sb.append(this.partNumber);
        sb.append(", etag='");
        sb.append(this.etag);
        sb.append("', lastModified=");
        sb.append(this.lastModified);
        sb.append(", size=");
        return a.p(sb, this.size, '}');
    }
}
