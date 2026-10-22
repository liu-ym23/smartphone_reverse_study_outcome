package com.volcengine.tos.model.object;

import X6.b;
import Y6.c;
import a.AbstractC0291a;
import a7.AbstractC0306b;
import com.volcengine.tos.TosClientException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public class UploadPartCopyV2Input {
    private String bucket;
    private String copySourceIfMatch;
    private Date copySourceIfModifiedSinceDate;
    private String copySourceIfNoneMatch;
    private Date copySourceIfUnmodifiedSinceDate;
    private c copySourceRange;
    private String copySourceRangeString;
    private String copySourceSSECAlgorithm;
    private String copySourceSSECKey;
    private String copySourceSSECKeyMD5;
    private Map<String, String> headers;
    private String key;
    private ObjectMetaRequestOptions options;
    private int partNumber;
    private String sourceBucket;
    private String sourceKey;
    private String sourceVersionID;
    private String uploadID;

    public static final class UploadPartCopyV2InputBuilder {
        private String bucket;
        private String copySourceIfMatch;
        private Date copySourceIfModifiedSinceDate;
        private String copySourceIfNoneMatch;
        private Date copySourceIfUnmodifiedSinceDate;
        private String copySourceSSECAlgorithm;
        private String copySourceSSECKey;
        private String copySourceSSECKeyMD5;
        private String key;
        private ObjectMetaRequestOptions options;
        private int partNumber;
        private c range;
        private String sourceBucket;
        private String sourceKey;
        private String sourceVersionID;
        private String uploadID;

        public UploadPartCopyV2InputBuilder bucket(String str) {
            this.bucket = str;
            return this;
        }

        public UploadPartCopyV2Input build() {
            UploadPartCopyV2Input uploadPartCopyV2Input = new UploadPartCopyV2Input();
            uploadPartCopyV2Input.setBucket(this.bucket);
            uploadPartCopyV2Input.setKey(this.key);
            uploadPartCopyV2Input.setUploadID(this.uploadID);
            uploadPartCopyV2Input.setPartNumber(this.partNumber);
            uploadPartCopyV2Input.setSourceBucket(this.sourceBucket);
            uploadPartCopyV2Input.setSourceKey(this.sourceKey);
            uploadPartCopyV2Input.setSourceVersionID(this.sourceVersionID);
            uploadPartCopyV2Input.setCopySourceIfMatch(this.copySourceIfMatch);
            uploadPartCopyV2Input.setCopySourceIfModifiedSinceDate(this.copySourceIfModifiedSinceDate);
            uploadPartCopyV2Input.setCopySourceIfNoneMatch(this.copySourceIfNoneMatch);
            uploadPartCopyV2Input.setCopySourceIfUnmodifiedSinceDate(this.copySourceIfUnmodifiedSinceDate);
            uploadPartCopyV2Input.setCopySourceSSECAlgorithm(this.copySourceSSECAlgorithm);
            uploadPartCopyV2Input.setCopySourceSSECKey(this.copySourceSSECKey);
            uploadPartCopyV2Input.setCopySourceSSECKeyMD5(this.copySourceSSECKeyMD5);
            c cVar = this.range;
            if (cVar != null) {
                uploadPartCopyV2Input.copySourceRange = cVar;
            }
            uploadPartCopyV2Input.setOptions(this.options);
            return uploadPartCopyV2Input;
        }

        public UploadPartCopyV2InputBuilder copySourceIfMatch(String str) {
            this.copySourceIfMatch = str;
            return this;
        }

        public UploadPartCopyV2InputBuilder copySourceIfModifiedSinceDate(Date date) {
            this.copySourceIfModifiedSinceDate = date;
            return this;
        }

        public UploadPartCopyV2InputBuilder copySourceIfNoneMatch(String str) {
            this.copySourceIfNoneMatch = str;
            return this;
        }

        public UploadPartCopyV2InputBuilder copySourceIfUnmodifiedSinceDate(Date date) {
            this.copySourceIfUnmodifiedSinceDate = date;
            return this;
        }

        public UploadPartCopyV2InputBuilder copySourceRange(long j5, long j6) {
            c cVar = new c();
            cVar.f1567a = j5;
            cVar.b = j6;
            this.range = cVar;
            return this;
        }

        public UploadPartCopyV2InputBuilder copySourceSSECAlgorithm(String str) {
            this.copySourceSSECAlgorithm = str;
            return this;
        }

        public UploadPartCopyV2InputBuilder copySourceSSECKey(String str) {
            this.copySourceSSECKey = str;
            return this;
        }

        public UploadPartCopyV2InputBuilder copySourceSSECKeyMD5(String str) {
            this.copySourceSSECKeyMD5 = str;
            return this;
        }

        public UploadPartCopyV2InputBuilder key(String str) {
            this.key = str;
            return this;
        }

        public UploadPartCopyV2InputBuilder options(ObjectMetaRequestOptions objectMetaRequestOptions) {
            this.options = objectMetaRequestOptions;
            return this;
        }

        public UploadPartCopyV2InputBuilder partNumber(int i) {
            this.partNumber = i;
            return this;
        }

        public UploadPartCopyV2InputBuilder sourceBucket(String str) {
            this.sourceBucket = str;
            return this;
        }

        public UploadPartCopyV2InputBuilder sourceKey(String str) {
            this.sourceKey = str;
            return this;
        }

        public UploadPartCopyV2InputBuilder sourceVersionID(String str) {
            this.sourceVersionID = str;
            return this;
        }

        public UploadPartCopyV2InputBuilder uploadID(String str) {
            this.uploadID = str;
            return this;
        }

        private UploadPartCopyV2InputBuilder() {
        }
    }

    public static UploadPartCopyV2InputBuilder builder() {
        return new UploadPartCopyV2InputBuilder();
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
        c cVar = this.copySourceRange;
        if (cVar != null) {
            withHeader("X-Tos-Copy-Source-Range", cVar.toString());
        }
        if (AbstractC0291a.y(this.copySourceRangeString)) {
            withHeader("X-Tos-Copy-Source-Range", this.copySourceRangeString);
        }
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
        Date date = this.copySourceIfModifiedSinceDate;
        if (date != null) {
            withHeader(this.key, AbstractC0306b.a(date));
        }
        Date date2 = this.copySourceIfUnmodifiedSinceDate;
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

    public Date getCopySourceIfModifiedSinceDate() {
        return this.copySourceIfModifiedSinceDate;
    }

    public String getCopySourceIfNoneMatch() {
        return this.copySourceIfNoneMatch;
    }

    public Date getCopySourceIfUnmodifiedSinceDate() {
        return this.copySourceIfUnmodifiedSinceDate;
    }

    public long getCopySourceRangeEnd() {
        c cVar = this.copySourceRange;
        if (cVar == null) {
            return 0L;
        }
        return cVar.b;
    }

    public long getCopySourceRangeStart() {
        c cVar = this.copySourceRange;
        if (cVar == null) {
            return 0L;
        }
        return cVar.f1567a;
    }

    public String getCopySourceRangeString() {
        return this.copySourceRangeString;
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

    public ObjectMetaRequestOptions getOptions() {
        return this.options;
    }

    public int getPartNumber() {
        return this.partNumber;
    }

    public String getSourceBucket() {
        return this.sourceBucket;
    }

    public String getSourceKey() {
        return this.sourceKey;
    }

    public String getSourceVersionID() {
        return this.sourceVersionID;
    }

    public String getUploadID() {
        return this.uploadID;
    }

    public UploadPartCopyV2Input setBucket(String str) {
        this.bucket = str;
        return this;
    }

    public UploadPartCopyV2Input setCopySourceIfMatch(String str) {
        this.copySourceIfMatch = str;
        return this;
    }

    public UploadPartCopyV2Input setCopySourceIfModifiedSinceDate(Date date) {
        this.copySourceIfModifiedSinceDate = date;
        return this;
    }

    public UploadPartCopyV2Input setCopySourceIfNoneMatch(String str) {
        this.copySourceIfNoneMatch = str;
        return this;
    }

    public UploadPartCopyV2Input setCopySourceIfUnmodifiedSinceDate(Date date) {
        this.copySourceIfUnmodifiedSinceDate = date;
        return this;
    }

    public UploadPartCopyV2Input setCopySourceRange(long j5, long j6) {
        c cVar = new c();
        cVar.f1567a = j5;
        cVar.b = j6;
        this.copySourceRange = cVar;
        return this;
    }

    public UploadPartCopyV2Input setCopySourceRangeString(String str) {
        this.copySourceRangeString = str;
        return this;
    }

    public UploadPartCopyV2Input setCopySourceSSECAlgorithm(String str) {
        this.copySourceSSECAlgorithm = str;
        return this;
    }

    public UploadPartCopyV2Input setCopySourceSSECKey(String str) {
        this.copySourceSSECKey = str;
        return this;
    }

    public UploadPartCopyV2Input setCopySourceSSECKeyMD5(String str) {
        this.copySourceSSECKeyMD5 = str;
        return this;
    }

    public UploadPartCopyV2Input setKey(String str) {
        this.key = str;
        return this;
    }

    public UploadPartCopyV2Input setOptions(ObjectMetaRequestOptions objectMetaRequestOptions) {
        this.options = objectMetaRequestOptions;
        return this;
    }

    public UploadPartCopyV2Input setPartNumber(int i) {
        this.partNumber = i;
        return this;
    }

    public UploadPartCopyV2Input setSourceBucket(String str) {
        this.sourceBucket = str;
        return this;
    }

    public UploadPartCopyV2Input setSourceKey(String str) {
        this.sourceKey = str;
        return this;
    }

    public UploadPartCopyV2Input setSourceVersionID(String str) {
        this.sourceVersionID = str;
        return this;
    }

    public UploadPartCopyV2Input setUploadID(String str) {
        this.uploadID = str;
        return this;
    }

    public String toString() {
        return "UploadPartCopyV2Input{bucket='" + this.bucket + "', key='" + this.key + "', uploadID='" + this.uploadID + "', partNumber=" + this.partNumber + ", sourceBucket='" + this.sourceBucket + "', sourceKey='" + this.sourceKey + "', sourceVersionID='" + this.sourceVersionID + "', copySourceRange=" + this.copySourceRange + ", copySourceIfMatch='" + this.copySourceIfMatch + "', copySourceIfModifiedSinceDate=" + this.copySourceIfModifiedSinceDate + ", copySourceIfNoneMatch='" + this.copySourceIfNoneMatch + "', copySourceIfUnmodifiedSinceDate=" + this.copySourceIfUnmodifiedSinceDate + ", copySourceSSECAlgorithm='" + this.copySourceSSECAlgorithm + "', copySourceSSECKey='" + this.copySourceSSECKey + "', copySourceSSECKeyMD5='" + this.copySourceSSECKeyMD5 + "', options=" + this.options + '}';
    }
}
