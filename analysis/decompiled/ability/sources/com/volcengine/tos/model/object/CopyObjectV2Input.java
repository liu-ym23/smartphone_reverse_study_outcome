package com.volcengine.tos.model.object;

import X6.b;
import a.AbstractC0291a;
import a7.AbstractC0306b;
import com.volcengine.tos.TosClientException;
import com.volcengine.tos.comm.common.MetadataDirectiveType;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public class CopyObjectV2Input {
    private String bucket;
    private String copySourceIfMatch;
    private Date copySourceIfModifiedSince;
    private String copySourceIfNoneMatch;
    private Date copySourceIfUnmodifiedSince;
    private String copySourceSSECAlgorithm;
    private String copySourceSSECKey;
    private String copySourceSSECKeyMD5;
    private Map<String, String> headers;
    private String key;
    private MetadataDirectiveType metadataDirective;
    private ObjectMetaRequestOptions options;
    private String srcBucket;
    private String srcKey;
    private String srcVersionID;

    public static final class CopyObjectV2InputBuilder {
        private String bucket;
        private String copySourceIfMatch;
        private Date copySourceIfModifiedSince;
        private String copySourceIfNoneMatch;
        private Date copySourceIfUnmodifiedSince;
        private String copySourceSSECAlgorithm;
        private String copySourceSSECKey;
        private String copySourceSSECKeyMD5;
        private String key;
        private MetadataDirectiveType metadataDirective;
        private ObjectMetaRequestOptions options;
        private String srcBucket;
        private String srcKey;
        private String srcVersionID;

        public CopyObjectV2InputBuilder bucket(String str) {
            this.bucket = str;
            return this;
        }

        public CopyObjectV2Input build() {
            CopyObjectV2Input copyObjectV2Input = new CopyObjectV2Input();
            copyObjectV2Input.setBucket(this.bucket);
            copyObjectV2Input.setKey(this.key);
            copyObjectV2Input.setSrcBucket(this.srcBucket);
            copyObjectV2Input.setSrcKey(this.srcKey);
            copyObjectV2Input.setSrcVersionID(this.srcVersionID);
            copyObjectV2Input.setCopySourceIfMatch(this.copySourceIfMatch);
            copyObjectV2Input.setCopySourceIfModifiedSince(this.copySourceIfModifiedSince);
            copyObjectV2Input.setCopySourceIfNoneMatch(this.copySourceIfNoneMatch);
            copyObjectV2Input.setCopySourceIfUnmodifiedSince(this.copySourceIfUnmodifiedSince);
            copyObjectV2Input.setCopySourceSSECAlgorithm(this.copySourceSSECAlgorithm);
            copyObjectV2Input.setCopySourceSSECKey(this.copySourceSSECKey);
            copyObjectV2Input.setCopySourceSSECKeyMD5(this.copySourceSSECKeyMD5);
            copyObjectV2Input.setMetadataDirective(this.metadataDirective);
            copyObjectV2Input.setOptions(this.options);
            return copyObjectV2Input;
        }

        public CopyObjectV2InputBuilder copySourceIfMatch(String str) {
            this.copySourceIfMatch = str;
            return this;
        }

        public CopyObjectV2InputBuilder copySourceIfModifiedSince(Date date) {
            this.copySourceIfModifiedSince = date;
            return this;
        }

        public CopyObjectV2InputBuilder copySourceIfNoneMatch(String str) {
            this.copySourceIfNoneMatch = str;
            return this;
        }

        public CopyObjectV2InputBuilder copySourceIfUnmodifiedSince(Date date) {
            this.copySourceIfUnmodifiedSince = date;
            return this;
        }

        public CopyObjectV2InputBuilder copySourceSSECAlgorithm(String str) {
            this.copySourceSSECAlgorithm = str;
            return this;
        }

        public CopyObjectV2InputBuilder copySourceSSECKey(String str) {
            this.copySourceSSECKey = str;
            return this;
        }

        public CopyObjectV2InputBuilder copySourceSSECKeyMD5(String str) {
            this.copySourceSSECKeyMD5 = str;
            return this;
        }

        public CopyObjectV2InputBuilder key(String str) {
            this.key = str;
            return this;
        }

        public CopyObjectV2InputBuilder metadataDirective(MetadataDirectiveType metadataDirectiveType) {
            this.metadataDirective = metadataDirectiveType;
            return this;
        }

        public CopyObjectV2InputBuilder options(ObjectMetaRequestOptions objectMetaRequestOptions) {
            this.options = objectMetaRequestOptions;
            return this;
        }

        public CopyObjectV2InputBuilder srcBucket(String str) {
            this.srcBucket = str;
            return this;
        }

        public CopyObjectV2InputBuilder srcKey(String str) {
            this.srcKey = str;
            return this;
        }

        public CopyObjectV2InputBuilder srcVersionID(String str) {
            this.srcVersionID = str;
            return this;
        }

        private CopyObjectV2InputBuilder() {
        }
    }

    public static CopyObjectV2InputBuilder builder() {
        return new CopyObjectV2InputBuilder();
    }

    private void withHeader(String str, String str2) {
        if (this.headers == null) {
            this.headers = new HashMap();
        }
        if (str2 == null || str2.length() == 0) {
            return;
        }
        this.headers.put(str, str2);
    }

    public Map<String, String> getAllSettedHeaders() {
        withHeader("X-Tos-Copy-Source-If-Match", this.copySourceIfMatch);
        withHeader("X-Tos-Copy-Source-If-None-Match", this.copySourceIfNoneMatch);
        if (AbstractC0291a.y(this.copySourceSSECAlgorithm)) {
            if (!b.d.contains(this.copySourceSSECAlgorithm)) {
                throw new TosClientException("invalid copySourceSSECAlgorithm input, only support AES256", null);
            }
            withHeader("X-Tos-Server-Side-Encryption-Customer-Algorithm", this.copySourceSSECAlgorithm);
        }
        withHeader("x-tos-copy-source-server-side-encryption-customer-key", this.copySourceSSECKey);
        withHeader("x-tos-copy-source-server-side-encryption-customer-key-MD5", this.copySourceSSECKeyMD5);
        MetadataDirectiveType metadataDirectiveType = this.metadataDirective;
        withHeader("X-Tos-Metadata-Directive", metadataDirectiveType != null ? metadataDirectiveType.f4224a : null);
        Date date = this.copySourceIfModifiedSince;
        if (date != null) {
            withHeader(this.key, AbstractC0306b.a(date));
        }
        Date date2 = this.copySourceIfUnmodifiedSince;
        if (date2 != null) {
            withHeader(this.key, AbstractC0306b.a(date2));
        }
        ObjectMetaRequestOptions objectMetaRequestOptions = this.options;
        if (objectMetaRequestOptions != null) {
            this.headers.putAll(objectMetaRequestOptions.headers());
        }
        return this.headers;
    }

    public String getBucket() {
        return this.bucket;
    }

    public String getCopySourceIfMatch() {
        return this.copySourceIfMatch;
    }

    public Date getCopySourceIfModifiedSince() {
        return this.copySourceIfModifiedSince;
    }

    public String getCopySourceIfNoneMatch() {
        return this.copySourceIfNoneMatch;
    }

    public Date getCopySourceIfUnmodifiedSince() {
        return this.copySourceIfUnmodifiedSince;
    }

    public String getCopySourceSSECAlgorithm() {
        return this.copySourceSSECAlgorithm;
    }

    public String getCopySourceSSECKey() {
        return this.copySourceSSECKey;
    }

    public String getCopySourceSSECKeyMD5() {
        return this.copySourceSSECKeyMD5;
    }

    public String getKey() {
        return this.key;
    }

    public MetadataDirectiveType getMetadataDirective() {
        return this.metadataDirective;
    }

    public ObjectMetaRequestOptions getOptions() {
        return this.options;
    }

    public String getSrcBucket() {
        return this.srcBucket;
    }

    public String getSrcKey() {
        return this.srcKey;
    }

    public String getSrcVersionID() {
        return this.srcVersionID;
    }

    public CopyObjectV2Input setBucket(String str) {
        this.bucket = str;
        return this;
    }

    public CopyObjectV2Input setCopySourceIfMatch(String str) {
        this.copySourceIfMatch = str;
        return this;
    }

    public CopyObjectV2Input setCopySourceIfModifiedSince(Date date) {
        this.copySourceIfModifiedSince = date;
        return this;
    }

    public CopyObjectV2Input setCopySourceIfNoneMatch(String str) {
        this.copySourceIfNoneMatch = str;
        return this;
    }

    public CopyObjectV2Input setCopySourceIfUnmodifiedSince(Date date) {
        this.copySourceIfUnmodifiedSince = date;
        return this;
    }

    public CopyObjectV2Input setCopySourceSSECAlgorithm(String str) {
        this.copySourceSSECAlgorithm = str;
        return this;
    }

    public CopyObjectV2Input setCopySourceSSECKey(String str) {
        this.copySourceSSECKey = str;
        return this;
    }

    public CopyObjectV2Input setCopySourceSSECKeyMD5(String str) {
        this.copySourceSSECKeyMD5 = str;
        return this;
    }

    public CopyObjectV2Input setKey(String str) {
        this.key = str;
        return this;
    }

    public CopyObjectV2Input setMetadataDirective(MetadataDirectiveType metadataDirectiveType) {
        this.metadataDirective = metadataDirectiveType;
        return this;
    }

    public CopyObjectV2Input setOptions(ObjectMetaRequestOptions objectMetaRequestOptions) {
        this.options = objectMetaRequestOptions;
        return this;
    }

    public CopyObjectV2Input setSrcBucket(String str) {
        this.srcBucket = str;
        return this;
    }

    public CopyObjectV2Input setSrcKey(String str) {
        this.srcKey = str;
        return this;
    }

    public CopyObjectV2Input setSrcVersionID(String str) {
        this.srcVersionID = str;
        return this;
    }

    public String toString() {
        return "CopyObjectV2Input{bucket='" + this.bucket + "', key='" + this.key + "', srcBucket='" + this.srcBucket + "', srcKey='" + this.srcKey + "', srcVersionID='" + this.srcVersionID + "', copySourceIfMatch='" + this.copySourceIfMatch + "', copySourceIfModifiedSince=" + this.copySourceIfModifiedSince + ", copySourceIfNoneMatch='" + this.copySourceIfNoneMatch + "', copySourceIfUnmodifiedSince=" + this.copySourceIfUnmodifiedSince + ", copySourceSSECAlgorithm='" + this.copySourceSSECAlgorithm + "', copySourceSSECKey='" + this.copySourceSSECKey + "', copySourceSSECKeyMD5='" + this.copySourceSSECKeyMD5 + "', metadataDirective=" + this.metadataDirective + ", options=" + this.options + '}';
    }
}
