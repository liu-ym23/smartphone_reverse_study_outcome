package com.google.zxing.pdf417;

/* JADX INFO: loaded from: classes3.dex */
public final class PDF417ResultMetadata {
    private String fileId;
    private boolean lastSegment;
    private int[] optionalData;
    private int segmentIndex;

    public PDF417ResultMetadata() {
    }

    public int getSegmentIndex() {
        return this.segmentIndex;
    }

    public void setSegmentIndex(int r1) {
        this.segmentIndex = r1;
    }

    public String getFileId() {
        return this.fileId;
    }

    public void setFileId(String r1) {
        this.fileId = r1;
    }

    public int[] getOptionalData() {
        return this.optionalData;
    }

    public void setOptionalData(int[] r1) {
        this.optionalData = r1;
    }

    public boolean isLastSegment() {
        return this.lastSegment;
    }

    public void setLastSegment(boolean r1) {
        this.lastSegment = r1;
    }
}
