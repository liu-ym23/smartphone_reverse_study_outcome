package com.volcengine.tos.model.object;

import B7.a;

/* loaded from: classes3.dex */
public class ListPartsInput {
    private String bucket;
    private String encodingType;
    private String key;
    private int maxParts;
    private int partNumberMarker;
    private String uploadID;

    public static final class ListPartsInputBuilder {
        private String bucket;
        private String encodingType;
        private String key;
        private int maxParts;
        private int partNumberMarker;
        private String uploadID;

        public ListPartsInputBuilder bucket(String str) {
            this.bucket = str;
            return this;
        }

        public ListPartsInput build() {
            ListPartsInput listPartsInput = new ListPartsInput();
            listPartsInput.bucket = this.bucket;
            listPartsInput.partNumberMarker = this.partNumberMarker;
            listPartsInput.encodingType = this.encodingType;
            listPartsInput.key = this.key;
            listPartsInput.uploadID = this.uploadID;
            listPartsInput.maxParts = this.maxParts;
            return listPartsInput;
        }

        public ListPartsInputBuilder encodingType(String str) {
            this.encodingType = str;
            return this;
        }

        public ListPartsInputBuilder key(String str) {
            this.key = str;
            return this;
        }

        public ListPartsInputBuilder maxParts(int i) {
            this.maxParts = i;
            return this;
        }

        public ListPartsInputBuilder partNumberMarker(int i) {
            this.partNumberMarker = i;
            return this;
        }

        public ListPartsInputBuilder uploadID(String str) {
            this.uploadID = str;
            return this;
        }

        private ListPartsInputBuilder() {
        }
    }

    public static ListPartsInputBuilder builder() {
        return new ListPartsInputBuilder();
    }

    public String getBucket() {
        return this.bucket;
    }

    public String getEncodingType() {
        return this.encodingType;
    }

    public String getKey() {
        return this.key;
    }

    public int getMaxParts() {
        return this.maxParts;
    }

    public int getPartNumberMarker() {
        return this.partNumberMarker;
    }

    public String getUploadID() {
        return this.uploadID;
    }

    public ListPartsInput setBucket(String str) {
        this.bucket = str;
        return this;
    }

    public ListPartsInput setEncodingType(String str) {
        this.encodingType = str;
        return this;
    }

    public ListPartsInput setKey(String str) {
        this.key = str;
        return this;
    }

    public ListPartsInput setMaxParts(int i) {
        this.maxParts = i;
        return this;
    }

    public ListPartsInput setPartNumberMarker(int i) {
        this.partNumberMarker = i;
        return this;
    }

    public ListPartsInput setUploadID(String str) {
        this.uploadID = str;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("ListPartsInput{bucket='");
        sb.append(this.bucket);
        sb.append("', key='");
        sb.append(this.key);
        sb.append("', uploadID='");
        sb.append(this.uploadID);
        sb.append("', partNumberMarker=");
        sb.append(this.partNumberMarker);
        sb.append(", maxParts=");
        sb.append(this.maxParts);
        sb.append(", encodingType='");
        return a.q(sb, this.encodingType, "'}");
    }
}
