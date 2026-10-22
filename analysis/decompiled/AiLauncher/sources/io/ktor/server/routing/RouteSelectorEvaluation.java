package io.ktor.server.routing;

import com.stepos.ailauncher.chat.trace.ChatTracker;
import io.ktor.http.HttpStatusCode;
import io.ktor.http.Parameters;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000 \t2\u00020\u0001:\u0003\n\u000b\tB\u0011\b\u0004\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0006\u001a\u0004\b\u0007\u0010\b\u0082\u0001\u0002\f\r¨\u0006\u000e"}, d2 = {"Lio/ktor/server/routing/RouteSelectorEvaluation;", "", "", "succeeded", "<init>", "(Z)V", "Z", "getSucceeded", "()Z", "Companion", "Success", "Failure", "Lio/ktor/server/routing/RouteSelectorEvaluation$Failure;", "Lio/ktor/server/routing/RouteSelectorEvaluation$Success;", "ktor-server-core"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes4.dex */
public abstract class RouteSelectorEvaluation {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final RouteSelectorEvaluation Constant;
    private static final RouteSelectorEvaluation ConstantPath;
    private static final Failure Failed;
    private static final Failure FailedAcceptHeader;
    private static final Failure FailedMethod;
    private static final Failure FailedParameter;
    private static final Failure FailedPath;
    private static final RouteSelectorEvaluation Missing;
    private static final RouteSelectorEvaluation Transparent;
    private static final RouteSelectorEvaluation WildcardPath;
    public static final double qualityConstant = 1.0d;
    public static final double qualityFailedMethod = 0.02d;
    public static final double qualityFailedParameter = 0.01d;
    public static final double qualityMethodParameter = 0.8d;
    public static final double qualityMissing = 0.2d;
    public static final double qualityParameter = 0.8d;
    public static final double qualityParameterWithPrefixOrSuffix = 0.9d;
    public static final double qualityPathParameter = 0.8d;
    public static final double qualityQueryParameter = 1.0d;
    public static final double qualityTailcard = 0.1d;
    public static final double qualityTransparent = -1.0d;
    public static final double qualityWildcard = 0.5d;
    private final boolean succeeded;

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0019\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J4\u0010\r\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\nH\u0087\u0002¢\u0006\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\u00068\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\u00068\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0011\u0010\u0010R\u0014\u0010\u0012\u001a\u00020\u00068\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0012\u0010\u0010R\u0014\u0010\u0013\u001a\u00020\u00068\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0013\u0010\u0010R\u0014\u0010\u0014\u001a\u00020\u00068\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0014\u0010\u0010R\u001a\u0010\u0015\u001a\u00020\u00068\u0006X\u0086T¢\u0006\f\n\u0004\b\u0015\u0010\u0010\u0012\u0004\b\u0016\u0010\u0003R\u0014\u0010\u0017\u001a\u00020\u00068\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0017\u0010\u0010R\u0014\u0010\u0018\u001a\u00020\u00068\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0018\u0010\u0010R\u0014\u0010\u0019\u001a\u00020\u00068\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0019\u0010\u0010R\u0014\u0010\u001a\u001a\u00020\u00068\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u001a\u0010\u0010R\u0014\u0010\u001b\u001a\u00020\u00068\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u001b\u0010\u0010R\u0014\u0010\u001c\u001a\u00020\u00068\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u001c\u0010\u0010R\u0017\u0010\u001e\u001a\u00020\u001d8\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!R\u0017\u0010\"\u001a\u00020\u001d8\u0006¢\u0006\f\n\u0004\b\"\u0010\u001f\u001a\u0004\b#\u0010!R\u0017\u0010$\u001a\u00020\u001d8\u0006¢\u0006\f\n\u0004\b$\u0010\u001f\u001a\u0004\b%\u0010!R\u0017\u0010&\u001a\u00020\u001d8\u0006¢\u0006\f\n\u0004\b&\u0010\u001f\u001a\u0004\b'\u0010!R\u0017\u0010(\u001a\u00020\u001d8\u0006¢\u0006\f\n\u0004\b(\u0010\u001f\u001a\u0004\b)\u0010!R\u0017\u0010*\u001a\u00020\f8\u0006¢\u0006\f\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-R\u0017\u0010.\u001a\u00020\f8\u0006¢\u0006\f\n\u0004\b.\u0010+\u001a\u0004\b/\u0010-R\u0017\u00100\u001a\u00020\f8\u0006¢\u0006\f\n\u0004\b0\u0010+\u001a\u0004\b1\u0010-R\u0017\u00102\u001a\u00020\f8\u0006¢\u0006\f\n\u0004\b2\u0010+\u001a\u0004\b3\u0010-R\u0017\u00104\u001a\u00020\f8\u0006¢\u0006\f\n\u0004\b4\u0010+\u001a\u0004\b5\u0010-¨\u00066"}, d2 = {"Lio/ktor/server/routing/RouteSelectorEvaluation$Companion;", "", "<init>", "()V", "", "succeeded", "", "quality", "Lio/ktor/http/Parameters;", "parameters", "", "segmentIncrement", "Lio/ktor/server/routing/RouteSelectorEvaluation;", "invoke", "(ZDLio/ktor/http/Parameters;I)Lio/ktor/server/routing/RouteSelectorEvaluation;", "qualityConstant", "D", "qualityQueryParameter", "qualityParameterWithPrefixOrSuffix", "qualityParameter", "qualityPathParameter", "qualityMethodParameter", "getQualityMethodParameter$annotations", "qualityWildcard", "qualityMissing", "qualityTailcard", "qualityTransparent", "qualityFailedMethod", "qualityFailedParameter", "Lio/ktor/server/routing/RouteSelectorEvaluation$Failure;", "Failed", "Lio/ktor/server/routing/RouteSelectorEvaluation$Failure;", "getFailed", "()Lio/ktor/server/routing/RouteSelectorEvaluation$Failure;", "FailedPath", "getFailedPath", "FailedMethod", "getFailedMethod", "FailedParameter", "getFailedParameter", "FailedAcceptHeader", "getFailedAcceptHeader", "Missing", "Lio/ktor/server/routing/RouteSelectorEvaluation;", "getMissing", "()Lio/ktor/server/routing/RouteSelectorEvaluation;", "Constant", "getConstant", "Transparent", "getTransparent", "ConstantPath", "getConstantPath", "WildcardPath", "getWildcardPath", "ktor-server-core"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }

        public static /* synthetic */ void getQualityMethodParameter$annotations() {
        }

        public static /* synthetic */ RouteSelectorEvaluation invoke$default(Companion companion, boolean z10, double d10, Parameters parameters, int i10, int i11, Object obj) {
            if ((i11 & 4) != 0) {
                parameters = Parameters.INSTANCE.getEmpty();
            }
            Parameters parameters2 = parameters;
            if ((i11 & 8) != 0) {
                i10 = 0;
            }
            return companion.invoke(z10, d10, parameters2, i10);
        }

        public final RouteSelectorEvaluation getConstant() {
            return RouteSelectorEvaluation.Constant;
        }

        public final RouteSelectorEvaluation getConstantPath() {
            return RouteSelectorEvaluation.ConstantPath;
        }

        public final Failure getFailed() {
            return RouteSelectorEvaluation.Failed;
        }

        public final Failure getFailedAcceptHeader() {
            return RouteSelectorEvaluation.FailedAcceptHeader;
        }

        public final Failure getFailedMethod() {
            return RouteSelectorEvaluation.FailedMethod;
        }

        public final Failure getFailedParameter() {
            return RouteSelectorEvaluation.FailedParameter;
        }

        public final Failure getFailedPath() {
            return RouteSelectorEvaluation.FailedPath;
        }

        public final RouteSelectorEvaluation getMissing() {
            return RouteSelectorEvaluation.Missing;
        }

        public final RouteSelectorEvaluation getTransparent() {
            return RouteSelectorEvaluation.Transparent;
        }

        public final RouteSelectorEvaluation getWildcardPath() {
            return RouteSelectorEvaluation.WildcardPath;
        }

        public final RouteSelectorEvaluation invoke(boolean succeeded, double quality, Parameters parameters, int segmentIncrement) {
            kotlin.jvm.internal.p.i(parameters, "parameters");
            return succeeded ? new Success(quality, parameters, segmentIncrement) : new Failure(quality, HttpStatusCode.INSTANCE.getNotFound());
        }

        private Companion() {
        }
    }

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ$\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004HÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0014\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0017\u001a\u00020\u0016HÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0018R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0019\u001a\u0004\b\u001a\u0010\tR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u001b\u001a\u0004\b\u001c\u0010\u000b¨\u0006\u001d"}, d2 = {"Lio/ktor/server/routing/RouteSelectorEvaluation$Failure;", "Lio/ktor/server/routing/RouteSelectorEvaluation;", "", "quality", "Lio/ktor/http/HttpStatusCode;", "failureStatusCode", "<init>", "(DLio/ktor/http/HttpStatusCode;)V", "component1", "()D", "component2", "()Lio/ktor/http/HttpStatusCode;", ChatTracker.CLICK_COPY, "(DLio/ktor/http/HttpStatusCode;)Lio/ktor/server/routing/RouteSelectorEvaluation$Failure;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "D", "getQuality", "Lio/ktor/http/HttpStatusCode;", "getFailureStatusCode", "ktor-server-core"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final /* data */ class Failure extends RouteSelectorEvaluation {
        private final HttpStatusCode failureStatusCode;
        private final double quality;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Failure(double d10, HttpStatusCode failureStatusCode) {
            super(false, null);
            kotlin.jvm.internal.p.i(failureStatusCode, "failureStatusCode");
            this.quality = d10;
            this.failureStatusCode = failureStatusCode;
        }

        public static /* synthetic */ Failure copy$default(Failure failure, double d10, HttpStatusCode httpStatusCode, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                d10 = failure.quality;
            }
            if ((i10 & 2) != 0) {
                httpStatusCode = failure.failureStatusCode;
            }
            return failure.copy(d10, httpStatusCode);
        }

        /* renamed from: component1, reason: from getter */
        public final double getQuality() {
            return this.quality;
        }

        /* renamed from: component2, reason: from getter */
        public final HttpStatusCode getFailureStatusCode() {
            return this.failureStatusCode;
        }

        public final Failure copy(double quality, HttpStatusCode failureStatusCode) {
            kotlin.jvm.internal.p.i(failureStatusCode, "failureStatusCode");
            return new Failure(quality, failureStatusCode);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Failure)) {
                return false;
            }
            Failure failure = (Failure) other;
            return Double.compare(this.quality, failure.quality) == 0 && kotlin.jvm.internal.p.d(this.failureStatusCode, failure.failureStatusCode);
        }

        public final HttpStatusCode getFailureStatusCode() {
            return this.failureStatusCode;
        }

        public final double getQuality() {
            return this.quality;
        }

        public int hashCode() {
            return (Double.hashCode(this.quality) * 31) + this.failureStatusCode.hashCode();
        }

        public String toString() {
            return "Failure(quality=" + this.quality + ", failureStatusCode=" + this.failureStatusCode + ')';
        }
    }

    static {
        HttpStatusCode.Companion companion = HttpStatusCode.INSTANCE;
        Failed = new Failure(0.0d, companion.getNotFound());
        FailedPath = new Failure(0.0d, companion.getNotFound());
        FailedMethod = new Failure(0.02d, companion.getMethodNotAllowed());
        FailedParameter = new Failure(0.01d, companion.getBadRequest());
        FailedAcceptHeader = new Failure(0.01d, companion.getNotAcceptable());
        Missing = new Success(0.2d, null, 0, 6, null);
        Constant = new Success(1.0d, null, 0, 6, null);
        Transparent = new Success(-1.0d, null, 0, 6, null);
        ConstantPath = new Success(1.0d, null, 1, 2, null);
        WildcardPath = new Success(0.5d, null, 1, 2, null);
    }

    public /* synthetic */ RouteSelectorEvaluation(boolean z10, kotlin.jvm.internal.i iVar) {
        this(z10);
    }

    public final boolean getSucceeded() {
        return this.succeeded;
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ.\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u0006HÆ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0015\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012HÖ\u0003¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0017\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0017\u0010\u000fJ\u0010\u0010\u0019\u001a\u00020\u0018HÖ\u0001¢\u0006\u0004\b\u0019\u0010\u001aR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u001b\u001a\u0004\b\u001c\u0010\u000bR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u001d\u001a\u0004\b\u001e\u0010\rR\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u001f\u001a\u0004\b \u0010\u000f¨\u0006!"}, d2 = {"Lio/ktor/server/routing/RouteSelectorEvaluation$Success;", "Lio/ktor/server/routing/RouteSelectorEvaluation;", "", "quality", "Lio/ktor/http/Parameters;", "parameters", "", "segmentIncrement", "<init>", "(DLio/ktor/http/Parameters;I)V", "component1", "()D", "component2", "()Lio/ktor/http/Parameters;", "component3", "()I", ChatTracker.CLICK_COPY, "(DLio/ktor/http/Parameters;I)Lio/ktor/server/routing/RouteSelectorEvaluation$Success;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "", "toString", "()Ljava/lang/String;", "D", "getQuality", "Lio/ktor/http/Parameters;", "getParameters", "I", "getSegmentIncrement", "ktor-server-core"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final /* data */ class Success extends RouteSelectorEvaluation {
        private final Parameters parameters;
        private final double quality;
        private final int segmentIncrement;

        public /* synthetic */ Success(double d10, Parameters parameters, int i10, int i11, kotlin.jvm.internal.i iVar) {
            this(d10, (i11 & 2) != 0 ? Parameters.INSTANCE.getEmpty() : parameters, (i11 & 4) != 0 ? 0 : i10);
        }

        public static /* synthetic */ Success copy$default(Success success, double d10, Parameters parameters, int i10, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                d10 = success.quality;
            }
            if ((i11 & 2) != 0) {
                parameters = success.parameters;
            }
            if ((i11 & 4) != 0) {
                i10 = success.segmentIncrement;
            }
            return success.copy(d10, parameters, i10);
        }

        /* renamed from: component1, reason: from getter */
        public final double getQuality() {
            return this.quality;
        }

        /* renamed from: component2, reason: from getter */
        public final Parameters getParameters() {
            return this.parameters;
        }

        /* renamed from: component3, reason: from getter */
        public final int getSegmentIncrement() {
            return this.segmentIncrement;
        }

        public final Success copy(double quality, Parameters parameters, int segmentIncrement) {
            kotlin.jvm.internal.p.i(parameters, "parameters");
            return new Success(quality, parameters, segmentIncrement);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Success)) {
                return false;
            }
            Success success = (Success) other;
            return Double.compare(this.quality, success.quality) == 0 && kotlin.jvm.internal.p.d(this.parameters, success.parameters) && this.segmentIncrement == success.segmentIncrement;
        }

        public final Parameters getParameters() {
            return this.parameters;
        }

        public final double getQuality() {
            return this.quality;
        }

        public final int getSegmentIncrement() {
            return this.segmentIncrement;
        }

        public int hashCode() {
            return (((Double.hashCode(this.quality) * 31) + this.parameters.hashCode()) * 31) + Integer.hashCode(this.segmentIncrement);
        }

        public String toString() {
            return "Success(quality=" + this.quality + ", parameters=" + this.parameters + ", segmentIncrement=" + this.segmentIncrement + ')';
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Success(double d10, Parameters parameters, int i10) {
            super(true, null);
            kotlin.jvm.internal.p.i(parameters, "parameters");
            this.quality = d10;
            this.parameters = parameters;
            this.segmentIncrement = i10;
        }
    }

    private RouteSelectorEvaluation(boolean z10) {
        this.succeeded = z10;
    }
}
