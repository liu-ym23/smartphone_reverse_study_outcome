package com.bytedance.android.live.liveinteract.plantform.commonwindow.wm;

import android.view.SurfaceView;
import android.view.TextureView;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.config.am0;
import com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.type.LiveWrappedNetworkDetectionLinkType;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import java.nio.ByteBuffer;
import kotlin.jvm.internal.Intrinsics;
import uf2.z;
import zf2.s0;

/* JADX INFO: loaded from: classes46.dex */
public final class t implements com.bytedance.android.live.liveinteract.plantform.core.k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ConcertMultiLinkWindowManager f76109a;

    @Override // com.bytedance.android.live.liveinteract.plantform.core.v
    public final void D1(String r100, ByteBuffer r101, int r102) {
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.core.v
    public final void G9(long r100, Exception r101) {
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.core.v
    public final void J(String[] r100, boolean[] r101, int[] r102) {
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.core.v
    public final void L(String r100) {
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.core.v
    public final void L0(String r100, TextureView r101, int r102, int r103) {
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.core.k
    public final void Lb() {
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.core.v
    public final void M1() {
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.core.v
    public final void R(long r100, Exception r101) {
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.core.v
    public final void S(String r100, int r101, int r102) {
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.core.v
    public final void T6(String r100, s0 r101) {
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.core.v
    public final void Xi(int r100, int r101) {
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.core.v
    public final void al(String r100, int r101) {
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.core.k
    public final void ci() {
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.core.v
    public final void e1(String r100, long r101) {
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.core.v
    public final void f0(long r100, Exception r101) {
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.core.v
    public final void f1(long r100, long r101) {
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.core.v
    public final void f4() {
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.core.v
    public final void h1(String r100, SurfaceView r101, int r102, int r103) {
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.core.v
    public final void h6(int r100) {
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.core.v
    public final void ip(Object r100) {
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.core.v
    public final void j0(String r100, TextureView r101, int r102, int r103) {
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.core.v
    public final void k1() {
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.core.v
    public final void o() {
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.core.v
    public final void o0(long r100) {
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.core.t
    public final void p2(fi6.a r100) {
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.core.v
    public final void wf(String r100) {
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.core.v
    public final void wk(String r100) {
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.core.v
    public final void y0(String r100, SurfaceView r101, int r102, int r103) {
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.core.k
    public final void z7() {
    }

    public t(ConcertMultiLinkWindowManager r100) {
        this.f76109a = r100;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.core.v
    public final void onUserJoined(String r100) {
        Intrinsics.checkNotNullParameter(r100, "s");
        Intrinsics.checkNotNullParameter(r100, "s");
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.core.v
    public final void A(String r100, Boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "interactId");
        Intrinsics.checkNotNullParameter(r100, "interactId");
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.core.v
    public final void J3(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "from");
        Intrinsics.checkNotNullParameter(r101, "message");
        com.bytedance.android.live.liveinteract.plantform.core.g.a(r100, r101);
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.core.v
    public final void S1(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "rtcRoomId");
        Intrinsics.checkNotNullParameter(r101, "interactId");
        com.bytedance.android.live.liveinteract.plantform.core.g.c(r100, r101);
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.core.v
    public final void V4(String r100, z.a r101) {
        if (((Boolean) this.f76109a.Y.getValue()).booleanValue() == false) goto L5;
        ConcertMultiLinkWindowManager.q1(this.f76109a);
    L5:
        ALogger.i("ConcertMultiLinkWindowManager", "[chorus_concert] onFirstRemoteVideoFrameRender");
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.core.v
    public final void Z4(String r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "interactId");
        Intrinsics.checkNotNullParameter(r100, "interactId");
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.core.v
    public final void d5(dg2.e r100, dg2.e[] r101) {
        Intrinsics.checkNotNullParameter(r100, "localQuality");
        Intrinsics.checkNotNullParameter(r101, "remoteQualities");
        com.bytedance.android.live.liveinteract.plantform.core.g.d(r100, r101);
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.core.v
    public final void g(String r100, Boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "interactId");
        Intrinsics.checkNotNullParameter(r100, "interactId");
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.core.v
    public final void n2(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "rtcRoomId");
        Intrinsics.checkNotNullParameter(r101, "interactId");
        com.bytedance.android.live.liveinteract.plantform.core.g.b(r100, r101);
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.core.v
    public final void Hf(int r100, String r101, int r102) {
        Intrinsics.checkNotNullParameter(r101, "deviceId");
        Intrinsics.checkNotNullParameter(r101, "deviceId");
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.core.v
    public final void Rj(int r100, int r101, String r102) {
        Intrinsics.checkNotNullParameter(r102, DBDefinition.TASK_ID);
        Intrinsics.checkNotNullParameter(r102, DBDefinition.TASK_ID);
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.core.v
    public final void x1(LiveWrappedNetworkDetectionLinkType r100, int r101, double r102) {
        Intrinsics.checkNotNullParameter(r100, "type");
        Intrinsics.checkNotNullParameter(r100, "type");
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.core.v
    public final void b4(String r100, z.a r101, int r102, int r103) {
        if (((Boolean) this.f76109a.Y.getValue()).booleanValue() == true) goto L6;
        ConcertMultiLinkWindowManager.q1(this.f76109a);
    L8:
        ALogger.i("ConcertMultiLinkWindowManager", "[chorus_concert] onFirstRemoteVideoFrame");
        return;
    L6:
        if (am0.f119804a.getValue().booleanValue() == false) goto L8;
        ConcertMultiLinkWindowManager.q1(this.f76109a);
        goto L8
    }
}
