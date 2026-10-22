package com.volcengine.tos.model.object;

import U6.a;
import Z6.d;

/* loaded from: classes3.dex */
public class DownloadFileInput {
    private CancelHook cancelHook;
    private String checkpointFile;
    private a dataTransferListener;
    private DownloadEventListener downloadEventListener;
    private boolean enableCheckpoint;
    private String filePath;
    private HeadObjectV2Input headObjectV2Input = new HeadObjectV2Input();
    private long partSize;
    private W6.a rateLimiter;
    private int taskNum;
    private String tempFilePath;
    private long trafficLimit;

    public static final class DownloadFileInputBuilder {
        private CancelHook cancelHook;
        private String checkpointFile;
        private a dataTransferListener;
        private DownloadEventListener downloadEventListener;
        private boolean enableCheckpoint;
        private String filePath;
        private HeadObjectV2Input headObjectV2Input;
        private long partSize;
        private W6.a rateLimiter;
        private int taskNum;
        private String tempFilePath;
        private long trafficLimit;

        public DownloadFileInputBuilder bucket(String str) {
            this.headObjectV2Input.setBucket(str);
            return this;
        }

        public DownloadFileInput build() {
            DownloadFileInput downloadFileInput = new DownloadFileInput();
            downloadFileInput.setHeadObjectV2Input(this.headObjectV2Input);
            downloadFileInput.setFilePath(this.filePath);
            downloadFileInput.setTempFilePath(this.tempFilePath);
            downloadFileInput.setPartSize(this.partSize);
            downloadFileInput.setTaskNum(this.taskNum);
            downloadFileInput.setEnableCheckpoint(this.enableCheckpoint);
            downloadFileInput.setCheckpointFile(this.checkpointFile);
            downloadFileInput.setDataTransferListener(null);
            downloadFileInput.setDownloadEventListener(this.downloadEventListener);
            downloadFileInput.cancelHook = this.cancelHook;
            downloadFileInput.setRateLimiter(null);
            downloadFileInput.setTrafficLimit(this.trafficLimit);
            return downloadFileInput;
        }

        public DownloadFileInputBuilder cancelHook(boolean z10) {
            if (z10) {
                this.cancelHook = new d();
                return this;
            }
            this.cancelHook = null;
            return this;
        }

        public DownloadFileInputBuilder checkpointFile(String str) {
            this.checkpointFile = str;
            return this;
        }

        public DownloadFileInputBuilder dataTransferListener(a aVar) {
            return this;
        }

        public DownloadFileInputBuilder downloadEventListener(DownloadEventListener downloadEventListener) {
            this.downloadEventListener = downloadEventListener;
            return this;
        }

        public DownloadFileInputBuilder enableCheckpoint(boolean z10) {
            this.enableCheckpoint = z10;
            return this;
        }

        public DownloadFileInputBuilder filePath(String str) {
            this.filePath = str;
            return this;
        }

        @Deprecated
        public DownloadFileInputBuilder headObjectV2Input(HeadObjectV2Input headObjectV2Input) {
            this.headObjectV2Input = headObjectV2Input;
            return this;
        }

        public DownloadFileInputBuilder key(String str) {
            this.headObjectV2Input.setKey(str);
            return this;
        }

        public DownloadFileInputBuilder options(ObjectMetaRequestOptions objectMetaRequestOptions) {
            this.headObjectV2Input.setOptions(objectMetaRequestOptions);
            return this;
        }

        public DownloadFileInputBuilder partSize(long j5) {
            this.partSize = j5;
            return this;
        }

        public DownloadFileInputBuilder rateLimiter(W6.a aVar) {
            return this;
        }

        public DownloadFileInputBuilder taskNum(int i) {
            this.taskNum = i;
            return this;
        }

        public DownloadFileInputBuilder tempFilePath(String str) {
            this.tempFilePath = str;
            return this;
        }

        public DownloadFileInputBuilder trafficLimit(long j5) {
            this.trafficLimit = j5;
            return this;
        }

        public DownloadFileInputBuilder versionID(String str) {
            this.headObjectV2Input.setVersionID(str);
            return this;
        }

