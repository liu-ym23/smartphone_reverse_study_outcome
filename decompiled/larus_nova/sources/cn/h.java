package cn;

import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.ec.store.search.history.HistoryView;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes44.dex */
public final class h implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ HistoryView f24504a;

    public h(HistoryView r100) {
        this.f24504a = r100;
    }

    public final void a() {
        View r100 = HistoryView.b(this.f24504a);
        if (r100 == null) goto L5;
        int r101 = r100.getBottom();
    L6:
        if (r101 == 0) goto L8;
        int r102 = HistoryView.f48543f;
        r101 = r101 + HistoryView.f48545h;
    L8:
        if (r101 != 0) goto L10;
        return;
    L10:
        if (r101 == this.f24504a.getLayoutParams().height) goto L14;
        ViewGroup.LayoutParams r103 = this.f24504a.getLayoutParams();
        r103.height = r101;
        this.f24504a.setLayoutParams(r103);
        return;
    L14:
        return;
    L5:
        r101 = this.f24504a.getHeight();
        goto L6
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
