package k3;

import java.lang.invoke.VarHandle;
import java.util.concurrent.ThreadFactory;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class j implements ThreadFactory {
    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        i iVar = new i(runnable, "fonts-androidx");
        iVar.f7238c = 10;
        VarHandle.storeStoreFence();
        return iVar;
    }
}
