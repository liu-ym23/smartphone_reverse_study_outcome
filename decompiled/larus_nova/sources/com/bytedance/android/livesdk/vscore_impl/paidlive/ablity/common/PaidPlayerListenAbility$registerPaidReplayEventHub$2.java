package com.bytedance.android.livesdk.vscore_impl.paidlive.ablity.common;

import kotlin.jvm.internal.Intrinsics;
import nic.l;
import nic.p;

/* JADX INFO: loaded from: classes11.dex */
public final class PaidPlayerListenAbility$registerPaidReplayEventHub$2 extends l.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PaidPlayerListenAbility f160123a;

    public PaidPlayerListenAbility$registerPaidReplayEventHub$2(PaidPlayerListenAbility r100) {
        this.f160123a = r100;
    }

    @Override // nic.l.a, nic.h
    public final void B(p r100, tic.a r101) {
        PaidPlayerListenAbility.a(this.f160123a.f160105b, PaidPlayerListenAbility$registerPaidReplayEventHub$2$onRenderStart$1.INSTANCE);
    }

    @Override // nic.l.a, nic.h
    public final void D(oic.f r100, tic.a r101) {
        Intrinsics.checkNotNullParameter(r100, "videoStateInquirer");
        Intrinsics.checkNotNullParameter(r101, "entity");
        PaidPlayerListenAbility.a(this.f160123a.f160105b, PaidPlayerListenAbility$registerPaidReplayEventHub$2$onVideoPreCompleted$1.INSTANCE);
    }

    @Override // nic.l.a, nic.h
    public final void W(oic.f r100, tic.a r101) {
        PaidPlayerListenAbility.a(this.f160123a.f160105b, PaidPlayerListenAbility$registerPaidReplayEventHub$2$onVideoPlay$1.INSTANCE);
    }

    @Override // nic.l.a, nic.h
    public final void o(oic.f r100, tic.a r101) {
        PaidPlayerListenAbility.a(this.f160123a.f160105b, PaidPlayerListenAbility$registerPaidReplayEventHub$2$onVideoReleased$1.INSTANCE);
    }

    @Override // nic.l.a, nic.h
    public final void s(oic.f r100, tic.a r101) {
        PaidPlayerListenAbility.a(this.f160123a.f160105b, PaidPlayerListenAbility$registerPaidReplayEventHub$2$onVideoPause$1.INSTANCE);
    }

    @Override // nic.l.a, nic.h
    public final void q(oic.f r100, tic.a r101, final int r102, int r103) {
        PaidPlayerListenAbility.a(this.f160123a.f160105b, new PaidPlayerListenAbility$registerPaidReplayEventHub$2$onProgressUpdate$1(this, r102));
    }
}
