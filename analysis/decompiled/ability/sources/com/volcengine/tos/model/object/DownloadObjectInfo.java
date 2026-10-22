package com.volcengine.tos.model.object;

import java.util.Date;

/* loaded from: classes3.dex */
public class DownloadObjectInfo {
    private String etag;
    private String hashCrc64ecma;
    private Date lastModified;
    private long objectSize;

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

    public DownloadObjectInfo setEtag(String str) {
        this.etag = str;
        return this;
    }

    public DownloadObjectInfo setHashCrc64ecma(String str) {
        this.hashCrc64ecma = str;
        return this;
    }

    public DownloadObjectInfo setLastModified(Date date) {
        this.lastModified = date;
        return this;
    }

    public DownloadObjectInfo setObjectSize(long j5) {
        this.objectSize = j5;
        return this;
    }

    public String toString() {
        return "DownloadObjectInfo{etag='" + this.etag + "', objectSize=" + this.objectSize + ", hashCrc64ecma='" + this.hashCrc64ecma + "', lastModified=" + this.lastModified + '}';
    }
}
