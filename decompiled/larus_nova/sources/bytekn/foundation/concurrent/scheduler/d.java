package bytekn.foundation.concurrent.scheduler;

import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes3.dex */
public final class d implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function0 f21740a;

    public d(Function0 r100) {
        this.f21740a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f21740a.invoke();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L11;
        return;
    L11:
        throw th;
    }
}
