package stepai.android.mindx.client.config;

import A4.b;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import kotlin.Metadata;
import kotlin.jvm.internal.k;
import m9.AbstractC1683A;
import m9.AbstractC1729v;
import m9.C1703V;
import m9.C1732y;
import m9.InterfaceC1733z;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\"\u0014\u0010\u0001\u001a\u00020\u00008\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0001\u0010\u0002\"\u0017\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0017\u0010\t\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0014\u0010\r\u001a\u00020\u00008\u0006X\u0086T¢\u0006\u0006\n\u0004\b\r\u0010\u0002\"\u0014\u0010\u000e\u001a\u00020\u00008\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000e\u0010\u0002¨\u0006\u000f"}, d2 = {"", "TAG", "Ljava/lang/String;", "Lm9/v;", "LLMClientDispatcher", "Lm9/v;", "getLLMClientDispatcher", "()Lm9/v;", "Lm9/z;", "LLMClientScope", "Lm9/z;", "getLLMClientScope", "()Lm9/z;", "TARGET_PACKAGE", "TARGET_SERVICE_CLASS", "mindXClient_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ConfigsKt {
    private static final AbstractC1729v LLMClientDispatcher;
    private static final InterfaceC1733z LLMClientScope;
    public static final String TAG = "mindx-client";
    public static final String TARGET_PACKAGE = "stepai.android.mindx.sdk";
    public static final String TARGET_SERVICE_CLASS = "stepai.android.mindx.sdk.service.StepLLMRemoteService";

    static {
        ExecutorService executorServiceNewSingleThreadExecutor = Executors.newSingleThreadExecutor(new b(2));
        k.e(executorServiceNewSingleThreadExecutor, "newSingleThreadExecutor(...)");
        C1703V c1703v = new C1703V(executorServiceNewSingleThreadExecutor);
        LLMClientDispatcher = c1703v;
        LLMClientScope = AbstractC1683A.b(c1703v.plus(AbstractC1683A.c()).plus(new C1732y("step-llm-client")));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Thread LLMClientDispatcher$lambda$1(Runnable runnable) {
        Thread thread = new Thread(runnable, "step-llm-client-thread");
        thread.setDaemon(true);
        return thread;
    }

    public static final AbstractC1729v getLLMClientDispatcher() {
        return LLMClientDispatcher;
    }

    public static final InterfaceC1733z getLLMClientScope() {
        return LLMClientScope;
    }
}
