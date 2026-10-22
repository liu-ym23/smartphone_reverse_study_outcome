package com.volcengine.tos.model.object;

import B7.a;
import X6.b;
import Y6.c;
import a.AbstractC0291a;
import a7.AbstractC0306b;
import ca.AbstractC0897f;
import com.volcengine.tos.TosClientException;
import com.volcengine.tos.comm.common.ACLType;
import com.volcengine.tos.comm.common.StorageClassType;
import io.modelcontextprotocol.spec.HttpHeaders;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public class ObjectMetaRequestOptions {
    private ACLType aclType;
    private String cacheControl;
    private String contentDisposition;
    private String contentEncoding;
    private String contentLanguage;
    private long contentLength;
    private String contentMD5;
    private String contentType;
    private Map<String, String> customMetadata;
    private Date expires;
    private String grantFullControl;
    private String grantRead;
    private String grantReadAcp;
    private String grantWrite;
    private String grantWriteAcp;
    private Map<String, String> headers = new HashMap();
    private String ifMatch;
    private Date ifModifiedSince;
    private String ifNoneMatch;
    private Date ifUnmodifiedSince;
    private long rangeEnd;
    private long rangeStart;
    private String serverSideEncryption;
    private String ssecAlgorithm;
    private String ssecKey;
    private String ssecKeyMD5;
    private StorageClassType storageClass;
    private long trafficLimit;
    private String websiteRedirectLocation;

    public static final class ObjectMetaRequestOptionsBuilder {
        private Map<String, String> customMetaData;
        private Date expires;
        private Map<String, String> headers;
        private Date ifModifiedSince;
        private Date ifUnmodifiedSince;

        private void withHeader(String str, String str2) {
            if (AbstractC0291a.x(str) || AbstractC0291a.x(str2)) {
                return;
            }
            this.headers.put(str, str2);
        }

        private void withTimeHeader(String str, Date date) {
            if (date == null) {
                return;
            }
            withHeader(str, AbstractC0306b.a(date));
        }

        public ObjectMetaRequestOptionsBuilder aclType(ACLType aCLType) {
            withHeader("X-Tos-Acl", aCLType == null ? null : aCLType.f4219a);
            return this;
        }

        public ObjectMetaRequestOptions build() {
            withTimeHeader("Expires", this.expires);
            withTimeHeader("If-Modified-Since", this.ifModifiedSince);
            withTimeHeader("If-Unmodified-Since", this.ifUnmodifiedSince);
            ObjectMetaRequestOptions objectMetaRequestOptions = new ObjectMetaRequestOptions();
            objectMetaRequestOptions.headers = this.headers;
            objectMetaRequestOptions.customMetadata = this.customMetaData;
            return objectMetaRequestOptions;
        }

        public ObjectMetaRequestOptionsBuilder cacheControl(String str) {
            withHeader(HttpHeaders.CACHE_CONTROL, str);
            return this;
        }

        public ObjectMetaRequestOptionsBuilder contentDisposition(String str) {
            withHeader("Content-Disposition", str);
            return this;
        }

        public ObjectMetaRequestOptionsBuilder contentEncoding(String str) {
            withHeader("Content-Encoding", str);
            return this;
        }

        public ObjectMetaRequestOptionsBuilder contentLanguage(String str) {
            withHeader("Content-Language", str);
            return this;
        }

        public ObjectMetaRequestOptionsBuilder contentLength(long j5) {
            withHeader(HttpHeaders.CONTENT_LENGTH, String.valueOf(j5));
            return this;
        }

        public ObjectMetaRequestOptionsBuilder contentMD5(String str) {
            withHeader("Content-MD5", str);
            return this;
        }

        public ObjectMetaRequestOptionsBuilder contentType(String str) {
            withHeader(HttpHeaders.CONTENT_TYPE, str);
            return this;
        }

        public ObjectMetaRequestOptionsBuilder customMetadata(Map<String, String> map) {
            this.customMetaData = map;
            return this;
        }

        public ObjectMetaRequestOptionsBuilder expires(Date date) {
            this.expires = date;
            return this;
        }

        public ObjectMetaRequestOptionsBuilder grantFullControl(String str) {
            withHeader("X-Tos-Grant-Full-Control", str);
            return this;
        }

        public ObjectMetaRequestOptionsBuilder grantRead(String str) {
            withHeader("X-Tos-Grant-Read", str);
            return this;
        }

        public ObjectMetaRequestOptionsBuilder grantReadAcp(String str) {
            withHeader("X-Tos-Grant-Read-Acp", str);
            return this;
        }

        public ObjectMetaRequestOptionsBuilder grantWrite(String str) {
            withHeader("X-Tos-Grant-Write", str);
            return this;
        }

        public ObjectMetaRequestOptionsBuilder grantWriteAcp(String str) {
            withHeader("X-Tos-Grant-Write-Acp", str);
            return this;
        }

        public ObjectMetaRequestOptionsBuilder ifMatch(String str) {
            withHeader("If-Match", str);
            return this;
        }

        public ObjectMetaRequestOptionsBuilder ifModifiedSince(Date date) {
            this.ifModifiedSince = date;
            return this;
        }

        public ObjectMetaRequestOptionsBuilder ifNoneMatch(String str) {
            withHeader("If-None-Match", str);
            return this;
        }

        public ObjectMetaRequestOptionsBuilder ifUnmodifiedSince(Date date) {
            this.ifUnmodifiedSince = date;
            return this;
        }

        public ObjectMetaRequestOptionsBuilder range(long j5, long j6) {
            c cVar = new c();
            cVar.f1567a = j5;
            cVar.b = j6;
            withHeader("Range", cVar.toString());
            return this;
        }

        public ObjectMetaRequestOptionsBuilder serverSideEncryption(String str) {
            if (!AbstractC0291a.y(str) || !b.d.contains(str)) {
                throw new TosClientException("invalid serverSideEncryption input, only support AES256", null);
            }
            withHeader("x-tos-server-side-encryption", str);
            return this;
        }

        public ObjectMetaRequestOptionsBuilder ssecAlgorithm(String str) {
            if (!AbstractC0291a.y(str) || !b.d.contains(str)) {
                throw new TosClientException("invalid encryption-decryption algorithm", null);
            }
            withHeader("X-Tos-Server-Side-Encryption-Customer-Algorithm", str);
            return this;
        }

        public ObjectMetaRequestOptionsBuilder ssecKey(String str) {
            withHeader("X-Tos-Server-Side-Encryption-Customer-Key", str);
            return this;
        }

        public ObjectMetaRequestOptionsBuilder ssecKeyMD5(String str) {
            withHeader("X-Tos-Server-Side-Encryption-Customer-Key-MD5", str);
            return this;
        }

        public ObjectMetaRequestOptionsBuilder storageClass(StorageClassType storageClassType) {
            withHeader("X-Tos-Storage-Class", storageClassType == null ? null : storageClassType.f4230a);
            return this;
        }

        public ObjectMetaRequestOptionsBuilder trafficLimit(long j5) {
            withHeader("x-tos-traffic-limit", String.valueOf(j5));
            return this;
        }

        public ObjectMetaRequestOptionsBuilder websiteRedirectLocation(String str) {
            withHeader("X-Tos-Website-Redirect-Location", str);
            return this;
        }

        private ObjectMetaRequestOptionsBuilder() {
            this.headers = new HashMap();
        }
    }

    public static ObjectMetaRequestOptionsBuilder builder() {
        return new ObjectMetaRequestOptionsBuilder();
    }

    private void withHeader(String str, String str2) {
        if (AbstractC0291a.x(str) || AbstractC0291a.x(str2)) {
            return;
        }
        this.headers.put(str, str2);
    }

    public ACLType getAclType() {
        return AbstractC0897f.s(this.headers.get("X-Tos-Acl"));
    }

    public String getCacheControl() {
        return this.headers.get(HttpHeaders.CACHE_CONTROL);
    }

    public String getContentDisposition() {
        return this.headers.get("Content-Disposition");
    }

    public String getContentEncoding() {
        return this.headers.get("Content-Encoding");
    }

    public String getContentLanguage() {
        return this.headers.get("Content-Language");
    }

    public long getContentLength() {
        String str = this.headers.get(HttpHeaders.CONTENT_LENGTH);
        if (AbstractC0291a.x(str)) {
            return 0L;
        }
        return Long.parseLong(str);
    }

    public String getContentMD5() {
        return this.headers.get("Content-MD5");
    }

    public String getContentType() {
        return this.headers.get(HttpHeaders.CONTENT_TYPE);
    }

    public Map<String, String> getCustomMetadata() {
        return this.customMetadata;
    }

    public Date getExpires() {
        return AbstractC0306b.b(this.headers.get("Expires"));
    }

    public String getGrantFullControl() {
        return this.headers.get("X-Tos-Grant-Full-Control");
    }

    public String getGrantRead() {
        return this.headers.get("X-Tos-Grant-Read");
    }

    public String getGrantReadAcp() {
        return this.headers.get("X-Tos-Grant-Read-Acp");
    }

    public String getGrantWrite() {
        return this.headers.get("X-Tos-Grant-Write");
    }

    public String getGrantWriteAcp() {
        return this.headers.get("X-Tos-Grant-Write-Acp");
    }

    public Map<String, String> getHeaders() {
        return this.headers;
    }

    public String getIfMatch() {
        return this.headers.get("If-Match");
    }

    public Date getIfModifiedSince() {
        return AbstractC0306b.b(this.headers.get("If-Modified-Since"));
    }

    public String getIfNoneMatch() {
        return this.headers.get("If-None-Match");
    }

    public Date getIfUnmodifiedSince() {
        return AbstractC0306b.b(this.headers.get("If-Unmodified-Since"));
    }

    public String getRange() {
        return this.headers.get("Range");
    }

    public String getServerSideEncryption() {
        return this.headers.get("x-tos-server-side-encryption");
    }

    public String getSsecAlgorithm() {
        return this.headers.get("X-Tos-Server-Side-Encryption-Customer-Algorithm");
    }

    public String getSsecKey() {
        return this.headers.get("X-Tos-Server-Side-Encryption-Customer-Key");
    }

    public String getSsecKeyMD5() {
        return this.headers.get("X-Tos-Server-Side-Encryption-Customer-Key-MD5");
    }

    public StorageClassType getStorageClass() {
        return AbstractC0897f.u(this.headers.get("X-Tos-Storage-Class"));
    }

    public long getTrafficLimit() {
        String str = this.headers.get("x-tos-traffic-limit");
        if (AbstractC0291a.x(str)) {
            return 0L;
        }
        return Long.parseLong(str);
    }

    public String getWebsiteRedirectLocation() {
        return this.headers.get("X-Tos-Website-Redirect-Location");
    }

    public Map<String, String> headers() {
        Map<String, String> map = this.customMetadata;
        if (map != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();
                if (AbstractC0291a.y(value)) {
                    this.headers.put("X-Tos-Meta-" + key, value);
                }
            }
        }
        return this.headers;
    }

    public ObjectMetaRequestOptions setAclType(ACLType aCLType) {
        withHeader("X-Tos-Acl", aCLType == null ? null : aCLType.f4219a);
        return this;
    }

    public ObjectMetaRequestOptions setCacheControl(String str) {
        withHeader(HttpHeaders.CACHE_CONTROL, str);
        return this;
    }

    public ObjectMetaRequestOptions setContentDisposition(String str) {
        withHeader("Content-Disposition", str);
        return this;
    }

    public ObjectMetaRequestOptions setContentEncoding(String str) {
        withHeader("Content-Encoding", str);
        return this;
    }

    public ObjectMetaRequestOptions setContentLanguage(String str) {
        withHeader("Content-Language", str);
        return this;
    }

    public ObjectMetaRequestOptions setContentLength(long j5) {
        withHeader(HttpHeaders.CONTENT_LENGTH, String.valueOf(j5));
        return this;
    }

    public ObjectMetaRequestOptions setContentMD5(String str) {
        withHeader("Content-MD5", str);
        return this;
    }

    public ObjectMetaRequestOptions setContentType(String str) {
        withHeader(HttpHeaders.CONTENT_TYPE, str);
        return this;
    }

    public ObjectMetaRequestOptions setCustomMetadata(Map<String, String> map) {
        this.customMetadata = map;
        return this;
    }

    public ObjectMetaRequestOptions setExpires(Date date) {
        if (date == null) {
            return this;
        }
        withHeader("Expires", AbstractC0306b.a(date));
        return this;
    }

    public ObjectMetaRequestOptions setGrantFullControl(String str) {
        withHeader("X-Tos-Grant-Full-Control", str);
        return this;
    }

    public ObjectMetaRequestOptions setGrantRead(String str) {
        withHeader("X-Tos-Grant-Read", str);
        return this;
    }

    public ObjectMetaRequestOptions setGrantReadAcp(String str) {
        withHeader("X-Tos-Grant-Read-Acp", str);
        return this;
    }

    public ObjectMetaRequestOptions setGrantWrite(String str) {
        withHeader("X-Tos-Grant-Write", str);
        return this;
    }

    public ObjectMetaRequestOptions setGrantWriteAcp(String str) {
        withHeader("X-Tos-Grant-Write-Acp", str);
        return this;
    }

    public ObjectMetaRequestOptions setHeaders(Map<String, String> map) {
        this.headers = map;
        return this;
    }

    public ObjectMetaRequestOptions setIfMatch(String str) {
        withHeader("If-Match", str);
        return this;
    }

    public ObjectMetaRequestOptions setIfModifiedSince(Date date) {
        if (date == null) {
            return this;
        }
        withHeader("If-Modified-Since", AbstractC0306b.a(date));
        return this;
    }

    public ObjectMetaRequestOptions setIfNoneMatch(String str) {
        withHeader("If-None-Match", str);
        return this;
    }

    public ObjectMetaRequestOptions setIfUnmodifiedSince(Date date) {
        if (date == null) {
            return this;
        }
        withHeader("If-Unmodified-Since", AbstractC0306b.a(date));
        return this;
    }

    public ObjectMetaRequestOptions setRange(long j5, long j6) {
        c cVar = new c();
        cVar.f1567a = j5;
        cVar.b = j6;
        withHeader("Range", cVar.toString());
        return this;
    }

    public ObjectMetaRequestOptions setServerSideEncryption(String str) {
        if (!AbstractC0291a.y(str) || !b.d.contains(str)) {
            throw new TosClientException("invalid serverSideEncryption input, only support AES256", null);
        }
        withHeader("x-tos-server-side-encryption", str);
        return this;
    }

    public ObjectMetaRequestOptions setSsecAlgorithm(String str) {
        if (!AbstractC0291a.y(str) || !b.d.contains(str)) {
            throw new TosClientException("invalid encryption-decryption algorithm", null);
        }
        withHeader("X-Tos-Server-Side-Encryption-Customer-Algorithm", str);
        return this;
    }

    public ObjectMetaRequestOptions setSsecKey(String str) {
        withHeader("X-Tos-Server-Side-Encryption-Customer-Key", str);
        return this;
    }

    public ObjectMetaRequestOptions setSsecKeyMD5(String str) {
        withHeader("X-Tos-Server-Side-Encryption-Customer-Key-MD5", str);
        return this;
    }

    public ObjectMetaRequestOptions setStorageClass(StorageClassType storageClassType) {
        withHeader("X-Tos-Storage-Class", storageClassType == null ? null : storageClassType.f4230a);
        return this;
    }

    public ObjectMetaRequestOptions setTrafficLimit(long j5) {
        withHeader("x-tos-traffic-limit", String.valueOf(j5));
        return this;
    }

    public ObjectMetaRequestOptions setWebsiteRedirectLocation(String str) {
        withHeader("X-Tos-Website-Redirect-Location", str);
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("ObjectMetaRequestOptions{cacheControl='");
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
        sb.append(this.expires);
        sb.append(", ifMatch='");
        sb.append(this.ifMatch);
        sb.append("', ifModifiedSince=");
        sb.append(this.ifModifiedSince);
        sb.append(", ifNoneMatch='");
        sb.append(this.ifNoneMatch);
        sb.append("', ifUnmodifiedSince=");
        sb.append(this.ifUnmodifiedSince);
        sb.append(", contentLength=");
        sb.append(this.contentLength);
        sb.append(", contentMD5='");
        sb.append(this.contentMD5);
        sb.append("', rangeStart=");
        sb.append(this.rangeStart);
        sb.append(", rangeEnd=");
        sb.append(this.rangeEnd);
        sb.append(", customMetadata=");
        sb.append(this.customMetadata);
        sb.append(", aclType=");
        sb.append(this.aclType);
        sb.append(", grantFullControl='");
        sb.append(this.grantFullControl);
        sb.append("', grantRead='");
        sb.append(this.grantRead);
        sb.append("', grantReadAcp='");
        sb.append(this.grantReadAcp);
        sb.append("', grantWrite='");
        sb.append(this.grantWrite);
        sb.append("', grantWriteAcp='");
        sb.append(this.grantWriteAcp);
        sb.append("', ssecAlgorithm='");
        sb.append(this.ssecAlgorithm);
        sb.append("', ssecKey='");
        sb.append(this.ssecKey);
        sb.append("', ssecKeyMD5='");
        sb.append(this.ssecKeyMD5);
        sb.append("', serverSideEncryption='");
        sb.append(this.serverSideEncryption);
        sb.append("', websiteRedirectLocation='");
        sb.append(this.websiteRedirectLocation);
        sb.append("', storageClass=");
        sb.append(this.storageClass);
        sb.append(", trafficLimit=");
        return a.p(sb, this.trafficLimit, '}');
    }
}
