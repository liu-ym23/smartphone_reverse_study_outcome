package com.volcengine.tos.model.object;

import androidx.compose.material3.internal.TextFieldImplKt;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.volcengine.tos.model.RequestInfo;
import java.util.Arrays;

@Deprecated
/* loaded from: classes3.dex */
public class ListMultipartUploadsOutput {

    @JsonProperty("Bucket")
    private String bucket;

    @JsonProperty("CommonPrefixes")
    private UploadCommonPrefix[] commonPrefixes;

    @JsonProperty("Delimiter")
    private String delimiter;

    @JsonProperty("IsTruncated")
    private boolean isTruncated;

    @JsonProperty("KeyMarker")
    private String keyMarker;

    @JsonProperty("MaxUploads")
    private int maxUploads;

    @JsonProperty("NextKeyMarker")
    private String nextKeyMarker;

    @JsonProperty("NextUploadIdMarker")
    private String nextUploadIdMarker;

    @JsonProperty(TextFieldImplKt.PrefixId)
    private String prefix;
    private RequestInfo requestInfo;

    @JsonProperty("Uploads")
    private UploadInfo[] upload;

    @JsonProperty("UploadIdMarker")
    private String uploadIDMarker;

    public String getBucket() {
        return this.bucket;
    }

    public UploadCommonPrefix[] getCommonPrefixes() {
        return this.commonPrefixes;
    }

    public String getDelimiter() {
        return this.delimiter;
    }

    public String getKeyMarker() {
        return this.keyMarker;
    }

    public int getMaxUploads() {
        return this.maxUploads;
    }

    public String getNextKeyMarker() {
        return this.nextKeyMarker;
    }

    public String getNextUploadIdMarker() {
        return this.nextUploadIdMarker;
    }

    public String getPrefix() {
        return this.prefix;
    }

    public RequestInfo getRequestInfo() {
        return this.requestInfo;
    }

    public UploadInfo[] getUpload() {
        return this.upload;
    }

    public String getUploadIDMarker() {
        return this.uploadIDMarker;
    }

    public boolean isTruncated() {
        return this.isTruncated;
    }

    public ListMultipartUploadsOutput setBucket(String str) {
        this.bucket = str;
        return this;
    }

    public ListMultipartUploadsOutput setCommonPrefixes(UploadCommonPrefix[] uploadCommonPrefixArr) {
        this.commonPrefixes = uploadCommonPrefixArr;
        return this;
    }

    public ListMultipartUploadsOutput setDelimiter(String str) {
        this.delimiter = str;
        return this;
    }

    public ListMultipartUploadsOutput setKeyMarker(String str) {
        this.keyMarker = str;
        return this;
    }

    public ListMultipartUploadsOutput setMaxUploads(int i) {
        this.maxUploads = i;
        return this;
    }

    public ListMultipartUploadsOutput setNextKeyMarker(String str) {
        this.nextKeyMarker = str;
        return this;
    }

    public ListMultipartUploadsOutput setNextUploadIdMarker(String str) {
        this.nextUploadIdMarker = str;
        return this;
    }

    public ListMultipartUploadsOutput setPrefix(String str) {
        this.prefix = str;
        return this;
    }

    public ListMultipartUploadsOutput setRequestInfo(RequestInfo requestInfo) {
        this.requestInfo = requestInfo;
        return this;
    }

    public ListMultipartUploadsOutput setTruncated(boolean z10) {
        this.isTruncated = z10;
        return this;
    }

    public ListMultipartUploadsOutput setUpload(UploadInfo[] uploadInfoArr) {
        this.upload = uploadInfoArr;
        return this;
    }

    public ListMultipartUploadsOutput setUploadIDMarker(String str) {
        this.uploadIDMarker = str;
        return this;
    }

    public String toString() {
        return "ListMultipartUploadsOutput{requestInfo=" + this.requestInfo + ", bucket='" + this.bucket + "', keyMarker='" + this.keyMarker + "', nextKeyMarker='" + this.nextKeyMarker + "', uploadIDMarker='" + this.uploadIDMarker + "', nextUploadIdMarker='" + this.nextUploadIdMarker + "', delimiter='" + this.delimiter + "', prefix='" + this.prefix + "', maxUploads=" + this.maxUploads + ", isTruncated=" + this.isTruncated + ", upload=" + Arrays.toString(this.upload) + ", commonPrefixes=" + Arrays.toString(this.commonPrefixes) + '}';
    }
}
