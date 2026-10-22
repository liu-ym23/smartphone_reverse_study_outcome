package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.mviview;

import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.mviview.adapter.LazyMVIViewPagerAdapter;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftAction;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.PagerListData;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes9.dex */
public final class f1 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ GiftMVIVerticalListView f127929a;

    public f1(GiftMVIVerticalListView r100) {
        this.f127929a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        LazyMVIViewPagerAdapter<PagerListData, GiftAction> r100 = this.f127929a.f127657p;     // Catch: Throwable -> L7
        if (r100 == null) goto L10;
        r100.f127800f = false;     // Catch: Throwable -> L7
        return;
    L10:
        return;
    L7:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L14;
        throw th;
    }
}
