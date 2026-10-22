package stepai.aios.guiexecutor.api;

import B7.a;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.taskrobot.llmapi.stepfun.InjectExperienceResult;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010$\n\u0002\b\u0015\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u0000 #2\u00020\u0001:\u0001#BC\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\u0014\b\u0002\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u000b¢\u0006\u0004\b\f\u0010\rJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\t\u0010\u001b\u001a\u00020\tHÆ\u0003J\u0015\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u000bHÆ\u0003JI\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\u0014\b\u0002\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u000bHÆ\u0001J\u0013\u0010\u001e\u001a\u00020\t2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001a\u00020!HÖ\u0001J\t\u0010\"\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u001d\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006$"}, d2 = {"Lstepai/aios/guiexecutor/api/GuiError;", "", "code", "Lstepai/aios/guiexecutor/api/ErrorCode;", "message", "", "cause", "", "recoverable", "", "context", "", AppAgent.CONSTRUCT, "(Lstepai/aios/guiexecutor/api/ErrorCode;Ljava/lang/String;Ljava/lang/Throwable;ZLjava/util/Map;)V", "getCode", "()Lstepai/aios/guiexecutor/api/ErrorCode;", "getMessage", "()Ljava/lang/String;", "getCause", "()Ljava/lang/Throwable;", "getRecoverable", "()Z", "getContext", "()Ljava/util/Map;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "", "toString", "Companion", "guiagent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class GuiError {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final Throwable cause;
    private final ErrorCode code;
    private final Map<String, Object> context;
    private final String message;
    private final boolean recoverable;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0003\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007J\u0010\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007J\u0010\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007J\u0010\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007J\u0010\u0010\u000b\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007J\u001a\u0010\f\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e¨\u0006\u000f"}, d2 = {"Lstepai/aios/guiexecutor/api/GuiError$Companion;", "", AppAgent.CONSTRUCT, "()V", "targetNotFound", "Lstepai/aios/guiexecutor/api/GuiError;", "message", "", "accessibilityDisabled", "permissionDenied", InjectExperienceResult.REASON_TIMEOUT, "invalidParameter", "systemError", "cause", "", "guiagent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(e eVar) {
            this();
        }

        public static /* synthetic */ GuiError accessibilityDisabled$default(Companion companion, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = "Accessibility service disabled";
            }
            return companion.accessibilityDisabled(str);
        }

        public static /* synthetic */ GuiError invalidParameter$default(Companion companion, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = "Invalid parameter";
            }
            return companion.invalidParameter(str);
        }

        public static /* synthetic */ GuiError permissionDenied$default(Companion companion, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = "Permission denied";
            }
            return companion.permissionDenied(str);
        }

        public static /* synthetic */ GuiError systemError$default(Companion companion, String str, Throwable th, int i, Object obj) {
            if ((i & 2) != 0) {
                th = null;
            }
            return companion.systemError(str, th);
        }

        public static /* synthetic */ GuiError targetNotFound$default(Companion companion, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = "Target not found";
            }
            return companion.targetNotFound(str);
        }

        public static /* synthetic */ GuiError timeout$default(Companion companion, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = "Operation timeout";
            }
            return companion.timeout(str);
        }

        public final GuiError accessibilityDisabled(String message) {
            k.f(message, "message");
            return new GuiError(ErrorCode.ACCESSIBILITY_DISABLED, message, null, true, null, 20, null);
        }

        public final GuiError invalidParameter(String message) {
            k.f(message, "message");
            return new GuiError(ErrorCode.INVALID_PARAMETER, message, null, false, null, 20, null);
        }

        public final GuiError permissionDenied(String message) {
            k.f(message, "message");
            return new GuiError(ErrorCode.PERMISSION_DENIED, message, null, false, null, 20, null);
        }

        public final GuiError systemError(String message, Throwable cause) {
            k.f(message, "message");
            return new GuiError(ErrorCode.SYSTEM_ERROR, message, cause, false, null, 16, null);
        }

        public final GuiError targetNotFound(String message) {
            k.f(message, "message");
            return new GuiError(ErrorCode.TARGET_NOT_FOUND, message, null, true, null, 20, null);
        }

        public final GuiError timeout(String message) {
            k.f(message, "message");
            return new GuiError(ErrorCode.TIMEOUT, message, null, true, null, 20, null);
        }

        private Companion() {
        }
    }

    public GuiError(ErrorCode code, String message, Throwable th, boolean z10, Map<String, ? extends Object> context) {
        k.f(code, "code");
        k.f(message, "message");
        k.f(context, "context");
        this.code = code;
        this.message = message;
        this.cause = th;
        this.recoverable = z10;
        this.context = context;
    }

    public static /* synthetic */ GuiError copy$default(GuiError guiError, ErrorCode errorCode, String str, Throwable th, boolean z10, Map map, int i, Object obj) {
        if ((i & 1) != 0) {
            errorCode = guiError.code;
        }
        if ((i & 2) != 0) {
            str = guiError.message;
        }
        if ((i & 4) != 0) {
            th = guiError.cause;
        }
        if ((i & 8) != 0) {
            z10 = guiError.recoverable;
        }
        if ((i & 16) != 0) {
            map = guiError.context;
        }
        Map map2 = map;
        Throwable th2 = th;
        return guiError.copy(errorCode, str, th2, z10, map2);
    }

    /* renamed from: component1, reason: from getter */
    public final ErrorCode getCode() {
        return this.code;
    }

    /* renamed from: component2, reason: from getter */
    public final String getMessage() {
        return this.message;
    }

    /* renamed from: component3, reason: from getter */
    public final Throwable getCause() {
        return this.cause;
    }

    /* renamed from: component4, reason: from getter */
    public final boolean getRecoverable() {
        return this.recoverable;
    }

    public final Map<String, Object> component5() {
        return this.context;
    }

    public final GuiError copy(ErrorCode code, String message, Throwable cause, boolean recoverable, Map<String, ? extends Object> context) {
        k.f(code, "code");
        k.f(message, "message");
        k.f(context, "context");
        return new GuiError(code, message, cause, recoverable, context);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GuiError)) {
            return false;
        }
        GuiError guiError = (GuiError) other;
        return this.code == guiError.code && k.b(this.message, guiError.message) && k.b(this.cause, guiError.cause) && this.recoverable == guiError.recoverable && k.b(this.context, guiError.context);
    }

    public final Throwable getCause() {
        return this.cause;
    }

    public final ErrorCode getCode() {
        return this.code;
    }

    public final Map<String, Object> getContext() {
        return this.context;
    }

    public final String getMessage() {
        return this.message;
    }

    public final boolean getRecoverable() {
        return this.recoverable;
    }

    public int hashCode() {
        int iC = a.c(this.code.hashCode() * 31, 31, this.message);
        Throwable th = this.cause;
        return this.context.hashCode() + androidx.appfunctions.metadata.a.d((iC + (th == null ? 0 : th.hashCode())) * 31, 31, this.recoverable);
    }

    public String toString() {
        return "GuiError(code=" + this.code + ", message=" + this.message + ", cause=" + this.cause + ", recoverable=" + this.recoverable + ", context=" + this.context + ")";
    }

    public /* synthetic */ GuiError(ErrorCode errorCode, String str, Throwable th, boolean z10, Map map, int i, e eVar) {
        this(errorCode, str, (i & 4) != 0 ? null : th, (i & 8) != 0 ? false : z10, (i & 16) != 0 ? kotlin.collections.a.M() : map);
    }
}
