package stepai.aios.guiagent.llm;

import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.aiengine.update.AlgorithmUpdateBundle;
import kotlin.Metadata;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00060\u0001j\u0002`\u0002:\u000b\t\n\u000b\f\r\u000e\u000f\u0010\u0011\u0012\u0013B\u001d\b\u0004\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\b\u0082\u0001\u000b\u0014\u0015\u0016\u0017\u0018\u0019\u001a\u001b\u001c\u001d\u001e¨\u0006\u001f"}, d2 = {"Lstepai/aios/guiagent/llm/LlmException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "message", "", "cause", "", AppAgent.CONSTRUCT, "(Ljava/lang/String;Ljava/lang/Throwable;)V", "AuthenticationError", "InvalidApiKey", "QuotaExceededError", "RateLimitError", "ModelNotSupported", "InvalidRequestError", "ContentFilterError", "TimeoutError", "NetworkError", "ServerError", "UnknownError", "Lstepai/aios/guiagent/llm/LlmException$AuthenticationError;", "Lstepai/aios/guiagent/llm/LlmException$ContentFilterError;", "Lstepai/aios/guiagent/llm/LlmException$InvalidApiKey;", "Lstepai/aios/guiagent/llm/LlmException$InvalidRequestError;", "Lstepai/aios/guiagent/llm/LlmException$ModelNotSupported;", "Lstepai/aios/guiagent/llm/LlmException$NetworkError;", "Lstepai/aios/guiagent/llm/LlmException$QuotaExceededError;", "Lstepai/aios/guiagent/llm/LlmException$RateLimitError;", "Lstepai/aios/guiagent/llm/LlmException$ServerError;", "Lstepai/aios/guiagent/llm/LlmException$TimeoutError;", "Lstepai/aios/guiagent/llm/LlmException$UnknownError;", "guiagent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public abstract class LlmException extends Exception {

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lstepai/aios/guiagent/llm/LlmException$AuthenticationError;", "Lstepai/aios/guiagent/llm/LlmException;", "message", "", AppAgent.CONSTRUCT, "(Ljava/lang/String;)V", "guiagent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class AuthenticationError extends LlmException {
        /* JADX WARN: Multi-variable type inference failed */
        public AuthenticationError() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public AuthenticationError(String message) {
            super(message, null, 2, 0 == true ? 1 : 0);
            k.f(message, "message");
        }

        public /* synthetic */ AuthenticationError(String str, int i, e eVar) {
            this((i & 1) != 0 ? "Authentication failed" : str);
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lstepai/aios/guiagent/llm/LlmException$ContentFilterError;", "Lstepai/aios/guiagent/llm/LlmException;", "message", "", AppAgent.CONSTRUCT, "(Ljava/lang/String;)V", "guiagent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class ContentFilterError extends LlmException {
        /* JADX WARN: Multi-variable type inference failed */
        public ContentFilterError() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public ContentFilterError(String message) {
            super(message, null, 2, 0 == true ? 1 : 0);
            k.f(message, "message");
        }

        public /* synthetic */ ContentFilterError(String str, int i, e eVar) {
            this((i & 1) != 0 ? "Content filtered" : str);
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lstepai/aios/guiagent/llm/LlmException$InvalidApiKey;", "Lstepai/aios/guiagent/llm/LlmException;", "message", "", AppAgent.CONSTRUCT, "(Ljava/lang/String;)V", "guiagent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class InvalidApiKey extends LlmException {
        /* JADX WARN: Multi-variable type inference failed */
        public InvalidApiKey() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public InvalidApiKey(String message) {
            super(message, null, 2, 0 == true ? 1 : 0);
            k.f(message, "message");
        }

        public /* synthetic */ InvalidApiKey(String str, int i, e eVar) {
            this((i & 1) != 0 ? "Invalid API key" : str);
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lstepai/aios/guiagent/llm/LlmException$InvalidRequestError;", "Lstepai/aios/guiagent/llm/LlmException;", "message", "", AppAgent.CONSTRUCT, "(Ljava/lang/String;)V", "guiagent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class InvalidRequestError extends LlmException {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public InvalidRequestError(String message) {
            super(message, null, 2, 0 == true ? 1 : 0);
            k.f(message, "message");
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lstepai/aios/guiagent/llm/LlmException$ModelNotSupported;", "Lstepai/aios/guiagent/llm/LlmException;", AlgorithmUpdateBundle.KEY_SUFFIX_MODEL, "", AppAgent.CONSTRUCT, "(Ljava/lang/String;)V", "guiagent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class ModelNotSupported extends LlmException {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public ModelNotSupported(String model) {
            super("Model not supported: ".concat(model), null, 2, 0 == true ? 1 : 0);
            k.f(model, "model");
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lstepai/aios/guiagent/llm/LlmException$NetworkError;", "Lstepai/aios/guiagent/llm/LlmException;", "message", "", "cause", "", AppAgent.CONSTRUCT, "(Ljava/lang/String;Ljava/lang/Throwable;)V", "guiagent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class NetworkError extends LlmException {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public NetworkError(String message, Throwable th) {
            super(message, th, null);
            k.f(message, "message");
        }

        public /* synthetic */ NetworkError(String str, Throwable th, int i, e eVar) {
            this(str, (i & 2) != 0 ? null : th);
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lstepai/aios/guiagent/llm/LlmException$QuotaExceededError;", "Lstepai/aios/guiagent/llm/LlmException;", "message", "", AppAgent.CONSTRUCT, "(Ljava/lang/String;)V", "guiagent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class QuotaExceededError extends LlmException {
        /* JADX WARN: Multi-variable type inference failed */
        public QuotaExceededError() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public QuotaExceededError(String message) {
            super(message, null, 2, 0 == true ? 1 : 0);
            k.f(message, "message");
        }

        public /* synthetic */ QuotaExceededError(String str, int i, e eVar) {
            this((i & 1) != 0 ? "API quota exceeded" : str);
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lstepai/aios/guiagent/llm/LlmException$RateLimitError;", "Lstepai/aios/guiagent/llm/LlmException;", "message", "", AppAgent.CONSTRUCT, "(Ljava/lang/String;)V", "guiagent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class RateLimitError extends LlmException {
        /* JADX WARN: Multi-variable type inference failed */
        public RateLimitError() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public RateLimitError(String message) {
            super(message, null, 2, 0 == true ? 1 : 0);
            k.f(message, "message");
        }

        public /* synthetic */ RateLimitError(String str, int i, e eVar) {
            this((i & 1) != 0 ? "Rate limit exceeded" : str);
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lstepai/aios/guiagent/llm/LlmException$ServerError;", "Lstepai/aios/guiagent/llm/LlmException;", "message", "", "cause", "", AppAgent.CONSTRUCT, "(Ljava/lang/String;Ljava/lang/Throwable;)V", "guiagent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class ServerError extends LlmException {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ServerError(String message, Throwable th) {
            super(message, th, null);
            k.f(message, "message");
        }

        public /* synthetic */ ServerError(String str, Throwable th, int i, e eVar) {
            this(str, (i & 2) != 0 ? null : th);
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lstepai/aios/guiagent/llm/LlmException$TimeoutError;", "Lstepai/aios/guiagent/llm/LlmException;", "message", "", AppAgent.CONSTRUCT, "(Ljava/lang/String;)V", "guiagent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class TimeoutError extends LlmException {
        /* JADX WARN: Multi-variable type inference failed */
        public TimeoutError() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public TimeoutError(String message) {
            super(message, null, 2, 0 == true ? 1 : 0);
            k.f(message, "message");
        }

        public /* synthetic */ TimeoutError(String str, int i, e eVar) {
            this((i & 1) != 0 ? "Request timeout" : str);
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lstepai/aios/guiagent/llm/LlmException$UnknownError;", "Lstepai/aios/guiagent/llm/LlmException;", "message", "", "cause", "", AppAgent.CONSTRUCT, "(Ljava/lang/String;Ljava/lang/Throwable;)V", "guiagent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class UnknownError extends LlmException {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public UnknownError(String message, Throwable th) {
            super(message, th, null);
            k.f(message, "message");
        }

        public /* synthetic */ UnknownError(String str, Throwable th, int i, e eVar) {
            this(str, (i & 2) != 0 ? null : th);
        }
    }

    public /* synthetic */ LlmException(String str, Throwable th, e eVar) {
        this(str, th);
    }

    private LlmException(String str, Throwable th) {
        super(str, th);
    }

    public /* synthetic */ LlmException(String str, Throwable th, int i, e eVar) {
        this(str, (i & 2) != 0 ? null : th, null);
    }
}
