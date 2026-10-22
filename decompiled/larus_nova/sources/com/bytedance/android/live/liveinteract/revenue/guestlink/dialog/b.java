package com.bytedance.android.live.liveinteract.revenue.guestlink.dialog;

import android.view.View;
import com.bytedance.android.live.core.utils.a1;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes46.dex */
public final class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BaseGuestLinkMainPageDialog f78469a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Ref.FloatRef f78470b;

    public b(BaseGuestLinkMainPageDialog r100, Ref.FloatRef r101) {
        this.f78469a = r100;
        this.f78470b = r101;
    }

    @Override // java.lang.Runnable
    public final void run() {
        View r100 = this.f78469a.f78421e;     // Catch: Throwable -> L10
        if (r100 == null) goto L5;
        int r101 = r100.getMeasuredWidth();     // Catch: Throwable -> L10
    L6:
        float r102 = r101 / this.f78470b.element;     // Catch: Throwable -> L10
        View r103 = this.f78469a.f78421e;     // Catch: Throwable -> L10
        if (r103 == null) goto L13;
        a1.k(r103, (int) r102);     // Catch: Throwable -> L10
        return;
    L13:
        return;
    L5:
        r101 = 0;
    L10:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L17;
        throw th;
    }
}
