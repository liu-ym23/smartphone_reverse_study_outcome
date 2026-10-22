package com.volcengine.tos.model.object;

import a7.AbstractC0307c;
import com.volcengine.tos.comm.common.StorageClassType;
import com.volcengine.tos.model.RequestInfo;
import java.util.Date;
import java.util.Map;

/* loaded from: classes3.dex */
public class HeadObjectV2Output {
    private GetObjectBasicOutput headObjectBasicOutput;

    public HeadObjectV2Output() {
        this.headObjectBasicOutput = new GetObjectBasicOutput();
    }

    public String getCacheControl() {
        return this.headObjectBasicOutput.getCacheControl();
    }

    public String getContentDisposition() {
        return this.headObjectBasicOutput.getContentDisposition();
    }

    public String getContentEncoding() {
        return this.headObjectBasicOutput.getContentEncoding();
    }

    public String getContentLanguage() {
        return this.headObjectBasicOutput.getContentLanguage();
    }

    public long getContentLength() {
        return this.headObjectBasicOutput.getContentLength();
    }

    public String getContentMD5() {
        return this.headObjectBasicOutput.getContentMD5();
    }

    public String getContentRange() {
        return this.headObjectBasicOutput.getContentRange();
    }

    public String getContentType() {
        return this.headObjectBasicOutput.getContentType();
    }

    public Map<String, String> getCustomMetadata() {
        return this.headObjectBasicOutput.getCustomMetadata();
    }

    public String getEtag() {
        return this.headObjectBasicOutput.getEtag();
    }

    public String getExpires() {
        return this.headObjectBasicOutput.getExpires();
    }

    public Date getExpiresInDate() {
        return this.headObjectBasicOutput.getExpiresInDate();
    }

    public String getHashCrc64ecma() {
        return this.headObjectBasicOutput.getHashCrc64ecma();
    }

    @Deprecated
    public GetObjectBasicOutput getHeadObjectBasicOutput() {
        return this.headObjectBasicOutput;
    }

    public String getLastModified() {
        return this.headObjectBasicOutput.getLastModified();
    }

    public Date getLastModifiedInDate() {
        return this.headObjectBasicOutput.getLastModifiedInDate();
    }

    public String getObjectType() {
        return this.headObjectBasicOutput.getObjectType();
    }

    public RequestInfo getRequestInfo() {
        return this.headObjectBasicOutput.getRequestInfo();
    }

    public String getSsecAlgorithm() {
        return this.headObjectBasicOutput.getSsecAlgorithm();
    }

    public String getSsecKeyMD5() {
        return this.headObjectBasicOutput.getSsecKeyMD5();
    }

    public StorageClassType getStorageClass() {
        return this.headObjectBasicOutput.getStorageClass();
    }

    public String getVersionID() {
        return this.headObjectBasicOutput.getVersionID();
    }

    public String getWebsiteRedirectLocation() {
        return this.headObjectBasicOutput.getWebsiteRedirectLocation();
    }

    public boolean isDeleteMarker() {
        return this.headObjectBasicOutput.isDeleteMarker();
    }

    @Deprecated
    public HeadObjectV2Output setHeadObjectBasicOutput(GetObjectBasicOutput getObjectBasicOutput) {
        this.headObjectBasicOutput = getObjectBasicOutput;
        return this;
    }

    public HeadObjectV2Output setRequestInfo(RequestInfo requestInfo) {
        this.headObjectBasicOutput.setRequestInfo(requestInfo);
        return this;
    }

    public String toString() {
        return "HeadObjectOutputV2{requestInfo=" + getRequestInfo() + ", contentRange='" + getContentRange() + "', etag='" + getEtag() + "', lastModified=" + getLastModified() + ", deleteMarker=" + isDeleteMarker() + ", ssecAlgorithm='" + getSsecAlgorithm() + "', ssecKeyMD5='" + getSsecKeyMD5() + "', versionID='" + getVersionID() + "', websiteRedirectLocation='" + getWebsiteRedirectLocation() + "', objectType='" + getObjectType() + "', hashCrc64ecma=" + getHashCrc64ecma() + ", storageClass=" + getStorageClass() + ", metadata=" + getCustomMetadata() + ", cacheControl='" + getCacheControl() + "', contentDisposition='" + getContentDisposition() + "', contentEncoding='" + getContentEncoding() + "', contentLanguage='" + getContentLanguage() + "', contentType='" + getContentType() + "', expires=" + getExpires() + "'}";
    }

    @Deprecated
    public HeadObjectV2Output(GetObjectBasicOutput getObjectBasicOutput) {
        this.headObjectBasicOutput = new GetObjectBasicOutput();
        AbstractC0307c.a(getObjectBasicOutput, "GetObjectBasicOutput");
        this.headObjectBasicOutput = getObjectBasicOutput;
    }
}
