package com.bytedance.android.ec.core.monitor;

import android.content.ComponentCallbacks2;
import android.content.Context;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.ec.core.utils.ECQuickUtilKt;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Unit;

/* JADX INFO: loaded from: classes43.dex */
public final class MonitorService$monitorParams$runnable$1 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Context f45126a;

    public MonitorService$monitorParams$runnable$1(Context r100) {
        this.f45126a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ComponentCallbacks2 r100 = com.bytedance.android.ec.sdk.plugin.e.getActivity(this.f45126a);     // Catch: Throwable -> L10
        if ((r100 instanceof LifecycleOwner) == true) goto L5;
        r100 = null;
    L5:
        LifecycleOwner r101 = (LifecycleOwner) r100;     // Catch: Throwable -> L10
        if (r101 != null) goto L8;
        r101 = ECQuickUtilKt.f45526b;     // Catch: Throwable -> L10
    L8:
        final Lifecycle r102 = r101.getLifecycle();     // Catch: Throwable -> L10
        r102.addObserver(new MonitorService$monitorParams$runnable$1$$special$$inlined$apply$lambda$1(r102, this));     // Catch: Throwable -> L10
        MonitorService.f45125a.put(this.f45126a, Unit.INSTANCE);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L14;
        return;
    L14:
        throw th;
    }
}
