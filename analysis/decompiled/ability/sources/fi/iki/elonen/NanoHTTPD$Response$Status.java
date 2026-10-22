package fi.iki.elonen;

import androidx.compose.runtime.ComposerKt;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.stepos.ability.mcpserver.model.McpErrorCode;
import z7.InterfaceC2187h;

/* loaded from: classes2.dex */
public enum NanoHTTPD$Response$Status implements InterfaceC2187h {
    /* JADX INFO: Fake field, exist only in values array */
    EXPECTATION_FAILED(101, "Switching Protocols"),
    OK(200, "OK"),
    /* JADX INFO: Fake field, exist only in values array */
    CREATED(ComposerKt.providerKey, "Created"),
    ACCEPTED(ComposerKt.compositionLocalMapKey, "Accepted"),
    /* JADX INFO: Fake field, exist only in values array */
    NO_CONTENT(ComposerKt.providerMapsKey, "No Content"),
    /* JADX INFO: Fake field, exist only in values array */
    PARTIAL_CONTENT(ComposerKt.referenceKey, "Partial Content"),
    /* JADX INFO: Fake field, exist only in values array */
    MULTI_STATUS(ComposerKt.reuseKey, "Multi-Status"),
    /* JADX INFO: Fake field, exist only in values array */
    REDIRECT(301, "Moved Permanently"),
    /* JADX INFO: Fake field, exist only in values array */
    FOUND(302, "Found"),
    /* JADX INFO: Fake field, exist only in values array */
    REDIRECT_SEE_OTHER(303, "See Other"),
    /* JADX INFO: Fake field, exist only in values array */
    NOT_MODIFIED(304, "Not Modified"),
    /* JADX INFO: Fake field, exist only in values array */
    TEMPORARY_REDIRECT(307, "Temporary Redirect"),
    BAD_REQUEST(400, "Bad Request"),
    UNAUTHORIZED(401, "Unauthorized"),
    /* JADX INFO: Fake field, exist only in values array */
    FORBIDDEN(403, "Forbidden"),
    NOT_FOUND(McpErrorCode.TOOL_NOT_FOUND, "Not Found"),
    METHOD_NOT_ALLOWED(405, "Method Not Allowed"),
    /* JADX INFO: Fake field, exist only in values array */
    NOT_IMPLEMENTED(406, "Not Acceptable"),
    /* JADX INFO: Fake field, exist only in values array */
    EXPECTATION_FAILED(McpErrorCode.TIMEOUT, "Request Timeout"),
    /* JADX INFO: Fake field, exist only in values array */
    NOT_IMPLEMENTED(409, "Conflict"),
    /* JADX INFO: Fake field, exist only in values array */
    EXPECTATION_FAILED(410, "Gone"),
    /* JADX INFO: Fake field, exist only in values array */
    NOT_IMPLEMENTED(411, "Length Required"),
    /* JADX INFO: Fake field, exist only in values array */
    EXPECTATION_FAILED(412, "Precondition Failed"),
    /* JADX INFO: Fake field, exist only in values array */
    NOT_IMPLEMENTED(413, "Payload Too Large"),
    /* JADX INFO: Fake field, exist only in values array */
    EXPECTATION_FAILED(415, "Unsupported Media Type"),
    /* JADX INFO: Fake field, exist only in values array */
    NOT_IMPLEMENTED(TypedValues.CycleType.TYPE_PATH_ROTATE, "Requested Range Not Satisfiable"),
    /* JADX INFO: Fake field, exist only in values array */
    EXPECTATION_FAILED(417, "Expectation Failed"),
    /* JADX INFO: Fake field, exist only in values array */
    NOT_IMPLEMENTED(McpErrorCode.RATE_LIMITED, "Too Many Requests"),
    INTERNAL_ERROR(500, "Internal Server Error"),
    /* JADX INFO: Fake field, exist only in values array */
    NOT_IMPLEMENTED(TypedValues.PositionType.TYPE_TRANSITION_EASING, "Not Implemented"),
    SERVICE_UNAVAILABLE(503, "Service Unavailable"),
    /* JADX INFO: Fake field, exist only in values array */
    UNSUPPORTED_HTTP_VERSION(TypedValues.PositionType.TYPE_SIZE_PERCENT, "HTTP Version Not Supported");


    /* renamed from: a, reason: collision with root package name */
    public final int f4452a;
    public final String b;

    NanoHTTPD$Response$Status(int i, String str) {
        this.f4452a = i;
        this.b = str;
    }

    @Override // z7.InterfaceC2187h
    public final String getDescription() {
        return "" + this.f4452a + " " + this.b;
    }
}
