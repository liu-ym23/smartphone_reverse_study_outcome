package cn;

import android.widget.LinearLayout;
import com.bytedance.android.ec.store.search.history.HistoryChip;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes44.dex */
public final class f implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ HistoryChip f24501a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ LinearLayout.LayoutParams f24502b;

    public f(HistoryChip r100, LinearLayout.LayoutParams r101) {
        this.f24501a = r100;
        this.f24502b = r101;
    }

    @Override // java.lang.Runnable
    public final void run() {
        HistoryChip r100 = this.f24501a;     // Catch: Throwable -> L4
        r100.addView(r100.f48538b, this.f24502b);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
