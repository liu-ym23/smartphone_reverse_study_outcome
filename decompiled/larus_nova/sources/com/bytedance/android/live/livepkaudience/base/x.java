package com.bytedance.android.live.livepkaudience.base;

import com.bytedance.android.livesdk.chatroom.interact.model.LinkInviteResult;
import com.bytedance.android.livesdk.message.model.xe;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public class x implements g {
    public x() {
    }

    @Override // com.bytedance.android.live.livepkaudience.base.g
    public final void Em(xe r100) {
        Intrinsics.checkNotNullParameter(r100, "message");
    }

    @Override // com.bytedance.android.live.livepkaudience.base.g
    public final void L2(String r100, Throwable r101) {
        Intrinsics.checkNotNullParameter(r100, "uid");
    }

    @Override // com.bytedance.android.live.livepkaudience.base.g
    public void V6(String r100, LinkInviteResult r101) {
        Intrinsics.checkNotNullParameter(r100, "uid");
        Intrinsics.checkNotNullParameter(r101, "result");
    }

    @Override // com.bytedance.android.live.livepkaudience.base.g
    public final void c7(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "uid");
    }

    @Override // com.bytedance.android.live.livepkaudience.base.g
    public final void k5(String r100, Throwable r101) {
        Intrinsics.checkNotNullParameter(r100, "uid");
    }

    @Override // com.bytedance.android.live.livepkaudience.base.g
    public void l(String r100, Throwable r101) {
        Intrinsics.checkNotNullParameter(r100, "uid");
    }

    @Override // com.bytedance.android.live.livepkaudience.base.g
    public final void l0(Throwable r100) {
    }

    @Override // com.bytedance.android.live.livepkaudience.base.g
    public final void nm(xe r100) {
        Intrinsics.checkNotNullParameter(r100, "message");
    }

    @Override // com.bytedance.android.live.livepkaudience.base.g
    public void onPermitSuccess(String r100) {
        Intrinsics.checkNotNullParameter(r100, "uid");
    }

    @Override // com.bytedance.android.live.livepkaudience.base.g
    public final void u0() {
    }
}
