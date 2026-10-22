package com.volcengine.tos.model.object;

import B7.a;
import a.AbstractC0291a;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.volcengine.tos.TosClientException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;

@Deprecated
/* loaded from: classes3.dex */
public class UploadFileCheckpoint implements Serializable {
    private String bucket;
    private UploadFileInfo fileInfo;
    private String key;
    private long partSize;
    private String sseAlgorithm;
    private String sseKeyMd5;
    private List<UploadFilePartInfo> uploadFilePartInfoList;
    private String uploadID;

    public String getBucket() {
        return this.bucket;
    }

    public UploadFileInfo getFileInfo() {
        return this.fileInfo;
    }

    public String getKey() {
        return this.key;
    }

    public List<UploadFilePartInfo> getPartInfoList() {
        return this.uploadFilePartInfoList;
    }

    public long getPartSize() {
        return this.partSize;
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

    public boolean isValid(long j5, long j6, String str, String str2, String str3) {
        return !AbstractC0291a.x(this.uploadID) && AbstractC0291a.s(this.bucket, str) && AbstractC0291a.s(this.key, str2) && AbstractC0291a.s(this.fileInfo.getFilePath(), str3) && this.fileInfo.getFileSize() == j5 && this.fileInfo.getLastModified() == j6;
    }

    public UploadFileCheckpoint setBucket(String str) {
        this.bucket = str;
        return this;
    }

    public UploadFileCheckpoint setFileInfo(UploadFileInfo uploadFileInfo) {
        this.fileInfo = uploadFileInfo;
        return this;
    }

    public UploadFileCheckpoint setKey(String str) {
        this.key = str;
        return this;
    }

    public UploadFileCheckpoint setPartInfoList(List<UploadFilePartInfo> list) {
        this.uploadFilePartInfoList = list;
        return this;
    }

    public UploadFileCheckpoint setPartSize(long j5) {
        this.partSize = j5;
        return this;
    }

    public UploadFileCheckpoint setSseAlgorithm(String str) {
        this.sseAlgorithm = str;
        return this;
    }

    public UploadFileCheckpoint setSseKeyMd5(String str) {
        this.sseKeyMd5 = str;
        return this;
    }

    public UploadFileCheckpoint setUploadID(String str) {
        this.uploadID = str;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("UploadFileCheckpoint{bucket='");
        sb.append(this.bucket);
        sb.append("', key='");
        sb.append(this.key);
        sb.append("', partSize=");
        sb.append(this.partSize);
        sb.append(", uploadID='");
        sb.append(this.uploadID);
        sb.append("', sseAlgorithm='");
        sb.append(this.sseAlgorithm);
        sb.append("', sseKeyMd5='");
        sb.append(this.sseKeyMd5);
        sb.append("', fileInfo=");
        sb.append(this.fileInfo);
        sb.append(", uploadFilePartInfoList=");
        return a.r(sb, this.uploadFilePartInfoList, '}');
    }

    public synchronized void writeToFile(String str, ObjectMapper objectMapper) throws IOException {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(str);
            try {
                fileOutputStream.write(objectMapper.writeValueAsBytes(this));
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
