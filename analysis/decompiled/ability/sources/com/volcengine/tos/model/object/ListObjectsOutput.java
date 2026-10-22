package com.volcengine.tos.model.object;

import androidx.compose.material3.internal.TextFieldImplKt;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.volcengine.tos.model.RequestInfo;
import java.util.Arrays;

@Deprecated
/* loaded from: classes3.dex */
public class ListObjectsOutput {

    @JsonProperty("CommonPrefixes")
    private ListedCommonPrefix[] commonPrefixes;

    @JsonProperty("Contents")
    private ListedObject[] contents;

    @JsonProperty("Delimiter")
    private String delimiter;

    @JsonProperty("EncodingType")
    private String encodingType;

    @JsonProperty("IsTruncated")
    private boolean isTruncated;

    @JsonProperty("Marker")
    private String marker;

    @JsonProperty("MaxKeys")
    private long maxKeys;

    @JsonProperty("Name")
    private String name;

    @JsonProperty("NextMarker")
    private String nextMarker;

    @JsonProperty(TextFieldImplKt.PrefixId)
    private String prefix;

    @JsonIgnore
    private RequestInfo requestInfo;

    public ListedCommonPrefix[] getCommonPrefixes() {
        return this.commonPrefixes;
    }

    public ListedObject[] getContents() {
        return this.contents;
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

    public long getMaxKeys() {
        return this.maxKeys;
    }

    public String getName() {
        return this.name;
    }

    public String getNextMarker() {
        return this.nextMarker;
    }

    public String getPrefix() {
        return this.prefix;
    }

    public RequestInfo getRequestInfo() {
        return this.requestInfo;
    }

    public boolean isTruncated() {
        return this.isTruncated;
    }

    public ListObjectsOutput setCommonPrefixes(ListedCommonPrefix[] listedCommonPrefixArr) {
        this.commonPrefixes = listedCommonPrefixArr;
        return this;
    }

    public ListObjectsOutput setContents(ListedObject[] listedObjectArr) {
        this.contents = listedObjectArr;
        return this;
    }

    public ListObjectsOutput setDelimiter(String str) {
        this.delimiter = str;
        return this;
    }

    public ListObjectsOutput setEncodingType(String str) {
        this.encodingType = str;
        return this;
    }

    public ListObjectsOutput setMarker(String str) {
        this.marker = str;
        return this;
    }

    public ListObjectsOutput setMaxKeys(long j5) {
        this.maxKeys = j5;
        return this;
    }

    public ListObjectsOutput setName(String str) {
        this.name = str;
        return this;
    }

    public ListObjectsOutput setNextMarker(String str) {
        this.nextMarker = str;
        return this;
    }

    public ListObjectsOutput setPrefix(String str) {
        this.prefix = str;
        return this;
    }

    public ListObjectsOutput setRequestInfo(RequestInfo requestInfo) {
        this.requestInfo = requestInfo;
        return this;
    }

    public ListObjectsOutput setTruncated(boolean z10) {
        this.isTruncated = z10;
        return this;
    }

    public String toString() {
        return "ListObjectsOutput{requestInfo=" + this.requestInfo + ", name='" + this.name + "', prefix='" + this.prefix + "', marker='" + this.marker + "', maxKeys=" + this.maxKeys + ", nextMarker='" + this.nextMarker + "', delimiter='" + this.delimiter + "', isTruncated=" + this.isTruncated + ", encodingType='" + this.encodingType + "', commonPrefixes=" + Arrays.toString(this.commonPrefixes) + ", contents=" + Arrays.toString(this.contents) + '}';
    }
}
