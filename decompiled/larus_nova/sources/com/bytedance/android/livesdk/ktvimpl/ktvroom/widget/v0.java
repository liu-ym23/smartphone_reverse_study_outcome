package com.bytedance.android.livesdk.ktvimpl.ktvroom.widget;

import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes10.dex */
public final class v0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.android.live.ktv.common.util.c f145869a;

    public v0(com.bytedance.android.livesdk.ktvimpl.ktvroom.view.b r100) {
        this.f145869a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Function2<Boolean, Long, Unit> r100 = this.f145869a.getOneDrawCallback();     // Catch: Throwable -> L6
        if (r100 == null) goto L9;
        Unit r101 = r100.invoke(Boolean.TRUE, Long.valueOf(System.currentTimeMillis()));     // Catch: Throwable -> L6
        return;
    L9:
        return;
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    }
}
