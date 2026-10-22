package com.volcengine.tos.model.object;

import B7.a;

/* loaded from: classes3.dex */
public class ListMultipartUploadsV2Input {
    private String bucket;
    private String delimiter;
    private String encodingType;
    private String keyMarker;
    private int maxUploads;
    private String prefix;
    private String uploadIDMarker;

    public static final class ListMultipartUploadsV2InputBuilder {
        private String bucket;
        private String delimiter;
        private String encodingType;
        private String keyMarker;
        private int maxUploads;
        private String prefix;
        private String uploadIDMarker;

        public ListMultipartUploadsV2InputBuilder bucket(String str) {
            this.bucket = str;
            return this;
        }

        public ListMultipartUploadsV2Input build() {
            ListMultipartUploadsV2Input listMultipartUploadsV2Input = new ListMultipartUploadsV2Input();
            listMultipartUploadsV2Input.encodingType = this.encodingType;
            listMultipartUploadsV2Input.delimiter = this.delimiter;
            listMultipartUploadsV2Input.keyMarker = this.keyMarker;
            listMultipartUploadsV2Input.maxUploads = this.maxUploads;
            listMultipartUploadsV2Input.bucket = this.bucket;
            listMultipartUploadsV2Input.uploadIDMarker = this.uploadIDMarker;
            listMultipartUploadsV2Input.prefix = this.prefix;
            return listMultipartUploadsV2Input;
        }

        public ListMultipartUploadsV2InputBuilder delimiter(String str) {
            this.delimiter = str;
            return this;
        }

        public ListMultipartUploadsV2InputBuilder encodingType(String str) {
            this.encodingType = str;
            return this;
        }

        public ListMultipartUploadsV2InputBuilder keyMarker(String str) {
            this.keyMarker = str;
            return this;
        }

        public ListMultipartUploadsV2InputBuilder maxUploads(int i) {
            this.maxUploads = i;
            return this;
        }

        public ListMultipartUploadsV2InputBuilder prefix(String str) {
            this.prefix = str;
            return this;
        }

        public ListMultipartUploadsV2InputBuilder uploadIDMarker(String str) {
            this.uploadIDMarker = str;
            return this;
        }

        private ListMultipartUploadsV2InputBuilder() {
        }
    }

    public static ListMultipartUploadsV2InputBuilder builder() {
        return new ListMultipartUploadsV2InputBuilder();
    }

    public String getBucket() {
        return this.bucket;
    }

    public String getDelimiter() {
        return this.delimiter;
    }

    public String getEncodingType() {
        return this.encodingType;
    }

    public String getKeyMarker() {
        return this.keyMarker;
    }

    public int getMaxUploads() {
        return this.maxUploads;
    }

    public String getPrefix() {
        return this.prefix;
    }

    public String getUploadIDMarker() {
        return this.uploadIDMarker;
    }

    public ListMultipartUploadsV2Input setBucket(String str) {
        this.bucket = str;
        return this;
    }

    public ListMultipartUploadsV2Input setDelimiter(String str) {
        this.delimiter = str;
        return this;
    }

    public ListMultipartUploadsV2Input setEncodingType(String str) {
        this.encodingType = str;
        return this;
    }

    public ListMultipartUploadsV2Input setKeyMarker(String str) {
        this.keyMarker = str;
        return this;
    }

    public ListMultipartUploadsV2Input setMaxUploads(int i) {
        this.maxUploads = i;
        return this;
    }

    public ListMultipartUploadsV2Input setPrefix(String str) {
        this.prefix = str;
        return this;
    }

    public ListMultipartUploadsV2Input setUploadIDMarker(String str) {
        this.uploadIDMarker = str;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("ListMultipartUploadsV2Input{bucket='");
        sb.append(this.bucket);
        sb.append("', encodingType='");
        sb.append(this.encodingType);
        sb.append("', prefix='");
        sb.append(this.prefix);
        sb.append("', delimiter='");
        sb.append(this.delimiter);
        sb.append("', keyMarker='");
        sb.append(this.keyMarker);
        sb.append("', uploadIDMarker='");
        sb.append(this.uploadIDMarker);
        sb.append("', maxUploads=");
        return a.o(sb, this.maxUploads, '}');
    }
}
