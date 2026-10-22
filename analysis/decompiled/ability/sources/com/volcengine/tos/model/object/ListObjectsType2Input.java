package com.volcengine.tos.model.object;

import androidx.appfunctions.metadata.a;

/* loaded from: classes3.dex */
public class ListObjectsType2Input {
    private String bucket;
    private String continuationToken;
    private String delimiter;
    private String encodingType;
    private boolean listOnlyOnce;
    private int maxKeys;
    private String prefix;
    private String startAfter;

    public static final class ListObjectsType2InputBuilder {
        private String bucket;
        private String continuationToken;
        private String delimiter;
        private String encodingType;
        private boolean listOnlyOnce;
        private int maxKeys;
        private String prefix;
        private String startAfter;

        public ListObjectsType2InputBuilder bucket(String str) {
            this.bucket = str;
            return this;
        }

        public ListObjectsType2Input build() {
            ListObjectsType2Input listObjectsType2Input = new ListObjectsType2Input();
            listObjectsType2Input.setBucket(this.bucket);
            listObjectsType2Input.setPrefix(this.prefix);
            listObjectsType2Input.setDelimiter(this.delimiter);
            listObjectsType2Input.setStartAfter(this.startAfter);
            listObjectsType2Input.setContinuationToken(this.continuationToken);
            listObjectsType2Input.setMaxKeys(this.maxKeys);
            listObjectsType2Input.setEncodingType(this.encodingType);
            listObjectsType2Input.setListOnlyOnce(this.listOnlyOnce);
            return listObjectsType2Input;
        }

        public ListObjectsType2InputBuilder continuationToken(String str) {
            this.continuationToken = str;
            return this;
        }

        public ListObjectsType2InputBuilder delimiter(String str) {
            this.delimiter = str;
            return this;
        }

        public ListObjectsType2InputBuilder encodingType(String str) {
            this.encodingType = str;
            return this;
        }

        public ListObjectsType2InputBuilder listOnlyOnce(boolean z10) {
            this.listOnlyOnce = z10;
            return this;
        }

        public ListObjectsType2InputBuilder maxKeys(int i) {
            this.maxKeys = i;
            return this;
        }

        public ListObjectsType2InputBuilder prefix(String str) {
            this.prefix = str;
            return this;
        }

        public ListObjectsType2InputBuilder startAfter(String str) {
            this.startAfter = str;
            return this;
        }

        private ListObjectsType2InputBuilder() {
        }
    }

    public static ListObjectsType2InputBuilder builder() {
        return new ListObjectsType2InputBuilder();
    }

    public String getBucket() {
        return this.bucket;
    }

    public String getContinuationToken() {
        return this.continuationToken;
    }

    public String getDelimiter() {
        return this.delimiter;
    }

    public String getEncodingType() {
        return this.encodingType;
    }

    public int getMaxKeys() {
        return this.maxKeys;
    }

    public String getPrefix() {
        return this.prefix;
    }

    public String getStartAfter() {
        return this.startAfter;
    }

    public boolean isListOnlyOnce() {
        return this.listOnlyOnce;
    }

    public ListObjectsType2Input setBucket(String str) {
        this.bucket = str;
        return this;
    }

    public ListObjectsType2Input setContinuationToken(String str) {
        this.continuationToken = str;
        return this;
    }

    public ListObjectsType2Input setDelimiter(String str) {
        this.delimiter = str;
        return this;
    }

    public ListObjectsType2Input setEncodingType(String str) {
        this.encodingType = str;
        return this;
    }

    public ListObjectsType2Input setListOnlyOnce(boolean z10) {
        this.listOnlyOnce = z10;
        return this;
    }

    public ListObjectsType2Input setMaxKeys(int i) {
        this.maxKeys = i;
        return this;
    }

    public ListObjectsType2Input setPrefix(String str) {
        this.prefix = str;
        return this;
    }

    public ListObjectsType2Input setStartAfter(String str) {
        this.startAfter = str;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("ListObjectsType2Input{bucket='");
        sb.append(this.bucket);
        sb.append("', prefix='");
        sb.append(this.prefix);
        sb.append("', delimiter='");
        sb.append(this.delimiter);
        sb.append("', startAfter='");
        sb.append(this.startAfter);
        sb.append("', continuationToken='");
        sb.append(this.continuationToken);
        sb.append("', maxKeys=");
        sb.append(this.maxKeys);
        sb.append(", encodingType='");
        sb.append(this.encodingType);
        sb.append("', listOnlyOnce=");
        return a.r(sb, this.listOnlyOnce, '}');
    }
}
