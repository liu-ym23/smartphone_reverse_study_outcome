package stepai.aios.guiexecutor.input;

import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002¨\u0006\u0003"}, d2 = {"toFullListener", "Lstepai/aios/guiexecutor/input/UserInputListener;", "Lstepai/aios/guiexecutor/input/SimpleUserInputListener;", "guiagent_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class UserInputListenerKt {
    public static final UserInputListener toFullListener(final SimpleUserInputListener simpleUserInputListener) {
        k.f(simpleUserInputListener, "<this>");
        return new UserInputListenerAdapter() { // from class: stepai.aios.guiexecutor.input.UserInputListenerKt.toFullListener.1
            @Override // stepai.aios.guiexecutor.input.UserInputListener
            public void onUserInputRequested(String sessionId, UserInputRequest inputRequest) {
                k.f(sessionId, "sessionId");
                k.f(inputRequest, "inputRequest");
                simpleUserInputListener.onUserInputRequested(sessionId, inputRequest);
            }
        };
    }
}
