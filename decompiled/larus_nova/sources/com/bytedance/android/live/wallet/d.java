package com.bytedance.android.live.wallet;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import com.android.ttcjpaysdk.base.service.IHostApi;
import com.android.ttcjpaysdk.base.service.IPayLifecycle;
import com.android.ttcjpaysdk.base.service.ITTCJPayComponent;
import com.android.ttcjpaysdk.ttcjpayapi.TTCJPayAlipayAuthCallback;
import com.bytedance.android.live.wallet.platform.business.verify.k;
import com.bytedance.android.live.wallet.platform.jsbridge.methods.AuthToFinanceMethod;
import com.bytedance.android.live.wallet.platform.jsbridge.methods.CJModalViewMethod;
import com.bytedance.android.live.wallet.platform.jsbridge.methods.h;
import java.util.Map;
import org.json.JSONObject;
import zv0.l;
import zv0.n;

/* JADX INFO: loaded from: classes7.dex */
public interface d extends com.bytedance.android.live.recharge.core.c {

    public interface a {
    }

    void A(Activity r100, String r101, String r102, String r103, String r104, String r105, String r106, n r107);

    void A1(Activity r100, zc1.a r101, Map r102, Map r103, boolean r104, boolean r105, JSONObject r106);

    ITTCJPayComponent F(IPayLifecycle r100, IHostApi r101);

    void J(Context r100, String r101, String r102, Map<String, String> r103, String r104, Map<String, String> r105, Map<String, String> r106, l r107);

    void J0(Context r100, String r101, String r102, String r103, String r104);

    void K(Context r100, String r101);

    void K0(zc1.a r100);

    void R();

    void X(Context r100, String r101, String r102, String r103, String r104);

    String Y0();

    void authAlipay(Activity r100, String r101, boolean r102, TTCJPayAlipayAuthCallback r103);

    void g(Map<String, String> r100, int r101);

    String getBioType();

    void j0(Context r100, String r101, int r102, boolean r103, String r104, Uri r105);

    void k(Activity r100, zc1.a r101, Map r102, Map r103, int r104);

    com.bytedance.android.live.wallet.model.b o();

    void q();

    void r1();

    void releaseAll();

    void s(Activity r100, String r101, String r102, String r103, k r104);

    void w1(Context r100, JSONObject r101, JSONObject r102, String r103, int r104, String r105, CJModalViewMethod.a r106);

    void x(Activity r100, AuthToFinanceMethod.a r101, com.bytedance.android.live.wallet.platform.jsbridge.methods.d r102);

    void x0(Context r100, Map r101, Map r102, String r103, int r104, String r105, String r106, String r107, String r108, h r110);
}
