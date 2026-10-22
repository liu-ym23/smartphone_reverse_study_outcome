package cn;

import android.view.View;
import com.bytedance.android.ec.store.search.history.HistoryBanner;

/* JADX INFO: loaded from: classes44.dex */
public final class b implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ HistoryBanner f24310a;

    public b(HistoryBanner r100) {
        this.f24310a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        HistoryBanner.b r101 = this.f24310a.getActionPerformListener();
        if (r101 == null) goto L6;
        r101.b();
        return;
    }
}
