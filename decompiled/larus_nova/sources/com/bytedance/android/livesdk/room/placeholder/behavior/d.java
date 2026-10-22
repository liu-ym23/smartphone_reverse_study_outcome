package com.bytedance.android.livesdk.room.placeholder.behavior;

import android.view.View;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class d implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ f f157716a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ View f157717b;

    public d(f r100, View r101) {
        this.f157716a = r100;
        this.f157717b = r101;
    }

    public final void a() {
        this.f157716a.f157721d.onViewAttached(l.a(this.f157717b));
        DataCenter r100 = this.f157716a.f157720c;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("dataCenter");
    L5:
        r100.put("cmd_specific_view_loaded", this.f157716a.f157721d.getClass().getName());
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
