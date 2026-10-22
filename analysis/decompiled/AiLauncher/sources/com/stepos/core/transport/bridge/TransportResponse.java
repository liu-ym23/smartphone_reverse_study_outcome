package com.stepos.core.transport.bridge;

import com.stepos.ailauncher.chat.trace.ChatTracker;
import com.stepos.core.data.base.Content;
import com.stepos.core.error.AIEngineError;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000 \n2\u00020\u0001:\u0007\u0004\u0005\u0006\u0007\b\t\nB\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0006\u000b\f\r\u000e\u000f\u0010¨\u0006\u0011"}, d2 = {"Lcom/stepos/core/transport/bridge/TransportResponse;", "", "<init>", "()V", "Result", "Complete", "Error", "Cancelled", "Progress", "RoutingDecision", "Companion", "Lcom/stepos/core/transport/bridge/TransportResponse$Cancelled;", "Lcom/stepos/core/transport/bridge/TransportResponse$Complete;", "Lcom/stepos/core/transport/bridge/TransportResponse$Error;", "Lcom/stepos/core/transport/bridge/TransportResponse$Progress;", "Lcom/stepos/core/transport/bridge/TransportResponse$Result;", "Lcom/stepos/core/transport/bridge/TransportResponse$RoutingDecision;", "aiengine-api_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public abstract class TransportResponse {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0006\u0010\f\u001a\u00020\rJ\u0006\u0010\u000e\u001a\u00020\rJ\u0006\u0010\u000f\u001a\u00020\rJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\r2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0018"}, d2 = {"Lcom/stepos/core/transport/bridge/TransportResponse$Cancelled;", "Lcom/stepos/core/transport/bridge/TransportResponse;", "reason", "", "message", "", "<init>", "(ILjava/lang/String;)V", "getReason", "()I", "getMessage", "()Ljava/lang/String;", "isUserCancelled", "", "isTimeout", "isInterrupted", "component1", "component2", ChatTracker.CLICK_COPY, "equals", "other", "", "hashCode", "toString", "aiengine-api_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final /* data */ class Cancelled extends TransportResponse {
        private final String message;
        private final int reason;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Cancelled(int i10, String message) {
            super(null);
            p.i(message, "message");
            this.reason = i10;
            this.message = message;
        }

        public static /* synthetic */ Cancelled copy$default(Cancelled cancelled, int i10, String str, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                i10 = cancelled.reason;
            }
            if ((i11 & 2) != 0) {
                str = cancelled.message;
            }
            return cancelled.copy(i10, str);
        }

        /* renamed from: component1, reason: from getter */
        public final int getReason() {
            return this.reason;
        }

        /* renamed from: component2, reason: from getter */
        public final String getMessage() {
            return this.message;
        }

        public final Cancelled copy(int reason, String message) {
            p.i(message, "message");
            return new Cancelled(reason, message);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Cancelled)) {
                return false;
            }
            Cancelled cancelled = (Cancelled) other;
            return this.reason == cancelled.reason && p.d(this.message, cancelled.message);
        }

        public final String getMessage() {
            return this.message;
        }

        public final int getReason() {
            return this.reason;
        }

        public int hashCode() {
            return (Integer.hashCode(this.reason) * 31) + this.message.hashCode();
        }

        public final boolean isInterrupted() {
            return this.reason == -102;
        }

        public final boolean isTimeout() {
            return this.reason == -101;
        }

        public final boolean isUserCancelled() {
            return this.reason == -100;
        }

        public String toString() {
            return "Cancelled(reason=" + this.reason + ", message=" + this.message + ")";
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t¨\u0006\n"}, d2 = {"Lcom/stepos/core/transport/bridge/TransportResponse$Companion;", "", "<init>", "()V", "fromErrorCode", "Lcom/stepos/core/transport/bridge/TransportResponse;", "errorCode", "", "message", "", "aiengine-api_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(i iVar) {
            this();
        }

        public final TransportResponse fromErrorCode(int errorCode, String message) {
            p.i(message, "message");
            return AIEngineError.INSTANCE.isCancellation(errorCode) ? new Cancelled(errorCode, message) : new Error(errorCode, message);
        }

        private Companion() {
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/stepos/core/transport/bridge/TransportResponse$Complete;", "Lcom/stepos/core/transport/bridge/TransportResponse;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "aiengine-api_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final /* data */ class Complete extends TransportResponse {
        public static final Complete INSTANCE = new Complete();

        private Complete() {
            super(null);
        }

        public boolean equals(Object other) {
            return this == other || (other instanceof Complete);
        }

        public int hashCode() {
            return 1064472479;
        }

        public String toString() {
            return "Complete";
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/stepos/core/transport/bridge/TransportResponse$Error;", "Lcom/stepos/core/transport/bridge/TransportResponse;", "errorCode", "", "message", "", "<init>", "(ILjava/lang/String;)V", "getErrorCode", "()I", "getMessage", "()Ljava/lang/String;", "component1", "component2", ChatTracker.CLICK_COPY, "equals", "", "other", "", "hashCode", "toString", "aiengine-api_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final /* data */ class Error extends TransportResponse {
        private final int errorCode;
        private final String message;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Error(int i10, String message) {
            super(null);
            p.i(message, "message");
            this.errorCode = i10;
            this.message = message;
        }

        public static /* synthetic */ Error copy$default(Error error, int i10, String str, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                i10 = error.errorCode;
            }
            if ((i11 & 2) != 0) {
                str = error.message;
            }
            return error.copy(i10, str);
        }

        /* renamed from: component1, reason: from getter */
        public final int getErrorCode() {
            return this.errorCode;
        }

        /* renamed from: component2, reason: from getter */
        public final String getMessage() {
            return this.message;
        }

        public final Error copy(int errorCode, String message) {
            p.i(message, "message");
            return new Error(errorCode, message);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Error)) {
                return false;
            }
            Error error = (Error) other;
            return this.errorCode == error.errorCode && p.d(this.message, error.message);
        }

        public final int getErrorCode() {
            return this.errorCode;
        }

        public final String getMessage() {
            return this.message;
        }

        public int hashCode() {
            return (Integer.hashCode(this.errorCode) * 31) + this.message.hashCode();
        }

        public String toString() {
            return "Error(errorCode=" + this.errorCode + ", message=" + this.message + ")";
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/stepos/core/transport/bridge/TransportResponse$Progress;", "Lcom/stepos/core/transport/bridge/TransportResponse;", "percent", "", "extra", "Lcom/stepos/core/data/base/Content;", "<init>", "(ILcom/stepos/core/data/base/Content;)V", "getPercent", "()I", "getExtra", "()Lcom/stepos/core/data/base/Content;", "component1", "component2", ChatTracker.CLICK_COPY, "equals", "", "other", "", "hashCode", "toString", "", "aiengine-api_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final /* data */ class Progress extends TransportResponse {
        private final Content extra;
        private final int percent;

        public Progress(int i10, Content content) {
            super(null);
            this.percent = i10;
            this.extra = content;
        }

        public static /* synthetic */ Progress copy$default(Progress progress, int i10, Content content, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                i10 = progress.percent;
            }
            if ((i11 & 2) != 0) {
                content = progress.extra;
            }
            return progress.copy(i10, content);
        }

        /* renamed from: component1, reason: from getter */
        public final int getPercent() {
            return this.percent;
        }

        /* renamed from: component2, reason: from getter */
        public final Content getExtra() {
            return this.extra;
        }

        public final Progress copy(int percent, Content extra) {
            return new Progress(percent, extra);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Progress)) {
                return false;
            }
            Progress progress = (Progress) other;
            return this.percent == progress.percent && p.d(this.extra, progress.extra);
        }

        public final Content getExtra() {
            return this.extra;
        }

        public final int getPercent() {
            return this.percent;
        }

        public int hashCode() {
            int iHashCode = Integer.hashCode(this.percent) * 31;
            Content content = this.extra;
            return iHashCode + (content == null ? 0 : content.hashCode());
        }

        public String toString() {
            return "Progress(percent=" + this.percent + ", extra=" + this.extra + ")";
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/stepos/core/transport/bridge/TransportResponse$Result;", "Lcom/stepos/core/transport/bridge/TransportResponse;", "output", "Lcom/stepos/core/data/base/Content;", "<init>", "(Lcom/stepos/core/data/base/Content;)V", "getOutput", "()Lcom/stepos/core/data/base/Content;", "component1", ChatTracker.CLICK_COPY, "equals", "", "other", "", "hashCode", "", "toString", "", "aiengine-api_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final /* data */ class Result extends TransportResponse {
        private final Content output;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Result(Content output) {
            super(null);
            p.i(output, "output");
            this.output = output;
        }

        public static /* synthetic */ Result copy$default(Result result, Content content, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                content = result.output;
            }
            return result.copy(content);
        }

        /* renamed from: component1, reason: from getter */
        public final Content getOutput() {
            return this.output;
        }

        public final Result copy(Content output) {
            p.i(output, "output");
            return new Result(output);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Result) && p.d(this.output, ((Result) other).output);
        }

        public final Content getOutput() {
            return this.output;
        }

        public int hashCode() {
            return this.output.hashCode();
        }

        public String toString() {
            return "Result(output=" + this.output + ")";
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0014"}, d2 = {"Lcom/stepos/core/transport/bridge/TransportResponse$RoutingDecision;", "Lcom/stepos/core/transport/bridge/TransportResponse;", "executionLocation", "", "reason", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getExecutionLocation", "()Ljava/lang/String;", "getReason", "component1", "component2", ChatTracker.CLICK_COPY, "equals", "", "other", "", "hashCode", "", "toString", "aiengine-api_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final /* data */ class RoutingDecision extends TransportResponse {
        private final String executionLocation;
        private final String reason;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public RoutingDecision(String executionLocation, String reason) {
            super(null);
            p.i(executionLocation, "executionLocation");
            p.i(reason, "reason");
            this.executionLocation = executionLocation;
            this.reason = reason;
        }

        public static /* synthetic */ RoutingDecision copy$default(RoutingDecision routingDecision, String str, String str2, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                str = routingDecision.executionLocation;
            }
            if ((i10 & 2) != 0) {
                str2 = routingDecision.reason;
            }
            return routingDecision.copy(str, str2);
        }

        /* renamed from: component1, reason: from getter */
        public final String getExecutionLocation() {
            return this.executionLocation;
        }

        /* renamed from: component2, reason: from getter */
        public final String getReason() {
            return this.reason;
        }

        public final RoutingDecision copy(String executionLocation, String reason) {
            p.i(executionLocation, "executionLocation");
            p.i(reason, "reason");
            return new RoutingDecision(executionLocation, reason);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof RoutingDecision)) {
                return false;
            }
            RoutingDecision routingDecision = (RoutingDecision) other;
            return p.d(this.executionLocation, routingDecision.executionLocation) && p.d(this.reason, routingDecision.reason);
        }

        public final String getExecutionLocation() {
            return this.executionLocation;
        }

        public final String getReason() {
            return this.reason;
        }

        public int hashCode() {
            return (this.executionLocation.hashCode() * 31) + this.reason.hashCode();
        }

        public String toString() {
            return "RoutingDecision(executionLocation=" + this.executionLocation + ", reason=" + this.reason + ")";
        }
    }

    public /* synthetic */ TransportResponse(i iVar) {
        this();
    }

    private TransportResponse() {
    }
}
