package com.bytedance.applog;

import android.accounts.Account;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import com.bytedance.applog.isolate.DataIsolateKey;
import com.bytedance.bdinstall.Level;
import com.bytedance.bdinstall.d0;
import com.bytedance.bdinstall.f0;
import com.bytedance.bdinstall.g0;
import com.bytedance.bdinstall.t0;
import com.bytedance.bdinstall.y;
import java.net.Proxy;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public interface g {
    void A(ow3.b r100);

    void A0(boolean r100);

    void A1(boolean r100);

    void B(boolean r100);

    void B0(boolean r100);

    void B1();

    uw3.i C();

    boolean C0();

    void C1(boolean r100);

    void D(String r100);

    void D0(long r100);

    void D1();

    void E(String r100);

    void E0(h r100);

    void E1(long r100, t0 r101);

    void F(boolean r100);

    void F0(int r100);

    void F1(int r100);

    void G(boolean r100);

    void G0();

    <T> T G1(String r100, T r101, Class<T> r102);

    void H(View r100, String r101, String r102, JSONObject r103);

    void H0(d0 r100);

    void H1(String r100);

    void I(boolean r100);

    void I0(boolean r100);

    String I1(Context r100, StringBuilder r101, boolean r102, Level r103);

    boolean J();

    void J0(boolean r100);

    void J1(f0 r100);

    void K(ow3.b r100);

    void K0(p r100);

    void K1(int r100, i r101);

    void L(n r100);

    void L0(boolean r100);

    fx3.e L1();

    void M(int r100);

    void M0(boolean r100);

    void M1(kx3.b r100);

    void N();

    void N0(boolean r100);

    void O(Context r100, q r101);

    void O0(boolean r100);

    void P(l r100);

    boolean P0();

    void Q(String r100, String r101, String r102, long r103, long r104, JSONObject r105);

    Integer Q0();

    mw3.a R();

    void R0(r r100);

    void S(boolean r100);

    void S0(String r100, String r101, int r102);

    void T();

    void T0(m r100);

    void U(f r100);

    boolean U0();

    y V();

    void V0(String r100, String r101, String r102, long r103, long r104);

    void W(boolean r100);

    void W0(String r100, Bundle r101, String r102, String r103, String r104);

    ex3.e X();

    boolean X0(String r100, JSONObject r101);

    uw3.a Y();

    boolean Y0();

    void Z(k r100);

    void Z0();

    void a(String r100, Object r101);

    void a0(j r100);

    void a1(int r100, j r101);

    void b(Account r100);

    void b0(String r100);

    void b1(boolean r100);

    boolean c();

    boolean c0();

    void c1(DataIsolateKey r100);

    Map<String, String> d();

    void d0(boolean r100);

    void d1(String r100, Throwable r101);

    boolean e();

    String e0();

    void e1();

    void f(boolean r100);

    void f0(boolean r100);

    void f1(long r100);

    void flush();

    void g();

    void g0(boolean r100);

    int g1();

    String getAbSdkVersion();

    String getAid();

    String getAppId();

    com.bytedance.applog.params.b getCommonParams();

    Context getContext();

    String getDid();

    boolean getEncryptAndCompress();

    JSONObject getHeader();

    String getIid();

    q getInitConfig();

    g0 getNetClient();

    String getOpenUdid();

    String getSessionId();

    String getSsid();

    void getSsidGroup(Map<String, String> r100);

    String getUserID();

    String getUserUniqueID();

    m h();

    void h0(String r100);

    void h1(int r100);

    boolean i();

    void i0(boolean r100);

    void i1(int r100);

    boolean isNewUser();

    void j(boolean r100);

    void j0(boolean r100);

    void j1(boolean r100);

    void k(boolean r100);

    boolean k0();

    void k1(h r100);

    void l();

    tw3.b l0();

    void l1(i r100);

    void m(String r100, String r101);

    void m0(Context r100, Map<String, String> r101, boolean r102, Level r103);

    void m1(boolean r100);

    void n(String r100);

    void n0();

    void n1(l r100);

    void o(boolean r100);

    void o0(boolean r100);

    void o1(String r100, String r101);

    void onActivityPause();

    void onActivityResumed(Activity r100);

    void onEvent(String r100);

    void onEvent(String r100, String r101);

    void onEventV3(String r100);

    void onEventV3(String r100, Bundle r101);

    void onEventV3(String r100, JSONObject r101);

    void onInternalEventV3(String r100, JSONObject r101, String r102, String r103, String r104);

    void onMiscEvent(String r100, JSONObject r101);

    void onPause(Context r100);

    void onResume(Context r100);

    void p(String r100, int r101);

    void p0(boolean r100);

    void p1(boolean r100, long r101, t0 r102);

    void q(Proxy r100);

    boolean q0();

    boolean q1();

    void r(JSONObject r100);

    void r0(int r100);

    void r1();

    boolean s(String r100);

    void s0(boolean r100, String r101);

    void s1(HashSet<String> r100, int r101, int r102);

    void setAppLanguageAndRegion(String r100, String r101);

    void setHeaderInfo(HashMap<String, Object> r100);

    void setPageName(String r100);

    void setUserUniqueID(String r100);

    void start();

    void stop();

    void t(long r100);

    void t0(String r100, int r101);

    void t1(boolean r100);

    k u();

    void u0(Context r100, JSONObject r101);

    void u1(boolean r100);

    IBDAccountCallback v();

    void v0(List<String> r100, boolean r101);

    void v1(IBDAccountCallback r100);

    String w(Context r100, String r101, boolean r102, Level r103);

    void w0(boolean r100);

    void w1();

    void x(boolean r100);

    void x0(j r100);

    void x1(String r100);

    void y();

    void y0(String r100, String r101, String r102, long r103, long r104, String r105);

    void y1(i r100);

    void z(boolean r100);

    void z0(p r100);

    boolean z1();
}
