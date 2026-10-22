package com.stepos.core.ability.handler;

import com.stepos.core.data.base.Content;
import h0.e;
import kotlin.jvm.internal.g;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public abstract class InferResult {

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class Complete extends InferResult {
        public static final Complete INSTANCE = new Complete();

        private Complete() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof Complete);
        }

        public int hashCode() {
            return 1089379170;
        }

        public String toString() {
            return "Complete";
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class Error extends InferResult {
        private final int errorCode;
        private final String message;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Error(int i10, String message) {
            super(null);
            g.f(message, "message");
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

        public final int component1() {
            return this.errorCode;
        }

        public final String component2() {
            return this.message;
        }

        public final Error copy(int i10, String message) {
            g.f(message, "message");
            return new Error(i10, message);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Error)) {
                return false;
            }
            Error error = (Error) obj;
            return this.errorCode == error.errorCode && g.b(this.message, error.message);
        }

        public final int getErrorCode() {
            return this.errorCode;
        }

        public final String getMessage() {
            return this.message;
        }

        public int hashCode() {
            return this.message.hashCode() + (Integer.hashCode(this.errorCode) * 31);
        }

        public String toString() {
            return "Error(errorCode=" + this.errorCode + ", message=" + this.message + ")";
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class Output extends InferResult {
        private final Content content;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Output(Content content) {
            super(null);
            g.f(content, "content");
            this.content = content;
        }

        public static /* synthetic */ Output copy$default(Output output, Content content, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                content = output.content;
            }
            return output.copy(content);
        }

        public final Content component1() {
            return this.content;
        }

        public final Output copy(Content content) {
            g.f(content, "content");
            return new Output(content);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Output) && g.b(this.content, ((Output) obj).content);
        }

        public final Content getContent() {
            return this.content;
        }

        public int hashCode() {
            return this.content.hashCode();
        }

        public String toString() {
            return "Output(content=" + this.content + ")";
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class Progress extends InferResult {
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

        public final int component1() {
            return this.percent;
        }

        public final Content component2() {
            return this.extra;
        }

        public final Progress copy(int i10, Content content) {
            return new Progress(i10, content);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Progress)) {
                return false;
            }
            Progress progress = (Progress) obj;
            return this.percent == progress.percent && g.b(this.extra, progress.extra);
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

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class RoutingDecision extends InferResult {
        private final String executionLocation;
        private final String reason;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public RoutingDecision(String executionLocation, String reason) {
            super(null);
            g.f(executionLocation, "executionLocation");
            g.f(reason, "reason");
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

        public final String component1() {
            return this.executionLocation;
        }

        public final String component2() {
            return this.reason;
        }

        public final RoutingDecision copy(String executionLocation, String reason) {
            g.f(executionLocation, "executionLocation");
            g.f(reason, "reason");
            return new RoutingDecision(executionLocation, reason);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof RoutingDecision)) {
                return false;
            }
            RoutingDecision routingDecision = (RoutingDecision) obj;
            return g.b(this.executionLocation, routingDecision.executionLocation) && g.b(this.reason, routingDecision.reason);
        }

        public final String getExecutionLocation() {
            return this.executionLocation;
        }

        public final String getReason() {
            return this.reason;
        }

        public int hashCode() {
            return this.reason.hashCode() + (this.executionLocation.hashCode() * 31);
        }

        public String toString() {
            return e.c("RoutingDecision(executionLocation=", this.executionLocation, ", reason=", this.reason, ")");
        }
    }

    public /* synthetic */ InferResult(kotlin.jvm.internal.e eVar) {
        this();
    }

    private InferResult() {
    }
}
