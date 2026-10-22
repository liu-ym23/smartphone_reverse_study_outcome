package com.bytedance.android.livesdk.gift.platform.business.normal.view.v2.animation;

import android.animation.AnimatorSet;
import com.bytedance.android.livesdk.gift.platform.business.normal.view.v2.TrayWaveControllerView;
import com.bytedance.android.livesdk.gift.platform.business.normal.view.v2.m;
import com.bytedance.android.livesdk.gift.platform.business.normal.view.v2.p;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes9.dex */
public final class d implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ e f129938a;

    public d(e r100) {
        this.f129938a = r100;
    }

    public final void a() {
        b r100 = this.f129938a.f129939a;
        int r101 = b.f129920i;
        r100.a(true);
        TrayWaveControllerView r102 = this.f129938a.f129939a.f129928e;
        if (r102 == null) goto L26;
        r102.setVisibility(0);
        List<p> r103 = r102.f129902b;
        if (r103 == null) goto L10;
        Iterator<T> r104 = r103.iterator();
    L8:
        if (r104.hasNext() == false) goto L10;
        r102.addView((p) r104.next());
    L10:
        List<AnimatorSet> r105 = r102.f129901a;
        if (r105 == null) goto L18;
        Iterator<T> r106 = r105.iterator();
    L14:
        if (r106.hasNext() == false) goto L18;
        AnimatorSet r107 = (AnimatorSet) r106.next();
        if (r107 == null) goto L14;
        r107.start();
    L18:
        r102.postDelayed(new m(r102), 1400);
        return;
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
