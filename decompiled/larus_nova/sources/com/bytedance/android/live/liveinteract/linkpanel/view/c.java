package com.bytedance.android.live.liveinteract.linkpanel.view;

import android.view.View;
import com.bytedance.android.livesdk.r3;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes46.dex */
public final class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Ref.ObjectRef f75090a;

    public c(Ref.ObjectRef r100) {
        this.f75090a = r100;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.lang.Runnable
    public final void run() {
        View r100 = (View) this.f75090a.element;     // Catch: Throwable -> L4
        Intrinsics.checkNotNull(r100);     // Catch: Throwable -> L4
        r3.p(r100);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
