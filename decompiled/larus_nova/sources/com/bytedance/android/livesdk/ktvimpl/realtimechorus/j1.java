package com.bytedance.android.livesdk.ktvimpl.realtimechorus;

import com.bytedance.android.livesdkapi.model.SeiAppData;

/* JADX INFO: loaded from: classes10.dex */
public final class j1 extends com.bytedance.android.livesdk.ktvimpl.base.sei.j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.bytedance.android.live.liveinteract.plantform.datamerge.d f146661a;

    public j1(com.bytedance.android.live.liveinteract.plantform.datamerge.d r100) {
        this.f146661a = r100;
    }

    @Override // md0.a.InterfaceC6802a
    public final void onSeiUpdated(SeiAppData r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        com.bytedance.android.live.liveinteract.plantform.datamerge.d r101 = this.f146661a;
        if (r101 == null) goto L8;
        r101.t0(r100);
        return;
    }
}
