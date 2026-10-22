package com.bytedance.android.live.liveinteract.animation.tasklet;

import android.widget.FrameLayout;
import com.bytedance.android.live.core.widget.HSImageView;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes46.dex */
public final class r implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ n f71240a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ FrameLayout f71241b;

    public r(n r100, FrameLayout r101) {
        this.f71240a = r100;
        this.f71241b = r101;
    }

    public final void a() {
        Iterator<T> r100 = this.f71240a.f71214d.iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        HSImageView r101 = (HSImageView) r100.next();
        this.f71241b.removeView(r101);
        this.f71240a.f71221k.a(r101);
        goto L4
    L6:
        ((ArrayList) this.f71240a.f71214d).clear();
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
