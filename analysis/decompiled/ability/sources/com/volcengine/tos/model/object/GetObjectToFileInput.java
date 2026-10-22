package com.volcengine.tos.model.object;

import U6.a;
import java.io.File;
import java.util.Date;

/* loaded from: classes3.dex */
public class GetObjectToFileInput {
    private File file;
    private String filePath;
    private GetObjectV2Input getObjectInputV2;

    public static final class GetObjectToFileInputBuilder {
        private File file;
        private String filePath;
        private GetObjectV2Input getObjectInputV2;

        public GetObjectToFileInputBuilder bucket(String str) {
            this.getObjectInputV2.setBucket(str);
            return this;
        }

        public GetObjectToFileInput build() {
            GetObjectToFileInput getObjectToFileInput = new GetObjectToFileInput(this.getObjectInputV2, this.filePath);
            getObjectToFileInput.setFile(this.file);
            return getObjectToFileInput;
        }

        public GetObjectToFileInputBuilder dataTransferListener(a aVar) {
            this.getObjectInputV2.setDataTransferListener(aVar);
            return this;
        }

        public GetObjectToFileInputBuilder file(File file) {
            this.file = file;
            return this;
        }

        public GetObjectToFileInputBuilder filePath(String str) {
            this.filePath = str;
            return this;
        }

        @Deprecated
        public GetObjectToFileInputBuilder getObjectInputV2(GetObjectV2Input getObjectV2Input) {
            this.getObjectInputV2 = getObjectV2Input;
            return this;
        }

        public GetObjectToFileInputBuilder key(String str) {
            this.getObjectInputV2.setKey(str);
            return this;
        }

        public GetObjectToFileInputBuilder options(ObjectMetaRequestOptions objectMetaRequestOptions) {
            this.getObjectInputV2.setOptions(objectMetaRequestOptions);
            return this;
        }

        public GetObjectToFileInputBuilder rateLimiter(W6.a aVar) {
            this.getObjectInputV2.setRateLimiter(aVar);
            return this;
        }

        public GetObjectToFileInputBuilder responseCacheControl(String str) {
            this.getObjectInputV2.setResponseCacheControl(str);
            return this;
        }

        public GetObjectToFileInputBuilder responseContentDisposition(String str) {
            this.getObjectInputV2.setResponseContentDisposition(str);
            return this;
        }

        public GetObjectToFileInputBuilder responseContentEncoding(String str) {
            this.getObjectInputV2.setResponseContentEncoding(str);
            return this;
        }

        public GetObjectToFileInputBuilder responseContentLanguage(String str) {
            this.getObjectInputV2.setResponseContentLanguage(str);
            return this;
        }

        public GetObjectToFileInputBuilder responseContentType(String str) {
            this.getObjectInputV2.setResponseContentType(str);
            return this;
        }

        public GetObjectToFileInputBuilder responseExpires(Date date) {
            this.getObjectInputV2.setResponseExpires(date);
            return this;
        }

        public GetObjectToFileInputBuilder versionID(String str) {
            this.getObjectInputV2.setVersionID(str);
            return this;
        }

        private GetObjectToFileInputBuilder() {
            this.getObjectInputV2 = new GetObjectV2Input();
        }
    }

    public GetObjectToFileInput() {
        this.getObjectInputV2 = new GetObjectV2Input();
    }

    public static GetObjectToFileInputBuilder builder() {
        return new GetObjectToFileInputBuilder();
    }

    public String getBucket() {
        return this.getObjectInputV2.getBucket();
    }

    public a getDataTransferListener() {
        this.getObjectInputV2.getDataTransferListener();
        return null;
    }

    public File getFile() {
        return this.file;
    }

    public String getFilePath() {
        return this.filePath;
    }

    @Deprecated
    public GetObjectV2Input getGetObjectInputV2() {
        return this.getObjectInputV2;
    }

    public String getKey() {
        return this.getObjectInputV2.getKey();
    }

    public ObjectMetaRequestOptions getOptions() {
        return this.getObjectInputV2.getOptions();
    }

    public W6.a getRateLimiter() {
        this.getObjectInputV2.getRateLimiter();
        return null;
    }

    public String getResponseCacheControl() {
        return this.getObjectInputV2.getResponseCacheControl();
    }

