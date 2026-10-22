package com.volcengine.tos.model.object;

import U6.a;
import a.AbstractC0291a;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public class GetObjectV2Input {
    private String bucket;
    private a dataTransferListener;
    private String key;
    private ObjectMetaRequestOptions options;
    private String process;
    private String range;
    private W6.a rateLimiter;
    private String responseCacheControl;
    private String responseContentDisposition;
    private String responseContentEncoding;
    private String responseContentLanguage;
    private String responseContentType;
    private Date responseExpires;
    private String versionID;

    public static final class GetObjectV2InputBuilder {
        private String bucket;
        private a dataTransferListener;
        private String key;
        private ObjectMetaRequestOptions options;
        private String process;
        private String range;
        private W6.a rateLimiter;
        private String responseCacheControl;
        private String responseContentDisposition;
        private String responseContentEncoding;
        private String responseContentLanguage;
        private String responseContentType;
        private Date responseExpires;
        private String versionID;

        public GetObjectV2InputBuilder bucket(String str) {
            this.bucket = str;
            return this;
        }

        public GetObjectV2Input build() {
            GetObjectV2Input getObjectV2Input = new GetObjectV2Input();
            getObjectV2Input.bucket = this.bucket;
            getObjectV2Input.key = this.key;
            getObjectV2Input.range = this.range;
            GetObjectV2Input.access$402(getObjectV2Input, null);
            getObjectV2Input.versionID = this.versionID;
            getObjectV2Input.options = this.options;
            getObjectV2Input.responseCacheControl = this.responseCacheControl;
            getObjectV2Input.responseContentDisposition = this.responseContentDisposition;
            getObjectV2Input.responseContentType = this.responseContentType;
            getObjectV2Input.responseContentEncoding = this.responseContentEncoding;
            getObjectV2Input.responseContentLanguage = this.responseContentLanguage;
            getObjectV2Input.responseExpires = this.responseExpires;
            GetObjectV2Input.access$1302(getObjectV2Input, null);
            getObjectV2Input.process = this.process;
            return getObjectV2Input;
        }

        public GetObjectV2InputBuilder dataTransferListener(a aVar) {
            return this;
        }

        public GetObjectV2InputBuilder key(String str) {
            this.key = str;
            return this;
        }

        public GetObjectV2InputBuilder options(ObjectMetaRequestOptions objectMetaRequestOptions) {
            this.options = objectMetaRequestOptions;
            return this;
        }

        public GetObjectV2InputBuilder process(String str) {
            this.process = str;
            return this;
        }

        public GetObjectV2InputBuilder range(String str) {
            this.range = str;
            return this;
        }

        public GetObjectV2InputBuilder rateLimiter(W6.a aVar) {
            return this;
        }

        public GetObjectV2InputBuilder responseCacheControl(String str) {
            this.responseCacheControl = str;
            return this;
        }

        public GetObjectV2InputBuilder responseContentDisposition(String str) {
            this.responseContentDisposition = str;
            return this;
        }

        public GetObjectV2InputBuilder responseContentEncoding(String str) {
            this.responseContentEncoding = str;
            return this;
        }

        public GetObjectV2InputBuilder responseContentLanguage(String str) {
            this.responseContentLanguage = str;
            return this;
        }

        public GetObjectV2InputBuilder responseContentType(String str) {
            this.responseContentType = str;
            return this;
        }

        public GetObjectV2InputBuilder responseExpires(Date date) {
            this.responseExpires = date;
            return this;
        }

        public GetObjectV2InputBuilder versionID(String str) {
            this.versionID = str;
            return this;
        }

        private GetObjectV2InputBuilder() {
        }
    }

    public static /* synthetic */ W6.a access$1302(GetObjectV2Input getObjectV2Input, W6.a aVar) {
        getObjectV2Input.getClass();
        return aVar;
    }

    public static /* synthetic */ a access$402(GetObjectV2Input getObjectV2Input, a aVar) {
        getObjectV2Input.getClass();
        return aVar;
    }

    public static GetObjectV2InputBuilder builder() {
        return new GetObjectV2InputBuilder();
    }

    public Map<String, String> getAllSettedHeaders() {
        ObjectMetaRequestOptions objectMetaRequestOptions = this.options;
        HashMap map = new HashMap(objectMetaRequestOptions == null ? Collections.EMPTY_MAP : objectMetaRequestOptions.headers());
        if (AbstractC0291a.y(this.range)) {
            map.put("Range", this.range);
        }
        return map;
    }

    public String getBucket() {
        return this.bucket;
    }

    public a getDataTransferListener() {
        return null;
    }

    public String getKey() {
        return this.key;
    }

    public ObjectMetaRequestOptions getOptions() {
        return this.options;
    }

    public String getProcess() {
        return this.process;
    }

    public String getRange() {
        return this.range;
    }

    public W6.a getRateLimiter() {
        return null;
    }

    public String getResponseCacheControl() {
        return this.responseCacheControl;
    }

    public String getResponseContentDisposition() {
        return this.responseContentDisposition;
    }

    public String getResponseContentEncoding() {
        return this.responseContentEncoding;
    }

    public String getResponseContentLanguage() {
        return this.responseContentLanguage;
    }

    public String getResponseContentType() {
        return this.responseContentType;
    }

    public Date getResponseExpires() {
        return this.responseExpires;
    }

    public String getVersionID() {
        return this.versionID;
    }

    public GetObjectV2Input setBucket(String str) {
        this.bucket = str;
        return this;
    }

    public GetObjectV2Input setDataTransferListener(a aVar) {
        return this;
    }

    public GetObjectV2Input setKey(String str) {
        this.key = str;
        return this;
    }

    public GetObjectV2Input setOptions(ObjectMetaRequestOptions objectMetaRequestOptions) {
        this.options = objectMetaRequestOptions;
        return this;
    }

    public GetObjectV2Input setProcess(String str) {
        this.process = str;
        return this;
    }

    public GetObjectV2Input setRange(String str) {
        this.range = str;
        return this;
    }

    public GetObjectV2Input setRateLimiter(W6.a aVar) {
        return this;
    }

    public GetObjectV2Input setResponseCacheControl(String str) {
        this.responseCacheControl = str;
        return this;
    }

    public GetObjectV2Input setResponseContentDisposition(String str) {
        this.responseContentDisposition = str;
        return this;
    }

    public GetObjectV2Input setResponseContentEncoding(String str) {
        this.responseContentEncoding = str;
        return this;
    }

    public GetObjectV2Input setResponseContentLanguage(String str) {
        this.responseContentLanguage = str;
        return this;
    }

    public GetObjectV2Input setResponseContentType(String str) {
        this.responseContentType = str;
        return this;
    }

    public GetObjectV2Input setResponseExpires(Date date) {
        this.responseExpires = date;
        return this;
    }

    public GetObjectV2Input setVersionID(String str) {
        this.versionID = str;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("GetObjectV2Input{bucket='");
        sb.append(this.bucket);
        sb.append("', key='");
        sb.append(this.key);
        sb.append("', versionID='");
        sb.append(this.versionID);
        sb.append("', range='");
        sb.append(this.range);
        sb.append("', options=");
        sb.append(this.options);
        sb.append(", responseCacheControl='");
        sb.append(this.responseCacheControl);
        sb.append("', responseContentDisposition='");
        sb.append(this.responseContentDisposition);
        sb.append("', responseContentEncoding='");
        sb.append(this.responseContentEncoding);
        sb.append("', responseContentLanguage='");
        sb.append(this.responseContentLanguage);
        sb.append("', responseContentType='");
        sb.append(this.responseContentType);
        sb.append("', responseExpires=");
        sb.append(this.responseExpires);
        sb.append(", dataTransferListener=null, rateLimiter=null, process='");
        return B7.a.q(sb, this.process, "'}");
    }
}
