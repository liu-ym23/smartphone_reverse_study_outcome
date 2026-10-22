package com.bytedance.android.live.liveinteract.revenue.common.vieweffect;

import android.view.View;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.common.utility.UIUtils;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes46.dex */
public final class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f78071a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ View f78072b;

    public a(b r100, View r101) {
        this.f78071a = r100;
        this.f78072b = r101;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int r100 = this.f78072b.getWidth();     // Catch: Throwable -> L9
        UIUtils.updateLayout(this.f78071a.f78073a, r100, r100);     // Catch: Throwable -> L9
        HSImageView r101 = this.f78071a.f78073a;     // Catch: Throwable -> L9
        if (r101 == null) goto L5;
        r101.setTranslationX(r100 / 2);     // Catch: Throwable -> L9
    L5:
        HSImageView r102 = this.f78071a.f78073a;     // Catch: Throwable -> L9
        if (r102 == null) goto L12;
        r102.setTranslationY(-(r100 / 2));     // Catch: Throwable -> L9
        return;
    L12:
        return;
    L9:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L16;
        throw th;
    }
}
