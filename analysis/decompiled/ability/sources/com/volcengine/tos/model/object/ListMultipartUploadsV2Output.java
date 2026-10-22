package com.volcengine.tos.model.object;

import B7.a;
import androidx.compose.material3.internal.TextFieldImplKt;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.volcengine.tos.model.RequestInfo;
import java.util.List;

/* loaded from: classes3.dex */
public class ListMultipartUploadsV2Output {

    @JsonProperty("Bucket")
    private String bucket;

    @JsonProperty("CommonPrefixes")
    private List<ListedCommonPrefix> commonPrefixes;

    @JsonProperty("Delimiter")
    private String delimiter;

    @JsonProperty("EncodingType")
    private String encodingType;

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

    @JsonIgnore
    private RequestInfo requestInfo;

    @JsonProperty("UploadIdMarker")
    private String uploadIDMarker;

    @JsonProperty("Uploads")
    private List<ListedUpload> uploads;

    public String getBucket() {
        return this.bucket;
    }

    public List<ListedCommonPrefix> getCommonPrefixes() {
        return this.commonPrefixes;
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

    public String getUploadIDMarker() {
        return this.uploadIDMarker;
    }

    public List<ListedUpload> getUploads() {
        return this.uploads;
    }

    public boolean isTruncated() {
        return this.isTruncated;
    }

    public ListMultipartUploadsV2Output setBucket(String str) {
        this.bucket = str;
        return this;
    }

    public ListMultipartUploadsV2Output setCommonPrefixes(List<ListedCommonPrefix> list) {
        this.commonPrefixes = list;
        return this;
    }

    public ListMultipartUploadsV2Output setDelimiter(String str) {
        this.delimiter = str;
        return this;
    }

    public ListMultipartUploadsV2Output setEncodingType(String str) {
        this.encodingType = str;
        return this;
    }

    public ListMultipartUploadsV2Output setKeyMarker(String str) {
        this.keyMarker = str;
        return this;
    }

    public ListMultipartUploadsV2Output setMaxUploads(int i) {
        this.maxUploads = i;
        return this;
    }

    public ListMultipartUploadsV2Output setNextKeyMarker(String str) {
        this.nextKeyMarker = str;
        return this;
    }

    public ListMultipartUploadsV2Output setNextUploadIdMarker(String str) {
        this.nextUploadIdMarker = str;
        return this;
    }

    public ListMultipartUploadsV2Output setPrefix(String str) {
        this.prefix = str;
        return this;
    }

    public ListMultipartUploadsV2Output setRequestInfo(RequestInfo requestInfo) {
        this.requestInfo = requestInfo;
        return this;
    }

    public ListMultipartUploadsV2Output setTruncated(boolean z10) {
        this.isTruncated = z10;
        return this;
    }

    public ListMultipartUploadsV2Output setUploadIDMarker(String str) {
        this.uploadIDMarker = str;
        return this;
    }

    public ListMultipartUploadsV2Output setUploads(List<ListedUpload> list) {
        this.uploads = list;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("ListMultipartUploadsV2Output{requestInfo=");
        sb.append(this.requestInfo);
        sb.append(", bucket='");
        sb.append(this.bucket);
        sb.append("', prefix='");
        sb.append(this.prefix);
        sb.append("', keyMarker='");
        sb.append(this.keyMarker);
        sb.append("', uploadIDMarker='");
        sb.append(this.uploadIDMarker);
        sb.append("', maxUploads=");
        sb.append(this.maxUploads);
        sb.append(", delimiter='");
        sb.append(this.delimiter);
        sb.append("', isTruncated=");
        sb.append(this.isTruncated);
        sb.append(", encodingType='");
        sb.append(this.encodingType);
        sb.append("', nextKeyMarker='");
        sb.append(this.nextKeyMarker);
        sb.append("', nextUploadIdMarker='");
        sb.append(this.nextUploadIdMarker);
        sb.append("', commonPrefixes=");
        sb.append(this.commonPrefixes);
        sb.append(", uploads=");
        return a.r(sb, this.uploads, '}');
    }
}
