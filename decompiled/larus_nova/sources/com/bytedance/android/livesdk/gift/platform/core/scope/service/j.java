package com.bytedance.android.livesdk.gift.platform.core.scope.service;

import com.bytedance.ies.sdk.widgets.NextLiveData;

/* JADX INFO: loaded from: classes9.dex */
public final class j implements com.bytedance.android.scope.o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final NextLiveData<Boolean> f131598a;

    @Override // com.bytedance.android.scope.o
    public final void onStop() {
    }

    @Override // com.bytedance.android.scope.o
    public final void onStart() {
        this.f131598a.setValue(Boolean.FALSE);
    }

    public j() {
        this.f131598a = new NextLiveData();
    }
}
