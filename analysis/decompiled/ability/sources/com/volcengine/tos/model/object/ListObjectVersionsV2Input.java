package com.volcengine.tos.model.object;

import B7.a;

/* loaded from: classes3.dex */
public class ListObjectVersionsV2Input {
    private String bucket;
    private String delimiter;
    private String encodingType;
    private String keyMarker;
    private int maxKeys;
    private String prefix;
    private String versionIDMarker;

    public static final class ListObjectVersionsV2InputBuilder {
        private String bucket;
        private String delimiter;
        private String encodingType;
        private String keyMarker;
        private int maxKeys;
        private String prefix;
        private String versionIDMarker;

        public ListObjectVersionsV2InputBuilder bucket(String str) {
            this.bucket = str;
            return this;
        }

        public ListObjectVersionsV2Input build() {
            ListObjectVersionsV2Input listObjectVersionsV2Input = new ListObjectVersionsV2Input();
            listObjectVersionsV2Input.keyMarker = this.keyMarker;
            listObjectVersionsV2Input.versionIDMarker = this.versionIDMarker;
            listObjectVersionsV2Input.encodingType = this.encodingType;
            listObjectVersionsV2Input.prefix = this.prefix;
            listObjectVersionsV2Input.bucket = this.bucket;
            listObjectVersionsV2Input.delimiter = this.delimiter;
            listObjectVersionsV2Input.maxKeys = this.maxKeys;
            return listObjectVersionsV2Input;
        }

        public ListObjectVersionsV2InputBuilder delimiter(String str) {
            this.delimiter = str;
            return this;
        }

        public ListObjectVersionsV2InputBuilder encodingType(String str) {
            this.encodingType = str;
            return this;
        }

        public ListObjectVersionsV2InputBuilder keyMarker(String str) {
            this.keyMarker = str;
            return this;
        }

        public ListObjectVersionsV2InputBuilder maxKeys(int i) {
            this.maxKeys = i;
            return this;
        }

        public ListObjectVersionsV2InputBuilder prefix(String str) {
            this.prefix = str;
            return this;
        }

        public ListObjectVersionsV2InputBuilder versionIDMarker(String str) {
            this.versionIDMarker = str;
            return this;
        }

        private ListObjectVersionsV2InputBuilder() {
        }
    }

    public static ListObjectVersionsV2InputBuilder builder() {
        return new ListObjectVersionsV2InputBuilder();
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

    public int getMaxKeys() {
        return this.maxKeys;
    }

    public String getPrefix() {
        return this.prefix;
    }

    public String getVersionIDMarker() {
        return this.versionIDMarker;
    }

    public ListObjectVersionsV2Input setBucket(String str) {
        this.bucket = str;
        return this;
    }

    public ListObjectVersionsV2Input setDelimiter(String str) {
        this.delimiter = str;
        return this;
    }

    public ListObjectVersionsV2Input setEncodingType(String str) {
        this.encodingType = str;
        return this;
    }

    public ListObjectVersionsV2Input setKeyMarker(String str) {
        this.keyMarker = str;
        return this;
    }

    public ListObjectVersionsV2Input setMaxKeys(int i) {
        this.maxKeys = i;
        return this;
    }

    public ListObjectVersionsV2Input setPrefix(String str) {
        this.prefix = str;
        return this;
    }

    public ListObjectVersionsV2Input setVersionIDMarker(String str) {
        this.versionIDMarker = str;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("ListObjectVersionsV2Input{bucket='");
        sb.append(this.bucket);
        sb.append("', prefix='");
        sb.append(this.prefix);
        sb.append("', delimiter='");
        sb.append(this.delimiter);
        sb.append("', keyMarker='");
        sb.append(this.keyMarker);
        sb.append("', versionIDMarker='");
        sb.append(this.versionIDMarker);
        sb.append("', maxKeys=");
        sb.append(this.maxKeys);
        sb.append(", encodingType='");
        return a.q(sb, this.encodingType, "'}");
    }
}
