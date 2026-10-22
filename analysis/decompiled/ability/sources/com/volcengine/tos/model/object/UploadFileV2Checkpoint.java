package com.volcengine.tos.model.object;

import B7.a;
import a.AbstractC0291a;
import a7.f;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.volcengine.tos.TosClientException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

/* loaded from: classes3.dex */
public class UploadFileV2Checkpoint {
    private String bucket;
    private String contentType;
    private String encodingType;
    private String filePath;
    private long fileSize;
    private String key;
    private long lastModified;
    private String sseAlgorithm;
    private String sseKeyMd5;
    private String uploadID;
    private List<UploadPartInfo> uploadPartInfos;

    public String getBucket() {
        return this.bucket;
    }

    public String getContentType() {
        return this.contentType;
    }

    public String getEncodingType() {
        return this.encodingType;
    }

    public String getFilePath() {
        return this.filePath;
    }

    public long getFileSize() {
        return this.fileSize;
    }

    public String getKey() {
        return this.key;
    }

    public long getLastModified() {
        return this.lastModified;
    }

    public String getSseAlgorithm() {
        return this.sseAlgorithm;
    }

    public String getSseKeyMd5() {
        return this.sseKeyMd5;
    }

    public String getUploadID() {
        return this.uploadID;
    }

    public List<UploadPartInfo> getUploadPartInfos() {
        return this.uploadPartInfos;
    }

    public boolean isValid(long j5, long j6, String str, String str2, String str3) {
        return !AbstractC0291a.x(this.uploadID) && AbstractC0291a.s(this.bucket, str) && AbstractC0291a.s(this.key, str2) && AbstractC0291a.s(this.filePath, str3) && this.fileSize == j5 && this.lastModified == j6;
    }

    public UploadFileV2Checkpoint setBucket(String str) {
        this.bucket = str;
        return this;
    }

    public UploadFileV2Checkpoint setContentType(String str) {
        this.contentType = str;
        return this;
    }

    public UploadFileV2Checkpoint setEncodingType(String str) {
        this.encodingType = str;
        return this;
    }

    public UploadFileV2Checkpoint setFilePath(String str) {
        this.filePath = str;
        return this;
    }

    public UploadFileV2Checkpoint setFileSize(long j5) {
        this.fileSize = j5;
        return this;
    }

    public UploadFileV2Checkpoint setKey(String str) {
        this.key = str;
        return this;
    }

    public UploadFileV2Checkpoint setLastModified(long j5) {
        this.lastModified = j5;
        return this;
    }

    public UploadFileV2Checkpoint setSseAlgorithm(String str) {
        this.sseAlgorithm = str;
        return this;
    }

    public UploadFileV2Checkpoint setSseKeyMd5(String str) {
        this.sseKeyMd5 = str;
        return this;
    }

    public UploadFileV2Checkpoint setUploadID(String str) {
        this.uploadID = str;
        return this;
    }

    public UploadFileV2Checkpoint setUploadPartInfos(List<UploadPartInfo> list) {
        this.uploadPartInfos = list;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("UploadFileV2Checkpoint{bucket='");
        sb.append(this.bucket);
        sb.append("', key='");
        sb.append(this.key);
        sb.append("', uploadID='");
        sb.append(this.uploadID);
        sb.append("', sseAlgorithm='");
        sb.append(this.sseAlgorithm);
        sb.append("', sseKeyMd5='");
        sb.append(this.sseKeyMd5);
        sb.append("', contentType='");
        sb.append(this.contentType);
        sb.append("', filePath='");
        sb.append(this.filePath);
        sb.append("', lastModified=");
        sb.append(this.lastModified);
        sb.append(", fileSize=");
        sb.append(this.fileSize);
        sb.append(", encodingType='");
        sb.append(this.encodingType);
        sb.append("', uploadPartInfos=");
        return a.r(sb, this.uploadPartInfos, '}');
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
