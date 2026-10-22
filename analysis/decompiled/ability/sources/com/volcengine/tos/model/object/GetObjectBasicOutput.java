package com.volcengine.tos.model.object;

import B7.a;
import a7.AbstractC0306b;
import ca.AbstractC0897f;
import com.volcengine.tos.comm.common.StorageClassType;
import com.volcengine.tos.internal.TosResponse;
import com.volcengine.tos.model.RequestInfo;
import io.modelcontextprotocol.spec.HttpHeaders;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes3.dex */
public class GetObjectBasicOutput {
    private String cacheControl;
    private String contentDisposition;
    private String contentEncoding;
    private String contentLanguage;
    private long contentLength;
    private String contentMD5;
    private String contentRange;
    private String contentType;
    private Map<String, String> customMetadata;
    private boolean deleteMarker;
    private String etag;
    private String expires;
    private String hashCrc64ecma;
    private String lastModified;
    private String objectType;
    private RequestInfo requestInfo;
    private String ssecAlgorithm;
    private String ssecKeyMD5;
    private String storageClass;
    private String versionID;
    private String websiteRedirectLocation;

    private Map<String, String> parseCustomMetadata(Map<String, String> map) {
        HashMap map2 = null;
        if (map == null) {
            return null;
        }
        Iterator<Map.Entry<String, String>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            String key = it.next().getKey();
            if (key.startsWith("X-Tos-Meta-".toLowerCase())) {
                if (map2 == null) {
                    map2 = new HashMap();
                }
                map2.put(key.substring(11), map.get(key));
            }
        }
        return map2;
    }

    public String getCacheControl() {
        return this.cacheControl;
    }

    public String getContentDisposition() {
        return this.contentDisposition;
    }

    public String getContentEncoding() {
        return this.contentEncoding;
    }

    public String getContentLanguage() {
        return this.contentLanguage;
    }

    public long getContentLength() {
        return this.contentLength;
    }

    public String getContentMD5() {
        return this.contentMD5;
    }

    public String getContentRange() {
        return this.contentRange;
    }

    public String getContentType() {
        return this.contentType;
    }

    public Map<String, String> getCustomMetadata() {
        return this.customMetadata;
    }

    public String getEtag() {
        return this.etag;
    }

    public String getExpires() {
        return this.expires;
    }

    public Date getExpiresInDate() {
        return AbstractC0306b.b(this.expires);
    }

    public String getHashCrc64ecma() {
        return this.hashCrc64ecma;
    }

    public String getLastModified() {
        return this.lastModified;
    }

    public Date getLastModifiedInDate() {
        return AbstractC0306b.b(this.lastModified);
    }

    public String getObjectType() {
        return this.objectType;
    }

    public RequestInfo getRequestInfo() {
        return this.requestInfo;
    }

    public String getSsecAlgorithm() {
        return this.ssecAlgorithm;
    }

    public String getSsecKeyMD5() {
        return this.ssecKeyMD5;
    }

    public StorageClassType getStorageClass() {
        return AbstractC0897f.u(this.storageClass);
    }

    public String getVersionID() {
        return this.versionID;
    }

    public String getWebsiteRedirectLocation() {
        return this.websiteRedirectLocation;
    }

    public boolean isDeleteMarker() {
        return this.deleteMarker;
    }

    public GetObjectBasicOutput parseFromTosResponse(TosResponse tosResponse) {
        this.contentLength = tosResponse.b;
        this.contentType = tosResponse.c(HttpHeaders.CONTENT_TYPE);
        this.contentMD5 = tosResponse.c("Content-MD5");
        this.contentLanguage = tosResponse.c("Content-Language");
        this.contentEncoding = tosResponse.c("Content-Encoding");
        this.contentDisposition = tosResponse.c("Content-Disposition");
        this.lastModified = tosResponse.c("Last-Modified");
        this.cacheControl = tosResponse.c(HttpHeaders.CACHE_CONTROL);
        this.expires = tosResponse.c("Expires");
        this.etag = tosResponse.c("ETag");
        this.versionID = tosResponse.c("X-Tos-Version-Id");
        this.deleteMarker = Boolean.parseBoolean(tosResponse.c("X-Tos-Delete-Marker"));
        this.objectType = tosResponse.c("X-Tos-Object-Type");
        this.storageClass = tosResponse.c("X-Tos-Storage-Class");
        this.customMetadata = parseCustomMetadata(tosResponse.c);
        this.ssecAlgorithm = tosResponse.c("X-Tos-Server-Side-Encryption-Customer-Algorithm");
        this.ssecKeyMD5 = tosResponse.c("X-Tos-Server-Side-Encryption-Customer-Key-MD5");
        this.websiteRedirectLocation = tosResponse.c("X-Tos-Website-Redirect-Location");
        this.hashCrc64ecma = tosResponse.c("x-tos-hash-crc64ecma");
        this.storageClass = tosResponse.c("X-Tos-Storage-Class");
        this.contentRange = tosResponse.c("Content-Range");
        return this;
    }

    public GetObjectBasicOutput setRequestInfo(RequestInfo requestInfo) {
        this.requestInfo = requestInfo;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("GetObjectBasicOutput{requestInfo=");
        sb.append(this.requestInfo);
        sb.append(", contentRange='");
        sb.append(this.contentRange);
        sb.append("', etag='");
        sb.append(this.etag);
        sb.append("', lastModified=");
        sb.append(this.lastModified);
        sb.append(", deleteMarker=");
        sb.append(this.deleteMarker);
        sb.append(", ssecAlgorithm='");
        sb.append(this.ssecAlgorithm);
        sb.append("', ssecKeyMD5='");
        sb.append(this.ssecKeyMD5);
        sb.append("', versionID='");
        sb.append(this.versionID);
        sb.append("', websiteRedirectLocation='");
        sb.append(this.websiteRedirectLocation);
        sb.append("', objectType='");
        sb.append(this.objectType);
        sb.append("', hashCrc64ecma=");
        sb.append(this.hashCrc64ecma);
        sb.append(", storageClass=");
        sb.append(this.storageClass);
        sb.append(", metadata=");
        sb.append(this.customMetadata);
        sb.append(", cacheControl='");
        sb.append(this.cacheControl);
        sb.append("', contentDisposition='");
        sb.append(this.contentDisposition);
        sb.append("', contentEncoding='");
        sb.append(this.contentEncoding);
        sb.append("', contentLanguage='");
        sb.append(this.contentLanguage);
        sb.append("', contentType='");
        sb.append(this.contentType);
        sb.append("', expires=");
        return a.q(sb, this.expires, "'}");
    }
}
