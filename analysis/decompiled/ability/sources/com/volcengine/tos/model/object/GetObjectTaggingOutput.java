package com.volcengine.tos.model.object;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.volcengine.tos.model.RequestInfo;

/* loaded from: classes3.dex */
public class GetObjectTaggingOutput {

    @JsonIgnore
    private RequestInfo requestInfo;

    @JsonProperty("TagSet")
    private TagSet tagSet;

    @JsonIgnore
    private String versionID;

    public RequestInfo getRequestInfo() {
        return this.requestInfo;
    }

    public TagSet getTagSet() {
        return this.tagSet;
    }

    public String getVersionID() {
        return this.versionID;
    }

    public GetObjectTaggingOutput setRequestInfo(RequestInfo requestInfo) {
        this.requestInfo = requestInfo;
        return this;
    }

    public GetObjectTaggingOutput setTagSet(TagSet tagSet) {
        this.tagSet = tagSet;
        return this;
    }

    public GetObjectTaggingOutput setVersionID(String str) {
        this.versionID = str;
        return this;
    }

    public String toString() {
        return "GetObjectTaggingOutput{requestInfo=" + this.requestInfo + ", versionID='" + this.versionID + "', tagSet=" + this.tagSet + '}';
    }
}
