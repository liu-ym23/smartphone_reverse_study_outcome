package com.volcengine.tos.model.object;

import B7.a;
import com.volcengine.tos.internal.TosResponse;
import io.modelcontextprotocol.spec.HttpHeaders;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Deprecated
/* loaded from: classes3.dex */
public class ObjectMeta {
    private String cacheControl;
    private String contentDisposition;
    private String contentEncoding;
    private String contentLanguage;
    private long contentLength;
    private String contentMD5;
    private String contentType;
    private String crc64;
    private String csType;
    private boolean deleteMarker;
    private String etags;
    private String expires;
    private String lastModified;
    private Map<String, String> metadata;
    private String mirrorTag;
    private String objectType;
    private String restore;
    private String sseCustomerAlgorithm;
    private String sseCustomerKeyMD5;
    private String storageClass;
    private String versionID;

    private Map<String, String> userMetadata(Map<String, String> map) {
        HashMap map2 = new HashMap();
        for (String str : map.keySet()) {
            if (str.startsWith("X-Tos-Meta-".toLowerCase())) {
                map2.put(str.substring(11), map.get(str));
            }
        }
        return map2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            ObjectMeta objectMeta = (ObjectMeta) obj;
            if (this.contentLength == objectMeta.contentLength && this.deleteMarker == objectMeta.deleteMarker && Objects.equals(this.contentType, objectMeta.contentType) && Objects.equals(this.contentMD5, objectMeta.contentMD5) && Objects.equals(this.contentLanguage, objectMeta.contentLanguage) && Objects.equals(this.contentEncoding, objectMeta.contentEncoding) && Objects.equals(this.contentDisposition, objectMeta.contentDisposition) && Objects.equals(this.lastModified, objectMeta.lastModified) && Objects.equals(this.cacheControl, objectMeta.cacheControl) && Objects.equals(this.expires, objectMeta.expires) && Objects.equals(this.etags, objectMeta.etags) && Objects.equals(this.versionID, objectMeta.versionID) && Objects.equals(this.objectType, objectMeta.objectType) && Objects.equals(this.storageClass, objectMeta.storageClass) && Objects.equals(this.restore, objectMeta.restore) && Objects.equals(this.metadata, objectMeta.metadata) && Objects.equals(this.mirrorTag, objectMeta.mirrorTag) && Objects.equals(this.sseCustomerAlgorithm, objectMeta.sseCustomerAlgorithm) && Objects.equals(this.sseCustomerKeyMD5, objectMeta.sseCustomerKeyMD5) && Objects.equals(this.csType, objectMeta.csType)) {
                return true;
            }
        }
        return false;
    }

    public ObjectMeta fromGetObjectV2Output(GetObjectBasicOutput getObjectBasicOutput) {
        if (getObjectBasicOutput == null) {
            return null;
        }
        this.contentLength = getObjectBasicOutput.getContentLength();
        this.contentType = getObjectBasicOutput.getContentType();
        this.contentMD5 = getObjectBasicOutput.getContentMD5();
        this.contentLanguage = getObjectBasicOutput.getContentLanguage();
        this.contentEncoding = getObjectBasicOutput.getContentEncoding();
        this.contentDisposition = getObjectBasicOutput.getContentDisposition();
        this.lastModified = getObjectBasicOutput.getLastModified();
        this.cacheControl = getObjectBasicOutput.getCacheControl();
        this.expires = getObjectBasicOutput.getExpires();
        this.etags = getObjectBasicOutput.getEtag();
        this.versionID = getObjectBasicOutput.getVersionID();
        this.deleteMarker = getObjectBasicOutput.isDeleteMarker();
        this.objectType = getObjectBasicOutput.getObjectType();
        this.storageClass = getObjectBasicOutput.getStorageClass().f4230a;
        this.metadata = getObjectBasicOutput.getCustomMetadata();
        this.sseCustomerAlgorithm = getObjectBasicOutput.getSsecAlgorithm();
        this.sseCustomerKeyMD5 = getObjectBasicOutput.getSsecKeyMD5();
        this.crc64 = getObjectBasicOutput.getHashCrc64ecma();
        return this;
    }

    public ObjectMeta fromResponse(TosResponse tosResponse) {
        this.contentLength = tosResponse.b;
        this.contentType = tosResponse.c(HttpHeaders.CONTENT_TYPE);
        this.contentMD5 = tosResponse.c("Content-MD5");
        this.contentLanguage = tosResponse.c("Content-Language");
        this.contentEncoding = tosResponse.c("Content-Encoding");
        this.contentDisposition = tosResponse.c("Content-Disposition");
        this.lastModified = tosResponse.c("Last-Modified");
        this.cacheControl = tosResponse.c(HttpHeaders.CACHE_CONTROL);
        this.expires = tosResponse.c("Expires");
        this.etags = tosResponse.c("ETag");
        this.versionID = tosResponse.c("X-Tos-Version-Id");
        this.deleteMarker = Boolean.parseBoolean(tosResponse.c("X-Tos-Delete-Marker"));
        this.objectType = tosResponse.c("X-Tos-Object-Type");
        this.storageClass = tosResponse.c("X-Tos-Storage-Class");
        this.restore = tosResponse.c("X-Tos-Restore");
        this.metadata = userMetadata(tosResponse.c);
        this.mirrorTag = tosResponse.c("X-Tos-Tag");
        this.sseCustomerAlgorithm = tosResponse.c("X-Tos-Server-Side-Encryption-Customer-Algorithm");
        this.sseCustomerKeyMD5 = tosResponse.c("X-Tos-Server-Side-Encryption-Customer-Key-MD5");
        this.csType = tosResponse.c("X-Tos-Cs-Type");
        this.crc64 = tosResponse.c("x-tos-hash-crc64ecma");
        return this;
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

    public String getContentType() {
        return this.contentType;
    }

    public String getCrc64() {
        return this.crc64;
    }

    public String getCsType() {
        return this.csType;
    }

    public String getEtags() {
        return this.etags;
    }

    public String getExpires() {
        return this.expires;
    }

    public String getLastModified() {
        return this.lastModified;
    }

    public Map<String, String> getMetadata() {
        return this.metadata;
    }

    public String getMirrorTag() {
        return this.mirrorTag;
    }

    public String getObjectType() {
        return this.objectType;
    }

    public String getRestore() {
        return this.restore;
    }

    public String getSseCustomerAlgorithm() {
        return this.sseCustomerAlgorithm;
    }

    public String getSseCustomerKeyMD5() {
        return this.sseCustomerKeyMD5;
    }

    public String getStorageClass() {
        return this.storageClass;
    }

    public String getVersionID() {
        return this.versionID;
    }

    public int hashCode() {
        return Objects.hash(Long.valueOf(this.contentLength), this.contentType, this.contentMD5, this.contentLanguage, this.contentEncoding, this.contentDisposition, this.lastModified, this.cacheControl, this.expires, this.etags, this.versionID, Boolean.valueOf(this.deleteMarker), this.objectType, this.storageClass, this.restore, this.metadata, this.mirrorTag, this.sseCustomerAlgorithm, this.sseCustomerKeyMD5, this.csType);
    }

    public boolean isDeleteMarker() {
        return this.deleteMarker;
    }

    public ObjectMeta setCacheControl(String str) {
        this.cacheControl = str;
        return this;
    }

    public ObjectMeta setContentDisposition(String str) {
        this.contentDisposition = str;
        return this;
    }

    public ObjectMeta setContentEncoding(String str) {
        this.contentEncoding = str;
        return this;
    }

    public ObjectMeta setContentLanguage(String str) {
        this.contentLanguage = str;
        return this;
    }

    public ObjectMeta setContentLength(long j5) {
        this.contentLength = j5;
        return this;
    }

    public ObjectMeta setContentMD5(String str) {
        this.contentMD5 = str;
        return this;
    }

    public ObjectMeta setContentType(String str) {
        this.contentType = str;
        return this;
    }

    public ObjectMeta setCrc64(String str) {
        this.crc64 = str;
        return this;
    }

    public ObjectMeta setCsType(String str) {
        this.csType = str;
        return this;
    }

    public ObjectMeta setDeleteMarker(boolean z10) {
        this.deleteMarker = z10;
        return this;
    }

    public ObjectMeta setEtags(String str) {
        this.etags = str;
        return this;
    }

    public ObjectMeta setExpires(String str) {
        this.expires = str;
        return this;
    }

    public ObjectMeta setLastModified(String str) {
        this.lastModified = str;
        return this;
    }

    public ObjectMeta setMetadata(Map<String, String> map) {
        this.metadata = map;
        return this;
    }

    public ObjectMeta setMirrorTag(String str) {
        this.mirrorTag = str;
        return this;
    }

    public ObjectMeta setObjectType(String str) {
        this.objectType = str;
        return this;
    }

    public ObjectMeta setRestore(String str) {
        this.restore = str;
        return this;
    }

    public ObjectMeta setSseCustomerAlgorithm(String str) {
        this.sseCustomerAlgorithm = str;
        return this;
    }

    public ObjectMeta setSseCustomerKeyMD5(String str) {
        this.sseCustomerKeyMD5 = str;
        return this;
    }

    public ObjectMeta setStorageClass(String str) {
        this.storageClass = str;
        return this;
    }

    public ObjectMeta setVersionID(String str) {
        this.versionID = str;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("ObjectMeta{contentLength=");
        sb.append(this.contentLength);
        sb.append(", contentType='");
        sb.append(this.contentType);
        sb.append("', contentMD5='");
        sb.append(this.contentMD5);
        sb.append("', contentLanguage='");
        sb.append(this.contentLanguage);
        sb.append("', contentEncoding='");
        sb.append(this.contentEncoding);
        sb.append("', contentDisposition='");
        sb.append(this.contentDisposition);
        sb.append("', lastModified='");
        sb.append(this.lastModified);
        sb.append("', cacheControl='");
        sb.append(this.cacheControl);
        sb.append("', expires='");
        sb.append(this.expires);
        sb.append("', etags='");
        sb.append(this.etags);
        sb.append("', versionID='");
        sb.append(this.versionID);
        sb.append("', deleteMarker=");
        sb.append(this.deleteMarker);
        sb.append(", objectType='");
        sb.append(this.objectType);
        sb.append("', storageClass='");
        sb.append(this.storageClass);
        sb.append("', restore='");
        sb.append(this.restore);
        sb.append("', metadata=");
        sb.append(this.metadata);
        sb.append(", mirrorTag='");
        sb.append(this.mirrorTag);
        sb.append("', sseCustomerAlgorithm='");
        sb.append(this.sseCustomerAlgorithm);
        sb.append("', sseCustomerKeyMD5='");
        sb.append(this.sseCustomerKeyMD5);
        sb.append("', csType='");
        sb.append(this.csType);
        sb.append("', crc64=");
        return a.g('}', this.crc64, sb);
    }
}
