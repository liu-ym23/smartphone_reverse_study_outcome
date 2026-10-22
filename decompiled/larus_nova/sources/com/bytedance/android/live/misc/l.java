package com.bytedance.android.live.misc;

import com.bytedance.android.live.profit.privilege.service.PrivilegePreloadService;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes46.dex */
public final class l<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.android.livesdk.revenue.message.b f83231a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f83232b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ vlc.l f83233c;

    public l(com.bytedance.android.livesdk.revenue.message.b r100, String r101, PrivilegePreloadService.a r102) {
        this.f83231a = r100;
        this.f83232b = r101;
        this.f83233c = r102;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Disposable r101 = (Disposable) r100;
        this.f83231a.addMessageListener(this.f83232b, this.f83233c);
    }
}
