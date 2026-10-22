package com.bytedance.android.live.liveinteract.plantform.commonwindow.wm;

import android.content.Context;
import android.opengl.GLSurfaceView;
import android.view.SurfaceView;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.i0;
import com.bytedance.android.live.liveinteract.utils.n1;
import com.bytedance.android.live.liveinteract.videotalk.MultiLinkVideoTalkRoomGuestWidget;
import com.bytedance.android.livesdk.chatroom.utils.o3;
import com.bytedance.android.livesdk.chatroom.widget.j1;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import uf2.d0;
import zg1.a1;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/liveinteract/plantform/commonwindow/wm/ConcertMultiLinkWindowManager;", "Lcom/bytedance/android/live/liveinteract/plantform/commonwindow/wm/CommonMultiLinkWindowManager;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class ConcertMultiLinkWindowManager extends CommonMultiLinkWindowManager {
    public final Lazy X;
    public final Lazy Y;
    public final Lazy Z;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public final t f76076k0;

    public static final class a {
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ConcertMultiLinkWindowManager f76077a;

        public b(ConcertMultiLinkWindowManager r100) {
            this.f76077a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f76077a.m1();     // Catch: Throwable -> L4
            this.f76077a.D.Y7().clear();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.wm.CommonMultiLinkWindowManager, com.bytedance.android.live.liveinteract.plantform.commonwindow.wm.BaseMultiLinkWindowManager, tf0.o
    public final void O() {
        ALogger.i("ConcertMultiLinkWindowManager", "[chorus_concert]  onStopRtcSuccess，delay: " + ((Long) this.X.getValue()));
        i0.c().postDelayed(new b(this), ((Long) this.X.getValue()).longValue());
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.wm.CommonMultiLinkWindowManager, com.bytedance.android.live.liveinteract.plantform.commonwindow.wm.BaseMultiLinkWindowManager, tf0.o
    public final void L() {
        l1();
        SurfaceView r100 = this.D.q1();
        if (r100 == null) goto L5;
        r100.setVisibility(8);
    L5:
        ALogger.i("ConcertMultiLinkWindowManager", "[chorus_concert]  onStartRtcSuccess");
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.wm.CommonMultiLinkWindowManager, com.bytedance.android.live.liveinteract.plantform.commonwindow.wm.BaseMultiLinkWindowManager, tf0.o
    public final void end() {
        super.end();
        j1 r100 = this.G;
        if (r100 == null) goto L5;
        cg6.a r101 = (cg6.a) r100.getScopeServiceOrNullInMultiLinkRoom(cg6.a.class);
    L6:
        if (r101 == null) goto L10;
        hg6.g r102 = r101.getRtcManager();
        if (r102 == null) goto L10;
        r102.Z(this.f76076k0);
    L10:
        ALogger.i("ConcertMultiLinkWindowManager", "[chorus_concert] end");
        return;
    L5:
        r101 = null;
        goto L6
    }

    public static final void q1(ConcertMultiLinkWindowManager r100) {
        SurfaceView r101 = r100.D.q1();
        if (r101 == null) goto L6;
        r101.setVisibility(0);
    L6:
        if (je0.d.L() == true) goto L8;
        return;
    L8:
        if (((Boolean) r100.Z.getValue()).booleanValue() == false) goto L14;
        DataCenter r102 = r100.C;
        if (r102 == null) goto L15;
        r102.put("cmd_interact_state_change", new a1(3));
        return;
    L15:
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.wm.BaseMultiLinkWindowManager, tf0.o
    public final void g(d0 r100) {
        n1.f78815f.getClass();
        n1.b.b(r100);
        ALogger.i("SingleView", "multi_link_service ConcertMultiLinkWindowManager  onRtcAdvanceStartSuccess ConcertMultiLinkWindowManager");
        l1();
        if (((Boolean) this.Z.getValue()).booleanValue() == true) goto L15;
        com.bytedance.live.datacontext.j<com.bytedance.android.livesdk.chatroom.viewmodel.e> r101 = o3.f().getVideoTalkRoomSubScene();
        if (r101 == null) goto L15;
        com.bytedance.android.livesdk.chatroom.viewmodel.e r102 = r101.getValue();
        if (r102 == null) goto L15;
        com.bytedance.android.livesdk.chatroom.viewmodel.j r103 = r102.t();
        if (r103 == null) goto L15;
        if (r103.f114800c != 63) goto L15;
        SurfaceView r104 = this.D.q1();
        if (r104 == null) goto L18;
        r104.setVisibility(0);
    L18:
        ALogger.i("ConcertMultiLinkWindowManager", "[chorus_concert] onRtcAdvanceStartSuccess");
        return;
    L15:
        SurfaceView r105 = this.D.q1();
        if (r105 == null) goto L18;
        r105.setVisibility(8);
        goto L18
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.wm.CommonMultiLinkWindowManager, com.bytedance.android.live.liveinteract.plantform.commonwindow.wm.BaseMultiLinkWindowManager, tf0.o
    public final void l(boolean r100, Pair<Integer, Integer> r101, Pair<Integer, Integer> r102) {
        Intrinsics.checkNotNullParameter(r101, "livePlayerVideoSize");
        Intrinsics.checkNotNullParameter(r102, "livePlayerLayoutSize");
        super.l(r100, r101, r102);
        j1 r103 = this.G;
        if (r103 == null) goto L5;
        cg6.a r104 = (cg6.a) r103.getScopeServiceOrNullInMultiLinkRoom(cg6.a.class);
    L6:
        if (r104 == null) goto L10;
        hg6.g r105 = r104.getRtcManager();
        if (r105 == null) goto L10;
        r105.p(this.f76076k0);
    L10:
        ALogger.i("ConcertMultiLinkWindowManager", "[chorus_concert] start");
        return;
    L5:
        r104 = null;
        goto L6
    }

    public ConcertMultiLinkWindowManager(Context r100, ConstraintLayout r101, com.bytedance.android.live.liveinteract.plantform.commonwindow.m r102, zj0.c r103, com.bytedance.android.live.liveinteract.plantform.datamerge.d r104, DataCenter r105, MultiLinkVideoTalkRoomGuestWidget r106, MultiLinkVideoTalkRoomGuestWidget r107, View r110, GLSurfaceView r111, com.bytedance.android.live.pushstream.d r112, MultiLinkVideoTalkRoomGuestWidget r113) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "containerView");
        Intrinsics.checkNotNullParameter(r102, "layoutConfig");
        Intrinsics.checkNotNullParameter(r104, "dataMergeCenter");
        Intrinsics.checkNotNullParameter(r105, "dataCenter");
        Intrinsics.checkNotNullParameter(r106, "callBack");
        Intrinsics.checkNotNullParameter(r107, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(r110, "interactEmojiLayout");
        Intrinsics.checkNotNullParameter(r111, "renderContainer");
        super(r100, r101, r102, r103, r104, r105, r106, r107, r110, r111, r112, r113);
        this.X = LazyKt.lazy(ConcertMultiLinkWindowManager$mRemoveSurfaceViewDelayTime$2.INSTANCE);
        this.Y = LazyKt.lazy(ConcertMultiLinkWindowManager$mFirstFrameNotifyOpt$2.INSTANCE);
        this.Z = LazyKt.lazy(ConcertMultiLinkWindowManager$mEnableSwitchStreamOpt$2.INSTANCE);
        this.f76076k0 = new t(this);
    }
}
