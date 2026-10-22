package com.bytedance.android.live.soloktv.fragment;

import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes7.dex */
public final class s implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SoloKtvEditFragment f101227a;

    public s(SoloKtvEditFragment r100) {
        this.f101227a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        View r100 = this.f101227a.f101150d;     // Catch: Throwable -> L6
        if (r100 == null) goto L9;
        com.bytedance.android.live.soloktv.util.k.a r101 = com.bytedance.android.live.soloktv.util.k.f101616b;     // Catch: Throwable -> L6
        ViewGroup r102 = UtilityKotlinExtentionsKt.p(r100);     // Catch: Throwable -> L6
        int r103 = SoloKtvEditFragment.f101149u;     // Catch: Throwable -> L6
        r101.getClass();     // Catch: Throwable -> L6
        com.bytedance.android.live.soloktv.util.k.a.a(r100, r102);     // Catch: Throwable -> L6
        return;
    L9:
        return;
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    }
}
