package com.volcengine.tos.model.object;

import com.volcengine.tos.comm.common.StorageClassType;
import com.volcengine.tos.model.RequestInfo;
import java.util.Date;
import java.util.Map;

/* loaded from: classes3.dex */
public class DownloadFileOutput {
    private HeadObjectV2Output output = new HeadObjectV2Output();

    public String getCacheControl() {
        return this.output.getCacheControl();
    }

    public String getContentDisposition() {
        return this.output.getContentDisposition();
    }

    public String getContentEncoding() {
        return this.output.getContentEncoding();
    }

    public String getContentLanguage() {
        return this.output.getContentLanguage();
    }

    public long getContentLength() {
        return this.output.getContentLength();
    }

    public String getContentMD5() {
        return this.output.getContentMD5();
    }

    public String getContentRange() {
        return this.output.getContentRange();
    }

    public String getContentType() {
        return this.output.getContentType();
    }

    public Map<String, String> getCustomMetadata() {
        return this.output.getCustomMetadata();
    }

    public String getEtag() {
        return this.output.getEtag();
    }

    public String getExpires() {
        return this.output.getExpires();
    }

    public Date getExpiresInDate() {
        return this.output.getExpiresInDate();
    }

    public String getHashCrc64ecma() {
        return this.output.getHashCrc64ecma();
    }

    public String getLastModified() {
        return this.output.getLastModified();
    }

    public Date getLastModifiedInDate() {
        return this.output.getLastModifiedInDate();
    }

    public String getObjectType() {
        return this.output.getObjectType();
    }

    @Deprecated
    public HeadObjectV2Output getOutput() {
        return this.output;
    }

    public RequestInfo getRequestInfo() {
        return this.output.getRequestInfo();
    }

    public String getSsecAlgorithm() {
        return this.output.getSsecAlgorithm();
    }

    public String getSsecKeyMD5() {
        return this.output.getSsecKeyMD5();
    }

    public StorageClassType getStorageClass() {
        return this.output.getStorageClass();
    }

    public String getVersionID() {
        return this.output.getVersionID();
    }

    public String getWebsiteRedirectLocation() {
        return this.output.getWebsiteRedirectLocation();
    }

    public boolean isDeleteMarker() {
        return this.output.isDeleteMarker();
    }

    public DownloadFileOutput setOutput(HeadObjectV2Output headObjectV2Output) {
        this.output = headObjectV2Output;
        return this;
    }

    public String toString() {
        return "DownloadFileOutput{requestInfo=" + getRequestInfo() + ", contentRange='" + getContentRange() + "', etag='" + getEtag() + "', lastModified=" + getLastModified() + ", deleteMarker=" + isDeleteMarker() + ", ssecAlgorithm='" + getSsecAlgorithm() + "', ssecKeyMD5='" + getSsecKeyMD5() + "', versionID='" + getVersionID() + "', websiteRedirectLocation='" + getWebsiteRedirectLocation() + "', objectType='" + getObjectType() + "', hashCrc64ecma=" + getHashCrc64ecma() + ", storageClass=" + getStorageClass() + ", metadata=" + getCustomMetadata() + ", cacheControl='" + getCacheControl() + "', contentDisposition='" + getContentDisposition() + "', contentEncoding='" + getContentEncoding() + "', contentLanguage='" + getContentLanguage() + "', contentType='" + getContentType() + "', expires=" + getExpires() + "'}";
    }
}
