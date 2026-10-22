package stepai.aios.guiexecutor.input;

import B7.a;
import androidx.core.location.LocationRequestCompat;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.taskrobot.llmapi.stepfun.InjectExperienceResult;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010$\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u0000 +2\u00020\u0001:\u0001+BW\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\u0014\b\u0002\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\f¢\u0006\u0004\b\r\u0010\u000eJ\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0006HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010#\u001a\u00020\nHÆ\u0003J\u0015\u0010$\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\fHÆ\u0003J_\u0010%\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\t\u001a\u00020\n2\u0014\b\u0002\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\fHÆ\u0001J\u0013\u0010&\u001a\u00020\u001b2\b\u0010'\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010(\u001a\u00020)HÖ\u0001J\t\u0010*\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0010R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0010R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u001d\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u001a\u001a\u00020\u001b8F¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001cR\u0011\u0010\u001d\u001a\u00020\u001b8F¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001c¨\u0006,"}, d2 = {"Lstepai/aios/guiexecutor/input/UserInputResponse;", "", "requestId", "", "sessionId", "status", "Lstepai/aios/guiexecutor/input/UserInputStatus;", "input", "errorMessage", "timestamp", "", "metadata", "", AppAgent.CONSTRUCT, "(Ljava/lang/String;Ljava/lang/String;Lstepai/aios/guiexecutor/input/UserInputStatus;Ljava/lang/String;Ljava/lang/String;JLjava/util/Map;)V", "getRequestId", "()Ljava/lang/String;", "getSessionId", "getStatus", "()Lstepai/aios/guiexecutor/input/UserInputStatus;", "getInput", "getErrorMessage", "getTimestamp", "()J", "getMetadata", "()Ljava/util/Map;", "isSuccess", "", "()Z", "isFailure", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "other", "hashCode", "", "toString", "Companion", "guiagent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class UserInputResponse {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String errorMessage;
    private final String input;
    private final Map<String, Object> metadata;
    private final String requestId;
    private final String sessionId;
    private final UserInputStatus status;
    private final long timestamp;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u0007J\u0018\u0010\n\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u0007J\u0018\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u0007J \u0010\f\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u0007J \u0010\u000e\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u0007¨\u0006\u000f"}, d2 = {"Lstepai/aios/guiexecutor/input/UserInputResponse$Companion;", "", AppAgent.CONSTRUCT, "()V", "success", "Lstepai/aios/guiexecutor/input/UserInputResponse;", "sessionId", "", "input", "requestId", InjectExperienceResult.REASON_TIMEOUT, "cancelled", "error", "errorMessage", "validationFailed", "guiagent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(e eVar) {
            this();
        }

        public static /* synthetic */ UserInputResponse cancelled$default(Companion companion, String str, String str2, int i, Object obj) {
            if ((i & 2) != 0) {
                str2 = "";
            }
            return companion.cancelled(str, str2);
        }

        public static /* synthetic */ UserInputResponse error$default(Companion companion, String str, String str2, String str3, int i, Object obj) {
            if ((i & 4) != 0) {
                str3 = "";
            }
            return companion.error(str, str2, str3);
        }

        public static /* synthetic */ UserInputResponse success$default(Companion companion, String str, String str2, String str3, int i, Object obj) {
            if ((i & 4) != 0) {
                str3 = "";
            }
            return companion.success(str, str2, str3);
        }

        public static /* synthetic */ UserInputResponse timeout$default(Companion companion, String str, String str2, int i, Object obj) {
            if ((i & 2) != 0) {
                str2 = "";
            }
            return companion.timeout(str, str2);
        }

        public static /* synthetic */ UserInputResponse validationFailed$default(Companion companion, String str, String str2, String str3, int i, Object obj) {
            if ((i & 4) != 0) {
                str3 = "";
            }
            return companion.validationFailed(str, str2, str3);
        }

        public final UserInputResponse cancelled(String sessionId, String requestId) {
            k.f(sessionId, "sessionId");
            k.f(requestId, "requestId");
            return new UserInputResponse(requestId, sessionId, UserInputStatus.CANCELLED, null, "User cancelled input", 0L, null, LocationRequestCompat.QUALITY_LOW_POWER, null);
        }

        public final UserInputResponse error(String sessionId, String errorMessage, String requestId) {
            k.f(sessionId, "sessionId");
            k.f(errorMessage, "errorMessage");
            k.f(requestId, "requestId");
            return new UserInputResponse(requestId, sessionId, UserInputStatus.ERROR, null, errorMessage, 0L, null, LocationRequestCompat.QUALITY_LOW_POWER, null);
        }

        public final UserInputResponse success(String sessionId, String input, String requestId) {
            k.f(sessionId, "sessionId");
            k.f(input, "input");
            k.f(requestId, "requestId");
            return new UserInputResponse(requestId, sessionId, UserInputStatus.SUCCESS, input, null, 0L, null, 112, null);
        }

        public final UserInputResponse timeout(String sessionId, String requestId) {
            k.f(sessionId, "sessionId");
            k.f(requestId, "requestId");
            return new UserInputResponse(requestId, sessionId, UserInputStatus.TIMEOUT, null, "User input timed out", 0L, null, LocationRequestCompat.QUALITY_LOW_POWER, null);
        }

        public final UserInputResponse validationFailed(String sessionId, String errorMessage, String requestId) {
            k.f(sessionId, "sessionId");
            k.f(errorMessage, "errorMessage");
            k.f(requestId, "requestId");
            return new UserInputResponse(requestId, sessionId, UserInputStatus.VALIDATION_FAILED, null, errorMessage, 0L, null, LocationRequestCompat.QUALITY_LOW_POWER, null);
        }

        private Companion() {
        }
    }

    public UserInputResponse(String requestId, String sessionId, UserInputStatus status, String str, String str2, long j5, Map<String, ? extends Object> metadata) {
        k.f(requestId, "requestId");
        k.f(sessionId, "sessionId");
        k.f(status, "status");
        k.f(metadata, "metadata");
        this.requestId = requestId;
        this.sessionId = sessionId;
        this.status = status;
        this.input = str;
        this.errorMessage = str2;
        this.timestamp = j5;
        this.metadata = metadata;
    }

    public static /* synthetic */ UserInputResponse copy$default(UserInputResponse userInputResponse, String str, String str2, UserInputStatus userInputStatus, String str3, String str4, long j5, Map map, int i, Object obj) {
        if ((i & 1) != 0) {
            str = userInputResponse.requestId;
        }
        if ((i & 2) != 0) {
            str2 = userInputResponse.sessionId;
        }
        if ((i & 4) != 0) {
            userInputStatus = userInputResponse.status;
        }
        if ((i & 8) != 0) {
            str3 = userInputResponse.input;
        }
        if ((i & 16) != 0) {
            str4 = userInputResponse.errorMessage;
        }
        if ((i & 32) != 0) {
            j5 = userInputResponse.timestamp;
        }
        if ((i & 64) != 0) {
            map = userInputResponse.metadata;
        }
        Map map2 = map;
        long j6 = j5;
        String str5 = str4;
        UserInputStatus userInputStatus2 = userInputStatus;
        return userInputResponse.copy(str, str2, userInputStatus2, str3, str5, j6, map2);
    }

    /* renamed from: component1, reason: from getter */
    public final String getRequestId() {
        return this.requestId;
    }

    /* renamed from: component2, reason: from getter */
    public final String getSessionId() {
        return this.sessionId;
    }

    /* renamed from: component3, reason: from getter */
    public final UserInputStatus getStatus() {
        return this.status;
    }

    /* renamed from: component4, reason: from getter */
    public final String getInput() {
        return this.input;
    }

    /* renamed from: component5, reason: from getter */
    public final String getErrorMessage() {
        return this.errorMessage;
    }

    /* renamed from: component6, reason: from getter */
    public final long getTimestamp() {
        return this.timestamp;
    }

    public final Map<String, Object> component7() {
        return this.metadata;
    }

    public final UserInputResponse copy(String requestId, String sessionId, UserInputStatus status, String input, String errorMessage, long timestamp, Map<String, ? extends Object> metadata) {
        k.f(requestId, "requestId");
        k.f(sessionId, "sessionId");
        k.f(status, "status");
        k.f(metadata, "metadata");
        return new UserInputResponse(requestId, sessionId, status, input, errorMessage, timestamp, metadata);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof UserInputResponse)) {
            return false;
        }
        UserInputResponse userInputResponse = (UserInputResponse) other;
        return k.b(this.requestId, userInputResponse.requestId) && k.b(this.sessionId, userInputResponse.sessionId) && this.status == userInputResponse.status && k.b(this.input, userInputResponse.input) && k.b(this.errorMessage, userInputResponse.errorMessage) && this.timestamp == userInputResponse.timestamp && k.b(this.metadata, userInputResponse.metadata);
    }

    public final String getErrorMessage() {
        return this.errorMessage;
    }

    public final String getInput() {
        return this.input;
    }

    public final Map<String, Object> getMetadata() {
        return this.metadata;
    }

    public final String getRequestId() {
        return this.requestId;
    }

    public final String getSessionId() {
        return this.sessionId;
    }

    public final UserInputStatus getStatus() {
        return this.status;
    }

    public final long getTimestamp() {
        return this.timestamp;
    }

    public int hashCode() {
        int iHashCode = (this.status.hashCode() + a.c(this.requestId.hashCode() * 31, 31, this.sessionId)) * 31;
        String str = this.input;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.errorMessage;
        return this.metadata.hashCode() + androidx.appfunctions.metadata.a.c((iHashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31, 31, this.timestamp);
    }

    public final boolean isFailure() {
        return !isSuccess();
    }

    public final boolean isSuccess() {
        return this.status == UserInputStatus.SUCCESS;
    }

    public String toString() {
        String str = this.requestId;
        String str2 = this.sessionId;
        UserInputStatus userInputStatus = this.status;
        String str3 = this.input;
        String str4 = this.errorMessage;
        long j5 = this.timestamp;
        Map<String, Object> map = this.metadata;
        StringBuilder sbW = a.w("UserInputResponse(requestId=", str, ", sessionId=", str2, ", status=");
        sbW.append(userInputStatus);
        sbW.append(", input=");
        sbW.append(str3);
        sbW.append(", errorMessage=");
        a.y(j5, str4, ", timestamp=", sbW);
        sbW.append(", metadata=");
        sbW.append(map);
        sbW.append(")");
        return sbW.toString();
    }

    public /* synthetic */ UserInputResponse(String str, String str2, UserInputStatus userInputStatus, String str3, String str4, long j5, Map map, int i, e eVar) {
        this(str, str2, userInputStatus, (i & 8) != 0 ? null : str3, (i & 16) != 0 ? null : str4, (i & 32) != 0 ? System.currentTimeMillis() : j5, (i & 64) != 0 ? kotlin.collections.a.M() : map);
    }
}
