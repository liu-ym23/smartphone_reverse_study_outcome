package com.volcengine.tos.model.object;

import U6.a;
import java.io.File;
import java.io.FileInputStream;

/* loaded from: classes3.dex */
public class UploadPartFromFileInput {
    private File file;
    private FileInputStream fileInputStream;
    private String filePath;
    private long offset;
    private long partSize;
    private UploadPartBasicInput uploadPartBasicInput = new UploadPartBasicInput();

    public static final class UploadPartFromFileInputBuilder {
        private File file;
        private FileInputStream fileInputStream;
        private String filePath;
        private long offset;
        private long partSize;
        private UploadPartBasicInput uploadPartBasicInput;

        public UploadPartFromFileInputBuilder bucket(String str) {
            this.uploadPartBasicInput.setBucket(str);
            return this;
        }

        public UploadPartFromFileInput build() {
            UploadPartFromFileInput uploadPartFromFileInput = new UploadPartFromFileInput();
            uploadPartFromFileInput.filePath = this.filePath;
            uploadPartFromFileInput.file = this.file;
            uploadPartFromFileInput.fileInputStream = this.fileInputStream;
            uploadPartFromFileInput.uploadPartBasicInput = this.uploadPartBasicInput;
            uploadPartFromFileInput.offset = this.offset;
            uploadPartFromFileInput.partSize = this.partSize;
            return uploadPartFromFileInput;
        }

        public UploadPartFromFileInputBuilder dataTransferListener(a aVar) {
            this.uploadPartBasicInput.setDataTransferListener(aVar);
            return this;
        }

        public UploadPartFromFileInputBuilder file(File file) {
            this.file = file;
            return this;
        }

        public UploadPartFromFileInputBuilder fileInputStream(FileInputStream fileInputStream) {
            this.fileInputStream = fileInputStream;
            return this;
        }

        public UploadPartFromFileInputBuilder filePath(String str) {
            this.filePath = str;
            return this;
        }

        public UploadPartFromFileInputBuilder key(String str) {
            this.uploadPartBasicInput.setKey(str);
            return this;
        }

        public UploadPartFromFileInputBuilder offset(long j5) {
            this.offset = j5;
            return this;
        }

        public UploadPartFromFileInputBuilder options(ObjectMetaRequestOptions objectMetaRequestOptions) {
            this.uploadPartBasicInput.setOptions(objectMetaRequestOptions);
            return this;
        }

        public UploadPartFromFileInputBuilder partNumber(int i) {
            this.uploadPartBasicInput.setPartNumber(i);
            return this;
        }

        public UploadPartFromFileInputBuilder partSize(long j5) {
            this.partSize = j5;
            return this;
        }

        public UploadPartFromFileInputBuilder rateLimiter(W6.a aVar) {
            this.uploadPartBasicInput.setRateLimiter(aVar);
            return this;
        }

        public UploadPartFromFileInputBuilder uploadID(String str) {
            this.uploadPartBasicInput.setUploadID(str);
            return this;
        }

        @Deprecated
        public UploadPartFromFileInputBuilder uploadPartBasicInput(UploadPartBasicInput uploadPartBasicInput) {
            this.uploadPartBasicInput = uploadPartBasicInput;
            return this;
        }

        private UploadPartFromFileInputBuilder() {
            this.uploadPartBasicInput = new UploadPartBasicInput();
        }
    }

    public static UploadPartFromFileInputBuilder builder() {
        return new UploadPartFromFileInputBuilder();
    }

    public String getBucket() {
        return this.uploadPartBasicInput.getBucket();
    }

    public a getDataTransferListener() {
        this.uploadPartBasicInput.getDataTransferListener();
        return null;
    }

    public File getFile() {
        return this.file;
    }

    public FileInputStream getFileInputStream() {
        return this.fileInputStream;
    }

    public String getFilePath() {
        return this.filePath;
    }

    public String getKey() {
        return this.uploadPartBasicInput.getKey();
    }

    public long getOffset() {
        return this.offset;
    }

    public ObjectMetaRequestOptions getOptions() {
        return this.uploadPartBasicInput.getOptions();
    }

    public int getPartNumber() {
        return this.uploadPartBasicInput.getPartNumber();
    }

    public long getPartSize() {
        return this.partSize;
    }

    public W6.a getRateLimiter() {
        this.uploadPartBasicInput.getRateLimiter();
        return null;
    }

    public String getUploadID() {
        return this.uploadPartBasicInput.getUploadID();
    }

    @Deprecated
    public UploadPartBasicInput getUploadPartBasicInput() {
        return this.uploadPartBasicInput;
    }

    public UploadPartFromFileInput setBucket(String str) {
        this.uploadPartBasicInput.setBucket(str);
        return this;
    }

    public UploadPartFromFileInput setDataTransferListener(a aVar) {
        this.uploadPartBasicInput.setDataTransferListener(aVar);
        return this;
    }

    public UploadPartFromFileInput setFile(File file) {
        this.file = file;
        return this;
    }

    public UploadPartFromFileInput setFileInputStream(FileInputStream fileInputStream) {
        this.fileInputStream = fileInputStream;
        return this;
    }

    public UploadPartFromFileInput setFilePath(String str) {
        this.filePath = str;
        return this;
    }

    public UploadPartFromFileInput setKey(String str) {
        this.uploadPartBasicInput.setKey(str);
        return this;
    }

    public UploadPartFromFileInput setOffset(long j5) {
        this.offset = j5;
        return this;
    }

    public UploadPartFromFileInput setOptions(ObjectMetaRequestOptions objectMetaRequestOptions) {
        this.uploadPartBasicInput.setOptions(objectMetaRequestOptions);
        return this;
    }

    public UploadPartFromFileInput setPartNumber(int i) {
        this.uploadPartBasicInput.setPartNumber(i);
        return this;
    }

    public UploadPartFromFileInput setPartSize(long j5) {
        this.partSize = j5;
        return this;
    }

    public UploadPartFromFileInput setRateLimiter(W6.a aVar) {
        this.uploadPartBasicInput.setRateLimiter(aVar);
        return this;
    }

    public UploadPartFromFileInput setUploadID(String str) {
        this.uploadPartBasicInput.setUploadID(str);
        return this;
    }

    @Deprecated
    public UploadPartFromFileInput setUploadPartBasicInput(UploadPartBasicInput uploadPartBasicInput) {
        this.uploadPartBasicInput = uploadPartBasicInput;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("UploadPartFromFileInput{bucket='");
        sb.append(getBucket());
        sb.append("', key='");
        sb.append(getKey());
        sb.append("', uploadID='");
        sb.append(getUploadID());
        sb.append("', partNumber=");
        sb.append(getPartNumber());
        sb.append(", options=");
        sb.append(getOptions());
        sb.append(", dataTransferListener=null, rateLimit=null, filePath='");
        getDataTransferListener();
        getRateLimiter();
        sb.append(this.filePath);
        sb.append("', offset=");
        sb.append(this.offset);
        sb.append(", partSize=");
        return B7.a.p(sb, this.partSize, '}');
    }
}
