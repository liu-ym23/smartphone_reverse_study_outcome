package com.bytedance.android.shopping.anchorv4.containers.page;

import android.view.ViewGroup;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Iterator;

/* JADX INFO: loaded from: classes12.dex */
public final class t implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ u f166324a;

    public t(u r100) {
        this.f166324a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        u r100 = this.f166324a;     // Catch: Throwable -> L14
        r100.f166327c = null;     // Catch: Throwable -> L14
        Iterator<T> r101 = r100.f166329e.f166291a.iterator();     // Catch: Throwable -> L14
    L4:
        if (r101.hasNext() == false) goto L12;
        ViewGroup r102 = (ViewGroup) r101.next();     // Catch: Throwable -> L14
        if (r102 == null) goto L8;
        int r103 = r102.getChildCount();     // Catch: Throwable -> L14
    L9:
        if (r103 <= 0) goto L4;
        if (r102 == null) goto L4;
        r102.removeViewAt(0);     // Catch: Throwable -> L14
        goto L4
    L8:
        r103 = 0;
        goto L9
    L12:
        this.f166324a.f166329e.a(true);     // Catch: Throwable -> L14
        return;
    L14:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L18;
        return;
    L18:
        throw th;
    }
}
