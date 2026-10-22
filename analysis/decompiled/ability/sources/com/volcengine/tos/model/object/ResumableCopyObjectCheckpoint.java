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
public class ResumableCopyObjectCheckpoint {
    private String bucket;
    private List<CopyPartInfo> copyPartInfoList;
    private String copySourceIfMatch;
    private Date copySourceIfModifiedSince;
    private String copySourceIfNoneMatch;
    private Date copySourceIfUnModifiedSince;
    private CopySourceObjectInfo copySourceObjectInfo;
    private String copySourceSSECAlgorithm;
    private String copySourceSSECKeyMD5;
    private String encodingType;
    private String key;
    private long partSize;
    private String srcBucket;
    private String srcKey;
    private String srcVersionID;
    private String ssecAlgorithm;
    private String ssecKeyMD5;
    private String uploadID;

    public String getBucket() {
        return this.bucket;
    }

    public List<CopyPartInfo> getCopyPartInfoList() {
        return this.copyPartInfoList;
    }

    public String getCopySourceIfMatch() {
        return this.copySourceIfMatch;
    }

    public Date getCopySourceIfModifiedSince() {
        return this.copySourceIfModifiedSince;
    }

    public String getCopySourceIfNoneMatch() {
        return this.copySourceIfNoneMatch;
    }

    public Date getCopySourceIfUnModifiedSince() {
        return this.copySourceIfUnModifiedSince;
    }

    public CopySourceObjectInfo getCopySourceObjectInfo() {
        return this.copySourceObjectInfo;
    }

    public String getCopySourceSSECAlgorithm() {
        return this.copySourceSSECAlgorithm;
    }

    public String getCopySourceSSECKeyMD5() {
        return this.copySourceSSECKeyMD5;
    }

    public String getEncodingType() {
        return this.encodingType;
    }

    public String getKey() {
        return this.key;
    }

    public long getPartSize() {
        return this.partSize;
    }

    public String getSrcBucket() {
        return this.srcBucket;
    }

    public String getSrcKey() {
        return this.srcKey;
    }

    public String getSrcVersionID() {
        return this.srcVersionID;
    }

    public String getSsecAlgorithm() {
        return this.ssecAlgorithm;
    }

    public String getSsecKeyMD5() {
        return this.ssecKeyMD5;
    }

    public String getUploadID() {
        return this.uploadID;
    }

    public boolean isValid(CopySourceObjectInfo copySourceObjectInfo, String str, String str2, String str3, String str4, String str5) {
        CopySourceObjectInfo copySourceObjectInfo2;
        if (!AbstractC0291a.x(this.uploadID) && AbstractC0291a.s(this.bucket, str) && AbstractC0291a.s(this.key, str2) && AbstractC0291a.s(this.srcBucket, str3) && AbstractC0291a.s(this.srcKey, str4) && AbstractC0291a.s(this.srcVersionID, str5) && copySourceObjectInfo != null && (copySourceObjectInfo2 = this.copySourceObjectInfo) != null) {
            return copySourceObjectInfo2.equals(copySourceObjectInfo);
        }
        return false;
    }

    public ResumableCopyObjectCheckpoint setBucket(String str) {
        this.bucket = str;
        return this;
    }

    public ResumableCopyObjectCheckpoint setCopyPartInfoList(List<CopyPartInfo> list) {
        this.copyPartInfoList = list;
        return this;
    }

    public ResumableCopyObjectCheckpoint setCopySourceIfMatch(String str) {
        this.copySourceIfMatch = str;
        return this;
    }

    public ResumableCopyObjectCheckpoint setCopySourceIfModifiedSince(Date date) {
        this.copySourceIfModifiedSince = date;
        return this;
    }

    public ResumableCopyObjectCheckpoint setCopySourceIfNoneMatch(String str) {
        this.copySourceIfNoneMatch = str;
        return this;
    }

    public ResumableCopyObjectCheckpoint setCopySourceIfUnModifiedSince(Date date) {
        this.copySourceIfUnModifiedSince = date;
        return this;
    }

    public ResumableCopyObjectCheckpoint setCopySourceObjectInfo(CopySourceObjectInfo copySourceObjectInfo) {
        this.copySourceObjectInfo = copySourceObjectInfo;
        return this;
    }

    public ResumableCopyObjectCheckpoint setCopySourceSSECAlgorithm(String str) {
        this.copySourceSSECAlgorithm = str;
        return this;
    }

    public ResumableCopyObjectCheckpoint setCopySourceSSECKeyMD5(String str) {
        this.copySourceSSECKeyMD5 = str;
        return this;
    }

    public ResumableCopyObjectCheckpoint setEncodingType(String str) {
        this.encodingType = str;
        return this;
    }

    public ResumableCopyObjectCheckpoint setKey(String str) {
        this.key = str;
        return this;
    }

    public ResumableCopyObjectCheckpoint setPartSize(long j5) {
        this.partSize = j5;
        return this;
    }

    public ResumableCopyObjectCheckpoint setSrcBucket(String str) {
        this.srcBucket = str;
        return this;
    }

    public ResumableCopyObjectCheckpoint setSrcKey(String str) {
        this.srcKey = str;
        return this;
    }

    public ResumableCopyObjectCheckpoint setSrcVersionID(String str) {
        this.srcVersionID = str;
        return this;
    }

    public ResumableCopyObjectCheckpoint setSsecAlgorithm(String str) {
        this.ssecAlgorithm = str;
        return this;
    }

    public ResumableCopyObjectCheckpoint setSsecKeyMD5(String str) {
        this.ssecKeyMD5 = str;
        return this;
    }

    public ResumableCopyObjectCheckpoint setUploadID(String str) {
        this.uploadID = str;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("ResumableCopyObjectCheckpoint{bucket='");
        sb.append(this.bucket);
        sb.append("', key='");
        sb.append(this.key);
        sb.append("', srcBucket='");
        sb.append(this.srcBucket);
        sb.append("', srcKey='");
        sb.append(this.srcKey);
        sb.append("', srcVersionID='");
        sb.append(this.srcVersionID);
        sb.append("', partSize=");
        sb.append(this.partSize);
        sb.append(", uploadID='");
        sb.append(this.uploadID);
        sb.append("', copySourceIfMatch='");
        sb.append(this.copySourceIfMatch);
        sb.append("', copySourceIfModifiedSince=");
        sb.append(this.copySourceIfModifiedSince);
        sb.append(", copySourceIfNoneMatch='");
        sb.append(this.copySourceIfNoneMatch);
        sb.append("', copySourceIfUnModifiedSince=");
        sb.append(this.copySourceIfUnModifiedSince);
        sb.append(", copySourceSSECAlgorithm='");
        sb.append(this.copySourceSSECAlgorithm);
        sb.append("', copySourceSSECKeyMD5='");
        sb.append(this.copySourceSSECKeyMD5);
        sb.append("', ssecAlgorithm='");
        sb.append(this.ssecAlgorithm);
        sb.append("', ssecKeyMD5='");
        sb.append(this.ssecKeyMD5);
        sb.append("', encodingType='");
        sb.append(this.encodingType);
        sb.append("', copySourceObjectInfo=");
        sb.append(this.copySourceObjectInfo);
        sb.append(", copyPartInfoList=");
        return a.r(sb, this.copyPartInfoList, '}');
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
