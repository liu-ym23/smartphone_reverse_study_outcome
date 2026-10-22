package com.volcengine.tos.model.object;

import B7.a;
import Z6.f;
import java.util.Date;

/* loaded from: classes3.dex */
public class ResumableCopyObjectInput {
    private CancelHook cancelHook;
    private String checkpointFile;
    private CopyEventListener copyEventListener;
    private String copySourceIfMatch;
    private Date copySourceIfModifiedSince;
    private String copySourceIfNoneMatch;
    private Date copySourceIfUnModifiedSince;
    private String copySourceSSECAlgorithm;
    private String copySourceSSECKey;
    private String copySourceSSECKeyMD5;
    private CreateMultipartUploadInput createMultipartUploadInput = new CreateMultipartUploadInput();
    private boolean enableCheckpoint;
    private long partSize;
    private String srcBucket;
    private String srcKey;
    private String srcVersionID;
    private int taskNum;
    private long trafficLimit;

    public static final class ResumableCopyObjectInputBuilder {
        private CancelHook cancelHook;
        private String checkpointFile;
        private CopyEventListener copyEventListener;
        private String copySourceIfMatch;
        private Date copySourceIfModifiedSince;
        private String copySourceIfNoneMatch;
        private Date copySourceIfUnModifiedSince;
        private String copySourceSSECAlgorithm;
        private String copySourceSSECKey;
        private String copySourceSSECKeyMD5;
        private CreateMultipartUploadInput createMultipartUploadInput;
        private boolean enableCheckpoint;
        private long partSize;
        private String srcBucket;
        private String srcKey;
        private String srcVersionID;
        private int taskNum;
        private long trafficLimit;

        public ResumableCopyObjectInputBuilder bucket(String str) {
            this.createMultipartUploadInput.setBucket(str);
            return this;
        }

        public ResumableCopyObjectInput build() {
            ResumableCopyObjectInput resumableCopyObjectInput = new ResumableCopyObjectInput();
            resumableCopyObjectInput.setCreateMultipartUploadInput(this.createMultipartUploadInput);
            resumableCopyObjectInput.setSrcBucket(this.srcBucket);
            resumableCopyObjectInput.setSrcKey(this.srcKey);
            resumableCopyObjectInput.setSrcVersionID(this.srcVersionID);
            resumableCopyObjectInput.setCopySourceIfMatch(this.copySourceIfMatch);
            resumableCopyObjectInput.setCopySourceIfModifiedSince(this.copySourceIfModifiedSince);
            resumableCopyObjectInput.setCopySourceIfNoneMatch(this.copySourceIfNoneMatch);
            resumableCopyObjectInput.setCopySourceIfUnModifiedSince(this.copySourceIfUnModifiedSince);
            resumableCopyObjectInput.setCopySourceSSECAlgorithm(this.copySourceSSECAlgorithm);
            resumableCopyObjectInput.setCopySourceSSECKey(this.copySourceSSECKey);
            resumableCopyObjectInput.setCopySourceSSECKeyMD5(this.copySourceSSECKeyMD5);
            resumableCopyObjectInput.setPartSize(this.partSize);
            resumableCopyObjectInput.setTaskNum(this.taskNum);
            resumableCopyObjectInput.setEnableCheckpoint(this.enableCheckpoint);
            resumableCopyObjectInput.setCheckpointFile(this.checkpointFile);
            resumableCopyObjectInput.setCopyEventListener(this.copyEventListener);
            resumableCopyObjectInput.cancelHook = this.cancelHook;
            resumableCopyObjectInput.setTrafficLimit(this.trafficLimit);
            return resumableCopyObjectInput;
        }

        public ResumableCopyObjectInputBuilder cancelHook(boolean z10) {
            if (z10) {
                this.cancelHook = new f();
                return this;
            }
            this.cancelHook = null;
            return this;
        }

        public ResumableCopyObjectInputBuilder checkpointFile(String str) {
            this.checkpointFile = str;
            return this;
        }

        public ResumableCopyObjectInputBuilder copyEventListener(CopyEventListener copyEventListener) {
            this.copyEventListener = copyEventListener;
            return this;
        }

        public ResumableCopyObjectInputBuilder copySourceIfMatch(String str) {
            this.copySourceIfMatch = str;
            return this;
        }

        public ResumableCopyObjectInputBuilder copySourceIfModifiedSince(Date date) {
            this.copySourceIfModifiedSince = date;
            return this;
        }

