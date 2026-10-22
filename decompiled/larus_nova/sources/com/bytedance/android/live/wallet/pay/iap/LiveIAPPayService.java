package com.bytedance.android.live.wallet.pay.iap;

import android.app.Activity;
import android.content.Context;
import com.bytedance.android.live.wallet.caijing.LiveCJIAPPayManager;
import com.bytedance.android.live.wallet.model.g;
import com.bytedance.android.live.wallet.pay.iap.model.LiveIAPProductType;
import com.bytedance.android.livesdkapi.depend.model.wallet.DetailChargeDeal;
import com.bytedance.android.scope.o;
import com.bytedance.caijing.sdk.biz.googleiap.api.CJIAPService;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class LiveIAPPayService implements com.bytedance.android.live.wallet.pay.iap.a, o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f102689a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f102690b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final LiveCJIAPPayManager f102691c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f102692d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final com.bytedance.android.live.wallet.pay.iap.b f102693e;

    public static final class a {
    }

    public static final class b {
        public b(LiveIAPPayService r100, DetailChargeDeal r101, g r102, com.bytedance.android.live.wallet.e.b r103) {
        }
    }

    public static final class c {
        public c() {
        }
    }

    static {
    }

    @Override // com.bytedance.android.scope.o
    public final void onStart() {
    }

    @Override // com.bytedance.android.scope.o
    public final void onStop() {
    }

    public LiveIAPPayService(com.bytedance.android.live.wallet.pay.iap.b r100) {
        Intrinsics.checkNotNullParameter(r100, "queryOrderService");
        this.f102693e = r100;
        this.f102689a = "1200004784";
        this.f102690b = "800047848555";
        this.f102691c = LiveCJIAPPayManager.f102661b;
        this.f102692d = LazyKt.lazy(new LiveIAPPayService$iapContext$2(this));
    }

    @Override // com.bytedance.android.live.wallet.pay.iap.a
    public final void E(Context r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        LiveCJIAPPayManager r101 = this.f102691c;
        ad1.a r102 = (ad1.a) this.f102692d.getValue();
        c r103 = new c();
        r101.getClass();
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r102, "iapContext");
        Intrinsics.checkNotNullParameter(r103, "initListener");
        CJIAPService r104 = (CJIAPService) LiveCJIAPPayManager.f102660a.getValue();
        if (r104 == null) goto L8;
        r104.initIAP(com.bytedance.android.live.wallet.caijing.d.a(r102), r100, new com.bytedance.android.live.wallet.caijing.b(r103));
        return;
    }

    @Override // com.bytedance.android.live.wallet.pay.iap.a
    public final void L0(List r100) {
        Intrinsics.checkNotNullParameter(r100, "productIds");
        LiveIAPProductType r101 = LiveIAPProductType.INAPP;
        LiveCJIAPPayManager r102 = this.f102691c;
        ad1.a r103 = (ad1.a) this.f102692d.getValue();
        com.bytedance.android.live.wallet.pay.iap.c r104 = new com.bytedance.android.live.wallet.pay.iap.c();
        r102.getClass();
        Intrinsics.checkNotNullParameter(r103, "iapContext");
        Intrinsics.checkNotNullParameter(r100, "productIds");
        Intrinsics.checkNotNullParameter(r101, "productType");
        Intrinsics.checkNotNullParameter(r104, "listener");
        CJIAPService r105 = (CJIAPService) LiveCJIAPPayManager.f102660a.getValue();
        if (r105 == null) goto L6;
        r105.queryProductDetails(com.bytedance.android.live.wallet.caijing.d.a(r103), new sc4.c(r100, r101.getValue()), new com.bytedance.android.live.wallet.caijing.c(r104));
        return;
    }

    @Override // com.bytedance.android.live.wallet.pay.iap.a
    public final void y(Activity r110, DetailChargeDeal r111, g r112, com.bytedance.android.live.wallet.e.b r210) {
        Intrinsics.checkNotNullParameter(r110, "activity");
        Intrinsics.checkNotNullParameter(r111, "chargeDeal");
        Intrinsics.checkNotNullParameter(r112, "orderData");
        ad1.b r100 = new ad1.b(r112.f102684c, r112.f102683b, r112.f102682a, LiveIAPProductType.INAPP, r112.f102685d, r112.f102686e);
        System.currentTimeMillis();
        LiveCJIAPPayManager r101 = this.f102691c;
        ad1.a r102 = (ad1.a) this.f102692d.getValue();
        b r103 = new b(this, r111, r112, r210);
        r101.getClass();
        Intrinsics.checkNotNullParameter(r102, "iapContext");
        Intrinsics.checkNotNullParameter(r110, "activity");
        Intrinsics.checkNotNullParameter(r100, "payParams");
        Intrinsics.checkNotNullParameter(r103, "payListener");
        CJIAPService r104 = (CJIAPService) LiveCJIAPPayManager.f102660a.getValue();
        if (r104 == null) goto L6;
        sc4.a r105 = com.bytedance.android.live.wallet.caijing.d.a(r102);
        Intrinsics.checkNotNullParameter(r100, "$this$toCJModel");
        r104.pay(r105, r110, new sc4.b(r100.f2937a, r100.f2938b, r100.f2939c, r100.f2940d.getValue(), r100.f2941e, r100.f2942f), new com.bytedance.android.live.wallet.caijing.a(r103));
        return;
    }
}
