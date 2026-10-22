package com.volcengine.tos.model.object;

import B7.a;
import androidx.compose.material3.internal.TextFieldImplKt;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.volcengine.tos.model.RequestInfo;
import java.util.List;

/* loaded from: classes3.dex */
public class ListObjectsV2Output {

    @JsonProperty("CommonPrefixes")
    private List<ListedCommonPrefix> commonPrefixes;

    @JsonProperty("Contents")
    private List<ListedObjectV2> contents;

    @JsonProperty("Delimiter")
    private String delimiter;

    @JsonProperty("EncodingType")
    private String encodingType;

    @JsonProperty("IsTruncated")
    private boolean isTruncated;

    @JsonProperty("Marker")
    private String marker;

    @JsonProperty("MaxKeys")
    private int maxKeys;

    @JsonProperty("Name")
    private String name;

    @JsonProperty("NextMarker")
    private String nextMarker;

    @JsonProperty(TextFieldImplKt.PrefixId)
    private String prefix;

    @JsonIgnore
    private RequestInfo requestInfo;

    public List<ListedCommonPrefix> getCommonPrefixes() {
        return this.commonPrefixes;
    }

    public List<ListedObjectV2> getContents() {
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

    public int getMaxKeys() {
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

    public ListObjectsV2Output setCommonPrefixes(List<ListedCommonPrefix> list) {
        this.commonPrefixes = list;
        return this;
    }

    public ListObjectsV2Output setContents(List<ListedObjectV2> list) {
        this.contents = list;
        return this;
    }

    public ListObjectsV2Output setDelimiter(String str) {
        this.delimiter = str;
        return this;
    }

    public ListObjectsV2Output setEncodingType(String str) {
        this.encodingType = str;
        return this;
    }

    public ListObjectsV2Output setMarker(String str) {
        this.marker = str;
        return this;
    }

    public ListObjectsV2Output setMaxKeys(int i) {
        this.maxKeys = i;
        return this;
    }

    public ListObjectsV2Output setName(String str) {
        this.name = str;
        return this;
    }

    public ListObjectsV2Output setNextMarker(String str) {
        this.nextMarker = str;
        return this;
    }

    public ListObjectsV2Output setPrefix(String str) {
        this.prefix = str;
        return this;
    }

    public ListObjectsV2Output setRequestInfo(RequestInfo requestInfo) {
        this.requestInfo = requestInfo;
        return this;
    }

    public ListObjectsV2Output setTruncated(boolean z10) {
        this.isTruncated = z10;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("ListObjectsV2Output{requestInfo=");
        sb.append(this.requestInfo);
        sb.append(", name='");
        sb.append(this.name);
        sb.append("', prefix='");
        sb.append(this.prefix);
        sb.append("', marker='");
        sb.append(this.marker);
        sb.append("', maxKeys=");
        sb.append(this.maxKeys);
        sb.append(", nextMarker='");
        sb.append(this.nextMarker);
        sb.append("', delimiter='");
        sb.append(this.delimiter);
        sb.append("', isTruncated=");
        sb.append(this.isTruncated);
        sb.append(", encodingType='");
        sb.append(this.encodingType);
        sb.append("', commonPrefixes=");
        sb.append(this.commonPrefixes);
        sb.append(", contents=");
        return a.r(sb, this.contents, '}');
    }
}
