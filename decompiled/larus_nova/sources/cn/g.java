package cn;

import android.widget.LinearLayout;
import com.bytedance.android.ec.store.search.history.HistoryChip;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes44.dex */
public final class g implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ HistoryChip f24503a;

    public g(HistoryChip r100) {
        this.f24503a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        LinearLayout.LayoutParams r100 = new LinearLayout.LayoutParams(-2, -2);     // Catch: Throwable -> L4
        r100.gravity = 17;     // Catch: Throwable -> L4
        HistoryChip r101 = this.f24503a;     // Catch: Throwable -> L4
        r101.addView(r101.f48537a, r100);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
