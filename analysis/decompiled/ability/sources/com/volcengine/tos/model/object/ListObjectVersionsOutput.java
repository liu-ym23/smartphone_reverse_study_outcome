package com.volcengine.tos.model.object;

import androidx.compose.material3.internal.TextFieldImplKt;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.volcengine.tos.model.RequestInfo;
import java.util.Arrays;

@Deprecated
/* loaded from: classes3.dex */
public class ListObjectVersionsOutput {

    @JsonProperty("CommonPrefixes")
    private ListedCommonPrefix[] commonPrefixes;

    @JsonProperty("DeleteMarkers")
    private ListedDeleteMarkerEntry[] deleteMarkers;

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
    private ListedObjectVersion[] versions;

    public ListedCommonPrefix[] getCommonPrefixes() {
        return this.commonPrefixes;
    }

    public ListedDeleteMarkerEntry[] getDeleteMarkers() {
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

    public ListedObjectVersion[] getVersions() {
        return this.versions;
    }

    public boolean isTruncated() {
        return this.isTruncated;
    }

    public ListObjectVersionsOutput setCommonPrefixes(ListedCommonPrefix[] listedCommonPrefixArr) {
        this.commonPrefixes = listedCommonPrefixArr;
        return this;
    }

    public ListObjectVersionsOutput setDeleteMarkers(ListedDeleteMarkerEntry[] listedDeleteMarkerEntryArr) {
        this.deleteMarkers = listedDeleteMarkerEntryArr;
        return this;
    }

    public ListObjectVersionsOutput setDelimiter(String str) {
        this.delimiter = str;
        return this;
    }

    public ListObjectVersionsOutput setEncodingType(String str) {
        this.encodingType = str;
        return this;
    }

    public ListObjectVersionsOutput setKeyMarker(String str) {
        this.keyMarker = str;
        return this;
    }

    public ListObjectVersionsOutput setMaxKeys(long j5) {
        this.maxKeys = j5;
        return this;
    }

    public ListObjectVersionsOutput setName(String str) {
        this.name = str;
        return this;
    }

    public ListObjectVersionsOutput setNextKeyMarker(String str) {
        this.nextKeyMarker = str;
        return this;
    }

    public ListObjectVersionsOutput setNextVersionIDMarker(String str) {
        this.nextVersionIDMarker = str;
        return this;
    }

    public ListObjectVersionsOutput setPrefix(String str) {
        this.prefix = str;
        return this;
    }

    public ListObjectVersionsOutput setRequestInfo(RequestInfo requestInfo) {
        this.requestInfo = requestInfo;
        return this;
    }

    public ListObjectVersionsOutput setTruncated(boolean z10) {
        this.isTruncated = z10;
        return this;
    }

    public ListObjectVersionsOutput setVersionIDMarker(String str) {
        this.versionIDMarker = str;
        return this;
    }

    public ListObjectVersionsOutput setVersions(ListedObjectVersion[] listedObjectVersionArr) {
        this.versions = listedObjectVersionArr;
        return this;
    }

    public String toString() {
        return "ListObjectVersionsOutput{requestInfo=" + this.requestInfo + ", name='" + this.name + "', prefix='" + this.prefix + "', keyMarker='" + this.keyMarker + "', versionIDMarker='" + this.versionIDMarker + "', delimiter='" + this.delimiter + "', encodingType='" + this.encodingType + "', maxKeys=" + this.maxKeys + ", nextKeyMarker='" + this.nextKeyMarker + "', nextVersionIDMarker='" + this.nextVersionIDMarker + "', isTruncated=" + this.isTruncated + ", commonPrefixes=" + Arrays.toString(this.commonPrefixes) + ", versions=" + Arrays.toString(this.versions) + ", deleteMarkers=" + Arrays.toString(this.deleteMarkers) + '}';
    }
}
