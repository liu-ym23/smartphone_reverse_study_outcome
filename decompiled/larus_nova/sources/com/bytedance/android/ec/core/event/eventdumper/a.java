package com.bytedance.android.ec.core.event.eventdumper;

import android.content.Context;
import android.content.IntentFilter;
import com.bytedance.android.ec.core.event.b;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes43.dex */
public final class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Context f44020a;

    public a(Context r100) {
        this.f44020a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        b.f44010a.registerReceiver(this.f44020a, new ECEventDumper(), new IntentFilter("com.bytedance.ec.eventdumper"));     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
