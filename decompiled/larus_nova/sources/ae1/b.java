package ae1;

import com.bytedance.android.livesdk.antiaddiction.LiveAntiAddictionFragment;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes7.dex */
public final class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LiveAntiAddictionFragment f3064a;

    public b(LiveAntiAddictionFragment r100) {
        this.f3064a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.bytedance.android.livesdk.antiaddiction.view.a r100 = this.f3064a.f103672o;     // Catch: Throwable -> L6
        if (r100 == null) goto L9;
        r100.b();     // Catch: Throwable -> L6
        return;
    L9:
        return;
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    }
}
