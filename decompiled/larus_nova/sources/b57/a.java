package b57;

import com.bytedance.mt.protector.impl.PatternProtector;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes21.dex */
public final class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f17773a = null;

    static {
        f17773a = new a();
    }

    public a() {
    }

    @Override // java.lang.Runnable
    public final void run() {
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    L13:
        return;
    L3:
        if (d.f17778b.compareAndSet(false, true) == false) goto L9;
        PatternProtector.compile("<meta name=\"pia-snapshot\" content=\"(.*?)\">", 0);     // Catch: Throwable -> L6
        return;
    }
}
