package com.volcengine.tos.model.object;

import B7.a;
import androidx.compose.material3.internal.TextFieldImplKt;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.volcengine.tos.model.RequestInfo;
import java.util.List;

/* loaded from: classes3.dex */
public class ListObjectVersionsV2Output {

    @JsonProperty("CommonPrefixes")
    private List<ListedCommonPrefix> commonPrefixes;

    @JsonProperty("DeleteMarkers")
    private List<ListedDeleteMarkerEntry> deleteMarkers;

    @JsonProperty("Delimiter")
    private String delimiter;

    @JsonProperty("EncodingType")
    private String encodingType;

    @JsonProperty("IsTruncated")
    private boolean isTruncated;

    @JsonProperty("KeyMarker")
    private String keyMarker;

    @JsonProperty("MaxKeys")
    private long maxKeys;

    @JsonProperty("Name")
    private String name;

    @JsonProperty("NextKeyMarker")
    private String nextKeyMarker;

    @JsonProperty("NextVersionIdMarker")
    private String nextVersionIDMarker;

    @JsonProperty(TextFieldImplKt.PrefixId)
    private String prefix;

    @JsonIgnore
    private RequestInfo requestInfo;

    @JsonProperty("VersionIdMarker")
    private String versionIDMarker;

    @JsonProperty("Versions")
    private List<ListedObjectVersion> versions;

    public List<ListedCommonPrefix> getCommonPrefixes() {
        return this.commonPrefixes;
    }

    public List<ListedDeleteMarkerEntry> getDeleteMarkers() {
        return this.deleteMarkers;
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

    public long getMaxKeys() {
        return this.maxKeys;
    }

    public String getName() {
        return this.name;
    }

    public String getNextKeyMarker() {
        return this.nextKeyMarker;
    }

    public String getNextVersionIDMarker() {
        return this.nextVersionIDMarker;
    }

    public String getPrefix() {
        return this.prefix;
    }

    public RequestInfo getRequestInfo() {
        return this.requestInfo;
    }

    public String getVersionIDMarker() {
        return this.versionIDMarker;
    }

    public List<ListedObjectVersion> getVersions() {
        return this.versions;
    }

    public boolean isTruncated() {
        return this.isTruncated;
    }

    public ListObjectVersionsV2Output setCommonPrefixes(List<ListedCommonPrefix> list) {
        this.commonPrefixes = list;
        return this;
    }

    public ListObjectVersionsV2Output setDeleteMarkers(List<ListedDeleteMarkerEntry> list) {
        this.deleteMarkers = list;
        return this;
    }

    public ListObjectVersionsV2Output setDelimiter(String str) {
        this.delimiter = str;
        return this;
    }

    public ListObjectVersionsV2Output setEncodingType(String str) {
        this.encodingType = str;
        return this;
    }

    public ListObjectVersionsV2Output setKeyMarker(String str) {
        this.keyMarker = str;
        return this;
    }

    public ListObjectVersionsV2Output setMaxKeys(long j5) {
        this.maxKeys = j5;
        return this;
    }

    public ListObjectVersionsV2Output setName(String str) {
        this.name = str;
        return this;
    }

    public ListObjectVersionsV2Output setNextKeyMarker(String str) {
        this.nextKeyMarker = str;
        return this;
    }

    public ListObjectVersionsV2Output setNextVersionIDMarker(String str) {
        this.nextVersionIDMarker = str;
        return this;
    }

    public ListObjectVersionsV2Output setPrefix(String str) {
        this.prefix = str;
        return this;
    }

    public ListObjectVersionsV2Output setRequestInfo(RequestInfo requestInfo) {
        this.requestInfo = requestInfo;
        return this;
    }

    public ListObjectVersionsV2Output setTruncated(boolean z10) {
        this.isTruncated = z10;
        return this;
    }

    public ListObjectVersionsV2Output setVersionIDMarker(String str) {
        this.versionIDMarker = str;
        return this;
    }

    public ListObjectVersionsV2Output setVersions(List<ListedObjectVersion> list) {
        this.versions = list;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("ListObjectVersionsV2Output{requestInfo=");
        sb.append(this.requestInfo);
        sb.append(", name='");
        sb.append(this.name);
        sb.append("', prefix='");
        sb.append(this.prefix);
        sb.append("', keyMarker='");
        sb.append(this.keyMarker);
        sb.append("', versionIDMarker='");
        sb.append(this.versionIDMarker);
        sb.append("', delimiter='");
        sb.append(this.delimiter);
        sb.append("', encodingType='");
        sb.append(this.encodingType);
        sb.append("', maxKeys=");
        sb.append(this.maxKeys);
        sb.append(", nextKeyMarker='");
        sb.append(this.nextKeyMarker);
        sb.append("', nextVersionIDMarker='");
        sb.append(this.nextVersionIDMarker);
        sb.append("', isTruncated=");
        sb.append(this.isTruncated);
        sb.append(", commonPrefixes=");
        sb.append(this.commonPrefixes);
        sb.append(", versions=");
        sb.append(this.versions);
        sb.append(", deleteMarkers=");
        return a.r(sb, this.deleteMarkers, '}');
    }
}