    public String getResponseContentDisposition() {
        return this.getObjectInputV2.getResponseContentDisposition();
    }

    public String getResponseContentEncoding() {
        return this.getObjectInputV2.getResponseContentEncoding();
    }

    public String getResponseContentLanguage() {
        return this.getObjectInputV2.getResponseContentLanguage();
    }

    public String getResponseContentType() {
        return this.getObjectInputV2.getResponseContentType();
    }

    public Date getResponseExpires() {
        return this.getObjectInputV2.getResponseExpires();
    }

    public String getVersionID() {
        return this.getObjectInputV2.getVersionID();
    }

    public GetObjectToFileInput setBucket(String str) {
        this.getObjectInputV2.setBucket(str);
        return this;
    }

    public GetObjectToFileInput setDataTransferListener(a aVar) {
        this.getObjectInputV2.setDataTransferListener(aVar);
        return this;
    }

    public GetObjectToFileInput setFile(File file) {
        this.file = file;
        return this;
    }

    public GetObjectToFileInput setFilePath(String str) {
        this.filePath = str;
        return this;
    }

    @Deprecated
    public GetObjectToFileInput setGetObjectInputV2(GetObjectV2Input getObjectV2Input) {
        this.getObjectInputV2 = getObjectV2Input;
        return this;
    }

    public GetObjectToFileInput setKey(String str) {
        this.getObjectInputV2.setKey(str);
        return this;
    }

    public GetObjectToFileInput setOptions(ObjectMetaRequestOptions objectMetaRequestOptions) {
        this.getObjectInputV2.setOptions(objectMetaRequestOptions);
        return this;
    }

    public GetObjectToFileInput setRateLimiter(W6.a aVar) {
        this.getObjectInputV2.setRateLimiter(aVar);
        return this;
    }

    public GetObjectToFileInput setResponseCacheControl(String str) {
        this.getObjectInputV2.setResponseCacheControl(str);
        return this;
    }

    public GetObjectToFileInput setResponseContentDisposition(String str) {
        this.getObjectInputV2.setResponseContentDisposition(str);
        return this;
    }

    public GetObjectToFileInput setResponseContentEncoding(String str) {
        this.getObjectInputV2.setResponseContentEncoding(str);
        return this;
    }

    public GetObjectToFileInput setResponseContentLanguage(String str) {
        this.getObjectInputV2.setResponseContentLanguage(str);
        return this;
    }

    public GetObjectToFileInput setResponseContentType(String str) {
        this.getObjectInputV2.setResponseContentType(str);
        return this;
    }

    public GetObjectToFileInput setResponseExpires(Date date) {
        this.getObjectInputV2.setResponseExpires(date);
        return this;
    }

    public GetObjectToFileInput setVersionID(String str) {
        this.getObjectInputV2.setVersionID(str);
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("GetObjectToFileInput{bucket='");
        sb.append(getBucket());
        sb.append("', key='");
        sb.append(getKey());
        sb.append("', versionID='");
        sb.append(getVersionID());
        sb.append("', options=");
        sb.append(getOptions());
        sb.append(", responseCacheControl='");
        sb.append(getResponseCacheControl());
        sb.append("', responseContentDisposition='");
        sb.append(getResponseContentDisposition());
        sb.append("', responseContentEncoding='");
        sb.append(getResponseContentEncoding());
        sb.append("', responseContentLanguage='");
        sb.append(getResponseContentLanguage());
        sb.append("', responseContentType='");
        sb.append(getResponseContentType());
        sb.append("', responseExpires=");
        sb.append(getResponseExpires());
        sb.append(", dataTransferListener=null, rateLimiter=null, filePath='");
        getDataTransferListener();
        getRateLimiter();
        return B7.a.q(sb, this.filePath, "'}");
    }

    @Deprecated
    public GetObjectToFileInput(GetObjectV2Input getObjectV2Input, String str) {
        new GetObjectV2Input();
        this.getObjectInputV2 = getObjectV2Input;
        this.filePath = str;
    }

    @Deprecated
    public GetObjectToFileInput(GetObjectV2Input getObjectV2Input, File file) {
        new GetObjectV2Input();
        this.getObjectInputV2 = getObjectV2Input;
        this.file = file;
    }
}