        private DownloadFileInputBuilder() {
            this.headObjectV2Input = new HeadObjectV2Input();
        }
    }

    public static DownloadFileInputBuilder builder() {
        return new DownloadFileInputBuilder();
    }

    public String getBucket() {
        return this.headObjectV2Input.getBucket();
    }

    public CancelHook getCancelHook() {
        return this.cancelHook;
    }

    public String getCheckpointFile() {
        return this.checkpointFile;
    }

    public a getDataTransferListener() {
        return null;
    }

    public DownloadEventListener getDownloadEventListener() {
        return this.downloadEventListener;
    }

    public String getFilePath() {
        return this.filePath;
    }

    @Deprecated
    public HeadObjectV2Input getHeadObjectV2Input() {
        return this.headObjectV2Input;
    }

    public String getKey() {
        return this.headObjectV2Input.getKey();
    }

    public ObjectMetaRequestOptions getOptions() {
        return this.headObjectV2Input.getOptions();
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

    public String getTempFilePath() {
        return this.tempFilePath;
    }

    public long getTrafficLimit() {
        return this.trafficLimit;
    }

    public String getVersionID() {
        return this.headObjectV2Input.getVersionID();
    }

    public boolean isEnableCheckpoint() {
        return this.enableCheckpoint;
    }

    public DownloadFileInput setBucket(String str) {
        this.headObjectV2Input.setBucket(str);
        return this;
    }

    public DownloadFileInput setCancelHook(boolean z10) {
        if (z10) {
            this.cancelHook = new d();
            return this;
        }
        this.cancelHook = null;
        return this;
    }

    public DownloadFileInput setCheckpointFile(String str) {
        this.checkpointFile = str;
        return this;
    }

    public DownloadFileInput setDataTransferListener(a aVar) {
        return this;
    }

    public DownloadFileInput setDownloadEventListener(DownloadEventListener downloadEventListener) {
        this.downloadEventListener = downloadEventListener;
        return this;
    }

    public DownloadFileInput setEnableCheckpoint(boolean z10) {
        this.enableCheckpoint = z10;
        return this;
    }

    public DownloadFileInput setFilePath(String str) {
        this.filePath = str;
        return this;
    }

    @Deprecated
    public DownloadFileInput setHeadObjectV2Input(HeadObjectV2Input headObjectV2Input) {
        this.headObjectV2Input = headObjectV2Input;
        return this;
    }

    public DownloadFileInput setKey(String str) {
        this.headObjectV2Input.setKey(str);
        return this;
    }

    public DownloadFileInput setOptions(ObjectMetaRequestOptions objectMetaRequestOptions) {
        this.headObjectV2Input.setOptions(objectMetaRequestOptions);
        return this;
    }

    public DownloadFileInput setPartSize(long j5) {
        this.partSize = j5;
        return this;
    }

    public DownloadFileInput setRateLimiter(W6.a aVar) {
        return this;
    }

    public DownloadFileInput setTaskNum(int i) {
        this.taskNum = i;
        return this;
    }

    public DownloadFileInput setTempFilePath(String str) {
        this.tempFilePath = str;
        return this;
    }

    public DownloadFileInput setTrafficLimit(long j5) {
        this.trafficLimit = j5;
        return this;
    }

    public DownloadFileInput setVersionID(String str) {
        this.headObjectV2Input.setVersionID(str);
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("DownloadFileInput{bucket='");
        sb.append(getBucket());
        sb.append("', key='");
        sb.append(getKey());
        sb.append("', versionID='");
        sb.append(getVersionID());
        sb.append("', options=");
        sb.append(getOptions());
        sb.append(", filePath='");
        sb.append(this.filePath);
        sb.append("', tempFilePath='");
        sb.append(this.tempFilePath);
        sb.append("', partSize=");
        sb.append(this.partSize);
        sb.append(", taskNum=");
        sb.append(this.taskNum);
        sb.append(", enableCheckpoint=");
        sb.append(this.enableCheckpoint);
        sb.append(", checkpointFile='");
        sb.append(this.checkpointFile);
        sb.append("', rateLimiter=null, trafficLimit=");
        return B7.a.p(sb, this.trafficLimit, '}');
    }
}
