package com.bytedance.android.live.core.tetris.componentx.schedule;

import com.bytedance.android.live.core.log.ALogger;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes45.dex */
public final class d implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ e f65589a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Ref.ObjectRef f65590b;

    public d(e r100, Ref.ObjectRef r101) {
        this.f65589a = r100;
        this.f65590b = r101;
    }

    public final void a() {
        ALogger.i(this.f65589a.f65591b, "loadedbatch = " + this.f65589a.e() + " ____  loadingbatch = " + this.f65589a.f65594e + " __  batchLoadDelayTime = " + ((Long) this.f65590b.element));
        this.f65589a.f();
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
