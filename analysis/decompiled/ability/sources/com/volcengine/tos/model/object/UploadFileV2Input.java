package com.volcengine.tos.model.object;

import U6.a;
import Z6.j;

/* loaded from: classes3.dex */
public class UploadFileV2Input {
    private CancelHook cancelHook;
    private String checkpointFile;
    private CreateMultipartUploadInput createMultipartUploadInput = new CreateMultipartUploadInput();
    private a dataTransferListener;
    private boolean enableCheckpoint;
    private String filePath;
    private long partSize;
    private W6.a rateLimiter;
    private int taskNum;
    private long trafficLimit;
    private UploadEventListener uploadEventListener;

    public static final class UploadFileV2InputBuilder {
        private CancelHook cancelHook;
        private String checkpointFile;
        private CreateMultipartUploadInput createMultipartUploadInput;
        private a dataTransferListener;
        private boolean enableCheckpoint;
        private String filePath;
        private long partSize;
        private W6.a rateLimiter;
        private int taskNum;
        private long trafficLimit;
        private UploadEventListener uploadEventListener;

        public UploadFileV2InputBuilder bucket(String str) {
            this.createMultipartUploadInput.setBucket(str);
            return this;
        }

        public UploadFileV2Input build() {
            UploadFileV2Input uploadFileV2Input = new UploadFileV2Input();
            uploadFileV2Input.setCreateMultipartUploadInput(this.createMultipartUploadInput);
            uploadFileV2Input.setFilePath(this.filePath);
            uploadFileV2Input.setPartSize(this.partSize);
            uploadFileV2Input.setTaskNum(this.taskNum);
            uploadFileV2Input.setEnableCheckpoint(this.enableCheckpoint);
            uploadFileV2Input.setCheckpointFile(this.checkpointFile);
            uploadFileV2Input.setDataTransferListener(null);
            uploadFileV2Input.setUploadEventListener(this.uploadEventListener);
            uploadFileV2Input.cancelHook = this.cancelHook;
            uploadFileV2Input.setRateLimiter(null);
            uploadFileV2Input.setTrafficLimit(this.trafficLimit);
            return uploadFileV2Input;
        }

        public UploadFileV2InputBuilder cancelHook(boolean z10) {
            if (z10) {
                this.cancelHook = new j();
                return this;
            }
            this.cancelHook = null;
            return this;
        }

        public UploadFileV2InputBuilder checkpointFile(String str) {
            this.checkpointFile = str;
            return this;
        }

        @Deprecated
        public UploadFileV2InputBuilder createMultipartUploadInput(CreateMultipartUploadInput createMultipartUploadInput) {
            this.createMultipartUploadInput = createMultipartUploadInput;
            return this;
        }

        public UploadFileV2InputBuilder dataTransferListener(a aVar) {
            return this;
        }

        public UploadFileV2InputBuilder enableCheckpoint(boolean z10) {
            this.enableCheckpoint = z10;
            return this;
        }

        public UploadFileV2InputBuilder encodingType(String str) {
            this.createMultipartUploadInput.setEncodingType(str);
            return this;
        }

        public UploadFileV2InputBuilder filePath(String str) {
            this.filePath = str;
            return this;
        }

        public UploadFileV2InputBuilder key(String str) {
            this.createMultipartUploadInput.setKey(str);
            return this;
        }

        public UploadFileV2InputBuilder options(ObjectMetaRequestOptions objectMetaRequestOptions) {
            this.createMultipartUploadInput.setOptions(objectMetaRequestOptions);
            return this;
        }

        public UploadFileV2InputBuilder partSize(long j5) {
            this.partSize = j5;
            return this;
        }

        public UploadFileV2InputBuilder rateLimiter(W6.a aVar) {
            return this;
        }

        public UploadFileV2InputBuilder taskNum(int i) {
            this.taskNum = i;
            return this;
        }

        public UploadFileV2InputBuilder trafficLimit(long j5) {
            this.trafficLimit = j5;
            return this;
        }

        public UploadFileV2InputBuilder uploadEventListener(UploadEventListener uploadEventListener) {
            this.uploadEventListener = uploadEventListener;
            return this;
        }

