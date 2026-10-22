package com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery;

import androidx.recyclerview.widget.RecyclerView;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes13.dex */
public final class b0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f169279a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ t f169280b;

    public b0(int r100, t r101) {
        this.f169279a = r100;
        this.f169280b = r101;
    }

    @Override // java.lang.Runnable
    public final void run() {
        t r100 = this.f169280b;     // Catch: Throwable -> L6
        RecyclerView r101 = r100.f169394b;     // Catch: Throwable -> L6
        if (r101 == null) goto L9;
        t.b(r100, this.f169279a, r101);     // Catch: Throwable -> L6
        return;
    L9:
        return;
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    }
}
