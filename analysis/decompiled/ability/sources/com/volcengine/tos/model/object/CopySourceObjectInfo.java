package com.volcengine.tos.model.object;

import B7.a;
import java.util.Date;
import java.util.Objects;

/* loaded from: classes3.dex */
public class CopySourceObjectInfo {
    private String etag;
    private String hashCrc64ecma;
    private Date lastModified;
    private long objectSize;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            CopySourceObjectInfo copySourceObjectInfo = (CopySourceObjectInfo) obj;
            if (this.objectSize == copySourceObjectInfo.objectSize && this.etag.equals(copySourceObjectInfo.etag) && Objects.equals(this.hashCrc64ecma, copySourceObjectInfo.hashCrc64ecma) && this.lastModified.equals(copySourceObjectInfo.lastModified)) {
                return true;
            }
        }
        return false;
    }

    public String getEtag() {
        return this.etag;
    }

    public String getHashCrc64ecma() {
        return this.hashCrc64ecma;
    }

    public Date getLastModified() {
        return this.lastModified;
    }

    public long getObjectSize() {
        return this.objectSize;
    }

    public int hashCode() {
        return Objects.hash(this.etag, this.hashCrc64ecma, this.lastModified, Long.valueOf(this.objectSize));
    }

    public CopySourceObjectInfo setEtag(String str) {
        this.etag = str;
        return this;
    }

    public CopySourceObjectInfo setHashCrc64ecma(String str) {
        this.hashCrc64ecma = str;
        return this;
    }

    public CopySourceObjectInfo setLastModified(Date date) {
        this.lastModified = date;
        return this;
    }

    public CopySourceObjectInfo setObjectSize(long j5) {
        this.objectSize = j5;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("CopySourceObjectInfo{etag='");
        sb.append(this.etag);
        sb.append("', hashCrc64ecma='");
        sb.append(this.hashCrc64ecma);
        sb.append("', lastModified=");
        sb.append(this.lastModified);
        sb.append(", objectSize=");
        return a.p(sb, this.objectSize, '}');
    }
}
