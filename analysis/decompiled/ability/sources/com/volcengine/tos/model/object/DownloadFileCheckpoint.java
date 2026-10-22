package com.volcengine.tos.model.object;

import B7.a;
import a.AbstractC0291a;
import a7.f;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.volcengine.tos.TosClientException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.List;

/* loaded from: classes3.dex */
public class DownloadFileCheckpoint {
    private String bucket;
    private DownloadFileInfo downloadFileInfo;
    private DownloadObjectInfo downloadObjectInfo;
    private List<DownloadPartInfo> downloadPartInfos;
    private String ifMatch;
    private Date ifModifiedSince;
    private String ifNoneMatch;
    private Date ifUnModifiedSince;
    private String key;
    private long partSize;
    private String ssecAlgorithm;
    private String ssecKeyMD5;
    private String versionID;

    public String getBucket() {
        return this.bucket;
    }

    public DownloadFileInfo getDownloadFileInfo() {
        return this.downloadFileInfo;
    }

    public DownloadObjectInfo getDownloadObjectInfo() {
        return this.downloadObjectInfo;
    }

    public List<DownloadPartInfo> getDownloadPartInfos() {
        return this.downloadPartInfos;
    }

    public String getIfMatch() {
        return this.ifMatch;
    }

    public Date getIfModifiedSince() {
        return this.ifModifiedSince;
    }

    public String getIfNoneMatch() {
        return this.ifNoneMatch;
    }

    public Date getIfUnModifiedSince() {
        return this.ifUnModifiedSince;
    }

    public String getKey() {
        return this.key;
    }

    public long getPartSize() {
        return this.partSize;
    }

    public String getSsecAlgorithm() {
        return this.ssecAlgorithm;
    }

    public String getSsecKeyMD5() {
        return this.ssecKeyMD5;
    }

    public String getVersionID() {
        return this.versionID;
    }

    public boolean isValid(String str, String str2, String str3, String str4) {
        if (!AbstractC0291a.s(this.bucket, str) || !AbstractC0291a.s(this.key, str2)) {
            return false;
        }
        DownloadFileInfo downloadFileInfo = this.downloadFileInfo;
        if (downloadFileInfo != null && !AbstractC0291a.s(downloadFileInfo.getFilePath(), str3)) {
            return false;
        }
        DownloadObjectInfo downloadObjectInfo = this.downloadObjectInfo;
        return downloadObjectInfo == null || AbstractC0291a.s(downloadObjectInfo.getEtag(), str4);
    }

    public DownloadFileCheckpoint setBucket(String str) {
        this.bucket = str;
        return this;
    }

    public DownloadFileCheckpoint setDownloadFileInfo(DownloadFileInfo downloadFileInfo) {
        this.downloadFileInfo = downloadFileInfo;
        return this;
    }

    public DownloadFileCheckpoint setDownloadObjectInfo(DownloadObjectInfo downloadObjectInfo) {
        this.downloadObjectInfo = downloadObjectInfo;
        return this;
    }

    public DownloadFileCheckpoint setDownloadPartInfos(List<DownloadPartInfo> list) {
        this.downloadPartInfos = list;
        return this;
    }

    public DownloadFileCheckpoint setIfMatch(String str) {
        this.ifMatch = str;
        return this;
    }

    public DownloadFileCheckpoint setIfModifiedSince(Date date) {
        this.ifModifiedSince = date;
        return this;
    }

    public DownloadFileCheckpoint setIfNoneMatch(String str) {
        this.ifNoneMatch = str;
        return this;
    }

    public DownloadFileCheckpoint setIfUnModifiedSince(Date date) {
        this.ifUnModifiedSince = date;
        return this;
    }

    public DownloadFileCheckpoint setKey(String str) {
        this.key = str;
        return this;
    }

    public DownloadFileCheckpoint setPartSize(long j5) {
        this.partSize = j5;
        return this;
    }

    public DownloadFileCheckpoint setSsecAlgorithm(String str) {
        this.ssecAlgorithm = str;
        return this;
    }

    public DownloadFileCheckpoint setSsecKeyMD5(String str) {
        this.ssecKeyMD5 = str;
        return this;
    }

    public DownloadFileCheckpoint setVersionID(String str) {
        this.versionID = str;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("DownloadFileCheckpoint{bucket='");
        sb.append(this.bucket);
        sb.append("', key='");
        sb.append(this.key);
        sb.append("', versionID='");
        sb.append(this.versionID);
        sb.append("', partSize=");
        sb.append(this.partSize);
        sb.append(", ifMatch='");
        sb.append(this.ifMatch);
        sb.append("', ifModifiedSince=");
        sb.append(this.ifModifiedSince);
        sb.append(", ifNoneMatch='");
        sb.append(this.ifNoneMatch);
        sb.append("', ifUnModifiedSince=");
        sb.append(this.ifUnModifiedSince);
        sb.append(", ssecAlgorithm='");
        sb.append(this.ssecAlgorithm);
        sb.append("', ssecKeyMD5='");
        sb.append(this.ssecKeyMD5);
        sb.append("', downloadObjectInfo=");
        sb.append(this.downloadObjectInfo);
        sb.append(", downloadFileInfo=");
        sb.append(this.downloadFileInfo);
        sb.append(", downloadPartInfo=");
        return a.r(sb, this.downloadPartInfos, '}');
    }

    public synchronized void writeToFile(String str) throws IOException {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(str);
            try {
                fileOutputStream.write(f.b.writeValueAsBytes(this));
                fileOutputStream.close();
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    try {
                        fileOutputStream.close();
                    } catch (Throwable th3) {
                        th.addSuppressed(th3);
                    }
                    throw th2;
                }
            }
        } catch (JsonProcessingException e) {
            throw new TosClientException("tos: unable to do serialization", e);
        }
    }
}
