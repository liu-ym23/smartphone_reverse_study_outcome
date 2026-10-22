package com.bytedance.android.live.liveinteract.plantform.datamerge;

import android.view.SurfaceView;
import com.bytedance.android.live.liveinteract.multianchor.model.LinkmicPositionItem;
import com.bytedance.android.live.liveinteract.plantform.datamerge.handler.v;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.livesdk.link.model.l6;
import com.bytedance.android.livesdkapi.depend.model.live.audio.IVoiceLiveTheme;
import com.bytedance.android.livesdkapi.model.SeiAppData;
import io.reactivex.subjects.BehaviorSubject;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes46.dex */
public interface d extends b {
    void A0(boolean r100);

    void B0(boolean r100);

    void C0(com.bytedance.android.live.liveinteract.plantform.datamerge.handler.b.a r100);

    void D0(ch0.m r100);

    void E0(boolean r100);

    BehaviorSubject<Boolean> F0();

    BehaviorSubject<IVoiceLiveTheme> G0();

    BehaviorSubject<Boolean> H0();

    BehaviorSubject<ch0.i> I0();

    void J0(Map<String, Boolean> r100);

    void K0(String r100);

    void L0(IVoiceLiveTheme r100);

    void M0(com.bytedance.android.live.liveinteract.plantform.datamerge.handler.a r100);

    BehaviorSubject<List<ILinkPlayerInfoBridge>> N0();

    void O0(ch0.b r100);

    BehaviorSubject<ch0.m> P0();

    BehaviorSubject<Map<String, Boolean>> Q0();

    SurfaceView R0();

    BehaviorSubject<Map<String, Boolean>> S0();

    void T0(List<? extends LinkmicPositionItem> r100);

    void U0(Map<String, Long> r100);

    BehaviorSubject<Boolean> V0();

    void W0(ch0.c r100);

    ILinkPlayerInfoBridge X0(String r100);

    void Y0(ch0.k r100);

    void Z0(List<ILinkPlayerInfoBridge> r100);

    void a(List<? extends ILinkPlayerInfoBridge> r100);

    BehaviorSubject<ch0.d> a1();

    BehaviorSubject<wg0.a> b();

    BehaviorSubject<ch0.d> b1();

    void c(wg0.a r100);

    void c1(boolean r100);

    void d1(com.bytedance.android.live.liveinteract.plantform.datamerge.handler.a r100);

    BehaviorSubject<ch0.k> e1();

    BehaviorSubject<List<ch0.e>> f();

    BehaviorSubject<Boolean> f1();

    BehaviorSubject<List<LinkmicPositionItem>> g();

    void g1(com.bytedance.android.live.liveinteract.plantform.datamerge.handler.a r100);

    void h1(Map<String, Boolean> r100);

    void i1(l6 r100);

    BehaviorSubject<Map<String, Boolean>> j1();

    void k1(ch0.l r100);

    ch0.d l1();

    BehaviorSubject<Map<String, Long>> m1();

    void n0(v r100);

    ch0.e n1();

    BehaviorSubject<ch0.b> o1();

    BehaviorSubject<com.bytedance.android.live.liveinteract.plantform.datamerge.handler.b.a> p1();

    v s0();

    void t0(SeiAppData r100);

    BehaviorSubject<List<ILinkPlayerInfoBridge>> u0();

    void v0(com.bytedance.android.live.liveinteract.plantform.datamerge.handler.h.a r100);

    BehaviorSubject<ch0.l> w0();

    BehaviorSubject<ch0.c> x0();

    void y0(ch0.i r100);

    void z0(ch0.d r100);
}
