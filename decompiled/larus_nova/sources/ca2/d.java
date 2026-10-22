package ca2;

import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Iterator;

/* JADX INFO: loaded from: classes9.dex */
public final class d implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c f22930a;

    @Override // java.lang.Runnable
    public final void run() {
        c r100 = this.f22930a;     // Catch: Throwable -> L7
        r100.f139327v = false;     // Catch: Throwable -> L7
        Iterator<T> r101 = r100.f22924w.iterator();     // Catch: Throwable -> L7
    L4:
        if (r101.hasNext() == false) goto L16;
        ((a) r101.next()).onTransitionEnd(this.f22930a.f22925x);     // Catch: Throwable -> L7
        goto L4
    L16:
        return;
    L7:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L11;
        return;
    L11:
        throw th;
    }

    public d(c r100) {
        this.f22930a = r100;
    }
}
