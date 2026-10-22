package com.bytedance.android.ec.store.sortbar;

import androidx.cardview.widget.CardView;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes44.dex */
public final class g implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CardView f48626a;

    public g(CardView r100) {
        this.f48626a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        CardView r100 = this.f48626a;     // Catch: Throwable -> L4
        r100.setRadius(r100.getHeight() / 2.0f);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
