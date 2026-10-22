package com.bytedance.android.live.recharge.deal;

import com.bytedance.android.livesdkapi.depend.model.IOneKeyPay;
import com.bytedance.android.livesdkapi.depend.model.IPrePayCashierInfo;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes47.dex */
public interface i {
    List<Long> a();

    boolean b();

    List<u> c();

    long d();

    int e();

    IOneKeyPay f();

    String g();

    com.bytedance.android.live.recharge.model.diamond.b getBizExtra();

    Map<Long, com.bytedance.android.live.recharge.platform.business.model.diamond.g> getPanelExtraInfo();

    boolean h();

    String i();

    boolean isOneStep();

    Map<Long, com.bytedance.android.live.recharge.model.diamond.e> j();

    List<d> k();

    long l();

    boolean m();

    IPrePayCashierInfo n();

    long o();
}
