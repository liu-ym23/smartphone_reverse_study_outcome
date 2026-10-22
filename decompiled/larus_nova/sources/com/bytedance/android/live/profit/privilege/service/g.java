package com.bytedance.android.live.profit.privilege.service;

import com.bytedance.android.annie.api.card.HybridCard;
import io.reactivex.functions.Action;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes47.dex */
public final class g implements Action {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ WeakReference f88457a;

    public g(WeakReference r100) {
        this.f88457a = r100;
    }

    @Override // io.reactivex.functions.Action
    public final void run() {
        HybridCard r100 = (HybridCard) this.f88457a.get();
        if (r100 == null) goto L6;
        r100.release();
        return;
    }
}
