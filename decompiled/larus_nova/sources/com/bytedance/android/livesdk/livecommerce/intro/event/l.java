package com.bytedance.android.livesdk.livecommerce.intro.event;

import com.bytedance.android.livesdk.livecommerce.room.controller.business.RoomContextController;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes10.dex */
public final class l implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f148279a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f148280b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ RoomContextController f148281c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ boolean f148282d;

    public l(String r100, String r101, RoomContextController r102, boolean r103) {
        this.f148279a = r100;
        this.f148280b = r101;
        this.f148281c = r102;
        this.f148282d = r103;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.bytedance.android.livesdk.livecommerce.event.h r100 = new com.bytedance.android.livesdk.livecommerce.event.h(this.f148279a, this.f148280b, this.f148281c);     // Catch: Throwable -> L4
        r100.d("has_promotion", this.f148282d ? 1 : 0);     // Catch: Throwable -> L4
        r100.f("is_ecom_new", "1");     // Catch: Throwable -> L4
        r100.k();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
