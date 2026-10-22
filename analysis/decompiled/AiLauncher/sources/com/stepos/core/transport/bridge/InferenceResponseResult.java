package com.stepos.core.transport.bridge;

import com.stepos.ailauncher.chat.trace.ChatTracker;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0002\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/stepos/core/transport/bridge/InferenceResponseResult;", "", "<init>", "()V", "Success", "Failure", "Lcom/stepos/core/transport/bridge/InferenceResponseResult$Failure;", "Lcom/stepos/core/transport/bridge/InferenceResponseResult$Success;", "aiengine-api_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public abstract class InferenceResponseResult {

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/stepos/core/transport/bridge/InferenceResponseResult$Failure;", "Lcom/stepos/core/transport/bridge/InferenceResponseResult;", "requestId", "", "error", "Lcom/stepos/core/transport/bridge/InferenceResponseError;", "<init>", "(Ljava/lang/String;Lcom/stepos/core/transport/bridge/InferenceResponseError;)V", "getRequestId", "()Ljava/lang/String;", "getError", "()Lcom/stepos/core/transport/bridge/InferenceResponseError;", "component1", "component2", ChatTracker.CLICK_COPY, "equals", "", "other", "", "hashCode", "", "toString", "aiengine-api_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final /* data */ class Failure extends InferenceResponseResult {
        private final InferenceResponseError error;
        private final String requestId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Failure(String requestId, InferenceResponseError error) {
            super(null);
            p.i(requestId, "requestId");
            p.i(error, "error");
            this.requestId = requestId;
            this.error = error;
        }

        public static /* synthetic */ Failure copy$default(Failure failure, String str, InferenceResponseError inferenceResponseError, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                str = failure.requestId;
            }
            if ((i10 & 2) != 0) {
                inferenceResponseError = failure.error;
            }
            return failure.copy(str, inferenceResponseError);
        }

        /* renamed from: component1, reason: from getter */
        public final String getRequestId() {
            return this.requestId;
        }

        /* renamed from: component2, reason: from getter */
        public final InferenceResponseError getError() {
            return this.error;
        }

        public final Failure copy(String requestId, InferenceResponseError error) {
            p.i(requestId, "requestId");
            p.i(error, "error");
            return new Failure(requestId, error);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Failure)) {
                return false;
            }
            Failure failure = (Failure) other;
            return p.d(this.requestId, failure.requestId) && p.d(this.error, failure.error);
        }

        public final InferenceResponseError getError() {
            return this.error;
        }

        public final String getRequestId() {
            return this.requestId;
        }

        public int hashCode() {
            return (this.requestId.hashCode() * 31) + this.error.hashCode();
        }

        public String toString() {
            return "Failure(requestId=" + this.requestId + ", error=" + this.error + ")";
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/stepos/core/transport/bridge/InferenceResponseResult$Success;", "Lcom/stepos/core/transport/bridge/InferenceResponseResult;", "requestId", "", "<init>", "(Ljava/lang/String;)V", "getRequestId", "()Ljava/lang/String;", "component1", ChatTracker.CLICK_COPY, "equals", "", "other", "", "hashCode", "", "toString", "aiengine-api_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final /* data */ class Success extends InferenceResponseResult {
        private final String requestId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Success(String requestId) {
            super(null);
            p.i(requestId, "requestId");
            this.requestId = requestId;
        }

        public static /* synthetic */ Success copy$default(Success success, String str, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                str = success.requestId;
            }
            return success.copy(str);
        }

        /* renamed from: component1, reason: from getter */
        public final String getRequestId() {
            return this.requestId;
        }

        public final Success copy(String requestId) {
            p.i(requestId, "requestId");
            return new Success(requestId);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Success) && p.d(this.requestId, ((Success) other).requestId);
        }

        public final String getRequestId() {
            return this.requestId;
        }

        public int hashCode() {
            return this.requestId.hashCode();
        }

        public String toString() {
            return "Success(requestId=" + this.requestId + ")";
        }
    }

    public /* synthetic */ InferenceResponseResult(i iVar) {
        this();
    }

    private InferenceResponseResult() {
    }
}
