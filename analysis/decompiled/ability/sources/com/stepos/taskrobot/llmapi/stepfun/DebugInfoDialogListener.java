package com.stepos.taskrobot.llmapi.stepfun;

import C7.r;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.VisibleForTesting;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.taskrobot.llmapi.stepfun.view.InfoDebugWindow;
import java.io.Serializable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;
import kotlin.Result;
import stepai.aios.guiexecutor.input.UserInputListener;
import stepai.aios.guiexecutor.input.UserInputRequest;
import ua.C2052a;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\bÀ\u0002\u0018\u00002\u00020\u0001:\u0004)*+,B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\r\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u001f\u0010\u000f\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u000f\u0010\u000eJ'\u0010\u0011\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\tH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J'\u0010\u0014\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\tH\u0016¢\u0006\u0004\b\u0014\u0010\u0012J+\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u00152\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00060\u0017H\u0007¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001c\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\u001c\u0010\u0003R\u0014\u0010\u001d\u001a\u00020\t8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR&\u0010\"\u001a\u0014\u0012\u0004\u0012\u00020\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020!0 0\u001f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010$\u001a\u00020\u00048\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010&\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b&\u0010'R\"\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00060\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010(¨\u0006-"}, d2 = {"Lcom/stepos/taskrobot/llmapi/stepfun/DebugInfoDialogListener;", "Lstepai/aios/guiexecutor/input/UserInputListener;", AppAgent.CONSTRUCT, "()V", "Landroid/content/Context;", "context", "LC7/r;", "init", "(Landroid/content/Context;)V", "", "sessionId", "Lstepai/aios/guiexecutor/input/UserInputRequest;", "inputRequest", "onUserInputRequested", "(Ljava/lang/String;Lstepai/aios/guiexecutor/input/UserInputRequest;)V", "onUserInputTimeout", "reason", "onUserInputCancelled", "(Ljava/lang/String;Lstepai/aios/guiexecutor/input/UserInputRequest;Ljava/lang/String;)V", "errorMessage", "onUserInputValidationFailed", "Lcom/stepos/taskrobot/llmapi/stepfun/DebugInfoDialogListener$WindowOpener;", "fakeOpener", "Lkotlin/Function1;", "Ljava/lang/Runnable;", "runOnMain", "installForTest", "(Lcom/stepos/taskrobot/llmapi/stepfun/DebugInfoDialogListener$WindowOpener;LS7/k;)V", "resetForTest", "TAG", "Ljava/lang/String;", "Ljava/util/concurrent/ConcurrentHashMap;", "Ljava/util/concurrent/atomic/AtomicReference;", "Lcom/stepos/taskrobot/llmapi/stepfun/DebugInfoDialogListener$WindowHandle;", "windows", "Ljava/util/concurrent/ConcurrentHashMap;", "appContext", "Landroid/content/Context;", "opener", "Lcom/stepos/taskrobot/llmapi/stepfun/DebugInfoDialogListener$WindowOpener;", "LS7/k;", "WindowOpener", "WindowHandle", "PendingPlaceholder", "DefaultProductionOpener", "stepfun_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class DebugInfoDialogListener implements UserInputListener {
    private static final String TAG = "DebugInfoDialogListener";
    private static volatile Context appContext;
    public static final DebugInfoDialogListener INSTANCE = new DebugInfoDialogListener();
    private static final ConcurrentHashMap<String, AtomicReference<WindowHandle>> windows = new ConcurrentHashMap<>();
    private static volatile WindowOpener opener = DefaultProductionOpener.INSTANCE;
    private static volatile S7.k runOnMain = new n(2);

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÂ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J9\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00042\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00070\u00062\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\tH\u0016¢\u0006\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/stepos/taskrobot/llmapi/stepfun/DebugInfoDialogListener$DefaultProductionOpener;", "Lcom/stepos/taskrobot/llmapi/stepfun/DebugInfoDialogListener$WindowOpener;", AppAgent.CONSTRUCT, "()V", "", "message", "Lkotlin/Function1;", "LC7/r;", "onSubmit", "Lkotlin/Function0;", "onCancel", "Lcom/stepos/taskrobot/llmapi/stepfun/DebugInfoDialogListener$WindowHandle;", "open", "(Ljava/lang/String;LS7/k;LS7/a;)Lcom/stepos/taskrobot/llmapi/stepfun/DebugInfoDialogListener$WindowHandle;", "stepfun_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class DefaultProductionOpener implements WindowOpener {
        public static final DefaultProductionOpener INSTANCE = new DefaultProductionOpener();

        private DefaultProductionOpener() {
        }

        @Override // com.stepos.taskrobot.llmapi.stepfun.DebugInfoDialogListener.WindowOpener
        public WindowHandle open(String message, S7.k onSubmit, S7.a onCancel) {
            kotlin.jvm.internal.k.f(message, "message");
            kotlin.jvm.internal.k.f(onSubmit, "onSubmit");
            kotlin.jvm.internal.k.f(onCancel, "onCancel");
            if (DebugInfoDialogListener.appContext == null) {
                throw new IllegalStateException("DebugInfoDialogListener not initialized; call init(context) first");
            }
            InfoDebugWindow.Companion companion = InfoDebugWindow.INSTANCE;
            Context context = DebugInfoDialogListener.appContext;
            if (context != null) {
                final InfoDebugWindow infoDebugWindowShow = companion.show(context, message, onSubmit, onCancel);
                return new WindowHandle() { // from class: com.stepos.taskrobot.llmapi.stepfun.DebugInfoDialogListener$DefaultProductionOpener$open$2
                    @Override // com.stepos.taskrobot.llmapi.stepfun.DebugInfoDialogListener.WindowHandle
                    public void dismiss() {
                        infoDebugWindowShow.dismiss();
                    }
                };
            }
            kotlin.jvm.internal.k.n("appContext");
            throw null;
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÂ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0005\u0010\u0003¨\u0006\u0006"}, d2 = {"Lcom/stepos/taskrobot/llmapi/stepfun/DebugInfoDialogListener$PendingPlaceholder;", "Lcom/stepos/taskrobot/llmapi/stepfun/DebugInfoDialogListener$WindowHandle;", AppAgent.CONSTRUCT, "()V", "LC7/r;", "dismiss", "stepfun_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class PendingPlaceholder implements WindowHandle {
        public static final PendingPlaceholder INSTANCE = new PendingPlaceholder();

        private PendingPlaceholder() {
        }

        @Override // com.stepos.taskrobot.llmapi.stepfun.DebugInfoDialogListener.WindowHandle
        public void dismiss() {
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005À\u0006\u0003"}, d2 = {"Lcom/stepos/taskrobot/llmapi/stepfun/DebugInfoDialogListener$WindowHandle;", "", "LC7/r;", "dismiss", "()V", "stepfun_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public interface WindowHandle {
        void dismiss();
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J9\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00050\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007H&¢\u0006\u0004\b\n\u0010\u000b¨\u0006\fÀ\u0006\u0003"}, d2 = {"Lcom/stepos/taskrobot/llmapi/stepfun/DebugInfoDialogListener$WindowOpener;", "", "", "message", "Lkotlin/Function1;", "LC7/r;", "onSubmit", "Lkotlin/Function0;", "onCancel", "Lcom/stepos/taskrobot/llmapi/stepfun/DebugInfoDialogListener$WindowHandle;", "open", "(Ljava/lang/String;LS7/k;LS7/a;)Lcom/stepos/taskrobot/llmapi/stepfun/DebugInfoDialogListener$WindowHandle;", "stepfun_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public interface WindowOpener {
        WindowHandle open(String message, S7.k onSubmit, S7.a onCancel);
    }

    private DebugInfoDialogListener() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onUserInputRequested$lambda$0(String str, AtomicReference atomicReference, UserInputRequest userInputRequest) {
        if (windows.get(str) != atomicReference) {
            return;
        }
        try {
            WindowHandle windowHandleOpen = opener.open(userInputRequest.getMessage(), new R3.c(str, 17), new a(str, 0));
            if (atomicReference.compareAndSet(PendingPlaceholder.INSTANCE, windowHandleOpen)) {
                return;
            }
            windowHandleOpen.dismiss();
        } catch (Exception e) {
            N9.j.J("open window failed: " + e.getMessage(), TAG);
            windows.remove(str, atomicReference);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final r onUserInputRequested$lambda$0$0(String requestId, String text) {
        Object objA;
        stepai.aios.guiagent.runtime.a aVar;
        kotlin.jvm.internal.k.f(text, "text");
        windows.remove(requestId);
        try {
            aVar = C2052a.c;
        } catch (Throwable th) {
            objA = kotlin.b.a(th);
        }
        if (aVar == null) {
            throw new IllegalStateException("GuiAgentManager is not initialized");
        }
        kotlin.jvm.internal.k.f(requestId, "requestId");
        objA = Boolean.valueOf(aVar.f.provideUserInput(requestId, text));
        Throwable thA = Result.a(objA);
        if (thA != null) {
            N9.j.J("provideUserInput failed: " + thA.getMessage(), TAG);
        }
        return r.f317a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final r onUserInputRequested$lambda$0$1(String requestId) {
        Object objA;
        stepai.aios.guiagent.runtime.a aVar;
        try {
            aVar = C2052a.c;
        } catch (Throwable th) {
            objA = kotlin.b.a(th);
        }
        if (aVar == null) {
            throw new IllegalStateException("GuiAgentManager is not initialized");
        }
        kotlin.jvm.internal.k.f(requestId, "requestId");
        objA = Boolean.valueOf(aVar.f.cancelUserInput(requestId, "user_cancelled"));
        Throwable thA = Result.a(objA);
        if (thA != null) {
            N9.j.J("cancelUserInput failed: " + thA.getMessage(), TAG);
        }
        return r.f317a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final r resetForTest$lambda$0(Runnable r5) {
        kotlin.jvm.internal.k.f(r5, "r");
        new Handler(Looper.getMainLooper()).post(r5);
        return r.f317a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final r runOnMain$lambda$0(Runnable r5) {
        kotlin.jvm.internal.k.f(r5, "r");
        new Handler(Looper.getMainLooper()).post(r5);
        return r.f317a;
    }

    public final void init(Context context) {
        kotlin.jvm.internal.k.f(context, "context");
        Context applicationContext = context.getApplicationContext();
        kotlin.jvm.internal.k.e(applicationContext, "getApplicationContext(...)");
        appContext = applicationContext;
        N9.j.H("DebugInfoDialogListener initialized", TAG);
    }

    @VisibleForTesting
    public final void installForTest(WindowOpener fakeOpener, S7.k runOnMain2) {
        kotlin.jvm.internal.k.f(fakeOpener, "fakeOpener");
        kotlin.jvm.internal.k.f(runOnMain2, "runOnMain");
        opener = fakeOpener;
        runOnMain = runOnMain2;
    }

    @Override // stepai.aios.guiexecutor.input.UserInputListener
    public void onUserInputCancelled(String sessionId, UserInputRequest inputRequest, String reason) {
        PendingPlaceholder pendingPlaceholder;
        WindowHandle andSet;
        kotlin.jvm.internal.k.f(sessionId, "sessionId");
        kotlin.jvm.internal.k.f(inputRequest, "inputRequest");
        kotlin.jvm.internal.k.f(reason, "reason");
        AtomicReference<WindowHandle> atomicReferenceRemove = windows.remove(inputRequest.getRequestId());
        if (atomicReferenceRemove == null || (andSet = atomicReferenceRemove.getAndSet((pendingPlaceholder = PendingPlaceholder.INSTANCE))) == pendingPlaceholder) {
            return;
        }
        andSet.dismiss();
    }

    @Override // stepai.aios.guiexecutor.input.UserInputListener
    public void onUserInputRequested(String sessionId, UserInputRequest inputRequest) {
        kotlin.jvm.internal.k.f(sessionId, "sessionId");
        kotlin.jvm.internal.k.f(inputRequest, "inputRequest");
        String requestId = inputRequest.getRequestId();
        AtomicReference<WindowHandle> atomicReference = new AtomicReference<>(PendingPlaceholder.INSTANCE);
        if (windows.putIfAbsent(requestId, atomicReference) != null) {
            return;
        }
        runOnMain.invoke(new A4.e(requestId, (Serializable) atomicReference, (Object) inputRequest, 5));
    }

    @Override // stepai.aios.guiexecutor.input.UserInputListener
    public void onUserInputTimeout(String sessionId, UserInputRequest inputRequest) {
        kotlin.jvm.internal.k.f(sessionId, "sessionId");
        kotlin.jvm.internal.k.f(inputRequest, "inputRequest");
        onUserInputCancelled(sessionId, inputRequest, InjectExperienceResult.REASON_TIMEOUT);
    }

    @Override // stepai.aios.guiexecutor.input.UserInputListener
    public void onUserInputValidationFailed(String sessionId, UserInputRequest inputRequest, String errorMessage) {
        kotlin.jvm.internal.k.f(sessionId, "sessionId");
        kotlin.jvm.internal.k.f(inputRequest, "inputRequest");
        kotlin.jvm.internal.k.f(errorMessage, "errorMessage");
        onUserInputCancelled(sessionId, inputRequest, "validation_failed");
    }

    @VisibleForTesting
    public final void resetForTest() {
        opener = DefaultProductionOpener.INSTANCE;
        runOnMain = new n(3);
        windows.clear();
    }
}
