package bh2;

import com.bytedance.android.livesdk.livecommerce.dialog.ECBottomDialog;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes10.dex */
public final class n implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Runnable f19012a;

    @Override // java.lang.Runnable
    public final void run() {
        this.f19012a.run();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public n(ECBottomDialog.a r100) {
        this.f19012a = r100;
    }
}
