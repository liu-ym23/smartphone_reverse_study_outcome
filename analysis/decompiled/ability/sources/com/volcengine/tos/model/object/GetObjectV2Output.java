package com.volcengine.tos.model.object;

import B0.f;
import V9.w;
import a7.AbstractC0307c;
import b7.InterfaceC0827a;
import com.volcengine.tos.comm.common.StorageClassType;
import com.volcengine.tos.model.RequestInfo;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.Map;

/* loaded from: classes3.dex */
public class GetObjectV2Output implements Closeable {
    private transient InputStream content;
    private GetObjectBasicOutput getObjectBasicOutput;
    private InterfaceC0827a hook;

    public GetObjectV2Output(GetObjectBasicOutput getObjectBasicOutput, InputStream inputStream) {
        AbstractC0307c.a(getObjectBasicOutput, "GetObjectBasicOutput");
        this.getObjectBasicOutput = getObjectBasicOutput;
        this.content = inputStream;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        InputStream inputStream = this.content;
        if (inputStream != null) {
            inputStream.close();
        }
    }

    public void forceClose() throws IOException {
        InterfaceC0827a interfaceC0827a;
        w wVar;
        if (this.content == null || (interfaceC0827a = this.hook) == null) {
            return;
        }
        f fVar = (f) interfaceC0827a;
        InputStream inputStream = (InputStream) fVar.f177a;
        if (fVar.b || inputStream == null || (wVar = (w) fVar.c) == null) {
            return;
        }
        wVar.timeout().d(System.nanoTime());
        fVar.b = true;
        inputStream.close();
    }

    public String getCacheControl() {
        return this.getObjectBasicOutput.getCacheControl();
    }

    public InputStream getContent() {
        return this.content;
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

    public GetObjectV2Output setContent(InputStream inputStream) {
        this.content = inputStream;
        return this;
    }

    @Deprecated
    public GetObjectV2Output setGetObjectBasicOutput(GetObjectBasicOutput getObjectBasicOutput) {
        this.getObjectBasicOutput = getObjectBasicOutput;
        return this;
    }

    public GetObjectV2Output setHook(InterfaceC0827a interfaceC0827a) {
        this.hook = interfaceC0827a;
        return this;
    }

    public GetObjectV2Output setRequestInfo(RequestInfo requestInfo) {
        this.getObjectBasicOutput.setRequestInfo(requestInfo);
        return this;
    }

    public String toString() {
        return "GetObjectV2Output{requestInfo=" + getRequestInfo() + ", contentRange='" + getContentRange() + "', etag='" + getEtag() + "', lastModified=" + getLastModified() + ", deleteMarker=" + isDeleteMarker() + ", ssecAlgorithm='" + getSsecAlgorithm() + "', ssecKeyMD5='" + getSsecKeyMD5() + "', versionID='" + getVersionID() + "', websiteRedirectLocation='" + getWebsiteRedirectLocation() + "', objectType='" + getObjectType() + "', hashCrc64ecma=" + getHashCrc64ecma() + ", storageClass=" + getStorageClass() + ", metadata=" + getCustomMetadata() + ", cacheControl='" + getCacheControl() + "', contentDisposition='" + getContentDisposition() + "', contentEncoding='" + getContentEncoding() + "', contentLanguage='" + getContentLanguage() + "', contentType='" + getContentType() + "', expires=" + getExpires() + "'}";
    }
}