        public ResumableCopyObjectInputBuilder copySourceIfNoneMatch(String str) {
            this.copySourceIfNoneMatch = str;
            return this;
        }

        public ResumableCopyObjectInputBuilder copySourceIfUnModifiedSince(Date date) {
            this.copySourceIfUnModifiedSince = date;
            return this;
        }

        public ResumableCopyObjectInputBuilder copySourceSSECAlgorithm(String str) {
            this.copySourceSSECAlgorithm = str;
            return this;
        }

        public ResumableCopyObjectInputBuilder copySourceSSECKey(String str) {
            this.copySourceSSECKey = str;
            return this;
        }

        public ResumableCopyObjectInputBuilder copySourceSSECKeyMD5(String str) {
            this.copySourceSSECKeyMD5 = str;
            return this;
        }

        @Deprecated
        public ResumableCopyObjectInputBuilder createMultipartUploadInput(CreateMultipartUploadInput createMultipartUploadInput) {
            this.createMultipartUploadInput = createMultipartUploadInput;
            return this;
        }

        public ResumableCopyObjectInputBuilder enableCheckpoint(boolean z10) {
            this.enableCheckpoint = z10;
            return this;
        }

        public ResumableCopyObjectInputBuilder encodingType(String str) {
            this.createMultipartUploadInput.setEncodingType(str);
            return this;
        }

        public ResumableCopyObjectInputBuilder key(String str) {
            this.createMultipartUploadInput.setKey(str);
            return this;
        }

        public ResumableCopyObjectInputBuilder options(ObjectMetaRequestOptions objectMetaRequestOptions) {
            this.createMultipartUploadInput.setOptions(objectMetaRequestOptions);
            return this;
        }

        public ResumableCopyObjectInputBuilder partSize(long j5) {
            this.partSize = j5;
            return this;
        }

        public ResumableCopyObjectInputBuilder srcBucket(String str) {
            this.srcBucket = str;
            return this;
        }

        public ResumableCopyObjectInputBuilder srcKey(String str) {
            this.srcKey = str;
            return this;
        }

        public ResumableCopyObjectInputBuilder srcVersionID(String str) {
            this.srcVersionID = str;
            return this;
        }

        public ResumableCopyObjectInputBuilder taskNum(int i) {
            this.taskNum = i;
            return this;
        }

        public ResumableCopyObjectInputBuilder trafficLimit(long j5) {
            this.trafficLimit = j5;
            return this;
        }

        private ResumableCopyObjectInputBuilder() {
            this.createMultipartUploadInput = new CreateMultipartUploadInput();
        }
    }

