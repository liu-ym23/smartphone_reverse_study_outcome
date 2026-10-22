package com.bytedance.android.livesdk.ktvimpl.concert_stage.biz;

import android.view.SurfaceView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class l extends gd2.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ConcertStageComponent f143744a;

    public l(ConcertStageComponent r100) {
        this.f143744a = r100;
    }

    @Override // gd2.e
    public final void d(String r100, final SurfaceView r101) {
        if (r101 != null) goto L4;
        return;
    L4:
        if ((!Intrinsics.areEqual(r100, this.f143744a.f143716q)) == true) goto L9;
        this.f143744a.f143714o = r101;
        w.b("ConcertStageComponent", "onFirstRemoteVideoFrame");
        this.f143744a.l(new ConcertStageComponent$rtcLinkListener$1$onFirstRemoteVideoFrame$1(r101));
        ConcertStageComponent.j(this.f143744a);
        return;
    }
}
