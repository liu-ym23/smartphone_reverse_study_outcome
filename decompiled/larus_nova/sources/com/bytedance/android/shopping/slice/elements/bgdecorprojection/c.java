package com.bytedance.android.shopping.slice.elements.bgdecorprojection;

import androidx.recyclerview.widget.RecyclerView;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes13.dex */
public final class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SlcBgDecorProjectionOptimizedView f183287a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ RecyclerView f183288b;

    public c(SlcBgDecorProjectionOptimizedView r100, RecyclerView r101) {
        this.f183287a = r100;
        this.f183288b = r101;
    }

    @Override // java.lang.Runnable
    public final void run() {
    L16:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L24;
        throw th;
    L24:
        return;
    L3:
        if (this.f183287a.L == false) goto L5;
        return;
    L5:
        if (this.f183287a.M == true) goto L23;
        RecyclerView.Adapter r100 = this.f183288b.getAdapter();     // Catch: Throwable -> L16
        if (r100 == null) goto L10;
        int r101 = r100.getItemCount();     // Catch: Throwable -> L16
    L11:
        SlcBgDecorProjectionOptimizedView.b r102 = this.f183287a.f183226f;     // Catch: Throwable -> L16
        if (r102.f183253a != 0) goto L14;
        r102.f183253a = r101;     // Catch: Throwable -> L16
        r102.notifyDataSetChanged();     // Catch: Throwable -> L16
    L14:
        this.f183287a.w();     // Catch: Throwable -> L16
        return;
    L10:
        r101 = 0;
        goto L11
    }
}
