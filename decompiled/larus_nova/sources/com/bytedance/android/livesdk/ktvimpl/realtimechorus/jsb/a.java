package com.bytedance.android.livesdk.ktvimpl.realtimechorus.jsb;

import android.view.SurfaceView;
import android.view.TextureView;
import androidx.camera.video.AudioStats;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.ktv.common.util.KtvSettingHelper;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.plantform.core.k;
import com.bytedance.android.livesdk.chatroom.widget.j1;
import com.bytedance.android.livesdk.config.zl0;
import com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.type.LiveWrappedNetworkDetectionLinkType;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.google.gson.JsonObject;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.ss.ttvideoengine.ITTVideoEngineEventSource;
import dg2.e;
import hg6.g;
import java.nio.ByteBuffer;
import kotlin.jvm.internal.Intrinsics;
import uf2.z;
import ui6.d;
import zf2.s0;

/* JADX INFO: loaded from: classes10.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f146674a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final DataCenter f146675b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f146676c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final j1 f146677d;

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.ktvimpl.realtimechorus.jsb.a$a, reason: collision with other inner class name */
    public static final class C2281a {
    }

    public static final class b implements k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f146678a;

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

        @Override // com.bytedance.android.live.liveinteract.plantform.core.v
        public final void k1() {
            j1 r100 = this.f146678a.f146677d;
            if (r100 == null) goto L15;
            cg6.a r101 = (cg6.a) r100.getScopeServiceOrNullInMultiLinkRoom(cg6.a.class);
            if (r101 == null) goto L15;
            g r102 = r101.getRtcManager();
            if (r102 == null) goto L15;
            ei6.a r103 = r102.V0();
            if (r103 == null) goto L15;
            d r104 = r103.l();
            if (r104 == null) goto L15;
            mi6.a r105 = r104.b();
            if (r105 == null) goto L15;
            r105.v();
        L15:
            JsonObject r106 = new JsonObject();
            r106.addProperty("sub_type", "chorus");
            r106.addProperty("ntp_time", 0L);
            r106.addProperty("current_time", Long.valueOf(System.currentTimeMillis()));
            this.f146678a.c("onNtpTimeSynchronizationCompleted", r106);
            ALogger.i("ChorusJsbService", "onNtpTimeSynchronizationCompleted, ntp: 0");
        }

        public b(a r100) {
            this.f146678a = r100;
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
            if (zl0.f121775a.getValue().booleanValue() == true) goto L5;
            return;
        L5:
            ALogger.i("ChorusJsbService", "onFirstRemoteVideoFrameRender, linkId: " + r100);
            JsonObject r102 = new JsonObject();
            r102.addProperty("sub_type", "chorus");
            r102.addProperty("linkId", r100);
            this.f146678a.c("onFirstRemoteVideoFrameDecode", r102);
            xe2.a.b(r100);
        }

        @Override // com.bytedance.android.live.liveinteract.plantform.core.v
        public final void Z4(String r100, int r101) {
            Intrinsics.checkNotNullParameter(r100, "interactId");
            JsonObject r102 = new JsonObject();
            r102.addProperty("sub_type", "chorus");
            r102.addProperty("audio_device_loop_delay", Integer.valueOf(r101));
            this.f146678a.c("onAudioDeviceLoopDelayUpdate", r102);
        }

        @Override // com.bytedance.android.live.liveinteract.plantform.core.v
        public final void d5(e r100, e[] r101) {
            Intrinsics.checkNotNullParameter(r100, "localQuality");
            Intrinsics.checkNotNullParameter(r101, "remoteQualities");
            JsonObject r102 = new JsonObject();
            r102.addProperty("sub_type", "chorus");
            r102.addProperty("rtt", 0);
            r102.addProperty("fraction_lost", Double.valueOf(AudioStats.AUDIO_AMPLITUDE_NONE));
            r102.addProperty("tx_quality", 0);
            this.f146678a.c("onNetworkQuality", r102);
        }

        @Override // com.bytedance.android.live.liveinteract.plantform.core.v
        public final void g(String r100, Boolean r101) {
            Intrinsics.checkNotNullParameter(r100, "interactId");
            if (r100.length() != 0) goto L5;
            boolean r102 = true;
        L6:
            if (r102 == true) goto L15;
            if (r101 != null) goto L9;
            return;
        L9:
            if (Intrinsics.areEqual(r101, Boolean.TRUE) == false) goto L12;
            return;
        L12:
            if (Intrinsics.areEqual(r100, KtvSettingHelper.p().getAccompanimentRobotPrefix() + je0.d.a()) == false) goto L17;
            JsonObject r103 = new JsonObject();
            r103.addProperty("sub_type", "chorus");
            r103.addProperty("interactId", r100);
            r103.addProperty(ITTVideoEngineEventSource.KEY_MUTE, r101);
            ALogger.i("ChorusJsbService", "onRemoteAudioMute, interactId: " + r100 + ", mute: " + r101);
            this.f146678a.c("onUserPublishStreamAudio", r103);
            return;
        L17:
            return;
        L15:
            return;
        L5:
            r102 = false;
            goto L6
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
            JsonObject r103 = new JsonObject();
            r103.addProperty("sub_type", "chorus");
            r103.addProperty("rtt", Integer.valueOf(r101));
            r103.addProperty("fraction_lost", Double.valueOf(r102));
            this.f146678a.c("onNetworkDetectionResult", r103);
        }

        @Override // com.bytedance.android.live.liveinteract.plantform.core.v
        public final void b4(String r100, z.a r101, int r102, int r103) {
            ALogger.i("ChorusJsbService", "onFirstRemoteVideoFrame, linkId: " + r100);
            if (zl0.f121775a.getValue().booleanValue() == false) goto L5;
            return;
        L5:
            JsonObject r104 = new JsonObject();
            r104.addProperty("sub_type", "chorus");
            r104.addProperty("linkId", r100);
            this.f146678a.c("onFirstRemoteVideoFrameDecode", r104);
            xe2.a.b(r100);
        }
    }

    static {
    }

    public final void a() {
        j1 r100 = this.f146677d;
        if (r100 == null) goto L5;
        cg6.a r101 = (cg6.a) r100.getScopeServiceOrNullInMultiLinkRoom(cg6.a.class);
    L6:
        if (r101 == null) goto L11;
        g r102 = r101.getRtcManager();
        if (r102 == null) goto L12;
        r102.Z(this.f146674a);
        return;
    L12:
        return;
    L11:
        return;
    L5:
        r101 = null;
        goto L6
    }

    public final void b(boolean r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "source");
        ALogger.i("ChorusJsbService", "onCheckPerMissionResult, result: " + r100);
        JsonObject r102 = new JsonObject();
        r102.addProperty("sub_type", "chorus");
        r102.addProperty("Success", Boolean.valueOf(r100));
        c("onCheckPermissionFinished", r102);
        xe2.a.a(r100, r101);
    }

    public final void c(String r100, JsonObject r101) {
        IInteractService r102 = (IInteractService) jc1.k.f(IInteractService.class);
        if (r102 == null) goto L8;
        ih0.b r103 = r102.dynamicService(this.f146675b);
        if (r103 == null) goto L9;
        r103.Dk(this.f146676c, r100, r101, true);
        return;
    L9:
        return;
    }

    public a(DataCenter r100, String r101, j1 r102) {
        Intrinsics.checkNotNullParameter(r101, "businessId");
        this.f146675b = r100;
        this.f146676c = r101;
        this.f146677d = r102;
        b r103 = new b(this);
        this.f146674a = r103;
        if (r102 == null) goto L5;
        cg6.a r104 = (cg6.a) r102.getScopeServiceOrNullInMultiLinkRoom(cg6.a.class);
    L6:
        if (r104 == null) goto L11;
        g r105 = r104.getRtcManager();
        if (r105 == null) goto L12;
        r105.p(r103);
        return;
    L12:
        return;
    L11:
        return;
    L5:
        r104 = null;
        goto L6
    }
}
