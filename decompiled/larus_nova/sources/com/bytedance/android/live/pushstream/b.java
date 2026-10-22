package com.bytedance.android.live.pushstream;

import android.os.Bundle;
import android.view.View;
import com.bytedance.android.live.liveinteract.plantform.core.RtcManager;
import fr2.q0;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;
import uf2.b1;
import uf2.d0;
import uf2.h0;
import uf2.z;

/* JADX INFO: loaded from: classes47.dex */
public interface b {

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f89390a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f89391b;

        public a() {
            this.f89390a = 0;
            this.f89391b = 0;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.live.pushstream.b$b, reason: collision with other inner class name */
    public static class C1372b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f89392a;

        public C1372b() {
            this.f89392a = 0;
        }
    }

    d0 A();

    void A0(String r100);

    void B(String r100);

    void B0(String r100, uv0.a r101);

    z C();

    void C0(uv0.a r100);

    void D();

    void D0(h0.b r100);

    void E0();

    void F0(Bundle r100, com.bytedance.android.live.broadcastgame.opengame.service.g r101);

    void G0();

    void H0(String r100, sk0.a.C7623a r101);

    void I();

    void I0(h0.c r100);

    void J();

    void J0(String r100, uv0.a r101);

    void K0(View r100);

    void L();

    void L0(h0.b r100);

    void M();

    void M0(String r100, uv0.a r101);

    boolean N();

    void N0();

    void O(boolean r100);

    void O0(com.bytedance.android.live.broadcast.api.camera.b r100, String r101);

    void P0(int r100, String r101);

    void Q0(boolean r100, String r101, uv0.a r102);

    void R0(boolean r100, String r101, uv0.a r102);

    void S0(h0.e r100);

    int T0();

    void U0(uv0.a r100);

    ei6.a V0();

    int W0();

    void X0(List<String> r100, uv0.a r101);

    void Y0(int r100);

    void Z0(int r100, uv0.a r101);

    boolean a();

    void a1(float r100);

    uf2.x b();

    void b1(String r100);

    int c1(String r100, Object r101, int r102, boolean r103, boolean r104);

    void d1();

    void e1(h0.b r100);

    void f1(String r100, uv0.a r101);

    ei6.a g1(fi6.a r100);

    JSONObject getClientInfo();

    Map<String, String> getFpsInfo();

    d0 getLiveCore();

    C1372b getStatus();

    View getSurfaceView();

    void h1(h0.c r100);

    void i1(uv0.a r100);

    String j1();

    void k1(uv0.a r100);

    void l1(b1 r100);

    void m1(String r100);

    void n1(int r100);

    void o1(q0 r100);

    void p1(float r100);

    void q1(String r100, uv0.a r101);

    void r1();

    void release();

    void s();

    a s1();

    void startZoom(float r100);

    void t(boolean r100);

    boolean t0();

    void t1(boolean r100);

    void u();

    boolean u1();

    void v1(RtcManager.g r100);

    boolean w0();

    void x0();

    void y(String r100);

    d0.a y0();

    void z0(int r100, int r101);
}
