package com.bytedance.android.live.recharge.platform.service;

import com.android.ttcjpaysdk.base.service.IHostApi;
import com.android.ttcjpaysdk.base.service.IPayLifecycle;
import com.android.ttcjpaysdk.base.service.ITTCJPayComponent;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes47.dex */
public final class b implements m, com.bytedance.android.scope.o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConcurrentHashMap<String, ITTCJPayComponent> f90293a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.bytedance.android.live.wallet.d f90294b;

    @Override // com.bytedance.android.live.recharge.platform.service.m
    public final JSONObject f0() {
        Intrinsics.checkNotNullParameter("recharge_panel", "scene");
        ITTCJPayComponent r100 = this.f90293a.get("recharge_panel");
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getDynamicBizParams();
    }

    @Override // com.bytedance.android.scope.o
    public final void onStart() {
        this.f90293a.clear();
    }

    @Override // com.bytedance.android.scope.o
    public final void onStop() {
        this.f90293a.clear();
    }

    public b(com.bytedance.android.live.wallet.d r100) {
        Intrinsics.checkNotNullParameter(r100, "cjPayService");
        this.f90294b = r100;
        this.f90293a = new ConcurrentHashMap();
    }

    @Override // com.bytedance.android.live.recharge.platform.service.m
    public final JSONObject I(String r100) {
        Intrinsics.checkNotNullParameter(r100, "scene");
        ITTCJPayComponent r101 = this.f90293a.get(r100);
        if (r101 != null) goto L7;
        return null;
    L7:
        return r101.getPayParams();
    }

    @Override // com.bytedance.android.live.recharge.platform.service.m
    public final void a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "scene");
        ITTCJPayComponent r101 = this.f90293a.remove(r100);
        if (r101 == null) goto L6;
        r101.release();
        return;
    }

    @Override // com.bytedance.android.live.recharge.platform.service.m
    public final ITTCJPayComponent f(String r100) {
        Intrinsics.checkNotNullParameter(r100, "scene");
        return this.f90293a.get(r100);
    }

    @Override // com.bytedance.android.live.recharge.platform.service.m
    public final boolean w(JSONObject r100) {
        Intrinsics.checkNotNullParameter("recharge_panel", "scene");
        ITTCJPayComponent r101 = this.f90293a.get("recharge_panel");
        if (r101 != null) goto L7;
        return false;
    L7:
        return r101.refresh(r100);
    }

    @Override // com.bytedance.android.live.recharge.platform.service.m
    public final ITTCJPayComponent L(IPayLifecycle r100, IHostApi r101) {
        return this.f90294b.F(r100, r101);
    }

    @Override // com.bytedance.android.live.recharge.platform.service.m
    public final void X0(String r100, JSONObject r101) {
        Intrinsics.checkNotNullParameter(r100, "scene");
        ITTCJPayComponent r102 = this.f90293a.get(r100);
        if (r102 == null) goto L6;
        r102.confirm(r101);
        return;
    }

    @Override // com.bytedance.android.live.recharge.platform.service.m
    public final void s1(String r100, ITTCJPayComponent r101) {
        Intrinsics.checkNotNullParameter(r100, "scene");
        Intrinsics.checkNotNullParameter(r101, "component");
        this.f90293a.put(r100, r101);
    }
}
