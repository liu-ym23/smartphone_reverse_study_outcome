package Ca;

import stepai.aios.guiexecutor.input.UserInputListener;
import stepai.aios.guiexecutor.input.UserInputRequest;

/* renamed from: Ca.g, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0208g implements UserInputListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ stepai.aios.guiagent.runtime.a f350a;

    public C0208g(stepai.aios.guiagent.runtime.a aVar) {
        this.f350a = aVar;
    }

    @Override // stepai.aios.guiexecutor.input.UserInputListener
    public final void onUserInputCancelled(String sessionId, UserInputRequest inputRequest, String reason) {
        kotlin.jvm.internal.k.f(sessionId, "sessionId");
        kotlin.jvm.internal.k.f(inputRequest, "inputRequest");
        kotlin.jvm.internal.k.f(reason, "reason");
        stepai.aios.guiagent.runtime.a.b(this.f350a, sessionId, new C(sessionId, inputRequest, reason));
    }

    @Override // stepai.aios.guiexecutor.input.UserInputListener
    public final void onUserInputRequested(String sessionId, UserInputRequest inputRequest) {
        kotlin.jvm.internal.k.f(sessionId, "sessionId");
        kotlin.jvm.internal.k.f(inputRequest, "inputRequest");
        stepai.aios.guiagent.runtime.a.b(this.f350a, sessionId, new D(sessionId, inputRequest));
    }

    @Override // stepai.aios.guiexecutor.input.UserInputListener
    public final void onUserInputTimeout(String sessionId, UserInputRequest inputRequest) {
        kotlin.jvm.internal.k.f(sessionId, "sessionId");
        kotlin.jvm.internal.k.f(inputRequest, "inputRequest");
        stepai.aios.guiagent.runtime.a.b(this.f350a, sessionId, new E(sessionId, inputRequest));
    }

    @Override // stepai.aios.guiexecutor.input.UserInputListener
    public final void onUserInputValidationFailed(String sessionId, UserInputRequest inputRequest, String errorMessage) {
        kotlin.jvm.internal.k.f(sessionId, "sessionId");
        kotlin.jvm.internal.k.f(inputRequest, "inputRequest");
        kotlin.jvm.internal.k.f(errorMessage, "errorMessage");
        stepai.aios.guiagent.runtime.a.b(this.f350a, sessionId, new F(sessionId, inputRequest, errorMessage));
    }
}
