package stepai.aios.guiexecutor.input;

import W7.c;
import Y7.f;
import androidx.appfunctions.metadata.a;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.taskrobot.llmapi.stepfun.InjectExperienceResult;
import g1.AbstractC1451a;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u001e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u0000 52\u00020\u0001:\u00015B}\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\u0014\b\u0002\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u0011¢\u0006\u0004\b\u0012\u0010\u0013J\t\u0010$\u001a\u00020\u0003HÆ\u0003J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\t\u0010&\u001a\u00020\u0003HÆ\u0003J\t\u0010'\u001a\u00020\u0007HÆ\u0003J\t\u0010(\u001a\u00020\tHÆ\u0003J\u0011\u0010)\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000bHÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\rHÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010-\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u0011HÆ\u0003J\u0087\u0001\u0010.\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00032\u0014\b\u0002\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u0011HÆ\u0001J\u0013\u0010/\u001a\u0002002\b\u00101\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00102\u001a\u000203HÖ\u0001J\t\u00104\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0015R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0015R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0019\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0013\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0015R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0015R\u001d\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u0011¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#¨\u00066"}, d2 = {"Lstepai/aios/guiexecutor/input/UserInputRequest;", "", "requestId", "", "sessionId", "message", "inputType", "Lstepai/aios/guiexecutor/input/UserInputType;", InjectExperienceResult.REASON_TIMEOUT, "", "options", "", "validation", "Lstepai/aios/guiexecutor/input/InputValidation;", "defaultValue", "placeholder", "metadata", "", AppAgent.CONSTRUCT, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lstepai/aios/guiexecutor/input/UserInputType;JLjava/util/List;Lstepai/aios/guiexecutor/input/InputValidation;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)V", "getRequestId", "()Ljava/lang/String;", "getSessionId", "getMessage", "getInputType", "()Lstepai/aios/guiexecutor/input/UserInputType;", "getTimeout", "()J", "getOptions", "()Ljava/util/List;", "getValidation", "()Lstepai/aios/guiexecutor/input/InputValidation;", "getDefaultValue", "getPlaceholder", "getMetadata", "()Ljava/util/Map;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "copy", "equals", "", "other", "hashCode", "", "toString", "Companion", "guiagent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class UserInputRequest {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String defaultValue;
    private final UserInputType inputType;
    private final String message;
    private final Map<String, Object> metadata;
    private final List<String> options;
    private final String placeholder;
    private final String requestId;
    private final String sessionId;
    private final long timeout;
    private final InputValidation validation;

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005J*\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r¨\u0006\u000e"}, d2 = {"Lstepai/aios/guiexecutor/input/UserInputRequest$Companion;", "", AppAgent.CONSTRUCT, "()V", "generateRequestId", "", "text", "Lstepai/aios/guiexecutor/input/UserInputRequest;", "sessionId", "message", InjectExperienceResult.REASON_TIMEOUT, "", "validation", "Lstepai/aios/guiexecutor/input/InputValidation;", "guiagent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(e eVar) {
            this();
        }

        public static /* synthetic */ UserInputRequest text$default(Companion companion, String str, String str2, long j5, InputValidation inputValidation, int i, Object obj) {
            if ((i & 8) != 0) {
                inputValidation = null;
            }
            return companion.text(str, str2, j5, inputValidation);
        }

        public final String generateRequestId() {
            return "input_req_" + System.currentTimeMillis() + "_" + AbstractC1451a.R(c.f1492a, new f(1000, 9999, 1));
        }

        public final UserInputRequest text(String sessionId, String message, long timeout, InputValidation validation) {
            k.f(sessionId, "sessionId");
            k.f(message, "message");
            return new UserInputRequest(generateRequestId(), sessionId, message, UserInputType.TEXT, timeout, null, validation, null, null, null, 928, null);
        }

        private Companion() {
        }
    }

    public UserInputRequest(String requestId, String sessionId, String message, UserInputType inputType, long j5, List<String> list, InputValidation inputValidation, String str, String str2, Map<String, ? extends Object> metadata) {
        k.f(requestId, "requestId");
        k.f(sessionId, "sessionId");
        k.f(message, "message");
        k.f(inputType, "inputType");
        k.f(metadata, "metadata");
        this.requestId = requestId;
        this.sessionId = sessionId;
        this.message = message;
        this.inputType = inputType;
        this.timeout = j5;
        this.options = list;
        this.validation = inputValidation;
        this.defaultValue = str;
        this.placeholder = str2;
        this.metadata = metadata;
    }

    public static /* synthetic */ UserInputRequest copy$default(UserInputRequest userInputRequest, String str, String str2, String str3, UserInputType userInputType, long j5, List list, InputValidation inputValidation, String str4, String str5, Map map, int i, Object obj) {
        if ((i & 1) != 0) {
            str = userInputRequest.requestId;
        }
        if ((i & 2) != 0) {
            str2 = userInputRequest.sessionId;
        }
        if ((i & 4) != 0) {
            str3 = userInputRequest.message;
        }
        if ((i & 8) != 0) {
            userInputType = userInputRequest.inputType;
        }
        if ((i & 16) != 0) {
            j5 = userInputRequest.timeout;
        }
        if ((i & 32) != 0) {
            list = userInputRequest.options;
        }
        if ((i & 64) != 0) {
            inputValidation = userInputRequest.validation;
        }
        if ((i & 128) != 0) {
            str4 = userInputRequest.defaultValue;
        }
        if ((i & 256) != 0) {
            str5 = userInputRequest.placeholder;
        }
        if ((i & 512) != 0) {
            map = userInputRequest.metadata;
        }
        Map map2 = map;
        String str6 = str4;
        List list2 = list;
        long j6 = j5;
        String str7 = str3;
        UserInputType userInputType2 = userInputType;
        return userInputRequest.copy(str, str2, str7, userInputType2, j6, list2, inputValidation, str6, str5, map2);
    }

    /* renamed from: component1, reason: from getter */
    public final String getRequestId() {
        return this.requestId;
    }

    public final Map<String, Object> component10() {
        return this.metadata;
    }

    /* renamed from: component2, reason: from getter */
    public final String getSessionId() {
        return this.sessionId;
    }

    /* renamed from: component3, reason: from getter */
    public final String getMessage() {
        return this.message;
    }

    /* renamed from: component4, reason: from getter */
    public final UserInputType getInputType() {
        return this.inputType;
    }

    /* renamed from: component5, reason: from getter */
    public final long getTimeout() {
        return this.timeout;
    }

    public final List<String> component6() {
        return this.options;
    }

    /* renamed from: component7, reason: from getter */
    public final InputValidation getValidation() {
        return this.validation;
    }

    /* renamed from: component8, reason: from getter */
    public final String getDefaultValue() {
        return this.defaultValue;
    }

    /* renamed from: component9, reason: from getter */
    public final String getPlaceholder() {
        return this.placeholder;
    }

    public final UserInputRequest copy(String requestId, String sessionId, String message, UserInputType inputType, long timeout, List<String> options, InputValidation validation, String defaultValue, String placeholder, Map<String, ? extends Object> metadata) {
        k.f(requestId, "requestId");
        k.f(sessionId, "sessionId");
        k.f(message, "message");
        k.f(inputType, "inputType");
        k.f(metadata, "metadata");
        return new UserInputRequest(requestId, sessionId, message, inputType, timeout, options, validation, defaultValue, placeholder, metadata);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof UserInputRequest)) {
            return false;
        }
        UserInputRequest userInputRequest = (UserInputRequest) other;
        return k.b(this.requestId, userInputRequest.requestId) && k.b(this.sessionId, userInputRequest.sessionId) && k.b(this.message, userInputRequest.message) && this.inputType == userInputRequest.inputType && this.timeout == userInputRequest.timeout && k.b(this.options, userInputRequest.options) && k.b(this.validation, userInputRequest.validation) && k.b(this.defaultValue, userInputRequest.defaultValue) && k.b(this.placeholder, userInputRequest.placeholder) && k.b(this.metadata, userInputRequest.metadata);
    }

    public final String getDefaultValue() {
        return this.defaultValue;
    }

    public final UserInputType getInputType() {
        return this.inputType;
    }

    public final String getMessage() {
        return this.message;
    }

    public final Map<String, Object> getMetadata() {
        return this.metadata;
    }

    public final List<String> getOptions() {
        return this.options;
    }

    public final String getPlaceholder() {
        return this.placeholder;
    }

    public final String getRequestId() {
        return this.requestId;
    }

    public final String getSessionId() {
        return this.sessionId;
    }

    public final long getTimeout() {
        return this.timeout;
    }

    public final InputValidation getValidation() {
        return this.validation;
    }

    public int hashCode() {
        int iC = a.c((this.inputType.hashCode() + B7.a.c(B7.a.c(this.requestId.hashCode() * 31, 31, this.sessionId), 31, this.message)) * 31, 31, this.timeout);
        List<String> list = this.options;
        int iHashCode = (iC + (list == null ? 0 : list.hashCode())) * 31;
        InputValidation inputValidation = this.validation;
        int iHashCode2 = (iHashCode + (inputValidation == null ? 0 : inputValidation.hashCode())) * 31;
        String str = this.defaultValue;
        int iHashCode3 = (iHashCode2 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.placeholder;
        return this.metadata.hashCode() + ((iHashCode3 + (str2 != null ? str2.hashCode() : 0)) * 31);
    }

    public String toString() {
        String str = this.requestId;
        String str2 = this.sessionId;
        String str3 = this.message;
        UserInputType userInputType = this.inputType;
        long j5 = this.timeout;
        List<String> list = this.options;
        InputValidation inputValidation = this.validation;
        String str4 = this.defaultValue;
        String str5 = this.placeholder;
        Map<String, Object> map = this.metadata;
        StringBuilder sbW = B7.a.w("UserInputRequest(requestId=", str, ", sessionId=", str2, ", message=");
        sbW.append(str3);
        sbW.append(", inputType=");
        sbW.append(userInputType);
        sbW.append(", timeout=");
        sbW.append(j5);
        sbW.append(", options=");
        sbW.append(list);
        sbW.append(", validation=");
        sbW.append(inputValidation);
        sbW.append(", defaultValue=");
        sbW.append(str4);
        sbW.append(", placeholder=");
        sbW.append(str5);
        sbW.append(", metadata=");
        sbW.append(map);
        sbW.append(")");
        return sbW.toString();
    }

    public /* synthetic */ UserInputRequest(String str, String str2, String str3, UserInputType userInputType, long j5, List list, InputValidation inputValidation, String str4, String str5, Map map, int i, e eVar) {
        this(str, str2, str3, (i & 8) != 0 ? UserInputType.TEXT : userInputType, j5, (i & 32) != 0 ? null : list, (i & 64) != 0 ? null : inputValidation, (i & 128) != 0 ? null : str4, (i & 256) != 0 ? null : str5, (i & 512) != 0 ? kotlin.collections.a.M() : map);
    }
}
