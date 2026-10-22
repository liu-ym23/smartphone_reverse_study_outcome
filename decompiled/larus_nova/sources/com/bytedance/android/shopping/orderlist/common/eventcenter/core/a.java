package com.bytedance.android.shopping.orderlist.common.eventcenter.core;

import android.view.View;
import c53.d;
import com.bytedance.android.ecom.arch.slice.render.context.SlcRenderContext;
import com.bytedance.android.shopping.orderlist.common.controller.o;
import com.bytedance.android.shopping.orderlist.common.controller.w;
import com.bytedance.android.shopping.orderlist.common.eventcenter.function.OrderSelfRegisterBridgeFunction$onExecuteAsync$1;
import com.bytedance.android.shopping.orderlist.common.eventcenter.function.j0;
import com.bytedance.android.shopping.orderlist.common.freq.OrderFreqControlManager;
import com.bytedance.kmp.ec.yata.store.node.c;
import eg3.b;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes13.dex */
public interface a {
    void A0(Map<String, String> r100);

    void B0();

    OrderFreqControlManager C0();

    d D0();

    com.bytedance.android.shopping.orderlist.common.monitor.error.a E0();

    void F0();

    boolean G0();

    b H0();

    void I0(j0 r100);

    void J0(Function0<Unit> r100);

    void K0(float r100);

    void L0(String r100, w r101);

    void M0(JSONObject r100);

    void N0(String r100, String r101);

    void O0(JSONObject r100);

    Map<String, Map<String, Object>> P0();

    void Q0();

    void R0();

    ig3.a S0();

    View T0();

    void U0(String r100);

    SlcRenderContext f();

    String getCurrentSessionId();

    void t0();

    void u0(int r100);

    void v0(int r100, boolean r101);

    void w0();

    void x0(String r100, o r101);

    void y0(String r100, OrderSelfRegisterBridgeFunction$onExecuteAsync$1.a r101);

    void z0(c r100);
}
