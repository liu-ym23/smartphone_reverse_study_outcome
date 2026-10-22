package com.bytedance.android.livesdk.chatroom.vs_base.log;

import nic.p;

/* JADX INFO: loaded from: classes8.dex */
public final class c extends com.bytedance.android.livesdk.chatroom.vs_base.player.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ReplayDurationLogger f118007a;

    public c(ReplayDurationLogger r100) {
        this.f118007a = r100;
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_base.player.d
    public final void o0(p r100, tic.a r101, long r102, long r103) {
        ReplayDurationLogger r104 = this.f118007a;
        if (r104.f117989b != (-1)) goto L6;
        r104.f117989b = r103;
        return;
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_base.player.d
    public final void q0(oic.f r100, tic.a r101, long r102, long r103) {
        ReplayDurationLogger r104 = this.f118007a;
        if (r104.f117989b != (-1)) goto L6;
        r104.f117989b = r103;
        return;
    }
}