    public static ResumableCopyObjectInputBuilder builder() {
        return new ResumableCopyObjectInputBuilder();
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

    public CopyEventListener getCopyEventListener() {
        return this.copyEventListener;
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

    public Date getCopySourceIfUnModifiedSince() {
        return this.copySourceIfUnModifiedSince;
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

    @Deprecated
    public CreateMultipartUploadInput getCreateMultipartUploadInput() {
        return this.createMultipartUploadInput;
    }

    public String getEncodingType() {
        return this.createMultipartUploadInput.getEncodingType();
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

    public String getSrcBucket() {
        return this.srcBucket;
    }

    public String getSrcKey() {
        return this.srcKey;
    }

    public String getSrcVersionID() {
        return this.srcVersionID;
    }

    public int getTaskNum() {
        return this.taskNum;
    }

    public long getTrafficLimit() {
        return this.trafficLimit;
    }

    public boolean isEnableCheckpoint() {
        return this.enableCheckpoint;
    }

    public ResumableCopyObjectInput setBucket(String str) {
        this.createMultipartUploadInput.setBucket(str);
        return this;
    }

    public ResumableCopyObjectInput setCancelHook(boolean z10) {
        if (z10) {
            this.cancelHook = new f();
            return this;
        }
        this.cancelHook = null;
        return this;
    }

    public ResumableCopyObjectInput setCheckpointFile(String str) {
        this.checkpointFile = str;
        return this;
    }

    public ResumableCopyObjectInput setCopyEventListener(CopyEventListener copyEventListener) {
        this.copyEventListener = copyEventListener;
        return this;
    }

    public ResumableCopyObjectInput setCopySourceIfMatch(String str) {
        this.copySourceIfMatch = str;
        return this;
    }

    public ResumableCopyObjectInput setCopySourceIfModifiedSince(Date date) {
        this.copySourceIfModifiedSince = date;
        return this;
    }

    public ResumableCopyObjectInput setCopySourceIfNoneMatch(String str) {
        this.copySourceIfNoneMatch = str;
        return this;
    }

    public ResumableCopyObjectInput setCopySourceIfUnModifiedSince(Date date) {
        this.copySourceIfUnModifiedSince = date;
        return this;
    }

    public ResumableCopyObjectInput setCopySourceSSECAlgorithm(String str) {
        this.copySourceSSECAlgorithm = str;
        return this;
    }

    public ResumableCopyObjectInput setCopySourceSSECKey(String str) {
        this.copySourceSSECKey = str;
        return this;
    }

    public ResumableCopyObjectInput setCopySourceSSECKeyMD5(String str) {
        this.copySourceSSECKeyMD5 = str;
        return this;
    }

    @Deprecated
    public ResumableCopyObjectInput setCreateMultipartUploadInput(CreateMultipartUploadInput createMultipartUploadInput) {
        this.createMultipartUploadInput = createMultipartUploadInput;
        return this;
    }

    public ResumableCopyObjectInput setEnableCheckpoint(boolean z10) {
        this.enableCheckpoint = z10;
        return this;
    }

    public ResumableCopyObjectInput setEncodingType(String str) {
        this.createMultipartUploadInput.setEncodingType(str);
        return this;
    }

    public ResumableCopyObjectInput setKey(String str) {
        this.createMultipartUploadInput.setKey(str);
        return this;
    }

    public ResumableCopyObjectInput setOptions(ObjectMetaRequestOptions objectMetaRequestOptions) {
        this.createMultipartUploadInput.setOptions(objectMetaRequestOptions);
        return this;
    }

    public ResumableCopyObjectInput setPartSize(long j5) {
        this.partSize = j5;
        return this;
    }

    public ResumableCopyObjectInput setSrcBucket(String str) {
        this.srcBucket = str;
        return this;
    }

    public ResumableCopyObjectInput setSrcKey(String str) {
        this.srcKey = str;
        return this;
    }

    public ResumableCopyObjectInput setSrcVersionID(String str) {
        this.srcVersionID = str;
        return this;
    }

    public ResumableCopyObjectInput setTaskNum(int i) {
        this.taskNum = i;
        return this;
    }

    public ResumableCopyObjectInput setTrafficLimit(long j5) {
        this.trafficLimit = j5;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("ResumableCopyObjectInput{bucket='");
        sb.append(getBucket());
        sb.append("', key='");
        sb.append(getKey());
        sb.append("', encodingType='");
        sb.append(getEncodingType());
        sb.append("', options=");
        sb.append(getOptions());
        sb.append(", srcBucket='");
        sb.append(this.srcBucket);
        sb.append("', srcKey='");
        sb.append(this.srcKey);
        sb.append("', srcVersionID='");
        sb.append(this.srcVersionID);
        sb.append("', copySourceIfMatch='");
        sb.append(this.copySourceIfMatch);
        sb.append("', copySourceIfModifiedSince=");
        sb.append(this.copySourceIfModifiedSince);
        sb.append(", copySourceIfNoneMatch='");
        sb.append(this.copySourceIfNoneMatch);
        sb.append("', copySourceIfUnModifiedSince=");
        sb.append(this.copySourceIfUnModifiedSince);
        sb.append(", copySourceSSECAlgorithm='");
        sb.append(this.copySourceSSECAlgorithm);
        sb.append("', copySourceSSECKey='");
        sb.append(this.copySourceSSECKey);
        sb.append("', copySourceSSECKeyMD5='");
        sb.append(this.copySourceSSECKeyMD5);
        sb.append("', partSize=");
        sb.append(this.partSize);
        sb.append(", taskNum=");
        sb.append(this.taskNum);
        sb.append(", enableCheckpoint=");
        sb.append(this.enableCheckpoint);
        sb.append(", checkpointFile='");
        sb.append(this.checkpointFile);
        sb.append("', copyEventListener=");
        sb.append(this.copyEventListener);
        sb.append(", cancelHook=");
        sb.append(this.cancelHook);
        sb.append(", trafficLimit=");
        return a.p(sb, this.trafficLimit, '}');
    }
}
