package com.volcengine.tos.model.object;

import a7.AbstractC0307c;
import com.volcengine.tos.comm.common.StorageClassType;
import com.volcengine.tos.model.RequestInfo;
import java.util.Date;
import java.util.Map;

/* loaded from: classes3.dex */
public class GetObjectToFileOutput {

    @Deprecated
    private GetObjectBasicOutput getObjectBasicOutput;

    public GetObjectToFileOutput(GetObjectBasicOutput getObjectBasicOutput) {
        AbstractC0307c.a(getObjectBasicOutput, "GetObjectBasicOutput");
        this.getObjectBasicOutput = getObjectBasicOutput;
    }

    public String getCacheControl() {
        return this.getObjectBasicOutput.getCacheControl();
    }

    public String getContentDisposition() {
        return this.getObjectBasicOutput.getContentDisposition();
    }

    public String getContentEncoding() {
        return this.getObjectBasicOutput.getContentEncoding();
    }

    public String getContentLanguage() {
        return this.getObjectBasicOutput.getContentLanguage();
    }

    public long getContentLength() {
        return this.getObjectBasicOutput.getContentLength();
    }

    public String getContentMD5() {
        return this.getObjectBasicOutput.getContentMD5();
    }

    public String getContentRange() {
        return this.getObjectBasicOutput.getContentRange();
    }

    public String getContentType() {
        return this.getObjectBasicOutput.getContentType();
    }

    public Map<String, String> getCustomMetadata() {
        return this.getObjectBasicOutput.getCustomMetadata();
    }

    public String getEtag() {
        return this.getObjectBasicOutput.getEtag();
    }

    public String getExpires() {
        return this.getObjectBasicOutput.getExpires();
    }

    public Date getExpiresInDate() {
        return this.getObjectBasicOutput.getExpiresInDate();
    }

    @Deprecated
    public GetObjectBasicOutput getGetObjectBasicOutput() {
        return this.getObjectBasicOutput;
    }

    public String getHashCrc64ecma() {
        return this.getObjectBasicOutput.getHashCrc64ecma();
    }

    public String getLastModified() {
        return this.getObjectBasicOutput.getLastModified();
    }

    public Date getLastModifiedInDate() {
        return this.getObjectBasicOutput.getLastModifiedInDate();
    }

    public String getObjectType() {
        return this.getObjectBasicOutput.getObjectType();
    }

    public RequestInfo getRequestInfo() {
        return this.getObjectBasicOutput.getRequestInfo();
    }

    public String getSsecAlgorithm() {
        return this.getObjectBasicOutput.getSsecAlgorithm();
    }

    public String getSsecKeyMD5() {
        return this.getObjectBasicOutput.getSsecKeyMD5();
    }

    public StorageClassType getStorageClass() {
        return this.getObjectBasicOutput.getStorageClass();
    }

    public String getVersionID() {
        return this.getObjectBasicOutput.getVersionID();
    }

    public String getWebsiteRedirectLocation() {
        return this.getObjectBasicOutput.getWebsiteRedirectLocation();
    }

    public boolean isDeleteMarker() {
        return this.getObjectBasicOutput.isDeleteMarker();
    }

    @Deprecated
    public GetObjectToFileOutput setGetObjectBasicOutput(GetObjectBasicOutput getObjectBasicOutput) {
        this.getObjectBasicOutput = getObjectBasicOutput;
        return this;
    }

    public GetObjectToFileOutput setRequestInfo(RequestInfo requestInfo) {
        this.getObjectBasicOutput.setRequestInfo(requestInfo);
        return this;
    }

    public String toString() {
        return "GetObjectToFileOutput{requestInfo=" + getRequestInfo() + ", contentRange='" + getContentRange() + "', etag='" + getEtag() + "', lastModified=" + getLastModified() + ", deleteMarker=" + isDeleteMarker() + ", ssecAlgorithm='" + getSsecAlgorithm() + "', ssecKeyMD5='" + getSsecKeyMD5() + "', versionID='" + getVersionID() + "', websiteRedirectLocation='" + getWebsiteRedirectLocation() + "', objectType='" + getObjectType() + "', hashCrc64ecma=" + getHashCrc64ecma() + ", storageClass=" + getStorageClass() + ", metadata=" + getCustomMetadata() + ", cacheControl='" + getCacheControl() + "', contentDisposition='" + getContentDisposition() + "', contentEncoding='" + getContentEncoding() + "', contentLanguage='" + getContentLanguage() + "', contentType='" + getContentType() + "', expires=" + getExpires() + "'}";
    }
}
