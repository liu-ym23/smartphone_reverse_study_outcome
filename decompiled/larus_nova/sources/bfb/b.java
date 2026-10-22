package bfb;

import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.feed.shared.data.UpdateRecord;

/* JADX INFO: loaded from: classes35.dex */
public final class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a f18850a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ UpdateRecord f18851b;

    public b(a r100, UpdateRecord r101) {
        this.f18850a = r100;
        this.f18851b = r101;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f18850a.a(this.f18851b);     // Catch: Throwable -> L4
        this.f18850a.f18849c = false;     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
