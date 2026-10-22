package com.bytedance.android.live.liveinteract.videotalk;

import com.bytedance.android.live.liveinteract.plantform.permission.model.BaseCheckException;

/* JADX INFO: loaded from: classes46.dex */
public final class h0 implements qh0.d<rh0.a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ rj0.b f79454a;

    public h0(rj0.b r100) {
        this.f79454a = r100;
    }

    @Override // qh0.d
    public final void b(BaseCheckException r100) {
        this.f79454a.onFailed(r100);
    }

    @Override // qh0.d
    public final void onResult(rh0.a r100) {
        this.f79454a.onSuccess();
    }
}
