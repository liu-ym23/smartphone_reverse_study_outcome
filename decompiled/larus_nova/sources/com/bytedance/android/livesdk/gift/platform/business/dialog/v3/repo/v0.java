package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo;

import com.bytedance.android.annie.param.GsonMap;
import com.bytedance.android.annie.param.UtilsKt;
import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.livesdk.gift.configmodel.m1;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.GiftPanelBizBoostUtils;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.LynxTouchViewVisibleChange;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.QueryUserHonorMap;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class v0 implements com.bytedance.android.scope.o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CompositeDisposable f128551a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final i12.e f128552b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final uz1.a f128553c;

    @Override // com.bytedance.android.scope.o
    public final void onStop() {
        this.f128551a.clear();
    }

    public final void a() {
        if (com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.v.e() == true) goto L30;
        this.f128553c.a(new LynxTouchViewVisibleChange(true, true));
    L30:
        if (com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.v.a() == false) goto L10;
        GiftPanelBizBoostUtils.E.getClass();     // Catch: Exception -> L25
        if (GiftPanelBizBoostUtils.d().r0() == true) goto L26;
    L10:
        py.d r100 = ((l01.d) com.bytedance.android.live.revenue.core.util.f.a(l01.d.class)).b().getUserHonor();     // Catch: Exception -> L25
        GsonMap r101 = null;
        m1 r102 = (m1) nz1.a.f521340i.getValue(null, nz1.a.f521324a[7]);     // Catch: Exception -> L25
        Pair[] r103 = new Pair[2];     // Catch: Exception -> L25
        JsonElement r104 = GsonHelper.getDefault().toJsonTree(r100);     // Catch: Exception -> L25
        if ((r104 instanceof JsonObject) == true) goto L13;
        r104 = null;
    L13:
        JsonObject r105 = (JsonObject) r104;     // Catch: Exception -> L25
        if (r105 == null) goto L16;
        GsonMap r106 = UtilsKt.i(r105);     // Catch: Exception -> L25
    L17:
        r103[0] = TuplesKt.to("payGrade", r106);     // Catch: Exception -> L25
        JsonElement r107 = GsonHelper.getDefault().toJsonTree(r102);     // Catch: Exception -> L25
        if ((r107 instanceof JsonObject) == true) goto L20;
        r107 = null;
    L20:
        JsonObject r108 = (JsonObject) r107;     // Catch: Exception -> L25
        if (r108 == null) goto L23;
        r101 = UtilsKt.i(r108);     // Catch: Exception -> L25
    L23:
        r103[1] = TuplesKt.to("honorSetting", r101);     // Catch: Exception -> L25
        this.f128553c.a(new QueryUserHonorMap(MapsKt.mutableMapOf(r103)));     // Catch: Exception -> L25
        goto L26
    L16:
        r106 = null;
    L26:
        com.bytedance.android.live.profit.privilege.a r109 = yt0.c.i();
        if (r109 == null) goto L32;
        this.f128551a.add(r109.getTouchPositionData().a().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new s0(this)));
        return;
    }

    @Override // com.bytedance.android.scope.o
    public final void onStart() {
        if (com.bytedance.android.livesdk.gift.platform.core.utils.u.m() == false) goto L5;
        a();
        return;
    L5:
        this.f128551a.add(((com.bytedance.android.livesdk.revenue.service.user.a) vh6.c.b(com.bytedance.android.livesdk.revenue.service.user.a.class)).pl().filter(t0.f128522a).subscribe(new u0(this)));
    }

    public v0(i12.e r100, uz1.a r101) {
        Intrinsics.checkNotNullParameter(r100, "scope");
        Intrinsics.checkNotNullParameter(r101, "giftMVIFacade");
        this.f128552b = r100;
        this.f128553c = r101;
        this.f128551a = new CompositeDisposable();
    }
}
