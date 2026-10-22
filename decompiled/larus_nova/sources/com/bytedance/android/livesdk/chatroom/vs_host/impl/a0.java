package com.bytedance.android.livesdk.chatroom.vs_host.impl;

import com.bytedance.android.livesdk.chatroom.utils.VrUtils;
import com.bytedance.ies.sdk.widgets.DataCenter;

/* JADX INFO: loaded from: classes8.dex */
public final class a0 implements vr1.x, com.bytedance.android.scope.o {
    public a0() {
    }

    @Override // com.bytedance.android.scope.o
    public final void onStart() {
    }

    @Override // com.bytedance.android.scope.o
    public final void onStop() {
    }

    @Override // vr1.x
    public final boolean f() {
        return VrUtils.B();
    }

    @Override // vr1.x
    public final boolean c(DataCenter r100) {
        return VrUtils.c(r100);
    }

    @Override // vr1.x
    public final boolean d(DataCenter r100) {
        return VrUtils.u(r100, true);
    }

    @Override // vr1.x
    public final boolean g(DataCenter r100) {
        return VrUtils.y(r100);
    }

    @Override // vr1.x
    public final boolean isVrCamera(DataCenter r100) {
        return VrUtils.w(r100);
    }

    @Override // vr1.x
    public final boolean a(DataCenter r100, boolean r101) {
        return VrUtils.t(r100, r101);
    }
}
