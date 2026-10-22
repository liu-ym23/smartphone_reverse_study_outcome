package com.bytedance.android.livesdk.revenue.service.experience;

import com.bytedance.android.live.room.api.messagewindow.service.IMsgWindowService;
import com.bytedance.android.scope.o;
import jc1.k;

/* JADX INFO: loaded from: classes11.dex */
public final class e implements o, c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public IMsgWindowService f157313a;

    public e() {
    }

    @Override // com.bytedance.android.scope.o
    public final void onStop() {
    }

    @Override // com.bytedance.android.scope.o
    public final void onStart() {
        this.f157313a = (IMsgWindowService) k.n(IMsgWindowService.class);
    }
}
