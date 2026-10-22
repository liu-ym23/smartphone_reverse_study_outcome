package stepai.aios.guiexecutor.input;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\bf\u0018\u00002\u00020\u0001J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\t\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\t\u0010\bJ)\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\n\u001a\u00020\u0002H&¢\u0006\u0004\b\u000b\u0010\fJ'\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u0002H&¢\u0006\u0004\b\u000e\u0010\f¨\u0006\u000fÀ\u0006\u0003"}, d2 = {"Lstepai/aios/guiexecutor/input/UserInputListener;", "", "", "sessionId", "Lstepai/aios/guiexecutor/input/UserInputRequest;", "inputRequest", "LC7/r;", "onUserInputRequested", "(Ljava/lang/String;Lstepai/aios/guiexecutor/input/UserInputRequest;)V", "onUserInputTimeout", "reason", "onUserInputCancelled", "(Ljava/lang/String;Lstepai/aios/guiexecutor/input/UserInputRequest;Ljava/lang/String;)V", "errorMessage", "onUserInputValidationFailed", "guiagent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public interface UserInputListener {

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class DefaultImpls {
    }

    static /* synthetic */ void onUserInputCancelled$default(UserInputListener userInputListener, String str, UserInputRequest userInputRequest, String str2, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onUserInputCancelled");
        }
        if ((i & 4) != 0) {
            str2 = "";
        }
        userInputListener.onUserInputCancelled(str, userInputRequest, str2);
    }

    void onUserInputCancelled(String sessionId, UserInputRequest inputRequest, String reason);

    void onUserInputRequested(String sessionId, UserInputRequest inputRequest);

    void onUserInputTimeout(String sessionId, UserInputRequest inputRequest);

    void onUserInputValidationFailed(String sessionId, UserInputRequest inputRequest, String errorMessage);
}
