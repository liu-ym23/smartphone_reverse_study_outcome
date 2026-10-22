package stepai.aios.guiexecutor.input;

import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ'\u0010\f\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\f\u0010\rJ'\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000f\u0010\r¨\u0006\u0010"}, d2 = {"Lstepai/aios/guiexecutor/input/UserInputListenerAdapter;", "Lstepai/aios/guiexecutor/input/UserInputListener;", AppAgent.CONSTRUCT, "()V", "", "sessionId", "Lstepai/aios/guiexecutor/input/UserInputRequest;", "inputRequest", "LC7/r;", "onUserInputTimeout", "(Ljava/lang/String;Lstepai/aios/guiexecutor/input/UserInputRequest;)V", "reason", "onUserInputCancelled", "(Ljava/lang/String;Lstepai/aios/guiexecutor/input/UserInputRequest;Ljava/lang/String;)V", "errorMessage", "onUserInputValidationFailed", "guiagent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public abstract class UserInputListenerAdapter implements UserInputListener {
    @Override // stepai.aios.guiexecutor.input.UserInputListener
    public void onUserInputCancelled(String sessionId, UserInputRequest inputRequest, String reason) {
        k.f(sessionId, "sessionId");
        k.f(inputRequest, "inputRequest");
        k.f(reason, "reason");
    }

    @Override // stepai.aios.guiexecutor.input.UserInputListener
    public void onUserInputTimeout(String sessionId, UserInputRequest inputRequest) {
        k.f(sessionId, "sessionId");
        k.f(inputRequest, "inputRequest");
    }

    @Override // stepai.aios.guiexecutor.input.UserInputListener
    public void onUserInputValidationFailed(String sessionId, UserInputRequest inputRequest, String errorMessage) {
        k.f(sessionId, "sessionId");
        k.f(inputRequest, "inputRequest");
        k.f(errorMessage, "errorMessage");
    }
}
