package L0;

import java.util.concurrent.ThreadFactory;

/* loaded from: classes2.dex */
public final class c implements ThreadFactory {
    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        return new Thread(runnable, "Apm_Normal");
    }
}
