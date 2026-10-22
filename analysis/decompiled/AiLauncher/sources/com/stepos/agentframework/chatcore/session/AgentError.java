package com.stepos.agentframework.chatcore.session;

import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0002\b\t\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0086\b\u0018\u0000 \u001d2\u00060\u0001j\u0002`\u0002:\u0001\u000bB#\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\t\u0010\nJ0\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\r\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u001a\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0016\u001a\u0004\b\u0017\u0010\u0010R\u001a\u0010\u0006\u001a\u00020\u00058\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u0018\u001a\u0004\b\u0019\u0010\u000eR\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\b\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c¨\u0006\u001e"}, d2 = {"Lcom/stepos/agentframework/chatcore/session/AgentError;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "", "code", "", "message", "", "cause", "<init>", "(ILjava/lang/String;Ljava/lang/Throwable;)V", Const.INTENT_KEY_APIKEY, "(ILjava/lang/String;Ljava/lang/Throwable;)Lcom/stepos/agentframework/chatcore/session/AgentError;", "toString", "()Ljava/lang/String;", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "I", "c", "Ljava/lang/String;", "getMessage", "Ljava/lang/Throwable;", "getCause", "()Ljava/lang/Throwable;", "Companion", "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class AgentError extends Exception {
    public static final int AGENT_ERROR_FILE_AUDIT_BLOCKED = 10105;
    public static final int AGENT_ERROR_FILE_UPLOAD = 10098;
    public static final int ERROR_CODE_AGENT_OFFLINE = 10106;
    public static final int ERROR_CODE_CONTENT_FILTER = 10105;
    public static final int ERROR_CODE_CONTENT_PREPROCESSING_ERROR = 10103;
    public static final int ERROR_CODE_INIT = 10091;
    public static final int ERROR_CODE_MESSAGE_ID = 10100;
    public static final int ERROR_CODE_NETWORK = 10092;
    public static final int ERROR_CODE_NETWORK_TIMEOUT = 10093;
    public static final int ERROR_CODE_NO_PERMISSION = 10095;
    public static final int ERROR_CODE_NO_RESPONSE = 10096;
    public static final int ERROR_CODE_RESOURCE_FAIL = 10108;
    public static final int ERROR_CODE_STEPAI_ACCOUNT_UNBOUND = 10107;
    public static final int ERROR_CODE_STREAM_CANCEL = 10099;
    public static final int ERROR_CODE_TASK_ERROR = 10101;
    public static final int ERROR_CODE_TOOL_ERROR = 10102;
    public static final int ERROR_CODE_UNKNOWN = 10097;
    public static final int ERROR_CODE__TOOL_EXECUTION = 10094;
    public static final int USER_CANCEL = 10104;
    private final Throwable cause;
    private final int code;
    private final String message;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AgentError(int i10, String message, Throwable th) {
        super(message, th);
        kotlin.jvm.internal.p.i(message, "message");
        this.code = i10;
        this.message = message;
        this.cause = th;
    }

    public static /* synthetic */ AgentError b(AgentError agentError, int i10, String str, Throwable th, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i10 = agentError.code;
        }
        if ((i11 & 2) != 0) {
            str = agentError.message;
        }
        if ((i11 & 4) != 0) {
            th = agentError.cause;
        }
        return agentError.a(i10, str, th);
    }

    public final AgentError a(int code, String message, Throwable cause) {
        kotlin.jvm.internal.p.i(message, "message");
        return new AgentError(code, message, cause);
    }

    /* renamed from: c, reason: from getter */
    public final int getCode() {
        return this.code;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AgentError)) {
            return false;
        }
        AgentError agentError = (AgentError) other;
        return this.code == agentError.code && kotlin.jvm.internal.p.d(this.message, agentError.message) && kotlin.jvm.internal.p.d(this.cause, agentError.cause);
    }

    @Override // java.lang.Throwable
    public Throwable getCause() {
        return this.cause;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return this.message;
    }

    public int hashCode() {
        int iHashCode = ((Integer.hashCode(this.code) * 31) + this.message.hashCode()) * 31;
        Throwable th = this.cause;
        return iHashCode + (th == null ? 0 : th.hashCode());
    }

    @Override // java.lang.Throwable
    public String toString() {
        return "AgentError(code=" + this.code + ", message=" + this.message + ", cause=" + this.cause + ")";
    }

    public /* synthetic */ AgentError(int i10, String str, Throwable th, int i11, kotlin.jvm.internal.i iVar) {
        this(i10, str, (i11 & 4) != 0 ? null : th);
    }
}
