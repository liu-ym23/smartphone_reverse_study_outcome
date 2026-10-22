package com.bytedance.android.live.misc;

import com.bytedance.android.live.profit.privilege.service.PrivilegePreloadService;
import io.reactivex.functions.Action;

/* JADX INFO: loaded from: classes46.dex */
public final class m implements Action {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.android.livesdk.revenue.message.b f83234a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f83235b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ vlc.l f83236c;

    public m(com.bytedance.android.livesdk.revenue.message.b r100, String r101, PrivilegePreloadService.a r102) {
        this.f83234a = r100;
        this.f83235b = r101;
        this.f83236c = r102;
    }

    @Override // io.reactivex.functions.Action
    public final void run() {
        this.f83234a.removeMessageListener(this.f83235b, this.f83236c);
    }
}
