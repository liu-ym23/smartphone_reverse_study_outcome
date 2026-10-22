package com.bytedance.android.live.revlink.impl.pk.ui;

import android.widget.TextView;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes47.dex */
public final class u implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PkTopTipView f97069a;

    public u(PkTopTipView r100) {
        this.f97069a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ((TextView) this.f97069a._$_findCachedViewById(R.id.tv_top_tip)).setFocusable(true);     // Catch: Throwable -> L4
        ((TextView) this.f97069a._$_findCachedViewById(R.id.tv_top_tip)).setFocusableInTouchMode(true);     // Catch: Throwable -> L4
        ((TextView) this.f97069a._$_findCachedViewById(R.id.tv_top_tip)).requestFocus();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