        private UploadFileV2InputBuilder() {
            this.createMultipartUploadInput = new CreateMultipartUploadInput();
        }
    }

    public static UploadFileV2InputBuilder builder() {
        return new UploadFileV2InputBuilder();
    }

    public String getBucket() {
        return this.createMultipartUploadInput.getBucket();
    }

    public CancelHook getCancelHook() {
        return this.cancelHook;
    }

    public String getCheckpointFile() {
        return this.checkpointFile;
    }

    @Deprecated
    public CreateMultipartUploadInput getCreateMultipartUploadInput() {
        return this.createMultipartUploadInput;
    }

    public a getDataTransferListener() {
        return null;
    }

    public String getEncodingType() {
        return this.createMultipartUploadInput.getEncodingType();
    }

    public String getFilePath() {
        return this.filePath;
    }

    public String getKey() {
        return this.createMultipartUploadInput.getKey();
    }

    public ObjectMetaRequestOptions getOptions() {
        return this.createMultipartUploadInput.getOptions();
    }

    public long getPartSize() {
        return this.partSize;
    }

    public W6.a getRateLimiter() {
        return null;
    }

    public int getTaskNum() {
        return this.taskNum;
    }

    public long getTrafficLimit() {
        return this.trafficLimit;
    }

    public UploadEventListener getUploadEventListener() {
        return this.uploadEventListener;
    }

    public boolean isEnableCheckpoint() {
        return this.enableCheckpoint;
    }

    public UploadFileV2Input setBucket(String str) {
        this.createMultipartUploadInput.setBucket(str);
        return this;
    }

    public UploadFileV2Input setCancelHook(boolean z10) {
        if (z10) {
            this.cancelHook = new j();
            return this;
        }
        this.cancelHook = null;
        return this;
    }

    public UploadFileV2Input setCheckpointFile(String str) {
        this.checkpointFile = str;
        return this;
    }

    @Deprecated
    public UploadFileV2Input setCreateMultipartUploadInput(CreateMultipartUploadInput createMultipartUploadInput) {
        this.createMultipartUploadInput = createMultipartUploadInput;
        return this;
    }

    public UploadFileV2Input setDataTransferListener(a aVar) {
        return this;
    }

    public UploadFileV2Input setEnableCheckpoint(boolean z10) {
        this.enableCheckpoint = z10;
        return this;
    }

    public UploadFileV2Input setEncodingType(String str) {
        this.createMultipartUploadInput.setEncodingType(str);
        return this;
    }

    public UploadFileV2Input setFilePath(String str) {
        this.filePath = str;
        return this;
    }

    public UploadFileV2Input setKey(String str) {
        this.createMultipartUploadInput.setKey(str);
        return this;
    }

    public UploadFileV2Input setOptions(ObjectMetaRequestOptions objectMetaRequestOptions) {
        this.createMultipartUploadInput.setOptions(objectMetaRequestOptions);
        return this;
    }

    public UploadFileV2Input setPartSize(long j5) {
        this.partSize = j5;
        return this;
    }

    public UploadFileV2Input setRateLimiter(W6.a aVar) {
        return this;
    }

    public UploadFileV2Input setTaskNum(int i) {
        this.taskNum = i;
        return this;
    }

    public UploadFileV2Input setTrafficLimit(long j5) {
        this.trafficLimit = j5;
        return this;
    }

    public UploadFileV2Input setUploadEventListener(UploadEventListener uploadEventListener) {
        this.uploadEventListener = uploadEventListener;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("UploadFileV2Input{bucket='");
        sb.append(getBucket());
        sb.append("', key='");
        sb.append(getKey());
        sb.append("', encodingType='");
        sb.append(getEncodingType());
        sb.append("', options=");
        sb.append(getOptions());
        sb.append(", filePath='");
        sb.append(this.filePath);
        sb.append("', partSize=");
        sb.append(this.partSize);
        sb.append(", taskNum=");
        sb.append(this.taskNum);
        sb.append(", enableCheckpoint=");
        sb.append(this.enableCheckpoint);
        sb.append(", checkpointFile='");
        sb.append(this.checkpointFile);
        sb.append("', trafficLimit=");
        return B7.a.p(sb, this.trafficLimit, '}');
    }
}
