package com.volcengine.tos.model.object;

@Deprecated
/* loaded from: classes3.dex */
public class ListMultipartUploadsInput {
    private String delimiter;
    private String keyMarker;
    private int maxUploads;
    private String prefix;
    private String uploadIDMarker;

    public String getDelimiter() {
        return this.delimiter;
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

    public ListMultipartUploadsInput setDelimiter(String str) {
        this.delimiter = str;
        return this;
    }

    public ListMultipartUploadsInput setKeyMarker(String str) {
        this.keyMarker = str;
        return this;
    }

    public ListMultipartUploadsInput setMaxUploads(int i) {
        this.maxUploads = i;
        return this;
    }

    public ListMultipartUploadsInput setPrefix(String str) {
        this.prefix = str;
        return this;
    }

    public ListMultipartUploadsInput setUploadIDMarker(String str) {
        this.uploadIDMarker = str;
        return this;
    }
}
