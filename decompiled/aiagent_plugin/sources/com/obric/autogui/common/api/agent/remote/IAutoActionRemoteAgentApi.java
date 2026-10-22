package com.obric.autogui.common.api.agent.remote;

import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.autogui.common.e;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.d;
import d.d.a;
import d.d.b;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: compiled from: IAutoActionRemoteAgentApi.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface IAutoActionRemoteAgentApi {

    /* JADX INFO: compiled from: IAutoActionRemoteAgentApi.kt */
    public static final enum ErrorType extends Enum<ErrorType> {
        private static final /* synthetic */ a $ENTRIES = null;
        private static final /* synthetic */ ErrorType[] $VALUES = null;
        public static final ErrorType ApiError = null;
        public static final ErrorType ClientError = null;
        public static final ErrorType NetworkError = null;
        public static final ErrorType QueueFull = null;
        public static final ErrorType QueueTimedOut = null;
        public static final ErrorType RespondedError = null;
        public static final ErrorType ServiceError = null;
        public static final ErrorType Succeeded = null;
        private final boolean retryable;

        private static final /* synthetic */ ErrorType[] $values() {
            return new ErrorType[]{Succeeded, QueueTimedOut, NetworkError, ClientError, ServiceError, RespondedError, ApiError, QueueFull};
        }

        public static a<ErrorType> getEntries() {
            return $ENTRIES;
        }

        private ErrorType(String r1, int r2, boolean r3) {
            super(r1, r2);
            this.retryable = r3;
        }

        /* synthetic */ ErrorType(String r1, int r2, boolean r3, int r4, h r5) {
            if ((r4 & 1) == 0) goto L5;
            r3 = true;
        L5:
            this(r1, r2, r3);
        }

        public final boolean getRetryable() {
            return this.retryable;
        }

        static {
            Succeeded = new ErrorType("Succeeded", 0, false);
            QueueTimedOut = new ErrorType("QueueTimedOut", 1, false);
            boolean r7 = false;
            int r8 = 1;
            h r9 = null;
            NetworkError = new ErrorType("NetworkError", 2, r7, r8, r9);
            ClientError = new ErrorType("ClientError", 3, false);
            ServiceError = new ErrorType("ServiceError", 4, r7, r8, r9);
            RespondedError = new ErrorType("RespondedError", 5, false, 1, null);
            ApiError = new ErrorType("ApiError", 6, false, 1, null);
            QueueFull = new ErrorType("QueueFull", 7, false);
            ErrorType[] r0 = $values();
            $VALUES = r0;
            $ENTRIES = b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
        }

        public static ErrorType valueOf(String r2) {
            return (ErrorType) ZeusTransformUtils.preCheckCast(Enum.valueOf(ErrorType.class, r2), ErrorType.class, "com.obric.aiagent.plugin");
        }

        public static ErrorType[] values() {
            return (ErrorType[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), ErrorType[].class, "com.obric.aiagent.plugin");
        }
    }

    /* JADX INFO: compiled from: IAutoActionRemoteAgentApi.kt */
    public static final class QueueStateEnteringResult {
        private final ErrorType errorType;
        private final int initQueueSize;
        private final boolean isQueueNeeded;
        private final String sessionId;

        public QueueStateEnteringResult() {
            this(null, null, false, 0, 15, null);
        }

        public static /* synthetic */ QueueStateEnteringResult copy$default(QueueStateEnteringResult r0, ErrorType r1, String r2, boolean r3, int r4, int r5, Object r6) {
            if ((r5 & 1) == 0) goto L6;
            r1 = r0.errorType;
        L6:
            if ((r5 & 2) == 0) goto L9;
            r2 = r0.sessionId;
        L9:
            if ((r5 & 4) == 0) goto L12;
            r3 = r0.isQueueNeeded;
        L12:
            if ((r5 & 8) == 0) goto L15;
            r4 = r0.initQueueSize;
        L15:
            return r0.copy(r1, r2, r3, r4);
        }

        public final ErrorType component1() {
            return this.errorType;
        }

        public final String component2() {
            return this.sessionId;
        }

        public final boolean component3() {
            return this.isQueueNeeded;
        }

        public final int component4() {
            return this.initQueueSize;
        }

        public final QueueStateEnteringResult copy(ErrorType r1, String r2, boolean r3, int r4) {
            o.e(r1, "errorType");
            o.e(r2, ObricMemoryConstants.KEY_SESSION_ID);
            return new QueueStateEnteringResult(r1, r2, r3, r4);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, QueueStateEnteringResult.class) == true) goto L8;
            return false;
        L8:
            QueueStateEnteringResult r6 = (QueueStateEnteringResult) ZeusTransformUtils.preCheckCast(r5, QueueStateEnteringResult.class, "com.obric.aiagent.plugin");
            if (this.errorType == r6.errorType) goto L12;
            return false;
        L12:
            if (o.a(this.sessionId, r6.sessionId) == true) goto L15;
            return false;
        L15:
            if (this.isQueueNeeded == r6.isQueueNeeded) goto L18;
            return false;
        L18:
            if (this.initQueueSize == r6.initQueueSize) goto L20;
            return false;
        L20:
            return true;
        }

        public int hashCode() {
            return (((((this.errorType.hashCode() * 31) + this.sessionId.hashCode()) * 31) + Boolean.hashCode(this.isQueueNeeded)) * 31) + Integer.hashCode(this.initQueueSize);
        }

        public String toString() {
            return "QueueStateEnteringResult(errorType=" + this.errorType + ", sessionId=" + this.sessionId + ", isQueueNeeded=" + this.isQueueNeeded + ", initQueueSize=" + this.initQueueSize + ')';
        }

        public QueueStateEnteringResult(ErrorType r2, String r3, boolean r4, int r5) {
            o.e(r2, "errorType");
            o.e(r3, ObricMemoryConstants.KEY_SESSION_ID);
            this.errorType = r2;
            this.sessionId = r3;
            this.isQueueNeeded = r4;
            this.initQueueSize = r5;
        }

        public /* synthetic */ QueueStateEnteringResult(ErrorType r2, String r3, boolean r4, int r5, int r6, h r7) {
            if ((r6 & 1) == 0) goto L6;
            r2 = ErrorType.Succeeded;
        L6:
            if ((r6 & 2) == 0) goto L9;
            r3 = "";
        L9:
            if ((r6 & 4) == 0) goto L12;
            r4 = false;
        L12:
            if ((r6 & 8) == 0) goto L14;
            r5 = 0;
        L14:
            this(r2, r3, r4, r5);
        }

        public final ErrorType getErrorType() {
            return this.errorType;
        }

        public final String getSessionId() {
            return this.sessionId;
        }

        public final boolean isQueueNeeded() {
            return this.isQueueNeeded;
        }

        public final int getInitQueueSize() {
            return this.initQueueSize;
        }
    }

    /* JADX INFO: compiled from: IAutoActionRemoteAgentApi.kt */
    public interface QueueStateUpdateListener {
        void onQueueStateUpdated(QueueStateUpdation r1);
    }

    /* JADX INFO: compiled from: IAutoActionRemoteAgentApi.kt */
    public static final class QueueStateUpdation {
        private final boolean isQueueCompleted;
        private final int queuePosition;

        public static /* synthetic */ QueueStateUpdation copy$default(QueueStateUpdation r0, boolean r1, int r2, int r3, Object r4) {
            if ((r3 & 1) == 0) goto L6;
            r1 = r0.isQueueCompleted;
        L6:
            if ((r3 & 2) == 0) goto L9;
            r2 = r0.queuePosition;
        L9:
            return r0.copy(r1, r2);
        }

        public final boolean component1() {
            return this.isQueueCompleted;
        }

        public final int component2() {
            return this.queuePosition;
        }

        public final QueueStateUpdation copy(boolean r1, int r2) {
            return new QueueStateUpdation(r1, r2);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, QueueStateUpdation.class) == true) goto L8;
            return false;
        L8:
            QueueStateUpdation r6 = (QueueStateUpdation) ZeusTransformUtils.preCheckCast(r5, QueueStateUpdation.class, "com.obric.aiagent.plugin");
            if (this.isQueueCompleted == r6.isQueueCompleted) goto L12;
            return false;
        L12:
            if (this.queuePosition == r6.queuePosition) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            return (Boolean.hashCode(this.isQueueCompleted) * 31) + Integer.hashCode(this.queuePosition);
        }

        public String toString() {
            return "QueueStateUpdation(isQueueCompleted=" + this.isQueueCompleted + ", queuePosition=" + this.queuePosition + ')';
        }

        public QueueStateUpdation(boolean r1, int r2) {
            this.isQueueCompleted = r1;
            this.queuePosition = r2;
        }

        public /* synthetic */ QueueStateUpdation(boolean r1, int r2, int r3, h r4) {
            if ((r3 & 1) == 0) goto L5;
            r1 = false;
        L5:
            this(r1, r2);
        }

        public final boolean isQueueCompleted() {
            return this.isQueueCompleted;
        }

        public final int getQueuePosition() {
            return this.queuePosition;
        }
    }

    Object checkNetworkLinkage(d<? super e> r1);

    Object enterQueueState(QueueStateUpdateListener r1, d<? super QueueStateEnteringResult> r2);
}
