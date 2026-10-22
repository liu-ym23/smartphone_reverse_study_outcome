package stepai.aios.guiexecutor.input;

import C7.r;
import J7.c;
import N9.j;
import S7.k;
import S7.n;
import U7.a;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.ability.beaninternal.task.GuiTaskProgressKt;
import com.stepos.statsrpk.d;
import com.stepos.taskrobot.llmapi.stepfun.InjectExperienceResult;
import j9.m;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.b;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.e;
import kotlin.text.Regex;
import m9.AbstractC1683A;
import m9.AbstractC1691I;
import m9.C1718k;
import m9.InterfaceC1733z;
import m9.c0;

@Metadata(d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 L2\u00020\u0001:\u0002LMB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u001d\u0010\u0007\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\u000bJ\u0015\u0010\f\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\f\u0010\bJ\u001d\u0010\f\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\f\u0010\u000bJ\r\u0010\r\u001a\u00020\u0006¢\u0006\u0004\b\r\u0010\u0003JR\u0010\u0018\u001a\u00020\u00172\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\t2\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0012\u001a\u00020\u00112\u0010\b\u0002\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u00132\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0086@¢\u0006\u0004\b\u0018\u0010\u0019J\u001d\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001a\u001a\u00020\t2\u0006\u0010\u001b\u001a\u00020\t¢\u0006\u0004\b\u001d\u0010\u001eJ\u001f\u0010 \u001a\u00020\u001c2\u0006\u0010\u001a\u001a\u00020\t2\b\b\u0002\u0010\u001f\u001a\u00020\t¢\u0006\u0004\b \u0010\u001eJ\u001f\u0010!\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u001f\u001a\u00020\t¢\u0006\u0004\b!\u0010\"J\r\u0010$\u001a\u00020#¢\u0006\u0004\b$\u0010%J\u001b\u0010'\u001a\b\u0012\u0004\u0012\u00020&0\u00132\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b'\u0010(J\r\u0010)\u001a\u00020\u0006¢\u0006\u0004\b)\u0010\u0003J\u0017\u0010+\u001a\u00020\u00062\u0006\u0010*\u001a\u00020&H\u0002¢\u0006\u0004\b+\u0010,J\u001f\u0010.\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\t2\u0006\u0010-\u001a\u00020\u0017H\u0002¢\u0006\u0004\b.\u0010/J\u0017\u00100\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\tH\u0002¢\u0006\u0004\b0\u00101J\u0017\u00102\u001a\u00020\u00062\u0006\u0010*\u001a\u00020&H\u0002¢\u0006\u0004\b2\u0010,J\u0017\u00103\u001a\u00020\u00062\u0006\u0010*\u001a\u00020&H\u0002¢\u0006\u0004\b3\u0010,J\u001f\u00104\u001a\u00020\u00062\u0006\u0010*\u001a\u00020&2\u0006\u0010\u001f\u001a\u00020\tH\u0002¢\u0006\u0004\b4\u00105J\u001f\u00107\u001a\u00020\u00062\u0006\u0010*\u001a\u00020&2\u0006\u00106\u001a\u00020\tH\u0002¢\u0006\u0004\b7\u00105J,\u0010:\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\u0012\u00109\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000608H\u0082\b¢\u0006\u0004\b:\u0010;J!\u0010=\u001a\u00020<2\u0006\u0010\u001b\u001a\u00020\t2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0002¢\u0006\u0004\b=\u0010>R \u0010@\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020&0?8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b@\u0010AR\u001a\u0010C\u001a\b\u0012\u0004\u0012\u00020\u00040B8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bC\u0010DR&\u0010E\u001a\u0014\u0012\u0004\u0012\u00020\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040B0?8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bE\u0010AR,\u0010F\u001a\u001a\u0012\u0004\u0012\u00020\t\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u0006080?8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bF\u0010AR \u0010H\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020G0?8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bH\u0010AR\u0014\u0010J\u001a\u00020I8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bJ\u0010K¨\u0006N"}, d2 = {"Lstepai/aios/guiexecutor/input/UserInputManager;", "", AppAgent.CONSTRUCT, "()V", "Lstepai/aios/guiexecutor/input/UserInputListener;", "listener", "LC7/r;", "addUserInputListener", "(Lstepai/aios/guiexecutor/input/UserInputListener;)V", "", "sessionId", "(Ljava/lang/String;Lstepai/aios/guiexecutor/input/UserInputListener;)V", "removeUserInputListener", "clearUserInputListeners", "message", "Lstepai/aios/guiexecutor/input/UserInputType;", "inputType", "", InjectExperienceResult.REASON_TIMEOUT, "", "options", "Lstepai/aios/guiexecutor/input/InputValidation;", "validation", "Lstepai/aios/guiexecutor/input/UserInputResponse;", "requestUserInput", "(Ljava/lang/String;Ljava/lang/String;Lstepai/aios/guiexecutor/input/UserInputType;JLjava/util/List;Lstepai/aios/guiexecutor/input/InputValidation;LH7/c;)Ljava/lang/Object;", "requestId", "input", "", "provideUserInput", "(Ljava/lang/String;Ljava/lang/String;)Z", "reason", "cancelUserInput", "cancelSessionInputs", "(Ljava/lang/String;Ljava/lang/String;)V", "", "getPendingRequestCount", "()I", "Lstepai/aios/guiexecutor/input/UserInputRequest;", "getSessionPendingRequests", "(Ljava/lang/String;)Ljava/util/List;", "shutdown", "request", "handleTimeout", "(Lstepai/aios/guiexecutor/input/UserInputRequest;)V", "response", "completeRequest", "(Ljava/lang/String;Lstepai/aios/guiexecutor/input/UserInputResponse;)V", "cleanupRequest", "(Ljava/lang/String;)V", "notifyInputRequested", "notifyInputTimeout", "notifyInputCancelled", "(Lstepai/aios/guiexecutor/input/UserInputRequest;Ljava/lang/String;)V", "errorMessage", "notifyValidationFailed", "Lkotlin/Function1;", GuiTaskProgressKt.GuiTaskProgress_KEY_ACTION, "dispatch", "(Ljava/lang/String;LS7/k;)V", "Lstepai/aios/guiexecutor/input/UserInputManager$ValidationResult;", "validateInput", "(Ljava/lang/String;Lstepai/aios/guiexecutor/input/InputValidation;)Lstepai/aios/guiexecutor/input/UserInputManager$ValidationResult;", "Ljava/util/concurrent/ConcurrentHashMap;", "pendingRequests", "Ljava/util/concurrent/ConcurrentHashMap;", "Ljava/util/concurrent/CopyOnWriteArrayList;", "globalListeners", "Ljava/util/concurrent/CopyOnWriteArrayList;", "sessionListeners", "completionCallbacks", "Lm9/c0;", "timeoutJobs", "Lm9/z;", "coroutineScope", "Lm9/z;", "Companion", "ValidationResult", "guiagent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class UserInputManager {
    private static final long DEFAULT_TIMEOUT = 30000;
    private static final String TAG = "UserInputManager";
    private final InterfaceC1733z coroutineScope;
    private final ConcurrentHashMap<String, UserInputRequest> pendingRequests = new ConcurrentHashMap<>();
    private final CopyOnWriteArrayList<UserInputListener> globalListeners = new CopyOnWriteArrayList<>();
    private final ConcurrentHashMap<String, CopyOnWriteArrayList<UserInputListener>> sessionListeners = new ConcurrentHashMap<>();
    private final ConcurrentHashMap<String, k> completionCallbacks = new ConcurrentHashMap<>();
    private final ConcurrentHashMap<String, c0> timeoutJobs = new ConcurrentHashMap<>();

    @c(c = "stepai.aios.guiexecutor.input.UserInputManager", f = "UserInputManager.kt", l = {137}, m = "requestUserInput", v = 1)
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: stepai.aios.guiexecutor.input.UserInputManager$requestUserInput$1, reason: invalid class name */
    public static final class AnonymousClass1 extends ContinuationImpl {
        long J$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(H7.c<? super AnonymousClass1> cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return UserInputManager.this.requestUserInput(null, null, null, 0L, null, null, this);
        }
    }

    @c(c = "stepai.aios.guiexecutor.input.UserInputManager$requestUserInput$2", f = "UserInputManager.kt", l = {433}, m = "invokeSuspend", v = 1)
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "Lstepai/aios/guiexecutor/input/UserInputResponse;", "<anonymous>", "(Lm9/z;)Lstepai/aios/guiexecutor/input/UserInputResponse;"}, k = 3, mv = {2, 2, 0})
    /* renamed from: stepai.aios.guiexecutor.input.UserInputManager$requestUserInput$2, reason: invalid class name */
    public static final class AnonymousClass2 extends SuspendLambda implements n {
        final /* synthetic */ UserInputType $inputType;
        final /* synthetic */ String $message;
        final /* synthetic */ List<String> $options;
        final /* synthetic */ String $sessionId;
        final /* synthetic */ long $timeout;
        final /* synthetic */ InputValidation $validation;
        int I$0;
        long J$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        int label;
        final /* synthetic */ UserInputManager this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(String str, String str2, UserInputType userInputType, long j5, List<String> list, InputValidation inputValidation, UserInputManager userInputManager, H7.c<? super AnonymousClass2> cVar) {
            super(2, cVar);
            this.$sessionId = str;
            this.$message = str2;
            this.$inputType = userInputType;
            this.$timeout = j5;
            this.$options = list;
            this.$validation = inputValidation;
            this.this$0 = userInputManager;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c<r> create(Object obj, H7.c<?> cVar) {
            return new AnonymousClass2(this.$sessionId, this.$message, this.$inputType, this.$timeout, this.$options, this.$validation, this.this$0, cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws NoSuchAlgorithmException {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
            int i = this.label;
            if (i != 0) {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                b.b(obj);
                return obj;
            }
            b.b(obj);
            String str = this.$sessionId;
            String str2 = this.$message;
            UserInputType userInputType = this.$inputType;
            long j5 = this.$timeout;
            List<String> list = this.$options;
            InputValidation inputValidation = this.$validation;
            final UserInputManager userInputManager = this.this$0;
            this.L$0 = str;
            this.L$1 = str2;
            this.L$2 = userInputType;
            this.L$3 = list;
            this.L$4 = inputValidation;
            this.L$5 = userInputManager;
            this.J$0 = j5;
            this.I$0 = 0;
            this.label = 1;
            final C1718k c1718k = new C1718k(1, a.I(this));
            c1718k.y();
            final UserInputRequest userInputRequest = new UserInputRequest(UserInputRequest.INSTANCE.generateRequestId(), str, str2, userInputType, j5, list, inputValidation, null, null, null, 896, null);
            String strM = d.M(str2);
            StringBuilder sbW = B7.a.w("Requesting user input: requestId=", userInputRequest.getRequestId(), ", session=", str, ", message=");
            sbW.append(strM);
            sbW.append(", type=");
            sbW.append(userInputType);
            sbW.append(", timeoutMs=");
            sbW.append(j5);
            j.H(sbW.toString(), UserInputManager.TAG);
            userInputManager.pendingRequests.put(userInputRequest.getRequestId(), userInputRequest);
            userInputManager.completionCallbacks.put(userInputRequest.getRequestId(), new k() { // from class: stepai.aios.guiexecutor.input.UserInputManager$requestUserInput$2$1$1
                @Override // S7.k
                public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                    invoke((UserInputResponse) obj2);
                    return r.f317a;
                }

                public final void invoke(UserInputResponse response) {
                    kotlin.jvm.internal.k.f(response, "response");
                    c1718k.resumeWith(response);
                }
            });
            userInputManager.timeoutJobs.put(userInputRequest.getRequestId(), AbstractC1683A.n(userInputManager.coroutineScope, null, new UserInputManager$requestUserInput$2$1$timeoutJob$1(j5, userInputManager, userInputRequest, null), 3));
            c1718k.j(new k() { // from class: stepai.aios.guiexecutor.input.UserInputManager$requestUserInput$2$1$2
                @Override // S7.k
                public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                    invoke((Throwable) obj2);
                    return r.f317a;
                }

                public final void invoke(Throwable th) {
                    userInputManager.cleanupRequest(userInputRequest.getRequestId());
                    userInputManager.notifyInputCancelled(userInputRequest, "Coroutine cancelled");
                }
            });
            userInputManager.notifyInputRequested(userInputRequest);
            Object objX = c1718k.x();
            return objX == coroutineSingletons ? coroutineSingletons : objX;
        }

        @Override // S7.n
        public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<? super UserInputResponse> cVar) {
            return ((AnonymousClass2) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
        }
    }

    public UserInputManager() {
        u9.d dVar = AbstractC1691I.f5315a;
        this.coroutineScope = AbstractC1683A.b(s9.k.f6003a.plus(AbstractC1683A.c()));
    }

    public static /* synthetic */ void cancelSessionInputs$default(UserInputManager userInputManager, String str, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = "Session cancelled";
        }
        userInputManager.cancelSessionInputs(str, str2);
    }

    public static /* synthetic */ boolean cancelUserInput$default(UserInputManager userInputManager, String str, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = "User cancelled";
        }
        return userInputManager.cancelUserInput(str, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void cleanupRequest(String requestId) {
        this.pendingRequests.remove(requestId);
        this.completionCallbacks.remove(requestId);
        c0 c0VarRemove = this.timeoutJobs.remove(requestId);
        if (c0VarRemove != null) {
            c0VarRemove.cancel(null);
        }
    }

    private final void completeRequest(String requestId, UserInputResponse response) {
        k kVarRemove = this.completionCallbacks.remove(requestId);
        if (kVarRemove != null) {
            kVarRemove.invoke(response);
        }
        cleanupRequest(requestId);
    }

    private final void dispatch(String sessionId, k action) {
        for (UserInputListener userInputListener : this.globalListeners) {
            try {
                kotlin.jvm.internal.k.c(userInputListener);
                action.invoke(userInputListener);
            } catch (Exception e) {
                com.stepos.statsrpk.service.c.n("Error notifying global listener: ", e.getMessage(), TAG);
            }
        }
        CopyOnWriteArrayList<UserInputListener> copyOnWriteArrayList = this.sessionListeners.get(sessionId);
        if (copyOnWriteArrayList != null) {
            for (UserInputListener userInputListener2 : copyOnWriteArrayList) {
                try {
                    kotlin.jvm.internal.k.c(userInputListener2);
                    action.invoke(userInputListener2);
                } catch (Exception e6) {
                    com.stepos.statsrpk.service.c.o("Error notifying session listener (", sessionId, "): ", e6.getMessage(), TAG);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handleTimeout(UserInputRequest request) {
        j.J("User input timeout: " + request.getRequestId(), TAG);
        completeRequest(request.getRequestId(), UserInputResponse.INSTANCE.timeout(request.getSessionId(), request.getRequestId()));
        notifyInputTimeout(request);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void notifyInputCancelled(UserInputRequest request, String reason) {
        String sessionId = request.getSessionId();
        for (UserInputListener userInputListener : this.globalListeners) {
            try {
                kotlin.jvm.internal.k.c(userInputListener);
                userInputListener.onUserInputCancelled(request.getSessionId(), request, reason);
            } catch (Exception e) {
                com.stepos.statsrpk.service.c.n("Error notifying global listener: ", e.getMessage(), TAG);
            }
        }
        CopyOnWriteArrayList<UserInputListener> copyOnWriteArrayList = this.sessionListeners.get(sessionId);
        if (copyOnWriteArrayList != null) {
            for (UserInputListener userInputListener2 : copyOnWriteArrayList) {
                try {
                    kotlin.jvm.internal.k.c(userInputListener2);
                    userInputListener2.onUserInputCancelled(request.getSessionId(), request, reason);
                } catch (Exception e6) {
                    com.stepos.statsrpk.service.c.o("Error notifying session listener (", sessionId, "): ", e6.getMessage(), TAG);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void notifyInputRequested(UserInputRequest request) {
        String sessionId = request.getSessionId();
        for (UserInputListener userInputListener : this.globalListeners) {
            try {
                kotlin.jvm.internal.k.c(userInputListener);
                userInputListener.onUserInputRequested(request.getSessionId(), request);
            } catch (Exception e) {
                com.stepos.statsrpk.service.c.n("Error notifying global listener: ", e.getMessage(), TAG);
            }
        }
        CopyOnWriteArrayList<UserInputListener> copyOnWriteArrayList = this.sessionListeners.get(sessionId);
        if (copyOnWriteArrayList != null) {
            for (UserInputListener userInputListener2 : copyOnWriteArrayList) {
                try {
                    kotlin.jvm.internal.k.c(userInputListener2);
                    userInputListener2.onUserInputRequested(request.getSessionId(), request);
                } catch (Exception e6) {
                    com.stepos.statsrpk.service.c.o("Error notifying session listener (", sessionId, "): ", e6.getMessage(), TAG);
                }
            }
        }
    }

    private final void notifyInputTimeout(UserInputRequest request) {
        String sessionId = request.getSessionId();
        for (UserInputListener userInputListener : this.globalListeners) {
            try {
                kotlin.jvm.internal.k.c(userInputListener);
                userInputListener.onUserInputTimeout(request.getSessionId(), request);
            } catch (Exception e) {
                com.stepos.statsrpk.service.c.n("Error notifying global listener: ", e.getMessage(), TAG);
            }
        }
        CopyOnWriteArrayList<UserInputListener> copyOnWriteArrayList = this.sessionListeners.get(sessionId);
        if (copyOnWriteArrayList != null) {
            for (UserInputListener userInputListener2 : copyOnWriteArrayList) {
                try {
                    kotlin.jvm.internal.k.c(userInputListener2);
                    userInputListener2.onUserInputTimeout(request.getSessionId(), request);
                } catch (Exception e6) {
                    com.stepos.statsrpk.service.c.o("Error notifying session listener (", sessionId, "): ", e6.getMessage(), TAG);
                }
            }
        }
    }

    private final void notifyValidationFailed(UserInputRequest request, String errorMessage) {
        String sessionId = request.getSessionId();
        for (UserInputListener userInputListener : this.globalListeners) {
            try {
                kotlin.jvm.internal.k.c(userInputListener);
                userInputListener.onUserInputValidationFailed(request.getSessionId(), request, errorMessage);
            } catch (Exception e) {
                com.stepos.statsrpk.service.c.n("Error notifying global listener: ", e.getMessage(), TAG);
            }
        }
        CopyOnWriteArrayList<UserInputListener> copyOnWriteArrayList = this.sessionListeners.get(sessionId);
        if (copyOnWriteArrayList != null) {
            for (UserInputListener userInputListener2 : copyOnWriteArrayList) {
                try {
                    kotlin.jvm.internal.k.c(userInputListener2);
                    userInputListener2.onUserInputValidationFailed(request.getSessionId(), request, errorMessage);
                } catch (Exception e6) {
                    com.stepos.statsrpk.service.c.o("Error notifying session listener (", sessionId, "): ", e6.getMessage(), TAG);
                }
            }
        }
    }

    public static /* synthetic */ Object requestUserInput$default(UserInputManager userInputManager, String str, String str2, UserInputType userInputType, long j5, List list, InputValidation inputValidation, H7.c cVar, int i, Object obj) {
        if ((i & 4) != 0) {
            userInputType = UserInputType.TEXT;
        }
        UserInputType userInputType2 = userInputType;
        if ((i & 8) != 0) {
            j5 = DEFAULT_TIMEOUT;
        }
        return userInputManager.requestUserInput(str, str2, userInputType2, j5, (i & 16) != 0 ? null : list, (i & 32) != 0 ? null : inputValidation, cVar);
    }

    private final ValidationResult validateInput(String input, InputValidation validation) {
        int iIntValue;
        int iIntValue2;
        if (validation == null) {
            return ValidationResult.INSTANCE.valid();
        }
        if (validation.getRequired() && m.s0(input)) {
            return ValidationResult.INSTANCE.invalid("Input cannot be empty");
        }
        Integer minLength = validation.getMinLength();
        if (minLength != null && input.length() < (iIntValue2 = minLength.intValue())) {
            return ValidationResult.INSTANCE.invalid("Input length must be at least " + iIntValue2 + " characters");
        }
        Integer maxLength = validation.getMaxLength();
        if (maxLength != null && input.length() > (iIntValue = maxLength.intValue())) {
            return ValidationResult.INSTANCE.invalid("Input length must not exceed " + iIntValue + " characters");
        }
        String pattern = validation.getPattern();
        if (pattern != null && !new Regex(pattern).d(input)) {
            return ValidationResult.INSTANCE.invalid("Invalid input format");
        }
        k customValidator = validation.getCustomValidator();
        return (customValidator == null || ((Boolean) customValidator.invoke(input)).booleanValue()) ? ValidationResult.INSTANCE.valid() : ValidationResult.INSTANCE.invalid("Input validation failed");
    }

    public final void addUserInputListener(UserInputListener listener) {
        kotlin.jvm.internal.k.f(listener, "listener");
        this.globalListeners.add(listener);
        j.H("Added global user input listener: ".concat(listener.getClass().getSimpleName()), TAG);
    }

    public final void cancelSessionInputs(String sessionId, String reason) {
        kotlin.jvm.internal.k.f(sessionId, "sessionId");
        kotlin.jvm.internal.k.f(reason, "reason");
        Collection<UserInputRequest> collectionValues = this.pendingRequests.values();
        kotlin.jvm.internal.k.e(collectionValues, "<get-values>(...)");
        ArrayList arrayList = new ArrayList();
        for (Object obj : collectionValues) {
            if (kotlin.jvm.internal.k.b(((UserInputRequest) obj).getSessionId(), sessionId)) {
                arrayList.add(obj);
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            cancelUserInput(((UserInputRequest) it.next()).getRequestId(), reason);
        }
        j.H("Cancelled " + arrayList.size() + " pending inputs for session: " + sessionId, TAG);
    }

    public final boolean cancelUserInput(String requestId, String reason) {
        kotlin.jvm.internal.k.f(requestId, "requestId");
        kotlin.jvm.internal.k.f(reason, "reason");
        UserInputRequest userInputRequest = this.pendingRequests.get(requestId);
        if (userInputRequest == null) {
            j.J("Cannot find pending request to cancel: ".concat(requestId), TAG);
            return false;
        }
        j.H("Cancelling user input: " + requestId + ", reason: " + reason, TAG);
        completeRequest(requestId, UserInputResponse.INSTANCE.cancelled(userInputRequest.getSessionId(), requestId));
        notifyInputCancelled(userInputRequest, reason);
        return true;
    }

    public final void clearUserInputListeners() {
        this.globalListeners.clear();
        this.sessionListeners.clear();
        j.H("Cleared all user input listeners", TAG);
    }

    public final int getPendingRequestCount() {
        return this.pendingRequests.size();
    }

    public final List<UserInputRequest> getSessionPendingRequests(String sessionId) {
        kotlin.jvm.internal.k.f(sessionId, "sessionId");
        Collection<UserInputRequest> collectionValues = this.pendingRequests.values();
        kotlin.jvm.internal.k.e(collectionValues, "<get-values>(...)");
        ArrayList arrayList = new ArrayList();
        for (Object obj : collectionValues) {
            if (kotlin.jvm.internal.k.b(((UserInputRequest) obj).getSessionId(), sessionId)) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    public final boolean provideUserInput(String requestId, String input) {
        kotlin.jvm.internal.k.f(requestId, "requestId");
        kotlin.jvm.internal.k.f(input, "input");
        UserInputRequest userInputRequest = this.pendingRequests.get(requestId);
        if (userInputRequest == null) {
            j.J("Cannot find pending request: ".concat(requestId), TAG);
            return false;
        }
        j.H("Received user input: requestId=" + requestId + ", input=" + d.M(input), TAG);
        ValidationResult validationResultValidateInput = validateInput(input, userInputRequest.getValidation());
        if (validationResultValidateInput.isValid()) {
            completeRequest(requestId, UserInputResponse.INSTANCE.success(userInputRequest.getSessionId(), input, requestId));
            return true;
        }
        j.J("Input validation failed: " + requestId + ", error: " + validationResultValidateInput.getErrorMessage(), TAG);
        notifyValidationFailed(userInputRequest, validationResultValidateInput.getErrorMessage());
        return false;
    }

    public final void removeUserInputListener(UserInputListener listener) {
        kotlin.jvm.internal.k.f(listener, "listener");
        this.globalListeners.remove(listener);
        j.H("Removed global user input listener: ".concat(listener.getClass().getSimpleName()), TAG);
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0016  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object requestUserInput(java.lang.String r15, java.lang.String r16, stepai.aios.guiexecutor.input.UserInputType r17, long r18, java.util.List<java.lang.String> r20, stepai.aios.guiexecutor.input.InputValidation r21, H7.c<? super stepai.aios.guiexecutor.input.UserInputResponse> r22) {
        /*
            r14 = this;
            r0 = r22
            boolean r1 = r0 instanceof stepai.aios.guiexecutor.input.UserInputManager.AnonymousClass1
            if (r1 == 0) goto L16
            r1 = r0
            stepai.aios.guiexecutor.input.UserInputManager$requestUserInput$1 r1 = (stepai.aios.guiexecutor.input.UserInputManager.AnonymousClass1) r1
            int r2 = r1.label
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r2 & r3
            if (r4 == 0) goto L16
            int r2 = r2 - r3
            r1.label = r2
        L14:
            r10 = r1
            goto L1c
        L16:
            stepai.aios.guiexecutor.input.UserInputManager$requestUserInput$1 r1 = new stepai.aios.guiexecutor.input.UserInputManager$requestUserInput$1
            r1.<init>(r0)
            goto L14
        L1c:
            java.lang.Object r0 = r10.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r11 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            int r1 = r10.label
            r12 = 1
            r13 = 0
            if (r1 == 0) goto L49
            if (r1 != r12) goto L41
            java.lang.Object r14 = r10.L$4
            stepai.aios.guiexecutor.input.InputValidation r14 = (stepai.aios.guiexecutor.input.InputValidation) r14
            java.lang.Object r14 = r10.L$3
            java.util.List r14 = (java.util.List) r14
            java.lang.Object r14 = r10.L$2
            stepai.aios.guiexecutor.input.UserInputType r14 = (stepai.aios.guiexecutor.input.UserInputType) r14
            java.lang.Object r14 = r10.L$1
            java.lang.String r14 = (java.lang.String) r14
            java.lang.Object r14 = r10.L$0
            r15 = r14
            java.lang.String r15 = (java.lang.String) r15
            kotlin.b.b(r0)
            goto L73
        L41:
            java.lang.IllegalStateException r14 = new java.lang.IllegalStateException
            java.lang.String r15 = "call to 'resume' before 'invoke' with coroutine"
            r14.<init>(r15)
            throw r14
        L49:
            kotlin.b.b(r0)
            stepai.aios.guiexecutor.input.UserInputManager$requestUserInput$2 r0 = new stepai.aios.guiexecutor.input.UserInputManager$requestUserInput$2
            r9 = 0
            r8 = r14
            r1 = r15
            r2 = r16
            r3 = r17
            r4 = r18
            r6 = r20
            r7 = r21
            r0.<init>(r1, r2, r3, r4, r6, r7, r8, r9)
            r10.L$0 = r15
            r10.L$1 = r13
            r10.L$2 = r13
            r10.L$3 = r13
            r10.L$4 = r13
            r10.J$0 = r4
            r10.label = r12
            java.lang.Object r0 = kotlinx.coroutines.a.p(r4, r0, r10)
            if (r0 != r11) goto L73
            return r11
        L73:
            stepai.aios.guiexecutor.input.UserInputResponse r0 = (stepai.aios.guiexecutor.input.UserInputResponse) r0
            if (r0 != 0) goto L92
            java.lang.StringBuilder r14 = new java.lang.StringBuilder
            java.lang.String r0 = "User input request timed out: sessionId="
            r14.<init>(r0)
            r14.append(r15)
            java.lang.String r14 = r14.toString()
            java.lang.String r0 = "UserInputManager"
            N9.j.J(r14, r0)
            stepai.aios.guiexecutor.input.UserInputResponse$Companion r14 = stepai.aios.guiexecutor.input.UserInputResponse.INSTANCE
            r0 = 2
            stepai.aios.guiexecutor.input.UserInputResponse r14 = stepai.aios.guiexecutor.input.UserInputResponse.Companion.timeout$default(r14, r15, r13, r0, r13)
            return r14
        L92:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: stepai.aios.guiexecutor.input.UserInputManager.requestUserInput(java.lang.String, java.lang.String, stepai.aios.guiexecutor.input.UserInputType, long, java.util.List, stepai.aios.guiexecutor.input.InputValidation, H7.c):java.lang.Object");
    }

    public final void shutdown() {
        j.H("Shutting down UserInputManager", TAG);
        Set<String> setKeySet = this.pendingRequests.keySet();
        kotlin.jvm.internal.k.e(setKeySet, "<get-keys>(...)");
        for (String str : setKeySet) {
            kotlin.jvm.internal.k.c(str);
            cancelUserInput(str, "Manager shutdown");
        }
        Collection<c0> collectionValues = this.timeoutJobs.values();
        kotlin.jvm.internal.k.e(collectionValues, "<get-values>(...)");
        for (c0 c0Var : collectionValues) {
            kotlin.jvm.internal.k.c(c0Var);
            c0Var.cancel(null);
        }
        this.timeoutJobs.clear();
        this.pendingRequests.clear();
        this.completionCallbacks.clear();
        this.globalListeners.clear();
        this.sessionListeners.clear();
        AbstractC1683A.e(this.coroutineScope, null);
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0003\b\u0082\b\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u00032\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Lstepai/aios/guiexecutor/input/UserInputManager$ValidationResult;", "", "isValid", "", "errorMessage", "", AppAgent.CONSTRUCT, "(ZLjava/lang/String;)V", "()Z", "getErrorMessage", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "Companion", "guiagent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class ValidationResult {

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final String errorMessage;
        private final boolean isValid;

        @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005J\u000e\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\b¨\u0006\t"}, d2 = {"Lstepai/aios/guiexecutor/input/UserInputManager$ValidationResult$Companion;", "", AppAgent.CONSTRUCT, "()V", "valid", "Lstepai/aios/guiexecutor/input/UserInputManager$ValidationResult;", "invalid", "message", "", "guiagent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(e eVar) {
                this();
            }

            public final ValidationResult invalid(String message) {
                kotlin.jvm.internal.k.f(message, "message");
                return new ValidationResult(false, message);
            }

            /* JADX WARN: Multi-variable type inference failed */
            public final ValidationResult valid() {
                return new ValidationResult(true, null, 2, 0 == true ? 1 : 0);
            }

            private Companion() {
            }
        }

        public ValidationResult(boolean z10, String errorMessage) {
            kotlin.jvm.internal.k.f(errorMessage, "errorMessage");
            this.isValid = z10;
            this.errorMessage = errorMessage;
        }

        public static /* synthetic */ ValidationResult copy$default(ValidationResult validationResult, boolean z10, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                z10 = validationResult.isValid;
            }
            if ((i & 2) != 0) {
                str = validationResult.errorMessage;
            }
            return validationResult.copy(z10, str);
        }

        /* renamed from: component1, reason: from getter */
        public final boolean getIsValid() {
            return this.isValid;
        }

        /* renamed from: component2, reason: from getter */
        public final String getErrorMessage() {
            return this.errorMessage;
        }

        public final ValidationResult copy(boolean isValid, String errorMessage) {
            kotlin.jvm.internal.k.f(errorMessage, "errorMessage");
            return new ValidationResult(isValid, errorMessage);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ValidationResult)) {
                return false;
            }
            ValidationResult validationResult = (ValidationResult) other;
            return this.isValid == validationResult.isValid && kotlin.jvm.internal.k.b(this.errorMessage, validationResult.errorMessage);
        }

        public final String getErrorMessage() {
            return this.errorMessage;
        }

        public int hashCode() {
            return this.errorMessage.hashCode() + (Boolean.hashCode(this.isValid) * 31);
        }

        public final boolean isValid() {
            return this.isValid;
        }

        public String toString() {
            return "ValidationResult(isValid=" + this.isValid + ", errorMessage=" + this.errorMessage + ")";
        }

        public /* synthetic */ ValidationResult(boolean z10, String str, int i, e eVar) {
            this(z10, (i & 2) != 0 ? "" : str);
        }
    }

    public final void addUserInputListener(String sessionId, UserInputListener listener) {
        CopyOnWriteArrayList<UserInputListener> copyOnWriteArrayListPutIfAbsent;
        kotlin.jvm.internal.k.f(sessionId, "sessionId");
        kotlin.jvm.internal.k.f(listener, "listener");
        ConcurrentHashMap<String, CopyOnWriteArrayList<UserInputListener>> concurrentHashMap = this.sessionListeners;
        CopyOnWriteArrayList<UserInputListener> copyOnWriteArrayList = concurrentHashMap.get(sessionId);
        if (copyOnWriteArrayList == null && (copyOnWriteArrayListPutIfAbsent = concurrentHashMap.putIfAbsent(sessionId, (copyOnWriteArrayList = new CopyOnWriteArrayList<>()))) != null) {
            copyOnWriteArrayList = copyOnWriteArrayListPutIfAbsent;
        }
        copyOnWriteArrayList.add(listener);
        j.H("Added session-scoped user input listener: session=" + sessionId + ", " + listener.getClass().getSimpleName(), TAG);
    }

    public final void removeUserInputListener(String sessionId, UserInputListener listener) {
        kotlin.jvm.internal.k.f(sessionId, "sessionId");
        kotlin.jvm.internal.k.f(listener, "listener");
        CopyOnWriteArrayList<UserInputListener> copyOnWriteArrayList = this.sessionListeners.get(sessionId);
        if (copyOnWriteArrayList == null) {
            return;
        }
        copyOnWriteArrayList.remove(listener);
        if (copyOnWriteArrayList.isEmpty()) {
            this.sessionListeners.remove(sessionId, copyOnWriteArrayList);
        }
        j.H("Removed session-scoped user input listener: session=" + sessionId + ", " + listener.getClass().getSimpleName(), TAG);
    }
}
