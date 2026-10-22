package com.volcengine.tos.model.object;

import B7.a;

/* loaded from: classes3.dex */
public class ListObjectsV2Input {
    private String bucket;
    private String delimiter;
    private String encodingType;
    private String marker;
    private int maxKeys;
    private String prefix;
    private boolean reverse;

    public static final class ListObjectsV2InputBuilder {
        private String bucket;
        private String delimiter;
        private String encodingType;
        private String marker;
        private int maxKeys;
        private String prefix;
        private boolean reverse;

        public ListObjectsV2InputBuilder bucket(String str) {
            this.bucket = str;
            return this;
        }

        public ListObjectsV2Input build() {
            ListObjectsV2Input listObjectsV2Input = new ListObjectsV2Input();
            listObjectsV2Input.bucket = this.bucket;
            listObjectsV2Input.delimiter = this.delimiter;
            listObjectsV2Input.reverse = this.reverse;
            listObjectsV2Input.encodingType = this.encodingType;
            listObjectsV2Input.maxKeys = this.maxKeys;
            listObjectsV2Input.marker = this.marker;
            listObjectsV2Input.prefix = this.prefix;
            return listObjectsV2Input;
        }

        public ListObjectsV2InputBuilder delimiter(String str) {
            this.delimiter = str;
            return this;
        }

        public ListObjectsV2InputBuilder encodingType(String str) {
            this.encodingType = str;
            return this;
        }

        public ListObjectsV2InputBuilder marker(String str) {
            this.marker = str;
            return this;
        }

        public ListObjectsV2InputBuilder maxKeys(int i) {
            this.maxKeys = i;
            return this;
        }

        public ListObjectsV2InputBuilder prefix(String str) {
            this.prefix = str;
            return this;
        }

        public ListObjectsV2InputBuilder reverse(boolean z10) {
            this.reverse = z10;
            return this;
        }

        private ListObjectsV2InputBuilder() {
        }
    }

    public static ListObjectsV2InputBuilder builder() {
        return new ListObjectsV2InputBuilder();
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

    public String getMarker() {
        return this.marker;
    }

    public int getMaxKeys() {
        return this.maxKeys;
    }

    public String getPrefix() {
        return this.prefix;
    }

    public boolean isReverse() {
        return this.reverse;
    }

    public ListObjectsV2Input setBucket(String str) {
        this.bucket = str;
        return this;
    }

    public ListObjectsV2Input setDelimiter(String str) {
        this.delimiter = str;
        return this;
    }

    public ListObjectsV2Input setEncodingType(String str) {
        this.encodingType = str;
        return this;
    }

    public ListObjectsV2Input setMarker(String str) {
        this.marker = str;
        return this;
    }

    public ListObjectsV2Input setMaxKeys(int i) {
        this.maxKeys = i;
        return this;
    }

    public ListObjectsV2Input setPrefix(String str) {
        this.prefix = str;
        return this;
    }

    public ListObjectsV2Input setReverse(boolean z10) {
        this.reverse = z10;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("ListObjectsV2Input{bucket='");
        sb.append(this.bucket);
        sb.append("', prefix='");
        sb.append(this.prefix);
        sb.append("', delimiter='");
        sb.append(this.delimiter);
        sb.append("', marker='");
        sb.append(this.marker);
        sb.append("', maxKeys=");
        sb.append(this.maxKeys);
        sb.append(", reverse=");
        sb.append(this.reverse);
        sb.append(", encodingType='");
        return a.q(sb, this.encodingType, "'}");
    }
}
