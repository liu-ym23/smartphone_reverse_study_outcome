package com.bytedance.android.live.liveinteract.plantform.core;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.livesdk.link.model.bridge.ILinkMicGuideMessageBridge;
import com.bytedance.android.livesdk.link.model.bridge.z0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public class l0 implements uf0.a {
    public l0() {
    }

    @Override // uf0.a
    public final void Ba(z0 r100) {
        Intrinsics.checkNotNullParameter(r100, "message");
    }

    @Override // uf0.a
    public final void Ff(z0 r100) {
        Intrinsics.checkNotNullParameter(r100, "message");
    }

    @Override // uf0.a
    public final void If() {
    }

    @Override // uf0.a
    public final void L2(String r100, Throwable r101) {
    }

    @Override // uf0.b
    public final void b2(com.bytedance.android.live.network.response.e<com.bytedance.android.livesdk.link.model.bridge.i0> r100) {
        Intrinsics.checkNotNullParameter(r100, "response");
    }

    @Override // uf0.a
    public void e6(String r100, IBaseUser r101, com.bytedance.android.livesdk.chatroom.interact.model.v r102) {
        Intrinsics.checkNotNullParameter(r101, "user");
        Intrinsics.checkNotNullParameter(r102, "result");
    }

    @Override // uf0.a
    public final void eo(z0 r100) {
        Intrinsics.checkNotNullParameter(r100, "message");
    }

    @Override // uf0.a
    public final void k5(String r100, Throwable r101) {
    }

    @Override // uf0.a
    public void l(String r100, Throwable r101) {
    }

    @Override // uf0.b
    public final void l0(Throwable r100) {
    }

    @Override // uf0.b
    public final void m0(Throwable r100) {
    }

    @Override // uf0.a
    public void onPermitSuccess(String r100) {
    }

    @Override // uf0.b
    public final void u0() {
    }

    @Override // uf0.a
    public final void vf(ILinkMicGuideMessageBridge r100) {
        Intrinsics.checkNotNullParameter(r100, "message");
    }
}
