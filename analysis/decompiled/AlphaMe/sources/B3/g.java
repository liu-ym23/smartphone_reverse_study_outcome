package B3;

import java.util.concurrent.ThreadFactory;

/* loaded from: classes2.dex */
public final class g implements ThreadFactory {
    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        throw new AssertionError("No threads allowed.");
    }
}
