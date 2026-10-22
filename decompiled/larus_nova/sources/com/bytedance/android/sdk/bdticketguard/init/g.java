package com.bytedance.android.sdk.bdticketguard.init;

import com.bytedance.android.sdk.bdticketguard.r0;
import com.bytedance.android.sdk.bdticketguard.setting.l;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes3.dex */
public final class g implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d f163783a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Class f163784b;

    public g(d r100, Class r101) {
        this.f163783a = r100;
        this.f163784b = r101;
    }

    public final void a() {
        l.f164015l0.getClass();
        com.bytedance.android.sdk.bdticketguard.setting.c r100 = l.f164008i;
        KProperty r101 = l.f163998d[4];
        if (((Boolean) r100.a().a()).booleanValue() == true) goto L5;
    L7:
        int r102 = r0.f163979a;
        r0.c("InitTaskManager", "run init task: " + this.f163784b + " with normal priority, source: " + this.f163783a.f163782c);
        this.f163783a.f163780a.invoke();
        return;
    L5:
        if (this.f163783a.f163781b.invoke().booleanValue() == false) goto L7;
        int r103 = r0.f163979a;
        r0.c("InitTaskManager", "run init task: " + this.f163784b + " with high priority, source: " + this.f163783a.f163782c);
        h.a(this.f163783a.f163780a);
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
