package com.bytedance.android.live.revenuelink.rtc;

import com.bytedance.android.live.core.monitor.LiveTracingMonitorKt;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes47.dex */
public interface i {

    public static final class a {
        public static /* synthetic */ void a(i r100, String r101, String r102) {
            r100.d0(r101, r102, 0, 0, null);
        }
    }

    void A(String r100, String r101);

    void B(JSONObject r100);

    void D1(String r100, boolean r101, String r102);

    boolean F();

    void F1(LiveTracingMonitorKt.EventModule r100, com.bytedance.android.live.revlink.impl.multianchor.connect.m r101);

    boolean G();

    void G1(String r100, boolean r101, String r102);

    void H1(long r100, String r101);

    void I1(vc0.a r100);

    void J(String r100);

    void J0(boolean r100, boolean r101, boolean r102, boolean r103, boolean r104);

    void K();

    p L();

    List<vc0.a> L0();

    void L1();

    long M(String r100, String r101);

    void M1();

    void N0(JSONObject r100);

    void N1(boolean r100);

    String O();

    void O0(String r100);

    void O1();

    com.bytedance.android.live.revenuelink.b P();

    vc0.a P0();

    void P1(boolean r100, String r101, List<String> r102);

    void Q(String r100, String r101);

    boolean Q0();

    void Q1(String r100);

    void R0(String r100);

    void R1(String r100, boolean r101);

    void S1(String r100, vc0.a r101, long r102);

    void T(String r100, String r101);

    void T1(String r100, boolean r101);

    void U();

    String U0();

    void U1(vc0.a r100, j r101, String r102, q r103);

    void V0(List<String> r100);

    void W0(int r100, long r101, long r102, String r103);

    void Z0(String r100);

    Integer a1(Map<Long, String> r100, String r101, String r102);

    void b0(String r100, int r101, String r102);

    void b1(String r100, boolean r101);

    String c0();

    Integer c1(Map<Long, String> r100, String r101, String r102);

    pc0.e createRtcData();

    void d0(String r100, String r101, int r102, int r103, Map<String, ? extends Object> r104);

    pc0.e e();

    void f();

    String f0();

    void g(String r100);

    boolean g0();

    void g1(g r100);

    String getBusinessId();

    vc0.a getLiveCore();

    String getLiveCoreExtInfo();

    int getMixType();

    String getRtcExtInfo();

    void h(String r100, boolean r101, String r102);

    boolean hasLogin();

    void i(boolean r100);

    void i1(g r100);

    boolean isEngineOn();

    void j();

    void j1(vc0.a r100);

    void k(String r100);

    void k1(pc0.e r100, String r101);

    void logout();

    void muteLocalVideo(boolean r100);

    void n();

    void n1();

    void o();

    void o1();

    void onPause();

    void onResume();

    void p0(boolean r100, String r101);

    void q0();

    void q1(String r100);

    void v1(vc0.a r100, int r101, int r102);

    void x(boolean r100);

    void y1(boolean r100, String r101);
}
