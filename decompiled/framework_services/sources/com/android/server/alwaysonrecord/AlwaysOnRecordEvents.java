package com.android.server.alwaysonrecord;

import com.android.server.utils.EventLogger;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class AlwaysOnRecordEvents {

    static final class DataAvailableEvent extends EventLogger.Event {
        int mActualSegmentCount;
        int mDataSize;
        int mSegmentCount;
        String mStatus;

        DataAvailableEvent(int segmentCount, int actualSegmentCount, int dataSize, String status) {
            this.mSegmentCount = segmentCount;
            this.mActualSegmentCount = actualSegmentCount;
            this.mDataSize = dataSize;
            this.mStatus = status;
        }

        @Override // com.android.server.utils.EventLogger.Event
        public String eventToString() {
            return "onDataAvailable(segment count:" + this.mSegmentCount + ", actual segment count:" + this.mActualSegmentCount + ", data size:" + this.mDataSize + ", status:" + this.mStatus + ")";
        }
    }

    static final class DataFileRecycleEvent extends EventLogger.Event {
        int mFileCount;
        String mStatus;

        DataFileRecycleEvent(int fileCount, String status) {
            this.mFileCount = fileCount;
            this.mStatus = status;
        }

        @Override // com.android.server.utils.EventLogger.Event
        public String eventToString() {
            return "deleteOlderFiles(fileCount:" + this.mFileCount + ", status:" + this.mStatus + ")";
        }
    }

    static final class FireEvent extends EventLogger.Event {
        private final List<Integer> mFailedClientSessionIds;
        private final String mFireReason;
        private final List<Integer> mRetryClientSessionIds;
        private final List<Integer> mSucceedClientSessionIds;

        FireEvent(int fireReason, List<Integer> succeedClientSessionIds, List<Integer> retryClientSessionIds, List<Integer> failedClientSessionIds) {
            this.mFireReason = getReason(fireReason);
            this.mSucceedClientSessionIds = succeedClientSessionIds;
            this.mRetryClientSessionIds = retryClientSessionIds;
            this.mFailedClientSessionIds = failedClientSessionIds;
        }

        private String getReason(int reason) {
            switch(reason) {
                case 0: goto L9;
                case 1: goto L7;
                case 2: goto L5;
                default: goto L4;
            };
        L5:
            return "FORCE_SYNC";
        L7:
            return "ALARM";
        L9:
            return "START_RECORD";
        L4:
            return "UNKNOWN code " + reason;
        }

        @Override // com.android.server.utils.EventLogger.Event
        public String eventToString() {
            return "fireEvent(reason:" + this.mFireReason + ", succeed ids:" + this.mSucceedClientSessionIds + ", retry ids:" + this.mRetryClientSessionIds + ", failed ids:" + this.mFailedClientSessionIds + ")";
        }
    }

    static final class ServiceEvent extends EventLogger.Event {
        private final String mOp;
        private final String mPackageName;
        private final int mSessionId;

        ServiceEvent(String op, int sessionId, String packageName) {
            this.mOp = op;
            this.mSessionId = sessionId;
            this.mPackageName = packageName;
        }

        @Override // com.android.server.utils.EventLogger.Event
        public String eventToString() {
            return "serviceEvent(op:" + this.mOp + ", session id:" + this.mSessionId + ", from package name:" + this.mPackageName + ")";
        }
    }

    public AlwaysOnRecordEvents() {
    }
}
