package com.bytedance.android.livesdk.chatroom.indicator.shortterm;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes7.dex */
public final class g implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ViewGroup f106643a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ View f106644b;

    public g(ViewGroup r100, View r101) {
        this.f106643a = r100;
        this.f106644b = r101;
    }

    public final void a() {
        ViewParent r100 = this.f106643a.getParent();
        if (r100 == null) goto L7;
        ((ViewGroup) r100).addView(this.f106644b, new ViewGroup.MarginLayoutParams(this.f106643a.getWidth(), this.f106643a.getHeight()));
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
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
