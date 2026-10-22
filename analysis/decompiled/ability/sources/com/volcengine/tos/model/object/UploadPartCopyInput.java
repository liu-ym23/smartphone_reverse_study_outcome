package com.volcengine.tos.model.object;

import B7.a;

@Deprecated
/* loaded from: classes3.dex */
public class UploadPartCopyInput {
    private String destinationKey;
    private int partNumber;
    private long partSize;
    private String sourceBucket;
    private String sourceKey;
    private String sourceVersionID;
    private long startOffset;
    private String uploadID;

    public String getDestinationKey() {
        return this.destinationKey;
    }

    public int getPartNumber() {
        return this.partNumber;
    }

    public long getPartSize() {
        return this.partSize;
    }

    public String getSourceBucket() {
        return this.sourceBucket;
    }

    public String getSourceKey() {
        return this.sourceKey;
    }

    public String getSourceVersionID() {
        return this.sourceVersionID;
    }

    public long getStartOffset() {
        return this.startOffset;
    }

    public String getUploadID() {
        return this.uploadID;
    }

    public UploadPartCopyInput setDestinationKey(String str) {
        this.destinationKey = str;
        return this;
    }

    public UploadPartCopyInput setPartNumber(int i) {
        this.partNumber = i;
        return this;
    }

    public UploadPartCopyInput setPartSize(long j5) {
        this.partSize = j5;
        return this;
    }

    public UploadPartCopyInput setSourceBucket(String str) {
        this.sourceBucket = str;
        return this;
    }

    public UploadPartCopyInput setSourceKey(String str) {
        this.sourceKey = str;
        return this;
    }

    public UploadPartCopyInput setSourceVersionID(String str) {
        this.sourceVersionID = str;
        return this;
    }

    public UploadPartCopyInput setStartOffset(long j5) {
        this.startOffset = j5;
        return this;
    }

    public UploadPartCopyInput setUploadID(String str) {
        this.uploadID = str;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("UploadPartCopyInput{uploadID='");
        sb.append(this.uploadID);
        sb.append("', destinationKey='");
        sb.append(this.destinationKey);
        sb.append("', sourceBucket='");
        sb.append(this.sourceBucket);
        sb.append("', sourceKey='");
        sb.append(this.sourceKey);
        sb.append("', sourceVersionID='");
        sb.append(this.sourceVersionID);
        sb.append("', startOffset=");
        sb.append(this.startOffset);
        sb.append(", partSize=");
        sb.append(this.partSize);
        sb.append(", partNumber=");
        return a.o(sb, this.partNumber, '}');
    }
}
