package A4;

import com.mdisdk.capability.input.impl.gesture.BaseGestureExecutor;
import java.util.concurrent.ThreadFactory;
import stepai.android.mindx.client.config.ConfigsKt;

/* loaded from: classes3.dex */
public final /* synthetic */ class b implements ThreadFactory {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f97a;

    public /* synthetic */ b(int i) {
        this.f97a = i;
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        switch (this.f97a) {
            case 0:
                Thread thread = new Thread(runnable, "TaskListener-Callback");
                thread.setDaemon(true);
                return thread;
            case 1:
                return new Thread(runnable, "clawbench-probe-store");
            case 2:
                return ConfigsKt.LLMClientDispatcher$lambda$1(runnable);
            case 3:
                return new Thread(runnable, "SpeechRecognitionAbilityAdapter-multi-files");
            case 4:
                Thread thread2 = new Thread(runnable, "device-id-oaid");
                thread2.setDaemon(true);
                return thread2;
            case 5:
                return new Thread(runnable, "GlobalTask");
            case 6:
                return BaseGestureExecutor.lambda$static$0(runnable);
            case 7:
                Thread thread3 = new Thread(runnable, "voice-wakeup-retry");
                thread3.setDaemon(true);
                return thread3;
            default:
                Thread thread4 = new Thread(runnable, "voice-wakeup");
                thread4.setDaemon(true);
                return thread4;
        }
    }
}
