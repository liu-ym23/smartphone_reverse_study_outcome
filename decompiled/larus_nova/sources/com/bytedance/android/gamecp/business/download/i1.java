package com.bytedance.android.gamecp.business.download;

import com.bytedance.map.api.monitor.MapMonitorConst;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class i1 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f52721a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ p f52722b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f52723c;

    public i1(String r100, p r101, String r102) {
        this.f52721a = r100;
        this.f52722b = r101;
        this.f52723c = r102;
    }

    public final void a() {
        String r100 = this.f52721a;
        String r101 = "suc";
        if (Intrinsics.areEqual(r100, "suc") == false) goto L9;
        AppLifecycleObserver r102 = k1.f52798a;
        if (r102.f52305a == true) goto L9;
        if (r102.f52307c == false) goto L9;
        yr.c.a("gamecp_InstallChainReporter", "页面被销毁，并不是真的进入后台，launchSuc被更新为false");
        r100 = MapMonitorConst.EVENT_DESTROY;
    L9:
        StringBuilder r103 = new StringBuilder();
        r103.append(r100);
        r103.append('|');
        AppLifecycleObserver r104 = k1.f52798a;
        AppLifecycleObserver r105 = k1.f52798a;
        if (r105.f52306b == true) goto L13;
        r101 = "no_background";
    L15:
        r103.append(r101);
        String r106 = r103.toString();
        k1.j(this.f52722b, r106, this.f52723c);
        return;
    L13:
        if (r105.f52309e == false) goto L15;
        r101 = "is_foreground";
        goto L15
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
