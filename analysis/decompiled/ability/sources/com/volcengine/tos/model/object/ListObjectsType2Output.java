package com.volcengine.tos.model.object;

import B7.a;
import androidx.compose.material3.internal.TextFieldImplKt;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.volcengine.tos.model.RequestInfo;
import java.util.List;

/* loaded from: classes3.dex */
public class ListObjectsType2Output {

    @JsonProperty("CommonPrefixes")
    private List<ListedCommonPrefix> commonPrefixes;

    @JsonProperty("Contents")
    private List<ListedObjectV2> contents;

    @JsonProperty("ContinuationToken")
    private String continuationToken;

    @JsonProperty("Delimiter")
    private String delimiter;

    @JsonProperty("EncodingType")
    private String encodingType;

    @JsonProperty("IsTruncated")
    private boolean isTruncated;

    @JsonProperty("KeyCount")
    private int keyCount;

    @JsonProperty("MaxKeys")
    private int maxKeys;

    @JsonProperty("Name")
    private String name;

    @JsonProperty("NextContinuationToken")
    private String nextContinuationToken;

    @JsonProperty(TextFieldImplKt.PrefixId)
    private String prefix;

    @JsonIgnore
    private RequestInfo requestInfo;

    public static final class ListObjectsType2OutputBuilder {
        private List<ListedCommonPrefix> commonPrefixes;
        private List<ListedObjectV2> contents;
        private String continuationToken;
        private String delimiter;
        private String encodingType;
        private boolean isTruncated;
        private int keyCount;
        private int maxKeys;
        private String name;
        private String nextContinuationToken;
        private String prefix;
        private RequestInfo requestInfo;

        public ListObjectsType2Output build() {
            ListObjectsType2Output listObjectsType2Output = new ListObjectsType2Output();
            listObjectsType2Output.setRequestInfo(this.requestInfo);
            listObjectsType2Output.setName(this.name);
            listObjectsType2Output.setPrefix(this.prefix);
            listObjectsType2Output.setContinuationToken(this.continuationToken);
            listObjectsType2Output.setMaxKeys(this.maxKeys);
            listObjectsType2Output.setDelimiter(this.delimiter);
            listObjectsType2Output.setEncodingType(this.encodingType);
            listObjectsType2Output.setKeyCount(this.keyCount);
            listObjectsType2Output.setNextContinuationToken(this.nextContinuationToken);
            listObjectsType2Output.setCommonPrefixes(this.commonPrefixes);
            listObjectsType2Output.setContents(this.contents);
            listObjectsType2Output.isTruncated = this.isTruncated;
            return listObjectsType2Output;
        }

        public ListObjectsType2OutputBuilder commonPrefixes(List<ListedCommonPrefix> list) {
            this.commonPrefixes = list;
            return this;
        }

        public ListObjectsType2OutputBuilder contents(List<ListedObjectV2> list) {
            this.contents = list;
            return this;
        }

        public ListObjectsType2OutputBuilder continuationToken(String str) {
            this.continuationToken = str;
            return this;
        }

        public ListObjectsType2OutputBuilder delimiter(String str) {
            this.delimiter = str;
            return this;
        }

        public ListObjectsType2OutputBuilder encodingType(String str) {
            this.encodingType = str;
            return this;
        }

        public ListObjectsType2OutputBuilder isTruncated(boolean z10) {
            this.isTruncated = z10;
            return this;
        }

        public ListObjectsType2OutputBuilder keyCount(int i) {
            this.keyCount = i;
            return this;
        }

        public ListObjectsType2OutputBuilder maxKeys(int i) {
            this.maxKeys = i;
            return this;
        }

        public ListObjectsType2OutputBuilder name(String str) {
            this.name = str;
            return this;
        }

        public ListObjectsType2OutputBuilder nextContinuationToken(String str) {
            this.nextContinuationToken = str;
            return this;
        }

        public ListObjectsType2OutputBuilder prefix(String str) {
            this.prefix = str;
            return this;
        }

        public ListObjectsType2OutputBuilder requestInfo(RequestInfo requestInfo) {
            this.requestInfo = requestInfo;
            return this;
        }

        private ListObjectsType2OutputBuilder() {
        }
    }

    public static ListObjectsType2OutputBuilder builder() {
        return new ListObjectsType2OutputBuilder();
    }

    public List<ListedCommonPrefix> getCommonPrefixes() {
        return this.commonPrefixes;
    }

    public List<ListedObjectV2> getContents() {
        return this.contents;
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

    public int getKeyCount() {
        return this.keyCount;
    }

    public int getMaxKeys() {
        return this.maxKeys;
    }

    public String getName() {
        return this.name;
    }

    public String getNextContinuationToken() {
        return this.nextContinuationToken;
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

    public ListObjectsType2Output setCommonPrefixes(List<ListedCommonPrefix> list) {
        this.commonPrefixes = list;
        return this;
    }

    public ListObjectsType2Output setContents(List<ListedObjectV2> list) {
        this.contents = list;
        return this;
    }

    public ListObjectsType2Output setContinuationToken(String str) {
        this.continuationToken = str;
        return this;
    }

    public ListObjectsType2Output setDelimiter(String str) {
        this.delimiter = str;
        return this;
    }

    public ListObjectsType2Output setEncodingType(String str) {
        this.encodingType = str;
        return this;
    }

    public ListObjectsType2Output setKeyCount(int i) {
        this.keyCount = i;
        return this;
    }

    public ListObjectsType2Output setMaxKeys(int i) {
        this.maxKeys = i;
        return this;
    }

    public ListObjectsType2Output setName(String str) {
        this.name = str;
        return this;
    }

    public ListObjectsType2Output setNextContinuationToken(String str) {
        this.nextContinuationToken = str;
        return this;
    }

    public ListObjectsType2Output setPrefix(String str) {
        this.prefix = str;
        return this;
    }

    public ListObjectsType2Output setRequestInfo(RequestInfo requestInfo) {
        this.requestInfo = requestInfo;
        return this;
    }

    public ListObjectsType2Output setTruncated(boolean z10) {
        this.isTruncated = z10;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("ListObjectsType2Output{requestInfo=");
        sb.append(this.requestInfo);
        sb.append(", name='");
        sb.append(this.name);
        sb.append("', prefix='");
        sb.append(this.prefix);
        sb.append("', continuationToken='");
        sb.append(this.continuationToken);
        sb.append("', maxKeys=");
        sb.append(this.maxKeys);
        sb.append(", delimiter='");
        sb.append(this.delimiter);
        sb.append("', encodingType='");
        sb.append(this.encodingType);
        sb.append("', keyCount=");
        sb.append(this.keyCount);
        sb.append(", isTruncated=");
        sb.append(this.isTruncated);
        sb.append(", nextContinuationToken='");
        sb.append(this.nextContinuationToken);
        sb.append("', commonPrefixes=");
        sb.append(this.commonPrefixes);
        sb.append(", contents=");
        return a.r(sb, this.contents, '}');
    }
}
