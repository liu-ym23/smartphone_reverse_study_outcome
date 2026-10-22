package com.volcengine.tos.model.object;

import U6.a;
import java.io.File;
import java.io.FileInputStream;

/* loaded from: classes3.dex */
public class PutObjectFromFileInput {
    private File file;
    private FileInputStream fileInputStream;
    private String filePath;
    private PutObjectBasicInput putObjectBasicInput;

    public static final class PutObjectFromFileInputBuilder {
        private File file;
        private FileInputStream fileInputStream;
        private String filePath;
        private PutObjectBasicInput putObjectBasicInput;

        public PutObjectFromFileInputBuilder bucket(String str) {
            this.putObjectBasicInput.setBucket(str);
            return this;
        }

        public PutObjectFromFileInput build() {
            PutObjectFromFileInput putObjectFromFileInput = new PutObjectFromFileInput();
            putObjectFromFileInput.setPutObjectBasicInput(this.putObjectBasicInput);
            putObjectFromFileInput.setFilePath(this.filePath);
            putObjectFromFileInput.setFile(this.file);
            putObjectFromFileInput.setFileInputStream(this.fileInputStream);
            return putObjectFromFileInput;
        }

        public PutObjectFromFileInputBuilder dataTransferListener(a aVar) {
            this.putObjectBasicInput.setDataTransferListener(aVar);
            return this;
        }

        public PutObjectFromFileInputBuilder file(File file) {
            this.file = file;
            return this;
        }

        public PutObjectFromFileInputBuilder fileInputStream(FileInputStream fileInputStream) {
            this.fileInputStream = fileInputStream;
            return this;
        }

        public PutObjectFromFileInputBuilder filePath(String str) {
            this.filePath = str;
            return this;
        }

        public PutObjectFromFileInputBuilder key(String str) {
            this.putObjectBasicInput.setKey(str);
            return this;
        }

        public PutObjectFromFileInputBuilder options(ObjectMetaRequestOptions objectMetaRequestOptions) {
            this.putObjectBasicInput.setOptions(objectMetaRequestOptions);
            return this;
        }

        @Deprecated
        public PutObjectFromFileInputBuilder putObjectBasicInput(PutObjectBasicInput putObjectBasicInput) {
            this.putObjectBasicInput = putObjectBasicInput;
            return this;
        }

        public PutObjectFromFileInputBuilder rateLimiter(W6.a aVar) {
            this.putObjectBasicInput.setRateLimiter(aVar);
            return this;
        }

        private PutObjectFromFileInputBuilder() {
            this.putObjectBasicInput = new PutObjectBasicInput();
        }
    }

    public PutObjectFromFileInput() {
        this.putObjectBasicInput = new PutObjectBasicInput();
    }

    public static PutObjectFromFileInputBuilder builder() {
        return new PutObjectFromFileInputBuilder();
    }

    public String getBucket() {
        return this.putObjectBasicInput.getBucket();
    }

    public a getDataTransferListener() {
        this.putObjectBasicInput.getDataTransferListener();
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
        return this.putObjectBasicInput.getKey();
    }

    public ObjectMetaRequestOptions getOptions() {
        return this.putObjectBasicInput.getOptions();
    }

    @Deprecated
    public PutObjectBasicInput getPutObjectBasicInput() {
        return this.putObjectBasicInput;
    }

    public W6.a getRateLimiter() {
        this.putObjectBasicInput.getRateLimiter();
        return null;
    }

    public PutObjectFromFileInput setBucket(String str) {
        this.putObjectBasicInput.setBucket(str);
        return this;
    }

    public PutObjectFromFileInput setDataTransferListener(a aVar) {
        this.putObjectBasicInput.setDataTransferListener(aVar);
        return this;
    }

    public PutObjectFromFileInput setFile(File file) {
        this.file = file;
        return this;
    }

    public PutObjectFromFileInput setFileInputStream(FileInputStream fileInputStream) {
        this.fileInputStream = fileInputStream;
        return this;
    }

    public PutObjectFromFileInput setFilePath(String str) {
        this.filePath = str;
        return this;
    }

    public PutObjectFromFileInput setKey(String str) {
        this.putObjectBasicInput.setKey(str);
        return this;
    }

    public PutObjectFromFileInput setOptions(ObjectMetaRequestOptions objectMetaRequestOptions) {
        this.putObjectBasicInput.setOptions(objectMetaRequestOptions);
        return this;
    }

    @Deprecated
    public PutObjectFromFileInput setPutObjectBasicInput(PutObjectBasicInput putObjectBasicInput) {
        this.putObjectBasicInput = putObjectBasicInput;
        return this;
    }

    public PutObjectFromFileInput setRateLimiter(W6.a aVar) {
        this.putObjectBasicInput.setRateLimiter(aVar);
        return this;
    }

    public String toString() {
        return "PutObjectFromFileInput{bucket='" + getBucket() + "', key='" + getKey() + "', options=" + getOptions() + ", filePath='" + this.filePath + "', file=" + this.file + '}';
    }

    @Deprecated
    public PutObjectFromFileInput(PutObjectBasicInput putObjectBasicInput, String str) {
        new PutObjectBasicInput();
        this.putObjectBasicInput = putObjectBasicInput;
        this.filePath = str;
    }

    @Deprecated
    public PutObjectFromFileInput(PutObjectBasicInput putObjectBasicInput, File file) {
        new PutObjectBasicInput();
        this.putObjectBasicInput = putObjectBasicInput;
        this.file = file;
    }

    @Deprecated
    public PutObjectFromFileInput(PutObjectBasicInput putObjectBasicInput, FileInputStream fileInputStream) {
        new PutObjectBasicInput();
        this.putObjectBasicInput = putObjectBasicInput;
        this.fileInputStream = fileInputStream;
    }
}
