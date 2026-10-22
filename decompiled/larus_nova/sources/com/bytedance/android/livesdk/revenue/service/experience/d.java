package com.bytedance.android.livesdk.revenue.service.experience;

import com.bytedance.android.live.room.api.ILiveShareService;
import com.bytedance.android.scope.o;
import jc1.k;

/* JADX INFO: loaded from: classes11.dex */
public final class d implements o, a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ILiveShareService f157312a;

    public d() {
    }

    @Override // com.bytedance.android.scope.o
    public final void onStop() {
    }

    @Override // com.bytedance.android.scope.o
    public final void onStart() {
        this.f157312a = (ILiveShareService) k.f(ILiveShareService.class);
    }
}
